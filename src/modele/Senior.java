package modele;

public class Senior extends Tarification {
    static final public double reductionStatic = 0.25;

    public double calculReduction() {
        return Spectacle.pleinTarif.getPleinTarif() - Spectacle.pleinTarif.getPleinTarif() * reductionStatic;
    }
}
