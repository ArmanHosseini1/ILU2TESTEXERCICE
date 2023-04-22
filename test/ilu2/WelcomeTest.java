package ilu2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class WelcomeTest {


	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void testBob() {
		assertEquals("Hello, Bob", Welcome.welcome("bob"));
		assertEquals("Hello, Bob", Welcome.welcome("Bob"));
	}
	
	@Test
	void testNullEmpty() {
		assertEquals("Hello, my friend", Welcome.welcome(null));
		assertEquals("Hello, my friend", Welcome.welcome(""));
		assertEquals("Hello, my friend", Welcome.welcome("    "));
	}
	
	@Test
	void testCri() {
		assertEquals("HELLO, JERRY !", Welcome.welcome("JERRY"));
		assertEquals("Hello, JERRy", Welcome.welcome("JERRy"));
		assertEquals("Hello, JERRY", Welcome.welcome("jERRY"));
	}

	@Test
	void testDeuxNoms() {
		assertEquals("Hello, Amy, Leonard", Welcome.welcome("amy,leonard"));
		assertEquals("HELLO, AMY, LEONARD !", Welcome.welcome("AMY, LEONARD"));
		assertEquals("Hello, Amy, ", Welcome.welcome("amy, "));
	}
}
