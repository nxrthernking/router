package com.innowise.test.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class IncomeFileDto {
    private String name;
    private String extension;
    private byte[] data;
}
