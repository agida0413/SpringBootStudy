package com.sist.web.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sist.web.entity.FoodListVO;
import com.sist.web.entity.Food_house;

public interface FoodDAO extends JpaRepository<Food_house, Integer> {

	@Query(value = "SELECT fno,name,poster "
			+"FROM food_house ORDER BY fno ASC "
			+"LIMIT :start,20",nativeQuery = true)
	public List<FoodListVO> foodList(@Param("start") int start);
	
	@Query(value = "SELECT CEIL(COUNT(*)/20.0) FROM food_house",nativeQuery = true)
	public int foodTotalPage();
	
	public Food_house findByFno(int fno);
	
}
