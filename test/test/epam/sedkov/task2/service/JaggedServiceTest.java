package test.epam.sedkov.task2.service;

import by.epam.sedkov.task2.service.JaggedService;
import by.epam.sedkov.task2.type.TypeDirection;
import by.epam.sedkov.task2.type.TypeSort;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class JaggedServiceTest {
    JaggedService jaggedService;
    int[][] jaggedArray;

    @BeforeMethod
    public void setUp() {
        jaggedService = new JaggedService();
        jaggedArray = new int[][]{{2, 4, 6, 8}, {46, 99}, {-1, -3, -6}, {1, 2, 3, 4, 5, 6, -7, 8, 9}};
    }

    @Test(dataProvider = "jaggedArray")
    public void testBooleanSortByType(TypeSort sortBy, TypeDirection direction, int[][] expected) {
        boolean actual = jaggedService.sortByType(jaggedArray, sortBy, direction);
        Assert.assertTrue(actual);
    }

    @Test(dataProvider = "jaggedArray")
    public void testArraySortByType(TypeSort sortBy, TypeDirection direction, int[][] expected) {
        jaggedService.sortByType(jaggedArray, sortBy, direction);
        Assert.assertEquals(jaggedArray, expected);
    }

    @Test
    public void testFalseSortByType() {
        boolean actual = jaggedService.sortByType(null, TypeSort.SUM, TypeDirection.INCREASE);
        Assert.assertFalse(actual);
    }

    @DataProvider(name = "jaggedArray")
    public Object[][] jaggedArray() {
        return new Object[][]{
                {TypeSort.SUM, TypeDirection.INCREASE, new int[][]{{-1, -3, -6}, {2, 4, 6, 8}, {1, 2, 3, 4, 5, 6, -7, 8, 9}, {46, 99}}},
                {TypeSort.SUM, TypeDirection.DECREASE, new int[][]{{46, 99}, {1, 2, 3, 4, 5, 6, -7, 8, 9}, {2, 4, 6, 8}, {-1, -3, -6}}},
                {TypeSort.MAX, TypeDirection.INCREASE, new int[][]{{-1, -3, -6}, {2, 4, 6, 8}, {1, 2, 3, 4, 5, 6, -7, 8, 9}, {46, 99}}},
                {TypeSort.MAX, TypeDirection.DECREASE, new int[][]{{46, 99}, {1, 2, 3, 4, 5, 6, -7, 8, 9}, {2, 4, 6, 8}, {-1, -3, -6}}},
                {TypeSort.MIN, TypeDirection.INCREASE, new int[][]{{1, 2, 3, 4, 5, 6, -7, 8, 9}, {-1, -3, -6}, {2, 4, 6, 8}, {46, 99}}},
                {TypeSort.MIN, TypeDirection.DECREASE, new int[][]{{46, 99}, {2, 4, 6, 8}, {-1, -3, -6}, {1, 2, 3, 4, 5, 6, -7, 8, 9}}}
        };
    }
}