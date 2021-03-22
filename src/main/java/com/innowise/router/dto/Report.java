package com.innowise.router.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Report {

    private String storeName;
    private LocalDate startDate;
    private LocalDate endDate;
    private String saleId;
    private List<String> customerId;
    private String tin;
}
