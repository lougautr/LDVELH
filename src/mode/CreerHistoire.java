package mode;

import boutons.*;
import noeud.*;
import principal.*;
import java.awt.event.*;
import java.awt.Toolkit;
import java.awt.*;
import javax.swing.*;
import org.json.simple.JSONObject;

/*La classe CreerHistoire permet de tout préparer pour écrire une histoire à partir de rien
Elle prend en paramètre la fenêtre principal, le panel de la liste des histoires, le panel principal, le panel des boutons,
et l'objet sections*/

public class CreerHistoire{

  protected Fenetre principal;
  protected JPanel panelListeHist;
  protected JPanel panelPrincipal;
  protected JPanel panelBoutons;

  protected JSONObject sections;

  public CreerHistoire(Fenetre principal, JPanel panelListeHist, JPanel panelPrincipal, JPanel panelBoutons, JSONObject sections){
    //On créé une nouvelle JFrame avec une zone texte et un bouton pour boutonCliquerr la JFrame
    JFrame frameIntro = new JFrame("Saisissez le texte de l'introduction");
    JPanel panelIntro = new JPanel();
    JPanel panelBoutonCliquer = new JPanel();
    JButton boutonCliquer = new JButton("Cliquer pour valider!");
    JTextArea texteIntro = new JTextArea();
    boutonCliquer.addMouseListener(new MouseAdapter(){
      public void mouseClicked(MouseEvent e){
        frameIntro.dispose();
        principal.setIntro(texteIntro.getText());
        JFrame frameSection = new JFrame("Saisissez le texte de la première section");
        JPanel panelSection = new JPanel();
        JPanel panelBoutonCliquer2 = new JPanel();
        JButton boutonCliquer2 = new JButton("Cliquer pour valider!");
        JTextArea texteSection = new JTextArea();
        boutonCliquer2.addMouseListener(new MouseAdapter(){
          public void mouseClicked(MouseEvent e){
            frameSection.dispose();
            //Quand on clique sur le bouton, on recupère le texte saisie par l'utilisateur puis on créé la section 1 pour commencer l'histoire
            Noeud n = new Noeud(sections,"1");
            n.addNoeud();
            n.ajoutTexte(texteSection.getText());
            n.ajoutChoix();
            principal.setSections(sections);
            //On créé une instance de ModeEdition pour commencer à éditer notre histoire
            ModeEdition edition = new ModeEdition(texteIntro.getText(), principal.getZoneTexteSection(), panelPrincipal, sections, principal);
            edition.afficherIntro();
            panelBoutons.setVisible(false);
            panelPrincipal.remove(panelBoutons);
            panelListeHist.setVisible(false);
            panelPrincipal.remove(panelListeHist);
          }
        });
        panelSection.add(texteSection);
        panelBoutonCliquer2.add(boutonCliquer2);
        panelSection.add(panelBoutonCliquer2);
        frameSection.setSize(Toolkit.getDefaultToolkit().getScreenSize().width, Toolkit.getDefaultToolkit().getScreenSize().height);
        frameSection.getContentPane().add(panelSection);
        frameSection.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        frameSection.setVisible(true);
        panelSection.setLayout(new BoxLayout(panelSection, BoxLayout.PAGE_AXIS));
      }
    });
    panelIntro.add(texteIntro);
    panelBoutonCliquer.add(boutonCliquer);
    panelIntro.add(panelBoutonCliquer);
    frameIntro.setSize(Toolkit.getDefaultToolkit().getScreenSize().width, Toolkit.getDefaultToolkit().getScreenSize().height);
    frameIntro.getContentPane().add(panelIntro);
    frameIntro.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    frameIntro.setVisible(true);
    panelIntro.setLayout(new BoxLayout(panelIntro, BoxLayout.PAGE_AXIS));
  }

}
