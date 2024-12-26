package modele;

public class Adulte extends Tarification{
	
    public double calculReduction()
    {
        return Spectacle.pleinTarif.getPleinTarif();
    }
}
