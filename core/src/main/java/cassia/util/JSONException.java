package cassia.util;

import cassia.util.JSON.Reader;

public class JSONException extends RuntimeException {
	private static final long serialVersionUID = 3554766711240985706L;

	public JSONException(Reader p) {
		super(p.toString(p.i));
	}

	public JSONException(String s) {
		super(s);
	}
}
