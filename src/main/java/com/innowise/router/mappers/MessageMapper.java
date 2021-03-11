package com.innowise.router.mappers;


import com.innowise.router.dto.MessageRequest;
import com.innowise.router.entities.Document;
import org.springframework.stereotype.Component;


@Component
public class MessageMapper {

    // TODO: 11.03.2021 ZAEBAL POFIXI

    public Document mapToMessageEntity(MessageRequest messageRequest){

        return Document.builder()
                .sender(messageRequest.getSender())
                .date(messageRequest.getDate())
                //.files(messageRequest.getFiles())
                .build();
    }

    public MessageRequest mapToMessageDto(Document document){

        return MessageRequest.builder()
                .sender(document.getSender())
                .date(document.getDate())
                //.files(document.getFiles())
                .build();

    }

}
