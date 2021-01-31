package com.qa.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qa.persistence.domain.TrainDomain;

@Repository
public interface TrainRepo extends JpaRepository<TrainDomain, Long>{

}