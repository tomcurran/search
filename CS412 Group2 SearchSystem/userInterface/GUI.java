import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextPane;
import javax.swing.JTextArea;


public class GUI {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI window = new GUI();
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
	public GUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 529, 383);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 16, 1, 345);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JTextPane txtpnSearchGui = new JTextPane();
		txtpnSearchGui.setBounds(171, 4, 169, 20);
		txtpnSearchGui.setText("Search GUI");
	
		frame.getContentPane().add(txtpnSearchGui);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setBounds(347, 2, 117, 29);
		frame.getContentPane().add(btnNewButton);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(448, 52, -267, 257);
		frame.getContentPane().add(textArea);
	}
}