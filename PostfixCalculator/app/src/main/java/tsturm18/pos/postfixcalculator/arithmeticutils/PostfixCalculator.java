package tsturm18.pos.postfixcalculator.arithmeticutils;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class PostfixCalculator {

    private final String infix;
    private Deque<Character> stack = new ArrayDeque<>();
    private List<String> postfix = new ArrayList<>();

    public PostfixCalculator(String infix) {
        this.infix = infix;
    }

    private void convertExpression ( ) {

    }

    private void inputToStack ( char input ){

    }

    private int getPrecedence ( char op ){

        return 0;
    }

    private void clearStack ( ) {

    }

    public String getPostfixExpression ( ) {

        return null;
    }
    public List<String> getPostfixAsList ( ) {
        return null;
    }
}
