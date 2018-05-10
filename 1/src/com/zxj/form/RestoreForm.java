package com.zxj.form;
//文章回复信息表
public class RestoreForm {
	private Integer id=0;
	private Integer articleId=0;//文章的id
	private String reAccount="";//回复用户的id
	private String reTitle="";//回复的标题
	private String reContent="";//回复的内容
	public Integer getArticleId() {
		return articleId;
	}
	public void setArticleId(Integer articleId) {
		this.articleId = articleId;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getReAccount() {
		return reAccount;
	}
	public void setReAccount(String reAccount) {
		this.reAccount = reAccount;
	}
	public String getReContent() {
		return reContent;
	}
	public void setReContent(String reContent) {
		this.reContent = reContent;
	}
	public String getReTitle() {
		return reTitle;
	}
	public void setReTitle(String reTitle) {
		this.reTitle = reTitle;
	}
}
