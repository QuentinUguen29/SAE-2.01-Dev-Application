package modele;

public abstract class Paiement{

    private boolean realise;
    private Facture facture;
    
    public Paiement(boolean realise)
    {
    	this.realise=realise;
    }

    public abstract String toString();

    protected void affecterFacture(Facture f){
        this.facture = f;
    }

    public Facture getFacture(){
        return facture;
    }
    public boolean getRealise(){
        return realise;
    }

}