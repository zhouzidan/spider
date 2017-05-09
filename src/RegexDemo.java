
public class RegexDemo {
	public static void main(String[] args) {
		System.out.println("精选".matches("\\w*精选\\w*"));
		System.out.println("精选房源".matches(".*(精选|委托).*"));
		System.out.println("有委托".matches(".*(精选|委托).*"));
		System.out.println("书面委托".matches(".*(精选|委托).*"));
		
	}
}
