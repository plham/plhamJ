package samples.DarkPool;


/**
 * Reference: Mizuta, Kosugi, Kusumoto, Matsumoto, Izumi (2014) Analysis of the impact of dark pool to the market efficiency using an artificial market (in Japanese).
 */
@x10.runtime.impl.java.X10Generated
public class DarkPoolMain extends samples.CI2002.CI2002Main implements x10.serialization.X10JavaSerializable
{
    public static final x10.rtt.RuntimeType<DarkPoolMain> $RTT = 
        x10.rtt.NamedType.<DarkPoolMain> make("samples.DarkPool.DarkPoolMain",
                                              DarkPoolMain.class,
                                              new x10.rtt.Type[] {
                                                  samples.CI2002.CI2002Main.$RTT
                                              });
    
    public x10.rtt.RuntimeType<?> $getRTT() { return $RTT; }
    
    public x10.rtt.Type<?> $getParam(int i) { return null; }
    
    private Object writeReplace() throws java.io.ObjectStreamException {
        return new x10.serialization.SerializationProxy(this);
    }
    
    public static x10.serialization.X10JavaSerializable $_deserialize_body(samples.DarkPool.DarkPoolMain $_obj, x10.serialization.X10JavaDeserializer $deserializer) throws java.io.IOException {
        if (x10.runtime.impl.java.Runtime.TRACE_SER) { x10.runtime.impl.java.Runtime.printTraceMessage("X10JavaSerializable: $_deserialize_body() of " + DarkPoolMain.class + " calling"); } 
        samples.CI2002.CI2002Main.$_deserialize_body($_obj, $deserializer);
        return $_obj;
    }
    
    public static x10.serialization.X10JavaSerializable $_deserializer(x10.serialization.X10JavaDeserializer $deserializer) throws java.io.IOException {
        samples.DarkPool.DarkPoolMain $_obj = new samples.DarkPool.DarkPoolMain((java.lang.System[]) null);
        $deserializer.record_reference($_obj);
        return $_deserialize_body($_obj, $deserializer);
    }
    
    public void $_serialize(x10.serialization.X10JavaSerializer $serializer) throws java.io.IOException {
        super.$_serialize($serializer);
        
    }
    
    // constructor just for allocation
    public DarkPoolMain(final java.lang.System[] $dummy) {
        super($dummy);
        
    }
    
    

    
    
    //#line 17 "samples/DarkPool/DarkPoolMain.x10"
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
            DarkPoolMain.main(args);
        }
    }
    
    // the original app-main method
    public static void main(final x10.core.Rail<java.lang.String> args) {
        
        //#line 18 "samples/DarkPool/DarkPoolMain.x10"
        final samples.DarkPool.DarkPoolMain sim = ((samples.DarkPool.DarkPoolMain)(new samples.DarkPool.DarkPoolMain((java.lang.System[]) null).samples$DarkPool$DarkPoolMain$$init$S()));
        
        //#line 19 "samples/DarkPool/DarkPoolMain.x10"
        samples.DarkPool.DarkPoolFCNAgent.register(((plham.main.Simulator)(sim)));
        
        //#line 20 "samples/DarkPool/DarkPoolMain.x10"
        samples.DarkPool.DarkPoolMarket.register(((plham.main.Simulator)(sim)));
        
        //#line 21 "samples/DarkPool/DarkPoolMain.x10"
        final plham.main.SequentialRunner t$20256 = ((plham.main.SequentialRunner)(new plham.main.SequentialRunner<samples.DarkPool.DarkPoolMain>((java.lang.System[]) null, samples.DarkPool.DarkPoolMain.$RTT).plham$main$SequentialRunner$$init$S(sim, (plham.main.SequentialRunner.__0plham$main$SequentialRunner$$B) null)));
        
        //#line 21 "samples/DarkPool/DarkPoolMain.x10"
        ((plham.main.Runner<samples.DarkPool.DarkPoolMain>)t$20256).run__0$1x10$lang$String$2(((x10.core.Rail)(args)));
    }
    
    
    //#line 24 "samples/DarkPool/DarkPoolMain.x10"
    public void print(final java.lang.String sessionName) {
        
        //#line 25 "samples/DarkPool/DarkPoolMain.x10"
        final x10.util.List markets = this.getMarketsByName(((java.lang.String)("markets")));
        
        //#line 26 "samples/DarkPool/DarkPoolMain.x10"
        final x10.util.List agents = this.getAgentsByName(((java.lang.String)("agents")));
        
        //#line 28 "samples/DarkPool/DarkPoolMain.x10"
        assert ((long) ((x10.util.Container<plham.Market>)markets).size$O()) == ((long) 2L);
        
        //#line 29 "samples/DarkPool/DarkPoolMain.x10"
        final plham.Market lit = this.getMarketByName(((java.lang.String)("LitMarket")));
        
        //#line 30 "samples/DarkPool/DarkPoolMain.x10"
        final plham.Market dark = this.getMarketByName(((java.lang.String)("DarkPoolMarket")));
        
        //#line 31 "samples/DarkPool/DarkPoolMain.x10"
        double tradePrice = java.lang.Double.NaN;
        
        //#line 32 "samples/DarkPool/DarkPoolMain.x10"
        final long t$20257 = dark.getTradeVolume$O();
        
        //#line 32 "samples/DarkPool/DarkPoolMain.x10"
        final boolean t$20262 = ((t$20257) > (((long)(0L))));
        
        //#line 32 "samples/DarkPool/DarkPoolMain.x10"
        if (t$20262) {
            
            //#line 33 "samples/DarkPool/DarkPoolMain.x10"
            final double t$20258 = dark.getPrice$O();
            
            //#line 33 "samples/DarkPool/DarkPoolMain.x10"
            tradePrice = t$20258;
        } else {
            
            //#line 34 "samples/DarkPool/DarkPoolMain.x10"
            final long t$20259 = lit.getTradeVolume$O();
            
            //#line 34 "samples/DarkPool/DarkPoolMain.x10"
            final boolean t$20261 = ((t$20259) > (((long)(0L))));
            
            //#line 34 "samples/DarkPool/DarkPoolMain.x10"
            if (t$20261) {
                
                //#line 35 "samples/DarkPool/DarkPoolMain.x10"
                final double t$20260 = lit.getPrice$O();
                
                //#line 35 "samples/DarkPool/DarkPoolMain.x10"
                tradePrice = t$20260;
            }
        }
        
        //#line 38 "samples/DarkPool/DarkPoolMain.x10"
        final x10.util.ListIterator market$20287 = ((x10.util.ListIterator<plham.Market>)
                                                     ((x10.util.List<plham.Market>)markets).iterator());
        
        //#line 38 "samples/DarkPool/DarkPoolMain.x10"
        for (;
             true;
             ) {
            
            //#line 38 "samples/DarkPool/DarkPoolMain.x10"
            final boolean t$20288 = ((x10.util.ListIterator<plham.Market>)market$20287).hasNext$O();
            
            //#line 38 "samples/DarkPool/DarkPoolMain.x10"
            if (!(t$20288)) {
                
                //#line 38 "samples/DarkPool/DarkPoolMain.x10"
                break;
            }
            
            //#line 38 "samples/DarkPool/DarkPoolMain.x10"
            final plham.Market market$20275 = ((plham.Market)(((x10.util.ListIterator<plham.Market>)market$20287).next$G()));
            
            //#line 39 "samples/DarkPool/DarkPoolMain.x10"
            final long t$20276 = market$20275.getTime$O();
            
            //#line 40 "samples/DarkPool/DarkPoolMain.x10"
            final x10.io.Printer t$20277 = ((x10.io.Printer)(x10.io.Console.get$OUT()));
            
            //#line 43 "samples/DarkPool/DarkPoolMain.x10"
            final long t$20278 = market$20275.id;
            
            //#line 44 "samples/DarkPool/DarkPoolMain.x10"
            final java.lang.String t$20279 = ((java.lang.String)(market$20275.name));
            
            //#line 45 "samples/DarkPool/DarkPoolMain.x10"
            final double t$20280 = market$20275.getPrice$O((long)(t$20276));
            
            //#line 46 "samples/DarkPool/DarkPoolMain.x10"
            final double t$20281 = market$20275.getFundamentalPrice$O((long)(t$20276));
            
            //#line 48 "samples/DarkPool/DarkPoolMain.x10"
            final double t$20282 = tradePrice;
            
            //#line 49 "samples/DarkPool/DarkPoolMain.x10"
            final long t$20283 = market$20275.getTradeVolume$O();
            
            //#line 40 "samples/DarkPool/DarkPoolMain.x10"
            final x10.core.Rail t$20284 = ((x10.core.Rail)(x10.runtime.impl.java.ArrayUtils.<java.lang.Object> makeRailFromJavaArray(x10.rtt.Types.ANY, new java.lang.Object[] {sessionName, t$20276, t$20278, t$20279, t$20280, t$20281, t$20282, t$20283, "", ""})));
            
            //#line 50 "samples/DarkPool/DarkPoolMain.x10"
            final int t$20285 = java.lang.Integer.MAX_VALUE;
            
            //#line 40 "samples/DarkPool/DarkPoolMain.x10"
            final java.lang.String t$20286 = x10.util.StringUtil.<java.lang.Object> formatArray__0$1x10$util$StringUtil$$T$2(x10.rtt.Types.ANY, ((x10.core.Rail)(t$20284)), ((java.lang.String)(" ")), ((java.lang.String)("")), (int)(t$20285));
            
            //#line 40 "samples/DarkPool/DarkPoolMain.x10"
            t$20277.println(((java.lang.Object)(t$20286)));
        }
    }
    
    
    //#line 15 "samples/DarkPool/DarkPoolMain.x10"
    final public samples.DarkPool.DarkPoolMain samples$DarkPool$DarkPoolMain$$this$samples$DarkPool$DarkPoolMain() {
        
        //#line 15 "samples/DarkPool/DarkPoolMain.x10"
        return samples.DarkPool.DarkPoolMain.this;
    }
    
    
    //#line 15 "samples/DarkPool/DarkPoolMain.x10"
    // creation method for java code (1-phase java constructor)
    public DarkPoolMain() {
        this((java.lang.System[]) null);
        samples$DarkPool$DarkPoolMain$$init$S();
    }
    
    // constructor for non-virtual call
    final public samples.DarkPool.DarkPoolMain samples$DarkPool$DarkPoolMain$$init$S() {
         {
            
            //#line 15 "samples/DarkPool/DarkPoolMain.x10"
            /*super.*/samples$CI2002$CI2002Main$$init$S();
            
            //#line 15 "samples/DarkPool/DarkPoolMain.x10"
            
            
            //#line 15 "samples/DarkPool/DarkPoolMain.x10"
            this.__fieldInitializers_samples_DarkPool_DarkPoolMain();
        }
        return this;
    }
    
    
    
    //#line 15 "samples/DarkPool/DarkPoolMain.x10"
    final public void __fieldInitializers_samples_DarkPool_DarkPoolMain() {
        
    }
}

