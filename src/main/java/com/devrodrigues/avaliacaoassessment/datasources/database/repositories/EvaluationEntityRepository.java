package com.devrodrigues.avaliacaoassessment.datasources.database.repositories;

import com.devrodrigues.avaliacaoassessment.datasources.database.entities.EvaluationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EvaluationEntityRepository extends JpaRepository<EvaluationEntity, Long> {
}
