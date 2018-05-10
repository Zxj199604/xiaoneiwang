package com.zxj.form;
//用户表的javabean

import org.omg.CosNaming.NamingContextExtPackage.StringNameHelper;

public class ConsumerForm {
	private Integer id = 0;//id
	private String account = null;//用户名
	private String password = null;//密码
	private String picture=null;//用户头像
	private String name = null;//用户真实姓名
	private String sex = null;//用户的性别
	private String QQNumber = null;//用户QQ号码
	private String phoneNumber = null;//手机号码
	private String interest = null;//用户的爱好
	private String eMail = null;//电子邮件
	private String manageLevel = null;//用户登录级别
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getQQNumber() {
		return QQNumber;
	}

	public void setQQNumber(String number) {
		QQNumber = number;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getInterest() {
		return interest;
	}

	public void setInterest(String interest) {
		this.interest = interest;
	}

	public String getEMail() {
		return eMail;
	}

	public void setEMail(String mail) {
		eMail = mail;
	}

	public String getManageLevel() {
		return manageLevel;
	}

	public void setManageLevel(String manageLevel) {
		this.manageLevel = manageLevel;
	}

}
