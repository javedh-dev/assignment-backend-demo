package com.taomish.assignment.jobportal.utils;

import com.taomish.assignment.jobportal.dto.JobHistoryDTO;
import com.taomish.assignment.jobportal.model.JobHistoryEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class JobHistoryConverter {

	public JobHistoryDTO entityToDTO(JobHistoryEntity entity) {
		JobHistoryDTO dto = new JobHistoryDTO();
		dto.setJobId(entity.getJob().getJobId());
		dto.setEndTime(entity.getEndTime());
		dto.setMonthlyDate(entity.getMonthlyDate());
		dto.setErrorDetails(entity.getErrorDetails());
		dto.setSchedule(entity.getSchedule());
		dto.setId(entity.getId());
		dto.setPublished(entity.isPublished());
		dto.setJobParameters(entity.getJobParameters());
		validateStatusMap(entity, dto);
		dto.setStartTime(entity.getStartTime());
		dto.setRunBy(entity.getRunBy());
		dto.setRunDate(entity.getRunDate());
		dto.setWeekDays(entity.getWeekDays());
		return dto;
	}

	public List<JobHistoryDTO> entityToDTO(List<JobHistoryEntity> entities) {
		List<JobHistoryDTO> dtos = new ArrayList<>();
		for (JobHistoryEntity entity : entities) {
			JobHistoryDTO dto = new JobHistoryDTO();
			dto.setJobId(entity.getJob().getJobId());
			dto.setEndTime(entity.getEndTime());
			dto.setMonthlyDate(entity.getMonthlyDate());
			dto.setErrorDetails(entity.getErrorDetails());
			dto.setSchedule(entity.getSchedule());
			dto.setId(entity.getId());
			dto.setPublished(entity.isPublished());
			dto.setJobParameters(entity.getJobParameters());
			validateStatusMap(entity, dto);
			dto.setStartTime(entity.getStartTime());
			dto.setRunBy(entity.getRunBy());
			dto.setRunDate(entity.getRunDate());
			dto.setWeekDays(entity.getWeekDays());
			dtos.add(dto);
		}
		return dtos;
	}

	public JobHistoryEntity dtoToEntity(JobHistoryDTO jobHistoryDTO) throws Exception {
		JobHistoryEntity jobHistoryEntity = new JobHistoryEntity();
		jobHistoryEntity.setEndTime(jobHistoryDTO.getEndTime());
		jobHistoryEntity.setMonthlyDate(jobHistoryDTO.getMonthlyDate());
		jobHistoryEntity.setErrorDetails(jobHistoryDTO.getErrorDetails());
		jobHistoryEntity.setSchedule(jobHistoryDTO.getSchedule());
		jobHistoryEntity.setId(jobHistoryDTO.getId());
		jobHistoryEntity.setPublished(jobHistoryDTO.isPublished());
		jobHistoryEntity.setJobParameters(jobHistoryDTO.getJobParameters());
		jobHistoryEntity.setStatusMap(jobHistoryDTO.getStatusMap());
		jobHistoryEntity.setStartTime(jobHistoryDTO.getStartTime());
		jobHistoryEntity.setRunBy(jobHistoryDTO.getRunBy());
		jobHistoryEntity.setRunDate(jobHistoryDTO.getRunDate());
		jobHistoryEntity.setWeekDays(jobHistoryDTO.getWeekDays());
		return jobHistoryEntity;
	}

	public List<JobHistoryEntity> dtoToEntity(List<JobHistoryDTO> dtos) throws Exception {
		List<JobHistoryEntity> entities = new ArrayList<>();
		for (JobHistoryDTO jobHistoryDTO : dtos) {
			JobHistoryEntity jobHistoryEntity = new JobHistoryEntity();
			jobHistoryEntity.setEndTime(jobHistoryDTO.getEndTime());
			jobHistoryEntity.setMonthlyDate(jobHistoryDTO.getMonthlyDate());
			jobHistoryEntity.setErrorDetails(jobHistoryDTO.getErrorDetails());
			jobHistoryEntity.setSchedule(jobHistoryDTO.getSchedule());
			jobHistoryEntity.setId(jobHistoryDTO.getId());
			jobHistoryEntity.setPublished(jobHistoryDTO.isPublished());
			jobHistoryEntity.setJobParameters(jobHistoryDTO.getJobParameters());
			jobHistoryEntity.setStatusMap(jobHistoryDTO.getStatusMap());
			jobHistoryEntity.setStartTime(jobHistoryDTO.getStartTime());
			jobHistoryEntity.setRunBy(jobHistoryDTO.getRunBy());
			jobHistoryEntity.setRunDate(jobHistoryDTO.getRunDate());
			jobHistoryEntity.setWeekDays(jobHistoryDTO.getWeekDays());
			entities.add(jobHistoryEntity);
		}
		return entities;
	}

	private void validateStatusMap(JobHistoryEntity entity, JobHistoryDTO dto) {
		Map<String, JobHistoryEntity.StepStatus> status = new HashMap<>();
		for(Map.Entry kv : entity.getStatusMap().entrySet()){
			status.put(kv.getKey().toString(), JobHistoryEntity.StepStatus.valueOf(kv.getValue().toString()));
		}
		dto.setStatusMap(status);
	}
}
