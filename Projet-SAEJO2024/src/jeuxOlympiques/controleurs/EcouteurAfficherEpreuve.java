package jeuxOlympiques.controleurs;

import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import jeuxOlympiques.vues.*;

/**
 * 
 * @author sgadewa
 * 
 */
//Stephane
public class EcouteurAfficherEpreuve implements ActionListener{

	PanelGrille grid;

	

	/**
	 * 
	 * Constructeur pour EcouteurAfficherEpreuve 
	 * 
	 * @param grille : PanelGrille
	 */

	public EcouteurAfficherEpreuve(PanelGrille grille){
		grid=grille;
	}

	public void actionPerformed(ActionEvent e) {
		for (Window window : Window.getWindows()) {
			if (window instanceof JFrame) {
				window.dispose();
			}
		}
		PanelAfficherEpreuve epreuve= new PanelAfficherEpreuve(grid);
		epreuve.afficherFenetre();
	}

}
