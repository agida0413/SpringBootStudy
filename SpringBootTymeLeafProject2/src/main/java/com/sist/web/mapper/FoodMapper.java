package com.sist.web.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.sist.web.vo.FoodVO;

@Repository
@Mapper
public interface FoodMapper {

	public List<FoodVO> foodListData(int start);
	
	public int foodTo8talPage();
	
	public FoodVO foodDetailData(int fno);
	
	public void hitIncrement(int fno);
}
