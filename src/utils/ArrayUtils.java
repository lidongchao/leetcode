package utils;

import java.util.Arrays;

public class ArrayUtils {
    public static void print2DimArray(final int[][] arr) {
        for (int[] a : arr) {
            System.out.println(Arrays.toString(a));
        }
    }

    public static int[] toPrimitive(final Integer[] array) {
        if (array == null) {
            return null;
        } else if (array.length == 0) {
            return EMPTY_INT_ARRAY;
        }
        final int[] result = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            result[i] = array[i];
        }
        return result;
     }

    public static Integer[] toObject(final int[] array) {
        if (array == null) {
           return null;
        } else if (array.length == 0) {
            return EMPTY_INTEGER_ARRAY;
        }
        final Integer[] result = new Integer[array.length];
        for (int i = 0; i < array.length; i++) {
            result[i] = array[i];
        }
        return result;
    }

    private static final int[] EMPTY_INT_ARRAY = new int[0];
    private static final Integer[] EMPTY_INTEGER_ARRAY = new Integer[0];
}
