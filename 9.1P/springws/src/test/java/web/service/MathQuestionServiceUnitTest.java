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
    public void testLoginSuccessforValidUsernameandValidPassword() {
        Assert.assertEquals(MathQuestionService.q1Addition("1", "2"), 3, 0);
    }

    @Test
    public void testInValidNumber12andInValidResultForQ1() {
    	Assert.assertEquals(MathQuestionService.q1Addition("Invalid", "Invalid"), 3, 0);
    }

    @Test
    public void tesValidNumbersandIncorrectResultForQ1() {
    	Assert.assertNull("Stay on q1 page", MathQuestionService.q1Addition("1", "2"));
    }

    @Test
    public void testInValidResultForQ1() {
    	Assert.assertNull("Stay on q1 page", MathQuestionService.q1Addition("1", "Invalid"));
    }

    @Test
    public void testInValidNumber1ForQ1() {
    	Assert.assertNull("Stay on q1 page", MathQuestionService.q1Addition("Invalid", "2"));
    }

    @Test
    public void testInValidNumber1andInvalidResulttForQ1() {
    	Assert.assertNull("Stay on q1 page", MathQuestionService.q1Addition("Invalid", "Invalid"));
    }

    @Test
    public void testInValidNumber2ForQ1() {
    	Assert.assertNull("Stay on q1 page", MathQuestionService.q1Addition("1", "Invalid"));
    }

    @Test
    public void testInValidNumber2andInvalidResulttForQ1() {
    	Assert.assertNull("Stay on q1 page", MathQuestionService.q1Addition("2", "Invalid"));
    }

    @Test
    public void testInValidNumber12tForQ1() {
    	Assert.assertNull("Stay on q1 page", MathQuestionService.q1Addition("Invalid", "Invalid"));
    }
}
