package vue;

import controleur.Main;
import javafx.event.ActionEvent;
import javafx.fxml.*;
import javafx.scene.control.*;
import javafx.scene.input.*;
import javafx.scene.layout.BorderPane;

public class CtrlAffichageFacture {
	@FXML
	private Button bnFermer;
	
	@FXML
	private Label adresseClient;

	@FXML
	private Label dateFacture;

	@FXML
	private Label nomClient;

	@FXML
	private Label numFacture;

	@FXML
	private Label typePaiement;

	@FXML
	private Label villeClient;

	@FXML
	public void clicFermer() {
		Main.fermerAfficher();
	}

	@FXML
	public void setAdresseClient(String addresseClient) {
		this.adresseClient.setText(addresseClient);
	}

	public void setDateFacture(String dateFacture) {
		this.dateFacture.setText(dateFacture);
	}

	public void setNomClient(String nomClient) {
		this.nomClient.setText(nomClient);
	}

	public void setNumFacture(String numFacture) {
		this.numFacture.setText(numFacture);
	}

	public void setTypePaiement(String typePaiement) {
		this.typePaiement.setText(typePaiement);
	}

	public void setVilleClient(String villeClient) {
		this.villeClient.setText(villeClient);
	}

}
