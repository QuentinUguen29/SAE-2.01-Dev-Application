package controleur;

import javafx.application.Application;
import javafx.stage.Modality;
import javafx.stage.Stage;
import vue.FenAffichageFacture;
import vue.FenCreerFacture;
import vue.FenListeFactures;

public class Main extends Application {
	static private FenListeFactures fListeFacture;
	static private FenAffichageFacture fAffichageFacture;
	static private FenCreerFacture fCreerFacture;

	@Override
	public void start(Stage primaryStage) throws Exception {
		fListeFacture = new FenListeFactures();
		fListeFacture.initModality(Modality.APPLICATION_MODAL);
		fAffichageFacture = new FenAffichageFacture();
		fAffichageFacture.initModality(Modality.APPLICATION_MODAL);
		fCreerFacture= new FenCreerFacture();
		fCreerFacture.initModality(Modality.APPLICATION_MODAL);

		fListeFacture.show();
	}

	public static void main(String[] args) {
		Application.launch(args);

	}
	
	static public void ouvrirCreer() {
		fCreerFacture.show();
	}
	
	static public void fermerListe() {
		System.exit(0);
	}
	
	static public void fermerCreer() {
		fCreerFacture.close();
	}
	
	static public void fermerAfficher() {
		fAffichageFacture.close();
	}
	
	static public void ouvrirAfficher(String adresse, String date, String nomClient, String numFacture, String typePaiement) {
		fAffichageFacture.getCtrl().setAdresseClient(adresse);
		fAffichageFacture.getCtrl().setNomClient(nomClient);
		fAffichageFacture.getCtrl().setNumFacture(numFacture);
		fAffichageFacture.getCtrl().setTypePaiement(typePaiement);
		fAffichageFacture.getCtrl().setDateFacture(date);
		
		
		fAffichageFacture.show();
	}
}
