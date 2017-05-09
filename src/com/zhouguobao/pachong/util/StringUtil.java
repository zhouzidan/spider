package com.zhouguobao.pachong.util;

public class StringUtil {
	/**
	 * 判断是否为空
	 * @param str
	 * @return
	 */
	public static boolean isEmpty(String str) {
		if (str != null && str.length() > 0) {
			return false;
		}
		return true;
	}
}
