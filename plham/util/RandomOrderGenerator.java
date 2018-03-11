package plham.util;



public class RandomOrderGenerator extends x10.core.Ref implements x10.serialization.X10JavaSerializable
{
    public static final x10.rtt.RuntimeType<RandomOrderGenerator> $RTT = 
        x10.rtt.NamedType.<RandomOrderGenerator> make("plham.util.RandomOrderGenerator",
                                                      RandomOrderGenerator.class);
    
    public x10.rtt.RuntimeType<?> $getRTT() { return $RTT; }
    
    public x10.rtt.Type<?> $getParam(int i) { return null; }
    
    private Object writeReplace() throws java.io.ObjectStreamException {
        return new x10.serialization.SerializationProxy(this);
    }
    
    public static x10.serialization.X10JavaSerializable $_deserialize_body(plham.util.RandomOrderGenerator $_obj, x10.serialization.X10JavaDeserializer $deserializer) throws java.io.IOException {
        if (x10.runtime.impl.java.Runtime.TRACE_SER) { x10.runtime.impl.java.Runtime.printTraceMessage("X10JavaSerializable: $_deserialize_body() of " + RandomOrderGenerator.class + " calling"); } 
        $_obj.nextPrice = $deserializer.readObject();
        $_obj.nextTimeLength = $deserializer.readObject();
        $_obj.nextVolume = $deserializer.readObject();
        $_obj.random = $deserializer.readObject();
        return $_obj;
    }
    
    public static x10.serialization.X10JavaSerializable $_deserializer(x10.serialization.X10JavaDeserializer $deserializer) throws java.io.IOException {
        plham.util.RandomOrderGenerator $_obj = new plham.util.RandomOrderGenerator((java.lang.System[]) null);
        $deserializer.record_reference($_obj);
        return $_deserialize_body($_obj, $deserializer);
    }
    
    public void $_serialize(x10.serialization.X10JavaSerializer $serializer) throws java.io.IOException {
        $serializer.write(this.nextPrice);
        $serializer.write(this.nextTimeLength);
        $serializer.write(this.nextVolume);
        $serializer.write(this.random);
        
    }
    
    // constructor just for allocation
    public RandomOrderGenerator(final java.lang.System[] $dummy) {
        
    }
    
    // synthetic type for parameter mangling
    public static final class __0$1x10$lang$Double$3x10$lang$Double$2__1$1x10$lang$Long$2__2$1x10$lang$Long$2 {}
    

    
    //#line 13 "/home/dsl/workspace/plhamK/plham/util/RandomOrderGenerator.x10"
    public x10.util.Random random;
    
    //#line 14 "/home/dsl/workspace/plhamK/plham/util/RandomOrderGenerator.x10"
    public x10.core.fun.Fun_0_1<x10.core.Double,x10.core.Double> nextPrice;
    
    //#line 15 "/home/dsl/workspace/plhamK/plham/util/RandomOrderGenerator.x10"
    public x10.core.fun.Fun_0_0<x10.core.Long> nextVolume;
    
    //#line 16 "/home/dsl/workspace/plhamK/plham/util/RandomOrderGenerator.x10"
    public x10.core.fun.Fun_0_0<x10.core.Long> nextTimeLength;
    
    
    //#line 18 "/home/dsl/workspace/plhamK/plham/util/RandomOrderGenerator.x10"
    // creation method for java code (1-phase java constructor)
    public RandomOrderGenerator(final x10.core.fun.Fun_0_1<x10.core.Double,x10.core.Double> nextPrice, final x10.core.fun.Fun_0_0<x10.core.Long> nextVolume, final x10.core.fun.Fun_0_0<x10.core.Long> nextTimeLength, __0$1x10$lang$Double$3x10$lang$Double$2__1$1x10$lang$Long$2__2$1x10$lang$Long$2 $dummy) {
        this((java.lang.System[]) null);
        plham$util$RandomOrderGenerator$$init$S(nextPrice, nextVolume, nextTimeLength, (plham.util.RandomOrderGenerator.__0$1x10$lang$Double$3x10$lang$Double$2__1$1x10$lang$Long$2__2$1x10$lang$Long$2) null);
    }
    
    // constructor for non-virtual call
    final public plham.util.RandomOrderGenerator plham$util$RandomOrderGenerator$$init$S(final x10.core.fun.Fun_0_1<x10.core.Double,x10.core.Double> nextPrice, final x10.core.fun.Fun_0_0<x10.core.Long> nextVolume, final x10.core.fun.Fun_0_0<x10.core.Long> nextTimeLength, __0$1x10$lang$Double$3x10$lang$Double$2__1$1x10$lang$Long$2__2$1x10$lang$Long$2 $dummy) {
         {
            
            //#line 18 "/home/dsl/workspace/plhamK/plham/util/RandomOrderGenerator.x10"
            
            
            //#line 11 "/home/dsl/workspace/plhamK/plham/util/RandomOrderGenerator.x10"
            this.__fieldInitializers_plham_util_RandomOrderGenerator();
            
            //#line 19 "/home/dsl/workspace/plhamK/plham/util/RandomOrderGenerator.x10"
            this.nextPrice = ((nextPrice));
            
            //#line 20 "/home/dsl/workspace/plhamK/plham/util/RandomOrderGenerator.x10"
            this.nextVolume = ((nextVolume));
            
            //#line 21 "/home/dsl/workspace/plhamK/plham/util/RandomOrderGenerator.x10"
            this.nextTimeLength = ((nextTimeLength));
        }
        return this;
    }
    
    
    
    //#line 24 "/home/dsl/workspace/plhamK/plham/util/RandomOrderGenerator.x10"
    public plham.Order get(final plham.Market market, final plham.Agent agent) {
        
        //#line 25 "/home/dsl/workspace/plhamK/plham/util/RandomOrderGenerator.x10"
        final double middlePrice = market.getPrice$O();
        
        //#line 26 "/home/dsl/workspace/plhamK/plham/util/RandomOrderGenerator.x10"
        final x10.core.fun.Fun_0_1 t$35817 = ((this.nextPrice));
        
        //#line 26 "/home/dsl/workspace/plhamK/plham/util/RandomOrderGenerator.x10"
        final double price = x10.core.Double.$unbox(((x10.core.fun.Fun_0_1<x10.core.Double,x10.core.Double>)t$35817).$apply(x10.core.Double.$box(middlePrice), x10.rtt.Types.DOUBLE));
        
        //#line 27 "/home/dsl/workspace/plhamK/plham/util/RandomOrderGenerator.x10"
        final x10.core.fun.Fun_0_0 t$35818 = ((this.nextVolume));
        
        //#line 27 "/home/dsl/workspace/plhamK/plham/util/RandomOrderGenerator.x10"
        final long volume = x10.core.Long.$unbox(((x10.core.fun.Fun_0_0<x10.core.Long>)t$35818).$apply$G());
        
        //#line 28 "/home/dsl/workspace/plhamK/plham/util/RandomOrderGenerator.x10"
        final x10.core.fun.Fun_0_0 t$35819 = ((this.nextTimeLength));
        
        //#line 28 "/home/dsl/workspace/plhamK/plham/util/RandomOrderGenerator.x10"
        final long timeLength = x10.core.Long.$unbox(((x10.core.fun.Fun_0_0<x10.core.Long>)t$35819).$apply$G());
        
        //#line 29 "/home/dsl/workspace/plhamK/plham/util/RandomOrderGenerator.x10"
        final boolean t$35824 = ((price) < (((middlePrice))));
        
        //#line 29 "/home/dsl/workspace/plhamK/plham/util/RandomOrderGenerator.x10"
        if (t$35824) {
            
            //#line 30 "/home/dsl/workspace/plhamK/plham/util/RandomOrderGenerator.x10"
            final plham.Order.Kind t$35820 = ((plham.Order.get$KIND_BUY_LIMIT_ORDER()));
            
            //#line 30 "/home/dsl/workspace/plhamK/plham/util/RandomOrderGenerator.x10"
            final plham.Order t$35821 = ((new plham.Order((java.lang.System[]) null).plham$Order$$init$S(((t$35820)), ((agent)), ((market)), ((price)), ((volume)), ((timeLength)))));
            
            //#line 30 "/home/dsl/workspace/plhamK/plham/util/RandomOrderGenerator.x10"
            return t$35821;
        } else {
            
            //#line 32 "/home/dsl/workspace/plhamK/plham/util/RandomOrderGenerator.x10"
            final plham.Order.Kind t$35822 = ((plham.Order.get$KIND_SELL_LIMIT_ORDER()));
            
            //#line 32 "/home/dsl/workspace/plhamK/plham/util/RandomOrderGenerator.x10"
            final plham.Order t$35823 = ((new plham.Order((java.lang.System[]) null).plham$Order$$init$S(((t$35822)), ((agent)), ((market)), ((price)), ((volume)), ((timeLength)))));
            
            //#line 32 "/home/dsl/workspace/plhamK/plham/util/RandomOrderGenerator.x10"
            return t$35823;
        }
    }
    
    
    //#line 36 "/home/dsl/workspace/plhamK/plham/util/RandomOrderGenerator.x10"
    public x10.util.List get__1$1plham$Agent$2(final plham.Market market, final x10.core.fun.Fun_0_0 nextAgent, final long N) {
        
        //#line 37 "/home/dsl/workspace/plhamK/plham/util/RandomOrderGenerator.x10"
        final x10.util.Random random = ((this.random));
        
        //#line 38 "/home/dsl/workspace/plhamK/plham/util/RandomOrderGenerator.x10"
        final x10.util.ArrayList orders = ((new x10.util.ArrayList<plham.Order>((java.lang.System[]) null, plham.Order.$RTT).x10$util$ArrayList$$init$S()));
        
        //#line 39 "/home/dsl/workspace/plhamK/plham/util/RandomOrderGenerator.x10"
        final long i$35798min$35855 = 0L;
        
        //#line 39 "/home/dsl/workspace/plhamK/plham/util/RandomOrderGenerator.x10"
        final long i$35798max$35856 = ((N) - (((1L))));
        
        //#line 39 "/home/dsl/workspace/plhamK/plham/util/RandomOrderGenerator.x10"
        long i$35852 = i$35798min$35855;
        
        //#line 39 "/home/dsl/workspace/plhamK/plham/util/RandomOrderGenerator.x10"
        for (;
             true;
             ) {
            
            //#line 39 "/home/dsl/workspace/plhamK/plham/util/RandomOrderGenerator.x10"
            final long t$35853 = i$35852;
            
            //#line 39 "/home/dsl/workspace/plhamK/plham/util/RandomOrderGenerator.x10"
            final boolean t$35854 = ((t$35853) <= (((i$35798max$35856))));
            
            //#line 39 "/home/dsl/workspace/plhamK/plham/util/RandomOrderGenerator.x10"
            if (!(t$35854)) {
                
                //#line 39 "/home/dsl/workspace/plhamK/plham/util/RandomOrderGenerator.x10"
                break;
            }
            
            //#line 39 "/home/dsl/workspace/plhamK/plham/util/RandomOrderGenerator.x10"
            final long i$35849 = i$35852;
            
            //#line 40 "/home/dsl/workspace/plhamK/plham/util/RandomOrderGenerator.x10"
            final plham.Agent agent$35847 = ((x10.core.fun.Fun_0_0<plham.Agent>)nextAgent).$apply$G();
            
            //#line 41 "/home/dsl/workspace/plhamK/plham/util/RandomOrderGenerator.x10"
            final plham.Order t$35848 = this.get(((market)), ((agent$35847)));
            
            //#line 41 "/home/dsl/workspace/plhamK/plham/util/RandomOrderGenerator.x10"
            ((x10.util.ArrayList<plham.Order>)orders).add__0x10$util$ArrayList$$T$O(((t$35848)));
            
            //#line 39 "/home/dsl/workspace/plhamK/plham/util/RandomOrderGenerator.x10"
            final long t$35850 = i$35852;
            
            //#line 39 "/home/dsl/workspace/plhamK/plham/util/RandomOrderGenerator.x10"
            final long t$35851 = ((t$35850) + (((1L))));
            
            //#line 39 "/home/dsl/workspace/plhamK/plham/util/RandomOrderGenerator.x10"
            i$35852 = t$35851;
        }
        
        //#line 43 "/home/dsl/workspace/plhamK/plham/util/RandomOrderGenerator.x10"
        return orders;
    }
    
    
    //#line 46 "/home/dsl/workspace/plhamK/plham/util/RandomOrderGenerator.x10"
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
            RandomOrderGenerator.main(args);
        }
    }
    
    // the original app-main method
    public static void main(final x10.core.Rail<java.lang.String> args) {
        
        //#line 48 "/home/dsl/workspace/plhamK/plham/util/RandomOrderGenerator.x10"
        final x10.util.Random t$35831 = ((new x10.util.Random((java.lang.System[]) null).x10$util$Random$$init$S()));
        
        //#line 48 "/home/dsl/workspace/plhamK/plham/util/RandomOrderGenerator.x10"
        final plham.util.RandomHelper random = ((new plham.util.RandomHelper((java.lang.System[]) null).plham$util$RandomHelper$$init$S(((t$35831)))));
        
        //#line 50 "/home/dsl/workspace/plhamK/plham/util/RandomOrderGenerator.x10"
        final plham.Market market = ((new plham.Market((java.lang.System[]) null).plham$Market$$init$S(((-1L)))));
        
        //#line 51 "/home/dsl/workspace/plhamK/plham/util/RandomOrderGenerator.x10"
        market.setInitialMarketPrice((300.0));
        
        //#line 54 "/home/dsl/workspace/plhamK/plham/util/RandomOrderGenerator.x10"
        final x10.core.fun.Fun_0_1 t$35839 = ((new plham.util.RandomOrderGenerator.$Closure$33(random)));
        
        //#line 55 "/home/dsl/workspace/plhamK/plham/util/RandomOrderGenerator.x10"
        final x10.core.fun.Fun_0_0 t$35840 = ((new plham.util.RandomOrderGenerator.$Closure$34()));
        
        //#line 56 "/home/dsl/workspace/plhamK/plham/util/RandomOrderGenerator.x10"
        final x10.core.fun.Fun_0_0 t$35841 = ((new plham.util.RandomOrderGenerator.$Closure$35(random)));
        
        //#line 53 "/home/dsl/workspace/plhamK/plham/util/RandomOrderGenerator.x10"
        final plham.util.RandomOrderGenerator rog = ((new plham.util.RandomOrderGenerator((java.lang.System[]) null).plham$util$RandomOrderGenerator$$init$S(((t$35839)), ((t$35840)), ((t$35841)), (plham.util.RandomOrderGenerator.__0$1x10$lang$Double$3x10$lang$Double$2__1$1x10$lang$Long$2__2$1x10$lang$Long$2) null)));
        
        //#line 58 "/home/dsl/workspace/plhamK/plham/util/RandomOrderGenerator.x10"
        final plham.agent.TestAgent agent = ((new plham.agent.TestAgent((java.lang.System[]) null).plham$agent$TestAgent$$init$S(((-1L)))));
        
        //#line 60 "/home/dsl/workspace/plhamK/plham/util/RandomOrderGenerator.x10"
        final x10.core.fun.Fun_0_0 t$35859 = ((new plham.util.RandomOrderGenerator.$Closure$36(agent)));
        
        //#line 60 "/home/dsl/workspace/plhamK/plham/util/RandomOrderGenerator.x10"
        final x10.util.List t$35860 = rog.get__1$1plham$Agent$2(((market)), ((t$35859)), (100L));
        
        //#line 60 "/home/dsl/workspace/plhamK/plham/util/RandomOrderGenerator.x10"
        final x10.util.ListIterator order$35861 = (((x10.util.List<plham.Order>)t$35860).iterator());
        
        //#line 60 "/home/dsl/workspace/plhamK/plham/util/RandomOrderGenerator.x10"
        for (;
             true;
             ) {
            
            //#line 60 "/home/dsl/workspace/plhamK/plham/util/RandomOrderGenerator.x10"
            final boolean t$35862 = ((x10.util.ListIterator<plham.Order>)order$35861).hasNext$O();
            
            //#line 60 "/home/dsl/workspace/plhamK/plham/util/RandomOrderGenerator.x10"
            if (!(t$35862)) {
                
                //#line 60 "/home/dsl/workspace/plhamK/plham/util/RandomOrderGenerator.x10"
                break;
            }
            
            //#line 60 "/home/dsl/workspace/plhamK/plham/util/RandomOrderGenerator.x10"
            final plham.Order order$35857 = ((((x10.util.ListIterator<plham.Order>)order$35861).next$G()));
            
            //#line 61 "/home/dsl/workspace/plhamK/plham/util/RandomOrderGenerator.x10"
            final x10.io.Printer t$35858 = ((x10.io.Console.get$OUT()));
            
            //#line 61 "/home/dsl/workspace/plhamK/plham/util/RandomOrderGenerator.x10"
            t$35858.println(((order$35857)));
        }
    }
    
    
    //#line 11 "/home/dsl/workspace/plhamK/plham/util/RandomOrderGenerator.x10"
    final public plham.util.RandomOrderGenerator plham$util$RandomOrderGenerator$$this$plham$util$RandomOrderGenerator() {
        
        //#line 11 "/home/dsl/workspace/plhamK/plham/util/RandomOrderGenerator.x10"
        return plham.util.RandomOrderGenerator.this;
    }
    
    
    //#line 11 "/home/dsl/workspace/plhamK/plham/util/RandomOrderGenerator.x10"
    final public void __fieldInitializers_plham_util_RandomOrderGenerator() {
        
        //#line 11 "/home/dsl/workspace/plhamK/plham/util/RandomOrderGenerator.x10"
        this.random = null;
        
        //#line 11 "/home/dsl/workspace/plhamK/plham/util/RandomOrderGenerator.x10"
        this.nextPrice = null;
        
        //#line 11 "/home/dsl/workspace/plhamK/plham/util/RandomOrderGenerator.x10"
        this.nextVolume = null;
        
        //#line 11 "/home/dsl/workspace/plhamK/plham/util/RandomOrderGenerator.x10"
        this.nextTimeLength = null;
    }
    
    
    final public static class $Closure$33 extends x10.core.Ref implements x10.core.fun.Fun_0_1, x10.serialization.X10JavaSerializable
    {
        public static final x10.rtt.RuntimeType<$Closure$33> $RTT = 
            x10.rtt.StaticFunType.<$Closure$33> make($Closure$33.class,
                                                     new x10.rtt.Type[] {
                                                         x10.rtt.ParameterizedType.make(x10.core.fun.Fun_0_1.$RTT, x10.rtt.Types.DOUBLE, x10.rtt.Types.DOUBLE)
                                                     });
        
        public x10.rtt.RuntimeType<?> $getRTT() { return $RTT; }
        
        public x10.rtt.Type<?> $getParam(int i) { return null; }
        
        private Object writeReplace() throws java.io.ObjectStreamException {
            return new x10.serialization.SerializationProxy(this);
        }
        
        public static x10.serialization.X10JavaSerializable $_deserialize_body(plham.util.RandomOrderGenerator.$Closure$33 $_obj, x10.serialization.X10JavaDeserializer $deserializer) throws java.io.IOException {
            if (x10.runtime.impl.java.Runtime.TRACE_SER) { x10.runtime.impl.java.Runtime.printTraceMessage("X10JavaSerializable: $_deserialize_body() of " + $Closure$33.class + " calling"); } 
            $_obj.random = $deserializer.readObject();
            return $_obj;
        }
        
        public static x10.serialization.X10JavaSerializable $_deserializer(x10.serialization.X10JavaDeserializer $deserializer) throws java.io.IOException {
            plham.util.RandomOrderGenerator.$Closure$33 $_obj = new plham.util.RandomOrderGenerator.$Closure$33((java.lang.System[]) null);
            $deserializer.record_reference($_obj);
            return $_deserialize_body($_obj, $deserializer);
        }
        
        public void $_serialize(x10.serialization.X10JavaSerializer $serializer) throws java.io.IOException {
            $serializer.write(this.random);
            
        }
        
        // constructor just for allocation
        public $Closure$33(final java.lang.System[] $dummy) {
            
        }
        
        // dispatcher for method abstract public (Z1)=>U.operator()(a1:Z1):U
        public java.lang.Object $apply(final java.lang.Object a1, final x10.rtt.Type t1) {
            return x10.core.Double.$box($apply$O(x10.core.Double.$unbox(a1)));
            
        }
        
        // dispatcher for method abstract public (Z1)=>U.operator()(a1:Z1):U
        public double $apply$D(final java.lang.Object a1, final x10.rtt.Type t1) {
            return $apply$O(x10.core.Double.$unbox(a1));
            
        }
        
        
    
        
        public double $apply$O(final double p) {
            
            //#line 54 "/home/dsl/workspace/plhamK/plham/util/RandomOrderGenerator.x10"
            final double t$35832 = this.random.nextGaussian$O();
            
            //#line 54 "/home/dsl/workspace/plhamK/plham/util/RandomOrderGenerator.x10"
            final double t$35833 = ((((10L))));
            
            //#line 54 "/home/dsl/workspace/plhamK/plham/util/RandomOrderGenerator.x10"
            final double t$35834 = ((t$35832) * (((t$35833))));
            
            //#line 54 "/home/dsl/workspace/plhamK/plham/util/RandomOrderGenerator.x10"
            final double t$35835 = ((p) + (((t$35834))));
            
            //#line 54 "/home/dsl/workspace/plhamK/plham/util/RandomOrderGenerator.x10"
            final double t$35836 = java.lang.Math.max(((0.0)),((t$35835)));
            
            //#line 54 "/home/dsl/workspace/plhamK/plham/util/RandomOrderGenerator.x10"
            return t$35836;
        }
        
        public plham.util.RandomHelper random;
        
        public $Closure$33(final plham.util.RandomHelper random) {
             {
                this.random = ((random));
            }
        }
        
    }
    
    
    final public static class $Closure$34 extends x10.core.Ref implements x10.core.fun.Fun_0_0, x10.serialization.X10JavaSerializable
    {
        public static final x10.rtt.RuntimeType<$Closure$34> $RTT = 
            x10.rtt.StaticFunType.<$Closure$34> make($Closure$34.class,
                                                     new x10.rtt.Type[] {
                                                         x10.rtt.ParameterizedType.make(x10.core.fun.Fun_0_0.$RTT, x10.rtt.Types.LONG)
                                                     });
        
        public x10.rtt.RuntimeType<?> $getRTT() { return $RTT; }
        
        public x10.rtt.Type<?> $getParam(int i) { return null; }
        
        private Object writeReplace() throws java.io.ObjectStreamException {
            return new x10.serialization.SerializationProxy(this);
        }
        
        public static x10.serialization.X10JavaSerializable $_deserialize_body(plham.util.RandomOrderGenerator.$Closure$34 $_obj, x10.serialization.X10JavaDeserializer $deserializer) throws java.io.IOException {
            if (x10.runtime.impl.java.Runtime.TRACE_SER) { x10.runtime.impl.java.Runtime.printTraceMessage("X10JavaSerializable: $_deserialize_body() of " + $Closure$34.class + " calling"); } 
            return $_obj;
        }
        
        public static x10.serialization.X10JavaSerializable $_deserializer(x10.serialization.X10JavaDeserializer $deserializer) throws java.io.IOException {
            plham.util.RandomOrderGenerator.$Closure$34 $_obj = new plham.util.RandomOrderGenerator.$Closure$34((java.lang.System[]) null);
            $deserializer.record_reference($_obj);
            return $_deserialize_body($_obj, $deserializer);
        }
        
        public void $_serialize(x10.serialization.X10JavaSerializer $serializer) throws java.io.IOException {
            
        }
        
        // constructor just for allocation
        public $Closure$34(final java.lang.System[] $dummy) {
            
        }
        
        // bridge for method abstract public ()=>U.operator()():U
        public x10.core.Long $apply$G() {
            return x10.core.Long.$box($apply$O());
        }
        
        
    
        
        public long $apply$O() {
            
            //#line 55 "/home/dsl/workspace/plhamK/plham/util/RandomOrderGenerator.x10"
            return 1L;
        }
        
        public $Closure$34() {
             {
                
            }
        }
        
    }
    
    
    final public static class $Closure$35 extends x10.core.Ref implements x10.core.fun.Fun_0_0, x10.serialization.X10JavaSerializable
    {
        public static final x10.rtt.RuntimeType<$Closure$35> $RTT = 
            x10.rtt.StaticFunType.<$Closure$35> make($Closure$35.class,
                                                     new x10.rtt.Type[] {
                                                         x10.rtt.ParameterizedType.make(x10.core.fun.Fun_0_0.$RTT, x10.rtt.Types.LONG)
                                                     });
        
        public x10.rtt.RuntimeType<?> $getRTT() { return $RTT; }
        
        public x10.rtt.Type<?> $getParam(int i) { return null; }
        
        private Object writeReplace() throws java.io.ObjectStreamException {
            return new x10.serialization.SerializationProxy(this);
        }
        
        public static x10.serialization.X10JavaSerializable $_deserialize_body(plham.util.RandomOrderGenerator.$Closure$35 $_obj, x10.serialization.X10JavaDeserializer $deserializer) throws java.io.IOException {
            if (x10.runtime.impl.java.Runtime.TRACE_SER) { x10.runtime.impl.java.Runtime.printTraceMessage("X10JavaSerializable: $_deserialize_body() of " + $Closure$35.class + " calling"); } 
            $_obj.random = $deserializer.readObject();
            return $_obj;
        }
        
        public static x10.serialization.X10JavaSerializable $_deserializer(x10.serialization.X10JavaDeserializer $deserializer) throws java.io.IOException {
            plham.util.RandomOrderGenerator.$Closure$35 $_obj = new plham.util.RandomOrderGenerator.$Closure$35((java.lang.System[]) null);
            $deserializer.record_reference($_obj);
            return $_deserialize_body($_obj, $deserializer);
        }
        
        public void $_serialize(x10.serialization.X10JavaSerializer $serializer) throws java.io.IOException {
            $serializer.write(this.random);
            
        }
        
        // constructor just for allocation
        public $Closure$35(final java.lang.System[] $dummy) {
            
        }
        
        // bridge for method abstract public ()=>U.operator()():U
        public x10.core.Long $apply$G() {
            return x10.core.Long.$box($apply$O());
        }
        
        
    
        
        public long $apply$O() {
            
            //#line 56 "/home/dsl/workspace/plhamK/plham/util/RandomOrderGenerator.x10"
            final long t$35837 = this.random.nextLong$O((100L));
            
            //#line 56 "/home/dsl/workspace/plhamK/plham/util/RandomOrderGenerator.x10"
            final long t$35838 = ((t$35837) + (((10L))));
            
            //#line 56 "/home/dsl/workspace/plhamK/plham/util/RandomOrderGenerator.x10"
            return t$35838;
        }
        
        public plham.util.RandomHelper random;
        
        public $Closure$35(final plham.util.RandomHelper random) {
             {
                this.random = ((random));
            }
        }
        
    }
    
    
    final public static class $Closure$36 extends x10.core.Ref implements x10.core.fun.Fun_0_0, x10.serialization.X10JavaSerializable
    {
        public static final x10.rtt.RuntimeType<$Closure$36> $RTT = 
            x10.rtt.StaticFunType.<$Closure$36> make($Closure$36.class,
                                                     new x10.rtt.Type[] {
                                                         x10.rtt.ParameterizedType.make(x10.core.fun.Fun_0_0.$RTT, plham.agent.TestAgent.$RTT)
                                                     });
        
        public x10.rtt.RuntimeType<?> $getRTT() { return $RTT; }
        
        public x10.rtt.Type<?> $getParam(int i) { return null; }
        
        private Object writeReplace() throws java.io.ObjectStreamException {
            return new x10.serialization.SerializationProxy(this);
        }
        
        public static x10.serialization.X10JavaSerializable $_deserialize_body(plham.util.RandomOrderGenerator.$Closure$36 $_obj, x10.serialization.X10JavaDeserializer $deserializer) throws java.io.IOException {
            if (x10.runtime.impl.java.Runtime.TRACE_SER) { x10.runtime.impl.java.Runtime.printTraceMessage("X10JavaSerializable: $_deserialize_body() of " + $Closure$36.class + " calling"); } 
            $_obj.agent = $deserializer.readObject();
            return $_obj;
        }
        
        public static x10.serialization.X10JavaSerializable $_deserializer(x10.serialization.X10JavaDeserializer $deserializer) throws java.io.IOException {
            plham.util.RandomOrderGenerator.$Closure$36 $_obj = new plham.util.RandomOrderGenerator.$Closure$36((java.lang.System[]) null);
            $deserializer.record_reference($_obj);
            return $_deserialize_body($_obj, $deserializer);
        }
        
        public void $_serialize(x10.serialization.X10JavaSerializer $serializer) throws java.io.IOException {
            $serializer.write(this.agent);
            
        }
        
        // constructor just for allocation
        public $Closure$36(final java.lang.System[] $dummy) {
            
        }
        
        // bridge for method abstract public ()=>U.operator()():U
        public plham.agent.TestAgent $apply$G() {
            return $apply();
        }
        
        
    
        
        public plham.agent.TestAgent $apply() {
            
            //#line 60 "/home/dsl/workspace/plhamK/plham/util/RandomOrderGenerator.x10"
            return this.agent;
        }
        
        public plham.agent.TestAgent agent;
        
        public $Closure$36(final plham.agent.TestAgent agent) {
             {
                this.agent = ((agent));
            }
        }
        
    }
    
}

