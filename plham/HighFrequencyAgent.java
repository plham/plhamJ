package plham;


/**
 * A marker class for high-frequency trading agents.
 */

abstract public class HighFrequencyAgent extends plham.Agent implements x10.serialization.X10JavaSerializable
{
    public static final x10.rtt.RuntimeType<HighFrequencyAgent> $RTT = 
        x10.rtt.NamedType.<HighFrequencyAgent> make("plham.HighFrequencyAgent",
                                                    HighFrequencyAgent.class,
                                                    new x10.rtt.Type[] {
                                                        plham.Agent.$RTT
                                                    });
    
    public x10.rtt.RuntimeType<?> $getRTT() { return $RTT; }
    
    public x10.rtt.Type<?> $getParam(int i) { return null; }
    
    public static x10.serialization.X10JavaSerializable $_deserialize_body(plham.HighFrequencyAgent $_obj, x10.serialization.X10JavaDeserializer $deserializer) throws java.io.IOException {
        if (x10.runtime.impl.java.Runtime.TRACE_SER) { x10.runtime.impl.java.Runtime.printTraceMessage("X10JavaSerializable: $_deserialize_body() of " + HighFrequencyAgent.class + " calling"); } 
        plham.Agent.$_deserialize_body($_obj, $deserializer);
        return $_obj;
    }
    
    public static x10.serialization.X10JavaSerializable $_deserializer(x10.serialization.X10JavaDeserializer $deserializer) throws java.io.IOException {
        return null;
    }
    
    public void $_serialize(x10.serialization.X10JavaSerializer $serializer) throws java.io.IOException {
        super.$_serialize($serializer);
        
    }
    
    // constructor just for allocation
    public HighFrequencyAgent(final java.lang.System[] $dummy) {
        super($dummy);
        
    }
    
    

    
    
    //#line 8 "/home/dsl/workspace/plhamK/plham/HighFrequencyAgent.x10"
    
    // constructor for non-virtual call
    final public plham.HighFrequencyAgent plham$HighFrequencyAgent$$init$S(final long id, final java.lang.String name, final x10.util.Random random) {
         {
            
            //#line 8 "/home/dsl/workspace/plhamK/plham/HighFrequencyAgent.x10"
            /*super.*/initAgent(((id)), ((name)), ((random)));
            
            //#line 8 "/home/dsl/workspace/plhamK/plham/HighFrequencyAgent.x10"
            
            
            //#line 7 "/home/dsl/workspace/plhamK/plham/HighFrequencyAgent.x10"
            this.__fieldInitializers_plham_HighFrequencyAgent();
        }
        return this;
    }
    
    
    
    //#line 7 "/home/dsl/workspace/plhamK/plham/HighFrequencyAgent.x10"
    final public plham.HighFrequencyAgent plham$HighFrequencyAgent$$this$plham$HighFrequencyAgent() {
        
        //#line 7 "/home/dsl/workspace/plhamK/plham/HighFrequencyAgent.x10"
        return plham.HighFrequencyAgent.this;
    }
    
    
    //#line 7 "/home/dsl/workspace/plhamK/plham/HighFrequencyAgent.x10"
    final public void __fieldInitializers_plham_HighFrequencyAgent() {
        
    }
}

