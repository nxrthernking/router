package com.innowise.router.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.*;
import java.time.LocalDate;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@XmlRootElement(name = "report")
@XmlAccessorType(value = XmlAccessType.FIELD)
public class XMLReport {
    @XmlElement(required = true)
    private String storeName;
    @XmlElement(required = true)
    private LocalDate startDate;
    @XmlElement(required = true)
    private LocalDate endDate;
    @XmlElement(required = true)
    private String saleId;
    @XmlElementWrapper(name = "customers", required = true)
    @XmlElement(name = "customerId", required = true)
    private List<String> customersId;
    @XmlElement(required = true)
    private String tin;
}
