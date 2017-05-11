package com.zhouguobao.pachong;
/**
 * 已访问的，等待访问的
 * @author zhou
 *
 */

import java.util.HashSet;
import java.util.Set;

public class LinkQueue {
	// 已访问的URL集合
	private Set visitedUrl = null;
	// 待访问的URL集合
	private Queue unVisitUrl = null;
	
	private LinkQueue childQueue = null;

	public LinkQueue() {
		visitedUrl = new HashSet<>();
		unVisitUrl = new Queue();
	}

	public Set getVisitedUrl() {
		return visitedUrl;
	}

	public Queue getUnVisitUrl() {
		return unVisitUrl;
	}

	// 添加到访问过的Url
	public void addVisistedUrl(Object url) {
		if (url != null) {
			visitedUrl.add(url);
		}
	}

	public void removeVisistedUrl(Object url) {
		visitedUrl.remove(url);
	}

	// 从未访问队列中，弹出一个
	public Object popUnVisitUrl() {
		if (unVisitUrl.isEmpty() == false) {
			return unVisitUrl.pop();
		}
		return null;
	}

	// 增加到未访问的队列中
	public void addUnVisistUrl(Object url) {
		if (url != null && unVisitUrl.contain(url) == false) {
			unVisitUrl.add(url);
		}
	}

	// 判断未访问队列是否为空
	public boolean isUnVisitUrlEmpty() {
		return unVisitUrl.isEmpty();
	}

	public LinkQueue getChildQueue() {
		return childQueue;
	}

	public void setChildQueue(LinkQueue childQueue) {
		this.childQueue = childQueue;
	}
	
	

}
