package com.taomish.assignment.jobportal.utils;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.taomish.assignment.jobportal.dto.JobDTO;
import com.taomish.assignment.jobportal.model.JobEntity;

@Component
public class JobConverter {

	public JobDTO entityToDTO(JobEntity entity) {
		JobDTO dto = new JobDTO();
		dto.setJobId(entity.getJobId());
		dto.setLastRunDate(entity.getLastRunDate());
		dto.setMonthlyDate(entity.getMonthlyDate());
		dto.setSchedule(entity.getSchedule());
		dto.setWeekDays(entity.getWeekDays());
		return dto;
	}

	public List<JobDTO> entityToDTO(List<JobEntity> entities) {
		List<JobDTO> dtos = new ArrayList<>();
		for (JobEntity entity : entities) {
			JobDTO dto = new JobDTO();
			dto.setJobId(entity.getJobId());
			dto.setLastRunDate(entity.getLastRunDate());
			dto.setMonthlyDate(entity.getMonthlyDate());
			dto.setSchedule(entity.getSchedule());
			dto.setWeekDays(entity.getWeekDays());
			dtos.add(dto);
		}
		return dtos;
	}

	public JobEntity dtoToEntity(JobDTO jobDTO) throws Exception {
		JobEntity jobEntity = new JobEntity();
		jobEntity.setJobId(jobDTO.getJobId());
		jobEntity.setLastRunDate(jobDTO.getLastRunDate());
		jobEntity.setMonthlyDate(jobDTO.getMonthlyDate());
		jobEntity.setSchedule(jobDTO.getSchedule());
		jobEntity.setWeekDays(jobDTO.getWeekDays());
		return jobEntity;
	}

	public List<JobEntity> dtoToEntity(List<JobDTO> dtos) throws Exception {
		List<JobEntity> entities = new ArrayList<>();
		for (JobDTO jobDTO : dtos) {
			JobEntity jobEntity = new JobEntity();
			jobEntity.setJobId(jobDTO.getJobId());
			jobEntity.setLastRunDate(jobDTO.getLastRunDate());
			jobEntity.setMonthlyDate(jobDTO.getMonthlyDate());
			jobEntity.setSchedule(jobDTO.getSchedule());
			jobEntity.setWeekDays(jobDTO.getWeekDays());
			entities.add(jobEntity);
		}
		return entities;
	}
}
