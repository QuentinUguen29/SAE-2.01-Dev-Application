package modele;

public class Groupe extends Tarification {
    static final public double reductionStatic = 0.15;

    public double calculReduction() {
        return Spectacle.pleinTarif.getPleinTarif() - Spectacle.pleinTarif.getPleinTarif() * reductionStatic;
    }
}
