package com.innowise.test.entities;

import lombok.Builder;
import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Builder(toBuilder = true)
public class IncomeFileEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fileName;

    private String fileExtension;

    private byte[] data;
}
