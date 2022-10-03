package com.devrodrigues.avaliacaoassessment.repositories;

import com.devrodrigues.avaliacaoassessment.core.Evaluation;

public interface EvaluationRepository {

    Evaluation store(Evaluation evaluation);
}
