package InterGraph;


import java.awt.Rectangle;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import java.awt.Toolkit;

public class Connexion extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;
	private JLabel l1 = null;
	private JLabel l2 = null;
	private JButton bConnect = null;
	private JTextField txtLog = null;
	private JPasswordField pass = null;

	/**
	 * This is the default constructor
	 */
	public Connexion() {
		super();
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(280, 170);
		this.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/abdo.jpg")));
		this.setContentPane(getJContentPane());
		this.setTitle("Connexion");
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			l2 = new JLabel();
			l2.setBounds(new Rectangle(20,60,100,20));
			l2.setText("Password:");
			l1 = new JLabel();
			l1.setBounds(new Rectangle(20,20,100,20));
			l1.setText("Login:");
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.add(l1, null);
			jContentPane.add(l2, null);
			jContentPane.add(getBConnect(), null);
			jContentPane.add(getTxtLog(), null);
			jContentPane.add(getPass(), null);
		}
		return jContentPane;
	}
	/**
	 * This method initializes bConnect	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getBConnect() {
		if (bConnect == null) {
			bConnect = new JButton();
			bConnect.setBounds(new Rectangle(80,100,100,20));
			bConnect.setText("Valider");
			bConnect.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					if(txtLog.getText().equals(new String("admin")))// || txtLog.getText()=="ADMINISTRATEUR")
						if(String.copyValueOf(pass.getPassword()).equals(new String("admin")))
						{
							Main.connecte=true;
							setVisible(false);
						}
						else
							JOptionPane.showMessageDialog(null, "Vérifier le mot de passe Ou Lire Le README Ou vous pouvez me conntacter sur tel : +212654598516 ou  email : abdellilah.aitja@gmail.com");
				}
			});
		}
		return bConnect;
	}

	/**
	 * This method initializes txtLog	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getTxtLog() {
		if (txtLog == null) {
			txtLog = new JTextField();
			txtLog.setBounds(new Rectangle(150,20,100,20));
		}
		return txtLog;
	}

	/**
	 * This method initializes pass	
	 * 	
	 * @return javax.swing.JPasswordField	
	 */
	private JPasswordField getPass() {
		if (pass == null) {
			pass = new JPasswordField();
			pass.setBounds(new Rectangle(150,60,100,20));
			pass.setEchoChar('*');
		}
		return pass;
	}
}
