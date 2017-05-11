import com.sun.org.apache.xerces.internal.impl.xpath.regex.Match;

import jdk.nashorn.internal.runtime.regexp.joni.Matcher;
import jdk.nashorn.internal.runtime.regexp.joni.Regex;

public class RegexDemo {
	public static void main(String[] args) {
//		System.out.println("精选".matches("\\w*精选\\w*"));
//		System.out.println("精选房源".matches(".*(精选|委托).*"));
//		System.out.println("有委托".matches(".*(精选|委托).*"));
//		System.out.println("书面委托".matches(".*(精选|委托).*"));

		String a = "http://www.xiumm.org/albums/JingXuan-2.html";
		String bString = a.replaceFirst("-\\d\\.html", "-22.html");
		System.out.println(a);
		System.out.println(bString);
		
		String[] aa = "(共47页)".split("\\D");
		System.out.println(aa.length);
		for (String string : aa) {
			System.out.println("--"+string);
		}
		System.out.println("(共47页)".replaceAll("\\D", ""));;
		
		int count = Integer.parseInt("(共47页)".replaceAll("\\D", ""));
		for (int i = 2; i < count + 1; i++) {
			System.out.println(i);
			String temp = a.replaceFirst("-\\d\\.html", "-"+i+".html");
			System.out.println(temp);
		}
	}
}
