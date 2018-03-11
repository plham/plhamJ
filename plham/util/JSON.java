package plham.util;

/**
 * A dummy class.
 * @see cassia.util.JSON.
 */

public class JSON extends cassia.util.JSON implements x10.serialization.X10JavaSerializable
{
    public static final x10.rtt.RuntimeType<JSON> $RTT = 
        x10.rtt.NamedType.<JSON> make("plham.util.JSON",
                                      JSON.class,
                                      new x10.rtt.Type[] {
                                          cassia.util.JSON.$RTT
                                      });
    
    public x10.rtt.RuntimeType<?> $getRTT() { return $RTT; }
    
    public x10.rtt.Type<?> $getParam(int i) { return null; }
    
    private Object writeReplace() throws java.io.ObjectStreamException {
        return new x10.serialization.SerializationProxy(this);
    }
    
    public static x10.serialization.X10JavaSerializable $_deserialize_body(plham.util.JSON $_obj, x10.serialization.X10JavaDeserializer $deserializer) throws java.io.IOException {
        if (x10.runtime.impl.java.Runtime.TRACE_SER) { x10.runtime.impl.java.Runtime.printTraceMessage("X10JavaSerializable: $_deserialize_body() of " + JSON.class + " calling"); } 
        cassia.util.JSON.$_deserialize_body($_obj, $deserializer);
        return $_obj;
    }
    
    public static x10.serialization.X10JavaSerializable $_deserializer(x10.serialization.X10JavaDeserializer $deserializer) throws java.io.IOException {
        plham.util.JSON $_obj = new plham.util.JSON((java.lang.System[]) null);
        $deserializer.record_reference($_obj);
        return $_deserialize_body($_obj, $deserializer);
    }
    
    public void $_serialize(x10.serialization.X10JavaSerializer $serializer) throws java.io.IOException {
        super.$_serialize($serializer);
        
    }
    
    // constructor just for allocation
    public JSON(final java.lang.System[] $dummy) {
        super($dummy);
        
    }
    
    

    
    
    //#line 7 "/home/dsl/workspace/plhamK/plham/util/JSON.x10"
    final public plham.util.JSON plham$util$JSON$$this$plham$util$JSON() {
        
        //#line 7 "/home/dsl/workspace/plhamK/plham/util/JSON.x10"
        return plham.util.JSON.this;
    }
    
    
    //#line 7 "/home/dsl/workspace/plhamK/plham/util/JSON.x10"
    // creation method for java code (1-phase java constructor)
    public JSON() {
        this((java.lang.System[]) null);
        plham$util$JSON$$init$S();
    }
    
    // constructor for non-virtual call
    final public plham.util.JSON plham$util$JSON$$init$S() {
         {
            
            //#line 7 "/home/dsl/workspace/plhamK/plham/util/JSON.x10"
            /*super.*/cassia$util$JSON$$init$S();
            
            //#line 7 "/home/dsl/workspace/plhamK/plham/util/JSON.x10"
            
            
            //#line 7 "/home/dsl/workspace/plhamK/plham/util/JSON.x10"
            this.__fieldInitializers_plham_util_JSON();
        }
        return this;
    }
    
    
    
    //#line 7 "/home/dsl/workspace/plhamK/plham/util/JSON.x10"
    final public void __fieldInitializers_plham_util_JSON() {
        
    }
}

