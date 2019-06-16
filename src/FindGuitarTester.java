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
import java.awt.Font;


public class FindGuitarTester extends JFrame {

		private JPanel contentPane;
		private JTextField textField;
		static Inventory inventory = new Inventory();

		public static void main(String[] args) {
		inventory.addGuitar("delete from guitar");
		initializeInventory(inventory);
		}
			
		private static void initializeInventory(Inventory inventory) {
		
			inventory.addGuitar("insert into guitar (serialNumber, price, builder, model, type, numString, backWood, topWood) values('11277', '3999.95', 'COLLINGS','CJ','ELECTRIC','6','INDIAN_ROSEWOOD','SITKA');");
			inventory.addGuitar("insert into guitar (serialNumber, price, builder, model, type, numString, backWood, topWood) values('V95693', '1499.95', 'FENDER','Stratocastor','ELECTRIC','6','ALDER', 'ALDER');");
			inventory.addGuitar("insert into guitar (serialNumber, price, builder, model, type, numString, backWood, topWood) values('V9512', '1549.95', 'FENDER', 'Stratocastor', 'ELECTRIC', '6', 'ALDER', 'ALDER');");
			inventory.addGuitar("insert into guitar (serialNumber, price, builder, model, type, numString, backWood, topWood) values('122784', '5495.95', 'MARTIN','D-18','ACOUSTIC', '6', 'MAHOGANY', 'ADIRONDACK');");
			inventory.addGuitar("insert into guitar (serialNumber, price, builder, model, type, numString, backWood, topWood) values('76531', '6295.95', 'MARTIN', 'OM-28','ACOUSTIC', '6', 'BRAZILIAN_ROSEWOOD', 'ADIRONDACK');");
			inventory.addGuitar("insert into guitar (serialNumber, price, builder, model, type, numString, backWood, topWood) values('70108276', '2295.95', 'GIBSON', 'Les Paul', 'ELECTRIC','6', 'MAHOGANY', 'MAHOGANY');");
			inventory.addGuitar("insert into guitar (serialNumber, price, builder, model, type, numString, backWood, topWood) values('82765501', '1890.95', 'GIBSON', 'SG 61 Reissue', 'ELECTRIC', '6',' MAHOGANY', 'MAHOGANY');");
			inventory.addGuitar("insert into guitar (serialNumber, price, builder, model, type, numString, backWood, topWood) values('77023', '6275.95', 'MARTIN', 'D-28', 'ACOUSTIC', '6', 'BRAZILIAN_ROSEWOOD', 'ADIRONDACK');");
			inventory.addGuitar("insert into guitar (serialNumber, price, builder, model, type, numString, backWood, topWood) values('1092', '12995.95', 'OLSON', 'SJ', 'ACOUSTIC', '12', 'INDIAN_ROSEWOOD', 'CEDAR');");
			inventory.addGuitar("insert into guitar (serialNumber, price, builder, model, type, numString, backWood, topWood) values('566-62', '8999.95', 'RYAN', 'Cathedral', 'ACOUSTIC',' 12', 'COCOBOLO', 'CEDAR');");
			inventory.addGuitar("insert into guitar (serialNumber, price, builder, model, type, numString, backWood, topWood) values('6 29584', '2100.95', 'PRS', 'Dave Navarro Signature', 'ELECTRIC', '6', 'MAHOGANY', 'MAPLE');");
						
				  			
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
			
			JPanel ifNoGuitar = new JPanel();
			ifNoGuitar.setBounds(0, 0, 706, 411);
			ifNoGuitar.setVisible(false);
			
			JPanel ifYesGuitar = new JPanel();
			ifYesGuitar.setBounds(0, 0, 706, 411);
			ifYesGuitar.setVisible(false);
			panel_1.add(ifYesGuitar);
			ifYesGuitar.setBackground(Color.ORANGE);
			ifYesGuitar.setLayout(null);
			
			JLabel lblNewLabel_4 = new JLabel("New label");
			lblNewLabel_4.setIcon(new ImageIcon(FindGuitarTester.class.getResource("/res/yes.png")));
			lblNewLabel_4.setBounds(12, 37, 247, 364);
			ifYesGuitar.add(lblNewLabel_4);
			panel_1.add(ifNoGuitar);
			ifNoGuitar.setBackground(Color.PINK);
			ifNoGuitar.setLayout(null);
			
			JLabel lblNewLabel_2 = new JLabel("Sorry! we don't have nothing for you");
			lblNewLabel_2.setIcon(new ImageIcon(FindGuitarTester.class.getResource("/res/sorry.png")));
			lblNewLabel_2.setBounds(-295, -57, 839, 677);
			ifNoGuitar.add(lblNewLabel_2);
			
			JLabel lblNewLabel_3 = new JLabel("Sorry! we have nothing for you!");
			lblNewLabel_3.setFont(new Font("굴림", Font.BOLD, 16));
			lblNewLabel_3.setBounds(366, 163, 265, 48);
			ifNoGuitar.add(lblNewLabel_3);
			
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
			
			
			//고객이 원하는 제품 
			GuitarSpec costumerLikes=new GuitarSpec(Builder.FENDER, " ", 
                    TypeGuitar.ACOUSTIC, 6, Wood.INDIAN_ROSEWOOD, Wood.INDIAN_ROSEWOOD); 
			
			
			
			JComboBox builderJCB = new JComboBox();
			builderJCB.setModel(new DefaultComboBoxModel(Builder.values()));
		
			builderJCB.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e) {
					//model 초기화
					costumerLikes.setBuilder((Builder) builderJCB.getSelectedItem());
				}
			});
			
			builderJCB.setBounds(218, 65, 101, 21);
			panel_1.add(builderJCB);
			
			JTextField modelText = new JTextField();
			modelText.setBounds(218, 107, 101, 21);
			panel_1.add(modelText);
			modelText.setColumns(10);
			
			
			JComboBox typeJCB = new JComboBox();
			typeJCB.setModel(new DefaultComboBoxModel(TypeGuitar.values()));
			
			
			typeJCB.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e) {
					
					costumerLikes.setType((TypeGuitar) typeJCB.getSelectedItem());
				}
			});
			
			typeJCB.setBounds(218, 153, 101, 21);
			panel_1.add(typeJCB);
			
			JComboBox numStringJCB = new JComboBox();
			numStringJCB.setModel(new DefaultComboBoxModel(new String[] {"6", "12"}));
			
			
			numStringJCB.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e) {
					costumerLikes.setNumStrings(Integer.valueOf(numStringJCB.getSelectedItem().toString()));
				}
			});
			
			
			numStringJCB.setBounds(218, 194, 101, 21);
			panel_1.add(numStringJCB);
			
			JComboBox backWoodJCB = new JComboBox();
			backWoodJCB.setModel(new DefaultComboBoxModel(Wood.values()));
			
			backWoodJCB.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e) {
					costumerLikes.setBackWood((Wood)backWoodJCB.getSelectedItem());
					//search 메소드에 바로 보내버리자.
				}
			});
			backWoodJCB.setBounds(218, 235, 101, 21);
			panel_1.add(backWoodJCB);
			
			JComboBox topWoodJCB = new JComboBox();
			topWoodJCB.setModel(new DefaultComboBoxModel(Wood.values()));
			
			topWoodJCB.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e) {
					costumerLikes.setTopWood((Wood)topWoodJCB.getSelectedItem());
					//search 메소드에 바로 보내버리자.
					
				}
			});
			topWoodJCB.setBounds(218, 273, 101, 21);
			panel_1.add(topWoodJCB);
			
			JButton searchBtn = new JButton("Search");
			searchBtn.setBounds(271, 335, 184, 42);
			
			
			//검색 버튼 눌렀을때
			
			searchBtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					
					costumerLikes.setModel(modelText.getText());
					List matchingGuitars = inventory.search(costumerLikes);
				
					if (!matchingGuitars.isEmpty()) {
					System.out.println("Erin, you might like these guitars:");
					for (Iterator i = matchingGuitars.iterator(); i.hasNext();){
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
						      ifNoGuitar.setVisible(true);
//						      searchBtn.setVisible(false);
						    }
					
				}
			});
			
			
			panel_1.add(searchBtn);
			panel_1.setVisible(false);
			contentPane.add(panel);
			
			JButton viewAllbtn = new JButton("View all instrument");
			viewAllbtn.setBounds(292, 176, 148, 43);
			contentPane.add(viewAllbtn);
			
			JButton btnNewButton_1 = new JButton("Search instrument");
			btnNewButton_1.setBounds(292, 243, 148, 43);
			contentPane.add(btnNewButton_1);
			
			viewAllbtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					panel.setVisible(true);
					viewAllbtn.setVisible(false);
					btnNewButton_1.setVisible(false);
					
				}
			});
			
			btnNewButton_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					panel_1.setVisible(true);
					viewAllbtn.setVisible(false);
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




