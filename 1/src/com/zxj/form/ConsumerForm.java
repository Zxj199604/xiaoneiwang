package com.zxj.form;
//�û����javabean

import org.omg.CosNaming.NamingContextExtPackage.StringNameHelper;

public class ConsumerForm {
	private Integer id = 0;//id
	private String account = null;//�û���
	private String password = null;//����
	private String picture=null;//�û�ͷ��
	private String name = null;//�û���ʵ����
	private String sex = null;//�û����Ա�
	private String QQNumber = null;//�û�QQ����
	private String phoneNumber = null;//�ֻ�����
	private String interest = null;//�û��İ���
	private String eMail = null;//�����ʼ�
	private String manageLevel = null;//�û���¼����
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
