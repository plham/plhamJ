package plham.event;



public class PriceLimitRule extends x10.core.Ref implements plham.Market.OrderEvent, x10.serialization.X10JavaSerializable
{
    public static final x10.rtt.RuntimeType<PriceLimitRule> $RTT = 
        x10.rtt.NamedType.<PriceLimitRule> make("plham.event.PriceLimitRule",
                                                PriceLimitRule.class,
                                                new x10.rtt.Type[] {
                                                    plham.Market.OrderEvent.$RTT
                                                });
    
    public x10.rtt.RuntimeType<?> $getRTT() { return $RTT; }
    
    public x10.rtt.Type<?> $getParam(int i) { return null; }
    
    private Object writeReplace() throws java.io.ObjectStreamException {
        return new x10.serialization.SerializationProxy(this);
    }
    
    public static x10.serialization.X10JavaSerializable $_deserialize_body(plham.event.PriceLimitRule $_obj, x10.serialization.X10JavaDeserializer $deserializer) throws java.io.IOException {
        if (x10.runtime.impl.java.Runtime.TRACE_SER) { x10.runtime.impl.java.Runtime.printTraceMessage("X10JavaSerializable: $_deserialize_body() of " + PriceLimitRule.class + " calling"); } 
        $_obj.activationCount = $deserializer.readLong();
        $_obj.id = $deserializer.readLong();
        $_obj.name = $deserializer.readObject();
        $_obj.random = $deserializer.readObject();
        $_obj.referenceMarketId = $deserializer.readLong();
        $_obj.referencePrice = $deserializer.readDouble();
        $_obj.triggerChangeRate = $deserializer.readDouble();
        return $_obj;
    }
    
    public static x10.serialization.X10JavaSerializable $_deserializer(x10.serialization.X10JavaDeserializer $deserializer) throws java.io.IOException {
        plham.event.PriceLimitRule $_obj = new plham.event.PriceLimitRule((java.lang.System[]) null);
        $deserializer.record_reference($_obj);
        return $_deserialize_body($_obj, $deserializer);
    }
    
    public void $_serialize(x10.serialization.X10JavaSerializer $serializer) throws java.io.IOException {
        $serializer.write(this.activationCount);
        $serializer.write(this.id);
        $serializer.write(this.name);
        $serializer.write(this.random);
        $serializer.write(this.referenceMarketId);
        $serializer.write(this.referencePrice);
        $serializer.write(this.triggerChangeRate);
        
    }
    
    // constructor just for allocation
    public PriceLimitRule(final java.lang.System[] $dummy) {
        
    }
    
    

    
    //#line 11 "/home/dsl/workspace/plhamK/plham/event/PriceLimitRule.x10"
    public long id;
    
    //#line 12 "/home/dsl/workspace/plhamK/plham/event/PriceLimitRule.x10"
    public java.lang.String name;
    
    //#line 13 "/home/dsl/workspace/plhamK/plham/event/PriceLimitRule.x10"
    public x10.util.Random random;
    
    //#line 14 "/home/dsl/workspace/plhamK/plham/event/PriceLimitRule.x10"
    public long referenceMarketId;
    
    //#line 15 "/home/dsl/workspace/plhamK/plham/event/PriceLimitRule.x10"
    public double referencePrice;
    
    //#line 16 "/home/dsl/workspace/plhamK/plham/event/PriceLimitRule.x10"
    public double triggerChangeRate;
    
    //#line 17 "/home/dsl/workspace/plhamK/plham/event/PriceLimitRule.x10"
    public long activationCount;
    
    
    //#line 19 "/home/dsl/workspace/plhamK/plham/event/PriceLimitRule.x10"
    // creation method for java code (1-phase java constructor)
    public PriceLimitRule(final long id, final java.lang.String name, final x10.util.Random random) {
        this((java.lang.System[]) null);
        plham$event$PriceLimitRule$$init$S(id, name, random);
    }
    
    // constructor for non-virtual call
    final public plham.event.PriceLimitRule plham$event$PriceLimitRule$$init$S(final long id, final java.lang.String name, final x10.util.Random random) {
         {
            
            //#line 19 "/home/dsl/workspace/plhamK/plham/event/PriceLimitRule.x10"
            
            
            //#line 9 "/home/dsl/workspace/plhamK/plham/event/PriceLimitRule.x10"
            this.__fieldInitializers_plham_event_PriceLimitRule();
            
            //#line 20 "/home/dsl/workspace/plhamK/plham/event/PriceLimitRule.x10"
            this.id = id;
            
            //#line 21 "/home/dsl/workspace/plhamK/plham/event/PriceLimitRule.x10"
            this.name = ((name));
            
            //#line 22 "/home/dsl/workspace/plhamK/plham/event/PriceLimitRule.x10"
            this.random = ((random));
            
            //#line 26 "/home/dsl/workspace/plhamK/plham/event/PriceLimitRule.x10"
            this.activationCount = 0L;
        }
        return this;
    }
    
    
    
    //#line 30 "/home/dsl/workspace/plhamK/plham/event/PriceLimitRule.x10"
    /** This is for Agents to calculate the modified price within the price limits. */
    public double getLimitedPrice$O(final plham.Order order, final plham.Market market) {
        
        //#line 31 "/home/dsl/workspace/plhamK/plham/event/PriceLimitRule.x10"
        assert (this.referenceMarketId) == (market.id);
        
        //#line 32 "/home/dsl/workspace/plhamK/plham/event/PriceLimitRule.x10"
        final double orderPrice = order.getPrice$O();
        
        //#line 33 "/home/dsl/workspace/plhamK/plham/event/PriceLimitRule.x10"
        final double t$34566 = this.referencePrice;
        
        //#line 33 "/home/dsl/workspace/plhamK/plham/event/PriceLimitRule.x10"
        final double priceChange = ((orderPrice) - (((t$34566))));
        
        //#line 34 "/home/dsl/workspace/plhamK/plham/event/PriceLimitRule.x10"
        final double t$34567 = this.referencePrice;
        
        //#line 34 "/home/dsl/workspace/plhamK/plham/event/PriceLimitRule.x10"
        final double t$34568 = this.triggerChangeRate;
        
        //#line 34 "/home/dsl/workspace/plhamK/plham/event/PriceLimitRule.x10"
        final double thresholdChange = ((t$34567) * (((t$34568))));
        
        //#line 35 "/home/dsl/workspace/plhamK/plham/event/PriceLimitRule.x10"
        final double t$34569 = java.lang.Math.abs(((priceChange)));
        
        //#line 35 "/home/dsl/workspace/plhamK/plham/event/PriceLimitRule.x10"
        final double t$34570 = java.lang.Math.abs(((thresholdChange)));
        
        //#line 35 "/home/dsl/workspace/plhamK/plham/event/PriceLimitRule.x10"
        final boolean t$34580 = ((t$34569) >= (((t$34570))));
        
        //#line 35 "/home/dsl/workspace/plhamK/plham/event/PriceLimitRule.x10"
        if (t$34580) {
            
            //#line 36 "/home/dsl/workspace/plhamK/plham/event/PriceLimitRule.x10"
            final double t$34573 = this.referencePrice;
            
            //#line 36 "/home/dsl/workspace/plhamK/plham/event/PriceLimitRule.x10"
            final double t$34571 = ((((1L))));
            
            //#line 36 "/home/dsl/workspace/plhamK/plham/event/PriceLimitRule.x10"
            final double t$34572 = this.triggerChangeRate;
            
            //#line 36 "/home/dsl/workspace/plhamK/plham/event/PriceLimitRule.x10"
            final double t$34574 = ((t$34571) + (((t$34572))));
            
            //#line 36 "/home/dsl/workspace/plhamK/plham/event/PriceLimitRule.x10"
            final double maxPrice = ((t$34573) * (((t$34574))));
            
            //#line 37 "/home/dsl/workspace/plhamK/plham/event/PriceLimitRule.x10"
            final double t$34577 = this.referencePrice;
            
            //#line 37 "/home/dsl/workspace/plhamK/plham/event/PriceLimitRule.x10"
            final double t$34575 = ((((1L))));
            
            //#line 37 "/home/dsl/workspace/plhamK/plham/event/PriceLimitRule.x10"
            final double t$34576 = this.triggerChangeRate;
            
            //#line 37 "/home/dsl/workspace/plhamK/plham/event/PriceLimitRule.x10"
            final double t$34578 = ((t$34575) - (((t$34576))));
            
            //#line 37 "/home/dsl/workspace/plhamK/plham/event/PriceLimitRule.x10"
            final double minPrice = ((t$34577) * (((t$34578))));
            
            //#line 38 "/home/dsl/workspace/plhamK/plham/event/PriceLimitRule.x10"
            final double t$34579 = java.lang.Math.max(((orderPrice)),((minPrice)));
            
            //#line 38 "/home/dsl/workspace/plhamK/plham/event/PriceLimitRule.x10"
            final double limitedPrice = java.lang.Math.min(((t$34579)),((maxPrice)));
            
            //#line 39 "/home/dsl/workspace/plhamK/plham/event/PriceLimitRule.x10"
            return limitedPrice;
        }
        
        //#line 41 "/home/dsl/workspace/plhamK/plham/event/PriceLimitRule.x10"
        return orderPrice;
    }
    
    
    //#line 45 "/home/dsl/workspace/plhamK/plham/event/PriceLimitRule.x10"
    /** This should be called only from the System. */
    public void update(final plham.Market market, final plham.Order order) {
        
        //#line 46 "/home/dsl/workspace/plhamK/plham/event/PriceLimitRule.x10"
        assert (this.referenceMarketId) == (market.id);
        
        //#line 47 "/home/dsl/workspace/plhamK/plham/event/PriceLimitRule.x10"
        final boolean t$34584 = market.isRunning$O();
        
        //#line 47 "/home/dsl/workspace/plhamK/plham/event/PriceLimitRule.x10"
        if (t$34584) {
            
            //#line 49 "/home/dsl/workspace/plhamK/plham/event/PriceLimitRule.x10"
            final double oldPrice = order.getPrice$O();
            
            //#line 50 "/home/dsl/workspace/plhamK/plham/event/PriceLimitRule.x10"
            final double newPrice = this.getLimitedPrice$O(((order)), ((market)));
            
            //#line 51 "/home/dsl/workspace/plhamK/plham/event/PriceLimitRule.x10"
            order.setPrice$O((newPrice));
            
            //#line 52 "/home/dsl/workspace/plhamK/plham/event/PriceLimitRule.x10"
            final boolean t$34583 = (newPrice) != (oldPrice);
            
            //#line 52 "/home/dsl/workspace/plhamK/plham/event/PriceLimitRule.x10"
            if (t$34583) {
                
                //#line 53 "/home/dsl/workspace/plhamK/plham/event/PriceLimitRule.x10"
                final long t$34581 = this.activationCount;
                
                //#line 53 "/home/dsl/workspace/plhamK/plham/event/PriceLimitRule.x10"
                final long t$34582 = ((t$34581) + (((1L))));
                
                //#line 53 "/home/dsl/workspace/plhamK/plham/event/PriceLimitRule.x10"
                this.activationCount = t$34582;
            }
        }
    }
    
    
    //#line 58 "/home/dsl/workspace/plhamK/plham/event/PriceLimitRule.x10"
    public static void register(final plham.main.Simulator sim) {
        
        //#line 59 "/home/dsl/workspace/plhamK/plham/event/PriceLimitRule.x10"
        final java.lang.String name = (("PriceLimitRule"));
        
        //#line 60 "/home/dsl/workspace/plhamK/plham/event/PriceLimitRule.x10"
        final x10.core.fun.Fun_0_4 t$34587 = ((new plham.event.PriceLimitRule.$Closure$30(sim)));
        
        //#line 60 "/home/dsl/workspace/plhamK/plham/event/PriceLimitRule.x10"
        sim.addEventInitializer__1$1x10$lang$Long$3x10$lang$String$3x10$util$Random$3cassia$util$JSON$Value$3plham$Event$2(((name)), ((t$34587)));
    }
    
    
    //#line 65 "/home/dsl/workspace/plhamK/plham/event/PriceLimitRule.x10"
    public plham.event.PriceLimitRule setup(final cassia.util.JSON.Value json, final plham.main.Simulator sim) {
        
        //#line 66 "/home/dsl/workspace/plhamK/plham/event/PriceLimitRule.x10"
        final cassia.util.JSON.Value t$34588 = json.<java.lang.String> get(x10.rtt.Types.STRING, (("referenceMarket")));
        
        //#line 66 "/home/dsl/workspace/plhamK/plham/event/PriceLimitRule.x10"
        final plham.Market referenceMarket = sim.getMarketByName(((t$34588)));
        
        //#line 67 "/home/dsl/workspace/plhamK/plham/event/PriceLimitRule.x10"
        final long t$34589 = referenceMarket.id;
        
        //#line 67 "/home/dsl/workspace/plhamK/plham/event/PriceLimitRule.x10"
        this.referenceMarketId = t$34589;
        
        //#line 68 "/home/dsl/workspace/plhamK/plham/event/PriceLimitRule.x10"
        final double t$34590 = referenceMarket.getPrice$O();
        
        //#line 68 "/home/dsl/workspace/plhamK/plham/event/PriceLimitRule.x10"
        this.referencePrice = t$34590;
        
        //#line 69 "/home/dsl/workspace/plhamK/plham/event/PriceLimitRule.x10"
        final cassia.util.JSON.Value t$34591 = json.<java.lang.String> get(x10.rtt.Types.STRING, (("triggerChangeRate")));
        
        //#line 69 "/home/dsl/workspace/plhamK/plham/event/PriceLimitRule.x10"
        final double t$34592 = t$34591.toDouble$O();
        
        //#line 69 "/home/dsl/workspace/plhamK/plham/event/PriceLimitRule.x10"
        this.triggerChangeRate = t$34592;
        
        //#line 70 "/home/dsl/workspace/plhamK/plham/event/PriceLimitRule.x10"
        referenceMarket.addBeforeOrderHandlingEvent$O(((this)));
        
        //#line 71 "/home/dsl/workspace/plhamK/plham/event/PriceLimitRule.x10"
        return this;
    }
    
    
    //#line 9 "/home/dsl/workspace/plhamK/plham/event/PriceLimitRule.x10"
    final public plham.event.PriceLimitRule plham$event$PriceLimitRule$$this$plham$event$PriceLimitRule() {
        
        //#line 9 "/home/dsl/workspace/plhamK/plham/event/PriceLimitRule.x10"
        return plham.event.PriceLimitRule.this;
    }
    
    
    //#line 9 "/home/dsl/workspace/plhamK/plham/event/PriceLimitRule.x10"
    final public void __fieldInitializers_plham_event_PriceLimitRule() {
        
        //#line 9 "/home/dsl/workspace/plhamK/plham/event/PriceLimitRule.x10"
        this.referenceMarketId = 0L;
        
        //#line 9 "/home/dsl/workspace/plhamK/plham/event/PriceLimitRule.x10"
        this.referencePrice = 0.0;
        
        //#line 9 "/home/dsl/workspace/plhamK/plham/event/PriceLimitRule.x10"
        this.triggerChangeRate = 0.0;
        
        //#line 9 "/home/dsl/workspace/plhamK/plham/event/PriceLimitRule.x10"
        this.activationCount = 0L;
    }
    
    
    final public static class $Closure$30 extends x10.core.Ref implements x10.core.fun.Fun_0_4, x10.serialization.X10JavaSerializable
    {
        public static final x10.rtt.RuntimeType<$Closure$30> $RTT = 
            x10.rtt.StaticFunType.<$Closure$30> make($Closure$30.class,
                                                     new x10.rtt.Type[] {
                                                         x10.rtt.ParameterizedType.make(x10.core.fun.Fun_0_4.$RTT, x10.rtt.Types.LONG, x10.rtt.Types.STRING, x10.util.Random.$RTT, cassia.util.JSON.Value.$RTT, plham.event.PriceLimitRule.$RTT)
                                                     });
        
        public x10.rtt.RuntimeType<?> $getRTT() { return $RTT; }
        
        public x10.rtt.Type<?> $getParam(int i) { return null; }
        
        private Object writeReplace() throws java.io.ObjectStreamException {
            return new x10.serialization.SerializationProxy(this);
        }
        
        public static x10.serialization.X10JavaSerializable $_deserialize_body(plham.event.PriceLimitRule.$Closure$30 $_obj, x10.serialization.X10JavaDeserializer $deserializer) throws java.io.IOException {
            if (x10.runtime.impl.java.Runtime.TRACE_SER) { x10.runtime.impl.java.Runtime.printTraceMessage("X10JavaSerializable: $_deserialize_body() of " + $Closure$30.class + " calling"); } 
            $_obj.sim = $deserializer.readObject();
            return $_obj;
        }
        
        public static x10.serialization.X10JavaSerializable $_deserializer(x10.serialization.X10JavaDeserializer $deserializer) throws java.io.IOException {
            plham.event.PriceLimitRule.$Closure$30 $_obj = new plham.event.PriceLimitRule.$Closure$30((java.lang.System[]) null);
            $deserializer.record_reference($_obj);
            return $_deserialize_body($_obj, $deserializer);
        }
        
        public void $_serialize(x10.serialization.X10JavaSerializer $serializer) throws java.io.IOException {
            $serializer.write(this.sim);
            
        }
        
        // constructor just for allocation
        public $Closure$30(final java.lang.System[] $dummy) {
            
        }
        
        // dispatcher for method abstract public (Z1,Z2,Z3,Z4)=>U.operator()(a1:Z1, a2:Z2, a3:Z3, a4:Z4):U
        public java.lang.Object $apply(final java.lang.Object a1, final x10.rtt.Type t1, final java.lang.Object a2, final x10.rtt.Type t2, final java.lang.Object a3, final x10.rtt.Type t3, final java.lang.Object a4, final x10.rtt.Type t4) {
            return $apply(x10.core.Long.$unbox(a1), (java.lang.String)a2, (x10.util.Random)a3, (cassia.util.JSON.Value)a4);
            
        }
        
        
    
        
        public plham.event.PriceLimitRule $apply(final long id, final java.lang.String name, final x10.util.Random random, final cassia.util.JSON.Value json) {
            
            //#line 61 "/home/dsl/workspace/plhamK/plham/event/PriceLimitRule.x10"
            final plham.event.PriceLimitRule t$34585 = ((new plham.event.PriceLimitRule((java.lang.System[]) null).plham$event$PriceLimitRule$$init$S(((id)), ((name)), ((random)))));
            
            //#line 61 "/home/dsl/workspace/plhamK/plham/event/PriceLimitRule.x10"
            final plham.event.PriceLimitRule t$34586 = t$34585.setup(((json)), ((this.sim)));
            
            //#line 61 "/home/dsl/workspace/plhamK/plham/event/PriceLimitRule.x10"
            return t$34586;
        }
        
        public plham.main.Simulator sim;
        
        public $Closure$30(final plham.main.Simulator sim) {
             {
                this.sim = ((sim));
            }
        }
        
    }
    
}

