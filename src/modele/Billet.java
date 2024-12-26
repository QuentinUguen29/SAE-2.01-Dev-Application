package modele;

public class Billet {
	
    private String numero;
    private Tarification categorie;
    private Reservation reservation;
    
    public Billet(String numero, Tarification categorie, Reservation reservation) {
        this.numero = numero;
        this.categorie=categorie;
        this.categorie.ajouterBillet(this);
        this.reservation=reservation;
        reservation.ajouterBillet(this);
    }
    
    protected void modifierTarification(Tarification t)
    {
    	this.categorie=t;
    }
    
    protected void modifierReservation(Reservation r)
    {
    	this.reservation=r;
    }
    
    public Tarification getCategorie() {
		return categorie;
	}
    
	public Reservation getReservation() {
		return reservation;
	}

	public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String toString() {
        return "Billet{" + "numero=" + numero + '}';
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass()!= obj.getClass()) {
            return false;
        }
        final Billet other = (Billet) obj;
        if ((this.numero == null)? (other.numero!= null) :!this.numero.equals(other.numero)) {
            return false;
        }
        return true;
    }

    public void affiche() {
        System.out.println(this.toString());
    }


}
