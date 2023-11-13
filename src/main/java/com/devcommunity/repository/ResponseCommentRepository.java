package com.devcommunity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.devcommunity.entity.ResponseComment;

@Repository
public interface ResponseCommentRepository extends JpaRepository<ResponseComment, Integer>{

}
