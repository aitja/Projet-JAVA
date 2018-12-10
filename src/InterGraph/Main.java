package InterGraph;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashSet;
import java.util.TreeSet;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import Ressources.Cours;
import Ressources.Etudiant;
import java.awt.Toolkit;

public class Main extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;
	private JMenuBar jJMenuBar = null;
	private JMenu fileM = null;
	private JMenuItem saveItem = null;
	private JMenuItem QuitItem = null;
	private JMenu coursM = null;
	private JMenuItem addCItem = null;
	private JMenuItem showCItem = null;
	private JMenu etudiantM = null;
	private JMenuItem addEItem = null;
	private JMenuItem showEItem = null;
	private JMenuItem suscribeItem = null;
	private JMenuItem describeItem = null;
	private JMenu connectM = null;
	private JMenuItem cnxItem = null;
	private JMenuItem decnxItem = null;
	private JMenu aboutM = null;
	private JMenuItem aboutItem = null;
	public static boolean connecte=false;
	
	//déclaration des ensemble
	private HashSet<Cours> ensCours=new HashSet<Cours>();  
	private TreeSet<Etudiant> ensEtudiant=new TreeSet<Etudiant>();  
	
	//déclaration des fenêtres
	private ShowCours AfficheC=new ShowCours(this);
	private AddCours AjoutC=new AddCours(this);
	private AddEtudiant addE=new AddEtudiant(this);
	private ShowEtudiant AfficheE=new ShowEtudiant(this);
	private Inscription insEtu=new Inscription(this);
	private Desinscription deInsEtu=new Desinscription(this);
	private About ap=new About(this);	
	
	/**
	 * This is the default constructor
	 */
	public Main() {
		super();
		
		// pour charger faire la désérialisation des ensemble
		try {
			ObjectInputStream ois= new ObjectInputStream(new FileInputStream("save.dat"));
			ensCours=(HashSet<Cours>)ois.readObject();
			ensEtudiant=(TreeSet<Etudiant>) ois.readObject();
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		} catch (ClassNotFoundException e3) {
			e3.printStackTrace();
		}
		initialize();
	}

	public HashSet<Cours> getEnsCours() {
		return ensCours;
	}

	public void setEnsCours(HashSet<Cours> ensCours) {
		this.ensCours = ensCours;
	}

	public TreeSet<Etudiant> getEnsEtudiant() {
		return ensEtudiant;
	}

	public void setEnsEtudiant(TreeSet<Etudiant> ensEtudiant) {
		this.ensEtudiant = ensEtudiant;
	}
	
	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(640,480);
		this.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/abdo.jpg")));
		this.setJMenuBar(getJJMenuBar());
		this.setContentPane(getJContentPane());
		this.setTitle("Gestion de Reinsctiption ATJ");
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jContentPane = new JPanel();
			jContentPane.setLayout(new BorderLayout());
		}
		return jContentPane;
	}

	/**
	 * This method initializes jJMenuBar	
	 * 	
	 * @return javax.swing.JMenuBar	
	 */
	private JMenuBar getJJMenuBar() {
		if (jJMenuBar == null) {
			jJMenuBar = new JMenuBar();
			jJMenuBar.setPreferredSize(new Dimension(0, 20));
			jJMenuBar.add(getFileM());
			jJMenuBar.add(getCoursM());
			jJMenuBar.add(getEtudiantM());
			jJMenuBar.add(getConnectM());
			jJMenuBar.add(getAboutM());
		}
		return jJMenuBar;
	}

	/**
	 * This method initializes fileM	
	 * 	
	 * @return javax.swing.JMenu	
	 */
	private JMenu getFileM() {
		if (fileM == null) {
			fileM = new JMenu();
			fileM.setText("Fichier");
			fileM.add(getSaveItem());
			fileM.add(getQuitItem());
		}
		return fileM;
	}

	/**
	 * This method initializes saveItem	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getSaveItem() {
		if (saveItem == null) {
			saveItem = new JMenuItem();
			saveItem.setText("sauvegarder");
			saveItem.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					try {
						ObjectOutputStream oos= new ObjectOutputStream(new FileOutputStream("save.dat"));
						oos.writeObject(ensCours);
						oos.writeObject(ensEtudiant);
						JOptionPane.showMessageDialog(null, "L'enregistrement est términé avec succès");
					} catch (FileNotFoundException e1) {
						e1.printStackTrace();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}
			});
		}
		return saveItem;
	}

	/**
	 * This method initializes QuitItem	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getQuitItem() {
		if (QuitItem == null) {
			QuitItem = new JMenuItem();
			QuitItem.setText("Quitter");
			QuitItem.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					System.exit(NORMAL);
				}
			});
		}
		return QuitItem;
	}

	/**
	 * This method initializes coursM	
	 * 	
	 * @return javax.swing.JMenu	
	 */
	private JMenu getCoursM() {
		if (coursM == null) {
			coursM = new JMenu();
			coursM.setText("Cours");
			coursM.add(getAddCItem());
			coursM.add(getShowCItem());
		}
		return coursM;
	}

	/**
	 * This method initializes addCItem	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getAddCItem() {
		if (addCItem == null) {
			addCItem = new JMenuItem();
			addCItem.setText("Ajouter un cours");
			addCItem.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					if(connecte==true)
					{
						AjoutC.setVisible(true);
					}
					else
						JOptionPane.showMessageDialog(null, "Pour ajouter un cours vous devez être administrateur");
				}
			});
		}
		return addCItem;
	}

	/**
	 * This method initializes showCItem	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getShowCItem() {
		if (showCItem == null) {
			showCItem = new JMenuItem();
			showCItem.setText("Afficher les cours");
			showCItem.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					AfficheC.setVisible(true);
				}
			});
		}
		return showCItem;
	}

	/**
	 * This method initializes etudiantM	
	 * 	
	 * @return javax.swing.JMenu	
	 */
	private JMenu getEtudiantM() {
		if (etudiantM == null) {
			etudiantM = new JMenu();
			etudiantM.setText("Etudiants");
			etudiantM.add(getAddEItem());
			etudiantM.add(getShowEItem());
			etudiantM.add(getSuscribeItem());
			etudiantM.add(getDescribeItem());
		}
		return etudiantM;
	}

	/**
	 * This method initializes addEItem	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getAddEItem() {
		if (addEItem == null) {
			addEItem = new JMenuItem();
			addEItem.setText("Ajouter un étudiant");
			addEItem.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					if(connecte==true)
					{
						addE.setVisible(true);
					}
					else
						JOptionPane.showMessageDialog(null, "Pour ajouter un étudiant vous devez être administrateur");
				}
			});
		}
		return addEItem;
	}

	/**
	 * This method initializes showEItem	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getShowEItem() {
		if (showEItem == null) {
			showEItem = new JMenuItem();
			showEItem.setText("Afficher les étudiants");
			showEItem.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					AfficheE.setVisible(true);
				}
			});
		}
		return showEItem;
	}

	/**
	 * This method initializes suscribeItem	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getSuscribeItem() {
		if (suscribeItem == null) {
			suscribeItem = new JMenuItem();
			suscribeItem.setText("Inscrire un étudiant");
			suscribeItem.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					if(connecte==true)
					{
						insEtu.setVisible(true);
					}else
						JOptionPane.showMessageDialog(null, "Pour inscrire un étudiant vous devez être administrateur");
					
				}
			});
		}
		return suscribeItem;
	}

	/**
	 * This method initializes describeItem	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getDescribeItem() {
		if (describeItem == null) {
			describeItem = new JMenuItem();
			describeItem.setText("Désinscire un étudiant");
			describeItem.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					if(connecte==true)
					{
						deInsEtu.setVisible(true);
					}else
						JOptionPane.showMessageDialog(null, "Pour désinscrire un étudiant vous devez être administrateur");	
				}
			});
		}
		return describeItem;
	}

	/**
	 * This method initializes connectM	
	 * 	
	 * @return javax.swing.JMenu	
	 */
	private JMenu getConnectM() {
		if (connectM == null) {
			connectM = new JMenu();
			connectM.setText("Connexion");
			connectM.add(getCnxItem());
			connectM.add(getDecnxItem());
		}
		return connectM;
	}

	/**
	 * This method initializes cnxItem	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getCnxItem() {
		if (cnxItem == null) {
			cnxItem = new JMenuItem();
			cnxItem.setText("Se connecter");
			cnxItem.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					Connexion cnx=new Connexion();
					cnx.setVisible(true);
				}
			});
		}
		return cnxItem;
	}

	/**
	 * This method initializes decnxItem	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getDecnxItem() {
		if (decnxItem == null) {
			decnxItem = new JMenuItem();
			decnxItem.setText("Se déconnecter");
			decnxItem.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					connecte=false;
				}
			});
		}
		return decnxItem;
	}

	/**
	 * This method initializes aboutM	
	 * 	
	 * @return javax.swing.JMenu	
	 */
	private JMenu getAboutM() {
		if (aboutM == null) {
			aboutM = new JMenu();
			aboutM.setText("A propos");
			aboutM.add(getAboutItem());
		}
		return aboutM;
	}

	/**
	 * This method initializes aboutItem	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getAboutItem() {
		if (aboutItem == null) {
			aboutItem = new JMenuItem();
			aboutItem.setText("A propos de Gestion d'inscription ");
			aboutItem.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					ap.setVisible(true);
				}
			});
		}
		return aboutItem;
	}

	//rendre Main une classe principal
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				Main application = new Main();
				application.setVisible(true);
			}
		});
	}
}
