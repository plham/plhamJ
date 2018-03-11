package plham;

/**
 * A class for shared clocks.
 * For system use only.
 */

public class Time extends x10.core.Ref implements x10.serialization.X10JavaSerializable
{
    public static final x10.rtt.RuntimeType<Time> $RTT = 
        x10.rtt.NamedType.<Time> make("plham.Time",
                                      Time.class);
    
    public x10.rtt.RuntimeType<?> $getRTT() { return $RTT; }
    
    public x10.rtt.Type<?> $getParam(int i) { return null; }
    
    private Object writeReplace() throws java.io.ObjectStreamException {
        return new x10.serialization.SerializationProxy(this);
    }
    
    public static x10.serialization.X10JavaSerializable $_deserialize_body(plham.Time $_obj, x10.serialization.X10JavaDeserializer $deserializer) throws java.io.IOException {
        if (x10.runtime.impl.java.Runtime.TRACE_SER) { x10.runtime.impl.java.Runtime.printTraceMessage("X10JavaSerializable: $_deserialize_body() of " + Time.class + " calling"); } 
        $_obj.t = $deserializer.readLong();
        return $_obj;
    }
    
    public static x10.serialization.X10JavaSerializable $_deserializer(x10.serialization.X10JavaDeserializer $deserializer) throws java.io.IOException {
        plham.Time $_obj = new plham.Time((java.lang.System[]) null);
        $deserializer.record_reference($_obj);
        return $_deserialize_body($_obj, $deserializer);
    }
    
    public void $_serialize(x10.serialization.X10JavaSerializer $serializer) throws java.io.IOException {
        $serializer.write(this.t);
        
    }
    
    // constructor just for allocation
    public Time(final java.lang.System[] $dummy) {
        
    }
    
    

    
    //#line 9 "/home/dsl/workspace/plhamK/plham/Time.x10"
    public long t;
    
    
    //#line 11 "/home/dsl/workspace/plhamK/plham/Time.x10"
    // creation method for java code (1-phase java constructor)
    public Time(final long t) {
        this((java.lang.System[]) null);
        plham$Time$$init$S(t);
    }
    
    // constructor for non-virtual call
    final public plham.Time plham$Time$$init$S(final long t) {
         {
            
            //#line 11 "/home/dsl/workspace/plhamK/plham/Time.x10"
            
            
            //#line 7 "/home/dsl/workspace/plhamK/plham/Time.x10"
            this.__fieldInitializers_plham_Time();
            
            //#line 12 "/home/dsl/workspace/plhamK/plham/Time.x10"
            this.t = t;
        }
        return this;
    }
    
    
    
    //#line 7 "/home/dsl/workspace/plhamK/plham/Time.x10"
    final public plham.Time plham$Time$$this$plham$Time() {
        
        //#line 7 "/home/dsl/workspace/plhamK/plham/Time.x10"
        return plham.Time.this;
    }
    
    
    //#line 7 "/home/dsl/workspace/plhamK/plham/Time.x10"
    final public void __fieldInitializers_plham_Time() {
        
        //#line 7 "/home/dsl/workspace/plhamK/plham/Time.x10"
        this.t = 0L;
    }
}

