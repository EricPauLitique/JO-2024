package jeuxOlympiques.vues;

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;

import jeuxOlympiques.controleurs.*;
import jeuxOlympiques.modeles.*;

//Lucas 
/**
 * @author lpivet
 */
public class PanelSelectionSession extends PanelSelection {
	PanelSelectionCategorie categorie;
	static ArrayList<Session> lesSessions = new ArrayList<Session>();
	Session saSession;

	/**
	 * Getter de categorie
	 * 
	 * @return categorie - PanelSelectionCategorie
	 */
	public PanelSelectionCategorie getCategorie() {
		return categorie;
	}

	/**
	 * Setter de categorie
	 * 
	 * @param categorie - PanelSelectionCategorie
	 */
	public void setCategorie(PanelSelectionCategorie categorie) {
		this.categorie = categorie;
	}

	/**
	 * Permet de créer un objet session en appelant le constructeur panelSelection
	 * 
	 * @param session - Session
	 */
	public PanelSelectionSession(Session session) {
		super();
		buttonTitre = new JButton(
				"       " + session.getDateSession() + "(" + session.heureDebut() + "-" + session.heureFin() + ")       ");
		lesSessions.add(session);
		saSession = session;
		buttonTitre.setForeground(Color.white); // Met le texte du label en blanc
		buttonTitre.setBackground(Color.blue);
		buttonTitre.setBorderPainted(false);
		panelTitre.add(buttonTitre);

		panelTitre.setBackground(Color.blue);
	}

	/**
	 * Getter de saSession
	 * 
	 * @return saSession - Session
	 */
	public Session getSaSession() {
		return saSession;
	}

	/**
	 * Setter de saSession
	 * 
	 * @param saSession - Session
	 */
	public void setSaSession(Session saSession) {
		this.saSession = saSession;
	}

	// Permet d'initialiser les écouteurs modifier et supprimer (en conservant le
	// PanelAfficherSession pour garder la grille des catégories
	// ainsi que la case de l'épreuve)

	public void ajouterEcouteurs(PanelAfficherSession temp) {

		buttonSupprimer.addActionListener(new EcouteurSupprimerElementGrilleSession(this, temp));
		buttonModifier.addActionListener(new EcouteurModifierElementGrilleSession(this, temp));
	}

	/**
	 * Getter de lesSessions
	 * 
	 * @return lesSessions - ArrayList Session
	 */
	public static ArrayList<Session> getLesSessions() {
		return lesSessions;
	}

	/**
	 * Setter de lesSessions
	 * 
	 * @param lesSessions
	 */
	public static void setLesSessions(ArrayList<Session> lesSessions) {
		PanelSelectionSession.lesSessions = lesSessions;
	}
}
