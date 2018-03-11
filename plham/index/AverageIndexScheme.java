package plham.index;



abstract public class AverageIndexScheme extends plham.index.IndexScheme implements x10.serialization.X10JavaSerializable
{
    public static final x10.rtt.RuntimeType<AverageIndexScheme> $RTT = 
        x10.rtt.NamedType.<AverageIndexScheme> make("plham.index.AverageIndexScheme",
                                                    AverageIndexScheme.class,
                                                    new x10.rtt.Type[] {
                                                        plham.index.IndexScheme.$RTT
                                                    });
    
    public x10.rtt.RuntimeType<?> $getRTT() { return $RTT; }
    
    public x10.rtt.Type<?> $getParam(int i) { return null; }
    
    public static x10.serialization.X10JavaSerializable $_deserialize_body(plham.index.AverageIndexScheme $_obj, x10.serialization.X10JavaDeserializer $deserializer) throws java.io.IOException {
        if (x10.runtime.impl.java.Runtime.TRACE_SER) { x10.runtime.impl.java.Runtime.printTraceMessage("X10JavaSerializable: $_deserialize_body() of " + AverageIndexScheme.class + " calling"); } 
        plham.index.IndexScheme.$_deserialize_body($_obj, $deserializer);
        $_obj.get = $deserializer.readObject();
        $_obj.indexDivisor = $deserializer.readDouble();
        return $_obj;
    }
    
    public static x10.serialization.X10JavaSerializable $_deserializer(x10.serialization.X10JavaDeserializer $deserializer) throws java.io.IOException {
        return null;
    }
    
    public void $_serialize(x10.serialization.X10JavaSerializer $serializer) throws java.io.IOException {
        super.$_serialize($serializer);
        $serializer.write(this.get);
        $serializer.write(this.indexDivisor);
        
    }
    
    // constructor just for allocation
    public AverageIndexScheme(final java.lang.System[] $dummy) {
        super($dummy);
        
    }
    
    // synthetic type for parameter mangling
    public static final class __0$1plham$Market$3x10$lang$Double$2 {}
    

    
    //#line 7 "/home/dsl/workspace/plhamK/plham/index/AverageIndexScheme.x10"
    private static x10.core.fun.Fun_0_1<plham.Market,x10.core.Double> MARKET_PRICE;
    
    //#line 8 "/home/dsl/workspace/plhamK/plham/index/AverageIndexScheme.x10"
    private static x10.core.fun.Fun_0_1<plham.Market,x10.core.Double> FUNDAMENTAL_PRICE;
    
    //#line 10 "/home/dsl/workspace/plhamK/plham/index/AverageIndexScheme.x10"
    public x10.core.fun.Fun_0_1<plham.Market,x10.core.Double> get;
    
    //#line 11 "/home/dsl/workspace/plhamK/plham/index/AverageIndexScheme.x10"
    public double indexDivisor;
    
    
    //#line 13 "/home/dsl/workspace/plhamK/plham/index/AverageIndexScheme.x10"
    
    // constructor for non-virtual call
    final public plham.index.AverageIndexScheme plham$index$AverageIndexScheme$$init$S(final x10.core.fun.Fun_0_1<plham.Market,x10.core.Double> get, __0$1plham$Market$3x10$lang$Double$2 $dummy) {
         {
            
            //#line 13 "/home/dsl/workspace/plhamK/plham/index/AverageIndexScheme.x10"
            /*super.*/plham$index$IndexScheme$$init$S();
            
            //#line 13 "/home/dsl/workspace/plhamK/plham/index/AverageIndexScheme.x10"
            
            
            //#line 5 "/home/dsl/workspace/plhamK/plham/index/AverageIndexScheme.x10"
            this.__fieldInitializers_plham_index_AverageIndexScheme();
            
            //#line 14 "/home/dsl/workspace/plhamK/plham/index/AverageIndexScheme.x10"
            this.get = ((get));
            
            //#line 15 "/home/dsl/workspace/plhamK/plham/index/AverageIndexScheme.x10"
            this.indexDivisor = 1.0;
        }
        return this;
    }
    
    
    
    //#line 18 "/home/dsl/workspace/plhamK/plham/index/AverageIndexScheme.x10"
    public double getIndex__0$1plham$Market$2$O(final x10.util.Indexed markets) {
        
        //#line 19 "/home/dsl/workspace/plhamK/plham/index/AverageIndexScheme.x10"
        double sum = 0.0;
        
        //#line 20 "/home/dsl/workspace/plhamK/plham/index/AverageIndexScheme.x10"
        final x10.lang.Iterator market$32065 = (((x10.lang.Iterable<plham.Market>)markets).iterator());
        
        //#line 20 "/home/dsl/workspace/plhamK/plham/index/AverageIndexScheme.x10"
        for (;
             true;
             ) {
            
            //#line 20 "/home/dsl/workspace/plhamK/plham/index/AverageIndexScheme.x10"
            final boolean t$32066 = ((x10.lang.Iterator<plham.Market>)market$32065).hasNext$O();
            
            //#line 20 "/home/dsl/workspace/plhamK/plham/index/AverageIndexScheme.x10"
            if (!(t$32066)) {
                
                //#line 20 "/home/dsl/workspace/plhamK/plham/index/AverageIndexScheme.x10"
                break;
            }
            
            //#line 20 "/home/dsl/workspace/plhamK/plham/index/AverageIndexScheme.x10"
            final plham.Market market$32059 = ((((x10.lang.Iterator<plham.Market>)market$32065).next$G()));
            
            //#line 21 "/home/dsl/workspace/plhamK/plham/index/AverageIndexScheme.x10"
            final double t$32060 = sum;
            
            //#line 21 "/home/dsl/workspace/plhamK/plham/index/AverageIndexScheme.x10"
            final double t$32061 = this.getWeight$O(((market$32059)));
            
            //#line 21 "/home/dsl/workspace/plhamK/plham/index/AverageIndexScheme.x10"
            final double t$32062 = this.getPrice$O(((market$32059)));
            
            //#line 21 "/home/dsl/workspace/plhamK/plham/index/AverageIndexScheme.x10"
            final double t$32063 = ((t$32061) * (((t$32062))));
            
            //#line 21 "/home/dsl/workspace/plhamK/plham/index/AverageIndexScheme.x10"
            final double t$32064 = ((t$32060) + (((t$32063))));
            
            //#line 21 "/home/dsl/workspace/plhamK/plham/index/AverageIndexScheme.x10"
            sum = t$32064;
        }
        
        //#line 23 "/home/dsl/workspace/plhamK/plham/index/AverageIndexScheme.x10"
        final double t$32040 = sum;
        
        //#line 23 "/home/dsl/workspace/plhamK/plham/index/AverageIndexScheme.x10"
        final long t$32039 = ((x10.util.Container<plham.Market>)markets).size$O();
        
        //#line 23 "/home/dsl/workspace/plhamK/plham/index/AverageIndexScheme.x10"
        final double t$32041 = ((((t$32039))));
        
        //#line 23 "/home/dsl/workspace/plhamK/plham/index/AverageIndexScheme.x10"
        final double meanPrice = ((t$32040) / (((t$32041))));
        
        //#line 24 "/home/dsl/workspace/plhamK/plham/index/AverageIndexScheme.x10"
        final double t$32042 = this.indexDivisor;
        
        //#line 24 "/home/dsl/workspace/plhamK/plham/index/AverageIndexScheme.x10"
        final double t$32043 = ((meanPrice) / (((t$32042))));
        
        //#line 24 "/home/dsl/workspace/plhamK/plham/index/AverageIndexScheme.x10"
        return t$32043;
    }
    
    
    //#line 27 "/home/dsl/workspace/plhamK/plham/index/AverageIndexScheme.x10"
    public double getIndex__0$1plham$Market$2__1$1x10$lang$Long$2$O(final x10.util.Indexed markets, final x10.util.Indexed components) {
        
        //#line 28 "/home/dsl/workspace/plhamK/plham/index/AverageIndexScheme.x10"
        double sum = 0.0;
        
        //#line 29 "/home/dsl/workspace/plhamK/plham/index/AverageIndexScheme.x10"
        final x10.lang.Iterator i$32074 = (((x10.lang.Iterable<x10.core.Long>)components).iterator());
        
        //#line 29 "/home/dsl/workspace/plhamK/plham/index/AverageIndexScheme.x10"
        for (;
             true;
             ) {
            
            //#line 29 "/home/dsl/workspace/plhamK/plham/index/AverageIndexScheme.x10"
            final boolean t$32075 = ((x10.lang.Iterator<x10.core.Long>)i$32074).hasNext$O();
            
            //#line 29 "/home/dsl/workspace/plhamK/plham/index/AverageIndexScheme.x10"
            if (!(t$32075)) {
                
                //#line 29 "/home/dsl/workspace/plhamK/plham/index/AverageIndexScheme.x10"
                break;
            }
            
            //#line 29 "/home/dsl/workspace/plhamK/plham/index/AverageIndexScheme.x10"
            final long i$32067 = x10.core.Long.$unbox(((x10.lang.Iterator<x10.core.Long>)i$32074).next$G());
            
            //#line 30 "/home/dsl/workspace/plhamK/plham/index/AverageIndexScheme.x10"
            final plham.Market market$32068 = ((x10.util.Indexed<plham.Market>)markets).$apply$G((i$32067));
            
            //#line 31 "/home/dsl/workspace/plhamK/plham/index/AverageIndexScheme.x10"
            final double t$32069 = sum;
            
            //#line 31 "/home/dsl/workspace/plhamK/plham/index/AverageIndexScheme.x10"
            final double t$32070 = this.getWeight$O(((market$32068)));
            
            //#line 31 "/home/dsl/workspace/plhamK/plham/index/AverageIndexScheme.x10"
            final double t$32071 = this.getPrice$O(((market$32068)));
            
            //#line 31 "/home/dsl/workspace/plhamK/plham/index/AverageIndexScheme.x10"
            final double t$32072 = ((t$32070) * (((t$32071))));
            
            //#line 31 "/home/dsl/workspace/plhamK/plham/index/AverageIndexScheme.x10"
            final double t$32073 = ((t$32069) + (((t$32072))));
            
            //#line 31 "/home/dsl/workspace/plhamK/plham/index/AverageIndexScheme.x10"
            sum = t$32073;
        }
        
        //#line 33 "/home/dsl/workspace/plhamK/plham/index/AverageIndexScheme.x10"
        final double t$32052 = sum;
        
        //#line 33 "/home/dsl/workspace/plhamK/plham/index/AverageIndexScheme.x10"
        final long t$32051 = ((x10.util.Container<x10.core.Long>)components).size$O();
        
        //#line 33 "/home/dsl/workspace/plhamK/plham/index/AverageIndexScheme.x10"
        final double t$32053 = ((((t$32051))));
        
        //#line 33 "/home/dsl/workspace/plhamK/plham/index/AverageIndexScheme.x10"
        final double meanPrice = ((t$32052) / (((t$32053))));
        
        //#line 34 "/home/dsl/workspace/plhamK/plham/index/AverageIndexScheme.x10"
        final double t$32054 = this.indexDivisor;
        
        //#line 34 "/home/dsl/workspace/plhamK/plham/index/AverageIndexScheme.x10"
        final double t$32055 = ((meanPrice) / (((t$32054))));
        
        //#line 34 "/home/dsl/workspace/plhamK/plham/index/AverageIndexScheme.x10"
        return t$32055;
    }
    
    
    //#line 37 "/home/dsl/workspace/plhamK/plham/index/AverageIndexScheme.x10"
    public double getPrice$O(final plham.Market market) {
        
        //#line 38 "/home/dsl/workspace/plhamK/plham/index/AverageIndexScheme.x10"
        final x10.core.fun.Fun_0_1 t$32056 = ((this.get));
        
        //#line 38 "/home/dsl/workspace/plhamK/plham/index/AverageIndexScheme.x10"
        final double t$32057 = x10.core.Double.$unbox(((x10.core.fun.Fun_0_1<plham.Market,x10.core.Double>)t$32056).$apply(market, plham.Market.$RTT));
        
        //#line 38 "/home/dsl/workspace/plhamK/plham/index/AverageIndexScheme.x10"
        return t$32057;
    }
    
    
    //#line 41 "/home/dsl/workspace/plhamK/plham/index/AverageIndexScheme.x10"
    public void setIndexDivisor(final double initialPrice, final double basePrice) {
        
        //#line 42 "/home/dsl/workspace/plhamK/plham/index/AverageIndexScheme.x10"
        final double t$32058 = ((basePrice) / (((initialPrice))));
        
        //#line 42 "/home/dsl/workspace/plhamK/plham/index/AverageIndexScheme.x10"
        this.indexDivisor = t$32058;
    }
    
    
    //#line 5 "/home/dsl/workspace/plhamK/plham/index/AverageIndexScheme.x10"
    final public plham.index.AverageIndexScheme plham$index$AverageIndexScheme$$this$plham$index$AverageIndexScheme() {
        
        //#line 5 "/home/dsl/workspace/plhamK/plham/index/AverageIndexScheme.x10"
        return plham.index.AverageIndexScheme.this;
    }
    
    
    //#line 5 "/home/dsl/workspace/plhamK/plham/index/AverageIndexScheme.x10"
    final public void __fieldInitializers_plham_index_AverageIndexScheme() {
        
        //#line 5 "/home/dsl/workspace/plhamK/plham/index/AverageIndexScheme.x10"
        this.get = null;
        
        //#line 5 "/home/dsl/workspace/plhamK/plham/index/AverageIndexScheme.x10"
        this.indexDivisor = 0.0;
    }
    
    final private static x10.core.concurrent.AtomicInteger initStatus$FUNDAMENTAL_PRICE = new x10.core.concurrent.AtomicInteger(x10.runtime.impl.java.InitDispatcher.UNINITIALIZED);
    private static x10.lang.ExceptionInInitializer exception$FUNDAMENTAL_PRICE;
    final private static x10.core.concurrent.AtomicInteger initStatus$MARKET_PRICE = new x10.core.concurrent.AtomicInteger(x10.runtime.impl.java.InitDispatcher.UNINITIALIZED);
    private static x10.lang.ExceptionInInitializer exception$MARKET_PRICE;
    
    public static x10.core.fun.Fun_0_1 get$MARKET_PRICE() {
        if ((plham.index.AverageIndexScheme.initStatus$MARKET_PRICE.get()) == (x10.runtime.impl.java.InitDispatcher.INITIALIZED)) {
            return plham.index.AverageIndexScheme.MARKET_PRICE;
        }
        if ((plham.index.AverageIndexScheme.initStatus$MARKET_PRICE.get()) == (x10.runtime.impl.java.InitDispatcher.EXCEPTION_RAISED)) {
            if ((x10.runtime.impl.java.InitDispatcher.TRACE_STATIC_INIT) == (true)) {
                x10.runtime.impl.java.InitDispatcher.printStaticInitMessage((("Rethrowing ExceptionInInitializer for field: plham.index.AverageIndexScheme.MARKET_PRICE")));
            }
            throw plham.index.AverageIndexScheme.exception$MARKET_PRICE;
        }
        if (plham.index.AverageIndexScheme.initStatus$MARKET_PRICE.compareAndSet((x10.runtime.impl.java.InitDispatcher.UNINITIALIZED), (x10.runtime.impl.java.InitDispatcher.INITIALIZING))) {
            try {{
                plham.index.AverageIndexScheme.MARKET_PRICE = ((new plham.index.AverageIndexScheme.$Closure$36()));
            }}catch (java.lang.Throwable exc$32076) {
                plham.index.AverageIndexScheme.exception$MARKET_PRICE = new x10.lang.ExceptionInInitializer(exc$32076);
                plham.index.AverageIndexScheme.initStatus$MARKET_PRICE.set((x10.runtime.impl.java.InitDispatcher.EXCEPTION_RAISED));
                x10.runtime.impl.java.InitDispatcher.lockInitialized();
                x10.runtime.impl.java.InitDispatcher.notifyInitialized();
                throw plham.index.AverageIndexScheme.exception$MARKET_PRICE;
            }
            if ((x10.runtime.impl.java.InitDispatcher.TRACE_STATIC_INIT) == (true)) {
                x10.runtime.impl.java.InitDispatcher.printStaticInitMessage((("Doing static initialization for field: plham.index.AverageIndexScheme.MARKET_PRICE")));
            }
            plham.index.AverageIndexScheme.initStatus$MARKET_PRICE.set((x10.runtime.impl.java.InitDispatcher.INITIALIZED));
            x10.runtime.impl.java.InitDispatcher.lockInitialized();
            x10.runtime.impl.java.InitDispatcher.notifyInitialized();
        } else {
            if (plham.index.AverageIndexScheme.initStatus$MARKET_PRICE.get() < x10.runtime.impl.java.InitDispatcher.INITIALIZED) {
                x10.runtime.impl.java.InitDispatcher.lockInitialized();
                while (plham.index.AverageIndexScheme.initStatus$MARKET_PRICE.get() < x10.runtime.impl.java.InitDispatcher.INITIALIZED) {
                    x10.runtime.impl.java.InitDispatcher.awaitInitialized();
                }
                x10.runtime.impl.java.InitDispatcher.unlockInitialized();
                if ((plham.index.AverageIndexScheme.initStatus$MARKET_PRICE.get()) == (x10.runtime.impl.java.InitDispatcher.EXCEPTION_RAISED)) {
                    if ((x10.runtime.impl.java.InitDispatcher.TRACE_STATIC_INIT) == (true)) {
                        x10.runtime.impl.java.InitDispatcher.printStaticInitMessage((("Rethrowing ExceptionInInitializer for field: plham.index.AverageIndexScheme.MARKET_PRICE")));
                    }
                    throw plham.index.AverageIndexScheme.exception$MARKET_PRICE;
                }
            }
        }
        return plham.index.AverageIndexScheme.MARKET_PRICE;
    }
    
    public static x10.core.fun.Fun_0_1 get$FUNDAMENTAL_PRICE() {
        if ((plham.index.AverageIndexScheme.initStatus$FUNDAMENTAL_PRICE.get()) == (x10.runtime.impl.java.InitDispatcher.INITIALIZED)) {
            return plham.index.AverageIndexScheme.FUNDAMENTAL_PRICE;
        }
        if ((plham.index.AverageIndexScheme.initStatus$FUNDAMENTAL_PRICE.get()) == (x10.runtime.impl.java.InitDispatcher.EXCEPTION_RAISED)) {
            if ((x10.runtime.impl.java.InitDispatcher.TRACE_STATIC_INIT) == (true)) {
                x10.runtime.impl.java.InitDispatcher.printStaticInitMessage((("Rethrowing ExceptionInInitializer for field: plham.index.AverageIndexScheme.FUNDAMENTAL_PRICE")));
            }
            throw plham.index.AverageIndexScheme.exception$FUNDAMENTAL_PRICE;
        }
        if (plham.index.AverageIndexScheme.initStatus$FUNDAMENTAL_PRICE.compareAndSet((x10.runtime.impl.java.InitDispatcher.UNINITIALIZED), (x10.runtime.impl.java.InitDispatcher.INITIALIZING))) {
            try {{
                plham.index.AverageIndexScheme.FUNDAMENTAL_PRICE = ((new plham.index.AverageIndexScheme.$Closure$37()));
            }}catch (java.lang.Throwable exc$32077) {
                plham.index.AverageIndexScheme.exception$FUNDAMENTAL_PRICE = new x10.lang.ExceptionInInitializer(exc$32077);
                plham.index.AverageIndexScheme.initStatus$FUNDAMENTAL_PRICE.set((x10.runtime.impl.java.InitDispatcher.EXCEPTION_RAISED));
                x10.runtime.impl.java.InitDispatcher.lockInitialized();
                x10.runtime.impl.java.InitDispatcher.notifyInitialized();
                throw plham.index.AverageIndexScheme.exception$FUNDAMENTAL_PRICE;
            }
            if ((x10.runtime.impl.java.InitDispatcher.TRACE_STATIC_INIT) == (true)) {
                x10.runtime.impl.java.InitDispatcher.printStaticInitMessage((("Doing static initialization for field: plham.index.AverageIndexScheme.FUNDAMENTAL_PRICE")));
            }
            plham.index.AverageIndexScheme.initStatus$FUNDAMENTAL_PRICE.set((x10.runtime.impl.java.InitDispatcher.INITIALIZED));
            x10.runtime.impl.java.InitDispatcher.lockInitialized();
            x10.runtime.impl.java.InitDispatcher.notifyInitialized();
        } else {
            if (plham.index.AverageIndexScheme.initStatus$FUNDAMENTAL_PRICE.get() < x10.runtime.impl.java.InitDispatcher.INITIALIZED) {
                x10.runtime.impl.java.InitDispatcher.lockInitialized();
                while (plham.index.AverageIndexScheme.initStatus$FUNDAMENTAL_PRICE.get() < x10.runtime.impl.java.InitDispatcher.INITIALIZED) {
                    x10.runtime.impl.java.InitDispatcher.awaitInitialized();
                }
                x10.runtime.impl.java.InitDispatcher.unlockInitialized();
                if ((plham.index.AverageIndexScheme.initStatus$FUNDAMENTAL_PRICE.get()) == (x10.runtime.impl.java.InitDispatcher.EXCEPTION_RAISED)) {
                    if ((x10.runtime.impl.java.InitDispatcher.TRACE_STATIC_INIT) == (true)) {
                        x10.runtime.impl.java.InitDispatcher.printStaticInitMessage((("Rethrowing ExceptionInInitializer for field: plham.index.AverageIndexScheme.FUNDAMENTAL_PRICE")));
                    }
                    throw plham.index.AverageIndexScheme.exception$FUNDAMENTAL_PRICE;
                }
            }
        }
        return plham.index.AverageIndexScheme.FUNDAMENTAL_PRICE;
    }
    
    
    final public static class $Closure$36 extends x10.core.Ref implements x10.core.fun.Fun_0_1, x10.serialization.X10JavaSerializable
    {
        public static final x10.rtt.RuntimeType<$Closure$36> $RTT = 
            x10.rtt.StaticFunType.<$Closure$36> make($Closure$36.class,
                                                     new x10.rtt.Type[] {
                                                         x10.rtt.ParameterizedType.make(x10.core.fun.Fun_0_1.$RTT, plham.Market.$RTT, x10.rtt.Types.DOUBLE)
                                                     });
        
        public x10.rtt.RuntimeType<?> $getRTT() { return $RTT; }
        
        public x10.rtt.Type<?> $getParam(int i) { return null; }
        
        private Object writeReplace() throws java.io.ObjectStreamException {
            return new x10.serialization.SerializationProxy(this);
        }
        
        public static x10.serialization.X10JavaSerializable $_deserialize_body(plham.index.AverageIndexScheme.$Closure$36 $_obj, x10.serialization.X10JavaDeserializer $deserializer) throws java.io.IOException {
            if (x10.runtime.impl.java.Runtime.TRACE_SER) { x10.runtime.impl.java.Runtime.printTraceMessage("X10JavaSerializable: $_deserialize_body() of " + $Closure$36.class + " calling"); } 
            return $_obj;
        }
        
        public static x10.serialization.X10JavaSerializable $_deserializer(x10.serialization.X10JavaDeserializer $deserializer) throws java.io.IOException {
            plham.index.AverageIndexScheme.$Closure$36 $_obj = new plham.index.AverageIndexScheme.$Closure$36((java.lang.System[]) null);
            $deserializer.record_reference($_obj);
            return $_deserialize_body($_obj, $deserializer);
        }
        
        public void $_serialize(x10.serialization.X10JavaSerializer $serializer) throws java.io.IOException {
            
        }
        
        // constructor just for allocation
        public $Closure$36(final java.lang.System[] $dummy) {
            
        }
        
        // dispatcher for method abstract public (Z1)=>U.operator()(a1:Z1):U
        public java.lang.Object $apply(final java.lang.Object a1, final x10.rtt.Type t1) {
            return x10.core.Double.$box($apply$O((plham.Market)a1));
            
        }
        
        // dispatcher for method abstract public (Z1)=>U.operator()(a1:Z1):U
        public double $apply$D(final java.lang.Object a1, final x10.rtt.Type t1) {
            return $apply$O((plham.Market)a1);
            
        }
        
        
    
        
        public double $apply$O(final plham.Market market) {
            
            //#line 7 "/home/dsl/workspace/plhamK/plham/index/AverageIndexScheme.x10"
            return market.getPrice$O();
        }
        
        public $Closure$36() {
             {
                
            }
        }
        
    }
    
    
    final public static class $Closure$37 extends x10.core.Ref implements x10.core.fun.Fun_0_1, x10.serialization.X10JavaSerializable
    {
        public static final x10.rtt.RuntimeType<$Closure$37> $RTT = 
            x10.rtt.StaticFunType.<$Closure$37> make($Closure$37.class,
                                                     new x10.rtt.Type[] {
                                                         x10.rtt.ParameterizedType.make(x10.core.fun.Fun_0_1.$RTT, plham.Market.$RTT, x10.rtt.Types.DOUBLE)
                                                     });
        
        public x10.rtt.RuntimeType<?> $getRTT() { return $RTT; }
        
        public x10.rtt.Type<?> $getParam(int i) { return null; }
        
        private Object writeReplace() throws java.io.ObjectStreamException {
            return new x10.serialization.SerializationProxy(this);
        }
        
        public static x10.serialization.X10JavaSerializable $_deserialize_body(plham.index.AverageIndexScheme.$Closure$37 $_obj, x10.serialization.X10JavaDeserializer $deserializer) throws java.io.IOException {
            if (x10.runtime.impl.java.Runtime.TRACE_SER) { x10.runtime.impl.java.Runtime.printTraceMessage("X10JavaSerializable: $_deserialize_body() of " + $Closure$37.class + " calling"); } 
            return $_obj;
        }
        
        public static x10.serialization.X10JavaSerializable $_deserializer(x10.serialization.X10JavaDeserializer $deserializer) throws java.io.IOException {
            plham.index.AverageIndexScheme.$Closure$37 $_obj = new plham.index.AverageIndexScheme.$Closure$37((java.lang.System[]) null);
            $deserializer.record_reference($_obj);
            return $_deserialize_body($_obj, $deserializer);
        }
        
        public void $_serialize(x10.serialization.X10JavaSerializer $serializer) throws java.io.IOException {
            
        }
        
        // constructor just for allocation
        public $Closure$37(final java.lang.System[] $dummy) {
            
        }
        
        // dispatcher for method abstract public (Z1)=>U.operator()(a1:Z1):U
        public java.lang.Object $apply(final java.lang.Object a1, final x10.rtt.Type t1) {
            return x10.core.Double.$box($apply$O((plham.Market)a1));
            
        }
        
        // dispatcher for method abstract public (Z1)=>U.operator()(a1:Z1):U
        public double $apply$D(final java.lang.Object a1, final x10.rtt.Type t1) {
            return $apply$O((plham.Market)a1);
            
        }
        
        
    
        
        public double $apply$O(final plham.Market market) {
            
            //#line 8 "/home/dsl/workspace/plhamK/plham/index/AverageIndexScheme.x10"
            return market.getFundamentalPrice();
        }
        
        public $Closure$37() {
             {
                
            }
        }
        
    }
    
}

