package by.epam.sedkov.task1.service;

import by.epam.sedkov.task1.entity.IntArray;
import by.epam.sedkov.task1.exception.ProjectException;

public class SortingService {

    public boolean increasingBobbleSort(IntArray array) throws ProjectException {
        if (array != null) {
            boolean sorted = false;
            int length = array.size();
            while (!sorted) {
                sorted = true;
                for (int i = 0; i < length - 1; i++) {
                    if (array.getElement(i + 1) < array.getElement(i)) {
                        swapElements(array, i, (i + 1));
                        sorted = false;
                    }
                }
            }
            return true;
        } else {
            return false;
        }
    }

    public boolean increasingSelectionSort(IntArray array) throws ProjectException {
        if (array != null) {
            int length = array.size();
            for (int i = 0; i < length - 1; i++) {
                int tmp = i;
                for (int j = i + 1; j < length; j++) {
                    if (array.getElement(tmp) > array.getElement(j)) {
                        tmp = j;
                    }
                }
                swapElements(array, i, tmp);
            }
            return true;
        } else {
            return false;
        }
    }

    public boolean increasingShellSort(IntArray array) throws ProjectException {
        if (array != null) {
            int length = array.size();
            for (int i = 1; i < length; i++) {
                while (i > 0) {
                    if (array.getElement(i) < array.getElement(i - 1)) {
                        swapElements(array, (i - 1), i);
                        i--;
                    } else {
                        break;
                    }
                }
            }
            return true;
        } else {
            return false;
        }
    }

    public int binarySearch(IntArray array, int element) throws ProjectException {
        if ((array != null) && (element <= array.getElement(0))
                && (element >= array.getElement(array.size() - 1))) {
            int startIndex = 0;
            int endIndex = array.size() - 1;
            while (startIndex < endIndex) {
                int middle = startIndex + (endIndex - startIndex) / 2;
                int middleElement = array.getElement(middle);
                if (element < middleElement) {
                    endIndex = middle;
                } else if (element > middleElement) {
                    startIndex = middle + 1;
                } else if (element == middleElement) {
                    return middle;
                }
            }
            return -(startIndex + 1);
        }
        return -1;
    }

    public boolean reverseArray(IntArray array) throws ProjectException {
        if (array != null) {
            int length = array.size();
            for (int i = 0; i < length / 2; i++) {
                swapElements(array, i, length - 1 - i);
            }
            return true;
        } else {
            return false;
        }
    }

    private void swapElements(IntArray array, int indexOne, int indexTwo) throws ProjectException {
        int tmp = array.getElement(indexOne);
        array.setElement(array.getElement(indexTwo), indexOne);
        array.setElement(tmp, indexTwo);
    }

}