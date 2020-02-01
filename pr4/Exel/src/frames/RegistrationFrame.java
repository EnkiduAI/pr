package frames;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import dao.DaoUsers;
import db.DB;
import entity.Users;

public class RegistrationFrame extends JFrame{
	private JPanel panel;
	private JLabel lableLogin, lablePass, lablePass1;
	private JTextField login;
	private JPasswordField pass, pass1;
	private JButton ok, back;	
	private DB db;
	
	public RegistrationFrame(DB db) {
		this.db = db;
		setTitle("RegistrationFrame");
		setSize(290, 200);
		setLocationRelativeTo(null);
		setResizable(false);
		
		initComponents();
		action();
		
		setVisible(true);
		
	}
	
	private void initComponents() {
		panel = new JPanel();
		
		lableLogin = new JLabel("login");
		lablePass = new JLabel("pass");
		lablePass1 = new JLabel("pass1");
		
		login = new JTextField("", 20);
		
		pass = new JPasswordField("", 20);
		pass1 = new JPasswordField("", 20);
		
		ok = new JButton("ok");
		back = new JButton("back");
				
		panel.add(lableLogin);
		panel.add(login);
		panel.add(lablePass);
		panel.add(pass);
		panel.add(lablePass1);
		panel.add(pass1);
		
		panel.add(ok);
		panel.add(back);
		
		add(panel);
	}

	private void action() {
		ok.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
		
				if(login.getText().equals("") != true && String.valueOf(pass.getPassword()).equals("") != true && String.valueOf(pass.getPassword()).equals(String.valueOf(pass1.getPassword()) )== true) {
					try {
						ResultSet rs = db.query("SELECT * FROM users WHERE login='" + login.getText() + "'");
						
						if(rs.next() != true) {
							DaoUsers user = new DaoUsers(db);
							user.insert(new Users(0, login.getText(), String.valueOf(pass.getPassword()), 2, "not blok"));
							JOptionPane.showMessageDialog(panel,  "Пользователь с логином " + login.getText() + " успешно зарегестрирован" );
							new LoginFrame(db);
							dispose();
						}else {
							JOptionPane.showMessageDialog(panel,  "Пользователь с логином " + login.getText() + " уже существует" );
						}					
						
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					
				}else {
					if(login.getText().equals("") == true) {
						JOptionPane.showMessageDialog(panel,  "Заполните поле логин");
					}
					if(String.valueOf(pass.getPassword()).equals("") == true) {
						JOptionPane.showMessageDialog(panel,  "Заполните поле pass");
					}
					if(String.valueOf(pass1.getPassword()).equals("") == true) {
						JOptionPane.showMessageDialog(panel,  "Заполните поле pass1");
					}	
					if(String.valueOf(pass.getPassword()).equals(String.valueOf(pass1.getPassword()) ) != true) {
						JOptionPane.showMessageDialog(panel,  "Пароли не совпали");
					}
						
					
				}
				
			}
		});
		
		back.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new LoginFrame(db);
				dispose();
			}
		});
	}
}
