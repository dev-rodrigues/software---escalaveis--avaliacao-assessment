package com.devrodrigues.avaliacaoassessment.entrypoint.http;

import com.devrodrigues.avaliacaoassessment.entrypoint.http.mappers.SubmitActivityMappers;
import com.devrodrigues.avaliacaoassessment.openapi.api.SubmissionsApi;
import com.devrodrigues.avaliacaoassessment.openapi.model.Submit;
import com.devrodrigues.avaliacaoassessment.services.SubmitService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SubmissionsApiImpl implements SubmissionsApi {

    private final SubmitService service;
    private final SubmitActivityMappers mapper = SubmitActivityMappers.INSTANCE;

    public SubmissionsApiImpl(SubmitService service) {
        this.service = service;
    }

    @Override
    public ResponseEntity<List<Submit>> submissionsGet() {
        var result = service.list();
        var response = result.stream().map(mapper::map).toList();
        return ResponseEntity.ok(response);
    }
}
