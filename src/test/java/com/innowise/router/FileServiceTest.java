package com.innowise.router;

import com.innowise.router.helper.Util;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.mock.web.MockMultipartFile;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

class FileServiceTest extends IntegrationTest {

    public static List<MockMultipartFile> mockFiles() {
        final Map<String, String> stringStringMap = Map.of(
                "test.rar", "src/test/json/resources/archive/test.rar",
                "zip.zip", "src/test/json/resources/archive/zipTest.zip",
                "sevenZ.7z", "src/test/json/resources/archive/sevenZTest.7z"
        );
        final ArrayList<MockMultipartFile> mockMultipartFiles = new ArrayList<>();
        stringStringMap.forEach((key, value) -> mockMultipartFiles.add(new MockMultipartFile(key, Util.getBytes(value))));
        return mockMultipartFiles;
    }

    // TODO: 22.03.2021 FIX TEST
    @ParameterizedTest
    @MethodSource("mockFiles")
     void givenArchive_whenUnzip_thenAssert(MockMultipartFile multipartFile){
        Assertions.assertEquals(1,fileService.parse(multipartFile).size());
    }
}
