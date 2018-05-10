package com.zxj.form;
//音乐歌曲回复信息
public class songRestoreForm {
	private Integer id=0;
	private Integer songId=0;//歌曲的id
	private String reAccount="";//回复用户的id
	private String reTime="";//回复的时间
	private String reContent="";//回复的内容
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
