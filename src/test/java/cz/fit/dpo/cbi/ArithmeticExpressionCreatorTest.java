package cz.fit.dpo.cbi;

import cz.fit.dpo.cbi.ArithmeticExpressionCreator;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ArithmeticExpressionCreatorTest {

    private ArithmeticExpressionCreator aec = new ArithmeticExpressionCreator();

    @Test
    public void testSimpleExpressionCreation() {
        assertEquals(new Integer(1), aec.createExpressionFromRPN("1").evaluate());
    }
    
    @Test
    public void testComplexExpressionCreation() {
        assertEquals(new Integer(4), aec.createExpressionFromRPN("3 1 +").evaluate());
        assertEquals(new Integer(0), aec.createExpressionFromRPN("3 1 2 + -").evaluate());
        assertEquals(new Integer(0), aec.createExpressionFromRPN("1 2 3 - +").evaluate());
        assertEquals(new Integer(-2), aec.createExpressionFromRPN("3 1 + 4 - 2 -").evaluate());
    }    

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidExpressionCreation() {
        assertEquals(new Integer(1), aec.createExpressionFromRPN("1 2 Baf").evaluate());
    }

    /** Empty expression is not valid expression */
    @Test(expected = IllegalArgumentException.class)
    public void testEmptyExpressionCreation() {
        assertEquals(new Integer(1), aec.createExpressionFromRPN("").evaluate());
    }
}
