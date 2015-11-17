/**
 * 
 */
package test;



import org.junit.Test;

import io.Parameters;
import schedule.Schedule;

/**
 * @author skrause
 *
 */
public class ScheduleTest {

	/**
	 * Test method for {@link schedule.Schedule#Schedule()}.
	 */
	@Test
	public void testSchedule() {
		Parameters p = new Parameters("parameters.json");		
		Schedule sched = new Schedule(p);
		System.out.println(sched.calculateSolution(3).toString());
	}

}
