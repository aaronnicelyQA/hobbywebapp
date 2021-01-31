package com.qa.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qa.persistence.domain.PeopleDomain;

@Repository
public interface PeopleRepo extends JpaRepository<PeopleDomain, Long>{

}
