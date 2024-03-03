package com.sist.web.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
/*
 * 
 * FNO int 
POSTER text 
NAME text 
TYPE text 
ADDRESS text 
PHONE text 
SCORE double 
THEME text 
PRICE text 
TIME text 
SEAT text 
CONTENT text 
LINK text 
HIT int
 */

@Entity
@Data
@Table(name = "food_house")
public class FoodEntity {
@Id
private int fno;

private int hit;
private double score;
private String poster,name,type,address,phone,theme,price,time,seat,content,link;

}
