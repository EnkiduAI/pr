package task1page223;

public class Main {

	public static void main(String[] args) {
		Matrix m1 = new Matrix();
		Matrix m2 = new Matrix();
		
		System.out.println(m1);
		System.out.println(m2);
		
		m1.summa(m2);
		m1.compare(m2);
		
		Stroki s1 = new Stroki();
		Stroki s2 = new Stroki();
		
		m1.summa(s1);
		
		m1.metod1();
		m1.metod2();
	}

}
