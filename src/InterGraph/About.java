package InterGraph;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Rectangle;

import javax.swing.JDialog;
import java.awt.Dimension;

public class About extends JDialog {

	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;
	private JLabel L1 = null;
	private JLabel l2 = null;
	private JLabel l3 = null;
	private JLabel L4 = null;
	/**
	 * @param owner
	 */
	public About(Frame owner) {
		super(owner);
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(375, 196);
		this.setTitle("A propos");
		this.setContentPane(getJContentPane());
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			L4 = new JLabel();
			L4.setBounds(new Rectangle(10, 60, 184, 16));
			L4.setFont(new Font("Georgia", Font.BOLD, 12));
			L4.setText("Travail réalisé par: Abdellilah");
			l3 = new JLabel();
			l3.setBounds(new Rectangle(17, 136, 325, 16));
			l3.setFont(new Font("Georgia", Font.BOLD, 12));
		
			l2 = new JLabel();
			l2.setBounds(new Rectangle(14, 100, 95, 16));
			l2.setFont(new Font("Georgia", Font.BOLD, 12));
			l2.setText("Version: 1.0");
			L1 = new JLabel();
			L1.setBounds(new Rectangle(48, 15, 267, 24));
			L1.setHorizontalAlignment(SwingConstants.CENTER);
			L1.setHorizontalTextPosition(SwingConstants.CENTER);
			L1.setFont(new Font("Georgia", Font.BOLD, 18));
			L1.setForeground(new Color(102, 102, 102));
			L1.setText("Gestionderenscription");
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.setBackground(Color.lightGray);
			jContentPane.add(L1, null);
			jContentPane.add(l2, null);
			jContentPane.add(l3, null);
			jContentPane.add(L4, null);
		}
		return jContentPane;
	}

}  //  @jve:decl-index=0:visual-constraint="10,10"
