package test.epam.sedkov.task1.service;

import by.epam.sedkov.task1.entity.IntArray;
import by.epam.sedkov.task1.exception.ProjectException;
import by.epam.sedkov.task1.service.NumericService;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;

public class NumericServiceTest {
    NumericService numericService;
    IntArray exampleGood;
    IntArray exampleBad;

    @BeforeMethod
    public void setUp() {
        numericService = new NumericService();
        try {
            exampleGood = new IntArray(new int[]{
                    7, 6765, 123, 31, 10946, -456, 73, 987
            });
            exampleBad = new IntArray(new int[]{
                    -123456, 15, -31, 12, -100, 1000, 4, 88
            });
        } catch (ProjectException e) {
            fail();
        }
    }

    @Test
    public void testReceivePrimeNumbers() {
        int[] expected = new int[]{7, 31, 73};
        try {
            int[] actual = numericService.receivePrimeNumbers(exampleGood);
            assertEquals(actual, expected);
        } catch (ProjectException e) {
            fail();
        }
    }

    @Test
    public void testNullReceivePrimeNumbers() {
        int[] expected = new int[0];
        try {
            int[] actual = numericService.receivePrimeNumbers(exampleBad);
            assertEquals(actual, expected);
        } catch (ProjectException e) {
            fail();
        }
    }

    @Test
    public void testReceiveFibonacciNumbers() {
        int[] expected = new int[]{6765, 10946, 987};
        try {
            int[] actual = numericService.receiveFibonacciNumbers(exampleGood);
            assertEquals(actual, expected);
        } catch (ProjectException e) {
            fail();
        }
    }

    @Test
    public void testNullReceiveFibonacciNumbers() {
        int[] expected = new int[0];
        try {
            int[] actual = numericService.receiveFibonacciNumbers(exampleBad);
            assertEquals(actual, expected);
        } catch (ProjectException e) {
            fail();
        }
    }

    @Test
    public void testReceiveThreeDifferentDigitNumbers() {
        int[] expected = new int[]{123, -456, 987};
        try {
            int[] actual = numericService.receiveThreeDifferentDigitNumbers(exampleGood);
            assertEquals(actual, expected);
        } catch (ProjectException e) {
            fail();
        }
    }

    @Test
    public void testNullReceiveThreeDifferentDigitNumbers() {
        int[] expected = new int[0];
        try {
            int[] actual = numericService.receiveThreeDifferentDigitNumbers(exampleBad);
            assertEquals(actual, expected);
        } catch (ProjectException e) {
            fail();
        }
    }

}