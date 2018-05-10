package com.zxj.form;
//公共信息
public class DiscussForm {
	private Integer id=-1;
	private String discussTitle=null;//标题
	private String discussContent=null;//内容
	private String discussTime=null;//时间
	public String getDiscussContent() {
		return discussContent;
	}
	public void setDiscussContent(String discussContent) {
		this.discussContent = discussContent;
	}
	public String getDiscussTime() {
		return discussTime;
	}
	public void setDiscussTime(String discussTime) {
		this.discussTime = discussTime;
	}
	public String getDiscussTitle() {
		return discussTitle;
	}
	public void setDiscussTitle(String discussTitle) {
		this.discussTitle = discussTitle;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
}
