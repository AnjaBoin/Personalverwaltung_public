public class Mitarbeiter {
    // in dieser Klasse wird das Objekt Mitarbeiter definiiert

    // KONSTANTEN
    // Formattierung fuer die Konsolenausgabe
    public static final String FORMAT = "%-4s | %-20s | %-25s | %-8s %-15s | %-12s | %-14s | %-6s | %s";
    // Kopfzeile fuer Tabelle und andere Ausgabemoeglichkeiten
    public static final String[] SPALTEN = {"Id, Nachname, Vorname, Adresse, Hausnummer, Plz, Wohnort, Telefon, Geburtsdatum, Status, Abteilung"};
    // Kopfzeile fuer Methode Drucken (Verwaltung)
    public static final String[] SPALTEN_DRUCKEN = {"Id", "Name", "Adresse", "PLZ", "Wohnort", "Telefon", "Geburtsdatum", "Status", "Abteilung"};
    // Felder fÜr Drop Down Menü
    public static final String [] FELDER_DDMENUE= {"Nachname", "Vorname", "Adresse", "Hausnummer", "Plz", "Wohnort",
            "Telefon", "Geburtsdatum", "Status", "Abteilung"};

    // FELDER
    private String id;
    private String nachname;
    private String vorname;
    private String adresse;
    private String hausnummer;
    private String plz;
    private String wohnort;
    private String telefon;
    private String geburtsdatum;
    private String status;
    private String abteilung;


    // KONSTRUKTOR
    public Mitarbeiter(
            String id, String nachname, String vorname, String adresse, String hausnummer, String plz,
            String wohnort, String telefon, String geburtsdatum, String status, String abteilung
    ){
        this.id = id;
        this.nachname = nachname;
        this.vorname = vorname;
        this.adresse = adresse;
        this.hausnummer = hausnummer;
        this.plz = plz;
        this.wohnort = wohnort;
        this.telefon = telefon;
        this.geburtsdatum = geburtsdatum;
        this.status = status;
        this.abteilung = (abteilung == null) ? "" : abteilung;
    }

    // GETTERS
    public String getId(){
        return id;
    }
    public String getNachname(){
        return nachname;
    }
    public String getVorname(){
        return vorname;
    }
    public String getAdresse(){
        return adresse;
    }
    public String getHausnummer(){
        return hausnummer;
    }
    public String getPlz(){return plz;}
    public String getWohnort(){
        return wohnort;
    }
    public String getTelefon(){
        return telefon;
    }
    public String getGeburtsdatum(){
        return geburtsdatum;
    }
    public String getStatus(){
        return status;
    }
    public String getAbteilung(){
        return abteilung;
    }

    // SETTERS
    public void setId(String newId){
        id = newId;
    }
    public void setNachname(String newNachname){
        nachname = newNachname;
    }
    public void setVorname(String newVorname){
        vorname = newVorname;
    }
    public void setAdresse(String newAdresse){
        adresse = newAdresse;
    }
    public void setHausnummer(String newHausnummer){
        hausnummer = newHausnummer;
    }
    public void setPlz(String newPlz){
        plz = newPlz;
    }
    public void setWohnort(String newWohnort){
        wohnort = newWohnort;
    }
    public void setTelefon(String newTelefon){
        telefon = newTelefon;
    }
    public void setGeburtsdatum(String newGeburtsdatum){
        geburtsdatum = newGeburtsdatum;
    }
    public void setStatus(String newStatus){
        status = newStatus;
    }
    public void setAbteilung(String newAbteilung){
        abteilung = newAbteilung;
    }

    // AUSGABE ANPASSEN
    @Override
    public String toString() {
        return String.format(FORMAT,
                id,
                nachname + ", " + vorname,
                adresse + " " + hausnummer,
                plz, wohnort,
                telefon,
                geburtsdatum,
                status,
                abteilung);
    }

    // Mitarbeiter als Zeile definiiert für Tabelle oder andere Ausgabemöglichkeiten
    public String[] alsZeile() {
        return new String[] {id, nachname, vorname, adresse, hausnummer, plz,
                wohnort, telefon, geburtsdatum, status, abteilung};
    }
    // Mitarbeiter erstellen aus einer Zeile Werte
    public static Mitarbeiter ausZeile(String[] w) {
        return new Mitarbeiter(w[0], w[1], w[2], w[3], w[4], w[5],
                w[6], w[7], w[8], w[9], w[10]);
    }

}
