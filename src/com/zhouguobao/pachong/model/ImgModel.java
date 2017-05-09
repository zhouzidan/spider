package com.zhouguobao.pachong.model;
/**
 * 图片的model
 * @author zhou
 *
 */
public class ImgModel {
	private int id ;
	private String url ;
	private int star ;
	private int deteted = 0 ;
	private long createTime;
	private long updateTime ;
	private int groupId ;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public int getDeteted() {
		return deteted;
	}
	public void setDeteted(int deteted) {
		this.deteted = deteted;
	}
	public long getCreateTime() {
		return createTime;
	}
	public void setCreateTime(long createTime) {
		this.createTime = createTime;
	}
	public long getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(long updateTime) {
		this.updateTime = updateTime;
	}
	public int getGroupId() {
		return groupId;
	}
	public void setGroupId(int groupId) {
		this.groupId = groupId;
	}
	
}
