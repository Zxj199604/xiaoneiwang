package com.zxj.form;
//文章信息
public class ArticleForm {
	private Integer id=-1;
	private Integer typeId=-1;//文章类型的外键
	private String title="";//文章的题目
	private String content="";//文章内容
	private String phTime="";//文章的发布时间
	private Integer number=-1;//文章被访问的次数
	private String accountId="";//此文章发表者的用户id
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getNumber() {
		return number;
	}
	public void setNumber(Integer number) {
		this.number = number;
	}
	public String getPhTime() {
		return phTime;
	}
	public void setPhTime(String phTime) {
		this.phTime = phTime;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Integer getTypeId() {
		return typeId;
	}
	public void setTypeId(Integer typeId) {
		this.typeId = typeId;
	}
	public String getAccountId() {
		return accountId;
	}
	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}
}
