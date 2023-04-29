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
		assertEquals("Hello, Amy and Leonard", Welcome.welcome("amy,leonard"));
		assertEquals("HELLO, AMY AND LEONARD !", Welcome.welcome("AMY, LEONARD"));
	}
	
	@Test
	void testPlusieursNoms() {
		assertEquals("Hello, Amy, Bob and Jerry", Welcome.welcome("Amy,bob, jerry"));
		assertEquals("HELLO, AMY, BOB AND JERRY !", Welcome.welcome("AMY, BOB,JERRY"));
	}
	
	@Test
	void testPlusieursNomsCris() {
		assertEquals("Hello, Amy and Jerry. AND HELLO, BOB !", Welcome.welcome("amy, BOB, Jerry"));
		assertEquals("Hello, Amy. AND HELLO, BOB !", Welcome.welcome("BOB,amy"));
		assertEquals("Hello, Amy. AND HELLO, BOB AND JERRY !", Welcome.welcome("BOB, amy, JERRY"));
	}
	
	@Test
	void testAndPourLeDernierNom() {
		assertEquals("Hello, Bob, Amy and Jerry", Welcome.welcome("bob, Amy, jerry"));
		assertEquals("Hello, Bob. AND HELLO, AMY AND JERRY !", Welcome.welcome("bob, AMY, JERRY"));
		assertEquals("Hello, Bob and Amy. AND HELLO, JERRY !", Welcome.welcome("bob, Amy, JERRY"));
		assertEquals("Hello, Bob and Amy. AND HELLO, JERRY AND JACK !", Welcome.welcome("bob, JERRY, JACK, amy"));
	}
	
	@Test
	void testEspacesInutiles() {
		assertEquals("Hello, Bob and Amy", Welcome.welcome("bob    ,   amy "));
		assertEquals("HELLO, BOB AND AMY !", Welcome.welcome("BOB    ,   AMY"));
		assertEquals("Hello, Bob", Welcome.welcome("   bob  "));
		assertEquals("HELLO, AMY !", Welcome.welcome("  AMY  "));
	}
	
	@Test
	void testNumération() {
		assertEquals("Hello, Bob (*3) and Amy. AND HELLO, JERRY (*2) !", Welcome.welcome("bob, JERRY, amy, bob, JERRY, bob"));
		assertEquals("Hello, Bob (*3), AMy and Amy", Welcome.welcome("bob, bob, Bob, aMy, Amy"));
		assertEquals("HELLO, AMY (*2) AND JERRY !", Welcome.welcome("AMY, JERRY, AMY"));
	}
}
