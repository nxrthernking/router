package com.innowise.test.utils;

import com.github.junrar.Archive;
import com.github.junrar.exception.RarException;
import com.github.junrar.rarfile.FileHeader;
import com.innowise.test.dto.IncomeFileDto;
import org.apache.commons.compress.archivers.sevenz.SevenZArchiveEntry;
import org.apache.commons.compress.archivers.sevenz.SevenZFile;
import org.apache.commons.compress.archivers.zip.ZipArchiveEntry;
import org.apache.commons.compress.archivers.zip.ZipFile;
import org.apache.commons.compress.utils.SeekableInMemoryByteChannel;

import java.io.*;
import java.nio.channels.SeekableByteChannel;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class ArchiveUtils {
    public static List<IncomeFileDto> unzipZip(final byte[] content) {
        List<IncomeFileDto> incomeFiles = new LinkedList<>();
        IncomeFileDto incomeFileDto;
        SeekableByteChannel channel = new SeekableInMemoryByteChannel(content);
        try (ZipFile zipFile = new ZipFile(channel)) {
            for (ZipArchiveEntry entry : Collections.list(zipFile.getEntries())) {
                incomeFileDto = IncomeFileDto.builder()
                        .name(entry.getName())
                        .extension("json") // to add parse for extension
                        .data(zipFile.getInputStream(entry).readAllBytes())
                        .build();
                incomeFiles.add(incomeFileDto);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


        return incomeFiles;
    }

    public static List<IncomeFileDto> unzipSevenZip(final byte[] content) {
        List<IncomeFileDto> incomeFileDtoList = new LinkedList<>();
        IncomeFileDto incomeFileDto;
        SeekableByteChannel channel = new SeekableInMemoryByteChannel(content);
        try (SevenZFile sevenZFile = new SevenZFile(channel)) {
            for (SevenZArchiveEntry archiveEntry : sevenZFile.getEntries()) {
                incomeFileDto = IncomeFileDto.builder()
                        .name(archiveEntry.getName())
                        .extension("json")
                        .data(sevenZFile.getInputStream(archiveEntry).readAllBytes())
                        .build();
                incomeFileDtoList.add(incomeFileDto);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return incomeFileDtoList;
    }

    public static List<IncomeFileDto> unzipRar(final byte[] content) {
        List<IncomeFileDto> incomeFileDtoList = new LinkedList<>();
        IncomeFileDto incomeFileDto;
        InputStream inputStream = new ByteArrayInputStream(content);
        try {
            Archive archive = new Archive(inputStream);
            FileHeader fileHeader = archive.nextFileHeader();
            while (fileHeader != null) {
                incomeFileDto = IncomeFileDto.builder()
                        .name(fileHeader.getFileName())
                        .extension("json")
                        .data(archive.getInputStream(fileHeader).readAllBytes())
                        .build();
                incomeFileDtoList.add(incomeFileDto);
                fileHeader = archive.nextFileHeader();
            }
        } catch (RarException | IOException e) {
            e.printStackTrace();
        }

        return incomeFileDtoList;
    }
}
