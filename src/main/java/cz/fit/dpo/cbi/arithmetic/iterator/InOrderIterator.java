package cz.fit.dpo.cbi.arithmetic.iterator;

import java.util.Iterator;

import cz.fit.dpo.cbi.arithmetic.ArithmeticExpression;
import cz.fit.dpo.cbi.arithmetic.BinaryOperator;
import cz.fit.dpo.cbi.arithmetic.SubstractOperator;
import cz.fit.dpo.cbi.arithmetic.elements.CloseBracketOperation;
import cz.fit.dpo.cbi.arithmetic.elements.ExpressionElement;
import cz.fit.dpo.cbi.arithmetic.elements.OpenBracketOperation;
import cz.fit.dpo.cbi.arithmetic.elements.SubstractOperation;

public class InOrderIterator implements Iterator<ExpressionElement> {
    private final ExpressionElement operation;
    BinaryOperator expression;
    boolean iteratedSelf = false;
    boolean iteratedFirst = false;
    boolean iteratedSecond = false;
    boolean printedOpenBracket = false;
    boolean printedCloseBracket = false;
    Iterator<ExpressionElement> firstIterator;
    Iterator<ExpressionElement> secondIterator;

    public InOrderIterator(BinaryOperator expression, ExpressionElement operation) {
        this.expression = expression;
        this.operation = operation;
    }


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
                firstIterator = expression.getFirstOperand().getInOrderIterator();
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
            return operation;
        }

        if(!iteratedSecond) {
            if (secondIterator == null){
                secondIterator = expression.getSecondOperand().getInOrderIterator();
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


        throw new IllegalStateException("Operand with " + operation +  " cant have another next()");
    }
}

