package example;

public class Main {

	public static void main(String[] args) {


			Door door = new Door(new MagniticLock());
			door.openDoor();
			door.closeDoor();
			
			Lock lock = new ElectronikLock();
			door.setLock(lock);
			door.openDoor();
			door.closeDoor();
	}

}
