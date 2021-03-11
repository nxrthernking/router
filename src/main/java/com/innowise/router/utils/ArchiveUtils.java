package com.innowise.router.utils;

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
        List<FileContent> incomeFiles = new LinkedList<>();
        SeekableByteChannel channel = new SeekableInMemoryByteChannel(content);
        try (ZipFile zipFile = new ZipFile(channel)) {
            for (ZipArchiveEntry entry : Collections.list(zipFile.getEntries())) {
                incomeFiles.add(FileContent.builder()
                        .name(entry.getName())
                        .extension("json") // to add parse for extension
                        .data(zipFile.getInputStream(entry).readAllBytes())
                        .build());
            }
            return incomeFiles;
        }
    }

    @SneakyThrows
    public List<FileContent> unzipSevenZip(final byte[] content) {
        List<FileContent> fileContentList = new LinkedList<>();
        SeekableByteChannel channel = new SeekableInMemoryByteChannel(content);
        try (SevenZFile sevenZFile = new SevenZFile(channel)) {
            for (SevenZArchiveEntry archiveEntry : sevenZFile.getEntries()) {
                fileContentList.add(FileContent.builder()
                        .name(archiveEntry.getName())
                        .extension("json")
                        .data(sevenZFile.getInputStream(archiveEntry).readAllBytes())
                        .build());
            }

            return fileContentList;
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
            // TODO: 11.03.2021  change file name to ext
            files.add(new FileContent(fileHeader.getFileName(), fileHeader.getFileName(), contentBytes.toByteArray()));
        }
    }
}
