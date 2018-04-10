package samples.ShockTransfer;


@x10.runtime.impl.java.X10Generated
public class ShockTransferMain extends samples.CI2002.CI2002Main implements x10.serialization.X10JavaSerializable
{
    public static final x10.rtt.RuntimeType<ShockTransferMain> $RTT = 
        x10.rtt.NamedType.<ShockTransferMain> make("samples.ShockTransfer.ShockTransferMain",
                                                   ShockTransferMain.class,
                                                   new x10.rtt.Type[] {
                                                       samples.CI2002.CI2002Main.$RTT
                                                   });
    
    public x10.rtt.RuntimeType<?> $getRTT() { return $RTT; }
    
    public x10.rtt.Type<?> $getParam(int i) { return null; }
    
    private Object writeReplace() throws java.io.ObjectStreamException {
        return new x10.serialization.SerializationProxy(this);
    }
    
    public static x10.serialization.X10JavaSerializable $_deserialize_body(samples.ShockTransfer.ShockTransferMain $_obj, x10.serialization.X10JavaDeserializer $deserializer) throws java.io.IOException {
        if (x10.runtime.impl.java.Runtime.TRACE_SER) { x10.runtime.impl.java.Runtime.printTraceMessage("X10JavaSerializable: $_deserialize_body() of " + ShockTransferMain.class + " calling"); } 
        samples.CI2002.CI2002Main.$_deserialize_body($_obj, $deserializer);
        return $_obj;
    }
    
    public static x10.serialization.X10JavaSerializable $_deserializer(x10.serialization.X10JavaDeserializer $deserializer) throws java.io.IOException {
        samples.ShockTransfer.ShockTransferMain $_obj = new samples.ShockTransfer.ShockTransferMain((java.lang.System[]) null);
        $deserializer.record_reference($_obj);
        return $_deserialize_body($_obj, $deserializer);
    }
    
    public void $_serialize(x10.serialization.X10JavaSerializer $serializer) throws java.io.IOException {
        super.$_serialize($serializer);
        
    }
    
    // constructor just for allocation
    public ShockTransferMain(final java.lang.System[] $dummy) {
        super($dummy);
        
    }
    
    

    
    
    //#line 20 "samples/ShockTransfer/ShockTransferMain.x10"
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
            ShockTransferMain.main(args);
        }
    }
    
    // the original app-main method
    public static void main(final x10.core.Rail<java.lang.String> args) {
        
        //#line 21 "samples/ShockTransfer/ShockTransferMain.x10"
        final samples.ShockTransfer.ShockTransferMain sim = ((samples.ShockTransfer.ShockTransferMain)(new samples.ShockTransfer.ShockTransferMain((java.lang.System[]) null).samples$ShockTransfer$ShockTransferMain$$init$S()));
        
        //#line 22 "samples/ShockTransfer/ShockTransferMain.x10"
        plham.agent.FCNAgent.register(((plham.main.Simulator)(sim)));
        
        //#line 23 "samples/ShockTransfer/ShockTransferMain.x10"
        plham.Market.register(((plham.main.Simulator)(sim)));
        
        //#line 24 "samples/ShockTransfer/ShockTransferMain.x10"
        samples.ShockTransfer.ArbitrageAgent.register(((plham.main.Simulator)(sim)));
        
        //#line 25 "samples/ShockTransfer/ShockTransferMain.x10"
        plham.IndexMarket.register(((plham.main.Simulator)(sim)));
        
        //#line 26 "samples/ShockTransfer/ShockTransferMain.x10"
        plham.util.SimpleMarketGenerator.register(((plham.main.Simulator)(sim)));
        
        //#line 27 "samples/ShockTransfer/ShockTransferMain.x10"
        plham.util.AgentGeneratorForEachMarket.register(((plham.main.Simulator)(sim)));
        
        //#line 28 "samples/ShockTransfer/ShockTransferMain.x10"
        plham.event.FundamentalPriceShock.register(((plham.main.Simulator)(sim)));
        
        //#line 29 "samples/ShockTransfer/ShockTransferMain.x10"
        final plham.main.SequentialRunner t$20386 = ((plham.main.SequentialRunner)(new plham.main.SequentialRunner<samples.ShockTransfer.ShockTransferMain>((java.lang.System[]) null, samples.ShockTransfer.ShockTransferMain.$RTT).plham$main$SequentialRunner$$init$S(sim, (plham.main.SequentialRunner.__0plham$main$SequentialRunner$$B) null)));
        
        //#line 29 "samples/ShockTransfer/ShockTransferMain.x10"
        ((plham.main.Runner<samples.ShockTransfer.ShockTransferMain>)t$20386).run__0$1x10$lang$String$2(((x10.core.Rail)(args)));
    }
    
    
    //#line 32 "samples/ShockTransfer/ShockTransferMain.x10"
    public void print(final java.lang.String sessionName) {
        
        //#line 33 "samples/ShockTransfer/ShockTransferMain.x10"
        final x10.util.List markets = this.getMarketsByName(((java.lang.String)("markets")));
        
        //#line 34 "samples/ShockTransfer/ShockTransferMain.x10"
        final x10.util.ListIterator market$20416 = ((x10.util.ListIterator<plham.Market>)
                                                     ((x10.util.List<plham.Market>)markets).iterator());
        
        //#line 34 "samples/ShockTransfer/ShockTransferMain.x10"
        for (;
             true;
             ) {
            
            //#line 34 "samples/ShockTransfer/ShockTransferMain.x10"
            final boolean t$20417 = ((x10.util.ListIterator<plham.Market>)market$20416).hasNext$O();
            
            //#line 34 "samples/ShockTransfer/ShockTransferMain.x10"
            if (!(t$20417)) {
                
                //#line 34 "samples/ShockTransfer/ShockTransferMain.x10"
                break;
            }
            
            //#line 34 "samples/ShockTransfer/ShockTransferMain.x10"
            final plham.Market market$20401 = ((plham.Market)(((x10.util.ListIterator<plham.Market>)market$20416).next$G()));
            
            //#line 35 "samples/ShockTransfer/ShockTransferMain.x10"
            final long t$20402 = market$20401.getTime$O();
            
            //#line 36 "samples/ShockTransfer/ShockTransferMain.x10"
            double marketIndex$20403 = java.lang.Double.NaN;
            
            //#line 37 "samples/ShockTransfer/ShockTransferMain.x10"
            final boolean t$20404 = plham.IndexMarket.$RTT.isInstance(market$20401);
            
            //#line 37 "samples/ShockTransfer/ShockTransferMain.x10"
            if (t$20404) {
                
                //#line 38 "samples/ShockTransfer/ShockTransferMain.x10"
                final plham.IndexMarket t$20405 = ((plham.IndexMarket)(x10.rtt.Types.<plham.IndexMarket> cast(market$20401,plham.IndexMarket.$RTT)));
                
                //#line 38 "samples/ShockTransfer/ShockTransferMain.x10"
                final double t$20406 = t$20405.getIndex$O((long)(t$20402));
                
                //#line 38 "samples/ShockTransfer/ShockTransferMain.x10"
                marketIndex$20403 = t$20406;
            }
            
            //#line 40 "samples/ShockTransfer/ShockTransferMain.x10"
            final x10.io.Printer t$20407 = ((x10.io.Printer)(x10.io.Console.get$OUT()));
            
            //#line 43 "samples/ShockTransfer/ShockTransferMain.x10"
            final long t$20408 = market$20401.id;
            
            //#line 44 "samples/ShockTransfer/ShockTransferMain.x10"
            final java.lang.String t$20409 = ((java.lang.String)(market$20401.name));
            
            //#line 45 "samples/ShockTransfer/ShockTransferMain.x10"
            final double t$20410 = market$20401.getPrice$O((long)(t$20402));
            
            //#line 46 "samples/ShockTransfer/ShockTransferMain.x10"
            final double t$20411 = market$20401.getFundamentalPrice$O((long)(t$20402));
            
            //#line 47 "samples/ShockTransfer/ShockTransferMain.x10"
            final double t$20412 = marketIndex$20403;
            
            //#line 40 "samples/ShockTransfer/ShockTransferMain.x10"
            final x10.core.Rail t$20413 = ((x10.core.Rail)(x10.runtime.impl.java.ArrayUtils.<java.lang.Object> makeRailFromJavaArray(x10.rtt.Types.ANY, new java.lang.Object[] {sessionName, t$20402, t$20408, t$20409, t$20410, t$20411, t$20412, "", ""})));
            
            //#line 48 "samples/ShockTransfer/ShockTransferMain.x10"
            final int t$20414 = java.lang.Integer.MAX_VALUE;
            
            //#line 40 "samples/ShockTransfer/ShockTransferMain.x10"
            final java.lang.String t$20415 = x10.util.StringUtil.<java.lang.Object> formatArray__0$1x10$util$StringUtil$$T$2(x10.rtt.Types.ANY, ((x10.core.Rail)(t$20413)), ((java.lang.String)(" ")), ((java.lang.String)("")), (int)(t$20414));
            
            //#line 40 "samples/ShockTransfer/ShockTransferMain.x10"
            t$20407.println(((java.lang.Object)(t$20415)));
        }
    }
    
    
    //#line 18 "samples/ShockTransfer/ShockTransferMain.x10"
    final public samples.ShockTransfer.ShockTransferMain samples$ShockTransfer$ShockTransferMain$$this$samples$ShockTransfer$ShockTransferMain() {
        
        //#line 18 "samples/ShockTransfer/ShockTransferMain.x10"
        return samples.ShockTransfer.ShockTransferMain.this;
    }
    
    
    //#line 18 "samples/ShockTransfer/ShockTransferMain.x10"
    // creation method for java code (1-phase java constructor)
    public ShockTransferMain() {
        this((java.lang.System[]) null);
        samples$ShockTransfer$ShockTransferMain$$init$S();
    }
    
    // constructor for non-virtual call
    final public samples.ShockTransfer.ShockTransferMain samples$ShockTransfer$ShockTransferMain$$init$S() {
         {
            
            //#line 18 "samples/ShockTransfer/ShockTransferMain.x10"
            /*super.*/samples$CI2002$CI2002Main$$init$S();
            
            //#line 18 "samples/ShockTransfer/ShockTransferMain.x10"
            
            
            //#line 18 "samples/ShockTransfer/ShockTransferMain.x10"
            this.__fieldInitializers_samples_ShockTransfer_ShockTransferMain();
        }
        return this;
    }
    
    
    
    //#line 18 "samples/ShockTransfer/ShockTransferMain.x10"
    final public void __fieldInitializers_samples_ShockTransfer_ShockTransferMain() {
        
    }
}

