import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

/**
 * Created by Anton on 30.10.2017.
 */
public class StringParser {
    private ArrayList<Double> numberArray = new ArrayList();
    private ArrayList<String> operations = new ArrayList();

    public ArrayList<Double> getNumberArray() {
        return new ArrayList<Double>(numberArray);
    }

    public ArrayList<String> getOperations() {
        return new ArrayList<String>(operations);
    }

    StringParser(String s) {
        parseString(s);
    }

    private void parseString(String s) throws NumberFormatException {
        if (!s.contains("(")) {
            Pattern pattern = Pattern.compile("\\+|-|\\*|/");
            String[] numbers = pattern.split(s);

            List<String> arlist = Arrays.asList(numbers);
            for (String st : arlist) {
                if (!st.isEmpty()) {
                    try {
                        Double d = Double.valueOf(st);
                        numberArray.add(d);
                    } catch (NumberFormatException e) {
                        throw new NumberFormatException("wrong symbols instead of numbers or no open bracket ");
                    }
                } else {
                    numberArray.add(null);
                }
            }

            for (int i = 0; i < s.length(); i++) {
                char x = s.charAt(i);
                switch (x) {
                    case '+':
                        operations.add("+");
                        break;
                    case '-':
                        operations.add("-");
                        break;
                    case '/':
                        operations.add("/");
                        break;
                    case '*':
                        operations.add("*");
                        break;
                }


            }

            int size = numberArray.size();
            for (int i = 0; i < size; i++) {
                if (numberArray.get(i) == null && operations.get(i).equals("-")) {
                    double temp = numberArray.get(i + 1);
                    operations.remove(i);
                    numberArray.set(i + 1, -temp);
                    numberArray.remove(i);
                    size--;
                }
                if (numberArray.get(i) == null && !operations.get(i).equals("-")) {
                    throw new RuntimeException("operator is in wrong position");
                }

                if (numberArray.size() <= operations.size()) {
                    throw new RuntimeException("operator is in wrong position!");
                }
            }
        } else {
            String noBracketString = "";

            int i = 0;
            while (i < s.length()) {
                if (s.charAt(i) != '(') {
                    noBracketString += s.charAt(i);
                    i++;
                }
                if (i < s.length() - 1 && s.charAt(i) == '(') {
                    int openingBracket = i;
                    int closingBracket = 0;
                    int match = 1;

                    for (int j = s.length() - 1; j > i; j--) {
                        if (s.charAt(j) == ')') {
                            if (match > 0) closingBracket = j;
                            match--;
                        }
                        if (s.charAt(j) == '(') {
                            match++;
                        }
                    }
                    if (match == 0) {
                        noBracketString += Calculator.calculateIt(s.substring(openingBracket + 1, closingBracket));
                    } else {
                        throw new RuntimeException("looks like brakets don't mach");
                    }
                    i = closingBracket + 1;
                }
            }
            parseString(noBracketString);
        }
    }
}

