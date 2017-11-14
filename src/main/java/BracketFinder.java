import java.util.*;

/**
 * Created by Anton on 09.11.2017.
 */
public class BracketFinder {

    //map "brackets" where K=position of'(', V=position of matching')'
     private HashMap<Integer, Integer> brackets = new HashMap<Integer, Integer>();

    public BracketFinder(String s){
        findAllBrackets(s);
    }

    //todo
    // what you do in this method?
    // you initialize brackets map by given string.
    // So do you really need this method?
    // Or maybe you can inline its logic into constructor
    // also you can initialize brackets map there too
    public  void findAllBrackets(String s) {
        Stack<Integer> stack = new Stack();

        for (int j = 0; j < s.length(); j++) {
            if (s.charAt(j) == '(') {
                stack.push(j);
                brackets.put(j, null);
            }
            if (s.charAt(j) == ')') {
                brackets.put(stack.pop(),j);
            }
        }
    }

    public int getClosingBracket(int open){

        //todo
        // if calc string was invalid e.g. (1+2 - you'll get here NPE
        // because brackets.get(open) will return null and you return primitive int. unboxing null Integer to int cause NPE
        // it is required to check brackets validity when you parse string for brackets
        return this.brackets.get(open);
    }

}
