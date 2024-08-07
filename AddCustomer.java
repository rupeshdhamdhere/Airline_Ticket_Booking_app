package Airline_reservation_system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class AddCustomer extends JFrame implements ActionListener{
    JTextField  name1,tfNationality,tfAdharNO,tfAddress,tfphone;
    JRadioButton rbfeMale, rbMale;
	public AddCustomer() {
		getContentPane().setBackground(Color.WHITE);
		setLayout(null);
		JLabel Heading = new JLabel("Add Customer details");
		Heading.setBounds(250, 20, 500, 35);
		Heading.setForeground(Color.RED);
        Heading.setFont(new Font("Tahoma",Font.PLAIN,32));
		add(Heading);
		
		JLabel name = new JLabel("Name");
		name.setBounds(60, 80, 150, 25);
		name.setForeground(Color.RED);
        name.setFont(new Font("Tahoma",Font.PLAIN,16));
		add(name);
		name1=new JTextField();
		name1.setBounds(220,80,150,25);
		add(name1);
		
		JLabel Nationality = new JLabel("Nationality");
		Nationality.setBounds(60, 130, 150, 25);
		Nationality.setForeground(Color.RED);
		Nationality.setFont(new Font("Tahoma",Font.PLAIN,16));
		add(Nationality);
		tfNationality=new JTextField();
		tfNationality.setBounds(220,130,150,25);
		add(tfNationality);
		
		JLabel AdharNO = new JLabel("Adhar No");
		AdharNO.setBounds(60, 180, 150, 25);
		AdharNO.setForeground(Color.RED);
		AdharNO .setFont(new Font("Tahoma",Font.PLAIN,16));
		add(AdharNO);
		tfAdharNO=new JTextField();
		tfAdharNO.setBounds(220,180,150,25);
		add(tfAdharNO);
		
		JLabel Address = new JLabel("Address");
		Address.setBounds(60, 230, 150, 25);
		Address.setForeground(Color.RED);
		Address.setFont(new Font("Tahoma",Font.PLAIN,16));
		add(Address);
		tfAddress=new JTextField();
		tfAddress.setBounds(220,230,150,25);
		add(tfAddress);
		
		JLabel Gender = new JLabel("Gender");
		Gender.setBounds(60, 280, 150, 25);
		Gender.setForeground(Color.RED);
		Gender.setFont(new Font("Tahoma",Font.PLAIN,16));
		add(Gender);
		
        ButtonGroup gendergroup= new ButtonGroup();		
		rbMale= new JRadioButton("Male");
		rbMale.setBounds(220,280,70,25);
		add(rbMale);
		
		rbfeMale= new JRadioButton("Female");
		rbfeMale.setBounds(300,280,70,25);
		add(rbfeMale);
		
		gendergroup.add(rbMale);
		gendergroup.add(rbfeMale);
		
		JLabel phone = new JLabel("Phone");
		phone.setBounds(60, 330, 150, 25);
		phone.setForeground(Color.RED);
		phone.setFont(new Font("Tahoma",Font.PLAIN,16));
		add(phone);
		tfphone=new JTextField();
		tfphone.setBounds(220,330,150,25);
		add(tfphone);
		
		JButton save = new JButton("Save");
		save.setBounds(220,380,150,25);
		save.setBackground(Color.black);
		save.setForeground(Color.white);
		save.addActionListener(this);
		add(save);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Airline_reservation_system/icons/emp.png"));
		JLabel Image = new JLabel(i1);
		Image.setBounds(450, 80, 280, 400);
		add(Image);
		
		setSize(900,600);
		setLocation(300,150);
		setVisible(true);
		
		
         		
	}

	public void actionPerformed(ActionEvent ae) {
          String name = name1.getText();
          String nationality =tfNationality.getText();
          String adhar =tfAdharNO.getText();
          String address =tfAddress.getText();
          String phone =tfphone.getText();
          String gender=null;
          if(rbMale.isSelected())
          {
        	  gender=("Male");
          }
          else {
        	  gender="female";
          }
		try {
			
			Conn conn= new Conn();
			
			String query="insert into passenger values ( '"+name+"','"+nationality+"','"+adhar+"','"+address+"','"+phone+"','"+gender+"')";
			conn.s.executeUpdate(query);
			JOptionPane.showMessageDialog(null,"Customer details added Successfully");
            setVisible(false);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
   
	public static void main(String[] args) {
           new AddCustomer();
	}

}
