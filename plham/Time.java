package plham;

import java.io.Serializable;

/**
 * A class for shared clocks. For system use only.
 */

public class Time implements Serializable {
	private static final long serialVersionUID = -3740728528349778203L;

	/*
	public var t:Long;

	public def this(t:Long) {
		this.t = t;
	}
	 */
	public long t;

	public Time(long t) {
		this.t = t;
	}
}
