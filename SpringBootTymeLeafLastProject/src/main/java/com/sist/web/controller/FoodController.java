package com.sist.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.sist.web.dao.FoodDAO;
import com.sist.web.entity.FoodListVO;
import com.sist.web.entity.Food_house;
import com.sist.web.entity.Recipe2;

@Controller
public class FoodController {

	@Autowired
	private FoodDAO dao;
	
	@GetMapping("/food/list")
	public String food_list (String page,Model model)
	{
		   if(page==null)
			   page="1";
		   int curpage=Integer.parseInt(page);
		   int rowSize=20;
		   int start=(rowSize*curpage)-rowSize;
		   List<FoodListVO>list = dao.foodList(start);
		   int totalpage=dao.foodTotalPage();
		   
		   final int BLOCK=10;
		   int startPage=((curpage-1)/BLOCK*BLOCK)+1;
		   int endPage=((curpage-1)/BLOCK*BLOCK)+BLOCK;
		   
		   if(endPage>totalpage)
			   endPage=totalpage;
		   model.addAttribute("curpage", curpage);
		   model.addAttribute("totalpage", totalpage);
		   model.addAttribute("startPage", startPage);
		   model.addAttribute("endPage", endPage);
		
		   model.addAttribute("list", list);
		model.addAttribute("main_html","food/list");
		return "main";
	}
	
	@GetMapping("/food/detail")
	public String food_detail(int fno,Model model)
	{
		Food_house vo = dao.findByFno(fno);
		model.addAttribute("main_html","food/detail");
		model.addAttribute("vo",vo);
		
		return "main";
		
	}
	
}
