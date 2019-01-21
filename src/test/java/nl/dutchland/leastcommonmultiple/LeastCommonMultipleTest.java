package nl.dutchland.leastcommonmultiple;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.function.Executable;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class LeastCommonMultipleTest {

    @Test
    public void testInvalidRange_NegativeRange() {
        // Arrange
        Executable negativeRange = () -> LeastCommonMultiple.ofInclusiveRange(-1, 1);

        // Act
        IllegalArgumentException thrownException = Assertions.assertThrows(IllegalArgumentException.class,
                negativeRange);

        // Assert
        Assertions.assertEquals("Start of the range has to be bigger than zero", thrownException.getMessage());
    }

    @Test
    public void testInvalidRange_EndSmallerThanStart() {
        // Arrange
        Executable endSmallerThanStartRange = () -> LeastCommonMultiple.ofInclusiveRange(10, 9);

        // Act
        IllegalArgumentException thrownException = Assertions.assertThrows(IllegalArgumentException.class,
                endSmallerThanStartRange);

        // Assert
        Assertions.assertEquals("End of the range has to be bigger than the start", thrownException.getMessage());
    }

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
        LeastCommonMultiple leastCommonMultiple = LeastCommonMultiple.ofInclusiveRange(from, until);

        // Act
        long answer = leastCommonMultiple.value()
                .longValue();

        // Assert
        Assertions.assertEquals(expectedAnswer, answer);
    }
}