import java.util.*;

/**
 * Created by Anton on 09.11.2017.
 */
public class BracketFinder {

    //map "brackets" where K=position of'(', V=position of matching')'
     HashMap<Integer, Integer> brackets = new HashMap<Integer, Integer>();

    public BracketFinder(String s){
        findAllBrackets(s);
    }

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


}
