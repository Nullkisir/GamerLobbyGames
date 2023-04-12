import java.util.Scanner;
public class Game {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        //Spielart bestimmen
        System.out.println("Welches Spiel wollt ihr spielen?");
        System.out.println("1: Discord Zitat; 2: Lol Zitat; 3: Fakten Spiel; 4: Schaetzfragen(geht noch nicht) \n");

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