/**
 * 
 */
package test;

import static org.junit.Assert.*;

import org.junit.Test;

import io.Parameters;
import schedule.Subject;

/**
 * @author skrause
 *
 */
public class SubjectTest {

	/**
	 * Test method for {@link schedule.Subject#setCountStudents(int)}.
	 */
	@Test
	public void testSetCountStudents() {
		Subject sub = new Subject(new Parameters());
		assertEquals( sub.setCountStudents(100), 7);
	}

}
