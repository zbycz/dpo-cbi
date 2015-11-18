package cz.fit.dpo.cbi.arithmetic;

/**
 * Represents the Binary operations like + - etc.
 */
public abstract class BinaryOperator extends ArithmeticExpression {

    private ArithmeticExpression firstOperand;
    private ArithmeticExpression secondOperand;

    public BinaryOperator(ArithmeticExpression firstOperand, ArithmeticExpression secondOperand) {
        this.firstOperand = firstOperand;
        this.secondOperand = secondOperand;
    }
    
    public ArithmeticExpression getFirstOperand() {
        return firstOperand;
    }

    public ArithmeticExpression getSecondOperand() {
        return secondOperand;
    }

}
