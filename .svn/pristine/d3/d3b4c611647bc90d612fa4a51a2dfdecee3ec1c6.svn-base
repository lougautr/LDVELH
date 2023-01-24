package boutons;

import principal.*;
import noeud.*;
import mode.*;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

/*Le bouton "Charger une histoire" charge une histoire
  Il prend en paramètre le jpanel contenant la liste des histoires qui existe déjà, le panel principal, le panel des boutons, la liste des histoires
  la zone pour écrire le texte et la fenêtre principal*/

public class ChargerHistoire extends JButton{

  protected JPanel panelListeHist;
  protected JPanel panelPrincipal;
  protected JPanel panelBoutons;
  protected JList<String> listeHistoires;
  protected JTextArea zoneTexteSection;
  protected Fenetre principal;


  public ChargerHistoire(JPanel panelListeHist, JPanel panelPrincipal, JPanel panelBoutons, JList<String> listeHistoires, JTextArea zoneTexteSection, Fenetre principal){
    this.setText("Charger une histoire");
    this.addMouseListener(new MouseAdapter(){
      public void mouseClicked(MouseEvent e) {
        //On met la zone de texte en non editable afin que le joueur ne puisse pas modifier l'histoire en mode lecture
        zoneTexteSection.setEditable(false);
        panelListeHist.setVisible(true);
        listeHistoires.addMouseListener(new MouseAdapter(){
          public void mouseClicked(MouseEvent e) {
            String selected = listeHistoires.getSelectedValue();
            String chemin = "./files/" + selected;
            //On récupère l'histoire que l'on vient de choisir pour la donner en argument de ModifierChargerHistoire
            ModifierChargerHistoire hist = new ModifierChargerHistoire(chemin, principal, panelPrincipal, false);
            panelBoutons.setVisible(false);
            panelPrincipal.remove(panelBoutons);
            panelListeHist.setVisible(false);
            panelPrincipal.remove(panelListeHist);
          }
        });
      }
    });
  }
}
