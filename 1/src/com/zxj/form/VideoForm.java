package com.zxj.form;

public class VideoForm {
	private Integer id=0;
	private String videoAddress=null;//������ַ
	private String videoTite=null;//����
	private String videoIntroduction=null;//��Ƶ���
	private String videoTime=null;//ʱ��
	private String accountId="";
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
	public String getVideoAddress() {
		return videoAddress;
	}
	public void setVideoAddress(String videoAddress) {
		this.videoAddress = videoAddress;
	}
	public String getVideoTite() {
		return videoTite;
	}
	public void setVideoTite(String videoTite) {
		this.videoTite = videoTite;
	}
	public String getVideoIntroduction() {
		return videoIntroduction;
	}
	public void setVideoIntroduction(String videoIntroduction) {
		this.videoIntroduction = videoIntroduction;
	}
	public String getVideoTime() {
		return videoTime;
	}
	public void setVideoTime(String videoTime) {
		this.videoTime = videoTime;
	}
	

}
