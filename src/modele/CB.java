package modele;

public class CB extends Paiement{

    public CB(boolean realise)
    {
        super(realise);
    }

    public String toString()
    {
        return "Réalisé : "+this.getRealise()+" Type : CB";
    }

}