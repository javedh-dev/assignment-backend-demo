package com.taomish.assignment.jobportal.dto;

import java.util.Date;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.taomish.assignment.jobportal.model.JobEntity.Schedule;

import lombok.Data;

@Data
public class JobDTO {

	private Integer jobId;
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy")
	private Date lastRunDate;
	private Schedule schedule;
	
	private Map<String, Boolean> weekDays;
	
	private Integer monthlyDate;

}
