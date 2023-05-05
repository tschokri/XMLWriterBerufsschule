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

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class WriteBookstoreData3 {

	public static final String filePath = "src/main/resources/buchhandlung3.xml";

	public static void main(String[] args) {

		List<Buch> buchliste = new ArrayList<>();
		buchliste.add(new Buch("Everyday Italian", "Giada De Laurentiis", 30.0));
		buchliste.add(new Buch("Harry Potter", "J K. Rowling", 29.99));
		buchliste.add(new Buch("XQuery Kick Start", "James McGovern", 49.99));
		buchliste.add(new Buch("Learning XML", "Erik T. Ray", 39.95));

		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document doc = builder.newDocument();

			Element root = doc.createElement("buchhandlung");
			doc.appendChild(root);

			populateXml(doc, root, buchliste);

			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			DOMSource source = new DOMSource(doc);
			StreamResult result = new StreamResult(new File(filePath));
			transformer.transform(source, result);
		} catch (ParserConfigurationException | TransformerConfigurationException e) {
			e.printStackTrace();
		} catch (TransformerException e) {
			throw new RuntimeException(e);
		}

	}

	public static void populateXml(Document doc, Element root, List<Buch> books) {
		for (Buch buch : books) {
			Element book = doc.createElement("book");
			root.appendChild(book);

			Element title = doc.createElement("titel");
			title.appendChild(doc.createTextNode(buch.getTitel()));
			book.appendChild(title);

			Element author = doc.createElement("autor");
			author.appendChild(doc.createTextNode(buch.getAutor()));
			book.appendChild(author);

			Element price = doc.createElement("preis");
			price.appendChild(doc.createTextNode(String.valueOf(buch.getPreis())));
			book.appendChild(price);
		}

	}

}
