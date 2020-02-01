
public class Test {
	public int a, b;

	public Test(int a, int b) {
		this.a = a;
		this.b = b;
	}

	public Test() {
		
	}
	
	public void show() {
		System.out.println("a = " + a + " b = " + b);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + a;
		result = prime * result + b;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		System.out.println(this.getClass());
		System.out.println(obj.getClass());
		if (getClass() != obj.getClass())
			return false;
		Test other = (Test) obj;
		if (a != other.a)
			return false;
		if (b != other.b)
			return false;
		return true;
	}

	@Override
	public String toString() {
		
		System.out.println("hello");
		System.out.println("Test [a=" + a + ", b=" + b + "]");
		System.out.println("poka");
		return "";
	}
	
	
	
	
	
	
	
	
}
