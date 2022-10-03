package com.devrodrigues.avaliacaoassessment.services;

import com.devrodrigues.avaliacaoassessment.core.Submit;
import com.devrodrigues.avaliacaoassessment.repositories.SubmitRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubmitService {

    private final SubmitRepository repository;

    public SubmitService(SubmitRepository repository) {
        this.repository = repository;
    }

    public void create(Submit submit) {
        repository.store(submit);
    }

    public List<Submit> list() {
        return repository.list();
    }
}
