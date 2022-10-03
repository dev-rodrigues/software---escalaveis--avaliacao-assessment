package com.devrodrigues.avaliacaoassessment.repositories;

import com.devrodrigues.avaliacaoassessment.core.Evaluation;

public interface EventRepository {
    void send(Evaluation event);
}
