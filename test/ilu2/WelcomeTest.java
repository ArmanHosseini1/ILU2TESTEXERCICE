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

}
