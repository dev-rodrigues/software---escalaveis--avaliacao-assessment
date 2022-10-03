package com.devrodrigues.avaliacaoassessment.datasources.database.repositories;

import com.devrodrigues.avaliacaoassessment.datasources.database.entities.SubmitEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubmitEntityRepository extends JpaRepository<SubmitEntity, Long> {
}
