package tsturm18.pos.postfixcalculator.arithmeticutils;

import java.math.BigDecimal;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

public class PostFixConverter {
    private List<String> expressions;
    private Deque<Double> stack = new ArrayDeque<>();

    public PostFixConverter(List<String> expressions) {
        this.expressions = expressions;
    }

    public BigDecimal getResult (){

        return null;
    }
}
