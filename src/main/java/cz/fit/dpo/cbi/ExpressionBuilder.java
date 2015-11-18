package cz.fit.dpo.cbi;

import cz.fit.dpo.cbi.arithmetic.AddOperator;
import cz.fit.dpo.cbi.arithmetic.ArithmeticExpression;
import cz.fit.dpo.cbi.arithmetic.NumericOperand;
import cz.fit.dpo.cbi.arithmetic.SubstractOperator;

/**
 * Created by Pavel on 18.11.2015.
 */
public interface ExpressionBuilder {


    public NumericOperand createNumericOperand(int x);

    public AddOperator createAddOperator(ArithmeticExpression a, ArithmeticExpression b);

    public SubstractOperator createSubstractOperator(ArithmeticExpression a, ArithmeticExpression b);

    ArithmeticExpression getExpression();
}
