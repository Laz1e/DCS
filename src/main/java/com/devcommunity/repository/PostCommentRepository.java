package com.devcommunity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.devcommunity.entity.PostComment;

@Repository
public interface PostCommentRepository extends JpaRepository<PostComment, Integer>{

}
