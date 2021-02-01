package com.taomish.assignment.jobportal.dao;

import com.taomish.assignment.jobportal.model.JobEntity;
import org.springframework.data.repository.CrudRepository;

public interface JobRepository extends CrudRepository<JobEntity, Integer> {
	
}
