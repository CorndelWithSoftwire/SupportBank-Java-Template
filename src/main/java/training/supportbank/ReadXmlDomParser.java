package training.supportbank;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Array;
import java.util.ArrayList;

public class ReadXmlDomParser {
    public ArrayList<Transaction> parseXml(String FILENAME) throws IOException {
        //instantuate the factory
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        try{
            //process XML securely
            dbf.setFeature(XMLConstants.FEATURE_SECURE_PROCESSING,true);
            //parse XMl file
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(new File(FILENAME));
            doc.getDocumentElement().normalize();
            //get

        }
    }
}
