package cassia.util;


/**
 * A JSON parser written in X10.
 * 
 * <p>Restrictions:<ul>
 * <li> No type recognition for literals (stored as string)
 * <li> No escape sequence handling
 * </ul>
 *
 * <p>Use <code>JSON.parse()</code> to obtain a JSON object from a string or file.
 * 
 * <p>See {@link JSON.Value} to know how to access to the JSON data.
 * 
 * <p>Syntax:
 * <p><pre>
 *     json := object
 *     name := ( string | literal )
 *     value := ( object | array | string | literal )
 *     object := "{" [ name ":" value [ "," name ":" value ]&ast; ] "}"
 *     array := "[" [ value [ "," value ]&ast; ] "]"
 *     string := QUOTE [ CHARACTER ]&ast; QUOTE
 *     literal := ( LETTERS | DIGITS | "_" | "." | "+" | "-" )+
 * </pre>
 */
@x10.runtime.impl.java.X10Generated
public class JSON extends x10.core.Ref implements x10.serialization.X10JavaSerializable
{
    public static final x10.rtt.RuntimeType<JSON> $RTT = 
        x10.rtt.NamedType.<JSON> make("cassia.util.JSON",
                                      JSON.class);
    
    public x10.rtt.RuntimeType<?> $getRTT() { return $RTT; }
    
    public x10.rtt.Type<?> $getParam(int i) { return null; }
    
    private Object writeReplace() throws java.io.ObjectStreamException {
        return new x10.serialization.SerializationProxy(this);
    }
    
    public static x10.serialization.X10JavaSerializable $_deserialize_body(cassia.util.JSON $_obj, x10.serialization.X10JavaDeserializer $deserializer) throws java.io.IOException {
        if (x10.runtime.impl.java.Runtime.TRACE_SER) { x10.runtime.impl.java.Runtime.printTraceMessage("X10JavaSerializable: $_deserialize_body() of " + JSON.class + " calling"); } 
        return $_obj;
    }
    
    public static x10.serialization.X10JavaSerializable $_deserializer(x10.serialization.X10JavaDeserializer $deserializer) throws java.io.IOException {
        cassia.util.JSON $_obj = new cassia.util.JSON((java.lang.System[]) null);
        $deserializer.record_reference($_obj);
        return $_deserialize_body($_obj, $deserializer);
    }
    
    public void $_serialize(x10.serialization.X10JavaSerializer $serializer) throws java.io.IOException {
        
    }
    
    // constructor just for allocation
    public JSON(final java.lang.System[] $dummy) {
        
    }
    
    

    
    //#line 37 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
    /**
	 * Json object's entry, in other words, key-value pair.
	 */
    @x10.runtime.impl.java.X10Generated
    final public static class Entry extends x10.core.Ref implements x10.serialization.X10JavaSerializable
    {
        public static final x10.rtt.RuntimeType<Entry> $RTT = 
            x10.rtt.NamedType.<Entry> make("cassia.util.JSON.Entry",
                                           Entry.class);
        
        public x10.rtt.RuntimeType<?> $getRTT() { return $RTT; }
        
        public x10.rtt.Type<?> $getParam(int i) { return null; }
        
        private Object writeReplace() throws java.io.ObjectStreamException {
            return new x10.serialization.SerializationProxy(this);
        }
        
        public static x10.serialization.X10JavaSerializable $_deserialize_body(cassia.util.JSON.Entry $_obj, x10.serialization.X10JavaDeserializer $deserializer) throws java.io.IOException {
            if (x10.runtime.impl.java.Runtime.TRACE_SER) { x10.runtime.impl.java.Runtime.printTraceMessage("X10JavaSerializable: $_deserialize_body() of " + Entry.class + " calling"); } 
            $_obj.key = $deserializer.readObject();
            $_obj.value = $deserializer.readObject();
            return $_obj;
        }
        
        public static x10.serialization.X10JavaSerializable $_deserializer(x10.serialization.X10JavaDeserializer $deserializer) throws java.io.IOException {
            cassia.util.JSON.Entry $_obj = new cassia.util.JSON.Entry((java.lang.System[]) null);
            $deserializer.record_reference($_obj);
            return $_deserialize_body($_obj, $deserializer);
        }
        
        public void $_serialize(x10.serialization.X10JavaSerializer $serializer) throws java.io.IOException {
            $serializer.write(this.key);
            $serializer.write(this.value);
            
        }
        
        // constructor just for allocation
        public Entry(final java.lang.System[] $dummy) {
            
        }
        
        
    
        
        //#line 38 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
        public java.lang.String key;
        
        //#line 39 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
        public cassia.util.JSON.Value value;
        
        
        //#line 40 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
        // creation method for java code (1-phase java constructor)
        public Entry(final java.lang.String key, final cassia.util.JSON.Value value) {
            this((java.lang.System[]) null);
            cassia$util$JSON$Entry$$init$S(key, value);
        }
        
        // constructor for non-virtual call
        final public cassia.util.JSON.Entry cassia$util$JSON$Entry$$init$S(final java.lang.String key, final cassia.util.JSON.Value value) {
             {
                
                //#line 40 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
                
                
                //#line 37 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
                this.__fieldInitializers_cassia_util_JSON_Entry();
                
                //#line 40 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
                this.key = ((key));
                
                //#line 40 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
                this.value = ((value));
            }
            return this;
        }
        
        
        
        //#line 41 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
        public java.lang.String getKey() {
            
            //#line 41 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
            final java.lang.String t$25325 = ((this.key));
            
            //#line 41 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
            return t$25325;
        }
        
        
        //#line 42 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
        public cassia.util.JSON.Value getValue() {
            
            //#line 42 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
            final cassia.util.JSON.Value t$25326 = ((this.value));
            
            //#line 42 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
            return t$25326;
        }
        
        
        //#line 37 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
        final public cassia.util.JSON.Entry cassia$util$JSON$Entry$$this$cassia$util$JSON$Entry() {
            
            //#line 37 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
            return cassia.util.JSON.Entry.this;
        }
        
        
        //#line 37 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
        final public void __fieldInitializers_cassia_util_JSON_Entry() {
            
        }
    }
    
    
    //#line 59 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
    /**
	 * <code>JSON.parse(String)</code> returns <code>JSON.Value</code>.
	 * 
	 * <p>To access the content, use the <i>apply</i> operators:
	 * <p><pre>
	 *     val json = JSON.parse(...);
	 *     val x = json("x");
	 *     val y = json("y", "default");     // default
	 *     val z = json(["z1", "z2", "z3"]); // first one
	 * </pre>
	 * <p>If the key is a number, it is interpreted as a JSON Array (or X10 List) type.
	 * If the key is a string, it is interpreted as a JSON Object (or X10 Map) type.
	 * See the definition below for details.
	 */
    @x10.runtime.impl.java.X10Generated
    public static class Value extends x10.core.Ref implements x10.serialization.X10JavaSerializable
    {
        public static final x10.rtt.RuntimeType<Value> $RTT = 
            x10.rtt.NamedType.<Value> make("cassia.util.JSON.Value",
                                           Value.class);
        
        public x10.rtt.RuntimeType<?> $getRTT() { return $RTT; }
        
        public x10.rtt.Type<?> $getParam(int i) { return null; }
        
        private Object writeReplace() throws java.io.ObjectStreamException {
            return new x10.serialization.SerializationProxy(this);
        }
        
        public static x10.serialization.X10JavaSerializable $_deserialize_body(cassia.util.JSON.Value $_obj, x10.serialization.X10JavaDeserializer $deserializer) throws java.io.IOException {
            if (x10.runtime.impl.java.Runtime.TRACE_SER) { x10.runtime.impl.java.Runtime.printTraceMessage("X10JavaSerializable: $_deserialize_body() of " + Value.class + " calling"); } 
            $_obj.i = $deserializer.readInt();
            $_obj.p = $deserializer.readObject();
            $_obj.value = $deserializer.readObject();
            return $_obj;
        }
        
        public static x10.serialization.X10JavaSerializable $_deserializer(x10.serialization.X10JavaDeserializer $deserializer) throws java.io.IOException {
            cassia.util.JSON.Value $_obj = new cassia.util.JSON.Value((java.lang.System[]) null);
            $deserializer.record_reference($_obj);
            return $_deserialize_body($_obj, $deserializer);
        }
        
        public void $_serialize(x10.serialization.X10JavaSerializer $serializer) throws java.io.IOException {
            $serializer.write(this.i);
            $serializer.write(this.p);
            $serializer.write(this.value);
            
        }
        
        // constructor just for allocation
        public Value(final java.lang.System[] $dummy) {
            
        }
        
        
    
        
        //#line 61 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
        public java.lang.Object value;
        
        //#line 62 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
        public cassia.util.JSON.Reader p;
        
        //#line 63 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
        public int i;
        
        
        //#line 65 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
        // creation method for java code (1-phase java constructor)
        public Value(final java.lang.Object value, final cassia.util.JSON.Reader p, final int i) {
            this((java.lang.System[]) null);
            cassia$util$JSON$Value$$init$S(value, p, i);
        }
        
        // constructor for non-virtual call
        final public cassia.util.JSON.Value cassia$util$JSON$Value$$init$S(final java.lang.Object value, final cassia.util.JSON.Reader p, final int i) {
             {
                
                //#line 65 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
                
                
                //#line 59 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
                this.__fieldInitializers_cassia_util_JSON_Value();
                
                //#line 66 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
                this.value = ((value));
                
                //#line 67 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
                this.p = ((p));
                
                //#line 68 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
                this.i = i;
            }
            return this;
        }
        
        
        
        //#line 71 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
        // creation method for java code (1-phase java constructor)
        public Value(final java.lang.Object value) {
            this((java.lang.System[]) null);
            cassia$util$JSON$Value$$init$S(value);
        }
        
        // constructor for non-virtual call
        final public cassia.util.JSON.Value cassia$util$JSON$Value$$init$S(final java.lang.Object value) {
             {
                
                //#line 72 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
                /*this.*/cassia$util$JSON$Value$$init$S(((value)), ((cassia.util.JSON.Reader)(null)), ((0)));
            }
            return this;
        }
        
        
        
        //#line 87 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
        /**
		 * Get the value associated with the key if exists.
		 * The key can be of any type.
		 * The key is first casted in <code>toString()</code> and then
		 * treated as <code>Long</code> if <code>isList()</code> but as <code>String</code> if <code>isMap()</code>.
		 * <pre>
		 *     JSON: {"one": {"two": {"three": 3}}}
		 *     X10 : json("one")("two")("three").toLong()    // gets 3
		 * </pre>
		 * @param s  a key
		 * @return the value
		 */
        public <$T>cassia.util.JSON.Value get__0cassia$util$JSON$Value$$T(final x10.rtt.Type $T, final $T s) {
            
            //#line 88 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
            final boolean t$25327 = this.<$T> has__0cassia$util$JSON$Value$$T$O($T, ((s)));
            
            //#line 88 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
            final boolean t$25330 = !(t$25327);
            
            //#line 88 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
            if (t$25330) {
                
                //#line 89 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
                final java.lang.String t$25328 = (("No key: ") + (s));
                
                //#line 89 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
                final cassia.util.JSON.JSONException t$25329 = ((new cassia.util.JSON.JSONException(t$25328)));
                
                //#line 89 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
                throw t$25329;
            }
            
            //#line 91 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
            final boolean t$25334 = this.isList$O();
            
            //#line 91 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
            if (t$25334) {
                
                //#line 92 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
                final java.lang.String t$25331 = x10.rtt.Types.toString(((s)));
                
                //#line 92 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
                final long i = java.lang.Long.parseLong(t$25331);
                
                //#line 93 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
                final x10.util.List t$25332 = this.asList();
                
                //#line 93 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
                final cassia.util.JSON.Value t$25333 = ((x10.util.Indexed<cassia.util.JSON.Value>)t$25332).$apply$G((i));
                
                //#line 93 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
                return t$25333;
            }
            
            //#line 95 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
            final boolean t$25338 = this.isMap$O();
            
            //#line 95 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
            if (t$25338) {
                
                //#line 96 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
                final x10.util.Map t$25335 = this.asMap();
                
                //#line 96 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
                final java.lang.String t$25336 = x10.rtt.Types.toString(((s)));
                
                //#line 96 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
                final cassia.util.JSON.Value t$25337 = ((cassia.util.JSON.Value)
                                                         ((x10.util.Map<java.lang.String, cassia.util.JSON.Value>)t$25335).get(((t$25336)), x10.rtt.Types.STRING));
                
                //#line 96 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
                return t$25337;
            }
            
            //#line 98 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
            final java.lang.String t$25339 = (("No key: ") + (s));
            
            //#line 98 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
            final cassia.util.JSON.JSONException t$25340 = ((new cassia.util.JSON.JSONException(t$25339)));
            
            //#line 98 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
            throw t$25340;
        }
        
        
        //#line 110 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
        /**
		 * Get the final value associated with all the keys in the list.
		 * <pre>
		 *     JSON: {"one": {"two": {"three": 3}}}
		 *     X10 : json(["one", "two", "three"]).toLong()    // gets 3
		 * </pre>
		 * @param s  a key list
		 * @return the value
		 */
        public <$T>cassia.util.JSON.Value get__0$1cassia$util$JSON$Value$$T$2(final x10.rtt.Type $T, final x10.core.Rail s) {
            
            //#line 111 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
            cassia.util.JSON.Value v = this;
            
            //#line 112 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
            final long i$25211min$25802 = 0L;
            
            //#line 112 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
            final long t$25803 = ((x10.core.Rail<$T>)s).size;
            
            //#line 112 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
            final long i$25211max$25804 = ((t$25803) - (((1L))));
            
            //#line 112 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
            long i$25799 = i$25211min$25802;
            
            //#line 112 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
            for (;
                 true;
                 ) {
                
                //#line 112 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
                final long t$25800 = i$25799;
                
                //#line 112 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
                final boolean t$25801 = ((t$25800) <= (((i$25211max$25804))));
                
                //#line 112 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
                if (!(t$25801)) {
                    
                    //#line 112 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
                    break;
                }
                
                //#line 112 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
                final long i$25796 = i$25799;
                
                //#line 113 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
                final cassia.util.JSON.Value t$25788 = ((v));
                
                //#line 113 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
                final $T t$25789 = ((((x10.core.Rail<$T>)s).$apply$G((i$25796))));
                
                //#line 113 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
                final boolean t$25790 = t$25788.<$T> has__0cassia$util$JSON$Value$$T$O($T, ((t$25789)));
                
                //#line 113 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
                if (t$25790) {
                    
                    //#line 114 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
                    final cassia.util.JSON.Value t$25791 = ((v));
                    
                    //#line 114 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
                    final $T t$25792 = ((((x10.core.Rail<$T>)s).$apply$G((i$25796))));
                    
                    //#line 114 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
                    final cassia.util.JSON.Value t$25793 = t$25791.<$T> get__0cassia$util$JSON$Value$$T($T, ((t$25792)));
                    
                    //#line 114 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
                    v = ((t$25793));
                } else {
                    
                    //#line 116 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
                    final java.lang.String t$25794 = (("No key: ") + (s));
                    
                    //#line 116 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
                    final cassia.util.JSON.JSONException t$25795 = ((new cassia.util.JSON.JSONException(t$25794)));
                    
                    //#line 116 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
                    throw t$25795;
                }
                
                //#line 112 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
                final long t$25797 = i$25799;
                
                //#line 112 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
                final long t$25798 = ((t$25797) + (((1L))));
                
                //#line 112 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
                i$25799 = t$25798;
            }
            
            //#line 119 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
            final cassia.util.JSON.Value t$25355 = ((v));
            
            //#line 119 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
            return t$25355;
        }
        
        
        //#line 133 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
        /**
		 * Get the value associated with the key if exists;
		 * Otherwise return <code>JSON.parse(orElse)</code>.
		 * <pre>
		 *     JSON: {"one": {"two": {"three": 3}}}
		 *     X10 : json("one")("two")("threat", "13").toLong()    // gets 13
		 * </pre>
		 * @param s  a key
		 * @param orElse  a JSON text used if <code>s</code> not found
		 * @return the value
		 */
        public <$T>cassia.util.JSON.Value getOrElse__0cassia$util$JSON$Value$$T(final x10.rtt.Type $T, final $T s, final java.lang.String orElse) {
            
            //#line 134 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
            final boolean t$25357 = this.<$T> has__0cassia$util$JSON$Value$$T$O($T, ((s)));
            
            //#line 134 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
            if (t$25357) {
                
                //#line 135 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
                final cassia.util.JSON.Value t$25356 = this.<$T> get__0cassia$util$JSON$Value$$T($T, ((s)));
                
                //#line 135 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
                return t$25356;
            }
            
            //#line 137 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
            final cassia.util.JSON.Value t$25358 = ((cassia.util.JSON.parse(((orElse)))));
            
            //#line 137 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
            return t$25358;
        }
        
        
        //#line 140 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
        public void set(final java.lang.Object v) {
            
            //#line 141 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
            this.value = ((v));
        }
        
        
        //#line 144 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
        public <$T>cassia.util.JSON.Value put__0cassia$util$JSON$Value$$T(final x10.rtt.Type $T, final $T s, final cassia.util.JSON.Value v) {
            
            //#line 145 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
            final boolean t$25362 = this.isList$O();
            
            //#line 145 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
            if (t$25362) {
                
                //#line 146 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
                final java.lang.String t$25359 = x10.rtt.Types.toString(((s)));
                
                //#line 146 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
                final long i = java.lang.Long.parseLong(t$25359);
                
                //#line 147 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
                final x10.util.List t$25360 = this.asList();
                
                //#line 147 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
                final cassia.util.JSON.Value t$25361 = ((cassia.util.JSON.Value)
                                                         ((x10.lang.Settable<x10.core.Long, cassia.util.JSON.Value>)t$25360).$set(x10.core.Long.$box(i), x10.rtt.Types.LONG, ((v)), cassia.util.JSON.Value.$RTT));
                
                //#line 147 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
                return t$25361;
            }
            
            //#line 149 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
            final boolean t$25366 = this.isMap$O();
            
            //#line 149 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
            if (t$25366) {
                
                //#line 150 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
                final x10.util.Map t$25363 = this.asMap();
                
                //#line 150 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
                final java.lang.String t$25364 = x10.rtt.Types.toString(((s)));
                
                //#line 150 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
                final cassia.util.JSON.Value t$25365 = ((cassia.util.JSON.Value)
                                                         ((x10.util.Map<java.lang.String, cassia.util.JSON.Value>)t$25363).put(((t$25364)), x10.rtt.Types.STRING, ((v)), cassia.util.JSON.Value.$RTT));
                
                //#line 150 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
                return t$25365;
            }
            
            //#line 152 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
            final java.lang.String t$25367 = (("Cannot assign to ") + (s));
            
            //#line 152 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
            final java.lang.String t$25368 = ((t$25367) + (": "));
            
            //#line 152 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
            final java.lang.String t$25369 = ((t$25368) + (v));
            
            //#line 152 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
            final cassia.util.JSON.JSONException t$25370 = ((new cassia.util.JSON.JSONException(t$25369)));
            
            //#line 152 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
            throw t$25370;
        }
        
        
        //#line 155 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
        public <$T>cassia.util.JSON.Value put__0cassia$util$JSON$Value$$T(final x10.rtt.Type $T, final $T s, final java.lang.Object v) {
            
            //#line 156 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
            final java.lang.String t$25371 = x10.rtt.Types.toString(v);
            
            //#line 156 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
            final cassia.util.JSON.Value t$25372 = ((new cassia.util.JSON.Value((java.lang.System[]) null).cassia$util$JSON$Value$$init$S((t$25371))));
            
            //#line 156 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
            final cassia.util.JSON.Value t$25373 = this.<$T> put__0cassia$util$JSON$Value$$T($T, ((s)), ((t$25372)));
            
            //#line 156 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
            return t$25373;
        }
        
        
        //#line 164 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
        /**
		 * Test if it has the key <code>s</code>.
		 * @param s  a key
		 * @return
		 */
        public <$T>boolean has__0cassia$util$JSON$Value$$T$O(final x10.rtt.Type $T, final $T s) {
            
            //#line 165 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
            final boolean t$25379 = this.isList$O();
            
            //#line 165 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
            if (t$25379) {
                
                //#line 166 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
                final java.lang.String t$25374 = x10.rtt.Types.toString(((s)));
                
                //#line 166 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
                final long i = java.lang.Long.parseLong(t$25374);
                
                //#line 167 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
                boolean t$25377 = ((0L) <= (((i))));
                
                //#line 167 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
                if (t$25377) {
                    
                    //#line 167 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
                    final x10.util.List t$25375 = this.asList();
                    
                    //#line 167 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
                    final long t$25376 = ((x10.util.Container<cassia.util.JSON.Value>)t$25375).size$O();
                    
                    //#line 167 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
                    t$25377 = ((i) < (((t$25376))));
                }
                
                //#line 167 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
                final boolean t$25378 = t$25377;
                
                //#line 167 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
                return t$25378;
            }
            
            //#line 169 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
            final boolean t$25383 = this.isMap$O();
            
            //#line 169 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
            if (t$25383) {
                
                //#line 170 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
                final x10.util.Map t$25380 = this.asMap();
                
                //#line 170 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
                final java.lang.String t$25381 = x10.rtt.Types.toString(((s)));
                
                //#line 170 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
                final boolean t$25382 = x10.core.Boolean.$unbox(((x10.util.Map<java.lang.String, cassia.util.JSON.Value>)t$25380).containsKey$Z(((t$25381)), x10.rtt.Types.STRING));
                
                //#line 170 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
                return t$25382;
            }
            
            //#line 172 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
            return false;
        }
        
        
        //#line 184 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
        /**
		 * Get the value associated with the key first matched if any such exists.
		 * <pre>
		 *     JSON: {"one": 1, "TWO": 2, "THREE": 3}
		 *     X10 : json(["ONE", "TWO", "THREE"]).toLong()    // gets 2
		 * </pre>
		 * @param s  a key list
		 * @return the value
		 */
        @SuppressWarnings("cast")
		public <$T>cassia.util.JSON.Value any__0$1cassia$util$JSON$Value$$T$2(final x10.rtt.Type $T, final x10.core.Rail s) {
            
            //#line 185 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
            final long i$25229min$25815 = 0L;
            
            //#line 185 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
            final long t$25816 = ((x10.core.Rail<$T>)s).size;
            
            //#line 185 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
            final long i$25229max$25817 = ((t$25816) - (((1L))));
            
            //#line 185 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
            long i$25812 = i$25229min$25815;
            
            //#line 185 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
            for (;
                 true;
                 ) {
                
                //#line 185 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
                final long t$25813 = i$25812;
                
                //#line 185 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
                final boolean t$25814 = ((t$25813) <= (((i$25229max$25817))));
                
                //#line 185 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
                if (!(t$25814)) {
                    
                    //#line 185 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
                    break;
                }
                
                //#line 185 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
                final long i$25809 = i$25812;
                
                //#line 186 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
                final $T t$25805 = ((((x10.core.Rail<$T>)s).$apply$G((long)(i$25809))));
                
                //#line 186 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
                final boolean t$25806 = this.<$T> has__0cassia$util$JSON$Value$$T$O($T, (($T)(t$25805)));
                
                //#line 186 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
                if (t$25806) {
                    
                    //#line 187 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
                    final $T t$25807 = (($T)(((x10.core.Rail<$T>)s).$apply$G((long)(i$25809))));
                    
                    //#line 187 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
                    final cassia.util.JSON.Value t$25808 = this.<$T> get__0cassia$util$JSON$Value$$T($T, (($T)(t$25807)));
                    
                    //#line 187 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
                    return t$25808;
                }
                
                //#line 185 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
                final long t$25810 = i$25812;
                
                //#line 185 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
                final long t$25811 = ((t$25810) + (((long)(1L))));
                
                //#line 185 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
                i$25812 = t$25811;
            }
            
            //#line 190 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
            final java.lang.String t$25394 = (("No key: ") + (s));
            
            //#line 190 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
            final cassia.util.JSON.JSONException t$25395 = ((cassia.util.JSON.JSONException)(new cassia.util.JSON.JSONException(t$25394)));
            
            //#line 190 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
            throw t$25395;
        }
        
        
        //#line 197 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
        /**
		 * Get the size of this JSON Array or JSON Object (otherwise return 0).
		 * @return
		 */
        public long size$O() {
            
            //#line 198 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
            final boolean t$25398 = this.isList$O();
            
            //#line 198 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
            if (t$25398) {
                
                //#line 199 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
                final x10.util.List t$25396 = this.asList();
                
                //#line 199 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
                final long t$25397 = ((x10.util.Container<cassia.util.JSON.Value>)t$25396).size$O();
                
                //#line 199 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
                return t$25397;
            }
            
            //#line 201 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
            final boolean t$25401 = this.isMap$O();
            
            //#line 201 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
            if (t$25401) {
                
                //#line 202 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
                final x10.util.Map t$25399 = this.asMap();
                
                //#line 202 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
                final long t$25400 = ((x10.util.Map<java.lang.String, cassia.util.JSON.Value>)t$25399).size$O();
                
                //#line 202 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
                return t$25400;
            }
            
            //#line 204 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
            return 0L;
        }
        
        
        //#line 219 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
        /**
		 * Get the value associated with the key if exists.
		 * The key can be of any type.
		 * The key is first casted in <code>toString()</code> and then
		 * treated as <code>Long</code> if <code>isList()</code> but as <code>String</code> if <code>isMap()</code>.
		 * <pre>
		 *     JSON: {"one": {"two": {"three": 3}}}
		 *     X10 : json("one")("two")("three").toLong()    // gets 3
		 * </pre>
		 * @param key  a key
		 * @return the value
		 */
        public <$T>cassia.util.JSON.Value get(final x10.rtt.Type $T, final $T key) {
            
            //#line 220 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
            final cassia.util.JSON.Value t$25402 = this.<$T> get__0cassia$util$JSON$Value$$T($T, ((key)));
            
            //#line 220 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
            return t$25402;
        }
        
        
        //#line 223 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
        public <$T>cassia.util.JSON.Value $set__0cassia$util$JSON$Value$$T(final x10.rtt.Type $T, final $T key, final cassia.util.JSON.Value v) {
            
            //#line 224 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
            final cassia.util.JSON.Value t$25403 = this.<$T> put__0cassia$util$JSON$Value$$T($T, ((key)), ((v)));
            
            //#line 224 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
            return t$25403;
        }
        
        
        //#line 227 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
        public <$T>cassia.util.JSON.Value $set__0cassia$util$JSON$Value$$T(final x10.rtt.Type $T, final $T key, final java.lang.Object v) {
            
            //#line 228 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
            final cassia.util.JSON.Value t$25404 = this.<$T> put__0cassia$util$JSON$Value$$T($T, ((key)), ((v)));
            
            //#line 228 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
            return t$25404;
        }
        
        
        //#line 242 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
        /**
		 * Get the value associated with the key if exists;
		 * Otherwise returns <code>JSON.parse(orElse)</code>.
		 * <pre>
		 *     JSON: {"one": {"two": {"three": 3}}}
		 *     X10 : json("one")("two")("threat", "13").toLong()    // gets 13
		 * </pre>
		 * @param key  a key
		 * @param orElse  a JSON text used if <code>s</code> not found
		 * @return the value
		 */
        public <$T>cassia.util.JSON.Value $apply__0cassia$util$JSON$Value$$T(final x10.rtt.Type $T, final $T key, final java.lang.String orElse) {
            
            //#line 243 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
            final cassia.util.JSON.Value t$25405 = this.<$T> getOrElse__0cassia$util$JSON$Value$$T($T, ((key)), ((orElse)));
            
            //#line 243 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
            return t$25405;
        }
        
        
        //#line 255 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
        /**
		 * Get the value associated with the key first matched if any such exists.
		 * <pre>
		 *     JSON: {"one": 1, "TWO": 2, "THREE": 3}
		 *     X10 : json(["ONE", "TWO", "THREE"]).toLong()    // gets 2
		 * </pre>
		 * @param keys  a key list
		 * @return the value
		 */
        public <$T>cassia.util.JSON.Value $apply__0$1cassia$util$JSON$Value$$T$2(final x10.rtt.Type $T, final x10.core.Rail keys) {
            
            //#line 256 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
            final cassia.util.JSON.Value t$25406 = this.<$T> any__0$1cassia$util$JSON$Value$$T$2($T, ((keys)));
            
            //#line 256 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
            return t$25406;
        }
        
        
        //#line 259 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
        public boolean isNull$O() {
            
            //#line 260 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
            final java.lang.Object t$25407 = ((this.value));
            
            //#line 260 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
            final boolean t$25408 = ((t$25407) == (null));
            
            //#line 260 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
            return t$25408;
        }
        
        
        //#line 263 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
        public boolean isMap$O() {
            
            //#line 264 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
            final java.lang.Object t$25409 = ((this.value));
            
            //#line 264 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
            final boolean t$25410 = x10.util.Map.$RTT.isInstance(t$25409, x10.rtt.Types.STRING, cassia.util.JSON.Value.$RTT);
            
            //#line 264 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
            return t$25410;
        }
        
        
        //#line 267 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
        public x10.util.Map asMap() {
            
            //#line 268 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
            final java.lang.Object t$25411 = ((this.value));
            
            //#line 268 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
            final x10.util.Map t$25412 = x10.rtt.Types.<x10.util.Map<java.lang.String, cassia.util.JSON.Value>> cast(t$25411,x10.rtt.ParameterizedType.make(x10.util.Map.$RTT, x10.rtt.Types.STRING, cassia.util.JSON.Value.$RTT));
            
            //#line 268 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
            return t$25412;
        }
        
        
        //#line 271 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
        public boolean isList$O() {
            
            //#line 272 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
            final java.lang.Object t$25413 = ((this.value));
            
            //#line 272 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
            final boolean t$25414 = x10.util.List.$RTT.isInstance(t$25413, cassia.util.JSON.Value.$RTT);
            
            //#line 272 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
            return t$25414;
        }
        
        
        //#line 275 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
        public x10.util.List asList() {
            
            //#line 276 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
            final java.lang.Object t$25415 = ((this.value));
            
            //#line 276 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
            final x10.util.List t$25416 = x10.rtt.Types.<x10.util.List<cassia.util.JSON.Value>> cast(t$25415,x10.rtt.ParameterizedType.make(x10.util.List.$RTT, cassia.util.JSON.Value.$RTT));
            
            //#line 276 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
            return t$25416;
        }
        
        
        //#line 285 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
        /**
		 * Clones its receiver, and modifies its element pointed by "key" into "value".
		 * Requires that the receiver is a json object.
		 * 
		 * The receiver and all of the arguments are not modified.
		 */
        public cassia.util.JSON.Value apply(final java.lang.String key, final cassia.util.JSON.Value value) {
            
            //#line 286 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
            assert this.isMap$O(): ((cassia.util.JSON.dump(((this)))) + (" is not a json object."));
            
            //#line 287 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
            final cassia.util.JSON.Value obj = this.clone();
            
            //#line 288 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
            final cassia.util.JSON.Value t$25417 = value.clone();
            
            //#line 288 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
            obj.<java.lang.String> put__0cassia$util$JSON$Value$$T(x10.rtt.Types.STRING, ((key)), ((t$25417)));
            
            //#line 289 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
            return obj;
        }
        
        
        //#line 299 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
        /**
		 * Clones its receiver, and modifies its element pointed by "key" into "value". 
		 * "value"(String) is automatically converted into json string object.
		 * Requires that the receiver is a json object.
		 * 
		 * The receiver and all of the arguments are not modified.
		 */
        public cassia.util.JSON.Value apply(final java.lang.String key, final java.lang.String value) {
            
            //#line 300 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
            final java.lang.String t$25418 = (("\"") + (value));
            
            //#line 300 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
            final java.lang.String t$25419 = ((t$25418) + ("\""));
            
            //#line 300 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
            final cassia.util.JSON.Value t$25420 = ((cassia.util.JSON.parse(((t$25419)))));
            
            //#line 300 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
            final cassia.util.JSON.Value t$25421 = this.apply(((key)), ((t$25420)));
            
            //#line 300 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
            return t$25421;
        }
        
        
        //#line 303 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
        public cassia.util.JSON.Value apply(final java.lang.String key, final long value) {
            
            //#line 304 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
            final java.lang.String t$25422 = java.lang.Long.toString(value);
            
            //#line 304 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
            final cassia.util.JSON.Value t$25423 = ((cassia.util.JSON.parse(((t$25422)))));
            
            //#line 304 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
            final cassia.util.JSON.Value t$25424 = this.apply(((key)), ((t$25423)));
            
            //#line 304 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
            return t$25424;
        }
        
        
        //#line 307 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
        public cassia.util.JSON.Value apply(final java.lang.String key, final double value) {
            
            //#line 308 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
            final java.lang.String t$25425 = java.lang.Double.toString(value);
            
            //#line 308 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
            final cassia.util.JSON.Value t$25426 = ((cassia.util.JSON.parse(((t$25425)))));
            
            //#line 308 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
            final cassia.util.JSON.Value t$25427 = this.apply(((key)), ((t$25426)));
            
            //#line 308 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
            return t$25427;
        }
        
        
        //#line 317 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
        /**
		 * Clones its receiver, and modifies its element pointed by "key" into "value" for each given entry.
		 * Requires that the receiver is a json object.
		 * 
		 * The receiver and all of the arguments are not modified.
		 */
        public cassia.util.JSON.Value apply__0$1cassia$util$JSON$Entry$2(final x10.core.Rail entries) {
            
            //#line 318 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
            final cassia.util.JSON.Value obj = this.clone();
            
            //#line 319 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
            final x10.core.Rail rail$25828 = ((entries));
            
            //#line 319 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
            final long size$25829 = ((x10.core.Rail<cassia.util.JSON.Entry>)rail$25828).size;
            
            //#line 319 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
            long idx$25825 = 0L;
            {
                
                //#line 319 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
                final cassia.util.JSON.Entry[] rail$25828$value$25945 = ((cassia.util.JSON.Entry[])rail$25828.value);
                
                //#line 319 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
                for (;
                     true;
                     ) {
                    
                    //#line 319 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
                    final long t$25826 = idx$25825;
                    
                    //#line 319 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
                    final boolean t$25827 = ((t$25826) < (((size$25829))));
                    
                    //#line 319 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
                    if (!(t$25827)) {
                        
                        //#line 319 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
                        break;
                    }
                    
                    //#line 319 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
                    final long t$25821 = idx$25825;
                    
                    //#line 319 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
                    final cassia.util.JSON.Entry entry$25822 = (((rail$25828$value$25945[(int)t$25821])));
                    
                    //#line 320 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
                    final java.lang.String key$25818 = entry$25822.getKey();
                    
                    //#line 321 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
                    final cassia.util.JSON.Value value$25819 = entry$25822.getValue();
                    
                    //#line 322 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
                    final cassia.util.JSON.Value t$25820 = value$25819.clone();
                    
                    //#line 322 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
                    obj.<java.lang.String> put__0cassia$util$JSON$Value$$T(x10.rtt.Types.STRING, ((key$25818)), ((t$25820)));
                    
                    //#line 319 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
                    final long t$25823 = idx$25825;
                    
                    //#line 319 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
                    final long t$25824 = ((t$25823) + (((1L))));
                    
                    //#line 319 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
                    idx$25825 = t$25824;
                }
            }
            
            //#line 324 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
            return obj;
        }
        
        
        //#line 333 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
        /**
		 * Clones its receiver, and modifies its element pointed by "key" into "value" for each given object's entry.
		 * Requires that the receiver is a json object.
		 * 
		 * The receiver and all of the arguments are not modified.
		 */
        public cassia.util.JSON.Value apply(final cassia.util.JSON.Value rhs) {
            
            //#line 334 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
            assert this.isMap$O(): ((this.toString()) + (" is not a json object."));
            
            //#line 335 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
            final cassia.util.JSON.Value obj = this.clone();
            
            //#line 336 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
            final x10.util.Map t$25834 = rhs.asMap();
            
            //#line 336 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
            final x10.util.Set t$25835 = (((x10.util.Map<java.lang.String, cassia.util.JSON.Value>)t$25834).entries());
            
            //#line 336 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
            final x10.lang.Iterator entry$25836 = (((x10.lang.Iterable<x10.util.Map.Entry<java.lang.String, cassia.util.JSON.Value>>)t$25835).iterator());
            
            //#line 336 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
            for (;
                 true;
                 ) {
                
                //#line 336 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
                final boolean t$25837 = ((x10.lang.Iterator<x10.util.Map.Entry<java.lang.String, cassia.util.JSON.Value>>)entry$25836).hasNext$O();
                
                //#line 336 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
                if (!(t$25837)) {
                    
                    //#line 336 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
                    break;
                }
                
                //#line 336 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
                final x10.util.Map.Entry entry$25830 = ((((x10.lang.Iterator<x10.util.Map.Entry<java.lang.String, cassia.util.JSON.Value>>)entry$25836).next$G()));
                
                //#line 337 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
                final java.lang.String key$25831 = ((x10.util.Map.Entry<java.lang.String, cassia.util.JSON.Value>)entry$25830).getKey$G();
                
                //#line 338 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
                final cassia.util.JSON.Value value$25832 = ((x10.util.Map.Entry<java.lang.String, cassia.util.JSON.Value>)entry$25830).getValue$G();
                
                //#line 339 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
                final cassia.util.JSON.Value t$25833 = value$25832.clone();
                
                //#line 339 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
                obj.<java.lang.String> put__0cassia$util$JSON$Value$$T(x10.rtt.Types.STRING, ((key$25831)), ((t$25833)));
            }
            
            //#line 341 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
            return obj;
        }
        
        
        //#line 357 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
        /**
		 * Perform a String-vs-String equality test.
		 * Any argument is casted to String and then compared.
		 * This is to avoid the common pitfall:
		 * Without overriding <code>equals()</code>, the following
		 * <pre>
		 *     json("x").equals("x")
		 * </pre>
		 * results in the unintended <code>JSON.Value</code>-vs-<code>String</code> test,
		 * returning always false.
		 * @param that
		 * @return
		 */
        public boolean equals(final java.lang.Object that) {
            
            //#line 358 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
            final java.lang.String t$25440 = this.toString();
            
            //#line 358 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
            final java.lang.String t$25441 = x10.rtt.Types.toString(that);
            
            //#line 358 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
            final boolean t$25442 = (t$25440).equals(t$25441);
            
            //#line 358 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
            return t$25442;
        }
        
        
        //#line 365 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
        /**
		 * Get an error message with the JSON text around.
		 * @return
		 */
        public java.lang.String getExInfo() {
            
            //#line 366 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
            final cassia.util.JSON.Reader t$25443 = ((this.p));
            
            //#line 366 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
            final boolean t$25446 = ((t$25443) == (null));
            
            //#line 366 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
            if (t$25446) {
                
                //#line 367 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
                final java.lang.Object t$25444 = ((this.value));
                
                //#line 367 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
                final java.lang.String t$25445 = x10.rtt.Types.toString(t$25444);
                
                //#line 367 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
                return t$25445;
            }
            
            //#line 369 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
            final cassia.util.JSON.Reader t$25447 = ((this.p));
            
            //#line 369 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
            final int t$25448 = this.i;
            
            //#line 369 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
            final java.lang.String t$25449 = t$25447.toString((t$25448));
            
            //#line 369 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
            return t$25449;
        }
        
        
        //#line 377 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
        /**
		 * Cast this <code>JSON.Value</code> to String.
		 * Use <code>JSON.dump()</code> instead.
		 * @return
		 */
        public java.lang.String toString() {
            
            //#line 378 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
            try {{
                
                //#line 379 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
                final java.lang.Object t$25450 = ((this.value));
                
                //#line 379 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
                final java.lang.String t$25451 = x10.rtt.Types.<java.lang.String> castConversion(t$25450,x10.rtt.Types.STRING);
                
                //#line 379 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
                return t$25451;
            }}catch (final java.lang.RuntimeException id$38) {
                
                //#line 381 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
                final java.lang.String t$25452 = this.getExInfo();
                
                //#line 381 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
                final java.lang.String t$25453 = (("Cannot cast to String: ") + (t$25452));
                
                //#line 381 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
                final cassia.util.JSON.JSONException t$25454 = ((new cassia.util.JSON.JSONException(t$25453)));
                
                //#line 381 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
                throw t$25454;
            }
        }
        
        
        //#line 385 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
        public boolean toBoolean$O() {
            
            //#line 386 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
            try {{
                
                //#line 387 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
                final java.lang.Object t$25455 = ((this.value));
                
                //#line 387 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
                final java.lang.String t$25456 = x10.rtt.Types.<java.lang.String> castConversion(t$25455,x10.rtt.Types.STRING);
                
                //#line 387 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
                final boolean t$25457 = java.lang.Boolean.parseBoolean(t$25456);
                
                //#line 387 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
                return t$25457;
            }}catch (final java.lang.RuntimeException id$39) {
                
                //#line 389 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
                final java.lang.String t$25458 = this.getExInfo();
                
                //#line 389 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
                final java.lang.String t$25459 = (("Cannot cast to Boolean: ") + (t$25458));
                
                //#line 389 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
                final cassia.util.JSON.JSONException t$25460 = ((new cassia.util.JSON.JSONException(t$25459)));
                
                //#line 389 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
                throw t$25460;
            }
        }
        
        
        //#line 393 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
        public int toInt$O() {
            
            //#line 394 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
            try {{
                
                //#line 395 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
                final java.lang.Object t$25461 = ((this.value));
                
                //#line 395 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
                final java.lang.String t$25462 = x10.rtt.Types.<java.lang.String> castConversion(t$25461,x10.rtt.Types.STRING);
                
                //#line 395 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
                final int t$25463 = java.lang.Integer.parseInt(t$25462);
                
                //#line 395 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
                return t$25463;
            }}catch (final java.lang.RuntimeException id$40) {
                
                //#line 397 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
                final java.lang.String t$25464 = this.getExInfo();
                
                //#line 397 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
                final java.lang.String t$25465 = (("Cannot cast to Int: ") + (t$25464));
                
                //#line 397 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
                final cassia.util.JSON.JSONException t$25466 = ((cassia.util.JSON.JSONException)(new cassia.util.JSON.JSONException(t$25465)));
                
                //#line 397 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
                throw t$25466;
            }
        }
        
        
        //#line 401 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
        public long toLong$O() {
            
            //#line 402 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
            try {{
                
                //#line 403 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
                final java.lang.Object t$25467 = ((java.lang.Object)(this.value));
                
                //#line 403 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
                final java.lang.String t$25468 = x10.rtt.Types.<java.lang.String> castConversion(t$25467,x10.rtt.Types.STRING);
                
                //#line 403 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
                final long t$25469 = java.lang.Long.parseLong(t$25468);
                
                //#line 403 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
                return t$25469;
            }}catch (final java.lang.RuntimeException id$41) {
                
                //#line 405 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
                final java.lang.String t$25470 = this.getExInfo();
                
                //#line 405 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
                final java.lang.String t$25471 = (("Cannot cast to Long: ") + (t$25470));
                
                //#line 405 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
                final cassia.util.JSON.JSONException t$25472 = ((cassia.util.JSON.JSONException)(new cassia.util.JSON.JSONException(t$25471)));
                
                //#line 405 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
                throw t$25472;
            }
        }
        
        
        //#line 409 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
        public double toDouble$O() {
            
            //#line 410 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
            try {{
                
                //#line 411 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
                final java.lang.Object t$25473 = ((java.lang.Object)(this.value));
                
                //#line 411 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
                final java.lang.String t$25474 = x10.rtt.Types.<java.lang.String> castConversion(t$25473,x10.rtt.Types.STRING);
                
                //#line 411 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
                final double t$25475 = java.lang.Double.parseDouble(t$25474);
                
                //#line 411 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
                return t$25475;
            }}catch (final java.lang.RuntimeException id$42) {
                
                //#line 413 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
                final java.lang.String t$25476 = this.getExInfo();
                
                //#line 413 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
                final java.lang.String t$25477 = (("Cannot cast to Double: ") + (t$25476));
                
                //#line 413 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
                final cassia.util.JSON.JSONException t$25478 = ((cassia.util.JSON.JSONException)(new cassia.util.JSON.JSONException(t$25477)));
                
                //#line 413 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
                throw t$25478;
            }
        }
        
        
        //#line 417 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
        public cassia.util.JSON.Value clone() {
            
            //#line 418 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
            java.lang.Object value = this.value;
            
            //#line 419 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
            final boolean t$25482 = this.isList$O();
            
            //#line 419 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
            if (t$25482) {
                
                //#line 420 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
                final x10.util.List a = this.asList();
                
                //#line 421 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
                final x10.util.ArrayList h = ((x10.util.ArrayList)(new x10.util.ArrayList<cassia.util.JSON.Value>((java.lang.System[]) null, cassia.util.JSON.Value.$RTT).x10$util$ArrayList$$init$S()));
                
                //#line 422 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
                final x10.util.ListIterator item$25840 = ((x10.util.ListIterator<cassia.util.JSON.Value>)
                                                           ((x10.util.List<cassia.util.JSON.Value>)a).iterator());
                
                //#line 422 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
                for (;
                     true;
                     ) {
                    
                    //#line 422 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
                    final boolean t$25841 = ((x10.util.ListIterator<cassia.util.JSON.Value>)item$25840).hasNext$O();
                    
                    //#line 422 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
                    if (!(t$25841)) {
                        
                        //#line 422 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
                        break;
                    }
                    
                    //#line 422 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
                    final cassia.util.JSON.Value item$25838 = ((cassia.util.JSON.Value)(((x10.util.ListIterator<cassia.util.JSON.Value>)item$25840).next$G()));
                    
                    //#line 422 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
                    final cassia.util.JSON.Value t$25839 = item$25838.clone();
                    
                    //#line 422 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
                    ((x10.util.ArrayList<cassia.util.JSON.Value>)h).add__0x10$util$ArrayList$$T$O(((cassia.util.JSON.Value)(t$25839)));
                }
                
                //#line 423 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
                value = ((java.lang.Object)(h));
            }
            
            //#line 425 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
            final boolean t$25488 = this.isMap$O();
            
            //#line 425 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
            if (t$25488) {
                
                //#line 426 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
                final x10.util.Map a = this.asMap();
                
                //#line 427 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
                final x10.util.HashMap h = ((x10.util.HashMap)(new x10.util.HashMap<java.lang.String, cassia.util.JSON.Value>((java.lang.System[]) null, x10.rtt.Types.STRING, cassia.util.JSON.Value.$RTT).x10$util$HashMap$$init$S()));
                
                //#line 428 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
                final x10.util.Set t$25845 = ((x10.util.Set<java.lang.String>)
                                               ((x10.util.Map<java.lang.String, cassia.util.JSON.Value>)a).keySet());
                
                //#line 428 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
                final x10.lang.Iterator key$25846 = ((x10.lang.Iterator<java.lang.String>)
                                                      ((x10.lang.Iterable<java.lang.String>)t$25845).iterator());
                
                //#line 428 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
                for (;
                     true;
                     ) {
                    
                    //#line 428 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
                    final boolean t$25847 = ((x10.lang.Iterator<java.lang.String>)key$25846).hasNext$O();
                    
                    //#line 428 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
                    if (!(t$25847)) {
                        
                        //#line 428 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
                        break;
                    }
                    
                    //#line 428 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
                    final java.lang.String key$25842 = ((java.lang.String)(((x10.lang.Iterator<java.lang.String>)key$25846).next$G()));
                    
                    //#line 428 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
                    final cassia.util.JSON.Value t$25843 = ((cassia.util.JSON.Value)
                                                             ((x10.util.Map<java.lang.String, cassia.util.JSON.Value>)a).$apply(((java.lang.String)(key$25842)), x10.rtt.Types.STRING));
                    
                    //#line 428 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
                    final cassia.util.JSON.Value t$25844 = t$25843.clone();
                    
                    //#line 428 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
                    ((x10.util.HashMap<java.lang.String, cassia.util.JSON.Value>)h).$set__0x10$util$HashMap$$K__1x10$util$HashMap$$V$G(((java.lang.String)(key$25842)), ((cassia.util.JSON.Value)(t$25844)));
                }
                
                //#line 429 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
                value = ((java.lang.Object)(h));
            }
            
            //#line 431 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
            final java.lang.Object t$25489 = ((java.lang.Object)(value));
            
            //#line 431 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
            final cassia.util.JSON.Reader t$25490 = ((cassia.util.JSON.Reader)(this.p));
            
            //#line 431 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
            final int t$25491 = this.i;
            
            //#line 431 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
            final cassia.util.JSON.Value t$25492 = ((cassia.util.JSON.Value)(new cassia.util.JSON.Value((java.lang.System[]) null).cassia$util$JSON$Value$$init$S(t$25489, t$25490, t$25491)));
            
            //#line 431 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
            return t$25492;
        }
        
        
        //#line 59 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
        final public cassia.util.JSON.Value cassia$util$JSON$Value$$this$cassia$util$JSON$Value() {
            
            //#line 59 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
            return cassia.util.JSON.Value.this;
        }
        
        
        //#line 59 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
        final public void __fieldInitializers_cassia_util_JSON_Value() {
            
            //#line 59 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
            this.value = null;
            
            //#line 59 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
            this.p = null;
            
            //#line 59 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
            this.i = 0;
        }
    }
    
    
    //#line 435 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
    @x10.runtime.impl.java.X10Generated
    public static class Reader extends x10.core.Ref implements x10.serialization.X10JavaSerializable
    {
        public static final x10.rtt.RuntimeType<Reader> $RTT = 
            x10.rtt.NamedType.<Reader> make("cassia.util.JSON.Reader",
                                            Reader.class);
        
        public x10.rtt.RuntimeType<?> $getRTT() { return $RTT; }
        
        public x10.rtt.Type<?> $getParam(int i) { return null; }
        
        private Object writeReplace() throws java.io.ObjectStreamException {
            return new x10.serialization.SerializationProxy(this);
        }
        
        public static x10.serialization.X10JavaSerializable $_deserialize_body(cassia.util.JSON.Reader $_obj, x10.serialization.X10JavaDeserializer $deserializer) throws java.io.IOException {
            if (x10.runtime.impl.java.Runtime.TRACE_SER) { x10.runtime.impl.java.Runtime.printTraceMessage("X10JavaSerializable: $_deserialize_body() of " + Reader.class + " calling"); } 
            $_obj.i = $deserializer.readInt();
            $_obj.text = $deserializer.readObject();
            return $_obj;
        }
        
        public static x10.serialization.X10JavaSerializable $_deserializer(x10.serialization.X10JavaDeserializer $deserializer) throws java.io.IOException {
            cassia.util.JSON.Reader $_obj = new cassia.util.JSON.Reader((java.lang.System[]) null);
            $deserializer.record_reference($_obj);
            return $_deserialize_body($_obj, $deserializer);
        }
        
        public void $_serialize(x10.serialization.X10JavaSerializer $serializer) throws java.io.IOException {
            $serializer.write(this.i);
            $serializer.write(this.text);
            
        }
        
        // constructor just for allocation
        public Reader(final java.lang.System[] $dummy) {
            
        }
        
        
    
        
        //#line 437 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
        public java.lang.String text;
        
        //#line 438 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
        public int i;
        
        
        //#line 440 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
        // creation method for java code (1-phase java constructor)
        public Reader(final java.lang.String text) {
            this((java.lang.System[]) null);
            cassia$util$JSON$Reader$$init$S(text);
        }
        
        // constructor for non-virtual call
        final public cassia.util.JSON.Reader cassia$util$JSON$Reader$$init$S(final java.lang.String text) {
             {
                
                //#line 440 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
                
                
                //#line 435 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
                this.__fieldInitializers_cassia_util_JSON_Reader();
                
                //#line 441 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
                this.text = ((java.lang.String)(text));
                
                //#line 442 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
                this.i = 0;
            }
            return this;
        }
        
        
        
        //#line 445 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
        public char get$O() {
            
            //#line 446 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
            final java.lang.String t$25493 = ((java.lang.String)(this.text));
            
            //#line 446 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
            final int t$25494 = this.i;
            
            //#line 446 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
            final char t$25495 = (t$25493).charAt(((int)(t$25494)));
            
            //#line 446 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
            return t$25495;
        }
        
        
        //#line 449 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
        public void next() {
            
            //#line 450 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
            final int t$25496 = this.i;
            
            //#line 450 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
            final int t$25497 = ((t$25496) + (((int)(1))));
            
            //#line 450 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
            this.i = t$25497;
        }
        
        
        //#line 453 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
        public java.lang.String toString(final int i) {
            
            //#line 454 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
            final java.lang.String t$25502 = ((java.lang.String)(this.text));
            
            //#line 454 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
            final int t$25498 = ((i) - (((int)(20))));
            
            //#line 454 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
            final int t$25503 = java.lang.Math.max(((int)(0)),((int)(t$25498)));
            
            //#line 454 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
            final int t$25500 = ((i) + (((int)(20))));
            
            //#line 454 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
            final java.lang.String t$25499 = ((java.lang.String)(this.text));
            
            //#line 454 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
            final int t$25501 = (t$25499).length();
            
            //#line 454 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
            final int t$25504 = java.lang.Math.min(((int)(t$25500)),((int)(t$25501)));
            
            //#line 454 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
            final java.lang.String t$25505 = (t$25502).substring(((int)(t$25503)), ((int)(t$25504)));
            
            //#line 454 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
            return t$25505;
        }
        
        
        //#line 435 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
        final public cassia.util.JSON.Reader cassia$util$JSON$Reader$$this$cassia$util$JSON$Reader() {
            
            //#line 435 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
            return cassia.util.JSON.Reader.this;
        }
        
        
        //#line 435 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
        final public void __fieldInitializers_cassia_util_JSON_Reader() {
            
            //#line 435 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
            this.text = null;
            
            //#line 435 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
            this.i = 0;
        }
    }
    
    
    //#line 458 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
    @x10.runtime.impl.java.X10Generated
    public static class JSONException extends java.lang.RuntimeException implements x10.serialization.X10JavaSerializable
    {
        public static final x10.rtt.RuntimeType<JSONException> $RTT = 
            x10.rtt.NamedType.<JSONException> make("cassia.util.JSON.JSONException",
                                                   JSONException.class,
                                                   new x10.rtt.Type[] {
                                                       x10.rtt.Types.EXCEPTION
                                                   });
        
        public x10.rtt.RuntimeType<?> $getRTT() { return $RTT; }
        
        public x10.rtt.Type<?> $getParam(int i) { return null; }
        
        private Object writeReplace() throws java.io.ObjectStreamException {
            return new x10.serialization.SerializationProxy(this);
        }
        
        public static x10.serialization.X10JavaSerializable $_deserialize_body(cassia.util.JSON.JSONException $_obj, x10.serialization.X10JavaDeserializer $deserializer) throws java.io.IOException {
            if (x10.runtime.impl.java.Runtime.TRACE_SER) { x10.runtime.impl.java.Runtime.printTraceMessage("X10JavaSerializable: $_deserialize_body() of " + JSONException.class + " calling"); } 
            $deserializer.deserializeFieldsStartingFromClass(java.lang.RuntimeException.class, $_obj, 0);
            return $_obj;
        }
        
        public static x10.serialization.X10JavaSerializable $_deserializer(x10.serialization.X10JavaDeserializer $deserializer) throws java.io.IOException {
            cassia.util.JSON.JSONException $_obj = new cassia.util.JSON.JSONException((java.lang.System[]) null);
            $deserializer.record_reference($_obj);
            return $_deserialize_body($_obj, $deserializer);
        }
        
        public void $_serialize(x10.serialization.X10JavaSerializer $serializer) throws java.io.IOException {
            $serializer.serializeFieldsStartingFromClass(this, java.lang.RuntimeException.class);
            
        }
        
        // constructor just for allocation
        public JSONException(final java.lang.System[] $dummy) {
            
        }
        
        
    
        
        
        //#line 460 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
        public JSONException(final java.lang.String s) {
            super(((java.lang.String)(s)));
             {
                
                //#line 460 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
                
                
                //#line 458 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
                this.__fieldInitializers_cassia_util_JSON_JSONException();
            }
        }
        
        
        
        //#line 464 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
        public JSONException(final cassia.util.JSON.Reader p) {
            super(p.toString((int)(p.i)));
             {
                
                //#line 464 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
                
                
                //#line 458 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
                this.__fieldInitializers_cassia_util_JSON_JSONException();
            }
        }
        
        
        
        //#line 458 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
        final public cassia.util.JSON.JSONException cassia$util$JSON$JSONException$$this$cassia$util$JSON$JSONException() {
            
            //#line 458 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
            return cassia.util.JSON.JSONException.this;
        }
        
        
        //#line 458 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
        final public void __fieldInitializers_cassia_util_JSON_JSONException() {
            
        }
    }
    
    
    
    //#line 469 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
    public static boolean isJSONLetter$O(final cassia.util.JSON.Reader p) {
        
        //#line 470 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
        final char c = p.get$O();
        
        //#line 471 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
        boolean t$25506 = java.lang.Character.isLetter(c);
        
        //#line 471 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
        if (!(t$25506)) {
            
            //#line 471 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
            t$25506 = java.lang.Character.isDigit(c);
        }
        
        //#line 471 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
        boolean t$25507 = t$25506;
        
        //#line 471 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
        if (!(t$25507)) {
            
            //#line 471 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
            t$25507 = ((char) c) == ((char) '_');
        }
        
        //#line 471 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
        boolean t$25508 = t$25507;
        
        //#line 471 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
        if (!(t$25508)) {
            
            //#line 471 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
            t$25508 = ((char) c) == ((char) '.');
        }
        
        //#line 471 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
        boolean t$25509 = t$25508;
        
        //#line 471 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
        if (!(t$25509)) {
            
            //#line 471 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
            t$25509 = ((char) c) == ((char) '+');
        }
        
        //#line 471 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
        boolean t$25510 = t$25509;
        
        //#line 471 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
        if (!(t$25510)) {
            
            //#line 471 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
            t$25510 = ((char) c) == ((char) '-');
        }
        
        //#line 471 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
        final boolean t$25511 = t$25510;
        
        //#line 471 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
        return t$25511;
    }
    
    
    //#line 474 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
    public static boolean isJSONQuote$O(final cassia.util.JSON.Reader p) {
        
        //#line 475 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
        final char c = p.get$O();
        
        //#line 476 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
        boolean t$25512 = ((char) c) == ((char) '\"');
        
        //#line 476 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
        if (!(t$25512)) {
            
            //#line 476 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
            t$25512 = ((char) c) == ((char) '\'');
        }
        
        //#line 476 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
        final boolean t$25513 = t$25512;
        
        //#line 476 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
        return t$25513;
    }
    
    
    //#line 479 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
    public static void skipSpaces(final cassia.util.JSON.Reader p) {
        
        //#line 480 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
        while (true) {
            
            //#line 480 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
            final char t$25514 = p.get$O();
            
            //#line 480 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
            final boolean t$25515 = java.lang.Character.isWhitespace(t$25514);
            
            //#line 480 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
            if (!(t$25515)) {
                
                //#line 480 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
                break;
            }
            
            //#line 481 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
            p.next();
        }
    }
    
    
    //#line 485 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
    public static java.lang.String parseLiteral(final cassia.util.JSON.Reader p) {
        
        //#line 486 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
        final int b = p.i;
        
        //#line 488 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
        while (true) {
            
            //#line 488 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
            final boolean t$25520 = cassia.util.JSON.isJSONLetter$O(((cassia.util.JSON.Reader)(p)));
            
            //#line 488 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
            if (!(t$25520)) {
                
                //#line 488 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
                break;
            }
            
            //#line 489 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
            p.next();
            
            //#line 490 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
            final int t$25848 = p.i;
            
            //#line 490 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
            final java.lang.String t$25849 = ((java.lang.String)(p.text));
            
            //#line 490 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
            final int t$25850 = (t$25849).length();
            
            //#line 490 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
            final boolean t$25851 = ((t$25848) >= (((int)(t$25850))));
            
            //#line 490 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
            if (t$25851) {
                
                //#line 491 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
                break;
            }
        }
        
        //#line 494 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
        final int t$25521 = p.i;
        
        //#line 494 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
        final boolean t$25523 = ((int) b) == ((int) t$25521);
        
        //#line 494 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
        if (t$25523) {
            
            //#line 495 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
            final cassia.util.JSON.JSONException t$25522 = ((cassia.util.JSON.JSONException)(new cassia.util.JSON.JSONException(((cassia.util.JSON.Reader)(p)))));
            
            //#line 495 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
            throw t$25522;
        }
        
        //#line 497 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
        final java.lang.String t$25524 = ((java.lang.String)(p.text));
        
        //#line 497 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
        final int t$25525 = p.i;
        
        //#line 497 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
        final java.lang.String t$25526 = (t$25524).substring(((int)(b)), ((int)(t$25525)));
        
        //#line 497 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
        return t$25526;
    }
    
    
    //#line 500 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
    public static java.lang.String parseString(final cassia.util.JSON.Reader p) {
        
        //#line 501 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
        final char quote = p.get$O();
        
        //#line 502 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
        final boolean t$25528 = cassia.util.JSON.isJSONQuote$O(((cassia.util.JSON.Reader)(p)));
        
        //#line 502 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
        if (t$25528) {
            
            //#line 503 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
            p.next();
        } else {
            
            //#line 505 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
            final cassia.util.JSON.JSONException t$25527 = ((cassia.util.JSON.JSONException)(new cassia.util.JSON.JSONException(((cassia.util.JSON.Reader)(p)))));
            
            //#line 505 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
            throw t$25527;
        }
        
        //#line 508 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
        final int b = p.i;
        
        //#line 510 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
        while (true) {
            
            //#line 510 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
            final int t$25530 = p.i;
            
            //#line 510 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
            final java.lang.String t$25529 = ((java.lang.String)(p.text));
            
            //#line 510 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
            final int t$25531 = (t$25529).length();
            
            //#line 510 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
            final boolean t$25534 = ((t$25530) < (((int)(t$25531))));
            
            //#line 510 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
            if (!(t$25534)) {
                
                //#line 510 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
                break;
            }
            
            //#line 511 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
            final char t$25852 = p.get$O();
            
            //#line 511 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
            final boolean t$25853 = ((char) t$25852) == ((char) quote);
            
            //#line 511 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
            if (t$25853) {
                
                //#line 512 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
                p.next();
                
                //#line 513 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
                break;
            } else {
                
                //#line 515 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
                p.next();
            }
        }
        
        //#line 518 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
        assert ((p.i) <= (((int)((p.text).length()))));
        
        //#line 519 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
        final java.lang.String t$25536 = ((java.lang.String)(p.text));
        
        //#line 519 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
        final int t$25535 = p.i;
        
        //#line 519 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
        final int t$25537 = ((t$25535) - (((int)(1))));
        
        //#line 519 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
        final java.lang.String t$25538 = (t$25536).substring(((int)(b)), ((int)(t$25537)));
        
        //#line 519 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
        return t$25538;
    }
    
    
    //#line 522 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
    public static java.lang.Object parseValue(final cassia.util.JSON.Reader p) {
        
        //#line 523 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
        final char t$25539 = p.get$O();
        
        //#line 523 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
        final boolean t$25547 = ((char) t$25539) == ((char) '{');
        
        //#line 523 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
        if (t$25547) {
            
            //#line 524 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
            final x10.util.Map t$25540 = cassia.util.JSON.parseObject(((cassia.util.JSON.Reader)(p)));
            
            //#line 524 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
            return t$25540;
        } else {
            
            //#line 525 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
            final char t$25541 = p.get$O();
            
            //#line 525 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
            final boolean t$25546 = ((char) t$25541) == ((char) '[');
            
            //#line 525 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
            if (t$25546) {
                
                //#line 526 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
                final x10.util.List t$25542 = cassia.util.JSON.parseArray(((cassia.util.JSON.Reader)(p)));
                
                //#line 526 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
                return t$25542;
            } else {
                
                //#line 527 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
                final boolean t$25545 = cassia.util.JSON.isJSONQuote$O(((cassia.util.JSON.Reader)(p)));
                
                //#line 527 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
                if (t$25545) {
                    
                    //#line 528 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
                    final java.lang.String t$25543 = cassia.util.JSON.parseString(((cassia.util.JSON.Reader)(p)));
                    
                    //#line 528 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
                    return ((java.lang.Object)
                             (t$25543));
                } else {
                    
                    //#line 530 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
                    final java.lang.String t$25544 = cassia.util.JSON.parseLiteral(((cassia.util.JSON.Reader)(p)));
                    
                    //#line 530 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
                    return ((java.lang.Object)
                             (t$25544));
                }
            }
        }
    }
    
    
    //#line 534 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
    public static java.lang.String parseName(final cassia.util.JSON.Reader p) {
        
        //#line 535 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
        final boolean t$25550 = cassia.util.JSON.isJSONQuote$O(((cassia.util.JSON.Reader)(p)));
        
        //#line 535 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
        if (t$25550) {
            
            //#line 536 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
            final java.lang.String t$25548 = cassia.util.JSON.parseString(((cassia.util.JSON.Reader)(p)));
            
            //#line 536 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
            return t$25548;
        } else {
            
            //#line 538 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
            final java.lang.String t$25549 = cassia.util.JSON.parseLiteral(((cassia.util.JSON.Reader)(p)));
            
            //#line 538 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
            return t$25549;
        }
    }
    
    
    //#line 542 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
    public static x10.util.Map parseObject(final cassia.util.JSON.Reader p) {
        
        //#line 543 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
        final x10.util.HashMap a = ((x10.util.HashMap)(new x10.util.HashMap<java.lang.String, cassia.util.JSON.Value>((java.lang.System[]) null, x10.rtt.Types.STRING, cassia.util.JSON.Value.$RTT).x10$util$HashMap$$init$S()));
        
        //#line 545 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
        final char t$25551 = p.get$O();
        
        //#line 545 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
        final boolean t$25553 = ((char) t$25551) == ((char) '{');
        
        //#line 545 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
        if (t$25553) {
            
            //#line 546 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
            p.next();
        } else {
            
            //#line 548 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
            final cassia.util.JSON.JSONException t$25552 = ((cassia.util.JSON.JSONException)(new cassia.util.JSON.JSONException(((cassia.util.JSON.Reader)(p)))));
            
            //#line 548 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
            throw t$25552;
        }
        
        //#line 551 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
        cassia.util.JSON.skipSpaces(((cassia.util.JSON.Reader)(p)));
        
        //#line 552 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
        final char t$25554 = p.get$O();
        
        //#line 552 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
        final boolean t$25555 = ((char) t$25554) == ((char) '}');
        
        //#line 552 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
        if (t$25555) {
            
            //#line 553 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
            p.next();
            
            //#line 554 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
            return a;
        }
        
        //#line 557 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
        while (true) {
            
            //#line 558 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
            cassia.util.JSON.skipSpaces(((cassia.util.JSON.Reader)(p)));
            
            //#line 559 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
            final java.lang.String s = cassia.util.JSON.parseName(((cassia.util.JSON.Reader)(p)));
            
            //#line 561 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
            cassia.util.JSON.skipSpaces(((cassia.util.JSON.Reader)(p)));
            
            //#line 562 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
            final char t$25556 = p.get$O();
            
            //#line 562 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
            final boolean t$25558 = ((char) t$25556) == ((char) ':');
            
            //#line 562 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
            if (t$25558) {
                
                //#line 563 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
                p.next();
            } else {
                
                //#line 565 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
                final cassia.util.JSON.JSONException t$25557 = ((cassia.util.JSON.JSONException)(new cassia.util.JSON.JSONException(((cassia.util.JSON.Reader)(p)))));
                
                //#line 565 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
                throw t$25557;
            }
            
            //#line 568 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
            cassia.util.JSON.skipSpaces(((cassia.util.JSON.Reader)(p)));
            
            //#line 569 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
            final int i = p.i;
            
            //#line 570 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
            final java.lang.Object v = cassia.util.JSON.parseValue(((cassia.util.JSON.Reader)(p)));
            
            //#line 572 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
            final cassia.util.JSON.Value t$25559 = ((cassia.util.JSON.Value)(new cassia.util.JSON.Value((java.lang.System[]) null).cassia$util$JSON$Value$$init$S(((java.lang.Object)(v)), ((cassia.util.JSON.Reader)(p)), ((int)(i)))));
            
            //#line 572 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
            ((x10.util.HashMap<java.lang.String, cassia.util.JSON.Value>)a).put__0x10$util$HashMap$$K__1x10$util$HashMap$$V$G(((java.lang.String)(s)), ((cassia.util.JSON.Value)(t$25559)));
            
            //#line 574 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
            cassia.util.JSON.skipSpaces(((cassia.util.JSON.Reader)(p)));
            
            //#line 575 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
            final char t$25560 = p.get$O();
            
            //#line 575 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
            final boolean t$25561 = ((char) t$25560) == ((char) ',');
            
            //#line 575 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
            if (t$25561) {
                
                //#line 576 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
                p.next();
            } else {
                
                //#line 578 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
                break;
            }
        }
        
        //#line 582 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
        cassia.util.JSON.skipSpaces(((cassia.util.JSON.Reader)(p)));
        
        //#line 583 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
        final char t$25562 = p.get$O();
        
        //#line 583 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
        final boolean t$25564 = ((char) t$25562) == ((char) '}');
        
        //#line 583 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
        if (t$25564) {
            
            //#line 584 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
            p.next();
        } else {
            
            //#line 586 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
            final cassia.util.JSON.JSONException t$25563 = ((cassia.util.JSON.JSONException)(new cassia.util.JSON.JSONException(((cassia.util.JSON.Reader)(p)))));
            
            //#line 586 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
            throw t$25563;
        }
        
        //#line 588 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
        return a;
    }
    
    
    //#line 591 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
    public static x10.util.List parseArray(final cassia.util.JSON.Reader p) {
        
        //#line 592 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
        final x10.util.ArrayList a = ((x10.util.ArrayList)(new x10.util.ArrayList<cassia.util.JSON.Value>((java.lang.System[]) null, cassia.util.JSON.Value.$RTT).x10$util$ArrayList$$init$S()));
        
        //#line 594 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
        final char t$25565 = p.get$O();
        
        //#line 594 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
        final boolean t$25567 = ((char) t$25565) == ((char) '[');
        
        //#line 594 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
        if (t$25567) {
            
            //#line 595 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
            p.next();
        } else {
            
            //#line 597 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
            final cassia.util.JSON.JSONException t$25566 = ((cassia.util.JSON.JSONException)(new cassia.util.JSON.JSONException(((cassia.util.JSON.Reader)(p)))));
            
            //#line 597 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
            throw t$25566;
        }
        
        //#line 600 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
        cassia.util.JSON.skipSpaces(((cassia.util.JSON.Reader)(p)));
        
        //#line 601 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
        final char t$25568 = p.get$O();
        
        //#line 601 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
        final boolean t$25569 = ((char) t$25568) == ((char) ']');
        
        //#line 601 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
        if (t$25569) {
            
            //#line 602 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
            p.next();
            
            //#line 603 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
            return a;
        }
        
        //#line 606 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
        while (true) {
            
            //#line 607 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
            cassia.util.JSON.skipSpaces(((cassia.util.JSON.Reader)(p)));
            
            //#line 608 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
            final int i = p.i;
            
            //#line 609 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
            final java.lang.Object v = cassia.util.JSON.parseValue(((cassia.util.JSON.Reader)(p)));
            
            //#line 611 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
            final cassia.util.JSON.Value t$25570 = ((cassia.util.JSON.Value)(new cassia.util.JSON.Value((java.lang.System[]) null).cassia$util$JSON$Value$$init$S(((java.lang.Object)(v)), ((cassia.util.JSON.Reader)(p)), ((int)(i)))));
            
            //#line 611 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
            ((x10.util.ArrayList<cassia.util.JSON.Value>)a).add__0x10$util$ArrayList$$T$O(((cassia.util.JSON.Value)(t$25570)));
            
            //#line 613 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
            cassia.util.JSON.skipSpaces(((cassia.util.JSON.Reader)(p)));
            
            //#line 614 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
            final char t$25571 = p.get$O();
            
            //#line 614 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
            final boolean t$25572 = ((char) t$25571) == ((char) ',');
            
            //#line 614 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
            if (t$25572) {
                
                //#line 615 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
                p.next();
            } else {
                
                //#line 617 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
                break;
            }
        }
        
        //#line 621 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
        cassia.util.JSON.skipSpaces(((cassia.util.JSON.Reader)(p)));
        
        //#line 622 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
        final char t$25573 = p.get$O();
        
        //#line 622 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
        final boolean t$25575 = ((char) t$25573) == ((char) ']');
        
        //#line 622 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
        if (t$25575) {
            
            //#line 623 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
            p.next();
        } else {
            
            //#line 625 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
            final cassia.util.JSON.JSONException t$25574 = ((cassia.util.JSON.JSONException)(new cassia.util.JSON.JSONException(((cassia.util.JSON.Reader)(p)))));
            
            //#line 625 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
            throw t$25574;
        }
        
        //#line 627 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
        return a;
    }
    
    
    //#line 633 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
    /**
	 * Parse the string and compose a JSON object.
	 */
    public static cassia.util.JSON.Value parse(final java.lang.String text) {
        
        //#line 634 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
        final cassia.util.JSON.Reader p = ((cassia.util.JSON.Reader)(new cassia.util.JSON.Reader((java.lang.System[]) null).cassia$util$JSON$Reader$$init$S(((java.lang.String)(text)))));
        
        //#line 635 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
        cassia.util.JSON.skipSpaces(((cassia.util.JSON.Reader)(p)));
        
        //#line 636 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
        final int i = p.i;
        
        //#line 637 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
        final java.lang.Object v = cassia.util.JSON.parseValue(((cassia.util.JSON.Reader)(p)));
        
        //#line 638 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
        final cassia.util.JSON.Value t$25576 = ((cassia.util.JSON.Value)(new cassia.util.JSON.Value((java.lang.System[]) null).cassia$util$JSON$Value$$init$S(((java.lang.Object)(v)), ((cassia.util.JSON.Reader)(p)), ((int)(i)))));
        
        //#line 638 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
        return t$25576;
    }
    
    
    //#line 644 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
    /**
	 * Parse the file and compose a JSON object.
	 */
    public static cassia.util.JSON.Value parse(final x10.io.File file) {
        
        //#line 645 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
        final x10.util.StringBuilder s = ((x10.util.StringBuilder)(new x10.util.StringBuilder((java.lang.System[]) null).x10$util$StringBuilder$$init$S()));
        
        //#line 646 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
        final x10.io.ReaderIterator t$25855 = file.lines();
        
        //#line 646 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
        final x10.lang.Iterator line$25856 = ((x10.lang.Iterator<java.lang.String>)
                                               ((x10.io.ReaderIterator<java.lang.String>)t$25855).iterator());
        
        //#line 646 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
        for (;
             true;
             ) {
            
            //#line 646 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
            final boolean t$25857 = ((x10.lang.Iterator<java.lang.String>)line$25856).hasNext$O();
            
            //#line 646 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
            if (!(t$25857)) {
                
                //#line 646 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
                break;
            }
            
            //#line 646 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
            final java.lang.String line$25854 = ((java.lang.String)(((x10.lang.Iterator<java.lang.String>)line$25856).next$G()));
            
            //#line 647 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
            s.add(((java.lang.String)(line$25854)));
            
            //#line 648 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
            s.add(((java.lang.String)(" ")));
        }
        
        //#line 650 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
        final java.lang.String t$25580 = s.toString();
        
        //#line 650 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
        final cassia.util.JSON.Value t$25581 = ((cassia.util.JSON.Value)(cassia.util.JSON.parse(((java.lang.String)(t$25580)))));
        
        //#line 650 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
        return t$25581;
    }
    
    
    //#line 653 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
    private static void _extendChain__2$1x10$lang$String$3cassia$util$JSON$Value$2(final cassia.util.JSON.Value root, final cassia.util.JSON.Value focus, final x10.util.HashMap<java.lang.String, cassia.util.JSON.Value> out) {
        
        //#line 654 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
        final boolean t$25582 = focus.isMap$O();
        
        //#line 654 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
        final boolean t$25583 = !(t$25582);
        
        //#line 654 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
        if (t$25583) {
            
            //#line 655 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
            return;
        }
        
        //#line 657 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
        final boolean t$25585 = ((cassia.util.JSON.Value)focus).<java.lang.String> has__0cassia$util$JSON$Value$$T$O(x10.rtt.Types.STRING, ((java.lang.String)("extends")));
        
        //#line 657 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
        if (t$25585) {
            
            //#line 658 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
            final cassia.util.JSON.Value child = ((cassia.util.JSON.Value)focus).<java.lang.String> get(x10.rtt.Types.STRING, ((java.lang.String)("extends")));
            
            //#line 659 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
            final cassia.util.JSON.Value t$25584 = ((cassia.util.JSON.Value)root).<cassia.util.JSON.Value> get(cassia.util.JSON.Value.$RTT, ((cassia.util.JSON.Value)(child)));
            
            //#line 659 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
            cassia.util.JSON._extendChain__2$1x10$lang$String$3cassia$util$JSON$Value$2(((cassia.util.JSON.Value)(root)), ((cassia.util.JSON.Value)(t$25584)), ((x10.util.HashMap)(out)));
        }
        
        //#line 661 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
        final x10.util.Map dict = focus.asMap();
        
        //#line 662 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
        final x10.util.Set t$25860 = ((x10.util.Set<java.lang.String>)
                                       ((x10.util.Map<java.lang.String, cassia.util.JSON.Value>)dict).keySet());
        
        //#line 662 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
        final x10.lang.Iterator key$25861 = ((x10.lang.Iterator<java.lang.String>)
                                              ((x10.lang.Iterable<java.lang.String>)t$25860).iterator());
        
        //#line 662 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
        for (;
             true;
             ) {
            
            //#line 662 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
            final boolean t$25862 = ((x10.lang.Iterator<java.lang.String>)key$25861).hasNext$O();
            
            //#line 662 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
            if (!(t$25862)) {
                
                //#line 662 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
                break;
            }
            
            //#line 662 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
            final java.lang.String key$25858 = ((java.lang.String)(((x10.lang.Iterator<java.lang.String>)key$25861).next$G()));
            
            //#line 663 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
            final cassia.util.JSON.Value t$25859 = ((cassia.util.JSON.Value)
                                                     ((x10.util.Map<java.lang.String, cassia.util.JSON.Value>)dict).$apply(((java.lang.String)(key$25858)), x10.rtt.Types.STRING));
            
            //#line 663 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
            ((x10.util.HashMap<java.lang.String, cassia.util.JSON.Value>)out).$set__0x10$util$HashMap$$K__1x10$util$HashMap$$V$G(((java.lang.String)(key$25858)), ((cassia.util.JSON.Value)(t$25859)));
        }
    }
    
    public static void _extendChain$P__2$1x10$lang$String$3cassia$util$JSON$Value$2(final cassia.util.JSON.Value root, final cassia.util.JSON.Value focus, final x10.util.HashMap<java.lang.String, cassia.util.JSON.Value> out) {
        cassia.util.JSON._extendChain__2$1x10$lang$String$3cassia$util$JSON$Value$2(((cassia.util.JSON.Value)(root)), ((cassia.util.JSON.Value)(focus)), ((x10.util.HashMap)(out)));
    }
    
    
    //#line 672 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
    /**
	 * Handle the "extends" keyword for JSON objects at level/depth = 1
	 * (not recursive).
	 * Modify the JSON.Value object given and return itself.
	 */
    public static cassia.util.JSON.Value extend(final cassia.util.JSON.Value root) {
        
        //#line 673 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
        final boolean t$25590 = root.isMap$O();
        
        //#line 673 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
        final boolean t$25591 = !(t$25590);
        
        //#line 673 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
        if (t$25591) {
            
            //#line 674 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
            return root;
        }
        
        //#line 676 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
        final x10.util.Map t$25863 = root.asMap();
        
        //#line 676 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
        final x10.util.Set t$25864 = ((x10.util.Set<java.lang.String>)
                                       ((x10.util.Map<java.lang.String, cassia.util.JSON.Value>)t$25863).keySet());
        
        //#line 676 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
        final x10.lang.Iterator key$25865 = ((x10.lang.Iterator<java.lang.String>)
                                              ((x10.lang.Iterable<java.lang.String>)t$25864).iterator());
        
        //#line 676 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
        for (;
             true;
             ) {
            
            //#line 676 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
            final boolean t$25866 = ((x10.lang.Iterator<java.lang.String>)key$25865).hasNext$O();
            
            //#line 676 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
            if (!(t$25866)) {
                
                //#line 676 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
                break;
            }
            
            //#line 676 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
            L$25867: {
                
                //#line 676 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
                final java.lang.String key$25868 = ((java.lang.String)(((x10.lang.Iterator<java.lang.String>)key$25865).next$G()));
                //#line 677 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
                final cassia.util.JSON.Value t$25869 = ((cassia.util.JSON.Value)root).<java.lang.String> get(x10.rtt.Types.STRING, ((java.lang.String)(key$25868)));
                //#line 677 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
                final boolean t$25870 = t$25869.isMap$O();
                //#line 677 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
                final boolean t$25871 = !(t$25870);
                //#line 677 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
                if (t$25871) {
                    
                    //#line 678 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
                    break L$25867;
                }
                //#line 680 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
                final cassia.util.JSON.Value t$25872 = ((cassia.util.JSON.Value)root).<java.lang.String> get(x10.rtt.Types.STRING, ((java.lang.String)(key$25868)));
                //#line 680 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
                final boolean t$25873 = ((cassia.util.JSON.Value)t$25872).<java.lang.String> has__0cassia$util$JSON$Value$$T$O(x10.rtt.Types.STRING, ((java.lang.String)("extends")));
                //#line 680 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
                if (t$25873) {
                    
                    //#line 681 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
                    final x10.util.HashMap out$25874 = ((x10.util.HashMap)(new x10.util.HashMap<java.lang.String, cassia.util.JSON.Value>((java.lang.System[]) null, x10.rtt.Types.STRING, cassia.util.JSON.Value.$RTT).x10$util$HashMap$$init$S()));
                    
                    //#line 682 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
                    final cassia.util.JSON.Value t$25875 = ((cassia.util.JSON.Value)root).<java.lang.String> get(x10.rtt.Types.STRING, ((java.lang.String)(key$25868)));
                    
                    //#line 682 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
                    cassia.util.JSON._extendChain__2$1x10$lang$String$3cassia$util$JSON$Value$2(((cassia.util.JSON.Value)(root)), ((cassia.util.JSON.Value)(t$25875)), ((x10.util.HashMap)(out$25874)));
                    
                    //#line 683 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
                    final cassia.util.JSON.Value t$25876 = ((cassia.util.JSON.Value)root).<java.lang.String> get(x10.rtt.Types.STRING, ((java.lang.String)(key$25868)));
                    
                    //#line 683 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
                    t$25876.value = ((java.lang.Object)(out$25874));
                }
            }
        }
        
        //#line 686 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
        return root;
    }
    
    
    //#line 693 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
    /**
	 * Handle the "extends" keyword for JSON objects at all depth.
	 * Modify the JSON.Value object given and return itself.
	 */
    public static cassia.util.JSON.Value extendDeeply(final cassia.util.JSON.Value root, final cassia.util.JSON.Value focus) {
        
        //#line 694 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
        final boolean t$25603 = focus.isMap$O();
        
        //#line 694 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
        final boolean t$25604 = !(t$25603);
        
        //#line 694 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
        if (t$25604) {
            
            //#line 694 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
            return focus;
        }
        
        //#line 695 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
        final x10.util.Map t$25877 = focus.asMap();
        
        //#line 695 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
        final x10.util.Set t$25878 = ((x10.util.Set<x10.util.Map.Entry<java.lang.String, cassia.util.JSON.Value>>)
                                       ((x10.util.Map<java.lang.String, cassia.util.JSON.Value>)t$25877).entries());
        
        //#line 695 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
        final x10.lang.Iterator entry$25879 = ((x10.lang.Iterator<x10.util.Map.Entry<java.lang.String, cassia.util.JSON.Value>>)
                                                ((x10.lang.Iterable<x10.util.Map.Entry<java.lang.String, cassia.util.JSON.Value>>)t$25878).iterator());
        
        //#line 695 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
        for (;
             true;
             ) {
            
            //#line 695 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
            final boolean t$25880 = ((x10.lang.Iterator<x10.util.Map.Entry<java.lang.String, cassia.util.JSON.Value>>)entry$25879).hasNext$O();
            
            //#line 695 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
            if (!(t$25880)) {
                
                //#line 695 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
                break;
            }
            
            //#line 695 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
            L$25881: {
                
                //#line 695 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
                final x10.util.Map.Entry entry$25882 = ((x10.util.Map.Entry)(((x10.lang.Iterator<x10.util.Map.Entry<java.lang.String, cassia.util.JSON.Value>>)entry$25879).next$G()));
                //#line 696 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
                final java.lang.String key$25883 = ((x10.util.Map.Entry<java.lang.String, cassia.util.JSON.Value>)entry$25882).getKey$G();
                //#line 697 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
                final cassia.util.JSON.Value nextFocus$25884 = ((x10.util.Map.Entry<java.lang.String, cassia.util.JSON.Value>)entry$25882).getValue$G();
                //#line 698 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
                final boolean t$25885 = nextFocus$25884.isMap$O();
                //#line 698 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
                final boolean t$25886 = !(t$25885);
                //#line 698 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
                if (t$25886) {
                    
                    //#line 698 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
                    break L$25881;
                }
                //#line 699 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
                final boolean t$25887 = ((cassia.util.JSON.Value)nextFocus$25884).<java.lang.String> has__0cassia$util$JSON$Value$$T$O(x10.rtt.Types.STRING, ((java.lang.String)("extends")));
                //#line 699 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
                if (t$25887) {
                    
                    //#line 700 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
                    final x10.util.HashMap out$25888 = ((x10.util.HashMap)(new x10.util.HashMap<java.lang.String, cassia.util.JSON.Value>((java.lang.System[]) null, x10.rtt.Types.STRING, cassia.util.JSON.Value.$RTT).x10$util$HashMap$$init$S()));
                    
                    //#line 701 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
                    cassia.util.JSON._extendChain__2$1x10$lang$String$3cassia$util$JSON$Value$2(((cassia.util.JSON.Value)(root)), ((cassia.util.JSON.Value)(nextFocus$25884)), ((x10.util.HashMap)(out$25888)));
                    
                    //#line 702 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
                    nextFocus$25884.value = ((java.lang.Object)(out$25888));
                }
                //#line 704 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
                cassia.util.JSON.extendDeeply(((cassia.util.JSON.Value)(root)), ((cassia.util.JSON.Value)(nextFocus$25884)));
            }
        }
        
        //#line 706 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
        return focus;
    }
    
    
    //#line 712 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
    /**
	 * Stringify the JSON object.
	 */
    public static java.lang.String dump(final cassia.util.JSON.Value root) {
        
        //#line 713 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
        final x10.util.StringBuilder s = ((x10.util.StringBuilder)(new x10.util.StringBuilder((java.lang.System[]) null).x10$util$StringBuilder$$init$S()));
        
        //#line 714 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
        final boolean t$25632 = root.isMap$O();
        
        //#line 714 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
        if (t$25632) {
            
            //#line 715 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
            s.add(((java.lang.String)("{")));
            
            //#line 716 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
            final x10.util.Map d = root.asMap();
            
            //#line 717 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
            final long n = ((x10.util.Map<java.lang.String, cassia.util.JSON.Value>)d).size$O();
            
            //#line 718 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
            long i = 0L;
            
            //#line 719 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
            final x10.util.Set t$25897 = ((x10.util.Set<java.lang.String>)
                                           ((x10.util.Map<java.lang.String, cassia.util.JSON.Value>)d).keySet());
            
            //#line 719 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
            final x10.lang.Iterator key$25898 = ((x10.lang.Iterator<java.lang.String>)
                                                  ((x10.lang.Iterable<java.lang.String>)t$25897).iterator());
            
            //#line 719 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
            for (;
                 true;
                 ) {
                
                //#line 719 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
                final boolean t$25899 = ((x10.lang.Iterator<java.lang.String>)key$25898).hasNext$O();
                
                //#line 719 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
                if (!(t$25899)) {
                    
                    //#line 719 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
                    break;
                }
                
                //#line 719 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
                final java.lang.String key$25889 = ((java.lang.String)(((x10.lang.Iterator<java.lang.String>)key$25898).next$G()));
                
                //#line 720 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
                s.add(((java.lang.String)("\"")));
                
                //#line 721 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
                final java.lang.String t$25890 = (key$25889).toString();
                
                //#line 721 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
                s.add(((java.lang.String)(t$25890)));
                
                //#line 722 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
                s.add(((java.lang.String)("\"")));
                
                //#line 723 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
                s.add(((java.lang.String)(":")));
                
                //#line 724 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
                final cassia.util.JSON.Value t$25891 = ((cassia.util.JSON.Value)
                                                         ((x10.util.Map<java.lang.String, cassia.util.JSON.Value>)d).$apply(((java.lang.String)(key$25889)), x10.rtt.Types.STRING));
                
                //#line 724 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
                final java.lang.String t$25892 = cassia.util.JSON.dump(((cassia.util.JSON.Value)(t$25891)));
                
                //#line 724 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
                s.add(((java.lang.String)(t$25892)));
                
                //#line 725 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
                final long t$25893 = i;
                
                //#line 725 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
                final long t$25894 = ((t$25893) + (((long)(1L))));
                
                //#line 725 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
                final long t$25895 = i = t$25894;
                
                //#line 725 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
                final boolean t$25896 = ((t$25895) < (((long)(n))));
                
                //#line 725 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
                if (t$25896) {
                    
                    //#line 726 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
                    s.add(((java.lang.String)(",")));
                }
            }
            
            //#line 729 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
            s.add(((java.lang.String)("}")));
        } else {
            
            //#line 730 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
            final boolean t$25631 = root.isList$O();
            
            //#line 730 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
            if (t$25631) {
                
                //#line 731 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
                s.add(((java.lang.String)("[")));
                
                //#line 732 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
                final x10.util.List a = root.asList();
                
                //#line 733 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
                final long n = ((x10.util.Container<cassia.util.JSON.Value>)a).size$O();
                
                //#line 734 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
                long i = 0L;
                
                //#line 735 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
                final x10.util.ListIterator elem$25906 = ((x10.util.ListIterator<cassia.util.JSON.Value>)
                                                           ((x10.util.List<cassia.util.JSON.Value>)a).iterator());
                
                //#line 735 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
                for (;
                     true;
                     ) {
                    
                    //#line 735 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
                    final boolean t$25907 = ((x10.util.ListIterator<cassia.util.JSON.Value>)elem$25906).hasNext$O();
                    
                    //#line 735 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
                    if (!(t$25907)) {
                        
                        //#line 735 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
                        break;
                    }
                    
                    //#line 735 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
                    final cassia.util.JSON.Value elem$25900 = ((cassia.util.JSON.Value)(((x10.util.ListIterator<cassia.util.JSON.Value>)elem$25906).next$G()));
                    
                    //#line 736 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
                    final java.lang.String t$25901 = cassia.util.JSON.dump(((cassia.util.JSON.Value)(elem$25900)));
                    
                    //#line 736 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
                    s.add(((java.lang.String)(t$25901)));
                    
                    //#line 737 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
                    final long t$25902 = i;
                    
                    //#line 737 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
                    final long t$25903 = ((t$25902) + (((long)(1L))));
                    
                    //#line 737 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
                    final long t$25904 = i = t$25903;
                    
                    //#line 737 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
                    final boolean t$25905 = ((t$25904) < (((long)(n))));
                    
                    //#line 737 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
                    if (t$25905) {
                        
                        //#line 738 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
                        s.add(((java.lang.String)(",")));
                    }
                }
                
                //#line 741 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
                s.add(((java.lang.String)("]")));
            } else {
                
                //#line 743 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
                s.add(((java.lang.String)("\"")));
                
                //#line 744 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
                final java.lang.Object t$25629 = ((java.lang.Object)(root.value));
                
                //#line 744 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
                final java.lang.String t$25630 = x10.rtt.Types.toString(t$25629);
                
                //#line 744 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
                s.add(((java.lang.String)(t$25630)));
                
                //#line 745 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
                s.add(((java.lang.String)("\"")));
            }
        }
        
        //#line 747 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
        final java.lang.String t$25633 = s.toString();
        
        //#line 747 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
        return t$25633;
    }
    
    
    //#line 750 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
    public static class $Main extends x10.runtime.impl.java.Runtime
    {
        // java main method
        public static void main(java.lang.String[] args) {
            // start native runtime
            new $Main().start(args);
        }
        
        // called by native runtime inside main x10 thread
        public void runtimeCallback(final x10.core.Rail<java.lang.String> args) {
            // call the original app-main method
            JSON.main(args);
        }
    }
    
    // the original app-main method
    public static void main(final x10.core.Rail<java.lang.String> args) {
        
        //#line 756 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
        final cassia.util.JSON.Value x$25933 = ((cassia.util.JSON.Value)(cassia.util.JSON.parse(((java.lang.String)("{x: \'x\'}")))));
        
        //#line 757 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
        final cassia.util.JSON.Value prev_x$25934 = x$25933.clone();
        
        //#line 758 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
        final cassia.util.JSON.Value xy$25935 = ((cassia.util.JSON.Value)(cassia.util.JSON.parse(((java.lang.String)("{x: \'x\', y: \'y\'}")))));
        
        //#line 759 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
        assert (cassia.util.JSON.dump(((cassia.util.JSON.Value)(x$25933.apply(((java.lang.String)("y")), ((cassia.util.JSON.Value)(cassia.util.JSON.parse(((java.lang.String)("y")))))))))).equals(cassia.util.JSON.dump(((cassia.util.JSON.Value)(xy$25935))));
        
        //#line 760 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
        assert (cassia.util.JSON.dump(((cassia.util.JSON.Value)(x$25933)))).equals(cassia.util.JSON.dump(((cassia.util.JSON.Value)(prev_x$25934))));
        
        //#line 764 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
        final cassia.util.JSON.Value empty$25936 = ((cassia.util.JSON.Value)(cassia.util.JSON.parse(((java.lang.String)("{}")))));
        
        //#line 765 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
        final long n$25937 = 100L;
        
        //#line 766 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
        final x10.core.Rail key_value_set$25938 = ((x10.core.Rail)(new x10.core.Rail<cassia.util.JSON.Entry>(cassia.util.JSON.Entry.$RTT, ((long)(n$25937)))));
        
        //#line 767 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
        final long i$25290min$25929 = 0L;
        
        //#line 767 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
        final long i$25290max$25930 = 99L;
        
        //#line 767 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
        long i$25916 = i$25290min$25929;
        {
            
            //#line 767 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
            final cassia.util.JSON.Entry[] key_value_set$25938$value$25946 = ((cassia.util.JSON.Entry[])key_value_set$25938.value);
            
            //#line 767 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
            for (;
                 true;
                 ) {
                
                //#line 767 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
                final long t$25917 = i$25916;
                
                //#line 767 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
                final boolean t$25918 = ((t$25917) <= (((long)(i$25290max$25930))));
                
                //#line 767 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
                if (!(t$25918)) {
                    
                    //#line 767 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
                    break;
                }
                
                //#line 767 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
                final long i$25913 = i$25916;
                
                //#line 768 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
                final java.lang.String t$25908 = java.lang.Long.toString(i$25913);
                
                //#line 768 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
                final long t$25909 = ((i$25913) * (((long)(i$25913))));
                
                //#line 768 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
                final java.lang.String t$25910 = java.lang.Long.toString(t$25909);
                
                //#line 768 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
                final cassia.util.JSON.Value t$25911 = ((cassia.util.JSON.Value)(cassia.util.JSON.parse(((java.lang.String)(t$25910)))));
                
                //#line 768 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
                final cassia.util.JSON.Entry t$25912 = ((cassia.util.JSON.Entry)(new cassia.util.JSON.Entry((java.lang.System[]) null).cassia$util$JSON$Entry$$init$S(t$25908, ((cassia.util.JSON.Value)(t$25911)))));
                
                //#line 768 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
                key_value_set$25938$value$25946[(int)i$25913]=t$25912;
                
                //#line 767 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
                final long t$25914 = i$25916;
                
                //#line 767 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
                final long t$25915 = ((t$25914) + (((long)(1L))));
                
                //#line 767 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
                i$25916 = t$25915;
            }
        }
        
        //#line 770 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
        final cassia.util.JSON.Value square_set_$25939 = empty$25936.apply__0$1cassia$util$JSON$Entry$2(((x10.core.Rail)(key_value_set$25938)));
        
        //#line 771 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
        final cassia.util.JSON.Value square_set_$25940 = empty$25936.clone();
        
        //#line 772 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
        final long i$25308min$25931 = 0L;
        
        //#line 772 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
        final long i$25308max$25932 = 99L;
        
        //#line 772 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
        long i$25926 = i$25308min$25931;
        
        //#line 772 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
        for (;
             true;
             ) {
            
            //#line 772 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
            final long t$25927 = i$25926;
            
            //#line 772 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
            final boolean t$25928 = ((t$25927) <= (((long)(i$25308max$25932))));
            
            //#line 772 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
            if (!(t$25928)) {
                
                //#line 772 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
                break;
            }
            
            //#line 772 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
            final long i$25923 = i$25926;
            
            //#line 773 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
            final java.lang.String t$25919 = java.lang.Long.toString(i$25923);
            
            //#line 773 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
            final long t$25920 = ((i$25923) * (((long)(i$25923))));
            
            //#line 773 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
            final java.lang.String t$25921 = java.lang.Long.toString(t$25920);
            
            //#line 773 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
            final cassia.util.JSON.Value t$25922 = ((cassia.util.JSON.Value)(cassia.util.JSON.parse(((java.lang.String)(t$25921)))));
            
            //#line 773 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
            ((cassia.util.JSON.Value)square_set_$25940).<java.lang.String> put__0cassia$util$JSON$Value$$T(x10.rtt.Types.STRING, ((java.lang.String)(t$25919)), ((cassia.util.JSON.Value)(t$25922)));
            
            //#line 772 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
            final long t$25924 = i$25926;
            
            //#line 772 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
            final long t$25925 = ((t$25924) + (((long)(1L))));
            
            //#line 772 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
            i$25926 = t$25925;
        }
        
        //#line 775 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
        assert (cassia.util.JSON.dump(((cassia.util.JSON.Value)(square_set_$25939)))).equals(cassia.util.JSON.dump(((cassia.util.JSON.Value)(square_set_$25940))));
        
        //#line 779 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
        final cassia.util.JSON.Value empty$25941 = ((cassia.util.JSON.Value)(cassia.util.JSON.parse(((java.lang.String)("{}")))));
        
        //#line 780 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
        final cassia.util.JSON.Value json$25942 = ((cassia.util.JSON.Value)(cassia.util.JSON.parse(((java.lang.String)("{foo: {bar: \'baz\'}}")))));
        
        //#line 781 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
        final cassia.util.JSON.Value a$25943 = json$25942.apply(((cassia.util.JSON.Value)(empty$25941)));
        
        //#line 782 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
        assert (cassia.util.JSON.dump(((cassia.util.JSON.Value)(a$25943)))).equals(cassia.util.JSON.dump(((cassia.util.JSON.Value)(json$25942))));
        
        //#line 783 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
        final cassia.util.JSON.Value a$25944 = empty$25941.apply(((cassia.util.JSON.Value)(json$25942)));
        
        //#line 784 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
        assert (cassia.util.JSON.dump(((cassia.util.JSON.Value)(a$25944)))).equals(cassia.util.JSON.dump(((cassia.util.JSON.Value)(json$25942))));
        
        //#line 788 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
        cassia.util.JSON.Value json =  null;
        
        //#line 789 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
        final long t$25653 = ((x10.core.Rail<java.lang.String>)args).size;
        
        //#line 789 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
        final boolean t$25658 = ((t$25653) > (((long)(0L))));
        
        //#line 789 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
        if (t$25658) {
            
            //#line 790 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
            final java.lang.String t$25654 = ((java.lang.String[])args.value)[(int)0L];
            
            //#line 790 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
            final x10.io.File t$25655 = ((x10.io.File)(new x10.io.File((java.lang.System[]) null).x10$io$File$$init$S(t$25654)));
            
            //#line 790 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
            final cassia.util.JSON.Value t$25656 = ((cassia.util.JSON.Value)(cassia.util.JSON.parse(((x10.io.File)(t$25655)))));
            
            //#line 790 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
            json = ((cassia.util.JSON.Value)(t$25656));
        } else {
            
            //#line 792 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
            final cassia.util.JSON.Value t$25657 = ((cassia.util.JSON.Value)(cassia.util.JSON.parse(((java.lang.String)("{\'first\': 1, \'second\': 2, \'third\': [1,2,\'c\'], \'4th\': {\'one\': { \'more\': b.c.c } }, nullobj: { }, 1  : [],  spaces  : \'a a a\'    ,   123   : 123  }")))));
            
            //#line 792 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
            json = ((cassia.util.JSON.Value)(t$25657));
        }
        
        //#line 795 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
        final x10.io.Printer t$25660 = ((x10.io.Printer)(x10.io.Console.get$OUT()));
        
        //#line 795 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
        final cassia.util.JSON.Value t$25659 = ((cassia.util.JSON.Value)(json));
        
        //#line 795 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
        final java.lang.String t$25661 = cassia.util.JSON.dump(((cassia.util.JSON.Value)(t$25659)));
        
        //#line 795 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
        t$25660.println(((java.lang.Object)(t$25661)));
        
        //#line 797 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
        final cassia.util.JSON.Value t$25662 = ((cassia.util.JSON.Value)(json));
        
        //#line 797 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
        cassia.util.JSON.extend(((cassia.util.JSON.Value)(t$25662)));
        
        //#line 799 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
        final x10.io.Printer t$25664 = ((x10.io.Printer)(x10.io.Console.get$OUT()));
        
        //#line 799 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
        final cassia.util.JSON.Value t$25663 = ((cassia.util.JSON.Value)(json));
        
        //#line 799 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
        final java.lang.String t$25665 = cassia.util.JSON.dump(((cassia.util.JSON.Value)(t$25663)));
        
        //#line 799 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
        t$25664.println(((java.lang.Object)(t$25665)));
        
        //#line 801 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
        final cassia.util.JSON.Value z = ((cassia.util.JSON.Value)(cassia.util.JSON.parse(((java.lang.String)("{}")))));
        
        //#line 802 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
        final x10.io.Printer t$25667 = ((x10.io.Printer)(x10.io.Console.get$OUT()));
        
        //#line 802 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
        final cassia.util.JSON.Value t$25666 = ((cassia.util.JSON.Value)z).<java.lang.String> $apply__0cassia$util$JSON$Value$$T(x10.rtt.Types.STRING, ((java.lang.String)("a")), ((java.lang.String)("{\'a\':1}")));
        
        //#line 802 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
        final java.lang.String t$25668 = cassia.util.JSON.dump(((cassia.util.JSON.Value)(t$25666)));
        
        //#line 802 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
        t$25667.println(((java.lang.Object)(t$25668)));
        
        //#line 804 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
        final cassia.util.JSON.Value x = ((cassia.util.JSON.Value)(new cassia.util.JSON.Value((java.lang.System[]) null).cassia$util$JSON$Value$$init$S((java.lang.Object)("x"))));
        
        //#line 805 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
        final cassia.util.JSON.Value y = ((cassia.util.JSON.Value)(new cassia.util.JSON.Value((java.lang.System[]) null).cassia$util$JSON$Value$$init$S((java.lang.Object)("2.0"))));
        
        //#line 806 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
        final x10.io.Printer t$25671 = ((x10.io.Printer)(x10.io.Console.get$OUT()));
        
        //#line 806 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
        final java.lang.String t$25669 = x.toString();
        
        //#line 806 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
        final boolean t$25670 = (t$25669).equals("x");
        
        //#line 806 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
        final java.lang.String t$25672 = (("x.toString().equals(\'x\'): ") + ((x10.core.Boolean.$box(t$25670))));
        
        //#line 806 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
        t$25671.println(((java.lang.Object)(t$25672)));
        
        //#line 807 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
        final x10.io.Printer t$25674 = ((x10.io.Printer)(x10.io.Console.get$OUT()));
        
        //#line 807 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
        final boolean t$25673 = x.equals(((java.lang.Object)("x")));
        
        //#line 807 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
        final java.lang.String t$25675 = (("x.equals(\'x\'): ") + ((x10.core.Boolean.$box(t$25673))));
        
        //#line 807 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
        t$25674.println(((java.lang.Object)(t$25675)));
        
        //#line 808 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
        final x10.io.Printer t$25677 = ((x10.io.Printer)(x10.io.Console.get$OUT()));
        
        //#line 808 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
        final boolean t$25676 = x.equals(((java.lang.Object)("w")));
        
        //#line 808 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
        final java.lang.String t$25678 = (("x.equals(\'w\'): ") + ((x10.core.Boolean.$box(t$25676))));
        
        //#line 808 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
        t$25677.println(((java.lang.Object)(t$25678)));
        
        //#line 809 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
        final x10.io.Printer t$25680 = ((x10.io.Printer)(x10.io.Console.get$OUT()));
        
        //#line 809 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
        final boolean t$25679 = y.equals(x10.core.Double.$box(2.0));
        
        //#line 809 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
        final java.lang.String t$25681 = (("y.equals(2.0): ") + ((x10.core.Boolean.$box(t$25679))));
        
        //#line 809 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
        t$25680.println(((java.lang.Object)(t$25681)));
        
        //#line 811 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
        final x10.io.Printer t$25683 = ((x10.io.Printer)(x10.io.Console.get$OUT()));
        
        //#line 811 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
        final boolean t$25682 = y.equals(x10.core.Double.$box(1.1));
        
        //#line 811 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
        final java.lang.String t$25684 = (("y.equals(1.1): ") + ((x10.core.Boolean.$box(t$25682))));
        
        //#line 811 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
        t$25683.println(((java.lang.Object)(t$25684)));
        
        //#line 813 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
        final x10.io.Printer t$25686 = ((x10.io.Printer)(x10.io.Console.get$OUT()));
        
        //#line 813 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
        final cassia.util.JSON.Value t$25685 = ((cassia.util.JSON.Value)(json));
        
        //#line 813 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
        final long t$25687 = t$25685.size$O();
        
        //#line 813 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
        t$25686.println(x10.core.Long.$box(t$25687));
        
        //#line 814 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
        final x10.io.Printer t$25690 = ((x10.io.Printer)(x10.io.Console.get$OUT()));
        
        //#line 814 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
        final cassia.util.JSON.Value t$25688 = ((cassia.util.JSON.Value)(json));
        
        //#line 814 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
        final cassia.util.JSON.Value t$25689 = ((cassia.util.JSON.Value)t$25688).<java.lang.String> get(x10.rtt.Types.STRING, ((java.lang.String)("first")));
        
        //#line 814 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
        final long t$25691 = t$25689.size$O();
        
        //#line 814 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
        t$25690.println(x10.core.Long.$box(t$25691));
        
        //#line 815 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
        final x10.io.Printer t$25694 = ((x10.io.Printer)(x10.io.Console.get$OUT()));
        
        //#line 815 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
        final cassia.util.JSON.Value t$25692 = ((cassia.util.JSON.Value)(json));
        
        //#line 815 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
        final cassia.util.JSON.Value t$25693 = ((cassia.util.JSON.Value)t$25692).<java.lang.String> get(x10.rtt.Types.STRING, ((java.lang.String)("first")));
        
        //#line 815 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
        final double t$25695 = t$25693.toDouble$O();
        
        //#line 815 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
        t$25694.println(x10.core.Double.$box(t$25695));
        
        //#line 816 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
        final x10.io.Printer t$25698 = ((x10.io.Printer)(x10.io.Console.get$OUT()));
        
        //#line 816 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
        final cassia.util.JSON.Value t$25696 = ((cassia.util.JSON.Value)(json));
        
        //#line 816 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
        final cassia.util.JSON.Value t$25697 = ((cassia.util.JSON.Value)t$25696).<java.lang.String> get(x10.rtt.Types.STRING, ((java.lang.String)("third")));
        
        //#line 816 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
        final long t$25699 = t$25697.size$O();
        
        //#line 816 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
        t$25698.println(x10.core.Long.$box(t$25699));
        
        //#line 817 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
        final x10.io.Printer t$25701 = ((x10.io.Printer)(x10.io.Console.get$OUT()));
        
        //#line 817 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
        final cassia.util.JSON.Value t$25700 = ((cassia.util.JSON.Value)(json));
        
        //#line 817 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
        final cassia.util.JSON.Value t$25702 = ((cassia.util.JSON.Value)t$25700).<java.lang.String> get(x10.rtt.Types.STRING, ((java.lang.String)("first")));
        
        //#line 817 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
        t$25701.println(((java.lang.Object)(t$25702)));
        
        //#line 818 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
        final x10.io.Printer t$25705 = ((x10.io.Printer)(x10.io.Console.get$OUT()));
        
        //#line 818 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
        final cassia.util.JSON.Value t$25703 = ((cassia.util.JSON.Value)(json));
        
        //#line 818 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
        final cassia.util.JSON.Value t$25704 = ((cassia.util.JSON.Value)t$25703).<java.lang.String> get(x10.rtt.Types.STRING, ((java.lang.String)("first")));
        
        //#line 818 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
        final java.lang.String t$25706 = t$25704.toString();
        
        //#line 818 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
        t$25705.println(((java.lang.Object)(t$25706)));
        
        //#line 821 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
        final cassia.util.JSON.Value t$25707 = ((cassia.util.JSON.Value)(json));
        
        //#line 821 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
        final cassia.util.JSON.Value clon = t$25707.clone();
        
        //#line 822 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
        ((cassia.util.JSON.Value)clon).<java.lang.String> $set__0cassia$util$JSON$Value$$T(x10.rtt.Types.STRING, ((java.lang.String)("5th")), x10.core.Long.$box(123L));
        
        //#line 823 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
        ((cassia.util.JSON.Value)clon).<java.lang.String> $set__0cassia$util$JSON$Value$$T(x10.rtt.Types.STRING, ((java.lang.String)("first")), ((java.lang.Object)("10000000000")));
        
        //#line 824 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
        final cassia.util.JSON.Value t$25708 = ((cassia.util.JSON.Value)clon).<java.lang.String> get(x10.rtt.Types.STRING, ((java.lang.String)("4th")));
        
        //#line 824 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
        ((cassia.util.JSON.Value)t$25708).<java.lang.String> $set__0cassia$util$JSON$Value$$T(x10.rtt.Types.STRING, ((java.lang.String)("one")), ((java.lang.Object)("ichi")));
        
        //#line 825 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
        final x10.io.Printer t$25710 = ((x10.io.Printer)(x10.io.Console.get$OUT()));
        
        //#line 825 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
        final cassia.util.JSON.Value t$25709 = ((cassia.util.JSON.Value)clon).<java.lang.String> get(x10.rtt.Types.STRING, ((java.lang.String)("5th")));
        
        //#line 825 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
        final java.lang.String t$25711 = (("5th: ") + (t$25709));
        
        //#line 825 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
        t$25710.println(((java.lang.Object)(t$25711)));
        
        //#line 826 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
        final x10.io.Printer t$25713 = ((x10.io.Printer)(x10.io.Console.get$OUT()));
        
        //#line 826 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
        final cassia.util.JSON.Value t$25712 = ((cassia.util.JSON.Value)(json));
        
        //#line 826 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
        final java.lang.String t$25714 = cassia.util.JSON.dump(((cassia.util.JSON.Value)(t$25712)));
        
        //#line 826 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
        t$25713.println(((java.lang.Object)(t$25714)));
        
        //#line 827 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
        final x10.io.Printer t$25715 = ((x10.io.Printer)(x10.io.Console.get$OUT()));
        
        //#line 827 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
        final java.lang.String t$25716 = cassia.util.JSON.dump(((cassia.util.JSON.Value)(clon)));
        
        //#line 827 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
        t$25715.println(((java.lang.Object)(t$25716)));
        
        //#line 829 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
        final x10.io.Printer t$25720 = ((x10.io.Printer)(x10.io.Console.get$OUT()));
        
        //#line 829 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
        final cassia.util.JSON.Value t$25717 = ((cassia.util.JSON.Value)(json));
        
        //#line 829 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
        final cassia.util.JSON.Value t$25718 = ((cassia.util.JSON.Value)(new cassia.util.JSON.Value((java.lang.System[]) null).cassia$util$JSON$Value$$init$S((java.lang.Object)("first"))));
        
        //#line 829 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
        final cassia.util.JSON.Value t$25719 = ((cassia.util.JSON.Value)t$25717).<cassia.util.JSON.Value> get(cassia.util.JSON.Value.$RTT, ((cassia.util.JSON.Value)(t$25718)));
        
        //#line 829 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
        final java.lang.String t$25721 = (("JSON.Value as key: ") + (t$25719));
        
        //#line 829 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
        t$25720.println(((java.lang.Object)(t$25721)));
        
        //#line 831 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
        final x10.io.Printer t$25722 = ((x10.io.Printer)(x10.io.Console.get$OUT()));
        
        //#line 831 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
        t$25722.println(((java.lang.Object)("third")));
        
        //#line 832 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
        final x10.io.Printer t$25726 = ((x10.io.Printer)(x10.io.Console.get$OUT()));
        
        //#line 832 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
        final cassia.util.JSON.Value t$25723 = ((cassia.util.JSON.Value)(json));
        
        //#line 832 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
        final cassia.util.JSON.Value t$25724 = ((cassia.util.JSON.Value)t$25723).<java.lang.String> get(x10.rtt.Types.STRING, ((java.lang.String)("third")));
        
        //#line 832 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
        final cassia.util.JSON.Value t$25725 = ((cassia.util.JSON.Value)t$25724).<x10.core.Long> get(x10.rtt.Types.LONG, x10.core.Long.$box(1L));
        
        //#line 832 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
        final long t$25727 = t$25725.toLong$O();
        
        //#line 832 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
        t$25726.println(x10.core.Long.$box(t$25727));
        
        //#line 833 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
        final x10.io.Printer t$25731 = ((x10.io.Printer)(x10.io.Console.get$OUT()));
        
        //#line 833 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
        final cassia.util.JSON.Value t$25728 = ((cassia.util.JSON.Value)(json));
        
        //#line 833 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
        final cassia.util.JSON.Value t$25729 = ((cassia.util.JSON.Value)t$25728).<java.lang.String> get(x10.rtt.Types.STRING, ((java.lang.String)("third")));
        
        //#line 833 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
        final cassia.util.JSON.Value t$25730 = ((cassia.util.JSON.Value)t$25729).<java.lang.String> get(x10.rtt.Types.STRING, ((java.lang.String)("1")));
        
        //#line 833 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
        final long t$25732 = t$25730.toLong$O();
        
        //#line 833 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
        t$25731.println(x10.core.Long.$box(t$25732));
        
        //#line 834 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
        final x10.io.Printer t$25736 = ((x10.io.Printer)(x10.io.Console.get$OUT()));
        
        //#line 834 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
        final cassia.util.JSON.Value t$25733 = ((cassia.util.JSON.Value)(json));
        
        //#line 834 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
        final cassia.util.JSON.Value t$25734 = ((cassia.util.JSON.Value)t$25733).<java.lang.String> get(x10.rtt.Types.STRING, ((java.lang.String)("third")));
        
        //#line 834 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
        final cassia.util.JSON.Value t$25735 = ((cassia.util.JSON.Value)t$25734).<java.lang.String> get(x10.rtt.Types.STRING, ((java.lang.String)("1")));
        
        //#line 834 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
        final double t$25737 = t$25735.toDouble$O();
        
        //#line 834 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
        t$25736.println(x10.core.Double.$box(t$25737));
        
        //#line 835 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
        final x10.io.Printer t$25741 = ((x10.io.Printer)(x10.io.Console.get$OUT()));
        
        //#line 835 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
        final cassia.util.JSON.Value t$25738 = ((cassia.util.JSON.Value)(json));
        
        //#line 835 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
        final cassia.util.JSON.Value t$25739 = ((cassia.util.JSON.Value)t$25738).<java.lang.String> get(x10.rtt.Types.STRING, ((java.lang.String)("third")));
        
        //#line 835 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
        final cassia.util.JSON.Value t$25740 = ((cassia.util.JSON.Value)t$25739).<java.lang.String> get(x10.rtt.Types.STRING, ((java.lang.String)("2")));
        
        //#line 835 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
        final java.lang.String t$25742 = t$25740.toString();
        
        //#line 835 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
        t$25741.println(((java.lang.Object)(t$25742)));
        
        //#line 836 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
        final x10.io.Printer t$25743 = ((x10.io.Printer)(x10.io.Console.get$OUT()));
        
        //#line 836 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
        t$25743.println(((java.lang.Object)("end third")));
        
        //#line 837 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
        final x10.io.Printer t$25748 = ((x10.io.Printer)(x10.io.Console.get$OUT()));
        
        //#line 837 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
        final cassia.util.JSON.Value t$25744 = ((cassia.util.JSON.Value)(json));
        
        //#line 837 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
        final cassia.util.JSON.Value t$25745 = ((cassia.util.JSON.Value)t$25744).<java.lang.String> get(x10.rtt.Types.STRING, ((java.lang.String)("4th")));
        
        //#line 837 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
        final cassia.util.JSON.Value t$25746 = ((cassia.util.JSON.Value)t$25745).<java.lang.String> get(x10.rtt.Types.STRING, ((java.lang.String)("one")));
        
        //#line 837 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
        final cassia.util.JSON.Value t$25747 = ((cassia.util.JSON.Value)t$25746).<java.lang.String> get(x10.rtt.Types.STRING, ((java.lang.String)("more")));
        
        //#line 837 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
        final java.lang.String t$25749 = t$25747.toString();
        
        //#line 837 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
        t$25748.println(((java.lang.Object)(t$25749)));
        
        //#line 838 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
        final x10.io.Printer t$25753 = ((x10.io.Printer)(x10.io.Console.get$OUT()));
        
        //#line 838 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
        final cassia.util.JSON.Value t$25750 = ((cassia.util.JSON.Value)(json));
        
        //#line 838 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
        final x10.core.Rail t$25751 = ((x10.core.Rail)(x10.runtime.impl.java.ArrayUtils.<java.lang.Object> makeRailFromJavaArray(x10.rtt.Types.ANY, new java.lang.Object[] {"third", 2L})));
        
        //#line 838 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
        final cassia.util.JSON.Value t$25752 = ((cassia.util.JSON.Value)t$25750).<java.lang.Object> get__0$1cassia$util$JSON$Value$$T$2(x10.rtt.Types.ANY, ((x10.core.Rail)(t$25751)));
        
        //#line 838 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
        final java.lang.String t$25754 = t$25752.toString();
        
        //#line 838 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
        t$25753.println(((java.lang.Object)(t$25754)));
        
        //#line 839 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
        final x10.io.Printer t$25758 = ((x10.io.Printer)(x10.io.Console.get$OUT()));
        
        //#line 839 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
        final cassia.util.JSON.Value t$25755 = ((cassia.util.JSON.Value)(json));
        
        //#line 839 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
        final x10.core.Rail t$25756 = ((x10.core.Rail)(x10.runtime.impl.java.ArrayUtils.<java.lang.String> makeRailFromJavaArray(x10.rtt.Types.STRING, new java.lang.String[] {"third", "2"})));
        
        //#line 839 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
        final cassia.util.JSON.Value t$25757 = ((cassia.util.JSON.Value)t$25755).<java.lang.String> get__0$1cassia$util$JSON$Value$$T$2(x10.rtt.Types.STRING, ((x10.core.Rail)(t$25756)));
        
        //#line 839 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
        final java.lang.String t$25759 = t$25757.toString();
        
        //#line 839 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
        t$25758.println(((java.lang.Object)(t$25759)));
        
        //#line 840 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
        final x10.io.Printer t$25763 = ((x10.io.Printer)(x10.io.Console.get$OUT()));
        
        //#line 840 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
        final cassia.util.JSON.Value t$25760 = ((cassia.util.JSON.Value)(json));
        
        //#line 840 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
        final x10.core.Rail t$25761 = ((x10.core.Rail)(x10.runtime.impl.java.ArrayUtils.<java.lang.String> makeRailFromJavaArray(x10.rtt.Types.STRING, new java.lang.String[] {"4th", "one", "more"})));
        
        //#line 840 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
        final cassia.util.JSON.Value t$25762 = ((cassia.util.JSON.Value)t$25760).<java.lang.String> get__0$1cassia$util$JSON$Value$$T$2(x10.rtt.Types.STRING, ((x10.core.Rail)(t$25761)));
        
        //#line 840 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
        final java.lang.String t$25764 = t$25762.toString();
        
        //#line 840 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
        t$25763.println(((java.lang.Object)(t$25764)));
        
        //#line 841 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
        final x10.io.Printer t$25767 = ((x10.io.Printer)(x10.io.Console.get$OUT()));
        
        //#line 841 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
        final cassia.util.JSON.Value t$25765 = ((cassia.util.JSON.Value)(json));
        
        //#line 841 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
        final x10.core.Rail t$25766 = ((x10.core.Rail)(x10.runtime.impl.java.ArrayUtils.<java.lang.String> makeRailFromJavaArray(x10.rtt.Types.STRING, new java.lang.String[] {"4th", "onetwo", "more"})));
        
        //#line 841 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
        final cassia.util.JSON.Value t$25768 = ((cassia.util.JSON.Value)t$25765).<java.lang.String> get__0$1cassia$util$JSON$Value$$T$2(x10.rtt.Types.STRING, ((x10.core.Rail)(t$25766)));
        
        //#line 841 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
        t$25767.println(((java.lang.Object)(t$25768)));
        
        //#line 842 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
        final x10.io.Printer t$25772 = ((x10.io.Printer)(x10.io.Console.get$OUT()));
        
        //#line 842 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
        final cassia.util.JSON.Value t$25769 = ((cassia.util.JSON.Value)(json));
        
        //#line 842 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
        final cassia.util.JSON.Value t$25770 = ((cassia.util.JSON.Value)t$25769).<java.lang.String> get(x10.rtt.Types.STRING, ((java.lang.String)("4th")));
        
        //#line 842 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
        final cassia.util.JSON.Value t$25771 = ((cassia.util.JSON.Value)t$25770).<java.lang.String> get(x10.rtt.Types.STRING, ((java.lang.String)("onetwo")));
        
        //#line 842 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
        final cassia.util.JSON.Value t$25773 = ((cassia.util.JSON.Value)t$25771).<java.lang.String> get(x10.rtt.Types.STRING, ((java.lang.String)("more")));
        
        //#line 842 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
        t$25772.println(((java.lang.Object)(t$25773)));
        
        //#line 843 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
        final x10.io.Printer t$25778 = ((x10.io.Printer)(x10.io.Console.get$OUT()));
        
        //#line 843 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
        final cassia.util.JSON.Value t$25774 = ((cassia.util.JSON.Value)(json));
        
        //#line 843 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
        final cassia.util.JSON.Value t$25775 = ((cassia.util.JSON.Value)t$25774).<java.lang.String> get(x10.rtt.Types.STRING, ((java.lang.String)("4th")));
        
        //#line 843 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
        final x10.core.Rail t$25776 = ((x10.core.Rail)(x10.runtime.impl.java.ArrayUtils.<java.lang.String> makeRailFromJavaArray(x10.rtt.Types.STRING, new java.lang.String[] {"three", "two"})));
        
        //#line 843 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
        final cassia.util.JSON.Value t$25777 = ((cassia.util.JSON.Value)t$25775).<java.lang.String> any__0$1cassia$util$JSON$Value$$T$2(x10.rtt.Types.STRING, ((x10.core.Rail)(t$25776)));
        
        //#line 843 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
        final cassia.util.JSON.Value t$25779 = ((cassia.util.JSON.Value)t$25777).<java.lang.String> get__0cassia$util$JSON$Value$$T(x10.rtt.Types.STRING, ((java.lang.String)("more")));
        
        //#line 843 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
        t$25778.println(((java.lang.Object)(t$25779)));
        
        //#line 844 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
        final x10.io.Printer t$25785 = ((x10.io.Printer)(x10.io.Console.get$OUT()));
        
        //#line 844 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
        final cassia.util.JSON.Value t$25780 = ((cassia.util.JSON.Value)(json));
        
        //#line 844 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
        final cassia.util.JSON.Value t$25781 = ((cassia.util.JSON.Value)t$25780).<java.lang.String> get(x10.rtt.Types.STRING, ((java.lang.String)("4th")));
        
        //#line 844 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
        final x10.core.Rail t$25782 = ((x10.core.Rail)(x10.runtime.impl.java.ArrayUtils.<java.lang.String> makeRailFromJavaArray(x10.rtt.Types.STRING, new java.lang.String[] {"three", "two"})));
        
        //#line 844 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
        final cassia.util.JSON.Value t$25783 = ((cassia.util.JSON.Value)t$25781).<java.lang.String> any__0$1cassia$util$JSON$Value$$T$2(x10.rtt.Types.STRING, ((x10.core.Rail)(t$25782)));
        
        //#line 844 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
        final cassia.util.JSON.Value t$25784 = ((cassia.util.JSON.Value)t$25783).<java.lang.String> get(x10.rtt.Types.STRING, ((java.lang.String)("more")));
        
        //#line 844 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
        final java.lang.String t$25786 = t$25784.toString();
        
        //#line 844 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
        t$25785.println(((java.lang.Object)(t$25786)));
        
        //#line 846 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
        final x10.io.Printer t$25787 = ((x10.io.Printer)(x10.io.Console.get$OUT()));
        
        //#line 846 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
        t$25787.println(((java.lang.Object)("END")));
    }
    
    
    //#line 32 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
    final public cassia.util.JSON cassia$util$JSON$$this$cassia$util$JSON() {
        
        //#line 32 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
        return cassia.util.JSON.this;
    }
    
    
    //#line 32 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
    // creation method for java code (1-phase java constructor)
    public JSON() {
        this((java.lang.System[]) null);
        cassia$util$JSON$$init$S();
    }
    
    // constructor for non-virtual call
    final public cassia.util.JSON cassia$util$JSON$$init$S() {
         {
            
            //#line 32 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
            
            
            //#line 32 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
            this.__fieldInitializers_cassia_util_JSON();
        }
        return this;
    }
    
    
    
    //#line 32 "/home/dsl/workspace/plhamK/cassia/util/JSON.x10"
    final public void __fieldInitializers_cassia_util_JSON() {
        
    }
}

