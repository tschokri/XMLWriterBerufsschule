package Auftrag1;

/* Arbeitsauftrag: Erstellen Sie ein DOM-Dokument gemäß den Vorgaben
 * 					aus der Datei "Vorgabe_für_Ausgabedatei.xml" 
 * 					und sichern Sie es als XML in eine Datei 
 * 					mit dem Filename "buchhandlung.xml".
 * 	
 *               
 */


import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.*;

public class WriteBookstoreData1 {

	public static final String filePath = "src/main/resources/buchhandlung1.xml";

	public static void main(String[] args) {
		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document doc = builder.newDocument();

			Element root = doc.createElement("buchhandlung");
			doc.appendChild(root);

			Element book = doc.createElement("buch");
			root.appendChild(book);

			Attr attr = doc.createAttribute("lang");
			attr.setValue("de");
			book.setAttributeNode(attr);

			Element title = doc.createElement("titel");
			title.appendChild(doc.createTextNode(" Java ist auch eine Insel "));
			book.appendChild(title);

			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			DOMSource source = new DOMSource(doc);
			StreamResult streamResult = new StreamResult(new File(filePath));
			transformer.transform(source, streamResult);
		} catch (ParserConfigurationException | TransformerException e) {
			e.printStackTrace();
		}
	}
}
