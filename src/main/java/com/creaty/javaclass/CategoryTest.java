package com.creaty.javaclass;

import junit.framework.TestCase;
import org.junit.Test;

import java.util.Arrays;

/**
 * Created by hyx on 2015/11/8.
 */
public class CategoryTest extends TestCase {

    @Test
    public void testCategory() throws Exception {
        assertEquals("A", Category.category(Arrays.asList(90, 98, 100)));
        assertEquals("invalid score", Category.category(Arrays.asList(100, -90, 0)));
        assertEquals("C", Category.category(Arrays.asList(100, 98, 0)));
        assertEquals("D", Category.category(Arrays.asList(40, 40, 50)));
        assertEquals("B", Category.category(Arrays.asList(89, 76, 90)));
    }
}