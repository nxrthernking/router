package com.innowise.router;

import com.innowise.router.entity.File;
import com.innowise.router.helper.Util;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.mock.web.MockMultipartFile;

import java.util.List;
import java.util.stream.Stream;

public class FileServiceTest extends IntegrationTest {
    private static final String SRC_TEST_RESOURCES_ARCHIVE_PATH = "src/test/resources/archive/";

    private static final String SRC_TEST_RESOURCES_JSON_PATH = "src/test/resources/json/";

    @ParameterizedTest
    @MethodSource("getArchiveNames")
    void givenArchive_whenUnzip_thenAssert(final String archiveName) {

        final MockMultipartFile mockMultipartFile = new MockMultipartFile(archiveName,
                Util.getBytes(SRC_TEST_RESOURCES_ARCHIVE_PATH + archiveName));

        final File expectedFile = File.builder()
                .fileName("test.json")
                .fileExtension("json")
                .content(Util.getBytes(SRC_TEST_RESOURCES_JSON_PATH + "test.json"))
                .build();

        Assertions.assertEquals(List.of(expectedFile),fileService.parse(mockMultipartFile));
    }


    @Test
    void givenNotValidArchive_whenDoNotUnzip_thenNotEquals(){
        final MockMultipartFile mockMultipartFile = new MockMultipartFile("file.tar",
                Util.getBytes(SRC_TEST_RESOURCES_ARCHIVE_PATH + "file.tar"));

        final File expectedFile = File.builder()
                .fileName("file.xml")
                .fileExtension("xml")
                .content(Util.getBytes("src/test/resources/xml/file.xml"))
                .build();

        Assertions.assertNotEquals(List.of(expectedFile),fileService.parse(mockMultipartFile));
    }

    private static Stream<Arguments> getArchiveNames() {
        return Stream.of(
                Arguments.of("test.rar"),
                Arguments.of("zipTest.zip"),
                Arguments.of("sevenZTest.7z")
        );
    }
}
