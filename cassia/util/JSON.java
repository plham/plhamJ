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
 * A JSON parser written in X10.
 * 
 * <p>
 * Restrictions:
 * <ul>
 * <li>No type recognition for literals (stored as string)
 * <li>No escape sequence handling
 * </ul>
 *
 * <p>
 * Use <code>JSON.parse()</code> to obtain a JSON object from a string or file.
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
	private static final long serialVersionUID = -1962266233974277670L;

	/*
	public static final class Entry {
		val key:String;
		val value:Value;
	/*
	public def this(key:String, value:Value) { this.key = key; this.value = value;  }
	/*
	public def getKey():String { return this.key; }
	/*
	public def getValue():Value { return this.value; }
	}
	 */
	public static final class Entry {
		String key;
		Value value;

		public Entry(String key, Value value) {
			this.key = key;
			this.value = value;
		}

		public String getKey() {
			return this.key;
		}

		public Value getValue() {
			return this.value;
		}
	}

	/*
	public static class Value {
		var value:Any; // String, List, or Map (never Boolean, Long, Double, etc)
		var p:Reader;
		var i:Int;
	*/
	public static class Value {
		Object value; // String, List, or Map (never Boolean, Long, Double, etc)
		Reader p;
		int i;

		/*
		public def this(Any value, Reader p, Int i) {
			this.value = value;
			this.p = p;
			this.i = i;
		}
		*/
		public Value(Object value, Reader p, int i) {
			this.value = value;
			this.p = p;
			this.i = i;
		}

		/*
		public def this(Any value) {
				this(value, null, 0n);
		}
		*/
		public Value(Object value) {
			this(value, null, 0);
		}

		/*
		public def get[T](s:T):Value {
			if (!this.has(s)) {
				throw new JSONException("No key: " + s);
			}
			if (this.isList()) {
				val i = Long.parse(s.toString());
				return this.asList()(i);
			}
			if (this.isMap()) {
				return this.asMap().get(s.toString());
			}
			throw new JSONException("No key: " + s);
		}
		 */
		@SuppressWarnings("hiding")
		public Value get(Object s) {
			if (!this.has(s)) {
				throw new JSONException("No key: " + s);
			}
			if (this.isList()) {
				int i = Integer.valueOf(s.toString());
				return this.asList().get(i);
			}
			if (this.isMap()) {
				return this.asMap().get(s.toString());
			}
			throw new JSONException("No key: " + s);
		}

		/*
		public def get[T](s:Rail[T]):Value {
			var v:Value = this;
			for (i in 0..(s.size - 1)) {
				if (v.has(s(i))) {
					v = v.get(s(i));
				} else {
					throw new JSONException("No key: " + s);
				}
			}
			return v;
		}
		 */
		@SuppressWarnings("hiding")
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

		/*
		public def getOrElse[T](s:T, orElse:String):Value {
			if (this.has(s)) {
				return this.get(s);
			}
			return parse(orElse);
		}
		*/
		public Value getOrElse(Object s, String orElse) {
			if (this.has(s)) {
				return this.get(s);
			}
			return parse(orElse);
		}

		/*
		public def set(v:Any) {
			this.value = v;
		}
		*/
		public void set(Object v) {
			this.value = v;
		}

		/*
		public def put[T](s:T, v:Value) {
			if (this.isList()) {
				val i = Long.parse(s.toString());
				return this.asList()(i) = v;
			}
			if (this.isMap()) {
				return this.asMap().put(s.toString(), v);
			}
			throw new JSONException("Cannot assign to " + s + ": " + v);
		}
		*/
		@SuppressWarnings("hiding")
		public void put(String s, Value v) {
			if (this.isList()) {
				int i = Integer.valueOf(s);
				this.asList().set(i, v);
				return;
			}
			if (this.isMap()) {
				this.asMap().put(s, v);
				return;
			}
			throw new JSONException("Cannot assign to " + s + ": " + v);

		}

		/*
		public def put[T](s:T, v:Any) {
			return this.put(s, new Value(v.toString()));
		}
		*/
		public void put(String s, Object v) {
			this.put(s, new Value(v.toString()));
		}

		/*
		public def has[T](s:T):Boolean {
			if (this.isList()) {
				val i = Long.parse(s.toString());
				return 0 <= i && i < this.asList().size();
			}
			if (this.isMap()) {
				return this.asMap().containsKey(s.toString());
			}
			return false;
		}
		*/
		@SuppressWarnings("hiding")
		public boolean has(Object s) {
			if (this.isList()) {
				long i = Long.valueOf(s.toString());
				return 0 <= i && i < this.asList().size();
			}
			if (this.isMap()) {
				return this.asMap().containsKey(s.toString());
			}
			return false;
		}

		/*
		public def any[T](s:Rail[T]):Value {
			for (i in 0..(s.size - 1)) {
				if (this.has(s(i))) {
					return this.get(s(i));
				}
			}
			throw new JSONException("No key: " + s);
		}
		*/
		@SuppressWarnings("hiding")
		public Value any(List<Value> s) {
			for (int i = 0; i < s.size(); i++) {
				if (this.has(s.get(i))) {
					return this.get(s.get(i));
				}
			}
			throw new JSONException("No key: " + s);
		}

		/*
		public def size():Long {
			if (this.isList()) {
				return this.asList().size();
			}
			if (this.isMap()) {
				return this.asMap().size();
			}
			return 0;
		}
		*/
		public long size() {
			if (this.isList()) {
				return this.asList().size();
			}
			if (this.isMap()) {
				return this.asMap().size();
			}
			return 0;
		}

		/*
		public operator this[T](key:T):Value {
			return this.get(key);
		}

		public operator this[T](key:T) = (v:Value) {
			return this.put(key, v);
		}

		public operator this[T](key:T) = (v:Any) {
			return this.put(key, v);
		}
		public operator this[T](key:T, orElse:String):Value {
			return this.getOrElse(key, orElse);
		}
		public operator this[T](keys:Rail[T]):Value {
			return this.any(keys);
		}
		*/

		/*
		public def isNull():Boolean {
			return this.value == null;
		}
		*/
		public boolean isNull() {
			return this.value == null;
		}

		/*
		public def isMap():Boolean {
			return this.value instanceof Map[String,Value];
		}
		*/
		public boolean isMap() {
			return this.value instanceof Map;
		}

		/*
		public def asMap():Map[String,Value] {
			return this.value as Map[String,Value];
		}
		*/
		@SuppressWarnings("unchecked")
		public Map<String, Value> asMap() {
			return (Map<String, Value>) this.value;
		}

		/*
		public def isList():Boolean {
			return this.value instanceof List[Value];
		}
		*/
		public boolean isList() {
			return this.value instanceof List;
		}

		/*
		public def asList():List[Value] {
			return this.value as List[Value];
		}
		*/
		@SuppressWarnings({ "unchecked", "rawtypes" })
		public List<Value> asList() {
			return (List) this.value;
		}

		/*
		public def apply(key:String, value:Value):Value {
			assert this.isMap() : JSON.dump(this) + " is not a json object.";
			val obj = this.clone();
			obj.put(key, value.clone());
			return obj;
		}
		*/
		@SuppressWarnings("hiding")
		public Value apply(String key, Value value) {
			assert this.isMap() : JSON.dump(this) + " is not a json object.";
			Value obj = this.clone();
			obj.put(key, value.clone());
			return obj;
		}

		/*
		public def apply(key:String, value:String):Value {
			return apply(key, JSON.parse("\"" + value + "\""));
		}
		*/
		@SuppressWarnings("hiding")
		public Value apply(String key, String value) {
			return apply(key, JSON.parse("\"" + value + "\""));
		}

		/*
		public def apply(key:String, value:Long):Value {
			return apply(key, JSON.parse(value.toString()));
		}
		*/
		@SuppressWarnings("hiding")
		public Value apply(String key, Long value) {
			return apply(key, JSON.parse(value.toString()));
		}

		/*
		public def apply(key:String, value:Double):Value {
			return apply(key, JSON.parse(value.toString()));
		}
		*/
		@SuppressWarnings("hiding")
		public Value apply(String key, Double value) {
			return apply(key, JSON.parse(value.toString()));
		}

		/*
		public def apply(entries:Rail[Entry]):Value {
			val obj = this.clone();
			for (entry in entries) {
				val key = entry.getKey();
				val value = entry.getValue();
				obj.put(key, value.clone());
			}
			return obj;
		}
		*/
		@SuppressWarnings("hiding")
		public Value apply(List<Entry> entries) {
			Value obj = this.clone();
			for (Entry entry : entries) {
				String key = entry.getKey();
				Value value = entry.getValue();
				obj.put(key,value.clone());
			}
			return obj;
		}

		/*
		public def apply(rhs:Value):Value {
			assert this.isMap() : (this.toString()) + " is not a json object.";
			val obj = this.clone();
			for (entry in rhs.asMap().entries()) {
				val key = entry.getKey();
				val value = entry.getValue();
				obj.put(key, value.clone());
			}
			return obj;
		}
		*/
		@SuppressWarnings("hiding")
		public Value apply(Value rhs) {
			assert this.isMap() : (this.toString()) + " is not a json object.";
			Value obj = this.clone();
			for (Map.Entry<String, Value> entry : rhs.asMap().entrySet()) {
				String key = entry.getKey();
				Value value = entry.getValue();
				obj.put(key, value.clone());
			}
			return obj;
		}

		/*
		public def equals(that:Any):Boolean {
			return this.toString().equals(that.toString());
		}
		*/
		@Override
		public boolean equals(Object that) {
			return this.toString().equals(that.toString());
		}

		/*
		protected def getExInfo():String {
			if (this.p == null) {
				return this.value.toString();
			}
			return this.p.toString(this.i);
		}
		*/
		protected String getExInfo() {
			if (this.p == null) {
				return this.value.toString();
			}
			return this.p.toString(this.i);
		}

		/*
		public def toString():String {
			try {
				return this.value as String;
			} catch (Exception) {
				throw new JSONException("Cannot cast to String: " + this.getExInfo());
			}
		}
		*/
		@Override
		public String toString() {
			try {
				return this.value.toString();
			} catch (Exception e) {
				throw new JSONException("Cannot cast to String: "
						+ this.getExInfo());
			}
		}

		/*
		public def toBoolean():Boolean {
			try {
				return Boolean.parse(this.value as String);
			} catch (Exception) {
				throw new JSONException("Cannot cast to Boolean: " + this.getExInfo());
			}
		}
		*/
		public boolean toBoolean() {
			try {
				return Boolean.valueOf(this.value.toString());
			} catch (Exception e) {
				throw new JSONException("Cannot cast to Boolean: "
						+ this.getExInfo());
			}
		}

		/*
		public def toInt():Int {
			try {
				return Int.parse(this.value as String);
			} catch (Exception) {
				throw new JSONException("Cannot cast to Int: " + this.getExInfo());
			}
		}
		*/
		public int toInt() {
			try {
				return Integer.valueOf(this.value.toString());
			} catch (Exception e) {
				throw new JSONException("Cannot cast to int: "
						+ this.getExInfo());
			}
		}

		/*
		public def toLong():Long {
			try {
				return Long.parse(this.value as String);
			} catch (Exception) {
				throw new JSONException("Cannot cast to Long: " + this.getExInfo());
			}
		}
		*/
		public long toLong() {
			try {
				return Long.valueOf(this.value.toString());
			} catch (Exception e) {
				throw new JSONException("Cannot cast to long: "
						+ this.getExInfo());
			}
		}

		/*
		public def toDouble():Double {
			try {
				return Double.parse(this.value as String);
			} catch (Exception) {
				throw new JSONException("Cannot cast to Double: " + this.getExInfo());
			}
		}
		*/
		public double toDouble() {
			try {
				return Double.valueOf(this.value.toString());
			} catch (Exception e) {
				throw new JSONException("Cannot cast to double: "
						+ this.getExInfo());
			}
		}

		/*
		public def clone():Value {
			var value:Any = this.value;
			if (this.isList()) {
				val a = this.asList();
				val h = new ArrayList[Value]();
				for (item in a) { h.add(item.clone()); }
				value = h;
			}
			if (this.isMap()) {
				val a = this.asMap();
				val h = new HashMap[String,Value]();
				for (key in a.keySet()) { h(key) = a(key).clone(); }
				value = h;
			}
			return new Value(value, this.p, this.i);
		}
		*/
		@Override
		@SuppressWarnings("hiding")
		public Value clone() {
			Object value = this.value;
			if (this.isList()) {
				List<Value> a = this.asList();
				List<Value> h = new ArrayList<Value>();
				for (Object item : a) {
					Value v = (Value) item;
					h.add(v.clone());
				}
				value = h;
			}
			if (this.isMap()) {
				Map<String, Value> a = this.asMap();
				Map<String, Value> h = new LinkedHashMap<String, Value>();
				for (Map.Entry<String, Value> entry : a.entrySet()) {
					h.put(entry.getKey(), entry.getValue().clone());
				}
				value = h;
			}
			return new Value(value, this.p, this.i);
		}

		@Override
		public int hashCode() {
			return value.hashCode();
		}
	}

	static class Reader {
		/*
		public var text:String;
		public var i:Int;
		 */
		public String text;
		public int i;

		/*
		public def this(text:String) {
				this.text = text;
				this.i = 0n;
			}
		*/
		public Reader(String text) {
			this.text = text;
			this.i = 0;
		}

		/*
		public def get():Char {
			return this.text(this.i);
		}
		*
		*/
		public Character get() {
			return this.text.charAt(i);
		}

		/*
		public def next() {
				this.i++;
		}
		*/
		public void next() {
			i++;
		}

		/*
		public def toString(i:Int):String {
				return this.text.substring(Math.max(0n, i - 20n), Math.min(i + 20n, this.text.length()));
			}
		}
		*/
		@SuppressWarnings("hiding")
		public String toString(int i) {
			return this.text.substring(Math.max(0, i - 20),
					Math.min(i + 20, text.length()));
		}
	}

	/*
	public static def isJSONLetter(p:Reader) {
		val c = p.get();
		return (c.isLetter() || c.isDigit() || c == '_' || c == '.' || c == '+' || c == '-');
	}
	*/
	public static boolean isJSONLetter(Reader p) {
		Character c = p.get();
		return (Character.isAlphabetic(c) || Character.isDigit(c) || c == '_'
				|| c == '.' || c == '+' || c == '-');
	}

	/*
	public static def isJSONQuote(p:Reader) {
		val c = p.get();
		return (c == '"' || c == '\''); //"
	}
	*/
	public static boolean isJSONQuote(Reader p) {
		Character c = p.get();
		return (c == '"' || c == '\'');
	}

	/*
	public static def skipSpaces(p:Reader) {
		while (p.get().isWhitespace()) {
			p.next();
		}
	}
	*/
	public static void skipSpaces(Reader p) {
		while (Character.isWhitespace(p.get())) {
			p.next();
		}
	}

	/*
	public static def parseLiteral(p:Reader):String {
		val b = p.i;

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
	*/
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

	/*
	public static def parseString(p:Reader):String {
		val quote = p.get();
		if (isJSONQuote(p)) {
			p.next();
		} else {
			throw new JSONException(p);
		}

		val b = p.i;

		while (p.i < p.text.length()) {
			if (p.get() == quote) {
				p.next();
				break;
			} else {
				p.next();
			}
		}
		assert(p.i <= p.text.length());
		return p.text.substring(b, p.i - 1n);
	}
	*/
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

	/*
	public static def parseValue(p:Reader):Any {
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
	*/
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

	/*
	public static def parseName(p:Reader):String {
		if (isJSONQuote(p)) {
			return parseString(p);
		} else {
			return parseLiteral(p);
		}
	}
	*/
	public static String parseName(Reader p) {
		if (isJSONQuote(p)) {
			return parseString(p);
		} else {
			return parseLiteral(p);
		}
	}

	/*
	public static def parseObject(p:Reader):Map[String,Value] {
		val a = new HashMap[String,Value]();

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
			val s = parseName(p);

			skipSpaces(p);
			if (p.get() == ':') {
				p.next();
			} else {
				throw new JSONException(p);
			}

			skipSpaces(p);
			val i = p.i;
			val v = parseValue(p);

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
	*/
	public static Map<String, Value> parseObject(Reader p) {
		Map<String, Value> a = new LinkedHashMap<String, Value>();

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

	/*
	public static def parseArray(p:Reader):List[Value] {
		val a = new ArrayList[Value]();

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
			val i = p.i;
			val v = parseValue(p);

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
	*/
	public static List<Value> parseArray(Reader p) {
		List<Value> a = new ArrayList<Value>();

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

	/*
	public static def parse(text:String) {
		val p = new Reader(text);
		skipSpaces(p);
		val i = p.i;
		val v = parseValue(p); // This allows any JSON values.
		return new Value(v, p, i);
	}
	*/
	public static Value parse(String text) {
		Reader p = new Reader(text);
		skipSpaces(p);
		int i = p.i;
		Object v = parseValue(p); // This allows any JSON values.
		return new Value(v, p, i);
	}

	/*
	public static def parse(file:File) {
		val s = new StringBuilder();
		for (line in file.lines()) {
			s.add(line);
			s.add(" ");
		}
		return parse(s.toString());
	}
	*/
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
		return parse(s.toString());
	}

	/*
	private static def _extendChain(root:JSON.Value, focus:JSON.Value, out:HashMap[String,Value]) {
		if (!focus.isMap()) {
			return;
		}
		if (focus.has("extends")) {
			val child = focus("extends");
			_extendChain(root, root(child), out);
		}
		val dict = focus.asMap();
		for (key in dict.keySet()) {
			out(key) = dict(key);
		}
	}
	*/
	private static void _extendChain(Value root, Value focus,
			Map<String, Value> out) {
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

	/*
	public static def extend(root:JSON.Value):JSON.Value {
		if (!root.isMap()) {
			return root;
		}
		for (key in root.asMap().keySet()) {
			if (!root(key).isMap()) {
				continue;
			}
			if (root(key).has("extends")) {
				val out = new HashMap[String,Value]();
				_extendChain(root, root(key), out);
				root(key).value = out;
			}
		}
		return root;
	}
	*/
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
				Map<String, Value> out = new LinkedHashMap<String, Value>();
				_extendChain(root, root.get(key), out);
				root.get(key).value = out;
			}
		}
		return root;
	}

	/*
	public static def extendDeeply(root:JSON.Value, focus:JSON.Value):JSON.Value {
		if (! focus.isMap()) return focus;
		for (entry in focus.asMap().entries()) {
			val key = entry.getKey();
			val nextFocus = entry.getValue();
			if (! nextFocus.isMap()) continue;
			if (nextFocus.has("extends")) {
				val out = new HashMap[String, Value]();
				_extendChain(root, nextFocus, out);
				nextFocus.value = out;
			}
			extendDeeply(root, nextFocus);
		}
		return focus;
	}
	*/
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
				Map<String, Value> out = new LinkedHashMap<String, Value>();
				_extendChain(root, nextFocus, out);
				nextFocus.value = out;
			}
			extendDeeply(root, nextFocus);
		}
		return focus;
	}

	/*
	public static def dump(root:JSON.Value):String {
		val s = new StringBuilder();
		if (root.isMap()) {
			s.add("{");
			val d = root.asMap();
			val n = d.size();
			var i:Long = 0;
			for (key in d.keySet()) {
				s.add("\"");
				s.add(key.toString());
				s.add("\"");
				s.add(":");
				s.add(dump(d(key)));
				if (++i < n) {
					s.add(",");
				}
			}
			s.add("}");
		} else if (root.isList()) {
			s.add("[");
			val a = root.asList();
			val n = a.size();
			var i:Long = 0;
			for (elem in a) {
				s.add(dump(elem));
				if (++i < n) {
					s.add(",");
				}
			}
			s.add("]");
		} else {
			s.add("\"");
			s.add(root.value.toString());
			s.add("\"");
		}
		return s.toString();
	}
	*/
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
	/*
		public static def main(args:Rail[String]) {
			{
				// Test cases for JSON.Value#apply

				{
					// 1st form of apply. json_object.apply(key, value).
					val x = JSON.parse("{x: 'x'}");
					val prev_x = x.clone();
					val xy = JSON.parse("{x: 'x', y: 'y'}");
					assert JSON.dump(x.apply("y", JSON.parse("y"))).equals(JSON.dump(xy));
					assert JSON.dump(x).equals(JSON.dump(prev_x)); // assert that apply never modifies the receiver and the arguments.
				}
				{
					// 2nd form of apply. json_object.apply([(key0, value0), (key1, value1), ...]).
					val empty = JSON.parse("{}");
					val n = 100;
					val key_value_set = new Rail[Entry](n);
					for (i in 0 .. (n - 1)) {
						key_value_set(i) = new Entry(i.toString(), JSON.parse((i * i).toString()));
					}
					val square_set_0 = empty.apply(key_value_set);
					val square_set_1 = empty.clone();
					for (i in 0 .. (n - 1)) {
						square_set_1.put(i.toString(), JSON.parse((i * i).toString()));
					}
					assert JSON.dump(square_set_0).equals(JSON.dump(square_set_1));
				}
				{
					// 3rd form of apply. json_object.apply(another_json_object).
					val empty = JSON.parse("{}");
					val json = JSON.parse("{foo: {bar: 'baz'}}");
					val a0 = json.apply(empty);
					assert JSON.dump(a0).equals(JSON.dump(json));
					val a1 = empty.apply(json);
					assert JSON.dump(a1).equals(JSON.dump(json));
				}
			}

			var json:JSON.Value;
			if (args.size > 0) {
				json = JSON.parse(new File(args(0)));
			} else {
				json = JSON.parse("{'first': 1, 'second': 2, 'third': [1,2,'c'], '4th': {'one': { 'more': b.c.c } }, nullobj: { }, 1  : [],  spaces  : 'a a a'    ,   123   : 123  }");
			}

			Console.OUT.println(JSON.dump(json));

			JSON.extend(json);

			Console.OUT.println(JSON.dump(json));

			val z = JSON.parse("{}");
			Console.OUT.println(JSON.dump(z("a", "{'a':1}")));

			val x = new JSON.Value("x");
			val y = new JSON.Value("2.0");
			Console.OUT.println("x.toString().equals('x'): " + x.toString().equals("x"));
			Console.OUT.println("x.equals('x'): " + x.equals("x"));
			Console.OUT.println("x.equals('w'): " + x.equals("w"));
			Console.OUT.println("y.equals(2.0): " + y.equals(2.0));
			//Console.OUT.println("y.equals(2): " + y.equals(2));
			Console.OUT.println("y.equals(1.1): " + y.equals(1.1));

			Console.OUT.println(json.size());
			Console.OUT.println(json("first").size());
			Console.OUT.println(json("first").toDouble());
			Console.OUT.println(json("third").size());
			Console.OUT.println(json("first"));
			Console.OUT.println(json("first").toString());
			
			//json.put("5th", JSON.parse("123"));
			val clon = json.clone();
			clon("5th") = 123;
			clon("first") = "10000000000";
			clon("4th")("one") = "ichi";
			Console.OUT.println("5th: " + clon("5th"));
			Console.OUT.println(JSON.dump(json));
			Console.OUT.println(JSON.dump(clon));

			Console.OUT.println("JSON.Value as key: " + json(new JSON.Value("first")));

			Console.OUT.println("third");
			Console.OUT.println(json("third")(1).toLong());
			Console.OUT.println(json("third")("1").toLong());
			Console.OUT.println(json("third")("1").toDouble());
			Console.OUT.println(json("third")("2").toString());
			Console.OUT.println("end third");
			Console.OUT.println(json("4th")("one")("more").toString());
			Console.OUT.println(json.get(["third", 2]).toString());
			Console.OUT.println(json.get(["third", "2"]).toString());
			Console.OUT.println(json.get(["4th", "one", "more"]).toString());
			Console.OUT.println(json.get(["4th", "onetwo", "more"]));
			Console.OUT.println(json("4th")("onetwo")("more"));
			Console.OUT.println(json("4th").any(["three", "two"]).get("more"));
			Console.OUT.println(json("4th").any(["three", "two"])("more").toString());

			Console.OUT.println("END");
		}
	*/
}
