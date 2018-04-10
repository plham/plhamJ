package samples.DarkPool;


@x10.runtime.impl.java.X10Generated
public class DarkPoolMarket extends plham.Market implements x10.serialization.X10JavaSerializable
{
    public static final x10.rtt.RuntimeType<DarkPoolMarket> $RTT = 
        x10.rtt.NamedType.<DarkPoolMarket> make("samples.DarkPool.DarkPoolMarket",
                                                DarkPoolMarket.class,
                                                new x10.rtt.Type[] {
                                                    plham.Market.$RTT
                                                });
    
    public x10.rtt.RuntimeType<?> $getRTT() { return $RTT; }
    
    public x10.rtt.Type<?> $getParam(int i) { return null; }
    
    private Object writeReplace() throws java.io.ObjectStreamException {
        return new x10.serialization.SerializationProxy(this);
    }
    
    public static x10.serialization.X10JavaSerializable $_deserialize_body(samples.DarkPool.DarkPoolMarket $_obj, x10.serialization.X10JavaDeserializer $deserializer) throws java.io.IOException {
        if (x10.runtime.impl.java.Runtime.TRACE_SER) { x10.runtime.impl.java.Runtime.printTraceMessage("X10JavaSerializable: $_deserialize_body() of " + DarkPoolMarket.class + " calling"); } 
        plham.Market.$_deserialize_body($_obj, $deserializer);
        $_obj.litMarketId = $deserializer.readLong();
        return $_obj;
    }
    
    public static x10.serialization.X10JavaSerializable $_deserializer(x10.serialization.X10JavaDeserializer $deserializer) throws java.io.IOException {
        samples.DarkPool.DarkPoolMarket $_obj = new samples.DarkPool.DarkPoolMarket((java.lang.System[]) null);
        $deserializer.record_reference($_obj);
        return $_deserialize_body($_obj, $deserializer);
    }
    
    public void $_serialize(x10.serialization.X10JavaSerializer $serializer) throws java.io.IOException {
        super.$_serialize($serializer);
        $serializer.write(this.litMarketId);
        
    }
    
    // constructor just for allocation
    public DarkPoolMarket(final java.lang.System[] $dummy) {
        super($dummy);
        
    }
    
    

    
    
    //#line 11 "/home/dsl/workspace/plhamK/samples/DarkPool/DarkPoolMarket.x10"
    // creation method for java code (1-phase java constructor)
    public DarkPoolMarket(final long id, final java.lang.String name, final x10.util.Random random) {
        this((java.lang.System[]) null);
        samples$DarkPool$DarkPoolMarket$$init$S(id, name, random);
    }
    
    // constructor for non-virtual call
    final public samples.DarkPool.DarkPoolMarket samples$DarkPool$DarkPoolMarket$$init$S(final long id, final java.lang.String name, final x10.util.Random random) {
         {
            
            //#line 11 "/home/dsl/workspace/plhamK/samples/DarkPool/DarkPoolMarket.x10"
            /*super.*/plham$Market$$init$S(((long)(id)), ((java.lang.String)(name)), ((x10.util.Random)(random)));
            
            //#line 11 "/home/dsl/workspace/plhamK/samples/DarkPool/DarkPoolMarket.x10"
            
            
            //#line 9 "/home/dsl/workspace/plhamK/samples/DarkPool/DarkPoolMarket.x10"
            this.__fieldInitializers_samples_DarkPool_DarkPoolMarket();
        }
        return this;
    }
    
    
    
    //#line 12 "/home/dsl/workspace/plhamK/samples/DarkPool/DarkPoolMarket.x10"
    public samples.DarkPool.DarkPoolMarket setup(final cassia.util.JSON.Value json, final plham.main.Simulator sim) {
        
        //#line 13 "/home/dsl/workspace/plhamK/samples/DarkPool/DarkPoolMarket.x10"
        assert ((long) ((cassia.util.JSON.Value)json).<java.lang.String> $apply__0cassia$util$JSON$Value$$T(x10.rtt.Types.STRING, ((java.lang.String)("markets"))).size$O()) == ((long) 1L);
        
        //#line 14 "/home/dsl/workspace/plhamK/samples/DarkPool/DarkPoolMarket.x10"
        super.setup(((cassia.util.JSON.Value)(json)), ((plham.main.Simulator)(sim)));
        
        //#line 15 "/home/dsl/workspace/plhamK/samples/DarkPool/DarkPoolMarket.x10"
        final cassia.util.JSON.Value t$25958 = ((cassia.util.JSON.Value)json).<java.lang.String> $apply__0cassia$util$JSON$Value$$T(x10.rtt.Types.STRING, ((java.lang.String)("markets")));
        
        //#line 15 "/home/dsl/workspace/plhamK/samples/DarkPool/DarkPoolMarket.x10"
        final cassia.util.JSON.Value t$25959 = ((cassia.util.JSON.Value)t$25958).<x10.core.Long> $apply__0cassia$util$JSON$Value$$T(x10.rtt.Types.LONG, x10.core.Long.$box(0L));
        
        //#line 15 "/home/dsl/workspace/plhamK/samples/DarkPool/DarkPoolMarket.x10"
        final plham.Market lit = sim.getMarketByName(((cassia.util.JSON.Value)(t$25959)));
        
        //#line 16 "/home/dsl/workspace/plhamK/samples/DarkPool/DarkPoolMarket.x10"
        this.setLitMarket$O(((plham.Market)(lit)));
        
        //#line 17 "/home/dsl/workspace/plhamK/samples/DarkPool/DarkPoolMarket.x10"
        return this;
    }
    
    
    //#line 19 "/home/dsl/workspace/plhamK/samples/DarkPool/DarkPoolMarket.x10"
    public static void register(final plham.main.Simulator sim) {
        
        //#line 20 "/home/dsl/workspace/plhamK/samples/DarkPool/DarkPoolMarket.x10"
        final java.lang.String className = ((java.lang.String)("DarkPoolMarket"));
        
        //#line 21 "/home/dsl/workspace/plhamK/samples/DarkPool/DarkPoolMarket.x10"
        final x10.core.fun.Fun_0_4 t$25962 = ((x10.core.fun.Fun_0_4)(new samples.DarkPool.DarkPoolMarket.$Closure$16(sim)));
        
        //#line 21 "/home/dsl/workspace/plhamK/samples/DarkPool/DarkPoolMarket.x10"
        sim.addMarketInitializer__1$1x10$lang$Long$3x10$lang$String$3x10$util$Random$3cassia$util$JSON$Value$3plham$Market$2(((java.lang.String)(className)), ((x10.core.fun.Fun_0_4)(t$25962)));
    }
    
    
    //#line 26 "/home/dsl/workspace/plhamK/samples/DarkPool/DarkPoolMarket.x10"
    public long litMarketId;
    
    
    //#line 28 "/home/dsl/workspace/plhamK/samples/DarkPool/DarkPoolMarket.x10"
    public void handleOrders__0$1plham$Order$2(final x10.util.List orders) {
        
        //#line 29 "/home/dsl/workspace/plhamK/samples/DarkPool/DarkPoolMarket.x10"
        final boolean t$25963 = this.isRunning$O();
        
        //#line 29 "/home/dsl/workspace/plhamK/samples/DarkPool/DarkPoolMarket.x10"
        if (t$25963) {
            
            //#line 30 "/home/dsl/workspace/plhamK/samples/DarkPool/DarkPoolMarket.x10"
            super.handleOrders__0$1plham$Order$2(((x10.util.Container)(orders)));
        }
    }
    
    
    //#line 34 "/home/dsl/workspace/plhamK/samples/DarkPool/DarkPoolMarket.x10"
    public void handleOrder(final plham.Order order) {
        
        //#line 35 "/home/dsl/workspace/plhamK/samples/DarkPool/DarkPoolMarket.x10"
        final boolean t$25964 = this.isRunning$O();
        
        //#line 35 "/home/dsl/workspace/plhamK/samples/DarkPool/DarkPoolMarket.x10"
        if (t$25964) {
            
            //#line 36 "/home/dsl/workspace/plhamK/samples/DarkPool/DarkPoolMarket.x10"
            super.handleOrder(((plham.Order)(order)));
        }
    }
    
    
    //#line 40 "/home/dsl/workspace/plhamK/samples/DarkPool/DarkPoolMarket.x10"
    public void executeBuyOrders(final plham.Order buyOrder, final plham.Order sellOrder) {
        
        //#line 41 "/home/dsl/workspace/plhamK/samples/DarkPool/DarkPoolMarket.x10"
        assert ((double) buyOrder.getPrice$O()) == ((double) plham.Order.get$NO_PRICE()): "The price must be Order.NO_PRICE";
        
        //#line 42 "/home/dsl/workspace/plhamK/samples/DarkPool/DarkPoolMarket.x10"
        assert ((double) sellOrder.getPrice$O()) == ((double) plham.Order.get$NO_PRICE()): "The price must be Order.NO_PRICE";
        
        //#line 43 "/home/dsl/workspace/plhamK/samples/DarkPool/DarkPoolMarket.x10"
        final double t$25965 = this.getLitMidPrice$O();
        
        //#line 43 "/home/dsl/workspace/plhamK/samples/DarkPool/DarkPoolMarket.x10"
        final double t$25966 = this.roundSellPrice$O((double)(t$25965));
        
        //#line 43 "/home/dsl/workspace/plhamK/samples/DarkPool/DarkPoolMarket.x10"
        this.executeOrders((double)(t$25966), ((plham.Order)(buyOrder)), ((plham.Order)(sellOrder)), (boolean)(true));
    }
    
    
    //#line 46 "/home/dsl/workspace/plhamK/samples/DarkPool/DarkPoolMarket.x10"
    public void executeSellOrders(final plham.Order sellOrder, final plham.Order buyOrder) {
        
        //#line 47 "/home/dsl/workspace/plhamK/samples/DarkPool/DarkPoolMarket.x10"
        assert ((double) buyOrder.getPrice$O()) == ((double) plham.Order.get$NO_PRICE()): "The price must be Order.NO_PRICE";
        
        //#line 48 "/home/dsl/workspace/plhamK/samples/DarkPool/DarkPoolMarket.x10"
        assert ((double) sellOrder.getPrice$O()) == ((double) plham.Order.get$NO_PRICE()): "The price must be Order.NO_PRICE";
        
        //#line 49 "/home/dsl/workspace/plhamK/samples/DarkPool/DarkPoolMarket.x10"
        final double t$25967 = this.getLitMidPrice$O();
        
        //#line 49 "/home/dsl/workspace/plhamK/samples/DarkPool/DarkPoolMarket.x10"
        final double t$25968 = this.roundBuyPrice$O((double)(t$25967));
        
        //#line 49 "/home/dsl/workspace/plhamK/samples/DarkPool/DarkPoolMarket.x10"
        this.executeOrders((double)(t$25968), ((plham.Order)(buyOrder)), ((plham.Order)(sellOrder)), (boolean)(false));
    }
    
    
    //#line 52 "/home/dsl/workspace/plhamK/samples/DarkPool/DarkPoolMarket.x10"
    public plham.Market getLitMarket() {
        
        //#line 52 "/home/dsl/workspace/plhamK/samples/DarkPool/DarkPoolMarket.x10"
        final plham.Env t$25969 = ((plham.Env)(this.env));
        
        //#line 52 "/home/dsl/workspace/plhamK/samples/DarkPool/DarkPoolMarket.x10"
        final x10.util.List t$25970 = ((x10.util.List)(t$25969.markets));
        
        //#line 52 "/home/dsl/workspace/plhamK/samples/DarkPool/DarkPoolMarket.x10"
        final long t$25971 = this.litMarketId;
        
        //#line 52 "/home/dsl/workspace/plhamK/samples/DarkPool/DarkPoolMarket.x10"
        final plham.Market t$25972 = ((x10.util.Indexed<plham.Market>)t$25970).$apply$G((long)(t$25971));
        
        //#line 52 "/home/dsl/workspace/plhamK/samples/DarkPool/DarkPoolMarket.x10"
        return t$25972;
    }
    
    
    //#line 54 "/home/dsl/workspace/plhamK/samples/DarkPool/DarkPoolMarket.x10"
    public long setLitMarket$O(final plham.Market market) {
        
        //#line 54 "/home/dsl/workspace/plhamK/samples/DarkPool/DarkPoolMarket.x10"
        final long t$25973 = market.id;
        
        //#line 54 "/home/dsl/workspace/plhamK/samples/DarkPool/DarkPoolMarket.x10"
        final long t$25974 = this.litMarketId = t$25973;
        
        //#line 54 "/home/dsl/workspace/plhamK/samples/DarkPool/DarkPoolMarket.x10"
        return t$25974;
    }
    
    
    //#line 56 "/home/dsl/workspace/plhamK/samples/DarkPool/DarkPoolMarket.x10"
    public double getLitMidPrice$O() {
        
        //#line 57 "/home/dsl/workspace/plhamK/samples/DarkPool/DarkPoolMarket.x10"
        final plham.Market lit = this.getLitMarket();
        
        //#line 58 "/home/dsl/workspace/plhamK/samples/DarkPool/DarkPoolMarket.x10"
        double litPrice = lit.getMidPrice$O();
        
        //#line 59 "/home/dsl/workspace/plhamK/samples/DarkPool/DarkPoolMarket.x10"
        final double t$25975 = litPrice;
        
        //#line 59 "/home/dsl/workspace/plhamK/samples/DarkPool/DarkPoolMarket.x10"
        final boolean t$25978 = java.lang.Double.isNaN(t$25975);
        
        //#line 59 "/home/dsl/workspace/plhamK/samples/DarkPool/DarkPoolMarket.x10"
        if (t$25978) {
            
            //#line 60 "/home/dsl/workspace/plhamK/samples/DarkPool/DarkPoolMarket.x10"
            final plham.Market t$25976 = this.getLitMarket();
            
            //#line 60 "/home/dsl/workspace/plhamK/samples/DarkPool/DarkPoolMarket.x10"
            final double t$25977 = t$25976.getPrice$O();
            
            //#line 60 "/home/dsl/workspace/plhamK/samples/DarkPool/DarkPoolMarket.x10"
            litPrice = t$25977;
        }
        
        //#line 62 "/home/dsl/workspace/plhamK/samples/DarkPool/DarkPoolMarket.x10"
        final double t$25979 = litPrice;
        
        //#line 62 "/home/dsl/workspace/plhamK/samples/DarkPool/DarkPoolMarket.x10"
        return t$25979;
    }
    
    
    //#line 9 "/home/dsl/workspace/plhamK/samples/DarkPool/DarkPoolMarket.x10"
    final public samples.DarkPool.DarkPoolMarket samples$DarkPool$DarkPoolMarket$$this$samples$DarkPool$DarkPoolMarket() {
        
        //#line 9 "/home/dsl/workspace/plhamK/samples/DarkPool/DarkPoolMarket.x10"
        return samples.DarkPool.DarkPoolMarket.this;
    }
    
    
    //#line 9 "/home/dsl/workspace/plhamK/samples/DarkPool/DarkPoolMarket.x10"
    final public void __fieldInitializers_samples_DarkPool_DarkPoolMarket() {
        
        //#line 9 "/home/dsl/workspace/plhamK/samples/DarkPool/DarkPoolMarket.x10"
        this.litMarketId = 0L;
    }
    
    @x10.runtime.impl.java.X10Generated
    final public static class $Closure$16 extends x10.core.Ref implements x10.core.fun.Fun_0_4, x10.serialization.X10JavaSerializable
    {
        public static final x10.rtt.RuntimeType<$Closure$16> $RTT = 
            x10.rtt.StaticFunType.<$Closure$16> make($Closure$16.class,
                                                     new x10.rtt.Type[] {
                                                         x10.rtt.ParameterizedType.make(x10.core.fun.Fun_0_4.$RTT, x10.rtt.Types.LONG, x10.rtt.Types.STRING, x10.util.Random.$RTT, cassia.util.JSON.Value.$RTT, samples.DarkPool.DarkPoolMarket.$RTT)
                                                     });
        
        public x10.rtt.RuntimeType<?> $getRTT() { return $RTT; }
        
        public x10.rtt.Type<?> $getParam(int i) { return null; }
        
        private Object writeReplace() throws java.io.ObjectStreamException {
            return new x10.serialization.SerializationProxy(this);
        }
        
        public static x10.serialization.X10JavaSerializable $_deserialize_body(samples.DarkPool.DarkPoolMarket.$Closure$16 $_obj, x10.serialization.X10JavaDeserializer $deserializer) throws java.io.IOException {
            if (x10.runtime.impl.java.Runtime.TRACE_SER) { x10.runtime.impl.java.Runtime.printTraceMessage("X10JavaSerializable: $_deserialize_body() of " + $Closure$16.class + " calling"); } 
            $_obj.sim = $deserializer.readObject();
            return $_obj;
        }
        
        public static x10.serialization.X10JavaSerializable $_deserializer(x10.serialization.X10JavaDeserializer $deserializer) throws java.io.IOException {
            samples.DarkPool.DarkPoolMarket.$Closure$16 $_obj = new samples.DarkPool.DarkPoolMarket.$Closure$16((java.lang.System[]) null);
            $deserializer.record_reference($_obj);
            return $_deserialize_body($_obj, $deserializer);
        }
        
        public void $_serialize(x10.serialization.X10JavaSerializer $serializer) throws java.io.IOException {
            $serializer.write(this.sim);
            
        }
        
        // constructor just for allocation
        public $Closure$16(final java.lang.System[] $dummy) {
            
        }
        
        // dispatcher for method abstract public (Z1,Z2,Z3,Z4)=>U.operator()(a1:Z1, a2:Z2, a3:Z3, a4:Z4):U
        public java.lang.Object $apply(final java.lang.Object a1, final x10.rtt.Type t1, final java.lang.Object a2, final x10.rtt.Type t2, final java.lang.Object a3, final x10.rtt.Type t3, final java.lang.Object a4, final x10.rtt.Type t4) {
            return $apply(x10.core.Long.$unbox(a1), (java.lang.String)a2, (x10.util.Random)a3, (cassia.util.JSON.Value)a4);
            
        }
        
        
    
        
        public samples.DarkPool.DarkPoolMarket $apply(final long id, final java.lang.String name, final x10.util.Random random, final cassia.util.JSON.Value json) {
            
            //#line 22 "/home/dsl/workspace/plhamK/samples/DarkPool/DarkPoolMarket.x10"
            final samples.DarkPool.DarkPoolMarket t$25960 = ((samples.DarkPool.DarkPoolMarket)(new samples.DarkPool.DarkPoolMarket((java.lang.System[]) null).samples$DarkPool$DarkPoolMarket$$init$S(((long)(id)), ((java.lang.String)(name)), ((x10.util.Random)(random)))));
            
            //#line 22 "/home/dsl/workspace/plhamK/samples/DarkPool/DarkPoolMarket.x10"
            final samples.DarkPool.DarkPoolMarket t$25961 = t$25960.setup(((cassia.util.JSON.Value)(json)), ((plham.main.Simulator)(this.sim)));
            
            //#line 22 "/home/dsl/workspace/plhamK/samples/DarkPool/DarkPoolMarket.x10"
            return t$25961;
        }
        
        public plham.main.Simulator sim;
        
        public $Closure$16(final plham.main.Simulator sim) {
             {
                this.sim = ((plham.main.Simulator)(sim));
            }
        }
        
    }
    
    
    public plham.Market plham$Market$setup$S(final cassia.util.JSON.Value a0, final plham.main.Simulator a1) {
        return super.setup(((cassia.util.JSON.Value)(a0)), ((plham.main.Simulator)(a1)));
    }
    
    public void plham$Market$handleOrders$S__0$1plham$Order$2(final x10.util.Container a0) {
        super.handleOrders__0$1plham$Order$2(((x10.util.Container)(a0)));
    }
    
    public void plham$Market$handleOrder$S(final plham.Order a0) {
        super.handleOrder(((plham.Order)(a0)));
    }
}

