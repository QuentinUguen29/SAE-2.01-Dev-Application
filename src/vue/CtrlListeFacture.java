package vue;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import controleur.Main;
import javafx.beans.binding.Bindings;
import javafx.beans.binding.BooleanBinding;
import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import modele.*;

public class CtrlListeFacture {

	// Création d'une facture de test
	private Date date = new Date();
	private Tarif tarif = new Tarif(50);
	private Artiste artiste = new Artiste("Rolling Stones");
	private Spectacle spectacle = new Spectacle("ElSpectaclo", tarif, artiste);
	private Representation representation = new Representation("Lundi", "22h", spectacle);
	private Client client = new Client("Uguen", "Quentin", "Lannion", "07.85.03.31.95", "q.u@gmail.com", "5");
	private Reservation reservation = new Reservation("123456", date, representation, client);
	private Cheque paiement = new Cheque(true);
	private Facture factureTest = new Facture("123456", 25.0, paiement, reservation);

	// Liste pour stocker les factures
	private ArrayList<Facture> listeFactures = new ArrayList<>();

	@FXML
	private TableView<Facture> tvListeFacture;
	@FXML
	private Button bnRechercher;
	@FXML
	private Button bnFermer;
	@FXML
	private Button bnCreer;
	@FXML
	private Button bnAfficher;
	@FXML
	private Button bnModifier;
	@FXML
	private Button bnSupprimer;

	@FXML
	private TableColumn<Facture, String> dateFacture;

	@FXML
	private TableColumn<Facture, String> nomClient;

	@FXML
	private TableColumn<Facture, String> numClient;

	@FXML
	private TableColumn<Facture, String> numFacture;

	@FXML
	private TableColumn<Facture, String> villeClient;

	@FXML
	private TableColumn<Facture, String> typePaiement;
	
	

	@FXML
	public void clicRechercher() {
		// Implémentez la logique de recherche ici
	}

	@FXML
	public void clicCreer(ActionEvent event) {
		Main.ouvrirCreer();
	}

	@FXML
	public void clicFermer() {
		Main.fermerListe();
	}

	@FXML
	public void clicAfficher() {
		String adresse = tvListeFacture.getSelectionModel().getSelectedItem().getReservation().getSpectateur().getAdresse();
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.FRENCH);
		String date = dateFormat.format(tvListeFacture.getSelectionModel().getSelectedItem().getReservation().getDate());
		System.out.println(date);
		
		String nomPrenomClient = tvListeFacture.getSelectionModel().getSelectedItem().getReservation().getSpectateur().getNom() + " " +
								 tvListeFacture.getSelectionModel().getSelectedItem().getReservation().getSpectateur().getPrenom();
		String numFacture = tvListeFacture.getSelectionModel().getSelectedItem().getNumero();
		String typePaiement = tvListeFacture.getSelectionModel().getSelectedItem().getPaiement().getClass().getSimpleName();
		
		Main.ouvrirAfficher(adresse, date, nomPrenomClient, numFacture, typePaiement);
	}

	@FXML
	public void initialize() {
		
			// Ajout de la facture de test à la TableView
			tvListeFacture.getItems().add(factureTest);
			/*
			// Création de 10 factures
			for (int i = 0; i < 10; i++) {
				Date date = new Date();
				Tarif tarif = new Tarif(50);
				Artiste artiste = new Artiste("Artiste" + i);
				Spectacle spectacle = new Spectacle("Spectacle" + i, tarif, artiste);
				Representation representation = new Representation("Jour" + i, "Horaire" + i, spectacle);
				Client client = new Client("Nom" + i, "Prenom" + i, "Ville" + i, "Telephone" + i, "Email" + i,
						"Numero" + i);
				Reservation reservation = new Reservation("Reservation" + i, date, representation, client);
				Cheque paiementCheque = new Cheque(true);
				ChequeVacance paiementChequeVacance = new ChequeVacance(true);
				Liquide paiementLiquide = new Liquide(true);
				CB paiementCB = new CB(true);
				if (i % 4 == 0) {
					listeFactures.add(new Facture("Facture" + i, 25.0 + i, paiementCheque, reservation));
				} else if (i % 4 == 1) {
					listeFactures.add(new Facture("Facture" + i, 25.0 + i, paiementChequeVacance, reservation));
				} else if (i % 4 == 2) {
					listeFactures.add(new Facture("Facture" + i, 25.0 + i, paiementLiquide, reservation));
				} else {
					listeFactures.add(new Facture("Facture" + i, 25.0 + i, paiementCB, reservation));
				}
			}
			for (int j = 0; j < listeFactures.size(); j++) {
				tvListeFacture.getItems().add(listeFactures.get(j));
			}
		
		*/
		
		
		
		// Configuration des colonnes
		// NUM DU CLIENT
		numClient.setCellValueFactory(
				cellData -> new SimpleStringProperty(cellData.getValue().getReservation().getSpectateur().getNumero()));

		// NOM DU CLIENT
		nomClient.setCellValueFactory(
				cellData -> new SimpleStringProperty(cellData.getValue().getReservation().getSpectateur().getNom()));

		// VILLE DU CLIENT
		villeClient.setCellValueFactory(cellData -> new SimpleStringProperty(
				cellData.getValue().getReservation().getSpectateur().getAdresse()));

		// TYPE DU PAIEMENT
		typePaiement.setCellValueFactory(
				cellData -> new SimpleStringProperty(cellData.getValue().getPaiement().getClass().getSimpleName()));

		// DATE
		// Formatter pour la date en français
		SimpleDateFormat dateFormat = new SimpleDateFormat("d MMMM yyyy", Locale.FRENCH);
		dateFacture.setCellValueFactory(cellData -> new SimpleStringProperty(
				dateFormat.format(cellData.getValue().getReservation().getDate())));

		// NUMERO FACTURE
		numFacture.setCellValueFactory(new PropertyValueFactory<>("numero"));

		// Désactivation des boutons si aucune ligne n'est sélectionnée
		BooleanBinding rien = Bindings.equal(tvListeFacture.getSelectionModel().selectedIndexProperty(), -1);
		bnAfficher.disableProperty().bind(Bindings.when(rien).then(true).otherwise(false));
	}

}
