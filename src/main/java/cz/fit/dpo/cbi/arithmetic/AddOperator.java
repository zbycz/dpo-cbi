package cz.fit.dpo.cbi.arithmetic;

import cz.fit.dpo.cbi.arithmetic.elements.*;

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
            boolean printedOpenBracket = false;
            boolean printedCloseBracket = false;
            Iterator<ExpressionElement> firstIterator;
            Iterator<ExpressionElement> secondIterator;

            @Override
            public boolean hasNext() {
                if(iteratedSelf && iteratedFirst && iteratedSecond && printedCloseBracket){
                    return false;
                }
                return true;
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
                    if(firstIterator == null) {
                        firstIterator = getFirstOperand().getInOrderIterator();
                    }

                    boolean has = firstIterator.hasNext();
                    if(!has) { //už nemá, tak jsme ho proiterovali
                        iteratedFirst = true;
                    }
                    else {
                        return firstIterator.next();
                    }
                }

                // vypíšeme operátor
                if(!iteratedSelf) {
                    iteratedSelf = true;
                    return new AddOperation();
                }

                if(!iteratedSecond) {
                    if (secondIterator == null){
                        secondIterator = getSecondOperand().getInOrderIterator();
                    }

                    boolean has = secondIterator.hasNext();
                    if(!has) { //už nemá, tak jsme ho proiterovali
                        iteratedSecond = true;
                    }
                    else {
                        return secondIterator.next();
                    }
                }

                //TODO tady závorku
                if(!printedCloseBracket) {
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
            boolean iteratedSelf = false;
            boolean iteratedFirst = false;
            boolean iteratedSecond = false;
            Iterator<ExpressionElement> firstIterator;
            Iterator<ExpressionElement> secondIterator;

            @Override
            public boolean hasNext() {
                if (iteratedSelf && iteratedFirst && iteratedSecond) {
                    return false;
                }
                return true;
            }

            @Override
            public ExpressionElement next() {

                // Iterujeme nad prvním
                if(!iteratedFirst) {
                    if(firstIterator == null) {
                        firstIterator = getFirstOperand().getPostOrderIterator();
                    }

                    boolean has = firstIterator.hasNext();
                    if(!has) { //už nemá, tak jsme ho proiterovali
                        iteratedFirst = true;
                    }
                    else {
                        return firstIterator.next();
                    }
                }

                // Iterujeme nad druhým
                if(!iteratedSecond) {
                    if (secondIterator == null){
                        secondIterator = getSecondOperand().getPostOrderIterator();
                    }

                    boolean has = secondIterator.hasNext();
                    if(!has) { //už nemá, tak jsme ho proiterovali
                        iteratedSecond = true;
                    }
                    else {
                        return secondIterator.next();
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
