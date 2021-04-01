package plham.core;

import java.io.Serializable;

/**
 * A class for shared clocks. For system use only.
 */

public class Time implements Serializable {
	private static final long serialVersionUID = -3740728528349778203L;

	public long t;

	public Time(long t) {
		this.t = t;
	}
}
