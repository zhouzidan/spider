package com.zhouguobao.pachong;
/**
 * 已访问的，等待访问的
 * @author zhou
 *
 */

import java.util.HashSet;
import java.util.Set;

import com.zhouguobao.pachong.util.StringUtil;

public class LinkQueue {
	// 已访问的URL集合
	private static Set visitedUrl = new HashSet<>();
	// 待访问的URL集合
	private static Queue unVisitUrl = new Queue();

	public static Set getVisitedUrl() {
		return visitedUrl;
	}

	public static Queue getUnVisitUrl() {
		return unVisitUrl;
	}

	// 添加到访问过的Url
	public static void addVisistedUrl(String url) {
		if (StringUtil.isEmpty(url) == false) {
			visitedUrl.add(url);
		}
	}

	public static void removeVisistedUrl(String url) {
		visitedUrl.remove(url);
	}

	// 从未访问队列中，弹出一个
	public static String popUnVisitUrl() {
		if (unVisitUrl.isEmpty() == false) {
			return unVisitUrl.pop();
		}
		return null;
	}

	// 增加到未访问的队列中
	public static void addUnVisistUrl(String url) {
		if (StringUtil.isEmpty(url) == false && unVisitUrl.contain(url) == false) {
			unVisitUrl.add(url);
		}
	}
	
	//判断未访问队列是否为空
	public static boolean isUnVisitUrlEmpty(){
		return unVisitUrl.isEmpty();
	}

}
