/**
 * Created by Anton on 09.11.2017.
 */
public class StringBuilder {

    //todo try to select all and press ctrl+alt+l =)


    public static String buildStringInBrackets(String s){

        String result="";

        if(!s.contains("(")){
            StringParser parser=new StringParser(s);
            result+=Double.toString(Calculator.calculateIt(parser.getNumberArray(), parser.getOperations()));
        }


        else {
            result+="";
               String inDaBraket=buildNoInnerBracketString(s);
               StringParser parser=new StringParser(inDaBraket);
               //todo again hide inner collections. delegate calls or make defensive copies
               //done
               result+=Double.toString(Calculator.calculateIt(parser.getNumberArray(), parser.getOperations()));
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
                noBracketString+=buildStringInBrackets(s.substring(i+1, bracketFinder.getClosingBracket(i)));
                i=bracketFinder.getClosingBracket(i)+1;
            }
        }

        return noBracketString;
    }

}
