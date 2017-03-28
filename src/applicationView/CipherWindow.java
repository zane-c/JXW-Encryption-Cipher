package applicationView;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.*;

import cipher.Cipher;

public class CipherWindow {

	/**
	 * Declaration of class instance variables.
	 */
	private JFrame frame;

	private Cipher cipher = new Cipher();


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CipherWindow window = new CipherWindow();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});


	}


	/**
	 * Create the application.
	 */
	public CipherWindow() {
		initialize();
	}


	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(
				"D:\\zaned\\Downloads\\security_lock_password_protection_secure_locking_system_safe_privacy_private_safety_encryption_flat_design_icon-512.png"));
		frame.setTitle("Ciphertext Translator");
		frame.getContentPane().setFont(new Font("Georgia", Font.PLAIN, 20));
		frame.getContentPane().setBackground(new Color(0, 0, 0));
		frame.setBounds(100, 100, 758, 475);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setResizable(false);

		JButton encryptButton = new JButton("Encrypt");
		encryptButton.setForeground(Color.WHITE);
		encryptButton.setBackground(Color.BLACK);
		encryptButton.setFont(new Font("Georgia", Font.PLAIN, 11));
		encryptButton.setIcon(null);
		encryptButton.setBounds(183, 243, 89, 23);
		frame.getContentPane().add(encryptButton);


		JButton decryptButton = new JButton("Decrypt");
		decryptButton.setForeground(Color.WHITE);
		decryptButton.setBackground(Color.BLACK);
		decryptButton.setFont(new Font("Georgia", Font.PLAIN, 11));
		decryptButton.setBounds(282, 243, 89, 23);
		frame.getContentPane().add(decryptButton);

		JLabel lblCipher_1 = new JLabel("JXW Encryption");
		lblCipher_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblCipher_1.setForeground(Color.WHITE);
		lblCipher_1.setFont(new Font("Georgia", Font.PLAIN, 20));
		lblCipher_1.setBounds(282, 11, 188, 40);
		frame.getContentPane().add(lblCipher_1);

		JEditorPane enterField = new JEditorPane();
		enterField.setBorder(new LineBorder(new Color(255, 255, 255)));
		enterField.setText("\r\n");
		enterField.setFont(new Font("Georgia", Font.PLAIN, 15));
		enterField.setForeground(new Color(255, 255, 255));
		enterField.setBackground(new Color(0, 0, 0));
		enterField.setBounds(10, 53, 732, 179);
		enterField.setBackground(null);
		frame.getContentPane().add(enterField);

		JEditorPane exportField = new JEditorPane();
		exportField.setForeground(Color.WHITE);
		exportField.setFont(new Font("Georgia", Font.PLAIN, 15));
		exportField.setBackground(Color.BLACK);
		exportField.setBounds(10, 282, 732, 153);
		frame.getContentPane().add(exportField);

		JButton swapButton = new JButton("Swap");
		swapButton.setForeground(Color.WHITE);
		swapButton.setFont(new Font("Georgia", Font.PLAIN, 11));
		swapButton.setBackground(Color.BLACK);
		swapButton.setBounds(381, 243, 89, 23);
		frame.getContentPane().add(swapButton);

		JButton clearButton = new JButton("Clear");
		clearButton.setForeground(Color.WHITE);
		clearButton.setFont(new Font("Georgia", Font.PLAIN, 11));
		clearButton.setBackground(Color.BLACK);
		clearButton.setBounds(480, 243, 89, 23);
		frame.getContentPane().add(clearButton);


		encryptButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				exportField.setText(cipher.encrypt(enterField.getText()));

			}
		});

		decryptButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				exportField.setText(cipher.decrypt(enterField.getText()));

			}
		});

		swapButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				enterField.setText(exportField.getText());
			}
		});

		clearButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				enterField.setText(null);
				exportField.setText(null);
			}
		});
	}


}
