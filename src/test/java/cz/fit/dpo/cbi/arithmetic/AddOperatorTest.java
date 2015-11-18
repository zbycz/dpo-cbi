package cz.fit.dpo.cbi.arithmetic;

import cz.fit.dpo.cbi.arithmetic.AddOperator;
import cz.fit.dpo.cbi.arithmetic.NumericOperand;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class AddOperatorTest {

    private NumericOperand o1 = new NumericOperand(1);
    private NumericOperand o2 = new NumericOperand(2);

    @Test
    public void testGetFirstOperand() {
        AddOperator o = new AddOperator(o1, o2);
        assertEquals(o1, o.getFirstOperand());
    }

    @Test
    public void testGetSecondOperand() {
        AddOperator o = new AddOperator(o1, o2);
        assertEquals(o2, o.getSecondOperand());
    }
}
