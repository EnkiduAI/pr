
public class Main {

	public static void main(String[] args) {
		
		String str1 = "hello";
		String str2 = "hello";
		
		if(str1 == str2) {
			System.out.println("True");
		}else {
			System.out.println("False");
		}
		if(str1.equals(str2) == true) {
			System.out.println("True");
		}else {
			System.out.println("False");
		}
		System.out.println("\n==========================================");
		
		String str3 = new String("hello");
		String str4 = new String("hello");
		
		if(str3 == str4) {
			System.out.println("True");
		}else {
			System.out.println("False");
		}
		if(str3.equals(str4) == true) {
			System.out.println("True");
		}else {
			System.out.println("False");
		}
		System.out.println("\n==========================================");
		
		Test t1 = new Test(5, 10);
		Test t2 = new Test(5, 10);
		
		if(t1 == t2) {
			System.out.println("True");
		}else {
			System.out.println("False");
		}
		if(t1.equals(t2) == true) {
			System.out.println("True");
		}else {
			System.out.println("False");
		}
		System.out.println("\n==========================================");
		
		System.out.println("hashkod t1 = " + t1.hashCode());
		System.out.println("hashkod t2 = " + t2.hashCode());
		System.out.println("\n==========================================");
		
		System.out.println(t1.toString());
		System.out.println(t2);
		
	}

}
