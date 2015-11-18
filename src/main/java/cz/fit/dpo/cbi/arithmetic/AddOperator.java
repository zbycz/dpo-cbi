package cz.fit.dpo.cbi.arithmetic;

import cz.fit.dpo.cbi.arithmetic.elements.ExpressionElement;
import java.util.Iterator;

/**
 * Represents + operation
 */
public class AddOperator extends BinaryOperator {

    public AddOperator(ArithmeticExpression firstOperand, ArithmeticExpression secondOperand) {
        super(firstOperand, secondOperand);
    }    

    @Override
    public Integer evaluate() {
        return new Integer(getFirstOperand().evaluate() + getSecondOperand().evaluate());

    }

    @Override
    public Iterator<ExpressionElement> getInOrderIterator() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Iterator<ExpressionElement> getPostOrderIterator() {
        throw new UnsupportedOperationException("Not supported yet.");
    }


}
