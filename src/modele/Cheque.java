package modele;

public class Cheque extends Paiement{

    public Cheque(boolean realise)
    {
        super(realise);
    }

    public String toString()
    {
        return "Réalisé : "+this.getRealise()+" Type : Chèque";
    }
}