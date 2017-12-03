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


    public void parseString(String s) throws NumberFormatException {
        Pattern pattern = Pattern.compile("\\+|-|\\*|/");
        String[] numbers = pattern.split(s);

        List<String> arlist = Arrays.asList(numbers);

        for (String st : arlist) {
            if (!st.isEmpty()) {
                try {
                    Double d = Double.valueOf(st);
                    numberArray.add(d);
                } catch (NumberFormatException e) {
                    throw new NumberFormatException("wrong symbols instead of numbers");

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
                throw new RuntimeException("operator is in wrong position");
            }

        }
    }


}

