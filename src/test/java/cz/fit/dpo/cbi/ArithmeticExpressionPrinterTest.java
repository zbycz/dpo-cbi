package cz.fit.dpo.cbi;

import cz.fit.dpo.cbi.ArithmeticExpressionPrinter;
import static org.junit.Assert.*;

import org.junit.Test;

import cz.fit.dpo.cbi.arithmetic.ArithmeticExpression;

public class ArithmeticExpressionPrinterTest {
    private TestExpressionsFactory expressionFactory = new TestExpressionsFactory();

    @Test
    public void testInOrderPrintingOfExpression1() {
        ArithmeticExpression expression = expressionFactory.createExpression1();
        ArithmeticExpressionPrinter printer = new ArithmeticExpressionPrinter(expression);
        
        assertEquals("(3-(1+2))", printer.printInOrder());
    }

    @Test
    public void testInOrderPrintingOfExpression2() {
        ArithmeticExpression e = expressionFactory.createExpression2();
        ArithmeticExpressionPrinter p = new ArithmeticExpressionPrinter(e);

        assertEquals("((3-1)+2)", p.printInOrder());
    }

   

    @Test
    public void testPostOrderPrintingOfExpression1() {
        ArithmeticExpression e = expressionFactory.createExpression1();
        ArithmeticExpressionPrinter p = new ArithmeticExpressionPrinter(e);

        assertEquals("3 1 2 + -", p.printPostOrder());
    }

    @Test
    public void testPostOrderPrintingOfExpression2() {
        ArithmeticExpression e = expressionFactory.createExpression2();
        ArithmeticExpressionPrinter p = new ArithmeticExpressionPrinter(e);

        assertEquals("3 1 - 2 +", p.printPostOrder());
    }


}
