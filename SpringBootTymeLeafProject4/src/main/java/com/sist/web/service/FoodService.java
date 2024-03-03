package com.sist.web.service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sist.web.entity.FoodEntity;

public interface FoodService extends JpaRepository<FoodEntity, Integer> {

	@Query(value = "SELECT * FROM food_house "
			+"ORDER BY fno ASC LIMIT :start,12",nativeQuery = true)
	public List<FoodEntity> foodListData(@Param("start")Integer start);
	@Query(value = "SELECT CEIL(COUNT(*)/12.0) FROM food_house",nativeQuery = true)
	public int foodTotalPage();
	
	
	
}
