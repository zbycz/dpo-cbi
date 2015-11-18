package cz.fit.dpo.cbi.arithmetic.elements;

public class Number implements ExpressionElement {

    private Integer value;

    public Number(Integer value) {
        this.value = value;
    }

    @Override
    public String stringValue() {
        return String.valueOf(value);
    }
}
