package com.devcommunity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.devcommunity.entity.PostVote;

@Repository
public interface PostVoteRepository extends JpaRepository<PostVote, Integer>{

}
