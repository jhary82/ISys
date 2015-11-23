package test;

import org.junit.Test;

import io.Parameters;

import schedule.Schedule;

/**
 * Eine Test-Klasse für die Gruppeneinteilung
 * @author Erik und Simon
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
