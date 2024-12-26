package modele;

import java.util.ArrayList;
import java.util.Objects;

public class Artiste {
	
	private String nom;
	private final ArrayList<Spectacle> mesSpectacles = new ArrayList<Spectacle>();

	public Artiste(String nom)
	{
		this.nom = nom;
		
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public ArrayList<Spectacle> getMesSpectaples() {
		return mesSpectacles;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Artiste other = (Artiste) obj;
		return Objects.equals(nom, other.nom);
	}

	@Override
	public String toString() {
		return "Artiste " + nom;
	}
	
	public void affiche() {
		System.out.println(this.toString());
	}
	
	
	//////DOERS
	
	protected void ajouterSpectacle(Spectacle s) {
		mesSpectacles.add(s);
	}
	
	protected boolean contientSpectacle(Spectacle s) {
		return mesSpectacles.contains(s);
	}
	
	protected int nbSpectacle() {
		return mesSpectacles.size();
	}
	
	protected void supprimerSpectacle(Spectacle s) {
		mesSpectacles.remove(s);
	}
	
}
