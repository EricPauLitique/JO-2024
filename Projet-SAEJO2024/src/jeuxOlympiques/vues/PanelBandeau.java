package jeuxOlympiques.vues;

import javax.swing.*;

import jeuxOlympiques.controleurs.EcouteurAfficherEpreuve;
import jeuxOlympiques.controleurs.EcouteurAfficherPays;
import jeuxOlympiques.controleurs.EcouteurAfficherPlanning;

import java.awt.*;

/**
 * 
 * @author sgadewa
 */
// Lucas

public class PanelBandeau extends JPanel {
	JButton modifierEquipe;
	JButton modifierEpreuvesEtSessions;
	JButton afficherPlanning;

	static PanelGrille grilleEpreuves = new PanelGrille(); // Conserve de façon static la grilleEpreuves
	static PanelGrille grillePays = new PanelGrille();

	/**
	 * Getter de grille
	 * 
	 * @return grilleEpreuve - PanelGrille
	 */
	public static PanelGrille getGrillePays() {
		return grillePays;
	}

	/**
	 * Setter de grille
	 * 
	 * @param grillePays - PanelGrille
	 */
	public static void setGrillePays(PanelGrille grillePays) {
		PanelBandeau.grillePays = grillePays;
	}

	/**
	 * Permet de créer un objet PanelBandeau
	 */
	PanelBandeau() {

		modifierEquipe = new JButton("Modifier pays et équipes");
		modifierEpreuvesEtSessions = new JButton("Modifier épreuves, catégorie et sessions");
		afficherPlanning = new JButton("Afficher planning des sessions");
		modifierEquipe.setBackground(Color.blue);
		modifierEpreuvesEtSessions.setBackground(Color.blue);
		afficherPlanning.setBackground(Color.blue);

		modifierEquipe.setForeground(Color.white);
		modifierEpreuvesEtSessions.setForeground(Color.white);
		afficherPlanning.setForeground(Color.white);

		add(modifierEquipe);
		add(modifierEpreuvesEtSessions);
		add(afficherPlanning);

		setLayout(new GridLayout(1, 1));
		setBackground(Color.blue);

		EcouteurAfficherEpreuve afficherEpreuves = new EcouteurAfficherEpreuve(grilleEpreuves);
		modifierEpreuvesEtSessions.addActionListener(afficherEpreuves);

		EcouteurAfficherPlanning planning = new EcouteurAfficherPlanning();
		afficherPlanning.addActionListener(planning);

		EcouteurAfficherPays afficherPays = new EcouteurAfficherPays(grillePays);
		modifierEquipe.addActionListener(afficherPays);

	}

	protected static void setGrilleEpreuve(PanelGrille grille) {
		grilleEpreuves = grille;
	}

	public static PanelGrille getGrilleEpreuve() {
		return grilleEpreuves;
	}

}
