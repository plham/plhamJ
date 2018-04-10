package samples.MarketShare;


@x10.runtime.impl.java.X10Generated
public class MarketShareFCNAgent extends plham.agent.FCNAgent implements x10.serialization.X10JavaSerializable
{
    public static final x10.rtt.RuntimeType<MarketShareFCNAgent> $RTT = 
        x10.rtt.NamedType.<MarketShareFCNAgent> make("samples.MarketShare.MarketShareFCNAgent",
                                                     MarketShareFCNAgent.class,
                                                     new x10.rtt.Type[] {
                                                         plham.agent.FCNAgent.$RTT
                                                     });
    
    public x10.rtt.RuntimeType<?> $getRTT() { return $RTT; }
    
    public x10.rtt.Type<?> $getParam(int i) { return null; }
    
    private Object writeReplace() throws java.io.ObjectStreamException {
        return new x10.serialization.SerializationProxy(this);
    }
    
    public static x10.serialization.X10JavaSerializable $_deserialize_body(samples.MarketShare.MarketShareFCNAgent $_obj, x10.serialization.X10JavaDeserializer $deserializer) throws java.io.IOException {
        if (x10.runtime.impl.java.Runtime.TRACE_SER) { x10.runtime.impl.java.Runtime.printTraceMessage("X10JavaSerializable: $_deserialize_body() of " + MarketShareFCNAgent.class + " calling"); } 
        plham.agent.FCNAgent.$_deserialize_body($_obj, $deserializer);
        return $_obj;
    }
    
    public static x10.serialization.X10JavaSerializable $_deserializer(x10.serialization.X10JavaDeserializer $deserializer) throws java.io.IOException {
        samples.MarketShare.MarketShareFCNAgent $_obj = new samples.MarketShare.MarketShareFCNAgent((java.lang.System[]) null);
        $deserializer.record_reference($_obj);
        return $_deserialize_body($_obj, $deserializer);
    }
    
    public void $_serialize(x10.serialization.X10JavaSerializer $serializer) throws java.io.IOException {
        super.$_serialize($serializer);
        
    }
    
    // constructor just for allocation
    public MarketShareFCNAgent(final java.lang.System[] $dummy) {
        super($dummy);
        
    }
    
    

    
    
    //#line 15 "/home/dsl/workspace/plhamK/samples/MarketShare/MarketShareFCNAgent.x10"
    // creation method for java code (1-phase java constructor)
    public MarketShareFCNAgent(final long id, final java.lang.String name, final x10.util.Random random) {
        this((java.lang.System[]) null);
        samples$MarketShare$MarketShareFCNAgent$$init$S(id, name, random);
    }
    
    // constructor for non-virtual call
    final public samples.MarketShare.MarketShareFCNAgent samples$MarketShare$MarketShareFCNAgent$$init$S(final long id, final java.lang.String name, final x10.util.Random random) {
         {
            
            //#line 15 "/home/dsl/workspace/plhamK/samples/MarketShare/MarketShareFCNAgent.x10"
            /*super.*/plham$agent$FCNAgent$$init$S(((long)(id)), ((java.lang.String)(name)), ((x10.util.Random)(random)));
            
            //#line 15 "/home/dsl/workspace/plhamK/samples/MarketShare/MarketShareFCNAgent.x10"
            
            
            //#line 13 "/home/dsl/workspace/plhamK/samples/MarketShare/MarketShareFCNAgent.x10"
            this.__fieldInitializers_samples_MarketShare_MarketShareFCNAgent();
        }
        return this;
    }
    
    
    
    //#line 16 "/home/dsl/workspace/plhamK/samples/MarketShare/MarketShareFCNAgent.x10"
    public samples.MarketShare.MarketShareFCNAgent setup(final cassia.util.JSON.Value json, final plham.main.Simulator sim) {
        
        //#line 16 "/home/dsl/workspace/plhamK/samples/MarketShare/MarketShareFCNAgent.x10"
        final plham.agent.FCNAgent t$24677 = super.setup(((cassia.util.JSON.Value)(json)), ((plham.main.Simulator)(sim)));
        
        //#line 16 "/home/dsl/workspace/plhamK/samples/MarketShare/MarketShareFCNAgent.x10"
        final samples.MarketShare.MarketShareFCNAgent t$24678 = x10.rtt.Types.<samples.MarketShare.MarketShareFCNAgent> cast(t$24677,samples.MarketShare.MarketShareFCNAgent.$RTT);
        
        //#line 16 "/home/dsl/workspace/plhamK/samples/MarketShare/MarketShareFCNAgent.x10"
        return t$24678;
    }
    
    
    //#line 17 "/home/dsl/workspace/plhamK/samples/MarketShare/MarketShareFCNAgent.x10"
    public static void register(final plham.main.Simulator sim) {
        
        //#line 18 "/home/dsl/workspace/plhamK/samples/MarketShare/MarketShareFCNAgent.x10"
        final java.lang.String className = ((java.lang.String)("MarketShareFCNAgent"));
        
        //#line 20 "/home/dsl/workspace/plhamK/samples/MarketShare/MarketShareFCNAgent.x10"
        final x10.core.fun.Fun_0_4 t$24681 = ((x10.core.fun.Fun_0_4)(new samples.MarketShare.MarketShareFCNAgent.$Closure$15(sim)));
        
        //#line 19 "/home/dsl/workspace/plhamK/samples/MarketShare/MarketShareFCNAgent.x10"
        sim.addAgentInitializer__1$1x10$lang$Long$3x10$lang$String$3x10$util$Random$3cassia$util$JSON$Value$3plham$Agent$2(((java.lang.String)(className)), ((x10.core.fun.Fun_0_4)(t$24681)));
    }
    
    
    //#line 31 "/home/dsl/workspace/plhamK/samples/MarketShare/MarketShareFCNAgent.x10"
    public x10.util.List submitOrders__0$1plham$Market$2(x10.util.List markets) {
        
        //#line 32 "/home/dsl/workspace/plhamK/samples/MarketShare/MarketShareFCNAgent.x10"
        final x10.util.List t$24682 = ((x10.util.List)(markets));
        
        //#line 32 "/home/dsl/workspace/plhamK/samples/MarketShare/MarketShareFCNAgent.x10"
        final x10.util.List t$24683 = this.filterMarkets__0$1plham$Market$2(((x10.util.List)(t$24682)));
        
        //#line 32 "/home/dsl/workspace/plhamK/samples/MarketShare/MarketShareFCNAgent.x10"
        markets = ((x10.util.List)(t$24683));
        
        //#line 33 "/home/dsl/workspace/plhamK/samples/MarketShare/MarketShareFCNAgent.x10"
        final x10.util.ArrayList weights = ((x10.util.ArrayList)(new x10.util.ArrayList<x10.core.Double>((java.lang.System[]) null, x10.rtt.Types.DOUBLE).x10$util$ArrayList$$init$S()));
        
        //#line 34 "/home/dsl/workspace/plhamK/samples/MarketShare/MarketShareFCNAgent.x10"
        final x10.util.List t$24710 = ((x10.util.List)(markets));
        
        //#line 34 "/home/dsl/workspace/plhamK/samples/MarketShare/MarketShareFCNAgent.x10"
        final x10.util.ListIterator m$24711 = ((x10.util.ListIterator<plham.Market>)
                                                ((x10.util.List<plham.Market>)t$24710).iterator());
        
        //#line 34 "/home/dsl/workspace/plhamK/samples/MarketShare/MarketShareFCNAgent.x10"
        for (;
             true;
             ) {
            
            //#line 34 "/home/dsl/workspace/plhamK/samples/MarketShare/MarketShareFCNAgent.x10"
            final boolean t$24712 = ((x10.util.ListIterator<plham.Market>)m$24711).hasNext$O();
            
            //#line 34 "/home/dsl/workspace/plhamK/samples/MarketShare/MarketShareFCNAgent.x10"
            if (!(t$24712)) {
                
                //#line 34 "/home/dsl/workspace/plhamK/samples/MarketShare/MarketShareFCNAgent.x10"
                break;
            }
            
            //#line 34 "/home/dsl/workspace/plhamK/samples/MarketShare/MarketShareFCNAgent.x10"
            final plham.Market m$24707 = ((plham.Market)(((x10.util.ListIterator<plham.Market>)m$24711).next$G()));
            
            //#line 35 "/home/dsl/workspace/plhamK/samples/MarketShare/MarketShareFCNAgent.x10"
            final long t$24708 = this.getSumTradeVolume$O(((plham.Market)(m$24707)));
            
            //#line 35 "/home/dsl/workspace/plhamK/samples/MarketShare/MarketShareFCNAgent.x10"
            final double t$24709 = ((double)(long)(((long)(t$24708))));
            
            //#line 35 "/home/dsl/workspace/plhamK/samples/MarketShare/MarketShareFCNAgent.x10"
            ((x10.util.ArrayList<x10.core.Double>)weights).add__0x10$util$ArrayList$$T$O(x10.core.Double.$box(t$24709));
        }
        
        //#line 37 "/home/dsl/workspace/plhamK/samples/MarketShare/MarketShareFCNAgent.x10"
        final x10.util.Random t$24689 = this.getRandom();
        
        //#line 37 "/home/dsl/workspace/plhamK/samples/MarketShare/MarketShareFCNAgent.x10"
        final long k = plham.util.Statistics.roulette__1$1x10$lang$Double$2$O(((x10.util.Random)(t$24689)), ((x10.util.List)(weights)));
        
        //#line 38 "/home/dsl/workspace/plhamK/samples/MarketShare/MarketShareFCNAgent.x10"
        final x10.util.List t$24690 = ((x10.util.List)(markets));
        
        //#line 38 "/home/dsl/workspace/plhamK/samples/MarketShare/MarketShareFCNAgent.x10"
        final plham.Market t$24691 = ((x10.util.Indexed<plham.Market>)t$24690).$apply$G((long)(k));
        
        //#line 38 "/home/dsl/workspace/plhamK/samples/MarketShare/MarketShareFCNAgent.x10"
        final x10.util.List t$24692 = super.submitOrders(((plham.Market)(t$24691)));
        
        //#line 38 "/home/dsl/workspace/plhamK/samples/MarketShare/MarketShareFCNAgent.x10"
        return t$24692;
    }
    
    
    //#line 41 "/home/dsl/workspace/plhamK/samples/MarketShare/MarketShareFCNAgent.x10"
    public long getSumTradeVolume$O(final plham.Market market) {
        
        //#line 42 "/home/dsl/workspace/plhamK/samples/MarketShare/MarketShareFCNAgent.x10"
        final long t = market.getTime$O();
        
        //#line 43 "/home/dsl/workspace/plhamK/samples/MarketShare/MarketShareFCNAgent.x10"
        final long t$24693 = this.timeWindowSize;
        
        //#line 43 "/home/dsl/workspace/plhamK/samples/MarketShare/MarketShareFCNAgent.x10"
        final long timeWindowSize = java.lang.Math.min(((long)(t)),((long)(t$24693)));
        
        //#line 44 "/home/dsl/workspace/plhamK/samples/MarketShare/MarketShareFCNAgent.x10"
        long volume = 0L;
        
        //#line 45 "/home/dsl/workspace/plhamK/samples/MarketShare/MarketShareFCNAgent.x10"
        final long i$24658min$24723 = 1L;
        
        //#line 45 "/home/dsl/workspace/plhamK/samples/MarketShare/MarketShareFCNAgent.x10"
        final long i$24658max$24724 = timeWindowSize;
        
        //#line 45 "/home/dsl/workspace/plhamK/samples/MarketShare/MarketShareFCNAgent.x10"
        long i$24720 = i$24658min$24723;
        
        //#line 45 "/home/dsl/workspace/plhamK/samples/MarketShare/MarketShareFCNAgent.x10"
        for (;
             true;
             ) {
            
            //#line 45 "/home/dsl/workspace/plhamK/samples/MarketShare/MarketShareFCNAgent.x10"
            final long t$24721 = i$24720;
            
            //#line 45 "/home/dsl/workspace/plhamK/samples/MarketShare/MarketShareFCNAgent.x10"
            final boolean t$24722 = ((t$24721) <= (((long)(i$24658max$24724))));
            
            //#line 45 "/home/dsl/workspace/plhamK/samples/MarketShare/MarketShareFCNAgent.x10"
            if (!(t$24722)) {
                
                //#line 45 "/home/dsl/workspace/plhamK/samples/MarketShare/MarketShareFCNAgent.x10"
                break;
            }
            
            //#line 45 "/home/dsl/workspace/plhamK/samples/MarketShare/MarketShareFCNAgent.x10"
            final long d$24717 = i$24720;
            
            //#line 46 "/home/dsl/workspace/plhamK/samples/MarketShare/MarketShareFCNAgent.x10"
            final long t$24713 = volume;
            
            //#line 46 "/home/dsl/workspace/plhamK/samples/MarketShare/MarketShareFCNAgent.x10"
            final long t$24714 = ((t) - (((long)(d$24717))));
            
            //#line 46 "/home/dsl/workspace/plhamK/samples/MarketShare/MarketShareFCNAgent.x10"
            final long t$24715 = market.getTradeVolume$O((long)(t$24714));
            
            //#line 46 "/home/dsl/workspace/plhamK/samples/MarketShare/MarketShareFCNAgent.x10"
            final long t$24716 = ((t$24713) + (((long)(t$24715))));
            
            //#line 46 "/home/dsl/workspace/plhamK/samples/MarketShare/MarketShareFCNAgent.x10"
            volume = t$24716;
            
            //#line 45 "/home/dsl/workspace/plhamK/samples/MarketShare/MarketShareFCNAgent.x10"
            final long t$24718 = i$24720;
            
            //#line 45 "/home/dsl/workspace/plhamK/samples/MarketShare/MarketShareFCNAgent.x10"
            final long t$24719 = ((t$24718) + (((long)(1L))));
            
            //#line 45 "/home/dsl/workspace/plhamK/samples/MarketShare/MarketShareFCNAgent.x10"
            i$24720 = t$24719;
        }
        
        //#line 48 "/home/dsl/workspace/plhamK/samples/MarketShare/MarketShareFCNAgent.x10"
        final long t$24703 = volume;
        
        //#line 48 "/home/dsl/workspace/plhamK/samples/MarketShare/MarketShareFCNAgent.x10"
        return t$24703;
    }
    
    
    //#line 51 "/home/dsl/workspace/plhamK/samples/MarketShare/MarketShareFCNAgent.x10"
    public x10.util.List filterMarkets__0$1plham$Market$2(final x10.util.List markets) {
        
        //#line 52 "/home/dsl/workspace/plhamK/samples/MarketShare/MarketShareFCNAgent.x10"
        final x10.util.ArrayList a = ((x10.util.ArrayList)(new x10.util.ArrayList<plham.Market>((java.lang.System[]) null, plham.Market.$RTT).x10$util$ArrayList$$init$S()));
        
        //#line 53 "/home/dsl/workspace/plhamK/samples/MarketShare/MarketShareFCNAgent.x10"
        final x10.util.ListIterator market$24727 = ((x10.util.ListIterator<plham.Market>)
                                                     ((x10.util.List<plham.Market>)markets).iterator());
        
        //#line 53 "/home/dsl/workspace/plhamK/samples/MarketShare/MarketShareFCNAgent.x10"
        for (;
             true;
             ) {
            
            //#line 53 "/home/dsl/workspace/plhamK/samples/MarketShare/MarketShareFCNAgent.x10"
            final boolean t$24728 = ((x10.util.ListIterator<plham.Market>)market$24727).hasNext$O();
            
            //#line 53 "/home/dsl/workspace/plhamK/samples/MarketShare/MarketShareFCNAgent.x10"
            if (!(t$24728)) {
                
                //#line 53 "/home/dsl/workspace/plhamK/samples/MarketShare/MarketShareFCNAgent.x10"
                break;
            }
            
            //#line 53 "/home/dsl/workspace/plhamK/samples/MarketShare/MarketShareFCNAgent.x10"
            final plham.Market market$24725 = ((plham.Market)(((x10.util.ListIterator<plham.Market>)market$24727).next$G()));
            
            //#line 54 "/home/dsl/workspace/plhamK/samples/MarketShare/MarketShareFCNAgent.x10"
            final boolean t$24726 = this.isMarketAccessible$O(((plham.Market)(market$24725)));
            
            //#line 54 "/home/dsl/workspace/plhamK/samples/MarketShare/MarketShareFCNAgent.x10"
            if (t$24726) {
                
                //#line 55 "/home/dsl/workspace/plhamK/samples/MarketShare/MarketShareFCNAgent.x10"
                ((x10.util.ArrayList<plham.Market>)a).add__0x10$util$ArrayList$$T$O(((plham.Market)(market$24725)));
            }
        }
        
        //#line 58 "/home/dsl/workspace/plhamK/samples/MarketShare/MarketShareFCNAgent.x10"
        return a;
    }
    
    
    //#line 13 "/home/dsl/workspace/plhamK/samples/MarketShare/MarketShareFCNAgent.x10"
    final public samples.MarketShare.MarketShareFCNAgent samples$MarketShare$MarketShareFCNAgent$$this$samples$MarketShare$MarketShareFCNAgent() {
        
        //#line 13 "/home/dsl/workspace/plhamK/samples/MarketShare/MarketShareFCNAgent.x10"
        return samples.MarketShare.MarketShareFCNAgent.this;
    }
    
    
    //#line 13 "/home/dsl/workspace/plhamK/samples/MarketShare/MarketShareFCNAgent.x10"
    final public void __fieldInitializers_samples_MarketShare_MarketShareFCNAgent() {
        
    }
    
    @x10.runtime.impl.java.X10Generated
    final public static class $Closure$15 extends x10.core.Ref implements x10.core.fun.Fun_0_4, x10.serialization.X10JavaSerializable
    {
        public static final x10.rtt.RuntimeType<$Closure$15> $RTT = 
            x10.rtt.StaticFunType.<$Closure$15> make($Closure$15.class,
                                                     new x10.rtt.Type[] {
                                                         x10.rtt.ParameterizedType.make(x10.core.fun.Fun_0_4.$RTT, x10.rtt.Types.LONG, x10.rtt.Types.STRING, x10.util.Random.$RTT, cassia.util.JSON.Value.$RTT, samples.MarketShare.MarketShareFCNAgent.$RTT)
                                                     });
        
        public x10.rtt.RuntimeType<?> $getRTT() { return $RTT; }
        
        public x10.rtt.Type<?> $getParam(int i) { return null; }
        
        private Object writeReplace() throws java.io.ObjectStreamException {
            return new x10.serialization.SerializationProxy(this);
        }
        
        public static x10.serialization.X10JavaSerializable $_deserialize_body(samples.MarketShare.MarketShareFCNAgent.$Closure$15 $_obj, x10.serialization.X10JavaDeserializer $deserializer) throws java.io.IOException {
            if (x10.runtime.impl.java.Runtime.TRACE_SER) { x10.runtime.impl.java.Runtime.printTraceMessage("X10JavaSerializable: $_deserialize_body() of " + $Closure$15.class + " calling"); } 
            $_obj.sim = $deserializer.readObject();
            return $_obj;
        }
        
        public static x10.serialization.X10JavaSerializable $_deserializer(x10.serialization.X10JavaDeserializer $deserializer) throws java.io.IOException {
            samples.MarketShare.MarketShareFCNAgent.$Closure$15 $_obj = new samples.MarketShare.MarketShareFCNAgent.$Closure$15((java.lang.System[]) null);
            $deserializer.record_reference($_obj);
            return $_deserialize_body($_obj, $deserializer);
        }
        
        public void $_serialize(x10.serialization.X10JavaSerializer $serializer) throws java.io.IOException {
            $serializer.write(this.sim);
            
        }
        
        // constructor just for allocation
        public $Closure$15(final java.lang.System[] $dummy) {
            
        }
        
        // dispatcher for method abstract public (Z1,Z2,Z3,Z4)=>U.operator()(a1:Z1, a2:Z2, a3:Z3, a4:Z4):U
        public java.lang.Object $apply(final java.lang.Object a1, final x10.rtt.Type t1, final java.lang.Object a2, final x10.rtt.Type t2, final java.lang.Object a3, final x10.rtt.Type t3, final java.lang.Object a4, final x10.rtt.Type t4) {
            return $apply(x10.core.Long.$unbox(a1), (java.lang.String)a2, (x10.util.Random)a3, (cassia.util.JSON.Value)a4);
            
        }
        
        
    
        
        public samples.MarketShare.MarketShareFCNAgent $apply(final long id, final java.lang.String name, final x10.util.Random random, final cassia.util.JSON.Value json) {
            
            //#line 26 "/home/dsl/workspace/plhamK/samples/MarketShare/MarketShareFCNAgent.x10"
            final samples.MarketShare.MarketShareFCNAgent t$24679 = ((samples.MarketShare.MarketShareFCNAgent)(new samples.MarketShare.MarketShareFCNAgent((java.lang.System[]) null).samples$MarketShare$MarketShareFCNAgent$$init$S(((long)(id)), ((java.lang.String)(name)), ((x10.util.Random)(random)))));
            
            //#line 26 "/home/dsl/workspace/plhamK/samples/MarketShare/MarketShareFCNAgent.x10"
            final samples.MarketShare.MarketShareFCNAgent t$24680 = t$24679.setup(((cassia.util.JSON.Value)(json)), ((plham.main.Simulator)(this.sim)));
            
            //#line 26 "/home/dsl/workspace/plhamK/samples/MarketShare/MarketShareFCNAgent.x10"
            return t$24680;
        }
        
        public plham.main.Simulator sim;
        
        public $Closure$15(final plham.main.Simulator sim) {
             {
                this.sim = ((plham.main.Simulator)(sim));
            }
        }
        
    }
    
    
    public plham.agent.FCNAgent plham$agent$FCNAgent$setup$S(final cassia.util.JSON.Value a0, final plham.main.Simulator a1) {
        return super.setup(((cassia.util.JSON.Value)(a0)), ((plham.main.Simulator)(a1)));
    }
    
    public x10.util.List plham$agent$FCNAgent$submitOrders$S(final plham.Market a0) {
        return super.submitOrders(((plham.Market)(a0)));
    }
}

