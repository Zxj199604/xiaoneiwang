package com.zxj.form;

public class PhotoForm {
	private Integer id=-1;
	private String photoAddress="";//相册存放的服务器地址
	private String photoDescription="";//相册描述信息
	private String phtoTime="";//相册上传时间
	private String accountId="";//图片上传者的id
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
	public String getPhotoAddress() {
		return photoAddress;
	}
	public void setPhotoAddress(String photoAddress) {
		this.photoAddress = photoAddress;
	}
	public String getPhotoDescription() {
		return photoDescription;
	}
	public void setPhotoDescription(String photoDescription) {
		this.photoDescription = photoDescription;
	}
	public String getPhtoTime() {
		return phtoTime;
	}
	public void setPhtoTime(String phtoTime) {
		this.phtoTime = phtoTime;
	}

}
