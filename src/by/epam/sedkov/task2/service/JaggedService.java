package by.epam.sedkov.task2.service;

public class JaggedService {
    // TODO: 24.06.2020
    private static final String INCREASE = "INCREASE";
    private static final String DECREASE = "DECREASE";
    private static final String MAX = "MAX";
    private static final String MIN = "MIN";
    private static final int[] DEFAULT_ARRAY = new int[0];

    public boolean sortBySum(int[][] jaggedArray) {
        if (jaggedArray != null) {
            int[] sumArray = makeSumArray(jaggedArray);
            sortJaggedArray(jaggedArray, sumArray);
            return true;
        } else {
            return false;
        }
    }

    public boolean sortByMax(int[][] jaggedArray) {
        if (jaggedArray != null) {
            int[] maxArray = makeMaxMinArray(jaggedArray, MAX);
            sortJaggedArray(jaggedArray, maxArray);
            return true;
        } else {
            return false;
        }
    }

    public boolean sortByMin(int[][] jaggedArray) {
        if (jaggedArray != null) {
            int[] minArray = makeMaxMinArray(jaggedArray, MIN);
            sortJaggedArray(jaggedArray, minArray);
            return true;
        } else {
            return false;
        }
    }

    private int[] makeSumArray(int[][] jaggedArray) {
        int length = jaggedArray.length;
        int[] sumArray = new int[length];
        for (int i = 0; i < length; i++) {
            int currentSum = 0;
            for (int j = 0; j < jaggedArray[i].length; j++) {
                currentSum += jaggedArray[i][j];
            }
            sumArray[i] = currentSum;
        }
        return sumArray;
    }

    private void sortJaggedArray(int[][] jaggedArray, int[] arraySortedBy) {
        boolean sorted = false;
        int length = jaggedArray.length;
        while (!sorted) {
            sorted = true;
            for (int i = 0; i < length - 1; i++) {
                if (arraySortedBy[i + 1] < arraySortedBy[i]) {
                    swapArray(jaggedArray, i, i + 1);
                    sorted = false;
                }
            }
        }
    }

    private void swapArray(int[][] toSort, int indexOne, int indexTwo) {
        int[] tmp = toSort[indexOne];
        toSort[indexOne] = toSort[indexTwo];
        toSort[indexTwo] = tmp;
    }

    private int[] makeMaxMinArray(int[][] jaggedArray, String condition) {
        int length = jaggedArray.length;
        int[] resultArray = new int[length];
        for (int i = 0; i < length; i++) {
            int currentResult = jaggedArray[i][0];
            for (int j = 0; j < jaggedArray[i].length; j++) {
                switch (condition) {
                    case MAX:
                        currentResult = Math.max(currentResult, jaggedArray[i][j]);
                        break;
                    case MIN:
                        currentResult = Math.min(currentResult, jaggedArray[i][j]);
                        break;
                    default:
                        return DEFAULT_ARRAY;
                }
            }
            resultArray[i] = currentResult;
        }
        return resultArray;
    }
}