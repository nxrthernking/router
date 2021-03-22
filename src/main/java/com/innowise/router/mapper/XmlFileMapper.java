package com.innowise.router.mapper;

import com.innowise.router.dto.Report;
import com.innowise.router.dto.XmlReport;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class XmlFileMapper {

    public List<Report> mapToReportList(List<XmlReport> xmlReports) {
        return xmlReports.stream()
                .map(this::mapToReport)
                .collect(Collectors.toList());
    }

    private Report mapToReport(XmlReport xmlReport){
        return Report.builder()
                .storeName(xmlReport.getStoreName())
                .startDate(xmlReport.getStartDate())
                .endDate(xmlReport.getEndDate())
                .saleId(xmlReport.getSaleId())
                .customersId(xmlReport.getCustomersId())
                .tin(xmlReport.getTin())
                .build();
    }

}
