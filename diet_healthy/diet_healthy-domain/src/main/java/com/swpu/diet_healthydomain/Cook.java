package com.swpu.diet_healthydomain;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Date;
import java.util.List;

public class Cook {
	private Integer id;
	private String name;
	//适宜天气
	private String weather;
	//创建时间
	private String creation;
	private String modified;
	//适宜时间
	private String time;
	private String picture;
	private String introduce1;
	private String introduce2;
	private List<Food> foods;
    /**
     * 搜索时的开始和结束的位置
     * @return
     */
    private int start;
    private int end;

    /*public Cook(Integer id, String picture) {
        this.id = id;
        this.picture = picture;
    }*/

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWeather() {
        return weather;
    }

    public void setWeather(String weather) {
        this.weather = weather;
    }

    public String getCreation() {
        return creation;
    }

    public void setCreation(String creation) {
        this.creation = creation;
    }

    public String getModified() {
        return modified;
    }

    public void setModified(String modified) {
        this.modified = modified;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getIntroduce1() {
        return introduce1;
    }

    public void setIntroduce1(String introduce1) {
        this.introduce1 = introduce1;
    }

    public String getIntroduce2() {
        return introduce2;
    }

    public void setIntroduce2(String introduce2) {
        this.introduce2 = introduce2;
    }

    public List<Food> getFoods() {
        return foods;
    }

    public void setFoods(List<Food> foods) {
        this.foods = foods;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }

    @Override
    public String toString() {
        return "Cook{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", weather='" + weather + '\'' +
                ", creation=" + creation +
                ", modified=" + modified +
                ", time='" + time + '\'' +
                ", picture='" + picture + '\'' +
                ", introduce1='" + introduce1 + '\'' +
                ", introduce2='" + introduce2 + '\'' +
                ", foods=" + foods +
                ", start=" + start +
                ", end=" + end +
                '}';
    }
}
