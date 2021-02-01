package com.taomish.assignment.jobportal.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.Map;

@Data
@Entity
@Table(name = "JOB")
public class JobEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "job_id")
	private Integer jobId;
	
	@Column(name = "last_run_date")
	@Temporal(TemporalType.DATE)
	private Date lastRunDate;
	
	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private Schedule schedule;

	@Column(name = "weekdays", columnDefinition = "varchar(255)", nullable = false)
	private Map<String, Boolean> weekDays;
	
	
	@Column(name = "monthly_date", nullable = false)
	private Integer monthlyDate;
	
	public enum Schedule{
		DAILY,WEEKLY,MONTHLY
	}

	public void setMonthlyDate(Integer monthlyDate) throws Exception {
		if(monthlyDate<1 || monthlyDate>31){
			throw new Exception("Invalid date. Date must be within 1-31 range");
		}
		this.monthlyDate = monthlyDate;
	}
}
