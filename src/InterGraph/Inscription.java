package InterGraph;


import java.awt.Rectangle;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JTextField;

import Exceptions.InsciptionImpossible;
import Ressources.Cours;
import Ressources.Etudiant;

import java.awt.Toolkit;

public class Inscription extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;
	private JLabel l1 = null;
	private JLabel l2 = null;
	private JTextField txtIdC = null;
	private JTextField txtIdE = null;
	private JButton BInscrire = null;

	private Main MainF;

	/**
	 * This is the default constructor
	 */
	public Inscription() {
		super();
		initialize();
	}


	public Inscription(Main f) {
		super();
		MainF=f;
		initialize();
	}
	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(295, 155);
		this.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/abdo.jpg")));
		this.setContentPane(getJContentPane());
		this.setTitle("Inscription d'un �tudiant");
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			l2 = new JLabel();
			l2.setBounds(new Rectangle(10, 50, 125, 16));
			l2.setText("Identifiant �tudiant:");
			l1 = new JLabel();
			l1.setBounds(new Rectangle(10, 10, 125, 16));
			l1.setText("Code Cours");
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.add(l1, null);
			jContentPane.add(l2, null);
			jContentPane.add(getTxtIdC(), null);
			jContentPane.add(getTxtIdE(), null);
			jContentPane.add(getBInscrire(), null);
		}
		return jContentPane;
	}

	/**
	 * This method initializes txtIdC	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getTxtIdC() {
		if (txtIdC == null) {
			txtIdC = new JTextField();
			txtIdC.setBounds(new Rectangle(140, 10, 125, 16));
		}
		return txtIdC;
	}

	/**
	 * This method initializes txtIdE	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getTxtIdE() {
		if (txtIdE == null) {
			txtIdE = new JTextField();
			txtIdE.setBounds(new Rectangle(140, 50, 125, 16));
		}
		return txtIdE;
	}

	/**
	 * This method initializes BInscrire	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getBInscrire() {
		if (BInscrire == null) {
			BInscrire = new JButton();
			BInscrire.setBounds(new Rectangle(90, 90, 100, 16));
			BInscrire.setText("Inscrire");
			BInscrire.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					try
					{
						int idE=Integer.parseInt(txtIdE.getText());
						int idC=Integer.parseInt(txtIdC.getText());
						
						Etudiant et=null;
						for(Etudiant etu: MainF.getEnsEtudiant())
							if(etu.getId()==idE)
								et=etu;
						
						Cours cour=null;
						for(Cours c: MainF.getEnsCours())
							if(c.getCode()==idC)
								cour=c;
						
						try
						{
							if(cour!=null && et!=null)
							{	
								et.inscrire(cour);
								JOptionPane.showMessageDialog(null, "Inscription r�ussie");
								txtIdC.setText("");
								txtIdE.setText("");
							}
							else
								if(cour==null)
									JOptionPane.showMessageDialog(null, "Ce cours n'�xiste pas");
								else
									JOptionPane.showMessageDialog(null, "Cet �tudiant n'�xiste pas");
						}catch(InsciptionImpossible er1)
						{
							JOptionPane.showMessageDialog(null, er1.getMessage());
						}
					}catch(NumberFormatException er)
					{
						JOptionPane.showMessageDialog(null, "Verifiez que les champs sont entiers");
					}
					
				}
			});
		}
		return BInscrire;
	}
}
