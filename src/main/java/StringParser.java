import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

/**
 * Created by Anton on 30.10.2017.
 */
public class StringParser {
    class WrongExpression extends RuntimeException {

    }

    private ArrayList<Double> numberArray = new ArrayList();
    private ArrayList<String> operations = new ArrayList();

    public ArrayList<Double> getNumberArray() {

        //defensive copy is also necessary here because when you populate your inner list,
        // anybody can do anything with it outside your class
        //return numberArray;
        return new ArrayList<Double>(numberArray);
    }


    public ArrayList<String> getOperations() {

        //return operations;
        return new ArrayList<String>(operations);

    }

    //todo Your StringParser class is broken
    //todo

    StringParser(String s) {
        parseString(s);
    }


    public void parseString(String s) {
        Pattern pattern = Pattern.compile("\\+|-|\\*|/");
        String[] numbers = pattern.split(s);

        List<String> arlist = Arrays.asList(numbers);

        for (String st : arlist) {
            if (!st.isEmpty()) {
                numberArray.add(Double.valueOf(st));
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
        // check for "8/-4 (is ok)" and "25/*6 (is not ok)" stuff


        // while it is correct to compare operation symbols with == here,
        // hope you understand what you are doing and somehow know about strings interns

        int size = numberArray.size();
        for (int i = 0; i < size; i++) {
            if (numberArray.get(i) == null && operations.get(i) == "-") {
                double temp = numberArray.get(i + 1);
                operations.remove(i);
                numberArray.set(i + 1, -temp);
                numberArray.remove(i);
                size--;
            }
            if (numberArray.get(i) == null && operations.get(i) != "-") {
                throw new WrongExpression();

            }
            if(numberArray.size()==operations.size()){
                throw new WrongExpression();
            }

        }
    }


}

