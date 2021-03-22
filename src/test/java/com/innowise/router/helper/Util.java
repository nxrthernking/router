package com.innowise.router.helper;

import lombok.SneakyThrows;

import java.nio.file.Files;
import java.nio.file.Paths;

public class Util {

    @SneakyThrows
    public static byte[] getBytes(String value) {
        return Files.readAllBytes(Paths.get(value));
    }
}
