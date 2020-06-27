package test.epam.sedkov.task1.creator;

import by.epam.sedkov.task1.creator.ArrayCreator;
import by.epam.sedkov.task1.exception.ProjectException;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class ArrayCreatorTest {
    ArrayCreator arrayCreator;

    @BeforeMethod
    public void setUp() {
        arrayCreator = new ArrayCreator();
    }

    @Test
    public void testCreateRandomArray() {
        try {
            int[] actual = arrayCreator.createRandomArray(5, 28, -14);
            assertNotNull(actual);
        } catch (ProjectException e) {
            fail();
        }
    }

    @Test(expectedExceptions = ProjectException.class, expectedExceptionsMessageRegExp = "Array length must be over 0")
    public void testExceptionCreateRandomArray() throws ProjectException {
        int[] actual = arrayCreator.createRandomArray(-105, 28, -14);
    }

    @Test
    public void testCreateArrayFromFile() {
        String[] args = new String[]{"3", "7", "6", "5", "4", "3", "2", "1"};
        int[] expected = new int[]{3, 7, 6, 5, 4, 3, 2, 1};
        try {
            int[] actual = arrayCreator.createArrayFromFile(args);
            assertEquals(actual, expected);
        } catch (ProjectException e) {
            fail();
        }
    }

    @Test(expectedExceptions = ProjectException.class, expectedExceptionsMessageRegExp = "Input string array is null")
    public void testExceptionCreateArrayFromFile() throws ProjectException {
        int[] array = arrayCreator.createArrayFromFile(null);
    }

}