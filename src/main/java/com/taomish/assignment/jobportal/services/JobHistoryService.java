package com.taomish.assignment.jobportal.services;

import com.taomish.assignment.jobportal.dao.JobHistoryRepository;
import com.taomish.assignment.jobportal.dao.JobRepository;
import com.taomish.assignment.jobportal.dto.JobDTO;
import com.taomish.assignment.jobportal.dto.JobHistoryDTO;
import com.taomish.assignment.jobportal.model.JobEntity;
import com.taomish.assignment.jobportal.model.JobHistoryEntity;
import com.taomish.assignment.jobportal.utils.JobConverter;
import com.taomish.assignment.jobportal.utils.JobHistoryConverter;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class JobHistoryService {

    @Autowired
    private JobHistoryRepository jobHistoryRepository;

    @Autowired
    private JobHistoryConverter converter;

    public JobHistoryEntity addJobHistory(JobHistoryEntity jobHistoryEntity) {
        return jobHistoryRepository.save(jobHistoryEntity);
    }

    public List<JobHistoryEntity> getJobHistory(int jobId) {
        return jobHistoryRepository.findByJobID(jobId);
    }
}
