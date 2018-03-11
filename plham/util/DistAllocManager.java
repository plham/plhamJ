package plham.util;



abstract public class DistAllocManager<$T> extends x10.core.Ref implements x10.serialization.X10JavaSerializable
{
    public static final x10.rtt.RuntimeType<DistAllocManager> $RTT = 
        x10.rtt.NamedType.<DistAllocManager> make("plham.util.DistAllocManager",
                                                  DistAllocManager.class,
                                                  1);
    
    public x10.rtt.RuntimeType<?> $getRTT() { return $RTT; }
    
    public x10.rtt.Type<?> $getParam(int i) { if (i == 0) return $T; return null; }
    
    public static <$T> x10.serialization.X10JavaSerializable $_deserialize_body(plham.util.DistAllocManager<$T> $_obj, x10.serialization.X10JavaDeserializer $deserializer) throws java.io.IOException {
        if (x10.runtime.impl.java.Runtime.TRACE_SER) { x10.runtime.impl.java.Runtime.printTraceMessage("X10JavaSerializable: $_deserialize_body() of " + DistAllocManager.class + " calling"); } 
        $_obj.$T = (x10.rtt.Type) $deserializer.readObject();
        return $_obj;
    }
    
    public static x10.serialization.X10JavaSerializable $_deserializer(x10.serialization.X10JavaDeserializer $deserializer) throws java.io.IOException {
        return null;
    }
    
    public void $_serialize(x10.serialization.X10JavaSerializer $serializer) throws java.io.IOException {
        $serializer.write(this.$T);
        
    }
    
    // constructor just for allocation
    public DistAllocManager(final java.lang.System[] $dummy, final x10.rtt.Type $T) {
        plham.util.DistAllocManager.$initParams(this, $T);
        
    }
    
    private x10.rtt.Type $T;
    
    // initializer of type parameters
    public static void $initParams(final DistAllocManager $this, final x10.rtt.Type $T) {
        $this.$T = $T;
        
    }
    

    
    
    //#line 6 "/home/dsl/workspace/plhamK/plham/util/DistAllocManager.x10"
    abstract public cassia.util.RangedList getRangedList(final x10.lang.Place id$415, final cassia.util.JSON.Value config, final x10.lang.LongRange id$416);
    
    
    //#line 7 "/home/dsl/workspace/plhamK/plham/util/DistAllocManager.x10"
    abstract public void setTotalCount(final long size);
    
    
    //#line 5 "/home/dsl/workspace/plhamK/plham/util/DistAllocManager.x10"
    final public plham.util.DistAllocManager plham$util$DistAllocManager$$this$plham$util$DistAllocManager() {
        
        //#line 5 "/home/dsl/workspace/plhamK/plham/util/DistAllocManager.x10"
        return plham.util.DistAllocManager.this;
    }
    
    
    //#line 5 "/home/dsl/workspace/plhamK/plham/util/DistAllocManager.x10"
    
    // constructor for non-virtual call
    final public plham.util.DistAllocManager<$T> plham$util$DistAllocManager$$init$S() {
         {
            
            //#line 5 "/home/dsl/workspace/plhamK/plham/util/DistAllocManager.x10"
            
            
            //#line 5 "/home/dsl/workspace/plhamK/plham/util/DistAllocManager.x10"
            this.__fieldInitializers_plham_util_DistAllocManager();
        }
        return this;
    }
    
    
    
    //#line 5 "/home/dsl/workspace/plhamK/plham/util/DistAllocManager.x10"
    final public void __fieldInitializers_plham_util_DistAllocManager() {
        
    }
}

