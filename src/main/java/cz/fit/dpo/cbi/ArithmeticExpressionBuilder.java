package cz.fit.dpo.cbi;

import cz.fit.dpo.cbi.arithmetic.AddOperator;
import cz.fit.dpo.cbi.arithmetic.ArithmeticExpression;
import cz.fit.dpo.cbi.arithmetic.NumericOperand;
import cz.fit.dpo.cbi.arithmetic.SubstractOperator;

import javax.lang.model.type.ArrayType;
import java.util.Stack;

/**
 * Created by Pavel on 18.11.2015.
 */
public class ArithmeticExpressionBuilder implements ExpressionBuilder {


    private Stack<ArithmeticExpression> stack  = new Stack<ArithmeticExpression>();

    @Override
    public void createNumericOperand(int x) {
        NumericOperand numericOperand = new NumericOperand(x);
        stack.push(numericOperand);
    }

    @Override
    public void createAddOperator() {
        ArithmeticExpression b = stack.pop();
        ArithmeticExpression a = stack.pop();

        AddOperator addOperator = new AddOperator(a, b);
        stack.push(addOperator);
    }

    @Override
    public void createSubstractOperator() {
        ArithmeticExpression b = stack.pop();
        ArithmeticExpression a = stack.pop();

        SubstractOperator substractOperator = new SubstractOperator(a, b);
        stack.push(substractOperator);
    }

    @Override
    public ArithmeticExpression getExpression() {
        return stack.pop();
    }


}
