package cz.fit.dpo.cbi.arithmetic;

import cz.fit.dpo.cbi.arithmetic.elements.*;
import cz.fit.dpo.cbi.arithmetic.elements.Number;
import cz.fit.dpo.cbi.arithmetic.iterator.InOrderIterator;
import cz.fit.dpo.cbi.arithmetic.iterator.PostOrderIterator;
import java.util.Iterator;

/**
 * Represents number in the arithmetic expression
 */
public class NumericOperand extends ArithmeticExpression {

    private Integer value;
    boolean iteratedSelf = false;

    public NumericOperand(Integer value) {
        this.value = value;
    }

    @Override
    public Integer evaluate() {
        return value;
    }

    @Override
    public Iterator<ExpressionElement> getInOrderIterator() {
        final ArithmeticExpression ex = this;

        return new Iterator<ExpressionElement>() {
            ArithmeticExpression expression = ex;

            @Override
            public boolean hasNext() {
                return !iteratedSelf;
            }

            @Override
            public ExpressionElement next() {
                if (!iteratedSelf) {
                    iteratedSelf = true;
                    return new Number(value);
                }

                throw new IllegalStateException("NumericOperand cant have another next()");
            }
        };
    }

    @Override
    public Iterator<ExpressionElement> getPostOrderIterator() {
        final ArithmeticExpression ex = this;

        return new Iterator<ExpressionElement>() {
            ArithmeticExpression expression = ex;

            @Override
            public boolean hasNext() {
                return !iteratedSelf;
            }

            @Override
            public ExpressionElement next() {
                if (!iteratedSelf) {
                    iteratedSelf = true;
                    return new Number(value);
                }

                throw new IllegalStateException("NumericOperand cant have another next()");
            }
        };
    }


}
