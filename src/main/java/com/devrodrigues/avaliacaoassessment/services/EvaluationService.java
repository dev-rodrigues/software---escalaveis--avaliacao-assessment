package com.devrodrigues.avaliacaoassessment.services;

import com.devrodrigues.avaliacaoassessment.core.Evaluation;
import com.devrodrigues.avaliacaoassessment.repositories.EvaluationRepository;
import com.devrodrigues.avaliacaoassessment.repositories.EventRepository;
import org.springframework.stereotype.Service;

@Service
public class EvaluationService {

    private final EvaluationRepository evaluationRepository;
    private final EventRepository eventRepository;

    public EvaluationService(EvaluationRepository evaluationRepository, EventRepository eventRepository) {
        this.evaluationRepository = evaluationRepository;
        this.eventRepository = eventRepository;
    }

    public Evaluation create(Evaluation evaluation) {
        var result = evaluationRepository.store(evaluation);
        eventRepository.send(result);
        return result;
    }
}
