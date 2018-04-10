package samples.PriceLimit;


@x10.runtime.impl.java.X10Generated
public class PriceLimitMain extends samples.CI2002.CI2002Main implements x10.serialization.X10JavaSerializable
{
    public static final x10.rtt.RuntimeType<PriceLimitMain> $RTT = 
        x10.rtt.NamedType.<PriceLimitMain> make("samples.PriceLimit.PriceLimitMain",
                                                PriceLimitMain.class,
                                                new x10.rtt.Type[] {
                                                    samples.CI2002.CI2002Main.$RTT
                                                });
    
    public x10.rtt.RuntimeType<?> $getRTT() { return $RTT; }
    
    public x10.rtt.Type<?> $getParam(int i) { return null; }
    
    private Object writeReplace() throws java.io.ObjectStreamException {
        return new x10.serialization.SerializationProxy(this);
    }
    
    public static x10.serialization.X10JavaSerializable $_deserialize_body(samples.PriceLimit.PriceLimitMain $_obj, x10.serialization.X10JavaDeserializer $deserializer) throws java.io.IOException {
        if (x10.runtime.impl.java.Runtime.TRACE_SER) { x10.runtime.impl.java.Runtime.printTraceMessage("X10JavaSerializable: $_deserialize_body() of " + PriceLimitMain.class + " calling"); } 
        samples.CI2002.CI2002Main.$_deserialize_body($_obj, $deserializer);
        return $_obj;
    }
    
    public static x10.serialization.X10JavaSerializable $_deserializer(x10.serialization.X10JavaDeserializer $deserializer) throws java.io.IOException {
        samples.PriceLimit.PriceLimitMain $_obj = new samples.PriceLimit.PriceLimitMain((java.lang.System[]) null);
        $deserializer.record_reference($_obj);
        return $_deserialize_body($_obj, $deserializer);
    }
    
    public void $_serialize(x10.serialization.X10JavaSerializer $serializer) throws java.io.IOException {
        super.$_serialize($serializer);
        
    }
    
    // constructor just for allocation
    public PriceLimitMain(final java.lang.System[] $dummy) {
        super($dummy);
        
    }
    
    

    
    
    //#line 16 "samples/PriceLimit/PriceLimitMain.x10"
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
            PriceLimitMain.main(args);
        }
    }
    
    // the original app-main method
    public static void main(final x10.core.Rail<java.lang.String> args) {
        
        //#line 17 "samples/PriceLimit/PriceLimitMain.x10"
        final samples.PriceLimit.PriceLimitMain sim = ((samples.PriceLimit.PriceLimitMain)(new samples.PriceLimit.PriceLimitMain((java.lang.System[]) null).samples$PriceLimit$PriceLimitMain$$init$S()));
        
        //#line 18 "samples/PriceLimit/PriceLimitMain.x10"
        samples.PriceLimit.PriceLimitFCNAgent.register(((plham.main.Simulator)(sim)));
        
        //#line 19 "samples/PriceLimit/PriceLimitMain.x10"
        plham.Market.register(((plham.main.Simulator)(sim)));
        
        //#line 20 "samples/PriceLimit/PriceLimitMain.x10"
        plham.event.PriceLimitRule.register(((plham.main.Simulator)(sim)));
        
        //#line 21 "samples/PriceLimit/PriceLimitMain.x10"
        final plham.main.SequentialRunner t$20104 = ((plham.main.SequentialRunner)(new plham.main.SequentialRunner<samples.PriceLimit.PriceLimitMain>((java.lang.System[]) null, samples.PriceLimit.PriceLimitMain.$RTT).plham$main$SequentialRunner$$init$S(sim, (plham.main.SequentialRunner.__0plham$main$SequentialRunner$$B) null)));
        
        //#line 21 "samples/PriceLimit/PriceLimitMain.x10"
        ((plham.main.Runner<samples.PriceLimit.PriceLimitMain>)t$20104).run__0$1x10$lang$String$2(((x10.core.Rail)(args)));
    }
    
    
    //#line 14 "samples/PriceLimit/PriceLimitMain.x10"
    final public samples.PriceLimit.PriceLimitMain samples$PriceLimit$PriceLimitMain$$this$samples$PriceLimit$PriceLimitMain() {
        
        //#line 14 "samples/PriceLimit/PriceLimitMain.x10"
        return samples.PriceLimit.PriceLimitMain.this;
    }
    
    
    //#line 14 "samples/PriceLimit/PriceLimitMain.x10"
    // creation method for java code (1-phase java constructor)
    public PriceLimitMain() {
        this((java.lang.System[]) null);
        samples$PriceLimit$PriceLimitMain$$init$S();
    }
    
    // constructor for non-virtual call
    final public samples.PriceLimit.PriceLimitMain samples$PriceLimit$PriceLimitMain$$init$S() {
         {
            
            //#line 14 "samples/PriceLimit/PriceLimitMain.x10"
            /*super.*/samples$CI2002$CI2002Main$$init$S();
            
            //#line 14 "samples/PriceLimit/PriceLimitMain.x10"
            
            
            //#line 14 "samples/PriceLimit/PriceLimitMain.x10"
            this.__fieldInitializers_samples_PriceLimit_PriceLimitMain();
        }
        return this;
    }
    
    
    
    //#line 14 "samples/PriceLimit/PriceLimitMain.x10"
    final public void __fieldInitializers_samples_PriceLimit_PriceLimitMain() {
        
    }
}

