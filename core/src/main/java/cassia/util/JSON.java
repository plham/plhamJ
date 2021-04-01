package cassia.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * A JSON parser ported from X10.
 *
 * <p>
 * Restrictions:
 * <ul>
 * <li>No type recognition for literals (stored as string)
 * <li>No escape sequence handling
 * </ul>
 *
 * <p>
 * Use {@link #parse(File)} to obtain a JSON object from a string, or
 * {@link #parse(File)} to obtain a JSON object from a file.
 *
 * <p>
 * See {@link JSON.Value} to know how to access to the JSON data.
 *
 * <p>
 * Syntax:
 * <p>
 *
 * <pre>
 *     json := object
 *     name := ( string | literal )
 *     value := ( object | array | string | literal )
 *     object := "{" [ name ":" value [ "," name ":" value ]&ast; ] "}"
 *     array := "[" [ value [ "," value ]&ast; ] "]"
 *     string := QUOTE [ CHARACTER ]&ast; QUOTE
 *     literal := ( LETTERS | DIGITS | "_" | "." | "+" | "-" )+
 * </pre>
 */
public class JSON implements Serializable {
	/**
	 * A mapping inside a JSON file from a {@link String} to a {@link Value}
	 */
	public static final class Entry {
		String key;
		Value value;

		public Entry(String key, Value value) {
			this.key = key;
			this.value = value;
		}

		public String getKey() {
			return key;
		}

		public Value getValue() {
			return value;
		}
	}

	static class Reader {
		public int i;
		public String text;

		public Reader(String text) {
			this.text = text;
			i = 0;
		}

		public Character get() {
			return text.charAt(i);
		}

		public void next() {
			i++;
		}

		public String toString(int i) {
			return text.substring(Math.max(0, i - 20), Math.min(i + 20, text.length()));
		}
	}

	public static class Value {
		int i;
		Reader p;
		Object value; // String, List, or Map (never Boolean, Long, Double, etc)

		public Value(Object value) {
			this(value, null, 0);
		}

		public Value(Object value, Reader p, int i) {
			this.value = value;
			this.p = p;
			this.i = i;
		}

		public Value any(List<Value> s) {
			for (int i = 0; i < s.size(); i++) {
				if (has(s.get(i))) {
					return this.get(s.get(i));
				}
			}
			throw new JSONException("No key: " + s);
		}

		public Value apply(List<Entry> entries) {
			Value obj = clone();
			for (Entry entry : entries) {
				String key = entry.getKey();
				Value value = entry.getValue();
				obj.put(key, value.clone());
			}
			return obj;
		}

		public Value apply(String key, Double value) {
			return apply(key, JSON.parse(value.toString()));
		}

		public Value apply(String key, Long value) {
			return apply(key, JSON.parse(value.toString()));
		}

		public Value apply(String key, String value) {
			return apply(key, JSON.parse("\"" + value + "\""));
		}

		public Value apply(String key, Value value) {
			assert isMap() : JSON.dump(this) + " is not a json object.";
			Value obj = clone();
			obj.put(key, value.clone());
			return obj;
		}

		public Value apply(Value rhs) {
			assert isMap() : (toString()) + " is not a json object.";
			Value obj = clone();
			for (Map.Entry<String, Value> entry : rhs.asMap().entrySet()) {
				String key = entry.getKey();
				Value value = entry.getValue();
				obj.put(key, value.clone());
			}
			return obj;
		}

		@SuppressWarnings({ "unchecked", "rawtypes" })
		public List<Value> asList() {
			return (List) value;
		}

		@SuppressWarnings("unchecked")
		public Map<String, Value> asMap() {
			return (Map<String, Value>) value;
		}

		@Override
		public Value clone() {
			Object value = this.value;
			if (isList()) {
				List<Value> a = asList();
				List<Value> h = new ArrayList<>();
				for (Object item : a) {
					Value v = (Value) item;
					h.add(v.clone());
				}
				value = h;
			}
			if (isMap()) {
				Map<String, Value> a = asMap();
				Map<String, Value> h = new LinkedHashMap<>();
				for (Map.Entry<String, Value> entry : a.entrySet()) {
					h.put(entry.getKey(), entry.getValue().clone());
				}
				value = h;
			}
			return new Value(value, p, i);
		}

		@Override
		public boolean equals(Object that) {
			return toString().equals(that.toString());
		}

		public Value get(List<Value> s) {
			Value v = this;
			for (int i = 0; i < s.size(); i++) {
				if (v.has(s.get(i))) {
					v = v.get(s.get(i));
				} else {
					throw new JSONException("No key: " + s);
				}
			}
			return v;
		}

		public Value get(Object s) {
			if (!has(s)) {
				throw new JSONException("No key: " + s);
			}
			if (isList()) {
				int i = Integer.valueOf(s.toString());
				return asList().get(i);
			}
			if (isMap()) {
				return asMap().get(s.toString());
			}
			throw new JSONException("No key: " + s);
		}

		protected String getExInfo() {
			if (p == null) {
				return value.toString();
			}
			return p.toString(i);
		}

		public Value getOrElse(Object s, String orElse) {
			if (has(s)) {
				return this.get(s);
			}
			return parse(orElse);
		}

		public boolean has(Object s) {
			if (isList()) {
				long i = Long.valueOf(s.toString());
				return 0 <= i && i < asList().size();
			}
			if (isMap()) {
				return asMap().containsKey(s.toString());
			}
			return false;
		}

		@Override
		public int hashCode() {
			return value.hashCode();
		}

		public boolean isList() {
			return value instanceof List;
		}

		public boolean isMap() {
			return value instanceof Map;
		}

		public boolean isNull() {
			return value == null;
		}

		public void put(String s, Object v) {
			this.put(s, new Value(v.toString()));
		}

		public void put(String s, Value v) {
			if (isList()) {
				int i = Integer.valueOf(s);
				asList().set(i, v);
				return;
			}
			if (isMap()) {
				asMap().put(s, v);
				return;
			}
			throw new JSONException("Cannot assign to " + s + ": " + v);

		}

		public void set(Object v) {
			value = v;
		}

		public int size() {
			if (isList()) {
				return asList().size();
			}
			if (isMap()) {
				return asMap().size();
			}
			return 0;
		}

		public boolean toBoolean() {
			try {
				return Boolean.valueOf(value.toString());
			} catch (Exception e) {
				throw new JSONException("Cannot cast to Boolean: " + getExInfo());
			}
		}

		public double toDouble() {
			try {
				return Double.valueOf(value.toString());
			} catch (Exception e) {
				throw new JSONException("Cannot cast to double: " + getExInfo());
			}
		}

		public int toInt() {
			try {
				return Integer.valueOf(value.toString());
			} catch (Exception e) {
				throw new JSONException("Cannot cast to int: " + getExInfo());
			}
		}

		public long toLong() {
			try {
				return Long.valueOf(value.toString());
			} catch (Exception e) {
				throw new JSONException("Cannot cast to long: " + getExInfo());
			}
		}

		@Override
		public String toString() {
			try {
				return value.toString();
			} catch (Exception e) {
				throw new JSONException("Cannot cast to String: " + getExInfo());
			}
		}
	}

	private static final long serialVersionUID = -1962266233974277670L;

	private static void _extendChain(Value root, Value focus, Map<String, Value> out) {
		if (!focus.isMap()) {
			return;
		}
		if (focus.has("extends")) {
			Value child = focus.get("extends");
			_extendChain(root, root.get(child), out);
		}
		Map<String, Value> dict = focus.asMap();
		for (Map.Entry<String, Value> e : dict.entrySet()) {
			out.put(e.getKey(), e.getValue());
		}
	}

	public static String dump(Value root) {
		StringBuilder s = new StringBuilder();
		if (root.isMap()) {
			s.append("{");
			Map<String, Value> d = root.asMap();
			int n = d.size();
			int i = 0;
			for (Map.Entry<String, Value> e : d.entrySet()) {
				String key = e.getKey();
				Value value = e.getValue();
				s.append("\"");
				s.append(key.toString());
				s.append("\"");
				s.append(":");
				s.append(dump(value));
				if (++i < n) {
					s.append(",");
				}
			}
			s.append("}");
		} else if (root.isList()) {
			s.append("[");
			List<Value> a = root.asList();
			int n = a.size();
			long i = 0;
			for (Object elem : a) {
				s.append(dump((Value) elem));
				if (++i < n) {
					s.append(",");
				}
			}
			s.append("]");
		} else {
			s.append("\"");
			s.append(root.value.toString());
			s.append("\"");
		}
		return s.toString();
	}

	public static Value extend(Value root) {
		if (!root.isMap()) {
			return root;
		}
		for (Map.Entry<String, Value> e : root.asMap().entrySet()) {
			String key = e.getKey();
			if (!root.get(key).isMap()) {
				continue;
			}
			if (root.get(key).has("extends")) {
				Map<String, Value> out = new LinkedHashMap<>();
				_extendChain(root, root.get(key), out);
				root.get(key).value = out;
			}
		}
		return root;
	}

	@SuppressWarnings("unused")
	public static Value extendDeeply(Value root, Value focus) {
		if (!focus.isMap()) {
			return focus;
		}
		for (Map.Entry<String, Value> e : focus.asMap().entrySet()) {
			String key = e.getKey();
			Value nextFocus = e.getValue();
			if (!nextFocus.isMap()) {
				continue;
			}
			if (nextFocus.has("extends")) {
				Map<String, Value> out = new LinkedHashMap<>();
				_extendChain(root, nextFocus, out);
				nextFocus.value = out;
			}
			extendDeeply(root, nextFocus);
		}
		return focus;
	}

	public static boolean isJSONLetter(Reader p) {
		Character c = p.get();
		return (Character.isAlphabetic(c) || Character.isDigit(c) || c == '_' || c == '.' || c == '+' || c == '-');
	}

	public static boolean isJSONQuote(Reader p) {
		Character c = p.get();
		return (c == '"' || c == '\'');
	}

	public static Value parse(File file) {
		StringBuilder s = new StringBuilder();
		FileReader fr = null;
		BufferedReader br = null;
		try {
			fr = new FileReader(file);
			br = new BufferedReader(fr);

			String line;
			while ((line = br.readLine()) != null) {
				s.append(line);
				s.append(" ");
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			try {
				br.close();
				fr.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		Value v = parse(s.toString());
		return extendDeeply(v, v);
	}

	public static Value parse(String text) {
		Reader p = new Reader(text);
		skipSpaces(p);
		int i = p.i;
		Object v = parseValue(p); // This allows any JSON values.
		return new Value(v, p, i);
	}

	public static List<Value> parseArray(Reader p) {
		List<Value> a = new ArrayList<>();

		if (p.get() == '[') {
			p.next();
		} else {
			throw new JSONException(p);
		}

		skipSpaces(p);
		if (p.get() == ']') {
			p.next();
			return a;
		}

		while (true) {
			skipSpaces(p);
			int i = p.i;
			Object v = parseValue(p);

			a.add(new Value(v, p, i));

			skipSpaces(p);
			if (p.get() == ',') {
				p.next();
			} else {
				break;
			}
		}

		skipSpaces(p);
		if (p.get() == ']') {
			p.next();
		} else {
			throw new JSONException(p);
		}
		return a;
	}

	public static String parseLiteral(Reader p) {
		int b = p.i;

		while (isJSONLetter(p)) {
			p.next();
			if (p.i >= p.text.length()) {
				break;
			}
		}
		if (b == p.i) {
			throw new JSONException(p);
		}
		return p.text.substring(b, p.i);

	}

	public static String parseName(Reader p) {
		if (isJSONQuote(p)) {
			return parseString(p);
		} else {
			return parseLiteral(p);
		}
	}

	public static Map<String, Value> parseObject(Reader p) {
		Map<String, Value> a = new LinkedHashMap<>();

		if (p.get() == '{') {
			p.next();
		} else {
			throw new JSONException(p);
		}

		skipSpaces(p);
		if (p.get() == '}') {
			p.next();
			return a;
		}

		while (true) {
			skipSpaces(p);
			String s = parseName(p);

			skipSpaces(p);
			if (p.get() == ':') {
				p.next();
			} else {
				throw new JSONException(p);
			}

			skipSpaces(p);
			int i = p.i;
			Object v = parseValue(p);

			a.put(s, new Value(v, p, i));

			skipSpaces(p);
			if (p.get() == ',') {
				p.next();
			} else {
				break;
			}
		}

		skipSpaces(p);
		if (p.get() == '}') {
			p.next();
		} else {
			throw new JSONException(p);
		}
		return a;
	}

	public static String parseString(Reader p) {
		Character quote = p.get();
		if (isJSONQuote(p)) {
			p.next();
		} else {
			throw new JSONException(p);
		}

		int b = p.i;

		while (p.i < p.text.length()) {
			if (p.get() == quote) {
				p.next();
				break;
			} else {
				p.next();
			}
		}
		assert (p.i <= p.text.length());
		return p.text.substring(b, p.i - 1);

	}

	public static Object parseValue(Reader p) {
		if (p.get() == '{') {
			return parseObject(p);
		} else if (p.get() == '[') {
			return parseArray(p);
		} else if (isJSONQuote(p)) {
			return parseString(p);
		} else {
			return parseLiteral(p);
		}
	}

	public static void skipSpaces(Reader p) {
		while (Character.isWhitespace(p.get())) {
			p.next();
		}
	}
}
