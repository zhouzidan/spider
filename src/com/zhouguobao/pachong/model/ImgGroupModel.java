package com.zhouguobao.pachong.model;
/**
 * 图片分组的model
 * @author zhou
 *
 */
public class ImgGroupModel {
	private int id ;
	private String[] tags ;
	private long createTime;
	private long updateTime ;
	private String desc ;
	private int sort ;
	private int deleted = 0 ;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String[] getTags() {
		return tags;
	}
	public void setTags(String[] tags) {
		this.tags = tags;
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
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public int getSort() {
		return sort;
	}
	public void setSort(int sort) {
		this.sort = sort;
	}
	public int getDeleted() {
		return deleted;
	}
	public void setDeleted(int deleted) {
		this.deleted = deleted;
	}
	
}
