package modele;

import java.util.ArrayList;

public abstract class Tarification {

	private final ArrayList<Billet> listeBillets = new ArrayList<Billet>();

	public abstract double calculReduction();

	protected boolean contientBillet(Billet b) {
		return this.listeBillets.contains(b);
	}

	protected int nbBillets() {
		return this.listeBillets.size();
	}

	protected void ajouterBillet(Billet b) {
		this.listeBillets.add(b);
	}

	protected void supprimerBillet(Billet b) {
		this.listeBillets.remove(b);
	}

	public void ajouterListeBillet(Billet b) {
		if (this.contientBillet(b)) {
			System.out.println("Il existe déjà ce billet dans la liste de la tarification.");
		} else if (b == null) {
			System.out.println("Le billet est vide.");
		} else {
			this.ajouterBillet(b);
			b.modifierTarification(this);
		}
	}

	public void supprimerListeBillet(Billet b) {
		if (!this.contientBillet(b)) {
			System.out.println("Ce billet n'existe pas dans la liste de la tarification.");
		} else if (b == null) {
			System.out.println("Ce billet est vide.");
		} else if (this.nbBillets() == 0) {
			System.out
					.println("On ne peut pas supprimer le billet : c'est la dernière de la liste de la tarification.");
		} else {
			this.supprimerBillet(b);
		}
	}

}
