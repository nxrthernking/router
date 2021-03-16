package com.innowise.router.repository;

import com.innowise.router.entity.File;
import org.springframework.data.jpa.repository.JpaRepository;


public interface FileRepository extends JpaRepository<File,Long> {
}
