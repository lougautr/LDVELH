package boutons;

import javax.swing.*;
import java.awt.event.*;
import principal.*;
import noeud.*;
import mode.*;
import org.json.simple.JSONObject;

/*Le bouton "Commencer l'histoire" affiche la première section de l'histoire
  Il prend en paramètre le panel des boutons, l'objet sections, le mode édition et lecture et un booléen qui symbolise le choix entre éditable et lecture*/

public class Commencer extends JButton{

protected JPanel panelBoutons;
protected JSONObject sections;
protected ModeEdition edition;
protected ModeLecture lecture;
protected boolean condition;

  public Commencer(JPanel panelBoutons, JSONObject sections, ModeEdition edition, ModeLecture lecture, boolean condition){
    this.setText("Commencer l'histoire");
    this.addMouseListener(new MouseAdapter(){
      public void mouseClicked(MouseEvent e) {
        if (e.getClickCount() == 1) {
          Noeud noeud1 = new Noeud(sections,"1");
          //On enlève au panel bouton, le bouton "Commencer l'histoire"
          panelBoutons.remove(panelBoutons.getComponent(0));
          //Suivant notre condition on lance le mode édition ou lecture
          if(condition)
            edition.afficherParagraphe(noeud1);
          else
            lecture.afficherParagraphe(noeud1);
        }
      }
    });
  }

}
