package samples.CancelTest;


@x10.runtime.impl.java.X10Generated
public class CancelFCNAgent extends plham.agent.FCNAgent implements x10.serialization.X10JavaSerializable
{
    public static final x10.rtt.RuntimeType<CancelFCNAgent> $RTT = 
        x10.rtt.NamedType.<CancelFCNAgent> make("samples.CancelTest.CancelFCNAgent",
                                                CancelFCNAgent.class,
                                                new x10.rtt.Type[] {
                                                    plham.agent.FCNAgent.$RTT
                                                });
    
    public x10.rtt.RuntimeType<?> $getRTT() { return $RTT; }
    
    public x10.rtt.Type<?> $getParam(int i) { return null; }
    
    private Object writeReplace() throws java.io.ObjectStreamException {
        return new x10.serialization.SerializationProxy(this);
    }
    
    public static x10.serialization.X10JavaSerializable $_deserialize_body(samples.CancelTest.CancelFCNAgent $_obj, x10.serialization.X10JavaDeserializer $deserializer) throws java.io.IOException {
        if (x10.runtime.impl.java.Runtime.TRACE_SER) { x10.runtime.impl.java.Runtime.printTraceMessage("X10JavaSerializable: $_deserialize_body() of " + CancelFCNAgent.class + " calling"); } 
        plham.agent.FCNAgent.$_deserialize_body($_obj, $deserializer);
        $_obj.orderId = $deserializer.readLong();
        return $_obj;
    }
    
    public static x10.serialization.X10JavaSerializable $_deserializer(x10.serialization.X10JavaDeserializer $deserializer) throws java.io.IOException {
        samples.CancelTest.CancelFCNAgent $_obj = new samples.CancelTest.CancelFCNAgent((java.lang.System[]) null);
        $deserializer.record_reference($_obj);
        return $_deserialize_body($_obj, $deserializer);
    }
    
    public void $_serialize(x10.serialization.X10JavaSerializer $serializer) throws java.io.IOException {
        super.$_serialize($serializer);
        $serializer.write(this.orderId);
        
    }
    
    // constructor just for allocation
    public CancelFCNAgent(final java.lang.System[] $dummy) {
        super($dummy);
        
    }
    
    

    
    //#line 16 "/home/dsl/workspace/plhamK/samples/CancelTest/CancelFCNAgent.x10"
    public long orderId;
    
    
    //#line 17 "/home/dsl/workspace/plhamK/samples/CancelTest/CancelFCNAgent.x10"
    public long nextOrderId$O() {
        
        //#line 18 "/home/dsl/workspace/plhamK/samples/CancelTest/CancelFCNAgent.x10"
        final long t$21209 = this.orderId;
        
        //#line 18 "/home/dsl/workspace/plhamK/samples/CancelTest/CancelFCNAgent.x10"
        final long t$21210 = ((t$21209) + (((long)(1L))));
        
        //#line 18 "/home/dsl/workspace/plhamK/samples/CancelTest/CancelFCNAgent.x10"
        final long t$21211 = this.orderId = t$21210;
        
        //#line 18 "/home/dsl/workspace/plhamK/samples/CancelTest/CancelFCNAgent.x10"
        final long t$21212 = ((t$21211) - (((long)(1L))));
        
        //#line 18 "/home/dsl/workspace/plhamK/samples/CancelTest/CancelFCNAgent.x10"
        return t$21212;
    }
    
    
    //#line 21 "/home/dsl/workspace/plhamK/samples/CancelTest/CancelFCNAgent.x10"
    public x10.util.List submitOrders(final plham.Market market) {
        
        //#line 22 "/home/dsl/workspace/plhamK/samples/CancelTest/CancelFCNAgent.x10"
        final x10.util.List orders = super.submitOrders(((plham.Market)(market)));
        
        //#line 23 "/home/dsl/workspace/plhamK/samples/CancelTest/CancelFCNAgent.x10"
        final long t$21213 = ((x10.util.Container<plham.Order>)orders).size$O();
        
        //#line 23 "/home/dsl/workspace/plhamK/samples/CancelTest/CancelFCNAgent.x10"
        final boolean t$21214 = ((long) t$21213) == ((long) 0L);
        
        //#line 23 "/home/dsl/workspace/plhamK/samples/CancelTest/CancelFCNAgent.x10"
        if (t$21214) {
            
            //#line 24 "/home/dsl/workspace/plhamK/samples/CancelTest/CancelFCNAgent.x10"
            return orders;
        }
        
        //#line 27 "/home/dsl/workspace/plhamK/samples/CancelTest/CancelFCNAgent.x10"
        final double CANCEL_RATE = 0.3;
        
        //#line 28 "/home/dsl/workspace/plhamK/samples/CancelTest/CancelFCNAgent.x10"
        final x10.util.Collection t$21232 = ((x10.util.Collection<plham.Order>)
                                              ((x10.util.Collection<plham.Order>)orders).clone());
        
        //#line 28 "/home/dsl/workspace/plhamK/samples/CancelTest/CancelFCNAgent.x10"
        final x10.lang.Iterator o$21233 = ((x10.lang.Iterator<plham.Order>)
                                            ((x10.lang.Iterable<plham.Order>)t$21232).iterator());
        
        //#line 28 "/home/dsl/workspace/plhamK/samples/CancelTest/CancelFCNAgent.x10"
        for (;
             true;
             ) {
            
            //#line 28 "/home/dsl/workspace/plhamK/samples/CancelTest/CancelFCNAgent.x10"
            final boolean t$21234 = ((x10.lang.Iterator<plham.Order>)o$21233).hasNext$O();
            
            //#line 28 "/home/dsl/workspace/plhamK/samples/CancelTest/CancelFCNAgent.x10"
            if (!(t$21234)) {
                
                //#line 28 "/home/dsl/workspace/plhamK/samples/CancelTest/CancelFCNAgent.x10"
                break;
            }
            
            //#line 28 "/home/dsl/workspace/plhamK/samples/CancelTest/CancelFCNAgent.x10"
            final plham.Order o$21227 = ((plham.Order)(((x10.lang.Iterator<plham.Order>)o$21233).next$G()));
            
            //#line 29 "/home/dsl/workspace/plhamK/samples/CancelTest/CancelFCNAgent.x10"
            final x10.util.Random t$21228 = this.getRandom();
            
            //#line 29 "/home/dsl/workspace/plhamK/samples/CancelTest/CancelFCNAgent.x10"
            final double t$21229 = t$21228.nextDouble$O();
            
            //#line 29 "/home/dsl/workspace/plhamK/samples/CancelTest/CancelFCNAgent.x10"
            final boolean t$21230 = ((t$21229) < (((double)(CANCEL_RATE))));
            
            //#line 29 "/home/dsl/workspace/plhamK/samples/CancelTest/CancelFCNAgent.x10"
            if (t$21230) {
                
                //#line 30 "/home/dsl/workspace/plhamK/samples/CancelTest/CancelFCNAgent.x10"
                final plham.Cancel t$21231 = ((plham.Cancel)(new plham.Cancel((java.lang.System[]) null).plham$Cancel$$init$S(((plham.Order)(o$21227)))));
                
                //#line 30 "/home/dsl/workspace/plhamK/samples/CancelTest/CancelFCNAgent.x10"
                ((x10.util.Collection<plham.Order>)orders).add$Z(((plham.Order)(t$21231)), plham.Order.$RTT);
            }
        }
        
        //#line 33 "/home/dsl/workspace/plhamK/samples/CancelTest/CancelFCNAgent.x10"
        return orders;
    }
    
    
    //#line 36 "/home/dsl/workspace/plhamK/samples/CancelTest/CancelFCNAgent.x10"
    // creation method for java code (1-phase java constructor)
    public CancelFCNAgent(final long id, final java.lang.String name, final x10.util.Random random) {
        this((java.lang.System[]) null);
        samples$CancelTest$CancelFCNAgent$$init$S(id, name, random);
    }
    
    // constructor for non-virtual call
    final public samples.CancelTest.CancelFCNAgent samples$CancelTest$CancelFCNAgent$$init$S(final long id, final java.lang.String name, final x10.util.Random random) {
         {
            
            //#line 36 "/home/dsl/workspace/plhamK/samples/CancelTest/CancelFCNAgent.x10"
            /*super.*/plham$agent$FCNAgent$$init$S(((long)(id)), ((java.lang.String)(name)), ((x10.util.Random)(random)));
            
            //#line 36 "/home/dsl/workspace/plhamK/samples/CancelTest/CancelFCNAgent.x10"
            
            
            //#line 12 "/home/dsl/workspace/plhamK/samples/CancelTest/CancelFCNAgent.x10"
            this.__fieldInitializers_samples_CancelTest_CancelFCNAgent();
        }
        return this;
    }
    
    
    
    //#line 38 "/home/dsl/workspace/plhamK/samples/CancelTest/CancelFCNAgent.x10"
    public samples.CancelTest.CancelFCNAgent setup(final cassia.util.JSON.Value json, final plham.main.Simulator sim) {
        
        //#line 39 "/home/dsl/workspace/plhamK/samples/CancelTest/CancelFCNAgent.x10"
        final plham.agent.FCNAgent t$21222 = super.setup(((cassia.util.JSON.Value)(json)), ((plham.main.Simulator)(sim)));
        
        //#line 39 "/home/dsl/workspace/plhamK/samples/CancelTest/CancelFCNAgent.x10"
        final samples.CancelTest.CancelFCNAgent t$21223 = x10.rtt.Types.<samples.CancelTest.CancelFCNAgent> cast(t$21222,samples.CancelTest.CancelFCNAgent.$RTT);
        
        //#line 39 "/home/dsl/workspace/plhamK/samples/CancelTest/CancelFCNAgent.x10"
        return t$21223;
    }
    
    
    //#line 42 "/home/dsl/workspace/plhamK/samples/CancelTest/CancelFCNAgent.x10"
    public static void register(final plham.main.Simulator sim) {
        
        //#line 43 "/home/dsl/workspace/plhamK/samples/CancelTest/CancelFCNAgent.x10"
        final java.lang.String className = ((java.lang.String)("CancelFCNAgent"));
        
        //#line 45 "/home/dsl/workspace/plhamK/samples/CancelTest/CancelFCNAgent.x10"
        final x10.core.fun.Fun_0_4 t$21226 = ((x10.core.fun.Fun_0_4)(new samples.CancelTest.CancelFCNAgent.$Closure$7(sim)));
        
        //#line 44 "/home/dsl/workspace/plhamK/samples/CancelTest/CancelFCNAgent.x10"
        sim.addAgentInitializer__1$1x10$lang$Long$3x10$lang$String$3x10$util$Random$3cassia$util$JSON$Value$3plham$Agent$2(((java.lang.String)(className)), ((x10.core.fun.Fun_0_4)(t$21226)));
    }
    
    
    //#line 12 "/home/dsl/workspace/plhamK/samples/CancelTest/CancelFCNAgent.x10"
    final public samples.CancelTest.CancelFCNAgent samples$CancelTest$CancelFCNAgent$$this$samples$CancelTest$CancelFCNAgent() {
        
        //#line 12 "/home/dsl/workspace/plhamK/samples/CancelTest/CancelFCNAgent.x10"
        return samples.CancelTest.CancelFCNAgent.this;
    }
    
    
    //#line 12 "/home/dsl/workspace/plhamK/samples/CancelTest/CancelFCNAgent.x10"
    final public void __fieldInitializers_samples_CancelTest_CancelFCNAgent() {
        
        //#line 12 "/home/dsl/workspace/plhamK/samples/CancelTest/CancelFCNAgent.x10"
        this.orderId = 1L;
    }
    
    @x10.runtime.impl.java.X10Generated
    final public static class $Closure$7 extends x10.core.Ref implements x10.core.fun.Fun_0_4, x10.serialization.X10JavaSerializable
    {
        public static final x10.rtt.RuntimeType<$Closure$7> $RTT = 
            x10.rtt.StaticFunType.<$Closure$7> make($Closure$7.class,
                                                    new x10.rtt.Type[] {
                                                        x10.rtt.ParameterizedType.make(x10.core.fun.Fun_0_4.$RTT, x10.rtt.Types.LONG, x10.rtt.Types.STRING, x10.util.Random.$RTT, cassia.util.JSON.Value.$RTT, samples.CancelTest.CancelFCNAgent.$RTT)
                                                    });
        
        public x10.rtt.RuntimeType<?> $getRTT() { return $RTT; }
        
        public x10.rtt.Type<?> $getParam(int i) { return null; }
        
        private Object writeReplace() throws java.io.ObjectStreamException {
            return new x10.serialization.SerializationProxy(this);
        }
        
        public static x10.serialization.X10JavaSerializable $_deserialize_body(samples.CancelTest.CancelFCNAgent.$Closure$7 $_obj, x10.serialization.X10JavaDeserializer $deserializer) throws java.io.IOException {
            if (x10.runtime.impl.java.Runtime.TRACE_SER) { x10.runtime.impl.java.Runtime.printTraceMessage("X10JavaSerializable: $_deserialize_body() of " + $Closure$7.class + " calling"); } 
            $_obj.sim = $deserializer.readObject();
            return $_obj;
        }
        
        public static x10.serialization.X10JavaSerializable $_deserializer(x10.serialization.X10JavaDeserializer $deserializer) throws java.io.IOException {
            samples.CancelTest.CancelFCNAgent.$Closure$7 $_obj = new samples.CancelTest.CancelFCNAgent.$Closure$7((java.lang.System[]) null);
            $deserializer.record_reference($_obj);
            return $_deserialize_body($_obj, $deserializer);
        }
        
        public void $_serialize(x10.serialization.X10JavaSerializer $serializer) throws java.io.IOException {
            $serializer.write(this.sim);
            
        }
        
        // constructor just for allocation
        public $Closure$7(final java.lang.System[] $dummy) {
            
        }
        
        // dispatcher for method abstract public (Z1,Z2,Z3,Z4)=>U.operator()(a1:Z1, a2:Z2, a3:Z3, a4:Z4):U
        public java.lang.Object $apply(final java.lang.Object a1, final x10.rtt.Type t1, final java.lang.Object a2, final x10.rtt.Type t2, final java.lang.Object a3, final x10.rtt.Type t3, final java.lang.Object a4, final x10.rtt.Type t4) {
            return $apply(x10.core.Long.$unbox(a1), (java.lang.String)a2, (x10.util.Random)a3, (cassia.util.JSON.Value)a4);
            
        }
        
        
    
        
        public samples.CancelTest.CancelFCNAgent $apply(final long id, final java.lang.String name, final x10.util.Random random, final cassia.util.JSON.Value json) {
            
            //#line 51 "/home/dsl/workspace/plhamK/samples/CancelTest/CancelFCNAgent.x10"
            final samples.CancelTest.CancelFCNAgent t$21224 = ((samples.CancelTest.CancelFCNAgent)(new samples.CancelTest.CancelFCNAgent((java.lang.System[]) null).samples$CancelTest$CancelFCNAgent$$init$S(((long)(id)), ((java.lang.String)(name)), ((x10.util.Random)(random)))));
            
            //#line 51 "/home/dsl/workspace/plhamK/samples/CancelTest/CancelFCNAgent.x10"
            final samples.CancelTest.CancelFCNAgent t$21225 = t$21224.setup(((cassia.util.JSON.Value)(json)), ((plham.main.Simulator)(this.sim)));
            
            //#line 51 "/home/dsl/workspace/plhamK/samples/CancelTest/CancelFCNAgent.x10"
            return t$21225;
        }
        
        public plham.main.Simulator sim;
        
        public $Closure$7(final plham.main.Simulator sim) {
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

