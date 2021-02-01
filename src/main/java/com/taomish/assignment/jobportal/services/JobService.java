package com.taomish.assignment.jobportal.services;

import com.taomish.assignment.jobportal.dao.JobRepository;
import com.taomish.assignment.jobportal.model.JobEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class JobService {

    @Autowired
    JobRepository jobRepository;

    public List<JobEntity> getAllJobs() {
        List<JobEntity> entities = new ArrayList<>();
        for( JobEntity entity : jobRepository.findAll()){
            entities.add(entity);
        }
        return entities;
    }

    public JobEntity getJobByID(Integer jobID) {
        return jobRepository.findById(jobID).orElse(null);
    }

    public JobEntity addJob(JobEntity jobEntity) {
        return jobRepository.save(jobEntity);
    }
}
