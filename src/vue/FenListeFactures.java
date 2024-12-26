package vue;

import java.io.IOException;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;


public class FenListeFactures extends Stage {
	public FenListeFactures() throws IOException {
		Scene laScene = new Scene(creerSceneGraph());
		this.setScene(laScene);
		this.setTitle("Liste des factures");
		this.setResizable(false);
	}

	private Pane creerSceneGraph() throws IOException {
     	FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("listeFacture.fxml"));
        Pane root = loader.load();
     	return root;
	}
}









































