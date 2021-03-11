package com.innowise.test.services;

import com.innowise.test.dto.IncomeFileDto;
import com.innowise.test.entities.IncomeFileEntity;
import com.innowise.test.mappers.IncomeFileMapper;
import com.innowise.test.repositories.IncomeFileRepository;
import org.springframework.stereotype.Service;


@Service
public class IncomeFileService {
    private final IncomeFileRepository incomeFileRepository;

    private final IncomeFileMapper incomeFileMapper;

    public IncomeFileService(IncomeFileRepository incomeFileRepository, IncomeFileMapper incomeFileMapper) {
        this.incomeFileRepository = incomeFileRepository;
        this.incomeFileMapper = incomeFileMapper;
    }

    public void save(IncomeFileDto incomeFileDto){
        IncomeFileEntity incomeFileEntity = incomeFileMapper.mapToFileIncomeEntity(incomeFileDto);
        incomeFileRepository.save(incomeFileEntity);
    }
}
