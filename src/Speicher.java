import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class  Speicher {
    // hier wird das Laden und Speichern von Mitarbeitern geregelt

    private static final String DATEI_PFAD = "Daten/outputMitarbeiter.txt";
    private static final String TRENNZEICHEN = ",";
    // private List<Mitarbeiter> mitarbeiterListe = new ArrayList<>();

    // Konstruktor
    public Speicher(){

    }

    // speichern von ArrayList mitarbeiterListe in einer txt Datei
    public void speichern(List<Mitarbeiter>liste) throws IOException{
        // FileWriter schreibt die Daten in die Datei outputMitarbeiter.txt
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(DATEI_PFAD))){
            writer.write(String.join(TRENNZEICHEN, Mitarbeiter.SPALTEN));
            writer.newLine();
            for(Mitarbeiter m : liste){
                writer.write(String.join(TRENNZEICHEN, m.alsZeile()));
                writer.newLine();
            }
        }
    }

    // laden von txt und umsetzen in ArrayList mitarbeiterListe
    public List<Mitarbeiter> laden() throws IOException{
        // FileReader liest die Daten aus der Datei outputMitarbeiter.txt
        List<Mitarbeiter> liste = new ArrayList<>();
        // wenn noch keine Liste vorhanden, dann eine leere Liste ausgeben
        File datei = new File(DATEI_PFAD);
        if (!datei.exists()) return liste;

        try (BufferedReader reader= new BufferedReader(new FileReader(DATEI_PFAD))){
            String zeile;
            reader.readLine();
            while ((zeile = reader.readLine()) != null){
                String[] input = zeile.split(TRENNZEICHEN, -1);
                // die Zeilen mit einzelnen Mitarbeitern an der Liste hinzufügen
                liste.add(Mitarbeiter.ausZeile(input));
            }
        }
        return liste;
    }

    public static void main(String[] args){


    }
}
