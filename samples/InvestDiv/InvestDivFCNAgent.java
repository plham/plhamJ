package samples.InvestDiv;


/** The regulation for investment diversification. */
@x10.runtime.impl.java.X10Generated
public class InvestDivFCNAgent extends plham.agent.FCNAgent implements x10.serialization.X10JavaSerializable
{
    public static final x10.rtt.RuntimeType<InvestDivFCNAgent> $RTT = 
        x10.rtt.NamedType.<InvestDivFCNAgent> make("samples.InvestDiv.InvestDivFCNAgent",
                                                   InvestDivFCNAgent.class,
                                                   new x10.rtt.Type[] {
                                                       plham.agent.FCNAgent.$RTT
                                                   });
    
    public x10.rtt.RuntimeType<?> $getRTT() { return $RTT; }
    
    public x10.rtt.Type<?> $getParam(int i) { return null; }
    
    private Object writeReplace() throws java.io.ObjectStreamException {
        return new x10.serialization.SerializationProxy(this);
    }
    
    public static x10.serialization.X10JavaSerializable $_deserialize_body(samples.InvestDiv.InvestDivFCNAgent $_obj, x10.serialization.X10JavaDeserializer $deserializer) throws java.io.IOException {
        if (x10.runtime.impl.java.Runtime.TRACE_SER) { x10.runtime.impl.java.Runtime.printTraceMessage("X10JavaSerializable: $_deserialize_body() of " + InvestDivFCNAgent.class + " calling"); } 
        plham.agent.FCNAgent.$_deserialize_body($_obj, $deserializer);
        $_obj.diversityRatio = $deserializer.readDouble();
        $_obj.leverageRatio = $deserializer.readDouble();
        return $_obj;
    }
    
    public static x10.serialization.X10JavaSerializable $_deserializer(x10.serialization.X10JavaDeserializer $deserializer) throws java.io.IOException {
        samples.InvestDiv.InvestDivFCNAgent $_obj = new samples.InvestDiv.InvestDivFCNAgent((java.lang.System[]) null);
        $deserializer.record_reference($_obj);
        return $_deserialize_body($_obj, $deserializer);
    }
    
    public void $_serialize(x10.serialization.X10JavaSerializer $serializer) throws java.io.IOException {
        super.$_serialize($serializer);
        $serializer.write(this.diversityRatio);
        $serializer.write(this.leverageRatio);
        
    }
    
    // constructor just for allocation
    public InvestDivFCNAgent(final java.lang.System[] $dummy) {
        super($dummy);
        
    }
    
    

    
    //#line 15 "/home/dsl/workspace/plhamK/samples/InvestDiv/InvestDivFCNAgent.x10"
    public double leverageRatio;
    
    //#line 16 "/home/dsl/workspace/plhamK/samples/InvestDiv/InvestDivFCNAgent.x10"
    public double diversityRatio;
    
    
    //#line 18 "/home/dsl/workspace/plhamK/samples/InvestDiv/InvestDivFCNAgent.x10"
    // creation method for java code (1-phase java constructor)
    public InvestDivFCNAgent(final long id, final java.lang.String name, final x10.util.Random random) {
        this((java.lang.System[]) null);
        samples$InvestDiv$InvestDivFCNAgent$$init$S(id, name, random);
    }
    
    // constructor for non-virtual call
    final public samples.InvestDiv.InvestDivFCNAgent samples$InvestDiv$InvestDivFCNAgent$$init$S(final long id, final java.lang.String name, final x10.util.Random random) {
         {
            
            //#line 18 "/home/dsl/workspace/plhamK/samples/InvestDiv/InvestDivFCNAgent.x10"
            /*super.*/plham$agent$FCNAgent$$init$S(((long)(id)), ((java.lang.String)(name)), ((x10.util.Random)(random)));
            
            //#line 18 "/home/dsl/workspace/plhamK/samples/InvestDiv/InvestDivFCNAgent.x10"
            
            
            //#line 13 "/home/dsl/workspace/plhamK/samples/InvestDiv/InvestDivFCNAgent.x10"
            this.__fieldInitializers_samples_InvestDiv_InvestDivFCNAgent();
        }
        return this;
    }
    
    
    
    //#line 19 "/home/dsl/workspace/plhamK/samples/InvestDiv/InvestDivFCNAgent.x10"
    public samples.InvestDiv.InvestDivFCNAgent setup(final cassia.util.JSON.Value json, final plham.main.Simulator sim) {
        
        //#line 20 "/home/dsl/workspace/plhamK/samples/InvestDiv/InvestDivFCNAgent.x10"
        super.setup(((cassia.util.JSON.Value)(json)), ((plham.main.Simulator)(sim)));
        
        //#line 21 "/home/dsl/workspace/plhamK/samples/InvestDiv/InvestDivFCNAgent.x10"
        final cassia.util.JSON.Value t$24086 = ((cassia.util.JSON.Value)json).<java.lang.String> $apply__0cassia$util$JSON$Value$$T(x10.rtt.Types.STRING, ((java.lang.String)("leverageRatio")));
        
        //#line 21 "/home/dsl/workspace/plhamK/samples/InvestDiv/InvestDivFCNAgent.x10"
        final double t$24087 = t$24086.toDouble$O();
        
        //#line 21 "/home/dsl/workspace/plhamK/samples/InvestDiv/InvestDivFCNAgent.x10"
        this.leverageRatio = t$24087;
        
        //#line 22 "/home/dsl/workspace/plhamK/samples/InvestDiv/InvestDivFCNAgent.x10"
        final cassia.util.JSON.Value t$24088 = ((cassia.util.JSON.Value)json).<java.lang.String> $apply__0cassia$util$JSON$Value$$T(x10.rtt.Types.STRING, ((java.lang.String)("diversityRatio")));
        
        //#line 22 "/home/dsl/workspace/plhamK/samples/InvestDiv/InvestDivFCNAgent.x10"
        final double t$24089 = t$24088.toDouble$O();
        
        //#line 22 "/home/dsl/workspace/plhamK/samples/InvestDiv/InvestDivFCNAgent.x10"
        this.diversityRatio = t$24089;
        
        //#line 23 "/home/dsl/workspace/plhamK/samples/InvestDiv/InvestDivFCNAgent.x10"
        return this;
    }
    
    
    //#line 25 "/home/dsl/workspace/plhamK/samples/InvestDiv/InvestDivFCNAgent.x10"
    public static void register(final plham.main.Simulator sim) {
        
        //#line 26 "/home/dsl/workspace/plhamK/samples/InvestDiv/InvestDivFCNAgent.x10"
        final java.lang.String className = ((java.lang.String)("InvestDivFCNAgent"));
        
        //#line 28 "/home/dsl/workspace/plhamK/samples/InvestDiv/InvestDivFCNAgent.x10"
        final x10.core.fun.Fun_0_4 t$24092 = ((x10.core.fun.Fun_0_4)(new samples.InvestDiv.InvestDivFCNAgent.$Closure$14(sim)));
        
        //#line 27 "/home/dsl/workspace/plhamK/samples/InvestDiv/InvestDivFCNAgent.x10"
        sim.addAgentInitializer__1$1x10$lang$Long$3x10$lang$String$3x10$util$Random$3cassia$util$JSON$Value$3plham$Agent$2(((java.lang.String)(className)), ((x10.core.fun.Fun_0_4)(t$24092)));
    }
    
    
    //#line 39 "/home/dsl/workspace/plhamK/samples/InvestDiv/InvestDivFCNAgent.x10"
    public x10.util.List filterMarkets__0$1plham$Market$2(final x10.util.Indexed markets) {
        
        //#line 40 "/home/dsl/workspace/plhamK/samples/InvestDiv/InvestDivFCNAgent.x10"
        final x10.util.ArrayList a = ((x10.util.ArrayList)(new x10.util.ArrayList<plham.Market>((java.lang.System[]) null, plham.Market.$RTT).x10$util$ArrayList$$init$S()));
        
        //#line 41 "/home/dsl/workspace/plhamK/samples/InvestDiv/InvestDivFCNAgent.x10"
        final x10.lang.Iterator market$24128 = ((x10.lang.Iterator<plham.Market>)
                                                 ((x10.lang.Iterable<plham.Market>)markets).iterator());
        
        //#line 41 "/home/dsl/workspace/plhamK/samples/InvestDiv/InvestDivFCNAgent.x10"
        for (;
             true;
             ) {
            
            //#line 41 "/home/dsl/workspace/plhamK/samples/InvestDiv/InvestDivFCNAgent.x10"
            final boolean t$24129 = ((x10.lang.Iterator<plham.Market>)market$24128).hasNext$O();
            
            //#line 41 "/home/dsl/workspace/plhamK/samples/InvestDiv/InvestDivFCNAgent.x10"
            if (!(t$24129)) {
                
                //#line 41 "/home/dsl/workspace/plhamK/samples/InvestDiv/InvestDivFCNAgent.x10"
                break;
            }
            
            //#line 41 "/home/dsl/workspace/plhamK/samples/InvestDiv/InvestDivFCNAgent.x10"
            final plham.Market market$24126 = ((plham.Market)(((x10.lang.Iterator<plham.Market>)market$24128).next$G()));
            
            //#line 42 "/home/dsl/workspace/plhamK/samples/InvestDiv/InvestDivFCNAgent.x10"
            final boolean t$24127 = this.isMarketAccessible$O(((plham.Market)(market$24126)));
            
            //#line 42 "/home/dsl/workspace/plhamK/samples/InvestDiv/InvestDivFCNAgent.x10"
            if (t$24127) {
                
                //#line 43 "/home/dsl/workspace/plhamK/samples/InvestDiv/InvestDivFCNAgent.x10"
                ((x10.util.ArrayList<plham.Market>)a).add__0x10$util$ArrayList$$T$O(((plham.Market)(market$24126)));
            }
        }
        
        //#line 46 "/home/dsl/workspace/plhamK/samples/InvestDiv/InvestDivFCNAgent.x10"
        return a;
    }
    
    
    //#line 49 "/home/dsl/workspace/plhamK/samples/InvestDiv/InvestDivFCNAgent.x10"
    public double getAssetValue$O(final plham.Market market) {
        
        //#line 50 "/home/dsl/workspace/plhamK/samples/InvestDiv/InvestDivFCNAgent.x10"
        final double t$24097 = market.getPrice$O();
        
        //#line 50 "/home/dsl/workspace/plhamK/samples/InvestDiv/InvestDivFCNAgent.x10"
        final long t$24096 = this.getAssetVolume$O(((plham.Market)(market)));
        
        //#line 50 "/home/dsl/workspace/plhamK/samples/InvestDiv/InvestDivFCNAgent.x10"
        final double t$24098 = ((double)(long)(((long)(t$24096))));
        
        //#line 50 "/home/dsl/workspace/plhamK/samples/InvestDiv/InvestDivFCNAgent.x10"
        final double t$24099 = ((t$24097) * (((double)(t$24098))));
        
        //#line 50 "/home/dsl/workspace/plhamK/samples/InvestDiv/InvestDivFCNAgent.x10"
        return t$24099;
    }
    
    
    //#line 53 "/home/dsl/workspace/plhamK/samples/InvestDiv/InvestDivFCNAgent.x10"
    public x10.util.List submitOrders__0$1plham$Market$2(final x10.util.Indexed markets) {
        
        //#line 54 "/home/dsl/workspace/plhamK/samples/InvestDiv/InvestDivFCNAgent.x10"
        final double leverageRatio = 1.0;
        
        //#line 55 "/home/dsl/workspace/plhamK/samples/InvestDiv/InvestDivFCNAgent.x10"
        final x10.util.List m = this.filterMarkets__0$1plham$Market$2(((x10.util.Indexed)(markets)));
        
        //#line 56 "/home/dsl/workspace/plhamK/samples/InvestDiv/InvestDivFCNAgent.x10"
        double nav = this.getCashAmount$O();
        
        //#line 57 "/home/dsl/workspace/plhamK/samples/InvestDiv/InvestDivFCNAgent.x10"
        double tavAbs = 0.0;
        
        //#line 58 "/home/dsl/workspace/plhamK/samples/InvestDiv/InvestDivFCNAgent.x10"
        final x10.util.ListIterator market$24157 = ((x10.util.ListIterator<plham.Market>)
                                                     ((x10.util.List<plham.Market>)m).iterator());
        
        //#line 58 "/home/dsl/workspace/plhamK/samples/InvestDiv/InvestDivFCNAgent.x10"
        for (;
             true;
             ) {
            
            //#line 58 "/home/dsl/workspace/plhamK/samples/InvestDiv/InvestDivFCNAgent.x10"
            final boolean t$24158 = ((x10.util.ListIterator<plham.Market>)market$24157).hasNext$O();
            
            //#line 58 "/home/dsl/workspace/plhamK/samples/InvestDiv/InvestDivFCNAgent.x10"
            if (!(t$24158)) {
                
                //#line 58 "/home/dsl/workspace/plhamK/samples/InvestDiv/InvestDivFCNAgent.x10"
                break;
            }
            
            //#line 58 "/home/dsl/workspace/plhamK/samples/InvestDiv/InvestDivFCNAgent.x10"
            final plham.Market market$24130 = ((plham.Market)(((x10.util.ListIterator<plham.Market>)market$24157).next$G()));
            
            //#line 59 "/home/dsl/workspace/plhamK/samples/InvestDiv/InvestDivFCNAgent.x10"
            final double av$24131 = this.getAssetValue$O(((plham.Market)(market$24130)));
            
            //#line 60 "/home/dsl/workspace/plhamK/samples/InvestDiv/InvestDivFCNAgent.x10"
            final double t$24132 = nav;
            
            //#line 60 "/home/dsl/workspace/plhamK/samples/InvestDiv/InvestDivFCNAgent.x10"
            final double t$24133 = ((t$24132) + (((double)(av$24131))));
            
            //#line 60 "/home/dsl/workspace/plhamK/samples/InvestDiv/InvestDivFCNAgent.x10"
            nav = t$24133;
            
            //#line 61 "/home/dsl/workspace/plhamK/samples/InvestDiv/InvestDivFCNAgent.x10"
            final double t$24134 = tavAbs;
            
            //#line 61 "/home/dsl/workspace/plhamK/samples/InvestDiv/InvestDivFCNAgent.x10"
            final double t$24135 = java.lang.Math.abs(((double)(av$24131)));
            
            //#line 61 "/home/dsl/workspace/plhamK/samples/InvestDiv/InvestDivFCNAgent.x10"
            final double t$24136 = ((t$24134) + (((double)(t$24135))));
            
            //#line 61 "/home/dsl/workspace/plhamK/samples/InvestDiv/InvestDivFCNAgent.x10"
            tavAbs = t$24136;
        }
        
        //#line 64 "/home/dsl/workspace/plhamK/samples/InvestDiv/InvestDivFCNAgent.x10"
        final x10.util.ArrayList orders = ((x10.util.ArrayList)(new x10.util.ArrayList<plham.Order>((java.lang.System[]) null, plham.Order.$RTT).x10$util$ArrayList$$init$S()));
        
        //#line 67 "/home/dsl/workspace/plhamK/samples/InvestDiv/InvestDivFCNAgent.x10"
        final double t$24108 = tavAbs;
        
        //#line 67 "/home/dsl/workspace/plhamK/samples/InvestDiv/InvestDivFCNAgent.x10"
        final double t$24107 = nav;
        
        //#line 67 "/home/dsl/workspace/plhamK/samples/InvestDiv/InvestDivFCNAgent.x10"
        final double t$24109 = ((leverageRatio) * (((double)(t$24107))));
        
        //#line 67 "/home/dsl/workspace/plhamK/samples/InvestDiv/InvestDivFCNAgent.x10"
        final boolean t$24110 = ((t$24108) > (((double)(t$24109))));
        
        //#line 67 "/home/dsl/workspace/plhamK/samples/InvestDiv/InvestDivFCNAgent.x10"
        if (t$24110) {
            
            //#line 68 "/home/dsl/workspace/plhamK/samples/InvestDiv/InvestDivFCNAgent.x10"
            return orders;
        }
        
        //#line 72 "/home/dsl/workspace/plhamK/samples/InvestDiv/InvestDivFCNAgent.x10"
        final x10.util.List temp = super.submitOrders__0$1plham$Market$2(((x10.util.List)(m)));
        
        //#line 73 "/home/dsl/workspace/plhamK/samples/InvestDiv/InvestDivFCNAgent.x10"
        final x10.util.ListIterator order$24159 = ((x10.util.ListIterator<plham.Order>)
                                                    ((x10.util.List<plham.Order>)temp).iterator());
        
        //#line 73 "/home/dsl/workspace/plhamK/samples/InvestDiv/InvestDivFCNAgent.x10"
        for (;
             true;
             ) {
            
            //#line 73 "/home/dsl/workspace/plhamK/samples/InvestDiv/InvestDivFCNAgent.x10"
            final boolean t$24160 = ((x10.util.ListIterator<plham.Order>)order$24159).hasNext$O();
            
            //#line 73 "/home/dsl/workspace/plhamK/samples/InvestDiv/InvestDivFCNAgent.x10"
            if (!(t$24160)) {
                
                //#line 73 "/home/dsl/workspace/plhamK/samples/InvestDiv/InvestDivFCNAgent.x10"
                break;
            }
            
            //#line 73 "/home/dsl/workspace/plhamK/samples/InvestDiv/InvestDivFCNAgent.x10"
            final plham.Order order$24137 = ((plham.Order)(((x10.util.ListIterator<plham.Order>)order$24159).next$G()));
            
            //#line 74 "/home/dsl/workspace/plhamK/samples/InvestDiv/InvestDivFCNAgent.x10"
            final long id$24138 = order$24137.marketId;
            
            //#line 75 "/home/dsl/workspace/plhamK/samples/InvestDiv/InvestDivFCNAgent.x10"
            final plham.Market market$24139 = ((x10.util.Indexed<plham.Market>)markets).$apply$G((long)(id$24138));
            
            //#line 76 "/home/dsl/workspace/plhamK/samples/InvestDiv/InvestDivFCNAgent.x10"
            assert ((long) market$24139.id) == ((long) id$24138);
            
            //#line 78 "/home/dsl/workspace/plhamK/samples/InvestDiv/InvestDivFCNAgent.x10"
            final double t$24140 = this.getAssetValue$O(((plham.Market)(market$24139)));
            
            //#line 78 "/home/dsl/workspace/plhamK/samples/InvestDiv/InvestDivFCNAgent.x10"
            final double avAbs$24141 = java.lang.Math.abs(((double)(t$24140)));
            
            //#line 79 "/home/dsl/workspace/plhamK/samples/InvestDiv/InvestDivFCNAgent.x10"
            final double t$24142 = this.diversityRatio;
            
            //#line 79 "/home/dsl/workspace/plhamK/samples/InvestDiv/InvestDivFCNAgent.x10"
            final double t$24143 = nav;
            
            //#line 79 "/home/dsl/workspace/plhamK/samples/InvestDiv/InvestDivFCNAgent.x10"
            final double t$24144 = ((t$24142) * (((double)(t$24143))));
            
            //#line 79 "/home/dsl/workspace/plhamK/samples/InvestDiv/InvestDivFCNAgent.x10"
            final boolean t$24145 = ((avAbs$24141) <= (((double)(t$24144))));
            
            //#line 79 "/home/dsl/workspace/plhamK/samples/InvestDiv/InvestDivFCNAgent.x10"
            if (t$24145) {
                
                //#line 80 "/home/dsl/workspace/plhamK/samples/InvestDiv/InvestDivFCNAgent.x10"
                ((x10.util.ArrayList<plham.Order>)orders).add__0x10$util$ArrayList$$T$O(((plham.Order)(order$24137)));
            } else {
                
                //#line 82 "/home/dsl/workspace/plhamK/samples/InvestDiv/InvestDivFCNAgent.x10"
                final long timeLength$24146 = 10L;
                
                //#line 83 "/home/dsl/workspace/plhamK/samples/InvestDiv/InvestDivFCNAgent.x10"
                final double orderPrice$24147 = plham.Order.get$NO_PRICE();
                
                //#line 84 "/home/dsl/workspace/plhamK/samples/InvestDiv/InvestDivFCNAgent.x10"
                final long orderVolume$24148 = 1L;
                
                //#line 85 "/home/dsl/workspace/plhamK/samples/InvestDiv/InvestDivFCNAgent.x10"
                final long t$24149 = this.getAssetVolume$O(((plham.Market)(market$24139)));
                
                //#line 85 "/home/dsl/workspace/plhamK/samples/InvestDiv/InvestDivFCNAgent.x10"
                final boolean t$24150 = ((t$24149) < (((long)(0L))));
                
                //#line 85 "/home/dsl/workspace/plhamK/samples/InvestDiv/InvestDivFCNAgent.x10"
                if (t$24150) {
                    
                    //#line 86 "/home/dsl/workspace/plhamK/samples/InvestDiv/InvestDivFCNAgent.x10"
                    final plham.Order.Kind t$24151 = ((plham.Order.Kind)(plham.Order.get$KIND_BUY_MARKET_ORDER()));
                    
                    //#line 86 "/home/dsl/workspace/plhamK/samples/InvestDiv/InvestDivFCNAgent.x10"
                    final plham.Order t$24152 = ((plham.Order)(new plham.Order((java.lang.System[]) null).plham$Order$$init$S(((plham.Order.Kind)(t$24151)), ((plham.Agent)(this)), ((plham.Market)(market$24139)), ((double)(orderPrice$24147)), ((long)(orderVolume$24148)), ((long)(timeLength$24146)))));
                    
                    //#line 86 "/home/dsl/workspace/plhamK/samples/InvestDiv/InvestDivFCNAgent.x10"
                    ((x10.util.ArrayList<plham.Order>)orders).add__0x10$util$ArrayList$$T$O(((plham.Order)(t$24152)));
                }
                
                //#line 88 "/home/dsl/workspace/plhamK/samples/InvestDiv/InvestDivFCNAgent.x10"
                final long t$24153 = this.getAssetVolume$O(((plham.Market)(market$24139)));
                
                //#line 88 "/home/dsl/workspace/plhamK/samples/InvestDiv/InvestDivFCNAgent.x10"
                final boolean t$24154 = ((t$24153) > (((long)(0L))));
                
                //#line 88 "/home/dsl/workspace/plhamK/samples/InvestDiv/InvestDivFCNAgent.x10"
                if (t$24154) {
                    
                    //#line 89 "/home/dsl/workspace/plhamK/samples/InvestDiv/InvestDivFCNAgent.x10"
                    final plham.Order.Kind t$24155 = ((plham.Order.Kind)(plham.Order.get$KIND_SELL_MARKET_ORDER()));
                    
                    //#line 89 "/home/dsl/workspace/plhamK/samples/InvestDiv/InvestDivFCNAgent.x10"
                    final plham.Order t$24156 = ((plham.Order)(new plham.Order((java.lang.System[]) null).plham$Order$$init$S(((plham.Order.Kind)(t$24155)), ((plham.Agent)(this)), ((plham.Market)(market$24139)), ((double)(orderPrice$24147)), ((long)(orderVolume$24148)), ((long)(timeLength$24146)))));
                    
                    //#line 89 "/home/dsl/workspace/plhamK/samples/InvestDiv/InvestDivFCNAgent.x10"
                    ((x10.util.ArrayList<plham.Order>)orders).add__0x10$util$ArrayList$$T$O(((plham.Order)(t$24156)));
                }
            }
        }
        
        //#line 93 "/home/dsl/workspace/plhamK/samples/InvestDiv/InvestDivFCNAgent.x10"
        return orders;
    }
    
    
    //#line 13 "/home/dsl/workspace/plhamK/samples/InvestDiv/InvestDivFCNAgent.x10"
    final public samples.InvestDiv.InvestDivFCNAgent samples$InvestDiv$InvestDivFCNAgent$$this$samples$InvestDiv$InvestDivFCNAgent() {
        
        //#line 13 "/home/dsl/workspace/plhamK/samples/InvestDiv/InvestDivFCNAgent.x10"
        return samples.InvestDiv.InvestDivFCNAgent.this;
    }
    
    
    //#line 13 "/home/dsl/workspace/plhamK/samples/InvestDiv/InvestDivFCNAgent.x10"
    final public void __fieldInitializers_samples_InvestDiv_InvestDivFCNAgent() {
        
        //#line 13 "/home/dsl/workspace/plhamK/samples/InvestDiv/InvestDivFCNAgent.x10"
        this.leverageRatio = 0.0;
        
        //#line 13 "/home/dsl/workspace/plhamK/samples/InvestDiv/InvestDivFCNAgent.x10"
        this.diversityRatio = 0.0;
    }
    
    @x10.runtime.impl.java.X10Generated
    final public static class $Closure$14 extends x10.core.Ref implements x10.core.fun.Fun_0_4, x10.serialization.X10JavaSerializable
    {
        public static final x10.rtt.RuntimeType<$Closure$14> $RTT = 
            x10.rtt.StaticFunType.<$Closure$14> make($Closure$14.class,
                                                     new x10.rtt.Type[] {
                                                         x10.rtt.ParameterizedType.make(x10.core.fun.Fun_0_4.$RTT, x10.rtt.Types.LONG, x10.rtt.Types.STRING, x10.util.Random.$RTT, cassia.util.JSON.Value.$RTT, samples.InvestDiv.InvestDivFCNAgent.$RTT)
                                                     });
        
        public x10.rtt.RuntimeType<?> $getRTT() { return $RTT; }
        
        public x10.rtt.Type<?> $getParam(int i) { return null; }
        
        private Object writeReplace() throws java.io.ObjectStreamException {
            return new x10.serialization.SerializationProxy(this);
        }
        
        public static x10.serialization.X10JavaSerializable $_deserialize_body(samples.InvestDiv.InvestDivFCNAgent.$Closure$14 $_obj, x10.serialization.X10JavaDeserializer $deserializer) throws java.io.IOException {
            if (x10.runtime.impl.java.Runtime.TRACE_SER) { x10.runtime.impl.java.Runtime.printTraceMessage("X10JavaSerializable: $_deserialize_body() of " + $Closure$14.class + " calling"); } 
            $_obj.sim = $deserializer.readObject();
            return $_obj;
        }
        
        public static x10.serialization.X10JavaSerializable $_deserializer(x10.serialization.X10JavaDeserializer $deserializer) throws java.io.IOException {
            samples.InvestDiv.InvestDivFCNAgent.$Closure$14 $_obj = new samples.InvestDiv.InvestDivFCNAgent.$Closure$14((java.lang.System[]) null);
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
        
        
    
        
        public samples.InvestDiv.InvestDivFCNAgent $apply(final long id, final java.lang.String name, final x10.util.Random random, final cassia.util.JSON.Value json) {
            
            //#line 34 "/home/dsl/workspace/plhamK/samples/InvestDiv/InvestDivFCNAgent.x10"
            final samples.InvestDiv.InvestDivFCNAgent t$24090 = ((samples.InvestDiv.InvestDivFCNAgent)(new samples.InvestDiv.InvestDivFCNAgent((java.lang.System[]) null).samples$InvestDiv$InvestDivFCNAgent$$init$S(((long)(id)), ((java.lang.String)(name)), ((x10.util.Random)(random)))));
            
            //#line 34 "/home/dsl/workspace/plhamK/samples/InvestDiv/InvestDivFCNAgent.x10"
            final samples.InvestDiv.InvestDivFCNAgent t$24091 = t$24090.setup(((cassia.util.JSON.Value)(json)), ((plham.main.Simulator)(this.sim)));
            
            //#line 34 "/home/dsl/workspace/plhamK/samples/InvestDiv/InvestDivFCNAgent.x10"
            return t$24091;
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
    
    public x10.util.List plham$agent$FCNAgent$submitOrders$S__0$1plham$Market$2(final x10.util.List a0) {
        return super.submitOrders__0$1plham$Market$2(((x10.util.List)(a0)));
    }
}

