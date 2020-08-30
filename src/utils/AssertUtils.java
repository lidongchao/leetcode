package utils;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public final class AssertUtils {
    private AssertUtils() {}

    private static final String PASS = "Pass";
    private static boolean mute = false;

    public static void mute() {
        mute = true;
    }

    /****************** basic ******************/

    public static boolean assertEquals(Double expect, Double actual) {
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

    /****************** list ******************/

    public static <T> boolean assertEqualsList(List<T> expect, List<T> actual) {
        boolean equals = true;
        if (expect == null && actual == null) {
            equals = true;
        } else if (expect == null || actual == null) {
            equals = false;
        } else if (expect.size() != actual.size()) {
            equals = false;
        } else {
            equals = expect.equals(actual);
        }

        if (equals) {
            if (!mute) {
                System.out.println(PASS);
            }
        } else {
            printlnExpect(expect, true);
            printlnActual(actual, true);
        }
        return equals;
    }

    /****************** array ******************/

    public static boolean assertEqualsArray(int[] expect, int[] actual) {
        return assertEqualsArray(ArrayUtils.primitiveToObject(expect), ArrayUtils.primitiveToObject(actual));
    }

    public static boolean assertEqualsArray(double[] expect, double[] actual) {
        return assertEqualsArray(ArrayUtils.primitiveToObject(expect), ArrayUtils.primitiveToObject(actual));
    }

    public static <T> boolean assertEqualsArray(T[] expect, T[] actual) {
        return assertEqualsList(ArrayUtils.arrayToList(expect), ArrayUtils.arrayToList(actual));
    }

    public static boolean assertEqualsArrayIgnorePosition(int[] expect, int[] actual) {
        return assertEqualsArrayIgnorePosition(ArrayUtils.primitiveToObject(expect), ArrayUtils.primitiveToObject(actual));
    }

    public static <T> boolean assertEqualsArrayIgnorePosition(T[] expect, T[] actual) {
        Arrays.sort(expect);
        Arrays.sort(actual);
        return assertEqualsArray(expect, actual);
    }

    public static boolean assertEqualsArrayAnyCase(int[][] expect, int[] actual) {
        return assertEqualsArrayAnyCase(ArrayUtils.primitiveTo2DObject(expect), ArrayUtils.primitiveToObject(actual));
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

    /****************** 2d array ******************/

    public static boolean assertEquals2DArray(int[][] expect, int[][] actual) {
        return assertEquals2DArray(ArrayUtils.primitiveTo2DObject(expect), ArrayUtils.primitiveTo2DObject(actual));
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
