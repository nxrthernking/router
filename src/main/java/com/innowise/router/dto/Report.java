package com.innowise.router.dto;

import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Report {

    private String storeName;
    private LocalDate startDate;
    private LocalDate endDate;
    private String saleId;
    private List<String> customersId;
    private String tin;
}
