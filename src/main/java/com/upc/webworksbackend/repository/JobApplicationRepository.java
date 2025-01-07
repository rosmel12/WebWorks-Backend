package com.upc.webworksbackend.repository;

import com.upc.webworksbackend.model.JobApplicationModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobApplicationRepository extends JpaRepository <JobApplicationModel,Integer>{
}
