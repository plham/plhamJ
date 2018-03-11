package plham.event;


/**
 * This suddenly changes the market price as a consequence of a fat finger error,
 * e.g., caused by an huge amount of orders at an extremely cheap or expensive price.
 */

public class OrderMistakeShock extends x10.core.Ref implements plham.Market.MarketEvent, x10.serialization.X10JavaSerializable
{
    public static final x10.rtt.RuntimeType<OrderMistakeShock> $RTT = 
        x10.rtt.NamedType.<OrderMistakeShock> make("plham.event.OrderMistakeShock",
                                                   OrderMistakeShock.class,
                                                   new x10.rtt.Type[] {
                                                       plham.Market.MarketEvent.$RTT
                                                   });
    
    public x10.rtt.RuntimeType<?> $getRTT() { return $RTT; }
    
    public x10.rtt.Type<?> $getParam(int i) { return null; }
    
    private Object writeReplace() throws java.io.ObjectStreamException {
        return new x10.serialization.SerializationProxy(this);
    }
    
    public static x10.serialization.X10JavaSerializable $_deserialize_body(plham.event.OrderMistakeShock $_obj, x10.serialization.X10JavaDeserializer $deserializer) throws java.io.IOException {
        if (x10.runtime.impl.java.Runtime.TRACE_SER) { x10.runtime.impl.java.Runtime.printTraceMessage("X10JavaSerializable: $_deserialize_body() of " + OrderMistakeShock.class + " calling"); } 
        $_obj.agentId = $deserializer.readLong();
        $_obj.id = $deserializer.readLong();
        $_obj.marketId = $deserializer.readLong();
        $_obj.name = $deserializer.readObject();
        $_obj.orderTimeLength = $deserializer.readLong();
        $_obj.orderVolume = $deserializer.readLong();
        $_obj.priceChangeRate = $deserializer.readDouble();
        $_obj.random = $deserializer.readObject();
        $_obj.triggerTime = $deserializer.readLong();
        return $_obj;
    }
    
    public static x10.serialization.X10JavaSerializable $_deserializer(x10.serialization.X10JavaDeserializer $deserializer) throws java.io.IOException {
        plham.event.OrderMistakeShock $_obj = new plham.event.OrderMistakeShock((java.lang.System[]) null);
        $deserializer.record_reference($_obj);
        return $_deserialize_body($_obj, $deserializer);
    }
    
    public void $_serialize(x10.serialization.X10JavaSerializer $serializer) throws java.io.IOException {
        $serializer.write(this.agentId);
        $serializer.write(this.id);
        $serializer.write(this.marketId);
        $serializer.write(this.name);
        $serializer.write(this.orderTimeLength);
        $serializer.write(this.orderVolume);
        $serializer.write(this.priceChangeRate);
        $serializer.write(this.random);
        $serializer.write(this.triggerTime);
        
    }
    
    // constructor just for allocation
    public OrderMistakeShock(final java.lang.System[] $dummy) {
        
    }
    
    

    
    //#line 16 "/home/dsl/workspace/plhamK/plham/event/OrderMistakeShock.x10"
    public long id;
    
    //#line 17 "/home/dsl/workspace/plhamK/plham/event/OrderMistakeShock.x10"
    public java.lang.String name;
    
    //#line 18 "/home/dsl/workspace/plhamK/plham/event/OrderMistakeShock.x10"
    public x10.util.Random random;
    
    //#line 19 "/home/dsl/workspace/plhamK/plham/event/OrderMistakeShock.x10"
    public long marketId;
    
    //#line 20 "/home/dsl/workspace/plhamK/plham/event/OrderMistakeShock.x10"
    public long agentId;
    
    //#line 21 "/home/dsl/workspace/plhamK/plham/event/OrderMistakeShock.x10"
    public long triggerTime;
    
    //#line 22 "/home/dsl/workspace/plhamK/plham/event/OrderMistakeShock.x10"
    public double priceChangeRate;
    
    //#line 23 "/home/dsl/workspace/plhamK/plham/event/OrderMistakeShock.x10"
    public long orderVolume;
    
    //#line 24 "/home/dsl/workspace/plhamK/plham/event/OrderMistakeShock.x10"
    public long orderTimeLength;
    
    
    //#line 26 "/home/dsl/workspace/plhamK/plham/event/OrderMistakeShock.x10"
    // creation method for java code (1-phase java constructor)
    public OrderMistakeShock(final long id, final java.lang.String name, final x10.util.Random random) {
        this((java.lang.System[]) null);
        plham$event$OrderMistakeShock$$init$S(id, name, random);
    }
    
    // constructor for non-virtual call
    final public plham.event.OrderMistakeShock plham$event$OrderMistakeShock$$init$S(final long id, final java.lang.String name, final x10.util.Random random) {
         {
            
            //#line 26 "/home/dsl/workspace/plhamK/plham/event/OrderMistakeShock.x10"
            
            
            //#line 14 "/home/dsl/workspace/plhamK/plham/event/OrderMistakeShock.x10"
            this.__fieldInitializers_plham_event_OrderMistakeShock();
            
            //#line 27 "/home/dsl/workspace/plhamK/plham/event/OrderMistakeShock.x10"
            this.id = id;
            
            //#line 28 "/home/dsl/workspace/plhamK/plham/event/OrderMistakeShock.x10"
            this.name = ((name));
            
            //#line 29 "/home/dsl/workspace/plhamK/plham/event/OrderMistakeShock.x10"
            this.random = ((random));
        }
        return this;
    }
    
    
    
    //#line 32 "/home/dsl/workspace/plhamK/plham/event/OrderMistakeShock.x10"
    public void update(final plham.Market market) {
        
        //#line 33 "/home/dsl/workspace/plhamK/plham/event/OrderMistakeShock.x10"
        assert (market.id) == (this.marketId);
        
        //#line 34 "/home/dsl/workspace/plhamK/plham/event/OrderMistakeShock.x10"
        final plham.Env env = ((market.env));
        
        //#line 35 "/home/dsl/workspace/plhamK/plham/event/OrderMistakeShock.x10"
        final long t = market.getTime$O();
        
        //#line 36 "/home/dsl/workspace/plhamK/plham/event/OrderMistakeShock.x10"
        final long t$34473 = this.triggerTime;
        
        //#line 36 "/home/dsl/workspace/plhamK/plham/event/OrderMistakeShock.x10"
        final boolean t$34493 = (t) == (t$34473);
        
        //#line 36 "/home/dsl/workspace/plhamK/plham/event/OrderMistakeShock.x10"
        if (t$34493) {
            
            //#line 37 "/home/dsl/workspace/plhamK/plham/event/OrderMistakeShock.x10"
            final x10.util.List t$34474 = ((env.agents));
            
            //#line 37 "/home/dsl/workspace/plhamK/plham/event/OrderMistakeShock.x10"
            final long t$34475 = this.agentId;
            
            //#line 37 "/home/dsl/workspace/plhamK/plham/event/OrderMistakeShock.x10"
            final plham.Agent agent = ((x10.util.Indexed<plham.Agent>)t$34474).$apply$G((t$34475));
            
            //#line 38 "/home/dsl/workspace/plhamK/plham/event/OrderMistakeShock.x10"
            final double basePrice = market.getPrice$O();
            
            //#line 39 "/home/dsl/workspace/plhamK/plham/event/OrderMistakeShock.x10"
            final double t$34476 = ((((1L))));
            
            //#line 39 "/home/dsl/workspace/plhamK/plham/event/OrderMistakeShock.x10"
            final double t$34477 = this.priceChangeRate;
            
            //#line 39 "/home/dsl/workspace/plhamK/plham/event/OrderMistakeShock.x10"
            final double t$34478 = ((t$34476) + (((t$34477))));
            
            //#line 39 "/home/dsl/workspace/plhamK/plham/event/OrderMistakeShock.x10"
            final double orderPrice = ((basePrice) * (((t$34478))));
            
            //#line 40 "/home/dsl/workspace/plhamK/plham/event/OrderMistakeShock.x10"
            final long timeLength = this.orderTimeLength;
            
            //#line 41 "/home/dsl/workspace/plhamK/plham/event/OrderMistakeShock.x10"
            final plham.Order order;
            
            //#line 42 "/home/dsl/workspace/plhamK/plham/event/OrderMistakeShock.x10"
            final double t$34479 = this.priceChangeRate;
            
            //#line 42 "/home/dsl/workspace/plhamK/plham/event/OrderMistakeShock.x10"
            final boolean t$34486 = ((t$34479) <= (((0.0))));
            
            //#line 42 "/home/dsl/workspace/plhamK/plham/event/OrderMistakeShock.x10"
            if (t$34486) {
                
                //#line 44 "/home/dsl/workspace/plhamK/plham/event/OrderMistakeShock.x10"
                final plham.Order.Kind t$34480 = ((plham.Order.get$KIND_SELL_LIMIT_ORDER()));
                
                //#line 44 "/home/dsl/workspace/plhamK/plham/event/OrderMistakeShock.x10"
                final long t$34481 = this.orderVolume;
                
                //#line 44 "/home/dsl/workspace/plhamK/plham/event/OrderMistakeShock.x10"
                final plham.Order t$34482 = ((new plham.Order((java.lang.System[]) null).plham$Order$$init$S(((t$34480)), ((agent)), ((market)), ((orderPrice)), t$34481, ((timeLength)))));
                
                //#line 44 "/home/dsl/workspace/plhamK/plham/event/OrderMistakeShock.x10"
                order = ((t$34482));
            } else {
                
                //#line 47 "/home/dsl/workspace/plhamK/plham/event/OrderMistakeShock.x10"
                final plham.Order.Kind t$34483 = ((plham.Order.get$KIND_BUY_LIMIT_ORDER()));
                
                //#line 47 "/home/dsl/workspace/plhamK/plham/event/OrderMistakeShock.x10"
                final long t$34484 = this.orderVolume;
                
                //#line 47 "/home/dsl/workspace/plhamK/plham/event/OrderMistakeShock.x10"
                final plham.Order t$34485 = ((new plham.Order((java.lang.System[]) null).plham$Order$$init$S(((t$34483)), ((agent)), ((market)), ((orderPrice)), t$34484, ((timeLength)))));
                
                //#line 47 "/home/dsl/workspace/plhamK/plham/event/OrderMistakeShock.x10"
                order = ((t$34485));
            }
            
            //#line 49 "/home/dsl/workspace/plhamK/plham/event/OrderMistakeShock.x10"
            market.handleOrder(((order)));
            
            //#line 50 "/home/dsl/workspace/plhamK/plham/event/OrderMistakeShock.x10"
            final x10.io.Printer t$34491 = ((x10.io.Console.get$OUT()));
            
            //#line 50 "/home/dsl/workspace/plhamK/plham/event/OrderMistakeShock.x10"
            final java.lang.String t$34487 = (("# OrderMistakeShock: ") + (order));
            
            //#line 50 "/home/dsl/workspace/plhamK/plham/event/OrderMistakeShock.x10"
            final java.lang.String t$34488 = ((t$34487) + ("(volume "));
            
            //#line 50 "/home/dsl/workspace/plhamK/plham/event/OrderMistakeShock.x10"
            final long t$34489 = order.getVolume$O();
            
            //#line 50 "/home/dsl/workspace/plhamK/plham/event/OrderMistakeShock.x10"
            final java.lang.String t$34490 = ((t$34488) + ((x10.core.Long.$box(t$34489))));
            
            //#line 50 "/home/dsl/workspace/plhamK/plham/event/OrderMistakeShock.x10"
            final java.lang.String t$34492 = ((t$34490) + (")"));
            
            //#line 50 "/home/dsl/workspace/plhamK/plham/event/OrderMistakeShock.x10"
            t$34491.println(((t$34492)));
        }
    }
    
    
    //#line 54 "/home/dsl/workspace/plhamK/plham/event/OrderMistakeShock.x10"
    public static void register(final plham.main.Simulator sim) {
        
        //#line 55 "/home/dsl/workspace/plhamK/plham/event/OrderMistakeShock.x10"
        final java.lang.String name = (("OrderMistakeShock"));
        
        //#line 56 "/home/dsl/workspace/plhamK/plham/event/OrderMistakeShock.x10"
        final x10.core.fun.Fun_0_4 t$34496 = ((new plham.event.OrderMistakeShock.$Closure$29(sim)));
        
        //#line 56 "/home/dsl/workspace/plhamK/plham/event/OrderMistakeShock.x10"
        sim.addEventInitializer__1$1x10$lang$Long$3x10$lang$String$3x10$util$Random$3cassia$util$JSON$Value$3plham$Event$2(((name)), ((t$34496)));
    }
    
    
    //#line 61 "/home/dsl/workspace/plhamK/plham/event/OrderMistakeShock.x10"
    public plham.event.OrderMistakeShock setup(final cassia.util.JSON.Value json, final plham.main.Simulator sim) {
        
        //#line 62 "/home/dsl/workspace/plhamK/plham/event/OrderMistakeShock.x10"
        final cassia.util.JSON.Value t$34497 = json.<java.lang.String> get(x10.rtt.Types.STRING, (("target")));
        
        //#line 62 "/home/dsl/workspace/plhamK/plham/event/OrderMistakeShock.x10"
        final plham.Market market = sim.getMarketByName(((t$34497)));
        
        //#line 63 "/home/dsl/workspace/plhamK/plham/event/OrderMistakeShock.x10"
        final x10.util.List t$34498 = sim.getAgentsByName((("agents")));
        
        //#line 63 "/home/dsl/workspace/plhamK/plham/event/OrderMistakeShock.x10"
        final plham.Agent agent = ((x10.util.Indexed<plham.Agent>)t$34498).$apply$G((0L));
        
        //#line 64 "/home/dsl/workspace/plhamK/plham/event/OrderMistakeShock.x10"
        final long t = market.getTime$O();
        
        //#line 65 "/home/dsl/workspace/plhamK/plham/event/OrderMistakeShock.x10"
        final long t$34499 = market.id;
        
        //#line 65 "/home/dsl/workspace/plhamK/plham/event/OrderMistakeShock.x10"
        this.marketId = t$34499;
        
        //#line 66 "/home/dsl/workspace/plhamK/plham/event/OrderMistakeShock.x10"
        final long t$34500 = agent.id;
        
        //#line 66 "/home/dsl/workspace/plhamK/plham/event/OrderMistakeShock.x10"
        this.agentId = t$34500;
        
        //#line 67 "/home/dsl/workspace/plhamK/plham/event/OrderMistakeShock.x10"
        final cassia.util.JSON.Value t$34501 = json.<java.lang.String> get(x10.rtt.Types.STRING, (("triggerTime")));
        
        //#line 67 "/home/dsl/workspace/plhamK/plham/event/OrderMistakeShock.x10"
        final long t$34502 = t$34501.toLong$O();
        
        //#line 67 "/home/dsl/workspace/plhamK/plham/event/OrderMistakeShock.x10"
        final long t$34503 = ((t) + (((t$34502))));
        
        //#line 67 "/home/dsl/workspace/plhamK/plham/event/OrderMistakeShock.x10"
        this.triggerTime = t$34503;
        
        //#line 68 "/home/dsl/workspace/plhamK/plham/event/OrderMistakeShock.x10"
        final cassia.util.JSON.Value t$34504 = json.<java.lang.String> get(x10.rtt.Types.STRING, (("priceChangeRate")));
        
        //#line 68 "/home/dsl/workspace/plhamK/plham/event/OrderMistakeShock.x10"
        final double t$34505 = t$34504.toDouble$O();
        
        //#line 68 "/home/dsl/workspace/plhamK/plham/event/OrderMistakeShock.x10"
        this.priceChangeRate = t$34505;
        
        //#line 69 "/home/dsl/workspace/plhamK/plham/event/OrderMistakeShock.x10"
        final cassia.util.JSON.Value t$34506 = json.<java.lang.String> get(x10.rtt.Types.STRING, (("orderVolume")));
        
        //#line 69 "/home/dsl/workspace/plhamK/plham/event/OrderMistakeShock.x10"
        final long t$34507 = t$34506.toLong$O();
        
        //#line 69 "/home/dsl/workspace/plhamK/plham/event/OrderMistakeShock.x10"
        this.orderVolume = t$34507;
        
        //#line 70 "/home/dsl/workspace/plhamK/plham/event/OrderMistakeShock.x10"
        final cassia.util.JSON.Value t$34508 = json.<java.lang.String> get(x10.rtt.Types.STRING, (("orderTimeLength")));
        
        //#line 70 "/home/dsl/workspace/plhamK/plham/event/OrderMistakeShock.x10"
        final long t$34509 = t$34508.toLong$O();
        
        //#line 70 "/home/dsl/workspace/plhamK/plham/event/OrderMistakeShock.x10"
        this.orderTimeLength = t$34509;
        
        //#line 71 "/home/dsl/workspace/plhamK/plham/event/OrderMistakeShock.x10"
        market.addBeforeSimulationStepEvent$O(((this)));
        
        //#line 72 "/home/dsl/workspace/plhamK/plham/event/OrderMistakeShock.x10"
        return this;
    }
    
    
    //#line 14 "/home/dsl/workspace/plhamK/plham/event/OrderMistakeShock.x10"
    final public plham.event.OrderMistakeShock plham$event$OrderMistakeShock$$this$plham$event$OrderMistakeShock() {
        
        //#line 14 "/home/dsl/workspace/plhamK/plham/event/OrderMistakeShock.x10"
        return plham.event.OrderMistakeShock.this;
    }
    
    
    //#line 14 "/home/dsl/workspace/plhamK/plham/event/OrderMistakeShock.x10"
    final public void __fieldInitializers_plham_event_OrderMistakeShock() {
        
        //#line 14 "/home/dsl/workspace/plhamK/plham/event/OrderMistakeShock.x10"
        this.marketId = 0L;
        
        //#line 14 "/home/dsl/workspace/plhamK/plham/event/OrderMistakeShock.x10"
        this.agentId = 0L;
        
        //#line 14 "/home/dsl/workspace/plhamK/plham/event/OrderMistakeShock.x10"
        this.triggerTime = 0L;
        
        //#line 14 "/home/dsl/workspace/plhamK/plham/event/OrderMistakeShock.x10"
        this.priceChangeRate = 0.0;
        
        //#line 14 "/home/dsl/workspace/plhamK/plham/event/OrderMistakeShock.x10"
        this.orderVolume = 0L;
        
        //#line 14 "/home/dsl/workspace/plhamK/plham/event/OrderMistakeShock.x10"
        this.orderTimeLength = 0L;
    }
    
    
    final public static class $Closure$29 extends x10.core.Ref implements x10.core.fun.Fun_0_4, x10.serialization.X10JavaSerializable
    {
        public static final x10.rtt.RuntimeType<$Closure$29> $RTT = 
            x10.rtt.StaticFunType.<$Closure$29> make($Closure$29.class,
                                                     new x10.rtt.Type[] {
                                                         x10.rtt.ParameterizedType.make(x10.core.fun.Fun_0_4.$RTT, x10.rtt.Types.LONG, x10.rtt.Types.STRING, x10.util.Random.$RTT, cassia.util.JSON.Value.$RTT, plham.event.OrderMistakeShock.$RTT)
                                                     });
        
        public x10.rtt.RuntimeType<?> $getRTT() { return $RTT; }
        
        public x10.rtt.Type<?> $getParam(int i) { return null; }
        
        private Object writeReplace() throws java.io.ObjectStreamException {
            return new x10.serialization.SerializationProxy(this);
        }
        
        public static x10.serialization.X10JavaSerializable $_deserialize_body(plham.event.OrderMistakeShock.$Closure$29 $_obj, x10.serialization.X10JavaDeserializer $deserializer) throws java.io.IOException {
            if (x10.runtime.impl.java.Runtime.TRACE_SER) { x10.runtime.impl.java.Runtime.printTraceMessage("X10JavaSerializable: $_deserialize_body() of " + $Closure$29.class + " calling"); } 
            $_obj.sim = $deserializer.readObject();
            return $_obj;
        }
        
        public static x10.serialization.X10JavaSerializable $_deserializer(x10.serialization.X10JavaDeserializer $deserializer) throws java.io.IOException {
            plham.event.OrderMistakeShock.$Closure$29 $_obj = new plham.event.OrderMistakeShock.$Closure$29((java.lang.System[]) null);
            $deserializer.record_reference($_obj);
            return $_deserialize_body($_obj, $deserializer);
        }
        
        public void $_serialize(x10.serialization.X10JavaSerializer $serializer) throws java.io.IOException {
            $serializer.write(this.sim);
            
        }
        
        // constructor just for allocation
        public $Closure$29(final java.lang.System[] $dummy) {
            
        }
        
        // dispatcher for method abstract public (Z1,Z2,Z3,Z4)=>U.operator()(a1:Z1, a2:Z2, a3:Z3, a4:Z4):U
        public java.lang.Object $apply(final java.lang.Object a1, final x10.rtt.Type t1, final java.lang.Object a2, final x10.rtt.Type t2, final java.lang.Object a3, final x10.rtt.Type t3, final java.lang.Object a4, final x10.rtt.Type t4) {
            return $apply(x10.core.Long.$unbox(a1), (java.lang.String)a2, (x10.util.Random)a3, (cassia.util.JSON.Value)a4);
            
        }
        
        
    
        
        public plham.event.OrderMistakeShock $apply(final long id, final java.lang.String name, final x10.util.Random random, final cassia.util.JSON.Value json) {
            
            //#line 57 "/home/dsl/workspace/plhamK/plham/event/OrderMistakeShock.x10"
            final plham.event.OrderMistakeShock t$34494 = ((new plham.event.OrderMistakeShock((java.lang.System[]) null).plham$event$OrderMistakeShock$$init$S(((id)), ((name)), ((random)))));
            
            //#line 57 "/home/dsl/workspace/plhamK/plham/event/OrderMistakeShock.x10"
            final plham.event.OrderMistakeShock t$34495 = t$34494.setup(((json)), ((this.sim)));
            
            //#line 57 "/home/dsl/workspace/plhamK/plham/event/OrderMistakeShock.x10"
            return t$34495;
        }
        
        public plham.main.Simulator sim;
        
        public $Closure$29(final plham.main.Simulator sim) {
             {
                this.sim = ((sim));
            }
        }
        
    }
    
}

