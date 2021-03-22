package com.innowise.router.service.parser;

import com.innowise.router.exception.BadFileExtensionException;
import com.innowise.router.util.FileUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.Optional;

@RequiredArgsConstructor
@Component
public class ReportParserFactory {

    private final Map<String, FileParser> parserMap;

    public FileParser getFileParserFromFactory(String filename) {
        return Optional.ofNullable(
                parserMap.get(FileUtils.getFileExtension(filename).toUpperCase()))
                .orElseThrow(BadFileExtensionException::new);

    }
}
