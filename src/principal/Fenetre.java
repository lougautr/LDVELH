package principal;

import boutons.*;
import noeud.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.List;
import java.awt.Toolkit;
import java.util.Map;
import java.util.HashMap;
import java.io.*;
import org.json.simple.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class Fenetre extends JFrame{
	//Creation zone texte de l'intro
	protected JTextArea zoneTexteSection;
	//Creation des sections
	protected JSONObject sections;
	protected JPanel panelPrincipal;
	//Creation des boutons
	protected String texteIntroduction;
	protected HashMap<Integer, String> dicoTexteSections;

	public Fenetre(){
		//Nom de la fenêtre : "ldvelh-lap"
		this.setTitle("ldvelh-lap");
		//Initialisation du panel principal
		panelPrincipal = new JPanel();
		panelPrincipal.setLayout(new BorderLayout(20,0));
		//Initialisation de la zone de texte de l'intro
		zoneTexteSection = new JTextArea();
		//Initialisation du panel des boutons
		this.setSize(Toolkit.getDefaultToolkit().getScreenSize().width, Toolkit.getDefaultToolkit().getScreenSize().height);
	}

	//Fonction pour afficher la toute première fenêtre du jeu: la fenêtre "accueil"
	public void afficherAccueil(){
		panelPrincipal.setLayout(new BorderLayout(20,0));

		JPanel panelPremiersBouton = new JPanel();
		JPanel panelListeHist = new JPanel();

		panelPrincipal.add("North",panelPremiersBouton);

		//On recupère la liste des fichiers présent dans le dossier files
		File dir = new File("./files/");
		File[] listeFichiers = dir.listFiles();

		DefaultListModel<String> modellisteHistoires = new DefaultListModel<>();
		//On ajoute au model tout les fichiers du dossier files
		for(File item : listeFichiers){
			modellisteHistoires.addElement(String.format(item.getName()));
		}
		JList<String> listeHistoires = new JList<String>(modellisteHistoires);
		//Nous avons maintenant une JList contenant tous les fichiers du dossier files
		//On rend notre JList cliquable pour pouvoir choisir le fichier que l'on veut charger
		listeHistoires.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listeHistoires.setFont(new Font("Serif", Font.PLAIN, 15));

		panelListeHist.setLayout(new BoxLayout(panelListeHist, BoxLayout.PAGE_AXIS));
		panelListeHist.add(listeHistoires);
		panelListeHist.setVisible(false);

		panelPrincipal.add("Center",panelListeHist);

		//On ajoute nos boutons "Creer une histoire" et "Charger une histoire" à notre fenêtre accueil
		CreerModifierHistoire boutonCreerHistoire = new CreerModifierHistoire(modellisteHistoires, panelListeHist, panelPrincipal, panelPremiersBouton, sections, listeHistoires, this, zoneTexteSection);
		ChargerHistoire boutonChargerHistoire = new ChargerHistoire(panelListeHist, panelPrincipal, panelPremiersBouton, listeHistoires, zoneTexteSection, this);
		panelPremiersBouton.add(boutonCreerHistoire);
		panelPremiersBouton.add(boutonChargerHistoire);
		panelPrincipal.repaint();

		this.getContentPane().add(panelPrincipal);
		this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		this.setVisible(true);
	}

	public void setIntro(String intro){texteIntroduction = intro;}

	public void setSections(JSONObject sec){sections = sec;}

	public JTextArea getZoneTexteSection(){return zoneTexteSection;}
}
