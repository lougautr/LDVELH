package boutons;

import principal.*;
import noeud.*;
import mode.*;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import org.json.simple.JSONObject;

/*Le bouton "Créer/modifier une histoire" lance/créé une histoire en mode édition
  Il prend en paramètre le model de la liste, la liste des histoires, le panel des histoires, le panel principal,
  le panel des boutons, la zone de texte de la section, l'objet section et la fenêtre principal*/

public class CreerModifierHistoire extends JButton{

  protected DefaultListModel<String> modelListeHistoires;
  protected JList<String> listeHistoires;
  protected JPanel panelListeHist;
  protected JPanel panelPrincipal;
  protected JPanel panelBoutons;
  protected JTextArea zoneTexteSection;
  protected JSONObject sections;
  protected Fenetre principal;

  public CreerModifierHistoire(DefaultListModel<String> modelListeHistoires, JPanel panelListeHist, JPanel panelPrincipal, JPanel panelBoutons, JSONObject sections, JList<String> listeHistoires, Fenetre principal, JTextArea zoneTexteSection){
    this.setText("Créer/modifier une histoire");
    this.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e) {
        //On met la zone de texte en éditable afin que le joueur puisse modifier l'histoire en mode édition
        zoneTexteSection.setEditable(true);
        //On ajoute au model un choix pour créer une histoire
				modelListeHistoires.addElement("Créer une nouvelle histoire");
				panelListeHist.setVisible(true);
				listeHistoires.addMouseListener(new MouseAdapter(){
					public void mouseClicked(MouseEvent e) {
						String selected = listeHistoires.getSelectedValue();
            //On regarde si le joueur a choisi une histoire ou s'il veut en créer une
						if(!selected.equals("Créer une nouvelle histoire")){
							String chemin = "./files/" + selected;
              //On récupère l'histoire que l'on vient de choisir pour la donner en argument de ModifierChargerHistoire
							ModifierChargerHistoire hist = new ModifierChargerHistoire(chemin, principal, panelPrincipal, true);
							panelBoutons.setVisible(false);
							panelPrincipal.remove(panelBoutons);
							panelListeHist.setVisible(false);
							panelPrincipal.remove(panelListeHist);
						}else{
              JSONObject sections = new JSONObject();
              CreerHistoire nouvelleHistoire = new CreerHistoire(principal, panelListeHist, panelPrincipal, panelBoutons, sections);
						}
					}
				});
			}
		});
  }
}
