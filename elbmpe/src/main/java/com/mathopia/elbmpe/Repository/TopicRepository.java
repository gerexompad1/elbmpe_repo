package com.mathopia.elbmpe.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mathopia.elbmpe.Entity.TopicEntity;

public interface TopicRepository extends JpaRepository<TopicEntity, Integer> {
	TopicEntity findByTitle(String title);
	
}
