package by.epam.sedkov.task1.service;

import by.epam.sedkov.task1.entity.IntArray;
import by.epam.sedkov.task1.exception.ProjectException;
import by.epam.sedkov.task1.validator.NumberValidator;

public class NumericService {

    private static final int[] EMPTY_ARRAY = new int[0];

    public int[] receivePrimeNumbers(IntArray array) throws ProjectException {
        if (array != null) {
            int[] primeNumbers = EMPTY_ARRAY;
            int length = array.size();
            for (int i = 0; i < length; i++) {
                int element = array.getElement(i);
                if (NumberValidator.isPrime(element)) {
                    primeNumbers = createNewArrayWithElement(primeNumbers, element);
                }
            }
            return primeNumbers;
        } else {
            return EMPTY_ARRAY;
        }
    }

    public int[] receiveFibonacciNumbers(IntArray array) throws ProjectException {
        if (array != null) {
            int[] fibonacciNumbers = EMPTY_ARRAY;
            int length = array.size();
            for (int i = 0; i < length; i++) {
                int element = array.getElement(i);
                if (NumberValidator.isFibonacciNumber(element)) {
                    fibonacciNumbers = createNewArrayWithElement(fibonacciNumbers, element);
                }
            }
            return fibonacciNumbers;
        } else {
            return EMPTY_ARRAY;
        }
    }

    public int[] receiveThreeDifferentDigitNumbers(IntArray array) throws ProjectException {
        if (array != null) {
            int[] numbers = EMPTY_ARRAY;
            int length = array.size();
            for (int i = 0; i < length; i++) {
                int element = array.getElement(i);
                if (NumberValidator.isDifferentThreeDigit(element)) {
                    numbers = createNewArrayWithElement(numbers, element);
                }
            }
            return numbers;
        } else {
            return EMPTY_ARRAY;
        }
    }

    private int[] createNewArrayWithElement(int[] oldArray, int element) {
        int[] newArray = new int[oldArray.length + 1];
        int i = 0;
        while (i < oldArray.length) {
            newArray[i] = oldArray[i];
            i++;
        }
        newArray[newArray.length - 1] = element;
        return newArray;
    }

}
