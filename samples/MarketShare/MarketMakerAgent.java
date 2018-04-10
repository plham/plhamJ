package samples.MarketShare;


@x10.runtime.impl.java.X10Generated
public class MarketMakerAgent extends plham.HighFrequencyAgent implements x10.serialization.X10JavaSerializable
{
    public static final x10.rtt.RuntimeType<MarketMakerAgent> $RTT = 
        x10.rtt.NamedType.<MarketMakerAgent> make("samples.MarketShare.MarketMakerAgent",
                                                  MarketMakerAgent.class,
                                                  new x10.rtt.Type[] {
                                                      plham.HighFrequencyAgent.$RTT
                                                  });
    
    public x10.rtt.RuntimeType<?> $getRTT() { return $RTT; }
    
    public x10.rtt.Type<?> $getParam(int i) { return null; }
    
    private Object writeReplace() throws java.io.ObjectStreamException {
        return new x10.serialization.SerializationProxy(this);
    }
    
    public static x10.serialization.X10JavaSerializable $_deserialize_body(samples.MarketShare.MarketMakerAgent $_obj, x10.serialization.X10JavaDeserializer $deserializer) throws java.io.IOException {
        if (x10.runtime.impl.java.Runtime.TRACE_SER) { x10.runtime.impl.java.Runtime.printTraceMessage("X10JavaSerializable: $_deserialize_body() of " + MarketMakerAgent.class + " calling"); } 
        plham.HighFrequencyAgent.$_deserialize_body($_obj, $deserializer);
        $_obj.netInterestSpread = $deserializer.readDouble();
        $_obj.orderTimeLength = $deserializer.readLong();
        $_obj.targetMarketId = $deserializer.readLong();
        return $_obj;
    }
    
    public static x10.serialization.X10JavaSerializable $_deserializer(x10.serialization.X10JavaDeserializer $deserializer) throws java.io.IOException {
        samples.MarketShare.MarketMakerAgent $_obj = new samples.MarketShare.MarketMakerAgent((java.lang.System[]) null);
        $deserializer.record_reference($_obj);
        return $_deserialize_body($_obj, $deserializer);
    }
    
    public void $_serialize(x10.serialization.X10JavaSerializer $serializer) throws java.io.IOException {
        super.$_serialize($serializer);
        $serializer.write(this.netInterestSpread);
        $serializer.write(this.orderTimeLength);
        $serializer.write(this.targetMarketId);
        
    }
    
    // constructor just for allocation
    public MarketMakerAgent(final java.lang.System[] $dummy) {
        super($dummy);
        
    }
    
    

    
    //#line 14 "/home/dsl/workspace/plhamK/samples/MarketShare/MarketMakerAgent.x10"
    public long targetMarketId;
    
    //#line 15 "/home/dsl/workspace/plhamK/samples/MarketShare/MarketMakerAgent.x10"
    public double netInterestSpread;
    
    //#line 16 "/home/dsl/workspace/plhamK/samples/MarketShare/MarketMakerAgent.x10"
    public long orderTimeLength;
    
    
    //#line 18 "/home/dsl/workspace/plhamK/samples/MarketShare/MarketMakerAgent.x10"
    // creation method for java code (1-phase java constructor)
    public MarketMakerAgent(final long id, final java.lang.String name, final x10.util.Random random) {
        this((java.lang.System[]) null);
        samples$MarketShare$MarketMakerAgent$$init$S(id, name, random);
    }
    
    // constructor for non-virtual call
    final public samples.MarketShare.MarketMakerAgent samples$MarketShare$MarketMakerAgent$$init$S(final long id, final java.lang.String name, final x10.util.Random random) {
         {
            
            //#line 18 "/home/dsl/workspace/plhamK/samples/MarketShare/MarketMakerAgent.x10"
            /*super.*/plham$HighFrequencyAgent$$init$S(((long)(id)), ((java.lang.String)(name)), ((x10.util.Random)(random)));
            
            //#line 18 "/home/dsl/workspace/plhamK/samples/MarketShare/MarketMakerAgent.x10"
            
            
            //#line 12 "/home/dsl/workspace/plhamK/samples/MarketShare/MarketMakerAgent.x10"
            this.__fieldInitializers_samples_MarketShare_MarketMakerAgent();
        }
        return this;
    }
    
    
    
    //#line 19 "/home/dsl/workspace/plhamK/samples/MarketShare/MarketMakerAgent.x10"
    public samples.MarketShare.MarketMakerAgent setup(final cassia.util.JSON.Value json, final plham.main.Simulator sim) {
        
        //#line 20 "/home/dsl/workspace/plhamK/samples/MarketShare/MarketMakerAgent.x10"
        super.setup(((cassia.util.JSON.Value)(json)), ((plham.main.Simulator)(sim)));
        
        //#line 21 "/home/dsl/workspace/plhamK/samples/MarketShare/MarketMakerAgent.x10"
        final cassia.util.JSON.Value t$24576 = ((cassia.util.JSON.Value)json).<java.lang.String> $apply__0cassia$util$JSON$Value$$T(x10.rtt.Types.STRING, ((java.lang.String)("targetMarket")));
        
        //#line 21 "/home/dsl/workspace/plhamK/samples/MarketShare/MarketMakerAgent.x10"
        final plham.Market targetMarket = sim.getMarketByName(((cassia.util.JSON.Value)(t$24576)));
        
        //#line 22 "/home/dsl/workspace/plhamK/samples/MarketShare/MarketMakerAgent.x10"
        final x10.util.Random t$24577 = this.getRandom();
        
        //#line 22 "/home/dsl/workspace/plhamK/samples/MarketShare/MarketMakerAgent.x10"
        final plham.util.JSONRandom random = ((plham.util.JSONRandom)(new plham.util.JSONRandom((java.lang.System[]) null).plham$util$JSONRandom$$init$S(t$24577)));
        
        //#line 23 "/home/dsl/workspace/plhamK/samples/MarketShare/MarketMakerAgent.x10"
        final long t$24578 = targetMarket.id;
        
        //#line 23 "/home/dsl/workspace/plhamK/samples/MarketShare/MarketMakerAgent.x10"
        this.targetMarketId = t$24578;
        
        //#line 24 "/home/dsl/workspace/plhamK/samples/MarketShare/MarketMakerAgent.x10"
        final cassia.util.JSON.Value t$24579 = ((cassia.util.JSON.Value)json).<java.lang.String> $apply__0cassia$util$JSON$Value$$T(x10.rtt.Types.STRING, ((java.lang.String)("netInterestSpread")));
        
        //#line 24 "/home/dsl/workspace/plhamK/samples/MarketShare/MarketMakerAgent.x10"
        final double t$24580 = random.nextRandom$O(((cassia.util.JSON.Value)(t$24579)));
        
        //#line 24 "/home/dsl/workspace/plhamK/samples/MarketShare/MarketMakerAgent.x10"
        this.netInterestSpread = t$24580;
        
        //#line 25 "/home/dsl/workspace/plhamK/samples/MarketShare/MarketMakerAgent.x10"
        final cassia.util.JSON.Value t$24581 = ((cassia.util.JSON.Value)json).<java.lang.String> $apply__0cassia$util$JSON$Value$$T(x10.rtt.Types.STRING, ((java.lang.String)("orderTimeLength")), ((java.lang.String)("2")));
        
        //#line 25 "/home/dsl/workspace/plhamK/samples/MarketShare/MarketMakerAgent.x10"
        final double t$24582 = random.nextRandom$O(((cassia.util.JSON.Value)(t$24581)));
        
        //#line 25 "/home/dsl/workspace/plhamK/samples/MarketShare/MarketMakerAgent.x10"
        final long t$24583 = ((long)(double)(((double)(t$24582))));
        
        //#line 25 "/home/dsl/workspace/plhamK/samples/MarketShare/MarketMakerAgent.x10"
        this.orderTimeLength = t$24583;
        
        //#line 26 "/home/dsl/workspace/plhamK/samples/MarketShare/MarketMakerAgent.x10"
        return this;
    }
    
    
    //#line 28 "/home/dsl/workspace/plhamK/samples/MarketShare/MarketMakerAgent.x10"
    public static void register(final plham.main.Simulator sim) {
        
        //#line 29 "/home/dsl/workspace/plhamK/samples/MarketShare/MarketMakerAgent.x10"
        final java.lang.String className = ((java.lang.String)("MarketMakerAgent"));
        
        //#line 31 "/home/dsl/workspace/plhamK/samples/MarketShare/MarketMakerAgent.x10"
        final x10.core.fun.Fun_0_4 t$24586 = ((x10.core.fun.Fun_0_4)(new samples.MarketShare.MarketMakerAgent.$Closure$14(sim)));
        
        //#line 30 "/home/dsl/workspace/plhamK/samples/MarketShare/MarketMakerAgent.x10"
        sim.addAgentInitializer__1$1x10$lang$Long$3x10$lang$String$3x10$util$Random$3cassia$util$JSON$Value$3plham$Agent$2(((java.lang.String)(className)), ((x10.core.fun.Fun_0_4)(t$24586)));
    }
    
    
    //#line 42 "/home/dsl/workspace/plhamK/samples/MarketShare/MarketMakerAgent.x10"
    public x10.util.List submitOrders__0$1plham$Market$2(final x10.util.List markets) {
        
        //#line 43 "/home/dsl/workspace/plhamK/samples/MarketShare/MarketMakerAgent.x10"
        final x10.util.ArrayList orders = ((x10.util.ArrayList)(new x10.util.ArrayList<plham.Order>((java.lang.System[]) null, plham.Order.$RTT).x10$util$ArrayList$$init$S()));
        
        //#line 45 "/home/dsl/workspace/plhamK/samples/MarketShare/MarketMakerAgent.x10"
        final long t$24587 = this.targetMarketId;
        
        //#line 45 "/home/dsl/workspace/plhamK/samples/MarketShare/MarketMakerAgent.x10"
        final plham.Market target = ((x10.util.Indexed<plham.Market>)markets).$apply$G((long)(t$24587));
        
        //#line 47 "/home/dsl/workspace/plhamK/samples/MarketShare/MarketMakerAgent.x10"
        double basePrice = this.getBasePrice__0$1plham$Market$2$O(((x10.util.List)(markets)));
        
        //#line 48 "/home/dsl/workspace/plhamK/samples/MarketShare/MarketMakerAgent.x10"
        final double t$24588 = basePrice;
        
        //#line 48 "/home/dsl/workspace/plhamK/samples/MarketShare/MarketMakerAgent.x10"
        final boolean t$24589 = samples.MarketShare.MarketMakerAgent.isFinite$O((double)(t$24588));
        
        //#line 48 "/home/dsl/workspace/plhamK/samples/MarketShare/MarketMakerAgent.x10"
        final boolean t$24591 = !(t$24589);
        
        //#line 48 "/home/dsl/workspace/plhamK/samples/MarketShare/MarketMakerAgent.x10"
        if (t$24591) {
            
            //#line 49 "/home/dsl/workspace/plhamK/samples/MarketShare/MarketMakerAgent.x10"
            final double t$24590 = target.getPrice$O();
            
            //#line 49 "/home/dsl/workspace/plhamK/samples/MarketShare/MarketMakerAgent.x10"
            basePrice = t$24590;
        }
        
        //#line 52 "/home/dsl/workspace/plhamK/samples/MarketShare/MarketMakerAgent.x10"
        final double t$24592 = target.getFundamentalPrice$O();
        
        //#line 52 "/home/dsl/workspace/plhamK/samples/MarketShare/MarketMakerAgent.x10"
        final double t$24593 = this.netInterestSpread;
        
        //#line 52 "/home/dsl/workspace/plhamK/samples/MarketShare/MarketMakerAgent.x10"
        final double t$24594 = ((t$24592) * (((double)(t$24593))));
        
        //#line 52 "/home/dsl/workspace/plhamK/samples/MarketShare/MarketMakerAgent.x10"
        final double priceMargin = ((t$24594) * (((double)(0.5))));
        
        //#line 53 "/home/dsl/workspace/plhamK/samples/MarketShare/MarketMakerAgent.x10"
        final long orderVolume = 1L;
        
        //#line 54 "/home/dsl/workspace/plhamK/samples/MarketShare/MarketMakerAgent.x10"
        final plham.Order.Kind t$24596 = ((plham.Order.Kind)(plham.Order.get$KIND_BUY_LIMIT_ORDER()));
        
        //#line 54 "/home/dsl/workspace/plhamK/samples/MarketShare/MarketMakerAgent.x10"
        final double t$24595 = basePrice;
        
        //#line 54 "/home/dsl/workspace/plhamK/samples/MarketShare/MarketMakerAgent.x10"
        final double t$24597 = ((t$24595) - (((double)(priceMargin))));
        
        //#line 54 "/home/dsl/workspace/plhamK/samples/MarketShare/MarketMakerAgent.x10"
        final long t$24598 = this.orderTimeLength;
        
        //#line 54 "/home/dsl/workspace/plhamK/samples/MarketShare/MarketMakerAgent.x10"
        final plham.Order t$24599 = ((plham.Order)(new plham.Order((java.lang.System[]) null).plham$Order$$init$S(((plham.Order.Kind)(t$24596)), ((plham.Agent)(this)), ((plham.Market)(target)), t$24597, ((long)(orderVolume)), t$24598)));
        
        //#line 54 "/home/dsl/workspace/plhamK/samples/MarketShare/MarketMakerAgent.x10"
        ((x10.util.ArrayList<plham.Order>)orders).add__0x10$util$ArrayList$$T$O(((plham.Order)(t$24599)));
        
        //#line 55 "/home/dsl/workspace/plhamK/samples/MarketShare/MarketMakerAgent.x10"
        final plham.Order.Kind t$24601 = ((plham.Order.Kind)(plham.Order.get$KIND_SELL_LIMIT_ORDER()));
        
        //#line 55 "/home/dsl/workspace/plhamK/samples/MarketShare/MarketMakerAgent.x10"
        final double t$24600 = basePrice;
        
        //#line 55 "/home/dsl/workspace/plhamK/samples/MarketShare/MarketMakerAgent.x10"
        final double t$24602 = ((t$24600) + (((double)(priceMargin))));
        
        //#line 55 "/home/dsl/workspace/plhamK/samples/MarketShare/MarketMakerAgent.x10"
        final long t$24603 = this.orderTimeLength;
        
        //#line 55 "/home/dsl/workspace/plhamK/samples/MarketShare/MarketMakerAgent.x10"
        final plham.Order t$24604 = ((plham.Order)(new plham.Order((java.lang.System[]) null).plham$Order$$init$S(((plham.Order.Kind)(t$24601)), ((plham.Agent)(this)), ((plham.Market)(target)), t$24602, ((long)(orderVolume)), t$24603)));
        
        //#line 55 "/home/dsl/workspace/plhamK/samples/MarketShare/MarketMakerAgent.x10"
        ((x10.util.ArrayList<plham.Order>)orders).add__0x10$util$ArrayList$$T$O(((plham.Order)(t$24604)));
        
        //#line 57 "/home/dsl/workspace/plhamK/samples/MarketShare/MarketMakerAgent.x10"
        return orders;
    }
    
    
    //#line 61 "/home/dsl/workspace/plhamK/samples/MarketShare/MarketMakerAgent.x10"
    public double getBasePrice__0$1plham$Market$2$O(final x10.util.List markets) {
        
        //#line 62 "/home/dsl/workspace/plhamK/samples/MarketShare/MarketMakerAgent.x10"
        double maxBuy = java.lang.Double.NEGATIVE_INFINITY;
        
        //#line 63 "/home/dsl/workspace/plhamK/samples/MarketShare/MarketMakerAgent.x10"
        final x10.util.ListIterator market$24635 = ((x10.util.ListIterator<plham.Market>)
                                                     ((x10.util.List<plham.Market>)markets).iterator());
        
        //#line 63 "/home/dsl/workspace/plhamK/samples/MarketShare/MarketMakerAgent.x10"
        for (;
             true;
             ) {
            
            //#line 63 "/home/dsl/workspace/plhamK/samples/MarketShare/MarketMakerAgent.x10"
            final boolean t$24636 = ((x10.util.ListIterator<plham.Market>)market$24635).hasNext$O();
            
            //#line 63 "/home/dsl/workspace/plhamK/samples/MarketShare/MarketMakerAgent.x10"
            if (!(t$24636)) {
                
                //#line 63 "/home/dsl/workspace/plhamK/samples/MarketShare/MarketMakerAgent.x10"
                break;
            }
            
            //#line 63 "/home/dsl/workspace/plhamK/samples/MarketShare/MarketMakerAgent.x10"
            final plham.Market market$24625 = ((plham.Market)(((x10.util.ListIterator<plham.Market>)market$24635).next$G()));
            
            //#line 64 "/home/dsl/workspace/plhamK/samples/MarketShare/MarketMakerAgent.x10"
            final boolean t$24626 = this.isMarketAccessible$O(((plham.Market)(market$24625)));
            
            //#line 64 "/home/dsl/workspace/plhamK/samples/MarketShare/MarketMakerAgent.x10"
            if (t$24626) {
                
                //#line 65 "/home/dsl/workspace/plhamK/samples/MarketShare/MarketMakerAgent.x10"
                final double t$24627 = maxBuy;
                
                //#line 65 "/home/dsl/workspace/plhamK/samples/MarketShare/MarketMakerAgent.x10"
                final double t$24628 = market$24625.getBestBuyPrice$O();
                
                //#line 65 "/home/dsl/workspace/plhamK/samples/MarketShare/MarketMakerAgent.x10"
                final double t$24629 = java.lang.Math.max(((double)(t$24627)),((double)(t$24628)));
                
                //#line 65 "/home/dsl/workspace/plhamK/samples/MarketShare/MarketMakerAgent.x10"
                maxBuy = t$24629;
            }
        }
        
        //#line 68 "/home/dsl/workspace/plhamK/samples/MarketShare/MarketMakerAgent.x10"
        double minSell = java.lang.Double.POSITIVE_INFINITY;
        
        //#line 69 "/home/dsl/workspace/plhamK/samples/MarketShare/MarketMakerAgent.x10"
        final x10.util.ListIterator market$24637 = ((x10.util.ListIterator<plham.Market>)
                                                     ((x10.util.List<plham.Market>)markets).iterator());
        
        //#line 69 "/home/dsl/workspace/plhamK/samples/MarketShare/MarketMakerAgent.x10"
        for (;
             true;
             ) {
            
            //#line 69 "/home/dsl/workspace/plhamK/samples/MarketShare/MarketMakerAgent.x10"
            final boolean t$24638 = ((x10.util.ListIterator<plham.Market>)market$24637).hasNext$O();
            
            //#line 69 "/home/dsl/workspace/plhamK/samples/MarketShare/MarketMakerAgent.x10"
            if (!(t$24638)) {
                
                //#line 69 "/home/dsl/workspace/plhamK/samples/MarketShare/MarketMakerAgent.x10"
                break;
            }
            
            //#line 69 "/home/dsl/workspace/plhamK/samples/MarketShare/MarketMakerAgent.x10"
            final plham.Market market$24630 = ((plham.Market)(((x10.util.ListIterator<plham.Market>)market$24637).next$G()));
            
            //#line 70 "/home/dsl/workspace/plhamK/samples/MarketShare/MarketMakerAgent.x10"
            final boolean t$24631 = this.isMarketAccessible$O(((plham.Market)(market$24630)));
            
            //#line 70 "/home/dsl/workspace/plhamK/samples/MarketShare/MarketMakerAgent.x10"
            if (t$24631) {
                
                //#line 71 "/home/dsl/workspace/plhamK/samples/MarketShare/MarketMakerAgent.x10"
                final double t$24632 = minSell;
                
                //#line 71 "/home/dsl/workspace/plhamK/samples/MarketShare/MarketMakerAgent.x10"
                final double t$24633 = market$24630.getBestSellPrice$O();
                
                //#line 71 "/home/dsl/workspace/plhamK/samples/MarketShare/MarketMakerAgent.x10"
                final double t$24634 = java.lang.Math.min(((double)(t$24632)),((double)(t$24633)));
                
                //#line 71 "/home/dsl/workspace/plhamK/samples/MarketShare/MarketMakerAgent.x10"
                minSell = t$24634;
            }
        }
        
        //#line 74 "/home/dsl/workspace/plhamK/samples/MarketShare/MarketMakerAgent.x10"
        final double t$24617 = maxBuy;
        
        //#line 74 "/home/dsl/workspace/plhamK/samples/MarketShare/MarketMakerAgent.x10"
        final double t$24618 = minSell;
        
        //#line 74 "/home/dsl/workspace/plhamK/samples/MarketShare/MarketMakerAgent.x10"
        final double t$24619 = ((t$24617) + (((double)(t$24618))));
        
        //#line 74 "/home/dsl/workspace/plhamK/samples/MarketShare/MarketMakerAgent.x10"
        final double t$24620 = ((t$24619) / (((double)(2.0))));
        
        //#line 74 "/home/dsl/workspace/plhamK/samples/MarketShare/MarketMakerAgent.x10"
        return t$24620;
    }
    
    
    //#line 77 "/home/dsl/workspace/plhamK/samples/MarketShare/MarketMakerAgent.x10"
    public static boolean isFinite$O(final double x) {
        
        //#line 78 "/home/dsl/workspace/plhamK/samples/MarketShare/MarketMakerAgent.x10"
        final boolean t$24621 = java.lang.Double.isNaN(x);
        
        //#line 78 "/home/dsl/workspace/plhamK/samples/MarketShare/MarketMakerAgent.x10"
        boolean t$24623 = !(t$24621);
        
        //#line 78 "/home/dsl/workspace/plhamK/samples/MarketShare/MarketMakerAgent.x10"
        if (t$24623) {
            
            //#line 78 "/home/dsl/workspace/plhamK/samples/MarketShare/MarketMakerAgent.x10"
            final boolean t$24622 = java.lang.Double.isInfinite(x);
            
            //#line 78 "/home/dsl/workspace/plhamK/samples/MarketShare/MarketMakerAgent.x10"
            t$24623 = !(t$24622);
        }
        
        //#line 78 "/home/dsl/workspace/plhamK/samples/MarketShare/MarketMakerAgent.x10"
        final boolean t$24624 = t$24623;
        
        //#line 78 "/home/dsl/workspace/plhamK/samples/MarketShare/MarketMakerAgent.x10"
        return t$24624;
    }
    
    
    //#line 12 "/home/dsl/workspace/plhamK/samples/MarketShare/MarketMakerAgent.x10"
    final public samples.MarketShare.MarketMakerAgent samples$MarketShare$MarketMakerAgent$$this$samples$MarketShare$MarketMakerAgent() {
        
        //#line 12 "/home/dsl/workspace/plhamK/samples/MarketShare/MarketMakerAgent.x10"
        return samples.MarketShare.MarketMakerAgent.this;
    }
    
    
    //#line 12 "/home/dsl/workspace/plhamK/samples/MarketShare/MarketMakerAgent.x10"
    final public void __fieldInitializers_samples_MarketShare_MarketMakerAgent() {
        
        //#line 12 "/home/dsl/workspace/plhamK/samples/MarketShare/MarketMakerAgent.x10"
        this.targetMarketId = 0L;
        
        //#line 12 "/home/dsl/workspace/plhamK/samples/MarketShare/MarketMakerAgent.x10"
        this.netInterestSpread = 0.0;
        
        //#line 12 "/home/dsl/workspace/plhamK/samples/MarketShare/MarketMakerAgent.x10"
        this.orderTimeLength = 0L;
    }
    
    @x10.runtime.impl.java.X10Generated
    final public static class $Closure$14 extends x10.core.Ref implements x10.core.fun.Fun_0_4, x10.serialization.X10JavaSerializable
    {
        public static final x10.rtt.RuntimeType<$Closure$14> $RTT = 
            x10.rtt.StaticFunType.<$Closure$14> make($Closure$14.class,
                                                     new x10.rtt.Type[] {
                                                         x10.rtt.ParameterizedType.make(x10.core.fun.Fun_0_4.$RTT, x10.rtt.Types.LONG, x10.rtt.Types.STRING, x10.util.Random.$RTT, cassia.util.JSON.Value.$RTT, samples.MarketShare.MarketMakerAgent.$RTT)
                                                     });
        
        public x10.rtt.RuntimeType<?> $getRTT() { return $RTT; }
        
        public x10.rtt.Type<?> $getParam(int i) { return null; }
        
        private Object writeReplace() throws java.io.ObjectStreamException {
            return new x10.serialization.SerializationProxy(this);
        }
        
        public static x10.serialization.X10JavaSerializable $_deserialize_body(samples.MarketShare.MarketMakerAgent.$Closure$14 $_obj, x10.serialization.X10JavaDeserializer $deserializer) throws java.io.IOException {
            if (x10.runtime.impl.java.Runtime.TRACE_SER) { x10.runtime.impl.java.Runtime.printTraceMessage("X10JavaSerializable: $_deserialize_body() of " + $Closure$14.class + " calling"); } 
            $_obj.sim = $deserializer.readObject();
            return $_obj;
        }
        
        public static x10.serialization.X10JavaSerializable $_deserializer(x10.serialization.X10JavaDeserializer $deserializer) throws java.io.IOException {
            samples.MarketShare.MarketMakerAgent.$Closure$14 $_obj = new samples.MarketShare.MarketMakerAgent.$Closure$14((java.lang.System[]) null);
            $deserializer.record_reference($_obj);
            return $_deserialize_body($_obj, $deserializer);
        }
        
        public void $_serialize(x10.serialization.X10JavaSerializer $serializer) throws java.io.IOException {
            $serializer.write(this.sim);
            
        }
        
        // constructor just for allocation
        public $Closure$14(final java.lang.System[] $dummy) {
            
        }
        
        // dispatcher for method abstract public (Z1,Z2,Z3,Z4)=>U.operator()(a1:Z1, a2:Z2, a3:Z3, a4:Z4):U
        public java.lang.Object $apply(final java.lang.Object a1, final x10.rtt.Type t1, final java.lang.Object a2, final x10.rtt.Type t2, final java.lang.Object a3, final x10.rtt.Type t3, final java.lang.Object a4, final x10.rtt.Type t4) {
            return $apply(x10.core.Long.$unbox(a1), (java.lang.String)a2, (x10.util.Random)a3, (cassia.util.JSON.Value)a4);
            
        }
        
        
    
        
        public samples.MarketShare.MarketMakerAgent $apply(final long id, final java.lang.String name, final x10.util.Random random, final cassia.util.JSON.Value json) {
            
            //#line 37 "/home/dsl/workspace/plhamK/samples/MarketShare/MarketMakerAgent.x10"
            final samples.MarketShare.MarketMakerAgent t$24584 = ((samples.MarketShare.MarketMakerAgent)(new samples.MarketShare.MarketMakerAgent((java.lang.System[]) null).samples$MarketShare$MarketMakerAgent$$init$S(((long)(id)), ((java.lang.String)(name)), ((x10.util.Random)(random)))));
            
            //#line 37 "/home/dsl/workspace/plhamK/samples/MarketShare/MarketMakerAgent.x10"
            final samples.MarketShare.MarketMakerAgent t$24585 = t$24584.setup(((cassia.util.JSON.Value)(json)), ((plham.main.Simulator)(this.sim)));
            
            //#line 37 "/home/dsl/workspace/plhamK/samples/MarketShare/MarketMakerAgent.x10"
            return t$24585;
        }
        
        public plham.main.Simulator sim;
        
        public $Closure$14(final plham.main.Simulator sim) {
             {
                this.sim = ((plham.main.Simulator)(sim));
            }
        }
        
    }
    
    
    public plham.Agent plham$Agent$setup$S(final cassia.util.JSON.Value a0, final plham.main.Simulator a1) {
        return super.setup(((cassia.util.JSON.Value)(a0)), ((plham.main.Simulator)(a1)));
    }
}

