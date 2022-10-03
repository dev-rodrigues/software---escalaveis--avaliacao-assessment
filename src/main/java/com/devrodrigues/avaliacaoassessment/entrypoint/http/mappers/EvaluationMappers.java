package com.devrodrigues.avaliacaoassessment.entrypoint.http.mappers;

import com.devrodrigues.avaliacaoassessment.core.Evaluation;
import com.devrodrigues.avaliacaoassessment.core.Submit;
import com.devrodrigues.avaliacaoassessment.openapi.model.CreateEvaluation;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

@Mapper
public interface EvaluationMappers {
    EvaluationMappers INSTANCE = Mappers.getMapper(EvaluationMappers.class);

    @Mapping(source = "submission", target = "submit", qualifiedByName = "mapSubmit")
    Evaluation map(CreateEvaluation createEvaluation);

    @Mapping(source = "submit.id", target = "submission")
    com.devrodrigues.avaliacaoassessment.openapi.model.Evaluation map(Evaluation evaluation);


    //
    @Named("mapSubmit")
    default Submit mapSubmit(Long submission) {
        if (submission == null) {
            return null;
        }
        Submit submit = new Submit();
        submit.setId(submission);

        return submit;
    }
}
