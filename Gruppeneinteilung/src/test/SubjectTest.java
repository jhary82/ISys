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
		assertEquals( 9 , sub.setCountStudents(100));
		assertEquals( 1, sub.setCountStudents(12));
		assertEquals( 1, sub.setCountStudents(10));
		assertEquals( 2, sub.setCountStudents(13));
	}

}
