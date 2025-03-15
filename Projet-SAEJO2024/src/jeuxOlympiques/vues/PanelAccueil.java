package jeuxOlympiques.vues;

import javax.swing.*;

import java.awt.*;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;

/**
 * @author sgadewa
 */
// Stephane
public class PanelAccueil extends JPanel {

	PanelBandeau bandeau;

	JFrame accueil;
	Container Ico;
	JLabel labelI;
	BufferedImage image;

	/**
	 * Créer le panel afficher accueil
	 */
	public PanelAccueil() {

		bandeau = new PanelBandeau();
		add(bandeau);

		accueil = new JFrame("Accueil");
		accueil.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		try {
			image = ImageIO.read(new File("Images/JO_2024.png"));// Chemin relatif
			ImageIcon icon = new ImageIcon(image);
			labelI = new JLabel(icon);
			add(labelI);
			accueil.add(this);

		} catch (Exception e) {
			System.out.println("Image non trouvée");
		}
		accueil.setSize(880, 500);

	}

	/**
	 * Afficher la fenetre
	 */
	public void afficherFenetre() {
		accueil.setLocationRelativeTo(null);
		accueil.setVisible(true);
	}

	public static void main(String[] args) {
		// PanelAccueil accueil = new PanelAccueil();
		// accueil.afficherFenetre();
	}
}
