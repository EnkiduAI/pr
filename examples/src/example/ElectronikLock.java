package example;

public class ElectronikLock implements Lock{

	@Override
	public void openLock() {
		System.out.println("����������� ����� ������");
	}

	@Override
	public void closeLock() {
		System.out.println("����������� ����� ������");
	}

}
