package com.swpu.diet_healthydomain;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Date;
import java.util.List;

public class Food {
	private Integer id;
	private String name;
	private String kind;
	private String hot;
	private String carbohydrate;
	private String fat;
	private String protein;
	private String cellulose;
	private String vitaminA;
	private String element;
	private String picture;
	private String introduce1;
	private String introduce2;
	private List<Cook> cooks;
	private String creation;
	private String modified;

	/**
	 * 搜索时的开始和结束的位置
	 * @return
	 */
	private int start;
	private int end;

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

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public String getHot() {
        return hot;
    }

    public void setHot(String hot) {
        this.hot = hot;
    }

    public String getCarbohydrate() {
        return carbohydrate;
    }

    public void setCarbohydrate(String carbohydrate) {
        this.carbohydrate = carbohydrate;
    }

    public String getFat() {
        return fat;
    }

    public void setFat(String fat) {
        this.fat = fat;
    }

    public String getProtein() {
        return protein;
    }

    public void setProtein(String protein) {
        this.protein = protein;
    }

    public String getCellulose() {
        return cellulose;
    }

    public void setCellulose(String cellulose) {
        this.cellulose = cellulose;
    }

    public String getVitaminA() {
        return vitaminA;
    }

    public void setVitaminA(String vitaminA) {
        this.vitaminA = vitaminA;
    }

    public String getElement() {
        return element;
    }

    public void setElement(String element) {
        this.element = element;
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

    public List<Cook> getCooks() {
        return cooks;
    }

    public void setCooks(List<Cook> cooks) {
        this.cooks = cooks;
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
        return "Food{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", kind='" + kind + '\'' +
                ", hot='" + hot + '\'' +
                ", carbohydrate='" + carbohydrate + '\'' +
                ", fat='" + fat + '\'' +
                ", protein='" + protein + '\'' +
                ", cellulose='" + cellulose + '\'' +
                ", vitaminA='" + vitaminA + '\'' +
                ", element='" + element + '\'' +
                ", picture='" + picture + '\'' +
                ", introduce1='" + introduce1 + '\'' +
                ", introduce2='" + introduce2 + '\'' +
                ", cooks=" + cooks +
                ", creation=" + creation +
                ", modified=" + modified +
                ", start=" + start +
                ", end=" + end +
                '}';
    }
}
