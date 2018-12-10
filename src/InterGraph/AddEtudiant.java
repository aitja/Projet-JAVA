package InterGraph;

import java.awt.Rectangle;

import Exceptions.*;

import Ressources.Etudiant;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.Toolkit;

public class AddEtudiant extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;
	private JLabel l1 = null;
	private JLabel l2 = null;
	private JLabel l3 = null;
	private JLabel l4 = null;
	private JLabel l5 = null;
	private JLabel l6 = null;
	private JButton Ajouter = null;
	private JButton Close = null;
	private JTextField txtId = null;
	private JTextField txtNom = null;
	private JTextField txtPrenom = null;
	private JTextField txtDate = null;
	private JTextField txtAdresse = null;
	private JTextField txtTel = null;
	
	private Main MenuF;
	/**
	 * This is the default constructor
	 */
	public AddEtudiant() {
		super();
		initialize();
	}
	
	//cstor avec param de la fenetre main
	public AddEtudiant(Main f) {
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
		this.setSize(300,265);
		this.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/abdo.jpg")));
		this.setContentPane(getJContentPane());
		this.setTitle("Ajout d'un étudiant");
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			l6 = new JLabel();
			l6.setBounds(new Rectangle(20, 160, 130, 16));
			l6.setText("Téléphone:");
			l5 = new JLabel();
			l5.setBounds(new Rectangle(20, 130, 130, 16));
			l5.setText("adresse:");
			l4 = new JLabel();
			l4.setBounds(new Rectangle(20, 100, 130, 16));
			l4.setText("Date naissance:");
			l3 = new JLabel();
			l3.setBounds(new Rectangle(20, 70, 130, 16));
			l3.setText("Prenom:");
			l2 = new JLabel();
			l2.setBounds(new Rectangle(20, 40, 130, 16));
			l2.setText("Nom:");
			l1 = new JLabel();
			l1.setBounds(new Rectangle(20, 10, 130, 16));
			l1.setText("Identifiant");
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.add(l1, null);
			jContentPane.add(l2, null);
			jContentPane.add(l3, null);
			jContentPane.add(l4, null);
			jContentPane.add(l5, null);
			jContentPane.add(l6, null);
			jContentPane.add(getAjouter(), null);
			jContentPane.add(getClose(), null);
			jContentPane.add(getTxtId(), null);
			jContentPane.add(getTxtNom(), null);
			jContentPane.add(getTxtPrenom(), null);
			jContentPane.add(getTxtDate(), null);
			jContentPane.add(getTxtAdresse(), null);
			jContentPane.add(getTxtTel(), null);
		}
		return jContentPane;
	}
	
	
	/**
	 * This method initializes Ajouter	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getAjouter() {
		if (Ajouter == null) {
			Ajouter = new JButton();
			Ajouter.setBounds(new Rectangle(50, 190, 80, 20));
			Ajouter.setText("Ajouter");
			Ajouter.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					int id=0; 
					if(txtId.getText().isEmpty())
						JOptionPane.showMessageDialog(null, "Veuillez remplir le champ Id");
					else
						if(txtNom.getText().isEmpty())
							JOptionPane.showMessageDialog(null, "Veuillez remplir le champ Nom");
						else
							if(txtPrenom.getText().isEmpty())
								JOptionPane.showMessageDialog(null, "Veuillez remplir le champ Prénom");
							else
								if(txtDate.getText().isEmpty())
									JOptionPane.showMessageDialog(null, "Veuillez remplir le champ Date");
								else
									if(txtAdresse.getText().isEmpty())
										JOptionPane.showMessageDialog(null, "Veuillez remplir le champ Adresse");
									else
										if(txtTel.getText().isEmpty())
											JOptionPane.showMessageDialog(null, "Veuillez remplir le champ Téléphone");
										else
										{
											try
											{	
												boolean trouve=false;
												id= Integer.parseInt(txtId.getText());
												for(Etudiant etud:MenuF.getEnsEtudiant())
													if(etud.getId()==id)
														trouve=true;
												
												if(trouve==false)
												{
													try
													{
														MenuF.getEnsEtudiant().add(new Etudiant(id,txtNom.getText(),
														txtPrenom.getText(),txtDate.getText(),txtAdresse.getText(),
														txtTel.getText()));
														JOptionPane.showMessageDialog(null, "étudiant Ajouté");
														//effacer les champs
														txtId.setText("");
														txtNom.setText("");
														txtPrenom.setText("");
														txtDate.setText("");
														txtAdresse.setText("");
														txtTel.setText("");
													}catch(ErreurDate erD)
													{
														JOptionPane.showMessageDialog(null, erD.getMessage());
													} catch (ErreurTelephone erT) {
														JOptionPane.showMessageDialog(null, erT.getMessage());
													}
												}
												else
													JOptionPane.showMessageDialog(null, "Un étudiant existe déjà avec le même identifiant");
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
	/**
	 * This method initializes Close	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getClose() {
		if (Close == null) {
			Close = new JButton();
			Close.setBounds(new Rectangle(150, 190, 80, 20));
			Close.setText("Fermer");
			Close.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					setVisible(false);
				}
			});
		}
		return Close;
	}

	/**
	 * This method initializes txtId	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getTxtId() {
		if (txtId == null) {
			txtId = new JTextField();
			txtId.setBounds(new Rectangle(160, 10, 100, 16));
		}
		return txtId;
	}

	/**
	 * This method initializes txtNom	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getTxtNom() {
		if (txtNom == null) {
			txtNom = new JTextField();
			txtNom.setBounds(new Rectangle(160, 40, 100, 16));
		}
		return txtNom;
	}

	/**
	 * This method initializes txtPrenom	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getTxtPrenom() {
		if (txtPrenom == null) {
			txtPrenom = new JTextField();
			txtPrenom.setBounds(new Rectangle(160, 70, 100, 16));
		}
		return txtPrenom;
	}

	/**
	 * This method initializes txtDate	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getTxtDate() {
		if (txtDate == null) {
			txtDate = new JTextField();
			txtDate.setBounds(new Rectangle(160, 100, 100, 16));
		}
		return txtDate;
	}

	/**
	 * This method initializes txtAdresse	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getTxtAdresse() {
		if (txtAdresse == null) {
			txtAdresse = new JTextField();
			txtAdresse.setBounds(new Rectangle(160, 130, 100, 16));
		}
		return txtAdresse;
	}

	/**
	 * This method initializes txtTel	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getTxtTel() {
		if (txtTel == null) {
			txtTel = new JTextField();
			txtTel.setBounds(new Rectangle(160, 160, 100, 16));
		}
		return txtTel;
	}

}
