package samples.TradingHalt;


@x10.runtime.impl.java.X10Generated
public class TradingHaltMain extends samples.CI2002.CI2002Main implements x10.serialization.X10JavaSerializable
{
    public static final x10.rtt.RuntimeType<TradingHaltMain> $RTT = 
        x10.rtt.NamedType.<TradingHaltMain> make("samples.TradingHalt.TradingHaltMain",
                                                 TradingHaltMain.class,
                                                 new x10.rtt.Type[] {
                                                     samples.CI2002.CI2002Main.$RTT
                                                 });
    
    public x10.rtt.RuntimeType<?> $getRTT() { return $RTT; }
    
    public x10.rtt.Type<?> $getParam(int i) { return null; }
    
    private Object writeReplace() throws java.io.ObjectStreamException {
        return new x10.serialization.SerializationProxy(this);
    }
    
    public static x10.serialization.X10JavaSerializable $_deserialize_body(samples.TradingHalt.TradingHaltMain $_obj, x10.serialization.X10JavaDeserializer $deserializer) throws java.io.IOException {
        if (x10.runtime.impl.java.Runtime.TRACE_SER) { x10.runtime.impl.java.Runtime.printTraceMessage("X10JavaSerializable: $_deserialize_body() of " + TradingHaltMain.class + " calling"); } 
        samples.CI2002.CI2002Main.$_deserialize_body($_obj, $deserializer);
        return $_obj;
    }
    
    public static x10.serialization.X10JavaSerializable $_deserializer(x10.serialization.X10JavaDeserializer $deserializer) throws java.io.IOException {
        samples.TradingHalt.TradingHaltMain $_obj = new samples.TradingHalt.TradingHaltMain((java.lang.System[]) null);
        $deserializer.record_reference($_obj);
        return $_deserialize_body($_obj, $deserializer);
    }
    
    public void $_serialize(x10.serialization.X10JavaSerializer $serializer) throws java.io.IOException {
        super.$_serialize($serializer);
        
    }
    
    // constructor just for allocation
    public TradingHaltMain(final java.lang.System[] $dummy) {
        super($dummy);
        
    }
    
    

    
    
    //#line 18 "samples/TradingHalt/TradingHaltMain.x10"
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
            TradingHaltMain.main(args);
        }
    }
    
    // the original app-main method
    public static void main(final x10.core.Rail<java.lang.String> args) {
        
        //#line 19 "samples/TradingHalt/TradingHaltMain.x10"
        final samples.TradingHalt.TradingHaltMain sim = ((samples.TradingHalt.TradingHaltMain)(new samples.TradingHalt.TradingHaltMain((java.lang.System[]) null).samples$TradingHalt$TradingHaltMain$$init$S()));
        
        //#line 20 "samples/TradingHalt/TradingHaltMain.x10"
        plham.agent.FCNAgent.register(((plham.main.Simulator)(sim)));
        
        //#line 21 "samples/TradingHalt/TradingHaltMain.x10"
        plham.Market.register(((plham.main.Simulator)(sim)));
        
        //#line 22 "samples/TradingHalt/TradingHaltMain.x10"
        plham.event.FundamentalPriceShock.register(((plham.main.Simulator)(sim)));
        
        //#line 23 "samples/TradingHalt/TradingHaltMain.x10"
        plham.event.TradingHaltRule.register(((plham.main.Simulator)(sim)));
        
        //#line 24 "samples/TradingHalt/TradingHaltMain.x10"
        final plham.main.SequentialRunner t$20079 = ((plham.main.SequentialRunner)(new plham.main.SequentialRunner<samples.TradingHalt.TradingHaltMain>((java.lang.System[]) null, samples.TradingHalt.TradingHaltMain.$RTT).plham$main$SequentialRunner$$init$S(sim, (plham.main.SequentialRunner.__0plham$main$SequentialRunner$$B) null)));
        
        //#line 24 "samples/TradingHalt/TradingHaltMain.x10"
        ((plham.main.Runner<samples.TradingHalt.TradingHaltMain>)t$20079).run__0$1x10$lang$String$2(((x10.core.Rail)(args)));
    }
    
    
    //#line 27 "samples/TradingHalt/TradingHaltMain.x10"
    public void print(final java.lang.String sessionName) {
        
        //#line 28 "samples/TradingHalt/TradingHaltMain.x10"
        final x10.util.List markets = this.getMarketsByName(((java.lang.String)("markets")));
        
        //#line 29 "samples/TradingHalt/TradingHaltMain.x10"
        final x10.util.List agents = this.getAgentsByName(((java.lang.String)("agents")));
        
        //#line 30 "samples/TradingHalt/TradingHaltMain.x10"
        final x10.util.ListIterator market$20102 = ((x10.util.ListIterator<plham.Market>)
                                                     ((x10.util.List<plham.Market>)markets).iterator());
        
        //#line 30 "samples/TradingHalt/TradingHaltMain.x10"
        for (;
             true;
             ) {
            
            //#line 30 "samples/TradingHalt/TradingHaltMain.x10"
            final boolean t$20103 = ((x10.util.ListIterator<plham.Market>)market$20102).hasNext$O();
            
            //#line 30 "samples/TradingHalt/TradingHaltMain.x10"
            if (!(t$20103)) {
                
                //#line 30 "samples/TradingHalt/TradingHaltMain.x10"
                break;
            }
            
            //#line 30 "samples/TradingHalt/TradingHaltMain.x10"
            final plham.Market market$20091 = ((plham.Market)(((x10.util.ListIterator<plham.Market>)market$20102).next$G()));
            
            //#line 31 "samples/TradingHalt/TradingHaltMain.x10"
            final long t$20092 = market$20091.getTime$O();
            
            //#line 32 "samples/TradingHalt/TradingHaltMain.x10"
            final x10.io.Printer t$20093 = ((x10.io.Printer)(x10.io.Console.get$OUT()));
            
            //#line 35 "samples/TradingHalt/TradingHaltMain.x10"
            final long t$20094 = market$20091.id;
            
            //#line 36 "samples/TradingHalt/TradingHaltMain.x10"
            final java.lang.String t$20095 = ((java.lang.String)(market$20091.name));
            
            //#line 37 "samples/TradingHalt/TradingHaltMain.x10"
            final double t$20096 = market$20091.getPrice$O((long)(t$20092));
            
            //#line 38 "samples/TradingHalt/TradingHaltMain.x10"
            final double t$20097 = market$20091.getFundamentalPrice$O((long)(t$20092));
            
            //#line 39 "samples/TradingHalt/TradingHaltMain.x10"
            final boolean t$20098 = market$20091.isRunning$O();
            
            //#line 32 "samples/TradingHalt/TradingHaltMain.x10"
            final x10.core.Rail t$20099 = ((x10.core.Rail)(x10.runtime.impl.java.ArrayUtils.<java.lang.Object> makeRailFromJavaArray(x10.rtt.Types.ANY, new java.lang.Object[] {sessionName, t$20092, t$20094, t$20095, t$20096, t$20097, t$20098, "", ""})));
            
            //#line 40 "samples/TradingHalt/TradingHaltMain.x10"
            final int t$20100 = java.lang.Integer.MAX_VALUE;
            
            //#line 32 "samples/TradingHalt/TradingHaltMain.x10"
            final java.lang.String t$20101 = x10.util.StringUtil.<java.lang.Object> formatArray__0$1x10$util$StringUtil$$T$2(x10.rtt.Types.ANY, ((x10.core.Rail)(t$20099)), ((java.lang.String)(" ")), ((java.lang.String)("")), (int)(t$20100));
            
            //#line 32 "samples/TradingHalt/TradingHaltMain.x10"
            t$20093.println(((java.lang.Object)(t$20101)));
        }
    }
    
    
    //#line 16 "samples/TradingHalt/TradingHaltMain.x10"
    final public samples.TradingHalt.TradingHaltMain samples$TradingHalt$TradingHaltMain$$this$samples$TradingHalt$TradingHaltMain() {
        
        //#line 16 "samples/TradingHalt/TradingHaltMain.x10"
        return samples.TradingHalt.TradingHaltMain.this;
    }
    
    
    //#line 16 "samples/TradingHalt/TradingHaltMain.x10"
    // creation method for java code (1-phase java constructor)
    public TradingHaltMain() {
        this((java.lang.System[]) null);
        samples$TradingHalt$TradingHaltMain$$init$S();
    }
    
    // constructor for non-virtual call
    final public samples.TradingHalt.TradingHaltMain samples$TradingHalt$TradingHaltMain$$init$S() {
         {
            
            //#line 16 "samples/TradingHalt/TradingHaltMain.x10"
            /*super.*/samples$CI2002$CI2002Main$$init$S();
            
            //#line 16 "samples/TradingHalt/TradingHaltMain.x10"
            
            
            //#line 16 "samples/TradingHalt/TradingHaltMain.x10"
            this.__fieldInitializers_samples_TradingHalt_TradingHaltMain();
        }
        return this;
    }
    
    
    
    //#line 16 "samples/TradingHalt/TradingHaltMain.x10"
    final public void __fieldInitializers_samples_TradingHalt_TradingHaltMain() {
        
    }
}

