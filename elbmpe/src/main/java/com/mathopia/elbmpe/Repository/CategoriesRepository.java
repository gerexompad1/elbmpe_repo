package com.mathopia.elbmpe.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mathopia.elbmpe.Entity.CategoriesEntity;

@Repository
public interface CategoriesRepository extends JpaRepository<CategoriesEntity, Integer> {
	
	//user defined query
	CategoriesEntity findByCategoryName(String categoryName);
}
