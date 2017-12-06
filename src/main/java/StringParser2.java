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

    private void parseString(String string) {
        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) != '-' && string.charAt(i) != '+' && string.charAt(i) != '/' && string.charAt(i) != '*') {
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
                    if (i == string.length() - 1) {
                        throw new RuntimeException("expression should not end with operator! ");
                    }
                    if (i < string.length() - 1) operations.add(String.valueOf(string.charAt(i)));

                } else {
                    int openBracket = i;
                    int closingBracket = 0;
                    int match = 1;
                    for (int j = string.length() - 1; j > i; j--) {
                        if (string.charAt(j) == ')') {
                            if (match == 1) closingBracket = j;
                            match--;
                        }
                        if (string.charAt(j) == '(') {
                            match++;
                        }
                    }
                    if (match == 0) {
                        if(closingBracket==openBracket+1){
                            throw new RuntimeException("nothing is brackets!");
                        }
                        try {
                            numberArray.add(Calculator.calculateIt(string.substring(openBracket + 1, closingBracket)));
                        } catch (NumberFormatException e) {
                            throw new RuntimeException("wrong symbols instead of numbers or no open bracket ");
                        }
                        i = closingBracket + 1;
                        if (i == string.length() - 1) {
                            throw new RuntimeException("expression should not end with operator ");
                        } else if (i < string.length() - 1 && string.charAt(i) != '*' && string.charAt(i) != '/' && string.charAt(i) != '+' && string.charAt(i) != '-') {
                            throw new RuntimeException("wrong uppend of brackets  ");
                        } else if (i < string.length() && i != string.length() - 1)
                            operations.add(String.valueOf(string.charAt(i)));
                    } else {
                        throw new RuntimeException("looks like brakets don't mach");
                    }
                }
            } else if (string.charAt(i) == '-') {
                numberArray.add(null);
                operations.add("-");
            } else if (string.charAt(i) == '+' || string.charAt(i) == '*' || string.charAt(i) == '/') {
                throw new RuntimeException("wrong position of operator!! ");
            }
        }

        int size = numberArray.size();
        for (int i = 0; i < size - 1; i++) {
            if (numberArray.get(i) == null && operations.get(i).equals("-")) {
                double temp = numberArray.get(i + 1);
                operations.remove(i);
                numberArray.set(i + 1, -temp);
                numberArray.remove(i);
                size--;
            }
        }
    }
}
