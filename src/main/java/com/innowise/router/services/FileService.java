package com.innowise.router.services;

import com.innowise.router.entities.File;
import com.innowise.router.mappers.FileContentMapper;
import com.innowise.router.mappers.MultipartFileMapper;
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
        return mapper.mapToFileList(file).stream().map(fileContentMapper::mapToFile).collect(Collectors.toList());
    }
}
