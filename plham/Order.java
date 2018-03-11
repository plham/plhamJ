package plham;

/**
 * A data structure for orders.
 * 
 * <p>Specify<ul>
 * <li> Type (kind): {buy, sell} x {limit, market}
 * <li> Price
 * <li> Volume
 * <li> Expiry time (relative)
 * </ul>
 */

public class Order extends x10.core.Ref implements x10.serialization.X10JavaSerializable
{
    public static final x10.rtt.RuntimeType<Order> $RTT = 
        x10.rtt.NamedType.<Order> make("plham.Order",
                                       Order.class);
    
    public x10.rtt.RuntimeType<?> $getRTT() { return $RTT; }
    
    public x10.rtt.Type<?> $getParam(int i) { return null; }
    
    private Object writeReplace() throws java.io.ObjectStreamException {
        return new x10.serialization.SerializationProxy(this);
    }
    
    public static x10.serialization.X10JavaSerializable $_deserialize_body(plham.Order $_obj, x10.serialization.X10JavaDeserializer $deserializer) throws java.io.IOException {
        if (x10.runtime.impl.java.Runtime.TRACE_SER) { x10.runtime.impl.java.Runtime.printTraceMessage("X10JavaSerializable: $_deserialize_body() of " + Order.class + " calling"); } 
        $_obj.agentId = $deserializer.readLong();
        $_obj.kind = $deserializer.readObject();
        $_obj.marketId = $deserializer.readLong();
        $_obj.orderId = $deserializer.readLong();
        $_obj.price = $deserializer.readDouble();
        $_obj.timeLength = $deserializer.readLong();
        $_obj.timePlaced = $deserializer.readLong();
        $_obj.volume = $deserializer.readLong();
        return $_obj;
    }
    
    public static x10.serialization.X10JavaSerializable $_deserializer(x10.serialization.X10JavaDeserializer $deserializer) throws java.io.IOException {
        plham.Order $_obj = new plham.Order((java.lang.System[]) null);
        $deserializer.record_reference($_obj);
        return $_deserialize_body($_obj, $deserializer);
    }
    
    public void $_serialize(x10.serialization.X10JavaSerializer $serializer) throws java.io.IOException {
        $serializer.write(this.agentId);
        $serializer.write(this.kind);
        $serializer.write(this.marketId);
        $serializer.write(this.orderId);
        $serializer.write(this.price);
        $serializer.write(this.timeLength);
        $serializer.write(this.timePlaced);
        $serializer.write(this.volume);
        
    }
    
    // constructor just for allocation
    public Order(final java.lang.System[] $dummy) {
        
    }
    
    

    
    //#line 15 "/home/dsl/workspace/plhamK/plham/Order.x10"
    
    public static class Kind extends x10.core.Struct implements x10.serialization.X10JavaSerializable
    {
        public static final x10.rtt.RuntimeType<Kind> $RTT = 
            x10.rtt.NamedStructType.<Kind> make("plham.Order.Kind",
                                                Kind.class,
                                                new x10.rtt.Type[] {
                                                    x10.rtt.Types.STRUCT
                                                });
        
        public x10.rtt.RuntimeType<?> $getRTT() { return $RTT; }
        
        public x10.rtt.Type<?> $getParam(int i) { return null; }
        
        private Object writeReplace() throws java.io.ObjectStreamException {
            return new x10.serialization.SerializationProxy(this);
        }
        
        public static x10.serialization.X10JavaSerializable $_deserialize_body(plham.Order.Kind $_obj, x10.serialization.X10JavaDeserializer $deserializer) throws java.io.IOException {
            if (x10.runtime.impl.java.Runtime.TRACE_SER) { x10.runtime.impl.java.Runtime.printTraceMessage("X10JavaSerializable: $_deserialize_body() of " + Kind.class + " calling"); } 
            $_obj.id = $deserializer.readLong();
            return $_obj;
        }
        
        public static x10.serialization.X10JavaSerializable $_deserializer(x10.serialization.X10JavaDeserializer $deserializer) throws java.io.IOException {
            plham.Order.Kind $_obj = new plham.Order.Kind((java.lang.System[]) null);
            return $_deserialize_body($_obj, $deserializer);
        }
        
        public void $_serialize(x10.serialization.X10JavaSerializer $serializer) throws java.io.IOException {
            $serializer.write(this.id);
            
        }
        
        // zero value constructor
        public Kind(final java.lang.System $dummy) { this.id = 0L; }
        
        // constructor just for allocation
        public Kind(final java.lang.System[] $dummy) {
            
        }
        
        
        // properties
        
        //#line 15 "/home/dsl/workspace/plhamK/plham/Order.x10"
        public long id;
        
    
        
        
        //#line 15 "/home/dsl/workspace/plhamK/plham/Order.x10"
        final public java.lang.String typeName() {
            try {
                return x10.rtt.Types.typeName(this);
            }
            catch (java.lang.Throwable exc$38109) {
                throw x10.runtime.impl.java.ThrowableUtils.ensureX10Exception(exc$38109);
            }
            
        }
        
        
        
        //#line 15 "/home/dsl/workspace/plhamK/plham/Order.x10"
        final public java.lang.String toString() {
            
            //#line 15 "/home/dsl/workspace/plhamK/plham/Order.x10"
            final java.lang.String t$31311 = "struct plham.Order.Kind: id=";
            
            //#line 15 "/home/dsl/workspace/plhamK/plham/Order.x10"
            final long t$31312 = this.id;
            
            //#line 15 "/home/dsl/workspace/plhamK/plham/Order.x10"
            final java.lang.String t$31313 = ((t$31311) + ((x10.core.Long.$box(t$31312))));
            
            //#line 15 "/home/dsl/workspace/plhamK/plham/Order.x10"
            return t$31313;
        }
        
        
        //#line 15 "/home/dsl/workspace/plhamK/plham/Order.x10"
        final public int hashCode() {
            
            //#line 15 "/home/dsl/workspace/plhamK/plham/Order.x10"
            int result = 1;
            
            //#line 15 "/home/dsl/workspace/plhamK/plham/Order.x10"
            final int t$31314 = result;
            
            //#line 15 "/home/dsl/workspace/plhamK/plham/Order.x10"
            final int t$31316 = ((8191) * (((t$31314))));
            
            //#line 15 "/home/dsl/workspace/plhamK/plham/Order.x10"
            final long t$31315 = this.id;
            
            //#line 15 "/home/dsl/workspace/plhamK/plham/Order.x10"
            final int t$31317 = x10.rtt.Types.hashCode(t$31315);
            
            //#line 15 "/home/dsl/workspace/plhamK/plham/Order.x10"
            final int t$31318 = ((t$31316) + (((t$31317))));
            
            //#line 15 "/home/dsl/workspace/plhamK/plham/Order.x10"
            result = t$31318;
            
            //#line 15 "/home/dsl/workspace/plhamK/plham/Order.x10"
            final int t$31319 = result;
            
            //#line 15 "/home/dsl/workspace/plhamK/plham/Order.x10"
            return t$31319;
        }
        
        
        //#line 15 "/home/dsl/workspace/plhamK/plham/Order.x10"
        final public boolean equals(java.lang.Object other) {
            
            //#line 15 "/home/dsl/workspace/plhamK/plham/Order.x10"
            final java.lang.Object t$31320 = ((other));
            
            //#line 15 "/home/dsl/workspace/plhamK/plham/Order.x10"
            final boolean t$31321 = plham.Order.Kind.$RTT.isInstance(t$31320);
            
            //#line 15 "/home/dsl/workspace/plhamK/plham/Order.x10"
            final boolean t$31322 = !(t$31321);
            
            //#line 15 "/home/dsl/workspace/plhamK/plham/Order.x10"
            if (t$31322) {
                
                //#line 15 "/home/dsl/workspace/plhamK/plham/Order.x10"
                return false;
            }
            
            //#line 15 "/home/dsl/workspace/plhamK/plham/Order.x10"
            final java.lang.Object t$31323 = ((other));
            
            //#line 15 "/home/dsl/workspace/plhamK/plham/Order.x10"
            final plham.Order.Kind t$31324 = ((plham.Order.Kind)x10.rtt.Types.asStruct(plham.Order.Kind.$RTT,t$31323));
            
            //#line 15 "/home/dsl/workspace/plhamK/plham/Order.x10"
            final boolean t$31325 = this.equals$O(((t$31324)));
            
            //#line 15 "/home/dsl/workspace/plhamK/plham/Order.x10"
            return t$31325;
        }
        
        
        //#line 15 "/home/dsl/workspace/plhamK/plham/Order.x10"
        final public boolean equals$O(plham.Order.Kind other) {
            
            //#line 15 "/home/dsl/workspace/plhamK/plham/Order.x10"
            final long t$31327 = this.id;
            
            //#line 15 "/home/dsl/workspace/plhamK/plham/Order.x10"
            final plham.Order.Kind t$31326 = ((other));
            
            //#line 15 "/home/dsl/workspace/plhamK/plham/Order.x10"
            final long t$31328 = t$31326.id;
            
            //#line 15 "/home/dsl/workspace/plhamK/plham/Order.x10"
            final boolean t$31329 = (t$31327) == (t$31328);
            
            //#line 15 "/home/dsl/workspace/plhamK/plham/Order.x10"
            return t$31329;
        }
        
        
        //#line 15 "/home/dsl/workspace/plhamK/plham/Order.x10"
        final public boolean _struct_equals$O(java.lang.Object other) {
            
            //#line 15 "/home/dsl/workspace/plhamK/plham/Order.x10"
            final java.lang.Object t$31330 = ((other));
            
            //#line 15 "/home/dsl/workspace/plhamK/plham/Order.x10"
            final boolean t$31331 = plham.Order.Kind.$RTT.isInstance(t$31330);
            
            //#line 15 "/home/dsl/workspace/plhamK/plham/Order.x10"
            final boolean t$31332 = !(t$31331);
            
            //#line 15 "/home/dsl/workspace/plhamK/plham/Order.x10"
            if (t$31332) {
                
                //#line 15 "/home/dsl/workspace/plhamK/plham/Order.x10"
                return false;
            }
            
            //#line 15 "/home/dsl/workspace/plhamK/plham/Order.x10"
            final java.lang.Object t$31333 = ((other));
            
            //#line 15 "/home/dsl/workspace/plhamK/plham/Order.x10"
            final plham.Order.Kind t$31334 = ((plham.Order.Kind)x10.rtt.Types.asStruct(plham.Order.Kind.$RTT,t$31333));
            
            //#line 15 "/home/dsl/workspace/plhamK/plham/Order.x10"
            final boolean t$31335 = this._struct_equals$O(((t$31334)));
            
            //#line 15 "/home/dsl/workspace/plhamK/plham/Order.x10"
            return t$31335;
        }
        
        
        //#line 15 "/home/dsl/workspace/plhamK/plham/Order.x10"
        final public boolean _struct_equals$O(plham.Order.Kind other) {
            
            //#line 15 "/home/dsl/workspace/plhamK/plham/Order.x10"
            final long t$31337 = this.id;
            
            //#line 15 "/home/dsl/workspace/plhamK/plham/Order.x10"
            final plham.Order.Kind t$31336 = ((other));
            
            //#line 15 "/home/dsl/workspace/plhamK/plham/Order.x10"
            final long t$31338 = t$31336.id;
            
            //#line 15 "/home/dsl/workspace/plhamK/plham/Order.x10"
            final boolean t$31339 = (t$31337) == (t$31338);
            
            //#line 15 "/home/dsl/workspace/plhamK/plham/Order.x10"
            return t$31339;
        }
        
        
        //#line 15 "/home/dsl/workspace/plhamK/plham/Order.x10"
        final public plham.Order.Kind plham$Order$Kind$$this$plham$Order$Kind() {
            
            //#line 15 "/home/dsl/workspace/plhamK/plham/Order.x10"
            return plham.Order.Kind.this;
        }
        
        
        //#line 15 "/home/dsl/workspace/plhamK/plham/Order.x10"
        // creation method for java code (1-phase java constructor)
        public Kind(final long id) {
            this((java.lang.System[]) null);
            plham$Order$Kind$$init$S(id);
        }
        
        // constructor for non-virtual call
        final public plham.Order.Kind plham$Order$Kind$$init$S(final long id) {
             {
                
                //#line 15 "/home/dsl/workspace/plhamK/plham/Order.x10"
                this.id = id;
                
                
                //#line 15 "/home/dsl/workspace/plhamK/plham/Order.x10"
                this.__fieldInitializers_plham_Order_Kind();
            }
            return this;
        }
        
        
        
        //#line 15 "/home/dsl/workspace/plhamK/plham/Order.x10"
        final public void __fieldInitializers_plham_Order_Kind() {
            
        }
    }
    
    
    //#line 16 "/home/dsl/workspace/plhamK/plham/Order.x10"
    private static plham.Order.Kind KIND_BUY_MARKET_ORDER;
    
    //#line 17 "/home/dsl/workspace/plhamK/plham/Order.x10"
    private static plham.Order.Kind KIND_SELL_MARKET_ORDER;
    
    //#line 18 "/home/dsl/workspace/plhamK/plham/Order.x10"
    private static plham.Order.Kind KIND_BUY_LIMIT_ORDER;
    
    //#line 19 "/home/dsl/workspace/plhamK/plham/Order.x10"
    private static plham.Order.Kind KIND_SELL_LIMIT_ORDER;
    
    //#line 22 "/home/dsl/workspace/plhamK/plham/Order.x10"
    /** Use if a market order */
    final public static double NO_PRICE = java.lang.Double.MAX_VALUE;
    
    //#line 24 "/home/dsl/workspace/plhamK/plham/Order.x10"
    public plham.Order.Kind kind;
    
    //#line 25 "/home/dsl/workspace/plhamK/plham/Order.x10"
    public long agentId;
    
    //#line 26 "/home/dsl/workspace/plhamK/plham/Order.x10"
    public long marketId;
    
    //#line 27 "/home/dsl/workspace/plhamK/plham/Order.x10"
    public double price;
    
    //#line 28 "/home/dsl/workspace/plhamK/plham/Order.x10"
    public long volume;
    
    //#line 30 "/home/dsl/workspace/plhamK/plham/Order.x10"
    /** The relative term until the expiry time (due time). */
    public long timeLength;
    
    //#line 32 "/home/dsl/workspace/plhamK/plham/Order.x10"
    /** The time when this order is placed. I.e. <code>market.getTime()</code>. */
    public long timePlaced;
    
    //#line 34 "/home/dsl/workspace/plhamK/plham/Order.x10"
    /** The order id used for consulting and to notify its execution (set to 0 if unnecessary; this is by default). */
    public long orderId;
    
    
    //#line 37 "/home/dsl/workspace/plhamK/plham/Order.x10"
    /** Do not use this. */
    // creation method for java code (1-phase java constructor)
    public Order(final plham.Order.Kind kind, final long agentId, final long marketId, final double price, final long volume, final long timeLength, final long timePlaced, final long orderId) {
        this((java.lang.System[]) null);
        plham$Order$$init$S(kind, agentId, marketId, price, volume, timeLength, timePlaced, orderId);
    }
    
    // constructor for non-virtual call
    final public plham.Order plham$Order$$init$S(final plham.Order.Kind kind, final long agentId, final long marketId, final double price, final long volume, final long timeLength, final long timePlaced, final long orderId) {
         {
            
            //#line 37 "/home/dsl/workspace/plhamK/plham/Order.x10"
            
            
            //#line 13 "/home/dsl/workspace/plhamK/plham/Order.x10"
            this.__fieldInitializers_plham_Order();
            
            //#line 38 "/home/dsl/workspace/plhamK/plham/Order.x10"
            assert ((price) >= (((0.0)))): "price >= 0.0";
            
            //#line 39 "/home/dsl/workspace/plhamK/plham/Order.x10"
            assert ((volume) >= (((0L)))): "volume >= 0";
            
            //#line 40 "/home/dsl/workspace/plhamK/plham/Order.x10"
            this.kind = ((kind));
            
            //#line 41 "/home/dsl/workspace/plhamK/plham/Order.x10"
            this.agentId = agentId;
            
            //#line 42 "/home/dsl/workspace/plhamK/plham/Order.x10"
            this.marketId = marketId;
            
            //#line 43 "/home/dsl/workspace/plhamK/plham/Order.x10"
            this.price = price;
            
            //#line 44 "/home/dsl/workspace/plhamK/plham/Order.x10"
            this.volume = volume;
            
            //#line 45 "/home/dsl/workspace/plhamK/plham/Order.x10"
            this.timeLength = timeLength;
            
            //#line 46 "/home/dsl/workspace/plhamK/plham/Order.x10"
            this.timePlaced = timePlaced;
            
            //#line 47 "/home/dsl/workspace/plhamK/plham/Order.x10"
            this.orderId = orderId;
        }
        return this;
    }
    
    
    
    //#line 51 "/home/dsl/workspace/plhamK/plham/Order.x10"
    /** Do not use this. */
    // creation method for java code (1-phase java constructor)
    public Order(final plham.Order.Kind kind, final long agentId, final long marketId, final double price, final long volume, final long timeLength, final long timePlaced) {
        this((java.lang.System[]) null);
        plham$Order$$init$S(kind, agentId, marketId, price, volume, timeLength, timePlaced);
    }
    
    // constructor for non-virtual call
    final public plham.Order plham$Order$$init$S(final plham.Order.Kind kind, final long agentId, final long marketId, final double price, final long volume, final long timeLength, final long timePlaced) {
         {
            
            //#line 52 "/home/dsl/workspace/plhamK/plham/Order.x10"
            /*this.*/plham$Order$$init$S(((kind)), ((agentId)), ((marketId)), ((price)), ((volume)), ((timeLength)), ((timePlaced)), ((0L)));
        }
        return this;
    }
    
    
    
    //#line 55 "/home/dsl/workspace/plhamK/plham/Order.x10"
    // creation method for java code (1-phase java constructor)
    public Order(final plham.Order.Kind kind, final plham.Agent agent, final plham.Market market, final double price, final long volume, final long timeLength) {
        this((java.lang.System[]) null);
        plham$Order$$init$S(kind, agent, market, price, volume, timeLength);
    }
    
    // constructor for non-virtual call
    final public plham.Order plham$Order$$init$S(final plham.Order.Kind kind, final plham.Agent agent, final plham.Market market, final double price, final long volume, final long timeLength) {
         {
            
            //#line 56 "/home/dsl/workspace/plhamK/plham/Order.x10"
            final long t$31340 = agent.id;
            
            //#line 56 "/home/dsl/workspace/plhamK/plham/Order.x10"
            final long t$31341 = market.id;
            
            //#line 56 "/home/dsl/workspace/plhamK/plham/Order.x10"
            final long t$31342 = market.getTime$O();
            
            //#line 56 "/home/dsl/workspace/plhamK/plham/Order.x10"
            final long t$31343 = agent.nextOrderId();
            
            //#line 56 "/home/dsl/workspace/plhamK/plham/Order.x10"
            /*this.*/plham$Order$$init$S(((kind)), ((t$31340)), ((t$31341)), ((price)), ((volume)), ((timeLength)), t$31342, t$31343);
        }
        return this;
    }
    
    
    
    //#line 62 "/home/dsl/workspace/plhamK/plham/Order.x10"
    /**
	 * Create a copy.
	 */
    // creation method for java code (1-phase java constructor)
    public Order(final plham.Order other) {
        this((java.lang.System[]) null);
        init(other);
    }
    
    // constructor for non-virtual call
    public plham.Order init(final plham.Order other) {
         {
            
            //#line 62 "/home/dsl/workspace/plhamK/plham/Order.x10"
            
            
            //#line 13 "/home/dsl/workspace/plhamK/plham/Order.x10"
            this.__fieldInitializers_plham_Order();
            
            //#line 63 "/home/dsl/workspace/plhamK/plham/Order.x10"
            final plham.Order.Kind t$31344 = ((other.kind));
            
            //#line 63 "/home/dsl/workspace/plhamK/plham/Order.x10"
            this.kind = ((t$31344));
            
            //#line 64 "/home/dsl/workspace/plhamK/plham/Order.x10"
            final long t$31345 = other.agentId;
            
            //#line 64 "/home/dsl/workspace/plhamK/plham/Order.x10"
            this.agentId = t$31345;
            
            //#line 65 "/home/dsl/workspace/plhamK/plham/Order.x10"
            final long t$31346 = other.marketId;
            
            //#line 65 "/home/dsl/workspace/plhamK/plham/Order.x10"
            this.marketId = t$31346;
            
            //#line 66 "/home/dsl/workspace/plhamK/plham/Order.x10"
            final double t$31347 = other.price;
            
            //#line 66 "/home/dsl/workspace/plhamK/plham/Order.x10"
            this.price = t$31347;
            
            //#line 67 "/home/dsl/workspace/plhamK/plham/Order.x10"
            final long t$31348 = other.volume;
            
            //#line 67 "/home/dsl/workspace/plhamK/plham/Order.x10"
            this.volume = t$31348;
            
            //#line 68 "/home/dsl/workspace/plhamK/plham/Order.x10"
            final long t$31349 = other.timeLength;
            
            //#line 68 "/home/dsl/workspace/plhamK/plham/Order.x10"
            this.timeLength = t$31349;
            
            //#line 69 "/home/dsl/workspace/plhamK/plham/Order.x10"
            final long t$31350 = other.timePlaced;
            
            //#line 69 "/home/dsl/workspace/plhamK/plham/Order.x10"
            this.timePlaced = t$31350;
            
            //#line 70 "/home/dsl/workspace/plhamK/plham/Order.x10"
            final long t$31351 = other.orderId;
            
            //#line 70 "/home/dsl/workspace/plhamK/plham/Order.x10"
            this.orderId = t$31351;
        }
        return this;
    }
    
    
    
    //#line 73 "/home/dsl/workspace/plhamK/plham/Order.x10"
    public double getPrice$O() {
        
        //#line 73 "/home/dsl/workspace/plhamK/plham/Order.x10"
        final double t$31352 = this.price;
        
        //#line 73 "/home/dsl/workspace/plhamK/plham/Order.x10"
        return t$31352;
    }
    
    
    //#line 75 "/home/dsl/workspace/plhamK/plham/Order.x10"
    public double setPrice$O(final double price) {
        
        //#line 75 "/home/dsl/workspace/plhamK/plham/Order.x10"
        final double t$31353 = this.price = price;
        
        //#line 75 "/home/dsl/workspace/plhamK/plham/Order.x10"
        return t$31353;
    }
    
    
    //#line 77 "/home/dsl/workspace/plhamK/plham/Order.x10"
    public long getVolume$O() {
        
        //#line 77 "/home/dsl/workspace/plhamK/plham/Order.x10"
        final long t$31354 = this.volume;
        
        //#line 77 "/home/dsl/workspace/plhamK/plham/Order.x10"
        return t$31354;
    }
    
    
    //#line 79 "/home/dsl/workspace/plhamK/plham/Order.x10"
    public long setVolume$O(final long volume) {
        
        //#line 79 "/home/dsl/workspace/plhamK/plham/Order.x10"
        final long t$31355 = this.volume = volume;
        
        //#line 79 "/home/dsl/workspace/plhamK/plham/Order.x10"
        return t$31355;
    }
    
    
    //#line 84 "/home/dsl/workspace/plhamK/plham/Order.x10"
    /**
	 * Update the volume of this order by adding <code>delta</code>.
	 */
    public void updateVolume(final long delta) {
        
        //#line 85 "/home/dsl/workspace/plhamK/plham/Order.x10"
        final long t$31356 = this.volume;
        
        //#line 85 "/home/dsl/workspace/plhamK/plham/Order.x10"
        final long t$31357 = ((t$31356) + (((delta))));
        
        //#line 85 "/home/dsl/workspace/plhamK/plham/Order.x10"
        this.volume = t$31357;
        
        //#line 86 "/home/dsl/workspace/plhamK/plham/Order.x10"
        assert ((this.volume) >= (((0L))));
    }
    
    
    //#line 89 "/home/dsl/workspace/plhamK/plham/Order.x10"
    public boolean isBuyOrder$O() {
        
        //#line 90 "/home/dsl/workspace/plhamK/plham/Order.x10"
        final plham.Order.Kind t$31358 = ((this.kind));
        
        //#line 90 "/home/dsl/workspace/plhamK/plham/Order.x10"
        final plham.Order.Kind t$31359 = ((plham.Order.get$KIND_BUY_MARKET_ORDER()));
        
        //#line 90 "/home/dsl/workspace/plhamK/plham/Order.x10"
        boolean t$31362 = x10.rtt.Equality.equalsequals((t$31358),(t$31359));
        
        //#line 90 "/home/dsl/workspace/plhamK/plham/Order.x10"
        if (!(t$31362)) {
            
            //#line 90 "/home/dsl/workspace/plhamK/plham/Order.x10"
            final plham.Order.Kind t$31360 = ((this.kind));
            
            //#line 90 "/home/dsl/workspace/plhamK/plham/Order.x10"
            final plham.Order.Kind t$31361 = ((plham.Order.get$KIND_BUY_LIMIT_ORDER()));
            
            //#line 90 "/home/dsl/workspace/plhamK/plham/Order.x10"
            t$31362 = x10.rtt.Equality.equalsequals((t$31360),(t$31361));
        }
        
        //#line 90 "/home/dsl/workspace/plhamK/plham/Order.x10"
        final boolean t$31363 = t$31362;
        
        //#line 90 "/home/dsl/workspace/plhamK/plham/Order.x10"
        return t$31363;
    }
    
    
    //#line 93 "/home/dsl/workspace/plhamK/plham/Order.x10"
    public boolean isSellOrder$O() {
        
        //#line 94 "/home/dsl/workspace/plhamK/plham/Order.x10"
        final plham.Order.Kind t$31364 = ((this.kind));
        
        //#line 94 "/home/dsl/workspace/plhamK/plham/Order.x10"
        final plham.Order.Kind t$31365 = ((plham.Order.get$KIND_SELL_MARKET_ORDER()));
        
        //#line 94 "/home/dsl/workspace/plhamK/plham/Order.x10"
        boolean t$31368 = x10.rtt.Equality.equalsequals((t$31364),(t$31365));
        
        //#line 94 "/home/dsl/workspace/plhamK/plham/Order.x10"
        if (!(t$31368)) {
            
            //#line 94 "/home/dsl/workspace/plhamK/plham/Order.x10"
            final plham.Order.Kind t$31366 = ((this.kind));
            
            //#line 94 "/home/dsl/workspace/plhamK/plham/Order.x10"
            final plham.Order.Kind t$31367 = ((plham.Order.get$KIND_SELL_LIMIT_ORDER()));
            
            //#line 94 "/home/dsl/workspace/plhamK/plham/Order.x10"
            t$31368 = x10.rtt.Equality.equalsequals((t$31366),(t$31367));
        }
        
        //#line 94 "/home/dsl/workspace/plhamK/plham/Order.x10"
        final boolean t$31369 = t$31368;
        
        //#line 94 "/home/dsl/workspace/plhamK/plham/Order.x10"
        return t$31369;
    }
    
    
    //#line 97 "/home/dsl/workspace/plhamK/plham/Order.x10"
    public boolean isLimitOrder$O() {
        
        //#line 98 "/home/dsl/workspace/plhamK/plham/Order.x10"
        final plham.Order.Kind t$31370 = ((this.kind));
        
        //#line 98 "/home/dsl/workspace/plhamK/plham/Order.x10"
        final plham.Order.Kind t$31371 = ((plham.Order.get$KIND_BUY_LIMIT_ORDER()));
        
        //#line 98 "/home/dsl/workspace/plhamK/plham/Order.x10"
        boolean t$31374 = x10.rtt.Equality.equalsequals((t$31370),(t$31371));
        
        //#line 98 "/home/dsl/workspace/plhamK/plham/Order.x10"
        if (!(t$31374)) {
            
            //#line 98 "/home/dsl/workspace/plhamK/plham/Order.x10"
            final plham.Order.Kind t$31372 = ((this.kind));
            
            //#line 98 "/home/dsl/workspace/plhamK/plham/Order.x10"
            final plham.Order.Kind t$31373 = ((plham.Order.get$KIND_SELL_LIMIT_ORDER()));
            
            //#line 98 "/home/dsl/workspace/plhamK/plham/Order.x10"
            t$31374 = x10.rtt.Equality.equalsequals((t$31372),(t$31373));
        }
        
        //#line 98 "/home/dsl/workspace/plhamK/plham/Order.x10"
        final boolean t$31375 = t$31374;
        
        //#line 98 "/home/dsl/workspace/plhamK/plham/Order.x10"
        return t$31375;
    }
    
    
    //#line 101 "/home/dsl/workspace/plhamK/plham/Order.x10"
    public boolean isMarketOrder$O() {
        
        //#line 102 "/home/dsl/workspace/plhamK/plham/Order.x10"
        final plham.Order.Kind t$31376 = ((this.kind));
        
        //#line 102 "/home/dsl/workspace/plhamK/plham/Order.x10"
        final plham.Order.Kind t$31377 = ((plham.Order.get$KIND_BUY_MARKET_ORDER()));
        
        //#line 102 "/home/dsl/workspace/plhamK/plham/Order.x10"
        boolean t$31380 = x10.rtt.Equality.equalsequals((t$31376),(t$31377));
        
        //#line 102 "/home/dsl/workspace/plhamK/plham/Order.x10"
        if (!(t$31380)) {
            
            //#line 102 "/home/dsl/workspace/plhamK/plham/Order.x10"
            final plham.Order.Kind t$31378 = ((this.kind));
            
            //#line 102 "/home/dsl/workspace/plhamK/plham/Order.x10"
            final plham.Order.Kind t$31379 = ((plham.Order.get$KIND_SELL_MARKET_ORDER()));
            
            //#line 102 "/home/dsl/workspace/plhamK/plham/Order.x10"
            t$31380 = x10.rtt.Equality.equalsequals((t$31378),(t$31379));
        }
        
        //#line 102 "/home/dsl/workspace/plhamK/plham/Order.x10"
        final boolean t$31381 = t$31380;
        
        //#line 102 "/home/dsl/workspace/plhamK/plham/Order.x10"
        return t$31381;
    }
    
    
    //#line 109 "/home/dsl/workspace/plhamK/plham/Order.x10"
    /**
	 * Test if this is a cancel request for an order.
	 * @return true if instanceof <code>Cancel</code>
	 */
    public boolean isCancel$O() {
        
        //#line 109 "/home/dsl/workspace/plhamK/plham/Order.x10"
        final boolean t$31382 = plham.Cancel.$RTT.isInstance(this);
        
        //#line 109 "/home/dsl/workspace/plhamK/plham/Order.x10"
        return t$31382;
    }
    
    
    //#line 116 "/home/dsl/workspace/plhamK/plham/Order.x10"
    /**
	 * Test if this order has been expired.
	 * @param market
	 * @return true if expired
	 */
    public boolean isExpired$O(final plham.Market market) {
        
        //#line 117 "/home/dsl/workspace/plhamK/plham/Order.x10"
        assert (this.marketId) == (market.id);
        
        //#line 118 "/home/dsl/workspace/plhamK/plham/Order.x10"
        final long t$31383 = market.getTime$O();
        
        //#line 118 "/home/dsl/workspace/plhamK/plham/Order.x10"
        final boolean t$31384 = this.isExpired$O((t$31383));
        
        //#line 118 "/home/dsl/workspace/plhamK/plham/Order.x10"
        return t$31384;
    }
    
    
    //#line 126 "/home/dsl/workspace/plhamK/plham/Order.x10"
    /**
	 * Test if this order has been expired.
	 * @param t
	 * @return true if expired
	 */
    public boolean isExpired$O(final long t) {
        
        //#line 127 "/home/dsl/workspace/plhamK/plham/Order.x10"
        final long t$31385 = this.timePlaced;
        
        //#line 127 "/home/dsl/workspace/plhamK/plham/Order.x10"
        final long t$31386 = this.timeLength;
        
        //#line 127 "/home/dsl/workspace/plhamK/plham/Order.x10"
        final long t$31387 = ((t$31385) + (((t$31386))));
        
        //#line 127 "/home/dsl/workspace/plhamK/plham/Order.x10"
        final boolean t$31388 = ((t$31387) < (((t))));
        
        //#line 127 "/home/dsl/workspace/plhamK/plham/Order.x10"
        return t$31388;
    }
    
    
    //#line 130 "/home/dsl/workspace/plhamK/plham/Order.x10"
    public java.lang.String toString() {
        
        //#line 131 "/home/dsl/workspace/plhamK/plham/Order.x10"
        final java.lang.String t$31400 = x10.rtt.Types.typeName(this);
        
        //#line 131 "/home/dsl/workspace/plhamK/plham/Order.x10"
        final java.lang.String t$31392 = this.getKindName();
        
        //#line 131 "/home/dsl/workspace/plhamK/plham/Order.x10"
        final long t$31389 = this.agentId;
        
        //#line 131 "/home/dsl/workspace/plhamK/plham/Order.x10"
        final java.lang.String t$31393 = (("agent:") + ((x10.core.Long.$box(t$31389))));
        
        //#line 131 "/home/dsl/workspace/plhamK/plham/Order.x10"
        final long t$31390 = this.marketId;
        
        //#line 131 "/home/dsl/workspace/plhamK/plham/Order.x10"
        final java.lang.String t$31394 = (("market:") + ((x10.core.Long.$box(t$31390))));
        
        //#line 131 "/home/dsl/workspace/plhamK/plham/Order.x10"
        final double t$31395 = this.price;
        
        //#line 131 "/home/dsl/workspace/plhamK/plham/Order.x10"
        final long t$31396 = this.volume;
        
        //#line 131 "/home/dsl/workspace/plhamK/plham/Order.x10"
        final long t$31397 = this.timeLength;
        
        //#line 131 "/home/dsl/workspace/plhamK/plham/Order.x10"
        final long t$31398 = this.timePlaced;
        
        //#line 131 "/home/dsl/workspace/plhamK/plham/Order.x10"
        final long t$31391 = this.orderId;
        
        //#line 131 "/home/dsl/workspace/plhamK/plham/Order.x10"
        final java.lang.String t$31399 = (("id:") + ((x10.core.Long.$box(t$31391))));
        
        //#line 131 "/home/dsl/workspace/plhamK/plham/Order.x10"
        final x10.core.Rail t$31401 = ((x10.runtime.impl.java.ArrayUtils.<java.lang.Object> makeRailFromJavaArray(x10.rtt.Types.ANY, new java.lang.Object[] {t$31392, t$31393, t$31394, t$31395, t$31396, t$31397, t$31398, t$31399})));
        
        //#line 131 "/home/dsl/workspace/plhamK/plham/Order.x10"
        final java.lang.String t$31402 = ((t$31400) + (t$31401));
        
        //#line 131 "/home/dsl/workspace/plhamK/plham/Order.x10"
        return t$31402;
    }
    
    
    //#line 134 "/home/dsl/workspace/plhamK/plham/Order.x10"
    public java.lang.String getKindName() {
        
        //#line 135 "/home/dsl/workspace/plhamK/plham/Order.x10"
        final plham.Order.Kind t$31403 = ((this.kind));
        
        //#line 135 "/home/dsl/workspace/plhamK/plham/Order.x10"
        final plham.Order.Kind t$31404 = ((plham.Order.get$KIND_BUY_MARKET_ORDER()));
        
        //#line 135 "/home/dsl/workspace/plhamK/plham/Order.x10"
        final boolean t$31405 = x10.rtt.Equality.equalsequals((t$31403),(t$31404));
        
        //#line 135 "/home/dsl/workspace/plhamK/plham/Order.x10"
        if (t$31405) {
            
            //#line 136 "/home/dsl/workspace/plhamK/plham/Order.x10"
            return "BUY_MARKET_ORDER";
        }
        
        //#line 138 "/home/dsl/workspace/plhamK/plham/Order.x10"
        final plham.Order.Kind t$31406 = ((this.kind));
        
        //#line 138 "/home/dsl/workspace/plhamK/plham/Order.x10"
        final plham.Order.Kind t$31407 = ((plham.Order.get$KIND_SELL_MARKET_ORDER()));
        
        //#line 138 "/home/dsl/workspace/plhamK/plham/Order.x10"
        final boolean t$31408 = x10.rtt.Equality.equalsequals((t$31406),(t$31407));
        
        //#line 138 "/home/dsl/workspace/plhamK/plham/Order.x10"
        if (t$31408) {
            
            //#line 139 "/home/dsl/workspace/plhamK/plham/Order.x10"
            return "SELL_MARKET_ORDER";
        }
        
        //#line 141 "/home/dsl/workspace/plhamK/plham/Order.x10"
        final plham.Order.Kind t$31409 = ((this.kind));
        
        //#line 141 "/home/dsl/workspace/plhamK/plham/Order.x10"
        final plham.Order.Kind t$31410 = ((plham.Order.get$KIND_BUY_LIMIT_ORDER()));
        
        //#line 141 "/home/dsl/workspace/plhamK/plham/Order.x10"
        final boolean t$31411 = x10.rtt.Equality.equalsequals((t$31409),(t$31410));
        
        //#line 141 "/home/dsl/workspace/plhamK/plham/Order.x10"
        if (t$31411) {
            
            //#line 142 "/home/dsl/workspace/plhamK/plham/Order.x10"
            return "BUY_LIMIT_ORDER";
        }
        
        //#line 144 "/home/dsl/workspace/plhamK/plham/Order.x10"
        final plham.Order.Kind t$31412 = ((this.kind));
        
        //#line 144 "/home/dsl/workspace/plhamK/plham/Order.x10"
        final plham.Order.Kind t$31413 = ((plham.Order.get$KIND_SELL_LIMIT_ORDER()));
        
        //#line 144 "/home/dsl/workspace/plhamK/plham/Order.x10"
        final boolean t$31414 = x10.rtt.Equality.equalsequals((t$31412),(t$31413));
        
        //#line 144 "/home/dsl/workspace/plhamK/plham/Order.x10"
        if (t$31414) {
            
            //#line 145 "/home/dsl/workspace/plhamK/plham/Order.x10"
            return "SELL_LIMIT_ORDER";
        }
        
        //#line 147 "/home/dsl/workspace/plhamK/plham/Order.x10"
        return "UNKNOWN_KIND";
    }
    
    
    //#line 13 "/home/dsl/workspace/plhamK/plham/Order.x10"
    final public plham.Order plham$Order$$this$plham$Order() {
        
        //#line 13 "/home/dsl/workspace/plhamK/plham/Order.x10"
        return plham.Order.this;
    }
    
    
    //#line 13 "/home/dsl/workspace/plhamK/plham/Order.x10"
    final public void __fieldInitializers_plham_Order() {
        
        //#line 24 "/home/dsl/workspace/plhamK/plham/Order.x10"
        final plham.Order.Kind t$31415 = (plham.Order.Kind) x10.rtt.Types.zeroValue(plham.Order.Kind.$RTT);
        
        //#line 13 "/home/dsl/workspace/plhamK/plham/Order.x10"
        this.kind = t$31415;
        
        //#line 13 "/home/dsl/workspace/plhamK/plham/Order.x10"
        this.agentId = 0L;
        
        //#line 13 "/home/dsl/workspace/plhamK/plham/Order.x10"
        this.marketId = 0L;
        
        //#line 13 "/home/dsl/workspace/plhamK/plham/Order.x10"
        this.price = 0.0;
        
        //#line 13 "/home/dsl/workspace/plhamK/plham/Order.x10"
        this.volume = 0L;
        
        //#line 13 "/home/dsl/workspace/plhamK/plham/Order.x10"
        this.timeLength = 0L;
        
        //#line 13 "/home/dsl/workspace/plhamK/plham/Order.x10"
        this.timePlaced = 0L;
        
        //#line 13 "/home/dsl/workspace/plhamK/plham/Order.x10"
        this.orderId = 0L;
    }
    
    final private static x10.core.concurrent.AtomicInteger initStatus$KIND_SELL_LIMIT_ORDER = new x10.core.concurrent.AtomicInteger(x10.runtime.impl.java.InitDispatcher.UNINITIALIZED);
    private static x10.lang.ExceptionInInitializer exception$KIND_SELL_LIMIT_ORDER;
    final private static x10.core.concurrent.AtomicInteger initStatus$KIND_BUY_LIMIT_ORDER = new x10.core.concurrent.AtomicInteger(x10.runtime.impl.java.InitDispatcher.UNINITIALIZED);
    private static x10.lang.ExceptionInInitializer exception$KIND_BUY_LIMIT_ORDER;
    final private static x10.core.concurrent.AtomicInteger initStatus$KIND_SELL_MARKET_ORDER = new x10.core.concurrent.AtomicInteger(x10.runtime.impl.java.InitDispatcher.UNINITIALIZED);
    private static x10.lang.ExceptionInInitializer exception$KIND_SELL_MARKET_ORDER;
    final private static x10.core.concurrent.AtomicInteger initStatus$KIND_BUY_MARKET_ORDER = new x10.core.concurrent.AtomicInteger(x10.runtime.impl.java.InitDispatcher.UNINITIALIZED);
    private static x10.lang.ExceptionInInitializer exception$KIND_BUY_MARKET_ORDER;
    
    public static plham.Order.Kind get$KIND_BUY_MARKET_ORDER() {
        if ((plham.Order.initStatus$KIND_BUY_MARKET_ORDER.get()) == (x10.runtime.impl.java.InitDispatcher.INITIALIZED)) {
            return plham.Order.KIND_BUY_MARKET_ORDER;
        }
        if ((plham.Order.initStatus$KIND_BUY_MARKET_ORDER.get()) == (x10.runtime.impl.java.InitDispatcher.EXCEPTION_RAISED)) {
            if ((x10.runtime.impl.java.InitDispatcher.TRACE_STATIC_INIT) == (true)) {
                x10.runtime.impl.java.InitDispatcher.printStaticInitMessage((("Rethrowing ExceptionInInitializer for field: plham.Order.KIND_BUY_MARKET_ORDER")));
            }
            throw plham.Order.exception$KIND_BUY_MARKET_ORDER;
        }
        if (plham.Order.initStatus$KIND_BUY_MARKET_ORDER.compareAndSet((x10.runtime.impl.java.InitDispatcher.UNINITIALIZED), (x10.runtime.impl.java.InitDispatcher.INITIALIZING))) {
            try {{
                plham.Order.KIND_BUY_MARKET_ORDER = ((new plham.Order.Kind((java.lang.System[]) null).plham$Order$Kind$$init$S(((1L)))));
            }}catch (java.lang.Throwable exc$31416) {
                plham.Order.exception$KIND_BUY_MARKET_ORDER = new x10.lang.ExceptionInInitializer(exc$31416);
                plham.Order.initStatus$KIND_BUY_MARKET_ORDER.set((x10.runtime.impl.java.InitDispatcher.EXCEPTION_RAISED));
                x10.runtime.impl.java.InitDispatcher.lockInitialized();
                x10.runtime.impl.java.InitDispatcher.notifyInitialized();
                throw plham.Order.exception$KIND_BUY_MARKET_ORDER;
            }
            if ((x10.runtime.impl.java.InitDispatcher.TRACE_STATIC_INIT) == (true)) {
                x10.runtime.impl.java.InitDispatcher.printStaticInitMessage((("Doing static initialization for field: plham.Order.KIND_BUY_MARKET_ORDER")));
            }
            plham.Order.initStatus$KIND_BUY_MARKET_ORDER.set((x10.runtime.impl.java.InitDispatcher.INITIALIZED));
            x10.runtime.impl.java.InitDispatcher.lockInitialized();
            x10.runtime.impl.java.InitDispatcher.notifyInitialized();
        } else {
            if (plham.Order.initStatus$KIND_BUY_MARKET_ORDER.get() < x10.runtime.impl.java.InitDispatcher.INITIALIZED) {
                x10.runtime.impl.java.InitDispatcher.lockInitialized();
                while (plham.Order.initStatus$KIND_BUY_MARKET_ORDER.get() < x10.runtime.impl.java.InitDispatcher.INITIALIZED) {
                    x10.runtime.impl.java.InitDispatcher.awaitInitialized();
                }
                x10.runtime.impl.java.InitDispatcher.unlockInitialized();
                if ((plham.Order.initStatus$KIND_BUY_MARKET_ORDER.get()) == (x10.runtime.impl.java.InitDispatcher.EXCEPTION_RAISED)) {
                    if ((x10.runtime.impl.java.InitDispatcher.TRACE_STATIC_INIT) == (true)) {
                        x10.runtime.impl.java.InitDispatcher.printStaticInitMessage((("Rethrowing ExceptionInInitializer for field: plham.Order.KIND_BUY_MARKET_ORDER")));
                    }
                    throw plham.Order.exception$KIND_BUY_MARKET_ORDER;
                }
            }
        }
        return plham.Order.KIND_BUY_MARKET_ORDER;
    }
    
    public static plham.Order.Kind get$KIND_SELL_MARKET_ORDER() {
        if ((plham.Order.initStatus$KIND_SELL_MARKET_ORDER.get()) == (x10.runtime.impl.java.InitDispatcher.INITIALIZED)) {
            return plham.Order.KIND_SELL_MARKET_ORDER;
        }
        if ((plham.Order.initStatus$KIND_SELL_MARKET_ORDER.get()) == (x10.runtime.impl.java.InitDispatcher.EXCEPTION_RAISED)) {
            if ((x10.runtime.impl.java.InitDispatcher.TRACE_STATIC_INIT) == (true)) {
                x10.runtime.impl.java.InitDispatcher.printStaticInitMessage((("Rethrowing ExceptionInInitializer for field: plham.Order.KIND_SELL_MARKET_ORDER")));
            }
            throw plham.Order.exception$KIND_SELL_MARKET_ORDER;
        }
        if (plham.Order.initStatus$KIND_SELL_MARKET_ORDER.compareAndSet((x10.runtime.impl.java.InitDispatcher.UNINITIALIZED), (x10.runtime.impl.java.InitDispatcher.INITIALIZING))) {
            try {{
                plham.Order.KIND_SELL_MARKET_ORDER = ((new plham.Order.Kind((java.lang.System[]) null).plham$Order$Kind$$init$S(((2L)))));
            }}catch (java.lang.Throwable exc$31417) {
                plham.Order.exception$KIND_SELL_MARKET_ORDER = new x10.lang.ExceptionInInitializer(exc$31417);
                plham.Order.initStatus$KIND_SELL_MARKET_ORDER.set((x10.runtime.impl.java.InitDispatcher.EXCEPTION_RAISED));
                x10.runtime.impl.java.InitDispatcher.lockInitialized();
                x10.runtime.impl.java.InitDispatcher.notifyInitialized();
                throw plham.Order.exception$KIND_SELL_MARKET_ORDER;
            }
            if ((x10.runtime.impl.java.InitDispatcher.TRACE_STATIC_INIT) == (true)) {
                x10.runtime.impl.java.InitDispatcher.printStaticInitMessage((("Doing static initialization for field: plham.Order.KIND_SELL_MARKET_ORDER")));
            }
            plham.Order.initStatus$KIND_SELL_MARKET_ORDER.set((x10.runtime.impl.java.InitDispatcher.INITIALIZED));
            x10.runtime.impl.java.InitDispatcher.lockInitialized();
            x10.runtime.impl.java.InitDispatcher.notifyInitialized();
        } else {
            if (plham.Order.initStatus$KIND_SELL_MARKET_ORDER.get() < x10.runtime.impl.java.InitDispatcher.INITIALIZED) {
                x10.runtime.impl.java.InitDispatcher.lockInitialized();
                while (plham.Order.initStatus$KIND_SELL_MARKET_ORDER.get() < x10.runtime.impl.java.InitDispatcher.INITIALIZED) {
                    x10.runtime.impl.java.InitDispatcher.awaitInitialized();
                }
                x10.runtime.impl.java.InitDispatcher.unlockInitialized();
                if ((plham.Order.initStatus$KIND_SELL_MARKET_ORDER.get()) == (x10.runtime.impl.java.InitDispatcher.EXCEPTION_RAISED)) {
                    if ((x10.runtime.impl.java.InitDispatcher.TRACE_STATIC_INIT) == (true)) {
                        x10.runtime.impl.java.InitDispatcher.printStaticInitMessage((("Rethrowing ExceptionInInitializer for field: plham.Order.KIND_SELL_MARKET_ORDER")));
                    }
                    throw plham.Order.exception$KIND_SELL_MARKET_ORDER;
                }
            }
        }
        return plham.Order.KIND_SELL_MARKET_ORDER;
    }
    
    public static plham.Order.Kind get$KIND_BUY_LIMIT_ORDER() {
        if ((plham.Order.initStatus$KIND_BUY_LIMIT_ORDER.get()) == (x10.runtime.impl.java.InitDispatcher.INITIALIZED)) {
            return plham.Order.KIND_BUY_LIMIT_ORDER;
        }
        if ((plham.Order.initStatus$KIND_BUY_LIMIT_ORDER.get()) == (x10.runtime.impl.java.InitDispatcher.EXCEPTION_RAISED)) {
            if ((x10.runtime.impl.java.InitDispatcher.TRACE_STATIC_INIT) == (true)) {
                x10.runtime.impl.java.InitDispatcher.printStaticInitMessage((("Rethrowing ExceptionInInitializer for field: plham.Order.KIND_BUY_LIMIT_ORDER")));
            }
            throw plham.Order.exception$KIND_BUY_LIMIT_ORDER;
        }
        if (plham.Order.initStatus$KIND_BUY_LIMIT_ORDER.compareAndSet((x10.runtime.impl.java.InitDispatcher.UNINITIALIZED), (x10.runtime.impl.java.InitDispatcher.INITIALIZING))) {
            try {{
                plham.Order.KIND_BUY_LIMIT_ORDER = ((new plham.Order.Kind((java.lang.System[]) null).plham$Order$Kind$$init$S(((3L)))));
            }}catch (java.lang.Throwable exc$31418) {
                plham.Order.exception$KIND_BUY_LIMIT_ORDER = new x10.lang.ExceptionInInitializer(exc$31418);
                plham.Order.initStatus$KIND_BUY_LIMIT_ORDER.set((x10.runtime.impl.java.InitDispatcher.EXCEPTION_RAISED));
                x10.runtime.impl.java.InitDispatcher.lockInitialized();
                x10.runtime.impl.java.InitDispatcher.notifyInitialized();
                throw plham.Order.exception$KIND_BUY_LIMIT_ORDER;
            }
            if ((x10.runtime.impl.java.InitDispatcher.TRACE_STATIC_INIT) == (true)) {
                x10.runtime.impl.java.InitDispatcher.printStaticInitMessage((("Doing static initialization for field: plham.Order.KIND_BUY_LIMIT_ORDER")));
            }
            plham.Order.initStatus$KIND_BUY_LIMIT_ORDER.set((x10.runtime.impl.java.InitDispatcher.INITIALIZED));
            x10.runtime.impl.java.InitDispatcher.lockInitialized();
            x10.runtime.impl.java.InitDispatcher.notifyInitialized();
        } else {
            if (plham.Order.initStatus$KIND_BUY_LIMIT_ORDER.get() < x10.runtime.impl.java.InitDispatcher.INITIALIZED) {
                x10.runtime.impl.java.InitDispatcher.lockInitialized();
                while (plham.Order.initStatus$KIND_BUY_LIMIT_ORDER.get() < x10.runtime.impl.java.InitDispatcher.INITIALIZED) {
                    x10.runtime.impl.java.InitDispatcher.awaitInitialized();
                }
                x10.runtime.impl.java.InitDispatcher.unlockInitialized();
                if ((plham.Order.initStatus$KIND_BUY_LIMIT_ORDER.get()) == (x10.runtime.impl.java.InitDispatcher.EXCEPTION_RAISED)) {
                    if ((x10.runtime.impl.java.InitDispatcher.TRACE_STATIC_INIT) == (true)) {
                        x10.runtime.impl.java.InitDispatcher.printStaticInitMessage((("Rethrowing ExceptionInInitializer for field: plham.Order.KIND_BUY_LIMIT_ORDER")));
                    }
                    throw plham.Order.exception$KIND_BUY_LIMIT_ORDER;
                }
            }
        }
        return plham.Order.KIND_BUY_LIMIT_ORDER;
    }
    
    public static plham.Order.Kind get$KIND_SELL_LIMIT_ORDER() {
        if ((plham.Order.initStatus$KIND_SELL_LIMIT_ORDER.get()) == (x10.runtime.impl.java.InitDispatcher.INITIALIZED)) {
            return plham.Order.KIND_SELL_LIMIT_ORDER;
        }
        if ((plham.Order.initStatus$KIND_SELL_LIMIT_ORDER.get()) == (x10.runtime.impl.java.InitDispatcher.EXCEPTION_RAISED)) {
            if ((x10.runtime.impl.java.InitDispatcher.TRACE_STATIC_INIT) == (true)) {
                x10.runtime.impl.java.InitDispatcher.printStaticInitMessage((("Rethrowing ExceptionInInitializer for field: plham.Order.KIND_SELL_LIMIT_ORDER")));
            }
            throw plham.Order.exception$KIND_SELL_LIMIT_ORDER;
        }
        if (plham.Order.initStatus$KIND_SELL_LIMIT_ORDER.compareAndSet((x10.runtime.impl.java.InitDispatcher.UNINITIALIZED), (x10.runtime.impl.java.InitDispatcher.INITIALIZING))) {
            try {{
                plham.Order.KIND_SELL_LIMIT_ORDER = ((new plham.Order.Kind((java.lang.System[]) null).plham$Order$Kind$$init$S(((4L)))));
            }}catch (java.lang.Throwable exc$31419) {
                plham.Order.exception$KIND_SELL_LIMIT_ORDER = new x10.lang.ExceptionInInitializer(exc$31419);
                plham.Order.initStatus$KIND_SELL_LIMIT_ORDER.set((x10.runtime.impl.java.InitDispatcher.EXCEPTION_RAISED));
                x10.runtime.impl.java.InitDispatcher.lockInitialized();
                x10.runtime.impl.java.InitDispatcher.notifyInitialized();
                throw plham.Order.exception$KIND_SELL_LIMIT_ORDER;
            }
            if ((x10.runtime.impl.java.InitDispatcher.TRACE_STATIC_INIT) == (true)) {
                x10.runtime.impl.java.InitDispatcher.printStaticInitMessage((("Doing static initialization for field: plham.Order.KIND_SELL_LIMIT_ORDER")));
            }
            plham.Order.initStatus$KIND_SELL_LIMIT_ORDER.set((x10.runtime.impl.java.InitDispatcher.INITIALIZED));
            x10.runtime.impl.java.InitDispatcher.lockInitialized();
            x10.runtime.impl.java.InitDispatcher.notifyInitialized();
        } else {
            if (plham.Order.initStatus$KIND_SELL_LIMIT_ORDER.get() < x10.runtime.impl.java.InitDispatcher.INITIALIZED) {
                x10.runtime.impl.java.InitDispatcher.lockInitialized();
                while (plham.Order.initStatus$KIND_SELL_LIMIT_ORDER.get() < x10.runtime.impl.java.InitDispatcher.INITIALIZED) {
                    x10.runtime.impl.java.InitDispatcher.awaitInitialized();
                }
                x10.runtime.impl.java.InitDispatcher.unlockInitialized();
                if ((plham.Order.initStatus$KIND_SELL_LIMIT_ORDER.get()) == (x10.runtime.impl.java.InitDispatcher.EXCEPTION_RAISED)) {
                    if ((x10.runtime.impl.java.InitDispatcher.TRACE_STATIC_INIT) == (true)) {
                        x10.runtime.impl.java.InitDispatcher.printStaticInitMessage((("Rethrowing ExceptionInInitializer for field: plham.Order.KIND_SELL_LIMIT_ORDER")));
                    }
                    throw plham.Order.exception$KIND_SELL_LIMIT_ORDER;
                }
            }
        }
        return plham.Order.KIND_SELL_LIMIT_ORDER;
    }
    
    public static double get$NO_PRICE() {
        return plham.Order.NO_PRICE;
    }
}

