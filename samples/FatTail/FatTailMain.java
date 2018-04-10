package samples.FatTail;


@x10.runtime.impl.java.X10Generated
public class FatTailMain extends samples.CI2002.CI2002Main implements x10.serialization.X10JavaSerializable
{
    public static final x10.rtt.RuntimeType<FatTailMain> $RTT = 
        x10.rtt.NamedType.<FatTailMain> make("samples.FatTail.FatTailMain",
                                             FatTailMain.class,
                                             new x10.rtt.Type[] {
                                                 samples.CI2002.CI2002Main.$RTT
                                             });
    
    public x10.rtt.RuntimeType<?> $getRTT() { return $RTT; }
    
    public x10.rtt.Type<?> $getParam(int i) { return null; }
    
    private Object writeReplace() throws java.io.ObjectStreamException {
        return new x10.serialization.SerializationProxy(this);
    }
    
    public static x10.serialization.X10JavaSerializable $_deserialize_body(samples.FatTail.FatTailMain $_obj, x10.serialization.X10JavaDeserializer $deserializer) throws java.io.IOException {
        if (x10.runtime.impl.java.Runtime.TRACE_SER) { x10.runtime.impl.java.Runtime.printTraceMessage("X10JavaSerializable: $_deserialize_body() of " + FatTailMain.class + " calling"); } 
        samples.CI2002.CI2002Main.$_deserialize_body($_obj, $deserializer);
        return $_obj;
    }
    
    public static x10.serialization.X10JavaSerializable $_deserializer(x10.serialization.X10JavaDeserializer $deserializer) throws java.io.IOException {
        samples.FatTail.FatTailMain $_obj = new samples.FatTail.FatTailMain((java.lang.System[]) null);
        $deserializer.record_reference($_obj);
        return $_deserialize_body($_obj, $deserializer);
    }
    
    public void $_serialize(x10.serialization.X10JavaSerializer $serializer) throws java.io.IOException {
        super.$_serialize($serializer);
        
    }
    
    // constructor just for allocation
    public FatTailMain(final java.lang.System[] $dummy) {
        super($dummy);
        
    }
    
    

    
    
    //#line 9 "samples/FatTail/FatTailMain.x10"
    public static class $Main extends x10.runtime.impl.java.Runtime
    {
        // java main method
        public static void main(java.lang.String[] args) {
            // start native runtime
            new $Main().start(args);
        }
        
        // called by native runtime inside main x10 thread
        public void runtimeCallback(final x10.core.Rail<java.lang.String> args) {
            // call the original app-main method
            FatTailMain.main(args);
        }
    }
    
    // the original app-main method
    public static void main(final x10.core.Rail<java.lang.String> args) {
        
        //#line 10 "samples/FatTail/FatTailMain.x10"
        final samples.FatTail.FatTailMain sim = ((samples.FatTail.FatTailMain)(new samples.FatTail.FatTailMain((java.lang.System[]) null).samples$FatTail$FatTailMain$$init$S()));
        
        //#line 11 "samples/FatTail/FatTailMain.x10"
        plham.agent.FCNAgent.register(((plham.main.Simulator)(sim)));
        
        //#line 12 "samples/FatTail/FatTailMain.x10"
        plham.Market.register(((plham.main.Simulator)(sim)));
        
        //#line 13 "samples/FatTail/FatTailMain.x10"
        final plham.main.SequentialRunner t$20024 = ((plham.main.SequentialRunner)(new plham.main.SequentialRunner<samples.FatTail.FatTailMain>((java.lang.System[]) null, samples.FatTail.FatTailMain.$RTT).plham$main$SequentialRunner$$init$S(sim, (plham.main.SequentialRunner.__0plham$main$SequentialRunner$$B) null)));
        
        //#line 13 "samples/FatTail/FatTailMain.x10"
        ((plham.main.Runner<samples.FatTail.FatTailMain>)t$20024).run__0$1x10$lang$String$2(((x10.core.Rail)(args)));
    }
    
    
    //#line 7 "samples/FatTail/FatTailMain.x10"
    final public samples.FatTail.FatTailMain samples$FatTail$FatTailMain$$this$samples$FatTail$FatTailMain() {
        
        //#line 7 "samples/FatTail/FatTailMain.x10"
        return samples.FatTail.FatTailMain.this;
    }
    
    
    //#line 7 "samples/FatTail/FatTailMain.x10"
    // creation method for java code (1-phase java constructor)
    public FatTailMain() {
        this((java.lang.System[]) null);
        samples$FatTail$FatTailMain$$init$S();
    }
    
    // constructor for non-virtual call
    final public samples.FatTail.FatTailMain samples$FatTail$FatTailMain$$init$S() {
         {
            
            //#line 7 "samples/FatTail/FatTailMain.x10"
            /*super.*/samples$CI2002$CI2002Main$$init$S();
            
            //#line 7 "samples/FatTail/FatTailMain.x10"
            
            
            //#line 7 "samples/FatTail/FatTailMain.x10"
            this.__fieldInitializers_samples_FatTail_FatTailMain();
        }
        return this;
    }
    
    
    
    //#line 7 "samples/FatTail/FatTailMain.x10"
    final public void __fieldInitializers_samples_FatTail_FatTailMain() {
        
    }
}

