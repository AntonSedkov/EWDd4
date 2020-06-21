package by.epam.sedkov.task1;

import by.epam.sedkov.task1.creator.ArrayCreator;
import by.epam.sedkov.task1.entity.IntegerArray;
import by.epam.sedkov.task1.exception.ProjectException;
import by.epam.sedkov.task1.reader.ReaderFile;
import by.epam.sedkov.task1.service.IntegerArrayService;

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


        IntegerArrayService tro = new IntegerArrayService();
        int[] arr = new int[]{1, 2, 3, 4, 55, 6678};
        System.out.println(tro.binarySearch(arr,44));
    }


}
