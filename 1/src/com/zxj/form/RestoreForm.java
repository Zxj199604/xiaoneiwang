package com.zxj.form;
//���»ظ���Ϣ��
public class RestoreForm {
	private Integer id=0;
	private Integer articleId=0;//���µ�id
	private String reAccount="";//�ظ��û���id
	private String reTitle="";//�ظ��ı���
	private String reContent="";//�ظ�������
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
