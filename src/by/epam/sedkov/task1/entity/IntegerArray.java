package by.epam.sedkov.task1.entity;

import by.epam.sedkov.task1.exception.ProjectException;

import java.util.Arrays;
import java.util.StringJoiner;

public class IntegerArray {
    private int[] array;
    private final int CAPACITY;

    public IntegerArray(int capacity) throws ProjectException {
        if (capacity > 0) {
            this.CAPACITY = capacity;
            array = new int[capacity];
        } else {
            throw new ProjectException("Capacity must be over 0");
        }
    }

    public IntegerArray(int[] array) throws ProjectException {
        if (array != null) {
            this.array = array;
            CAPACITY = array.length;
        } else {
            throw new ProjectException("Array is null");
        }
    }

    public int[] getArray() {
        return array;
    }

    public void setArray(int[] array) {
        if (this.array != null) {
            for (int i = 0; i < CAPACITY && i < array.length; i++) {
                this.array[i] = array[i];
            }
        } else {
            this.array = array;
        }
    }

    public int getCapacity() {
        return CAPACITY;
    }

    public int getElementById(int id) throws ProjectException {
        if (id >= 0 && id < CAPACITY) {
            return array[id];
        } else {
            throw new ProjectException("Wrong index");
        }
    }

    public int getMaxElement() {
        int max = array[0];
        for (int i = 0; i < CAPACITY; i++) {
            max = Math.max(array[i], max);
        }
        return max;
    }

    public int getMinElement() {
        int min = array[0];
        for (int i = 0; i < CAPACITY; i++) {
            min = Math.min(array[i], min);
        }
        return min;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || this.getClass() != o.getClass()) {
            return false;
        }
        IntegerArray that = (IntegerArray) o;
        if (CAPACITY != that.CAPACITY) {
            return false;
        }
        return Arrays.equals(array, that.array);
    }

    @Override
    public int hashCode() {
        int result = Arrays.hashCode(array);
        result = 31 * result + CAPACITY;
        return result;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", IntegerArray.class.getSimpleName() + "[", "]")
                .add("array = " + Arrays.toString(array))
                .add("capacity = " + CAPACITY)
                .toString();
    }

}
