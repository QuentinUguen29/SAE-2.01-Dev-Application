package modele;

public class ChequeVacance extends Paiement{

    public ChequeVacance(boolean realise)
    {
        super(realise);
    }

    public String toString()
    {
        return "Réalisé : "+this.getRealise()+" Type : Chèque vacance";
    }
}