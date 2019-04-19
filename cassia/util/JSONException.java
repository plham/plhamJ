package cassia.util;

import cassia.util.JSON.Reader;

public class JSONException extends RuntimeException {
	private static final long serialVersionUID = 3554766711240985706L;

	/* from JSON.x10
	static class JSONException extends Exception {

		public def this(s:String) {
			super(s);
		}
		
		public def this(p:Reader) {
			super(p.toString(p.i));
		}
	}
	 */
	public JSONException(String s) {
		super(s);
	}

	public JSONException(Reader p) {
		super(p.toString(p.i));
	}
}
