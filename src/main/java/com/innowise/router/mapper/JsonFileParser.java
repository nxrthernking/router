package com.innowise.router.mapper;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.innowise.router.dto.Report;
import com.innowise.router.exception.InvalidFileException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component("JSON")
@RequiredArgsConstructor
public class JsonFileParser implements FileParser {

    private final ObjectMapper objectMapper;

    @Override
    public List<Report> parse(byte[] content) {
        try {
            return Arrays.asList(objectMapper.readValue(content, Report[].class));
        } catch (Exception e) {
            throw new InvalidFileException("Invalid income file");
        }
    }

}
