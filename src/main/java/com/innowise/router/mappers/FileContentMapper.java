package com.innowise.router.mappers;

import com.innowise.router.dto.FileContent;
import com.innowise.router.entities.File;
import org.springframework.stereotype.Component;

@Component
public class FileContentMapper {

    public File mapToFileIncomeEntity(FileContent fileContent) {
        return File.builder()
                .fileName(fileContent.getName())
                .fileExtension(fileContent.getExtension())
                .content(fileContent.getData())
                .build();
    }

    public FileContent mapToIncomeFileDto(File file) {
        return FileContent.builder()
                .name(file.getFileName())
                .extension(file.getFileExtension())
                .data(file.getContent())
                .build();
    }
}
