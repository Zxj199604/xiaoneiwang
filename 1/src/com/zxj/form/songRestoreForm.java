package com.zxj.form;
//���ָ����ظ���Ϣ
public class songRestoreForm {
	private Integer id=0;
	private Integer songId=0;//������id
	private String reAccount="";//�ظ��û���id
	private String reTime="";//�ظ���ʱ��
	private String reContent="";//�ظ�������
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getSongId() {
		return songId;
	}
	public void setSongId(Integer songId) {
		this.songId = songId;
	}
	public String getReAccount() {
		return reAccount;
	}
	public void setReAccount(String reAccount) {
		this.reAccount = reAccount;
	}
	public String getReTime() {
		return reTime;
	}
	public void setReTime(String reTime) {
		this.reTime = reTime;
	}
	public String getReContent() {
		return reContent;
	}
	public void setReContent(String reContent) {
		this.reContent = reContent;
	}

}
