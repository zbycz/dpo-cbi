package cz.fit.dpo.cbi.arithmetic;

import cz.fit.dpo.cbi.arithmetic.elements.AddOperation;
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
        final ArithmeticExpression ex = this;

        return new Iterator<ExpressionElement>() {
            ArithmeticExpression expression = ex;
            boolean iteratedSelf = false;
            boolean iteratedFirst = false;
            boolean iteratedSecond = false;

            @Override
            public boolean hasNext() {
                if (!iteratedSelf && !iteratedFirst && !iteratedSecond) {
                    return true;
                }

                return false;
            }

            @Override
            public ExpressionElement next() {

                //iterujeme nad prvním

                //TODO tady závorku

                if(!iteratedFirst) {
                    boolean has = getFirstOperand().getInOrderIterator().hasNext();
                    if(!has) { //už nemá, tak jsme ho proiterovali
                        iteratedFirst = true;
                    }
                    else {
                        return getFirstOperand().getInOrderIterator().next();
                    }
                }

                //TODO tady závorku

                // vypíšeme operátor
                if (!iteratedSelf) {
                    return new AddOperation();
                }

                // (

                if(!iteratedSecond) {
                    boolean has = getSecondOperand().getInOrderIterator().hasNext();
                    if(!has) { //už nemá, tak jsme ho proiterovali
                        iteratedFirst = true;
                    }
                    else {
                        return getSecondOperand().getInOrderIterator().next();
                    }
                }

                // )


                throw new IllegalStateException("AddOperand cant have another next()");
            }
        };
    }

    @Override
    public Iterator<ExpressionElement> getPostOrderIterator() {
        throw new UnsupportedOperationException("Not supported yet.");
    }


}
