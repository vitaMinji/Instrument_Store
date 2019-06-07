import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class MainStore extends JFrame {

	private JPanel contentPane;

	/**
	 * 
	 * Launch the application.
	 */
	

	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainStore frame = new MainStore();
					frame.setVisible(true);
					try {
						Class.forName("com.mysql.cj.jdbc.Driver");
						Connection conn=null;
						conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sampledb?serverTimezone=Asia/Seoul","root","7202");
						conn.close();
						
					} catch(ClassNotFoundException e) {
						System.out.println("JDBC 드라이버 로드 에러");
					} 
					catch(SQLException e) {
						System.out.println("DB연결에러");
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainStore() {
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
			}
		});
		btnNewButton.setBounds(292, 176, 148, 43);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Search instrument");
		btnNewButton_1.setBounds(292, 243, 148, 43);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(MainStore.class.getResource("/res/store_inside.jpg")));
		lblNewLabel.setBackground(Color.BLACK);
		lblNewLabel.setBounds(0, 0, 730, 431);
		contentPane.add(lblNewLabel);
		
		
	}
}
