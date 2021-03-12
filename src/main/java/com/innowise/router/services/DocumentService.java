package com.innowise.router.services;

import com.innowise.router.dto.MessageRequest;
import com.innowise.router.entities.Document;
import com.innowise.router.entities.File;
import com.innowise.router.mappers.MessageMapper;
import com.innowise.router.repositories.DocumentRepository;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.LinkedList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DocumentService {

    private final DocumentRepository documentRepository;

    private final MessageMapper messageMapper;

    private final FileService fileService;

    @SneakyThrows
    public void process(MessageRequest messageRequest) {
        List<File> files = new LinkedList<>();
        for (MultipartFile file : messageRequest.getFiles()) {
            files.addAll(fileService.process(file));
        }
        Document document = messageMapper.mapToDocument(messageRequest, files);
        documentRepository.save(document);
    }
}
