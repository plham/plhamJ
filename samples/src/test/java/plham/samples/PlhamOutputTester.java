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

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.junit.After;
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
     * Default value for property {@value #DEFAULT_DIRECTORY_FOR_FAILED_EXECUTIONS}
     */
    public static final String DEFAULT_DIRECTORY_FOR_FAILED_EXECUTIONS = "target/plhamoutputtester";
    
    /**
     * Property used to override the default directory in which the executions run will be kept in case
     * they do not match the expected outputs.
     */
    public static final String DIRECTORY_PROPERTY = "plhamoutput.directory";
    
    /**
     * Property used to activate the creation of the "expected output" files in case they are not present 
     * on the system. By default is set to {@value false} which does not create the files.
     */
    public static final String PLHAMOUTPUTTEST_CREATE_OUTPUT = "plhamoutputtest.createOutput";
    
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
    
    /**
     * The arguments to pass to the main specified as parameter.
     */
    protected String[] args;
    
    /**
     * Path to the file containing the expected output
     */
    protected String expectedOutput;
    
    /**
     * File object containing the expected output 
     */
    private File expectedOutputFile;
    
    /**
     * The class which contains the main of the program to launch with this output checker
     */
    protected Class<?> main;

    /**
     * Collection containing the lines produced by the program being tested
     */
    List<String> obtainedLines;

    /**
     * Output stream to the temporary file containing the output of the program being tested. 
     */
    FileOutputStream output;
    
    /**
     * Name of the program being tested. Used as a prefix to 
     */
    String programName;
    /**
     * Temporary file used to collect the output from the tested program
     */
    private File temporaryOutput;

    /**
     * Boolean used in method {@link #after()} to know if the test succeeded. 
     * In case of success, the output produced by the testes program is discarded. In case of failure, it is kept for further analysis.
     * @see #after()
     */
    boolean testPassed;

    /**
     * Constructor for this class
     * @param name name of the program being tested. It is used as a prefix in case the test fails and the output of the program is saved on a local file
     * @param mainClass main class of the program whose output needs to be launched
     * @param expectedFileOutput path to the file containing the expected output of the program to launch
     * @param arguments the arguments of the main class supplied as first parameter of this constructor, as a number of successive {@link String}s
     */
    public PlhamOutputTester(String name, Class<?> mainClass, String expectedFileOutput, String ... arguments) {
        programName = name;
        main = mainClass;
        args = arguments;
        expectedOutput = expectedFileOutput;
    }
    @After
    public void after() throws IOException {
        if (!testPassed) {
            // The following three lines are necessary in case of timeout failure
            output.flush();
            output.close();
            obtainedLines = FileUtils.readLines(temporaryOutput);
            
            // Save the program output to a file
            saveFailedProgramOutput();
        }
    }

    @Before
    public void before() {
        expectedOutputFile = new File(expectedOutput);
        temporaryOutput = new File("tmp.txt");
        temporaryOutput.deleteOnExit();
        testPassed = false;
        obtainedLines = null;
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
    @Test(timeout=30000)
    public void checkProgramOutput() throws NoSuchMethodException, SecurityException, IllegalAccessException,
    IllegalArgumentException, IOException, Throwable {
        output = new FileOutputStream(temporaryOutput);
        Method m = main.getMethod("main", String[].class);
        PrintStream stdOut = System.out;
        System.setOut(new PrintStream(output));
        Object[] arguments = { args };
        try {
            m.invoke(null, arguments); // Call the main method   
        } catch (InvocationTargetException e) {
            // Print the exception here to leave a trace
            e.printStackTrace();
            // Transmit the "cause" to the JUnit framework: the cause is what caused the fault in the target program
            throw e.getCause(); 
        }
        System.setOut(stdOut);

        output.flush();
        output.close();

        compareOutputFile(expectedOutputFile, temporaryOutput);
    }

    /**
     * Helper method in charge of comparing the expected output with the output
     * received
     *
     * @param expectedOutputFile file containing the expected output
     * @param temporaryOutput    file containing the output produced by the program
     *                           under test
     * @throws IOException if thrown while attempting to read/parse files
     */
    private void compareOutputFile(File expectedOutputFile, File temporaryOutput) throws IOException {
        obtainedLines = FileUtils.readLines(temporaryOutput);
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
        
        // If we made it here, the test has succeeded
        testPassed = true;
    }

    private void saveFailedProgramOutput () throws IOException {
        // If a Junit failure occurs, save the "bad" results of the execution to a file for later examination
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd_HH:mm.ss");
        String timeStamp = dateFormat.format(new Date(System.currentTimeMillis()));
        String fileName = FilenameUtils.getName(programName + "_failed_" + timeStamp + ".txt");
        String directory = System.getProperty(DIRECTORY_PROPERTY, DEFAULT_DIRECTORY_FOR_FAILED_EXECUTIONS);
        File failedOutputFile = new File(directory, fileName);
        System.err.println("KEEPING THE OUTPUT OF THE FAILED PROGRAM IN FILE " + failedOutputFile);
        FileUtils.writeLines(failedOutputFile, obtainedLines);

    }
}
