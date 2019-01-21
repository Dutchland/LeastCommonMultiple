package nl.dutchland.leastcommonmultiple;

import java.math.BigInteger;
import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static nl.dutchland.leastcommonmultiple.Assertions.assertLargerThanZero;
import static nl.dutchland.leastcommonmultiple.Assertions.assertTrue;

public class LeastCommonMultiple {
    private final int from;
    private final int until;

    private LeastCommonMultiple(int from, int until) {
        this.from = from;
        this.until = until;
    }

    public static LeastCommonMultiple ofInclusiveRange(int from, int until) {
        assertTrue(until <= 42, () -> { throw new IllegalArgumentException("End of range cannot exceed 42"); });
        assertLargerThanZero(from, () -> { throw new IllegalArgumentException("Start of the range has to be bigger than zero"); });
        assertTrue(until >= from, () -> { throw new IllegalArgumentException("End of the range has to be bigger than the start"); });

        return new LeastCommonMultiple(from, until);
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