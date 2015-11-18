package cz.fit.dpo.cbi.arithmetic.iterator;

import cz.fit.dpo.cbi.TestExpressionsFactory;
import cz.fit.dpo.cbi.arithmetic.ArithmeticExpression;
import cz.fit.dpo.cbi.arithmetic.elements.ExpressionElement;
import java.util.Iterator;
import org.junit.Test;
import static org.junit.Assert.*;

public class InOrderIteratorTest {
    
    private TestExpressionsFactory expressionFactory = new TestExpressionsFactory();

    @Test
    public void testIteration() {
        ArithmeticExpression e = expressionFactory.createExpression1();
        Iterator<ExpressionElement> it = e.getInOrderIterator();
        assertNotNull(it);

        assertEquals("(", it.next().stringValue());
        assertEquals("3", it.next().stringValue());
        assertEquals("-", it.next().stringValue());
        assertEquals("(", it.next().stringValue());
        assertEquals("1", it.next().stringValue());
        assertEquals("+", it.next().stringValue());
        assertEquals("2", it.next().stringValue());
        assertEquals(")", it.next().stringValue());
        assertEquals(")", it.next().stringValue());
        assertFalse(it.hasNext());
    }

    @Test(expected = UnsupportedOperationException.class)
    public void testRemoveOperationUnsupported() {
        ArithmeticExpression e = expressionFactory.createExpression1();
        Iterator<ExpressionElement> it = e.getInOrderIterator();
        assertNotNull(it);
        it.remove();
    }
}