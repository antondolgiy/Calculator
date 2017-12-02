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
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    void getAndProcessTask() {
        while (true) {
            System.out.println("type task to calculate or 'e' to exit");
            String expression = null;
            try {
                expression = reader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }

            if (expression.equals("e")) {
                return;
            }

            try {
                BracketFinder bracketFinder = new BracketFinder(expression);
            } catch (Exception e) {
                return;
            }

            StringParser stringParser = new StringParser(StringBuilder.buildNoInnerBracketString(expression));
            double v = calculateIt(stringParser.getNumberArray(), stringParser.getOperations());
            System.out.println("RESULT:" + v);
        }
    }

    public static double calculateIt(ArrayList<Double> numbers, ArrayList<String> opers) {

        ArrayList<Double> numberArray = new ArrayList<Double>(numbers);
        ArrayList<String> operations = new ArrayList<String>(opers);

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


    public static void main(String[] args) {

        Calculator calculator = new Calculator();
        try {
            calculator.getAndProcessTask();
        } catch (StringParser.WrongExpression e) {
            System.out.println("you've entered some malformed expression");
        }

    }

}
