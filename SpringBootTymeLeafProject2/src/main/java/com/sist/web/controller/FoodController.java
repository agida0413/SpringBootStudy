package com.sist.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.sist.web.service.FoodService;
import com.sist.web.vo.FoodVO;

@Controller
public class FoodController {
@Autowired 
private FoodService fService;

	@GetMapping("food/list")
	public String food_list(String page,Model model) {
			
		if(page==null) {
			page="1";
		}
		int curpage=Integer.parseInt(page);
		int rowsize=12;
		int start =(rowsize*curpage)-rowsize;
		List<FoodVO>list = fService.foodListData(start);
		
		int totalPage=fService.foodTo8talPage();
		
		final int BLOCK=10;
		int startpage=((curpage-1)/BLOCK*BLOCK)+1;
		int endpage=((curpage-1)/BLOCK*BLOCK)+BLOCK;
		
		if(endpage>totalPage) {
			endpage=totalPage;

		}
		
		model.addAttribute("list",list);
		model.addAttribute("curpage",curpage);
		model.addAttribute("totalpage", totalPage);
		model.addAttribute("startpage",startpage);
		model.addAttribute("endpage",endpage);
		
		
		return "food/list";
	}
	
	
	@GetMapping("food/detail")
	
	public String foodDetail(int fno,Model model) {
	
		FoodVO vo = fService.foodDetailData(fno);
		model.addAttribute("vo",vo);
		return "food/detail";
	}
	
}
