
import java.util.ArrayList;

/**
 * Created by Anton on 26.10.2017.
 */
public class Calculator {


    public static double calculateIt(String expression) {
        StringParser2 stringParser = new StringParser2(expression);
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
