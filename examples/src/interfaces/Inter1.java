package interfaces;

public interface Inter1 {
	public final static int MAX = 100;
	
	public static void metod() {
		System.out.println("Статический метод интерфейса Inter1");
	}
	
	public abstract void show();
	public abstract void show(int a);
	public abstract void show2();
	public abstract void show3();
	
	
	
}
