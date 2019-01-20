package nl.dutchland.leastcommonmultiple;

import java.math.BigInteger;

public class LeastCommonMultiple {
    private final int from;
    private final int until;

    public LeastCommonMultiple(int from, int until) {
        this.from = from;
        this.until = until;
    }

    public BigInteger value() {
        return BigInteger.ONE;
    }
}