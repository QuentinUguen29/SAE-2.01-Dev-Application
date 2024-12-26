package modele;

import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;

public class Reservation {

	private String numero;
	private Date date;
	
	private Client spectateur;
	private Representation maRepresentation;
	private Facture maFacture;
	private final ArrayList<Billet> mesBillets = new ArrayList<Billet>();
	
	public Reservation(String numero, Date date, Representation representation, Client spectateur)
	{
		this.numero = numero;
		this.date = date;
		this.maRepresentation=representation;
		representation.ajouterReservation(this);
		this.spectateur=spectateur;
		spectateur.ajouterReservation(this);
	}
	
	protected void modifierClient(Client c)
	{
		this.spectateur=c;
	}
	
	protected void modifierRepresentation(Representation r)
	{
		this.maRepresentation=r;
	}
	
	protected void ajouterFacture(Facture f)
	{
		this.maFacture=f;
	}
	
	protected void supprimerFacture()
	{
		this.maFacture=null;
	}
	
	protected boolean contientBillet(Billet b)
	{
		return this.mesBillets.contains(b);
	}
	
	protected int nbBillet()
	{
		return this.mesBillets.size();
	}
	
	protected void ajouterBillet(Billet b)
	{
		this.mesBillets.add(b);
	}
	
	protected void supprimerBillet(Billet b)
	{
		this.mesBillets.remove(b);
	}
	
	public void ajouterMonBillet(Billet b)
	{
		if(b == null)
		{
			System.out.println("Le billet est vide.");
		}
		else
		{
			this.ajouterBillet(b);
			b.modifierReservation(this);
		}
	}
	
	public void supprimerMonBillet(Billet b)
	{
		if(b == null)
		{
			System.out.println("Le billet est vide.");
		}
		else if(!contientBillet(b))
		{
			System.out.println("Le billet n'est pas dans la liste de la reservation.");
		}
		else if (nbBillet()==0)
		{
			System.out.println("Il n'y a plus de billet dans la liste de la reservation.");
		}
		else
		{
			this.supprimerBillet(b);
		}
	}
	
	public void ajouterMaFacture(Facture f)
	{
		if(f == null)
		{
			System.out.println("La facture est vide.");
		}
		else
		{
			this.ajouterFacture(f);
			f.modifierReservation(this);
		}
	}
	
	public void supprimerMaFacture()
	{
		if(this.maFacture == null)
		{
			System.out.println("Il n'y a pas de facture existante.");
		}
		else
		{
			this.supprimerFacture();
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Reservation other = (Reservation) obj;
		return Objects.equals(date, other.date) && Objects.equals(numero, other.numero);
	}

	@Override
	public String toString() {
		return "Reservation [numero=" + numero + ", date=" + date + "]";
	}
	
	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}
	
	public Date getDate() {
		return date;
	}
	
	public void setDate(Date date) {
		this.date = date;
	}

	public Client getSpectateur() {
		return spectateur;
	}

	public Representation getMaRepresentation() {
		return maRepresentation;
	}
	
}
