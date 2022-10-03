package com.devrodrigues.avaliacaoassessment.entrypoint.http;

import com.devrodrigues.avaliacaoassessment.entrypoint.http.mappers.EvaluationMappers;
import com.devrodrigues.avaliacaoassessment.openapi.api.EvaluationApi;
import com.devrodrigues.avaliacaoassessment.openapi.model.CreateEvaluation;
import com.devrodrigues.avaliacaoassessment.openapi.model.Evaluation;
import com.devrodrigues.avaliacaoassessment.services.EvaluationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
public class EvaluationApiImpl implements EvaluationApi {

    private final EvaluationMappers mappers = EvaluationMappers.INSTANCE;
    private final EvaluationService service;

    public EvaluationApiImpl(EvaluationService service) {
        this.service = service;
    }

    @Override
    public ResponseEntity<Evaluation> evaluationPost(CreateEvaluation createEvaluation) {
        var request = mappers.map(createEvaluation);
        var result = service.create(request);
        var response = mappers.map(result);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest().path("/{id}")
                .buildAndExpand(result.getId()).toUri();

        return ResponseEntity.created(location).body(response);
    }
}
