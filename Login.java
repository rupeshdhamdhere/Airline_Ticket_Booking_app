package Airline_reservation_system;

import javax.swing.*;
import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import java.util.EventListener;

public class Login extends JFrame implements ActionListener {
	JButton reset, Submit, close;
	JTextField name, pass;

	public Login() {

		getContentPane().setBackground(Color.WHITE);
		setLayout(null);
		JLabel user = new JLabel("Username");
		user.setBounds(20, 20, 100, 20);
		add(user);

		JLabel password = new JLabel("Password");
		password.setBounds(20, 40, 100, 20);
		add(password);
		name = new JTextField();
		name.setBounds(135, 20, 100, 20);
		add(name);

		pass = new JTextField();
		pass.setBounds(135, 40, 100, 20);
		add(pass);

		reset = new JButton("Reset");
		reset.setBounds(135, 80, 100, 20);
		reset.addActionListener(this);
		add(reset);

		Submit = new JButton("Submit");
		Submit.setBounds(240, 80, 100, 20);
		add(Submit);
		Submit.addActionListener(this);

		close = new JButton("Close");
		close.setBounds(180, 105, 100, 20);
		add(close);
		close.addActionListener(this);
//		setSize(500, 500);
//		setLocation(500, 300);
		 setExtendedState(JFrame.MAXIMIZED_BOTH);
		setVisible(true);

	}

	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == Submit) {
			String username = name.getText();
			String password = pass.getText();

			try {
				Conn c = new Conn();
				String query = "select * from login where username ='" + username + "'and password='" + password + "'";
				ResultSet rs = c.s.executeQuery(query);

				if (rs.next()) {
					Home h = new Home();
				} else {
					JOptionPane.showMessageDialog(null, "Invalid username or password");
					setVisible(false);
				}

			} catch (Exception e) {
				e.printStackTrace();
			}

		} else if (ae.getSource() == reset) {
			name.setText("");
			pass.setText("");
		} else if (ae.getSource() == close) {
			setVisible(false);
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Login();

	}

}
