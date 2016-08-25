package com.work.built.common.model;

import java.util.List;

public class PageContainer<T> {
	/**
	 * 分页所得的数据集合
	 */
	private List<T> dataList;
	/**
	 * 当前页码
	 */
	private int page;
	/**
	 * 每页大小默认15
	 */
	private int pageSize = 15;
	/**
	 * 总页数
	 */
	private int totalPage;
	/**
	 * 总记录条数
	 */
	private int totalCount;
	
	

	public  PageContainer(){}
	
	/**
	 * 
	
	* <p>Title: </p> 
	
	* <p>Description: </p> 
	
	* @param page 当前页
	* @param pageSize 页面大小
	* @param totalCount 总记录条数
	 */
	public PageContainer(int page,int pageSize,int totalCount){
		this.page = page;
		this.pageSize = pageSize;
		this.totalCount = totalCount;
		this.totalPage = this.totalCount % this.pageSize == 0 ?  this.totalCount/this.pageSize : (this.totalCount/this.pageSize) + 1;
	}
	
	public List<T> getDataList() {
		return dataList;
	}

	public void setDataList(List<T> dataList) {
		this.dataList = dataList;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage() {
		this.totalPage = this.totalCount%this.pageSize == 0 ?  this.totalCount/this.pageSize: (this.totalCount/this.pageSize)+1;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	

}
