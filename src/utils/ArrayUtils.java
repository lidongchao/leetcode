package utils;

import java.util.Arrays;

public class ArrayUtils {
    public static String toStringInt2DArray(final int[][] arr) {
        StringBuilder sb = new StringBuilder();
        for (int[] a : arr) {
            sb.append(Arrays.toString(a)).append("\n");
        }
        return sb.toString();
    }

    public static String toString2DArray(final Object[][] arr) {
        StringBuilder sb = new StringBuilder();
        for (Object[] a : arr) {
            sb.append(Arrays.toString(a)).append("\n");
        }
        return sb.toString();
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

    public static int[][] to2DPrimitive(final Integer[][] array) {
        if (array == null) {
            return null;
        } else if (array.length == 0 || array[0].length == 0) {
            return EMPTY_INT_2D_ARRAY;
        }
        final int[][] result = new int[array.length][array[0].length];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                result[i][j] = array[i][j];
            }
        }
        return result;
    }

    public static Integer[][] to2DObject(final int[][] array) {
        if (array == null) {
            return null;
        } else if (array.length == 0 || array[0].length == 0) {
            return EMPTY_INTEGER_2D_ARRAY;
        }
        final Integer[][] result = new Integer[array.length][array[0].length];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                result[i][j] = array[i][j];
            }
        }
        return result;
    }

    private static final int[] EMPTY_INT_ARRAY = new int[0];
    private static final Integer[] EMPTY_INTEGER_ARRAY = new Integer[0];
    private static final int[][] EMPTY_INT_2D_ARRAY = new int[0][];
    private static final Integer[][] EMPTY_INTEGER_2D_ARRAY = new Integer[0][];
}
