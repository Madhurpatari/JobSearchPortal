package com.Geekster.JobSearchPortal.Repository;

import com.Geekster.JobSearchPortal.Model.Enum.JobType;
import com.Geekster.JobSearchPortal.Model.Job;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDate;
import java.util.List;



public interface IJobRepository extends CrudRepository<Job, Long> {
    //custom finders :
    List<Job> findByJobType(JobType jobType);
    List<Job> findByCompanyName(String companyName);

    //custom queries;
    @Modifying
    @Transactional
    @Query(value = "UPDATE JOB SET TITLE = :title WHERE ID = :id ", nativeQuery = true)
    void updateTitleById(Long id, String title);

    @Modifying
    @Transactional
    @Query(value = "UPDATE JOB SET SALARY = :salary WHERE ID = :id ", nativeQuery = true)
    void updateSalaryById(Long id, Double salary);

    @Modifying
    @Transactional
    @Query(value = "DELETE JOB WHERE COMPANY_NAME = :companyName ", nativeQuery = true)
    void deleteByCompanyName(String companyName);
}
