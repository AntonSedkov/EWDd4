package test.epam.sedkov.task1.reader;

import by.epam.sedkov.task1.exception.ProjectException;
import by.epam.sedkov.task1.reader.ReaderFile;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;

public class ReaderFileTest {

    ReaderFile reader;
    String[] example;

    @BeforeMethod
    public void setUp() {
        reader = new ReaderFile();
        example = new String[]{"7 51 62 73 84 95 100 3337", "8 1 2 3 4 5", "3 7 6 5 4 3 2 1"};
    }

    @Test
    public void testReadAllForArray() {
        try {
            String[] actual = reader.readAllForArray("./data/dataForArray.txt");
            assertEquals(actual, example);
        } catch (ProjectException e) {
            fail();
        }
    }

    @Test(expectedExceptions = ProjectException.class, expectedExceptionsMessageRegExp = "IO exception")
    public void testExceptionReadAllForArray() throws ProjectException {
        String[] actual = reader.readAllForArray("./dataForArray.txt");
    }

    @Test
    public void testTakeOneLineForArray() {
        String[] expected = new String[]{"8", "1", "2", "3", "4", "5"};
        try {
            String[] actual = reader.takeOneLineForArray(example, 1);
            assertEquals(actual, expected);
        } catch (ProjectException e) {
            fail();
        }
    }

    @Test(dataProvider = "dataExceptionOneLine",
            expectedExceptions = ProjectException.class, expectedExceptionsMessageRegExp = "Input strings is null or incorrect index of line")
    public void testExceptionTakeOneLineForArray(String[] input, int index) throws ProjectException {
        String[] actual = reader.takeOneLineForArray(input, index);
    }

    @DataProvider(name = "dataExceptionOneLine")
    public static Object[][] dataExceptionOneLine() {
        String[] example = new String[]{"7 51 62", "8 1 2 3 4 5", "3 2 1"};
        return new Object[][]{
                {null, 1}, {example, -1}, {example, 5}
        };
    }

}