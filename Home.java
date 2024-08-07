package Airline_reservation_system;

import javax.swing.*;
import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import java.util.EventListener;

public class Home extends JFrame implements ActionListener {

	public Home() {

		setLayout(null);
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Airline_reservation_system/icons/front.jpg"));
		JLabel Image = new JLabel(i1);
		Image.setBounds(0, 0, 1600, 800);
		add(Image);

		JLabel Heading = new JLabel("Welcome To the Air India");
		Heading.setBounds(500, 20, 400, 40);
		Heading.setForeground(Color.RED);
		Heading.setFont(new Font("Tahoma", Font.PLAIN, 20));
		Image.add(Heading);

		JMenuBar menubar = new JMenuBar();
		setJMenuBar(menubar);

		JMenu details = new JMenu("details");
		menubar.add(details);

		JMenuItem Flightdetails = new JMenuItem("Flightdetails");
		Flightdetails.addActionListener(this);
		details.add(Flightdetails);

		JMenuItem customerDetails = new JMenuItem("customerDetails");
		customerDetails.addActionListener(this);
		details.add(customerDetails);

		JMenuItem bookFlight = new JMenuItem("bookFlight");
		bookFlight.addActionListener(this);
		details.add(bookFlight);

		JMenuItem journeydetails = new JMenuItem("journeydetails");
		journeydetails.addActionListener(this);
		details.add(journeydetails);

		JMenuItem cancelticket = new JMenuItem("cancelticket");
		cancelticket.addActionListener(this);
		details.add(cancelticket);

		JMenu Ticket = new JMenu("Ticket");
		menubar.add(Ticket);

		JMenuItem Boardingpass = new JMenuItem("Boardingpass");
		Boardingpass.addActionListener(this);
		Ticket.add(Boardingpass);

		setExtendedState(JFrame.MAXIMIZED_BOTH);

		setVisible(true);

	}

	public void actionPerformed(ActionEvent ae) {
		String text = ae.getActionCommand();
		if (text == "customerDetails") {
			new AddCustomer();
		} else if (text == "Flightdetails") {
			new FlightInfo();
		} else if (text == "bookFlight") {
			new BookFlight();
		}else if (text=="journeydetails") {
			new JourneyDetails();
		}else if(text=="cancelticket") {
			new CancelTicket();
		}else if(text=="Boardingpass") {
			new BoardingPaas();
		}
			

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Home();

	}
}
