package JunitTest;


import org.junit.runners.Suite;
import org.junit.runner.RunWith;
import org.junit.runners.Suite.SuiteClasses;

/**
 * Execute all test cases
 * @author Amber Jong
 */
@RunWith(Suite.class)
@SuiteClasses({ AnimalTest.class, DigitTest.class, LogTest.class, ObstacleTest.class,TurtleTest.class, WetTurtleTest.class })

public class AllTestCases {
}
