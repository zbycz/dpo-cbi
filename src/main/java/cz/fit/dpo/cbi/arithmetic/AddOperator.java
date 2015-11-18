package cz.fit.dpo.cbi.arithmetic;

import cz.fit.dpo.cbi.arithmetic.elements.AddOperation;
import cz.fit.dpo.cbi.arithmetic.elements.CloseBracketOperation;
import cz.fit.dpo.cbi.arithmetic.elements.ExpressionElement;
import cz.fit.dpo.cbi.arithmetic.elements.OpenBracketOperation;
import java.util.Iterator;

/**
 * Represents + operation
 */
public class AddOperator extends BinaryOperator {
    boolean iteratedSelf = false;
    boolean iteratedFirst = false;
    boolean iteratedSecond = false;
    boolean printedOpenBracket = false;
    boolean printedCloseBracket = false;

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

            @Override
            public boolean hasNext() {
                return !(iteratedSelf || iteratedFirst || iteratedSecond || printedCloseBracket);
            }

            @Override
            public ExpressionElement next() {

                //iterujeme nad prvním

                //TODO tady závorku
                if(!printedOpenBracket) {
                    printedOpenBracket = true;
                    return new OpenBracketOperation();
                }

                if(!iteratedFirst) {
                    boolean has = getFirstOperand().getInOrderIterator().hasNext();
                    if(!has) { //už nemá, tak jsme ho proiterovali
                        iteratedFirst = true;
                    }
                    else {
                        return getFirstOperand().getInOrderIterator().next();
                    }
                }

                // vypíšeme operátor
                if(!iteratedSelf) {
                    iteratedSelf = true;
                    return new AddOperation();
                }

                if(!iteratedSecond) {
                    boolean has = getSecondOperand().getInOrderIterator().hasNext();
                    if(!has) { //už nemá, tak jsme ho proiterovali
                        iteratedSecond = true;
                    }
                    else {
                        return getSecondOperand().getInOrderIterator().next();
                    }
                }

                //TODO tady závorku
                if(iteratedSecond && !printedCloseBracket) {
                    printedCloseBracket = true;
                    return new CloseBracketOperation();
                }


                throw new IllegalStateException("AddOperand cant have another next()");
            }
        };
    }

    @Override
    public Iterator<ExpressionElement> getPostOrderIterator() {
        final ArithmeticExpression ex = this;

        return new Iterator<ExpressionElement>() {
            ArithmeticExpression expression = ex;
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

                // Iterujeme nad prvním
                if(!iteratedFirst) {
                    boolean has = getFirstOperand().getPostOrderIterator().hasNext();
                    if(!has) { //už nemá, tak jsme ho proiterovali
                        iteratedFirst = true;
                    }
                    else {
                        return getFirstOperand().getPostOrderIterator().next();
                    }
                }

                // Iterujeme nad druhým
                if(!iteratedSecond) {
                    boolean has = getSecondOperand().getPostOrderIterator().hasNext();
                    if(!has) { //už nemá, tak jsme ho proiterovali
                        iteratedFirst = true;
                    }
                    else {
                        return getSecondOperand().getPostOrderIterator().next();
                    }
                }

                // Vypíšeme operátor
                if (!iteratedSelf) {
                    iteratedSelf = true;
                    return new AddOperation();
                }

                throw new IllegalStateException("AddOperand cant have another next()");
            }
        };
    }


}
