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

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


public class FindGuitarTester extends JFrame {

		private JPanel contentPane;

		/**
		 * 
		 * Launch the application.
		 */
		

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
						stmt.executeUpdate("insert into guitar (serialNumber, price, builder, model, type, numString, backWood, topWood) values('11277', '3999.95', 'Builder.COLLINGS','CJ','TypeGuitar.ELECTRIC','6','Wood.INDIAN_ROSEWOOD','Wood.SITKA');");
						stmt.executeUpdate("insert into guitar (serialNumber, price, builder, model, type, numString, backWood, topWood) values('V95693', '1499.95', 'Builder.FENDER','Stratocastor','TypeGuitar.ELECTRIC','6','Wood.ALDER', 'Wood.ALDER');");
						stmt.executeUpdate("insert into guitar (serialNumber, price, builder, model, type, numString, backWood, topWood) values('V9512', '1549.95', 'Builder.FENDER', 'Stratocastor', 'TypeGuitar.ELECTRIC', '6', 'Wood.ALDER', 'Wood.ALDER');");
						stmt.executeUpdate("insert into guitar (serialNumber, price, builder, model, type, numString, backWood, topWood) values('122784', '5495.95', 'Builder.MARTIN','D-18','TypeGuitar.ACOUSTIC', '6', 'Wood.MAHOGANY', 'Wood.ADIRONDACK');");
						stmt.executeUpdate("insert into guitar (serialNumber, price, builder, model, type, numString, backWood, topWood) values('76531', '6295.95', 'Builder.MARTIN', 'OM-28','TypeGuitar.ACOUSTIC', '6', 'Wood.BRAZILIAN_ROSEWOOD', 'Wood.ADIRONDACK');");
						stmt.executeUpdate("insert into guitar (serialNumber, price, builder, model, type, numString, backWood, topWood) values('70108276', '2295.95', 'Builder.GIBSON', 'Les Paul', 'TypeGuitar.ELECTRIC','6', 'Wood.MAHOGANY', 'Wood.MAHOGANY');");
						stmt.executeUpdate("insert into guitar (serialNumber, price, builder, model, type, numString, backWood, topWood) values('82765501', '1890.95', 'Builder.GIBSON', 'SG 61 Reissue', 'TypeGuitar.ELECTRIC', '6',' Wood.MAHOGANY', 'Wood.MAHOGANY');");
						stmt.executeUpdate("insert into guitar (serialNumber, price, builder, model, type, numString, backWood, topWood) values('77023', '6275.95', 'Builder.MARTIN', 'D-28', 'TypeGuitar.ACOUSTIC', '6', ' Wood.BRAZILIAN_ROSEWOOD', 'Wood.ADIRONDACK');");
						stmt.executeUpdate("insert into guitar (serialNumber, price, builder, model, type, numString, backWood, topWood) values('1092', '12995.95', 'Builder.OLSON', 'SJ', 'TypeGuitar.ACOUSTIC', '12', 'Wood.INDIAN_ROSEWOOD', 'Wood.CEDAR');");
						stmt.executeUpdate("insert into guitar (serialNumber, price, builder, model, type, numString, backWood, topWood) values('566-62', '8999.95', 'Builder.RYAN', 'Cathedral', 'TypeGuitar.ACOUSTIC',' 12', 'Wood.COCOBOLO', 'Wood.CEDAR');");
						stmt.executeUpdate("insert into guitar (serialNumber, price, builder, model, type, numString, backWood, topWood) values('6 29584', '2100.95', 'Builder.PRS', 'Dave Navarro Signature', 'TypeGuitar.ELECTRIC', '6', 'Wood.MAHOGANY', 'Wood.MAPLE');");
						
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
			
			JLabel lblNewLabel_1 = new JLabel("New label");
			lblNewLabel_1.setEnabled(false);
			lblNewLabel_1.setBounds(24, 10, 665, 394);
			contentPane.add(lblNewLabel_1);
			
			JButton btnNewButton = new JButton("View all instrument");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					lblNewLabel_1.setVisible(true);
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
			btnNewButton.setBounds(292, 176, 148, 43);
			contentPane.add(btnNewButton);
			
			JButton btnNewButton_1 = new JButton("Search instrument");
			btnNewButton_1.setBounds(292, 243, 148, 43);
			contentPane.add(btnNewButton_1);
			
			JLabel lblNewLabel = new JLabel("New label");
			lblNewLabel.setIcon(new ImageIcon(FindGuitarTester.class.getResource("/res/store_inside.jpg")));
			lblNewLabel.setBackground(Color.BLACK);
			lblNewLabel.setBounds(0, 0, 730, 431);
			contentPane.add(lblNewLabel);
			
			
		}
	}




