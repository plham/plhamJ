package plham.util;


public class NumericalException extends java.lang.RuntimeException implements x10.serialization.X10JavaSerializable
{
    public static final x10.rtt.RuntimeType<NumericalException> $RTT = 
        x10.rtt.NamedType.<NumericalException> make("plham.util.NumericalException",
                                                    NumericalException.class,
                                                    new x10.rtt.Type[] {
                                                        x10.rtt.Types.EXCEPTION
                                                    });
    
    public x10.rtt.RuntimeType<?> $getRTT() { return $RTT; }
    
    public x10.rtt.Type<?> $getParam(int i) { return null; }
    
    private Object writeReplace() throws java.io.ObjectStreamException {
        return new x10.serialization.SerializationProxy(this);
    }
    
    public static x10.serialization.X10JavaSerializable $_deserialize_body(plham.util.NumericalException $_obj, x10.serialization.X10JavaDeserializer $deserializer) throws java.io.IOException {
        if (x10.runtime.impl.java.Runtime.TRACE_SER) { x10.runtime.impl.java.Runtime.printTraceMessage("X10JavaSerializable: $_deserialize_body() of " + NumericalException.class + " calling"); } 
        $deserializer.deserializeFieldsStartingFromClass(java.lang.RuntimeException.class, $_obj, 0);
        return $_obj;
    }
    
    public static x10.serialization.X10JavaSerializable $_deserializer(x10.serialization.X10JavaDeserializer $deserializer) throws java.io.IOException {
        plham.util.NumericalException $_obj = new plham.util.NumericalException((java.lang.System[]) null);
        $deserializer.record_reference($_obj);
        return $_deserialize_body($_obj, $deserializer);
    }
    
    public void $_serialize(x10.serialization.X10JavaSerializer $serializer) throws java.io.IOException {
        $serializer.serializeFieldsStartingFromClass(this, java.lang.RuntimeException.class);
        
    }
    
    // constructor just for allocation
    public NumericalException(final java.lang.System[] $dummy) {
        
    }
    
    

    
    
    //#line 5 "/home/dsl/workspace/plhamK/plham/util/NumericalException.x10"
    public NumericalException(final java.lang.String message) {
        super(((message)));
         {
            
            //#line 5 "/home/dsl/workspace/plhamK/plham/util/NumericalException.x10"
            
            
            //#line 3 "/home/dsl/workspace/plhamK/plham/util/NumericalException.x10"
            this.__fieldInitializers_plham_util_NumericalException();
        }
    }
    
    
    
    //#line 3 "/home/dsl/workspace/plhamK/plham/util/NumericalException.x10"
    final public plham.util.NumericalException plham$util$NumericalException$$this$plham$util$NumericalException() {
        
        //#line 3 "/home/dsl/workspace/plhamK/plham/util/NumericalException.x10"
        return plham.util.NumericalException.this;
    }
    
    
    //#line 3 "/home/dsl/workspace/plhamK/plham/util/NumericalException.x10"
    final public void __fieldInitializers_plham_util_NumericalException() {
        
    }
}

