package com.zhouguobao.pachong;
/**
 * 访问队列 存放URL
 * @author zhou
 *
 */

import java.util.LinkedList;

public class Queue {
	private LinkedList<Object> queue = new LinkedList<>();
	/**
	 * 入队列
	 * @param str
	 */
	public void add(Object str){
			queue.addLast(str);			
	}
	/**
	 * 是否包含
	 * @param str
	 * @return
	 */
	public boolean contain(Object str){
		return queue.contains(str);	
	}
	/**
	 * 出队列
	 * @return
	 */
	public Object pop() {
		return queue.removeFirst();	
	}
	
	/**
	 * 是否为空
	 * @return
	 */
	public boolean isEmpty(){
		return queue.isEmpty();
	}
	
	public LinkedList<Object> getQueue() {
		return queue;
	}
	
}
