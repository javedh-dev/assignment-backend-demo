package com.taomish.assignment.jobportal.dao;

import com.taomish.assignment.jobportal.model.JobHistoryEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface JobHistoryRepository extends CrudRepository<JobHistoryEntity, Integer> {

    @Query("from JobHistoryEntity where job_id = :jobID")
    List<JobHistoryEntity> findByJobID(@Param("jobID") Integer jobId);
}
