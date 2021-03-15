package com.innowise.router.mapper;


import com.innowise.router.dto.MessageRequest;
import com.innowise.router.entity.Document;
import com.innowise.router.entity.File;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class MessageMapper {

    public Document mapToDocument(MessageRequest messageRequest, List<File> files) {
        return Document.builder()
                .sender(messageRequest.getSender())
                .date(messageRequest.getDate())
                .files(files)
                .build();
    }


}
