package test.epam.sedkov.task1.validator;

import by.epam.sedkov.task1.validator.NumberValidator;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class NumberValidatorTest {

    @Test(dataProvider = "dataForPrime")
    public void testIsPrime(int arg) {
        boolean actual = NumberValidator.isPrime(arg);
        assertTrue(actual);
    }

    @Test(dataProvider = "dataWrongForPrime")
    public void testWrongIsPrime(int arg) {
        boolean actual = NumberValidator.isPrime(arg);
        assertFalse(actual);
    }

    @Test(dataProvider = "dataForFibonacci")
    public void testIsFibonacciNumber(int arg) {
        boolean actual = NumberValidator.isFibonacciNumber(arg);
        assertTrue(actual);
    }

    @Test(dataProvider = "dataForWrongFibonacci")
    public void testWrongIsFibonacciNumber(int arg) {
        boolean actual = NumberValidator.isFibonacciNumber(arg);
        assertFalse(actual);
    }

    @Test(dataProvider = "dataForDifferentThreeDigit")
    public void testIsDifferentThreeDigit(int arg) {
        boolean actual = NumberValidator.isDifferentThreeDigit(arg);
        assertTrue(actual);
    }

    @Test(dataProvider = "dataWrongForDifferentThreeDigit")
    public void testWrongIsDifferentThreeDigit(int arg) {
        boolean actual = NumberValidator.isDifferentThreeDigit(arg);
        assertFalse(actual);
    }

    @DataProvider(name = "dataForPrime")
    public static Object[][] dataForPrime() {
        return new Object[][]{
                {7}, {31}, {71}, {73}, {131}
        };
    }

    @DataProvider(name = "dataWrongForPrime")
    public static Object[][] dataWrongForPrime() {
        return new Object[][]{
                {-1895}, {-555}, {-31}, {-1}, {0}, {4}, {88}, {6519}
        };
    }

    @DataProvider(name = "dataForFibonacci")
    public static Object[][] dataForFibonacci() {
        return new Object[][]{
                {55}, {233}, {610}, {987}, {6765}, {10946}, {34}, {-55}, {-21}, {13}
        };
    }

    @DataProvider(name = "dataForWrongFibonacci")
    public static Object[][] dataForWrongFibonacci() {
        return new Object[][]{
                {-50}, {-15}, {15}, {1000}, {1550}, {11113}
        };
    }

    @DataProvider(name = "dataForDifferentThreeDigit")
    public static Object[][] dataForDifferentThreeDigit() {
        return new Object[][]{
                {123}, {-456}, {789}, {-409}
        };
    }

    @DataProvider(name = "dataWrongForDifferentThreeDigit")
    public static Object[][] dataWrongForDifferentThreeDigit() {
        return new Object[][]{
                {-123456}, {-100}, {12}, {121}, {855}, {990}, {1231}, {225599}
        };
    }

}