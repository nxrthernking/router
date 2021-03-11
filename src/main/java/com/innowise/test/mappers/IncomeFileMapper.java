package com.innowise.test.mappers;

import com.innowise.test.dto.IncomeFileDto;
import com.innowise.test.entities.IncomeFileEntity;

public class IncomeFileMapper {
    public IncomeFileEntity mapToFileIncomeEntity(IncomeFileDto incomeFileDto){
        return IncomeFileEntity.builder()
                .fileName(incomeFileDto.getName())
                .fileExtension(incomeFileDto.getExtension())
                .data(incomeFileDto.getData())
                .build();
    }

    public IncomeFileDto mapToIncomeFileDto(IncomeFileEntity incomeFileEntity){
        return IncomeFileDto.builder()
                .name(incomeFileEntity.getFileName())
                .extension(incomeFileEntity.getFileExtension())
                .data(incomeFileEntity.getData())
                .build();
    }
}
