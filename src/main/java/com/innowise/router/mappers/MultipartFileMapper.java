package com.innowise.router.mappers;

import com.innowise.router.dto.FileContent;
import com.innowise.router.enums.ArchiveFileType;
import com.innowise.router.utils.FileUtils;
import lombok.SneakyThrows;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Component
public class MultipartFileMapper {
    @SneakyThrows
    public List<FileContent> mapToFileList(MultipartFile file){
        return ArchiveFileType.of(file.getBytes())
                .map(s -> s.unzipToFileContentList(file))
                .orElse(mapToFile(file));
    }

    @SneakyThrows
    private List<FileContent> mapToFile(MultipartFile file){
        return List.of(new FileContent(file.getName(), FileUtils.getFileExtension(file.getName()),file.getBytes()));
    }
}
