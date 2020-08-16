package utils;

import java.util.Arrays;
import java.util.Comparator;

public final class AssertUtils {
    private AssertUtils() {}

    private static final String PASS = "Pass";
    private static boolean mute = false;

    public static void mute() {
        mute = true;
    }

    /****************** basic ******************/

    public static boolean assertEqualsString(String expect, String actual) {
        return assertEquals(expect, actual);
    }

    public static boolean assertEqualsInteger(Integer expect, Integer actual) {
        return assertEquals(expect, actual);
    }

    public static boolean assertEqualsBoolean(Boolean expect, Boolean actual) {
        return assertEquals(expect, actual);
    }

    public static boolean assertEqualsDouble(Double expect, Double actual) {
        if (expect - actual < Double.MIN_VALUE) {
            if (!mute) {
                System.out.println(PASS);
            }
            return true;
        } else {
            printlnExpect(expect);
            printlnActual(actual);
            return false;
        }
    }

    public static boolean assertEquals(Object expect, Object actual) {
        if (expect.equals(actual)) {
            if (!mute) {
                System.out.println(PASS);
            }
            return true;
        } else {
            printlnExpect(expect);
            printlnActual(actual);
            return false;
        }
    }

    /****************** array ******************/

    public static boolean assertEqualsStringArray(String[] expect, String[] actual) {
        return assertEqualsArray(expect, actual);
    }

    public static boolean assertEqualsIntegerArray(Integer[] expect, Integer[] actual) {
        return assertEqualsArray(expect, actual);
    }

    public static boolean assertEqualsIntArray(int[] expect, int[] actual) {
        return assertEqualsArray(ArrayUtils.toObject(expect), ArrayUtils.toObject(actual));
    }

    public static boolean assertEqualsIntArrayIgnorePosition(int[] expect, int[] actual) {
        return assertEqualsArrayIgnorePosition(ArrayUtils.toObject(expect), ArrayUtils.toObject(actual));
    }

    public static boolean assertEqualsDoubleArray(Double[] expect, Double[] actual) {
        return assertEqualsArray(expect, actual);
    }

    public static boolean assertEqualsDoubleArray(double[] expect, double[] actual) {
        return assertEqualsArray(ArrayUtils.toObject(expect), ArrayUtils.toObject(actual));
    }

    public static boolean assertEqualsArray(Object[] expect, Object[] actual) {
        if (Arrays.equals(expect, actual)) {
            if (!mute) {
                System.out.println(PASS);
            }
            return true;
        } else {
            printlnExpect(Arrays.toString(expect));
            printlnActual(Arrays.toString(actual));
            return false;
        }
    }

    public static boolean assertEqualsArrayIgnorePosition(Object[] expect, Object[] actual) {
        Arrays.sort(expect);
        Arrays.sort(actual);
        return assertEqualsArray(expect, actual);
    }

    /****************** 2d array ******************/

    public static boolean assertEqualsInt2DArray(int[][] expect, int[][] actual) {
        return assertEquals2DArray(ArrayUtils.to2DObject(expect), ArrayUtils.to2DObject(actual));
    }

    public static boolean assertEqualsIntArrayAnyCase(int[][] expect, int[] actual) {
        return assertEqualsArrayAnyCase(ArrayUtils.to2DObject(expect), ArrayUtils.toObject(actual));
    }

    @SuppressWarnings("rawtypes")
    public static boolean assertEquals2DArray(Comparable[][] expect, Comparable[][] actual) {
        boolean equals = false;
        if (expect.length == actual.length) {
            equals = true;
            if (expect.length != 0) {
                Comparator<Comparable[]> comparator = (x, y) -> {
                    int i = 0;
                    int j = 0;
                    while (i < x.length && j < y.length) {
                        if (x[i] != y[j]) {
                            //noinspection unchecked
                            return x[i].compareTo(y[j]);
                        }
                        i++;
                        j++;
                    }
                    if (i < x.length) {
                        return 1;
                    } else if (j < y.length) {
                        return -1;
                    } else {
                        return 0;
                    }
                };
                Arrays.sort(expect, comparator);
                Arrays.sort(actual, comparator);
                for (int i = 0; i < expect.length; i++) {
                    equals &= Arrays.equals(expect[i], actual[i]);
                }
            }
        }

        if (equals) {
            if (!mute) {
                System.out.println(PASS);
            }
            return true;
        } else {
            printlnExpect(ArrayUtils.toString2DArray(expect), true);
            printlnActual(ArrayUtils.toString2DArray(actual), true);
            return false;
        }
    }

    public static boolean assertEqualsArrayAnyCase(Object[][] expect, Object[] actual) {
        for (Object[] e: expect) {
            if (Arrays.equals(e, actual)) {
                if (!mute) {
                    System.out.println(PASS);
                }
                return true;
            }
        }
        printlnExpect(ArrayUtils.toString2DArray(expect));
        printlnActual(Arrays.toString(actual));
        return false;
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
