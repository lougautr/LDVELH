package noeud;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Iterator;
import java.util.HashMap;
import java.io.*;

//La classe CreationJson permet d'écrire l'histoire en cours dans un fichier JSON

public class CreationJson{

	public void creationJson(String intro, HashMap <String, HashMap<String, String>> dicoSections, HashMap<Integer,String> dicoTexteSections, String nomFichier) {

		JSONParser parser = new JSONParser();

		try {
			//On créé notre livre
			JSONObject livre = new JSONObject();
			//On créé notre object qui accueillera nos sections
			JSONObject sections = new JSONObject ();
			//On ajoute le texte de l'introduction à l'objet texte
			JSONArray texte = new JSONArray();
			texte.add(intro);
			//On parcourt notre dictionnaire de sections et on créé un objet noeud auquel on ajoute le texte et ses choix
			for(int i = 1; i <= dicoSections.size(); i++){
				Noeud N = new Noeud(sections,Integer.valueOf(i).toString());
				N.addNoeud();
				N.ajoutTexte(dicoTexteSections.get(Integer.valueOf(i)));
				//Si la section ne comporte pas de choix on créé un objet choix vide
				if(dicoSections.get("Sections " + Integer.valueOf(i).toString()).keySet().isEmpty()){
					N.ajoutChoix();
				}
				for(String str : dicoSections.get("Sections " + Integer.valueOf(i).toString()).keySet()){
						N.ajoutChoix(str,dicoSections.get("Sections " + Integer.valueOf(i).toString()).get(str));
				}
			}
			//On ajoute à notre livre l'introduction et les sections
			livre.put("intro_sequence",texte);
			livre.put("sections",sections);
			//On écrit le tout dans un fichier d'extension JSON
			FileWriter myWriter = new FileWriter("./files/"+nomFichier+".json");


			myWriter.write(livre.toString());
			myWriter.close();

		}
		catch (IOException e)
		{
      System.out.println("An error occurred.");
      e.printStackTrace();
      }
		}
	}
