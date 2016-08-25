package com.work.built.common.model;
public class CommonResult<T> {
	public CommonResult(int result,String message,  T data) {
		this.result = result;
		this.message = message;
		this.data = data;
	}

	
	public CommonResult(){}
	
	/**
	 * 操作是否成功
	 */
	public int result;
	
	/**
	 * 错误信息
	 */
	public String message;
	
	/**
	 * 数据
	 */
	public T data;
	
	/**
	 * 当前页
	 */
	public Integer page;
	/**
	 * 页面大小
	 */
	public Integer pageSize;
	/**
	 * 总页数
	 */
	public Integer totalPage;
	/**
	 * 总记录条数
	 */
	public Integer totalCount;
	
	
	public int getResult() {
		return result;
	}


	public void setResult(int result) {
		this.result = result;
	}


	public String getMessage() {
		return message;
	}


	public void setMessage(String message) {
		this.message = message;
	}


	public T getData() {
		return data;
	}
	
	public void setData(T data) {
		this.data = data;
	}


	public Integer getPage() {
		return page;
	}


	public void setPage(Integer page) {
		this.page = page;
	}


	public Integer getPageSize() {
		return pageSize;
	}


	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}


	public Integer getTotalPage() {
		return totalPage;
	}


	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}


	public Integer getTotalCount() {
		return totalCount;
	}


	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}

}
