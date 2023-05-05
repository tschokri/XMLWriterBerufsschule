package Auftrag3;

/* Arbeitsauftrag:  Speichern Sie die Liste der Bücher 
 * 					(buchliste) in die Datei "buchhandlung.xml".
 * 					Dabei gehen Sie wie folgt vor:
 *                  - Erstellen Sie ein DOM-Dokument  
 * 					- sichern Sie es als XML in die Datei "buchhandlung.xml".
 * 
 * 	Hinweis: Die Struktur der Ergebnisdatei soll der Datei 
 *           "Vorgabe_für_Ausgabedatei.xml" entsprechen. 			
 *               
 */

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class WriteBookstoreData3 {

	public static void main(String[] args) {

		List<Buch> buchliste = new ArrayList<>();
		buchliste.add(new Buch("Everyday Italian", "Giada De Laurentiis", 30.0));
		buchliste.add(new Buch("Harry Potter", "J K. Rowling", 29.99));
		buchliste.add(new Buch("XQuery Kick Start", "James McGovern", 49.99));
		buchliste.add(new Buch("Learning XML", "Erik T. Ray", 39.95));

		//Add your code here
		
	}

}
