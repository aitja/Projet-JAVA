package InterGraph;

import Ressources.Cours;
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

public class ShowCours extends JFrame {
	private static final long serialVersionUID = 1L;
	private JScrollPane jScrollPane = null;
	private JTable jTable = null;
	
	private Main fen;
	private Object[][] data;
	private JMenuBar jJMenuBar = null;
	private JMenu jMenu = null;
	private JMenuItem allItem = null;
	private JMenuItem dispoItem = null;
	private JMenuItem completItem = null;
	
	/**
	 * This is the default constructor
	 */
	public ShowCours() {
		super();
		initialize();
	}

	public ShowCours(Main f) {
		super();
		fen=f;
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
		this.setTitle("Affichage des cours");
		
		//Afficher des lignes de couleurs différentes
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
			jMenu.add(getAllItem());
			jMenu.add(getDispoItem());
			jMenu.add(getCompletItem());
		}
		return jMenu;
	}

	/**
	 * This method initializes allItem	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getAllItem() {
		if (allItem == null) {
			allItem = new JMenuItem();
			allItem.setText("Tous les cours");
			allItem.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					data=new Object[fen.getEnsCours().size()][6];
					int i=0;
					for(Cours c:fen.getEnsCours())
					{
						data[i][0]=c.getCode();
						data[i][1]=c.getIntitule();
						data[i][2]=c.getDesc();
						data[i][3]=c.getCof();
						data[i][4]=c.getNbI();
						data[i][5]=c.getEtat();
						i++;
					}
					MyTableModel model=new MyTableModel(data);
					jTable.setModel(model);
				}
			});
		}
		return allItem;
	}

	/**
	 * This method initializes dispoItem	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getDispoItem() {
		if (dispoItem == null) {
			dispoItem = new JMenuItem();
			dispoItem.setText("Les cours disponibles");
			dispoItem.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					data=new Object[fen.getEnsCours().size()][6];
					int i=0;
					for(Cours c:fen.getEnsCours())
					{
						if(c.getNbI()<10)
						{	
							data[i][0]=c.getCode();
							data[i][1]=c.getIntitule();
							data[i][2]=c.getDesc();
							data[i][3]=c.getCof();
							data[i][4]=c.getNbI();
							data[i][5]=c.getEtat();
							i++;
						}
					}
					MyTableModel model=new MyTableModel(data);
					jTable.setModel(model);
				}
			});
		}
		return dispoItem;
	}

	/**
	 * This method initializes completItem	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getCompletItem() {
		if (completItem == null) {
			completItem = new JMenuItem();
			completItem.setText("Les cours complets");
			completItem.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					data=new Object[fen.getEnsCours().size()][6];
					int i=0;
					for(Cours c:fen.getEnsCours())
					{
						if(c.getNbI()==10)
						{	
							data[i][0]=c.getCode();
							data[i][1]=c.getIntitule();
							data[i][2]=c.getDesc();
							data[i][3]=c.getCof();
							data[i][4]=c.getNbI();
							data[i][5]=c.getEtat();
							i++;
						}
					}
					MyTableModel model=new MyTableModel(data);
					jTable.setModel(model);
				}
			});
		}
		return completItem;
	}

	public class  MyTableModel extends AbstractTableModel {
		private String[] columnNames ={"Code","Intitulé","Description",
				"Coefficient","Nombre d'inscrits","Etat"};
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
