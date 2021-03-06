package com.innowise.router.mapper;

import com.innowise.router.dto.FileContent;
import com.innowise.router.entity.File;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@NoArgsConstructor
public class FileContentMapper {

    public File mapToFile(FileContent fileContent) {
        return File.builder()
                .fileName(fileContent.getName())
                .fileExtension(fileContent.getExtension())
                .content(fileContent.getData())
                .build();
    }

}
