package com.devrodrigues.avaliacaoassessment.datasources.database.mappers;

import com.devrodrigues.avaliacaoassessment.core.Evaluation;
import com.devrodrigues.avaliacaoassessment.core.Submit;
import com.devrodrigues.avaliacaoassessment.datasources.database.entities.EvaluationEntity;
import com.devrodrigues.avaliacaoassessment.datasources.database.entities.SubmitEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

@Mapper
public interface EvaluationEntityMapper {

    EvaluationEntityMapper INSTANCE = Mappers.getMapper(EvaluationEntityMapper.class);

    @Mapping(source = "submit", target = "submit", qualifiedByName = "mapSubmit")
    EvaluationEntity map(Evaluation evaluation);

    Evaluation map(EvaluationEntity entity);

    //
    @Named("mapSubmit")
    default SubmitEntity mapSubmit(Submit submission) {
        if (submission == null) {
            return null;
        }

        SubmitEntity submitEntity = new SubmitEntity();
        submitEntity.setId(submission.getId());
        return submitEntity;
    }
}
