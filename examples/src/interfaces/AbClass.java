package interfaces;

public abstract class AbClass {
	public int a;
	public static int b;
	public final static int MAX_MAX = 55;
	
	public AbClass(int a) {
		this.a = a;
	}

	public AbClass() {
		
	}
	
	public void show() {
		System.out.println("������� ����� ������������ ������");
	}
	
	public static void met() {
		System.out.println("����������� ����� ������������ ������");
	}
	
	public abstract void show2();
	
}
