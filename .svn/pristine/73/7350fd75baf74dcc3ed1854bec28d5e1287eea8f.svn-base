package noeud;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import java.util.HashMap;
import java.util.ArrayList;
import java.lang.Integer;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

//La classe Noeud contient les fonctions de récupération d'un element à partir d'un fichier json puis les fonctions de création d'Objects JSON

public class Noeud{
	protected JSONObject sections;
	protected String number;

	public Noeud(JSONObject sections , String number){
		this.sections = sections;
		this.number = number ;
	}

	public String getNumber(){
		return this.number;
	}

	public JSONObject getSection(){
		return this.sections;
	}

	//On récupère le texte du noeud
	public String getTexte(){
		JSONObject SectObject = (JSONObject) this.sections.get(this.number);
		String textValue = (String) SectObject.get("text");
		return textValue;
	}

	//On récupère les choix du noeud
	public JSONArray getChoice(){
		JSONObject SectObject = (JSONObject) this.sections.get(this.number);
		JSONArray choice = (JSONArray) SectObject.get("choices");
		return choice;
	}

	//On récupère le texte des choix du noeud
	public ArrayList<String> getChoiceTexte(){
		JSONArray choice = this.getChoice();
		ArrayList<String> listeTexte = new ArrayList<>();
		if(choice.size() >=1){
			for (int i=0; i< choice.size();i++){
				JSONObject object = (JSONObject) choice.get(i);
				String element =  (String) object.get("text");
				listeTexte.add(element);
			}
		}
		return listeTexte;
	}

	//On récupère le numéro des sections futurs
	public ArrayList<String> getChoiceNumber(){
		JSONArray choice = this.getChoice();
		ArrayList<String> listeSection = new ArrayList<>();
		if(choice.size() >=1){
			for (int i=0; i< choice.size();i++){
				JSONObject object = (JSONObject) choice.get(i);
				String numberSection = (String) object.get("section");
				listeSection.add(numberSection);
			}
		}
		return listeSection;
	}

	//Fonction pour récupérer les choix possibles pour un paragraphe sous forme de dictionnaire
	public HashMap<String , String> choices(){
		JSONArray choice =this.getChoice();
		HashMap<String,String> dicoChoix = new HashMap<>();
		if(choice.size() >=1){
			for (int i=0; i< choice.size();i++){
				JSONObject object = (JSONObject) choice.get(i);
				String numberSection = (String) object.get("section");
				String texte =  (String) object.get("text");
				dicoChoix.put(numberSection, texte);
			}
		}
		return dicoChoix;
	}

	//Fonction qui met des flèches entre chaque noeud
	public String toDot(){
			String graph = "";
	    graph += this.number + " -> {";
	    for(String s: this.getChoiceNumber()){
	      graph += s + " ";
	    }
	    graph += "};";
	    return graph;
	 }

	/*Fonction qui écrit le début du fichier output.dot (pour créer un graphe)
	  Elle définit une couleur pour les noeuds et les flèches du graphe
	  Pour chaque noeud, elle appelle la fonction toDot() définit au dessus afin de créer des liaisons entre tous les noeuds et leurs choix*/
	public String toDot2(){
	    String graph = "digraph G { node[shape=squre, color=purple, style = bold]; edge[color=brown, arrowsize=1.5];";
	    for(int i=1; i<=this.sections.size(); i++){
				Integer ibis = i;
	      graph += new Noeud(this.sections, Integer.toString(ibis)).toDot() + "\n";
	    }
	    graph += "}";
			return graph;
	  }

	//Fonction qui ajoute un noeud dans une section
	public void addNoeud(){
		String num = this.getNumber();
		JSONObject obj = this.getSection();
		JSONObject O = new JSONObject();
		obj.put(num,O);
	}

	//Fonction qui ajoute un texte dans une section
	public void ajoutTexte(String texte){
		JSONObject SectObject = (JSONObject) this.sections.get(this.number);
		SectObject.put("text", texte);
	}

	//Fonction qui ajoute des choix (texte et numéro)
	public void ajoutChoix(String futurSection, String texte){
		JSONObject JObj = new JSONObject();
		JObj.put("section", futurSection);
		JObj.put("text", texte );
		JSONObject s = (JSONObject) this.sections.get(this.number);
		if (!s.containsKey("choices")){
			JSONArray tabChoice = new JSONArray();
			tabChoice.add(JObj);
			s.put("choices",tabChoice);
		}
		else{
			JSONArray tabChoice = this.getChoice();
			tabChoice.add(JObj);

		}
	}

	public void ajoutChoix(){
		JSONObject s = (JSONObject) this.sections.get(this.number);
		JSONArray tabChoice = new JSONArray();
		s.put("choices",tabChoice);
	}

}
