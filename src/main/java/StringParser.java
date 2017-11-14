import java.io.IOException;
import java.lang.reflect.Array;
import java.nio.charset.MalformedInputException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.EmptyStackException;
import java.util.List;
import java.util.regex.Pattern;

/**
 * Created by Anton on 30.10.2017.
 */
public class StringParser {
    class WrongExpression extends RuntimeException{

    }
   private ArrayList<Double> numberArray =new ArrayList();
   private ArrayList<String> operations =new ArrayList();

   public ArrayList<Double> getNumberArray(){

       return numberArray;
   }

   public ArrayList<String> getOperations(){

       return operations;

   }

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
            if(!st.isEmpty()){
            numberArray.add(Double.valueOf(st));}

         else {

                numberArray.add(null);}


        }

        for (int i = 0; i <s.length() ; i++) {
            if(s.charAt(i)=='+')operations.add("+");
            if(s.charAt(i)=='-')operations.add("-");
            if(s.charAt(i)=='/')operations.add("/");
            if(s.charAt(i)=='*')operations.add("*");

        }
        // check for "8/-4 (is ok)" and "25/*6 (is not ok)" stuff
        int size=numberArray.size();
        for (int i = 0; i <size ; i++) {
            if(numberArray.get(i)==null&&operations.get(i)=="-"){
                double temp=numberArray.get(i+1);
                operations.remove(i);
                numberArray.set(i+1,-temp);
                numberArray.remove(i);
                size--;
            }
            if(numberArray.get(i)==null&&operations.get(i)!="-"){
                throw new WrongExpression();
            }

        }
        }



}

