package modele;

public class Abonne extends Tarification {
    static final public double reductionStatic = 0.3;

    public double calculReduction() {
        return Spectacle.pleinTarif.getPleinTarif() - Spectacle.pleinTarif.getPleinTarif() * reductionStatic;
    }
}
