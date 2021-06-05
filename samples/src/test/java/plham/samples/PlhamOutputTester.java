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
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

/**
 * Generic test class which will run a particular program and compare the output
 * of that program with the expected output specified as a file
 *
 * @author Patrick Finnerty
 *
 */
public abstract class PlhamOutputTester {

    public static final String PLHAMOUTPUTTEST_CREATE_OUTPUT = "plhamoutputtest.createOutput";

    @Rule
    public Timeout saveProgramOutputInCaseOfTimeout = Timeout.builder().withLookingForStuckThread(true).withTimeout(30l, TimeUnit.SECONDS).build();
//    
//    public FailOnTimeout custom = new FailOnTimeout(null, custom) {
//        @Override
//        public void evaluate() {
//            try {super.evaluate(); } catch (TestTimedOutException to) {
//                System.err.println("HEY THERE WAS A TIMEOUT ACTIONS NEED TO BE TAKEN HERE");
//            }
//        }
//    };
    
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
        List<String> filteredLines = removeComments(obtainedLines);

        List<String> expectedLines = null;
        try {
            expectedLines = FileUtils.readLines(expectedOutputFile);
        } catch (FileNotFoundException e) {
            // If the "createOutput" option is activated, write the "expected output file"
            if (Boolean.parseBoolean(System.getProperty(PLHAMOUTPUTTEST_CREATE_OUTPUT, "false"))) {
                FileUtils.writeLines(expectedOutputFile, filteredLines);
                fail("\"Expected Output\" file created, run this test again to make sure the program output is the same");
            } else {
                fail("Problem when trying to read contents from file " + expectedOutputFile); 
            }
        }
        expectedLines = removeComments(expectedLines);

        //		for (String line : obtainedLines) {
        //		    System.out.println(line);
        //		}

        try {


            boolean sameNumberOfLines = expectedLines.size() == filteredLines.size();
            Iterator<String> expectedIt = expectedLines.iterator();
            Iterator<String> obtainedIt = filteredLines.iterator();
            int lineNumber = -1;
            while (expectedIt.hasNext() && obtainedIt.hasNext()) {
                lineNumber++;
                String expected = expectedIt.next();
                String result = obtainedIt.next();
                assertTrue("First differrence at line " + lineNumber + ", expected [" + expected + "] was [" + result + "]",
                        expected.equals(result));
            }

            if (!sameNumberOfLines) {
                fail("Obtained file had " + filteredLines.size() + " lines when we were expecting " + expectedLines.size()
                + " lines.");
            }
        } catch (Throwable t) {
            // If a Junit failure occurs, save the "bad" results of the execution to a file for later examination
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd_HH:mm.ss");
            String timeStamp = dateFormat.format(new Date(System.currentTimeMillis()));
            String fileName = FilenameUtils.getBaseName(expectedOutputFile.getName()) + "_failed_" + timeStamp + ".txt";
            File failedOutputFile = new File(expectedOutputFile.getParent(), fileName);
            System.err.println("KEEPING THE OUTPUT OF THE FAILED PROGRAM IN FILE " + failedOutputFile);
            FileUtils.writeLines(failedOutputFile, obtainedLines);

            throw t;
        }
    }

    /**
     * Removes all the strings in the list that start with character '#'
     *
     * @param lines the collection from which undesired lines are to be removed
     * @return a newly created list 
     */
    private static List<String> removeComments(List<String> lines) {
        ArrayList<String> toReturn = new ArrayList<>(lines.size());
        for (String line : lines) {
            if (!line.startsWith("#")) {
                toReturn.add(line);
            } 
        }

        return toReturn;
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
    @Test
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
