package modele;

import java.util.ArrayList;
import java.util.Objects;

public class Client {

	private String nom;
	private String prenom;
	private String adresse;
	private String tel;
	private String mail;
	private String numero;
	private final ArrayList<Reservation> mesReservations = new ArrayList<Reservation>();
	
	public Client(String nom, String prenom, String adresse, String tel, String mail, String numero)
	{
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
		this.tel = tel;
		this.mail = mail;
		this.numero = numero;
	}
	
	protected boolean contientReservation(Reservation r)
	{
		return mesReservations.contains(r);
	}
	
	protected int nbReservations()
	{
		return mesReservations.size();
	}
	
	protected void ajouterReservation(Reservation r)
	{
		mesReservations.add(r);
	}
	
	protected void supprimerReservation(Reservation r)
	{
		mesReservations.remove(r);
	}
	
	public void ajouterDansMesReservations(Reservation r)
	{
		if (this.contientReservation(r))
		{
			System.out.println("Il existe déjà cette réservation dans la liste du client.");
		}
		else if(r == null)
		{
			System.out.println("La réservation est vide.");
		}
		else
		{
			this.ajouterReservation(r);
			r.modifierClient(this);
		}
	}
	
	public void supprimerDansMesReservations(Reservation r)
	{
		if (!this.contientReservation(r))
		{
			System.out.println("Cette réservation n'existe pas dans la liste du client.");
		}
		else if(r == null)
		{
			System.out.println("La réservation est vide.");
		}
		else if (this.nbReservations()==1)
		{
			System.out.println("On ne peut pas supprimer la réservation : c'est la dernière de la liste du client.");
		}
		else
		{
			this.supprimerReservation(r);
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
		Client other = (Client) obj;
		return Objects.equals(adresse, other.adresse) && Objects.equals(mail, other.mail)
				&& Objects.equals(nom, other.nom) && Objects.equals(numero, other.numero)
				&& Objects.equals(prenom, other.prenom) && Objects.equals(tel, other.tel);
	}

	@Override
	public String toString() {
		return "Client [nom=" + nom + ", prenom=" + prenom + ", adresse=" + adresse + ", tel=" + tel + ", mail=" + mail
				+ ", numero=" + numero + "]";
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

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}
	
}
