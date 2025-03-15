package jeuxOlympiques.vues;

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JLabel;
import jeuxOlympiques.controleurs.*;
import jeuxOlympiques.modeles.*;

//Halim
/**
 * @author hluquet
 */
public class PanelSelectionPays extends PanelSelection {

	Pays pays;

	/**
	 * Permet de créer un objet pays en appelant le constructeur panelSelection
	 * 
	 * @param pays - Pays
	 */
	public PanelSelectionPays(Pays pays) {
		super();
		this.pays = pays;
		buttonTitre = new JButton("       " + pays.getNomPays() + "       ");
		buttonTitre.setForeground(Color.white); // Met le texte du label en blanc
		buttonTitre.setBackground(Color.blue);
		buttonTitre.setBorderPainted(false);
		panelTitre.add(buttonTitre);
		panelTitre.setBackground(Color.blue);
	}

	// Permet d'ajouter les différents actionListener des boutons
	public void ajouterEcouteurs(PanelAfficherPays temp) {

		buttonSupprimer.addActionListener(new EcouteurSupprimerElementGrillePays(this, temp));
		buttonModifier.addActionListener(new EcouteurModifierElementGrillePays(this, temp));
		buttonTitre.addActionListener(new EcouteurPaysToEquipe(this, temp));
	}

	/**
	 * Getter de pays
	 * 
	 * @return pays - Pays
	 */
	public Pays getPays() {
		return pays;
	}
}
