package com.devrodrigues.avaliacaoassessment.datasources.database.entities;

import javax.persistence.*;

@Entity(name = "Evaluation")
public class EvaluationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long activity;

    private Integer note;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "submit_id", referencedColumnName = "id")
    private SubmitEntity submit;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getActivity() {
        return activity;
    }

    public void setActivity(Long activity) {
        this.activity = activity;
    }

    public Integer getNote() {
        return note;
    }

    public void setNote(Integer note) {
        this.note = note;
    }

    public SubmitEntity getSubmit() {
        return submit;
    }

    public void setSubmit(SubmitEntity submit) {
        this.submit = submit;
    }
}
