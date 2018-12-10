package InterGraph;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;

import java.awt.Toolkit;
import Ressources.Etudiant;

public class ShowEtudiant extends JFrame {
	private static final long serialVersionUID = 1L;
	private Object[][] data;
	private Main f;
	private JScrollPane jScrollPane = null;
	private JTable jTable = null;
	private JMenuBar jJMenuBar = null;
	private JMenu jMenu = null;
	private JMenuItem allEtud = null;
	private JMenuItem etudCour = null;
	/**
	 * This is the default constructor
	 */
	public ShowEtudiant() {
		super();
		initialize();
	}

	public ShowEtudiant(Main fen) {
		super();
		f=fen;
		initialize();
	}
	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(640, 480);
		this.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/abdo.jpg")));
		this.setJMenuBar(getJJMenuBar());
		this.setContentPane(getJScrollPane());
		this.setTitle("Affichage des étudiants");
		jTable.setDefaultRenderer(Object.class, new DefaultTableCellRenderer(){
			public Component getTableCellRendererComponent(
			JTable table,Object value,boolean isSelected,
			boolean hasFocus,int row,int column) {
			setBackground((row%2==0)?Color.LIGHT_GRAY:Color.WHITE);
			return super.getTableCellRendererComponent(
			table,value,isSelected,hasFocus,
			row,column);
			}
			});
	}

	/**
	 * This method initializes jScrollPane	
	 * 	
	 * @return javax.swing.JScrollPane	
	 */
	private JScrollPane getJScrollPane() {
		if (jScrollPane == null) {
			jScrollPane = new JScrollPane();
			jScrollPane.setViewportView(getJTable());
		}
		return jScrollPane;
	}

	/**
	 * This method initializes jTable	
	 * 	
	 * @return javax.swing.JTable	
	 */
	private JTable getJTable() {
		if (jTable == null) {
			jTable = new JTable();
		}
		return jTable;
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
			jJMenuBar.add(getJMenu());
		}
		return jJMenuBar;
	}

	/**
	 * This method initializes jMenu	
	 * 	
	 * @return javax.swing.JMenu	
	 */
	private JMenu getJMenu() {
		if (jMenu == null) {
			jMenu = new JMenu();
			jMenu.setText("Affichage");
			jMenu.add(getAllEtud());
			jMenu.add(getEtudCour());
		}
		return jMenu;
	}

	/**
	 * This method initializes allEtud	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getAllEtud() {
		if (allEtud == null) {
			allEtud = new JMenuItem();
			allEtud.setText("Tous les étudiants");
			allEtud.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					data=new Object[f.getEnsEtudiant().size()][6];
					int i=0;
					for(Etudiant et:f.getEnsEtudiant())
					{
						data[i][0]=et.getId();
						data[i][1]=et.getNom();
						data[i][2]=et.getPrenom();
						data[i][3]=et.getAdresse();
						data[i][4]=et.getDateN();
						data[i][5]=et.getTel();
						i++;
					}
					MyTableModel model=new MyTableModel(data);
					jTable.setModel(model);
				}
			});
		}
		return allEtud;
	}

	/**
	 * This method initializes etudCour	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getEtudCour() {
		if (etudCour == null) {
			etudCour = new JMenuItem();
			etudCour.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					
				}
			});
		}
		return etudCour;
	}
	
	
	public class  MyTableModel extends AbstractTableModel {
		private String[] columnNames ={"Identifiant","Nom","Prénom",
				"Adresse","Date de naissance","Téléphone"};
		private Object[][] data;
		public MyTableModel(Object[][] d)
		{
			data=d;
		}
		
		public int getColumnCount() {
			return columnNames.length;
		}
		
		public int getRowCount() {
			// TODO Auto-generated method stub
			return data.length;
		}

		public String getColumnName(int col) {
			return columnNames[col];
		}
		public Object getValueAt(int row, int col) {
			return data[row][col];
		}
	}
}
