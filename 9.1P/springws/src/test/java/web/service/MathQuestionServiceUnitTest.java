package web.service;

import org.junit.Assert;
import org.junit.Test;

import web.service.MathQuestionService;

public class MathQuestionServiceUnitTest {

//	@Test
//	public void testTrueAdd() {
//		Assert.assertEquals(MathQuestionService.q1Addition("1", "2"), 3, 0);
//	}
//
//	@Test
//	public void testAddNumber1Empty() {
//		Assert.assertNull(MathQuestionService.q1Addition("", "2"));
//	}	
	
	
	@Test
    public void testValidInputsValidResultForQ1() {
        Assert.assertEquals(MathQuestionService.q1Addition("1", "2"), 3, 0);
    }

    @Test
    public void testInValidNumber12ForQ1() {
    	Assert.assertEquals(MathQuestionService.q1Addition("Invalid", "Invalid"), Double.NaN, 0);
    }

    @Test
    public void testValidNumber1InValidNumber2ForQ1() {
    	Assert.assertEquals("Stay on q1 page", MathQuestionService.q1Addition("1", "Invalid"), Double.NaN, 0);
    }

    @Test
    public void testInValidNumber1ValidNumber2ForQ1() {
    	Assert.assertEquals("Stay on q1 page", MathQuestionService.q1Addition("Invalid", "2"), Double.NaN, 0);
    }
    
    
	@Test
    public void testValidInputsValidResultForQ2() {
        Assert.assertEquals(MathQuestionService.q2Subtraction("6", "2"), 4, 0);
    }

    @Test
    public void testInValidNumber12ForQ2() {
    	Assert.assertEquals(MathQuestionService.q2Subtraction("Invalid", "Invalid"), Double.NaN, 0);
    }

    @Test
    public void testValidNumber1InValidNumber2ForQ2() {
    	Assert.assertEquals("Stay on q1 page", MathQuestionService.q2Subtraction("1", "Invalid"), Double.NaN, 0);
    }

    @Test
    public void testInValidNumber1ValidNumber2ForQ2() {
    	Assert.assertEquals("Stay on q1 page", MathQuestionService.q2Subtraction("Invalid", "2"), Double.NaN, 0);
    }
    
	@Test
    public void testValidInputsValidResultForQ3() {
        Assert.assertEquals(MathQuestionService.qa3multipy("9", "2"), 18, 0);
    }

    @Test
    public void testInValidNumber12ForQ3() {
    	Assert.assertEquals(MathQuestionService.qa3multipy("Invalid", "Invalid"), Double.NaN, 0);
    }

    @Test
    public void testValidNumber1InValidNumber2ForQ3() {
    	Assert.assertEquals(MathQuestionService.qa3multipy("1", "Invalid"), Double.NaN, 0);
    }

    @Test
    public void testInValidNumber1ValidNumber2ForQ3() {
    	Assert.assertEquals(MathQuestionService.qa3multipy("Invalid", "2"), Double.NaN, 0);
    }
    
    @Test
    public void testnumberValidationForDouble() {
    	Assert.assertTrue(MathQuestionService.numberValidation("12.3"));
    }
    @Test
    public void testnumberValidationForNotDouble() {
    	Assert.assertFalse(MathQuestionService.numberValidation("not a number"));
    }

}
