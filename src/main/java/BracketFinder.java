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
            System.out.println(" opening brakets don't match closing brackets.");
            throw new Error();

        } catch (EmptyStackException e) {
            System.out.println(" opening brakets don't match closing brackets.");
           throw new Error();

        }
    }


    //todo
    // what you do in this method?
    // you initialize brackets map by given string.
    // So do you really need this method?
    // Or maybe you can inline its logic into constructor
    // also you can initialize brackets map there too

    /* Well I believe it makes  code more understandable... like looking at constructor, you may see
       that object is initialised with some String as parameter,
       and name of method "findAllbrackets" inside the constructor gives a good hint,
       that resulting object incapsulates info about "all brackets" in dat string.
    */

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

        // if numberof'(' != numberof')', in the end, stack will either be not empty
        // or it will try to pop element from empty stack
        if (!stack.empty()) {
            throw new IOException();
        }
    }


    //todo here create necessary methods for put and get from 'this.brackets' map. Field should be private
    //done
    public int getClosingBracket(int open) {


        //todo
        // if calc string was invalid e.g. (1+2 - you'll get here NPE
        // because brackets.get(open) will return null and you return primitive int. unboxing null Integer to int cause NPE
        // it is required to check brackets validity when you parse string for brackets

        //I've just delegated this shit to Calculator.getAndProcessTask()
        return this.brackets.get(open);
    }


}
