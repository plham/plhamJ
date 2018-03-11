package plham;


/**
 * A class for orderbooks for continuous double action mechanism.
 * Orders are arranged in the price/time priority basis.
 * Use HIGHERS_FIRST for buy side; Use LOWERS_FIRST for sell side.
 */

public class OrderBook extends x10.core.Ref implements x10.serialization.X10JavaSerializable
{
    public static final x10.rtt.RuntimeType<OrderBook> $RTT = 
        x10.rtt.NamedType.<OrderBook> make("plham.OrderBook",
                                           OrderBook.class);
    
    public x10.rtt.RuntimeType<?> $getRTT() { return $RTT; }
    
    public x10.rtt.Type<?> $getParam(int i) { return null; }
    
    private Object writeReplace() throws java.io.ObjectStreamException {
        return new x10.serialization.SerializationProxy(this);
    }
    
    public static x10.serialization.X10JavaSerializable $_deserialize_body(plham.OrderBook $_obj, x10.serialization.X10JavaDeserializer $deserializer) throws java.io.IOException {
        if (x10.runtime.impl.java.Runtime.TRACE_SER) { x10.runtime.impl.java.Runtime.printTraceMessage("X10JavaSerializable: $_deserialize_body() of " + OrderBook.class + " calling"); } 
        $_obj.cancelCache = $deserializer.readObject();
        $_obj.queue = $deserializer.readObject();
        $_obj.time = $deserializer.readObject();
        return $_obj;
    }
    
    public static x10.serialization.X10JavaSerializable $_deserializer(x10.serialization.X10JavaDeserializer $deserializer) throws java.io.IOException {
        plham.OrderBook $_obj = new plham.OrderBook((java.lang.System[]) null);
        $deserializer.record_reference($_obj);
        return $_deserialize_body($_obj, $deserializer);
    }
    
    public void $_serialize(x10.serialization.X10JavaSerializer $serializer) throws java.io.IOException {
        $serializer.write(this.cancelCache);
        $serializer.write(this.queue);
        $serializer.write(this.time);
        
    }
    
    // constructor just for allocation
    public OrderBook(final java.lang.System[] $dummy) {
        
    }
    
    // synthetic type for parameter mangling
    public static final class __0$1plham$Order$3plham$Order$3x10$lang$Int$2 {}
    

    
    //#line 19 "/home/dsl/workspace/plhamK/plham/OrderBook.x10"
    public cassia.util.SortedQueue<plham.Order> queue;
    
    //#line 20 "/home/dsl/workspace/plhamK/plham/OrderBook.x10"
    public plham.Time time;
    
    //#line 23 "/home/dsl/workspace/plhamK/plham/OrderBook.x10"
    /** A cache for cancel management. */
    public x10.util.Set<plham.OrderBook.Key> cancelCache;
    
    
    //#line 25 "/home/dsl/workspace/plhamK/plham/OrderBook.x10"
    // creation method for java code (1-phase java constructor)
    public OrderBook(final x10.core.fun.Fun_0_2<plham.Order,plham.Order,x10.core.Int> comparator, __0$1plham$Order$3plham$Order$3x10$lang$Int$2 $dummy) {
        this((java.lang.System[]) null);
        plham$OrderBook$$init$S(comparator, (plham.OrderBook.__0$1plham$Order$3plham$Order$3x10$lang$Int$2) null);
    }
    
    // constructor for non-virtual call
    final public plham.OrderBook plham$OrderBook$$init$S(final x10.core.fun.Fun_0_2<plham.Order,plham.Order,x10.core.Int> comparator, __0$1plham$Order$3plham$Order$3x10$lang$Int$2 $dummy) {
         {
            
            //#line 25 "/home/dsl/workspace/plhamK/plham/OrderBook.x10"
            
            
            //#line 17 "/home/dsl/workspace/plhamK/plham/OrderBook.x10"
            this.__fieldInitializers_plham_OrderBook();
            
            //#line 26 "/home/dsl/workspace/plhamK/plham/OrderBook.x10"
            final cassia.util.HeapQueue t$31043 = ((new cassia.util.HeapQueue<plham.Order>((java.lang.System[]) null, plham.Order.$RTT).cassia$util$HeapQueue$$init$S(((comparator)), (cassia.util.HeapQueue.__0$1cassia$util$HeapQueue$$T$3cassia$util$HeapQueue$$T$3x10$lang$Int$2) null)));
            
            //#line 26 "/home/dsl/workspace/plhamK/plham/OrderBook.x10"
            this.queue = ((t$31043));
        }
        return this;
    }
    
    
    
    //#line 29 "/home/dsl/workspace/plhamK/plham/OrderBook.x10"
    public void setTime(final plham.Time time) {
        
        //#line 30 "/home/dsl/workspace/plhamK/plham/OrderBook.x10"
        this.time = ((time));
    }
    
    
    //#line 33 "/home/dsl/workspace/plhamK/plham/OrderBook.x10"
    public long getTime$O() {
        
        //#line 34 "/home/dsl/workspace/plhamK/plham/OrderBook.x10"
        final plham.Time t$31044 = ((this.time));
        
        //#line 34 "/home/dsl/workspace/plhamK/plham/OrderBook.x10"
        final boolean t$31045 = ((t$31044) == (null));
        
        //#line 34 "/home/dsl/workspace/plhamK/plham/OrderBook.x10"
        if (t$31045) {
            
            //#line 35 "/home/dsl/workspace/plhamK/plham/OrderBook.x10"
            return 0L;
        }
        
        //#line 37 "/home/dsl/workspace/plhamK/plham/OrderBook.x10"
        final plham.Time t$31046 = ((this.time));
        
        //#line 37 "/home/dsl/workspace/plhamK/plham/OrderBook.x10"
        final long t$31047 = t$31046.t;
        
        //#line 37 "/home/dsl/workspace/plhamK/plham/OrderBook.x10"
        return t$31047;
    }
    
    
    //#line 41 "/home/dsl/workspace/plhamK/plham/OrderBook.x10"
    /** For system use only. */
    public void popUntil() {
        
        //#line 42 "/home/dsl/workspace/plhamK/plham/OrderBook.x10"
        final long t = this.getTime$O();
        
        //#line 43 "/home/dsl/workspace/plhamK/plham/OrderBook.x10"
        final cassia.util.SortedQueue q = ((this.queue));
        
        //#line 44 "/home/dsl/workspace/plhamK/plham/OrderBook.x10"
        final long n = ((cassia.util.SortedQueue<plham.Order>)q).size$O();
        
        //#line 45 "/home/dsl/workspace/plhamK/plham/OrderBook.x10"
        while (true) {
            
            //#line 45 "/home/dsl/workspace/plhamK/plham/OrderBook.x10"
            final long t$31048 = ((cassia.util.SortedQueue<plham.Order>)q).size$O();
            
            //#line 45 "/home/dsl/workspace/plhamK/plham/OrderBook.x10"
            final boolean t$31053 = ((t$31048) > (((0L))));
            
            //#line 45 "/home/dsl/workspace/plhamK/plham/OrderBook.x10"
            if (!(t$31053)) {
                
                //#line 45 "/home/dsl/workspace/plhamK/plham/OrderBook.x10"
                break;
            }
            
            //#line 46 "/home/dsl/workspace/plhamK/plham/OrderBook.x10"
            final plham.Order order$31172 = ((cassia.util.SortedQueue<plham.Order>)q).peek$G();
            
            //#line 47 "/home/dsl/workspace/plhamK/plham/OrderBook.x10"
            boolean t$31173 = order$31172.isExpired$O((t));
            
            //#line 47 "/home/dsl/workspace/plhamK/plham/OrderBook.x10"
            if (!(t$31173)) {
                
                //#line 47 "/home/dsl/workspace/plhamK/plham/OrderBook.x10"
                t$31173 = this.isCancelled$O(((order$31172)));
            }
            
            //#line 47 "/home/dsl/workspace/plhamK/plham/OrderBook.x10"
            final boolean t$31174 = t$31173;
            
            //#line 47 "/home/dsl/workspace/plhamK/plham/OrderBook.x10"
            if (t$31174) {
                
                //#line 48 "/home/dsl/workspace/plhamK/plham/OrderBook.x10"
                ((cassia.util.SortedQueue<plham.Order>)q).pop$G();
                
                //#line 49 "/home/dsl/workspace/plhamK/plham/OrderBook.x10"
                final x10.util.Set t$31175 = ((this.cancelCache));
                
                //#line 49 "/home/dsl/workspace/plhamK/plham/OrderBook.x10"
                final plham.OrderBook.Key t$31176 = new plham.OrderBook.Key((java.lang.System[]) null).plham$OrderBook$Key$$init$S(((order$31172)));
                
                //#line 49 "/home/dsl/workspace/plhamK/plham/OrderBook.x10"
                ((x10.util.Collection<plham.OrderBook.Key>)t$31175).remove$Z(((t$31176)), plham.OrderBook.Key.$RTT);
            } else {
                
                //#line 51 "/home/dsl/workspace/plhamK/plham/OrderBook.x10"
                break;
            }
        }
    }
    
    
    //#line 57 "/home/dsl/workspace/plhamK/plham/OrderBook.x10"
    public long size$O() {
        
        //#line 58 "/home/dsl/workspace/plhamK/plham/OrderBook.x10"
        this.popUntil();
        
        //#line 59 "/home/dsl/workspace/plhamK/plham/OrderBook.x10"
        final cassia.util.SortedQueue t$31054 = ((this.queue));
        
        //#line 59 "/home/dsl/workspace/plhamK/plham/OrderBook.x10"
        final long t$31055 = ((cassia.util.SortedQueue<plham.Order>)t$31054).size$O();
        
        //#line 59 "/home/dsl/workspace/plhamK/plham/OrderBook.x10"
        return t$31055;
    }
    
    
    //#line 62 "/home/dsl/workspace/plhamK/plham/OrderBook.x10"
    public void add(final plham.Order order) {
        
        //#line 63 "/home/dsl/workspace/plhamK/plham/OrderBook.x10"
        final cassia.util.SortedQueue t$31056 = ((this.queue));
        
        //#line 63 "/home/dsl/workspace/plhamK/plham/OrderBook.x10"
        ((cassia.util.SortedQueue<plham.Order>)t$31056).add$Z(((order)), plham.Order.$RTT);
    }
    
    
    //#line 66 "/home/dsl/workspace/plhamK/plham/OrderBook.x10"
    public void remove(final plham.Order order) {
        
        //#line 67 "/home/dsl/workspace/plhamK/plham/OrderBook.x10"
        final cassia.util.SortedQueue t$31057 = ((this.queue));
        
        //#line 67 "/home/dsl/workspace/plhamK/plham/OrderBook.x10"
        final boolean t$31060 = x10.core.Boolean.$unbox(((cassia.util.SortedQueue<plham.Order>)t$31057).remove$Z(((order)), plham.Order.$RTT));
        
        //#line 67 "/home/dsl/workspace/plhamK/plham/OrderBook.x10"
        if (t$31060) {
            
            //#line 68 "/home/dsl/workspace/plhamK/plham/OrderBook.x10"
            final x10.util.Set t$31058 = ((this.cancelCache));
            
            //#line 68 "/home/dsl/workspace/plhamK/plham/OrderBook.x10"
            final plham.OrderBook.Key t$31059 = new plham.OrderBook.Key((java.lang.System[]) null).plham$OrderBook$Key$$init$S(((order)));
            
            //#line 68 "/home/dsl/workspace/plhamK/plham/OrderBook.x10"
            ((x10.util.Collection<plham.OrderBook.Key>)t$31058).remove$Z(((t$31059)), plham.OrderBook.Key.$RTT);
        }
    }
    
    
    //#line 75 "/home/dsl/workspace/plhamK/plham/OrderBook.x10"
    /**
	 * Get the order at the best bid(buy)/ask(sell).
	 */
    public plham.Order getBestOrder() {
        
        //#line 76 "/home/dsl/workspace/plhamK/plham/OrderBook.x10"
        this.popUntil();
        
        //#line 77 "/home/dsl/workspace/plhamK/plham/OrderBook.x10"
        final cassia.util.SortedQueue t$31061 = ((this.queue));
        
        //#line 77 "/home/dsl/workspace/plhamK/plham/OrderBook.x10"
        final long t$31062 = ((cassia.util.SortedQueue<plham.Order>)t$31061).size$O();
        
        //#line 77 "/home/dsl/workspace/plhamK/plham/OrderBook.x10"
        final boolean t$31065 = ((t$31062) > (((0L))));
        
        //#line 77 "/home/dsl/workspace/plhamK/plham/OrderBook.x10"
        if (t$31065) {
            
            //#line 78 "/home/dsl/workspace/plhamK/plham/OrderBook.x10"
            final cassia.util.SortedQueue t$31063 = ((this.queue));
            
            //#line 78 "/home/dsl/workspace/plhamK/plham/OrderBook.x10"
            final plham.Order t$31064 = ((cassia.util.SortedQueue<plham.Order>)t$31063).peek$G();
            
            //#line 78 "/home/dsl/workspace/plhamK/plham/OrderBook.x10"
            return t$31064;
        }
        
        //#line 80 "/home/dsl/workspace/plhamK/plham/OrderBook.x10"
        return null;
    }
    
    
    //#line 86 "/home/dsl/workspace/plhamK/plham/OrderBook.x10"
    /**
	 * Remove all orders satisfying the condition <code>p</code>.
	 */
    public boolean removeAllWhere__0$1plham$Order$3x10$lang$Boolean$2$O(final x10.core.fun.Fun_0_1 p) {
        
        //#line 88 "/home/dsl/workspace/plhamK/plham/OrderBook.x10"
        final x10.core.fun.Fun_0_1 f = ((new plham.OrderBook.$Closure$22(this, p, (plham.OrderBook.$Closure$22.__1$1plham$Order$3x10$lang$Boolean$2) null)));
        
        //#line 93 "/home/dsl/workspace/plhamK/plham/OrderBook.x10"
        final cassia.util.SortedQueue t$31068 = ((this.queue));
        
        //#line 93 "/home/dsl/workspace/plhamK/plham/OrderBook.x10"
        final boolean t$31069 = x10.core.Boolean.$unbox(((cassia.util.SortedQueue<plham.Order>)t$31068).removeAllWhere$Z(((f)), x10.rtt.ParameterizedType.make(x10.core.fun.Fun_0_1.$RTT,plham.Order.$RTT,x10.rtt.Types.BOOLEAN)));
        
        //#line 93 "/home/dsl/workspace/plhamK/plham/OrderBook.x10"
        return t$31069;
    }
    
    
    //#line 99 "/home/dsl/workspace/plhamK/plham/OrderBook.x10"
    /**
	 * Get the price of the best bid(buy)/ask(sell) order.
	 */
    public double getBestPrice$O() {
        
        //#line 100 "/home/dsl/workspace/plhamK/plham/OrderBook.x10"
        this.popUntil();
        
        //#line 101 "/home/dsl/workspace/plhamK/plham/OrderBook.x10"
        final cassia.util.SortedQueue t$31070 = ((this.queue));
        
        //#line 101 "/home/dsl/workspace/plhamK/plham/OrderBook.x10"
        final long t$31071 = ((cassia.util.SortedQueue<plham.Order>)t$31070).size$O();
        
        //#line 101 "/home/dsl/workspace/plhamK/plham/OrderBook.x10"
        final boolean t$31075 = ((t$31071) > (((0L))));
        
        //#line 101 "/home/dsl/workspace/plhamK/plham/OrderBook.x10"
        if (t$31075) {
            
            //#line 102 "/home/dsl/workspace/plhamK/plham/OrderBook.x10"
            final cassia.util.SortedQueue t$31072 = ((this.queue));
            
            //#line 102 "/home/dsl/workspace/plhamK/plham/OrderBook.x10"
            final plham.Order t$31073 = ((cassia.util.SortedQueue<plham.Order>)t$31072).peek$G();
            
            //#line 102 "/home/dsl/workspace/plhamK/plham/OrderBook.x10"
            final double t$31074 = t$31073.getPrice$O();
            
            //#line 102 "/home/dsl/workspace/plhamK/plham/OrderBook.x10"
            return t$31074;
        }
        
        //#line 104 "/home/dsl/workspace/plhamK/plham/OrderBook.x10"
        final double t$31076 = java.lang.Double.NaN;
        
        //#line 104 "/home/dsl/workspace/plhamK/plham/OrderBook.x10"
        return t$31076;
    }
    
    
    //#line 113 "/home/dsl/workspace/plhamK/plham/OrderBook.x10"
    /**
	 * Cancel the order.
	 * This should not be called directly by agents.
	 * Use {@link plham.Cancel} instead.
	 * @param order  a cancel request
	 */
    public void cancel(final plham.Order order) {
        
        //#line 114 "/home/dsl/workspace/plhamK/plham/OrderBook.x10"
        assert ((order.orderId) > (((0L)))): "Cancel requests must have orderId > 0";
        
        //#line 115 "/home/dsl/workspace/plhamK/plham/OrderBook.x10"
        final long t$31077 = order.orderId;
        
        //#line 115 "/home/dsl/workspace/plhamK/plham/OrderBook.x10"
        final boolean t$31080 = ((t$31077) > (((0L))));
        
        //#line 115 "/home/dsl/workspace/plhamK/plham/OrderBook.x10"
        if (t$31080) {
            
            //#line 116 "/home/dsl/workspace/plhamK/plham/OrderBook.x10"
            final x10.util.Set t$31078 = ((this.cancelCache));
            
            //#line 116 "/home/dsl/workspace/plhamK/plham/OrderBook.x10"
            final plham.OrderBook.Key t$31079 = new plham.OrderBook.Key((java.lang.System[]) null).plham$OrderBook$Key$$init$S(((order)));
            
            //#line 116 "/home/dsl/workspace/plhamK/plham/OrderBook.x10"
            ((x10.util.Collection<plham.OrderBook.Key>)t$31078).add$Z(((t$31079)), plham.OrderBook.Key.$RTT);
        }
    }
    
    
    //#line 127 "/home/dsl/workspace/plhamK/plham/OrderBook.x10"
    /**
	 * Test if the order (having <code>agentId</code> and <code>orderId</code>) is requested for cancel.
	 * @param order
	 * @return
	 * @see plham.Cancel
	 */
    public boolean isCancelled$O(final plham.Order order) {
        
        //#line 127 "/home/dsl/workspace/plhamK/plham/OrderBook.x10"
        final x10.util.Set t$31081 = ((this.cancelCache));
        
        //#line 127 "/home/dsl/workspace/plhamK/plham/OrderBook.x10"
        final plham.OrderBook.Key t$31082 = new plham.OrderBook.Key((java.lang.System[]) null).plham$OrderBook$Key$$init$S(((order)));
        
        //#line 127 "/home/dsl/workspace/plhamK/plham/OrderBook.x10"
        final boolean t$31083 = x10.core.Boolean.$unbox(((x10.util.Container<plham.OrderBook.Key>)t$31081).contains$Z(((t$31082)), plham.OrderBook.Key.$RTT));
        
        //#line 127 "/home/dsl/workspace/plhamK/plham/OrderBook.x10"
        return t$31083;
    }
    
    
    //#line 129 "/home/dsl/workspace/plhamK/plham/OrderBook.x10"
    private static x10.core.fun.Fun_0_2<plham.Order,plham.Order,x10.core.Int> LOWERS_FIRST;
    
    //#line 145 "/home/dsl/workspace/plhamK/plham/OrderBook.x10"
    private static x10.core.fun.Fun_0_2<plham.Order,plham.Order,x10.core.Int> HIGHERS_FIRST;
    
    //#line 162 "/home/dsl/workspace/plhamK/plham/OrderBook.x10"
    /** For system use only. */
    
    public static class Key extends x10.core.Struct implements x10.serialization.X10JavaSerializable
    {
        public static final x10.rtt.RuntimeType<Key> $RTT = 
            x10.rtt.NamedStructType.<Key> make("plham.OrderBook.Key",
                                               Key.class,
                                               new x10.rtt.Type[] {
                                                   x10.rtt.Types.STRUCT
                                               });
        
        public x10.rtt.RuntimeType<?> $getRTT() { return $RTT; }
        
        public x10.rtt.Type<?> $getParam(int i) { return null; }
        
        private Object writeReplace() throws java.io.ObjectStreamException {
            return new x10.serialization.SerializationProxy(this);
        }
        
        public static x10.serialization.X10JavaSerializable $_deserialize_body(plham.OrderBook.Key $_obj, x10.serialization.X10JavaDeserializer $deserializer) throws java.io.IOException {
            if (x10.runtime.impl.java.Runtime.TRACE_SER) { x10.runtime.impl.java.Runtime.printTraceMessage("X10JavaSerializable: $_deserialize_body() of " + Key.class + " calling"); } 
            $_obj.agentId = $deserializer.readLong();
            $_obj.orderId = $deserializer.readLong();
            return $_obj;
        }
        
        public static x10.serialization.X10JavaSerializable $_deserializer(x10.serialization.X10JavaDeserializer $deserializer) throws java.io.IOException {
            plham.OrderBook.Key $_obj = new plham.OrderBook.Key((java.lang.System[]) null);
            return $_deserialize_body($_obj, $deserializer);
        }
        
        public void $_serialize(x10.serialization.X10JavaSerializer $serializer) throws java.io.IOException {
            $serializer.write(this.agentId);
            $serializer.write(this.orderId);
            
        }
        
        // zero value constructor
        public Key(final java.lang.System $dummy) { this.agentId = 0L; this.orderId = 0L; }
        
        // constructor just for allocation
        public Key(final java.lang.System[] $dummy) {
            
        }
        
        
    
        
        //#line 164 "/home/dsl/workspace/plhamK/plham/OrderBook.x10"
        public long agentId;
        
        //#line 165 "/home/dsl/workspace/plhamK/plham/OrderBook.x10"
        public long orderId;
        
        
        //#line 167 "/home/dsl/workspace/plhamK/plham/OrderBook.x10"
        // creation method for java code (1-phase java constructor)
        public Key(final plham.Order order) {
            this((java.lang.System[]) null);
            plham$OrderBook$Key$$init$S(order);
        }
        
        // constructor for non-virtual call
        final public plham.OrderBook.Key plham$OrderBook$Key$$init$S(final plham.Order order) {
             {
                
                //#line 168 "/home/dsl/workspace/plhamK/plham/OrderBook.x10"
                final long t$31084 = order.agentId;
                
                //#line 168 "/home/dsl/workspace/plhamK/plham/OrderBook.x10"
                final long t$31085 = order.orderId;
                
                //#line 168 "/home/dsl/workspace/plhamK/plham/OrderBook.x10"
                /*this.*/plham$OrderBook$Key$$init$S(t$31084, t$31085);
            }
            return this;
        }
        
        
        
        //#line 171 "/home/dsl/workspace/plhamK/plham/OrderBook.x10"
        // creation method for java code (1-phase java constructor)
        public Key(final long agentId, final long orderId) {
            this((java.lang.System[]) null);
            plham$OrderBook$Key$$init$S(agentId, orderId);
        }
        
        // constructor for non-virtual call
        final public plham.OrderBook.Key plham$OrderBook$Key$$init$S(final long agentId, final long orderId) {
             {
                
                //#line 171 "/home/dsl/workspace/plhamK/plham/OrderBook.x10"
                
                
                //#line 162 "/home/dsl/workspace/plhamK/plham/OrderBook.x10"
                this.__fieldInitializers_plham_OrderBook_Key();
                
                //#line 172 "/home/dsl/workspace/plhamK/plham/OrderBook.x10"
                this.agentId = agentId;
                
                //#line 173 "/home/dsl/workspace/plhamK/plham/OrderBook.x10"
                this.orderId = orderId;
            }
            return this;
        }
        
        
        
        //#line 162 "/home/dsl/workspace/plhamK/plham/OrderBook.x10"
        final public java.lang.String typeName() {
            try {
                return x10.rtt.Types.typeName(this);
            }
            catch (java.lang.Throwable exc$38108) {
                throw x10.runtime.impl.java.ThrowableUtils.ensureX10Exception(exc$38108);
            }
            
        }
        
        
        
        //#line 162 "/home/dsl/workspace/plhamK/plham/OrderBook.x10"
        final public java.lang.String toString() {
            
            //#line 162 "/home/dsl/workspace/plhamK/plham/OrderBook.x10"
            final java.lang.String t$31086 = "struct plham.OrderBook.Key: agentId=";
            
            //#line 162 "/home/dsl/workspace/plhamK/plham/OrderBook.x10"
            final long t$31087 = this.agentId;
            
            //#line 162 "/home/dsl/workspace/plhamK/plham/OrderBook.x10"
            final java.lang.String t$31088 = ((t$31086) + ((x10.core.Long.$box(t$31087))));
            
            //#line 162 "/home/dsl/workspace/plhamK/plham/OrderBook.x10"
            final java.lang.String t$31089 = ((t$31088) + (" orderId="));
            
            //#line 162 "/home/dsl/workspace/plhamK/plham/OrderBook.x10"
            final long t$31090 = this.orderId;
            
            //#line 162 "/home/dsl/workspace/plhamK/plham/OrderBook.x10"
            final java.lang.String t$31091 = ((t$31089) + ((x10.core.Long.$box(t$31090))));
            
            //#line 162 "/home/dsl/workspace/plhamK/plham/OrderBook.x10"
            return t$31091;
        }
        
        
        //#line 162 "/home/dsl/workspace/plhamK/plham/OrderBook.x10"
        final public int hashCode() {
            
            //#line 162 "/home/dsl/workspace/plhamK/plham/OrderBook.x10"
            int result = 1;
            
            //#line 162 "/home/dsl/workspace/plhamK/plham/OrderBook.x10"
            final int t$31092 = result;
            
            //#line 162 "/home/dsl/workspace/plhamK/plham/OrderBook.x10"
            final int t$31094 = ((8191) * (((t$31092))));
            
            //#line 162 "/home/dsl/workspace/plhamK/plham/OrderBook.x10"
            final long t$31093 = this.agentId;
            
            //#line 162 "/home/dsl/workspace/plhamK/plham/OrderBook.x10"
            final int t$31095 = x10.rtt.Types.hashCode(t$31093);
            
            //#line 162 "/home/dsl/workspace/plhamK/plham/OrderBook.x10"
            final int t$31096 = ((t$31094) + (((t$31095))));
            
            //#line 162 "/home/dsl/workspace/plhamK/plham/OrderBook.x10"
            result = t$31096;
            
            //#line 162 "/home/dsl/workspace/plhamK/plham/OrderBook.x10"
            final int t$31097 = result;
            
            //#line 162 "/home/dsl/workspace/plhamK/plham/OrderBook.x10"
            final int t$31099 = ((8191) * (((t$31097))));
            
            //#line 162 "/home/dsl/workspace/plhamK/plham/OrderBook.x10"
            final long t$31098 = this.orderId;
            
            //#line 162 "/home/dsl/workspace/plhamK/plham/OrderBook.x10"
            final int t$31100 = x10.rtt.Types.hashCode(t$31098);
            
            //#line 162 "/home/dsl/workspace/plhamK/plham/OrderBook.x10"
            final int t$31101 = ((t$31099) + (((t$31100))));
            
            //#line 162 "/home/dsl/workspace/plhamK/plham/OrderBook.x10"
            result = t$31101;
            
            //#line 162 "/home/dsl/workspace/plhamK/plham/OrderBook.x10"
            final int t$31102 = result;
            
            //#line 162 "/home/dsl/workspace/plhamK/plham/OrderBook.x10"
            return t$31102;
        }
        
        
        //#line 162 "/home/dsl/workspace/plhamK/plham/OrderBook.x10"
        final public boolean equals(java.lang.Object other) {
            
            //#line 162 "/home/dsl/workspace/plhamK/plham/OrderBook.x10"
            final java.lang.Object t$31103 = ((other));
            
            //#line 162 "/home/dsl/workspace/plhamK/plham/OrderBook.x10"
            final boolean t$31104 = plham.OrderBook.Key.$RTT.isInstance(t$31103);
            
            //#line 162 "/home/dsl/workspace/plhamK/plham/OrderBook.x10"
            final boolean t$31105 = !(t$31104);
            
            //#line 162 "/home/dsl/workspace/plhamK/plham/OrderBook.x10"
            if (t$31105) {
                
                //#line 162 "/home/dsl/workspace/plhamK/plham/OrderBook.x10"
                return false;
            }
            
            //#line 162 "/home/dsl/workspace/plhamK/plham/OrderBook.x10"
            final java.lang.Object t$31106 = ((other));
            
            //#line 162 "/home/dsl/workspace/plhamK/plham/OrderBook.x10"
            final plham.OrderBook.Key t$31107 = ((plham.OrderBook.Key)x10.rtt.Types.asStruct(plham.OrderBook.Key.$RTT,t$31106));
            
            //#line 162 "/home/dsl/workspace/plhamK/plham/OrderBook.x10"
            final boolean t$31108 = this.equals$O(((t$31107)));
            
            //#line 162 "/home/dsl/workspace/plhamK/plham/OrderBook.x10"
            return t$31108;
        }
        
        
        //#line 162 "/home/dsl/workspace/plhamK/plham/OrderBook.x10"
        final public boolean equals$O(plham.OrderBook.Key other) {
            
            //#line 162 "/home/dsl/workspace/plhamK/plham/OrderBook.x10"
            final long t$31110 = this.agentId;
            
            //#line 162 "/home/dsl/workspace/plhamK/plham/OrderBook.x10"
            final plham.OrderBook.Key t$31109 = ((other));
            
            //#line 162 "/home/dsl/workspace/plhamK/plham/OrderBook.x10"
            final long t$31111 = t$31109.agentId;
            
            //#line 162 "/home/dsl/workspace/plhamK/plham/OrderBook.x10"
            boolean t$31115 = (t$31110) == (t$31111);
            
            //#line 162 "/home/dsl/workspace/plhamK/plham/OrderBook.x10"
            if (t$31115) {
                
                //#line 162 "/home/dsl/workspace/plhamK/plham/OrderBook.x10"
                final long t$31113 = this.orderId;
                
                //#line 162 "/home/dsl/workspace/plhamK/plham/OrderBook.x10"
                final plham.OrderBook.Key t$31112 = ((other));
                
                //#line 162 "/home/dsl/workspace/plhamK/plham/OrderBook.x10"
                final long t$31114 = t$31112.orderId;
                
                //#line 162 "/home/dsl/workspace/plhamK/plham/OrderBook.x10"
                t$31115 = (t$31113) == (t$31114);
            }
            
            //#line 162 "/home/dsl/workspace/plhamK/plham/OrderBook.x10"
            final boolean t$31116 = t$31115;
            
            //#line 162 "/home/dsl/workspace/plhamK/plham/OrderBook.x10"
            return t$31116;
        }
        
        
        //#line 162 "/home/dsl/workspace/plhamK/plham/OrderBook.x10"
        final public boolean _struct_equals$O(java.lang.Object other) {
            
            //#line 162 "/home/dsl/workspace/plhamK/plham/OrderBook.x10"
            final java.lang.Object t$31117 = ((other));
            
            //#line 162 "/home/dsl/workspace/plhamK/plham/OrderBook.x10"
            final boolean t$31118 = plham.OrderBook.Key.$RTT.isInstance(t$31117);
            
            //#line 162 "/home/dsl/workspace/plhamK/plham/OrderBook.x10"
            final boolean t$31119 = !(t$31118);
            
            //#line 162 "/home/dsl/workspace/plhamK/plham/OrderBook.x10"
            if (t$31119) {
                
                //#line 162 "/home/dsl/workspace/plhamK/plham/OrderBook.x10"
                return false;
            }
            
            //#line 162 "/home/dsl/workspace/plhamK/plham/OrderBook.x10"
            final java.lang.Object t$31120 = ((other));
            
            //#line 162 "/home/dsl/workspace/plhamK/plham/OrderBook.x10"
            final plham.OrderBook.Key t$31121 = ((plham.OrderBook.Key)x10.rtt.Types.asStruct(plham.OrderBook.Key.$RTT,t$31120));
            
            //#line 162 "/home/dsl/workspace/plhamK/plham/OrderBook.x10"
            final boolean t$31122 = this._struct_equals$O(((t$31121)));
            
            //#line 162 "/home/dsl/workspace/plhamK/plham/OrderBook.x10"
            return t$31122;
        }
        
        
        //#line 162 "/home/dsl/workspace/plhamK/plham/OrderBook.x10"
        final public boolean _struct_equals$O(plham.OrderBook.Key other) {
            
            //#line 162 "/home/dsl/workspace/plhamK/plham/OrderBook.x10"
            final long t$31124 = this.agentId;
            
            //#line 162 "/home/dsl/workspace/plhamK/plham/OrderBook.x10"
            final plham.OrderBook.Key t$31123 = ((other));
            
            //#line 162 "/home/dsl/workspace/plhamK/plham/OrderBook.x10"
            final long t$31125 = t$31123.agentId;
            
            //#line 162 "/home/dsl/workspace/plhamK/plham/OrderBook.x10"
            boolean t$31129 = (t$31124) == (t$31125);
            
            //#line 162 "/home/dsl/workspace/plhamK/plham/OrderBook.x10"
            if (t$31129) {
                
                //#line 162 "/home/dsl/workspace/plhamK/plham/OrderBook.x10"
                final long t$31127 = this.orderId;
                
                //#line 162 "/home/dsl/workspace/plhamK/plham/OrderBook.x10"
                final plham.OrderBook.Key t$31126 = ((other));
                
                //#line 162 "/home/dsl/workspace/plhamK/plham/OrderBook.x10"
                final long t$31128 = t$31126.orderId;
                
                //#line 162 "/home/dsl/workspace/plhamK/plham/OrderBook.x10"
                t$31129 = (t$31127) == (t$31128);
            }
            
            //#line 162 "/home/dsl/workspace/plhamK/plham/OrderBook.x10"
            final boolean t$31130 = t$31129;
            
            //#line 162 "/home/dsl/workspace/plhamK/plham/OrderBook.x10"
            return t$31130;
        }
        
        
        //#line 162 "/home/dsl/workspace/plhamK/plham/OrderBook.x10"
        final public plham.OrderBook.Key plham$OrderBook$Key$$this$plham$OrderBook$Key() {
            
            //#line 162 "/home/dsl/workspace/plhamK/plham/OrderBook.x10"
            return plham.OrderBook.Key.this;
        }
        
        
        //#line 162 "/home/dsl/workspace/plhamK/plham/OrderBook.x10"
        final public void __fieldInitializers_plham_OrderBook_Key() {
            
        }
    }
    
    
    
    //#line 177 "/home/dsl/workspace/plhamK/plham/OrderBook.x10"
    public static void dump__0$1plham$Order$2(final x10.lang.Iterator<plham.Order> it, final long time) {
        
        //#line 178 "/home/dsl/workspace/plhamK/plham/OrderBook.x10"
        while (true) {
            
            //#line 178 "/home/dsl/workspace/plhamK/plham/OrderBook.x10"
            final boolean t$31140 = it.hasNext$O();
            
            //#line 178 "/home/dsl/workspace/plhamK/plham/OrderBook.x10"
            if (!(t$31140)) {
                
                //#line 178 "/home/dsl/workspace/plhamK/plham/OrderBook.x10"
                break;
            }
            
            //#line 179 "/home/dsl/workspace/plhamK/plham/OrderBook.x10"
            final plham.Order order$31177 = it.next$G();
            
            //#line 180 "/home/dsl/workspace/plhamK/plham/OrderBook.x10"
            final x10.io.Printer t$31178 = ((x10.io.Console.get$OUT()));
            
            //#line 181 "/home/dsl/workspace/plhamK/plham/OrderBook.x10"
            final plham.Order.Kind t$31179 = ((order$31177.kind));
            
            //#line 181 "/home/dsl/workspace/plhamK/plham/OrderBook.x10"
            final long t$31180 = t$31179.id;
            
            //#line 181 "/home/dsl/workspace/plhamK/plham/OrderBook.x10"
            final long t$31181 = order$31177.marketId;
            
            //#line 181 "/home/dsl/workspace/plhamK/plham/OrderBook.x10"
            final double t$31182 = order$31177.price;
            
            //#line 181 "/home/dsl/workspace/plhamK/plham/OrderBook.x10"
            final long t$31183 = order$31177.volume;
            
            //#line 180 "/home/dsl/workspace/plhamK/plham/OrderBook.x10"
            final x10.core.Rail t$31184 = ((x10.runtime.impl.java.ArrayUtils.<java.lang.Object> makeRailFromJavaArray(x10.rtt.Types.ANY, new java.lang.Object[] {"#BOOK", time, t$31180, t$31181, t$31182, t$31183, "", ""})));
            
            //#line 182 "/home/dsl/workspace/plhamK/plham/OrderBook.x10"
            final int t$31185 = java.lang.Integer.MAX_VALUE;
            
            //#line 180 "/home/dsl/workspace/plhamK/plham/OrderBook.x10"
            final java.lang.String t$31186 = x10.util.StringUtil.<java.lang.Object> formatArray__0$1x10$util$StringUtil$$T$2(x10.rtt.Types.ANY, ((t$31184)), ((" ")), (("")), (t$31185));
            
            //#line 180 "/home/dsl/workspace/plhamK/plham/OrderBook.x10"
            t$31178.println(((t$31186)));
        }
    }
    
    
    //#line 186 "/home/dsl/workspace/plhamK/plham/OrderBook.x10"
    public static void dump__0$1plham$Order$2(final x10.util.List<plham.Order> orders, final long time) {
        
        //#line 187 "/home/dsl/workspace/plhamK/plham/OrderBook.x10"
        final x10.util.ListIterator t$31141 = (orders.iterator());
        
        //#line 187 "/home/dsl/workspace/plhamK/plham/OrderBook.x10"
        plham.OrderBook.dump__0$1plham$Order$2(((t$31141)), (time));
    }
    
    
    //#line 193 "/home/dsl/workspace/plhamK/plham/OrderBook.x10"
    /**
	 * Dump this orderbook with the time-stamp in an <i>undefined</i> order.
	 */
    public void dump() {
        
        //#line 194 "/home/dsl/workspace/plhamK/plham/OrderBook.x10"
        final cassia.util.SortedQueue t$31142 = ((this.queue));
        
        //#line 194 "/home/dsl/workspace/plhamK/plham/OrderBook.x10"
        final x10.lang.Iterator t$31143 = (((cassia.util.SortedQueue<plham.Order>)t$31142).iterator());
        
        //#line 194 "/home/dsl/workspace/plhamK/plham/OrderBook.x10"
        final long t$31144 = this.getTime$O();
        
        //#line 194 "/home/dsl/workspace/plhamK/plham/OrderBook.x10"
        plham.OrderBook.dump__0$1plham$Order$2(((t$31143)), (t$31144));
    }
    
    
    //#line 200 "/home/dsl/workspace/plhamK/plham/OrderBook.x10"
    /**
	 * Dump this orderbook with the time-stamp in the <i>specified</i> order.
	 */
    public void dump__0$1plham$Order$3plham$Order$3x10$lang$Int$2(final x10.core.fun.Fun_0_2 comparator) {
        
        //#line 201 "/home/dsl/workspace/plhamK/plham/OrderBook.x10"
        final x10.util.List orders = this.toList__0$1plham$Order$3plham$Order$3x10$lang$Int$2(((comparator)));
        
        //#line 202 "/home/dsl/workspace/plhamK/plham/OrderBook.x10"
        final long t$31145 = this.getTime$O();
        
        //#line 202 "/home/dsl/workspace/plhamK/plham/OrderBook.x10"
        plham.OrderBook.dump__0$1plham$Order$2(((orders)), (t$31145));
    }
    
    
    //#line 208 "/home/dsl/workspace/plhamK/plham/OrderBook.x10"
    /**
	 * Get all orders in this orderbook sorted in an <i>undefined</i> order.
	 */
    public x10.util.List toList() {
        
        //#line 209 "/home/dsl/workspace/plhamK/plham/OrderBook.x10"
        final cassia.util.SortedQueue t$31146 = ((this.queue));
        
        //#line 209 "/home/dsl/workspace/plhamK/plham/OrderBook.x10"
        final x10.util.List t$31147 = (((cassia.util.SortedQueue<plham.Order>)t$31146).toList());
        
        //#line 209 "/home/dsl/workspace/plhamK/plham/OrderBook.x10"
        return t$31147;
    }
    
    
    //#line 215 "/home/dsl/workspace/plhamK/plham/OrderBook.x10"
    /**
	 * Get all orders in this orderbook sorted in the <i>specified</i> order.
	 */
    public x10.util.List toList__0$1plham$Order$3plham$Order$3x10$lang$Int$2(final x10.core.fun.Fun_0_2 comparator) {
        
        //#line 216 "/home/dsl/workspace/plhamK/plham/OrderBook.x10"
        final x10.util.List orders = this.toList();
        
        //#line 217 "/home/dsl/workspace/plhamK/plham/OrderBook.x10"
        ((x10.util.List<plham.Order>)orders).sort$V(((comparator)), x10.rtt.ParameterizedType.make(x10.core.fun.Fun_0_2.$RTT,plham.Order.$RTT,plham.Order.$RTT,x10.rtt.Types.INT));
        
        //#line 218 "/home/dsl/workspace/plhamK/plham/OrderBook.x10"
        return orders;
    }
    
    
    //#line 221 "/home/dsl/workspace/plhamK/plham/OrderBook.x10"
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
            OrderBook.main(args);
        }
    }
    
    // the original app-main method
    public static void main(final x10.core.Rail<java.lang.String> id$1285) {
        
        //#line 222 "/home/dsl/workspace/plhamK/plham/OrderBook.x10"
        final plham.agent.TestAgent agent = ((new plham.agent.TestAgent((java.lang.System[]) null).plham$agent$TestAgent$$init$S(((0L)))));
        
        //#line 223 "/home/dsl/workspace/plhamK/plham/OrderBook.x10"
        final plham.Market market = ((new plham.Market((java.lang.System[]) null).plham$Market$$init$S(((0L)))));
        
        //#line 224 "/home/dsl/workspace/plhamK/plham/OrderBook.x10"
        final x10.core.fun.Fun_0_2 t$31148 = ((plham.OrderBook.get$HIGHERS_FIRST()));
        
        //#line 224 "/home/dsl/workspace/plhamK/plham/OrderBook.x10"
        final plham.OrderBook book = ((new plham.OrderBook((java.lang.System[]) null).plham$OrderBook$$init$S(((t$31148)), (plham.OrderBook.__0$1plham$Order$3plham$Order$3x10$lang$Int$2) null)));
        
        //#line 225 "/home/dsl/workspace/plhamK/plham/OrderBook.x10"
        final long agentId = agent.id;
        
        //#line 226 "/home/dsl/workspace/plhamK/plham/OrderBook.x10"
        final plham.Order.Kind t$31149 = ((plham.Order.get$KIND_BUY_LIMIT_ORDER()));
        
        //#line 226 "/home/dsl/workspace/plhamK/plham/OrderBook.x10"
        final long t$31150 = market.id;
        
        //#line 226 "/home/dsl/workspace/plhamK/plham/OrderBook.x10"
        final plham.Order t$31151 = ((new plham.Order((java.lang.System[]) null).plham$Order$$init$S(((t$31149)), ((agentId)), ((t$31150)), ((100.0)), ((10L)), ((30L)), ((1L)))));
        
        //#line 226 "/home/dsl/workspace/plhamK/plham/OrderBook.x10"
        book.add(((t$31151)));
        
        //#line 227 "/home/dsl/workspace/plhamK/plham/OrderBook.x10"
        final plham.Order.Kind t$31152 = ((plham.Order.get$KIND_BUY_LIMIT_ORDER()));
        
        //#line 227 "/home/dsl/workspace/plhamK/plham/OrderBook.x10"
        final long t$31153 = market.id;
        
        //#line 227 "/home/dsl/workspace/plhamK/plham/OrderBook.x10"
        final plham.Order t$31154 = ((new plham.Order((java.lang.System[]) null).plham$Order$$init$S(((t$31152)), ((agentId)), ((t$31153)), ((50.0)), ((10L)), ((30L)), ((2L)))));
        
        //#line 227 "/home/dsl/workspace/plhamK/plham/OrderBook.x10"
        book.add(((t$31154)));
        
        //#line 228 "/home/dsl/workspace/plhamK/plham/OrderBook.x10"
        final plham.Order.Kind t$31155 = ((plham.Order.get$KIND_BUY_LIMIT_ORDER()));
        
        //#line 228 "/home/dsl/workspace/plhamK/plham/OrderBook.x10"
        final long t$31156 = market.id;
        
        //#line 228 "/home/dsl/workspace/plhamK/plham/OrderBook.x10"
        final plham.Order t$31157 = ((new plham.Order((java.lang.System[]) null).plham$Order$$init$S(((t$31155)), ((agentId)), ((t$31156)), ((50.0)), ((40L)), ((30L)), ((3L)))));
        
        //#line 228 "/home/dsl/workspace/plhamK/plham/OrderBook.x10"
        book.add(((t$31157)));
        
        //#line 229 "/home/dsl/workspace/plhamK/plham/OrderBook.x10"
        final plham.Order.Kind t$31158 = ((plham.Order.get$KIND_BUY_LIMIT_ORDER()));
        
        //#line 229 "/home/dsl/workspace/plhamK/plham/OrderBook.x10"
        final long t$31159 = market.id;
        
        //#line 229 "/home/dsl/workspace/plhamK/plham/OrderBook.x10"
        final plham.Order t$31160 = ((new plham.Order((java.lang.System[]) null).plham$Order$$init$S(((t$31158)), ((agentId)), ((t$31159)), ((100.0)), ((10L)), ((30L)), ((4L)))));
        
        //#line 229 "/home/dsl/workspace/plhamK/plham/OrderBook.x10"
        book.add(((t$31160)));
        
        //#line 230 "/home/dsl/workspace/plhamK/plham/OrderBook.x10"
        final plham.Order.Kind t$31161 = ((plham.Order.get$KIND_BUY_LIMIT_ORDER()));
        
        //#line 230 "/home/dsl/workspace/plhamK/plham/OrderBook.x10"
        final long t$31162 = market.id;
        
        //#line 230 "/home/dsl/workspace/plhamK/plham/OrderBook.x10"
        final plham.Order t$31163 = ((new plham.Order((java.lang.System[]) null).plham$Order$$init$S(((t$31161)), ((agentId)), ((long)(t$31162)), ((double)(70.0)), ((10L)), ((30L)), ((4L)))));
        
        //#line 230 "/home/dsl/workspace/plhamK/plham/OrderBook.x10"
        book.add(((plham.Order)(t$31163)));
        
        //#line 232 "/home/dsl/workspace/plhamK/plham/OrderBook.x10"
        final x10.io.Printer t$31165 = ((x10.io.Printer)(x10.io.Console.get$OUT()));
        
        //#line 232 "/home/dsl/workspace/plhamK/plham/OrderBook.x10"
        final plham.Order t$31164 = book.getBestOrder();
        
        //#line 232 "/home/dsl/workspace/plhamK/plham/OrderBook.x10"
        final java.lang.String t$31166 = (("THE BEST: ") + (t$31164));
        
        //#line 232 "/home/dsl/workspace/plhamK/plham/OrderBook.x10"
        t$31165.println(((java.lang.Object)(t$31166)));
        
        //#line 234 "/home/dsl/workspace/plhamK/plham/OrderBook.x10"
        final x10.io.Printer t$31167 = ((x10.io.Printer)(x10.io.Console.get$OUT()));
        
        //#line 234 "/home/dsl/workspace/plhamK/plham/OrderBook.x10"
        t$31167.println(((java.lang.Object)("LOWERS-FIRST")));
        
        //#line 235 "/home/dsl/workspace/plhamK/plham/OrderBook.x10"
        final x10.core.fun.Fun_0_2 t$31168 = ((x10.core.fun.Fun_0_2)(plham.OrderBook.get$LOWERS_FIRST()));
        
        //#line 235 "/home/dsl/workspace/plhamK/plham/OrderBook.x10"
        book.dump__0$1plham$Order$3plham$Order$3x10$lang$Int$2(((x10.core.fun.Fun_0_2)(t$31168)));
        
        //#line 237 "/home/dsl/workspace/plhamK/plham/OrderBook.x10"
        final x10.io.Printer t$31169 = ((x10.io.Printer)(x10.io.Console.get$OUT()));
        
        //#line 237 "/home/dsl/workspace/plhamK/plham/OrderBook.x10"
        t$31169.println(((java.lang.Object)("HIGHERS-FIRST")));
        
        //#line 238 "/home/dsl/workspace/plhamK/plham/OrderBook.x10"
        final x10.core.fun.Fun_0_2 t$31170 = ((x10.core.fun.Fun_0_2)(plham.OrderBook.get$HIGHERS_FIRST()));
        
        //#line 238 "/home/dsl/workspace/plhamK/plham/OrderBook.x10"
        book.dump__0$1plham$Order$3plham$Order$3x10$lang$Int$2(((x10.core.fun.Fun_0_2)(t$31170)));
    }
    
    
    //#line 17 "/home/dsl/workspace/plhamK/plham/OrderBook.x10"
    final public plham.OrderBook plham$OrderBook$$this$plham$OrderBook() {
        
        //#line 17 "/home/dsl/workspace/plhamK/plham/OrderBook.x10"
        return plham.OrderBook.this;
    }
    
    
    //#line 17 "/home/dsl/workspace/plhamK/plham/OrderBook.x10"
    final public void __fieldInitializers_plham_OrderBook() {
        
        //#line 17 "/home/dsl/workspace/plhamK/plham/OrderBook.x10"
        this.queue = null;
        
        //#line 17 "/home/dsl/workspace/plhamK/plham/OrderBook.x10"
        this.time = null;
        
        //#line 23 "/home/dsl/workspace/plhamK/plham/OrderBook.x10"
        final x10.util.HashSet t$31171 = ((x10.util.HashSet)(new x10.util.HashSet<plham.OrderBook.Key>((java.lang.System[]) null, plham.OrderBook.Key.$RTT).x10$util$HashSet$$init$S()));
        
        //#line 17 "/home/dsl/workspace/plhamK/plham/OrderBook.x10"
        this.cancelCache = ((x10.util.Set)(t$31171));
    }
    
    final private static x10.core.concurrent.AtomicInteger initStatus$HIGHERS_FIRST = new x10.core.concurrent.AtomicInteger(x10.runtime.impl.java.InitDispatcher.UNINITIALIZED);
    private static x10.lang.ExceptionInInitializer exception$HIGHERS_FIRST;
    final private static x10.core.concurrent.AtomicInteger initStatus$LOWERS_FIRST = new x10.core.concurrent.AtomicInteger(x10.runtime.impl.java.InitDispatcher.UNINITIALIZED);
    private static x10.lang.ExceptionInInitializer exception$LOWERS_FIRST;
    
    public static x10.core.fun.Fun_0_2 get$LOWERS_FIRST() {
        if (((int) plham.OrderBook.initStatus$LOWERS_FIRST.get()) == ((int) x10.runtime.impl.java.InitDispatcher.INITIALIZED)) {
            return plham.OrderBook.LOWERS_FIRST;
        }
        if (((int) plham.OrderBook.initStatus$LOWERS_FIRST.get()) == ((int) x10.runtime.impl.java.InitDispatcher.EXCEPTION_RAISED)) {
            if (((boolean) x10.runtime.impl.java.InitDispatcher.TRACE_STATIC_INIT) == ((boolean) true)) {
                x10.runtime.impl.java.InitDispatcher.printStaticInitMessage(((java.lang.String)("Rethrowing ExceptionInInitializer for field: plham.OrderBook.LOWERS_FIRST")));
            }
            throw plham.OrderBook.exception$LOWERS_FIRST;
        }
        if (plham.OrderBook.initStatus$LOWERS_FIRST.compareAndSet((int)(x10.runtime.impl.java.InitDispatcher.UNINITIALIZED), (int)(x10.runtime.impl.java.InitDispatcher.INITIALIZING))) {
            try {{
                plham.OrderBook.LOWERS_FIRST = ((x10.core.fun.Fun_0_2)(new plham.OrderBook.$Closure$23()));
            }}catch (java.lang.Throwable exc$31187) {
                plham.OrderBook.exception$LOWERS_FIRST = new x10.lang.ExceptionInInitializer(exc$31187);
                plham.OrderBook.initStatus$LOWERS_FIRST.set((int)(x10.runtime.impl.java.InitDispatcher.EXCEPTION_RAISED));
                x10.runtime.impl.java.InitDispatcher.lockInitialized();
                x10.runtime.impl.java.InitDispatcher.notifyInitialized();
                throw plham.OrderBook.exception$LOWERS_FIRST;
            }
            if (((boolean) x10.runtime.impl.java.InitDispatcher.TRACE_STATIC_INIT) == ((boolean) true)) {
                x10.runtime.impl.java.InitDispatcher.printStaticInitMessage(((java.lang.String)("Doing static initialization for field: plham.OrderBook.LOWERS_FIRST")));
            }
            plham.OrderBook.initStatus$LOWERS_FIRST.set((int)(x10.runtime.impl.java.InitDispatcher.INITIALIZED));
            x10.runtime.impl.java.InitDispatcher.lockInitialized();
            x10.runtime.impl.java.InitDispatcher.notifyInitialized();
        } else {
            if (plham.OrderBook.initStatus$LOWERS_FIRST.get() < x10.runtime.impl.java.InitDispatcher.INITIALIZED) {
                x10.runtime.impl.java.InitDispatcher.lockInitialized();
                while (plham.OrderBook.initStatus$LOWERS_FIRST.get() < x10.runtime.impl.java.InitDispatcher.INITIALIZED) {
                    x10.runtime.impl.java.InitDispatcher.awaitInitialized();
                }
                x10.runtime.impl.java.InitDispatcher.unlockInitialized();
                if (((int) plham.OrderBook.initStatus$LOWERS_FIRST.get()) == ((int) x10.runtime.impl.java.InitDispatcher.EXCEPTION_RAISED)) {
                    if (((boolean) x10.runtime.impl.java.InitDispatcher.TRACE_STATIC_INIT) == ((boolean) true)) {
                        x10.runtime.impl.java.InitDispatcher.printStaticInitMessage(((java.lang.String)("Rethrowing ExceptionInInitializer for field: plham.OrderBook.LOWERS_FIRST")));
                    }
                    throw plham.OrderBook.exception$LOWERS_FIRST;
                }
            }
        }
        return plham.OrderBook.LOWERS_FIRST;
    }
    
    public static x10.core.fun.Fun_0_2 get$HIGHERS_FIRST() {
        if (((int) plham.OrderBook.initStatus$HIGHERS_FIRST.get()) == ((int) x10.runtime.impl.java.InitDispatcher.INITIALIZED)) {
            return plham.OrderBook.HIGHERS_FIRST;
        }
        if (((int) plham.OrderBook.initStatus$HIGHERS_FIRST.get()) == ((int) x10.runtime.impl.java.InitDispatcher.EXCEPTION_RAISED)) {
            if (((boolean) x10.runtime.impl.java.InitDispatcher.TRACE_STATIC_INIT) == ((boolean) true)) {
                x10.runtime.impl.java.InitDispatcher.printStaticInitMessage(((java.lang.String)("Rethrowing ExceptionInInitializer for field: plham.OrderBook.HIGHERS_FIRST")));
            }
            throw plham.OrderBook.exception$HIGHERS_FIRST;
        }
        if (plham.OrderBook.initStatus$HIGHERS_FIRST.compareAndSet((int)(x10.runtime.impl.java.InitDispatcher.UNINITIALIZED), (int)(x10.runtime.impl.java.InitDispatcher.INITIALIZING))) {
            try {{
                plham.OrderBook.HIGHERS_FIRST = ((x10.core.fun.Fun_0_2)(new plham.OrderBook.$Closure$24()));
            }}catch (java.lang.Throwable exc$31188) {
                plham.OrderBook.exception$HIGHERS_FIRST = new x10.lang.ExceptionInInitializer(exc$31188);
                plham.OrderBook.initStatus$HIGHERS_FIRST.set((int)(x10.runtime.impl.java.InitDispatcher.EXCEPTION_RAISED));
                x10.runtime.impl.java.InitDispatcher.lockInitialized();
                x10.runtime.impl.java.InitDispatcher.notifyInitialized();
                throw plham.OrderBook.exception$HIGHERS_FIRST;
            }
            if (((boolean) x10.runtime.impl.java.InitDispatcher.TRACE_STATIC_INIT) == ((boolean) true)) {
                x10.runtime.impl.java.InitDispatcher.printStaticInitMessage(((java.lang.String)("Doing static initialization for field: plham.OrderBook.HIGHERS_FIRST")));
            }
            plham.OrderBook.initStatus$HIGHERS_FIRST.set((int)(x10.runtime.impl.java.InitDispatcher.INITIALIZED));
            x10.runtime.impl.java.InitDispatcher.lockInitialized();
            x10.runtime.impl.java.InitDispatcher.notifyInitialized();
        } else {
            if (plham.OrderBook.initStatus$HIGHERS_FIRST.get() < x10.runtime.impl.java.InitDispatcher.INITIALIZED) {
                x10.runtime.impl.java.InitDispatcher.lockInitialized();
                while (plham.OrderBook.initStatus$HIGHERS_FIRST.get() < x10.runtime.impl.java.InitDispatcher.INITIALIZED) {
                    x10.runtime.impl.java.InitDispatcher.awaitInitialized();
                }
                x10.runtime.impl.java.InitDispatcher.unlockInitialized();
                if (((int) plham.OrderBook.initStatus$HIGHERS_FIRST.get()) == ((int) x10.runtime.impl.java.InitDispatcher.EXCEPTION_RAISED)) {
                    if (((boolean) x10.runtime.impl.java.InitDispatcher.TRACE_STATIC_INIT) == ((boolean) true)) {
                        x10.runtime.impl.java.InitDispatcher.printStaticInitMessage(((java.lang.String)("Rethrowing ExceptionInInitializer for field: plham.OrderBook.HIGHERS_FIRST")));
                    }
                    throw plham.OrderBook.exception$HIGHERS_FIRST;
                }
            }
        }
        return plham.OrderBook.HIGHERS_FIRST;
    }
    
    
    final public static class $Closure$22 extends x10.core.Ref implements x10.core.fun.Fun_0_1, x10.serialization.X10JavaSerializable
    {
        public static final x10.rtt.RuntimeType<$Closure$22> $RTT = 
            x10.rtt.StaticFunType.<$Closure$22> make($Closure$22.class,
                                                     new x10.rtt.Type[] {
                                                         x10.rtt.ParameterizedType.make(x10.core.fun.Fun_0_1.$RTT, plham.Order.$RTT, x10.rtt.Types.BOOLEAN)
                                                     });
        
        public x10.rtt.RuntimeType<?> $getRTT() { return $RTT; }
        
        public x10.rtt.Type<?> $getParam(int i) { return null; }
        
        private Object writeReplace() throws java.io.ObjectStreamException {
            return new x10.serialization.SerializationProxy(this);
        }
        
        public static x10.serialization.X10JavaSerializable $_deserialize_body(plham.OrderBook.$Closure$22 $_obj, x10.serialization.X10JavaDeserializer $deserializer) throws java.io.IOException {
            if (x10.runtime.impl.java.Runtime.TRACE_SER) { x10.runtime.impl.java.Runtime.printTraceMessage("X10JavaSerializable: $_deserialize_body() of " + $Closure$22.class + " calling"); } 
            $_obj.out$$ = $deserializer.readObject();
            $_obj.p = $deserializer.readObject();
            return $_obj;
        }
        
        public static x10.serialization.X10JavaSerializable $_deserializer(x10.serialization.X10JavaDeserializer $deserializer) throws java.io.IOException {
            plham.OrderBook.$Closure$22 $_obj = new plham.OrderBook.$Closure$22((java.lang.System[]) null);
            $deserializer.record_reference($_obj);
            return $_deserialize_body($_obj, $deserializer);
        }
        
        public void $_serialize(x10.serialization.X10JavaSerializer $serializer) throws java.io.IOException {
            $serializer.write(this.out$$);
            $serializer.write(this.p);
            
        }
        
        // constructor just for allocation
        public $Closure$22(final java.lang.System[] $dummy) {
            
        }
        
        // dispatcher for method abstract public (Z1)=>U.operator()(a1:Z1):U
        public java.lang.Object $apply(final java.lang.Object a1, final x10.rtt.Type t1) {
            return x10.core.Boolean.$box($apply$O((plham.Order)a1));
            
        }
        
        // dispatcher for method abstract public (Z1)=>U.operator()(a1:Z1):U
        public boolean $apply$Z(final java.lang.Object a1, final x10.rtt.Type t1) {
            return $apply$O((plham.Order)a1);
            
        }
        
        // synthetic type for parameter mangling
        public static final class __1$1plham$Order$3x10$lang$Boolean$2 {}
        
    
        
        public boolean $apply$O(final plham.Order order) {
            
            //#line 89 "/home/dsl/workspace/plhamK/plham/OrderBook.x10"
            final boolean b = x10.core.Boolean.$unbox(((x10.core.fun.Fun_0_1<plham.Order,x10.core.Boolean>)this.p).$apply(order, plham.Order.$RTT));
            
            //#line 90 "/home/dsl/workspace/plhamK/plham/OrderBook.x10"
            if (b) {
                
                //#line 90 "/home/dsl/workspace/plhamK/plham/OrderBook.x10"
                final x10.util.Set t$31066 = ((x10.util.Set)(this.out$$.cancelCache));
                
                //#line 90 "/home/dsl/workspace/plhamK/plham/OrderBook.x10"
                final plham.OrderBook.Key t$31067 = new plham.OrderBook.Key((java.lang.System[]) null).plham$OrderBook$Key$$init$S(((plham.Order)(order)));
                
                //#line 90 "/home/dsl/workspace/plhamK/plham/OrderBook.x10"
                ((x10.util.Collection<plham.OrderBook.Key>)t$31066).remove$Z(((plham.OrderBook.Key)(t$31067)), plham.OrderBook.Key.$RTT);
            }
            
            //#line 91 "/home/dsl/workspace/plhamK/plham/OrderBook.x10"
            return b;
        }
        
        public plham.OrderBook out$$;
        public x10.core.fun.Fun_0_1<plham.Order,x10.core.Boolean> p;
        
        public $Closure$22(final plham.OrderBook out$$, final x10.core.fun.Fun_0_1<plham.Order,x10.core.Boolean> p, __1$1plham$Order$3x10$lang$Boolean$2 $dummy) {
             {
                this.out$$ = out$$;
                this.p = ((x10.core.fun.Fun_0_1)(p));
            }
        }
        
    }
    
    
    final public static class $Closure$23 extends x10.core.Ref implements x10.core.fun.Fun_0_2, x10.serialization.X10JavaSerializable
    {
        public static final x10.rtt.RuntimeType<$Closure$23> $RTT = 
            x10.rtt.StaticFunType.<$Closure$23> make($Closure$23.class,
                                                     new x10.rtt.Type[] {
                                                         x10.rtt.ParameterizedType.make(x10.core.fun.Fun_0_2.$RTT, plham.Order.$RTT, plham.Order.$RTT, x10.rtt.Types.INT)
                                                     });
        
        public x10.rtt.RuntimeType<?> $getRTT() { return $RTT; }
        
        public x10.rtt.Type<?> $getParam(int i) { return null; }
        
        private Object writeReplace() throws java.io.ObjectStreamException {
            return new x10.serialization.SerializationProxy(this);
        }
        
        public static x10.serialization.X10JavaSerializable $_deserialize_body(plham.OrderBook.$Closure$23 $_obj, x10.serialization.X10JavaDeserializer $deserializer) throws java.io.IOException {
            if (x10.runtime.impl.java.Runtime.TRACE_SER) { x10.runtime.impl.java.Runtime.printTraceMessage("X10JavaSerializable: $_deserialize_body() of " + $Closure$23.class + " calling"); } 
            return $_obj;
        }
        
        public static x10.serialization.X10JavaSerializable $_deserializer(x10.serialization.X10JavaDeserializer $deserializer) throws java.io.IOException {
            plham.OrderBook.$Closure$23 $_obj = new plham.OrderBook.$Closure$23((java.lang.System[]) null);
            $deserializer.record_reference($_obj);
            return $_deserialize_body($_obj, $deserializer);
        }
        
        public void $_serialize(x10.serialization.X10JavaSerializer $serializer) throws java.io.IOException {
            
        }
        
        // constructor just for allocation
        public $Closure$23(final java.lang.System[] $dummy) {
            
        }
        
        // dispatcher for method abstract public (Z1,Z2)=>U.operator()(a1:Z1, a2:Z2):U
        public java.lang.Object $apply(final java.lang.Object a1, final x10.rtt.Type t1, final java.lang.Object a2, final x10.rtt.Type t2) {
            return x10.core.Int.$box($apply$O((plham.Order)a1, (plham.Order)a2));
            
        }
        
        // dispatcher for method abstract public (Z1,Z2)=>U.operator()(a1:Z1, a2:Z2):U
        public int $apply$I(final java.lang.Object a1, final x10.rtt.Type t1, final java.lang.Object a2, final x10.rtt.Type t2) {
            return $apply$O((plham.Order)a1, (plham.Order)a2);
            
        }
        
        
    
        
        public int $apply$O(final plham.Order one, final plham.Order other) {
            
            //#line 130 "/home/dsl/workspace/plhamK/plham/OrderBook.x10"
            if (((one.price) < (((double)(other.price))))) {
                
                //#line 131 "/home/dsl/workspace/plhamK/plham/OrderBook.x10"
                return -1;
            }
            
            //#line 133 "/home/dsl/workspace/plhamK/plham/OrderBook.x10"
            if (((one.price) > (((double)(other.price))))) {
                
                //#line 134 "/home/dsl/workspace/plhamK/plham/OrderBook.x10"
                return 1;
            }
            
            //#line 136 "/home/dsl/workspace/plhamK/plham/OrderBook.x10"
            if (((one.timePlaced) < (((long)(other.timePlaced))))) {
                
                //#line 137 "/home/dsl/workspace/plhamK/plham/OrderBook.x10"
                return -1;
            }
            
            //#line 139 "/home/dsl/workspace/plhamK/plham/OrderBook.x10"
            if (((one.timePlaced) > (((long)(other.timePlaced))))) {
                
                //#line 140 "/home/dsl/workspace/plhamK/plham/OrderBook.x10"
                return 1;
            }
            
            //#line 142 "/home/dsl/workspace/plhamK/plham/OrderBook.x10"
            return 0;
        }
        
        public $Closure$23() {
             {
                
            }
        }
        
    }
    
    
    final public static class $Closure$24 extends x10.core.Ref implements x10.core.fun.Fun_0_2, x10.serialization.X10JavaSerializable
    {
        public static final x10.rtt.RuntimeType<$Closure$24> $RTT = 
            x10.rtt.StaticFunType.<$Closure$24> make($Closure$24.class,
                                                     new x10.rtt.Type[] {
                                                         x10.rtt.ParameterizedType.make(x10.core.fun.Fun_0_2.$RTT, plham.Order.$RTT, plham.Order.$RTT, x10.rtt.Types.INT)
                                                     });
        
        public x10.rtt.RuntimeType<?> $getRTT() { return $RTT; }
        
        public x10.rtt.Type<?> $getParam(int i) { return null; }
        
        private Object writeReplace() throws java.io.ObjectStreamException {
            return new x10.serialization.SerializationProxy(this);
        }
        
        public static x10.serialization.X10JavaSerializable $_deserialize_body(plham.OrderBook.$Closure$24 $_obj, x10.serialization.X10JavaDeserializer $deserializer) throws java.io.IOException {
            if (x10.runtime.impl.java.Runtime.TRACE_SER) { x10.runtime.impl.java.Runtime.printTraceMessage("X10JavaSerializable: $_deserialize_body() of " + $Closure$24.class + " calling"); } 
            return $_obj;
        }
        
        public static x10.serialization.X10JavaSerializable $_deserializer(x10.serialization.X10JavaDeserializer $deserializer) throws java.io.IOException {
            plham.OrderBook.$Closure$24 $_obj = new plham.OrderBook.$Closure$24((java.lang.System[]) null);
            $deserializer.record_reference($_obj);
            return $_deserialize_body($_obj, $deserializer);
        }
        
        public void $_serialize(x10.serialization.X10JavaSerializer $serializer) throws java.io.IOException {
            
        }
        
        // constructor just for allocation
        public $Closure$24(final java.lang.System[] $dummy) {
            
        }
        
        // dispatcher for method abstract public (Z1,Z2)=>U.operator()(a1:Z1, a2:Z2):U
        public java.lang.Object $apply(final java.lang.Object a1, final x10.rtt.Type t1, final java.lang.Object a2, final x10.rtt.Type t2) {
            return x10.core.Int.$box($apply$O((plham.Order)a1, (plham.Order)a2));
            
        }
        
        // dispatcher for method abstract public (Z1,Z2)=>U.operator()(a1:Z1, a2:Z2):U
        public int $apply$I(final java.lang.Object a1, final x10.rtt.Type t1, final java.lang.Object a2, final x10.rtt.Type t2) {
            return $apply$O((plham.Order)a1, (plham.Order)a2);
            
        }
        
        
    
        
        public int $apply$O(final plham.Order one, final plham.Order other) {
            
            //#line 146 "/home/dsl/workspace/plhamK/plham/OrderBook.x10"
            if (((one.price) > (((double)(other.price))))) {
                
                //#line 147 "/home/dsl/workspace/plhamK/plham/OrderBook.x10"
                return -1;
            }
            
            //#line 149 "/home/dsl/workspace/plhamK/plham/OrderBook.x10"
            if (((one.price) < (((double)(other.price))))) {
                
                //#line 150 "/home/dsl/workspace/plhamK/plham/OrderBook.x10"
                return 1;
            }
            
            //#line 152 "/home/dsl/workspace/plhamK/plham/OrderBook.x10"
            if (((one.timePlaced) < (((long)(other.timePlaced))))) {
                
                //#line 153 "/home/dsl/workspace/plhamK/plham/OrderBook.x10"
                return -1;
            }
            
            //#line 155 "/home/dsl/workspace/plhamK/plham/OrderBook.x10"
            if (((one.timePlaced) > (((long)(other.timePlaced))))) {
                
                //#line 156 "/home/dsl/workspace/plhamK/plham/OrderBook.x10"
                return 1;
            }
            
            //#line 158 "/home/dsl/workspace/plhamK/plham/OrderBook.x10"
            return 0;
        }
        
        public $Closure$24() {
             {
                
            }
        }
        
    }
    
}

