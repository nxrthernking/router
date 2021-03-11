package com.innowise.router.services;

import com.innowise.router.dto.FileContent;
import com.innowise.router.entities.File;
import com.innowise.router.mappers.FileContentMapper;
import com.innowise.router.repositories.IncomeFileRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class IncomeFileService {
    private final IncomeFileRepository incomeFileRepository;

    private final FileContentMapper fileContentMapper;



    public void save(FileContent fileContent){
        File file = fileContentMapper.mapToFileIncomeEntity(fileContent);
        incomeFileRepository.save(file);
    }
}
