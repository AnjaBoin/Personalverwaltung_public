import javax.swing.JOptionPane;

public class TestMain {
    public static Mitarbeiter anmelden(String[] options, Verwaltung verwaltung, String text, String[]optionsAbt){
        String [] antworten = new String [options.length];
        for (int i = 1; i < antworten.length; i ++) {
            if (options[i].equals("Status")) antworten[i] = statusAbfragen();
            else if (options[i].equals("Abteilung")) antworten[i] = abteilungAbfragen("Welche Abteilung?", optionsAbt);
            else antworten[i] = JOptionPane.showInputDialog(options[i]);
        }

        String id = String.valueOf(verwaltung.getMaxId() + 1);

        Mitarbeiter neuerMitarbeiter = new Mitarbeiter(
                id,
                antworten[1],
                antworten[2],
                antworten[3],
                antworten[4],
                antworten[5],
                antworten[6],
                antworten[7],
                antworten[8],
                antworten[9],
                antworten[10]
        );
        return neuerMitarbeiter;
    }

    // Status abfragen
    public static String statusAbfragen() {
        int antwort = JOptionPane.showConfirmDialog(null, "Ist der Mitarbeiter anwesend?",
                "Status", JOptionPane.YES_NO_OPTION);
        if (antwort == JOptionPane.CLOSED_OPTION) return null;
        return String.valueOf(antwort == JOptionPane.YES_OPTION);
    }

    // Abteilung abfragen
    public static String abteilungAbfragen(String text, String[]options) {

        Object obj= JOptionPane.showInputDialog(
                null,
                text,
                "Welcher Abteilung?",
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                options[1]
        );
        return (String) obj;
    }


    public static void main(String[] args) {
        Verwaltung verwaltung = new Verwaltung();
        System.out.println(new java.io.File("Daten/outputMitarbeiter.txt").getAbsolutePath());
        verwaltung.drucken();

        // Wahlmenue
        // Werte definieren
        String optionen[] = { "1. Neuer Mitarbeiter", "2. Mitarbeiterdaten ändern", "3. Mitarbeiter löschen", "5. Ende" };
        boolean menuAktiv = false;

        while (!menuAktiv) {
            int auswahl = 0;
            auswahl = JOptionPane.showOptionDialog(null, "Wählen Sie eine Option", "Auswahl der",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, optionen, optionen[0]);

            if (auswahl == JOptionPane.CLOSED_OPTION) auswahl = 5;

            String []options = Mitarbeiter.SPALTEN;
            String text;
            switch (auswahl) {

                // 0 Neuer Mitarbeiter
                case 0 -> {
                    text = "Füllen Sie Bitte folgende Felder aus:";
                    JOptionPane.showMessageDialog(null, text);
                    Mitarbeiter neu = anmelden(options, verwaltung, text, Abteilung.getAbteilungen());
                    verwaltung.addMitarbeiter(neu);
                    verwaltung.speichern();
                    text = "Der Mitarbeiter " + neu.getNachname() + " ist hinzugefügt.";
                    JOptionPane.showMessageDialog(null, text);
                    verwaltung.drucken();
                }
                // Mitarbeiterdaten ändern
                case 1 -> {
                    // erste Abfrage nach ID
                    text = "Welcher Mitarbeiter möchten Sie ändern? ID angeben bitte:";
                    String id = JOptionPane.showInputDialog(null, text);
                    if (id == null) continue;
                    if (verwaltung.searchMitarbeiter(id) == null) {
                        JOptionPane.showMessageDialog(null, "Die ID " + id + " wurde nicht gefunden.");
                        continue;
                    }

                    // zweite Abfrage nach Datenfeld
                    text = "Welche Daten möchten Sie ändern?";
                    String[]optionsDropDownMenue = Mitarbeiter.FELDER_DDMENUE;
                    Object aendern1= JOptionPane.showInputDialog(
                            null,
                            text,
                            "Mitarbeiter ändern",
                            JOptionPane.QUESTION_MESSAGE,
                            null,
                            optionsDropDownMenue,
                            options[1]
                    );
                    String indexText = (String)aendern1;
                    if (indexText == null) continue;
                    int index = -1;
                    for (int i = 1; i < options.length; i++) {
                        if (indexText.equals(options[i])) index = i;
                    }

                    // Dritte Abfrage nach Änderung
                    if (index == -1) continue;
                    String aendern;
                    text = "Geben Sie den neuen Wert ein für " + indexText + ":";
                    if (indexText.equals("Status")) aendern = statusAbfragen();
                    else if (indexText.equals("Abteilung")) aendern = abteilungAbfragen("Welche Abteilung?", Abteilung.getAbteilungen());
                    else aendern = JOptionPane.showInputDialog(null, text);
                    if (aendern == null) continue;

                    // Änderung durchführen (oder nicht)
                    if (verwaltung.changeMitarbeiter(id, index, aendern)) {
                        text = "Die folgende Daten wurden geändert: " + indexText;
                    } else {
                        text = "Die Änderung wurde nicht durchgeführt.";
                    }
                    JOptionPane.showMessageDialog(null, text);
                    verwaltung.drucken();
                }
                // Mitarbeiter entfernen
                case 2 -> {
                    text = "Welchen Mitarbeiter möchten Sie entfernen? ID angeben bitte:";
                    String entfernen = JOptionPane.showInputDialog(text);
                    if (entfernen == null) continue;
                    JOptionPane.showMessageDialog(null, verwaltung.deleteMitarbeiter(entfernen)
                                    ? "Der Mitarbeiter mit ID " + entfernen + " wurde gelöscht."
                                    : "Die ID " + entfernen + " wurde nicht gefunden.");
                    verwaltung.drucken();
                }

                // 5 Ende
                case 3,5 -> {
                    JOptionPane.showMessageDialog(null, "Auf Wiedersehen!");
                    menuAktiv = true;
                }

            }
            }
    }









}








