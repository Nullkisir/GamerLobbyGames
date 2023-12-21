import java.util.Scanner;
public class dcZitatGame {

    public static void zitatGame() {

        Scanner scan = new Scanner(System.in);
        Scanner scan2 = new Scanner(System.in);
        Scanner scan3 = new Scanner(System.in);
        Scanner scan4 = new Scanner(System.in);

        //Zitate erstellen
        dcZitat zitat = new dcZitat();
        String[] zitate = zitat.zitate;
        String[] wer = zitat.wer;

        //Hier ist das was bei help weiter unten ausgegeben wird
        String moeglicheZitierer = "\nWenn das Zitat von 2. Leuten stammt dann verbindet diese mit einem"
                + " ^und^ \nDie Reihenfolge der Personen ist in diesem Fall sehr wichtig"
                + " \nAlice \nDrache \nNullkisir \nCamo \nNamefall \nLeon \nEmanuel \nDiego \nRandom \nHitler";

        //Spieleranzahl wird fuer spaeter angegeben
        System.out.println("\nBitte tragt einmal die Spieleranzahl ein.");
        int spielerAnzahl = scan2.nextInt();

        //Die Boolean sind dafür da um zu gucken, ob etwas schonmal dran gekommen ist
        boolean[] testen = new boolean[zitate.length];
        boolean[] testen2 = new boolean[spielerAnzahl];

        //die Werte werden für das random Ausgeben der Zitate gebraucht
        int min = 0;
        int max = zitate.length - 1;
        int max2 = spielerAnzahl - 1;

        //Wird spaeter gebraucht
        String zitatRaten = "";

        //Jeder Spieler bekommt im punkteSpieler Array eine Stelle mit 0 Punkten die spaeter erhoet wird
        int[] punkteSpieler = new int[spielerAnzahl];
        for (int i = 0; i < spielerAnzahl; i++) {
            punkteSpieler[i] = 0;
        }

        //Namen
        String[] spielerNamen = new String[spielerAnzahl];
        for (int i = 1; i <= spielerAnzahl; i++) {
            System.out.println("\nSpieler " + i + ". wie heisst du?");
            spielerNamen[i - 1] = scan4.nextLine();
        }

        //Anzahl der Zitate bestimmen
        System.out.println("\n\nBitte sagt wie viele Zitate ihr erraten wollt, max " + zitate.length);
        int anzahlZitateDieWirNehmen = scan3.nextInt();
        System.out.println("\n\n\n\nSpielstart:\n");

        //Das eigentliche Spiel, jedes Zitat wird einmal durchgegangen
        for (int i = 0; i < anzahlZitateDieWirNehmen; i++) {
            int randomNumber = (int) (Math.random() * ((max - min) + 1)) + min;

            //Wenn das Zitat noch nicht dran gekommen ist dann geht er in die if Verzweigung sonst
            //wird unten einer vom i abgezogen, damit er ein neues Zitat raussucht
            if (testen[randomNumber] == false) {
                testen[randomNumber] = true;
                System.out.println(zitate[randomNumber] + "\n");

                //Die Spieler muessen eingaben wer das Zitat wohl gesagt hat
                for (int j = 1; j <= spielerAnzahl; j++) {

                    int randomNumber2 = (int) (Math.random() * ((max2 - min) + 1)) + min;

                    if (testen2[randomNumber2] == false) {
                        testen2[randomNumber2] = true;
                        System.out.println("Was denkt " + spielerNamen[randomNumber2] + " von wem das Zitat ist?");
                        System.out.println("Wenn ihr nicht mehr wisst, wer alles zur verfuegung steht, dann schreibt help");
                        zitatRaten = scan.nextLine();
                        System.out.println("");

                        //Wenn richtig geraten wurde dann bekommt der Spieler einen Punkt
                        if (zitatRaten.equals(wer[randomNumber])) {
                            punkteSpieler[randomNumber2] += 1;
                        }
                    } else {
                        j--;
                    }
                    if (zitatRaten.equals("help")) {
                        System.out.println(moeglicheZitierer);
                        System.out.println("Was denkt " + spielerNamen[randomNumber2] + " von wem das Zitat ist?");
                        zitatRaten = scan.nextLine();
                        System.out.println("");

                        //Wenn richtig geraten wurde dann bekommt der Spieler einen Punkt
                        if (zitatRaten.equals(wer[randomNumber])) {
                            punkteSpieler[randomNumber2] += 1;
                        }

                    }
                }

                System.out.println(wer[randomNumber] + " hat dies gesagt");

                for (int j = 0; j < spielerAnzahl; j++) {
                    testen2[j] = false;
                }

                //Alle 5 Runden wird ein Zwischenstand ausgegeben
                if (i % 5 == 0 && i != 0 && i + 1 != anzahlZitateDieWirNehmen) {
                   /* String[] tempInForSchleife = spielerNamen;
                    spielerNamen = sortierenNamen(punkteSpieler, spielerNamen, spielerAnzahl);
                    punkteSpieler = sortierenPunkte(punkteSpieler, tempInForSchleife, spielerAnzahl);   */

                    //Das ist nur ein Platzhalter zum sortieren der Namen entsprechend der Punkte
                    for (int q = 0; q < spielerAnzahl - 1; q++) {
                        for (int e = q + 1; e < spielerAnzahl; e++) {

                            if (punkteSpieler[q] < punkteSpieler[e]) {
                                String temp2 = spielerNamen[q];
                                spielerNamen[q] = spielerNamen[e];
                                spielerNamen[e] = temp2;
                                int temp3 = punkteSpieler[q];
                                punkteSpieler[q] = punkteSpieler[e];
                                punkteSpieler[e] = temp3;

                            }
                        }
                    }

                    for (int j = 0; j < spielerAnzahl; j++) {
                        if (j == 0) {
                            System.out.println("\n\n");
                        }
                        System.out.println(spielerNamen[j] + " hat " + punkteSpieler[j] + " Punkte.");
                        if (j == spielerAnzahl - 1) {
                            System.out.println("\n\n\n->->->->-> Und weiter geht das Spiel ->->->->->\n\n");
                        }
                    }

                }
                //Ein weiterer Durchgang, wenn das Zitat schon verwendet wurde
            } else {
                i--;
            }
        }

        //Der "Endbildschirm" mit den Punkten der Spieler wird ausgegeben
        System.out.println("\nDas Spiel ist vorbei");

        //Das ist nur ein Platzhalter zum sortieren der Namen entsprechend der Punkte
        /*for (int q = 0; q < spielerAnzahl - 1; q++) {
            for (int e = q + 1; e < spielerAnzahl; e++) {

                if (punkteSpieler[q] < punkteSpieler[e]) {
                    String temp2 = spielerNamen[q];
                    spielerNamen[q] = spielerNamen[e];
                    spielerNamen[e] = temp2;
                    int temp3 = punkteSpieler[q];
                    punkteSpieler[q] = punkteSpieler[e];
                    punkteSpieler[e] = temp3;

                }
            }
        }*/
        //Sollten die sortier Methoden nicht mehr funktionieren dann kann man das wieder entkommentieren und es funktioniert erstmal wieder

        sortierenNamen(punkteSpieler, spielerNamen, spielerAnzahl);
        sortierenPunkte(punkteSpieler, spielerAnzahl);


        for (int i = 0; i < spielerAnzahl; i++) {
            System.out.println(spielerNamen[i] + " hat " + punkteSpieler[i] + " Punkte.");
        }
    }

    public static String[] sortierenNamen(int[] punkteSpieler, String[] spielerNamen, int spielerAnzahl) {
        //Endergebnis wird Sortiert
        for (int i = 0; i < spielerAnzahl - 1; i++) {
            for (int j = i + 1; j < spielerAnzahl; j++) {

                if (punkteSpieler[i] < punkteSpieler[j]) {
                    String temp2 = spielerNamen[i];
                    spielerNamen[i] = spielerNamen[j];
                    spielerNamen[j] = temp2;
                    int temp3 = punkteSpieler[i];
                    punkteSpieler[i] = punkteSpieler[j];
                    punkteSpieler[j] = temp3;

                }
            }
        }

        return spielerNamen;
    }

    public static int[] sortierenPunkte(int[] punkteSpieler, int spielerAnzahl)    {

        for (int i = 0; i < spielerAnzahl - 1; i++) {
            for (int j = i + 1; j < spielerAnzahl; j++) {

                if (punkteSpieler[i] < punkteSpieler[j]) {
                    int temp3 = punkteSpieler[i];
                    punkteSpieler[i] = punkteSpieler[j];
                    punkteSpieler[j] = temp3;
                }
            }
        }
        return punkteSpieler;
    }

}
