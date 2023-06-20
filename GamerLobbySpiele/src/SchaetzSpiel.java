import java.util.Scanner;
public class SchaetzSpiel {

    public static void schaetzGame(){

        Scanner scanFuerInteger = new Scanner(System.in);
        Scanner scanFuerString = new Scanner(System.in);

        //Fakten erstellen
        SchaetzenAbfrage schaetz = new SchaetzenAbfrage();
        String[] schaetzen = schaetz.schaetzen;
        double[] schaetzenAntworten = schaetz.schaetzenAntworten;

        //Spieleranzahl wird ermittelt und gespeichert + jeder Spieler kann einen Namen eingeben
        System.out.println("\n Bitte tragt einmal die Spieleranzahl ein.");
        int spielerAnzahl = scanFuerInteger.nextInt();

        String[] spielerNamen = new String[spielerAnzahl];
        for(int i = 1; i<=spielerAnzahl; i++)	{
            System.out.println("\nSpieler " + i + ". wie heisst du?");
            spielerNamen[i-1] = scanFuerString.nextLine();
        }

        //Abfrage wie viele Schaetzfragen man haben möchte
        System.out.println("Bitte gebt an wie viele Schaetzfragen ihr erraten wollt");
        int anzahlSchaetzfragen = scanFuerInteger.nextInt();

        for(int i = 1; i<=anzahlSchaetzfragen; i++) {
            System.out.println(i);
        }

    }
}