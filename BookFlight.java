package Airline_reservation_system;
import javax.swing.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import com.toedter.calendar.JDateChooser;
public class BookFlight extends JFrame implements ActionListener{
	JTextField tfAdharNO;
	JButton flight,bookflight,fetchButton;
	Choice source,destination;
    JLabel  name1,tfNationality,tfAddress,tfphone,gender,lableFlcode,lablefname,labledate;
    JDateChooser dcdate;
	public BookFlight() {
		getContentPane().setBackground(Color.WHITE);
		setLayout(null);
		JLabel Heading = new JLabel("Book Flight ");
		Heading.setBounds(420, 20, 500, 35);
		Heading.setForeground(Color.RED);
        Heading.setFont(new Font("Tahoma",Font.PLAIN,32));
		add(Heading);
		
		JLabel AdharNO = new JLabel("Adhar No");
		AdharNO.setBounds(60, 130, 150, 25);
		AdharNO.setForeground(Color.RED);
		AdharNO .setFont(new Font("Tahoma",Font.PLAIN,16));
		add(AdharNO);
		tfAdharNO=new JTextField();
		tfAdharNO.setBounds(220,130,150,25);
		add(tfAdharNO);
		
		fetchButton = new JButton("Fetch");
		fetchButton.setBackground(Color.black);
		fetchButton.setForeground(Color.white);
		fetchButton.setBounds(380,130,120,25);
		fetchButton.addActionListener(this);
		add(fetchButton);
		 
		JLabel name = new JLabel("Name");
		name.setBounds(60, 180, 150, 25);
		name.setForeground(Color.RED);
        name.setFont(new Font("Tahoma",Font.PLAIN,16));
		add(name);
		name1=new JLabel();
		name1.setBounds(220,180,150,25);
		add(name1);
		
		JLabel Nationality = new JLabel("Nationality");
		Nationality.setBounds(60, 230, 150, 25);
		Nationality.setForeground(Color.RED);
		Nationality.setFont(new Font("Tahoma",Font.PLAIN,16));
		add(Nationality);
		tfNationality=new JLabel();
		tfNationality.setBounds(220,230,150,25);
		add(tfNationality);
		
	
		
		JLabel Address = new JLabel("Address");
		Address.setBounds(60, 280, 150, 25);
		Address.setForeground(Color.RED);
		Address.setFont(new Font("Tahoma",Font.PLAIN,16));
		add(Address);
		tfAddress=new JLabel();
		tfAddress.setBounds(220,280,150,25);
		add(tfAddress);
		
		JLabel Gender = new JLabel("Gender");
		Gender.setBounds(60, 330, 150, 25);
		Gender.setForeground(Color.RED);
		Gender.setFont(new Font("Tahoma",Font.PLAIN,16));
		add(Gender);
		 
		gender = new JLabel();
		gender.setBounds(220, 330, 150, 25);
		add(gender);
		
		JLabel lblsource = new JLabel("Source");
		lblsource.setBounds(60,380, 150, 25);
		lblsource.setForeground(Color.RED);
		lblsource.setFont(new Font("Tahoma",Font.PLAIN,16));
		add(lblsource);
		
		source=new Choice();
		source.setBounds(220,380,150,25);
		add(source);
		
		
		JLabel lbldest = new JLabel("Destination");
		lbldest.setBounds(60, 430, 150, 25);
		lbldest.setForeground(Color.RED);
		lbldest.setFont(new Font("Tahoma",Font.PLAIN,16));
		add(lbldest);
		
		destination =new Choice();
		destination.setBounds(220,430,150,25);
		add(destination);
       
		try {
			Conn c= new Conn();
			String query="select * from Flight";
			ResultSet rs = c.s.executeQuery(query);
			while(rs.next()) {
				source.add(rs.getString("source"));
				destination.add(rs.getString("destination"));
			}
		}
		catch(Exception ae) {
			ae.printStackTrace();
		}
		flight = new JButton("FetchFlight");
		flight.setBounds(380,430,150,25);
		flight.setBackground(Color.black);
		flight.setForeground(Color.white);
		flight.addActionListener(this);
		add(flight);
		
		JLabel Flightname = new JLabel("Flight Name");
		Flightname.setBounds(60,480, 150, 25);
		Flightname.setForeground(Color.RED);
		Flightname.setFont(new Font("Tahoma",Font.PLAIN,16));
		add(Flightname);
		lablefname=new JLabel();
		lablefname.setBounds(220,480,150,25);
		add(lablefname);
		
		JLabel Flcode = new JLabel("Flight code");
		Flcode.setBounds(60, 530, 150, 25);
		Flcode.setForeground(Color.RED);
		Flcode.setFont(new Font("Tahoma",Font.PLAIN,16));
		add(Flcode);
		lableFlcode=new JLabel();
		lableFlcode.setBounds(220,530,150,25);
		add(lableFlcode); 
		
		JLabel lbldate = new JLabel("Date of Travel");
		lbldate.setBounds(60, 580, 150, 25);
		lbldate.setForeground(Color.RED);
		lbldate.setFont(new Font("Tahoma",Font.PLAIN,16));
		add(lbldate);
		labledate=new JLabel();
		labledate.setBounds(220,580,150,25);
		add(labledate); 
		
        dcdate = new JDateChooser();
		dcdate.setBounds(220,580,150,25);
		add(dcdate);
		
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Airline_reservation_system/icons/details.jpg"));
		Image i2 =i1.getImage().getScaledInstance(450,320,Image.SCALE_DEFAULT);
		ImageIcon image=new ImageIcon(i2);
		JLabel lblimage =new JLabel(image);
		lblimage.setBounds(550, 80, 500, 410);
		add(lblimage);
		
		bookflight = new JButton("BookFLight");
		bookflight.setBounds(220,630,150,25);
		bookflight.setBackground(Color.black);
		bookflight.setForeground(Color.white);
		bookflight.addActionListener(this);
		add(bookflight);
		
		setSize(1100,800);
		setLocation(200,50);
		setVisible(true);
		
		
         		
	}

	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()==fetchButton)
		{
		  String adhar=	tfAdharNO.getText();
		
		
		try {
			
			Conn conn= new Conn();
			String query="select * from passenger where adhar ='"+ adhar +"'";
			ResultSet rs= conn.s.executeQuery(query);
			if(rs.next()) {
				name1.setText(rs.getString("name"));
				tfNationality.setText(rs.getString("nationality"));
				tfAddress.setText(rs.getString("address"));
				gender.setText(rs.getString("gender"));
				
				
			} else {
				JOptionPane.showMessageDialog(null,"Please Enter correct adhar number");
				
			}
		
		} catch (Exception e) {
			e.printStackTrace();
		}
	
		}
		else if(ae.getSource()==flight)
		{
			  String src = source.getSelectedItem();
			  String dest= destination.getSelectedItem();
			
			
			try {
				
				Conn conn= new Conn();
				String query="select * from flight where source ='"+ src +"' and destination ='"+dest+"'";
				ResultSet rs= conn.s.executeQuery(query);
				if(rs.next()) {
					lableFlcode.setText(rs.getString("f_code"));
					lablefname.setText(rs.getString("f_name"));
					
		
					
				} else {
					JOptionPane.showMessageDialog(null,"No flight Found");
					
				}
			
			} catch (Exception e) {
				e.printStackTrace();
			}
		
			}
		else 
		{
			 Random random = new Random();
			 String adhar= tfAdharNO.getText();
			 String name= name1.getText();
			 String nationality=tfNationality.getText();
			 String flightname=lablefname.getText();
			 String flightcode=lableFlcode.getText();
		     String src=source.getSelectedItem();
		     String dest=destination.getSelectedItem();
			 String Date= ((JTextField) dcdate.getDateEditor().getUiComponent()).getText();
			
			 try {
					
					Conn conn= new Conn();
					String query="insert into reservation values('PNR-"+random.nextInt(100000)+"','TIC-"+random.nextInt(10000)+"','"+adhar+"','"+name+"','"+nationality+"','"+flightname+"','"+flightcode+"','"+src+"','"+dest+"','"+Date+"')";					
				    conn.s.executeUpdate(query);
					JOptionPane.showMessageDialog(null,"Ticket Booked Successfully");
				    setVisible(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
	}
	
   
	public static void main(String[] args) {
           new BookFlight();
	}

}
