package cz.fit.dpo.cbi;

import cz.fit.dpo.cbi.arithmetic.AddOperator;
import cz.fit.dpo.cbi.arithmetic.ArithmeticExpression;
import cz.fit.dpo.cbi.arithmetic.NumericOperand;
import cz.fit.dpo.cbi.arithmetic.SubstractOperator;

/**
 * Created by Pavel on 18.11.2015.
 */
public class ArithmeticExpressionBuilder implements ExpressionBuilder {


    private ArithmeticExpression root;


    @Override
    public NumericOperand createNumericOperand(int x) {
        NumericOperand numericOperand = new NumericOperand(x);
        root = numericOperand;
        return numericOperand;
    }

    @Override
    public AddOperator createAddOperator(ArithmeticExpression a, ArithmeticExpression b) {
        AddOperator addOperator = new AddOperator(a, b);
        root = addOperator;
        return addOperator;
    }

    @Override
    public SubstractOperator createSubstractOperator(ArithmeticExpression a, ArithmeticExpression b) {
        SubstractOperator substractOperator = new SubstractOperator(a, b);
        root = substractOperator;
        return substractOperator;
    }

    @Override
    public ArithmeticExpression getExpression() {
        return root;
    }


}
