package com.innowise.router.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class FileContent {
    private String name;
    private String extension;
    private byte[] data;
}
