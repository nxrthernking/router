package com.innowise.router;

import com.innowise.router.service.DocumentService;
import com.innowise.router.service.FileService;
import container.PostgresContainer;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;

//@RunWith(SpringRunner.class)
@ExtendWith(SpringExtension.class)
@SpringBootTest
@ContextConfiguration(initializers = PostgresContainer.class)
public abstract class IntegrationTest {

    @Autowired
    protected FileService fileService;

    @Autowired
    protected DocumentService documentService;




}
