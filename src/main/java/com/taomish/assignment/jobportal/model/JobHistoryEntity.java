package com.taomish.assignment.jobportal.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.taomish.assignment.jobportal.utils.MapConverter;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.Map;

@Data
@Entity
@Table(name = "job_history")
public class JobHistoryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "job_id", nullable = false)
    private JobEntity job;

    @Temporal(TemporalType.TIMESTAMP)
    private Date startTime = new Date();

    @Temporal(TemporalType.TIMESTAMP)
    private Date endTime;

    @Temporal(TemporalType.DATE)
    private Date runDate;

    @Lob
    @Convert(converter = MapConverter.class)
    @Column(name = "job_parameters")
    private Map<String, String> jobParameters;

    @Enumerated(EnumType.STRING)
    private JobEntity.Schedule schedule;

    @Column(name = "monthly_date")
    private Integer monthlyDate;

    @Convert(converter = MapConverter.class)
    @Column(name = "status")
    private Map<String, StepStatus> statusMap;


    @Column(name = "published")
    private boolean published;

    @Lob
    @Column(name = "error_details", length = 1024)
    private String errorDetails;

    @Column(name = "run_by")
    private String runBy;

    @Column(name = "weekdays", columnDefinition = "varchar(255)", nullable = false)
    private Map<String, Boolean> weekDays;

    public enum StepStatus {
        FAILED, SUCCESSFUL, IN_PROGRESS
    }

    public void setMonthlyDate(Integer monthlyDate) throws Exception {
        if(monthlyDate<1 || monthlyDate>30){
            throw new Exception("Invalid date. Date must be within 1-30 range");
        }
        this.monthlyDate = monthlyDate;
    }

}
