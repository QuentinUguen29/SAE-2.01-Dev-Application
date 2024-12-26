package modele;

public class Tarif {
    private double pleinTarif;

    public Tarif(double pleinTarif) {
        this.pleinTarif = pleinTarif;
    }

    public double getPleinTarif() {
        return this.pleinTarif;
    }

    public void setPleinTarif(double pleinTarif) {
        this.pleinTarif = pleinTarif;
    }

    public String toString() {
        return "Tarif{" + "pleinTarif=" + pleinTarif + '}';
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass()!= obj.getClass()) {
            return false;
        }
        final Tarif other = (Tarif) obj;
        if (Double.doubleToLongBits(this.pleinTarif)!= Double.doubleToLongBits(other.pleinTarif)) {
            return false;
        }
        return true;
    }

    public void affiche() {
        System.out.println(this.toString());
    }
}
