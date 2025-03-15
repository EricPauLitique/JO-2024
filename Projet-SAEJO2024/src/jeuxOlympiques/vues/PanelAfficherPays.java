package jeuxOlympiques.vues;

import java.util.ArrayList;

import javax.swing.*;
import jeuxOlympiques.controleurs.*;
import jeuxOlympiques.modeles.*;

//Halim 
/**
 * @author hluquet
 */
public class PanelAfficherPays extends JPanel {

	// ATTRIBUTS
	PanelBandeau bandeau;
	PanelGrille grillePays;
	JButton ajouterPays;
	JFrame fenetre;

	// CONSTRUCTEUR
	PanelAfficherPays() {
		bandeau = new PanelBandeau();
		grillePays = PanelBandeau.getGrillePays(); // Récupère la grille enregistrer dans le bandeau de façon static
		ajouterPays = new JButton("Ajouter un pays");

		// Ajoute tout au Panel
		add(bandeau);
		add(grillePays);
		add(ajouterPays);

		// Ajoute tout à la fenêtre
		fenetre = new JFrame("Pays");
		fenetre.setSize(800, 500);
		fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fenetre.add(this);

		// Ajoute l'ecouteur permettant d'afficher ajouterPays au bouton ajouter
		EcouteurAfficherAjouterPays EcouteurajouterPays = new EcouteurAfficherAjouterPays(this);
		ajouterPays.addActionListener(EcouteurajouterPays);

	}

	public JFrame getFenetre() {
		return fenetre;
	}

	public void setFenetre(JFrame fenetre) {
		this.fenetre = fenetre;
	}

	// CONSTRUCTEUR permettant de conserver la grille (lorsque l'on ajoute ou
	// modifie)
	public PanelAfficherPays(PanelGrille grille) {
		bandeau = new PanelBandeau();
		grillePays = grille;
		ajouterPays = new JButton("Ajouter un pays");

		add(bandeau);
		add(grillePays);
		add(ajouterPays);

		PanelBandeau.setGrillePays(grillePays); // Permet d'enregistrer la nouvelle grille des épreuves de façon static

		fenetre = new JFrame("Pays");
		fenetre.setSize(880, 500);
		fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fenetre.add(this);

		EcouteurAfficherAjouterPays ajouterPaysListen = new EcouteurAfficherAjouterPays(this);
		ajouterPays.addActionListener(ajouterPaysListen);
	}

	public PanelBandeau getBandeau() {
		return bandeau;
	}

	public void setBandeau(PanelBandeau bandeau) {
		this.bandeau = bandeau;
	}

	public JButton getAjouterPays() {
		return ajouterPays;
	}

	public void setAjouterPays(JButton ajouterPays) {
		this.ajouterPays = ajouterPays;
	}

	public PanelGrille getGrillePays() {
		return grillePays;
	}

	public void setGrillePays(PanelGrille grillePays) {
		this.grillePays = grillePays;
	}

	public void afficherFenetre() {
		fenetre.setLocationRelativeTo(null);

		// Afficher la fenetre
		fenetre.setVisible(true);
	}

	public static void main(String[] args) {
		PanelAfficherPays test = new PanelAfficherPays();
		test.afficherFenetre();
		ArrayList<Epreuve> epreuves = new ArrayList<>();
		Epreuve Football = new Epreuve("Football");
		Epreuve Basketball = new Epreuve("Basketball");
		Epreuve Handball = new Epreuve("Handball");
		epreuves.add(Football);
		epreuves.add(Basketball);
		epreuves.add(Handball);
		Categorie Masculin = new Categorie(Football, "Masculin");
		Categorie Feminin = new Categorie(Football, "Feminin");

		Epreuve.JOParis.setSesEpreuves(epreuves);
	}
}
