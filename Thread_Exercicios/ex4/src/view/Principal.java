package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.ButtonController;

import javax.swing.JLabel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.Font;

@SuppressWarnings("serial")
public class Principal extends JFrame {

	private JPanel contentPane;
	public static JTextField txtVencedor, txtPerdedor;

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
		setBounds(100, 100, 562, 308);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCarro1 = new JLabel("CARRO 1");
		lblCarro1.setForeground(Color.BLUE);
		lblCarro1.setBounds(20, 59, 54, 22);
		contentPane.add(lblCarro1);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 92, 526, 2);
		contentPane.add(separator);
		
		JLabel lblCarro2 = new JLabel("CARRO 2");
		lblCarro2.setForeground(Color.RED);
		lblCarro2.setBounds(20, 105, 54, 22);
		contentPane.add(lblCarro2);
		
		JLabel lblVencedor = new JLabel("Vencedor:");
		lblVencedor.setBounds(181, 167, 63, 14);
		contentPane.add(lblVencedor);
		
		JLabel lblPerdedor = new JLabel("Perdedor:");
		lblPerdedor.setBounds(181, 195, 63, 14);
		contentPane.add(lblPerdedor);
		
		txtVencedor = new JTextField();
		txtVencedor.setEditable(false);
		txtVencedor.setBounds(247, 164, 86, 20);
		contentPane.add(txtVencedor);
		txtVencedor.setColumns(10);
		
		txtPerdedor = new JTextField();
		txtPerdedor.setEditable(false);
		txtPerdedor.setBounds(247, 192, 86, 20);
		contentPane.add(txtPerdedor);
		txtPerdedor.setColumns(10);
		
		JButton btnCorrer = new JButton("Correr");
		btnCorrer.setBounds(223, 220, 89, 23);
		contentPane.add(btnCorrer);
		ButtonController button = new ButtonController(lblCarro1, lblCarro2);
		
		JLabel lblCorridaDeCarros = new JLabel("CORRIDA DE CARROS");
		lblCorridaDeCarros.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCorridaDeCarros.setHorizontalAlignment(SwingConstants.CENTER);
		lblCorridaDeCarros.setBounds(10, 11, 526, 22);
		contentPane.add(lblCorridaDeCarros);
		btnCorrer.addActionListener(button);
	}
}
