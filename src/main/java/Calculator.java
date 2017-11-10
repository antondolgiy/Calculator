import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Created by Anton on 26.10.2017.
 */
public class Calculator {
    BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));

    String getTask(){
        System.out.println("type task to calculate");
        String expression=null;
        try{
            expression=reader.readLine();}
        catch (IOException e){e.printStackTrace();}

        return expression;
    }

    public static double calculateIt(ArrayList<Double> numberArray,ArrayList<String> operations){
        double result=0;

        int size=operations.size();
        for (int i = 0; i <size ; i++){
            if (operations.get(i).equals("*")||operations.get(i).equals("/")){
                double a=numberArray.get(i);
                double b=numberArray.get(i+1);
                double c=0;
                if(operations.get(i).equals("*"))
                {c=a*b;}
                else {
                    c=a/b;}

                numberArray.set(i,c);
                numberArray.remove(i+1);
                operations.remove(i);
                size--;
                i--;


            }

        }
        result=numberArray.get(0);
        for (int i = 0; i <operations.size() ; i++) {
            if (operations.get(i).equals("+")){
                result=result+numberArray.get(i+1);
            }

            if (operations.get(i).equals("-")){
                result=result-numberArray.get(i+1);
            }

        }

        return result;
    }


    public static void main(String[] args) {

        Calculator calculator =new Calculator();
        String task= calculator.getTask();

        StringParser stringParser=new StringParser(StringCalculatorBuilder.buildNoInnerBracketString(task));
        double v=calculateIt(stringParser.numberArray,stringParser.operations);
        System.out.println("RESULT:"+v);

        // (((6+2*5)-(2*2-1))-2)*10


    }

}
