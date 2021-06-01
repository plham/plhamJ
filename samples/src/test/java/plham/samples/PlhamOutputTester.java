/**
 *
 */
package plham.samples;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.junit.Before;
import org.junit.Test;

/**
 * Generic test class which will run a particular program and compare the output
 * of that program with the expected output specified as a file
 *
 * @author Patrick Finnerty
 *
 */
public abstract class PlhamOutputTester {

	/**
	 * Helper method in charge of comparing the excpected output with the output
	 * received
	 *
	 * @param expectedOutputFile file containing the expected output
	 * @param temporaryOutput    file containing the output produced by the program
	 *                           under test
	 * @throws IOException if thrown while attempting to read/parse files
	 */
	private static void compareOutputFile(File expectedOutputFile, File temporaryOutput) throws IOException {
		// Compare the ouptuts line by line
		List<String> expectedLines = FileUtils.readLines(expectedOutputFile);
		List<String> obtainedLines = FileUtils.readLines(temporaryOutput);

		removeComments(obtainedLines);
		removeComments(expectedLines);

//		for (String line : obtainedLines) {
//		    System.out.println(line);
//		}
		
		boolean sameNumberOfLines = expectedLines.size() == obtainedLines.size();
		Iterator<String> expectedIt = expectedLines.iterator();
		Iterator<String> obtainedIt = obtainedLines.iterator();
		int lineNumber = -1;
		while (expectedIt.hasNext() && obtainedIt.hasNext()) {
			lineNumber++;
			String expected = expectedIt.next();
			String result = obtainedIt.next();
			assertTrue("First differrence at line " + lineNumber + ", expected [" + expected + "] was [" + result + "]",
					expected.equals(result));
		}

		if (!sameNumberOfLines) {
			fail("Obtained file had " + obtainedLines.size() + " lines when we were expecting " + expectedLines.size()
					+ " lines.");
		}
	}

	/**
	 * Removes all the strings in the list that start with character '#'
	 *
	 * @param lines the collection from which undesired lines are to be removed
	 */
	private static void removeComments(List<String> lines) {
		int index = 0;
		while (index < lines.size()) {
			if (lines.get(index).startsWith("#")) {
				lines.remove(index);
			} else {
				index++;
			}
		}
	}

	protected String[] args;

	protected String expectedOutput;
	private File expectedOutputFile;

	protected Class<?> main;

	private File temporaryOutput;

	/**
	 * Constructor for this class
	 *
	 * @param mainClass          the class which contains the main of the program to
	 *                           run
	 * @param config             the path to the JSON configuration file for the
	 *                           simulation to perform
	 * @param seed               the seed (as a String) used to initialize the
	 *                           random generators used in the simulation
	 * @param expectedFileOutput the path to the file which contains the expected
	 *                           output for the specified program
	 */
	public PlhamOutputTester(Class<?> mainClass, String config, String seed, String expectedFileOutput) {
		main = mainClass;
		args = new String[2];
		args[0] = config;
		args[1] = seed;
		expectedOutput = expectedFileOutput;
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		expectedOutputFile = new File(expectedOutput);
		temporaryOutput = new File("tmp.txt");
		temporaryOutput.deleteOnExit();
	}

	/**
	 * Main test method.
	 *
	 * Runs the program that was specified as parameter in the constructor and
	 * compares the output with the expected output.
	 *
	 * @throws NoSuchMethodException     if the specified class does not contain a
	 *                                   main method
	 * @throws SecurityException         if the security provider prevents the use
	 *                                   of reflection
	 * @throws IllegalAccessException    if the security provider prevents the use
	 *                                   of reflection
	 * @throws IllegalArgumentException  should not occur, indicates an issue in
	 *                                   this method's implementation
	 * @throws InvocationTargetException should not occur, indivates an issue in
	 *                                   this method's implementation
	 * @throws IOException               if it occurs when parsing the results of
	 *                                   the execution and comparing it with the
	 *                                   file in which the expected output resides.
	 */
	@Test
	public void defaultTest() throws NoSuchMethodException, SecurityException, IllegalAccessException,
			IllegalArgumentException, InvocationTargetException, IOException {
		FileOutputStream output = new FileOutputStream(temporaryOutput);
		Method m = main.getMethod("main", String[].class);
		PrintStream stdOut = System.out;
		System.setOut(new PrintStream(output));
		Object[] arguments = { args };
		m.invoke(null, arguments); // Call the main method
		System.setOut(stdOut);

		output.flush();
		output.close();

		compareOutputFile(expectedOutputFile, temporaryOutput);
	}
}
