package plham.index;



abstract public class IndexScheme extends x10.core.Ref implements x10.serialization.X10JavaSerializable
{
    public static final x10.rtt.RuntimeType<IndexScheme> $RTT = 
        x10.rtt.NamedType.<IndexScheme> make("plham.index.IndexScheme",
                                             IndexScheme.class);
    
    public x10.rtt.RuntimeType<?> $getRTT() { return $RTT; }
    
    public x10.rtt.Type<?> $getParam(int i) { return null; }
    
    public static x10.serialization.X10JavaSerializable $_deserialize_body(plham.index.IndexScheme $_obj, x10.serialization.X10JavaDeserializer $deserializer) throws java.io.IOException {
        if (x10.runtime.impl.java.Runtime.TRACE_SER) { x10.runtime.impl.java.Runtime.printTraceMessage("X10JavaSerializable: $_deserialize_body() of " + IndexScheme.class + " calling"); } 
        return $_obj;
    }
    
    public static x10.serialization.X10JavaSerializable $_deserializer(x10.serialization.X10JavaDeserializer $deserializer) throws java.io.IOException {
        return null;
    }
    
    public void $_serialize(x10.serialization.X10JavaSerializer $serializer) throws java.io.IOException {
        
    }
    
    // constructor just for allocation
    public IndexScheme(final java.lang.System[] $dummy) {
        
    }
    
    

    
    
    //#line 7 "/home/dsl/workspace/plhamK/plham/index/IndexScheme.x10"
    abstract public double getIndex__0$1plham$Market$2$O(final x10.util.Indexed markets);
    
    
    //#line 9 "/home/dsl/workspace/plhamK/plham/index/IndexScheme.x10"
    abstract public double getIndex__0$1plham$Market$2__1$1x10$lang$Long$2$O(final x10.util.Indexed markets, final x10.util.Indexed components);
    
    
    //#line 11 "/home/dsl/workspace/plhamK/plham/index/IndexScheme.x10"
    abstract public double getWeight$O(final plham.Market market);
    
    
    //#line 13 "/home/dsl/workspace/plhamK/plham/index/IndexScheme.x10"
    abstract public double getPrice$O(final plham.Market market);
    
    
    //#line 5 "/home/dsl/workspace/plhamK/plham/index/IndexScheme.x10"
    final public plham.index.IndexScheme plham$index$IndexScheme$$this$plham$index$IndexScheme() {
        
        //#line 5 "/home/dsl/workspace/plhamK/plham/index/IndexScheme.x10"
        return plham.index.IndexScheme.this;
    }
    
    
    //#line 5 "/home/dsl/workspace/plhamK/plham/index/IndexScheme.x10"
    
    // constructor for non-virtual call
    final public plham.index.IndexScheme plham$index$IndexScheme$$init$S() {
         {
            
            //#line 5 "/home/dsl/workspace/plhamK/plham/index/IndexScheme.x10"
            
            
            //#line 5 "/home/dsl/workspace/plhamK/plham/index/IndexScheme.x10"
            this.__fieldInitializers_plham_index_IndexScheme();
        }
        return this;
    }
    
    
    
    //#line 5 "/home/dsl/workspace/plhamK/plham/index/IndexScheme.x10"
    final public void __fieldInitializers_plham_index_IndexScheme() {
        
    }
}

