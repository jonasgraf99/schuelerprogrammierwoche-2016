/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sybit.education.taschengeldboerse.service;

import com.sybit.education.taschengeldboerse.domain.Job;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sybit.education.taschengeldboerse.repository.JobsRepository;

/**
 * Implementierung des Services für die Jobs.
 * 
 */
@Service
public class JobsServiceImpl implements JobsService {

    @Autowired
    JobsRepository jobRepository;
    
    /**
     * Lade alle Jobs.
     * 
     * @return 
     */
    @Override
    public List<Job> findAll() {
        return jobRepository.findAll();
    }

    /**
     * Neuen Job hinufügen.
     * 
     * @param job 
     */
    @Override
    public void addJob(Job job) {
        
        if(job.getAnbieter() == null) {
            job.setAnbieter(1); //zum Standardbenutzer hinzufügen. Muss noch geändert werden.
        }
        jobRepository.save(job);
    }
    
    /**
     * Job anhand der id aus der datenbank laden.
     * 
     * @param id
     * @return 
     */
    @Override
    public Job findById(Integer id) {
        return jobRepository.findOne(id);
    }
    
}
