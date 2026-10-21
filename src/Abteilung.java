// diese Klasse speichert alle Abteilungen fuer ein DropDownMenue

public class Abteilung {

    private String abteilung;
    private static final String[] ABTEILUNGEN = {
            "Aussendienst", "Innendienst", "Buchhaltung", "Verwaltung", "Geschäftsführung",
            "IT", "Projekt", "Technik", "Personalmanagement", "nicht zugewiesen"
    };

    // Konstruktor
    public Abteilung(){
        this.abteilung = abteilung;
    }

    // Getter
    public static String[] getAbteilungen(){
        return ABTEILUNGEN;
    }

    // Setter
    public void setAbteilungen(String newAbteilung){
        abteilung = newAbteilung;
    }

    @Override
    public String toString(){
        return "Abteilung ist: " + abteilung;

    }

    public static void main(String[] args){



        for (String abt : ABTEILUNGEN){
            System.out.println(abt);
        }
    }


}

