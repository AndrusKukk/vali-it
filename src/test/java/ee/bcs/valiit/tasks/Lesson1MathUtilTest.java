package ee.bcs.valiit.tasks;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.test.util.AssertionErrors;

public class Lesson1MathUtilTest {

    @Test
    public void test (){
        Assertions.assertEquals(3,Lesson1MathUtil.min(3,4));
        Assertions.assertEquals(-4,Lesson1MathUtil.min(3,-4));
        Assertions.assertEquals(0,Lesson1MathUtil.min(3,0));
    }

    @Test
    void max() {
        Assertions.assertEquals(1, Lesson1MathUtil.max(0,1));
        Assertions.assertEquals(10, Lesson1MathUtil.max(5,10));
        Assertions.assertEquals(-2, Lesson1MathUtil.max(-2,-5));
    }

    @Test
    void abs() {
        Assertions.assertEquals(4, Lesson1MathUtil.abs(-4));
        Assertions.assertEquals(4, Lesson1MathUtil.abs(4));
    }

    @Test
    void isEven() {
        Assertions.assertTrue(Lesson1MathUtil.isEven(4));
        Assertions.assertFalse(Lesson1MathUtil.isEven(3));

    }

    @Test
    void min3() {
        Assertions.assertEquals(3, Lesson1MathUtil.min3(3, 4, 5));
        Assertions.assertEquals(-4, Lesson1MathUtil.min3(3, -4, 5));
        Assertions.assertEquals(0, Lesson1MathUtil.min3(3, 0, 5));
    }

    @Test
    void max3() {
        Assertions.assertEquals(5, Lesson1MathUtil.max3(3, 4, 5));
        Assertions.assertEquals(5, Lesson1MathUtil.max3(3, -4, 5));
        Assertions.assertEquals(0, Lesson1MathUtil.max3(-3, 0, -5));
    }
}
