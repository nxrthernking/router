package com.innowise.router.mappers;

import com.innowise.router.dto.FileContent;
import com.innowise.router.entities.File;
import org.springframework.stereotype.Component;

@Component
public class FileContentMapper {

    public File mapToFile(FileContent fileContent) {
        return File.builder()
                .fileName(fileContent.getName())
                .fileExtension(fileContent.getExtension())
                .content(fileContent.getData())
                .build();
    }

    public FileContent mapToFileContent(File file) {
        return new FileContent(file.getFileName(), file.getFileExtension(), file.getContent());
    }
}
