package ui;

import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

/**
 * Created by Koen on 11/02/2016.
 */
public class taalKiezer {

    static Locale taal; // De gekozen taal wordt in deze variabele gestopt
    static Locale[] talen = { // Array van alle mogelijke talen
            new Locale("nl", "BE"),
            Locale.FRENCH,
            Locale.ENGLISH
    };

    private static String stringInTaal(String key) { // Vertaalt een 'sleutel' naar de correcte waarde in de gekozen taal

        ResourceBundle labels = ResourceBundle.getBundle("resources.LabelsBundle", taal);

        return labels.getString(key);


    }

    private static void kiesTaal(String ingevoerdeTaal) { // Stopt aan de hand van het meegegeven argument de gekozen taal(indien juist) in de variabele 'taal'

        switch (ingevoerdeTaal.toLowerCase()) {
            case "nederlands":
                taal = talen[0];
                break;
            case "frans":
                taal = talen[1];
                break;
            case "engels":
                taal = talen[2];
                break;
            default:
                System.out.println("Ongeldige taal.");
        }

    }


    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        String newgame;

        while (taal == null) {
            System.out.print("Geef uw taal in(Nederlands, Frans of Engels): ");
            kiesTaal(input.next());
        }

        System.out.printf("%s%n%n", stringInTaal("lang"));
        System.out.printf("%s %s%n", stringInTaal("start"), "(y/n)");

        newgame = input.next();

        if (newgame.equals("y")) {
            System.out.println(stringInTaal("newgame"));
        }


    }
}
