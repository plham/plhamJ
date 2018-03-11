package plham.index;



public class CapitalWeightedIndexScheme extends plham.index.AverageIndexScheme implements x10.serialization.X10JavaSerializable
{
    public static final x10.rtt.RuntimeType<CapitalWeightedIndexScheme> $RTT = 
        x10.rtt.NamedType.<CapitalWeightedIndexScheme> make("plham.index.CapitalWeightedIndexScheme",
                                                            CapitalWeightedIndexScheme.class,
                                                            new x10.rtt.Type[] {
                                                                plham.index.AverageIndexScheme.$RTT
                                                            });
    
    public x10.rtt.RuntimeType<?> $getRTT() { return $RTT; }
    
    public x10.rtt.Type<?> $getParam(int i) { return null; }
    
    private Object writeReplace() throws java.io.ObjectStreamException {
        return new x10.serialization.SerializationProxy(this);
    }
    
    public static x10.serialization.X10JavaSerializable $_deserialize_body(plham.index.CapitalWeightedIndexScheme $_obj, x10.serialization.X10JavaDeserializer $deserializer) throws java.io.IOException {
        if (x10.runtime.impl.java.Runtime.TRACE_SER) { x10.runtime.impl.java.Runtime.printTraceMessage("X10JavaSerializable: $_deserialize_body() of " + CapitalWeightedIndexScheme.class + " calling"); } 
        plham.index.AverageIndexScheme.$_deserialize_body($_obj, $deserializer);
        return $_obj;
    }
    
    public static x10.serialization.X10JavaSerializable $_deserializer(x10.serialization.X10JavaDeserializer $deserializer) throws java.io.IOException {
        plham.index.CapitalWeightedIndexScheme $_obj = new plham.index.CapitalWeightedIndexScheme((java.lang.System[]) null);
        $deserializer.record_reference($_obj);
        return $_deserialize_body($_obj, $deserializer);
    }
    
    public void $_serialize(x10.serialization.X10JavaSerializer $serializer) throws java.io.IOException {
        super.$_serialize($serializer);
        
    }
    
    // constructor just for allocation
    public CapitalWeightedIndexScheme(final java.lang.System[] $dummy) {
        super($dummy);
        
    }
    
    // synthetic type for parameter mangling
    public static final class __0$1plham$Market$3x10$lang$Double$2 {}
    

    
    
    //#line 6 "/home/dsl/workspace/plhamK/plham/index/CapitalWeightedIndexScheme.x10"
    // creation method for java code (1-phase java constructor)
    public CapitalWeightedIndexScheme(final x10.core.fun.Fun_0_1<plham.Market,x10.core.Double> get, __0$1plham$Market$3x10$lang$Double$2 $dummy) {
        this((java.lang.System[]) null);
        plham$index$CapitalWeightedIndexScheme$$init$S(get, (plham.index.CapitalWeightedIndexScheme.__0$1plham$Market$3x10$lang$Double$2) null);
    }
    
    // constructor for non-virtual call
    final public plham.index.CapitalWeightedIndexScheme plham$index$CapitalWeightedIndexScheme$$init$S(final x10.core.fun.Fun_0_1<plham.Market,x10.core.Double> get, __0$1plham$Market$3x10$lang$Double$2 $dummy) {
         {
            
            //#line 7 "/home/dsl/workspace/plhamK/plham/index/CapitalWeightedIndexScheme.x10"
            /*super.*/plham$index$AverageIndexScheme$$init$S(((get)), (plham.index.AverageIndexScheme.__0$1plham$Market$3x10$lang$Double$2) null);
            
            //#line 6 "/home/dsl/workspace/plhamK/plham/index/CapitalWeightedIndexScheme.x10"
            
            
            //#line 4 "/home/dsl/workspace/plhamK/plham/index/CapitalWeightedIndexScheme.x10"
            this.__fieldInitializers_plham_index_CapitalWeightedIndexScheme();
        }
        return this;
    }
    
    
    
    //#line 10 "/home/dsl/workspace/plhamK/plham/index/CapitalWeightedIndexScheme.x10"
    public double getWeight$O(final plham.Market market) {
        
        //#line 11 "/home/dsl/workspace/plhamK/plham/index/CapitalWeightedIndexScheme.x10"
        final long t$31963 = market.getOutstandingShares$O();
        
        //#line 11 "/home/dsl/workspace/plhamK/plham/index/CapitalWeightedIndexScheme.x10"
        final double t$31964 = ((((t$31963))));
        
        //#line 11 "/home/dsl/workspace/plhamK/plham/index/CapitalWeightedIndexScheme.x10"
        return t$31964;
    }
    
    
    //#line 4 "/home/dsl/workspace/plhamK/plham/index/CapitalWeightedIndexScheme.x10"
    final public plham.index.CapitalWeightedIndexScheme plham$index$CapitalWeightedIndexScheme$$this$plham$index$CapitalWeightedIndexScheme() {
        
        //#line 4 "/home/dsl/workspace/plhamK/plham/index/CapitalWeightedIndexScheme.x10"
        return plham.index.CapitalWeightedIndexScheme.this;
    }
    
    
    //#line 4 "/home/dsl/workspace/plhamK/plham/index/CapitalWeightedIndexScheme.x10"
    final public void __fieldInitializers_plham_index_CapitalWeightedIndexScheme() {
        
    }
}

