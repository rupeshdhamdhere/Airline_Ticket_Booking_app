package Airline_reservation_system;
import javax.swing.*;
import java.awt.*;
import java.sql.ResultSet;

import net.proteanit.sql.DbUtils;
public class FlightInfo extends JFrame {
	
	public FlightInfo() {
		getContentPane().setBackground(Color.white);
		setLayout(null);
		
		JTable table= new JTable();
		
		try {
			Conn conn= new Conn();
			ResultSet rs = conn.s.executeQuery("select * from Flight");
			
			table.setModel(DbUtils.resultSetToTableModel(rs) );
			 
			}
		catch(Exception e){
			e.printStackTrace();
		}	
		table.setBounds(0,0,800,500);
		JScrollPane jsp = new JScrollPane(table);
		jsp.setBounds(0,0,800,500);
		add(table);
		setSize(800,500);
		setLocation(400,200);
		setVisible(true);
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new FlightInfo();

	}

}
