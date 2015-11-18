package cz.fit.dpo.cbi;

import cz.fit.dpo.cbi.arithmetic.ArithmeticExpression;

public class ArithmeticExpressionCreator {
    

    /**
     * Creates any expression from the RPN input. 
     *
     * @see http://en.wikipedia.org/wiki/Reverse_Polish_notation
     *
     * @param input in Reverse Polish Notation
     * @return {@link ArithmeticExpression} equivalent of the RPN input.
     */
    public ArithmeticExpression createExpressionFromRPN(String input) {
        ExpressionBuilder builder = new ArithmeticExpressionBuilder();
        AEBuilderDirector director = new AEBuilderDirector(builder);
        
        director.constructFromRPN(input);

        return builder.getExpression();
    }
}
