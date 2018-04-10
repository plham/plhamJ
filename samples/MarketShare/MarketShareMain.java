package samples.MarketShare;


/**
 * Reference: Kusada, Mizuta, Hayakawa, Izumi, Yoshimura (2014) Analysis of the market makers spread's impact to markets volume shares using an artificial market (in Japanese).
 */
@x10.runtime.impl.java.X10Generated
public class MarketShareMain extends samples.CI2002.CI2002Main implements x10.serialization.X10JavaSerializable
{
    public static final x10.rtt.RuntimeType<MarketShareMain> $RTT = 
        x10.rtt.NamedType.<MarketShareMain> make("samples.MarketShare.MarketShareMain",
                                                 MarketShareMain.class,
                                                 new x10.rtt.Type[] {
                                                     samples.CI2002.CI2002Main.$RTT
                                                 });
    
    public x10.rtt.RuntimeType<?> $getRTT() { return $RTT; }
    
    public x10.rtt.Type<?> $getParam(int i) { return null; }
    
    private Object writeReplace() throws java.io.ObjectStreamException {
        return new x10.serialization.SerializationProxy(this);
    }
    
    public static x10.serialization.X10JavaSerializable $_deserialize_body(samples.MarketShare.MarketShareMain $_obj, x10.serialization.X10JavaDeserializer $deserializer) throws java.io.IOException {
        if (x10.runtime.impl.java.Runtime.TRACE_SER) { x10.runtime.impl.java.Runtime.printTraceMessage("X10JavaSerializable: $_deserialize_body() of " + MarketShareMain.class + " calling"); } 
        samples.CI2002.CI2002Main.$_deserialize_body($_obj, $deserializer);
        return $_obj;
    }
    
    public static x10.serialization.X10JavaSerializable $_deserializer(x10.serialization.X10JavaDeserializer $deserializer) throws java.io.IOException {
        samples.MarketShare.MarketShareMain $_obj = new samples.MarketShare.MarketShareMain((java.lang.System[]) null);
        $deserializer.record_reference($_obj);
        return $_deserialize_body($_obj, $deserializer);
    }
    
    public void $_serialize(x10.serialization.X10JavaSerializer $serializer) throws java.io.IOException {
        super.$_serialize($serializer);
        
    }
    
    // constructor just for allocation
    public MarketShareMain(final java.lang.System[] $dummy) {
        super($dummy);
        
    }
    
    

    
    
    //#line 17 "samples/MarketShare/MarketShareMain.x10"
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
            MarketShareMain.main(args);
        }
    }
    
    // the original app-main method
    public static void main(final x10.core.Rail<java.lang.String> args) {
        
        //#line 18 "samples/MarketShare/MarketShareMain.x10"
        final samples.MarketShare.MarketShareMain sim = ((samples.MarketShare.MarketShareMain)(new samples.MarketShare.MarketShareMain((java.lang.System[]) null).samples$MarketShare$MarketShareMain$$init$S()));
        
        //#line 19 "samples/MarketShare/MarketShareMain.x10"
        samples.MarketShare.MarketMakerAgent.register(((plham.main.Simulator)(sim)));
        
        //#line 20 "samples/MarketShare/MarketShareMain.x10"
        samples.MarketShare.MarketShareFCNAgent.register(((plham.main.Simulator)(sim)));
        
        //#line 21 "samples/MarketShare/MarketShareMain.x10"
        final plham.main.SequentialRunner t$20830 = ((plham.main.SequentialRunner)(new plham.main.SequentialRunner<samples.MarketShare.MarketShareMain>((java.lang.System[]) null, samples.MarketShare.MarketShareMain.$RTT).plham$main$SequentialRunner$$init$S(sim, (plham.main.SequentialRunner.__0plham$main$SequentialRunner$$B) null)));
        
        //#line 21 "samples/MarketShare/MarketShareMain.x10"
        ((plham.main.Runner<samples.MarketShare.MarketShareMain>)t$20830).run__0$1x10$lang$String$2(((x10.core.Rail)(args)));
    }
    
    
    //#line 24 "samples/MarketShare/MarketShareMain.x10"
    public void print(final java.lang.String sessionName) {
        
        //#line 25 "samples/MarketShare/MarketShareMain.x10"
        final x10.util.List markets = this.getMarketsByName(((java.lang.String)("markets")));
        
        //#line 26 "samples/MarketShare/MarketShareMain.x10"
        final x10.util.List agents = this.getAgentsByName(((java.lang.String)("agents")));
        
        //#line 27 "samples/MarketShare/MarketShareMain.x10"
        final x10.util.ListIterator market$20853 = ((x10.util.ListIterator<plham.Market>)
                                                     ((x10.util.List<plham.Market>)markets).iterator());
        
        //#line 27 "samples/MarketShare/MarketShareMain.x10"
        for (;
             true;
             ) {
            
            //#line 27 "samples/MarketShare/MarketShareMain.x10"
            final boolean t$20854 = ((x10.util.ListIterator<plham.Market>)market$20853).hasNext$O();
            
            //#line 27 "samples/MarketShare/MarketShareMain.x10"
            if (!(t$20854)) {
                
                //#line 27 "samples/MarketShare/MarketShareMain.x10"
                break;
            }
            
            //#line 27 "samples/MarketShare/MarketShareMain.x10"
            final plham.Market market$20842 = ((plham.Market)(((x10.util.ListIterator<plham.Market>)market$20853).next$G()));
            
            //#line 28 "samples/MarketShare/MarketShareMain.x10"
            final long t$20843 = market$20842.getTime$O();
            
            //#line 29 "samples/MarketShare/MarketShareMain.x10"
            final x10.io.Printer t$20844 = ((x10.io.Printer)(x10.io.Console.get$OUT()));
            
            //#line 32 "samples/MarketShare/MarketShareMain.x10"
            final long t$20845 = market$20842.id;
            
            //#line 33 "samples/MarketShare/MarketShareMain.x10"
            final java.lang.String t$20846 = ((java.lang.String)(market$20842.name));
            
            //#line 34 "samples/MarketShare/MarketShareMain.x10"
            final double t$20847 = market$20842.getPrice$O((long)(t$20843));
            
            //#line 35 "samples/MarketShare/MarketShareMain.x10"
            final double t$20848 = market$20842.getFundamentalPrice$O((long)(t$20843));
            
            //#line 36 "samples/MarketShare/MarketShareMain.x10"
            final long t$20849 = market$20842.getTradeVolume$O((long)(t$20843));
            
            //#line 29 "samples/MarketShare/MarketShareMain.x10"
            final x10.core.Rail t$20850 = ((x10.core.Rail)(x10.runtime.impl.java.ArrayUtils.<java.lang.Object> makeRailFromJavaArray(x10.rtt.Types.ANY, new java.lang.Object[] {sessionName, t$20843, t$20845, t$20846, t$20847, t$20848, t$20849, "", ""})));
            
            //#line 37 "samples/MarketShare/MarketShareMain.x10"
            final int t$20851 = java.lang.Integer.MAX_VALUE;
            
            //#line 29 "samples/MarketShare/MarketShareMain.x10"
            final java.lang.String t$20852 = x10.util.StringUtil.<java.lang.Object> formatArray__0$1x10$util$StringUtil$$T$2(x10.rtt.Types.ANY, ((x10.core.Rail)(t$20850)), ((java.lang.String)(" ")), ((java.lang.String)("")), (int)(t$20851));
            
            //#line 29 "samples/MarketShare/MarketShareMain.x10"
            t$20844.println(((java.lang.Object)(t$20852)));
        }
    }
    
    
    //#line 15 "samples/MarketShare/MarketShareMain.x10"
    final public samples.MarketShare.MarketShareMain samples$MarketShare$MarketShareMain$$this$samples$MarketShare$MarketShareMain() {
        
        //#line 15 "samples/MarketShare/MarketShareMain.x10"
        return samples.MarketShare.MarketShareMain.this;
    }
    
    
    //#line 15 "samples/MarketShare/MarketShareMain.x10"
    // creation method for java code (1-phase java constructor)
    public MarketShareMain() {
        this((java.lang.System[]) null);
        samples$MarketShare$MarketShareMain$$init$S();
    }
    
    // constructor for non-virtual call
    final public samples.MarketShare.MarketShareMain samples$MarketShare$MarketShareMain$$init$S() {
         {
            
            //#line 15 "samples/MarketShare/MarketShareMain.x10"
            /*super.*/samples$CI2002$CI2002Main$$init$S();
            
            //#line 15 "samples/MarketShare/MarketShareMain.x10"
            
            
            //#line 15 "samples/MarketShare/MarketShareMain.x10"
            this.__fieldInitializers_samples_MarketShare_MarketShareMain();
        }
        return this;
    }
    
    
    
    //#line 15 "samples/MarketShare/MarketShareMain.x10"
    final public void __fieldInitializers_samples_MarketShare_MarketShareMain() {
        
    }
}

