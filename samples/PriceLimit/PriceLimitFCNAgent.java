package samples.PriceLimit;


@x10.runtime.impl.java.X10Generated
public class PriceLimitFCNAgent extends plham.agent.FCNAgent implements x10.serialization.X10JavaSerializable
{
    public static final x10.rtt.RuntimeType<PriceLimitFCNAgent> $RTT = 
        x10.rtt.NamedType.<PriceLimitFCNAgent> make("samples.PriceLimit.PriceLimitFCNAgent",
                                                    PriceLimitFCNAgent.class,
                                                    new x10.rtt.Type[] {
                                                        plham.agent.FCNAgent.$RTT
                                                    });
    
    public x10.rtt.RuntimeType<?> $getRTT() { return $RTT; }
    
    public x10.rtt.Type<?> $getParam(int i) { return null; }
    
    private Object writeReplace() throws java.io.ObjectStreamException {
        return new x10.serialization.SerializationProxy(this);
    }
    
    public static x10.serialization.X10JavaSerializable $_deserialize_body(samples.PriceLimit.PriceLimitFCNAgent $_obj, x10.serialization.X10JavaDeserializer $deserializer) throws java.io.IOException {
        if (x10.runtime.impl.java.Runtime.TRACE_SER) { x10.runtime.impl.java.Runtime.printTraceMessage("X10JavaSerializable: $_deserialize_body() of " + PriceLimitFCNAgent.class + " calling"); } 
        plham.agent.FCNAgent.$_deserialize_body($_obj, $deserializer);
        $_obj.priceLimit = $deserializer.readObject();
        return $_obj;
    }
    
    public static x10.serialization.X10JavaSerializable $_deserializer(x10.serialization.X10JavaDeserializer $deserializer) throws java.io.IOException {
        samples.PriceLimit.PriceLimitFCNAgent $_obj = new samples.PriceLimit.PriceLimitFCNAgent((java.lang.System[]) null);
        $deserializer.record_reference($_obj);
        return $_deserialize_body($_obj, $deserializer);
    }
    
    public void $_serialize(x10.serialization.X10JavaSerializer $serializer) throws java.io.IOException {
        super.$_serialize($serializer);
        $serializer.write(this.priceLimit);
        
    }
    
    // constructor just for allocation
    public PriceLimitFCNAgent(final java.lang.System[] $dummy) {
        super($dummy);
        
    }
    
    

    
    //#line 17 "/home/dsl/workspace/plhamK/samples/PriceLimit/PriceLimitFCNAgent.x10"
    public plham.event.PriceLimitRule priceLimit;
    
    
    //#line 19 "/home/dsl/workspace/plhamK/samples/PriceLimit/PriceLimitFCNAgent.x10"
    public x10.util.List submitOrders(final plham.Market market) {
        
        //#line 20 "/home/dsl/workspace/plhamK/samples/PriceLimit/PriceLimitFCNAgent.x10"
        final x10.util.List orders = super.submitOrders(((plham.Market)(market)));
        
        //#line 21 "/home/dsl/workspace/plhamK/samples/PriceLimit/PriceLimitFCNAgent.x10"
        final long t$23905 = ((x10.util.Container<plham.Order>)orders).size$O();
        
        //#line 21 "/home/dsl/workspace/plhamK/samples/PriceLimit/PriceLimitFCNAgent.x10"
        final boolean t$23906 = ((long) t$23905) == ((long) 0L);
        
        //#line 21 "/home/dsl/workspace/plhamK/samples/PriceLimit/PriceLimitFCNAgent.x10"
        if (t$23906) {
            
            //#line 22 "/home/dsl/workspace/plhamK/samples/PriceLimit/PriceLimitFCNAgent.x10"
            return orders;
        }
        
        //#line 25 "/home/dsl/workspace/plhamK/samples/PriceLimit/PriceLimitFCNAgent.x10"
        final x10.util.ListIterator order$23926 = ((x10.util.ListIterator<plham.Order>)
                                                    ((x10.util.List<plham.Order>)orders).iterator());
        
        //#line 25 "/home/dsl/workspace/plhamK/samples/PriceLimit/PriceLimitFCNAgent.x10"
        for (;
             true;
             ) {
            
            //#line 25 "/home/dsl/workspace/plhamK/samples/PriceLimit/PriceLimitFCNAgent.x10"
            final boolean t$23927 = ((x10.util.ListIterator<plham.Order>)order$23926).hasNext$O();
            
            //#line 25 "/home/dsl/workspace/plhamK/samples/PriceLimit/PriceLimitFCNAgent.x10"
            if (!(t$23927)) {
                
                //#line 25 "/home/dsl/workspace/plhamK/samples/PriceLimit/PriceLimitFCNAgent.x10"
                break;
            }
            
            //#line 25 "/home/dsl/workspace/plhamK/samples/PriceLimit/PriceLimitFCNAgent.x10"
            final plham.Order order$23921 = ((plham.Order)(((x10.util.ListIterator<plham.Order>)order$23926).next$G()));
            
            //#line 26 "/home/dsl/workspace/plhamK/samples/PriceLimit/PriceLimitFCNAgent.x10"
            final double oldPrice$23922 = order$23921.getPrice$O();
            
            //#line 27 "/home/dsl/workspace/plhamK/samples/PriceLimit/PriceLimitFCNAgent.x10"
            final plham.event.PriceLimitRule t$23923 = ((plham.event.PriceLimitRule)(this.priceLimit));
            
            //#line 27 "/home/dsl/workspace/plhamK/samples/PriceLimit/PriceLimitFCNAgent.x10"
            final double newPrice$23924 = t$23923.getLimitedPrice$O(((plham.Order)(order$23921)), ((plham.Market)(market)));
            
            //#line 28 "/home/dsl/workspace/plhamK/samples/PriceLimit/PriceLimitFCNAgent.x10"
            final boolean t$23925 = ((double) newPrice$23924) != ((double) oldPrice$23922);
            
            //#line 28 "/home/dsl/workspace/plhamK/samples/PriceLimit/PriceLimitFCNAgent.x10"
            if (t$23925) {
                
                //#line 29 "/home/dsl/workspace/plhamK/samples/PriceLimit/PriceLimitFCNAgent.x10"
                order$23921.setPrice$O((double)(newPrice$23924));
            }
        }
        
        //#line 33 "/home/dsl/workspace/plhamK/samples/PriceLimit/PriceLimitFCNAgent.x10"
        return orders;
    }
    
    
    //#line 35 "/home/dsl/workspace/plhamK/samples/PriceLimit/PriceLimitFCNAgent.x10"
    public static void register(final plham.main.Simulator sim) {
        
        //#line 36 "/home/dsl/workspace/plhamK/samples/PriceLimit/PriceLimitFCNAgent.x10"
        final java.lang.String className = ((java.lang.String)("PriceLimitFCNAgent"));
        
        //#line 38 "/home/dsl/workspace/plhamK/samples/PriceLimit/PriceLimitFCNAgent.x10"
        final x10.core.fun.Fun_0_4 t$23913 = ((x10.core.fun.Fun_0_4)(new samples.PriceLimit.PriceLimitFCNAgent.$Closure$15(sim)));
        
        //#line 37 "/home/dsl/workspace/plhamK/samples/PriceLimit/PriceLimitFCNAgent.x10"
        sim.addAgentInitializer__1$1x10$lang$Long$3x10$lang$String$3x10$util$Random$3cassia$util$JSON$Value$3plham$Agent$2(((java.lang.String)(className)), ((x10.core.fun.Fun_0_4)(t$23913)));
    }
    
    
    //#line 48 "/home/dsl/workspace/plhamK/samples/PriceLimit/PriceLimitFCNAgent.x10"
    // creation method for java code (1-phase java constructor)
    public PriceLimitFCNAgent(final long id, final java.lang.String name, final x10.util.Random random) {
        this((java.lang.System[]) null);
        samples$PriceLimit$PriceLimitFCNAgent$$init$S(id, name, random);
    }
    
    // constructor for non-virtual call
    final public samples.PriceLimit.PriceLimitFCNAgent samples$PriceLimit$PriceLimitFCNAgent$$init$S(final long id, final java.lang.String name, final x10.util.Random random) {
         {
            
            //#line 48 "/home/dsl/workspace/plhamK/samples/PriceLimit/PriceLimitFCNAgent.x10"
            /*super.*/plham$agent$FCNAgent$$init$S(((long)(id)), ((java.lang.String)(name)), ((x10.util.Random)(random)));
            
            //#line 48 "/home/dsl/workspace/plhamK/samples/PriceLimit/PriceLimitFCNAgent.x10"
            
            
            //#line 15 "/home/dsl/workspace/plhamK/samples/PriceLimit/PriceLimitFCNAgent.x10"
            this.__fieldInitializers_samples_PriceLimit_PriceLimitFCNAgent();
        }
        return this;
    }
    
    
    
    //#line 49 "/home/dsl/workspace/plhamK/samples/PriceLimit/PriceLimitFCNAgent.x10"
    public samples.PriceLimit.PriceLimitFCNAgent setup(final cassia.util.JSON.Value json, final plham.main.Simulator sim) {
        
        //#line 50 "/home/dsl/workspace/plhamK/samples/PriceLimit/PriceLimitFCNAgent.x10"
        super.setup(((cassia.util.JSON.Value)(json)), ((plham.main.Simulator)(sim)));
        
        //#line 51 "/home/dsl/workspace/plhamK/samples/PriceLimit/PriceLimitFCNAgent.x10"
        final samples.PriceLimit.PriceLimitMain t$23916 = ((samples.PriceLimit.PriceLimitMain)(new samples.PriceLimit.PriceLimitMain((java.lang.System[]) null).samples$PriceLimit$PriceLimitMain$$init$S()));
        
        //#line 51 "/home/dsl/workspace/plhamK/samples/PriceLimit/PriceLimitFCNAgent.x10"
        final cassia.util.JSON.Value t$23914 = ((cassia.util.JSON.Value)(sim.CONFIG));
        
        //#line 51 "/home/dsl/workspace/plhamK/samples/PriceLimit/PriceLimitFCNAgent.x10"
        final cassia.util.JSON.Value t$23915 = ((cassia.util.JSON.Value)json).<java.lang.String> $apply__0cassia$util$JSON$Value$$T(x10.rtt.Types.STRING, ((java.lang.String)("priceLimit")));
        
        //#line 51 "/home/dsl/workspace/plhamK/samples/PriceLimit/PriceLimitFCNAgent.x10"
        final cassia.util.JSON.Value t$23917 = ((cassia.util.JSON.Value)t$23914).<cassia.util.JSON.Value> $apply__0cassia$util$JSON$Value$$T(cassia.util.JSON.Value.$RTT, ((cassia.util.JSON.Value)(t$23915)));
        
        //#line 51 "/home/dsl/workspace/plhamK/samples/PriceLimit/PriceLimitFCNAgent.x10"
        final x10.util.List t$23918 = t$23916.createEvents(((cassia.util.JSON.Value)(t$23917)));
        
        //#line 51 "/home/dsl/workspace/plhamK/samples/PriceLimit/PriceLimitFCNAgent.x10"
        final plham.Event t$23919 = ((x10.util.Indexed<plham.Event>)t$23918).$apply$G((long)(0L));
        
        //#line 51 "/home/dsl/workspace/plhamK/samples/PriceLimit/PriceLimitFCNAgent.x10"
        final plham.event.PriceLimitRule t$23920 = x10.rtt.Types.<plham.event.PriceLimitRule> cast(t$23919,plham.event.PriceLimitRule.$RTT);
        
        //#line 51 "/home/dsl/workspace/plhamK/samples/PriceLimit/PriceLimitFCNAgent.x10"
        this.priceLimit = ((plham.event.PriceLimitRule)(t$23920));
        
        //#line 52 "/home/dsl/workspace/plhamK/samples/PriceLimit/PriceLimitFCNAgent.x10"
        return this;
    }
    
    
    //#line 15 "/home/dsl/workspace/plhamK/samples/PriceLimit/PriceLimitFCNAgent.x10"
    final public samples.PriceLimit.PriceLimitFCNAgent samples$PriceLimit$PriceLimitFCNAgent$$this$samples$PriceLimit$PriceLimitFCNAgent() {
        
        //#line 15 "/home/dsl/workspace/plhamK/samples/PriceLimit/PriceLimitFCNAgent.x10"
        return samples.PriceLimit.PriceLimitFCNAgent.this;
    }
    
    
    //#line 15 "/home/dsl/workspace/plhamK/samples/PriceLimit/PriceLimitFCNAgent.x10"
    final public void __fieldInitializers_samples_PriceLimit_PriceLimitFCNAgent() {
        
        //#line 15 "/home/dsl/workspace/plhamK/samples/PriceLimit/PriceLimitFCNAgent.x10"
        this.priceLimit = null;
    }
    
    @x10.runtime.impl.java.X10Generated
    final public static class $Closure$15 extends x10.core.Ref implements x10.core.fun.Fun_0_4, x10.serialization.X10JavaSerializable
    {
        public static final x10.rtt.RuntimeType<$Closure$15> $RTT = 
            x10.rtt.StaticFunType.<$Closure$15> make($Closure$15.class,
                                                     new x10.rtt.Type[] {
                                                         x10.rtt.ParameterizedType.make(x10.core.fun.Fun_0_4.$RTT, x10.rtt.Types.LONG, x10.rtt.Types.STRING, x10.util.Random.$RTT, cassia.util.JSON.Value.$RTT, samples.PriceLimit.PriceLimitFCNAgent.$RTT)
                                                     });
        
        public x10.rtt.RuntimeType<?> $getRTT() { return $RTT; }
        
        public x10.rtt.Type<?> $getParam(int i) { return null; }
        
        private Object writeReplace() throws java.io.ObjectStreamException {
            return new x10.serialization.SerializationProxy(this);
        }
        
        public static x10.serialization.X10JavaSerializable $_deserialize_body(samples.PriceLimit.PriceLimitFCNAgent.$Closure$15 $_obj, x10.serialization.X10JavaDeserializer $deserializer) throws java.io.IOException {
            if (x10.runtime.impl.java.Runtime.TRACE_SER) { x10.runtime.impl.java.Runtime.printTraceMessage("X10JavaSerializable: $_deserialize_body() of " + $Closure$15.class + " calling"); } 
            $_obj.sim = $deserializer.readObject();
            return $_obj;
        }
        
        public static x10.serialization.X10JavaSerializable $_deserializer(x10.serialization.X10JavaDeserializer $deserializer) throws java.io.IOException {
            samples.PriceLimit.PriceLimitFCNAgent.$Closure$15 $_obj = new samples.PriceLimit.PriceLimitFCNAgent.$Closure$15((java.lang.System[]) null);
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
        
        
    
        
        public samples.PriceLimit.PriceLimitFCNAgent $apply(final long id, final java.lang.String name, final x10.util.Random random, final cassia.util.JSON.Value json) {
            
            //#line 44 "/home/dsl/workspace/plhamK/samples/PriceLimit/PriceLimitFCNAgent.x10"
            final samples.PriceLimit.PriceLimitFCNAgent t$23911 = ((samples.PriceLimit.PriceLimitFCNAgent)(new samples.PriceLimit.PriceLimitFCNAgent((java.lang.System[]) null).samples$PriceLimit$PriceLimitFCNAgent$$init$S(((long)(id)), ((java.lang.String)(name)), ((x10.util.Random)(random)))));
            
            //#line 44 "/home/dsl/workspace/plhamK/samples/PriceLimit/PriceLimitFCNAgent.x10"
            final samples.PriceLimit.PriceLimitFCNAgent t$23912 = t$23911.setup(((cassia.util.JSON.Value)(json)), ((plham.main.Simulator)(this.sim)));
            
            //#line 44 "/home/dsl/workspace/plhamK/samples/PriceLimit/PriceLimitFCNAgent.x10"
            return t$23912;
        }
        
        public plham.main.Simulator sim;
        
        public $Closure$15(final plham.main.Simulator sim) {
             {
                this.sim = ((plham.main.Simulator)(sim));
            }
        }
        
    }
    
    
    public x10.util.List plham$agent$FCNAgent$submitOrders$S(final plham.Market a0) {
        return super.submitOrders(((plham.Market)(a0)));
    }
    
    public plham.agent.FCNAgent plham$agent$FCNAgent$setup$S(final cassia.util.JSON.Value a0, final plham.main.Simulator a1) {
        return super.setup(((cassia.util.JSON.Value)(a0)), ((plham.main.Simulator)(a1)));
    }
}

