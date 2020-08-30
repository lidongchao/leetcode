package utils;

import java.util.*;

public class GeneratorUtils {

    private static Random random = new Random();

    /**
     * 生成数组
     * @param minSize 数组的最小个数
     * @param maxSize 数组的最大个数
     * @param minValue 数组元素的最小值
     * @param maxValue 数组元素的最大值
     * @return 随机数组
     */
    public static int[] generateRandomArray(int minSize, int maxSize, int minValue, int maxValue) {
        int[] arr = new int[randomValue(minSize, maxSize)];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = randomValue(minValue, maxValue);
        }
        return arr;
    }

    public static int[][] generateRandomMatrix(int rowNum, int colNum, int minValue, int maxValue) {
        int[][] matrix = new int[rowNum][colNum];
        for (int i = 0; i < rowNum; i++) {
            matrix[i] = generateRandomArray(colNum, colNum, minValue, maxValue);
        }
        return matrix;
    }

    public static TreeNode generateRandomTree(int height, int ratioToFork, int minValue, int maxValue) {
        if (height <= 0) return null;
        TreeNode root = new TreeNode(randomValue(minValue, maxValue));
        if (random.nextInt(100) < ratioToFork) {
            root.left = generateRandomTree(height - 1, ratioToFork, minValue, maxValue);
        }
        if (random.nextInt(100) < ratioToFork) {
            root.right = generateRandomTree(height - 1, ratioToFork, minValue, maxValue);
        }
        return root;
    }

    private static int randomValue(int min, int max) {
        return random.nextInt(max - min + 1) + min;
    }
}
