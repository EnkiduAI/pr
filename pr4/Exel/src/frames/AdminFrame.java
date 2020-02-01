package frames;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import dao.DaoOrders;
import dao.DaoRooms;
import dao.DaoUsers;
import db.DB;
import entity.Orders;
import entity.Rooms;
import entity.Users;

public class AdminFrame extends JFrame{
	private JPanel panel;
	private JLabel lable1, lable2,lable3, lable4;
	private Table tableUsers, tableInfo, tableRooms, tableOrders;
	private JScrollPane scrollUsers, scrollInfo,scrollRooms, scrollOrders;
	private JButton 	add, update, rol, status, delete,
						update2, delete2,
						add3, update3,status3, delete3,
						status4, del_status, delete4,
						back;	
	private DB db;
	private String login_admin;
	
	public AdminFrame(DB db, String login_admin) {
		this.db = db;
		this.login_admin = login_admin;
		setTitle("ѕривет " + login_admin);
		setSize(900, 900);
		setLocationRelativeTo(null);
		setResizable(false);
		
		initComponents();
		action();
		
		setVisible(true);
		
	}
	
	private void initComponents() {
		panel = new JPanel();
		
		lable1 = new JLabel("----------------------------------------------------------------------------------------------------Users----------------------------------------------------------------------------------------------------");
		lable2 = new JLabel("----------------------------------------------------------------------------------------------------Info----------------------------------------------------------------------------------------------------");
		lable3 = new JLabel("----------------------------------------------------------------------------------------------------Rooms----------------------------------------------------------------------------------------------------");
		lable4 = new JLabel("----------------------------------------------------------------------------------------------------Orders----------------------------------------------------------------------------------------------------");
		
		try {
			tableUsers = new Table(db.query("SELECT * FROM users WHERE rol != 1"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			tableInfo = new Table(db.query("SELECT * FROM info"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			tableRooms = new Table(db.query("SELECT * FROM rooms"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			tableOrders = new Table(db.query("SELECT * FROM orders"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		scrollUsers = new JScrollPane(tableUsers);
		scrollUsers.setPreferredSize(new Dimension(880, 100));
		
		scrollInfo = new JScrollPane(tableInfo);
		scrollInfo.setPreferredSize(new Dimension(880, 100));
		
		scrollRooms = new JScrollPane(tableRooms);
		scrollRooms.setPreferredSize(new Dimension(880, 100));
		
		scrollOrders = new JScrollPane(tableOrders);
		scrollOrders.setPreferredSize(new Dimension(880, 100));
		
		
		add = new JButton("add");
		update = new JButton("update");
		rol = new JButton("rol");
		status = new JButton("status");
		delete = new JButton("delete");
		
		update2 = new JButton("update");
		delete2 = new JButton("delete");
		
		add3 = new JButton("add");
		update3 = new JButton("update");
		status3 = new JButton("status");
		delete3 = new JButton("delete");
		
		status4 = new JButton("status");
		del_status = new JButton("del_status");
		delete4 = new JButton("delete");
		
		back = new JButton("back");
		back.setPreferredSize(new Dimension(880, 20));
		
		panel.add(lable1);
		panel.add(scrollUsers);
		panel.add(add);
		panel.add(update);
		panel.add(rol);
		panel.add(status);
		panel.add(delete);
		
		panel.add(lable2);
		panel.add(scrollInfo);
		panel.add(update2);
		panel.add(delete2);
		
		panel.add(lable3);
		panel.add(scrollRooms);
		panel.add(add3);
		panel.add(update3);
		panel.add(status3);
		panel.add(delete3);
		
		panel.add(lable4);
		panel.add(scrollOrders);
		panel.add(status4);
		panel.add(del_status);
		panel.add(delete4);		
		
		panel.add(back);
		
		add(panel);
	}

	private void action() {
		
		delete3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(tableRooms.getSelectedRow() != -1) {
					DaoRooms room = new DaoRooms(db);
					
					try {
						
						room.delete(new Rooms(Integer.valueOf(String.valueOf(tableRooms.getValueAt(tableRooms.getSelectedRow(), 0)))));
						
					} catch (SQLException e1) {
						JOptionPane.showMessageDialog(panel, "Ќевозможно удалить");
					}
									
				}else {
					JOptionPane.showMessageDialog(panel, "выберите номер дл€ удалени€");
				}
				updateAdminFrame();
			}
		});
		
		status3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(tableRooms.getSelectedRow() != -1) {
					DaoRooms room = new DaoRooms(db);
					
					try {
						if(String.valueOf(tableRooms.getValueAt(tableRooms.getSelectedRow(), 4)).equals("not blok") == true) {
							room.statusBlok(new Rooms(Integer.valueOf(String.valueOf(tableRooms.getValueAt(tableRooms.getSelectedRow(), 0)))));
						}else {
							room.statusNotBlok(new Rooms(Integer.valueOf(String.valueOf(tableRooms.getValueAt(tableRooms.getSelectedRow(), 0)))));
						}
					} catch (SQLException e1) {
						JOptionPane.showMessageDialog(panel, "Ќевозможно помен€ть статус");
					}
									
				}else {
					JOptionPane.showMessageDialog(panel, "выберите номер дл€ изменени€ статуса");
				}
				updateAdminFrame();
			}
		});
		
		
		update3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(tableRooms.getSelectedRow() != -1) {
					DaoRooms room = new DaoRooms(db);
					
					try {
						room.update(new Rooms(Integer.valueOf(String.valueOf(tableRooms.getValueAt(tableRooms.getSelectedRow(), 0))),
								String.valueOf(tableRooms.getValueAt(tableRooms.getSelectedRow(), 1)),
								Integer.valueOf(String.valueOf(tableRooms.getValueAt(tableRooms.getSelectedRow(), 2))),
								Double.valueOf(String.valueOf(tableRooms.getValueAt(tableRooms.getSelectedRow(), 3))),
								String.valueOf(tableRooms.getValueAt(tableRooms.getSelectedRow(), 4))
								));
					} catch (SQLException e1) {
						JOptionPane.showMessageDialog(panel, "Ќевозможно отредактировать");
					}
									
				}else {
					JOptionPane.showMessageDialog(panel, "выберите номер дл€ редактировани€");
				}
				updateAdminFrame();
			}
		});
		
		
		
		add3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				DaoRooms room = new DaoRooms(db);
				try {
					room.insert(new Rooms(0, "econom", 1, 30.00, "not blok"));
				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(panel, "Ќевозможно добавить номер");
				}
				updateAdminFrame();
			}
		});
		
		
		
		
		
		status4.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(tableOrders.getSelectedRow() != -1) {
					DaoOrders order = new DaoOrders(db);
					try {
						if(String.valueOf(tableOrders.getValueAt(tableOrders.getSelectedRow(), 11)).equals("activ") == true) {
							
							if(String.valueOf(tableOrders.getValueAt(tableOrders.getSelectedRow(), 10)).equals("no") == true) {
								
								if(String.valueOf(tableOrders.getValueAt(tableOrders.getSelectedRow(), 9)).equals("no") == true) {
									order.statusYes(new Orders(Integer.valueOf(String.valueOf(tableOrders.getValueAt(tableOrders.getSelectedRow(), 0)))));
								}else {
									order.statusNo(new Orders(Integer.valueOf(String.valueOf(tableOrders.getValueAt(tableOrders.getSelectedRow(), 0)))));
								}
								
							}else {
								JOptionPane.showMessageDialog(panel, "заказ уже оплачен");
							}
							
						}else {
							JOptionPane.showMessageDialog(panel, "заказ уже закрыт");
						}
						
					} catch (NumberFormatException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (SQLException e1) {
						JOptionPane.showMessageDialog(panel, "подтверждение невозможно");
					}
				}else {
					JOptionPane.showMessageDialog(panel, "¬ыберите заказ дл€ подтверждени€");
				}
				updateAdminFrame();
			}
		});
		
		
		del_status.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(tableOrders.getSelectedRow() != -1) {
					DaoOrders order = new DaoOrders(db);
					try {
						if(String.valueOf(tableOrders.getValueAt(tableOrders.getSelectedRow(), 11)).equals("activ") == true) {
							order.delStatus(new Orders(Integer.valueOf(String.valueOf(tableOrders.getValueAt(tableOrders.getSelectedRow(), 0)))));
						}else {
							JOptionPane.showMessageDialog(panel, "заказ уже закрыт");
						}
						
					} catch (NumberFormatException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (SQLException e1) {
						JOptionPane.showMessageDialog(panel, "закрытие невозможно");
					}
				}else {
					JOptionPane.showMessageDialog(panel, "¬ыберите заказ дл€ закрыти€");
				}
				updateAdminFrame();
			}
		});
		
		
		delete4.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(tableOrders.getSelectedRow() != -1) {
					DaoOrders order = new DaoOrders(db);
					try {
						
						order.delete(new Orders(Integer.valueOf(String.valueOf(tableOrders.getValueAt(tableOrders.getSelectedRow(), 0)))));
						
					} catch (NumberFormatException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (SQLException e1) {
						JOptionPane.showMessageDialog(panel, "невозможно удаление");
					}
				}else {
					JOptionPane.showMessageDialog(panel, "¬ыберите заказ дл€ удалени€");
				}
				updateAdminFrame();
			}
		});
		
		delete.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(tableUsers.getSelectedRow() != -1) {
					DaoUsers user = new DaoUsers(db);
					try {
						
						user.delete(new Users(Integer.valueOf(String.valueOf(tableUsers.getValueAt(tableUsers.getSelectedRow(), 0)))));
						
					} catch (NumberFormatException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (SQLException e1) {
						JOptionPane.showMessageDialog(panel, "невозможно удаление");
					}
				}else {
					JOptionPane.showMessageDialog(panel, "¬ыберите запись удалени€");
				}
				updateAdminFrame();
				
			}
		});
		
		status.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(tableUsers.getSelectedRow() != -1) {
					DaoUsers user = new DaoUsers(db);
					try {
						
						if(String.valueOf(tableUsers.getValueAt(tableUsers.getSelectedRow(), 4)).equals("not blok") == true) {
							user.statusBlok(new Users(Integer.valueOf(String.valueOf(tableUsers.getValueAt(tableUsers.getSelectedRow(), 0)))));
						}else {
							user.statusNotBlok(new Users(Integer.valueOf(String.valueOf(tableUsers.getValueAt(tableUsers.getSelectedRow(), 0)))));
						}						
						
					} catch (NumberFormatException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (SQLException e1) {
						JOptionPane.showMessageDialog(panel, "невозможно изменение статуса");
					}
				}else {
					JOptionPane.showMessageDialog(panel, "¬ыберите запись изменени€ статуса");
				}
				updateAdminFrame();

			}
		});
		
		rol.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(tableUsers.getSelectedRow() != -1) {
					DaoUsers user = new DaoUsers(db);
					try {
						user.rolAdmin(new Users(Integer.valueOf(String.valueOf(tableUsers.getValueAt(tableUsers.getSelectedRow(), 0)))));
					} catch (NumberFormatException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (SQLException e1) {
						JOptionPane.showMessageDialog(panel, "невозможно изменение роли");
					}
				}else {
					JOptionPane.showMessageDialog(panel, "¬ыберите запись изменени€ роли");
				}
				updateAdminFrame();
			}
		});
		
		update.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(tableUsers.getSelectedRow() != -1) {
					DaoUsers user = new DaoUsers(db);
					try {
						user.update(new Users(Integer.valueOf(String.valueOf(tableUsers.getValueAt(tableUsers.getSelectedRow(), 0))),
								String.valueOf(tableUsers.getValueAt(tableUsers.getSelectedRow(), 1)),
								String.valueOf(tableUsers.getValueAt(tableUsers.getSelectedRow(), 2)),
								Integer.valueOf(String.valueOf(tableUsers.getValueAt(tableUsers.getSelectedRow(), 3))),
								String.valueOf(tableUsers.getValueAt(tableUsers.getSelectedRow(), 4))								
								));
					} catch (SQLException e1) {
						JOptionPane.showMessageDialog(panel, "–едактирование невозможно");
					}			
					
				}else {
					JOptionPane.showMessageDialog(panel, "¬ыберите запись дл€ редактировани€");
				}
				updateAdminFrame();
			}
		});
		
		add.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				DaoUsers user = new DaoUsers(db);
				try {
					user.insert(new Users(0, "", "", 2, "not blok"));
				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(panel, "Ќевозможно добавить запись");
				}
				
				updateAdminFrame();				
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
	
	private void updateAdminFrame() {
		panel.removeAll();
		
		lable1 = new JLabel("----------------------------------------------------------------------------------------------------Users----------------------------------------------------------------------------------------------------");
		lable2 = new JLabel("----------------------------------------------------------------------------------------------------Info----------------------------------------------------------------------------------------------------");
		lable3 = new JLabel("----------------------------------------------------------------------------------------------------Rooms----------------------------------------------------------------------------------------------------");
		lable4 = new JLabel("----------------------------------------------------------------------------------------------------Orders----------------------------------------------------------------------------------------------------");
		
		try {
			tableUsers = new Table(db.query("SELECT * FROM users WHERE rol != 1"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			tableInfo = new Table(db.query("SELECT * FROM info"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			tableRooms = new Table(db.query("SELECT * FROM rooms"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			tableOrders = new Table(db.query("SELECT * FROM orders"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		scrollUsers = new JScrollPane(tableUsers);
		scrollUsers.setPreferredSize(new Dimension(880, 100));
		
		scrollInfo = new JScrollPane(tableInfo);
		scrollInfo.setPreferredSize(new Dimension(880, 100));
		
		scrollRooms = new JScrollPane(tableRooms);
		scrollRooms.setPreferredSize(new Dimension(880, 100));
		
		scrollOrders = new JScrollPane(tableOrders);
		scrollOrders.setPreferredSize(new Dimension(880, 100));
		
		
		add = new JButton("add");
		update = new JButton("update");
		rol = new JButton("rol");
		status = new JButton("status");
		delete = new JButton("delete");
		
		update2 = new JButton("update");
		delete2 = new JButton("delete");
		
		add3 = new JButton("add");
		update3 = new JButton("update");
		status3 = new JButton("status");
		delete3 = new JButton("delete");
		
		status4 = new JButton("status");
		del_status = new JButton("del_status");
		delete4 = new JButton("delete");
		
		back = new JButton("back");
		back.setPreferredSize(new Dimension(880, 20));
		
		panel.add(lable1);
		panel.add(scrollUsers);
		panel.add(add);
		panel.add(update);
		panel.add(rol);
		panel.add(status);
		panel.add(delete);
		
		panel.add(lable2);
		panel.add(scrollInfo);
		panel.add(update2);
		panel.add(delete2);
		
		panel.add(lable3);
		panel.add(scrollRooms);
		panel.add(add3);
		panel.add(update3);
		panel.add(status3);
		panel.add(delete3);
		
		panel.add(lable4);
		panel.add(scrollOrders);
		panel.add(status4);
		panel.add(del_status);
		panel.add(delete4);		
		
		panel.add(back);
		
		panel.updateUI();
		action();
	}
	
	
	
}
