import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Anton on 03.12.2017.
 */
public class Runner {
    public static void main(String[] args) {

        BufferedReader reader =new BufferedReader(new InputStreamReader(System.in));
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


            StringParser stringParser = new StringParser(StringBuilder.buildNoInnerBracketString(expression));
            double v = Calculator.calculateIt(stringParser.getNumberArray(), stringParser.getOperations());
            System.out.println("RESULT:" + v);
        }


    }

}
