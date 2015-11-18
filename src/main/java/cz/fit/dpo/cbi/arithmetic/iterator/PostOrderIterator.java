package cz.fit.dpo.cbi.arithmetic.iterator;

import java.util.Iterator;

import cz.fit.dpo.cbi.arithmetic.AddOperator;
import cz.fit.dpo.cbi.arithmetic.ArithmeticExpression;
import cz.fit.dpo.cbi.arithmetic.BinaryOperator;
import cz.fit.dpo.cbi.arithmetic.elements.AddOperation;
import cz.fit.dpo.cbi.arithmetic.elements.ExpressionElement;

public class PostOrderIterator implements Iterator<ExpressionElement> {
    private final ExpressionElement operation;
    BinaryOperator expression;
    boolean iteratedSelf = false;
    boolean iteratedFirst = false;
    boolean iteratedSecond = false;
    Iterator<ExpressionElement> firstIterator;
    Iterator<ExpressionElement> secondIterator;

    public PostOrderIterator(BinaryOperator expression, ExpressionElement operation) {
        this.expression = expression;
        this.operation = operation;
    }


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
                firstIterator = expression.getFirstOperand().getPostOrderIterator();
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
                secondIterator = expression.getSecondOperand().getPostOrderIterator();
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
            return operation;
        }

        throw new IllegalStateException("Operand with " + operation + " cant have another next()");
    }
}