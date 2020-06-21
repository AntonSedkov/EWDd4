package by.epam.sedkov.task1.service;

import by.epam.sedkov.task1.validator.NumberValidator;

import java.util.Arrays;

public class IntegerArrayService {

    public void increasingBobbleSort(int[] array) {
        boolean sorted = false;
        while (!sorted) {
            sorted = true;
            for (int i = 0; i < array.length - 1; i++) {
                if (array[i + 1] < array[i]) {
                    swapElements(array, i, (i + 1));
                    sorted = false;
                }
            }
        }
    }

    public void increasingSelectionSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            int tmp = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[tmp] > array[j]) {
                    tmp = j;
                }
            }
            swapElements(array, i, tmp);
        }
    }

    public void increasingShellSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            while (i > 0) {
                if (array[i] < array[i - 1]) {
                    swapElements(array, (i - 1), i);
                    i--;
                } else {
                    break;
                }
            }
        }
    }

    public int binarySearch(int[] array, int element) {
        if ((array != null) && (element >= array[0]) && (element <= array[array.length-1])) {
            int startIndex = 0;
            int endIndex = array.length - 1;
            while (startIndex < endIndex) {
                int middle = startIndex + (endIndex - startIndex) / 2;
                if (element < array[middle]) {
                    endIndex = middle;
                } else if (element > array[middle]) {
                    startIndex = middle + 1;
                } else if (element == array[middle]) {
                    return middle;
                }
            }
            return -1;
        }
        return -1;
    }
// TODO: 21.06.2020

    public int[] receivePrimeNumbers(int[] array) {
        int[] primeNumbers = new int[0];
        for (int value : array) {
            if (NumberValidator.isPrime(value)) {
                primeNumbers = createNewArrayWithElement(primeNumbers, value);
            }
        }
        return primeNumbers;
    }

    public int[] receiveFibonacciNumbers(int[] array) {
        int[] fibonacciNumbers = new int[0];
        for (int value : array) {
            if (NumberValidator.isFibonacciNumber(value)) {
                fibonacciNumbers = createNewArrayWithElement(fibonacciNumbers, value);
            }
        }
        return fibonacciNumbers;
    }

    public int[] receiveThreeDifferentDigitNumbers(int[] array) {
        int[] numbers = new int[0];
        for (int value : array) {
            if (NumberValidator.isDifferentThreeDigit(value)) {
                numbers = createNewArrayWithElement(numbers, value);
            }
        }
        return numbers;
    }

    public void reverseArray(int[] array) {
        for (int i = 0; i < array.length / 2; i++) {
            swapElements(array, i, array.length - 1 - i);
        }
    }

    private void swapElements(int[] array, int indexOne, int indexTwo) {
        int tmp = array[indexOne];
        array[indexOne] = array[indexTwo];
        array[indexTwo] = tmp;
    }

    private int[] createNewArrayWithElement(int[] oldArray, int element) {
        int[] newArray = Arrays.copyOf(oldArray, oldArray.length + 1);
        newArray[newArray.length - 1] = element;
        return newArray;
    }

}
