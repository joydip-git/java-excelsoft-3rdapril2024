package tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import main.Person;

public class PersonTest {

	@Test
	public void testPeopleAreEqual() {
		Person anilPerson = new Person("anil");
		Person sunilPerson = new Person("anil");
		assertEquals(anilPerson, sunilPerson);
		//anilPerson.equals(sunilPerson)
	}
}
