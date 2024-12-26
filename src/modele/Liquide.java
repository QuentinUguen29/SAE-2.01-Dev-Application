package modele;

public class Liquide extends Paiement{

    public Liquide(boolean realise)
    {
        super(realise);
    }

    public String toString()
    {
        return "Réalisé : "+this.getRealise()+" Type : Liquide";
    }
}