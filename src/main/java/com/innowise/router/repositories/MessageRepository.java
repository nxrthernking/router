package com.innowise.router.repositories;

import com.innowise.router.entities.Document;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepository extends JpaRepository<Document,Long> {
}
