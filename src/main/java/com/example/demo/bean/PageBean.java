package com.example.demo.bean;

import java.util.List;

import org.springframework.data.domain.Page;

public class PageBean {
	private int curPage;
	private int pageSize;
	private List<?> data;
	
	
	public PageBean() {
		super();
	}
	public PageBean(Page<User> page) {
		this.curPage = page.getNumber();
		this.pageSize = page.getSize();
		this.data = page.getContent();
	}
	public int getCurPage() {
		return curPage;
	}
	public void setCurPage(int curPage) {
		this.curPage = curPage;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public List<?> getData() {
		return data;
	}
	public void setData(List<?> data) {
		this.data = data;
	}
	public void setPage(Page<User> page) {
		this.curPage = page.getNumber();
		this.pageSize = page.getSize();
		this.data = page.getContent();
	}
	
}
