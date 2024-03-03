package com.sist.web.service;

import java.util.List;

import com.sist.web.vo.FoodVO;

public interface FoodService {
	public List<FoodVO> foodListData(int start);
	public int foodTo8talPage();
	
	public FoodVO foodDetailData(int fno);
}
