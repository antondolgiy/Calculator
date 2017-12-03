import java.util.EmptyStackException;

/**
 * Created by Anton on 09.11.2017.
 */
public class StringBuilder {

    //todo try to select all and press ctrl+alt+l =)

    public static String buildStringInBrackets(String s) {

        String result = "";

        if (!s.contains("(")) {
            result += Double.toString(Calculator.calculateIt(s));
        } else {
            result += "";
            String inDaBraket = buildNoInnerBracketString(s);
            result += Double.toString(Calculator.calculateIt(inDaBraket));
        }

        return result;
    }

    public static String buildNoInnerBracketString(String s) {

        String noBracketString = "";

        BracketFinder bracketFinder = new BracketFinder(s);


        int i = 0;
        while (i < s.length()) {
            if (s.charAt(i) != '(') {
                noBracketString += s.charAt(i);
                i++;
            }

            if (i < s.length() - 1 && s.charAt(i) == '(') {
                noBracketString += buildStringInBrackets(s.substring(i + 1, bracketFinder.getClosingBracket(i)));
                i = bracketFinder.getClosingBracket(i) + 1;

            }
        }
        return noBracketString;

    }


}
