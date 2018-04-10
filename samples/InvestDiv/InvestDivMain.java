package samples.InvestDiv;


/**
 * Reference: Nozaki, Mizuta, Yagi (2016) Investigation of the rule for investment diversification at the time of a market crash using an artificial market (in Japanese).
 */
@x10.runtime.impl.java.X10Generated
public class InvestDivMain extends samples.TradingHalt.TradingHaltMain implements x10.serialization.X10JavaSerializable
{
    public static final x10.rtt.RuntimeType<InvestDivMain> $RTT = 
        x10.rtt.NamedType.<InvestDivMain> make("samples.InvestDiv.InvestDivMain",
                                               InvestDivMain.class,
                                               new x10.rtt.Type[] {
                                                   samples.TradingHalt.TradingHaltMain.$RTT
                                               });
    
    public x10.rtt.RuntimeType<?> $getRTT() { return $RTT; }
    
    public x10.rtt.Type<?> $getParam(int i) { return null; }
    
    private Object writeReplace() throws java.io.ObjectStreamException {
        return new x10.serialization.SerializationProxy(this);
    }
    
    public static x10.serialization.X10JavaSerializable $_deserialize_body(samples.InvestDiv.InvestDivMain $_obj, x10.serialization.X10JavaDeserializer $deserializer) throws java.io.IOException {
        if (x10.runtime.impl.java.Runtime.TRACE_SER) { x10.runtime.impl.java.Runtime.printTraceMessage("X10JavaSerializable: $_deserialize_body() of " + InvestDivMain.class + " calling"); } 
        samples.TradingHalt.TradingHaltMain.$_deserialize_body($_obj, $deserializer);
        return $_obj;
    }
    
    public static x10.serialization.X10JavaSerializable $_deserializer(x10.serialization.X10JavaDeserializer $deserializer) throws java.io.IOException {
        samples.InvestDiv.InvestDivMain $_obj = new samples.InvestDiv.InvestDivMain((java.lang.System[]) null);
        $deserializer.record_reference($_obj);
        return $_deserialize_body($_obj, $deserializer);
    }
    
    public void $_serialize(x10.serialization.X10JavaSerializer $serializer) throws java.io.IOException {
        super.$_serialize($serializer);
        
    }
    
    // constructor just for allocation
    public InvestDivMain(final java.lang.System[] $dummy) {
        super($dummy);
        
    }
    
    

    
    
    //#line 18 "samples/InvestDiv/InvestDivMain.x10"
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
            InvestDivMain.main(args);
        }
    }
    
    // the original app-main method
    public static void main(final x10.core.Rail<java.lang.String> args) {
        
        //#line 19 "samples/InvestDiv/InvestDivMain.x10"
        final samples.InvestDiv.InvestDivMain sim = ((samples.InvestDiv.InvestDivMain)(new samples.InvestDiv.InvestDivMain((java.lang.System[]) null).samples$InvestDiv$InvestDivMain$$init$S()));
        
        //#line 20 "samples/InvestDiv/InvestDivMain.x10"
        samples.InvestDiv.InvestDivFCNAgent.register(((plham.main.Simulator)(sim)));
        
        //#line 21 "samples/InvestDiv/InvestDivMain.x10"
        final plham.main.SequentialRunner t$20274 = ((plham.main.SequentialRunner)(new plham.main.SequentialRunner<samples.InvestDiv.InvestDivMain>((java.lang.System[]) null, samples.InvestDiv.InvestDivMain.$RTT).plham$main$SequentialRunner$$init$S(sim, (plham.main.SequentialRunner.__0plham$main$SequentialRunner$$B) null)));
        
        //#line 21 "samples/InvestDiv/InvestDivMain.x10"
        ((plham.main.Runner<samples.InvestDiv.InvestDivMain>)t$20274).run__0$1x10$lang$String$2(((x10.core.Rail)(args)));
    }
    
    
    //#line 16 "samples/InvestDiv/InvestDivMain.x10"
    final public samples.InvestDiv.InvestDivMain samples$InvestDiv$InvestDivMain$$this$samples$InvestDiv$InvestDivMain() {
        
        //#line 16 "samples/InvestDiv/InvestDivMain.x10"
        return samples.InvestDiv.InvestDivMain.this;
    }
    
    
    //#line 16 "samples/InvestDiv/InvestDivMain.x10"
    // creation method for java code (1-phase java constructor)
    public InvestDivMain() {
        this((java.lang.System[]) null);
        samples$InvestDiv$InvestDivMain$$init$S();
    }
    
    // constructor for non-virtual call
    final public samples.InvestDiv.InvestDivMain samples$InvestDiv$InvestDivMain$$init$S() {
         {
            
            //#line 16 "samples/InvestDiv/InvestDivMain.x10"
            /*super.*/samples$TradingHalt$TradingHaltMain$$init$S();
            
            //#line 16 "samples/InvestDiv/InvestDivMain.x10"
            
            
            //#line 16 "samples/InvestDiv/InvestDivMain.x10"
            this.__fieldInitializers_samples_InvestDiv_InvestDivMain();
        }
        return this;
    }
    
    
    
    //#line 16 "samples/InvestDiv/InvestDivMain.x10"
    final public void __fieldInitializers_samples_InvestDiv_InvestDivMain() {
        
    }
}

