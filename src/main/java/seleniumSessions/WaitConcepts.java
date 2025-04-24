package seleniumSessions;

public class WaitConcepts {

	public static void main(String[] args) {
		
		// Wait concepts in Selenium WebDriver
		// Selenium Script  ---> Browser  ---> Applications
		// Sync -- b/w  --- script and the application
		
		
		// Waits
		// 1. Static wait (Selenium xx ... Java) --> Thread.sleep();  ---> pause the script/thread/case for the given time (seconds, minutes ..)
			// not recommended --  Degrade the test execution performance
//		Thread.sleep(10000);
		// 2 seconds  -- all the elements are visible
		// 8 seconds   -- not ignoring the ramaining seconds
		
		
		// 2. Dynamic wait
			// DW in Sel are methods  -- control executions  -- between statements  -- based on some conditions
			// wait(10 seconds)  --- 3 seconds  --- 7 seconds = will be cancelled/ignored
				// 2.a: Implicitly wait
				// 2.b: Explicitly wait
						// 2.b.1: WebDriverWait
						// 2.b.2: Fluent wait
		
//		Wait Hierarchy
//		wait(I) until();  <--- FluentWait (class) until(){}; + other methods  <--- WebDriverWait (class)
		
		
	}

}
