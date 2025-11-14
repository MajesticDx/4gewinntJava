import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("How many lines? : ");
        int xHeight = scanner.nextInt();

        System.out.println("How high? : ");
        int yHeight = scanner.nextInt();

        scanner.nextLine();

        System.out.println("Symbol player 1 : ");
        String symbol1 = scanner.nextLine();

        System.out.println("Symbol player 2 : ");
        String symbol2 = scanner.next();

        ArrayList<ArrayList<String>> xList = new ArrayList<>();

        for (int i = 0; i < xHeight; i++) {
            ArrayList<String> yList = new ArrayList<>();
            xList.add(yList);
            for (int j = 0; j < yHeight; j++) {
                yList.add("");
            }
        }

        App app = new App(yHeight, xHeight, xList, symbol1, symbol2);
        app.startGame();

    }
}