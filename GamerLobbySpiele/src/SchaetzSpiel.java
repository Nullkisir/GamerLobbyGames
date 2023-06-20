import java.util.Scanner;
public class SchaetzSpiel {

    public static void schaetzGame() {

        Scanner scanFuerInteger = new Scanner(System.in);
        Scanner scanFuerString = new Scanner(System.in);
        Scanner scanFuerDouble = new Scanner(System.in);

        //Fakten erstellen
        SchaetzenAbfrage schaetz = new SchaetzenAbfrage();
        String[] schaetzenFrage = schaetz.schaetzen;
        double[] schaetzenAntworten = schaetz.schaetzenAntworten;

        //Spieleranzahl wird ermittelt und gespeichert
        System.out.println("\n Bitte tragt einmal die Spieleranzahl ein.");
        int spielerAnzahl = scanFuerInteger.nextInt();

        //Jeder Spieler kann einen Namen eingeben
        String[] spielerNamen = new String[spielerAnzahl];
        for (int i = 1; i <= spielerAnzahl; i++) {
            System.out.println("\nSpieler " + i + ". wie heisst du?");
            spielerNamen[i - 1] = scanFuerString.nextLine();
        }

        //Die Punkte fuer alle Spieler werden in einem Array gespeichert (die Positionen von diesem Array und dem Spieler
        //Array muessen immer gleich verändert werden, da sonst die Punkte am Ende nicht mehr stimmen
        int[] punkte = new int[spielerAnzahl];
        //Jeder Spieler startet mit 0 Punkten
        for (int i = 0; i < spielerAnzahl; i++) {
            punkte[i] = 0;
        }

        //Abfrage wie viele Schaetzfragen man haben möchte
        System.out.println("Bitte gebt an wie viele Schaetzfragen ihr erraten wollt");
        int anzahlSchaetzfragen = scanFuerInteger.nextInt();

        //Damit nicht die gleichen Schaetzfragen in einer Runde vorkommen koennen, wird ein Boolean Array gemacht
        //der später checkt ob die Frage schon mal vorkam
        boolean[] testen = new boolean[anzahlSchaetzfragen];

        //Damit nicht immer der gleiche Spieler, oder der mit den meisten Punkten anfangen muss, wird hier noch
        //ein Boolean Array erstellt damit er später in der for Schleife verwendet werden kann.
        boolean[] testenSpieler = new boolean[spielerAnzahl];

        System.out.println("\n\n\n\n\n\nNun beginnt das Spiel. \nviel Spass und Erfolg!\n\n\n\n");


        for (int i = 1; i <= anzahlSchaetzfragen; i++) {
            int randomNumber = (int) (Math.random() * ((anzahlSchaetzfragen - 1 - 0) + 1)) + 0;

            //Wenn das Zitat noch nicht dran gekommen ist dann geht er in die if Verzweigung sonst
            //wird unten einer vom i abgezogen, damit er ein neues Zitat raussucht
            if (testen[randomNumber] == false) {
                testen[randomNumber] = true;
                System.out.println(schaetzenFrage[randomNumber] + "\n");

                //Das Boolean Array wird wieder false gesetzt, damit alle wieder dran kommen koennen
                for(int j = 0; j<testenSpieler.length; j++) {
                    testenSpieler[j] = false;
                }

                //Die Spieler muessen die richtige Zahl nun schaetzen
                for (int j = 1; j <= spielerAnzahl; j++) {
                    //Hier wird ein Spieler random ausgewaehlt um die Reihenfolge der Runde zu bestimmen
                    int randomNumberFuerSpieler = (int) (Math.random() * ((testenSpieler.length - 1 - 0) + 1)) + 0;

                    //Hier wird ermittelt welcher Spieler an der Reihe ist mit seiner Eingabe
                    if (testenSpieler[randomNumberFuerSpieler] == false) {
                        testenSpieler[randomNumberFuerSpieler] = true;

                        System.out.println("Was denkt " + spielerNamen[j - 1] + " was fuer eine Zahl richtig ist?");
                        double schaetzen = scanFuerDouble.nextDouble();

                        //Es wird eine Art Puffer eingebaut, damit nicht immer genau richtig tippen muss
                        double untereProzente = schaetzenAntworten[randomNumber] * 0.9;
                        double obereProzente = schaetzenAntworten[randomNumber] * 1.1;

                        //Wenn richtig geraten wurde dann bekommt der Spieler einen Punkt +-10%
                        if (schaetzen <= obereProzente && schaetzen >= untereProzente) {
                            punkte[randomNumberFuerSpieler] += 1;
                        }
                    }
                    else    {
                        j --;
                    }
                }
                //Alle 5 Runden wird ein Zwischenstand ausgegeben
                if (i % 5 == 0 && i != 0 && i + 1 != anzahlSchaetzfragen) {
                    //In den zwei Methoden werden die Spieler anhand der Punkte sortiert und die Punkte werden auch in den
                    //Positionen getauscht
                    int[] temp = punkte;
                    punkte = sortierenPunkte(punkte, spielerNamen, spielerAnzahl);
                    spielerNamen = sortierenNamen(temp, spielerNamen, spielerAnzahl);

                    //Nach der Sortierung werden hier die Punkte der Spieler ausgegeben, anfangend mit dem Spieler
                    //der die meisten Punkte hat bis zu dem mit den wenigsten
                    for(int j = 0; j<spielerAnzahl; j++){
                        System.out.println(spielerNamen[j] + " hat " + punkte[j] + " Punkte.");
                    }
                    //Ein weiterer Durchgang, wenn die Schaetzfrage schon verwendet wurde
                } else {
                    i--;
                }
            }
        }
    }
        public static String[] sortierenNamen ( int[] punkteSpieler, String[] spielerNamen,int spielerAnzahl){
            //Endergebnis wird Sortiert
            for (int i = 0; i < spielerAnzahl - 1; i++) {
                for (int j = i + 1; j < spielerAnzahl; j++) {

                    if (punkteSpieler[i] < punkteSpieler[j]) {
                        String temp2 = spielerNamen[i];
                        spielerNamen[i] = spielerNamen[j];
                        spielerNamen[j] = temp2;
                    }
                }
            }

            return spielerNamen;
        }

        public static int[] sortierenPunkte(int[] punkteSpieler, String[] spielerNamen,int spielerAnzahl){
            //Endergebnis wird Sortiert
            for (int i = 0; i < spielerAnzahl - 1; i++) {
                for (int j = i + 1; j < spielerAnzahl; j++) {

                    if (punkteSpieler[i] < punkteSpieler[j]) {
                        int temp = punkteSpieler[i];
                        punkteSpieler[i] = punkteSpieler[j];
                        punkteSpieler[j] = temp;
                    }
                }
            }

            return punkteSpieler;
        }

}