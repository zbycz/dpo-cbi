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

        for (String s : split) {
            if(s.matches("^\\d+$")) {
                builder.createNumericOperand(Integer.parseInt(s));
            }
            else if (s.equals("+")) {
                builder.createAddOperator();
            }

            else if (s.equals("-")) {
                builder.createSubstractOperator();
            }

            else {
                throw new IllegalArgumentException("Unknown operator: "+s);
            }
        }
    }


}
