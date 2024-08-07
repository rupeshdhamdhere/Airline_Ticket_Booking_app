package Airline_reservation_system;

import javax.swing.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import com.toedter.calendar.JDateChooser;

public class CancelTicket extends JFrame implements ActionListener {
	JTextField tfpnr;
	JButton Cancel, fetchButton;
	Choice source, destination;
	JLabel name1, cancellation_no, flight_code, lbldateoftravell;
	JDateChooser dcdate;

	public CancelTicket() {
		getContentPane().setBackground(Color.WHITE);
		setLayout(null);
		JLabel Heading = new JLabel("Ticket Cancellation !!! ");
		Heading.setBounds(420, 20, 500, 35);
		Heading.setForeground(Color.RED);
		Heading.setFont(new Font("Tahoma", Font.PLAIN, 32));
		add(Heading);

		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Airline_reservation_system/icons/Cancel.jpg"));
		Image i2 = i1.getImage().getScaledInstance(450, 320, Image.SCALE_DEFAULT);
		ImageIcon image = new ImageIcon(i2);
		JLabel lblimage = new JLabel(image);
		lblimage.setBounds(550, 80, 500, 410);
		add(lblimage);

		JLabel pnr = new JLabel("PNR No");
		pnr.setBounds(60, 130, 150, 25);
		pnr.setForeground(Color.RED);
		pnr.setFont(new Font("Tahoma", Font.PLAIN, 16));
		add(pnr);
		tfpnr = new JTextField();
		tfpnr.setBounds(220, 130, 150, 25);
		add(tfpnr);

		fetchButton = new JButton("Show Details");
		fetchButton.setBackground(Color.black);
		fetchButton.setForeground(Color.white);
		fetchButton.setBounds(380, 130, 120, 25);
		fetchButton.addActionListener(this);
		add(fetchButton);

		JLabel name = new JLabel("Name");
		name.setBounds(60, 180, 150, 25);
		name.setForeground(Color.RED);
		name.setFont(new Font("Tahoma", Font.PLAIN, 16));
		add(name);
		name1 = new JLabel();
		name1.setBounds(220, 180, 150, 25);
		add(name1);

		Random random = new Random();
		JLabel Cancellation_NO = new JLabel("Cancellation_NO");
		Cancellation_NO.setBounds(60, 230, 150, 25);
		Cancellation_NO.setForeground(Color.RED);
		Cancellation_NO.setFont(new Font("Tahoma", Font.PLAIN, 16));
		add(Cancellation_NO);
		cancellation_no = new JLabel("" + random.nextInt(1000000));
		cancellation_no.setBounds(220, 230, 150, 25);
		add(cancellation_no);

		JLabel FlightCode = new JLabel("Flight Code");
		FlightCode.setBounds(60, 280, 150, 25);
		FlightCode.setForeground(Color.RED);
		FlightCode.setFont(new Font("Tahoma", Font.PLAIN, 16));
		add(FlightCode);
		flight_code = new JLabel();
		flight_code.setBounds(220, 280, 150, 25);
		add(flight_code);

		JLabel Gender = new JLabel("Date");
		Gender.setBounds(60, 330, 150, 25);
		Gender.setForeground(Color.RED);
		Gender.setFont(new Font("Tahoma", Font.PLAIN, 16));
		add(Gender);

		lbldateoftravell = new JLabel();
		lbldateoftravell.setBounds(220, 330, 150, 25);
		add(lbldateoftravell);

		Cancel = new JButton("Cancel");
		Cancel.setBounds(270, 430, 150, 25);
		Cancel.setBackground(Color.black);
		Cancel.setForeground(Color.white);
		Cancel.addActionListener(this);
		add(Cancel);

		setSize(1100, 800);
		setLocation(200, 50);
		setVisible(true);

	}

	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == fetchButton) {
			String pnr = tfpnr.getText();

			try {

				Conn conn = new Conn();
				String query = "select * from reservation where PNR ='" + pnr + "'";
				ResultSet rs = conn.s.executeQuery(query);
				if (rs.next()) {
					name1.setText(rs.getString("name"));
					flight_code.setText(rs.getString("flightcode"));
					lbldateoftravell.setText(rs.getString("ddate"));

				} else {
					JOptionPane.showMessageDialog(null, "Please Enter correct PNR number");

				}

			} catch (Exception e) {
				e.printStackTrace();

			}
		}
		else if(ae.getSource() == Cancel) {
			String name = name1.getText();
			String pnr  = tfpnr.getText();
			String cancelNO= cancellation_no.getText();
			String Flightcode=flight_code.getText();
			String Date = lbldateoftravell.getText();
			
			try {
				Conn conn = new Conn();
				String query = "insert into cancel values ( '"+pnr+"','"+name+"','"+cancelNO+"','"+Flightcode+"','"+Date+"')";
				conn.s.executeUpdate(query);
				conn.s.executeUpdate("delete from reservation where PNR ='"+pnr+"'");
				JOptionPane.showMessageDialog(null, "Ticket Cancelled successfully");
				setVisible(false);
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		new CancelTicket();
	}

}
