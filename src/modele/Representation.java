package modele;

import java.util.ArrayList;
import java.util.Objects;

public class Representation {
	
	private String jour;
	private String heure;
	private Spectacle monSpectacle;
	private final ArrayList<Reservation> listeReservations = new ArrayList<Reservation>();


	public Representation(String jour, String heure, Spectacle spectacle) {
		super();
		this.jour = jour;
		this.heure = heure;
		this.monSpectacle = spectacle;
		spectacle.ajouterRepresentations(this);
	}
	
	public String getJour() {
		return jour;
	}
	public void setJour(String jour) {
		this.jour = jour;
	}
	public String getHeure() {
		return heure;
	}
	public void setHeure(String heure) {
		this.heure = heure;
	}

	public Spectacle getMonSpectacle() {
		return monSpectacle;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Representation other = (Representation) obj;
		return Objects.equals(heure, other.heure) && Objects.equals(jour, other.jour);
	}

	//////DOERS & THINKERS

	protected void modifierMonSpectacle(Spectacle s){
		this.monSpectacle = s;
	}
	
	protected boolean contientReservation(Reservation r)
	{
		return this.listeReservations.contains(r);
	}
	
	protected int nbReservations()
	{
		return this.listeReservations.size();
	}
	
	protected void ajouterReservation(Reservation r)
	{
		this.listeReservations.add(r);
	}
	
	protected void supprimerReservation(Reservation r)
	{
		this.listeReservations.remove(r);
	}
	
	public void ajouterListeReservations(Reservation r)
	{
		if (this.contientReservation(r))
		{
			System.out.println("Il existe déjà cette réservation dans la liste de la représentation.");
		}
		else if(r == null)
		{
			System.out.println("La réservation est vide.");
		}
		else
		{
			this.ajouterReservation(r);
			r.modifierRepresentation(this);
		}
	}
	
	public void supprimerListeReservations(Reservation r)
	{
		if (!this.contientReservation(r))
		{
			System.out.println("Cette réservation n'existe pas dans la liste de la représentation.");
		}
		else if(r == null)
		{
			System.out.println("La réservation est vide.");
		}
		else if (this.nbReservations()==1)
		{
			System.out.println("On ne peut pas supprimer la réservation : c'est la dernière de la liste de la représentation.");
		}
		else
		{
			this.supprimerReservation(r);
		}
	}
	
}
