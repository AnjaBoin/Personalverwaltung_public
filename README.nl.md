[🇩🇪 Deutsch](README.md) | [🇬🇧 English](README.en.md) | 🇳🇱 Nederlands

# Personalverwaltung

Een kleine Java-applicatie voor het beheren van medewerkersgegevens.

## Over dit project

Dit project is ontstaan tijdens mijn stage bij **Bruckmann Steuerungstechnik GmbH**. De opdracht was om in Java een personeelsadministratie te programmeren. Het resultaat staat in deze repository.

## Functies

- Nieuwe medewerkers toevoegen (de ID wordt automatisch toegekend)
- Medewerkersgegevens wijzigen
- Medewerkers verwijderen
- Afdeling kiezen via een dropdownmenu
- Aanwezigheidsstatus vastleggen met een ja/nee-vraag
- Gegevens blijvend opslaan in een tekstbestand en bij het starten weer inladen
- Overzichtelijke, opgemaakte weergave van alle medewerkers in de console

## Projectstructuur

| Klasse        | Taak                                                                      |
|---------------|---------------------------------------------------------------------------|
| `Mitarbeiter` | Definieert het object medewerker met alle velden en kolomnamen            |
| `Verwaltung`  | Regelt het toevoegen, wijzigen, zoeken en verwijderen van medewerkers     |
| `Speicher`    | Slaat de medewerkerslijst op in een tekstbestand en laadt die weer in     |
| `Abteilung`   | Bevat de lijst met afdelingen voor het dropdownmenu                       |
| `TestMain`    | Start het programma met het keuzemenu (JOptionPane)                       |
| `Ausgabe`     | Weergave van de gegevens in een Swing-tabel (in ontwikkeling)             |

## Gebruikte technologieën

- Java
- JOptionPane voor de gebruikersinterface
- IntelliJ IDEA
- Git en GitHub

## Starten

1. Repository klonen:
   ```
   git clone https://github.com/AnjaBoin/Personalverwaltung.git
   ```
2. Project openen in IntelliJ IDEA.
3. `TestMain` uitvoeren.

De medewerkersgegevens worden opgeslagen in `Daten/outputMitarbeiter.txt`.

## Auteur

**Anja Boin**
Stage bij Bruckmann Steuerungstechnik GmbH