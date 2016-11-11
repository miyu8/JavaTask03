package test;


import main.ArrayUtil;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * @author Лобанов Михаил
 */
public class ArrayUtilTest {

    @Test
    public void mixTest() throws Exception {
        int[] arrIn = {1, 2, 3, 4, 5, 6};
        int size = 5;
        assertEquals(size, ArrayUtil.resize(arrIn, size).length);
    }

    @Test
    public void comparisonTest() throws Exception {
        int[] arrIn = {1, 6, 1, 2, 7, 2, 3, 2, 7, 4, 5, 6};
        int[] arrIn2 = {1, 2, 3, 3, 1, 5, 4, 6, 7};
        assertEquals(true, ArrayUtil.comparison(arrIn, arrIn2));
    }

    @Test
    public void ResizeLength() throws Exception {
        int[] arrIn = {1, 2, 3};
        int size = 5;
        assertEquals(size, ArrayUtil.resize(arrIn, size).length);
    }

    @Test
    public void resizeMore() throws Exception {
        int[] arrIn = {1, 2, 3};
        int size = 5;
        assertEquals(0, ArrayUtil.resize(arrIn, size)[4]);
    }

    @Test
    public void resizeLess() throws Exception {
        int[] arrIn = {1, 2, 3};
        int size = 2;
        assertEquals(2, ArrayUtil.resize(arrIn, size)[1]);
    }
}