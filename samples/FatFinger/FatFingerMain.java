package samples.FatFinger;


@x10.runtime.impl.java.X10Generated
public class FatFingerMain extends samples.CI2002.CI2002Main implements x10.serialization.X10JavaSerializable
{
    public static final x10.rtt.RuntimeType<FatFingerMain> $RTT = 
        x10.rtt.NamedType.<FatFingerMain> make("samples.FatFinger.FatFingerMain",
                                               FatFingerMain.class,
                                               new x10.rtt.Type[] {
                                                   samples.CI2002.CI2002Main.$RTT
                                               });
    
    public x10.rtt.RuntimeType<?> $getRTT() { return $RTT; }
    
    public x10.rtt.Type<?> $getParam(int i) { return null; }
    
    private Object writeReplace() throws java.io.ObjectStreamException {
        return new x10.serialization.SerializationProxy(this);
    }
    
    public static x10.serialization.X10JavaSerializable $_deserialize_body(samples.FatFinger.FatFingerMain $_obj, x10.serialization.X10JavaDeserializer $deserializer) throws java.io.IOException {
        if (x10.runtime.impl.java.Runtime.TRACE_SER) { x10.runtime.impl.java.Runtime.printTraceMessage("X10JavaSerializable: $_deserialize_body() of " + FatFingerMain.class + " calling"); } 
        samples.CI2002.CI2002Main.$_deserialize_body($_obj, $deserializer);
        return $_obj;
    }
    
    public static x10.serialization.X10JavaSerializable $_deserializer(x10.serialization.X10JavaDeserializer $deserializer) throws java.io.IOException {
        samples.FatFinger.FatFingerMain $_obj = new samples.FatFinger.FatFingerMain((java.lang.System[]) null);
        $deserializer.record_reference($_obj);
        return $_deserialize_body($_obj, $deserializer);
    }
    
    public void $_serialize(x10.serialization.X10JavaSerializer $serializer) throws java.io.IOException {
        super.$_serialize($serializer);
        
    }
    
    // constructor just for allocation
    public FatFingerMain(final java.lang.System[] $dummy) {
        super($dummy);
        
    }
    
    

    
    
    //#line 17 "samples/FatFinger/FatFingerMain.x10"
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
            FatFingerMain.main(args);
        }
    }
    
    // the original app-main method
    public static void main(final x10.core.Rail<java.lang.String> args) {
        
        //#line 18 "samples/FatFinger/FatFingerMain.x10"
        final samples.FatFinger.FatFingerMain sim = ((samples.FatFinger.FatFingerMain)(new samples.FatFinger.FatFingerMain((java.lang.System[]) null).samples$FatFinger$FatFingerMain$$init$S()));
        
        //#line 19 "samples/FatFinger/FatFingerMain.x10"
        plham.agent.FCNAgent.register(((plham.main.Simulator)(sim)));
        
        //#line 20 "samples/FatFinger/FatFingerMain.x10"
        plham.Market.register(((plham.main.Simulator)(sim)));
        
        //#line 21 "samples/FatFinger/FatFingerMain.x10"
        plham.event.OrderMistakeShock.register(((plham.main.Simulator)(sim)));
        
        //#line 22 "samples/FatFinger/FatFingerMain.x10"
        final plham.main.SequentialRunner t$20081 = ((plham.main.SequentialRunner)(new plham.main.SequentialRunner<samples.FatFinger.FatFingerMain>((java.lang.System[]) null, samples.FatFinger.FatFingerMain.$RTT).plham$main$SequentialRunner$$init$S(sim, (plham.main.SequentialRunner.__0plham$main$SequentialRunner$$B) null)));
        
        //#line 22 "samples/FatFinger/FatFingerMain.x10"
        ((plham.main.Runner<samples.FatFinger.FatFingerMain>)t$20081).run__0$1x10$lang$String$2(((x10.core.Rail)(args)));
    }
    
    
    //#line 25 "samples/FatFinger/FatFingerMain.x10"
    public void print(final java.lang.String sessionName) {
        
        //#line 26 "samples/FatFinger/FatFingerMain.x10"
        super.print(((java.lang.String)(sessionName)));
        
        //#line 27 "samples/FatFinger/FatFingerMain.x10"
        final x10.util.List markets = this.getMarketsByName(((java.lang.String)("markets")));
        
        //#line 28 "samples/FatFinger/FatFingerMain.x10"
        final x10.util.ListIterator market$20089 = ((x10.util.ListIterator<plham.Market>)
                                                     ((x10.util.List<plham.Market>)markets).iterator());
        
        //#line 28 "samples/FatFinger/FatFingerMain.x10"
        for (;
             true;
             ) {
            
            //#line 28 "samples/FatFinger/FatFingerMain.x10"
            final boolean t$20090 = ((x10.util.ListIterator<plham.Market>)market$20089).hasNext$O();
            
            //#line 28 "samples/FatFinger/FatFingerMain.x10"
            if (!(t$20090)) {
                
                //#line 28 "samples/FatFinger/FatFingerMain.x10"
                break;
            }
            
            //#line 28 "samples/FatFinger/FatFingerMain.x10"
            final plham.Market market$20086 = ((plham.Market)(((x10.util.ListIterator<plham.Market>)market$20089).next$G()));
            
            //#line 29 "samples/FatFinger/FatFingerMain.x10"
            final plham.OrderBook t$20087 = ((plham.OrderBook)(market$20086.getBuyOrderBook()));
            
            //#line 29 "samples/FatFinger/FatFingerMain.x10"
            t$20087.dump();
            
            //#line 30 "samples/FatFinger/FatFingerMain.x10"
            final plham.OrderBook t$20088 = ((plham.OrderBook)(market$20086.getSellOrderBook()));
            
            //#line 30 "samples/FatFinger/FatFingerMain.x10"
            t$20088.dump();
        }
    }
    
    
    //#line 15 "samples/FatFinger/FatFingerMain.x10"
    final public samples.FatFinger.FatFingerMain samples$FatFinger$FatFingerMain$$this$samples$FatFinger$FatFingerMain() {
        
        //#line 15 "samples/FatFinger/FatFingerMain.x10"
        return samples.FatFinger.FatFingerMain.this;
    }
    
    
    //#line 15 "samples/FatFinger/FatFingerMain.x10"
    // creation method for java code (1-phase java constructor)
    public FatFingerMain() {
        this((java.lang.System[]) null);
        samples$FatFinger$FatFingerMain$$init$S();
    }
    
    // constructor for non-virtual call
    final public samples.FatFinger.FatFingerMain samples$FatFinger$FatFingerMain$$init$S() {
         {
            
            //#line 15 "samples/FatFinger/FatFingerMain.x10"
            /*super.*/samples$CI2002$CI2002Main$$init$S();
            
            //#line 15 "samples/FatFinger/FatFingerMain.x10"
            
            
            //#line 15 "samples/FatFinger/FatFingerMain.x10"
            this.__fieldInitializers_samples_FatFinger_FatFingerMain();
        }
        return this;
    }
    
    
    
    //#line 15 "samples/FatFinger/FatFingerMain.x10"
    final public void __fieldInitializers_samples_FatFinger_FatFingerMain() {
        
    }
    
    public void samples$CI2002$CI2002Main$print$S(final java.lang.String a0) {
        super.print(((java.lang.String)(a0)));
    }
}

