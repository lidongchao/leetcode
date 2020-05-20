package utils;

import java.util.Arrays;

public final class AssertUtils {
    private AssertUtils() {}

    private static final String PASS = "Pass";

    /****************** basic ******************/

    public static void assertEqualsString(String expect, String actual) {
        assertEquals(expect, actual);
    }

    public static void assertEqualsInteger(Integer expect, Integer actual) {
        assertEquals(expect, actual);
    }

    public static void assertEqualsBoolean(Boolean expect, Boolean actual) {
        assertEquals(expect, actual);
    }

    public static void assertEqualsDouble(Double expect, Double actual) {
        if (expect - actual < Double.MIN_VALUE) {
            System.out.println(PASS);
        } else {
            printlnExpect(expect);
            printlnActual(actual);
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

    /****************** array ******************/

    public static void assertEqualsStringArray(String[] expect, String[] actual) {
        assertEqualsArray(expect, actual);
    }

    public static void assertEqualsIntegerArray(Integer[] expect, Integer[] actual) {
        assertEqualsArray(expect, actual);
    }

    public static void assertEqualsIntArray(int[] expect, int[] actual) {
        assertEqualsArray(ArrayUtils.toObject(expect), ArrayUtils.toObject(actual));
    }

    public static void assertEqualsIntArrayIgnorePosition(int[] expect, int[] actual) {
        assertEqualsArrayIgnorePosition(ArrayUtils.toObject(expect), ArrayUtils.toObject(actual));
    }

    public static void assertEqualsIntArrayAnyCase(int[][] expect, int[] actual) {
        assertEqualsArrayAnyCase(ArrayUtils.to2DObject(expect), ArrayUtils.toObject(actual));
    }

    public static void assertEqualsDoubleArray(Double[] expect, Double[] actual) {
        assertEqualsArray(expect, actual);
    }

    public static void assertEqualsDoubleArray(double[] expect, double[] actual) {
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

    public static void assertEqualsArrayIgnorePosition(Object[] expect, Object[] actual) {
        Arrays.sort(expect);
        Arrays.sort(actual);
        if (Arrays.equals(expect, actual)) {
            System.out.println(PASS);
        } else {
            printlnExpect(Arrays.toString(expect));
            printlnActual(Arrays.toString(actual));
        }
    }

    public static void assertEqualsArrayAnyCase(Object[][] expect, Object[] actual) {
        for (Object[] e: expect) {
            if (Arrays.equals(e, actual)) {
                System.out.println(PASS);
                return;
            }
        }
        printlnExpect(Arrays.toString(expect));
        printlnActual(Arrays.toString(actual));
    }

    /****************** 2d array ******************/

    public static void assertEqualsInt2DArray(int[][] expect, int[][] actual) {
        assertEquals2DArray(ArrayUtils.to2DObject(expect), ArrayUtils.to2DObject(actual));
    }

    public static void assertEquals2DArray(Object[][] expect, Object[][] actual) {
        boolean equals = false;
        if (expect.length == actual.length) {
            if (expect.length == 0) {
                equals = true;
            } else {
                if (expect[0].length == actual[0].length) {
                    equals = true;
                    for (int i = 0; i < expect.length; i++) {
                        equals &= Arrays.equals(expect[i], actual[i]);
                    }
                }
            }
        }

        if (equals) {
            System.out.println(PASS);
        } else {
            printlnExpect(ArrayUtils.toString2DArray(expect), true);
            printlnActual(ArrayUtils.toString2DArray(actual), true);
        }
    }

    /****************** print ******************/

    private static void printlnExpect(Object o, boolean startWithNewLine) {
        if (startWithNewLine) {
            System.out.println("Expect:");
            System.out.println(o);
        } else {
            System.out.println("Expect:" + o);
        }
    }

    private static void printlnExpect(Object o) {
        printlnExpect(o, false);
    }

    private static void printlnActual(Object o, boolean startWithNewLine) {
        if (startWithNewLine) {
            System.out.println("Actual:");
            System.out.println(o);
        } else {
            System.out.println("Actual:" + o);
        }
    }

    private static void printlnActual(Object o) {
        printlnActual(o, false);
    }
}
