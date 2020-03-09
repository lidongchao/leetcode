package utils;

import java.util.Arrays;

public final class AssertUtils {
    private AssertUtils() {}

    private static final String PASS = "Pass";

    public static void assertEqualsString(String expect, String actual) {
        assertEquals(expect, actual);
    }

    public static void assertEqualsInteger(Integer expect, Integer actual) {
        assertEquals(expect, actual);
    }

    public static void assertEqualsStringArray(String[] expect, String[] actual) {
        assertEqualsArray(expect, actual);
    }

    public static void assertEqualsIntegerArray(Integer[] expect, Integer[] actual) {
        assertEqualsArray(expect, actual);
    }

    public static void assertEqualsIntArray(int[] expect, int[] actual) {
        assertEqualsArray(ArrayUtils.toObject(expect), ArrayUtils.toObject(actual));
    }

    public static void assertEqualsArray(Object[] expect, Object[] actual) {
        if (Arrays.equals(expect, actual)) {
            System.out.println(PASS);
        } else {
            printlnExpect(Arrays.toString(expect));
            printlnActual(Arrays.toString(actual));
        }
    }

    public static void assertEquals(Object expect, Object actual) {
        if (expect.equals(actual)) {
            System.out.println(PASS);
        } else {
            printlnExpect(expect);
            printlnActual(actual);
        }
    }

    private static void printlnExpect(Object o) {
        System.out.println("Expect:" + o);
    }

    private static void printlnActual(Object o) {
        System.out.println("Actual:" + o);
    }
}
