package Ressources;

import java.io.Serializable;

public class Cours implements Serializable{
	private int code,cof,nbI;
	private String intitule,desc;
	private EtatCours etat;
	
	public Cours(int c,int co,String i,String d )
	{
		code=c;
		cof=co;
		intitule=i;
		desc=d;
		nbI=0;
		etat=EtatCours.OUVERT;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public int getCof() {
		return cof;
	}

	public void setCof(int cof) {
		this.cof = cof;
	}

	public int getNbI() {
		return nbI;
	}

	public void setNbI(int nbI) {
		this.nbI = nbI;
	}

	public String getIntitule() {
		return intitule;
	}

	public void setIntitule(String intitule) {
		this.intitule = intitule;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public EtatCours getEtat() {
		return etat;
	}

	public void setEtat(EtatCours etat) {
		this.etat = etat;
	}

	@Override
	public boolean equals(Object arg0) {
		Cours c=(Cours)arg0;
		return code==c.code;
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return code%10;
	}
}

