package frames;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import db.DB;

public class UserFrame extends JFrame{
	private JPanel panel;
	private JLabel lable1, lable2;
	//private 
	//private 
	private JButton back;	
	private DB db;
	private String login_user;
	
	public UserFrame(DB db, String login_user) {
		this.db = db;
		this.login_user = login_user;
		setTitle("Привет " + login_user);
		setSize(900, 900);
		setLocationRelativeTo(null);
		setResizable(false);
		
		initComponents();
		action();
		
		setVisible(true);
		
	}
	
	private void initComponents() {
		panel = new JPanel();
		
		
		back = new JButton("back");
		back.setPreferredSize(new Dimension(880, 20));
		
		panel.add(back);
		
		add(panel);
	}

	private void action() {
		back.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new LoginFrame(db);
				dispose();
			}
		});
	}
}
