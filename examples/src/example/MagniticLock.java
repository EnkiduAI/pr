package example;

public class MagniticLock implements Lock{

	@Override
	public void openLock() {
		System.out.println("��������� ����� ������");
	}

	@Override
	public void closeLock() {
		System.out.println("��������� ����� ������");
	}

}
