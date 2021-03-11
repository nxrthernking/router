package com.innowise.test.repositories;

import com.innowise.test.entities.IncomeFileEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface IncomeFileRepository extends JpaRepository<IncomeFileEntity,Long> {
}
