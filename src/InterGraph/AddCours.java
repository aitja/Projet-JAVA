package InterGraph;

import java.awt.Rectangle;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JTextField;

import java.awt.Toolkit;

import Ressources.Cours;

public class AddCours extends JFrame {

	private static final long serialVersionUID = 1L;
	private JLabel Label1 = null;
	private JLabel Label2 = null;
	private JLabel Label3 = null;
	private JLabel Label4 = null;
	private JButton Ajouter = null;
	private JButton Fermer = null;

	//fenêtre mère
	private Main MenuF;
	private JPanel jContentPane = null;
	private JTextField TxtId = null;
	private JTextField txtNom = null;
	private JTextField txtDesc = null;
	private JTextField txtCoef = null;
	
	/**
	 * This is the default constructor
	 */
	public AddCours() {
		super();
		initialize();
	}

	public AddCours(Main f) {
		super();
		MenuF=f;
		initialize();
	}
	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(290, 240);
		this.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/abdo.jpg")));
		this.setContentPane(getJContentPane());
		this.setTitle("Ajout d'un cours");
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			Label4 = new JLabel();
			Label4.setBounds(new Rectangle(20, 130, 130, 16));
			Label4.setText("Coeficient du cours:");
			
			Label3 = new JLabel();
			Label3.setBounds(new Rectangle(20, 90, 130, 16));
			Label3.setText("Description du cours:");
			
			Label2 = new JLabel();
			Label2.setBounds(new Rectangle(20, 50, 130, 16));
			Label2.setText("Nom du cours:");
			
			Label1 = new JLabel();
			Label1.setBounds(new Rectangle(20, 10, 130, 16));
			Label1.setText("Id cours:");
			
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.add(Label1, null);
			jContentPane.add(Label2, null);
			jContentPane.add(Label3, null);
			jContentPane.add(Label4, null);
			jContentPane.add(getFermer(), null);
			jContentPane.add(getTxtId(), null);
			jContentPane.add(getTxtNom(), null);
			jContentPane.add(getTxtDesc(), null);
			jContentPane.add(getTxtCoef(), null);
			jContentPane.add(getJButton(), null);
		}
		return jContentPane;
	}

	
	private JButton getFermer() {
		if (Fermer == null) {
			Fermer = new JButton();
			Fermer.setBounds(new Rectangle(150
					, 170, 80, 16));
			Fermer.setText("Fermer");
			Fermer.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					setVisible(false);
				}
			});
		}
		return Fermer;
	}
	/**
	 * This method initializes TxtId	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getTxtId() {
		if (TxtId == null) {
			TxtId = new JTextField();
			TxtId.setBounds(new Rectangle(160, 10, 100, 16));
		}
		return TxtId;
	}

	/**
	 * This method initializes txtNom	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getTxtNom() {
		if (txtNom == null) {
			txtNom = new JTextField();
			txtNom.setBounds(new Rectangle(160, 50, 100, 16));
		}
		return txtNom;
	}

	/**
	 * This method initializes txtDesc	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getTxtDesc() {
		if (txtDesc == null) {
			txtDesc = new JTextField();
			txtDesc.setBounds(new Rectangle(160, 90, 100, 16));
		}
		return txtDesc;
	}

	/**
	 * This method initializes txtCoef	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getTxtCoef() {
		if (txtCoef == null) {
			txtCoef = new JTextField();
			txtCoef.setBounds(new Rectangle(160, 130, 100, 16));
		}
		return txtCoef;
	}

	/**
	 * This method initializes jButton	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButton() {
		if (Ajouter == null) {
			Ajouter = new JButton();
			Ajouter.setBounds(new Rectangle(40, 170, 80, 16));
			Ajouter.setText("Ajouter");
			Ajouter.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					int id=0,coef=0; 
					boolean trouve=false;
					if(TxtId.getText().isEmpty())
						JOptionPane.showMessageDialog(null, "Veuillez remplir le champ Id");
					else
						if(txtNom.getText().isEmpty())
							JOptionPane.showMessageDialog(null, "Veuillez remplir le champ Nom");
						else
							if(txtDesc.getText().isEmpty())
								JOptionPane.showMessageDialog(null, "Veuillez remplir le champ Description");
							else
								if(txtCoef.getText().isEmpty())
									JOptionPane.showMessageDialog(null, "Veuillez remplir le champ Coefficient");
								else
								{
									try
									{	
										id= Integer.parseInt(TxtId.getText());
										for(Cours c:MenuF.getEnsCours())
											if(c.getCode()==id)
												trouve=true;
										if(trouve==false)
										{
											try
											{	
												coef=Integer.parseInt(txtCoef.getText());
												MenuF.getEnsCours().add(new Cours(id,coef,txtNom.getText(),
														txtDesc.getText()));
												JOptionPane.showMessageDialog(null, "Cours Ajouté");
												TxtId.setText("");
												txtNom.setText("");
												txtDesc.setText("");
												txtCoef.setText("");
											}catch(NumberFormatException err)
											{
												JOptionPane.showMessageDialog(null, "Veuillez mettre un entier dans le champ coefficient");
											}
										}
										else
											JOptionPane.showMessageDialog(null,"Il existe déjà un cours avec ce code");
									}catch(NumberFormatException err)
									{
										JOptionPane.showMessageDialog(null, "Veuillez mettre un entier dans le champ id");
									}
								}
				}
			});
		}
		return Ajouter;
	}
}
