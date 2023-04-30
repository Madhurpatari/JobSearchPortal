package com.Geekster.JobSearchPortal.Controller;

import com.Geekster.JobSearchPortal.Model.Enum.JobType;
import com.Geekster.JobSearchPortal.Model.Job;
import com.Geekster.JobSearchPortal.Service.JobService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/jobs")
public class JobController {
    @Autowired
    JobService jobService;

    //Add jobs
    @PostMapping
    public ResponseEntity<Job> addJob(@Valid @RequestBody Job job){
        return jobService.addJob(job);
    }
    //Get all jobs
    @GetMapping
    public List<Job> getAllJobs() {
        return jobService.getAllJobs();
    }
    //update the job
    @PutMapping(value = "/{id}")
    public ResponseEntity<Job> updateJob(@PathVariable Long id, @RequestParam JobType jobType){
        return jobService.updateJob(id, jobType);
    }


    //delete job by id
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteJobById(@PathVariable Long id){
        return jobService.remove(id);
    }

    //get job based on job-type
    @GetMapping(value = "/jobType/{jobType}")
    public ResponseEntity<List<Job>> getJobByJobType(@PathVariable JobType jobType){
        return jobService.getJobByJobType(jobType);
    }

    //get job based on companyName
    @GetMapping(value = "/companyName")
    public ResponseEntity<List<Job>> getJobByCompanyName(@RequestParam String  companyName){
        return jobService.getJobByCompanyName(companyName);
    }

    //update job title based on id
    @PutMapping("/id/title/{id}/{title}")
    public void updateTitleBasedOnId(@PathVariable Long id, @PathVariable String title){
        jobService.updateTitleBasedOnId(id, title);
    }

    //update salary  based on id
    @PutMapping("/id/salary/{id}/{salary}")
    public void updateSalaryBasedOnId(@PathVariable Long id, @PathVariable Double salary){
        jobService.updateSalaryBasedOnId(id, salary);
    }

    //delete job   based on companyName
    @DeleteMapping(value = "/companyName/{companyName}")
    public  void deleteJobByCompanyName(@PathVariable String companyName){
         jobService.deleteJobByCompanyName(companyName);
    }

}
