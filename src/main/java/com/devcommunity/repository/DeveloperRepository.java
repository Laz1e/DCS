package com.devcommunity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.devcommunity.entity.Developer;

@Repository
public interface DeveloperRepository extends JpaRepository<Developer, Integer>{

}
