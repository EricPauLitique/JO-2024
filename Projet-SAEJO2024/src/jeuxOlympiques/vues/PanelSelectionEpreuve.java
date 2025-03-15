package jeuxOlympiques.vues;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JLabel;

import jeuxOlympiques.controleurs.*;
import jeuxOlympiques.modeles.*;

//Lucas 
/**
 * @author lpivet
 */
public class PanelSelectionEpreuve extends PanelSelection {

	Epreuve epreuve;

	/**
	 * Permet de créer un objet epreuve en appelant le constructeur panelSelection
	 * 
	 * @param epreuve - Epreuve
	 */
	public PanelSelectionEpreuve(Epreuve epreuve) {
		super();
		this.epreuve = epreuve;
		buttonTitre = new JButton("       " + epreuve.getNomEpreuve() + "       ");
		buttonTitre.setForeground(Color.white); // Met le texte du label en blanc
		buttonTitre.setBackground(Color.blue);
		buttonTitre.setBorderPainted(false);
		panelTitre.add(buttonTitre);
		panelTitre.setBackground(Color.blue);
	}

	// Permet d'ajouter les différents actionListener des boutons
	public void ajouterEcouteurs(PanelAfficherEpreuve temp) {

		buttonSupprimer.addActionListener(new EcouteurSupprimerElementGrilleEpreuve(this, temp));
		buttonModifier.addActionListener(new EcouteurModifierElementGrilleEpreuve(this, temp));
		buttonTitre.addActionListener(new EcouteurEpreuveModifierCategorie(this, temp));
	}

	/**
	 * Getter de epreuve
	 * 
	 * @return epreuve - Epreuve
	 */
	public Epreuve getEpreuve() {
		return epreuve;
	}
}
