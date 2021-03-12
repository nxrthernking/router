package com.innowise.router.mappers;

import com.innowise.router.exceptions.InvalidFileException;
import com.innowise.router.dto.FileContent;
import com.innowise.router.enums.ArchiveFileType;
import com.innowise.router.utils.FileUtils;
import lombok.SneakyThrows;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

@Component
public class MultipartFileMapper {
    @SneakyThrows
    public List<FileContent> mapToFileList(MultipartFile file){
        List<FileContent> files;
        byte[] fileContent = file.getBytes();
        Optional<ArchiveFileType> result = ArchiveFileType.of(fileContent);
        if(result.isPresent()){
            files = result.map(s -> s.unzipToFileContentList(fileContent))
                    .orElseThrow(InvalidFileException::new);
        }else{
            files = mapToFile(file);
        }
        return  files;
    }

    @SneakyThrows
    private List<FileContent> mapToFile(MultipartFile file){
        return List.of(new FileContent(file.getName(), FileUtils.getFileExtension(file.getName()),file.getBytes()));
    }
}
