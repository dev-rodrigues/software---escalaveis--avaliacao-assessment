package com.devrodrigues.avaliacaoassessment.datasources.database;

import com.devrodrigues.avaliacaoassessment.core.Evaluation;
import com.devrodrigues.avaliacaoassessment.datasources.database.mappers.EvaluationEntityMapper;
import com.devrodrigues.avaliacaoassessment.datasources.database.repositories.EvaluationEntityRepository;
import com.devrodrigues.avaliacaoassessment.datasources.database.repositories.SubmitEntityRepository;
import com.devrodrigues.avaliacaoassessment.repositories.EvaluationRepository;
import org.springframework.stereotype.Component;

@Component
public class EvaluationRepositoryImpl implements EvaluationRepository {

    private final EvaluationEntityRepository evaluationEntityRepository;
    private final SubmitEntityRepository submitRepository;
    private final EvaluationEntityMapper mapper = EvaluationEntityMapper.INSTANCE;

    public EvaluationRepositoryImpl(EvaluationEntityRepository evaluationEntityRepository, SubmitEntityRepository submitRepository) {
        this.evaluationEntityRepository = evaluationEntityRepository;
        this.submitRepository = submitRepository;
    }

    @Override
    public Evaluation store(Evaluation evaluation) {
        var entity = mapper.map(evaluation);
        var submit = submitRepository.findById(entity.getSubmit().getId());

        if (submit.isPresent()) {
            entity.setSubmit(submit.get());
            var saved = evaluationEntityRepository.save(entity);
            return mapper.map(saved);
        }

        throw new RuntimeException("Submit not found");
    }
}
