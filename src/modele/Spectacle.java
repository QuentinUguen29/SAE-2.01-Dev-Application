package modele;

import java.util.ArrayList;
import java.util.Objects;

public class Spectacle {
	
	private String nom;
	protected static Tarif pleinTarif;
	private final ArrayList<Artiste> mesArtistes = new ArrayList<Artiste>();
	private final ArrayList<Representation> mesRepresentations = new ArrayList<Representation>();
	
	public Spectacle(String nom, Tarif tarif, Artiste artiste) {
		super();
		this.nom = nom;
		Spectacle.pleinTarif = tarif;
		this.mesArtistes.add(artiste);
		artiste.ajouterSpectacle(this);
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
		
	public Tarif getPrix() {
		return pleinTarif;
	}

	public void setPrix(Tarif t) {
		Spectacle.pleinTarif = t;
	}

	public ArrayList<Artiste> getArtistes() {
		return mesArtistes;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Spectacle other = (Spectacle) obj;
		return Objects.equals(nom, other.nom);
	}
	

	//////DOERS & THINKERS ------ ARTISTE 
	
	public void ajouterDansMesArtistes(Artiste a) {
		if (a == null) {
			System.out.println("Cet artiste n'existe pas");
		} else if (this.contientArtistes(a)) {
			System.out.println("L'artiste joue déjà dans ce spectacle");
		} else {
			ajouterArtistes(a);
			a.ajouterSpectacle(this);
		}
	}
	
	protected void ajouterArtistes(Artiste a) {
		mesArtistes.add(a);
	}
	
	protected boolean contientArtistes(Artiste a) {
		return mesArtistes.contains(a);
	}
	
	protected int nbSpectacle() {
		return mesArtistes.size();
	}
	
	public void supprimerDansMesArtistes(Artiste a) {
		if (a == null) {
			System.out.println("Cet artiste n'existe pas");
		} else if (!this.contientArtistes(a)) {
			System.out.println("L'artiste ne joue pas dans ce spectacle");
		} else if (this.nbSpectacle() <= 1 ) {
			System.out.println("Ce spectacle doit obligatoirement être joué par au moins un artiste");
		} else if (a.nbSpectacle()<=1) {
			System.out.println("Cet artiste doit obligatoirement jouer dans au moins un spectacle.");
		} else {
			supprimerArtistes(a);
			a.supprimerSpectacle(this);
		}
	}
	
	protected void supprimerArtistes(Artiste a) {
		mesArtistes.remove(a);
	}
	
	//////DOERS & THINKERS ------ REPRESENTATION 

	public void ajouterDansMesRepresentations(Representation r) {
		if (r == null) {
			System.out.println("Cette représentation n'existe pas");
		} else if (this.contientRepresentations(r)) {
			System.out.println("Ce spectacle contient déjà cette représentation");
		} else {
			ajouterRepresentations(r);
			r.modifierMonSpectacle(this);
		}
	}
	
	protected void ajouterRepresentations(Representation r) {
		mesRepresentations.add(r);
	}
	
	protected boolean contientRepresentations(Representation r) {
		return mesRepresentations.contains(r);
	}
	
	protected int nbRepresentation() {
		return mesRepresentations.size();
	}
	
	public void supprimerDansMesRepresentation(Representation r) {
		if (r == null) {
			System.out.println("Cette représentation n'existe pas");
		} else if (!this.contientRepresentations(r)) {
			System.out.println("Ce spectacle ne contient pas cette représentation");
		} else if (this.nbSpectacle() <= 1 ) {
			System.out.println("Ce spectacle doit obligatoirement contenir au moins une représentation");
		} else {
			supprimerRepresentations(r);
		}
	}
	
	protected void supprimerRepresentations(Representation r) {
		mesRepresentations.remove(r);
	}

}
