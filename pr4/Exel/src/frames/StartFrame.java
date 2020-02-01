package frames;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import db.DB;
import db.WorkDB;

public class StartFrame extends JFrame{
	private JPanel panel;
	private JLabel lableUrl, lableNameDB, lableLogin, lablePass;
	private JTextField url, nameDB, login;
	private JPasswordField pass;
	private JButton createDB, deleteDB, connect;	
	
	public StartFrame() {
		setTitle("StartFrame");
		setSize(290, 200);
		setLocationRelativeTo(null);
		setResizable(false);
		
		initComponents();
		action();
		
		setVisible(true);
	}

	private void initComponents() {
		panel = new JPanel();
		
		lableUrl = new JLabel("url");
		lableNameDB = new JLabel("nameDB");
		lableLogin = new JLabel("login");
		lablePass = new JLabel("pass");
		
		url = new JTextField("jdbc:mysql://127.0.0.1/", 20);
		nameDB = new JTextField("exel", 20);
		login = new JTextField("root", 20);
		
		pass = new JPasswordField("root", 20);
		
		createDB = new JButton("createDB");
		deleteDB = new JButton("deleteDB");
		connect = new JButton("connect");
		
		panel.add(lableUrl);
		panel.add(url);
		panel.add(lableNameDB);
		panel.add(nameDB);
		panel.add(lableLogin);
		panel.add(login);
		panel.add(lablePass);
		panel.add(pass);
		
		panel.add(createDB);
		panel.add(deleteDB);
		panel.add(connect);
		
		add(panel);
	}

	private void action() {
		
		connect.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				if(nameDB.getText().equals("") != true) {
					try {
						DB db = new DB(url.getText(), nameDB.getText(), login.getText(), String.valueOf(pass.getPassword()));
						new LoginFrame(db);
						dispose();
					} catch (SQLException e1) {
						JOptionPane.showMessageDialog(panel, "Ошибка при подключении");
					}
				}else {
					JOptionPane.showMessageDialog(panel, "Введите название базы данных");
				}
				
				
			}
		});
		
		createDB.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					WorkDB.createDB(url.getText(), nameDB.getText(), login.getText(), String.valueOf(pass.getPassword()));
					JOptionPane.showMessageDialog(panel, "База данных " + nameDB.getText() + " успешно создана");
				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(panel, "Невозможно создать\r\nБаза данных " + nameDB.getText() + " уже существует");
				}
			}
		});
		
		deleteDB.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					WorkDB.deleteDB(url.getText(), nameDB.getText(), login.getText(), String.valueOf(pass.getPassword()));
					JOptionPane.showMessageDialog(panel, "База данных " + nameDB.getText() + " успешно удалена");
				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(panel, "Невозможно удалить\r\nБаза данных " + nameDB.getText() + " не существует");
				}
			}
		});
		
	}
}
