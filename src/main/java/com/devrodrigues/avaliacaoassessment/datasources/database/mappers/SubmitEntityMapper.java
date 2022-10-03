package com.devrodrigues.avaliacaoassessment.datasources.database.mappers;

import com.devrodrigues.avaliacaoassessment.core.Submit;
import com.devrodrigues.avaliacaoassessment.datasources.database.entities.SubmitEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface SubmitEntityMapper {

    SubmitEntityMapper INSTANCE = Mappers.getMapper(SubmitEntityMapper.class);

    @Mapping(source = "atividadeId", target = "activity")
    SubmitEntity map(Submit submit);

    @Mapping(source = "activity", target = "atividadeId")
    Submit map(SubmitEntity entity);
}
