package com.devcommunity.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.devcommunity.entity.Post;

@Repository
public interface PostRepository extends JpaRepository<Post, Integer>{
	
}
