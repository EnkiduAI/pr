package example;

public class MagniticLock implements Lock{

	@Override
	public void openLock() {
		System.out.println("Магнитный замок открыт");
	}

	@Override
	public void closeLock() {
		System.out.println("Магнитный замок закрыт");
	}

}
