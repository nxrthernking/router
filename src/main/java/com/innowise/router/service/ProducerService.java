package com.innowise.router.service;

import com.innowise.router.dto.Report;
import com.innowise.router.feign.ProducerClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProducerService {

    private final ProducerClient client;

    void sendToProducer(List<Report> reports) {
        client.sendReports(reports);
    }
}
