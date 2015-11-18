package cz.fit.dpo.cbi;

import cz.fit.dpo.cbi.arithmetic.AddOperator;
import cz.fit.dpo.cbi.arithmetic.ArithmeticExpression;
import cz.fit.dpo.cbi.arithmetic.BinaryOperator;
import cz.fit.dpo.cbi.arithmetic.NumericOperand;
import cz.fit.dpo.cbi.arithmetic.SubstractOperator;

/**
 *
 * @author Ondrej Stuchlik
 */
public class TestExpressionsFactory {

    /**
     * Creates 3 - (1 + 2)
     */
    public ArithmeticExpression createExpression1() {
        NumericOperand op1 = new NumericOperand(1);
        NumericOperand op2 = new NumericOperand(2);
        NumericOperand op3 = new NumericOperand(3);

        BinaryOperator o2 = new AddOperator(op1, op2);
        BinaryOperator o1 = new SubstractOperator(op3, o2);

        return o1;
    }

    /**
     * Creates (3 - 1) + 2
     */
    public ArithmeticExpression createExpression2() {
        NumericOperand op1 = new NumericOperand(1);
        NumericOperand op2 = new NumericOperand(2);
        NumericOperand op3 = new NumericOperand(3);

        BinaryOperator o1 = new SubstractOperator(op3, op1);
        BinaryOperator o2 = new AddOperator(o1, op2);

        return o2;
    }
}
