package vue;
import controleur.Main;
import javafx.event.ActionEvent;
import javafx.fxml.*;
import javafx.scene.control.*;
import javafx.scene.input.*;
import javafx.scene.layout.BorderPane;
import modele.Facture;


public class CtrlCreerFacture {
	@FXML private Button bnFermer;
	@FXML public void clicFermer() {
		Main.fermerCreer();
	}

}
