package plham;

import java.util.List;

/**
 * For system use only.
 */
public class Env {
	/*
	public static DEBUG = 0;

	public static def getenvOrElse(name:String, orElse:String):String {
		val value = System.getenv(name);
		if (value == null) {
			return orElse;
		}
		return value;
	}

	public var agents:List[Agent];
	public var numAgents:Long;
	public var markets:List[Market];

	public var normalAgents:List[Agent];
	public var hifreqAgents:List[Agent];
	
	public def this() {
		this.agents = new ArrayList[Agent]();
	}
	 */
	public static final long DEBUG = 0L;

	public Env() {
		// do nothing
	}

	public static String getEnvOrElse(final String name, final String orElse) {
		final String value = x10.lang.System.getenv(name);
		if (value == null) {
			return orElse;
		}
		return value;
	}

	public List<Agent> agents;
	public long numAgents;
	public List<Market> markets;
	public List<Agent> normalAgents;
	public List<Agent> hifreqAgents;

	public static long isDebug() {
		return Env.DEBUG;
	}

	// TODO
	protected String here = "PLACE";
}
