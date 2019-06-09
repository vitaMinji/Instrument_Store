import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Iterator;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;


public class FindGuitarTester extends JFrame {

		private JPanel contentPane;
		private JTextField textField;


		public static void main(String[] args) {
			
			//있던거
		Inventory inventory = new Inventory();
		initializeInventory(inventory);

		GuitarSpec whatErinLikes = 
				new GuitarSpec(Builder.FENDER, "Stratocastor", 
			                     TypeGuitar.ELECTRIC, 6, Wood.ALDER, Wood.ALDER);
		List matchingGuitars = inventory.search(whatErinLikes);
		if (!matchingGuitars.isEmpty()) {
		System.out.println("Erin, you might like these guitars:");
		for (Iterator i = matchingGuitars.iterator(); i.hasNext(); ) {
		Guitar guitar = (Guitar)i.next();
		GuitarSpec spec = guitar.getSpec();
			        System.out.println("  We have a " +
			          spec.getBuilder() + " " + spec.getModel() + " " +
			          spec.getType() + " guitar:\n     " +
			          spec.getBackWood() + " back and sides,\n     " +
			          spec.getTopWood() + " top.\n  You can have it for only $" +
			          guitar.getPrice() + "!\n  ----");
			      }
			    } else {
			      System.out.println("Sorry, Erin, we have nothing for you.");
			    }
			  }
			
		
			  private static void initializeInventory(Inventory inventory) {
				  try {
						Class.forName("com.mysql.cj.jdbc.Driver");
						Connection conn=null;
						conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/guitar_inventory?serverTimezone=Asia/Seoul","root","7202");
						Statement stmt = conn.createStatement(); 
						
						stmt.executeUpdate("delete from guitar");
						inventory.addGuitar("insert into guitar (serialNumber, price, builder, model, type, numString, backWood, topWood) values('11277', '3999.95', 'Builder.COLLINGS','CJ','TypeGuitar.ELECTRIC','6','Wood.INDIAN_ROSEWOOD','Wood.SITKA');");
						inventory.addGuitar("insert into guitar (serialNumber, price, builder, model, type, numString, backWood, topWood) values('V95693', '1499.95', 'Builder.FENDER','Stratocastor','TypeGuitar.ELECTRIC','6','Wood.ALDER', 'Wood.ALDER');");
						inventory.addGuitar("insert into guitar (serialNumber, price, builder, model, type, numString, backWood, topWood) values('V9512', '1549.95', 'Builder.FENDER', 'Stratocastor', 'TypeGuitar.ELECTRIC', '6', 'Wood.ALDER', 'Wood.ALDER');");
						inventory.addGuitar("insert into guitar (serialNumber, price, builder, model, type, numString, backWood, topWood) values('122784', '5495.95', 'Builder.MARTIN','D-18','TypeGuitar.ACOUSTIC', '6', 'Wood.MAHOGANY', 'Wood.ADIRONDACK');");
						inventory.addGuitar("insert into guitar (serialNumber, price, builder, model, type, numString, backWood, topWood) values('76531', '6295.95', 'Builder.MARTIN', 'OM-28','TypeGuitar.ACOUSTIC', '6', 'Wood.BRAZILIAN_ROSEWOOD', 'Wood.ADIRONDACK');");
						inventory.addGuitar("insert into guitar (serialNumber, price, builder, model, type, numString, backWood, topWood) values('70108276', '2295.95', 'Builder.GIBSON', 'Les Paul', 'TypeGuitar.ELECTRIC','6', 'Wood.MAHOGANY', 'Wood.MAHOGANY');");
						inventory.addGuitar("insert into guitar (serialNumber, price, builder, model, type, numString, backWood, topWood) values('82765501', '1890.95', 'Builder.GIBSON', 'SG 61 Reissue', 'TypeGuitar.ELECTRIC', '6',' Wood.MAHOGANY', 'Wood.MAHOGANY');");
						inventory.addGuitar("insert into guitar (serialNumber, price, builder, model, type, numString, backWood, topWood) values('77023', '6275.95', 'Builder.MARTIN', 'D-28', 'TypeGuitar.ACOUSTIC', '6', ' Wood.BRAZILIAN_ROSEWOOD', 'Wood.ADIRONDACK');");
						inventory.addGuitar("insert into guitar (serialNumber, price, builder, model, type, numString, backWood, topWood) values('1092', '12995.95', 'Builder.OLSON', 'SJ', 'TypeGuitar.ACOUSTIC', '12', 'Wood.INDIAN_ROSEWOOD', 'Wood.CEDAR');");
						inventory.addGuitar("insert into guitar (serialNumber, price, builder, model, type, numString, backWood, topWood) values('566-62', '8999.95', 'Builder.RYAN', 'Cathedral', 'TypeGuitar.ACOUSTIC',' 12', 'Wood.COCOBOLO', 'Wood.CEDAR');");
						inventory.addGuitar("insert into guitar (serialNumber, price, builder, model, type, numString, backWood, topWood) values('6 29584', '2100.95', 'Builder.PRS', 'Dave Navarro Signature', 'TypeGuitar.ELECTRIC', '6', 'Wood.MAHOGANY', 'Wood.MAPLE');");
						
						
						conn.close();
						
					} catch(ClassNotFoundException e) {
						System.out.println("JDBC 드라이버 로드 에러");
					} 
					catch(SQLException e) {
						System.out.println(e);
					}
			  
				  			
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						FindGuitarTester frame = new FindGuitarTester();
						frame.setVisible(true);
						
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
		}

		/**
		 * Create the frame.
		 */
			  
			  
			  
			  
	    //GUI
		public FindGuitarTester() {
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBounds(100, 100, 746, 470);
			contentPane = new JPanel();
			contentPane.setBackground(Color.ORANGE);
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			setContentPane(contentPane);
			contentPane.setLayout(null);
			
			JPanel panel = new JPanel();
			panel.setBackground(new Color(250, 235, 215));
			panel.setBounds(12, 10, 706, 411);
			panel.setVisible(false);
			
			JPanel panel_1 = new JPanel();
			panel_1.setBounds(12, 10, 706, 411);
			contentPane.add(panel_1);
			panel_1.setBackground(new Color(210, 180, 140));
			panel_1.setLayout(null);
			
			JLabel lblSerialNumber = new JLabel("builder");
			lblSerialNumber.setBounds(77, 68, 101, 15);
			panel_1.add(lblSerialNumber);
			
			JLabel lblPrice = new JLabel("model");
			lblPrice.setBounds(77, 110, 57, 15);
			panel_1.add(lblPrice);
			
			JLabel lblType = new JLabel("type");
			lblType.setBounds(77, 156, 57, 15);
			panel_1.add(lblType);
			
			JLabel lblNewLabel_1 = new JLabel("Number of string");
			lblNewLabel_1.setBounds(77, 197, 101, 15);
			panel_1.add(lblNewLabel_1);
			
			JLabel lblBackwood = new JLabel("backWood");
			lblBackwood.setBounds(77, 238, 78, 15);
			panel_1.add(lblBackwood);
			
			JLabel lblTopwood = new JLabel("topWood");
			lblTopwood.setBounds(77, 276, 57, 15);
			panel_1.add(lblTopwood);
			
			JComboBox comboBox = new JComboBox();
			comboBox.setModel(new DefaultComboBoxModel(Builder.values()));
			
			comboBox.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e) {
					String builderValue = new String();
					builderValue= comboBox.getSelectedItem().toString();
					//search 메소드에 바로 보내버리자.
				}
			});
			comboBox.setBounds(218, 65, 101, 21);
			panel_1.add(comboBox);
			
			textField = new JTextField();
			textField.setBounds(218, 107, 101, 21);
			panel_1.add(textField);
			textField.setColumns(10);
			
			JComboBox comboBox_1 = new JComboBox();
			comboBox_1.setModel(new DefaultComboBoxModel(TypeGuitar.values()));
			
			//콤보박스 값 가져오자!! 화이팅,,
			
			comboBox_1.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e) {
					String typeValue = new String();
					typeValue= comboBox_1.getSelectedItem().toString();
					//search 메소드에 바로 보내버리자.
				}
			});
			
			comboBox_1.setBounds(218, 153, 101, 21);
			panel_1.add(comboBox_1);
			
			JComboBox comboBox_2 = new JComboBox();
			comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"6", "12"}));
			
			
			comboBox_2.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e) {
					String numStringValue = new String();
					numStringValue= comboBox_2.getSelectedItem().toString();
					//search 메소드에 바로 보내버리자.
				}
			});
			
			
			comboBox_2.setBounds(218, 194, 101, 21);
			panel_1.add(comboBox_2);
			
			JComboBox comboBox_3 = new JComboBox();
			comboBox_3.setModel(new DefaultComboBoxModel(Wood.values()));
			
			comboBox_3.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e) {
					String backWoodValue = new String();
					backWoodValue= comboBox_3.getSelectedItem().toString();
					//search 메소드에 바로 보내버리자.
				}
			});
			comboBox_3.setBounds(218, 235, 101, 21);
			panel_1.add(comboBox_3);
			
			JComboBox comboBox_4 = new JComboBox();
			comboBox_4.setModel(new DefaultComboBoxModel(Wood.values()));
			
			comboBox_4.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e) {
					String topWoodValue = new String();
					topWoodValue= comboBox_4.getSelectedItem().toString();
					//search 메소드에 바로 보내버리자.
				}
			});
			comboBox_4.setBounds(218, 273, 101, 21);
			panel_1.add(comboBox_4);
			
			JButton btnNewButton_2 = new JButton("Search");
			btnNewButton_2.setBounds(271, 335, 184, 42);
			panel_1.add(btnNewButton_2);
			panel_1.setVisible(false);
			contentPane.add(panel);
			
			JButton btnNewButton = new JButton("View all instrument");
			btnNewButton.setBounds(292, 176, 148, 43);
			contentPane.add(btnNewButton);
			
			JButton btnNewButton_1 = new JButton("Search instrument");
			btnNewButton_1.setBounds(292, 243, 148, 43);
			contentPane.add(btnNewButton_1);
			
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					panel.setVisible(true);
					btnNewButton.setVisible(false);
					btnNewButton_1.setVisible(false);
					try {
						Class.forName("com.mysql.cj.jdbc.Driver");
						Connection conn=null;
						conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/guitar_inventory?serverTimezone=Asia/Seoul","root","7202");
						Statement stmt = conn.createStatement(); 
						ResultSet rs = stmt.executeQuery("select * from guitar");
						conn.close();
						
					} catch(ClassNotFoundException e) {
						System.out.println("JDBC 드라이버 로드 에러");
					} 
					catch(SQLException e) {
						System.out.println("DB연결에러");
					}
				}
			});
			
			btnNewButton_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					panel_1.setVisible(true);
					btnNewButton.setVisible(false);
					btnNewButton_1.setVisible(false);
				}
			});
			
			
			JLabel lblNewLabel = new JLabel("");
			lblNewLabel.setIcon(new ImageIcon(FindGuitarTester.class.getResource("/res/store_inside.jpg")));
			lblNewLabel.setBackground(Color.BLACK);
			lblNewLabel.setBounds(0, 0, 730, 431);
			contentPane.add(lblNewLabel);
			
			
		}
	}




