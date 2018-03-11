package cassia.util;

@x10.runtime.impl.java.X10Generated
public interface Receiver<$T> extends x10.core.Any
{
    public static final x10.rtt.RuntimeType<Receiver> $RTT = 
        x10.rtt.NamedType.<Receiver> make("cassia.util.Receiver",
                                          Receiver.class,
                                          1);
    
    

    
    
    //#line 10 "/home/dsl/workspace/plhamK/cassia/util/Receiver.x10"
    /**
     * Add the specified value to a temporary storage.
     *
     * @param value a value of T.
     */
    void receive$V(final java.lang.Object value, x10.rtt.Type t1);
    
    
    //#line 15 "/home/dsl/workspace/plhamK/cassia/util/Receiver.x10"
    /**
     * Store the all saved values to the main storage of ReceiverHolder[T]
     */
    void close();
}

