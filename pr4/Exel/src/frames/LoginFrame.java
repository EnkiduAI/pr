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

import db.DB;

public class LoginFrame extends JFrame{
	private JPanel panel;
	private JLabel lableLogin, lablePass;
	private JTextField login;
	private JPasswordField pass;
	private JButton ok, registration;	
	private DB db;
	
	public LoginFrame(DB db) {
		this.db = db;
		setTitle("LoginFrame");
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
		
		login = new JTextField("admin", 20);
		
		pass = new JPasswordField("admin", 20);
		
		ok = new JButton("ok");
		registration = new JButton("registration");
				
		panel.add(lableLogin);
		panel.add(login);
		panel.add(lablePass);
		panel.add(pass);
		
		panel.add(ok);
		panel.add(registration);
		
		add(panel);
	}

	private void action() {
		ok.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(login.getText().equals("") != true && String.valueOf(pass.getPassword()).equals("") != true) {
					
					try {
						ResultSet rs = db.query("SELECT * FROM users WHERE login='" + login.getText() + "'");
						
						if(rs.next() == true) {
							
							if(rs.getString("pass").equals(String.valueOf(pass.getPassword())) == true) {
								
								if(rs.getString("status").equals("not blok")) {
									
									if(rs.getInt("rol") == 1) {
										//admin
										new AdminFrame(db, login.getText());
										dispose();
									}else {
										
										if(rs.getInt("rol") == 2) {
											//user
											new UserFrame(db, login.getText());
											dispose();
										}else {
											//���-�� ������
										}
										
									}
									
								}else {
									JOptionPane.showMessageDialog(panel, "������������ �������� ������������");
								}
								
							}else {
								JOptionPane.showMessageDialog(panel, "������ ��������");
							}
							
						}else {
							JOptionPane.showMessageDialog(panel, "������������ � ������� " + login.getText() + " �����������");
						}
						
					} catch (SQLException e1) {
						JOptionPane.showMessageDialog(panel, "������ � ������� SELECT");
					}
					
				}else {
					if(login.getText().equals("") == true) {
						JOptionPane.showMessageDialog(panel, "��������� ���� �����");
					}
					if(String.valueOf(pass.getPassword()).equals("") == true) {
						JOptionPane.showMessageDialog(panel, "��������� ���� pass");
					}
				}
				
			}
		});
		
		
		registration.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new RegistrationFrame(db);
				dispose();
			}
		});
	}
	
	
	
	
}
