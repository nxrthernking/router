package com.innowise.router.repositories;

import com.innowise.router.entities.File;
import org.springframework.data.jpa.repository.JpaRepository;


public interface IncomeFileRepository extends JpaRepository<File,Long> {
}
