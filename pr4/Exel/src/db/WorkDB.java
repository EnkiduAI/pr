package db;

import java.sql.SQLException;

import dao.DaoInfo;
import dao.DaoOrders;
import dao.DaoRooms;
import dao.DaoUsers;
import entity.Info;
import entity.Orders;
import entity.Rooms;
import entity.Users;

public class WorkDB {
	
	public static void createDB(String url, String nameDB, String login, String pass) throws SQLException {
		DB db = new DB(url, "", login, pass);
		
		db.update("CREATE DATABASE " + nameDB);
		db.update("USE " + nameDB);
		System.out.println("База данных " + nameDB + " успешно создана");
		
		db.update("CREATE TABLE users(id_user INT AUTO_INCREMENT UNIQUE NOT NULL," + 
				"    login VARCHAR(20) UNIQUE NOT NULL," + 
				"    pass VARCHAR(20) NOT NULL," + 
				"    rol INT(1) DEFAULT 2," + 
				"    status VARCHAR(8) DEFAULT 'not blok'," + 
				"    PRIMARY KEY(id_user));");
		/*db.update("INSERT INTO users VALUES(1, 'admin', 'admin', 1, 'not blok');");
		db.update("INSERT INTO users (login, pass) VALUES('user1', '111');");
		db.update("INSERT INTO users VALUES(3, 'user2', '222', 2, 'blok');");
		db.update("INSERT INTO users VALUES(5, 'user3', '333', 2, 'not blok');");*/
		
		DaoUsers user = new DaoUsers(db);
		user.insert(new Users(1, "admin", "admin", 1, "not blok"));
		user.insert(new Users(2, "user1", "111", 2, "not blok"));
		user.insert(new Users(3, "user2", "222", 2, "blok"));
		user.insert(new Users(5, "user3", "333", 2, "not blok"));
		
		
		
		
		db.update("CREATE TABLE info(id_info INT AUTO_INCREMENT UNIQUE NOT NULL," + 
				"    id_user INT NOT NULL," + 
				"    fam VARCHAR(20) DEFAULT ''," + 
				"    name VARCHAR(20) DEFAULT ''," + 
				"    pasport VARCHAR(20) DEFAULT ''," + 
				"    tel VARCHAR(20) DEFAULT ''," + 
				"    PRIMARY KEY(id_info)," + 
				"    FOREIGN KEY(id_user) REFERENCES users(id_user));");
		/*db.update("INSERT INTO info VALUES(10, 2, 'Ivanov', 'Ivan', 'mp123456', '+375291234567');");
		db.update("INSERT INTO info VALUES(20, 5, 'Petrov', 'Petr', 'mp654321', '+375441234567');");*/
		
		DaoInfo info = new DaoInfo(db);
		info.insert(new Info(10, 2, "Ivanov", "Ivan", "mp123456", "+375291234567"));
		info.insert(new Info(20, 5, "Petrov", "Petr", "mp654321", "+375441234567"));
		
		
		db.update("CREATE TABLE rooms(id_room INT AUTO_INCREMENT UNIQUE NOT NULL," + 
				"    type VARCHAR(8) DEFAULT 'econom'," + 
				"    kol_mest INT(1) DEFAULT 1," + 
				"    price DOUBLE(7,2) DEFAULT 30.00," + 
				"    status VARCHAR(8) DEFAULT 'not blok'," + 
				"    PRIMARY KEY(id_room));");
		/*db.update("INSERT INTO rooms VALUES(231, 'vip', 3, 150.00, 'blok');");
		db.update("INSERT INTO rooms VALUES(254, 'standart', 2, 70.00, 'not blok');");
		db.update("INSERT INTO rooms VALUES(268, 'econom', 1, 30.00, 'blok');");
		db.update("INSERT INTO rooms VALUES(275, 'econom', 2, 60.00, 'not blok');");*/
		DaoRooms room = new DaoRooms(db);
		room.insert(new Rooms(231, "vip", 3, 150.00, "blok"));
		room.insert(new Rooms(254, "standart", 2, 70.00, "not blok"));
		room.insert(new Rooms(268, "econom", 1, 30.00, "blok"));
		room.insert(new Rooms(275, "econom", 2, 60.00, "not blok"));
		
		
		
		db.update("CREATE TABLE orders(id_order INT AUTO_INCREMENT UNIQUE NOT NULL," + 
				"    id_user INT NOT NULL," + 
				"    login_user VARCHAR(20) NOT NULL," + 
				"    id_room INT NOT NULL," + 
				"    type VARCHAR(8) NOT NULL," + 
				"    kol_mest INT(1) NOT NULL," + 
				"    data_ot VARCHAR(10) NOT NULL," + 
				"    data_do VARCHAR(10) NOT NULL," + 
				"    cost DOUBLE(8,2) NOT NULL," + 
				"    status VARCHAR(3) DEFAULT 'no'," + 
				"    pay VARCHAR(3) DEFAULT 'no'," + 
				"    del_status VARCHAR(8) DEFAULT 'activ'," + 
				"    PRIMARY KEY(id_order)," + 
				"    FOREIGN KEY(id_user) REFERENCES users(id_user)," + 
				"    FOREIGN KEY(id_room) REFERENCES rooms(id_room));");
		/*db.update("INSERT INTO orders VALUES(25, 2, 'user1', 231, 'vip', 3, '01.01.2019', '10.01.2019', 1500.00, 'no', 'no', 'activ');");
		db.update("INSERT INTO orders VALUES(32, 5, 'user3', 268, 'econom', 1, '01.01.2019', '05.01.2019', 150.00, 'no', 'no', 'activ');");*/
		DaoOrders order = new DaoOrders(db);
		order.insert(new Orders(25, 2, "user1", 231, "vip", 3, "01.01.2019", "10.01.2019", 1500.00, "no", "no", "activ"));
		order.insert(new Orders(32, 5, "user3", 268, "econom", 1, "01.01.2019", "05.01.2019", 150.00, "no", "no", "activ"));
		
		
		
		System.out.println("\n----------------------Users----------------------------------");
		db.showTable(db.query("SELECT * FROM users"));
		
		System.out.println("\n----------------------Info----------------------------------");
		db.showTable(db.query("SELECT * FROM info"));
		
		System.out.println("\n----------------------Rooms----------------------------------");
		db.showTable(db.query("SELECT * FROM rooms"));
		
		System.out.println("\n----------------------Orders----------------------------------");
		db.showTable(db.query("SELECT * FROM orders"));
		
	}
	
	public static void deleteDB(String url, String nameDB, String login, String pass) throws SQLException {
		DB db = new DB(url, nameDB, login, pass);
		db.update("DROP DATABASE " + nameDB);
		System.out.println("База данных " + nameDB + " успешно удалена");
	}
	
}
