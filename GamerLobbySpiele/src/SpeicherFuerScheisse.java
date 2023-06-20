 //import java.util.Scanner;
    //public class SchaetzSpiel {

        //public static void schaetzGame(){
/*
        Scanner scan = new Scanner(System.in);
        Scanner scan2 = new Scanner(System.in);
        Scanner scan3 = new Scanner(System.in);
        Scanner scan4 = new Scanner(System.in);

        //Fakten erstellen
        SchaetzenAbfrage schaetz = new SchaetzenAbfrage();
        String[] schaetzen = schaetz.schaetzen;
        double[] schaetzenAntworten = schaetz.schaetzenAntworten;

        int min = 0;
        int max = schaetzen.length-1;
        boolean[] testen = new boolean[schaetzen.length];

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

        //Anzahl der Schaetzfragen bestimmen
        System.out.println("\n\nBitte sagt wie viele Schaetzfragen ihr erraten wollt, max " + schaetzen.length);
        int anzahlSchaetzfragenDieWirNehmen = scan3.nextInt();
        System.out.println("\n\n\n\nSpielstart:\n");

        //Das eigentliche Spiel
        for(int i = 0; i<anzahlSchaetzfragenDieWirNehmen;i++){
            int randomNumber = (int)(Math.random() * ((max - min) + 1)) + min;

            //Wenn die Schaetzfrage noch nicht dran gekommen ist dann geht er in die if Verzweigung sonst
            //wird unten einer vom i abgezogen, damit er einen neuen Fakt raussucht
            if(testen[randomNumber] == false){
                testen[randomNumber] = true;
                System.out.println(schaetzen[randomNumber]);

                //Die Spieler muessen schaetzen
                for(int j = 1; j<=spielerAnzahl; j++){
                    System.out.println("Was denkt " + spielerNamen[j-1] +  " was ist richitg?");


                    //scaner mit double Zahlen muss eingebaut werden
                   // double schaetzenRaten = scan.nextLine();


                    System.out.println("");

                    //Wenn richtig geraten wurde dann bekommt der Spieler einen Punkt


                    //Hier eine Toleranz mit einbauen evtl. 10% oder so
                   // if(schaetzenRaten<(schaetzenAntworten[randomNumber])){


                        punkteSpieler[j-1] += 1;
                    }
                }
                System.out.println("\n\nDie richtige Antwort war " + schaetzenAntworten[randomNumber] + "\n");

                //Alle 5 Runden wird ein Zwischenstand ausgegeben
                if(i%5==0 && i != 0 && i+1 != anzahlSchaetzfragenDieWirNehmen){
                    int[] tempInForSchleife = punkteSpieler;
                    spielerNamen = sortierenNamen(tempInForSchleife, spielerNamen, spielerAnzahl);
                    punkteSpieler = sortierenPunkte(punkteSpieler, spielerNamen, spielerAnzahl);


                    for(int j = 0; j<spielerAnzahl; j++){
                        System.out.println(spielerNamen[j] + " hat " + punkteSpieler[j] + " Punkte.");
                    }

                }
                //Ein weiterer Durchgang wenn der Fakt schon verwendet wurde
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


    */
