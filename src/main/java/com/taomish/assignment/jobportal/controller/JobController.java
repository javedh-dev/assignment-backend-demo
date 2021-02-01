package com.taomish.assignment.jobportal.controller;

import com.taomish.assignment.jobportal.dto.JobDTO;
import com.taomish.assignment.jobportal.dto.JobHistoryDTO;
import com.taomish.assignment.jobportal.model.JobEntity;
import com.taomish.assignment.jobportal.model.JobHistoryEntity;
import com.taomish.assignment.jobportal.services.JobHistoryService;
import com.taomish.assignment.jobportal.services.JobService;
import com.taomish.assignment.jobportal.utils.JobConverter;
import com.taomish.assignment.jobportal.utils.JobHistoryConverter;
import com.taomish.assignment.jobportal.utils.ResponseWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.Map;

@RestController
public class JobController {

    @Autowired
    JobService jobService;

    @Autowired
    JobHistoryService jobHistoryService;

    @Autowired
    JobConverter jobConverter;

    @Autowired
    JobHistoryConverter jobHistoryConverter;

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/getAllJobs")
    public ResponseEntity<ResponseWrapper> getAllEntities() {
        ResponseWrapper wrapper = new ResponseWrapper();
        HttpStatus status = HttpStatus.OK;
        try {
            wrapper.setMessage("fetched jobs successfully.");
            wrapper.getResponse().put("jobs", jobService.getAllJobs());
        } catch (Exception e) {
            status = wrapper.setError(e, "Error while fetching jobs.");
            e.printStackTrace();
        }
        return new ResponseEntity<>(wrapper, status);
    }


    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/addJob")
    public ResponseEntity<ResponseWrapper> addJob(@RequestBody JobDTO jobDTO) {
        ResponseWrapper wrapper = new ResponseWrapper();
        HttpStatus status = HttpStatus.OK;
        try {
            JobEntity entity = jobConverter.dtoToEntity(jobDTO);
            entity = jobService.addJob(entity);
            wrapper.setMessage("Added job successfully.");
            wrapper.getResponse().put("job_id", entity.getJobId());
        } catch (Exception e) {
            status = wrapper.setError(e, "Error while adding job.");
            e.printStackTrace();
        }
        return new ResponseEntity<ResponseWrapper>(wrapper, status);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/getJobHistory")
    public ResponseEntity<ResponseWrapper> getJobHistory(@RequestParam Map<String, String> params) {
        ResponseWrapper wrapper = new ResponseWrapper();
        HttpStatus status = HttpStatus.OK;
        try {
            wrapper.setMessage("fetched job history successfully.");
            wrapper.getResponse().put("history", jobHistoryConverter.entityToDTO(
                    jobHistoryService.getJobHistory(Integer.parseInt(params.get("job_id")))));
        } catch (Exception e) {
            status = wrapper.setError(e, "Error while fetching job history.");
            e.printStackTrace();
        }
        return new ResponseEntity<>(wrapper, status);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/addJobHistory")
    public ResponseEntity<ResponseWrapper> addJob(@RequestBody JobHistoryDTO jobHistoryDTO) {
        ResponseWrapper wrapper = new ResponseWrapper();
        HttpStatus status = HttpStatus.OK;
        try {
            JobEntity job = jobService.getJobByID(jobHistoryDTO.getJobId());
            if(null==job){
                throw new Exception("Invalid job ID");
            }
            job.setLastRunDate(new Date());
            job = jobService.addJob(job);
            JobHistoryEntity jobHistoryEntity = jobHistoryConverter.dtoToEntity(jobHistoryDTO);
            jobHistoryEntity.setJob(job);
            JobHistoryEntity entity = jobHistoryService.addJobHistory(jobHistoryEntity);
            wrapper.setMessage("Added job history successfully.");
            wrapper.getResponse().put("id", entity.getId());
        } catch (Exception e) {
            status = wrapper.setError(e, "Error while adding job history.");
            e.printStackTrace();
        }
        return new ResponseEntity<>(wrapper, status);
    }
}
