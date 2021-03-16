package com.innowise.router.util;

import com.github.junrar.Archive;
import com.github.junrar.rarfile.FileHeader;
import com.innowise.router.dto.FileContent;
import lombok.SneakyThrows;
import lombok.experimental.UtilityClass;
import org.apache.commons.compress.archivers.sevenz.SevenZArchiveEntry;
import org.apache.commons.compress.archivers.sevenz.SevenZFile;
import org.apache.commons.compress.archivers.zip.ZipArchiveEntry;
import org.apache.commons.compress.archivers.zip.ZipFile;
import org.apache.commons.compress.utils.SeekableInMemoryByteChannel;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.nio.channels.SeekableByteChannel;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

@UtilityClass
public class ArchiveUtils {

    @SneakyThrows
    public List<FileContent> unzipZip(final byte[] content) {
        List<FileContent> files = new LinkedList<>();
        SeekableByteChannel channel = new SeekableInMemoryByteChannel(content);
        try (ZipFile zipFile = new ZipFile(channel)) {
            for (ZipArchiveEntry entry : Collections.list(zipFile.getEntries())) {
                files.add(new FileContent(entry.getName(),FileUtils.getFileExtension(entry.getName()),
                        zipFile.getInputStream(entry).readAllBytes()));
            }
            return files;
        }
    }

    @SneakyThrows
    public List<FileContent> unzipSevenZip(final byte[] content) {
        List<FileContent> files = new LinkedList<>();
        SeekableByteChannel channel = new SeekableInMemoryByteChannel(content);
        try (SevenZFile sevenZFile = new SevenZFile(channel)) {
            for (SevenZArchiveEntry entry : sevenZFile.getEntries()) {
                files.add(new FileContent(entry.getName(),
                        FileUtils.getFileExtension(entry.getName()),sevenZFile.getInputStream(entry).readAllBytes()));
            }

            return files;
        }
    }

    @SneakyThrows
    public List<FileContent> unzipRar(final byte[] content) {
        List<FileContent> files = new ArrayList<>();
        try (Archive rarArchive = new Archive(new ByteArrayInputStream(content))) {
            FileHeader fileHeader = rarArchive.nextFileHeader();
            while (fileHeader != null) {
                getFileHeader(files, rarArchive, fileHeader);
                fileHeader = rarArchive.nextFileHeader();
            }
        }
        return files;
    }

    @SneakyThrows
    private void getFileHeader(List<FileContent> files, Archive rarArchive, FileHeader fileHeader) {
        try (ByteArrayOutputStream contentBytes = new ByteArrayOutputStream()) {
            rarArchive.extractFile(fileHeader, contentBytes);
            files.add(new FileContent(fileHeader.getFileName(),
                    FileUtils.getFileExtension(fileHeader.getFileName()), contentBytes.toByteArray()));
        }
    }

}
