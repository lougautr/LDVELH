package boutons;

import principal.*;
import java.awt.event.*;
import javax.swing.*;

/*Le bouton "Accueil" supprime les éléments de tout les panels afin de retourner à la première fenêtre comme si on venait de démarrer le logiciel
  Il prend en paramètre les 4 panels utilisés et le fenêtre principal*/

public class Accueil extends JButton{

  protected JPanel panelPrincipal;
  protected JPanel panelListeSections;
  protected JPanel panelBoutons;
  protected JPanel panelTexte;
  protected Fenetre principal;

  public Accueil(JPanel panelPrincipal, JPanel panelListeSections, JPanel panelBoutons, JPanel panelTexte, Fenetre principal){
    this.setText("accueil");
    this.addMouseListener(new MouseAdapter(){
		public void mouseClicked(MouseEvent e) {
      //On utilise removeALL sur chaque panel pour les vider de leurs composants
			panelPrincipal.removeAll();
			panelListeSections.removeAll();
			panelBoutons.removeAll();
			panelTexte.removeAll();
      //On appelle afficherAccueil pour revenir à la première fenêtre du logiciel
			principal.afficherAccueil();
			}
		});
  }

}
