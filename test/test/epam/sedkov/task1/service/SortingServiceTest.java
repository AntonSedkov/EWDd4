package test.epam.sedkov.task1.service;

import by.epam.sedkov.task1.entity.IntArray;
import by.epam.sedkov.task1.exception.ProjectException;
import by.epam.sedkov.task1.service.SortingService;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class SortingServiceTest {
    SortingService sortingService;
    IntArray example;
    IntArray sorted;

    @BeforeMethod
    public void setUp() {
        sortingService = new SortingService();
        try {
            example = new IntArray(new int[]{52, 6666, 1, -89, 152});
            sorted = new IntArray(new int[]{-89, 1, 52, 152, 6666});
        } catch (ProjectException e) {
            fail();
        }
    }

    @Test
    public void testBooleanIncreasingBobbleSort() {
        try {
            boolean actual = sortingService.increasingBobbleSort(example);
            assertTrue(actual);
        } catch (ProjectException e) {
            fail();
        }
    }

    @Test
    public void testIntArrayIncreasingBobbleSort() {
        try {
            sortingService.increasingBobbleSort(example);
            assertEquals(example, sorted);
        } catch (ProjectException e) {
            fail();
        }
    }

    @Test
    public void testFalseIncreasingBobbleSort() {
        try {
            boolean actual = sortingService.increasingBobbleSort(null);
            assertFalse(actual);
        } catch (ProjectException e) {
            fail();
        }
    }

    @Test
    public void testBooleanIncreasingSelectionSort() {
        try {
            boolean actual = sortingService.increasingSelectionSort(example);
            assertTrue(actual);
        } catch (ProjectException e) {
            fail();
        }
    }

    @Test
    public void testFalseIncreasingSelectionSort() {
        try {
            boolean actual = sortingService.increasingSelectionSort(null);
            assertFalse(actual);
        } catch (ProjectException e) {
            fail();
        }
    }

    @Test
    public void testIntArrayIncreasingSelectionSort() {
        try {
            sortingService.increasingSelectionSort(example);
            assertEquals(example, sorted);
        } catch (ProjectException e) {
            fail();
        }
    }

    @Test
    public void testBooleanIncreasingShellSort() {
        try {
            boolean actual = sortingService.increasingShellSort(example);
            assertTrue(actual);
        } catch (ProjectException e) {
            fail();
        }
    }

    @Test
    public void testFalseIncreasingShellSort() {
        try {
            boolean actual = sortingService.increasingShellSort(null);
            assertFalse(actual);
        } catch (ProjectException e) {
            fail();
        }
    }

    @Test
    public void testIntArrayIncreasingShellSort() {
        try {
            sortingService.increasingShellSort(example);
            assertEquals(example, sorted);
        } catch (ProjectException e) {
            fail();
        }
    }

    @Test
    public void testBinarySearch() {
        int expected = 3;
        try {
            int actual = sortingService.binarySearch(sorted, 152);
        } catch (ProjectException e) {
            fail();
        }
    }

    @Test
    public void testIntArrayReverseArray() {
        try {
            IntArray reversed = new IntArray(new int[]{6666, 152, 52, 1, -89});
            sortingService.reverseArray(sorted);
            assertEquals(sorted, reversed);
        } catch (ProjectException e) {
            fail();
        }
    }

    @Test
    public void testBooleanReverseArray() {
        try {
            boolean actual = sortingService.reverseArray(sorted);
            assertTrue(actual);
        } catch (ProjectException e) {
            fail();
        }
    }

}