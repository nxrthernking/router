package com.innowise.router.service.parser;

import com.innowise.router.IntegrationTest;
import com.innowise.router.dto.Report;
import com.innowise.router.exception.InvalidFileException;
import com.innowise.router.helper.Util;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

class JsonParserTest extends IntegrationTest {

    private final String JSON_FILE_PATH = "src/test/resources/json/";

    private final List<Report> expectedReportList = Arrays.asList(
            new Report(
                    "adidas",
                    LocalDate.of(2021, 3, 17),
                    LocalDate.of(2021, 4, 17),
                    "11",
                    Arrays.asList("1", "2", "3"),
                    "20303030"),
            new Report(
                    "nike",
                    LocalDate.of(2021, 3, 17),
                    LocalDate.of(2021, 4, 17),
                    "12",
                    Arrays.asList("1", "2", "3"),
                    "32213371312")
    );

    @Test
    void givenReportsFromJsonFileThenAssert() {
        Assertions.assertEquals(expectedReportList,
                jsonFileParser.parse(Util.getBytes(JSON_FILE_PATH + "valid.json")));
    }

    @Test
    void givenInvalidReportsFromJsonFileThenAssertThrow() {
        Assertions.assertThrows(
                InvalidFileException.class,
                () -> jsonFileParser.parse(
                        Util.getBytes(JSON_FILE_PATH + "invalid.json"))
        );
    }

}