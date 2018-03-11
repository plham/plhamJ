package plham.event;


/**
 * This suddently changes the fundamental price (just changing it).
 */

public class FundamentalPriceShock extends x10.core.Ref implements plham.Market.MarketEvent, x10.serialization.X10JavaSerializable
{
    public static final x10.rtt.RuntimeType<FundamentalPriceShock> $RTT = 
        x10.rtt.NamedType.<FundamentalPriceShock> make("plham.event.FundamentalPriceShock",
                                                       FundamentalPriceShock.class,
                                                       new x10.rtt.Type[] {
                                                           plham.Market.MarketEvent.$RTT
                                                       });
    
    public x10.rtt.RuntimeType<?> $getRTT() { return $RTT; }
    
    public x10.rtt.Type<?> $getParam(int i) { return null; }
    
    private Object writeReplace() throws java.io.ObjectStreamException {
        return new x10.serialization.SerializationProxy(this);
    }
    
    public static x10.serialization.X10JavaSerializable $_deserialize_body(plham.event.FundamentalPriceShock $_obj, x10.serialization.X10JavaDeserializer $deserializer) throws java.io.IOException {
        if (x10.runtime.impl.java.Runtime.TRACE_SER) { x10.runtime.impl.java.Runtime.printTraceMessage("X10JavaSerializable: $_deserialize_body() of " + FundamentalPriceShock.class + " calling"); } 
        $_obj.id = $deserializer.readLong();
        $_obj.marketId = $deserializer.readLong();
        $_obj.name = $deserializer.readObject();
        $_obj.priceChangeRate = $deserializer.readDouble();
        $_obj.random = $deserializer.readObject();
        $_obj.shockTimeLength = $deserializer.readLong();
        $_obj.triggerTime = $deserializer.readLong();
        return $_obj;
    }
    
    public static x10.serialization.X10JavaSerializable $_deserializer(x10.serialization.X10JavaDeserializer $deserializer) throws java.io.IOException {
        plham.event.FundamentalPriceShock $_obj = new plham.event.FundamentalPriceShock((java.lang.System[]) null);
        $deserializer.record_reference($_obj);
        return $_deserialize_body($_obj, $deserializer);
    }
    
    public void $_serialize(x10.serialization.X10JavaSerializer $serializer) throws java.io.IOException {
        $serializer.write(this.id);
        $serializer.write(this.marketId);
        $serializer.write(this.name);
        $serializer.write(this.priceChangeRate);
        $serializer.write(this.random);
        $serializer.write(this.shockTimeLength);
        $serializer.write(this.triggerTime);
        
    }
    
    // constructor just for allocation
    public FundamentalPriceShock(final java.lang.System[] $dummy) {
        
    }
    
    

    
    //#line 14 "/home/dsl/workspace/plhamK/plham/event/FundamentalPriceShock.x10"
    private static long NO_TIME_LENGTH = 0L;
    
    //#line 16 "/home/dsl/workspace/plhamK/plham/event/FundamentalPriceShock.x10"
    public long id;
    
    //#line 17 "/home/dsl/workspace/plhamK/plham/event/FundamentalPriceShock.x10"
    public java.lang.String name;
    
    //#line 18 "/home/dsl/workspace/plhamK/plham/event/FundamentalPriceShock.x10"
    public x10.util.Random random;
    
    //#line 20 "/home/dsl/workspace/plhamK/plham/event/FundamentalPriceShock.x10"
    public long marketId;
    
    //#line 21 "/home/dsl/workspace/plhamK/plham/event/FundamentalPriceShock.x10"
    public long triggerTime;
    
    //#line 22 "/home/dsl/workspace/plhamK/plham/event/FundamentalPriceShock.x10"
    public double priceChangeRate;
    
    //#line 23 "/home/dsl/workspace/plhamK/plham/event/FundamentalPriceShock.x10"
    public long shockTimeLength;
    
    
    //#line 25 "/home/dsl/workspace/plhamK/plham/event/FundamentalPriceShock.x10"
    // creation method for java code (1-phase java constructor)
    public FundamentalPriceShock(final long id, final java.lang.String name, final x10.util.Random random) {
        this((java.lang.System[]) null);
        plham$event$FundamentalPriceShock$$init$S(id, name, random);
    }
    
    // constructor for non-virtual call
    final public plham.event.FundamentalPriceShock plham$event$FundamentalPriceShock$$init$S(final long id, final java.lang.String name, final x10.util.Random random) {
         {
            
            //#line 25 "/home/dsl/workspace/plhamK/plham/event/FundamentalPriceShock.x10"
            
            
            //#line 12 "/home/dsl/workspace/plhamK/plham/event/FundamentalPriceShock.x10"
            this.__fieldInitializers_plham_event_FundamentalPriceShock();
            
            //#line 26 "/home/dsl/workspace/plhamK/plham/event/FundamentalPriceShock.x10"
            this.id = id;
            
            //#line 27 "/home/dsl/workspace/plhamK/plham/event/FundamentalPriceShock.x10"
            this.name = ((name));
            
            //#line 28 "/home/dsl/workspace/plhamK/plham/event/FundamentalPriceShock.x10"
            this.random = ((random));
            
            //#line 29 "/home/dsl/workspace/plhamK/plham/event/FundamentalPriceShock.x10"
            final long t$21208 = plham.event.FundamentalPriceShock.get$NO_TIME_LENGTH();
            
            //#line 29 "/home/dsl/workspace/plhamK/plham/event/FundamentalPriceShock.x10"
            this.shockTimeLength = t$21208;
        }
        return this;
    }
    
    
    
    //#line 32 "/home/dsl/workspace/plhamK/plham/event/FundamentalPriceShock.x10"
    public void update(final plham.Market market) {
        
        //#line 33 "/home/dsl/workspace/plhamK/plham/event/FundamentalPriceShock.x10"
        assert (this.marketId) == (market.id);
        
        //#line 34 "/home/dsl/workspace/plhamK/plham/event/FundamentalPriceShock.x10"
        final long t = market.getTime$O();
        
        //#line 35 "/home/dsl/workspace/plhamK/plham/event/FundamentalPriceShock.x10"
        final long t$21209 = this.triggerTime;
        
        //#line 35 "/home/dsl/workspace/plhamK/plham/event/FundamentalPriceShock.x10"
        boolean t$21213 = ((t) >= (((t$21209))));
        
        //#line 35 "/home/dsl/workspace/plhamK/plham/event/FundamentalPriceShock.x10"
        if (t$21213) {
            
            //#line 35 "/home/dsl/workspace/plhamK/plham/event/FundamentalPriceShock.x10"
            final long t$21210 = this.triggerTime;
            
            //#line 35 "/home/dsl/workspace/plhamK/plham/event/FundamentalPriceShock.x10"
            final long t$21211 = this.shockTimeLength;
            
            //#line 35 "/home/dsl/workspace/plhamK/plham/event/FundamentalPriceShock.x10"
            final long t$21212 = ((t$21210) + (((t$21211))));
            
            //#line 35 "/home/dsl/workspace/plhamK/plham/event/FundamentalPriceShock.x10"
            t$21213 = ((t) <= (((t$21212))));
        }
        
        //#line 35 "/home/dsl/workspace/plhamK/plham/event/FundamentalPriceShock.x10"
        final boolean t$21218 = t$21213;
        
        //#line 35 "/home/dsl/workspace/plhamK/plham/event/FundamentalPriceShock.x10"
        if (t$21218) {
            
            //#line 37 "/home/dsl/workspace/plhamK/plham/event/FundamentalPriceShock.x10"
            final x10.util.ArrayList a$21191 = ((market.fundamentalPrices));
            
            //#line 37 "/home/dsl/workspace/plhamK/plham/event/FundamentalPriceShock.x10"
            final long i0$21192 = t;
            
            //#line 37 "/home/dsl/workspace/plhamK/plham/event/FundamentalPriceShock.x10"
            final double t$21216 = x10.core.Double.$unbox(((x10.util.ArrayList<x10.core.Double>)a$21191).$apply$G((i0$21192)));
            
            //#line 37 "/home/dsl/workspace/plhamK/plham/event/FundamentalPriceShock.x10"
            final double t$21214 = ((((1L))));
            
            //#line 37 "/home/dsl/workspace/plhamK/plham/event/FundamentalPriceShock.x10"
            final double t$21215 = this.priceChangeRate;
            
            //#line 37 "/home/dsl/workspace/plhamK/plham/event/FundamentalPriceShock.x10"
            final double t$21217 = ((t$21214) + (((t$21215))));
            
            //#line 37 "/home/dsl/workspace/plhamK/plham/event/FundamentalPriceShock.x10"
            final double r$21200 = ((t$21216) * (((t$21217))));
            
            //#line 37 "/home/dsl/workspace/plhamK/plham/event/FundamentalPriceShock.x10"
            ((x10.util.ArrayList<x10.core.Double>)a$21191).$set__1x10$util$ArrayList$$T$G((i0$21192), x10.core.Double.$box(r$21200));
        }
    }
    
    
    //#line 41 "/home/dsl/workspace/plhamK/plham/event/FundamentalPriceShock.x10"
    public x10.util.Random getRandom() {
        
        //#line 41 "/home/dsl/workspace/plhamK/plham/event/FundamentalPriceShock.x10"
        final x10.util.Random t$21219 = ((this.random));
        
        //#line 41 "/home/dsl/workspace/plhamK/plham/event/FundamentalPriceShock.x10"
        return t$21219;
    }
    
    
    //#line 43 "/home/dsl/workspace/plhamK/plham/event/FundamentalPriceShock.x10"
    public plham.event.FundamentalPriceShock setup(final cassia.util.JSON.Value json, final plham.main.Simulator sim) {
        
        //#line 44 "/home/dsl/workspace/plhamK/plham/event/FundamentalPriceShock.x10"
        final x10.util.Random t$21220 = ((this.getRandom()));
        
        //#line 44 "/home/dsl/workspace/plhamK/plham/event/FundamentalPriceShock.x10"
        final plham.util.JSONRandom random = ((new plham.util.JSONRandom((java.lang.System[]) null).plham$util$JSONRandom$$init$S(((t$21220)))));
        
        //#line 45 "/home/dsl/workspace/plhamK/plham/event/FundamentalPriceShock.x10"
        final cassia.util.JSON.Value t$21221 = json.<java.lang.String> get(x10.rtt.Types.STRING, (("target")));
        
        //#line 45 "/home/dsl/workspace/plhamK/plham/event/FundamentalPriceShock.x10"
        final plham.Market market = sim.getMarketByName(((t$21221)));
        
        //#line 46 "/home/dsl/workspace/plhamK/plham/event/FundamentalPriceShock.x10"
        final long t$21222 = market.id;
        
        //#line 46 "/home/dsl/workspace/plhamK/plham/event/FundamentalPriceShock.x10"
        this.marketId = t$21222;
        
        //#line 47 "/home/dsl/workspace/plhamK/plham/event/FundamentalPriceShock.x10"
        final boolean t$21233 = json.<java.lang.String> has__0cassia$util$JSON$Value$$T$O(x10.rtt.Types.STRING, (("triggerTime")));
        
        //#line 47 "/home/dsl/workspace/plhamK/plham/event/FundamentalPriceShock.x10"
        if (t$21233) {
            
            //#line 48 "/home/dsl/workspace/plhamK/plham/event/FundamentalPriceShock.x10"
            final cassia.util.JSON.Value t$21223 = json.<java.lang.String> get(x10.rtt.Types.STRING, (("triggerTime")));
            
            //#line 48 "/home/dsl/workspace/plhamK/plham/event/FundamentalPriceShock.x10"
            final long t$21224 = t$21223.toLong$O();
            
            //#line 48 "/home/dsl/workspace/plhamK/plham/event/FundamentalPriceShock.x10"
            this.triggerTime = t$21224;
        } else {
            
            //#line 49 "/home/dsl/workspace/plhamK/plham/event/FundamentalPriceShock.x10"
            final boolean t$21232 = json.<java.lang.String> has__0cassia$util$JSON$Value$$T$O(x10.rtt.Types.STRING, (("triggerDays")));
            
            //#line 49 "/home/dsl/workspace/plhamK/plham/event/FundamentalPriceShock.x10"
            if (t$21232) {
                
                //#line 52 "/home/dsl/workspace/plhamK/plham/event/FundamentalPriceShock.x10"
                final cassia.util.JSON.Value t$21225 = ((sim.CONFIG));
                
                //#line 52 "/home/dsl/workspace/plhamK/plham/event/FundamentalPriceShock.x10"
                final boolean t$21226 = t$21225.<java.lang.String> has__0cassia$util$JSON$Value$$T$O(x10.rtt.Types.STRING, (("numStepsOneDay")));
                
                //#line 52 "/home/dsl/workspace/plhamK/plham/event/FundamentalPriceShock.x10"
                final boolean t$21227 = !(t$21226);
                
                //#line 52 "/home/dsl/workspace/plhamK/plham/event/FundamentalPriceShock.x10"
                if (t$21227) {
                    
                    //#line 53 "/home/dsl/workspace/plhamK/plham/event/FundamentalPriceShock.x10"
                    assert false: "FundamentalPriceShock: triggerDays was specified, but could not find \'numStepsOneDay\'. Specify \'numStepsOneDay\' in the config.";
                }
                
                //#line 55 "/home/dsl/workspace/plhamK/plham/event/FundamentalPriceShock.x10"
                final cassia.util.JSON.Value t$21228 = ((sim.CONFIG));
                
                //#line 55 "/home/dsl/workspace/plhamK/plham/event/FundamentalPriceShock.x10"
                final cassia.util.JSON.Value t$21229 = t$21228.<java.lang.String> get(x10.rtt.Types.STRING, (("numStepsOneDay")));
                
                //#line 55 "/home/dsl/workspace/plhamK/plham/event/FundamentalPriceShock.x10"
                final long numStepsOneDay = t$21229.toLong$O();
                
                //#line 56 "/home/dsl/workspace/plhamK/plham/event/FundamentalPriceShock.x10"
                final cassia.util.JSON.Value t$21230 = json.<java.lang.String> get(x10.rtt.Types.STRING, (("triggerDays")));
                
                //#line 56 "/home/dsl/workspace/plhamK/plham/event/FundamentalPriceShock.x10"
                final long triggerDays = t$21230.toLong$O();
                
                //#line 57 "/home/dsl/workspace/plhamK/plham/event/FundamentalPriceShock.x10"
                final long t$21231 = ((triggerDays) * (((numStepsOneDay))));
                
                //#line 57 "/home/dsl/workspace/plhamK/plham/event/FundamentalPriceShock.x10"
                this.triggerTime = t$21231;
            } else {
                
                //#line 59 "/home/dsl/workspace/plhamK/plham/event/FundamentalPriceShock.x10"
                assert false: "Could not find triggerTime. Specify \'triggerTime\' or \'triggerDays\' of \'FundamentalPriceShock\' in the config file.";
            }
        }
        
        //#line 61 "/home/dsl/workspace/plhamK/plham/event/FundamentalPriceShock.x10"
        final long t$21234 = plham.event.FundamentalPriceShock.get$NO_TIME_LENGTH();
        
        //#line 61 "/home/dsl/workspace/plhamK/plham/event/FundamentalPriceShock.x10"
        this.shockTimeLength = t$21234;
        
        //#line 62 "/home/dsl/workspace/plhamK/plham/event/FundamentalPriceShock.x10"
        final cassia.util.JSON.Value t$21235 = json.<java.lang.String> get(x10.rtt.Types.STRING, (("priceChangeRate")));
        
        //#line 62 "/home/dsl/workspace/plhamK/plham/event/FundamentalPriceShock.x10"
        final double t$21236 = t$21235.toDouble$O();
        
        //#line 62 "/home/dsl/workspace/plhamK/plham/event/FundamentalPriceShock.x10"
        this.priceChangeRate = t$21236;
        
        //#line 63 "/home/dsl/workspace/plhamK/plham/event/FundamentalPriceShock.x10"
        market.addBeforeSimulationStepEvent$O(((this)));
        
        //#line 64 "/home/dsl/workspace/plhamK/plham/event/FundamentalPriceShock.x10"
        return this;
    }
    
    
    //#line 67 "/home/dsl/workspace/plhamK/plham/event/FundamentalPriceShock.x10"
    public static void register(final plham.main.Simulator sim) {
        
        //#line 68 "/home/dsl/workspace/plhamK/plham/event/FundamentalPriceShock.x10"
        final java.lang.String name = (("FundamentalPriceShock"));
        
        //#line 69 "/home/dsl/workspace/plhamK/plham/event/FundamentalPriceShock.x10"
        final x10.core.fun.Fun_0_4 t$21239 = ((new plham.event.FundamentalPriceShock.$Closure$7(sim)));
        
        //#line 69 "/home/dsl/workspace/plhamK/plham/event/FundamentalPriceShock.x10"
        sim.addEventInitializer__1$1x10$lang$Long$3x10$lang$String$3x10$util$Random$3cassia$util$JSON$Value$3plham$Event$2(((name)), ((t$21239)));
    }
    
    
    //#line 12 "/home/dsl/workspace/plhamK/plham/event/FundamentalPriceShock.x10"
    final public plham.event.FundamentalPriceShock plham$event$FundamentalPriceShock$$this$plham$event$FundamentalPriceShock() {
        
        //#line 12 "/home/dsl/workspace/plhamK/plham/event/FundamentalPriceShock.x10"
        return plham.event.FundamentalPriceShock.this;
    }
    
    
    //#line 12 "/home/dsl/workspace/plhamK/plham/event/FundamentalPriceShock.x10"
    final public void __fieldInitializers_plham_event_FundamentalPriceShock() {
        
        //#line 12 "/home/dsl/workspace/plhamK/plham/event/FundamentalPriceShock.x10"
        this.marketId = 0L;
        
        //#line 12 "/home/dsl/workspace/plhamK/plham/event/FundamentalPriceShock.x10"
        this.triggerTime = 0L;
        
        //#line 12 "/home/dsl/workspace/plhamK/plham/event/FundamentalPriceShock.x10"
        this.priceChangeRate = 0.0;
        
        //#line 12 "/home/dsl/workspace/plhamK/plham/event/FundamentalPriceShock.x10"
        this.shockTimeLength = 0L;
    }
    
    final private static x10.core.concurrent.AtomicInteger initStatus$NO_TIME_LENGTH = new x10.core.concurrent.AtomicInteger(x10.runtime.impl.java.InitDispatcher.UNINITIALIZED);
    private static x10.lang.ExceptionInInitializer exception$NO_TIME_LENGTH;
    
    public static long get$NO_TIME_LENGTH() {
        if ((plham.event.FundamentalPriceShock.initStatus$NO_TIME_LENGTH.get()) == (x10.runtime.impl.java.InitDispatcher.INITIALIZED)) {
            return plham.event.FundamentalPriceShock.NO_TIME_LENGTH;
        }
        if ((plham.event.FundamentalPriceShock.initStatus$NO_TIME_LENGTH.get()) == (x10.runtime.impl.java.InitDispatcher.EXCEPTION_RAISED)) {
            if ((x10.runtime.impl.java.InitDispatcher.TRACE_STATIC_INIT) == (true)) {
                x10.runtime.impl.java.InitDispatcher.printStaticInitMessage((("Rethrowing ExceptionInInitializer for field: plham.event.FundamentalPriceShock.NO_TIME_LENGTH")));
            }
            throw plham.event.FundamentalPriceShock.exception$NO_TIME_LENGTH;
        }
        if (plham.event.FundamentalPriceShock.initStatus$NO_TIME_LENGTH.compareAndSet((x10.runtime.impl.java.InitDispatcher.UNINITIALIZED), (x10.runtime.impl.java.InitDispatcher.INITIALIZING))) {
            try {{
                plham.event.FundamentalPriceShock.NO_TIME_LENGTH = ((java.lang.Long.MAX_VALUE) / (((2L))));
            }}catch (java.lang.Throwable exc$21240) {
                plham.event.FundamentalPriceShock.exception$NO_TIME_LENGTH = new x10.lang.ExceptionInInitializer(exc$21240);
                plham.event.FundamentalPriceShock.initStatus$NO_TIME_LENGTH.set((x10.runtime.impl.java.InitDispatcher.EXCEPTION_RAISED));
                x10.runtime.impl.java.InitDispatcher.lockInitialized();
                x10.runtime.impl.java.InitDispatcher.notifyInitialized();
                throw plham.event.FundamentalPriceShock.exception$NO_TIME_LENGTH;
            }
            if ((x10.runtime.impl.java.InitDispatcher.TRACE_STATIC_INIT) == (true)) {
                x10.runtime.impl.java.InitDispatcher.printStaticInitMessage((("Doing static initialization for field: plham.event.FundamentalPriceShock.NO_TIME_LENGTH")));
            }
            plham.event.FundamentalPriceShock.initStatus$NO_TIME_LENGTH.set((x10.runtime.impl.java.InitDispatcher.INITIALIZED));
            x10.runtime.impl.java.InitDispatcher.lockInitialized();
            x10.runtime.impl.java.InitDispatcher.notifyInitialized();
        } else {
            if (plham.event.FundamentalPriceShock.initStatus$NO_TIME_LENGTH.get() < x10.runtime.impl.java.InitDispatcher.INITIALIZED) {
                x10.runtime.impl.java.InitDispatcher.lockInitialized();
                while (plham.event.FundamentalPriceShock.initStatus$NO_TIME_LENGTH.get() < x10.runtime.impl.java.InitDispatcher.INITIALIZED) {
                    x10.runtime.impl.java.InitDispatcher.awaitInitialized();
                }
                x10.runtime.impl.java.InitDispatcher.unlockInitialized();
                if ((plham.event.FundamentalPriceShock.initStatus$NO_TIME_LENGTH.get()) == (x10.runtime.impl.java.InitDispatcher.EXCEPTION_RAISED)) {
                    if ((x10.runtime.impl.java.InitDispatcher.TRACE_STATIC_INIT) == (true)) {
                        x10.runtime.impl.java.InitDispatcher.printStaticInitMessage((("Rethrowing ExceptionInInitializer for field: plham.event.FundamentalPriceShock.NO_TIME_LENGTH")));
                    }
                    throw plham.event.FundamentalPriceShock.exception$NO_TIME_LENGTH;
                }
            }
        }
        return plham.event.FundamentalPriceShock.NO_TIME_LENGTH;
    }
    
    
    final public static class $Closure$7 extends x10.core.Ref implements x10.core.fun.Fun_0_4, x10.serialization.X10JavaSerializable
    {
        public static final x10.rtt.RuntimeType<$Closure$7> $RTT = 
            x10.rtt.StaticFunType.<$Closure$7> make($Closure$7.class,
                                                    new x10.rtt.Type[] {
                                                        x10.rtt.ParameterizedType.make(x10.core.fun.Fun_0_4.$RTT, x10.rtt.Types.LONG, x10.rtt.Types.STRING, x10.util.Random.$RTT, cassia.util.JSON.Value.$RTT, plham.event.FundamentalPriceShock.$RTT)
                                                    });
        
        public x10.rtt.RuntimeType<?> $getRTT() { return $RTT; }
        
        public x10.rtt.Type<?> $getParam(int i) { return null; }
        
        private Object writeReplace() throws java.io.ObjectStreamException {
            return new x10.serialization.SerializationProxy(this);
        }
        
        public static x10.serialization.X10JavaSerializable $_deserialize_body(plham.event.FundamentalPriceShock.$Closure$7 $_obj, x10.serialization.X10JavaDeserializer $deserializer) throws java.io.IOException {
            if (x10.runtime.impl.java.Runtime.TRACE_SER) { x10.runtime.impl.java.Runtime.printTraceMessage("X10JavaSerializable: $_deserialize_body() of " + $Closure$7.class + " calling"); } 
            $_obj.sim = $deserializer.readObject();
            return $_obj;
        }
        
        public static x10.serialization.X10JavaSerializable $_deserializer(x10.serialization.X10JavaDeserializer $deserializer) throws java.io.IOException {
            plham.event.FundamentalPriceShock.$Closure$7 $_obj = new plham.event.FundamentalPriceShock.$Closure$7((java.lang.System[]) null);
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
        
        
    
        
        public plham.event.FundamentalPriceShock $apply(final long id, final java.lang.String name, final x10.util.Random random, final cassia.util.JSON.Value json) {
            
            //#line 70 "/home/dsl/workspace/plhamK/plham/event/FundamentalPriceShock.x10"
            final plham.event.FundamentalPriceShock t$21237 = ((new plham.event.FundamentalPriceShock((java.lang.System[]) null).plham$event$FundamentalPriceShock$$init$S(((id)), ((name)), ((random)))));
            
            //#line 70 "/home/dsl/workspace/plhamK/plham/event/FundamentalPriceShock.x10"
            final plham.event.FundamentalPriceShock t$21238 = ((t$21237.setup(((json)), ((this.sim)))));
            
            //#line 70 "/home/dsl/workspace/plhamK/plham/event/FundamentalPriceShock.x10"
            return t$21238;
        }
        
        public plham.main.Simulator sim;
        
        public $Closure$7(final plham.main.Simulator sim) {
             {
                this.sim = ((sim));
            }
        }
        
    }
    
}

