package Airline_reservation_system;

import javax.swing.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import com.toedter.calendar.JDateChooser;

public class BoardingPaas extends JFrame implements ActionListener {
	JTextField tfpnr;
	JButton fetchButton;
	JLabel name1, tfNationality, lblsrc, lbldest, lableFlcode, lablefname, dcdate;

	public BoardingPaas() {
		getContentPane().setBackground(Color.WHITE);
		setLayout(null);
		JLabel Heading = new JLabel("Air India ");
		Heading.setBounds(380, 10, 450, 35);
		Heading.setForeground(Color.RED);
		Heading.setFont(new Font("Tahoma", Font.PLAIN, 32));
		add(Heading);

		JLabel subHeading = new JLabel("BOARDING PASS ");
		subHeading.setBounds(360, 50, 300, 25);
		subHeading.setForeground(Color.RED);
		subHeading.setFont(new Font("Tahoma", Font.PLAIN, 32));
		add(subHeading);

		JLabel AdharNO = new JLabel("PNR DETAILS");
		AdharNO.setBounds(60, 100, 150, 25);
		AdharNO.setForeground(Color.RED);
		AdharNO.setFont(new Font("Tahoma", Font.PLAIN, 16));
		add(AdharNO);
		tfpnr = new JTextField();
		tfpnr.setBounds(220, 100, 150, 25);
		add(tfpnr);

		fetchButton = new JButton("ENTER");
		fetchButton.setBackground(Color.black);
		fetchButton.setForeground(Color.white);
		fetchButton.setBounds(380, 100, 120, 25);
		fetchButton.addActionListener(this);
		add(fetchButton);

		JLabel name = new JLabel("NAME");
		name.setBounds(60, 140, 150, 25);
		name.setForeground(Color.RED);
		name.setFont(new Font("Tahoma", Font.PLAIN, 16));
		add(name);
		name1 = new JLabel();
		name1.setBounds(220, 140, 150, 25);
		add(name1);

		JLabel Nationality = new JLabel("NATIONALITY");
		Nationality.setBounds(60, 180, 150, 25);
		Nationality.setForeground(Color.RED);
		Nationality.setFont(new Font("Tahoma", Font.PLAIN, 16));
		add(Nationality);
		tfNationality = new JLabel();
		tfNationality.setBounds(220, 180, 150, 25);
		add(tfNationality);

		JLabel Address = new JLabel("SRC");
		Address.setBounds(60, 220, 150, 25);
		Address.setForeground(Color.RED);
		Address.setFont(new Font("Tahoma", Font.PLAIN, 16));
		add(Address);
		lblsrc = new JLabel();
		lblsrc.setBounds(220, 220, 150, 25);
		add(lblsrc);

		JLabel Gender = new JLabel("DEST");
		Gender.setBounds(380, 220, 150, 25);
		Gender.setForeground(Color.RED);
		Gender.setFont(new Font("Tahoma", Font.PLAIN, 16));
		add(Gender);

		lbldest = new JLabel();
		lbldest.setBounds(480, 220, 150, 25);
		add(lbldest);

		JLabel Flightname = new JLabel("Flight Name");
		Flightname.setBounds(60, 260, 150, 25);
		Flightname.setForeground(Color.RED);
		Flightname.setFont(new Font("Tahoma", Font.PLAIN, 16));
		add(Flightname);
		lablefname = new JLabel();
		lablefname.setBounds(220, 260, 150, 25);
		add(lablefname);

		JLabel Flcode = new JLabel("Flight code");
		Flcode.setBounds(380, 260, 150, 25);
		Flcode.setForeground(Color.RED);
		Flcode.setFont(new Font("Tahoma", Font.PLAIN, 16));
		add(Flcode);
		lableFlcode = new JLabel();
		lableFlcode.setBounds(480, 260, 150, 25);
		add(lableFlcode);

		JLabel lbldate = new JLabel("Date of Travel");
		lbldate.setBounds(60, 300, 150, 25);
		lbldate.setForeground(Color.RED);
		lbldate.setFont(new Font("Tahoma", Font.PLAIN, 16));
		add(lbldate);

		dcdate = new JLabel();
		dcdate.setBounds(220, 300, 150, 25);
		add(dcdate);

		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Airline_reservation_system/icons/airindia.png"));
		Image i2 = i1.getImage().getScaledInstance(300, 230, Image.SCALE_DEFAULT);
		ImageIcon image = new ImageIcon(i2);
		JLabel lblimage = new JLabel(image);
		lblimage.setBounds(600, 0, 300, 300);
		add(lblimage);

		

		setSize(1000, 450);
		setLocation(300, 150);
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
					lableFlcode.setText(rs.getString("flightcode"));
					lblsrc.setText(rs.getString("src"));
					dcdate.setText(rs.getString("ddate"));
					tfNationality.setText(rs.getString("nationality"));
					lablefname.setText(rs.getString("flightname"));
					lbldest.setText(rs.getString("dest"));
					
				} else {
					JOptionPane.showMessageDialog(null, "Please Enter correct PNR number");

				}

			} catch (Exception e) {
				e.printStackTrace();

			}
			}
	}

	public static void main(String[] args) {
		new BoardingPaas();
	}

}
