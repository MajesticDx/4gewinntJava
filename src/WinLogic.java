import java.util.ArrayList;

public class WinLogic {

    public ArrayList<ArrayList<String>> xList;

    public WinLogic(ArrayList<ArrayList<String>> xList) {
        this.xList = xList;
    }

    public boolean checkWin() {
        return checkHorizontal();
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
            for (int j = 0; j < xList.size(); j++) {
                String currentSymbol = xList.get(j).get(i);
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
}
