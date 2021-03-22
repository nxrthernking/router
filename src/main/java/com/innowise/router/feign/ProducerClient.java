package com.innowise.router.feign;


import com.innowise.router.dto.Report;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@FeignClient(url = "${client.producer}", name = "producer")
public interface ProducerClient {

    @PostMapping("/reports")
    void sendReports(List<Report> reports);
}
