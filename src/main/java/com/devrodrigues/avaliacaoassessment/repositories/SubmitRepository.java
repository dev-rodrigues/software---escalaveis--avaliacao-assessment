package com.devrodrigues.avaliacaoassessment.repositories;

import com.devrodrigues.avaliacaoassessment.core.Submit;

import java.util.List;

public interface SubmitRepository {

    void store(Submit submit);
    List<Submit> list();
}
