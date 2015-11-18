package cz.fit.dpo.cbi;

import cz.fit.dpo.cbi.arithmetic.AddOperator;
import cz.fit.dpo.cbi.arithmetic.ArithmeticExpression;
import cz.fit.dpo.cbi.arithmetic.NumericOperand;
import cz.fit.dpo.cbi.arithmetic.SubstractOperator;

import java.util.Stack;

/**
 * Created by Pavel on 18.11.2015.
 */
public class AEBuilderDirector {

    private final ExpressionBuilder builder;

    public AEBuilderDirector(ExpressionBuilder builder) {
        this.builder = builder;

    }

    public void constructFromRPN(String input) {
        if (input.isEmpty()) {
            throw new IllegalArgumentException("Empty string invalid");
        }

        String[] split = input.split(" ");

        Stack<ArithmeticExpression> stack = new Stack<>();

        for (String s : split) {
            if(s.matches("^\\d+$")) {
                stack.push(builder.createNumericOperand(Integer.parseInt(s)));
            }
            else {
                ArithmeticExpression p2 = stack.pop();
                ArithmeticExpression p1 = stack.pop();

                if (s.equals("+")) {
                    stack.push(builder.createAddOperator(p1,p2));
                }

                else if (s.equals("-")) {
                    stack.push(builder.createSubstractOperator(p1, p2));
                }

                else {
                    throw new IllegalArgumentException("Unknown operator: "+s);
                }

            }
        }
    }


}
