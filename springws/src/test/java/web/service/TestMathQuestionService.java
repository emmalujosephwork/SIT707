package web.service;

import org.junit.Assert;
import org.junit.Test;

public class TestMathQuestionService {

    // Test for valid addition input
    @Test
    public void testAddValidInput() {
        Assert.assertEquals(MathQuestionService.q1Addition("5", "7"), 12, 0);
    }

    // Test for valid subtraction input
    @Test
    public void testSubValidInput() {
        Assert.assertEquals(MathQuestionService.q2Subtraction("10", "4"), 6, 0);
    }

    // Test for valid multiplication input (Q3)
    @Test
    public void testQ3ValidInput() {
        Assert.assertEquals(MathQuestionService.q3Multiplication("6", "8"), 48, 0);
    }

    // Test for empty input for Q1 (Addition)
    @Test
    public void testAddNumber1Empty() {
        Assert.assertNull(MathQuestionService.q1Addition("", "2"));
    }

    // Test for empty input for Q1 (Addition)
    @Test
    public void testAddNumber2Empty() {
        Assert.assertNull(MathQuestionService.q1Addition("1", ""));
    }

    // Test for invalid input (non-numeric) for Q1 (Addition)
    @Test
    public void testAddInvalidNumber() {
        Assert.assertNull(MathQuestionService.q1Addition("one", "2"));
    }

    // Test for invalid input (non-numeric) for Q2 (Subtraction)
    @Test
    public void testSubInvalidNumber() {
        Assert.assertNull(MathQuestionService.q2Subtraction("5", "two"));
    }

    // Test for invalid input (non-numeric) for Q3 (Multiplication)
    @Test
    public void testMulInvalidNumber() {
        Assert.assertNull(MathQuestionService.q3Multiplication("five", "three"));
    }

    // Test for valid input for Q1 (Addition)
    @Test
    public void testAddValidInputAgain() {
        Assert.assertEquals(MathQuestionService.q1Addition("5", "7"), 12, 0);
    }

    // Test for valid input for Q2 (Subtraction)
    @Test
    public void testSubValidInputAgain() {
        Assert.assertEquals(MathQuestionService.q2Subtraction("10", "4"), 6, 0);
    }

    // Test for valid input for Q3 (Multiplication)
    @Test
    public void testMulValidInputAgain() {
        Assert.assertEquals(MathQuestionService.q3Multiplication("6", "8"), 48, 0);
    }
}
