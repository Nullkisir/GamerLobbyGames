/*
Was noch gemacht werden muss:
1. Ein Modus wo alle Spiele kombiniert werden...
2. Das hier in einen Discord Bot integrieren
3. ?? @camo @drache @alice habt ihr noch was ??
 */
import java.util.Scanner;
public class Game {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        //Spielart bestimmen
        System.out.println("Welches Spiel wollt ihr spielen?");
        System.out.println("1: Discord Zitat; 2: Lol Zitat; 3: Fakten Spiel; 4: Schaetzfragen(Punktezuornen/Personen richtig sortieren geht noch nicht) \n");

        int Spielart = scan.nextInt();

        switch (Spielart) {
            case 1:
                dcZitatGame.zitatGame();
                break;
            case 2:
                LolZitatGame.zitatGame();
                break;
            case 3:
                FaktenSpiel.faktenGame();
                break;
            case 4:
                SchaetzSpiel.schaetzGame();
                break;
        }
    }
}
