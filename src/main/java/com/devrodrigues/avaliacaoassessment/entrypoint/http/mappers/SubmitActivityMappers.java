package com.devrodrigues.avaliacaoassessment.entrypoint.http.mappers;

import com.devrodrigues.avaliacaoassessment.openapi.model.Submit;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.time.Instant;
import java.time.OffsetDateTime;

@Mapper
public interface SubmitActivityMappers {

    SubmitActivityMappers INSTANCE = Mappers.getMapper(SubmitActivityMappers.class);

    @Mapping(source = "createdAt", target = "createdAt", qualifiedByName = "instantToOffsetDateTime")
    Submit map(com.devrodrigues.avaliacaoassessment.core.Submit submit);

    @Named("instantToOffsetDateTime")
    default OffsetDateTime map(Instant instant) {
        return instant.atOffset(OffsetDateTime.now().getOffset());
    }
}
