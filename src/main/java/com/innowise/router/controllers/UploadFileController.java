package com.innowise.router.controllers;

import com.innowise.router.dto.MessageRequest;
import com.innowise.router.services.MessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UploadFileController {

    private final MessageService messageService;

    @PostMapping(value = "/upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public void uploadFile(@ModelAttribute MessageRequest messageRequest) {
        messageService.process(messageRequest);
    }
}
