package test;


import main.ArrayUtil;

import static org.junit.Assert.*;

import main.PredicateFilter;
import org.junit.Test;

/**
 * @author Лобанов Михаил
 */
public class ArrayUtilTest {
    @Test
    public void filter() throws Exception {
        int[] arrIn = {1, 2, 3, 4, 5, 6};
        int[] arrIn2 = {1, 2, 3, 4, 5};
        assertArrayEquals(arrIn2, ArrayUtil.filter(arrIn, new PredicateFilter("<=", 5, 1)));
    }

    @Test
    public void mix() throws Exception {
        int[] arrIn = {1, 2, 3, 4, 5, 6};
        int size = 5;
        assertEquals(size, ArrayUtil.resize(arrIn, size).length);
    }

    @Test
    public void comparison() throws Exception {
        int[] arrIn = {1, 6, 1, 2, 7, 2, 3, 2, 7, 4, 5, 6};
        int[] arrIn2 = {1, 2, 3, 3, 1, 5, 4, 6, 7};
        assertEquals(true, ArrayUtil.comparison(arrIn, arrIn2));
    }

    @Test
    public void resizeLength() throws Exception {
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