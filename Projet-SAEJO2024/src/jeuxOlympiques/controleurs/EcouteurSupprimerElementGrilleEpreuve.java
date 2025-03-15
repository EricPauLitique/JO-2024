package jeuxOlympiques.controleurs;

import java.awt.event.ActionEvent;


import java.awt.event.ActionListener;

import javax.swing.JFrame;
import jeuxOlympiques.vues.*;
import jeuxOlympiques.modeles.*;
import java.awt.Window;

import java.util.ArrayList;

//Lucas
/**
* @author lpivet
*/

public class EcouteurSupprimerElementGrilleEpreuve implements ActionListener {
	PanelAfficherEpreuve panelAfficher;
	PanelSelection panelCase;

	/**
	 * Constructeur pour EcouteurSupprimerElementGrilleEpreuve
	 * 
	 * @param temp2 : PanelSelection
	 * @param temp : PanelAfficherEpreuve
	 */

	public EcouteurSupprimerElementGrilleEpreuve(PanelSelection temp2, PanelAfficherEpreuve temp) {

		panelCase = temp2;
		panelAfficher = temp;
	}

	// Lucas
	public void actionPerformed(ActionEvent event) {

		//Ferme toutes les fenêtres
		for (Window window : Window.getWindows()) {
			if (window instanceof JFrame) {
				window.dispose();
			}
		}

		//Récupère la grille des épreuves
		PanelGrille newGrille = panelAfficher.getGrilleEpreuve();

		//Supprime la case concerner
		newGrille.supprimerSelection(panelCase);

		//Supprimer l'épreuve de la liste des épreuves enregistrer
		PanelSelectionEpreuve caseActuel=(PanelSelectionEpreuve) panelCase;

		ArrayList<Epreuve> newLesEpreuves =  Epreuve.getJOParis().getSesEpreuves();

		newLesEpreuves.remove(caseActuel.getEpreuve());

		Epreuve.getJOParis().setSesEpreuves(newLesEpreuves);

		//affiche le nouveau panelAfficherEpreuve avec la nouvelle Grille
		PanelAfficherEpreuve panel = new PanelAfficherEpreuve(newGrille);
		panel.afficherFenetre();

	}
}
