package com.zhouguobao.pachong;
/**
 * 访问队列 存放URL
 * @author zhou
 *
 */

import java.util.LinkedList;

import com.zhouguobao.pachong.util.StringUtil;

public class Queue {
	private LinkedList<String> queue = new LinkedList<>();
	/**
	 * 入队列
	 * @param str
	 */
	public void add(String str){
			queue.addLast(str);			
	}
	/**
	 * 是否包含
	 * @param str
	 * @return
	 */
	public boolean contain(String str){
		return queue.contains(str);	
	}
	/**
	 * 出队列
	 * @return
	 */
	public String pop() {
		return queue.removeFirst();	
	}
	
	/**
	 * 是否为空
	 * @return
	 */
	public boolean isEmpty(){
		return queue.isEmpty();
	}
	
}
