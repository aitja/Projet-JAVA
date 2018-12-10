package Ressources;

import java.util.ArrayList;
import java.util.StringTokenizer;
import java.io.Serializable;

import Exceptions.ErreurDate;
import Exceptions.ErreurTelephone;
import Exceptions.InsciptionImpossible;
import Exceptions.DesinscriptionImpossible;

public class Etudiant implements Comparable<Etudiant>, Serializable {

	private int id;
	private String nom,prenom,dateN,adresse,tel;
	ArrayList<Cours> courI;
	
	public Etudiant(int id,  String nom,String prenom, String dateN,
			String adresse,String tel) throws ErreurDate,ErreurTelephone 
	{
		//traiter exeption date
		StringTokenizer st= new StringTokenizer(dateN,"/");
		String sa="";
		String sm="";
		String sj="";
		int j,m,a,compteur=0;
		
		while(st.hasMoreTokens())
		{
			compteur++;
			if(compteur==1) //1er itération
				sj=st.nextToken();
			if(compteur==2) //2em itération
				sm=st.nextToken();
			if(compteur==3) //3em itération
				sa=st.nextToken();
		}
		
		if(sj.length()!=2||sm.length()!=2|| sa.length()!=4)
			throw new ErreurDate("La date ne respecte pas le format jj/mm/aaaa");
		
		try{
			j=Integer.parseInt(sj);
			if(j<1||j>31)
				throw new ErreurDate("Le jour n'est pas compris entre 1 et 31");
		}
		catch(NumberFormatException e)
		{
			throw new ErreurDate("Le jour n'est pas de type numérique");
		}
		
		try{
			m=Integer.parseInt(sm);
			if(m<1||m>12)
				throw new ErreurDate("Le mois n'est pas compris entre 1 et 12");
		}
		catch(NumberFormatException e)
		{
			throw new ErreurDate("Le mois n'est pas de type numérique");
		}
		
		try{
			a=Integer.parseInt(sa);
			if(a<1975||a>2009)
				throw new ErreurDate("L'année n'est pas comprise entre 1975 et 2009");
		}
		catch(NumberFormatException e)
		{
			throw new ErreurDate("L'anneée n'est pas de type numérique");
		}
		
		//traiter exceptions téléphone
		StringTokenizer st1= new StringTokenizer(tel,"-");
		String n1="",n2="",n3="",n4="";
		int a1,a2,a3,a4;
		compteur=0;
		while(st1.hasMoreTokens())
		{
			compteur++;
			if(compteur==1)
				n1=st1.nextToken();
			if(compteur==2)
				n2=st1.nextToken();
			if(compteur==3)
				n3=st1.nextToken();
			if(compteur==4)
				n4=st1.nextToken();
		}
		
		if(n1.length()!=3||n2.length()!=2|| n3.length()!=2 || n4.length()!=2)
			throw new ErreurTelephone("Le numéro de téléphone ne respecte pas le format xxx-xx-xx-xx Ex:654-59-85-16");
		
		try{
			a1=Integer.parseInt(n1);
			
			a2=Integer.parseInt(n2);
			a3=Integer.parseInt(n3);
			a4=Integer.parseInt(n4);
		}catch(NumberFormatException e)
		{
			throw new ErreurTelephone("Tous les champs doivent être des entiers");
		}
		
		this.adresse = adresse;
		this.dateN = dateN;
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.tel = tel;
		courI=new ArrayList<Cours> ();
		
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adr) {
		this.adresse = adr;
	}
	
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	
	public String getDateN() {
		return dateN;
	}
	public void setDateN(String dn) {
		this.dateN = dn;
	}

	public ArrayList<Cours> getCours() {
		return courI;
	}
	public void setCode(ArrayList<Cours> courI) {
		this.courI = courI;
	}
	
	@Override
	public boolean equals(Object arg0) {
		Etudiant e=(Etudiant)arg0;
		return id==e.id;
	}
	public void inscrire(Cours c)throws InsciptionImpossible{
		if(courI.size()==4)
			throw new InsciptionImpossible("Cet étudiant a atteint le nombre de cours autorisés");
		if(courI.contains(c))
			throw new InsciptionImpossible("Cet étudiant est déjà inscrit dans ce cours");
		if(c.getEtat()==EtatCours.FERME)
			throw new InsciptionImpossible("Ce cours est complet");
		
		c.setNbI(c.getNbI()+1);
		courI.add(c);
		if(c.getNbI()==10)
			c.setEtat(EtatCours.FERME);
	}
	public void desincrire(Cours c)throws DesinscriptionImpossible 
	{
		if(!courI.contains(c))
			throw new DesinscriptionImpossible("Cet étudiant n'est pas inscrit dans ce cours");
		
		c.setNbI(c.getNbI()-1);
		courI.remove(c);
		if(c.getNbI()==9)
			c.setEtat(EtatCours.OUVERT);
	}
	
	public int compareTo(Etudiant e1) {
		if(id<e1.id)
			return -1;
		else
			if(id==e1.id)
				return 0;
			else
				return 1;
	}

}
