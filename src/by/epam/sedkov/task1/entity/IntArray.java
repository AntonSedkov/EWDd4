package by.epam.sedkov.task1.entity;

import by.epam.sedkov.task1.exception.ProjectException;

import java.util.Arrays;
import java.util.StringJoiner;

public class IntArray {
    private int[] array;

    public IntArray(int size) throws ProjectException {
        if (size < 0) {
            throw new ProjectException("Wrong array size");
        }
        array = new int[size];
    }

    public IntArray(int[] array) throws ProjectException {
        if (array == null) {
            throw new ProjectException("Array is null");
        }
        this.array = array;
    }

    public void setArray(int[] array) throws ProjectException {
        if (array == null) {
            throw new ProjectException("Array is null");
        }
        this.array = array;
    }

    public int size() {
        return array.length;
    }

    public int getElement(int index) throws ProjectException {
        if (!checkIndex(index)) {
            throw new ProjectException("Wrong index");
        }
        return array[index];

    }

    public void setElement(int element, int index) throws ProjectException {
        if (!checkIndex(index)) {
            throw new ProjectException("Wrong index");
        }
        array[index] = element;
    }

    public int getMaxElement() {
        int max = array[0];
        for (int value : array) {
            max = Math.max(value, max);
        }
        return max;
    }

    public int getMinElement() {
        int min = array[0];
        for (int value : array) {
            min = Math.min(value, min);
        }
        return min;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || o.getClass() != this.getClass()) {
            return false;
        }
        IntArray that = (IntArray) o;
        return Arrays.equals(array, that.array);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(array);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", IntArray.class.getSimpleName() + "[", "]")
                .add("array=" + Arrays.toString(array))
                .toString();
    }

    private boolean checkIndex(int index) {
        return index >= 0 && index < array.length;
    }

}
