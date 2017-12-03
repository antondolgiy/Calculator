import java.io.IOException;
import java.util.EmptyStackException;
import java.util.HashMap;
import java.util.Stack;

/**
 * Created by Anton on 09.11.2017.
 */
public class BracketFinder {

    //map "brackets" where K=position of'(', V=position of matching')'
    private HashMap<Integer, Integer> brackets = new HashMap<Integer, Integer>();

    public BracketFinder(String s) {
        try {
            findAllBrackets(s);
        } catch (IOException e) {
            System.out.println(" opening brakets don't match closing brackets.");
            throw new RuntimeException(" opening brakets don't match closing brackets.");
        } catch (EmptyStackException e) {
            System.out.println(" opening brakets don't match closing brackets.");
            throw new RuntimeException(" opening brakets don't match closing brackets.");
        }
    }

    public void findAllBrackets(String s) throws IOException  {
        Stack<Integer> stack = new Stack();
        for (int j = 0; j < s.length(); j++) {
            if (s.charAt(j) == '(') {
                stack.push(j);
                brackets.put(j, null);
            }
            if (s.charAt(j) == ')') {
                brackets.put(stack.pop(), j);
            }
        }
        if (!stack.empty()) {
            throw new IOException();
        }
    }

    public int getClosingBracket(int open) {
        return this.brackets.get(open);
    }
}
