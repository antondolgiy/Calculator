import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Created by Anton on 26.10.2017.
 */

/**
 * Stas comments
 * Separate runner and calculator logic.
 * Calculator should have only one public method calculate.
 * Runner should connect to console read line and return result
 * Get rid of useless BracketFinder where you are doing iteration over string twice
 * Get rid of StringBuilder. Use recursion when you find a opening bracket.
 */
public class Calculator {


    public static double calculateIt(String expression) {
        StringParser stringParser = new StringParser(StringBuilder.buildNoInnerBracketString(expression));
        ArrayList<Double> numberArray = stringParser.getNumberArray();
        ArrayList<String> operations = stringParser.getOperations();

        double result = 0;

        int size = operations.size();

        for (int i = 0; i < size; i++) {
            if (operations.get(i).equals("*") || operations.get(i).equals("/")) {
                double a = numberArray.get(i);
                double b = numberArray.get(i + 1);
                double c = 0;
                if (operations.get(i).equals("*")) {
                    c = a * b;
                } else {
                    c = a / b;
                }

                numberArray.set(i, c);
                numberArray.remove(i + 1);
                operations.remove(i);
                size--;
                i--;


            }

        }
        result = numberArray.get(0);
        for (int i = 0; i < operations.size(); i++) {
            if (operations.get(i).equals("+")) {
                result = result + numberArray.get(i + 1);
            }

            if (operations.get(i).equals("-")) {
                result = result - numberArray.get(i + 1);
            }

        }

        return result;
    }




}
