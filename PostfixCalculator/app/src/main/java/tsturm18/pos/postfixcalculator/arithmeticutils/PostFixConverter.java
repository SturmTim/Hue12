package tsturm18.pos.postfixcalculator.arithmeticutils;

import java.math.BigDecimal;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

public class PostFixConverter {

    private final String infix;
    private Deque<Character> stack = new ArrayDeque<>();
    private List<String> postfix = new ArrayList<>();
    private String converted;

    public PostFixConverter(String infix) {
        this.infix = infix;

        convertExpression();
    }

    private void convertExpression ( ) {
        StringBuilder stringBuilder = new StringBuilder();

        for (char c : infix.toCharArray()) {
            if(c == '('){
                inputToStack(c);
            }
            else if (c == ')'){
                while(!stack.isEmpty() && stack.peek() != '(') {
                    stringBuilder.append(" ").append(stack.pop());
                }
                    stack.pop();
            }
            else if (c == '+'||c == '-'||c == '*'||c == '/'){
                if(!stack.isEmpty() && getPrecedence(c) <= getPrecedence(stack.peek())) {

                    stringBuilder.append(" ").append(stack.pop());
                }
                inputToStack(c);
                stringBuilder.append(" ");
            }
            else{
                stringBuilder.append(c);
            }
        }
        while(!stack.isEmpty()) {
            stringBuilder.append(" ").append(stack.pop());
        }
        this.converted = stringBuilder.toString();
    }

    private void inputToStack ( char input ){
        stack.push(input);
    }

    private int getPrecedence ( char op ){
        if (op == '*' || op == '/')
            return 2;
        else if (op == '+' || op == '-')
            return 1;
        return -1;
    }

    private void clearStack ( ) {
        stack.clear();
    }

    public String getPostfixExpression ( ) {
        return converted;
    }
    public List<String> getPostfixAsList ( ) {
        return Arrays.asList(getPostfixExpression().split(" "));
    }
}
