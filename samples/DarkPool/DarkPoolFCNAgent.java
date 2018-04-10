package samples.DarkPool;


@x10.runtime.impl.java.X10Generated
public class DarkPoolFCNAgent extends plham.agent.FCNAgent implements x10.serialization.X10JavaSerializable
{
    public static final x10.rtt.RuntimeType<DarkPoolFCNAgent> $RTT = 
        x10.rtt.NamedType.<DarkPoolFCNAgent> make("samples.DarkPool.DarkPoolFCNAgent",
                                                  DarkPoolFCNAgent.class,
                                                  new x10.rtt.Type[] {
                                                      plham.agent.FCNAgent.$RTT
                                                  });
    
    public x10.rtt.RuntimeType<?> $getRTT() { return $RTT; }
    
    public x10.rtt.Type<?> $getParam(int i) { return null; }
    
    private Object writeReplace() throws java.io.ObjectStreamException {
        return new x10.serialization.SerializationProxy(this);
    }
    
    public static x10.serialization.X10JavaSerializable $_deserialize_body(samples.DarkPool.DarkPoolFCNAgent $_obj, x10.serialization.X10JavaDeserializer $deserializer) throws java.io.IOException {
        if (x10.runtime.impl.java.Runtime.TRACE_SER) { x10.runtime.impl.java.Runtime.printTraceMessage("X10JavaSerializable: $_deserialize_body() of " + DarkPoolFCNAgent.class + " calling"); } 
        plham.agent.FCNAgent.$_deserialize_body($_obj, $deserializer);
        $_obj.darkPoolChance = $deserializer.readDouble();
        return $_obj;
    }
    
    public static x10.serialization.X10JavaSerializable $_deserializer(x10.serialization.X10JavaDeserializer $deserializer) throws java.io.IOException {
        samples.DarkPool.DarkPoolFCNAgent $_obj = new samples.DarkPool.DarkPoolFCNAgent((java.lang.System[]) null);
        $deserializer.record_reference($_obj);
        return $_deserialize_body($_obj, $deserializer);
    }
    
    public void $_serialize(x10.serialization.X10JavaSerializer $serializer) throws java.io.IOException {
        super.$_serialize($serializer);
        $serializer.write(this.darkPoolChance);
        
    }
    
    // constructor just for allocation
    public DarkPoolFCNAgent(final java.lang.System[] $dummy) {
        super($dummy);
        
    }
    
    

    
    
    //#line 15 "/home/dsl/workspace/plhamK/samples/DarkPool/DarkPoolFCNAgent.x10"
    // creation method for java code (1-phase java constructor)
    public DarkPoolFCNAgent(final long id, final java.lang.String name, final x10.util.Random random) {
        this((java.lang.System[]) null);
        samples$DarkPool$DarkPoolFCNAgent$$init$S(id, name, random);
    }
    
    // constructor for non-virtual call
    final public samples.DarkPool.DarkPoolFCNAgent samples$DarkPool$DarkPoolFCNAgent$$init$S(final long id, final java.lang.String name, final x10.util.Random random) {
         {
            
            //#line 15 "/home/dsl/workspace/plhamK/samples/DarkPool/DarkPoolFCNAgent.x10"
            /*super.*/plham$agent$FCNAgent$$init$S(((long)(id)), ((java.lang.String)(name)), ((x10.util.Random)(random)));
            
            //#line 15 "/home/dsl/workspace/plhamK/samples/DarkPool/DarkPoolFCNAgent.x10"
            
            
            //#line 13 "/home/dsl/workspace/plhamK/samples/DarkPool/DarkPoolFCNAgent.x10"
            this.__fieldInitializers_samples_DarkPool_DarkPoolFCNAgent();
        }
        return this;
    }
    
    
    
    //#line 16 "/home/dsl/workspace/plhamK/samples/DarkPool/DarkPoolFCNAgent.x10"
    public samples.DarkPool.DarkPoolFCNAgent setup(final cassia.util.JSON.Value json, final plham.main.Simulator sim) {
        
        //#line 17 "/home/dsl/workspace/plhamK/samples/DarkPool/DarkPoolFCNAgent.x10"
        super.setup(((cassia.util.JSON.Value)(json)), ((plham.main.Simulator)(sim)));
        
        //#line 18 "/home/dsl/workspace/plhamK/samples/DarkPool/DarkPoolFCNAgent.x10"
        final x10.util.Random t$23966 = this.getRandom();
        
        //#line 18 "/home/dsl/workspace/plhamK/samples/DarkPool/DarkPoolFCNAgent.x10"
        final plham.util.JSONRandom t$23967 = ((plham.util.JSONRandom)(new plham.util.JSONRandom((java.lang.System[]) null).plham$util$JSONRandom$$init$S(t$23966)));
        
        //#line 18 "/home/dsl/workspace/plhamK/samples/DarkPool/DarkPoolFCNAgent.x10"
        final cassia.util.JSON.Value t$23968 = ((cassia.util.JSON.Value)json).<java.lang.String> $apply__0cassia$util$JSON$Value$$T(x10.rtt.Types.STRING, ((java.lang.String)("darkPoolChance")));
        
        //#line 18 "/home/dsl/workspace/plhamK/samples/DarkPool/DarkPoolFCNAgent.x10"
        final double t$23969 = t$23967.nextRandom$O(((cassia.util.JSON.Value)(t$23968)));
        
        //#line 18 "/home/dsl/workspace/plhamK/samples/DarkPool/DarkPoolFCNAgent.x10"
        this.darkPoolChance = t$23969;
        
        //#line 19 "/home/dsl/workspace/plhamK/samples/DarkPool/DarkPoolFCNAgent.x10"
        return this;
    }
    
    
    //#line 21 "/home/dsl/workspace/plhamK/samples/DarkPool/DarkPoolFCNAgent.x10"
    public static void register(final plham.main.Simulator sim) {
        
        //#line 22 "/home/dsl/workspace/plhamK/samples/DarkPool/DarkPoolFCNAgent.x10"
        final java.lang.String className = ((java.lang.String)("DarkPoolFCNAgent"));
        
        //#line 24 "/home/dsl/workspace/plhamK/samples/DarkPool/DarkPoolFCNAgent.x10"
        final x10.core.fun.Fun_0_4 t$23972 = ((x10.core.fun.Fun_0_4)(new samples.DarkPool.DarkPoolFCNAgent.$Closure$14(sim)));
        
        //#line 23 "/home/dsl/workspace/plhamK/samples/DarkPool/DarkPoolFCNAgent.x10"
        sim.addAgentInitializer__1$1x10$lang$Long$3x10$lang$String$3x10$util$Random$3cassia$util$JSON$Value$3plham$Agent$2(((java.lang.String)(className)), ((x10.core.fun.Fun_0_4)(t$23972)));
    }
    
    
    //#line 35 "/home/dsl/workspace/plhamK/samples/DarkPool/DarkPoolFCNAgent.x10"
    public double darkPoolChance;
    
    
    //#line 37 "/home/dsl/workspace/plhamK/samples/DarkPool/DarkPoolFCNAgent.x10"
    public x10.util.List submitOrders(final plham.Market market) {
        
        //#line 38 "/home/dsl/workspace/plhamK/samples/DarkPool/DarkPoolFCNAgent.x10"
        final x10.util.ArrayList orders = ((x10.util.ArrayList)(new x10.util.ArrayList<plham.Order>((java.lang.System[]) null, plham.Order.$RTT).x10$util$ArrayList$$init$S()));
        
        //#line 39 "/home/dsl/workspace/plhamK/samples/DarkPool/DarkPoolFCNAgent.x10"
        final boolean t$23973 = this.isMarketAccessible$O(((plham.Market)(market)));
        
        //#line 39 "/home/dsl/workspace/plhamK/samples/DarkPool/DarkPoolFCNAgent.x10"
        final boolean t$23974 = !(t$23973);
        
        //#line 39 "/home/dsl/workspace/plhamK/samples/DarkPool/DarkPoolFCNAgent.x10"
        if (t$23974) {
            
            //#line 40 "/home/dsl/workspace/plhamK/samples/DarkPool/DarkPoolFCNAgent.x10"
            return orders;
        }
        
        //#line 42 "/home/dsl/workspace/plhamK/samples/DarkPool/DarkPoolFCNAgent.x10"
        final boolean t$23975 = samples.DarkPool.DarkPoolMarket.$RTT.isInstance(market);
        
        //#line 42 "/home/dsl/workspace/plhamK/samples/DarkPool/DarkPoolFCNAgent.x10"
        final boolean t$23976 = !(t$23975);
        
        //#line 42 "/home/dsl/workspace/plhamK/samples/DarkPool/DarkPoolFCNAgent.x10"
        if (t$23976) {
            
            //#line 43 "/home/dsl/workspace/plhamK/samples/DarkPool/DarkPoolFCNAgent.x10"
            return orders;
        }
        
        //#line 46 "/home/dsl/workspace/plhamK/samples/DarkPool/DarkPoolFCNAgent.x10"
        final x10.util.Random t$23977 = this.getRandom();
        
        //#line 46 "/home/dsl/workspace/plhamK/samples/DarkPool/DarkPoolFCNAgent.x10"
        final plham.util.RandomHelper random = ((plham.util.RandomHelper)(new plham.util.RandomHelper((java.lang.System[]) null).plham$util$RandomHelper$$init$S(t$23977)));
        
        //#line 48 "/home/dsl/workspace/plhamK/samples/DarkPool/DarkPoolFCNAgent.x10"
        final samples.DarkPool.DarkPoolMarket dark = ((samples.DarkPool.DarkPoolMarket)(x10.rtt.Types.<samples.DarkPool.DarkPoolMarket> cast(market,samples.DarkPool.DarkPoolMarket.$RTT)));
        
        //#line 49 "/home/dsl/workspace/plhamK/samples/DarkPool/DarkPoolFCNAgent.x10"
        final plham.Market lit = dark.getLitMarket();
        
        //#line 51 "/home/dsl/workspace/plhamK/samples/DarkPool/DarkPoolFCNAgent.x10"
        final x10.util.List t$23978 = super.submitOrders(((plham.Market)(lit)));
        
        //#line 51 "/home/dsl/workspace/plhamK/samples/DarkPool/DarkPoolFCNAgent.x10"
        ((x10.util.AbstractCollection<plham.Order>)orders).addAll__0$1x10$util$AbstractCollection$$T$2$O(((x10.util.Container)(t$23978)));
        
        //#line 52 "/home/dsl/workspace/plhamK/samples/DarkPool/DarkPoolFCNAgent.x10"
        final x10.util.ListIterator order$23996 = ((x10.util.ListIterator<plham.Order>)
                                                    ((x10.util.ArrayList<plham.Order>)orders).iterator());
        
        //#line 52 "/home/dsl/workspace/plhamK/samples/DarkPool/DarkPoolFCNAgent.x10"
        for (;
             true;
             ) {
            
            //#line 52 "/home/dsl/workspace/plhamK/samples/DarkPool/DarkPoolFCNAgent.x10"
            final boolean t$23997 = ((x10.util.ListIterator<plham.Order>)order$23996).hasNext$O();
            
            //#line 52 "/home/dsl/workspace/plhamK/samples/DarkPool/DarkPoolFCNAgent.x10"
            if (!(t$23997)) {
                
                //#line 52 "/home/dsl/workspace/plhamK/samples/DarkPool/DarkPoolFCNAgent.x10"
                break;
            }
            
            //#line 52 "/home/dsl/workspace/plhamK/samples/DarkPool/DarkPoolFCNAgent.x10"
            final plham.Order order$23988 = ((plham.Order)(((x10.util.ListIterator<plham.Order>)order$23996).next$G()));
            
            //#line 53 "/home/dsl/workspace/plhamK/samples/DarkPool/DarkPoolFCNAgent.x10"
            final double t$23989 = dark.getMidPrice$O();
            
            //#line 53 "/home/dsl/workspace/plhamK/samples/DarkPool/DarkPoolFCNAgent.x10"
            final boolean t$23990 = plham.agent.FCNAgent.isFinite$O((double)(t$23989));
            
            //#line 53 "/home/dsl/workspace/plhamK/samples/DarkPool/DarkPoolFCNAgent.x10"
            boolean t$23991 = !(t$23990);
            
            //#line 53 "/home/dsl/workspace/plhamK/samples/DarkPool/DarkPoolFCNAgent.x10"
            if (t$23991) {
                
                //#line 53 "/home/dsl/workspace/plhamK/samples/DarkPool/DarkPoolFCNAgent.x10"
                final double t$23992 = this.darkPoolChance;
                
                //#line 53 "/home/dsl/workspace/plhamK/samples/DarkPool/DarkPoolFCNAgent.x10"
                t$23991 = random.nextBoolean$O((double)(t$23992));
            }
            
            //#line 53 "/home/dsl/workspace/plhamK/samples/DarkPool/DarkPoolFCNAgent.x10"
            final boolean t$23993 = t$23991;
            
            //#line 53 "/home/dsl/workspace/plhamK/samples/DarkPool/DarkPoolFCNAgent.x10"
            if (t$23993) {
                
                //#line 54 "/home/dsl/workspace/plhamK/samples/DarkPool/DarkPoolFCNAgent.x10"
                final long t$23994 = dark.id;
                
                //#line 54 "/home/dsl/workspace/plhamK/samples/DarkPool/DarkPoolFCNAgent.x10"
                order$23988.marketId = t$23994;
                
                //#line 55 "/home/dsl/workspace/plhamK/samples/DarkPool/DarkPoolFCNAgent.x10"
                final double t$23995 = plham.Order.get$NO_PRICE();
                
                //#line 55 "/home/dsl/workspace/plhamK/samples/DarkPool/DarkPoolFCNAgent.x10"
                order$23988.setPrice$O((double)(t$23995));
            }
        }
        
        //#line 58 "/home/dsl/workspace/plhamK/samples/DarkPool/DarkPoolFCNAgent.x10"
        return orders;
    }
    
    
    //#line 13 "/home/dsl/workspace/plhamK/samples/DarkPool/DarkPoolFCNAgent.x10"
    final public samples.DarkPool.DarkPoolFCNAgent samples$DarkPool$DarkPoolFCNAgent$$this$samples$DarkPool$DarkPoolFCNAgent() {
        
        //#line 13 "/home/dsl/workspace/plhamK/samples/DarkPool/DarkPoolFCNAgent.x10"
        return samples.DarkPool.DarkPoolFCNAgent.this;
    }
    
    
    //#line 13 "/home/dsl/workspace/plhamK/samples/DarkPool/DarkPoolFCNAgent.x10"
    final public void __fieldInitializers_samples_DarkPool_DarkPoolFCNAgent() {
        
        //#line 13 "/home/dsl/workspace/plhamK/samples/DarkPool/DarkPoolFCNAgent.x10"
        this.darkPoolChance = 0.0;
    }
    
    @x10.runtime.impl.java.X10Generated
    final public static class $Closure$14 extends x10.core.Ref implements x10.core.fun.Fun_0_4, x10.serialization.X10JavaSerializable
    {
        public static final x10.rtt.RuntimeType<$Closure$14> $RTT = 
            x10.rtt.StaticFunType.<$Closure$14> make($Closure$14.class,
                                                     new x10.rtt.Type[] {
                                                         x10.rtt.ParameterizedType.make(x10.core.fun.Fun_0_4.$RTT, x10.rtt.Types.LONG, x10.rtt.Types.STRING, x10.util.Random.$RTT, cassia.util.JSON.Value.$RTT, samples.DarkPool.DarkPoolFCNAgent.$RTT)
                                                     });
        
        public x10.rtt.RuntimeType<?> $getRTT() { return $RTT; }
        
        public x10.rtt.Type<?> $getParam(int i) { return null; }
        
        private Object writeReplace() throws java.io.ObjectStreamException {
            return new x10.serialization.SerializationProxy(this);
        }
        
        public static x10.serialization.X10JavaSerializable $_deserialize_body(samples.DarkPool.DarkPoolFCNAgent.$Closure$14 $_obj, x10.serialization.X10JavaDeserializer $deserializer) throws java.io.IOException {
            if (x10.runtime.impl.java.Runtime.TRACE_SER) { x10.runtime.impl.java.Runtime.printTraceMessage("X10JavaSerializable: $_deserialize_body() of " + $Closure$14.class + " calling"); } 
            $_obj.sim = $deserializer.readObject();
            return $_obj;
        }
        
        public static x10.serialization.X10JavaSerializable $_deserializer(x10.serialization.X10JavaDeserializer $deserializer) throws java.io.IOException {
            samples.DarkPool.DarkPoolFCNAgent.$Closure$14 $_obj = new samples.DarkPool.DarkPoolFCNAgent.$Closure$14((java.lang.System[]) null);
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
        
        
    
        
        public samples.DarkPool.DarkPoolFCNAgent $apply(final long id, final java.lang.String name, final x10.util.Random random, final cassia.util.JSON.Value json) {
            
            //#line 30 "/home/dsl/workspace/plhamK/samples/DarkPool/DarkPoolFCNAgent.x10"
            final samples.DarkPool.DarkPoolFCNAgent t$23970 = ((samples.DarkPool.DarkPoolFCNAgent)(new samples.DarkPool.DarkPoolFCNAgent((java.lang.System[]) null).samples$DarkPool$DarkPoolFCNAgent$$init$S(((long)(id)), ((java.lang.String)(name)), ((x10.util.Random)(random)))));
            
            //#line 30 "/home/dsl/workspace/plhamK/samples/DarkPool/DarkPoolFCNAgent.x10"
            final samples.DarkPool.DarkPoolFCNAgent t$23971 = t$23970.setup(((cassia.util.JSON.Value)(json)), ((plham.main.Simulator)(this.sim)));
            
            //#line 30 "/home/dsl/workspace/plhamK/samples/DarkPool/DarkPoolFCNAgent.x10"
            return t$23971;
        }
        
        public plham.main.Simulator sim;
        
        public $Closure$14(final plham.main.Simulator sim) {
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

