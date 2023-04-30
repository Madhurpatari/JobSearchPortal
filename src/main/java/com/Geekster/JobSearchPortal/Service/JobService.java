package com.Geekster.JobSearchPortal.Service;

import com.Geekster.JobSearchPortal.Model.Enum.JobType;
import com.Geekster.JobSearchPortal.Model.Job;
import com.Geekster.JobSearchPortal.Repository.IJobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class JobService {
    @Autowired
     IJobRepository jobRepository;
    public List<Job> getAllJobs() {
        return (List<Job>) jobRepository.findAll();
    }

    public ResponseEntity<Job> addJob(Job job) {
        Job savedJob = jobRepository.save(job);
        return new ResponseEntity<>(savedJob, HttpStatus.CREATED);
    }

    public ResponseEntity<Job> updateJob(Long id, JobType jobType) {
        Optional<Job> optionalJob = jobRepository.findById(id);
        if(optionalJob.isPresent()){
            Job job = optionalJob.get();
            job.setJobType(jobType);
            jobRepository.save(job);
            return new ResponseEntity<>(job, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<Void> remove(Long id) {
        Optional<Job> existingJob = jobRepository.findById(id);
        if (existingJob.isPresent()) {
            jobRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    //get job based on job-type
    public ResponseEntity<List<Job>> getJobByJobType(JobType jobType) {
        List<Job> jobs = jobRepository.findByJobType(jobType);
        return new ResponseEntity<>(jobs, HttpStatus.OK);
    }

    public ResponseEntity<List<Job>> getJobByCompanyName(String companyName) {
        List<Job> jobs = jobRepository.findByCompanyName(companyName);
        return new ResponseEntity<>(jobs, HttpStatus.OK);
    }


    public void updateTitleBasedOnId(Long id, String title) {
        jobRepository.updateTitleById(id, title);
    }

    public void updateSalaryBasedOnId(Long id, Double salary) {
        jobRepository.updateSalaryById(id, salary);
    }

    public void deleteJobByCompanyName(String companyName) {
        jobRepository.deleteByCompanyName(companyName);
    }
}
