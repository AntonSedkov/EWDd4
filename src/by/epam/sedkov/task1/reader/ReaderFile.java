package by.epam.sedkov.task1.reader;

import by.epam.sedkov.task1.exception.ProjectException;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class ReaderFile {

    public String[] readAllForArray(String path) throws ProjectException {
        ArrayList<String> arrayList = new ArrayList<>();
        String data = "";
        try {
            FileReader fileReader = new FileReader(path);
            Scanner sc = new Scanner(fileReader);
            while (sc.hasNext()) {
                data = sc.nextLine();
                arrayList.add(data);
            }
        } catch (IOException e) {
            throw new ProjectException("IO exception", e);
        }
        String[] array = new String[arrayList.size()];
        array = arrayList.toArray(array);
        return array;
    }

    public String[] takeOneLineForArray(String[] input, int indexLine) throws ProjectException {
        if (input != null && indexLine >= 0 && indexLine < input.length) {
            String[] array = input[indexLine].split("\\s+");
            return array;
        } else {
            throw new ProjectException("Input strings is null or incorrect index of line");
        }
    }

}
