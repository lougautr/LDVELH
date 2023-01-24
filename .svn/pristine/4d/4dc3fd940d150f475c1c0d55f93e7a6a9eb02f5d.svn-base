package boutons;

import principal.*;
import noeud.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.Toolkit;
import javax.swing.*;
import java.util.HashMap;
import org.json.simple.*;

/*Le bouton "plus" sert à ajouter un choix a une section
  Il prend en argument le  model de la liste des sections, le dictionnaire des sections, celui des textes des sections,
  la fenêtre principal, un noeud, la map des choix du noeud, le model de la liste des choix et l'objet section*/

public class Plus extends JButton{

  protected DefaultListModel<String> modelSections;
  protected DefaultListModel<String> modelChoix;
  protected HashMap<String, HashMap<String,String>> dicoSections;
  protected HashMap<Integer, String> dicoTexteSections;
  protected Fenetre principal;
  protected Noeud unNoeud;
  protected HashMap<String,String> mapNoeud;
  protected JSONObject sections;

  public Plus(DefaultListModel<String> modelSections, HashMap<String, HashMap<String,String>> dicoSections, HashMap<Integer, String> dicoTexteSections, Fenetre principal, Noeud unNoeud, HashMap<String,String> mapNoeud, DefaultListModel<String> modelChoix, JSONObject sections){
    this.setText("plus");
    Dimension tailleMoniteur = Toolkit.getDefaultToolkit().getScreenSize();
    int longueur = tailleMoniteur.width;
    int hauteur = tailleMoniteur.height;
    this.addMouseListener(new MouseAdapter(){
      public void mouseClicked(MouseEvent e) {
          //On créé une fenêtre pop-up pour que l'utilisateur saisisse le texte du nouveau choix
          String getMessage = JOptionPane.showInputDialog(principal, "Saisissez le texte de votre choix et mettez le numéro de la section à la fin sans point");
          //On repère la fin du texte pour avoir le numéro de section du nouveau choix
          String mot = getMessage.substring(getMessage.lastIndexOf(" ")+1, getMessage.length());
          //On regarde si la section vers laquelle renvoit le choix existe déjà ou non
          if(!modelSections.contains("Sections " + mot)){
            modelSections.addElement("Sections " + mot);
            HashMap<String,String> a = new HashMap<>();
            dicoSections.put("Sections " + mot, a);
            //On créé une nouvelle JFrame pour que l'utilisateur Saisisse le texte de la nouvelle section
            JFrame frameSection = new JFrame("Ecriver le contenu de votre section");
            JButton boutonCliquer = new JButton("Cliquer pour valider!");
            JTextArea texteSection = new JTextArea();
            JPanel panelSection = new JPanel();
            JPanel panelBoutonCliquer = new JPanel();
            boutonCliquer.addMouseListener(new MouseAdapter(){
              public void mouseClicked(MouseEvent e){
                frameSection.dispose();
                //On créé une nouvelle section avec le texte de l'utilisateur et on ajoute un objet choix vide à la section
                Noeud N2 = new Noeud(sections,mot);
                N2.addNoeud();
                N2.ajoutTexte(texteSection.getText());
                //On met à jour le dictionnaire des textes
                dicoTexteSections.put(Integer.valueOf(N2.getNumber()),texteSection.getText());
                N2.ajoutChoix();
              }
            });

            panelSection.add(texteSection);
            panelBoutonCliquer.add(boutonCliquer);
            panelSection.add(panelBoutonCliquer);
            frameSection.setSize(longueur, hauteur);
            frameSection.getContentPane().add(panelSection);
            frameSection.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
            frameSection.setVisible(true);
            panelSection.setLayout(new BoxLayout(panelSection, BoxLayout.PAGE_AXIS));
          }
          //On ajoute notre nouveau choix au model, à la map des choix du noeud et on met à jour le dictionnaire des sections
          modelChoix.addElement(getMessage);
          mapNoeud.put(mot, getMessage);
          dicoSections.put("Sections " + unNoeud.getNumber(), mapNoeud);
        }
      });
    }
  }
