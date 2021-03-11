package com.innowise.test.services;

import com.innowise.test.dto.MessageRequest;
import com.innowise.test.mappers.MessageMapper;
import com.innowise.test.repositories.MessageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MessageService {

    private final MessageRepository messageRepository;

    private final MessageMapper messageMapper;

    private final IncomeFileService incomeFileService;

    public void process(MessageRequest messageRequest){

    }
}
