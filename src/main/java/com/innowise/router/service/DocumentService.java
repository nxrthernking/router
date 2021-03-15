package com.innowise.router.service;

import com.innowise.router.dto.MessageRequest;
import com.innowise.router.entity.Document;
import com.innowise.router.entity.File;
import com.innowise.router.mapper.MessageMapper;
import com.innowise.router.repository.DocumentRepository;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DocumentService {

    private final DocumentRepository documentRepository;

    private final MessageMapper messageMapper;

    private final FileService fileService;

    @SneakyThrows
    public void documentProcess(MessageRequest messageRequest) {
        List<File> files = messageRequest.getFiles()
                .stream()
                .map(fileService::process)
                .flatMap(List::stream)
                .collect(Collectors.toList());
        Document document = messageMapper.mapToDocument(messageRequest, files);
        documentRepository.save(document);
    }
}
