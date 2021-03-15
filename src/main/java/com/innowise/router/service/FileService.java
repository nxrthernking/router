package com.innowise.router.service;

import com.innowise.router.entity.File;
import com.innowise.router.mapper.FileContentMapper;
import com.innowise.router.mapper.MultipartFileMapper;
import com.innowise.router.service.archive.ArchiveFileType;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class FileService {

    private final MultipartFileMapper mapper;

    private final FileContentMapper fileContentMapper;

    @SneakyThrows
    public List<File> process(MultipartFile file) {
        return ArchiveFileType.of(file.getBytes())
                .map(s -> s.unzipToFileContentList(file))
                .orElse(mapper.mapToFileList(file))
                .stream()
                .map(fileContentMapper::mapToFile)
                .collect(Collectors.toList());

    }
}
