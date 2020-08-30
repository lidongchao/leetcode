package utils;

import java.util.*;
import java.util.stream.Stream;

public class ArrayUtils {

    /**
     * 一维 Array 转换为 List
     * @param array 一维数组
     * @param <T> 范型
     * @return 一维集合
     */
    public static <T> List<T> arrayToList(final T[] array) {
        if (array == null || array.length == 0) {
            //noinspection unchecked
            return Collections.EMPTY_LIST;
        }
        List<T> ts = new ArrayList<>(array.length);
        ts.addAll(Arrays.asList(array));
        return ts;
    }

    /**
     * 二维 Array 转换为 List
     * @param array 二维数组
     * @param <T> 范型
     * @return 二维集合
     */
    public static <T> List<List<T>> arrayTo2DList(final T[][] array) {
        if (array == null || array.length == 0) {
            //noinspection unchecked
            return Collections.EMPTY_LIST;
        }
        List<List<T>> ts = new ArrayList<>(array.length);
        for (T[] a : array) {
            ts.add(arrayToList(a));
        }
        return ts;
    }


    /**
     * 输出二维数组的格式化字符串
     * @param arr 二维数字
     * @return 格式化字符串
     */
    public static String toStringInt2DArray(final int[][] arr) {
        return toStringInt2DArray(arr, "\n");
    }

    public static String toStringInt2DArray(final int[][] arr, String separator) {
        return toString2DArray(primitiveTo2DObject(arr), separator);
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
    public static String toString2DArray(final Object[][] arr, String separator) {
        StringBuilder sb = new StringBuilder();
        for (Object[] a : arr) {
            sb.append(Arrays.toString(a)).append(separator);
        }
        return sb.toString();
    }

    public static String toString2DArray(final Object[][] arr) {
        return toString2DArray(arr, "\n");
    }

    /****************** int 数组转换方法 ******************/

    public static int[] objectToPrimitive(final Integer[] array) {
        if (array == null || array.length == 0) {
            return EMPTY_INT_ARRAY;
        }
        return Arrays.stream(array).mapToInt(Integer::intValue).toArray();
     }

    public static Integer[] primitiveToObject(final int[] array) {
        if (array == null || array.length == 0) {
           return EMPTY_INTEGER_ARRAY;
        }
        return Arrays.stream(array).boxed().toArray(Integer[]::new);
    }

    public static int[][] objectTo2DPrimitive(final Integer[][] array) {
        if (array == null || array.length == 0 || array[0].length == 0) {
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

    public static Integer[][] primitiveTo2DObject(final int[][] array) {
        if (array == null || array.length == 0 || array[0].length == 0) {
            return EMPTY_INTEGER_2D_ARRAY;
        }
        return Stream.of(array).map(ArrayUtils::primitiveToObject).toArray(Integer[][]::new);
    }

    public static Integer[][] listTo2DIntArray(final List<List<Integer>> listForList) {
        if (listForList == null || listForList.size() == 0) {
            return EMPTY_INTEGER_2D_ARRAY;
        }
        return listForList.stream().map(x -> x.toArray(new Integer[0])).toArray(Integer[][]::new);
    }

    private static final int[] EMPTY_INT_ARRAY = new int[0];
    private static final Integer[] EMPTY_INTEGER_ARRAY = new Integer[0];
    private static final int[][] EMPTY_INT_2D_ARRAY = new int[0][];
    private static final Integer[][] EMPTY_INTEGER_2D_ARRAY = new Integer[0][];

    /****************** double 数组转换方法 ******************/

    public static Double[] primitiveToObject(final double[] array) {
        if (array == null || array.length == 0) {
            return EMPTY_DOUBLE_ARRAY;
        }
        return Arrays.stream(array).boxed().toArray(Double[]::new);
    }

    private static final double[] EMPTY_PRIMITIVE_DOUBLE_ARRAY = new double[0];
    private static final Double[] EMPTY_DOUBLE_ARRAY = new Double[0];

    /****************** char 数组转换方法 ******************/

    public static Character[] primitiveToObject(final char[] array) {
        if (array == null || array.length == 0) {
            return EMPTY_CHARACTER_ARRAY;
        }
        final Character[] result = new Character[array.length];
        for (int i = 0; i < array.length; i++) {
            result[i] = array[i];
        }
        return result;
    }

    public static Character[][] primitiveTo2DObject(final char[][] array) {
        if (array == null || array.length == 0 || array[0].length == 0) {
            return EMPTY_CHARACTER_2D_ARRAY;
        }
        return Stream.of(array).map(ArrayUtils::primitiveToObject).toArray(Character[][]::new);
    }

    private static final Character[] EMPTY_CHARACTER_ARRAY = new Character[0];
    private static final Character[][] EMPTY_CHARACTER_2D_ARRAY = new Character[0][];

    /****************** 字符串转换方法 ******************/

    public static String[][] listTo2DStringArray(final List<List<String>> listForList) {
        if (listForList == null || listForList.size() == 0) {
            return EMPTY_STRING_2D_ARRAY;
        }
        return listForList.stream().map(x -> x.toArray(new String[0])).toArray(String[][]::new);
    }

    /**
     * 转换字符串为一维整型数组
     * @param str 形如 [4,2,5] 的字符串
     * @return 字符串对应的一维数组
     */
    public static List<Integer> stringToIntList(String str) {
        List<Integer> list = new LinkedList<>();
        if (str.length() == 0 || str.charAt(0) != '[' || str.charAt(str.length() - 1) != ']') {
            return list;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < str.length() - 1; i++) {
            char c = str.charAt(i);
            switch (c) {
                case '0': case '1': case '2': case '3': case '4': case '5': case '6': case '7': case '8': case '9':
                    sb.append(c);
                    break;
                case ',':
                    list.add(Integer.valueOf(sb.toString()));
                    sb = new StringBuilder();
                    break;
                default:
                    break;
            }
        }
        if (sb.length() != 0) {
            list.add(Integer.valueOf(sb.toString()));
        }
        return list;
    }

    public static Integer[] stringToIntArray(String str) {
        return stringToIntList(str).toArray(new Integer[0]);
    }

    public static int[] stringToPrimitiveIntArray(String str) {
        return objectToPrimitive(stringToIntArray(str));
    }

    /**
     * 转换字符串为二维整型数组
     * @param str 形如 [[0,1],[0,2],[2,5],[3,4],[4,2]] 的字符串
     * @return 字符串对应的二维数组
     */
    public static List<List<Integer>> stringTo2DIntList(String str) {
        List<List<Integer>> list = new LinkedList<>();
        if (str.length() == 0 || str.charAt(0) != '[' || str.charAt(str.length() - 1) != ']') {
            return list;
        }

        List<Integer> subList = null;
        StringBuilder sb = null;
        for (int i = 1; i < str.length() - 1; i++) {
            char c = str.charAt(i);
            switch (c) {
                case '[':
                    subList = new LinkedList<>();
                    sb = new StringBuilder();
                    break;
                case ']':
                    if (subList != null) {
                        subList.add(Integer.valueOf(sb.toString()));
                        list.add(subList);
                        subList = null;
                        sb = null;
                        break;
                    } else {
                        return null;
                    }
                case '0': case '1': case '2': case '3': case '4': case '5': case '6': case '7': case '8': case '9':
                    Objects.requireNonNull(sb).append(c);
                    break;
                case ',':
                    if (subList != null) {
                        subList.add(Integer.valueOf(sb.toString()));
                        sb = new StringBuilder();
                        break;
                    }
                default:
                    break;
            }
        }
        return list;
    }

    public static Integer[][] stringTo2DIntArray(String str) {
        return listTo2DIntArray(stringTo2DIntList(str));
    }

    public static int[][] stringTo2DPrimitiveIntArray(String str) {
        return objectTo2DPrimitive(stringTo2DIntArray(str));
    }


    /**
     * 转换字符串为一维字符串数组
     * @param str 形如 ["a","b"] 或 [a,b] 的字符串
     * @return 字符串对应的一维数组
     */
    public static List<String> stringToStringList(String str) {
        List<String> list = new LinkedList<>();
        if (str.length() == 0 || str.charAt(0) != '[' || str.charAt(str.length() - 1) != ']') {
            return list;
        }

        StringBuilder sb = new StringBuilder();
        boolean inQuotes = false;
        for (int i = 1; i < str.length() - 1; i++) {
            char c = str.charAt(i);
            switch (c) {
                case '"':
                    inQuotes = !inQuotes;
                    break;
                case ',':
                    list.add(sb.toString());
                    sb = new StringBuilder();
                    break;
                case ' ':
                    if (inQuotes) {
                        sb.append(c);
                    }
                    break;
                default:
                    sb.append(c);
                    break;
            }
        }
        if (sb.length() != 0) {
            list.add(sb.toString());
        }
        return list;
    }

    public static String[] stringToStringArray(String str) {
        return stringToStringList(str).toArray(new String[0]);
    }

    /**
     * 转换字符串为二维字符串数组
     * @param str 形如 [["MUC","LHR"],["JFK","MUC"],["SFO","SJC"],["MUC","SFO"],["SJC","MUC"]] 的字符串
     * @return 字符串对应的二维数组
     */
    public static List<List<String>> stringTo2DStringList(String str) {
        List<List<String>> list = new LinkedList<>();
        if (str.length() == 0 || str.charAt(0) != '[' || str.charAt(str.length() - 1) != ']') {
            return list;
        }

        List<String> subList = null;
        StringBuilder sb = null;
        boolean inQuotes = false;
        for (int i = 1; i < str.length() - 1; i++) {
            char c = str.charAt(i);
            switch (c) {
                case '[':
                    subList = new LinkedList<>();
                    sb = new StringBuilder();
                    break;
                case ']':
                    if (subList != null) {
                        subList.add(sb.toString());
                        list.add(subList);
                        subList = null;
                        sb = null;
                        break;
                    } else {
                        return null;
                    }
                case '"':
                    inQuotes = !inQuotes;
                    break;
                case ',':
                    if (subList != null) {
                        subList.add(sb.toString());
                        sb = new StringBuilder();
                    }
                    break;
                case ' ':
                    if (inQuotes) {
                        Objects.requireNonNull(sb).append(c);
                    }
                    break;
                default:
                    Objects.requireNonNull(sb).append(c);
                    break;
            }
        }
        return list;
    }

    public static String[][] stringTo2DStringArray(String str) {
        return listTo2DStringArray(stringTo2DStringList(str));
    }

    private static final String[] EMPTY_STRING_ARRAY = new String[0];
    private static final String[][] EMPTY_STRING_2D_ARRAY = new String[0][];

    /****************** main ******************/

    public static void main(String[] args) {
        {
            double[] doubleOrigin = new double[]{1.1, 1.2, 1.3, 1.4};
            Double[] doubleBoxed = primitiveToObject(doubleOrigin);
            Double[] doubleExpect = new Double[]{1.1, 1.2, 1.3, 1.4};
            AssertUtils.assertEqualsArray(doubleExpect, doubleBoxed);
        }

        {
            int[][] intString = ArrayUtils.stringTo2DPrimitiveIntArray("[[0, 1], [0, 2], [2, 5], [3, 4], [4, 2]]");
            int[][] intExpect = new int[][]{{0, 1}, {0, 2}, {2, 5}, {3, 4}, {4, 2}};
            AssertUtils.assertEquals2DArray(intExpect, intString);
        }

        {
            int[] intString = ArrayUtils.stringToPrimitiveIntArray("[4, 6, 9, 16, 2]");
            int[] intExpect = new int[]{4, 6, 9, 16, 2};
            AssertUtils.assertEqualsArray(intExpect, intString);
        }

        {
            // test for arrayToList
            Integer[] intArray = new Integer[]{4, 6, 9, 16, 2};
            List<Integer> intList = arrayToList(intArray);
            List<Integer> intExpect = stringToIntList("[4, 6, 9, 16, 2]");
            AssertUtils.assertEqualsList(intExpect, intList);
        }

        {
            // test for arrayTo2DList
            Integer[][] intArray = new Integer[][]{{4, 6}, {9}, {16, 2}};
            List<List<Integer>> intList = arrayTo2DList(intArray);
            List<List<Integer>> intExpect = stringTo2DIntList("[[4, 6], [9], [16, 2]]");
            AssertUtils.assertEqualsList(intExpect, intList);
        }



    }
}
