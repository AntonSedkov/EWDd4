package test.epam.sedkov.task1.entity;

import by.epam.sedkov.task1.entity.IntArray;
import by.epam.sedkov.task1.exception.ProjectException;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class IntArrayTest {
    IntArray array;

    @BeforeMethod
    public void setUp() {
        try {
            array = new IntArray(new int[]{0, 5, 156, 99999, -50, -38});
        } catch (ProjectException e) {
            fail();
        }
    }

    @Test
    public void testGetMaxElement() {
        int actual = array.getMaxElement();
        assertEquals(actual, 99999);
    }

    @Test
    public void testWrongGetMaxElement() {
        int actual = array.getMaxElement();
        assertNotEquals(actual, 0);
    }

    @Test
    public void testGetMinElement() {
        int actual = array.getMinElement();
        assertEquals(actual, -50);
    }

    @Test
    public void testWrongGetMinElement() {
        int actual = array.getMinElement();
        assertNotEquals(actual, 156);
    }

}