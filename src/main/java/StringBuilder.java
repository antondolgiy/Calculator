/**
 * Created by Anton on 09.11.2017.
 */
public class StringBuilder {



    public static String buildStringInBrackets(String s){

        String result="";

        if(!s.contains("(")){
            StringParser parser=new StringParser(s);
            result+=Double.toString(Calculator.calculateIt(parser.numberArray, parser.operations));
        }


        else {
            result+="";
               String inDaBraket=buildNoInnerBracketString(s);
               StringParser parser=new StringParser(inDaBraket);
               result+=Double.toString(Calculator.calculateIt(parser.numberArray, parser.operations));
        }

        return result;
    }

    public static String buildNoInnerBracketString(String s){


        BracketFinder bracketFinder=new BracketFinder(s);

        String noBracketString="";
        int i=0;
        while (i<s.length()) {
            if (s.charAt(i) != '(') {
                noBracketString += s.charAt(i);
                i++;
            }
            if(i<s.length()-1&&s.charAt(i)=='('){
                noBracketString+=buildStringInBrackets(s.substring(i+1, bracketFinder.brackets.get(i)));
                i=bracketFinder.brackets.get(i)+1;
            }
        }

        return noBracketString;
    }

}
