package com.sist.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.sist.web.entity.FoodEntity;
import com.sist.web.service.FoodService;

@Controller
public class MainController {

	@Autowired
	private FoodService fService;
	
	
	@GetMapping("/")
	public String main_main(Model model,String page) {
		if(page==null) {
			page="1";
		}
		int curpage=Integer.parseInt(page);
		int rowsize=12;
		int start=(rowsize*curpage)-rowsize;
		
		List<FoodEntity> list = fService.foodListData(start);
		
		int totalpage=fService.foodTotalPage();
		final int BLOCK=10;
		int startpage=((curpage-1)/BLOCK*BLOCK)+1;
		int endpage=((curpage-1)/BLOCK*BLOCK)*BLOCK;
		if(endpage>totalpage) {
			endpage=totalpage;
		}
		model.addAttribute("curpage",curpage);
		model.addAttribute("totalpage",totalpage);
		model.addAttribute("startpage",startpage);
		model.addAttribute("endpage",endpage);
		model.addAttribute("list",list);
		model.addAttribute("main_html","main/home");
		return "main";
	}
	
	@GetMapping("/recipe/recipe_list")
	public String recipe(Model model) {
	
		model.addAttribute("main_html","recipe/recipe_list");
		return "main";
	}
	
	@GetMapping("/recipe/chef_list")
	public String chef(Model model) {
	
		model.addAttribute("main_html","recipe/chef_list");
		return "main";
	}
	
	
	@GetMapping("/board/board_list")
	public String board(Model model) {
	
		model.addAttribute("main_html","board/board_list");
		return "main";
	}
}
