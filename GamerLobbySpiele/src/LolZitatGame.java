import java.util.Scanner;

public class LolZitatGame {

    public static void zitatGame(){

        Scanner scan = new Scanner(System.in);
        Scanner scan2 = new Scanner(System.in);
        Scanner scan3 = new Scanner(System.in);
        Scanner scan4 = new Scanner(System.in);

        //Zitate erstellen
        LolZitat zitat = new LolZitat();
        String[] zitate = zitat.zitate;
        String[] wer = zitat.wer;

        String[] moeglicheZitierer = new String[5];
        int min = 0;
        int max = zitate.length-1;
        boolean[] testen = new boolean[zitate.length];

        //Spieleranzahl wird fuer spaeter angegeben
        System.out.println("\n Bitte tragt einmal die Spieleranzahl ein.");
        int spielerAnzahl = scan2.nextInt();

        //Jeder Spieler hat spaeter 3. mal eine Hilfestellung, diese wird hier hochgezaehlt
        int[] spielerHilfen = new int[spielerAnzahl];
        for(int i = 0; i<spielerAnzahl; i++){
            spielerHilfen[i] = 3;
        }

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

        //Das Spiel "startet"
        System.out.println("\n\n\n\nSpielstart:\nJeder Spieler hat 3. mal die Moeglichkeit Hilfe zu bekommen\n");

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

                    //Jeder Spieler kann 3. Hilfe bekommen
                    if(zitatRaten.equals("help")){
                        if(spielerHilfen[j-1] != 0){
                            hilfe(wer, moeglicheZitierer, randomNumber);
                            spielerHilfen[j-1]--;
                            System.out.println("Du hast noch " + spielerHilfen[j-1] + " Hilfen uebrig\n");
                        }
                        if(spielerHilfen[j-1] == 0){
                            System.out.println("Leider hast du keine Hilfen mehr uebrig, Versuche es beim naechsten Spiel nochmal :)");
                        }
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

    public static String[] hilfe(String[] wer, String[] moeglicheZitierer, int randomNumber){

        //Wenn man noch darf und help eingibt, werden 5 Champs angezeigt von denen einer der richtige ist
        boolean[] testen2 = new boolean[5];
        boolean testen3 = true;

        for(int k = 0; k<5;k++){
            int randomNumber2 = (int)(Math.random() * 5);
            int randomNumber3 = (int)(Math.random() * 3);
            if(testen2[randomNumber2] == false && randomNumber3 != 1){
                testen2[randomNumber2] = true;
                if(wer.length -5 < randomNumber){
                    moeglicheZitierer[randomNumber2] = wer[randomNumber -k];
                }
                if(randomNumber < wer.length -5){
                    moeglicheZitierer[randomNumber2] = wer[randomNumber +k];
                }
            }
            else if(testen2[randomNumber2] == false && randomNumber3 == 1 && testen3 == true){
                testen2[randomNumber2] = true;
                testen3 = false;
                moeglicheZitierer[randomNumber2] = wer[randomNumber];
            }
            else{
                k--;
            }

        }
        for(int g = 0; g<5;g++){
            System.out.println("Dieser Lol Champ koennte dies gesagt haben " + moeglicheZitierer[g]);
        }
        return moeglicheZitierer;
    }
}
