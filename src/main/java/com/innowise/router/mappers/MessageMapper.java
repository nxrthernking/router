package com.innowise.router.mappers;


import com.innowise.router.dto.MessageRequest;
import com.innowise.router.entities.Document;
import com.innowise.router.entities.File;
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
