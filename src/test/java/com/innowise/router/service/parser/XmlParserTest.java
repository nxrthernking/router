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

class XmlParserTest extends IntegrationTest {

    private final String XML_FILE_PATH = "src/test/resources/xml/";

    private final List<Report> expectedReportList = Arrays.asList(
            new Report(
                    "almi",
                    LocalDate.of(2011, 12, 13),
                    LocalDate.of(2012, 12, 13),
                    "1234",
                    Arrays.asList("12", "114"),
                    "23411"),
            new Report(
                    "deal",
                    LocalDate.of(2012, 12, 13),
                    LocalDate.of(2012, 12, 14),
                    "123",
                    Arrays.asList("134", "14"),
                    "234")
    );

    @Test
    void givenReportsFromXmlFileThenAssert() {
        Assertions.assertEquals(expectedReportList,
                xmlParser.parse(Util.getBytes(XML_FILE_PATH + "valid.xml")));
    }

    @Test
    void givenInvalidReportsFromXmlFileThenAssertThrow() {
        Assertions.assertThrows(
                InvalidFileException.class,
                () -> xmlParser.parse(
                        Util.getBytes(XML_FILE_PATH + "invalid.xml"))
        );
    }

}