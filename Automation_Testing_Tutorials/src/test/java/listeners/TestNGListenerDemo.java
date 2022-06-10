package listeners;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

//to implement multiple listeners, use diff method, refer to documentation
//@Listeners(listeners.TestNGListeners.class)
public class TestNGListenerDemo{

	@Test
	public void test1() {
		System.out.println("I am inside Test 1");
	}

	@Test
	public void test2() {
		System.out.println("I am inside Test 2");
		Assert.assertTrue(false);
	}

	@Test
	public void test3() {
		System.out.println("I am inside Test 3");
	}

}
