package com.mathopia.elbmpe.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mathopia.elbmpe.Entity.GameEntity;

@Repository
public interface GameRepository extends JpaRepository<GameEntity, Integer> {
	GameEntity findByGameTitle(String gameTitle);
}

