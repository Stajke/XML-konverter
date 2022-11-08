package konverterpostanskogizvoda;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class CitanjePS {
    
    public static void konvertujPS(String imeFajla) throws ParserConfigurationException, SAXException, IOException {
        
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document dokument = builder.parse(new File(imeFajla));
        dokument.getDocumentElement().normalize();
        
        String izlazniDokument = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n<TransakcioniRacunPrivredaIzvod>";
        
        int brojNaloga = Operacije.brojNaloga(dokument);
        NodeList brojIzvoda = dokument.getChildNodes();
        for(int i = 0; i < brojIzvoda.getLength(); i++) {
            Node tag1 = brojIzvoda.item(i);
            izlazniDokument = izlazniDokument.concat("<Zaglavlje OVERDRAFTENG=\"\" OVERDRAFTSRB=\"\" ");
            if(tag1.getChildNodes().getLength() > 1){
                NodeList lista2 = tag1.getChildNodes();
                for (int j=0; j<lista2.getLength(); j++) {
                    Node tag3 = lista2.item(j);
                    if(j == lista2.getLength() - brojNaloga){
                        izlazniDokument = izlazniDokument.concat("OznakaValute=\"RSD\" TipRacuna=\"Tekući račun komitenata\" TipIzvoda=\"Dnevni\" />");
                    }
                    if(tag3.getChildNodes().getLength() > 1){
                        izlazniDokument = izlazniDokument.concat("<Stavke ");
                        for (int k=0; k<tag3.getChildNodes().getLength(); k++) {
                            NodeList tag4 = tag3.getChildNodes();
                            izlazniDokument = izlazniDokument.concat(Operacije.vratiAtributStavke(tag4.item(k).getNodeName()) + Operacije.vratiVrednost(tag4.item(k).getNodeName(), tag4.item(k).getTextContent()));
                        }
                        izlazniDokument = izlazniDokument.concat("/>");
                    }
                    else{
                        izlazniDokument = izlazniDokument.concat(Operacije.vratiAtributZaglavlje(tag3.getNodeName()) + Operacije.vratiVrednost(tag3.getNodeName(), tag3.getTextContent()));
                    }
                }
            }
        }
        
        izlazniDokument = izlazniDokument.concat("</TransakcioniRacunPrivredaIzvod>");
        
        FileWriter myWriter = new FileWriter(imeFajla);
        myWriter.write(izlazniDokument);
        myWriter.close();
        
    }
    
    
    public static void konvertujPSnovi(String imeFajla) throws ParserConfigurationException, SAXException, IOException {
        
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document dokument = builder.parse(new File(imeFajla));
        dokument.getDocumentElement().normalize();
        
        String izlazniDokument = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n<TransakcioniRacunPrivredaIzvod>";
        
        int brojNaloga = Operacije.brojNaloga(dokument);
        NodeList brojIzvoda = dokument.getChildNodes();
        for(int i = 0; i < brojIzvoda.getLength(); i++) {
            Node tag1 = brojIzvoda.item(i);
            izlazniDokument = izlazniDokument.concat("<Zaglavlje OVERDRAFTENG=\"\" OVERDRAFTSRB=\"\" ");
            if(tag1.getChildNodes().getLength() > 1){
                NodeList lista2 = tag1.getChildNodes();
                for (int j=0; j<lista2.getLength(); j++) {
                    Node tag3 = lista2.item(j);
                    if(j == lista2.getLength() - brojNaloga){
                        izlazniDokument = izlazniDokument.concat("OznakaValute=\"RSD\" TipRacuna=\"Tekući račun komitenata\" TipIzvoda=\"Dnevni\" />");
                    }
                    if(tag3.getChildNodes().getLength() > 1){
                        izlazniDokument = izlazniDokument.concat("<Stavke ");
                        for (int k=0; k<tag3.getChildNodes().getLength(); k++) {
                            NodeList tag4 = tag3.getChildNodes();
                            izlazniDokument = izlazniDokument.concat(Operacije.vratiAtributStavke(tag4.item(k).getNodeName()) + Operacije.vratiVrednost(tag4.item(k).getNodeName(), tag4.item(k).getTextContent()));
                        }
                        izlazniDokument = izlazniDokument.concat("/>");
                    }
                    else{
                        izlazniDokument = izlazniDokument.concat(Operacije.vratiAtributZaglavlje(tag3.getNodeName()) + Operacije.vratiVrednost(tag3.getNodeName(), tag3.getTextContent()));
                    }
                }
            }
        }
        
        izlazniDokument = izlazniDokument.concat("</TransakcioniRacunPrivredaIzvod>");
        
        //FileWriter myWriter = new FileWriter(imeFajla + " - Prepravljen");
        FileWriter myWriter = new FileWriter(imeFajla.substring(0, imeFajla.length() - 4) + " - Prepravljen.XML");
        myWriter.write(izlazniDokument);
        myWriter.close();
        
    }
    
}
