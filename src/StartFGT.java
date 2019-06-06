

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class StartFGT extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StartFGT frame = new StartFGT();
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
	public StartFGT() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 640, 495);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnIn = new JButton("GO IN");
		btnIn.setFont(new Font("굴림", Font.PLAIN, 18));
		btnIn.setBounds(255, 332, 117, 36);
		contentPane.add(btnIn);
		//버튼 액션리스너
		btnIn.addActionListener(new ActionListener(){
			 public void actionPerformed(ActionEvent e) {
			//넘어가기
				dispose();
				MainStore ms = new MainStore();
				ms.setVisible(true);
			}
		});
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(StartFGT.class.getResource("/res/store_outside.jpg")));
		lblNewLabel.setBounds(0, 0, 624, 456);
		contentPane.add(lblNewLabel);
	}
}
