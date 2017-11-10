import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Created by Anton on 26.10.2017.
 */
public class Calculator {
    BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));

    void getAndProcessTask(){
        System.out.println("type task to calculate or 'e' to exit");
        String expression=null;
        try{
            expression=reader.readLine();
        }
        catch (IOException e){e.printStackTrace();}

        if (expression.equals("e")){return;}

        StringParser stringParser=new StringParser(StringBuilder.buildNoInnerBracketString(expression));
        double v=calculateIt(stringParser.numberArray,stringParser.operations);
        System.out.println("RESULT:"+v);
        getAndProcessTask();
    }

    //todo do not change collections passed as method parameters. Use defensive copies instead (you can google this pattern)
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
        calculator.getAndProcessTask();



        //todo make it run until user want to exit. e.g. print "type task to calculate or exit to exit" after every result
        // (((6+2*5)-(2*2-1))-2)*10



    }

}
