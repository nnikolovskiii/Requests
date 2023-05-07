package mk.ukim.finki.application.model.dto;

import lombok.Data;

@Data
public class RequestDto{

    private Long application;

    private String description;

    private String requestStatus;

    private String submissionDate;

    private Long course;
    private Long currentProfessor;

    private Long newProfessor;
    private String currentMajorType;

    private String newMajorType;
    private Integer numOfInstallments;
}
