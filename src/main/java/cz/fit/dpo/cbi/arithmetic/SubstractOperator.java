package cz.fit.dpo.cbi.arithmetic;

import cz.fit.dpo.cbi.arithmetic.elements.*;
import cz.fit.dpo.cbi.arithmetic.iterator.InOrderIterator;
import cz.fit.dpo.cbi.arithmetic.iterator.PostOrderIterator;

import java.util.Iterator;

/**
 * Represents - operation
 */
public class SubstractOperator extends BinaryOperator {


    public SubstractOperator(ArithmeticExpression firstOperand, ArithmeticExpression secondOperand) {
        super(firstOperand, secondOperand);
    }    

    @Override
    public Integer evaluate() {
        return new Integer(getFirstOperand().evaluate() - getSecondOperand().evaluate());
    }

    @Override
    public Iterator<ExpressionElement> getInOrderIterator() {
        return new InOrderIterator(this, new SubstractOperation());
    }

    @Override
    public Iterator<ExpressionElement> getPostOrderIterator() {
        return new PostOrderIterator(this, new SubstractOperation());
    }

}
