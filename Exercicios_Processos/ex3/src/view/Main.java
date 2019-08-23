package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.CancelController;
import controller.ExecuteController;
import controller.SelectController;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.ImageIcon;

@SuppressWarnings("serial")
public class Main extends JFrame {

	private JPanel contentPane;
	private JTextField txtProcedimento;
	private JButton btnOk = new JButton("OK");
	private JButton btnCancelar = new JButton("Cancelar");
	private JButton btnProcurar = new JButton("Procurar");
	private final JLabel lblNewLabel = new JLabel("");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
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
	public Main() {
		setResizable(false);
		String os = System.getProperty("os.name");
		setTitle("Executar - " + os);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 418, 175);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblDigiteOCaminho = new JLabel("Digite o caminho do execut\u00E1vel ou clique em procurar");
		lblDigiteOCaminho.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDigiteOCaminho.setBounds(63, 23, 339, 20);
		contentPane.add(lblDigiteOCaminho);
		
		JLabel lblAbrir = new JLabel("Abrir:");
		lblAbrir.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblAbrir.setBounds(46, 64, 46, 14);
		contentPane.add(lblAbrir);
		
		txtProcedimento = new JTextField();
		txtProcedimento.setBounds(102, 63, 300, 20);
		contentPane.add(txtProcedimento);
		txtProcedimento.setColumns(10);
		
		btnOk.setBounds(40, 111, 89, 23);
		contentPane.add(btnOk);
		
		btnCancelar.setBounds(160, 111, 89, 23);
		contentPane.add(btnCancelar);
		
		btnProcurar.setBounds(277, 111, 89, 23);
		contentPane.add(btnProcurar);
		
		ExecuteController execute = new ExecuteController(txtProcedimento);
		CancelController cancel = new CancelController();
		SelectController select = new SelectController(txtProcedimento);
		lblNewLabel.setIcon(new ImageIcon(Main.class.getResource("/com/sun/java/swing/plaf/windows/icons/JavaCup32.png")));
		lblNewLabel.setBounds(10, 9, 32, 43);
		
		contentPane.add(lblNewLabel);
		
		this.btnOk.addActionListener(execute);
		this.btnCancelar.addActionListener(cancel);
		this.btnProcurar.addActionListener(select);
	}
}
