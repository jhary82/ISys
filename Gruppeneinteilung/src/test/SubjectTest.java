package test;

import static org.junit.Assert.*;

import org.junit.Test;

import schedule.Subject;

/**
 * Eine Test-Klasse für die Faecher
 * @author Erik und Simon
 *
 */
public class SubjectTest {

	/**
	 * Test method for {@link schedule.Subject#setCountStudents(int)}.
	 */
	@Test
	public void testSetCountStudents() {
		Subject sub = new Subject("A", 0);
		assertEquals( 9 , sub.setCountStudents(100));
		assertEquals( 1, sub.setCountStudents(12));
		assertEquals( 1, sub.setCountStudents(10));
		assertEquals( 2, sub.setCountStudents(13));
	}

}
