package Airline_reservation_system;

import javax.swing.*;
import java.awt.*;
import java.sql.ResultSet;
import java.awt.event.*;
import net.proteanit.sql.DbUtils;

public class JourneyDetails extends JFrame implements ActionListener {
	JTextField Tfpnr;
	JLabel pnr;
	JTable table;
	JButton show;
	JScrollPane jsp;

	public JourneyDetails() {
		getContentPane().setBackground(Color.white);
		setLayout(null);

		pnr = new JLabel("PNR");
		pnr.setFont(new Font("Tahoma", Font.PLAIN, 25));
		pnr.setBounds(50, 50, 100, 25);
		add(pnr);

		Tfpnr = new JTextField();
		Tfpnr.setBounds(160, 50, 120, 25);
		add(Tfpnr);

		show = new JButton("Show details");
		show.setBackground(Color.black);
		show.setForeground(Color.white);
		show.setBounds(290, 50, 120, 25);
		show.addActionListener(this);
		add(show);

		table = new JTable();

		jsp = new JScrollPane(table);
		jsp.setBackground(Color.white);
		jsp.setBounds(0, 100, 800, 150);
		add(jsp);

		setSize(800, 600);
		setLocation(400, 150);
		setVisible(true);

	}

	public void actionPerformed(ActionEvent ae) {
		try {
			Conn conn = new Conn();
			ResultSet rs = conn.s.executeQuery("select * from reservation where PNR ='" + Tfpnr.getText() + "'");
			if (!rs.isBeforeFirst()) {
				JOptionPane.showMessageDialog(null, "No Data Found");
			}
			table.setModel(DbUtils.resultSetToTableModel(rs));

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new JourneyDetails();

	}

}
