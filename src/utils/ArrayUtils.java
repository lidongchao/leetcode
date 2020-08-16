package utils;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

public class ArrayUtils {
    /**
     * 输出二维数组的格式化字符串
     * @param arr 二维数字
     * @return 格式化字符串
     */
    public static String toStringInt2DArray(final int[][] arr) {
        StringBuilder sb = new StringBuilder();
        for (int[] a : arr) {
            sb.append(Arrays.toString(a)).append("\n");
        }
        return sb.toString();
    }

    /**
     * 输出二维数组的格式化字符串，数组中的每一个数字都要统一位数，不足的前面补 0
     * @param arr 二维数字
     * @return 格式化字符串
     */
    public static String toStringInt2DRichArray(final int[][] arr) {
        StringBuilder sb = new StringBuilder();

        int max = 0;
        for (int[] a : arr) {
            max = Math.max(max, Arrays.stream(a).max().orElse(0));
        }

        int n = 1;
        while (max / 10 != 0) {
            max = max / 10;
            n++;
        }
        String formatString = "%0" + n + "d";

        int iMax = arr[0].length - 1;

        for (int[] a : arr) {
            sb.append('[');
            for (int i = 0; i <= iMax; i++) {

                sb.append(String.format(formatString, a[i]));
                if (i == iMax)
                    sb.append(']');
                else sb.append(", ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    /**
     * 输出二维数组的格式化字符串
     * @param arr 二维数字
     * @return 格式化字符串
     */
    public static String toString2DArray(final Object[][] arr) {
        StringBuilder sb = new StringBuilder();
        for (Object[] a : arr) {
            sb.append(Arrays.toString(a)).append("\n");
        }
        return sb.toString();
    }

    /****************** int 数组转换方法 ******************/

    public static int[] toPrimitive(final Integer[] array) {
        if (array == null) {
            return null;
        } else if (array.length == 0) {
            return EMPTY_INT_ARRAY;
        }
        return Arrays.stream(array).mapToInt(Integer::intValue).toArray();
     }

    public static Integer[] toObject(final int[] array) {
        if (array == null) {
           return null;
        } else if (array.length == 0) {
            return EMPTY_INTEGER_ARRAY;
        }
        return Arrays.stream(array).boxed().toArray(Integer[]::new);
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
        return Stream.of(array).map(ArrayUtils::toObject).toArray(Integer[][]::new);
    }

    public static Integer[][] toObject(final List<List<Integer>> listForList) {
        if (listForList == null) {
            return null;
        } else if (listForList.size() == 0) {
            return EMPTY_INTEGER_2D_ARRAY;
        }
        return listForList.stream().map(x -> x.toArray(new Integer[0])).toArray(Integer[][]::new);
    }

    private static final int[] EMPTY_INT_ARRAY = new int[0];
    private static final Integer[] EMPTY_INTEGER_ARRAY = new Integer[0];
    private static final int[][] EMPTY_INT_2D_ARRAY = new int[0][];
    private static final Integer[][] EMPTY_INTEGER_2D_ARRAY = new Integer[0][];

    /****************** double 数组转换方法 ******************/

    public static Double[] toObject(final double[] array) {
        if (array == null) {
            return null;
        } else if (array.length == 0) {
            return EMPTY_DOUBLE_ARRAY;
        }
        return Arrays.stream(array).boxed().toArray(Double[]::new);
    }

    private static final double[] EMPTY_PRIMITIVE_DOUBLE_ARRAY = new double[0];
    private static final Double[] EMPTY_DOUBLE_ARRAY = new Double[0];

    /****************** char 数组转换方法 ******************/

    public static Character[] toObject(final char[] array) {
        if (array == null) {
            return null;
        } else if (array.length == 0) {
            return EMPTY_CHARACTER_ARRAY;
        }
        final Character[] result = new Character[array.length];
        for (int i = 0; i < array.length; i++) {
            result[i] = array[i];
        }
        return result;
    }

    public static Character[][] to2DObject(final char[][] array) {
        if (array == null) {
            return null;
        } else if (array.length == 0 || array[0].length == 0) {
            return EMPTY_CHARACTER_2D_ARRAY;
        }
        return Stream.of(array).map(ArrayUtils::toObject).toArray(Character[][]::new);
    }

    private static final Character[] EMPTY_CHARACTER_ARRAY = new Character[0];
    private static final Character[][] EMPTY_CHARACTER_2D_ARRAY = new Character[0][];


    /****************** main ******************/

    public static void main(String[] args) {
        double[] doubleOrigin = new double[]{1.1, 1.2, 1.3, 1.4};
        Double[] doubleBoxed = toObject(doubleOrigin);
        Double[] doubleExpect = new Double[]{1.1, 1.2, 1.3, 1.4};
        AssertUtils.assertEqualsArray(doubleExpect, doubleBoxed);

    }
}
