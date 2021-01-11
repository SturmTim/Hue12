package tsturm18.pos.postfixcalculator.arithmeticutils;

import java.math.BigDecimal;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class PostfixCalculator {

    private List<String> expressions;
    private Deque<Double> stack = new ArrayDeque<>();

    public PostfixCalculator(List<String> expressions) {
        this.expressions = expressions;
    }

    public BigDecimal getResult (){
        Double leftNumber;
        Double rightNumber;

        for (int i = 0; i < expressions.size(); i++) {
            char currentChar = expressions.get(i).charAt(0);
            if(currentChar==('+') || currentChar==('-') || currentChar==('*') || currentChar==('/')) {
                rightNumber = stack.pop();
                leftNumber = stack.pop();

                stack.push(calculate(leftNumber, currentChar, rightNumber));
            } else
                stack.push(Double.valueOf(expressions.get(i)));
        }
        return BigDecimal.valueOf(stack.pop());
    }

    private Double calculate(Double left, char expression, Double right) {
        switch (expression){
            case '+':
                return left + right;
            case '-':
                return left - right;
            case '*':
                return left * right;
            default:
                return left / right;
        }

    }
}
