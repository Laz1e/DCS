package com.devcommunity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.devcommunity.entity.ResponseVote;
@Repository
public interface ResponseVoteRepository extends JpaRepository<ResponseVote, Integer>{

}
