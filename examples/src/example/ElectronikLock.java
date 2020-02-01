package example;

public class ElectronikLock implements Lock{

	@Override
	public void openLock() {
		System.out.println("Ёлектронный замок открыт");
	}

	@Override
	public void closeLock() {
		System.out.println("Ёлектронный замок закрыт");
	}

}
