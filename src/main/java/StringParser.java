import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

/**
 * Created by Anton on 30.10.2017.
 */
public class StringParser {
    ArrayList<Double> numberArray =new ArrayList();
    ArrayList<String> operations =new ArrayList();

    //todo Your StringParser class is broken
    //todo
    StringParser(String s){
        parseString(s);
    }


    public  void parseString(String s){
        Pattern pattern =Pattern.compile("\\+|-|\\*|/");
        String []numbers=pattern.split(s);
        List<String> arlist= Arrays.asList(numbers);

        //todo try to rearrange code to be aligned. also good practice is to use {} for every block (ifs, loops, etc.)
        for(String st:arlist){
            if(!st.isEmpty())
            numberArray.add(Double.valueOf(st));

         else

                numberArray.add(Double.valueOf(0));}



        for (int i = 0; i <s.length() ; i++) {
            if(s.charAt(i)=='+')operations.add("+");
            if(s.charAt(i)=='-')operations.add("-");
            if(s.charAt(i)=='/')operations.add("/");
            if(s.charAt(i)=='*')operations.add("*");

        }
    }


}

