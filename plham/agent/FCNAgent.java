package plham.agent;


/**
 * An order decision mechanism proposed in Chiarella & Iori (2004).
 * It employs two simple margin-based random tradings.
 * 
 * Given an expected future price <it>p</it>, submit an order of price
 * <ul>
 * <li> <code>"fixed"</code> :  <it>p</it> (1 &pm; <it>k</it>)  where  0 \u2266 <it>k</it> \u2266 1
 * <li> <code>"normal"</code> : <it>p</it> + N(0, <it>k</it>)   where  <it>k</it> > 0
 * </ul>
 */

public class FCNAgent extends plham.Agent implements x10.serialization.X10JavaSerializable
{
    public static final x10.rtt.RuntimeType<FCNAgent> $RTT = 
        x10.rtt.NamedType.<FCNAgent> make("plham.agent.FCNAgent",
                                          FCNAgent.class,
                                          new x10.rtt.Type[] {
                                              plham.Agent.$RTT
                                          });
    
    public x10.rtt.RuntimeType<?> $getRTT() { return $RTT; }
    
    public x10.rtt.Type<?> $getParam(int i) { return null; }
    
    private Object writeReplace() throws java.io.ObjectStreamException {
        return new x10.serialization.SerializationProxy(this);
    }
    
    public static x10.serialization.X10JavaSerializable $_deserialize_body(plham.agent.FCNAgent $_obj, x10.serialization.X10JavaDeserializer $deserializer) throws java.io.IOException {
        if (x10.runtime.impl.java.Runtime.TRACE_SER) { x10.runtime.impl.java.Runtime.printTraceMessage("X10JavaSerializable: $_deserialize_body() of " + FCNAgent.class + " calling"); } 
        plham.Agent.$_deserialize_body($_obj, $deserializer);
        $_obj.chartWeight = $deserializer.readDouble();
        $_obj.fundamentalWeight = $deserializer.readDouble();
        $_obj.isChartFollowing = $deserializer.readBoolean();
        $_obj.marginType = $deserializer.readLong();
        $_obj.meanReversionTime = $deserializer.readLong();
        $_obj.noiseScale = $deserializer.readDouble();
        $_obj.noiseWeight = $deserializer.readDouble();
        $_obj.orderMargin = $deserializer.readDouble();
        $_obj.timeWindowSize = $deserializer.readLong();
        return $_obj;
    }
    
    public static x10.serialization.X10JavaSerializable $_deserializer(x10.serialization.X10JavaDeserializer $deserializer) throws java.io.IOException {
        plham.agent.FCNAgent $_obj = new plham.agent.FCNAgent((java.lang.System[]) null);
        $deserializer.record_reference($_obj);
        return $_deserialize_body($_obj, $deserializer);
    }
    
    public void $_serialize(x10.serialization.X10JavaSerializer $serializer) throws java.io.IOException {
        super.$_serialize($serializer);
        $serializer.write(this.chartWeight);
        $serializer.write(this.fundamentalWeight);
        $serializer.write(this.isChartFollowing);
        $serializer.write(this.marginType);
        $serializer.write(this.meanReversionTime);
        $serializer.write(this.noiseScale);
        $serializer.write(this.noiseWeight);
        $serializer.write(this.orderMargin);
        $serializer.write(this.timeWindowSize);
        
    }
    
    // constructor just for allocation
    public FCNAgent(final java.lang.System[] $dummy) {
        super($dummy);
        
    }
    
    

    
    //#line 26 "/home/dsl/workspace/plhamK/plham/agent/FCNAgent.x10"
    public double fundamentalWeight;
    
    //#line 27 "/home/dsl/workspace/plhamK/plham/agent/FCNAgent.x10"
    public double chartWeight;
    
    //#line 28 "/home/dsl/workspace/plhamK/plham/agent/FCNAgent.x10"
    public double noiseWeight;
    
    //#line 29 "/home/dsl/workspace/plhamK/plham/agent/FCNAgent.x10"
    public double noiseScale;
    
    //#line 30 "/home/dsl/workspace/plhamK/plham/agent/FCNAgent.x10"
    public long timeWindowSize;
    
    //#line 31 "/home/dsl/workspace/plhamK/plham/agent/FCNAgent.x10"
    public double orderMargin;
    
    //#line 32 "/home/dsl/workspace/plhamK/plham/agent/FCNAgent.x10"
    public boolean isChartFollowing;
    
    //#line 33 "/home/dsl/workspace/plhamK/plham/agent/FCNAgent.x10"
    public long meanReversionTime;
    
    //#line 35 "/home/dsl/workspace/plhamK/plham/agent/FCNAgent.x10"
    final public static long MARGIN_FIXED = 0L;
    
    //#line 36 "/home/dsl/workspace/plhamK/plham/agent/FCNAgent.x10"
    final public static long MARGIN_NORMAL = 1L;
    
    //#line 37 "/home/dsl/workspace/plhamK/plham/agent/FCNAgent.x10"
    public long marginType;
    
    
    //#line 39 "/home/dsl/workspace/plhamK/plham/agent/FCNAgent.x10"
    // creation method for java code (1-phase java constructor)
    public FCNAgent(final long id, final java.lang.String name, final x10.util.Random random) {
        this((java.lang.System[]) null);
        plham$agent$FCNAgent$$init$S(id, name, random);
    }
    
    // constructor for non-virtual call
    final public plham.agent.FCNAgent plham$agent$FCNAgent$$init$S(final long id, final java.lang.String name, final x10.util.Random random) {
         {
            
            //#line 39 "/home/dsl/workspace/plhamK/plham/agent/FCNAgent.x10"
            /*super.*/initAgent(((id)), ((name)), ((random)));
            
            //#line 39 "/home/dsl/workspace/plhamK/plham/agent/FCNAgent.x10"
            
            
            //#line 24 "/home/dsl/workspace/plhamK/plham/agent/FCNAgent.x10"
            this.__fieldInitializers_plham_agent_FCNAgent();
        }
        return this;
    }
    
    
    
    //#line 41 "/home/dsl/workspace/plhamK/plham/agent/FCNAgent.x10"
    public static void register(final plham.main.Simulator sim) {
        
        //#line 42 "/home/dsl/workspace/plhamK/plham/agent/FCNAgent.x10"
        final java.lang.String className = (("FCNAgent"));
        
        //#line 44 "/home/dsl/workspace/plhamK/plham/agent/FCNAgent.x10"
        final x10.core.fun.Fun_0_4 t$22285 = ((new plham.agent.FCNAgent.$Closure$9(sim)));
        
        //#line 43 "/home/dsl/workspace/plhamK/plham/agent/FCNAgent.x10"
        sim.addAgentInitializer__1$1x10$lang$Long$3x10$lang$String$3x10$util$Random$3cassia$util$JSON$Value$3plham$Agent$2(((className)), ((t$22285)));
    }
    
    
    //#line 55 "/home/dsl/workspace/plhamK/plham/agent/FCNAgent.x10"
    public plham.agent.FCNAgent setup(final cassia.util.JSON.Value json, final plham.main.Simulator sim) {
        
        //#line 56 "/home/dsl/workspace/plhamK/plham/agent/FCNAgent.x10"
        final x10.util.Random t$22286 = this.getRandom();
        
        //#line 56 "/home/dsl/workspace/plhamK/plham/agent/FCNAgent.x10"
        final plham.util.JSONRandom jsonrandom = ((new plham.util.JSONRandom((java.lang.System[]) null).plham$util$JSONRandom$$init$S(t$22286)));
        
        //#line 57 "/home/dsl/workspace/plhamK/plham/agent/FCNAgent.x10"
        super.setup(((json)), ((sim)));
        
        //#line 59 "/home/dsl/workspace/plhamK/plham/agent/FCNAgent.x10"
        final long t$22287 = plham.agent.FCNAgent.MARGIN_FIXED;
        
        //#line 59 "/home/dsl/workspace/plhamK/plham/agent/FCNAgent.x10"
        final java.lang.String t$22288 = "{\'fixed\': 0";
        
        //#line 59 "/home/dsl/workspace/plhamK/plham/agent/FCNAgent.x10"
        final java.lang.String t$22289 = "{\'fixed\': 0,";
        
        //#line 59 "/home/dsl/workspace/plhamK/plham/agent/FCNAgent.x10"
        final java.lang.String t$22290 = "{\'fixed\': 0,\'normal\': ";
        
        //#line 60 "/home/dsl/workspace/plhamK/plham/agent/FCNAgent.x10"
        final long t$22291 = plham.agent.FCNAgent.MARGIN_NORMAL;
        
        //#line 59 "/home/dsl/workspace/plhamK/plham/agent/FCNAgent.x10"
        final java.lang.String t$22292 = "{\'fixed\': 0,\'normal\': 1";
        
        //#line 59 "/home/dsl/workspace/plhamK/plham/agent/FCNAgent.x10"
        final java.lang.String t$22293 = "{\'fixed\': 0,\'normal\': 1}";
        
        //#line 58 "/home/dsl/workspace/plhamK/plham/agent/FCNAgent.x10"
        final cassia.util.JSON.Value MARGIN_TYPES = ((plham.util.JSON.parse(((t$22293)))));
        
        //#line 62 "/home/dsl/workspace/plhamK/plham/agent/FCNAgent.x10"
        final cassia.util.JSON.Value t$22294 = json.<java.lang.String> get(x10.rtt.Types.STRING, (("fundamentalWeight")));
        
        //#line 62 "/home/dsl/workspace/plhamK/plham/agent/FCNAgent.x10"
        final double t$22295 = jsonrandom.nextRandom$O(((t$22294)));
        
        //#line 62 "/home/dsl/workspace/plhamK/plham/agent/FCNAgent.x10"
        this.fundamentalWeight = t$22295;
        
        //#line 63 "/home/dsl/workspace/plhamK/plham/agent/FCNAgent.x10"
        final cassia.util.JSON.Value t$22296 = json.<java.lang.String> get(x10.rtt.Types.STRING, (("chartWeight")));
        
        //#line 63 "/home/dsl/workspace/plhamK/plham/agent/FCNAgent.x10"
        final double t$22297 = jsonrandom.nextRandom$O(((t$22296)));
        
        //#line 63 "/home/dsl/workspace/plhamK/plham/agent/FCNAgent.x10"
        this.chartWeight = t$22297;
        
        //#line 64 "/home/dsl/workspace/plhamK/plham/agent/FCNAgent.x10"
        final cassia.util.JSON.Value t$22298 = json.<java.lang.String> get(x10.rtt.Types.STRING, (("noiseWeight")));
        
        //#line 64 "/home/dsl/workspace/plhamK/plham/agent/FCNAgent.x10"
        final double t$22299 = jsonrandom.nextRandom$O(((t$22298)));
        
        //#line 64 "/home/dsl/workspace/plhamK/plham/agent/FCNAgent.x10"
        this.noiseWeight = t$22299;
        
        //#line 65 "/home/dsl/workspace/plhamK/plham/agent/FCNAgent.x10"
        final double t$22300 = jsonrandom.nextDouble$O();
        
        //#line 65 "/home/dsl/workspace/plhamK/plham/agent/FCNAgent.x10"
        final boolean t$22301 = ((t$22300) < (((1.0))));
        
        //#line 65 "/home/dsl/workspace/plhamK/plham/agent/FCNAgent.x10"
        this.isChartFollowing = t$22301;
        
        //#line 66 "/home/dsl/workspace/plhamK/plham/agent/FCNAgent.x10"
        final cassia.util.JSON.Value t$22302 = json.<java.lang.String> get(x10.rtt.Types.STRING, (("noiseScale")));
        
        //#line 66 "/home/dsl/workspace/plhamK/plham/agent/FCNAgent.x10"
        final double t$22303 = jsonrandom.nextRandom$O(((t$22302)));
        
        //#line 66 "/home/dsl/workspace/plhamK/plham/agent/FCNAgent.x10"
        this.noiseScale = t$22303;
        
        //#line 67 "/home/dsl/workspace/plhamK/plham/agent/FCNAgent.x10"
        final cassia.util.JSON.Value t$22304 = json.<java.lang.String> get(x10.rtt.Types.STRING, (("timeWindowSize")));
        
        //#line 67 "/home/dsl/workspace/plhamK/plham/agent/FCNAgent.x10"
        final double t$22305 = jsonrandom.nextRandom$O(((t$22304)));
        
        //#line 67 "/home/dsl/workspace/plhamK/plham/agent/FCNAgent.x10"
        final long t$22306 = ((long)(((t$22305))));
        
        //#line 67 "/home/dsl/workspace/plhamK/plham/agent/FCNAgent.x10"
        this.timeWindowSize = t$22306;
        
        //#line 68 "/home/dsl/workspace/plhamK/plham/agent/FCNAgent.x10"
        final cassia.util.JSON.Value t$22307 = json.<java.lang.String> get(x10.rtt.Types.STRING, (("orderMargin")));
        
        //#line 68 "/home/dsl/workspace/plhamK/plham/agent/FCNAgent.x10"
        final double t$22308 = jsonrandom.nextRandom$O(((t$22307)));
        
        //#line 68 "/home/dsl/workspace/plhamK/plham/agent/FCNAgent.x10"
        this.orderMargin = t$22308;
        
        //#line 69 "/home/dsl/workspace/plhamK/plham/agent/FCNAgent.x10"
        final cassia.util.JSON.Value t$22309 = json.<java.lang.String> $apply__0cassia$util$JSON$Value$$T(x10.rtt.Types.STRING, (("marginType")), (("fixed")));
        
        //#line 69 "/home/dsl/workspace/plhamK/plham/agent/FCNAgent.x10"
        final cassia.util.JSON.Value t$22310 = MARGIN_TYPES.<cassia.util.JSON.Value> get(cassia.util.JSON.Value.$RTT, ((t$22309)));
        
        //#line 69 "/home/dsl/workspace/plhamK/plham/agent/FCNAgent.x10"
        final long t$22311 = t$22310.toLong$O();
        
        //#line 69 "/home/dsl/workspace/plhamK/plham/agent/FCNAgent.x10"
        this.marginType = t$22311;
        
        //#line 70 "/home/dsl/workspace/plhamK/plham/agent/FCNAgent.x10"
        final boolean t$22316 = json.<java.lang.String> has__0cassia$util$JSON$Value$$T$O(x10.rtt.Types.STRING, (("meanReversionTime")));
        
        //#line 70 "/home/dsl/workspace/plhamK/plham/agent/FCNAgent.x10"
        if (t$22316) {
            
            //#line 71 "/home/dsl/workspace/plhamK/plham/agent/FCNAgent.x10"
            final cassia.util.JSON.Value t$22312 = json.<java.lang.String> get(x10.rtt.Types.STRING, (("meanReversionTime")));
            
            //#line 71 "/home/dsl/workspace/plhamK/plham/agent/FCNAgent.x10"
            final double t$22313 = jsonrandom.nextRandom$O(((t$22312)));
            
            //#line 71 "/home/dsl/workspace/plhamK/plham/agent/FCNAgent.x10"
            final long t$22314 = ((long)(((t$22313))));
            
            //#line 71 "/home/dsl/workspace/plhamK/plham/agent/FCNAgent.x10"
            this.meanReversionTime = t$22314;
        } else {
            
            //#line 73 "/home/dsl/workspace/plhamK/plham/agent/FCNAgent.x10"
            final long t$22315 = this.timeWindowSize;
            
            //#line 73 "/home/dsl/workspace/plhamK/plham/agent/FCNAgent.x10"
            this.meanReversionTime = t$22315;
        }
        
        //#line 75 "/home/dsl/workspace/plhamK/plham/agent/FCNAgent.x10"
        return this;
    }
    
    
    //#line 78 "/home/dsl/workspace/plhamK/plham/agent/FCNAgent.x10"
    public static boolean isFinite$O(final double x) {
        
        //#line 79 "/home/dsl/workspace/plhamK/plham/agent/FCNAgent.x10"
        final boolean t$22317 = java.lang.Double.isNaN(x);
        
        //#line 79 "/home/dsl/workspace/plhamK/plham/agent/FCNAgent.x10"
        boolean t$22319 = !(t$22317);
        
        //#line 79 "/home/dsl/workspace/plhamK/plham/agent/FCNAgent.x10"
        if (t$22319) {
            
            //#line 79 "/home/dsl/workspace/plhamK/plham/agent/FCNAgent.x10"
            final boolean t$22318 = java.lang.Double.isInfinite(x);
            
            //#line 79 "/home/dsl/workspace/plhamK/plham/agent/FCNAgent.x10"
            t$22319 = !(t$22318);
        }
        
        //#line 79 "/home/dsl/workspace/plhamK/plham/agent/FCNAgent.x10"
        final boolean t$22320 = t$22319;
        
        //#line 79 "/home/dsl/workspace/plhamK/plham/agent/FCNAgent.x10"
        return t$22320;
    }
    
    
    //#line 82 "/home/dsl/workspace/plhamK/plham/agent/FCNAgent.x10"
    public x10.util.List submitOrders(final x10.util.List markets) {
        
        //#line 83 "/home/dsl/workspace/plhamK/plham/agent/FCNAgent.x10"
        final x10.util.ArrayList orders = ((new x10.util.ArrayList<plham.Order>((java.lang.System[]) null, plham.Order.$RTT).x10$util$ArrayList$$init$S()));
        
        //#line 84 "/home/dsl/workspace/plhamK/plham/agent/FCNAgent.x10"
        final x10.util.ListIterator market$22417 = (((x10.util.List<plham.Market>)markets).iterator());
        
        //#line 84 "/home/dsl/workspace/plhamK/plham/agent/FCNAgent.x10"
        for (;
             true;
             ) {
            
            //#line 84 "/home/dsl/workspace/plhamK/plham/agent/FCNAgent.x10"
            final boolean t$22418 = ((x10.util.ListIterator<plham.Market>)market$22417).hasNext$O();
            
            //#line 84 "/home/dsl/workspace/plhamK/plham/agent/FCNAgent.x10"
            if (!(t$22418)) {
                
                //#line 84 "/home/dsl/workspace/plhamK/plham/agent/FCNAgent.x10"
                break;
            }
            
            //#line 84 "/home/dsl/workspace/plhamK/plham/agent/FCNAgent.x10"
            final plham.Market market$22414 = ((((x10.util.ListIterator<plham.Market>)market$22417).next$G()));
            
            //#line 85 "/home/dsl/workspace/plhamK/plham/agent/FCNAgent.x10"
            final boolean t$22415 = this.isMarketAccessible(((market$22414)));
            
            //#line 85 "/home/dsl/workspace/plhamK/plham/agent/FCNAgent.x10"
            if (t$22415) {
                
                //#line 86 "/home/dsl/workspace/plhamK/plham/agent/FCNAgent.x10"
                final x10.util.List t$22416 = this.submitOrders(((market$22414)));
                
                //#line 86 "/home/dsl/workspace/plhamK/plham/agent/FCNAgent.x10"
                ((x10.util.AbstractCollection<plham.Order>)orders).addAll__0$1x10$util$AbstractCollection$$T$2$O(((t$22416)));
            }
        }
        
        //#line 89 "/home/dsl/workspace/plhamK/plham/agent/FCNAgent.x10"
        return orders;
    }
    
    
    //#line 92 "/home/dsl/workspace/plhamK/plham/agent/FCNAgent.x10"
    public x10.util.List submitOrders(final plham.Market market) {
        
        //#line 93 "/home/dsl/workspace/plhamK/plham/agent/FCNAgent.x10"
        final x10.util.ArrayList orders = ((new x10.util.ArrayList<plham.Order>((java.lang.System[]) null, plham.Order.$RTT).x10$util$ArrayList$$init$S()));
        
        //#line 94 "/home/dsl/workspace/plhamK/plham/agent/FCNAgent.x10"
        final boolean t$22325 = this.isMarketAccessible(((market)));
        
        //#line 94 "/home/dsl/workspace/plhamK/plham/agent/FCNAgent.x10"
        final boolean t$22326 = !(t$22325);
        
        //#line 94 "/home/dsl/workspace/plhamK/plham/agent/FCNAgent.x10"
        if (t$22326) {
            
            //#line 95 "/home/dsl/workspace/plhamK/plham/agent/FCNAgent.x10"
            return orders;
        }
        
        //#line 98 "/home/dsl/workspace/plhamK/plham/agent/FCNAgent.x10"
        final x10.util.Random t$22327 = this.getRandom();
        
        //#line 98 "/home/dsl/workspace/plhamK/plham/agent/FCNAgent.x10"
        final plham.util.RandomHelper random = ((new plham.util.RandomHelper((java.lang.System[]) null).plham$util$RandomHelper$$init$S(t$22327)));
        
        //#line 100 "/home/dsl/workspace/plhamK/plham/agent/FCNAgent.x10"
        final double t$22328 = this.fundamentalWeight;
        
        //#line 100 "/home/dsl/workspace/plhamK/plham/agent/FCNAgent.x10"
        final double t$22330 = ((1.0) + (((t$22328))));
        
        //#line 100 "/home/dsl/workspace/plhamK/plham/agent/FCNAgent.x10"
        final double t$22329 = this.chartWeight;
        
        //#line 100 "/home/dsl/workspace/plhamK/plham/agent/FCNAgent.x10"
        final double t$22331 = ((1.0) + (((t$22329))));
        
        //#line 100 "/home/dsl/workspace/plhamK/plham/agent/FCNAgent.x10"
        final double fcRatio = ((t$22330) / (((t$22331))));
        
        //#line 103 "/home/dsl/workspace/plhamK/plham/agent/FCNAgent.x10"
        final long t = market.getTime$O();
        
        //#line 106 "/home/dsl/workspace/plhamK/plham/agent/FCNAgent.x10"
        final long t$22332 = this.timeWindowSize;
        
        //#line 106 "/home/dsl/workspace/plhamK/plham/agent/FCNAgent.x10"
        final long timeWindowSize = java.lang.Math.min(((t)),((t$22332)));
        
        //#line 107 "/home/dsl/workspace/plhamK/plham/agent/FCNAgent.x10"
        assert ((timeWindowSize) >= (((0L)))): "timeWindowSize >= 0";
        
        //#line 112 "/home/dsl/workspace/plhamK/plham/agent/FCNAgent.x10"
        assert ((this.fundamentalWeight) >= (((0.0)))): "fundamentalWeight >= 0.0";
        
        //#line 113 "/home/dsl/workspace/plhamK/plham/agent/FCNAgent.x10"
        assert ((this.chartWeight) >= (((0.0)))): "chartWeight >= 0.0";
        
        //#line 114 "/home/dsl/workspace/plhamK/plham/agent/FCNAgent.x10"
        assert ((this.noiseWeight) >= (((0.0)))): "noiseWeight >= 0.0";
        
        //#line 117 "/home/dsl/workspace/plhamK/plham/agent/FCNAgent.x10"
        final long t$22333 = this.meanReversionTime;
        
        //#line 117 "/home/dsl/workspace/plhamK/plham/agent/FCNAgent.x10"
        final long t$22334 = java.lang.Math.max(((t$22333)),((1L)));
        
        //#line 117 "/home/dsl/workspace/plhamK/plham/agent/FCNAgent.x10"
        final double t$22335 = ((((t$22334))));
        
        //#line 117 "/home/dsl/workspace/plhamK/plham/agent/FCNAgent.x10"
        final double fundamentalScale = ((1.0) / (((t$22335))));
        
        //#line 118 "/home/dsl/workspace/plhamK/plham/agent/FCNAgent.x10"
        final double t$22336 = market.getFundamentalPrice((t));
        
        //#line 118 "/home/dsl/workspace/plhamK/plham/agent/FCNAgent.x10"
        final double t$22337 = market.getPrice$O((t));
        
        //#line 118 "/home/dsl/workspace/plhamK/plham/agent/FCNAgent.x10"
        final double t$22338 = ((t$22336) / (((t$22337))));
        
        //#line 118 "/home/dsl/workspace/plhamK/plham/agent/FCNAgent.x10"
        final double t$22339 = java.lang.Math.log(((t$22338)));
        
        //#line 118 "/home/dsl/workspace/plhamK/plham/agent/FCNAgent.x10"
        final double fundamentalLogReturn = ((fundamentalScale) * (((t$22339))));
        
        //#line 119 "/home/dsl/workspace/plhamK/plham/agent/FCNAgent.x10"
        assert plham.agent.FCNAgent.isFinite$O((fundamentalLogReturn)): "isFinite(fundamentalLogReturn)";
        
        //#line 122 "/home/dsl/workspace/plhamK/plham/agent/FCNAgent.x10"
        final long t$22340 = java.lang.Math.max(((timeWindowSize)),((1L)));
        
        //#line 122 "/home/dsl/workspace/plhamK/plham/agent/FCNAgent.x10"
        final double t$22341 = ((((t$22340))));
        
        //#line 122 "/home/dsl/workspace/plhamK/plham/agent/FCNAgent.x10"
        final double chartScale = ((1.0) / (((t$22341))));
        
        //#line 123 "/home/dsl/workspace/plhamK/plham/agent/FCNAgent.x10"
        final double t$22343 = market.getPrice$O((t));
        
        //#line 123 "/home/dsl/workspace/plhamK/plham/agent/FCNAgent.x10"
        final long t$22342 = ((t) - (((timeWindowSize))));
        
        //#line 123 "/home/dsl/workspace/plhamK/plham/agent/FCNAgent.x10"
        final double t$22344 = market.getPrice$O((t$22342));
        
        //#line 123 "/home/dsl/workspace/plhamK/plham/agent/FCNAgent.x10"
        final double t$22345 = ((t$22343) / (((t$22344))));
        
        //#line 123 "/home/dsl/workspace/plhamK/plham/agent/FCNAgent.x10"
        final double t$22346 = java.lang.Math.log(((t$22345)));
        
        //#line 123 "/home/dsl/workspace/plhamK/plham/agent/FCNAgent.x10"
        final double chartMeanLogReturn = ((chartScale) * (((t$22346))));
        
        //#line 124 "/home/dsl/workspace/plhamK/plham/agent/FCNAgent.x10"
        assert plham.agent.FCNAgent.isFinite$O((chartMeanLogReturn)): "isFinite(chartMeanLogReturn)";
        
        //#line 127 "/home/dsl/workspace/plhamK/plham/agent/FCNAgent.x10"
        final double t$22347 = this.noiseScale;
        
        //#line 127 "/home/dsl/workspace/plhamK/plham/agent/FCNAgent.x10"
        final double t$22348 = random.nextGaussian$O();
        
        //#line 127 "/home/dsl/workspace/plhamK/plham/agent/FCNAgent.x10"
        final double t$22349 = ((t$22347) * (((t$22348))));
        
        //#line 127 "/home/dsl/workspace/plhamK/plham/agent/FCNAgent.x10"
        final double noiseLogReturn = ((0.0) + (((t$22349))));
        
        //#line 128 "/home/dsl/workspace/plhamK/plham/agent/FCNAgent.x10"
        assert plham.agent.FCNAgent.isFinite$O((noiseLogReturn)): "isFinite(noiseLogReturn)";
        
        //#line 131 "/home/dsl/workspace/plhamK/plham/agent/FCNAgent.x10"
        final double t$22350 = this.fundamentalWeight;
        
        //#line 131 "/home/dsl/workspace/plhamK/plham/agent/FCNAgent.x10"
        final double t$22351 = this.chartWeight;
        
        //#line 131 "/home/dsl/workspace/plhamK/plham/agent/FCNAgent.x10"
        final double t$22352 = ((t$22350) + (((t$22351))));
        
        //#line 131 "/home/dsl/workspace/plhamK/plham/agent/FCNAgent.x10"
        final double t$22353 = this.noiseWeight;
        
        //#line 131 "/home/dsl/workspace/plhamK/plham/agent/FCNAgent.x10"
        final double t$22354 = ((t$22352) + (((t$22353))));
        
        //#line 131 "/home/dsl/workspace/plhamK/plham/agent/FCNAgent.x10"
        final double t$22367 = ((1.0) / (((t$22354))));
        
        //#line 132 "/home/dsl/workspace/plhamK/plham/agent/FCNAgent.x10"
        final double t$22355 = this.fundamentalWeight;
        
        //#line 132 "/home/dsl/workspace/plhamK/plham/agent/FCNAgent.x10"
        final double t$22362 = ((t$22355) * (((fundamentalLogReturn))));
        
        //#line 133 "/home/dsl/workspace/plhamK/plham/agent/FCNAgent.x10"
        final double t$22356 = this.chartWeight;
        
        //#line 133 "/home/dsl/workspace/plhamK/plham/agent/FCNAgent.x10"
        final double t$22360 = ((t$22356) * (((chartMeanLogReturn))));
        
        //#line 133 "/home/dsl/workspace/plhamK/plham/agent/FCNAgent.x10"
        final boolean t$22357 = this.isChartFollowing;
        
        //#line 133 "/home/dsl/workspace/plhamK/plham/agent/FCNAgent.x10"
        long t$22358 =  0;
        
        //#line 133 "/home/dsl/workspace/plhamK/plham/agent/FCNAgent.x10"
        if (t$22357) {
            
            //#line 133 "/home/dsl/workspace/plhamK/plham/agent/FCNAgent.x10"
            t$22358 = 1L;
        } else {
            
            //#line 133 "/home/dsl/workspace/plhamK/plham/agent/FCNAgent.x10"
            t$22358 = -1L;
        }
        
        //#line 133 "/home/dsl/workspace/plhamK/plham/agent/FCNAgent.x10"
        final long t$22359 = t$22358;
        
        //#line 133 "/home/dsl/workspace/plhamK/plham/agent/FCNAgent.x10"
        final double t$22361 = ((((t$22359))));
        
        //#line 133 "/home/dsl/workspace/plhamK/plham/agent/FCNAgent.x10"
        final double t$22363 = ((t$22360) * (((t$22361))));
        
        //#line 132 "/home/dsl/workspace/plhamK/plham/agent/FCNAgent.x10"
        final double t$22365 = ((t$22362) + (((t$22363))));
        
        //#line 134 "/home/dsl/workspace/plhamK/plham/agent/FCNAgent.x10"
        final double t$22364 = this.noiseWeight;
        
        //#line 134 "/home/dsl/workspace/plhamK/plham/agent/FCNAgent.x10"
        final double t$22366 = ((t$22364) * (((noiseLogReturn))));
        
        //#line 132 "/home/dsl/workspace/plhamK/plham/agent/FCNAgent.x10"
        final double t$22368 = ((t$22365) + (((t$22366))));
        
        //#line 131 "/home/dsl/workspace/plhamK/plham/agent/FCNAgent.x10"
        final double expectedLogReturn = ((t$22367) * (((t$22368))));
        
        //#line 135 "/home/dsl/workspace/plhamK/plham/agent/FCNAgent.x10"
        assert plham.agent.FCNAgent.isFinite$O((expectedLogReturn)): "isFinite(expectedLogReturn)";
        
        //#line 138 "/home/dsl/workspace/plhamK/plham/agent/FCNAgent.x10"
        final double t$22371 = market.getPrice$O((t));
        
        //#line 138 "/home/dsl/workspace/plhamK/plham/agent/FCNAgent.x10"
        final double t$22369 = ((((timeWindowSize))));
        
        //#line 138 "/home/dsl/workspace/plhamK/plham/agent/FCNAgent.x10"
        final double t$22370 = ((expectedLogReturn) * (((t$22369))));
        
        //#line 138 "/home/dsl/workspace/plhamK/plham/agent/FCNAgent.x10"
        final double t$22372 = java.lang.Math.exp(((t$22370)));
        
        //#line 138 "/home/dsl/workspace/plhamK/plham/agent/FCNAgent.x10"
        final double expectedFuturePrice = ((t$22371) * (((t$22372))));
        
        //#line 139 "/home/dsl/workspace/plhamK/plham/agent/FCNAgent.x10"
        assert plham.agent.FCNAgent.isFinite$O((expectedFuturePrice)): "isFinite(expectedFuturePrice)";
        
        //#line 141 "/home/dsl/workspace/plhamK/plham/agent/FCNAgent.x10"
        final long t$22373 = this.marginType;
        
        //#line 141 "/home/dsl/workspace/plhamK/plham/agent/FCNAgent.x10"
        final long t$22374 = plham.agent.FCNAgent.MARGIN_FIXED;
        
        //#line 141 "/home/dsl/workspace/plhamK/plham/agent/FCNAgent.x10"
        final boolean t$22395 = (t$22373) == (t$22374);
        
        //#line 141 "/home/dsl/workspace/plhamK/plham/agent/FCNAgent.x10"
        if (t$22395) {
            
            //#line 144 "/home/dsl/workspace/plhamK/plham/agent/FCNAgent.x10"
            assert ((0.0) <= (((this.orderMargin)))) && ((this.orderMargin) <= (((1.0))));
            
            //#line 146 "/home/dsl/workspace/plhamK/plham/agent/FCNAgent.x10"
            double orderPrice = 0.0;
            
            //#line 147 "/home/dsl/workspace/plhamK/plham/agent/FCNAgent.x10"
            long orderVolume = 1L;
            
            //#line 149 "/home/dsl/workspace/plhamK/plham/agent/FCNAgent.x10"
            final double t$22375 = market.getPrice$O((t));
            
            //#line 149 "/home/dsl/workspace/plhamK/plham/agent/FCNAgent.x10"
            final boolean t$22384 = ((expectedFuturePrice) > (((t$22375))));
            
            //#line 149 "/home/dsl/workspace/plhamK/plham/agent/FCNAgent.x10"
            if (t$22384) {
                
                //#line 151 "/home/dsl/workspace/plhamK/plham/agent/FCNAgent.x10"
                final double t$22376 = ((((1L))));
                
                //#line 151 "/home/dsl/workspace/plhamK/plham/agent/FCNAgent.x10"
                final double t$22377 = this.orderMargin;
                
                //#line 151 "/home/dsl/workspace/plhamK/plham/agent/FCNAgent.x10"
                final double t$22378 = ((t$22376) - (((t$22377))));
                
                //#line 151 "/home/dsl/workspace/plhamK/plham/agent/FCNAgent.x10"
                final double t$22379 = ((expectedFuturePrice) * (((t$22378))));
                
                //#line 151 "/home/dsl/workspace/plhamK/plham/agent/FCNAgent.x10"
                orderPrice = t$22379;
                
                //#line 152 "/home/dsl/workspace/plhamK/plham/agent/FCNAgent.x10"
                final plham.Order.Kind t$22380 = ((plham.Order.get$KIND_BUY_LIMIT_ORDER()));
                
                //#line 152 "/home/dsl/workspace/plhamK/plham/agent/FCNAgent.x10"
                final double t$22381 = orderPrice;
                
                //#line 152 "/home/dsl/workspace/plhamK/plham/agent/FCNAgent.x10"
                final long t$22382 = orderVolume;
                
                //#line 152 "/home/dsl/workspace/plhamK/plham/agent/FCNAgent.x10"
                final plham.Order t$22383 = ((new plham.Order((java.lang.System[]) null).plham$Order$$init$S(((t$22380)), ((this)), ((market)), t$22381, t$22382, ((timeWindowSize)))));
                
                //#line 152 "/home/dsl/workspace/plhamK/plham/agent/FCNAgent.x10"
                ((x10.util.ArrayList<plham.Order>)orders).add__0x10$util$ArrayList$$T$O(((t$22383)));
            }
            
            //#line 154 "/home/dsl/workspace/plhamK/plham/agent/FCNAgent.x10"
            final double t$22385 = market.getPrice$O((t));
            
            //#line 154 "/home/dsl/workspace/plhamK/plham/agent/FCNAgent.x10"
            final boolean t$22394 = ((expectedFuturePrice) < (((t$22385))));
            
            //#line 154 "/home/dsl/workspace/plhamK/plham/agent/FCNAgent.x10"
            if (t$22394) {
                
                //#line 156 "/home/dsl/workspace/plhamK/plham/agent/FCNAgent.x10"
                final double t$22386 = ((((1L))));
                
                //#line 156 "/home/dsl/workspace/plhamK/plham/agent/FCNAgent.x10"
                final double t$22387 = this.orderMargin;
                
                //#line 156 "/home/dsl/workspace/plhamK/plham/agent/FCNAgent.x10"
                final double t$22388 = ((t$22386) + (((t$22387))));
                
                //#line 156 "/home/dsl/workspace/plhamK/plham/agent/FCNAgent.x10"
                final double t$22389 = ((expectedFuturePrice) * (((t$22388))));
                
                //#line 156 "/home/dsl/workspace/plhamK/plham/agent/FCNAgent.x10"
                orderPrice = t$22389;
                
                //#line 157 "/home/dsl/workspace/plhamK/plham/agent/FCNAgent.x10"
                final plham.Order.Kind t$22390 = ((plham.Order.get$KIND_SELL_LIMIT_ORDER()));
                
                //#line 157 "/home/dsl/workspace/plhamK/plham/agent/FCNAgent.x10"
                final double t$22391 = orderPrice;
                
                //#line 157 "/home/dsl/workspace/plhamK/plham/agent/FCNAgent.x10"
                final long t$22392 = orderVolume;
                
                //#line 157 "/home/dsl/workspace/plhamK/plham/agent/FCNAgent.x10"
                final plham.Order t$22393 = ((new plham.Order((java.lang.System[]) null).plham$Order$$init$S(((t$22390)), ((this)), ((market)), t$22391, t$22392, ((timeWindowSize)))));
                
                //#line 157 "/home/dsl/workspace/plhamK/plham/agent/FCNAgent.x10"
                ((x10.util.ArrayList<plham.Order>)orders).add__0x10$util$ArrayList$$T$O(((t$22393)));
            }
            
            //#line 159 "/home/dsl/workspace/plhamK/plham/agent/FCNAgent.x10"
            assert ((orderPrice) >= (((0.0)))): x10.runtime.impl.java.ArrayUtils.<java.lang.Object> makeRailFromJavaArray(x10.rtt.Types.ANY, new java.lang.Object[] {"orderPrice >= 0.0", orderPrice});
            
            //#line 160 "/home/dsl/workspace/plhamK/plham/agent/FCNAgent.x10"
            assert ((orderVolume) >= (((0L)))): x10.runtime.impl.java.ArrayUtils.<java.lang.Object> makeRailFromJavaArray(x10.rtt.Types.ANY, new java.lang.Object[] {"orderVolume >= 0", orderVolume});
        }
        
        //#line 162 "/home/dsl/workspace/plhamK/plham/agent/FCNAgent.x10"
        final long t$22396 = this.marginType;
        
        //#line 162 "/home/dsl/workspace/plhamK/plham/agent/FCNAgent.x10"
        final long t$22397 = plham.agent.FCNAgent.MARGIN_NORMAL;
        
        //#line 162 "/home/dsl/workspace/plhamK/plham/agent/FCNAgent.x10"
        final boolean t$22413 = (t$22396) == (t$22397);
        
        //#line 162 "/home/dsl/workspace/plhamK/plham/agent/FCNAgent.x10"
        if (t$22413) {
            
            //#line 165 "/home/dsl/workspace/plhamK/plham/agent/FCNAgent.x10"
            assert ((this.orderMargin) >= (((0.0))));
            
            //#line 167 "/home/dsl/workspace/plhamK/plham/agent/FCNAgent.x10"
            final double t$22398 = random.nextGaussian$O();
            
            //#line 167 "/home/dsl/workspace/plhamK/plham/agent/FCNAgent.x10"
            final double t$22399 = this.orderMargin;
            
            //#line 167 "/home/dsl/workspace/plhamK/plham/agent/FCNAgent.x10"
            final double t$22400 = ((t$22398) * (((t$22399))));
            
            //#line 167 "/home/dsl/workspace/plhamK/plham/agent/FCNAgent.x10"
            double orderPrice = ((expectedFuturePrice) + (((t$22400))));
            
            //#line 168 "/home/dsl/workspace/plhamK/plham/agent/FCNAgent.x10"
            long orderVolume = 1L;
            
            //#line 169 "/home/dsl/workspace/plhamK/plham/agent/FCNAgent.x10"
            assert ((orderPrice) >= (((0.0)))): x10.runtime.impl.java.ArrayUtils.<java.lang.Object> makeRailFromJavaArray(x10.rtt.Types.ANY, new java.lang.Object[] {"orderPrice >= 0.0", orderPrice});
            
            //#line 170 "/home/dsl/workspace/plhamK/plham/agent/FCNAgent.x10"
            assert ((orderVolume) >= (((0L)))): x10.runtime.impl.java.ArrayUtils.<java.lang.Object> makeRailFromJavaArray(x10.rtt.Types.ANY, new java.lang.Object[] {"orderVolume >= 0", orderVolume});
            
            //#line 172 "/home/dsl/workspace/plhamK/plham/agent/FCNAgent.x10"
            final double t$22401 = orderPrice;
            
            //#line 172 "/home/dsl/workspace/plhamK/plham/agent/FCNAgent.x10"
            final boolean t$22406 = ((expectedFuturePrice) > (((t$22401))));
            
            //#line 172 "/home/dsl/workspace/plhamK/plham/agent/FCNAgent.x10"
            if (t$22406) {
                
                //#line 174 "/home/dsl/workspace/plhamK/plham/agent/FCNAgent.x10"
                final plham.Order.Kind t$22402 = ((plham.Order.get$KIND_BUY_LIMIT_ORDER()));
                
                //#line 174 "/home/dsl/workspace/plhamK/plham/agent/FCNAgent.x10"
                final double t$22403 = orderPrice;
                
                //#line 174 "/home/dsl/workspace/plhamK/plham/agent/FCNAgent.x10"
                final long t$22404 = orderVolume;
                
                //#line 174 "/home/dsl/workspace/plhamK/plham/agent/FCNAgent.x10"
                final plham.Order t$22405 = ((new plham.Order((java.lang.System[]) null).plham$Order$$init$S(((t$22402)), ((this)), ((market)), t$22403, t$22404, ((timeWindowSize)))));
                
                //#line 174 "/home/dsl/workspace/plhamK/plham/agent/FCNAgent.x10"
                ((x10.util.ArrayList<plham.Order>)orders).add__0x10$util$ArrayList$$T$O(((t$22405)));
            }
            
            //#line 176 "/home/dsl/workspace/plhamK/plham/agent/FCNAgent.x10"
            final double t$22407 = orderPrice;
            
            //#line 176 "/home/dsl/workspace/plhamK/plham/agent/FCNAgent.x10"
            final boolean t$22412 = ((expectedFuturePrice) < (((t$22407))));
            
            //#line 176 "/home/dsl/workspace/plhamK/plham/agent/FCNAgent.x10"
            if (t$22412) {
                
                //#line 178 "/home/dsl/workspace/plhamK/plham/agent/FCNAgent.x10"
                final plham.Order.Kind t$22408 = ((plham.Order.get$KIND_SELL_LIMIT_ORDER()));
                
                //#line 178 "/home/dsl/workspace/plhamK/plham/agent/FCNAgent.x10"
                final double t$22409 = orderPrice;
                
                //#line 178 "/home/dsl/workspace/plhamK/plham/agent/FCNAgent.x10"
                final long t$22410 = orderVolume;
                
                //#line 178 "/home/dsl/workspace/plhamK/plham/agent/FCNAgent.x10"
                final plham.Order t$22411 = ((new plham.Order((java.lang.System[]) null).plham$Order$$init$S(((t$22408)), ((this)), ((market)), t$22409, t$22410, ((timeWindowSize)))));
                
                //#line 178 "/home/dsl/workspace/plhamK/plham/agent/FCNAgent.x10"
                ((x10.util.ArrayList<plham.Order>)orders).add__0x10$util$ArrayList$$T$O(((t$22411)));
            }
        }
        
        //#line 181 "/home/dsl/workspace/plhamK/plham/agent/FCNAgent.x10"
        return orders;
    }
    
    
    //#line 24 "/home/dsl/workspace/plhamK/plham/agent/FCNAgent.x10"
    final public plham.agent.FCNAgent plham$agent$FCNAgent$$this$plham$agent$FCNAgent() {
        
        //#line 24 "/home/dsl/workspace/plhamK/plham/agent/FCNAgent.x10"
        return plham.agent.FCNAgent.this;
    }
    
    
    //#line 24 "/home/dsl/workspace/plhamK/plham/agent/FCNAgent.x10"
    final public void __fieldInitializers_plham_agent_FCNAgent() {
        
        //#line 24 "/home/dsl/workspace/plhamK/plham/agent/FCNAgent.x10"
        this.fundamentalWeight = 0.0;
        
        //#line 24 "/home/dsl/workspace/plhamK/plham/agent/FCNAgent.x10"
        this.chartWeight = 0.0;
        
        //#line 24 "/home/dsl/workspace/plhamK/plham/agent/FCNAgent.x10"
        this.noiseWeight = 0.0;
        
        //#line 24 "/home/dsl/workspace/plhamK/plham/agent/FCNAgent.x10"
        this.noiseScale = 0.0;
        
        //#line 24 "/home/dsl/workspace/plhamK/plham/agent/FCNAgent.x10"
        this.timeWindowSize = 0L;
        
        //#line 24 "/home/dsl/workspace/plhamK/plham/agent/FCNAgent.x10"
        this.orderMargin = 0.0;
        
        //#line 24 "/home/dsl/workspace/plhamK/plham/agent/FCNAgent.x10"
        this.isChartFollowing = false;
        
        //#line 24 "/home/dsl/workspace/plhamK/plham/agent/FCNAgent.x10"
        this.meanReversionTime = 0L;
        
        //#line 24 "/home/dsl/workspace/plhamK/plham/agent/FCNAgent.x10"
        this.marginType = 0L;
    }
    
    public static long get$MARGIN_FIXED() {
        return plham.agent.FCNAgent.MARGIN_FIXED;
    }
    
    public static long get$MARGIN_NORMAL() {
        return plham.agent.FCNAgent.MARGIN_NORMAL;
    }
    
    
    final public static class $Closure$9 extends x10.core.Ref implements x10.core.fun.Fun_0_4, x10.serialization.X10JavaSerializable
    {
        public static final x10.rtt.RuntimeType<$Closure$9> $RTT = 
            x10.rtt.StaticFunType.<$Closure$9> make($Closure$9.class,
                                                    new x10.rtt.Type[] {
                                                        x10.rtt.ParameterizedType.make(x10.core.fun.Fun_0_4.$RTT, x10.rtt.Types.LONG, x10.rtt.Types.STRING, x10.util.Random.$RTT, cassia.util.JSON.Value.$RTT, plham.agent.FCNAgent.$RTT)
                                                    });
        
        public x10.rtt.RuntimeType<?> $getRTT() { return $RTT; }
        
        public x10.rtt.Type<?> $getParam(int i) { return null; }
        
        private Object writeReplace() throws java.io.ObjectStreamException {
            return new x10.serialization.SerializationProxy(this);
        }
        
        public static x10.serialization.X10JavaSerializable $_deserialize_body(plham.agent.FCNAgent.$Closure$9 $_obj, x10.serialization.X10JavaDeserializer $deserializer) throws java.io.IOException {
            if (x10.runtime.impl.java.Runtime.TRACE_SER) { x10.runtime.impl.java.Runtime.printTraceMessage("X10JavaSerializable: $_deserialize_body() of " + $Closure$9.class + " calling"); } 
            $_obj.sim = $deserializer.readObject();
            return $_obj;
        }
        
        public static x10.serialization.X10JavaSerializable $_deserializer(x10.serialization.X10JavaDeserializer $deserializer) throws java.io.IOException {
            plham.agent.FCNAgent.$Closure$9 $_obj = new plham.agent.FCNAgent.$Closure$9((java.lang.System[]) null);
            $deserializer.record_reference($_obj);
            return $_deserialize_body($_obj, $deserializer);
        }
        
        public void $_serialize(x10.serialization.X10JavaSerializer $serializer) throws java.io.IOException {
            $serializer.write(this.sim);
            
        }
        
        // constructor just for allocation
        public $Closure$9(final java.lang.System[] $dummy) {
            
        }
        
        // dispatcher for method abstract public (Z1,Z2,Z3,Z4)=>U.operator()(a1:Z1, a2:Z2, a3:Z3, a4:Z4):U
        public java.lang.Object $apply(final java.lang.Object a1, final x10.rtt.Type t1, final java.lang.Object a2, final x10.rtt.Type t2, final java.lang.Object a3, final x10.rtt.Type t3, final java.lang.Object a4, final x10.rtt.Type t4) {
            return $apply(x10.core.Long.$unbox(a1), (java.lang.String)a2, (x10.util.Random)a3, (cassia.util.JSON.Value)a4);
            
        }
        
        
    
        
        public plham.agent.FCNAgent $apply(final long id, final java.lang.String name, final x10.util.Random random, final cassia.util.JSON.Value json) {
            
            //#line 50 "/home/dsl/workspace/plhamK/plham/agent/FCNAgent.x10"
            final plham.agent.FCNAgent t$22283 = ((new plham.agent.FCNAgent((java.lang.System[]) null).plham$agent$FCNAgent$$init$S(((id)), ((name)), ((random)))));
            
            //#line 50 "/home/dsl/workspace/plhamK/plham/agent/FCNAgent.x10"
            final plham.agent.FCNAgent t$22284 = t$22283.setup(((json)), ((this.sim)));
            
            //#line 50 "/home/dsl/workspace/plhamK/plham/agent/FCNAgent.x10"
            return t$22284;
        }
        
        public plham.main.Simulator sim;
        
        public $Closure$9(final plham.main.Simulator sim) {
             {
                this.sim = ((sim));
            }
        }
        
    }
    
    
    public plham.Agent plham$Agent$setup$S(final cassia.util.JSON.Value a0, final plham.main.Simulator a1) {
        return super.setup(((a0)), ((a1)));
    }
}

