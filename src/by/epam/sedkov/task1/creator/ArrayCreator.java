package by.epam.sedkov.task1.creator;

import by.epam.sedkov.task1.exception.ProjectException;

import java.util.Scanner;

public class ArrayCreator {

    public int[] createRandomArray(int length, int maxRandomValue, int minRandomValue) throws ProjectException {
        if (length > 0) {
            int[] result = new int[length];
            for (int i = 0; i < result.length; i++) {
                result[i] = (int) (Math.random() * (maxRandomValue - minRandomValue + 1) + minRandomValue);
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
    }

    public int[] createArrayFromFile(String[] arrayString) throws ProjectException {
        if (arrayString != null) {
            int length = arrayString.length;
            int[] arrayInt = new int[length];
            for (int i = 0; i < length; i++) {
                arrayInt[i] = Integer.parseInt(arrayString[i]);
            }
            return arrayInt;
        } else {
            throw new ProjectException("Input string array is null");
        }
    }

}
