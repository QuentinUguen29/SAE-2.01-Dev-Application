package vue;

import java.io.IOException;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;


public class FenAffichageFacture extends Stage {
	private CtrlAffichageFacture ctrl;
	public FenAffichageFacture() throws IOException {
		Scene laScene = new Scene(creerSceneGraph());
		this.setScene(laScene);
		this.setTitle("Liste des factures");
		this.setResizable(false);
	}

	private Pane creerSceneGraph() throws IOException {
     	FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("afficherFacture.fxml"));
        Pane root = loader.load();
        ctrl = loader.getController();
     	return root;
	}

	public CtrlAffichageFacture getCtrl() {
		return ctrl;
	}
	
	
}









































