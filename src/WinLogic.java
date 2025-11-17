import java.util.ArrayList;

public class WinLogic {

    public ArrayList<ArrayList<String>> xList;

    public WinLogic(ArrayList<ArrayList<String>> xList) {
        this.xList = xList;
    }

    public boolean checkWin() {
        return checkDiagonal();
    }

    public boolean checkVertical() {
        boolean result = false;
        for (ArrayList<String> yList : xList) {
            int counter = 1;
            String recentSymbol = "";
            for(String y : yList) {
                if (!(y.isEmpty()) && y.equals(recentSymbol)) {
                    counter++;
                } else {
                    recentSymbol = y;
                    counter = 1;
                }

                if (counter == 4) {
                    result = true;
                }
            }
        }
        return result;
    }

    public boolean checkHorizontal() {
        boolean result = false;
        int len = xList.getFirst().size();
        for (int i = 0; i < len; i++) {
            int counter = 1;
            String recentSymbol = "";
            for (ArrayList<String> strings : xList) {
                String currentSymbol = strings.get(i);
                if (!(currentSymbol.isEmpty()) && currentSymbol.equals(recentSymbol)) {
                    counter++;
                } else {
                    recentSymbol = currentSymbol;
                    counter = 1;
                }

                if (counter == 4) {
                    result = true;
                }
            }
        }
        return result;
    }

    public boolean checkDiagonal() {
        boolean result = false;
        for (int i = 0; i < xList.getFirst().size() - 3; i++) {  //vertical number of iterations
            for (int j = 0; j < xList.size() - 3; j++) {  //horizontal number of iterations
                int counter = 1;
                String recentSymbol = "";
                for (int k = 0; k < 4; k++) {
                    String currentSymbol = xList.get(j + k).get(k + i);
                    if (!(currentSymbol.isEmpty()) && currentSymbol.equals(recentSymbol)) {
                        counter++;
                    } else {
                        recentSymbol = currentSymbol;
                        counter = 1;
                    }

                    if (counter == 4) {
                        result = true;
                    }
                }
            }
        }
        return result;
    }
}
