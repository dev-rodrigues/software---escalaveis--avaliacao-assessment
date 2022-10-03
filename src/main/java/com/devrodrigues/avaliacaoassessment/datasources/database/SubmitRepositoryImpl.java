package com.devrodrigues.avaliacaoassessment.datasources.database;

import com.devrodrigues.avaliacaoassessment.core.Submit;
import com.devrodrigues.avaliacaoassessment.datasources.database.mappers.SubmitEntityMapper;
import com.devrodrigues.avaliacaoassessment.datasources.database.repositories.SubmitEntityRepository;
import com.devrodrigues.avaliacaoassessment.repositories.SubmitRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SubmitRepositoryImpl implements SubmitRepository {

    private final SubmitEntityRepository repository;
    private final SubmitEntityMapper mapper = SubmitEntityMapper.INSTANCE;

    public SubmitRepositoryImpl(SubmitEntityRepository repository) {
        this.repository = repository;
    }

    @Override
    public void store(Submit submit) {
        var entity = mapper.map(submit);
        var saved = repository.save(entity);

        System.out.println(saved);
    }

    @Override
    public List<Submit> list() {
        var entities = repository.findAll();
        return entities.stream().map(mapper::map).toList();
    }
}
