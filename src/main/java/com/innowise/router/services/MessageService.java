package com.innowise.router.services;

import com.innowise.router.dto.MessageRequest;
import com.innowise.router.mappers.MessageMapper;
import com.innowise.router.repositories.MessageRepository;
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
