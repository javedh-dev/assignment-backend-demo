package com.taomish.assignment.jobportal.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.taomish.assignment.jobportal.model.JobEntity;
import com.taomish.assignment.jobportal.model.JobHistoryEntity;
import lombok.Data;

import javax.persistence.Column;
import java.util.Date;
import java.util.Map;

@Data
public class JobHistoryDTO {

    private Integer id;

    private Integer jobId;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss.SSS")
    private Date startTime = new Date();

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss.SSS")
    private Date endTime;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private Date runDate = new Date();

    private Map<String, String> jobParameters;

    private JobEntity.Schedule schedule;

    private Integer monthlyDate;

    private Map<String, Boolean> weekDays;

    private Map<String, JobHistoryEntity.StepStatus> statusMap;

    private boolean published;

    private String errorDetails;

    private String runBy;

}
