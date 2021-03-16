package com.innowise.router.mapper;

import com.innowise.router.dto.FileContent;
import com.innowise.router.util.FileUtils;
import lombok.SneakyThrows;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.util.Collections;
import java.util.List;

@Component
public class MultipartFileMapper {

    @SneakyThrows
    public List<FileContent> mapToFileList(MultipartFile file) {
        return Collections.singletonList(new FileContent(file.getName(),
                FileUtils.getFileExtension(file.getName()), file.getBytes()));
    }
}
