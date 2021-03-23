package com.innowise.router.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.time.LocalDate;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@XmlRootElement(name = "report")
@XmlAccessorType(value = XmlAccessType.FIELD)
public class XmlReport {
    @XmlElement(required = true)
    private String storeName;
    @XmlJavaTypeAdapter(LocalDateAdapter.class)
    @XmlElement(required = true)
    private LocalDate startDate;
    @XmlJavaTypeAdapter(LocalDateAdapter.class)
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
