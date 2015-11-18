package cz.fit.dpo.cbi.arithmetic;

import java.util.Iterator;

import cz.fit.dpo.cbi.arithmetic.elements.ExpressionElement;

public abstract class ArithmeticExpression {

    public abstract Integer evaluate();

    public abstract Iterator<ExpressionElement> getInOrderIterator();


    /*
    public Iterator<ExpressionElement> getInOrderIterator(){


//        Stack<ArithmeticExpression> stack = new Stack<>();
//        stack.push(this);
//
//        while(stack){
//            ArithmeticExpression pop = stack.pop();
//
//            echo pop;
//
//            stack.push(pop.getFirstOperand());
//            stack.push(pop.getSecondOperand());
//        }


        final ArithmeticExpression ex = this;

        return new Iterator<ExpressionElement>() {

            ArithmeticExpression expression = ex;
            boolean iteratedSelf = false;

            @Override
            public boolean hasNext() {
                if (!iteratedSelf) {
                    return true;
                }

                return expression.getInOrderIterator().hasNext();
            }

            @Override
            public ExpressionElement next() {
                if (!iteratedSelf) {
                    return get

                }

                return expression.getInOrderIterator().next();
            }
        };
    }
*/
    public abstract Iterator<ExpressionElement> getPostOrderIterator();
}
