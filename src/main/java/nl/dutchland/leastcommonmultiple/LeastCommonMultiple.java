package nl.dutchland.leastcommonmultiple;

import java.math.BigInteger;
import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LeastCommonMultiple {
    private final int from;
    private final int until;

    public LeastCommonMultiple(int from, int until) {
        this.from = from;
        this.until = until;
    }

    public BigInteger value() {
        Queue<BigInteger> range = createRange(from, until);
        return leastCommonMultiple(range);
    }

    private static Queue<BigInteger> createRange(int start, int end) {
        return IntStream.rangeClosed(start, end)
                .mapToObj(BigInteger::valueOf)
                .collect(Collectors.toCollection(LinkedList::new));
    }

    private static BigInteger leastCommonMultiple(Queue<BigInteger> queue) {
        if (queue.isEmpty()) {
            return BigInteger.ONE;
        } else {
            BigInteger currentValue = queue.poll();
            BigInteger leastCommonMultiple = leastCommonMultiple(queue);

            return leastCommonMultiple.multiply(currentValue)
                    .divide(leastCommonMultiple.gcd(currentValue));
        }
    }
}