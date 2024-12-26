package vue;

import java.io.IOException;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;


public class FenCreerFacture extends Stage {
	public FenCreerFacture() throws IOException {
		Scene laScene = new Scene(creerSceneGraph());
		this.setScene(laScene);
		this.setTitle("Création d'une facture");
		this.setResizable(false);
	}

	private Pane creerSceneGraph() throws IOException {
     	FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("creerFacture.fxml"));
        Pane root = loader.load();
     	return root;
	}
}









































