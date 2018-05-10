package com.zxj.form;
//文章类型
public class ArticleTypeForm {
	private Integer id=-1;
	private String typeName="";//类型名字
	private String description="";//描述
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTypeName() {
		return typeName;
	}
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}


}
