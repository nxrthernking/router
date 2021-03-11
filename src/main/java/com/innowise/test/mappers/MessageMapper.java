package com.innowise.test.mappers;


import com.innowise.test.dto.MessageRequest;
import com.innowise.test.entities.MessageEntity;


public class MessageMapper {

    public MessageEntity mapToMessageEntity(MessageRequest messageRequest){

        return MessageEntity.builder()
                .sender(messageRequest.getSender())
                .date(messageRequest.getDate())
                .files(messageRequest.getFiles())
                .build();
    }

    public MessageRequest mapToMessageDto(MessageEntity messageEntity){

        return MessageRequest.builder()
                .sender(messageEntity.getSender())
                .date(messageEntity.getDate())
                .files(messageEntity.getFiles())
                .build();

    }

}
