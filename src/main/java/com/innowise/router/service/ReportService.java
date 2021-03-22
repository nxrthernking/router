package com.innowise.router.service;


import com.innowise.router.dto.Report;
import com.innowise.router.entity.File;
import com.innowise.router.mapper.ReportParserFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ReportService {

    private final ReportParserFactory reportParserFactory;

    public List<Report> sendReport(List<File> files) {
        final List<Report> reportsList = createReportsList(files);

        return reportsList;
    }

    private List<Report> createReportsList(List<File> files) {
        return files.stream()
                .map(file -> reportParserFactory
                        .getFileParserFromFactory(file.getFileExtension())
                        .parse(file.getContent()))
                .flatMap(List::stream)
                .collect(Collectors.toList());
    }
}
