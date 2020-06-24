package by.epam.sedkov.task1;

import by.epam.sedkov.task1.creator.ArrayCreator;
import by.epam.sedkov.task1.entity.IntArray;
import by.epam.sedkov.task1.exception.ProjectException;
import by.epam.sedkov.task1.reader.ReaderFile;
import by.epam.sedkov.task1.service.NumericService;
import by.epam.sedkov.task1.service.SortingService;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws ProjectException {

        ArrayCreator as = new ArrayCreator();
        ReaderFile rf = new ReaderFile();
        String[] tt = rf.readAllForArray("./data/dataForArray.txt");
        String[] line1 = rf.takeOneLineForArray(tt, 0);
        String[] line2 = rf.takeOneLineForArray(tt, 1);
        String[] line3 = rf.takeOneLineForArray(tt, 2);
        int[] bb = as.createArrayFromFile(line1);
        System.out.println(Arrays.toString(bb));
        bb = as.createArrayFromFile(line2);
        System.out.println(Arrays.toString(bb));
        bb = as.createArrayFromFile(line3);
        System.out.println(Arrays.toString(bb));
        IntArray intArray=new IntArray(7);
        intArray.setArray(bb);
        NumericService tro = new NumericService();
        System.out.println(Arrays.toString(tro.receiveFibonacciNumbers(intArray)));
        System.out.println(Arrays.toString(tro.receivePrimeNumbers(intArray)));
        System.out.println(Arrays.toString(tro.receiveThreeDifferentDigitNumbers(intArray)));
        SortingService ss = new SortingService();
        System.out.println(ss.increasingBobbleSort(intArray));
        System.out.println(ss.reverseArray(intArray));
        System.out.println(ss.increasingSelectionSort(intArray));
        System.out.println(ss.reverseArray(intArray));
        System.out.println(ss.increasingShellSort(intArray));
        System.out.println(ss.reverseArray(intArray));
        System.out.println(ss.binarySearch(intArray,3));
        System.out.println(ss.binarySearch(intArray,30));


    }

}
