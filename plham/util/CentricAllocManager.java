package plham.util;



public class CentricAllocManager<$T> extends plham.util.DistAllocManager<$T> implements x10.serialization.X10JavaSerializable
{
    public static final x10.rtt.RuntimeType<CentricAllocManager> $RTT = 
        x10.rtt.NamedType.<CentricAllocManager> make("plham.util.CentricAllocManager",
                                                     CentricAllocManager.class,
                                                     1,
                                                     new x10.rtt.Type[] {
                                                         x10.rtt.ParameterizedType.make(plham.util.DistAllocManager.$RTT, x10.rtt.UnresolvedType.PARAM(0))
                                                     });
    
    public x10.rtt.RuntimeType<?> $getRTT() { return $RTT; }
    
    public x10.rtt.Type<?> $getParam(int i) { if (i == 0) return $T; return null; }
    
    private Object writeReplace() throws java.io.ObjectStreamException {
        return new x10.serialization.SerializationProxy(this);
    }
    
    public static <$T> x10.serialization.X10JavaSerializable $_deserialize_body(plham.util.CentricAllocManager<$T> $_obj, x10.serialization.X10JavaDeserializer $deserializer) throws java.io.IOException {
        if (x10.runtime.impl.java.Runtime.TRACE_SER) { x10.runtime.impl.java.Runtime.printTraceMessage("X10JavaSerializable: $_deserialize_body() of " + CentricAllocManager.class + " calling"); } 
        plham.util.DistAllocManager.$_deserialize_body($_obj, $deserializer);
        $_obj.$T = (x10.rtt.Type) $deserializer.readObject();
        $_obj.body = $deserializer.readObject();
        return $_obj;
    }
    
    public static x10.serialization.X10JavaSerializable $_deserializer(x10.serialization.X10JavaDeserializer $deserializer) throws java.io.IOException {
        plham.util.CentricAllocManager $_obj = new plham.util.CentricAllocManager((java.lang.System[]) null, (x10.rtt.Type) null);
        $deserializer.record_reference($_obj);
        return $_deserialize_body($_obj, $deserializer);
    }
    
    public void $_serialize(x10.serialization.X10JavaSerializer $serializer) throws java.io.IOException {
        super.$_serialize($serializer);
        $serializer.write(this.$T);
        $serializer.write(this.body);
        
    }
    
    // constructor just for allocation
    public CentricAllocManager(final java.lang.System[] $dummy, final x10.rtt.Type $T) {
        super($dummy, $T);
        plham.util.CentricAllocManager.$initParams(this, $T);
        
    }
    
    private x10.rtt.Type $T;
    
    // initializer of type parameters
    public static void $initParams(final CentricAllocManager $this, final x10.rtt.Type $T) {
        $this.$T = $T;
        
    }
    

    
    //#line 6 "/home/dsl/workspace/plhamK/plham/util/CentricAllocManager.x10"
    public x10.util.List<$T> body;
    
    
    //#line 8 "/home/dsl/workspace/plhamK/plham/util/CentricAllocManager.x10"
    // creation method for java code (1-phase java constructor)
    public CentricAllocManager(final x10.rtt.Type $T) {
        this((java.lang.System[]) null, $T);
        plham$util$CentricAllocManager$$init$S();
    }
    
    // constructor for non-virtual call
    final public plham.util.CentricAllocManager<$T> plham$util$CentricAllocManager$$init$S() {
         {
            
            //#line 8 "/home/dsl/workspace/plhamK/plham/util/CentricAllocManager.x10"
            /*super.*/plham$util$DistAllocManager$$init$S();
            
            //#line 8 "/home/dsl/workspace/plhamK/plham/util/CentricAllocManager.x10"
            
            
            //#line 5 "/home/dsl/workspace/plhamK/plham/util/CentricAllocManager.x10"
            this.__fieldInitializers_plham_util_CentricAllocManager();
        }
        return this;
    }
    
    
    
    //#line 9 "/home/dsl/workspace/plhamK/plham/util/CentricAllocManager.x10"
    public cassia.util.RangedList getRangedList(final x10.lang.Place id$414, final cassia.util.JSON.Value config, final x10.lang.LongRange range) {
        
        //#line 10 "/home/dsl/workspace/plhamK/plham/util/CentricAllocManager.x10"
        assert ((this.body) != (null)): "CentricAllocManager: body is null, setTotalCount has not called yet!";
        
        //#line 11 "/home/dsl/workspace/plhamK/plham/util/CentricAllocManager.x10"
        final x10.util.List t$27224 = ((this.body));
        
        //#line 11 "/home/dsl/workspace/plhamK/plham/util/CentricAllocManager.x10"
        final cassia.util.RangedListView t$27225 = ((new cassia.util.RangedListView<$T>((java.lang.System[]) null, $T).cassia$util$RangedListView$$init$S(t$27224, ((range)), (cassia.util.RangedListView.__0$1cassia$util$RangedListView$$T$2) null)));
        
        //#line 11 "/home/dsl/workspace/plhamK/plham/util/CentricAllocManager.x10"
        return t$27225;
    }
    
    
    //#line 13 "/home/dsl/workspace/plhamK/plham/util/CentricAllocManager.x10"
    public void setTotalCount(final long size) {
        
        //#line 14 "/home/dsl/workspace/plhamK/plham/util/CentricAllocManager.x10"
        final x10.util.ArrayList t$27226 = ((new x10.util.ArrayList<$T>((java.lang.System[]) null, $T).x10$util$ArrayList$$init$S(((size)))));
        
        //#line 14 "/home/dsl/workspace/plhamK/plham/util/CentricAllocManager.x10"
        this.body = ((t$27226));
    }
    
    
    //#line 16 "/home/dsl/workspace/plhamK/plham/util/CentricAllocManager.x10"
    public x10.util.List getBody() {
        
        //#line 16 "/home/dsl/workspace/plhamK/plham/util/CentricAllocManager.x10"
        final x10.util.List t$27227 = ((this.body));
        
        //#line 16 "/home/dsl/workspace/plhamK/plham/util/CentricAllocManager.x10"
        return t$27227;
    }
    
    
    //#line 5 "/home/dsl/workspace/plhamK/plham/util/CentricAllocManager.x10"
    final public plham.util.CentricAllocManager plham$util$CentricAllocManager$$this$plham$util$CentricAllocManager() {
        
        //#line 5 "/home/dsl/workspace/plhamK/plham/util/CentricAllocManager.x10"
        return plham.util.CentricAllocManager.this;
    }
    
    
    //#line 5 "/home/dsl/workspace/plhamK/plham/util/CentricAllocManager.x10"
    final public void __fieldInitializers_plham_util_CentricAllocManager() {
        
        //#line 5 "/home/dsl/workspace/plhamK/plham/util/CentricAllocManager.x10"
        this.body = null;
    }
}

