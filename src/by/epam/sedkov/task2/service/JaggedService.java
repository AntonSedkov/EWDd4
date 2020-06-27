package by.epam.sedkov.task2.service;

import by.epam.sedkov.task2.type.TypeDirection;
import by.epam.sedkov.task2.type.TypeSort;

public class JaggedService {

    private static final int[] DEFAULT_ARRAY = new int[0];

    public boolean sortByType(int[][] jaggedArray, TypeSort condition, TypeDirection direction) {
        if (jaggedArray != null) {
            int[] resultArray;
            switch (condition) {
                case SUM:
                    resultArray = makeSumArray(jaggedArray);
                    break;
                case MAX:
                case MIN:
                    resultArray = makeMaxMinArray(jaggedArray, condition);
                    break;
                default:
                    return false;
            }
            sortJaggedArray(jaggedArray, resultArray, direction);
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

    private int[] makeMaxMinArray(int[][] jaggedArray, TypeSort condition) {
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

    private void sortJaggedArray(int[][] jaggedArray, int[] arraySortedBy, TypeDirection direction) {
        boolean sorted = false;
        int length = jaggedArray.length;
        while (!sorted) {
            sorted = true;
            for (int i = 0; i < length - 1; i++) {
                if (sortCondition(arraySortedBy, i, direction)) {
                    swapElement(arraySortedBy, i, i + 1);
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

    private void swapElement(int[] array, int indexOne, int indexTwo) {
        int tmp = array[indexOne];
        array[indexOne] = array[indexTwo];
        array[indexTwo] = tmp;
    }

    private boolean sortCondition(int[] array, int index, TypeDirection direction) {
        switch (direction) {
            case INCREASE:
                return array[index + 1] < array[index];
            case DECREASE:
                return array[index + 1] > array[index];
            default:
                return false;
        }
    }

}