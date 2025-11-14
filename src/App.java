import java.util.ArrayList;
import java.util.Scanner;

public class App {
    int yHeight;
    int xHeight;
    ArrayList<ArrayList<String>> xList;
    String symbol1;
    String symbol2;
    boolean gameState = false;

    public App (int yH, int xH, ArrayList<ArrayList<String>> xL, String s1, String s2) {
        this.yHeight = yH;
        this.xHeight = xH;
        this.xList = xL;
        this.symbol1 = s1;
        this.symbol2 = s2;
    }

    public void startGame() {
        Scanner scanner = new Scanner(System.in);
        gameState = true;
        while (gameState) {
            printField();
            System.out.println("give row to place : ");
            int block = scanner.nextInt();
            setObject(symbol1, block - 1);
        }
        printField();
        scanner.close();
    }

    public void printField() {
        for (int k = 0; k < yHeight; k++) {
            System.out.print(" | ");
            for (ArrayList<String> yList : xList) {
                String value = yList.get(k);
                if (value.isEmpty()) {
                    System.out.print("  | ");
                } else {
                    System.out.print(value + " | ");
                }
            }
            System.out.println();
        }
    }

    public void setObject(String symbol, int index) {
        if (xList.get(index).getFirst().isEmpty()) {
            xList.get(index).set(0, symbol);
            simulateFall(xList.get(index));
        }
    }

    public void simulateFall(ArrayList<String> checkList) {
        boolean falling = true;
        int n = 1;
        while (falling  && n < checkList.size()) {
            if (checkList.get(n).isEmpty()) {
                checkList.set(n, checkList.get(n-1));
                checkList.set(n-1, "");
                n++;
            } else {
                falling = false;
            }
        }
    }
}
