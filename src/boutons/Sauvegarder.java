package boutons;

import principal.*;
import noeud.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.HashMap;
import org.json.simple.*;

/*Le bouton "sauvegarder" permet de compléter les dictionnaires pour créér un nouveau fichier JSON avec l'histoire que l'on vient de modifier/créér
  Il prend en paramètre un objet section, le dictionnaire des textes des sections, le dictionnaire des sections, la map des choix du noeud,
  la jframe principal et le texte de l'introduction*/

public class Sauvegarder extends JButton{

  protected JSONObject sections;
  protected HashMap<Integer, String> dicoTexteSections;
  protected HashMap<String, HashMap<String,String>> dicoSections;
  protected HashMap<String,String> mapNoeud;
  protected JFrame principal;
  protected String texteIntroduction;

  public Sauvegarder(JSONObject sections, HashMap<Integer, String> dicoTexteSections, HashMap<String, HashMap<String,String>> dicoSections, HashMap<String,String> mapNoeud, JFrame principal, String texteIntroduction){
    this.setText("sauvegarder");
    this.addMouseListener(new MouseAdapter(){
      public void mouseClicked(MouseEvent e) {
        //On créé une fenêtre pop-up pour que l'utilisateur entre le titre de son histoire
        String nomFichier = JOptionPane.showInputDialog(principal, "Saisissez le nom de votre histoire");
        for(int i = 1; i <= sections.size(); i++){
          Noeud noeud = new Noeud(sections,Integer.valueOf(i).toString());
          //On rempli le dictionnaire des textes des sections et des sections pour les sections qu'on a pas visité
          if(dicoTexteSections.get(i).isEmpty()){
            dicoTexteSections.put(Integer.valueOf(i),noeud.getTexte());
          }
          if(dicoSections.get("Sections " + i).isEmpty()){
            HashMap<String,String> mapNoeud = new HashMap<>(noeud.choices());
            dicoSections.put("Sections " + noeud.getNumber(), mapNoeud);
          }
        }
        CreationJson edition = new CreationJson();
        //On créé un instance de CreationJson pour écrire notre histoire dans un JSON
        edition.creationJson(texteIntroduction, dicoSections, dicoTexteSections ,nomFichier);
      }
    });
  }

}
