package com.swpu.diet_healthydomain;

import java.util.ArrayList;
import java.util.List;

public class Page<T> {
	private int currentPage;
	private int pageCount;
	private int perList;
	private int totalRecord;
	private int startIndex;
	private List<T> list;
	public Page() {
		super();
		this.list = new ArrayList<>();
	}

	public Page(int startIndex , int perList) {
		this.perList = perList;
		this.startIndex = startIndex;
	}

	public Page(int currentPage, int pageCount, List<T> list) {
		this.currentPage = currentPage;
		this.pageCount = pageCount;
		this.list = list;
	}

	public Page(int currentPage, int perList, int totalRecord) {
		this();
		this.currentPage = currentPage;
		this.perList = perList;
		this.totalRecord = totalRecord;
		if(totalRecord%perList == 0) {
			this.pageCount = totalRecord/perList;
		}else {
			this.pageCount = totalRecord/perList+1;
		}
	}


	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getPageCount() {
		return pageCount;
	}
	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}
	public int getPerList() {
		return perList;
	}
	public void setPerList(int perList) {
		this.perList = perList;
	}
	public int getTotalRecord() {
		return totalRecord;
	}
	public void setTotalRecord(int totalRecord) {
		this.totalRecord = totalRecord;
	}
	public int getStartIndex() {
		return startIndex;
	}
	public void setStartIndex(int startIndex) {
		this.startIndex = startIndex;
	}
	public List<T> getList() {
		return list;
	}
	public void setList(List<T> list) {
		this.list = list;
	}
	
}
