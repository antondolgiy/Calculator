import java.io.IOException;
import java.nio.charset.MalformedInputException;
import java.util.*;

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
            System.out.println(" opening brakets don't match closing brackets");
            throw new Error();

        } catch (EmptyStackException e) {
            System.out.println(" opening brakets don't match closing brackets");
            throw new Error();

        }
    }

    //todo this method can be inlined without any harm =)
    // WUT???
    public void findAllBrackets(String s) throws IOException {
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

    //todo here create necessary methods for put and get from 'this.brackets' map. Field should be private
    //done
    public int getClosingBracket(int open) {

        return this.brackets.get(open);
    }


}
