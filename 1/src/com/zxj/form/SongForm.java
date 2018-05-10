package com.zxj.form;
//“Ù¿÷œÍ«Î
public class SongForm {
	private Integer id=-1;//Œƒ’¬id
	private String songName="";
	private String singer="";
	private String specialName="";
	private String content="";
	private String fileURL="";
	private String format="";
	private Integer hits=0;
	private Integer download=0;
	private String upTime="";
	private Integer songType=-1;
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
	public String getSongName() {
		return songName;
	}
	public void setSongName(String songName) {
		this.songName = songName;
	}
	public String getSinger() {
		return singer;
	}
	public void setSinger(String singer) {
		this.singer = singer;
	}
	public String getSpecialName() {
		return specialName;
	}
	public void setSpecialName(String specialName) {
		this.specialName = specialName;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getFileURL() {
		return fileURL;
	}
	public void setFileURL(String fileURL) {
		this.fileURL = fileURL;
	}
	public String getFormat() {
		return format;
	}
	public void setFormat(String format) {
		this.format = format;
	}
	public Integer getHits() {
		return hits;
	}
	public void setHits(Integer hits) {
		this.hits = hits;
	}
	public Integer getDownload() {
		return download;
	}
	public void setDownload(Integer download) {
		this.download = download;
	}
	public String getUpTime() {
		return upTime;
	}
	public void setUpTime(String upTime) {
		this.upTime = upTime;
	}
	public Integer getSongType() {
		return songType;
	}
	public void setSongType(Integer songType) {
		this.songType = songType;
	}



}
