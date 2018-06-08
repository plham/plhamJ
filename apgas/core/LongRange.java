package apgas.core;

public class LongRange {
    public final long from;
    public final long to;

    /**
     * constructor
     * @param from from (min) inclusive
     * @param to to (max) exclusive
     */
    public LongRange(long from, long to) {
        this.from = from;
        this.to = to;
    }
}
