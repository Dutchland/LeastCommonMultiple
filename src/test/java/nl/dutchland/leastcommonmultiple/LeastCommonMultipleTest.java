package nl.dutchland.leastcommonmultiple;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class LeastCommonMultipleTest {

    @Test
    public void testValues() {
        Assertions.assertAll(
                () -> testLeastCommonMultiple(8,  8, 8),
                () -> testLeastCommonMultiple(2, 5 , 60),
                () -> testLeastCommonMultiple(1, 10 , 2520),
                () -> testLeastCommonMultiple(1, 15 , 360360),
                () -> testLeastCommonMultiple(1, 20 , 232792560));
    }

    private void testLeastCommonMultiple(int from, int until, long expectedAnswer) {
        // Arrange
        LeastCommonMultiple leastCommonMultiple = new LeastCommonMultiple(from, until);

        // Act
        long answer = leastCommonMultiple.value()
                .longValue();

        // Assert
        Assertions.assertEquals(expectedAnswer, answer);
    }
}