package cz.fit.dpo.cbi.arithmetic;

import cz.fit.dpo.cbi.ArithmeticExpressionCreator;
import cz.fit.dpo.cbi.TestExpressionsFactory;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ArithmeticExpressionEvaluationTest {
    private TestExpressionsFactory expressionFactory = new TestExpressionsFactory();

    @Test
    public void testExpression1Evaluation() {
        ArithmeticExpressionCreator aec = new ArithmeticExpressionCreator();
        assertEquals(new Integer(0), expressionFactory.createExpression1().evaluate());
    }

    @Test
    public void testExpression2Evaluation() {
        ArithmeticExpressionCreator aec = new ArithmeticExpressionCreator();
        assertEquals(new Integer(4), expressionFactory.createExpression2().evaluate());
    }
    
    
}
