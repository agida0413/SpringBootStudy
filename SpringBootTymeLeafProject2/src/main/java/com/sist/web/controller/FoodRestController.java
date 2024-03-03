package com.sist.web.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sist.web.service.FoodService;
import com.sist.web.vo.FoodVO;

@RestController
@CrossOrigin("http://localhost:3000")
public class FoodRestController {
@Autowired
private FoodService service;

@GetMapping("food/list_react")

public List<FoodVO> food_list(int page){
	int rowsize=10;
	int start=(rowsize*page)-rowsize;
	List<FoodVO>list= service.foodListData(start);
	
	return list;
}

@GetMapping("food/page_react")

public Map food_page(int page) {
	int totalpage=service.foodTo8talPage();
	final int BLOCK=10;
	int startpage=((page-1)/BLOCK*BLOCK)+1;
	int endpage=((page-1)/BLOCK*BLOCK)+BLOCK;
	
	if(endpage>totalpage) {
		endpage=totalpage;
	}
	Map map =new HashMap();
	map.put("totalpage", totalpage);
	map.put("startpage", startpage);
	map.put("curpage", page);
	map.put("endpage", endpage);
	
	return map;
}
}
