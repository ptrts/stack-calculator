package com.suchorukov.tarouts.calc;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.testng.AssertJUnit.assertEquals;

public class CalcTest {
	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

	@Before
	public void setUpStreams() {
		System.setOut(new PrintStream(outContent));
	}

	@After
	public void cleanUpStreams() {
		System.setOut(null);
	}

	@Test
	public void testMain() throws Exception {

		String[] args = new String[1];

		String userDir = System.getProperty("user.dir");

		args[0] = userDir + "\\x1.txt";
		Calc.main(args);

		args[0] = userDir + "\\x2.txt";
		Calc.main(args);

		String out = outContent.toString();

		String[] outStrings = out.split("[\r\n]+");

		assertEquals("-1.0", outStrings[0]);
		assertEquals("-2.0", outStrings[1]);
	}
}
