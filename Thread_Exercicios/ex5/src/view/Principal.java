package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.ButtonController;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class Principal extends JFrame {

	private JPanel contentPane;
	public static JTextField txtNumero1;
	public static JTextField txtNumero2;
	public static JTextField txtNumero3;
	public static JButton btnJogar = new JButton("Jogar");


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal frame = new Principal();
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
	public Principal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 389, 208);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtNumero1 = new JTextField();
		txtNumero1.setHorizontalAlignment(SwingConstants.CENTER);
		txtNumero1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		txtNumero1.setEditable(false);
		txtNumero1.setBounds(32, 52, 76, 39);
		contentPane.add(txtNumero1);
		txtNumero1.setColumns(10);
		
		txtNumero2 = new JTextField();
		txtNumero2.setHorizontalAlignment(SwingConstants.CENTER);
		txtNumero2.setFont(new Font("Tahoma", Font.PLAIN, 17));
		txtNumero2.setEditable(false);
		txtNumero2.setColumns(10);
		txtNumero2.setBounds(150, 52, 76, 39);
		contentPane.add(txtNumero2);
		
		txtNumero3 = new JTextField();
		txtNumero3.setHorizontalAlignment(SwingConstants.CENTER);
		txtNumero3.setFont(new Font("Tahoma", Font.PLAIN, 17));
		txtNumero3.setEditable(false);
		txtNumero3.setColumns(10);
		txtNumero3.setBounds(268, 52, 76, 39);
		contentPane.add(txtNumero3);
		
		btnJogar.setBounds(143, 135, 89, 23);
		contentPane.add(btnJogar);
		ButtonController jogar = new ButtonController(txtNumero1, txtNumero2, txtNumero3);
		btnJogar.addActionListener(jogar);
		
		JLabel lblJackpot = new JLabel("JACKPOT");
		lblJackpot.setHorizontalAlignment(SwingConstants.CENTER);
		lblJackpot.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblJackpot.setBounds(10, 11, 353, 30);
		contentPane.add(lblJackpot);
	}
}
