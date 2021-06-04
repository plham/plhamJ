/**
 *
 */
package plham.samples;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.File;
import java.io.FileNotFoundException;
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

	public static final String PLHAMOUTPUTTEST_CREATE_OUTPUT = "plhamoutputtest.createOutput";

    /**
	 * Helper method in charge of comparing the expected output with the output
	 * received
	 *
	 * @param expectedOutputFile file containing the expected output
	 * @param temporaryOutput    file containing the output produced by the program
	 *                           under test
	 * @throws IOException if thrown while attempting to read/parse files
	 */
	private static void compareOutputFile(File expectedOutputFile, File temporaryOutput) throws IOException {
		List<String> obtainedLines = FileUtils.readLines(temporaryOutput);
		removeComments(obtainedLines);
		
		List<String> expectedLines = null;
        try {
            expectedLines = FileUtils.readLines(expectedOutputFile);
        } catch (FileNotFoundException e) {
            // If the "createOutput" option is activated, write the "expected output file"
            if (Boolean.parseBoolean(System.getProperty(PLHAMOUTPUTTEST_CREATE_OUTPUT, "false"))) {
                FileUtils.writeLines(expectedOutputFile, obtainedLines);
                fail("\"Expected Output\" file created, run this test again to make sure the program output is the same");
            } else {
                fail("Problem when trying to read contents from file " + expectedOutputFile); 
            }
        }
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
	 * @param mainClass main class of the program whose output needs to be launched
	 * @param expectedFileOutput path to the file containing the expected output of the program to launch
	 * @param arguments the arguments of the main class supplied as first parameter of this constructor, as a number of successive {@link String}s
	 */
	public PlhamOutputTester(Class<?> mainClass, String expectedFileOutput, String ... arguments) {
		main = mainClass;
		args = arguments;
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
	@Test(timeout=60000)
	public void checkProgramOutput() throws NoSuchMethodException, SecurityException, IllegalAccessException,
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
