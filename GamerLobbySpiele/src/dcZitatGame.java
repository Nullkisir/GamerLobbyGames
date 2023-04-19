import java.util.Scanner;
public class dcZitatGame {

    public static void zitatGame(){

        Scanner scan = new Scanner(System.in);
        Scanner scan2 = new Scanner(System.in);
        Scanner scan3 = new Scanner(System.in);
        Scanner scan4 = new Scanner(System.in);

        //Zitate erstellen
        dcZitat zitat = new dcZitat();
        String[] zitate = zitat.zitate;
        String[] wer = zitat.wer;

        String moeglicheZitierer = "\nWenn das Zitat von 2. Leuten stammt dann verbindet diese mit einem"
                + " ^und^ \nDie Reihenfolge der Personen ist in diesem Fall sehr wichtig"
                + " \nAlice \nDrache \nNullkisir \nCamo \nNamefall \nLeon \nRandom";

        int min = 0;
        int max = zitate.length-1;
        boolean[] testen = new boolean[zitate.length];

        //Spieleranzahl wird fuer spaeter angegeben
        System.out.println("\nBitte tragt einmal die Spieleranzahl ein.");
        int spielerAnzahl = scan2.nextInt();

        //Jeder Spieler bekommt im punkteSpieler Array eine Stelle mit 0 Punkten die spaeter erhoet wird
        int[] punkteSpieler = new int[spielerAnzahl];
        for(int i = 0; i<spielerAnzahl; i++)	{
            punkteSpieler[i] = 0;
        }

        //Namen
        String[] spielerNamen = new String[spielerAnzahl];
        for(int i = 1; i<=spielerAnzahl; i++)	{
            System.out.println("\nSpieler " + i + ". wie heisst du?");
            spielerNamen[i-1] = scan4.nextLine();
        }

        //Anzahl der Zitate bestimmen
        System.out.println("\n\nBitte sagt wie viele Zitate ihr erraten wollt, max " + zitate.length);
        int anzahlZitateDieWirNehmen = scan3.nextInt();
        System.out.println("\n\n\n\nSpielstart:\n");

        //Das eigentliche Spiel, jedes Zitat wird einmal durchgegangen
        for(int i = 0; i<anzahlZitateDieWirNehmen;i++){
            int randomNumber = (int)(Math.random() * ((max - min) + 1)) + min;

            //Wenn das Zitat noch nicht dran gekommen ist dann geht er in die if Verzweigung sonst
            //wird unten einer vom i abgezogen, damit er ein neues Zitat raussucht
            if(testen[randomNumber] == false){
                testen[randomNumber] = true;
                System.out.println(zitate[randomNumber] + "\n");

                //Die Spieler muessen eingaben wer das Zitat wohl gesagt hat
                for(int j = 1; j<=spielerAnzahl; j++){
                    System.out.println("Was denkt " + spielerNamen[j-1] +  " von wem das Zitat ist?");
                    System.out.println("Wenn ihr nicht mehr wisst, wer alles zur verfuegung steht, dann schreibt help");
                    String zitatRaten = scan.nextLine();
                    System.out.println("");

                    //Wenn richtig geraten wurde dann bekommt der Spieler einen Punkt
                    if(zitatRaten.equals(wer[randomNumber])){
                        punkteSpieler[j-1] += 1;
                    }

                    if(zitatRaten.equals("help")){
                        System.out.println(moeglicheZitierer);
                        j--;
                    }
                }

                //Alle 5 Runden wird ein Zwischenstand ausgegeben
                if(i%5==0 && i != 0 && i+1 != anzahlZitateDieWirNehmen){
                    int[] tempInForSchleife = punkteSpieler;
                    spielerNamen = sortierenNamen(tempInForSchleife, spielerNamen, spielerAnzahl);
                    punkteSpieler = sortierenPunkte(punkteSpieler, spielerNamen, spielerAnzahl);


                    for(int j = 0; j<spielerAnzahl; j++){
                        System.out.println(spielerNamen[j] + " hat " + punkteSpieler[j] + " Punkte.");
                    }

                }
                //Ein weiterer Durchgang wenn das Zitat schon verwendet wurde
            }
            else{
                i--;
            }
        }

        //Der "Endbildschirm" mit den Punkten der Spieler wird ausgegeben
        System.out.println("\nDas Spiel ist vorbei");

        //Endergebnis wird in den Methoden sortiert
        int[] temp = punkteSpieler;
        punkteSpieler = sortierenPunkte(punkteSpieler, spielerNamen, spielerAnzahl);
        spielerNamen = sortierenNamen(temp, spielerNamen, spielerAnzahl);

        for(int i = 0; i<spielerAnzahl; i++){
            System.out.println(spielerNamen[i] + " hat " + punkteSpieler[i] + " Punkte.");

        }
    }

    public static String[] sortierenNamen(int[] punkteSpieler, String[] spielerNamen, int spielerAnzahl){
        //Endergebnis wird Sortiert
        for(int i = 0; i<spielerAnzahl-1; i++){
            for(int j = i+1; j<spielerAnzahl; j++){

                if(punkteSpieler[i]<punkteSpieler[j]){
                    String temp2 = spielerNamen[i];
                    spielerNamen[i] = spielerNamen[j];
                    spielerNamen[j] = temp2;
                }
            }
        }

        return spielerNamen;
    }

    public static int[] sortierenPunkte(int[] punkteSpieler, String[] spielerNamen, int spielerAnzahl){
        //Endergebnis wird Sortiert
        for(int i = 0; i<spielerAnzahl-1; i++){
            for(int j = i+1; j<spielerAnzahl; j++){

                if(punkteSpieler[i]<punkteSpieler[j]){
                    int temp = punkteSpieler[i];
                    punkteSpieler[i] = punkteSpieler[j];
                    punkteSpieler[j] = temp;
                }
            }
        }

        return punkteSpieler;
    }
}
