import java.util.ArrayList;

/**
 * Created by Anton on 04.12.2017.
 */
public class StringParser2 {

    private ArrayList<Double> numberArray = new ArrayList();
    private ArrayList<String> operations = new ArrayList();

    public ArrayList<Double> getNumberArray() {
        return new ArrayList<Double>(numberArray);
    }

    public ArrayList<String> getOperations() {
        return new ArrayList<String>(operations);
    }

    StringParser2(String s) {
        parseString(s);
    }

    public void parseString(String daString) {

        String string = daString;

        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) != '(') {
                int start = i;
                while (i < string.length() && string.charAt(i) != '+' && string.charAt(i) != '-' && string.charAt(i) != '*' && string.charAt(i) != '/') {
                    i++;
                }
                try {
                    numberArray.add(Double.valueOf(string.substring(start, i)));
                } catch (NumberFormatException e) {
                    throw new RuntimeException("wrong symbols instead of numbers or no open bracket ");
                }
                if (i < string.length()) operations.add(String.valueOf(string.charAt(i)));
            } else {
                int open = i;
                int closing = 0;
                int match = 1;
                for (int j = string.length() - 1; j > i; j--) {
                    if (string.charAt(j) == ')') {
                        if (match > 0) closing = j;
                        match--;
                    }
                    if (string.charAt(j) == '(') {
                        match++;
                    }
                }
                if (match == 0) {
                    try {
                        numberArray.add(Double.valueOf(Calculator.calculateIt(string.substring(open + 1, closing))));
                    } catch (NumberFormatException e) {
                        throw new RuntimeException("wrong symbols instead of numbers or no open bracket ");
                    }
                    i = closing + 1;
                    if (i < string.length()) operations.add(String.valueOf(string.charAt(i)));
                } else {
                    throw new RuntimeException("looks like brakets don't mach");
                }
            }
        }
    }

    public static void main(String[] args) {
        StringParser2
    }


}
