package com.devrodrigues.avaliacaoassessment.entrypoint.message;

import com.devrodrigues.avaliacaoassessment.core.Submit;
import com.devrodrigues.avaliacaoassessment.services.SubmitService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class SubmitListener {
    private final SubmitService service;
    private final ObjectMapper mapper;

    public SubmitListener(SubmitService service, ObjectMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @JmsListener(destination = "activity.submitted.queue", containerFactory = "jmsListenerContainerFactory")
    public void listen(String message) throws JsonProcessingException {
        var submit = mapper.readValue(message, Submit.class);
        service.create(submit);
    }
}