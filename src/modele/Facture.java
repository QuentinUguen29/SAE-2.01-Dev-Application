package modele;

public class Facture{

    // TVA
    final private double staticTauxTva = 0.021;

    private String numero;
    private double montantTTC;
    
    private Paiement paiement;
    private Reservation reservation;

    public Facture(String numero, double montantTTC, Paiement paiement, Reservation reservation){
        this(numero, montantTTC, paiement);
        this.reservation=reservation;
        reservation.ajouterFacture(this);

    }
    
    public Facture(String numero, double montantTTC, Paiement paiement){

        this.numero = numero;
        this.montantTTC = montantTTC;
        this.paiement = paiement;
        paiement.affecterFacture(this);

    }

    public double getMontantTTC() {
        return montantTTC;
    }
    
    public void setMontantTTC(double montantTTC) {
        this.montantTTC = montantTTC;
    }
    
    public String getNumero() {
        return numero;
    }
    
    public void setNumero(String numero) {
        this.numero = numero;
    }

    public Paiement getPaiement() {
        return paiement;
    }

    public double getStaticTauxTva() {
        return staticTauxTva;
    }

    public Reservation getReservation() {
		return reservation;
	}

	// THINKER
    public void modifierTransaction(Paiement p){

        if(p == null){
            System.out.println("Le moyen de paiement n'existe pas !");
        }
        if(this.paiement.equals(p)){
            System.out.println("Le moyen de payement est déjà définis !");
        }else{

            p.affecterFacture(this);
            this.modifierPaiement(p);
        }

    }

    // DOER
    protected void modifierPaiement(Paiement p){

        this.paiement = p;

    }
    
    protected void modifierReservation(Reservation r)
    {
    	this.reservation=r;
    }

    public String toString(){
        return "numero : "+numero+" montantTTC : "+montantTTC+" paiement : "+paiement.toString()+" Taux TVA : "+staticTauxTva;
    }

}