package com.zxj.form;

public class VotedForm {
	private Integer id=-1;
	private String accountId="";//�Ѿ�����ͶƱ���˵�ID
	private String voteid="";//����ͶƱ�����ݵı��
	public String getAccountId() {
		return accountId;
	}
	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getVoteid() {
		return voteid;
	}
	public void setVoteid(String voteid) {
		this.voteid = voteid;
	}

}
