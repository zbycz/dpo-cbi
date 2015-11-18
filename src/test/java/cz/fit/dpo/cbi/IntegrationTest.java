package cz.fit.dpo.cbi;

import cz.fit.dpo.cbi.ArithmeticExpressionCreator;
import cz.fit.dpo.cbi.ArithmeticExpressionPrinter;
import cz.fit.dpo.cbi.arithmetic.ArithmeticExpression;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class IntegrationTest {

    @Test
    public void testInOrderPrintingOfRPNExpression() {
        ArithmeticExpression e = new ArithmeticExpressionCreator()
              .createExpressionFromRPN("1 2 + 3 4 + -");
        ArithmeticExpressionPrinter p = new ArithmeticExpressionPrinter(e);

        assertEquals("((1+2)-(3+4))", p.printInOrder());
    }

    @Test
    public void testPostOrderPrintingOfRPNExpression() {
        ArithmeticExpression e = new ArithmeticExpressionCreator()
              .createExpressionFromRPN("1 2 + 3 4 + -");
        ArithmeticExpressionPrinter p = new ArithmeticExpressionPrinter(e);

        assertEquals("1 2 + 3 4 + -", p.printPostOrder());
    }
}
