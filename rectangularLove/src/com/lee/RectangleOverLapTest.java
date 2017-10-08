package com.lee;

import org.junit.Assert;
import org.junit.*;

/**
 * Created by Do My Duyen on 9/9/2017.
 */

public class RectangleOverLapTest {


    @Test(expected = IllegalArgumentException.class)
    public void test_find_Rectangle_Overlap_with_Rectangle_Input_Is_Null() {
        Rectangle rectangle = RectangleOverLap.findRectangleOverlap(null, null);
    }

    @Test
    public void test_find_Rectangle_Overlap_with_Two_Rectangle_No_OverlapX_And_Y_first_Test() {
        Rectangle rectangle1 = new Rectangle(1,1,3,2);
        Rectangle rectangle2 = new Rectangle(5,4,3,3);
        Rectangle rectangle = RectangleOverLap.findRectangleOverlap(rectangle1, rectangle2);
        Assert.assertEquals(rectangle, Rectangle.NO_RECTANGLE);
    }

    @Test
    public void test_find_Rectangle_Overlap_with_Two_Rectangle_No_OverlapX_And_Y_second_Test() {
        Rectangle rectangle1 = new Rectangle(5,4,3,3);
        Rectangle rectangle2 = new Rectangle(1,1,3,2);
        Rectangle rectangle = RectangleOverLap.findRectangleOverlap(rectangle1, rectangle2);
        Assert.assertEquals(rectangle, Rectangle.NO_RECTANGLE);
    }

    @Test
    public void test_find_Rectangle_Overlap_with_Two_Rectangle_No_OverlapX_And_Y_third_Test() {
        Rectangle rectangle1 = new Rectangle(5, 1 , 3, 4);
        Rectangle rectangle2 = new Rectangle(1,6,3, 4);
        Rectangle rectangle = RectangleOverLap.findRectangleOverlap(rectangle1, rectangle2);
        Assert.assertEquals(rectangle, Rectangle.NO_RECTANGLE);
    }

    @Test
    public void test_find_Rectangle_Overlap_With_Two_Rectangle_OverlapX_But_Y_Same_Dimension() {
        Rectangle rectangle1 = new Rectangle(5, 1 , 3, 5);
        Rectangle rectangle2 = new Rectangle(1,6,7, 4);
        Rectangle rectangle = RectangleOverLap.findRectangleOverlap(rectangle1, rectangle2);
        Assert.assertEquals(rectangle, Rectangle.NO_RECTANGLE);
    }

    @Test
    public void test_find_Rectangle_Overlap_With_Rectangle1_Contain_Rectangle2() {
        Rectangle rectangle1 = new Rectangle(1 , 1, 9, 9);
        Rectangle rectangle2 = new Rectangle(2,2,4, 4);
        Rectangle rectangle = RectangleOverLap.findRectangleOverlap(rectangle1, rectangle2);
        Assert.assertEquals(rectangle, new Rectangle(2,2, 4,4));
    }

    @Test
    public void test_find_Rectangle_Overlap() {
        Rectangle rectangle1 = new Rectangle(1 , 1, 5, 3);
        Rectangle rectangle2 = new Rectangle(3,2,5, 4);
        Rectangle rectangle = RectangleOverLap.findRectangleOverlap(rectangle1, rectangle2);
        Assert.assertEquals(rectangle, new Rectangle(3,2, 3,2));

    }
}
