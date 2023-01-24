package boutons;

import principal.*;
import noeud.*;
import mode.*;
import javax.swing.*;
import java.awt.event.*;

/*Le bouton "Modification texte" permet de mettre a jour le dictionnaire qui contient les textes des sections
  Il prend en paramètre la zone du texte de la section, un noeud et le mode édition*/

public class ModificationTexte extends JButton{

  protected JTextArea zoneTexteSection;
  protected Noeud unNoeud;
  protected ModeEdition edition;

  public ModificationTexte(JTextArea zoneTexteSection, Noeud unNoeud, ModeEdition edition){
    this.setText("modification texte");
    this.addMouseListener(new MouseAdapter(){
    public void mouseClicked(MouseEvent e) {
      //On appelle la majDicoTexteSections de ModeEdition pour mettre à jour le dictionnaire
      edition.majDicoTexteSections(zoneTexteSection, Integer.valueOf(unNoeud.getNumber()));
      }
    });
  }

}
