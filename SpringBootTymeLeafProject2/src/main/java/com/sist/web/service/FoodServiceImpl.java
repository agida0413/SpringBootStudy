package com.sist.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sist.web.mapper.FoodMapper;
import com.sist.web.vo.FoodVO;

@Service
public class FoodServiceImpl implements FoodService {

	@Autowired
	private FoodMapper mapper;

	@Override
	public List<FoodVO> foodListData(int start) {
		// TODO Auto-generated method stub
		return mapper.foodListData(start);
	}

	@Override
	public int foodTo8talPage() {
		// TODO Auto-generated method stub
		return mapper.foodTo8talPage();
	}

	@Override
	public FoodVO foodDetailData(int fno) {
		// TODO Auto-generated method stub
		mapper.hitIncrement(fno);
		
		return mapper.foodDetailData(fno);
	}
	
}
