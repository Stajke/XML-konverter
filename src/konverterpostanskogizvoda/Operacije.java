package konverterpostanskogizvoda;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class Operacije {
    
    
    public static String vratiAtributZaglavlje(String atribut){
        if(atribut.equals("Racun"))
            return "Partija=\"";
        else if(atribut.equals("BrojIzvoda"))
            return "IzvodID=\"";
        else if(atribut.equals("DatumIzvoda"))
            return "DatumIzvoda=\"";
        else if(atribut.equals("NazivUcesnikaPP"))
            return "NazivFirme=\"";
        else if(atribut.equals("PrethodnoStanje"))
            return "PrethodnoStanje=\"";
        else if(atribut.equals("DugovniPromet"))
            return "UkupnoOdobrenje=\"";
        else if(atribut.equals("PotrazniPromet"))
            return "UkupnoZaduzenje=\"";
        else if(atribut.equals("NovoStanje"))
            return "RaspolozivoStanje=\"";
        else if(atribut.equals("DatumRada"))
            return "DatumPocetka=\"";
        else
            return "";
    }
    
    
    public static String vratiAtributStavke(String atribut){
        if(atribut.equals("DatumKnjizenja"))
            return "DatumObrade=\"";
        else if(atribut.equals("DatumValute"))
            return "DatumValute=\"";
        else if(atribut.equals("IznosPot"))
            return "Potrazuje=\"";
        else if(atribut.equals("IznosDug"))
            return "Duguje=\"";
        else if(atribut.equals("Opis2"))
            return "Opis9=\"";
        else if(atribut.equals("Osnov"))
            return "Opis6=\"";
        else if(atribut.equals("RacunNal"))
            return "Opis5=\"";
        else if(atribut.equals("Opis1"))
            return "Opis3=\"";
        else
            return "";
    }
    
    
    public static String vratiVrednost(String atribut, String vrednost){
        if(!vrednost.isEmpty() && ( atribut.contains("Datum")))
            return vrednost.substring(8, 10) + "." + vrednost.substring(5, 7) + "." + vrednost.substring(0, 4) + "\" ";
        else if(    atribut.equals("NazivNal") ||
                    atribut.equals("MestoNal") ||
                    atribut.equals("Model") ||
                    atribut.equals("Poziv") ||
                    atribut.equals("ModelVezni") ||
                    atribut.equals("PozivVezni") ||
                    atribut.equals("BrojNaloga") ||
                    atribut.equals("BrojVirmana") ||
                    atribut.equals("BrojStavkiPotrazuje") ||
                    atribut.equals("BrojStavkiDuguje") ||
                    atribut.equals("Napomena")
                )
            return "";
        else if(!vrednost.isEmpty())
            return vrednost + "\" ";
        else if(vrednost.isEmpty())
            return "\" ";
        else
            return "";
    }
    
    
    public static int brojNaloga(Document dokument){
        NodeList brojNaloga = dokument.getElementsByTagName("Prom");
        return brojNaloga.getLength();
    }
    
    
}