package nl.dutchland.leastcommonmultiple;

public class Assertions {
    @FunctionalInterface
    public interface AssertionFailedHandler {
        void handle();
    }

    public static void assertLargerThanZero(int value, AssertionFailedHandler handler) {
        assertTrue(value > 0, handler);
    }

    public static void assertTrue(boolean assertionIsConfirmed, AssertionFailedHandler handler) {
        if (!assertionIsConfirmed) {
            handler.handle();
        }
    }
}
