package plham.util;


/**
 * JSONRandom extends RandomHelper to provide integrated usability with JSON.
 */

public class JSONRandom extends plham.util.RandomHelper implements x10.serialization.X10JavaSerializable
{
    public static final x10.rtt.RuntimeType<JSONRandom> $RTT = 
        x10.rtt.NamedType.<JSONRandom> make("plham.util.JSONRandom",
                                            JSONRandom.class,
                                            new x10.rtt.Type[] {
                                                plham.util.RandomHelper.$RTT
                                            });
    
    public x10.rtt.RuntimeType<?> $getRTT() { return $RTT; }
    
    public x10.rtt.Type<?> $getParam(int i) { return null; }
    
    private Object writeReplace() throws java.io.ObjectStreamException {
        return new x10.serialization.SerializationProxy(this);
    }
    
    public static x10.serialization.X10JavaSerializable $_deserialize_body(plham.util.JSONRandom $_obj, x10.serialization.X10JavaDeserializer $deserializer) throws java.io.IOException {
        if (x10.runtime.impl.java.Runtime.TRACE_SER) { x10.runtime.impl.java.Runtime.printTraceMessage("X10JavaSerializable: $_deserialize_body() of " + JSONRandom.class + " calling"); } 
        plham.util.RandomHelper.$_deserialize_body($_obj, $deserializer);
        return $_obj;
    }
    
    public static x10.serialization.X10JavaSerializable $_deserializer(x10.serialization.X10JavaDeserializer $deserializer) throws java.io.IOException {
        plham.util.JSONRandom $_obj = new plham.util.JSONRandom((java.lang.System[]) null);
        $deserializer.record_reference($_obj);
        return $_deserialize_body($_obj, $deserializer);
    }
    
    public void $_serialize(x10.serialization.X10JavaSerializer $serializer) throws java.io.IOException {
        super.$_serialize($serializer);
        
    }
    
    // constructor just for allocation
    public JSONRandom(final java.lang.System[] $dummy) {
        super($dummy);
        
    }
    
    

    
    
    //#line 10 "/home/dsl/workspace/plhamK/plham/util/JSONRandom.x10"
    // creation method for java code (1-phase java constructor)
    public JSONRandom(final x10.util.Random random) {
        this((java.lang.System[]) null);
        plham$util$JSONRandom$$init$S(random);
    }
    
    // constructor for non-virtual call
    final public plham.util.JSONRandom plham$util$JSONRandom$$init$S(final x10.util.Random random) {
         {
            
            //#line 11 "/home/dsl/workspace/plhamK/plham/util/JSONRandom.x10"
            /*super.*/plham$util$RandomHelper$$init$S(((random)));
            
            //#line 10 "/home/dsl/workspace/plhamK/plham/util/JSONRandom.x10"
            
            
            //#line 8 "/home/dsl/workspace/plhamK/plham/util/JSONRandom.x10"
            this.__fieldInitializers_plham_util_JSONRandom();
        }
        return this;
    }
    
    
    
    //#line 25 "/home/dsl/workspace/plhamK/plham/util/JSONRandom.x10"
    /**
	 * Return a random number from a probability distribution specified in the JSON.Value.
	 * If it is a constant, return the value.
	 * If it is a list (pair), return a uniform random number between them.
	 * If it is a dict (of one key), return a random number sampled from a distribution given by the key name:
	 * 
	 *   * "const": [value]       ... constant, the value.
	 *   * "uniform": [min, max]  ... uniform between min and max.
	 *   * "normal": [mu, sigma]  ... normal of mean mu and variance sigma^2.
	 *   * "expon": [lambda]      ... exponential of expected lambda.
	 */
    public double nextRandom$O(final cassia.util.JSON.Value json) {
        
        //#line 26 "/home/dsl/workspace/plhamK/plham/util/JSONRandom.x10"
        final boolean t$21654 = json.isList$O();
        
        //#line 26 "/home/dsl/workspace/plhamK/plham/util/JSONRandom.x10"
        if (t$21654) {
            
            //#line 27 "/home/dsl/workspace/plhamK/plham/util/JSONRandom.x10"
            assert (json.size$O()) == (2L): (("Uniform distribution must be [min, max] but ") + (cassia.util.JSON.dump(((json)))));
            
            //#line 28 "/home/dsl/workspace/plhamK/plham/util/JSONRandom.x10"
            final cassia.util.JSON.Value t$21651 = json.<x10.core.Long> get(x10.rtt.Types.LONG, x10.core.Long.$box(0L));
            
            //#line 28 "/home/dsl/workspace/plhamK/plham/util/JSONRandom.x10"
            final double min = t$21651.toDouble$O();
            
            //#line 29 "/home/dsl/workspace/plhamK/plham/util/JSONRandom.x10"
            final cassia.util.JSON.Value t$21652 = json.<x10.core.Long> get(x10.rtt.Types.LONG, x10.core.Long.$box(1L));
            
            //#line 29 "/home/dsl/workspace/plhamK/plham/util/JSONRandom.x10"
            final double max = t$21652.toDouble$O();
            
            //#line 30 "/home/dsl/workspace/plhamK/plham/util/JSONRandom.x10"
            final double t$21653 = this.nextUniform$O((min), (max));
            
            //#line 30 "/home/dsl/workspace/plhamK/plham/util/JSONRandom.x10"
            return t$21653;
        }
        
        //#line 32 "/home/dsl/workspace/plhamK/plham/util/JSONRandom.x10"
        final boolean t$21668 = json.isMap$O();
        
        //#line 32 "/home/dsl/workspace/plhamK/plham/util/JSONRandom.x10"
        if (t$21668) {
            
            //#line 33 "/home/dsl/workspace/plhamK/plham/util/JSONRandom.x10"
            assert (json.size$O()) == (1L): (("Multiple speficiation of distribution type: ") + (cassia.util.JSON.dump(((json)))));
            
            //#line 34 "/home/dsl/workspace/plhamK/plham/util/JSONRandom.x10"
            final boolean t$21656 = json.<java.lang.String> has__0cassia$util$JSON$Value$$T$O(x10.rtt.Types.STRING, (("const")));
            
            //#line 34 "/home/dsl/workspace/plhamK/plham/util/JSONRandom.x10"
            if (t$21656) {
                
                //#line 35 "/home/dsl/workspace/plhamK/plham/util/JSONRandom.x10"
                final cassia.util.JSON.Value args = json.<java.lang.String> get(x10.rtt.Types.STRING, (("const")));
                
                //#line 36 "/home/dsl/workspace/plhamK/plham/util/JSONRandom.x10"
                assert (args.size$O()) == (1L): (("Constant must be [value] but ") + (cassia.util.JSON.dump(((json)))));
                
                //#line 37 "/home/dsl/workspace/plhamK/plham/util/JSONRandom.x10"
                final cassia.util.JSON.Value t$21655 = args.<x10.core.Long> get(x10.rtt.Types.LONG, x10.core.Long.$box(0L));
                
                //#line 37 "/home/dsl/workspace/plhamK/plham/util/JSONRandom.x10"
                final double value = t$21655.toDouble$O();
                
                //#line 38 "/home/dsl/workspace/plhamK/plham/util/JSONRandom.x10"
                return value;
            }
            
            //#line 40 "/home/dsl/workspace/plhamK/plham/util/JSONRandom.x10"
            final boolean t$21660 = json.<java.lang.String> has__0cassia$util$JSON$Value$$T$O(x10.rtt.Types.STRING, (("uniform")));
            
            //#line 40 "/home/dsl/workspace/plhamK/plham/util/JSONRandom.x10"
            if (t$21660) {
                
                //#line 41 "/home/dsl/workspace/plhamK/plham/util/JSONRandom.x10"
                final cassia.util.JSON.Value args = json.<java.lang.String> get(x10.rtt.Types.STRING, (("uniform")));
                
                //#line 42 "/home/dsl/workspace/plhamK/plham/util/JSONRandom.x10"
                assert (args.size$O()) == (2L): (("Uniform distribution must be [min, max] but ") + (cassia.util.JSON.dump(((json)))));
                
                //#line 43 "/home/dsl/workspace/plhamK/plham/util/JSONRandom.x10"
                final cassia.util.JSON.Value t$21657 = args.<x10.core.Long> get(x10.rtt.Types.LONG, x10.core.Long.$box(0L));
                
                //#line 43 "/home/dsl/workspace/plhamK/plham/util/JSONRandom.x10"
                final double min = t$21657.toDouble$O();
                
                //#line 44 "/home/dsl/workspace/plhamK/plham/util/JSONRandom.x10"
                final cassia.util.JSON.Value t$21658 = args.<x10.core.Long> get(x10.rtt.Types.LONG, x10.core.Long.$box(1L));
                
                //#line 44 "/home/dsl/workspace/plhamK/plham/util/JSONRandom.x10"
                final double max = t$21658.toDouble$O();
                
                //#line 45 "/home/dsl/workspace/plhamK/plham/util/JSONRandom.x10"
                final double t$21659 = this.nextUniform$O((min), (max));
                
                //#line 45 "/home/dsl/workspace/plhamK/plham/util/JSONRandom.x10"
                return t$21659;
            }
            
            //#line 47 "/home/dsl/workspace/plhamK/plham/util/JSONRandom.x10"
            final boolean t$21664 = json.<java.lang.String> has__0cassia$util$JSON$Value$$T$O(x10.rtt.Types.STRING, (("normal")));
            
            //#line 47 "/home/dsl/workspace/plhamK/plham/util/JSONRandom.x10"
            if (t$21664) {
                
                //#line 48 "/home/dsl/workspace/plhamK/plham/util/JSONRandom.x10"
                final cassia.util.JSON.Value args = json.<java.lang.String> get(x10.rtt.Types.STRING, (("normal")));
                
                //#line 49 "/home/dsl/workspace/plhamK/plham/util/JSONRandom.x10"
                assert (args.size$O()) == (2L): (("Normal distribution must be [mu, sigma] but ") + (cassia.util.JSON.dump(((json)))));
                
                //#line 50 "/home/dsl/workspace/plhamK/plham/util/JSONRandom.x10"
                final cassia.util.JSON.Value t$21661 = args.<x10.core.Long> get(x10.rtt.Types.LONG, x10.core.Long.$box(0L));
                
                //#line 50 "/home/dsl/workspace/plhamK/plham/util/JSONRandom.x10"
                final double mu = t$21661.toDouble$O();
                
                //#line 51 "/home/dsl/workspace/plhamK/plham/util/JSONRandom.x10"
                final cassia.util.JSON.Value t$21662 = args.<x10.core.Long> get(x10.rtt.Types.LONG, x10.core.Long.$box(1L));
                
                //#line 51 "/home/dsl/workspace/plhamK/plham/util/JSONRandom.x10"
                final double sigma = t$21662.toDouble$O();
                
                //#line 52 "/home/dsl/workspace/plhamK/plham/util/JSONRandom.x10"
                final double t$21663 = this.nextNormal$O((mu), (sigma));
                
                //#line 52 "/home/dsl/workspace/plhamK/plham/util/JSONRandom.x10"
                return t$21663;
            }
            
            //#line 54 "/home/dsl/workspace/plhamK/plham/util/JSONRandom.x10"
            final boolean t$21667 = json.<java.lang.String> has__0cassia$util$JSON$Value$$T$O(x10.rtt.Types.STRING, (("expon")));
            
            //#line 54 "/home/dsl/workspace/plhamK/plham/util/JSONRandom.x10"
            if (t$21667) {
                
                //#line 55 "/home/dsl/workspace/plhamK/plham/util/JSONRandom.x10"
                final cassia.util.JSON.Value args = json.<java.lang.String> get(x10.rtt.Types.STRING, (("expon")));
                
                //#line 56 "/home/dsl/workspace/plhamK/plham/util/JSONRandom.x10"
                assert (args.size$O()) == (1L): (("Exponential distribution must be [lambda] but ") + (cassia.util.JSON.dump(((json)))));
                
                //#line 57 "/home/dsl/workspace/plhamK/plham/util/JSONRandom.x10"
                final cassia.util.JSON.Value t$21665 = args.<x10.core.Long> get(x10.rtt.Types.LONG, x10.core.Long.$box(0L));
                
                //#line 57 "/home/dsl/workspace/plhamK/plham/util/JSONRandom.x10"
                final double lambda = t$21665.toDouble$O();
                
                //#line 58 "/home/dsl/workspace/plhamK/plham/util/JSONRandom.x10"
                final double t$21666 = this.nextExponential$O((lambda));
                
                //#line 58 "/home/dsl/workspace/plhamK/plham/util/JSONRandom.x10"
                return t$21666;
            }
            
            //#line 60 "/home/dsl/workspace/plhamK/plham/util/JSONRandom.x10"
            assert false: (("Unknown distribution type: ") + (cassia.util.JSON.dump(((json)))));
        }
        
        //#line 62 "/home/dsl/workspace/plhamK/plham/util/JSONRandom.x10"
        final double t$21669 = json.toDouble$O();
        
        //#line 62 "/home/dsl/workspace/plhamK/plham/util/JSONRandom.x10"
        return t$21669;
    }
    
    
    //#line 8 "/home/dsl/workspace/plhamK/plham/util/JSONRandom.x10"
    final public plham.util.JSONRandom plham$util$JSONRandom$$this$plham$util$JSONRandom() {
        
        //#line 8 "/home/dsl/workspace/plhamK/plham/util/JSONRandom.x10"
        return plham.util.JSONRandom.this;
    }
    
    
    //#line 8 "/home/dsl/workspace/plhamK/plham/util/JSONRandom.x10"
    final public void __fieldInitializers_plham_util_JSONRandom() {
        
    }
}

