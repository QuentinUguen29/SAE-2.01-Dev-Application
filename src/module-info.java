module SAE201 {
	requires javafx.controls;
	requires javafx.fxml;
	
	opens controleur to javafx.graphics, javafx.fxml, javafx.base;
	opens modele to javafx.graphics, javafx.fxml, javafx.base;
	opens vue to javafx.graphics, javafx.fxml, javafx.base;
}
