package com.innowise.router.service;

import com.innowise.router.dto.FileContent;
import com.innowise.router.entity.File;
import com.innowise.router.helper.Util;
import com.innowise.router.mapper.FileContentMapper;
import com.innowise.router.mapper.MultipartFileMapper;
import com.innowise.router.service.archive.ArchiveFileType;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.mock.web.MockMultipartFile;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.only;


@ExtendWith(MockitoExtension.class)
class FileServiceUnitTest {

    private static final String FILE_NAME = "test.json";

    private static final String FILE_EXTENSION = "json";

    @Spy
    private MultipartFileMapper multipartFileMapper;

    @Mock
    private FileContentMapper fileContentMapper;

    @InjectMocks
    private FileService fileService;

    private static final String PATH_TO_ARCHIVE = "src/test/resources/archive/";

    private static final String PATH_TO_TEST_FILE = "src/test/resources/json/";


    final FileContent fileContent = FileContent.builder()
            .name(FILE_NAME)
            .extension(FILE_EXTENSION)
            .data(Util.getBytes(PATH_TO_TEST_FILE + "test.json"))
            .build();

    final File expectedFile = File.builder()
            .fileName(FILE_NAME)
            .fileExtension(FILE_EXTENSION)
            .content(Util.getBytes(PATH_TO_TEST_FILE + "test.json"))
            .build();


    @ParameterizedTest
    @MethodSource("getArchiveNames")
    void shouldGetUnzipFilesWhenFileIsArchive(final String archiveName) {

        final MockMultipartFile mockMultipartFile = new MockMultipartFile(archiveName,
                Util.getBytes(PATH_TO_ARCHIVE + archiveName));

        given(fileContentMapper.mapToFile(fileContent)).willReturn(expectedFile);

        assertEquals(List.of(expectedFile), fileService.parse(mockMultipartFile));

        then(multipartFileMapper).should(only()).mapToFileList(mockMultipartFile);

        then(fileContentMapper).should(only()).mapToFile(fileContent);

    }

    private static Stream<Arguments> getArchiveNames() {
        return Stream.of(
                Arguments.of("test.rar"),
                Arguments.of("zipTest.zip"),
                Arguments.of("sevenZTest.7z")
        );
    }

}