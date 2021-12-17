package plham.core.main.log;

import static plham.core.main.log.LogConstants.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.function.Consumer;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Options;

import handist.collections.dist.DistLog.LogItem;
import handist.collections.util.SavedLog;

/**
 * Class in charge of parsing logs and producing outputs about the runtime of
 * Runners
 *
 * @author Patrick Finnerty
 *
 */
public class Analyzer {

    private static final String EXTRA_VERBOSE = "e";
    private static final String ITERATION_TIMES = "t";
    private static final String OVERWRITE = "f";
    private static final String VERBOSE = "v";

    private static final Comparator<LogItem> timeStampSort = (a, b) -> {
        final long diff = Long.parseLong(a.appendix) - Long.parseLong(b.appendix);
        if (diff == 0l) {
            return 0;
        } else if (diff < 0l) {
            return -1;
        } else {
            return 1;
        }
    };

    private static Options commandOptions() {
        final Options opts = new Options();
        opts.addOption(ITERATION_TIMES, true,
                "Produce a CSV containing the times spent on the various steps of a simulation");
        opts.addOption(VERBOSE, false, "Verbose, dump the keys and number of entries for each key on std output");
        opts.addOption(EXTRA_VERBOSE, false,
                "Extra verbose, dumps the entire content of the log (each key and each entry for said key) on std output");
        opts.addOption(OVERWRITE, false,
                "Force Overwrite, in case a file specified as parameter as an output for one of the options this analyser provides, the contents of the existing file will be overwritten.");
        return opts;
    }

    /**
     * Return the elapsed time between two log items which feature a
     * {@link System#nanoTime()} timestamp as their appendix
     *
     * @param first  the log item recorded first
     * @param second the log item recoded later
     * @return the elapsed time (in nanoseconds) between the two arguments
     */
    private static long elapsed(LogItem first, LogItem second) {
        return Long.parseLong(second.appendix) - Long.parseLong(first.appendix);
    }

    /**
     * Main method.
     * <p>
     * Call without any arguments for help message
     * <p>
     * Specify the outputs to produce with their matching options and the log source
     * file last: Analyzer [option outputFile]* logFile
     *
     * @param args options specifying which outputs to produce and the log file from
     *             which the information is te be taken last
     */
    public static void main(String[] args) {
        final Options options = commandOptions();
        if (args.length <= 1) {
            new HelpFormatter().printHelp("(options)+ <log input file>", options);
            return;
        }

        SavedLog log = null;
        final String inputFileName = args[args.length - 1];
        final File f = new File(inputFileName);
        if (!f.exists()) {
            System.err.println("Could not read file " + inputFileName);
            System.err.println("Exiting with code -1");
            System.exit(-1);
        }

        try {
            log = new SavedLog(f);
        } catch (final Exception e) {
            System.err.println("A problem occurred while parsing input file " + inputFileName);
            e.printStackTrace();
            System.exit(-2);
        }

        // Create the "analyser"
        final Analyzer analyzer = new Analyzer(log);

        // Parse the options and produce the desired outputs
        final CommandLineParser parser = new DefaultParser();
        CommandLine cmd = null;
        final String[] optionArray = Arrays.copyOf(args, args.length - 1);
        try {
            cmd = parser.parse(options, optionArray);
        } catch (final Exception e) {
            System.err.println(e.getLocalizedMessage());
            new HelpFormatter().printHelp("(options)+ <log input file>", options);
            System.exit(-3);
        }

        if (cmd.hasOption(EXTRA_VERBOSE)) {
            log.printAll(System.out);
        } else if (cmd.hasOption(VERBOSE)) {
            // In simple verbose output, only show the keys and the number of entries for
            // each key
            log.printKeys(System.out);
        }
        final boolean overwriteFiles = cmd.hasOption(OVERWRITE);

        makeOutputToFile(cmd, ITERATION_TIMES, analyzer::iterationTimes, overwriteFiles);
    }

    /**
     * Generic method used to check whether an option was set. If so, the relevant
     * output is made
     *
     * @param option       the string option
     * @param outputMethod the method which produces the output based on the
     *                     contents of the log
     */
    private static void makeOutputToFile(CommandLine cmd, String option, Consumer<PrintStream> outputMethod,
            boolean overwriteFiles) {
        if (cmd.hasOption(option)) {
            final File output = new File(cmd.getOptionValue(option));
            if (output.exists() && !overwriteFiles) {
                System.err.println("File " + output.getAbsolutePath() + " already exists, skipping");
            } else {
                PrintStream ps;
                try {
                    ps = new PrintStream(output);
                    outputMethod.accept(ps);
                    ps.close();
                    System.out.println("Wrote file " + output.getAbsolutePath());
                } catch (final FileNotFoundException e) {
                    System.err.println("A problem occurred while writing to " + output.getAbsolutePath());
                    e.printStackTrace();
                } catch (final Exception e) {
                    System.err.println("Some problem occurred while producing '" + option + "' output");
                    e.printStackTrace();
                }

            }
        }
    }

    /** Saved log from which the outputs are made */
    private final SavedLog log;

    public Analyzer(SavedLog l) {
        log = l;
    }

    /**
     * Produces a table in CSV format with each line containing the iteration time
     * and details of a single iteration
     *
     * @param out the output stream into which the table should be printed
     * @throws RuntimeException if some inconsistencies are found while producing
     *                          the output
     */
    public void iterationTimes(PrintStream out) {
        final ArrayList<LogItem> startList = new ArrayList<>(log.getLog(0, LOG_ITERATION_START, 0));
        final ArrayList<LogItem> stopList = new ArrayList<>(log.getLog(0, LOG_ITERATION_STOP, 0));
        final ArrayList<LogItem> sOrdersStart = new ArrayList<>(log.getLog(0, LOG_SAGENTSUBMISSION_START, 0));
        final ArrayList<LogItem> sOrdersStop = new ArrayList<>(log.getLog(0, LOG_SAGENTSUBMISSION_STOP, 0));
        final ArrayList<LogItem> processStart = new ArrayList<>(log.getLog(0, LOG_PROCESSORDERS_START, 0));
        final ArrayList<LogItem> processStop = new ArrayList<>(log.getLog(0, LOG_PROCESSORDERS_STOP, 0));

        startList.sort(timeStampSort);
        stopList.sort(timeStampSort);
        sOrdersStart.sort(timeStampSort);
        sOrdersStop.sort(timeStampSort);
        processStart.sort(timeStampSort);
        processStop.sort(timeStampSort);

        out.println("Iteration; Total time; Order Production&transfer; Order Handling");
        // Iterate over all 6 lists to produce the output
        for (int it = 0; it < startList.size(); it++) {
            final LogItem start = startList.get(it);
            final LogItem stop = stopList.get(it);
            final long totalTime = elapsed(start, stop);
            final LogItem orderStart = sOrdersStart.get(it);
            final LogItem orderStop = sOrdersStop.get(it);
            final long orderProductionTransfer = elapsed(orderStart, orderStop);
            final LogItem handlingStart = processStart.get(it);
            final LogItem handlingStop = processStop.get(it);
            final long orderHandling = elapsed(handlingStart, handlingStop);

            // Small sanity check
            if (start.msg.equals(stop.msg) && orderStart.msg.equals(stop.msg) && orderStop.msg.equals(stop.msg)
                    && handlingStart.msg.equals(stop.msg) && handlingStop.msg.equals(stop.msg)) {
                out.println(String.format("%s;%s;%s;%s", it, totalTime / 1e9, orderProductionTransfer / 1e9,
                        orderHandling / 1e9));
            } else {
                System.err.println("### Producing iteration times: The messages of the various log keys did not match");
                System.err.println(start.msg + " " + stop.msg + " " + orderStart.msg + " " + orderStop.msg + " "
                        + handlingStart.msg + " " + handlingStop.msg);
                throw new RuntimeException("Inconcistency in message of iteration number " + it);
            }
        }
    }
}
