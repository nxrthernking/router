package com.innowise.router.mapper;

import com.innowise.router.exception.BadFileExtensionException;
import com.innowise.router.exception.InvalidFileException;
import com.innowise.router.util.FileUtils;
import lombok.RequiredArgsConstructor;
import lombok.experimental.UtilityClass;

import java.util.Map;
import java.util.Optional;

@RequiredArgsConstructor
public class ReportParserFactory {

    private final Map<String,FileParser> parserMap;

    public FileParser getFileParserFromFactory(String filename) {
        return Optional.ofNullable(
                parserMap.get(FileUtils.getFileExtension(filename).toUpperCase()))
                .orElseThrow(BadFileExtensionException::new);

    }
}
