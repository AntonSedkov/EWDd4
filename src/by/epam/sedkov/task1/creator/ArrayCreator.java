package by.epam.sedkov.task1.creator;

import by.epam.sedkov.task1.exception.ProjectException;

import java.util.Scanner;

public class ArrayCreator {
    private static final int MAX_RANDOM_VALUE = 3589;
    private static final int MIN_RANDOM_VALUE = -1972;

    public int[] createRandomArray(int length) throws ProjectException {
        if (length > 0) {
            int[] result = new int[length];
            for (int i = 0; i < result.length; i++) {
                result[i] = (int) (Math.random() * (MAX_RANDOM_VALUE - MIN_RANDOM_VALUE + 1) + MIN_RANDOM_VALUE);
            }
            return result;
        } else {
            throw new ProjectException("Array length must be over 0");
        }
    }

    public int[] createArrayFromConsole(int length) throws ProjectException {
        if (length > 0) {
            int[] result = new int[length];
            Scanner sc = new Scanner(System.in);
            int i = 0;
            while (i < length) {
                if (sc.hasNextInt()) {
                    result[i] = sc.nextInt();
                    i++;
                } else {
                    sc.next();
                }
            }
            return result;
        } else {
            throw new ProjectException("Array length must be over 0");
        }
    }// TODO: 21.06.2020

    public int[] createArrayFromFile(String[] arrayString) throws ProjectException {
        if (arrayString != null) {
            int length = Integer.parseInt(arrayString[0]);
            int[] arrayInt = new int[length];
            for (int i = 0; i < arrayInt.length && i < arrayString.length - 1; i++) {
                arrayInt[i] = Integer.parseInt(arrayString[i + 1]);
            }
            return arrayInt;
        } else {
            throw new ProjectException("Input string array is null");
        }
    }

}
