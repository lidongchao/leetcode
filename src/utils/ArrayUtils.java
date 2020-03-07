package utils;

import java.util.Arrays;

public class ArrayUtils {
    public static void print2DimArray(int[][] arr) {
        for (int[] a : arr) {
            System.out.println(Arrays.toString(a));
        }
    }
}
