package com.zhouguobao.pachong.model;

import java.sql.Date;

public class ImgGroup {
	private int id ;
	private int tagId ;
	private String url ;
	private String alt ;
	private int star = 0;
	private int failureNum = 0;
	private Date createTime ;
	private Date updateTime ;
	
	public ImgGroup(int tagId, String url, String alt) {
		super();
		this.tagId = tagId;
		this.url = url;
		this.alt = alt;
	}
	public ImgGroup() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getTagId() {
		return tagId;
	}
	public void setTagId(int tagId) {
		this.tagId = tagId;
	}
	

	public String getAlt() {
		return alt;
	}
	public void setAlt(String alt) {
		this.alt = alt;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public int getStar() {
		return star;
	}
	public void setStar(int star) {
		this.star = star;
	}
	public int getFailureNum() {
		return failureNum;
	}
	public void setFailureNum(int failureNum) {
		this.failureNum = failureNum;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	
}
