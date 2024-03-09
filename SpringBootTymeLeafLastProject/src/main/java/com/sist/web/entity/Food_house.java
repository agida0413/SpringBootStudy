package com.sist.web.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
@Entity
@Data
public class Food_house {

	@Id
	private int fno;
	   private int hit;
	   private String poster,name,type,address,phone,theme,price,time,seat,content;
	   private double score;
}
