package com.sxt.dto;

public class CustomerDto extends BasePage{
	
	private BasePage basePage;
	
	// 业务员姓名
	private String salesMan;
	// 常用区间
	private String interval;
	// 客户具有的订单个数
	private Integer orderNum;
	
	public BasePage getBasePage() {
		return basePage;
	}
	public void setBasePage(BasePage basePage) {
		this.basePage = basePage;
	}
	public String getSalesMan() {
		return salesMan;
	}
	public void setSalesMan(String salesMan) {
		this.salesMan = salesMan;
	}
	public String getInterval() {
		return interval;
	}
	public void setInterval(String interval) {
		this.interval = interval;
	}
	public Integer getOrderNum() {
		return orderNum;
	}
	public void setOrderNum(Integer orderNum) {
		this.orderNum = orderNum;
	}
	
	
}
