package plham;


/**
 * The base class for markets.
 * A continuous double auction mechanism is implemented.
 *
 * <p><ul>
 * <li> Override <code>handleOrders(List[Order])</code> and <code>handleOrder(Order)</code> to implement a matching mechanism.
 * <li> The price of every order will be rounded in increments of a tick size (in <code>handleOrder(Order)</code>).
 * <li> Market orders never be added onto the orderbooks (in the current implementation).
 * <li> Do not call <code>handleOrders(List[Order])</code> family in <code>Agent#submitOrders(List[Market])</code>.
 * <li> Do not access to the fields as much as possible; Use the corresponding methods if exist.
 * </ul>
 * 
 * <p>On events, it currently supports four places to register.
 * <p><ul>
 * <li> beforeSimulationStep: Called once before a simulation step (once each step)
 * <li>  afterSimulationStep: Called once  after a simulation step (once each step)
 * <li> beforeOrderHandling: Called every before handling an order (once per order)
 * <li>  afterOrderHandling: Called every  after handling an order (once per order)
 * </ul>
 */
@x10.runtime.impl.java.X10Generated
public class Market extends x10.core.Ref implements x10.serialization.X10JavaSerializable
{
    public static final x10.rtt.RuntimeType<Market> $RTT = 
        x10.rtt.NamedType.<Market> make("plham.Market",
                                        Market.class);
    
    public x10.rtt.RuntimeType<?> $getRTT() { return $RTT; }
    
    public x10.rtt.Type<?> $getParam(int i) { return null; }
    
    private Object writeReplace() throws java.io.ObjectStreamException {
        return new x10.serialization.SerializationProxy(this);
    }
    
    public static x10.serialization.X10JavaSerializable $_deserialize_body(plham.Market $_obj, x10.serialization.X10JavaDeserializer $deserializer) throws java.io.IOException {
        if (x10.runtime.impl.java.Runtime.TRACE_SER) { x10.runtime.impl.java.Runtime.printTraceMessage("X10JavaSerializable: $_deserialize_body() of " + Market.class + " calling"); } 
        $_obj.NO_TICKSIZE = $deserializer.readDouble();
        $_obj._isRunning = $deserializer.readBoolean();
        $_obj.afterOrderHandlingEvents = $deserializer.readObject();
        $_obj.afterSimulationStepEvents = $deserializer.readObject();
        $_obj.beforeOrderHandlingEvents = $deserializer.readObject();
        $_obj.beforeSimulationStepEvents = $deserializer.readObject();
        $_obj.buyOrderBook = $deserializer.readObject();
        $_obj.fundamentalPrices = $deserializer.readObject();
        $_obj.fundamentalVolatility = $deserializer.readDouble();
        $_obj.id = $deserializer.readLong();
        $_obj.marketPrices = $deserializer.readObject();
        $_obj.name = $deserializer.readObject();
        $_obj.outstandingShares = $deserializer.readLong();
        $_obj.random = $deserializer.readObject();
        $_obj.sellOrderBook = $deserializer.readObject();
        $_obj.tickSize = $deserializer.readDouble();
        $_obj.time = $deserializer.readObject();
        return $_obj;
    }
    
    public static x10.serialization.X10JavaSerializable $_deserializer(x10.serialization.X10JavaDeserializer $deserializer) throws java.io.IOException {
        plham.Market $_obj = new plham.Market((java.lang.System[]) null);
        $deserializer.record_reference($_obj);
        return $_deserialize_body($_obj, $deserializer);
    }
    
    public void $_serialize(x10.serialization.X10JavaSerializer $serializer) throws java.io.IOException {
        $serializer.write(this.NO_TICKSIZE);
        $serializer.write(this._isRunning);
        $serializer.write(this.afterOrderHandlingEvents);
        $serializer.write(this.afterSimulationStepEvents);
        $serializer.write(this.beforeOrderHandlingEvents);
        $serializer.write(this.beforeSimulationStepEvents);
        $serializer.write(this.buyOrderBook);
        $serializer.write(this.fundamentalPrices);
        $serializer.write(this.fundamentalVolatility);
        $serializer.write(this.id);
        $serializer.write(this.marketPrices);
        $serializer.write(this.name);
        $serializer.write(this.outstandingShares);
        $serializer.write(this.random);
        $serializer.write(this.sellOrderBook);
        $serializer.write(this.tickSize);
        $serializer.write(this.time);
        
    }
    
    // constructor just for allocation
    public Market(final java.lang.System[] $dummy) {
        
    }
    
    

    
    //#line 37 "/home/dsl/workspace/plhamK/plham/Market.x10"
    /** The id of this market assigned by the system. DON'T CHANGE IT. */
    public long id;
    
    //#line 39 "/home/dsl/workspace/plhamK/plham/Market.x10"
    /** The JSON object name. DON'T CHANGE IT. */
    public java.lang.String name;
    
    //#line 41 "/home/dsl/workspace/plhamK/plham/Market.x10"
    /** The RNG given by the system (DON'T CHANGE IT). */
    public x10.util.Random random;
    
    
    //#line 44 "/home/dsl/workspace/plhamK/plham/Market.x10"
    /** @return An instance of Random (derived from the root). */
    public x10.util.Random getRandom() {
        
        //#line 44 "/home/dsl/workspace/plhamK/plham/Market.x10"
        final x10.util.Random t$20789 = ((this.random));
        
        //#line 44 "/home/dsl/workspace/plhamK/plham/Market.x10"
        return t$20789;
    }
    
    
    //#line 46 "/home/dsl/workspace/plhamK/plham/Market.x10"
    public boolean _isRunning;
    
    //#line 47 "/home/dsl/workspace/plhamK/plham/Market.x10"
    public plham.OrderBook buyOrderBook;
    
    //#line 48 "/home/dsl/workspace/plhamK/plham/Market.x10"
    public plham.OrderBook sellOrderBook;
    
    //#line 49 "/home/dsl/workspace/plhamK/plham/Market.x10"
    public long outstandingShares;
    
    //#line 52 "/home/dsl/workspace/plhamK/plham/Market.x10"
    /** NOTE: Use <code>getTime()</code> instead. */
    public plham.Time time;
    
    //#line 55 "/home/dsl/workspace/plhamK/plham/Market.x10"
    public transient plham.Env env;
    
    //#line 57 "/home/dsl/workspace/plhamK/plham/Market.x10"
    public double tickSize;
    
    //#line 58 "/home/dsl/workspace/plhamK/plham/Market.x10"
    public double NO_TICKSIZE;
    
    //#line 59 "/home/dsl/workspace/plhamK/plham/Market.x10"
    private static x10.core.fun.Fun_0_2<x10.core.Double,x10.core.Double,x10.core.Double> ROUND_UPPER;
    
    //#line 60 "/home/dsl/workspace/plhamK/plham/Market.x10"
    private static x10.core.fun.Fun_0_2<x10.core.Double,x10.core.Double,x10.core.Double> ROUND_LOWER;
    
    //#line 63 "/home/dsl/workspace/plhamK/plham/Market.x10"
    public x10.util.ArrayList<x10.core.Double> marketPrices;
    
    //#line 64 "/home/dsl/workspace/plhamK/plham/Market.x10"
    public x10.util.ArrayList<x10.core.Double> fundamentalPrices;
    
    //#line 66 "/home/dsl/workspace/plhamK/plham/Market.x10"
    public double fundamentalVolatility;
    
    //#line 69 "/home/dsl/workspace/plhamK/plham/Market.x10"
    public transient x10.util.List<x10.core.Double> lastExecutedPrices;
    
    //#line 70 "/home/dsl/workspace/plhamK/plham/Market.x10"
    public transient x10.util.List<x10.core.Long> sumExecutedVolumes;
    
    //#line 71 "/home/dsl/workspace/plhamK/plham/Market.x10"
    public transient x10.util.List<x10.core.Long> buyOrdersCounts;
    
    //#line 72 "/home/dsl/workspace/plhamK/plham/Market.x10"
    public transient x10.util.List<x10.core.Long> sellOrdersCounts;
    
    //#line 73 "/home/dsl/workspace/plhamK/plham/Market.x10"
    public transient x10.util.List<x10.core.Long> executedOrdersCounts;
    
    //#line 75 "/home/dsl/workspace/plhamK/plham/Market.x10"
    public transient x10.util.List<x10.util.List<plham.Market.ExecutionLog>> executionLogs;
    
    //#line 77 "/home/dsl/workspace/plhamK/plham/Market.x10"
    @x10.runtime.impl.java.X10Generated
    public static class ExecutionLog extends x10.core.Ref implements x10.serialization.X10JavaSerializable
    {
        public static final x10.rtt.RuntimeType<ExecutionLog> $RTT = 
            x10.rtt.NamedType.<ExecutionLog> make("plham.Market.ExecutionLog",
                                                  ExecutionLog.class);
        
        public x10.rtt.RuntimeType<?> $getRTT() { return $RTT; }
        
        public x10.rtt.Type<?> $getParam(int i) { return null; }
        
        private Object writeReplace() throws java.io.ObjectStreamException {
            return new x10.serialization.SerializationProxy(this);
        }
        
        public static x10.serialization.X10JavaSerializable $_deserialize_body(plham.Market.ExecutionLog $_obj, x10.serialization.X10JavaDeserializer $deserializer) throws java.io.IOException {
            if (x10.runtime.impl.java.Runtime.TRACE_SER) { x10.runtime.impl.java.Runtime.printTraceMessage("X10JavaSerializable: $_deserialize_body() of " + ExecutionLog.class + " calling"); } 
            $_obj.buyAgentId = $deserializer.readLong();
            $_obj.exchangePrice = $deserializer.readDouble();
            $_obj.exchangeVolume = $deserializer.readLong();
            $_obj.isSellMajor = $deserializer.readBoolean();
            $_obj.sellAgentId = $deserializer.readLong();
            $_obj.time = $deserializer.readLong();
            return $_obj;
        }
        
        public static x10.serialization.X10JavaSerializable $_deserializer(x10.serialization.X10JavaDeserializer $deserializer) throws java.io.IOException {
            plham.Market.ExecutionLog $_obj = new plham.Market.ExecutionLog((java.lang.System[]) null);
            $deserializer.record_reference($_obj);
            return $_deserialize_body($_obj, $deserializer);
        }
        
        public void $_serialize(x10.serialization.X10JavaSerializer $serializer) throws java.io.IOException {
            $serializer.write(this.buyAgentId);
            $serializer.write(this.exchangePrice);
            $serializer.write(this.exchangeVolume);
            $serializer.write(this.isSellMajor);
            $serializer.write(this.sellAgentId);
            $serializer.write(this.time);
            
        }
        
        // constructor just for allocation
        public ExecutionLog(final java.lang.System[] $dummy) {
            
        }
        
        
    
        
        //#line 79 "/home/dsl/workspace/plhamK/plham/Market.x10"
        /** true if the exchange price is determined by a sell order (seller); otherwise false means it's done by a buy order (buyer). */
        public boolean isSellMajor;
        
        //#line 80 "/home/dsl/workspace/plhamK/plham/Market.x10"
        public long time;
        
        //#line 81 "/home/dsl/workspace/plhamK/plham/Market.x10"
        public long buyAgentId;
        
        //#line 82 "/home/dsl/workspace/plhamK/plham/Market.x10"
        public long sellAgentId;
        
        //#line 83 "/home/dsl/workspace/plhamK/plham/Market.x10"
        public double exchangePrice;
        
        //#line 84 "/home/dsl/workspace/plhamK/plham/Market.x10"
        public long exchangeVolume;
        
        
        //#line 77 "/home/dsl/workspace/plhamK/plham/Market.x10"
        final public plham.Market.ExecutionLog plham$Market$ExecutionLog$$this$plham$Market$ExecutionLog() {
            
            //#line 77 "/home/dsl/workspace/plhamK/plham/Market.x10"
            return plham.Market.ExecutionLog.this;
        }
        
        
        //#line 77 "/home/dsl/workspace/plhamK/plham/Market.x10"
        // creation method for java code (1-phase java constructor)
        public ExecutionLog() {
            this((java.lang.System[]) null);
            plham$Market$ExecutionLog$$init$S();
        }
        
        // constructor for non-virtual call
        final public plham.Market.ExecutionLog plham$Market$ExecutionLog$$init$S() {
             {
                
                //#line 77 "/home/dsl/workspace/plhamK/plham/Market.x10"
                
                
                //#line 77 "/home/dsl/workspace/plhamK/plham/Market.x10"
                this.__fieldInitializers_plham_Market_ExecutionLog();
            }
            return this;
        }
        
        
        
        //#line 77 "/home/dsl/workspace/plhamK/plham/Market.x10"
        final public void __fieldInitializers_plham_Market_ExecutionLog() {
            
            //#line 77 "/home/dsl/workspace/plhamK/plham/Market.x10"
            this.isSellMajor = false;
            
            //#line 77 "/home/dsl/workspace/plhamK/plham/Market.x10"
            this.time = 0L;
            
            //#line 77 "/home/dsl/workspace/plhamK/plham/Market.x10"
            this.buyAgentId = 0L;
            
            //#line 77 "/home/dsl/workspace/plhamK/plham/Market.x10"
            this.sellAgentId = 0L;
            
            //#line 77 "/home/dsl/workspace/plhamK/plham/Market.x10"
            this.exchangePrice = 0.0;
            
            //#line 77 "/home/dsl/workspace/plhamK/plham/Market.x10"
            this.exchangeVolume = 0L;
        }
    }
    
    
    
    //#line 87 "/home/dsl/workspace/plhamK/plham/Market.x10"
    // creation method for java code (1-phase java constructor)
    public Market(final long id, final java.lang.String name, final x10.util.Random random) {
        this((java.lang.System[]) null);
        plham$Market$$init$S(id, name, random);
    }
    
    // constructor for non-virtual call
    final public plham.Market plham$Market$$init$S(final long id, final java.lang.String name, final x10.util.Random random) {
         {
            
            //#line 87 "/home/dsl/workspace/plhamK/plham/Market.x10"
            
            
            //#line 34 "/home/dsl/workspace/plhamK/plham/Market.x10"
            this.__fieldInitializers_plham_Market();
            
            //#line 88 "/home/dsl/workspace/plhamK/plham/Market.x10"
            this.id = id;
            
            //#line 89 "/home/dsl/workspace/plhamK/plham/Market.x10"
            this.name = ((name));
            
            //#line 90 "/home/dsl/workspace/plhamK/plham/Market.x10"
            this.random = ((random));
            
            //#line 91 "/home/dsl/workspace/plhamK/plham/Market.x10"
            this._isRunning = true;
            
            //#line 92 "/home/dsl/workspace/plhamK/plham/Market.x10"
            final x10.core.fun.Fun_0_2 t$20790 = ((plham.OrderBook.get$HIGHERS_FIRST()));
            
            //#line 92 "/home/dsl/workspace/plhamK/plham/Market.x10"
            final plham.OrderBook t$20791 = ((new plham.OrderBook((java.lang.System[]) null).plham$OrderBook$$init$S(((t$20790)), (plham.OrderBook.__0$1plham$Order$3plham$Order$3x10$lang$Int$2) null)));
            
            //#line 92 "/home/dsl/workspace/plhamK/plham/Market.x10"
            this.buyOrderBook = ((t$20791));
            
            //#line 93 "/home/dsl/workspace/plhamK/plham/Market.x10"
            final x10.core.fun.Fun_0_2 t$20792 = ((plham.OrderBook.get$LOWERS_FIRST()));
            
            //#line 93 "/home/dsl/workspace/plhamK/plham/Market.x10"
            final plham.OrderBook t$20793 = ((new plham.OrderBook((java.lang.System[]) null).plham$OrderBook$$init$S(((t$20792)), (plham.OrderBook.__0$1plham$Order$3plham$Order$3x10$lang$Int$2) null)));
            
            //#line 93 "/home/dsl/workspace/plhamK/plham/Market.x10"
            this.sellOrderBook = ((t$20793));
            
            //#line 94 "/home/dsl/workspace/plhamK/plham/Market.x10"
            this.outstandingShares = 1L;
            
            //#line 96 "/home/dsl/workspace/plhamK/plham/Market.x10"
            final plham.Time t$20794 = ((new plham.Time((java.lang.System[]) null).plham$Time$$init$S(((0L)))));
            
            //#line 96 "/home/dsl/workspace/plhamK/plham/Market.x10"
            this.time = ((t$20794));
            
            //#line 98 "/home/dsl/workspace/plhamK/plham/Market.x10"
            final plham.OrderBook t$20795 = ((this.buyOrderBook));
            
            //#line 98 "/home/dsl/workspace/plhamK/plham/Market.x10"
            final plham.Time t$20796 = ((this.time));
            
            //#line 98 "/home/dsl/workspace/plhamK/plham/Market.x10"
            t$20795.setTime(((t$20796)));
            
            //#line 99 "/home/dsl/workspace/plhamK/plham/Market.x10"
            final plham.OrderBook t$20797 = ((this.sellOrderBook));
            
            //#line 99 "/home/dsl/workspace/plhamK/plham/Market.x10"
            final plham.Time t$20798 = ((this.time));
            
            //#line 99 "/home/dsl/workspace/plhamK/plham/Market.x10"
            t$20797.setTime(((t$20798)));
            
            //#line 100 "/home/dsl/workspace/plhamK/plham/Market.x10"
            this.env = null;
            
            //#line 101 "/home/dsl/workspace/plhamK/plham/Market.x10"
            final double t$20799 = this.NO_TICKSIZE;
            
            //#line 101 "/home/dsl/workspace/plhamK/plham/Market.x10"
            this.tickSize = t$20799;
            
            //#line 103 "/home/dsl/workspace/plhamK/plham/Market.x10"
            final x10.util.ArrayList t$20800 = ((new x10.util.ArrayList<x10.core.Double>((java.lang.System[]) null, x10.rtt.Types.DOUBLE).x10$util$ArrayList$$init$S()));
            
            //#line 103 "/home/dsl/workspace/plhamK/plham/Market.x10"
            this.marketPrices = ((t$20800));
            
            //#line 104 "/home/dsl/workspace/plhamK/plham/Market.x10"
            final x10.util.ArrayList t$20801 = ((new x10.util.ArrayList<x10.core.Double>((java.lang.System[]) null, x10.rtt.Types.DOUBLE).x10$util$ArrayList$$init$S()));
            
            //#line 104 "/home/dsl/workspace/plhamK/plham/Market.x10"
            this.fundamentalPrices = ((t$20801));
            
            //#line 106 "/home/dsl/workspace/plhamK/plham/Market.x10"
            final x10.util.ArrayList t$20802 = ((new x10.util.ArrayList<x10.core.Double>((java.lang.System[]) null, x10.rtt.Types.DOUBLE).x10$util$ArrayList$$init$S()));
            
            //#line 106 "/home/dsl/workspace/plhamK/plham/Market.x10"
            this.lastExecutedPrices = ((t$20802));
            
            //#line 107 "/home/dsl/workspace/plhamK/plham/Market.x10"
            final x10.util.ArrayList t$20803 = ((new x10.util.ArrayList<x10.core.Long>((java.lang.System[]) null, x10.rtt.Types.LONG).x10$util$ArrayList$$init$S()));
            
            //#line 107 "/home/dsl/workspace/plhamK/plham/Market.x10"
            this.sumExecutedVolumes = ((t$20803));
            
            //#line 108 "/home/dsl/workspace/plhamK/plham/Market.x10"
            final x10.util.ArrayList t$20804 = ((new x10.util.ArrayList<x10.core.Long>((java.lang.System[]) null, x10.rtt.Types.LONG).x10$util$ArrayList$$init$S()));
            
            //#line 108 "/home/dsl/workspace/plhamK/plham/Market.x10"
            this.buyOrdersCounts = ((t$20804));
            
            //#line 109 "/home/dsl/workspace/plhamK/plham/Market.x10"
            final x10.util.ArrayList t$20805 = ((new x10.util.ArrayList<x10.core.Long>((java.lang.System[]) null, x10.rtt.Types.LONG).x10$util$ArrayList$$init$S()));
            
            //#line 109 "/home/dsl/workspace/plhamK/plham/Market.x10"
            this.sellOrdersCounts = ((t$20805));
            
            //#line 110 "/home/dsl/workspace/plhamK/plham/Market.x10"
            final x10.util.ArrayList t$20806 = ((new x10.util.ArrayList<x10.core.Long>((java.lang.System[]) null, x10.rtt.Types.LONG).x10$util$ArrayList$$init$S()));
            
            //#line 110 "/home/dsl/workspace/plhamK/plham/Market.x10"
            this.executedOrdersCounts = ((t$20806));
            
            //#line 111 "/home/dsl/workspace/plhamK/plham/Market.x10"
            this.fundamentalVolatility = 0.0;
        }
        return this;
    }
    
    
    
    //#line 114 "/home/dsl/workspace/plhamK/plham/Market.x10"
    // creation method for java code (1-phase java constructor)
    public Market(final long id) {
        this((java.lang.System[]) null);
        plham$Market$$init$S(id);
    }
    
    // constructor for non-virtual call
    final public plham.Market plham$Market$$init$S(final long id) {
         {
            
            //#line 115 "/home/dsl/workspace/plhamK/plham/Market.x10"
            final x10.util.Random t$20807 = ((new x10.util.Random((java.lang.System[]) null).x10$util$Random$$init$S()));
            
            //#line 115 "/home/dsl/workspace/plhamK/plham/Market.x10"
            /*this.*/plham$Market$$init$S(((id)), (("default")), ((t$20807)));
        }
        return this;
    }
    
    
    
    //#line 117 "/home/dsl/workspace/plhamK/plham/Market.x10"
    // creation method for java code (1-phase java constructor)
    public Market() {
        this((java.lang.System[]) null);
        plham$Market$$init$S();
    }
    
    // constructor for non-virtual call
    final public plham.Market plham$Market$$init$S() {
         {
            
            //#line 118 "/home/dsl/workspace/plhamK/plham/Market.x10"
            final x10.util.Random t$20808 = ((new x10.util.Random((java.lang.System[]) null).x10$util$Random$$init$S()));
            
            //#line 118 "/home/dsl/workspace/plhamK/plham/Market.x10"
            /*this.*/plham$Market$$init$S(((-1L)), (("default")), ((t$20808)));
        }
        return this;
    }
    
    
    
    //#line 121 "/home/dsl/workspace/plhamK/plham/Market.x10"
    public plham.Market setup(final cassia.util.JSON.Value json, final plham.main.Simulator sim) {
        
        //#line 122 "/home/dsl/workspace/plhamK/plham/Market.x10"
        final x10.util.Random t$20809 = this.getRandom();
        
        //#line 122 "/home/dsl/workspace/plhamK/plham/Market.x10"
        final plham.util.JSONRandom jsonrandom = ((new plham.util.JSONRandom((java.lang.System[]) null).plham$util$JSONRandom$$init$S(t$20809)));
        
        //#line 123 "/home/dsl/workspace/plhamK/plham/Market.x10"
        final cassia.util.JSON.Value t$20810 = json.<java.lang.String> $apply__0cassia$util$JSON$Value$$T(x10.rtt.Types.STRING, (("tickSize")), (("-1.0")));
        
        //#line 123 "/home/dsl/workspace/plhamK/plham/Market.x10"
        final double t$20811 = jsonrandom.nextRandom$O(((t$20810)));
        
        //#line 123 "/home/dsl/workspace/plhamK/plham/Market.x10"
        this.setTickSize$O((t$20811));
        
        //#line 124 "/home/dsl/workspace/plhamK/plham/Market.x10"
        final cassia.util.JSON.Value t$20812 = json.<java.lang.String> get(x10.rtt.Types.STRING, (("marketPrice")));
        
        //#line 124 "/home/dsl/workspace/plhamK/plham/Market.x10"
        final double t$20813 = jsonrandom.nextRandom$O(((t$20812)));
        
        //#line 124 "/home/dsl/workspace/plhamK/plham/Market.x10"
        this.setInitialMarketPrice((t$20813));
        
        //#line 125 "/home/dsl/workspace/plhamK/plham/Market.x10"
        final cassia.util.JSON.Value t$20814 = json.<java.lang.String> get(x10.rtt.Types.STRING, (("marketPrice")));
        
        //#line 125 "/home/dsl/workspace/plhamK/plham/Market.x10"
        final double t$20815 = jsonrandom.nextRandom$O(((t$20814)));
        
        //#line 125 "/home/dsl/workspace/plhamK/plham/Market.x10"
        this.setInitialFundamentalPrice((t$20815));
        
        //#line 126 "/home/dsl/workspace/plhamK/plham/Market.x10"
        final cassia.util.JSON.Value t$20816 = json.<java.lang.String> $apply__0cassia$util$JSON$Value$$T(x10.rtt.Types.STRING, (("fundamentalVolatility")), (("0.0")));
        
        //#line 126 "/home/dsl/workspace/plhamK/plham/Market.x10"
        final double t$20817 = jsonrandom.nextRandom$O(((t$20816)));
        
        //#line 126 "/home/dsl/workspace/plhamK/plham/Market.x10"
        this.setFundamentalVolatility((t$20817));
        
        //#line 127 "/home/dsl/workspace/plhamK/plham/Market.x10"
        final cassia.util.JSON.Value t$20818 = json.<java.lang.String> get(x10.rtt.Types.STRING, (("outstandingShares")));
        
        //#line 127 "/home/dsl/workspace/plhamK/plham/Market.x10"
        final double t$20819 = jsonrandom.nextRandom$O(((t$20818)));
        
        //#line 127 "/home/dsl/workspace/plhamK/plham/Market.x10"
        final long t$20820 = ((long)(((t$20819))));
        
        //#line 127 "/home/dsl/workspace/plhamK/plham/Market.x10"
        this.setOutstandingShares$O((t$20820));
        
        //#line 128 "/home/dsl/workspace/plhamK/plham/Market.x10"
        return this;
    }
    
    
    //#line 131 "/home/dsl/workspace/plhamK/plham/Market.x10"
    public static void register(final plham.main.Simulator sim) {
        
        //#line 132 "/home/dsl/workspace/plhamK/plham/Market.x10"
        final java.lang.String className = (("Market"));
        
        //#line 133 "/home/dsl/workspace/plhamK/plham/Market.x10"
        final x10.core.fun.Fun_0_4 t$20833 = ((new plham.Market.$Closure$0(sim)));
        
        //#line 133 "/home/dsl/workspace/plhamK/plham/Market.x10"
        sim.addMarketsInitializer__1$1x10$lang$Long$3x10$lang$String$3x10$util$Random$3cassia$util$JSON$Value$3x10$util$List$1plham$Market$2$2(((className)), ((t$20833)));
    }
    
    
    //#line 152 "/home/dsl/workspace/plhamK/plham/Market.x10"
    /**
	 * Handle orders from some agents.
	 * This method will be invoked by the system.
	 * The list of orders may include those of other markets (please skip them).
	 * The primary task, order matching, should be done in <code>handleOrder(Order)</code>.
	 * @param orders  a list of orders.
	 */
    public void handleOrders__0$1plham$Order$2(final x10.util.Container orders) {
        
        //#line 153 "/home/dsl/workspace/plhamK/plham/Market.x10"
        final x10.lang.Iterator order$20780 = (((x10.lang.Iterable<plham.Order>)orders).iterator());
        
        //#line 153 "/home/dsl/workspace/plhamK/plham/Market.x10"
        for (;
             true;
             ) {
            
            //#line 153 "/home/dsl/workspace/plhamK/plham/Market.x10"
            final boolean t$20838 = ((x10.lang.Iterator<plham.Order>)order$20780).hasNext$O();
            
            //#line 153 "/home/dsl/workspace/plhamK/plham/Market.x10"
            if (!(t$20838)) {
                
                //#line 153 "/home/dsl/workspace/plhamK/plham/Market.x10"
                break;
            }
            
            //#line 153 "/home/dsl/workspace/plhamK/plham/Market.x10"
            final plham.Order order$21108 = ((((x10.lang.Iterator<plham.Order>)order$20780).next$G()));
            
            //#line 154 "/home/dsl/workspace/plhamK/plham/Market.x10"
            final long t$21109 = order$21108.marketId;
            
            //#line 154 "/home/dsl/workspace/plhamK/plham/Market.x10"
            final long t$21110 = this.id;
            
            //#line 154 "/home/dsl/workspace/plhamK/plham/Market.x10"
            final boolean t$21111 = (t$21109) == (t$21110);
            
            //#line 154 "/home/dsl/workspace/plhamK/plham/Market.x10"
            if (t$21111) {
                
                //#line 155 "/home/dsl/workspace/plhamK/plham/Market.x10"
                this.handleOrder(((order$21108)));
            }
        }
    }
    
    
    //#line 166 "/home/dsl/workspace/plhamK/plham/Market.x10"
    /**
	 * Handle orders from some agents.
	 * This method will be invoked by the system.
	 * The primary task, order matching, should be done here.
	 * @param orders  an order to this market.
	 */
    public void handleOrder(final plham.Order order) {
        
        //#line 167 "/home/dsl/workspace/plhamK/plham/Market.x10"
        assert (order.marketId) == (this.id);
        
        //#line 168 "/home/dsl/workspace/plhamK/plham/Market.x10"
        final long t = this.getTime$O();
        
        //#line 169 "/home/dsl/workspace/plhamK/plham/Market.x10"
        final double t$20839 = order.getPrice$O();
        
        //#line 169 "/home/dsl/workspace/plhamK/plham/Market.x10"
        final boolean t$20840 = ((t$20839) < (((0.0))));
        
        //#line 169 "/home/dsl/workspace/plhamK/plham/Market.x10"
        if (t$20840) {
            
            //#line 170 "/home/dsl/workspace/plhamK/plham/Market.x10"
            return;
        }
        
        //#line 172 "/home/dsl/workspace/plhamK/plham/Market.x10"
        final long t$20841 = order.getVolume$O();
        
        //#line 172 "/home/dsl/workspace/plhamK/plham/Market.x10"
        final boolean t$20842 = ((t$20841) <= (((0L))));
        
        //#line 172 "/home/dsl/workspace/plhamK/plham/Market.x10"
        if (t$20842) {
            
            //#line 173 "/home/dsl/workspace/plhamK/plham/Market.x10"
            return;
        }
        
        //#line 176 "/home/dsl/workspace/plhamK/plham/Market.x10"
        this.roundPrice(((order)));
        
        //#line 178 "/home/dsl/workspace/plhamK/plham/Market.x10"
        final boolean t$20845 = order.isCancel$O();
        
        //#line 178 "/home/dsl/workspace/plhamK/plham/Market.x10"
        if (t$20845) {
            
            //#line 179 "/home/dsl/workspace/plhamK/plham/Market.x10"
            final boolean t$20843 = order.isBuyOrder$O();
            
            //#line 179 "/home/dsl/workspace/plhamK/plham/Market.x10"
            if (t$20843) {
                
                //#line 180 "/home/dsl/workspace/plhamK/plham/Market.x10"
                this.cancelBuyOrder(((order)));
            }
            
            //#line 182 "/home/dsl/workspace/plhamK/plham/Market.x10"
            final boolean t$20844 = order.isSellOrder$O();
            
            //#line 182 "/home/dsl/workspace/plhamK/plham/Market.x10"
            if (t$20844) {
                
                //#line 183 "/home/dsl/workspace/plhamK/plham/Market.x10"
                this.cancelSellOrder(((order)));
            }
            
            //#line 185 "/home/dsl/workspace/plhamK/plham/Market.x10"
            return;
        }
        
        //#line 187 "/home/dsl/workspace/plhamK/plham/Market.x10"
        final boolean t$20847 = order.isBuyOrder$O();
        
        //#line 187 "/home/dsl/workspace/plhamK/plham/Market.x10"
        if (t$20847) {
            
            //#line 188 "/home/dsl/workspace/plhamK/plham/Market.x10"
            this.handleBuyOrder(((order)));
            
            //#line 189 "/home/dsl/workspace/plhamK/plham/Market.x10"
            final x10.util.List a$20242 = ((this.buyOrdersCounts));
            
            //#line 189 "/home/dsl/workspace/plhamK/plham/Market.x10"
            final long i0$20243 = t;
            
            //#line 189 "/home/dsl/workspace/plhamK/plham/Market.x10"
            final long t$20846 = x10.core.Long.$unbox(((x10.util.Indexed<x10.core.Long>)a$20242).$apply$G((i0$20243)));
            
            //#line 189 "/home/dsl/workspace/plhamK/plham/Market.x10"
            final long r$20251 = ((t$20846) + (((1L))));
            
            //#line 189 "/home/dsl/workspace/plhamK/plham/Market.x10"
            ((x10.lang.Settable<x10.core.Long, x10.core.Long>)a$20242).$set(x10.core.Long.$box(i0$20243), x10.rtt.Types.LONG, x10.core.Long.$box(r$20251), x10.rtt.Types.LONG);
        }
        
        //#line 191 "/home/dsl/workspace/plhamK/plham/Market.x10"
        final boolean t$20849 = order.isSellOrder$O();
        
        //#line 191 "/home/dsl/workspace/plhamK/plham/Market.x10"
        if (t$20849) {
            
            //#line 192 "/home/dsl/workspace/plhamK/plham/Market.x10"
            this.handleSellOrder(((order)));
            
            //#line 193 "/home/dsl/workspace/plhamK/plham/Market.x10"
            final x10.util.List a$20252 = ((this.sellOrdersCounts));
            
            //#line 193 "/home/dsl/workspace/plhamK/plham/Market.x10"
            final long i0$20253 = t;
            
            //#line 193 "/home/dsl/workspace/plhamK/plham/Market.x10"
            final long t$20848 = x10.core.Long.$unbox(((x10.util.Indexed<x10.core.Long>)a$20252).$apply$G((i0$20253)));
            
            //#line 193 "/home/dsl/workspace/plhamK/plham/Market.x10"
            final long r$20261 = ((t$20848) + (((1L))));
            
            //#line 193 "/home/dsl/workspace/plhamK/plham/Market.x10"
            ((x10.lang.Settable<x10.core.Long, x10.core.Long>)a$20252).$set(x10.core.Long.$box(i0$20253), x10.rtt.Types.LONG, x10.core.Long.$box(r$20261), x10.rtt.Types.LONG);
        }
    }
    
    
    //#line 197 "/home/dsl/workspace/plhamK/plham/Market.x10"
    public void cancelBuyOrder(final plham.Order order) {
        
        //#line 198 "/home/dsl/workspace/plhamK/plham/Market.x10"
        assert order.isBuyOrder$O();
        
        //#line 199 "/home/dsl/workspace/plhamK/plham/Market.x10"
        final plham.OrderBook t$20850 = ((this.buyOrderBook));
        
        //#line 199 "/home/dsl/workspace/plhamK/plham/Market.x10"
        t$20850.cancel(((order)));
    }
    
    
    //#line 202 "/home/dsl/workspace/plhamK/plham/Market.x10"
    public void cancelSellOrder(final plham.Order order) {
        
        //#line 203 "/home/dsl/workspace/plhamK/plham/Market.x10"
        assert order.isSellOrder$O();
        
        //#line 204 "/home/dsl/workspace/plhamK/plham/Market.x10"
        final plham.OrderBook t$20851 = ((this.sellOrderBook));
        
        //#line 204 "/home/dsl/workspace/plhamK/plham/Market.x10"
        t$20851.cancel(((order)));
    }
    
    
    //#line 207 "/home/dsl/workspace/plhamK/plham/Market.x10"
    public void handleBuyOrder(final plham.Order order) {
        
        //#line 208 "/home/dsl/workspace/plhamK/plham/Market.x10"
        assert order.isBuyOrder$O();
        
        //#line 209 "/home/dsl/workspace/plhamK/plham/Market.x10"
        final boolean t$20852 = order.isLimitOrder$O();
        
        //#line 209 "/home/dsl/workspace/plhamK/plham/Market.x10"
        if (t$20852) {
            
            //#line 210 "/home/dsl/workspace/plhamK/plham/Market.x10"
            this.handleBuyLimitOrder(((order)));
        }
        
        //#line 212 "/home/dsl/workspace/plhamK/plham/Market.x10"
        final boolean t$20853 = order.isMarketOrder$O();
        
        //#line 212 "/home/dsl/workspace/plhamK/plham/Market.x10"
        if (t$20853) {
            
            //#line 213 "/home/dsl/workspace/plhamK/plham/Market.x10"
            this.handleBuyMarketOrder(((order)));
        }
    }
    
    
    //#line 217 "/home/dsl/workspace/plhamK/plham/Market.x10"
    public void handleSellOrder(final plham.Order order) {
        
        //#line 218 "/home/dsl/workspace/plhamK/plham/Market.x10"
        assert order.isSellOrder$O();
        
        //#line 219 "/home/dsl/workspace/plhamK/plham/Market.x10"
        final boolean t$20854 = order.isLimitOrder$O();
        
        //#line 219 "/home/dsl/workspace/plhamK/plham/Market.x10"
        if (t$20854) {
            
            //#line 220 "/home/dsl/workspace/plhamK/plham/Market.x10"
            this.handleSellLimitOrder(((order)));
        }
        
        //#line 222 "/home/dsl/workspace/plhamK/plham/Market.x10"
        final boolean t$20855 = order.isMarketOrder$O();
        
        //#line 222 "/home/dsl/workspace/plhamK/plham/Market.x10"
        if (t$20855) {
            
            //#line 223 "/home/dsl/workspace/plhamK/plham/Market.x10"
            this.handleSellMarketOrder(((order)));
        }
    }
    
    
    //#line 227 "/home/dsl/workspace/plhamK/plham/Market.x10"
    public void handleBuyLimitOrder(final plham.Order buyOrder) {
        
        //#line 228 "/home/dsl/workspace/plhamK/plham/Market.x10"
        assert buyOrder.isBuyOrder$O() && buyOrder.isLimitOrder$O();
        
        //#line 229 "/home/dsl/workspace/plhamK/plham/Market.x10"
        final long t = this.getTime$O();
        
        //#line 230 "/home/dsl/workspace/plhamK/plham/Market.x10"
        final boolean t$20868 = this.isRunning$O();
        
        //#line 230 "/home/dsl/workspace/plhamK/plham/Market.x10"
        if (t$20868) {
            
            //#line 231 "/home/dsl/workspace/plhamK/plham/Market.x10"
            while (true) {
                
                //#line 231 "/home/dsl/workspace/plhamK/plham/Market.x10"
                final long t$20856 = buyOrder.getVolume$O();
                
                //#line 231 "/home/dsl/workspace/plhamK/plham/Market.x10"
                final boolean t$20867 = ((t$20856) > (((0L))));
                
                //#line 231 "/home/dsl/workspace/plhamK/plham/Market.x10"
                if (!(t$20867)) {
                    
                    //#line 231 "/home/dsl/workspace/plhamK/plham/Market.x10"
                    break;
                }
                
                //#line 232 "/home/dsl/workspace/plhamK/plham/Market.x10"
                final plham.OrderBook t$21112 = ((this.sellOrderBook));
                
                //#line 232 "/home/dsl/workspace/plhamK/plham/Market.x10"
                final long t$21113 = t$21112.size$O();
                
                //#line 232 "/home/dsl/workspace/plhamK/plham/Market.x10"
                final boolean t$21114 = (t$21113) == (0L);
                
                //#line 232 "/home/dsl/workspace/plhamK/plham/Market.x10"
                if (t$21114) {
                    
                    //#line 233 "/home/dsl/workspace/plhamK/plham/Market.x10"
                    break;
                }
                
                //#line 235 "/home/dsl/workspace/plhamK/plham/Market.x10"
                final plham.OrderBook t$21115 = ((this.sellOrderBook));
                
                //#line 235 "/home/dsl/workspace/plhamK/plham/Market.x10"
                final plham.Order sellOrder$21116 = t$21115.getBestOrder();
                
                //#line 236 "/home/dsl/workspace/plhamK/plham/Market.x10"
                final double t$21117 = buyOrder.getPrice$O();
                
                //#line 236 "/home/dsl/workspace/plhamK/plham/Market.x10"
                final double t$21118 = sellOrder$21116.getPrice$O();
                
                //#line 236 "/home/dsl/workspace/plhamK/plham/Market.x10"
                final boolean t$21119 = ((t$21117) >= (((t$21118))));
                
                //#line 236 "/home/dsl/workspace/plhamK/plham/Market.x10"
                if (t$21119) {
                    
                    //#line 237 "/home/dsl/workspace/plhamK/plham/Market.x10"
                    this.executeBuyOrders(((buyOrder)), ((sellOrder$21116)));
                } else {
                    
                    //#line 239 "/home/dsl/workspace/plhamK/plham/Market.x10"
                    break;
                }
                
                //#line 241 "/home/dsl/workspace/plhamK/plham/Market.x10"
                final long t$21120 = sellOrder$21116.getVolume$O();
                
                //#line 241 "/home/dsl/workspace/plhamK/plham/Market.x10"
                final boolean t$21121 = ((t$21120) <= (((0L))));
                
                //#line 241 "/home/dsl/workspace/plhamK/plham/Market.x10"
                if (t$21121) {
                    
                    //#line 242 "/home/dsl/workspace/plhamK/plham/Market.x10"
                    final plham.OrderBook t$21122 = ((this.sellOrderBook));
                    
                    //#line 242 "/home/dsl/workspace/plhamK/plham/Market.x10"
                    t$21122.remove(((sellOrder$21116)));
                }
            }
        }
        
        //#line 246 "/home/dsl/workspace/plhamK/plham/Market.x10"
        final long t$20869 = buyOrder.getVolume$O();
        
        //#line 246 "/home/dsl/workspace/plhamK/plham/Market.x10"
        final boolean t$20871 = ((t$20869) > (((0L))));
        
        //#line 246 "/home/dsl/workspace/plhamK/plham/Market.x10"
        if (t$20871) {
            
            //#line 247 "/home/dsl/workspace/plhamK/plham/Market.x10"
            final plham.OrderBook t$20870 = ((this.buyOrderBook));
            
            //#line 247 "/home/dsl/workspace/plhamK/plham/Market.x10"
            t$20870.add(((buyOrder)));
        }
    }
    
    
    //#line 251 "/home/dsl/workspace/plhamK/plham/Market.x10"
    public void handleSellLimitOrder(final plham.Order sellOrder) {
        
        //#line 252 "/home/dsl/workspace/plhamK/plham/Market.x10"
        assert sellOrder.isSellOrder$O() && sellOrder.isLimitOrder$O();
        
        //#line 253 "/home/dsl/workspace/plhamK/plham/Market.x10"
        final long t = this.getTime$O();
        
        //#line 254 "/home/dsl/workspace/plhamK/plham/Market.x10"
        final boolean t$20884 = this.isRunning$O();
        
        //#line 254 "/home/dsl/workspace/plhamK/plham/Market.x10"
        if (t$20884) {
            
            //#line 255 "/home/dsl/workspace/plhamK/plham/Market.x10"
            while (true) {
                
                //#line 255 "/home/dsl/workspace/plhamK/plham/Market.x10"
                final long t$20872 = sellOrder.getVolume$O();
                
                //#line 255 "/home/dsl/workspace/plhamK/plham/Market.x10"
                final boolean t$20883 = ((t$20872) > (((0L))));
                
                //#line 255 "/home/dsl/workspace/plhamK/plham/Market.x10"
                if (!(t$20883)) {
                    
                    //#line 255 "/home/dsl/workspace/plhamK/plham/Market.x10"
                    break;
                }
                
                //#line 256 "/home/dsl/workspace/plhamK/plham/Market.x10"
                final plham.OrderBook t$21123 = ((this.buyOrderBook));
                
                //#line 256 "/home/dsl/workspace/plhamK/plham/Market.x10"
                final long t$21124 = t$21123.size$O();
                
                //#line 256 "/home/dsl/workspace/plhamK/plham/Market.x10"
                final boolean t$21125 = (t$21124) == (0L);
                
                //#line 256 "/home/dsl/workspace/plhamK/plham/Market.x10"
                if (t$21125) {
                    
                    //#line 257 "/home/dsl/workspace/plhamK/plham/Market.x10"
                    break;
                }
                
                //#line 259 "/home/dsl/workspace/plhamK/plham/Market.x10"
                final plham.OrderBook t$21126 = ((this.buyOrderBook));
                
                //#line 259 "/home/dsl/workspace/plhamK/plham/Market.x10"
                final plham.Order buyOrder$21127 = t$21126.getBestOrder();
                
                //#line 260 "/home/dsl/workspace/plhamK/plham/Market.x10"
                final double t$21128 = buyOrder$21127.getPrice$O();
                
                //#line 260 "/home/dsl/workspace/plhamK/plham/Market.x10"
                final double t$21129 = sellOrder.getPrice$O();
                
                //#line 260 "/home/dsl/workspace/plhamK/plham/Market.x10"
                final boolean t$21130 = ((t$21128) >= (((t$21129))));
                
                //#line 260 "/home/dsl/workspace/plhamK/plham/Market.x10"
                if (t$21130) {
                    
                    //#line 261 "/home/dsl/workspace/plhamK/plham/Market.x10"
                    this.executeSellOrders(((sellOrder)), ((buyOrder$21127)));
                } else {
                    
                    //#line 263 "/home/dsl/workspace/plhamK/plham/Market.x10"
                    break;
                }
                
                //#line 265 "/home/dsl/workspace/plhamK/plham/Market.x10"
                final long t$21131 = buyOrder$21127.getVolume$O();
                
                //#line 265 "/home/dsl/workspace/plhamK/plham/Market.x10"
                final boolean t$21132 = ((t$21131) <= (((0L))));
                
                //#line 265 "/home/dsl/workspace/plhamK/plham/Market.x10"
                if (t$21132) {
                    
                    //#line 266 "/home/dsl/workspace/plhamK/plham/Market.x10"
                    final plham.OrderBook t$21133 = ((this.buyOrderBook));
                    
                    //#line 266 "/home/dsl/workspace/plhamK/plham/Market.x10"
                    t$21133.remove(((buyOrder$21127)));
                }
            }
        }
        
        //#line 270 "/home/dsl/workspace/plhamK/plham/Market.x10"
        final long t$20885 = sellOrder.getVolume$O();
        
        //#line 270 "/home/dsl/workspace/plhamK/plham/Market.x10"
        final boolean t$20887 = ((t$20885) > (((0L))));
        
        //#line 270 "/home/dsl/workspace/plhamK/plham/Market.x10"
        if (t$20887) {
            
            //#line 271 "/home/dsl/workspace/plhamK/plham/Market.x10"
            final plham.OrderBook t$20886 = ((this.sellOrderBook));
            
            //#line 271 "/home/dsl/workspace/plhamK/plham/Market.x10"
            t$20886.add(((sellOrder)));
        }
    }
    
    
    //#line 275 "/home/dsl/workspace/plhamK/plham/Market.x10"
    public void handleBuyMarketOrder(final plham.Order buyOrder) {
        
        //#line 276 "/home/dsl/workspace/plhamK/plham/Market.x10"
        assert buyOrder.isBuyOrder$O() && buyOrder.isMarketOrder$O();
        
        //#line 277 "/home/dsl/workspace/plhamK/plham/Market.x10"
        final long t = this.getTime$O();
        
        //#line 278 "/home/dsl/workspace/plhamK/plham/Market.x10"
        final boolean t$20897 = this.isRunning$O();
        
        //#line 278 "/home/dsl/workspace/plhamK/plham/Market.x10"
        if (t$20897) {
            
            //#line 279 "/home/dsl/workspace/plhamK/plham/Market.x10"
            while (true) {
                
                //#line 279 "/home/dsl/workspace/plhamK/plham/Market.x10"
                final long t$20888 = buyOrder.getVolume$O();
                
                //#line 279 "/home/dsl/workspace/plhamK/plham/Market.x10"
                final boolean t$20896 = ((t$20888) > (((0L))));
                
                //#line 279 "/home/dsl/workspace/plhamK/plham/Market.x10"
                if (!(t$20896)) {
                    
                    //#line 279 "/home/dsl/workspace/plhamK/plham/Market.x10"
                    break;
                }
                
                //#line 280 "/home/dsl/workspace/plhamK/plham/Market.x10"
                final plham.OrderBook t$21134 = ((this.sellOrderBook));
                
                //#line 280 "/home/dsl/workspace/plhamK/plham/Market.x10"
                final long t$21135 = t$21134.size$O();
                
                //#line 280 "/home/dsl/workspace/plhamK/plham/Market.x10"
                final boolean t$21136 = (t$21135) == (0L);
                
                //#line 280 "/home/dsl/workspace/plhamK/plham/Market.x10"
                if (t$21136) {
                    
                    //#line 281 "/home/dsl/workspace/plhamK/plham/Market.x10"
                    break;
                }
                
                //#line 283 "/home/dsl/workspace/plhamK/plham/Market.x10"
                final plham.OrderBook t$21137 = ((this.sellOrderBook));
                
                //#line 283 "/home/dsl/workspace/plhamK/plham/Market.x10"
                final plham.Order sellOrder$21138 = t$21137.getBestOrder();
                
                //#line 285 "/home/dsl/workspace/plhamK/plham/Market.x10"
                this.executeBuyOrders(((buyOrder)), ((sellOrder$21138)));
                
                //#line 289 "/home/dsl/workspace/plhamK/plham/Market.x10"
                final long t$21139 = sellOrder$21138.getVolume$O();
                
                //#line 289 "/home/dsl/workspace/plhamK/plham/Market.x10"
                final boolean t$21140 = ((t$21139) <= (((0L))));
                
                //#line 289 "/home/dsl/workspace/plhamK/plham/Market.x10"
                if (t$21140) {
                    
                    //#line 290 "/home/dsl/workspace/plhamK/plham/Market.x10"
                    final plham.OrderBook t$21141 = ((this.sellOrderBook));
                    
                    //#line 290 "/home/dsl/workspace/plhamK/plham/Market.x10"
                    t$21141.remove(((sellOrder$21138)));
                }
            }
        }
    }
    
    
    //#line 299 "/home/dsl/workspace/plhamK/plham/Market.x10"
    public void handleSellMarketOrder(final plham.Order sellOrder) {
        
        //#line 300 "/home/dsl/workspace/plhamK/plham/Market.x10"
        assert sellOrder.isSellOrder$O() && sellOrder.isMarketOrder$O();
        
        //#line 301 "/home/dsl/workspace/plhamK/plham/Market.x10"
        final long t = this.getTime$O();
        
        //#line 302 "/home/dsl/workspace/plhamK/plham/Market.x10"
        final boolean t$20907 = this.isRunning$O();
        
        //#line 302 "/home/dsl/workspace/plhamK/plham/Market.x10"
        if (t$20907) {
            
            //#line 303 "/home/dsl/workspace/plhamK/plham/Market.x10"
            while (true) {
                
                //#line 303 "/home/dsl/workspace/plhamK/plham/Market.x10"
                final long t$20898 = sellOrder.getVolume$O();
                
                //#line 303 "/home/dsl/workspace/plhamK/plham/Market.x10"
                final boolean t$20906 = ((t$20898) > (((0L))));
                
                //#line 303 "/home/dsl/workspace/plhamK/plham/Market.x10"
                if (!(t$20906)) {
                    
                    //#line 303 "/home/dsl/workspace/plhamK/plham/Market.x10"
                    break;
                }
                
                //#line 304 "/home/dsl/workspace/plhamK/plham/Market.x10"
                final plham.OrderBook t$21142 = ((this.buyOrderBook));
                
                //#line 304 "/home/dsl/workspace/plhamK/plham/Market.x10"
                final long t$21143 = t$21142.size$O();
                
                //#line 304 "/home/dsl/workspace/plhamK/plham/Market.x10"
                final boolean t$21144 = (t$21143) == (0L);
                
                //#line 304 "/home/dsl/workspace/plhamK/plham/Market.x10"
                if (t$21144) {
                    
                    //#line 305 "/home/dsl/workspace/plhamK/plham/Market.x10"
                    break;
                }
                
                //#line 307 "/home/dsl/workspace/plhamK/plham/Market.x10"
                final plham.OrderBook t$21145 = ((this.buyOrderBook));
                
                //#line 307 "/home/dsl/workspace/plhamK/plham/Market.x10"
                final plham.Order buyOrder$21146 = t$21145.getBestOrder();
                
                //#line 309 "/home/dsl/workspace/plhamK/plham/Market.x10"
                this.executeSellOrders(((sellOrder)), ((buyOrder$21146)));
                
                //#line 313 "/home/dsl/workspace/plhamK/plham/Market.x10"
                final long t$21147 = buyOrder$21146.getVolume$O();
                
                //#line 313 "/home/dsl/workspace/plhamK/plham/Market.x10"
                final boolean t$21148 = ((t$21147) <= (((0L))));
                
                //#line 313 "/home/dsl/workspace/plhamK/plham/Market.x10"
                if (t$21148) {
                    
                    //#line 314 "/home/dsl/workspace/plhamK/plham/Market.x10"
                    final plham.OrderBook t$21149 = ((this.buyOrderBook));
                    
                    //#line 314 "/home/dsl/workspace/plhamK/plham/Market.x10"
                    t$21149.remove(((buyOrder$21146)));
                }
            }
        }
    }
    
    
    //#line 327 "/home/dsl/workspace/plhamK/plham/Market.x10"
    /**
	 * Remove all expired and no-volume orders.
	 */
    public void updateOrderBooks() {
        
        //#line 328 "/home/dsl/workspace/plhamK/plham/Market.x10"
        final x10.core.fun.Fun_0_1 isExpired = ((new plham.Market.$Closure$1(this)));
        
        //#line 329 "/home/dsl/workspace/plhamK/plham/Market.x10"
        final x10.core.fun.Fun_0_1 isNoVolume = ((new plham.Market.$Closure$2()));
        
        //#line 330 "/home/dsl/workspace/plhamK/plham/Market.x10"
        final plham.OrderBook t$20913 = ((this.buyOrderBook));
        
        //#line 330 "/home/dsl/workspace/plhamK/plham/Market.x10"
        final x10.core.fun.Fun_0_1 t$20914 = ((new plham.Market.$Closure$3(isExpired, isNoVolume, (plham.Market.$Closure$3.__0$1plham$Order$3x10$lang$Boolean$2__1$1plham$Order$3x10$lang$Boolean$2) null)));
        
        //#line 330 "/home/dsl/workspace/plhamK/plham/Market.x10"
        t$20913.removeAllWhere__0$1plham$Order$3x10$lang$Boolean$2$O(((t$20914)));
        
        //#line 331 "/home/dsl/workspace/plhamK/plham/Market.x10"
        final plham.OrderBook t$20917 = ((this.sellOrderBook));
        
        //#line 331 "/home/dsl/workspace/plhamK/plham/Market.x10"
        final x10.core.fun.Fun_0_1 t$20918 = ((new plham.Market.$Closure$4(isExpired, isNoVolume, (plham.Market.$Closure$4.__0$1plham$Order$3x10$lang$Boolean$2__1$1plham$Order$3x10$lang$Boolean$2) null)));
        
        //#line 331 "/home/dsl/workspace/plhamK/plham/Market.x10"
        t$20917.removeAllWhere__0$1plham$Order$3x10$lang$Boolean$2$O(((t$20918)));
    }
    
    
    //#line 351 "/home/dsl/workspace/plhamK/plham/Market.x10"
    /**
	 * Perform the itayose method for clearance of matched orders.
	 * The method <code>updateOrderBooks()</code> will be called after this method.
	 */
    public void itayoseOrderBooks() {
        
        //#line 352 "/home/dsl/workspace/plhamK/plham/Market.x10"
        plham.util.Itayose.itayose(((this)));
        
        //#line 353 "/home/dsl/workspace/plhamK/plham/Market.x10"
        this.updateOrderBooks();
    }
    
    
    //#line 361 "/home/dsl/workspace/plhamK/plham/Market.x10"
    /**
	 * Whether this market is open or not (closed).
	 * If false (closed), this market does not execute orders;
     * just placing orders on the orderbooks.
	 */
    public boolean isRunning$O() {
        
        //#line 361 "/home/dsl/workspace/plhamK/plham/Market.x10"
        final boolean t$20919 = this._isRunning;
        
        //#line 361 "/home/dsl/workspace/plhamK/plham/Market.x10"
        return t$20919;
    }
    
    
    //#line 363 "/home/dsl/workspace/plhamK/plham/Market.x10"
    final public boolean setRunning$O(final boolean isRunning) {
        
        //#line 364 "/home/dsl/workspace/plhamK/plham/Market.x10"
        final boolean t$20920 = this._isRunning = isRunning;
        
        //#line 364 "/home/dsl/workspace/plhamK/plham/Market.x10"
        return t$20920;
    }
    
    
    //#line 369 "/home/dsl/workspace/plhamK/plham/Market.x10"
    /**
	 * See also <code>roundPrice()</code>.
	 */
    public double getTickSize$O() {
        
        //#line 369 "/home/dsl/workspace/plhamK/plham/Market.x10"
        final double t$20921 = this.tickSize;
        
        //#line 369 "/home/dsl/workspace/plhamK/plham/Market.x10"
        return t$20921;
    }
    
    
    //#line 374 "/home/dsl/workspace/plhamK/plham/Market.x10"
    /**
	 * Note: <code>tickSize &lt;= 0.0</code> means no tick size.
	 */
    final public double setTickSize$O(final double tickSize) {
        
        //#line 375 "/home/dsl/workspace/plhamK/plham/Market.x10"
        final double t$20922 = this.tickSize = tickSize;
        
        //#line 375 "/home/dsl/workspace/plhamK/plham/Market.x10"
        return t$20922;
    }
    
    
    //#line 381 "/home/dsl/workspace/plhamK/plham/Market.x10"
    /**
	 * Round the price of the order in increments of a tick size.
	 * Modify <code>order</code> in place and return it.
	 */
    public plham.Order roundPrice(final plham.Order order) {
        
        //#line 382 "/home/dsl/workspace/plhamK/plham/Market.x10"
        final double t$20923 = this.tickSize;
        
        //#line 382 "/home/dsl/workspace/plhamK/plham/Market.x10"
        final boolean t$20924 = ((t$20923) <= (((0.0))));
        
        //#line 382 "/home/dsl/workspace/plhamK/plham/Market.x10"
        if (t$20924) {
            
            //#line 383 "/home/dsl/workspace/plhamK/plham/Market.x10"
            return order;
        }
        
        //#line 385 "/home/dsl/workspace/plhamK/plham/Market.x10"
        final double t$20925 = order.getPrice$O();
        
        //#line 385 "/home/dsl/workspace/plhamK/plham/Market.x10"
        final double t$20926 = plham.Order.get$NO_PRICE();
        
        //#line 385 "/home/dsl/workspace/plhamK/plham/Market.x10"
        final boolean t$20927 = (t$20925) == (t$20926);
        
        //#line 385 "/home/dsl/workspace/plhamK/plham/Market.x10"
        if (t$20927) {
            
            //#line 386 "/home/dsl/workspace/plhamK/plham/Market.x10"
            return order;
        }
        
        //#line 388 "/home/dsl/workspace/plhamK/plham/Market.x10"
        final boolean t$20930 = order.isBuyOrder$O();
        
        //#line 388 "/home/dsl/workspace/plhamK/plham/Market.x10"
        if (t$20930) {
            
            //#line 389 "/home/dsl/workspace/plhamK/plham/Market.x10"
            final double t$20928 = order.getPrice$O();
            
            //#line 389 "/home/dsl/workspace/plhamK/plham/Market.x10"
            final double t$20929 = this.roundBuyPrice$O((t$20928));
            
            //#line 389 "/home/dsl/workspace/plhamK/plham/Market.x10"
            order.setPrice$O((t$20929));
        }
        
        //#line 391 "/home/dsl/workspace/plhamK/plham/Market.x10"
        final boolean t$20933 = order.isSellOrder$O();
        
        //#line 391 "/home/dsl/workspace/plhamK/plham/Market.x10"
        if (t$20933) {
            
            //#line 392 "/home/dsl/workspace/plhamK/plham/Market.x10"
            final double t$20931 = order.getPrice$O();
            
            //#line 392 "/home/dsl/workspace/plhamK/plham/Market.x10"
            final double t$20932 = this.roundSellPrice$O((t$20931));
            
            //#line 392 "/home/dsl/workspace/plhamK/plham/Market.x10"
            order.setPrice$O((t$20932));
        }
        
        //#line 394 "/home/dsl/workspace/plhamK/plham/Market.x10"
        return order;
    }
    
    
    //#line 397 "/home/dsl/workspace/plhamK/plham/Market.x10"
    public double roundBuyPrice$O(final double price) {
        
        //#line 397 "/home/dsl/workspace/plhamK/plham/Market.x10"
        final x10.core.fun.Fun_0_2 t$20934 = ((plham.Market.get$ROUND_LOWER()));
        
        //#line 397 "/home/dsl/workspace/plhamK/plham/Market.x10"
        final double t$20935 = this.tickSize;
        
        //#line 397 "/home/dsl/workspace/plhamK/plham/Market.x10"
        final double t$20936 = x10.core.Double.$unbox(((x10.core.fun.Fun_0_2<x10.core.Double,x10.core.Double,x10.core.Double>)t$20934).$apply(x10.core.Double.$box(price), x10.rtt.Types.DOUBLE, x10.core.Double.$box(t$20935), x10.rtt.Types.DOUBLE));
        
        //#line 397 "/home/dsl/workspace/plhamK/plham/Market.x10"
        return t$20936;
    }
    
    
    //#line 399 "/home/dsl/workspace/plhamK/plham/Market.x10"
    public double roundSellPrice$O(final double price) {
        
        //#line 399 "/home/dsl/workspace/plhamK/plham/Market.x10"
        final x10.core.fun.Fun_0_2 t$20937 = ((plham.Market.get$ROUND_UPPER()));
        
        //#line 399 "/home/dsl/workspace/plhamK/plham/Market.x10"
        final double t$20938 = this.tickSize;
        
        //#line 399 "/home/dsl/workspace/plhamK/plham/Market.x10"
        final double t$20939 = x10.core.Double.$unbox(((x10.core.fun.Fun_0_2<x10.core.Double,x10.core.Double,x10.core.Double>)t$20937).$apply(x10.core.Double.$box(price), x10.rtt.Types.DOUBLE, x10.core.Double.$box(t$20938), x10.rtt.Types.DOUBLE));
        
        //#line 399 "/home/dsl/workspace/plhamK/plham/Market.x10"
        return t$20939;
    }
    
    
    //#line 409 "/home/dsl/workspace/plhamK/plham/Market.x10"
    /**
	 * Return the next market price at t + 1.
	 * If some transactions occur, the last transaction price will be the next market price.
	 * Otherwise if the market has a mid price, it will be used.
	 * Otherwise, the last market price is used.
	 * This method does not change any internal state of this market;
	 * Use <code>updateMarketPrice()</code> for this purpose.
	 */
    public double getNextMarketPrice$O() {
        
        //#line 410 "/home/dsl/workspace/plhamK/plham/Market.x10"
        final x10.util.ArrayList t$20940 = ((this.marketPrices));
        
        //#line 410 "/home/dsl/workspace/plhamK/plham/Market.x10"
        final double lastPrice = x10.core.Double.$unbox(((x10.util.ArrayList<x10.core.Double>)t$20940).getLast$G());
        
        //#line 411 "/home/dsl/workspace/plhamK/plham/Market.x10"
        double price = lastPrice;
        
        //#line 412 "/home/dsl/workspace/plhamK/plham/Market.x10"
        final boolean t$20953 = this.isRunning$O();
        
        //#line 412 "/home/dsl/workspace/plhamK/plham/Market.x10"
        if (t$20953) {
            
            //#line 413 "/home/dsl/workspace/plhamK/plham/Market.x10"
            final x10.util.List t$20941 = ((this.executedOrdersCounts));
            
            //#line 413 "/home/dsl/workspace/plhamK/plham/Market.x10"
            final long t$20942 = x10.core.Long.$unbox(((x10.util.List<x10.core.Long>)t$20941).getLast$G());
            
            //#line 413 "/home/dsl/workspace/plhamK/plham/Market.x10"
            final boolean t$20952 = ((t$20942) > (((0L))));
            
            //#line 413 "/home/dsl/workspace/plhamK/plham/Market.x10"
            if (t$20952) {
                
                //#line 414 "/home/dsl/workspace/plhamK/plham/Market.x10"
                final x10.util.List t$20943 = ((this.lastExecutedPrices));
                
                //#line 414 "/home/dsl/workspace/plhamK/plham/Market.x10"
                final double t$20944 = x10.core.Double.$unbox(((x10.util.List<x10.core.Double>)t$20943).getLast$G());
                
                //#line 414 "/home/dsl/workspace/plhamK/plham/Market.x10"
                price = t$20944;
            } else {
                
                //#line 415 "/home/dsl/workspace/plhamK/plham/Market.x10"
                final plham.OrderBook t$20945 = ((this.buyOrderBook));
                
                //#line 415 "/home/dsl/workspace/plhamK/plham/Market.x10"
                final long t$20946 = t$20945.size$O();
                
                //#line 415 "/home/dsl/workspace/plhamK/plham/Market.x10"
                boolean t$20949 = ((t$20946) > (((0L))));
                
                //#line 415 "/home/dsl/workspace/plhamK/plham/Market.x10"
                if (t$20949) {
                    
                    //#line 415 "/home/dsl/workspace/plhamK/plham/Market.x10"
                    final plham.OrderBook t$20947 = ((this.sellOrderBook));
                    
                    //#line 415 "/home/dsl/workspace/plhamK/plham/Market.x10"
                    final long t$20948 = t$20947.size$O();
                    
                    //#line 415 "/home/dsl/workspace/plhamK/plham/Market.x10"
                    t$20949 = ((t$20948) > (((0L))));
                }
                
                //#line 415 "/home/dsl/workspace/plhamK/plham/Market.x10"
                final boolean t$20951 = t$20949;
                
                //#line 415 "/home/dsl/workspace/plhamK/plham/Market.x10"
                if (t$20951) {
                    
                    //#line 416 "/home/dsl/workspace/plhamK/plham/Market.x10"
                    final double t$20950 = this.getMidPrice$O();
                    
                    //#line 416 "/home/dsl/workspace/plhamK/plham/Market.x10"
                    price = t$20950;
                }
            }
        }
        
        //#line 419 "/home/dsl/workspace/plhamK/plham/Market.x10"
        final double t$20954 = price;
        
        //#line 419 "/home/dsl/workspace/plhamK/plham/Market.x10"
        return t$20954;
    }
    
    
    //#line 436 "/home/dsl/workspace/plhamK/plham/Market.x10"
    public void tickUpdateMarketPrice() {
        
        //#line 437 "/home/dsl/workspace/plhamK/plham/Market.x10"
        final long t = this.getTime$O();
        
        //#line 438 "/home/dsl/workspace/plhamK/plham/Market.x10"
        final double price = this.getNextMarketPrice$O();
        
        //#line 439 "/home/dsl/workspace/plhamK/plham/Market.x10"
        final x10.util.ArrayList t$20955 = ((this.marketPrices));
        
        //#line 439 "/home/dsl/workspace/plhamK/plham/Market.x10"
        ((x10.util.ArrayList<x10.core.Double>)t$20955).$set__1x10$util$ArrayList$$T$G((t), x10.core.Double.$box(price));
    }
    
    
    //#line 443 "/home/dsl/workspace/plhamK/plham/Market.x10"
    public void updateMarketPrice() {
        
        //#line 444 "/home/dsl/workspace/plhamK/plham/Market.x10"
        final double price = this.getNextMarketPrice$O();
        
        //#line 445 "/home/dsl/workspace/plhamK/plham/Market.x10"
        this.updateMarketPrice((price));
    }
    
    
    //#line 448 "/home/dsl/workspace/plhamK/plham/Market.x10"
    public void updateMarketPrice(final double price) {
        
        //#line 449 "/home/dsl/workspace/plhamK/plham/Market.x10"
        assert !(java.lang.Double.isNaN(price)): "!price.isNaN()";
        
        //#line 450 "/home/dsl/workspace/plhamK/plham/Market.x10"
        assert ((price) >= (((0.0)))): "price >= 0.0";
        
        //#line 451 "/home/dsl/workspace/plhamK/plham/Market.x10"
        final x10.util.ArrayList t$20956 = ((this.marketPrices));
        
        //#line 451 "/home/dsl/workspace/plhamK/plham/Market.x10"
        ((x10.util.ArrayList<x10.core.Double>)t$20956).add__0x10$util$ArrayList$$T$O(x10.core.Double.$box(price));
        
        //#line 453 "/home/dsl/workspace/plhamK/plham/Market.x10"
        final x10.util.List t$20957 = ((this.buyOrdersCounts));
        
        //#line 453 "/home/dsl/workspace/plhamK/plham/Market.x10"
        ((x10.util.Collection<x10.core.Long>)t$20957).add$Z(x10.core.Long.$box(0L), x10.rtt.Types.LONG);
        
        //#line 454 "/home/dsl/workspace/plhamK/plham/Market.x10"
        final x10.util.List t$20958 = ((this.sellOrdersCounts));
        
        //#line 454 "/home/dsl/workspace/plhamK/plham/Market.x10"
        ((x10.util.Collection<x10.core.Long>)t$20958).add$Z(x10.core.Long.$box(0L), x10.rtt.Types.LONG);
        
        //#line 455 "/home/dsl/workspace/plhamK/plham/Market.x10"
        final x10.util.List t$20959 = ((this.executedOrdersCounts));
        
        //#line 455 "/home/dsl/workspace/plhamK/plham/Market.x10"
        ((x10.util.Collection<x10.core.Long>)t$20959).add$Z(x10.core.Long.$box(0L), x10.rtt.Types.LONG);
        
        //#line 456 "/home/dsl/workspace/plhamK/plham/Market.x10"
        final x10.util.List t$20960 = ((this.lastExecutedPrices));
        
        //#line 456 "/home/dsl/workspace/plhamK/plham/Market.x10"
        final double t$20961 = java.lang.Double.NaN;
        
        //#line 456 "/home/dsl/workspace/plhamK/plham/Market.x10"
        ((x10.util.Collection<x10.core.Double>)t$20960).add$Z(x10.core.Double.$box(t$20961), x10.rtt.Types.DOUBLE);
        
        //#line 457 "/home/dsl/workspace/plhamK/plham/Market.x10"
        final x10.util.List t$20962 = ((this.sumExecutedVolumes));
        
        //#line 457 "/home/dsl/workspace/plhamK/plham/Market.x10"
        ((x10.util.Collection<x10.core.Long>)t$20962).add$Z(x10.core.Long.$box(0L), x10.rtt.Types.LONG);
        
        //#line 458 "/home/dsl/workspace/plhamK/plham/Market.x10"
        final x10.util.List t$20963 = ((this.executionLogs));
        
        //#line 458 "/home/dsl/workspace/plhamK/plham/Market.x10"
        final x10.util.ArrayList t$20964 = ((new x10.util.ArrayList<plham.Market.ExecutionLog>((java.lang.System[]) null, plham.Market.ExecutionLog.$RTT).x10$util$ArrayList$$init$S()));
        
        //#line 458 "/home/dsl/workspace/plhamK/plham/Market.x10"
        ((x10.util.Collection<x10.util.List<plham.Market.ExecutionLog>>)t$20963).add$Z(((t$20964)), x10.rtt.ParameterizedType.make(x10.util.List.$RTT, plham.Market.ExecutionLog.$RTT));
        
        //#line 459 "/home/dsl/workspace/plhamK/plham/Market.x10"
        final x10.util.List t$20965 = ((this.agentUpdates));
        
        //#line 459 "/home/dsl/workspace/plhamK/plham/Market.x10"
        final x10.util.ArrayList t$20966 = ((new x10.util.ArrayList<plham.Market.AgentUpdate>((java.lang.System[]) null, plham.Market.AgentUpdate.$RTT).x10$util$ArrayList$$init$S()));
        
        //#line 459 "/home/dsl/workspace/plhamK/plham/Market.x10"
        ((x10.util.Collection<x10.util.List<plham.Market.AgentUpdate>>)t$20965).add$Z(((t$20966)), x10.rtt.ParameterizedType.make(x10.util.List.$RTT, plham.Market.AgentUpdate.$RTT));
    }
    
    
    //#line 462 "/home/dsl/workspace/plhamK/plham/Market.x10"
    public void updateFundamentalPrice(final double price) {
        
        //#line 463 "/home/dsl/workspace/plhamK/plham/Market.x10"
        assert !(java.lang.Double.isNaN(price)): "!price.isNaN()";
        
        //#line 464 "/home/dsl/workspace/plhamK/plham/Market.x10"
        assert ((price) >= (((0.0)))): "price >= 0.0";
        
        //#line 465 "/home/dsl/workspace/plhamK/plham/Market.x10"
        final x10.util.ArrayList t$20967 = ((x10.util.ArrayList)(this.fundamentalPrices));
        
        //#line 465 "/home/dsl/workspace/plhamK/plham/Market.x10"
        ((x10.util.ArrayList<x10.core.Double>)t$20967).add__0x10$util$ArrayList$$T$O(x10.core.Double.$box(price));
    }
    
    
    //#line 472 "/home/dsl/workspace/plhamK/plham/Market.x10"
    /**
	 * This is for system use.
	 * This method can be used when the next fundamental price is set(by calling updateFundamentalPrice), but time is not updated yes.
	 */
    public double getNextFundamentalPrice$O() {
        
        //#line 473 "/home/dsl/workspace/plhamK/plham/Market.x10"
        assert ((long) this.getTime$O()) == ((long) ((((x10.util.ArrayList<x10.core.Double>)this.fundamentalPrices).size$O()) - (((long)(1L)))));
        
        //#line 474 "/home/dsl/workspace/plhamK/plham/Market.x10"
        final x10.util.ArrayList t$20968 = ((x10.util.ArrayList)(this.fundamentalPrices));
        
        //#line 474 "/home/dsl/workspace/plhamK/plham/Market.x10"
        final double t$20969 = x10.core.Double.$unbox(((x10.util.ArrayList<x10.core.Double>)t$20968).getLast$G());
        
        //#line 474 "/home/dsl/workspace/plhamK/plham/Market.x10"
        return t$20969;
    }
    
    
    //#line 478 "/home/dsl/workspace/plhamK/plham/Market.x10"
    final public double getInitialMarketPrice$O() {
        
        //#line 479 "/home/dsl/workspace/plhamK/plham/Market.x10"
        final x10.util.ArrayList t$20970 = ((x10.util.ArrayList)(this.marketPrices));
        
        //#line 479 "/home/dsl/workspace/plhamK/plham/Market.x10"
        final long t$20971 = ((x10.util.ArrayList<x10.core.Double>)t$20970).size$O();
        
        //#line 479 "/home/dsl/workspace/plhamK/plham/Market.x10"
        final boolean t$20973 = ((long) t$20971) == ((long) 0L);
        
        //#line 479 "/home/dsl/workspace/plhamK/plham/Market.x10"
        if (t$20973) {
            
            //#line 479 "/home/dsl/workspace/plhamK/plham/Market.x10"
            final java.util.NoSuchElementException t$20972 = ((java.util.NoSuchElementException)(new java.util.NoSuchElementException()));
            
            //#line 479 "/home/dsl/workspace/plhamK/plham/Market.x10"
            throw t$20972;
        }
        
        //#line 480 "/home/dsl/workspace/plhamK/plham/Market.x10"
        final x10.util.ArrayList t$20974 = ((x10.util.ArrayList)(this.marketPrices));
        
        //#line 480 "/home/dsl/workspace/plhamK/plham/Market.x10"
        final double t$20975 = x10.core.Double.$unbox(((x10.util.ArrayList<x10.core.Double>)t$20974).$apply$G((long)(0L)));
        
        //#line 480 "/home/dsl/workspace/plhamK/plham/Market.x10"
        return t$20975;
    }
    
    
    //#line 483 "/home/dsl/workspace/plhamK/plham/Market.x10"
    final public double getFundamentalVolatility$O() {
        
        //#line 483 "/home/dsl/workspace/plhamK/plham/Market.x10"
        final double t$20976 = this.fundamentalVolatility;
        
        //#line 483 "/home/dsl/workspace/plhamK/plham/Market.x10"
        return t$20976;
    }
    
    
    //#line 485 "/home/dsl/workspace/plhamK/plham/Market.x10"
    final public void setFundamentalVolatility(final double v) {
        
        //#line 487 "/home/dsl/workspace/plhamK/plham/Market.x10"
        this.fundamentalVolatility = v;
    }
    
    
    //#line 490 "/home/dsl/workspace/plhamK/plham/Market.x10"
    final public void setInitialMarketPrice(final double price) {
        
        //#line 492 "/home/dsl/workspace/plhamK/plham/Market.x10"
        assert ((long) ((x10.util.ArrayList<x10.core.Double>)this.marketPrices).size$O()) == ((long) 0L);
        
        //#line 493 "/home/dsl/workspace/plhamK/plham/Market.x10"
        final x10.util.ArrayList t$20977 = ((x10.util.ArrayList)(this.marketPrices));
        
        //#line 493 "/home/dsl/workspace/plhamK/plham/Market.x10"
        ((x10.util.ArrayList<x10.core.Double>)t$20977).add__0x10$util$ArrayList$$T$O(x10.core.Double.$box(price));
        
        //#line 494 "/home/dsl/workspace/plhamK/plham/Market.x10"
        final x10.util.ArrayList t$20978 = ((x10.util.ArrayList)(this.fundamentalPrices));
        
        //#line 494 "/home/dsl/workspace/plhamK/plham/Market.x10"
        ((x10.util.ArrayList<x10.core.Double>)t$20978).add__0x10$util$ArrayList$$T$O(x10.core.Double.$box(price));
        
        //#line 496 "/home/dsl/workspace/plhamK/plham/Market.x10"
        final x10.util.List t$20979 = ((x10.util.List)(this.buyOrdersCounts));
        
        //#line 496 "/home/dsl/workspace/plhamK/plham/Market.x10"
        ((x10.util.Collection<x10.core.Long>)t$20979).add$Z(x10.core.Long.$box(0L), x10.rtt.Types.LONG);
        
        //#line 497 "/home/dsl/workspace/plhamK/plham/Market.x10"
        final x10.util.List t$20980 = ((x10.util.List)(this.sellOrdersCounts));
        
        //#line 497 "/home/dsl/workspace/plhamK/plham/Market.x10"
        ((x10.util.Collection<x10.core.Long>)t$20980).add$Z(x10.core.Long.$box(0L), x10.rtt.Types.LONG);
        
        //#line 498 "/home/dsl/workspace/plhamK/plham/Market.x10"
        final x10.util.List t$20981 = ((x10.util.List)(this.executedOrdersCounts));
        
        //#line 498 "/home/dsl/workspace/plhamK/plham/Market.x10"
        ((x10.util.Collection<x10.core.Long>)t$20981).add$Z(x10.core.Long.$box(0L), x10.rtt.Types.LONG);
        
        //#line 499 "/home/dsl/workspace/plhamK/plham/Market.x10"
        final x10.util.List t$20982 = ((x10.util.List)(this.lastExecutedPrices));
        
        //#line 499 "/home/dsl/workspace/plhamK/plham/Market.x10"
        final double t$20983 = java.lang.Double.NaN;
        
        //#line 499 "/home/dsl/workspace/plhamK/plham/Market.x10"
        ((x10.util.Collection<x10.core.Double>)t$20982).add$Z(x10.core.Double.$box(t$20983), x10.rtt.Types.DOUBLE);
        
        //#line 500 "/home/dsl/workspace/plhamK/plham/Market.x10"
        final x10.util.List t$20984 = ((x10.util.List)(this.sumExecutedVolumes));
        
        //#line 500 "/home/dsl/workspace/plhamK/plham/Market.x10"
        ((x10.util.Collection<x10.core.Long>)t$20984).add$Z(x10.core.Long.$box(0L), x10.rtt.Types.LONG);
        
        //#line 501 "/home/dsl/workspace/plhamK/plham/Market.x10"
        final x10.util.List t$20985 = ((x10.util.List)(this.executionLogs));
        
        //#line 501 "/home/dsl/workspace/plhamK/plham/Market.x10"
        final x10.util.ArrayList t$20986 = ((x10.util.ArrayList)(new x10.util.ArrayList<plham.Market.ExecutionLog>((java.lang.System[]) null, plham.Market.ExecutionLog.$RTT).x10$util$ArrayList$$init$S()));
        
        //#line 501 "/home/dsl/workspace/plhamK/plham/Market.x10"
        ((x10.util.Collection<x10.util.List<plham.Market.ExecutionLog>>)t$20985).add$Z(((x10.util.List)(t$20986)), x10.rtt.ParameterizedType.make(x10.util.List.$RTT, plham.Market.ExecutionLog.$RTT));
        
        //#line 502 "/home/dsl/workspace/plhamK/plham/Market.x10"
        final x10.util.List t$20987 = ((x10.util.List)(this.agentUpdates));
        
        //#line 502 "/home/dsl/workspace/plhamK/plham/Market.x10"
        final x10.util.ArrayList t$20988 = ((x10.util.ArrayList)(new x10.util.ArrayList<plham.Market.AgentUpdate>((java.lang.System[]) null, plham.Market.AgentUpdate.$RTT).x10$util$ArrayList$$init$S()));
        
        //#line 502 "/home/dsl/workspace/plhamK/plham/Market.x10"
        ((x10.util.Collection<x10.util.List<plham.Market.AgentUpdate>>)t$20987).add$Z(((x10.util.List)(t$20988)), x10.rtt.ParameterizedType.make(x10.util.List.$RTT, plham.Market.AgentUpdate.$RTT));
    }
    
    
    //#line 505 "/home/dsl/workspace/plhamK/plham/Market.x10"
    final public double getInitialFundamentalPrice$O() {
        
        //#line 506 "/home/dsl/workspace/plhamK/plham/Market.x10"
        final x10.util.ArrayList t$20989 = ((x10.util.ArrayList)(this.fundamentalPrices));
        
        //#line 506 "/home/dsl/workspace/plhamK/plham/Market.x10"
        final long t$20990 = ((x10.util.ArrayList<x10.core.Double>)t$20989).size$O();
        
        //#line 506 "/home/dsl/workspace/plhamK/plham/Market.x10"
        final boolean t$20992 = ((long) t$20990) == ((long) 0L);
        
        //#line 506 "/home/dsl/workspace/plhamK/plham/Market.x10"
        if (t$20992) {
            
            //#line 506 "/home/dsl/workspace/plhamK/plham/Market.x10"
            final java.util.NoSuchElementException t$20991 = ((java.util.NoSuchElementException)(new java.util.NoSuchElementException()));
            
            //#line 506 "/home/dsl/workspace/plhamK/plham/Market.x10"
            throw t$20991;
        }
        
        //#line 507 "/home/dsl/workspace/plhamK/plham/Market.x10"
        final x10.util.ArrayList t$20993 = ((x10.util.ArrayList)(this.fundamentalPrices));
        
        //#line 507 "/home/dsl/workspace/plhamK/plham/Market.x10"
        final double t$20994 = x10.core.Double.$unbox(((x10.util.ArrayList<x10.core.Double>)t$20993).$apply$G((long)(0L)));
        
        //#line 507 "/home/dsl/workspace/plhamK/plham/Market.x10"
        return t$20994;
    }
    
    
    //#line 510 "/home/dsl/workspace/plhamK/plham/Market.x10"
    final public void setInitialFundamentalPrice(final double price) {
        
        //#line 512 "/home/dsl/workspace/plhamK/plham/Market.x10"
        final x10.util.ArrayList t$20995 = ((x10.util.ArrayList)(this.fundamentalPrices));
        
        //#line 512 "/home/dsl/workspace/plhamK/plham/Market.x10"
        ((x10.util.ArrayList<x10.core.Double>)t$20995).$set__1x10$util$ArrayList$$T$G((long)(0L), x10.core.Double.$box(price));
    }
    
    
    //#line 515 "/home/dsl/workspace/plhamK/plham/Market.x10"
    public double getPrice$O() {
        
        //#line 515 "/home/dsl/workspace/plhamK/plham/Market.x10"
        final double t$20996 = this.getMarketPrice$O();
        
        //#line 515 "/home/dsl/workspace/plhamK/plham/Market.x10"
        return t$20996;
    }
    
    
    //#line 517 "/home/dsl/workspace/plhamK/plham/Market.x10"
    public double getPrice$O(final long t) {
        
        //#line 517 "/home/dsl/workspace/plhamK/plham/Market.x10"
        final double t$20997 = this.getMarketPrice$O((long)(t));
        
        //#line 517 "/home/dsl/workspace/plhamK/plham/Market.x10"
        return t$20997;
    }
    
    
    //#line 519 "/home/dsl/workspace/plhamK/plham/Market.x10"
    public double getMarketPrice$O() {
        
        //#line 519 "/home/dsl/workspace/plhamK/plham/Market.x10"
        final x10.util.ArrayList t$20998 = ((x10.util.ArrayList)(this.marketPrices));
        
        //#line 519 "/home/dsl/workspace/plhamK/plham/Market.x10"
        final long t$20999 = this.getTime$O();
        
        //#line 519 "/home/dsl/workspace/plhamK/plham/Market.x10"
        final double t$21000 = x10.core.Double.$unbox(((x10.util.ArrayList<x10.core.Double>)t$20998).$apply$G((long)(t$20999)));
        
        //#line 519 "/home/dsl/workspace/plhamK/plham/Market.x10"
        return t$21000;
    }
    
    
    //#line 521 "/home/dsl/workspace/plhamK/plham/Market.x10"
    public double getMarketPrice$O(final long t) {
        
        //#line 521 "/home/dsl/workspace/plhamK/plham/Market.x10"
        final x10.util.ArrayList t$21001 = ((x10.util.ArrayList)(this.marketPrices));
        
        //#line 521 "/home/dsl/workspace/plhamK/plham/Market.x10"
        final double t$21002 = x10.core.Double.$unbox(((x10.util.ArrayList<x10.core.Double>)t$21001).$apply$G((long)(t)));
        
        //#line 521 "/home/dsl/workspace/plhamK/plham/Market.x10"
        return t$21002;
    }
    
    
    //#line 523 "/home/dsl/workspace/plhamK/plham/Market.x10"
	public double getFundamentalPrice() {
        
        //#line 523 "/home/dsl/workspace/plhamK/plham/Market.x10"
        final x10.util.ArrayList t$21003 = ((x10.util.ArrayList)(this.fundamentalPrices));
        
        //#line 523 "/home/dsl/workspace/plhamK/plham/Market.x10"
        final long t$21004 = this.getTime$O();
        
        //#line 523 "/home/dsl/workspace/plhamK/plham/Market.x10"
        final double t$21005 = x10.core.Double.$unbox(((x10.util.ArrayList<x10.core.Double>)t$21003).$apply$G((long)(t$21004)));
        
        //#line 523 "/home/dsl/workspace/plhamK/plham/Market.x10"
        return t$21005;
    }
    
    
    //#line 525 "/home/dsl/workspace/plhamK/plham/Market.x10"
	public double getFundamentalPrice(final long t) {
        
        //#line 525 "/home/dsl/workspace/plhamK/plham/Market.x10"
        final x10.util.ArrayList t$21006 = ((x10.util.ArrayList)(this.fundamentalPrices));
        
        //#line 525 "/home/dsl/workspace/plhamK/plham/Market.x10"
        final double t$21007 = x10.core.Double.$unbox(((x10.util.ArrayList<x10.core.Double>)t$21006).$apply$G((long)(t)));
        
        //#line 525 "/home/dsl/workspace/plhamK/plham/Market.x10"
        return t$21007;
    }
    
    
    //#line 527 "/home/dsl/workspace/plhamK/plham/Market.x10"
    public plham.OrderBook getBuyOrderBook() {
        
        //#line 527 "/home/dsl/workspace/plhamK/plham/Market.x10"
        final plham.OrderBook t$21008 = ((plham.OrderBook)(this.buyOrderBook));
        
        //#line 527 "/home/dsl/workspace/plhamK/plham/Market.x10"
        return t$21008;
    }
    
    
    //#line 529 "/home/dsl/workspace/plhamK/plham/Market.x10"
    public plham.OrderBook getSellOrderBook() {
        
        //#line 529 "/home/dsl/workspace/plhamK/plham/Market.x10"
        final plham.OrderBook t$21009 = ((plham.OrderBook)(this.sellOrderBook));
        
        //#line 529 "/home/dsl/workspace/plhamK/plham/Market.x10"
        return t$21009;
    }
    
    
    //#line 534 "/home/dsl/workspace/plhamK/plham/Market.x10"
    /**
	 * Get the best (highest) buy/bid price.  NaN if no order.
	 */
    public double getBestBuyPrice$O() {
        
        //#line 534 "/home/dsl/workspace/plhamK/plham/Market.x10"
        final plham.OrderBook t$21010 = ((plham.OrderBook)(this.buyOrderBook));
        
        //#line 534 "/home/dsl/workspace/plhamK/plham/Market.x10"
        final double t$21011 = t$21010.getBestPrice$O();
        
        //#line 534 "/home/dsl/workspace/plhamK/plham/Market.x10"
        return t$21011;
    }
    
    
    //#line 539 "/home/dsl/workspace/plhamK/plham/Market.x10"
    /**
	 * Get the best (lowest) sell/ask price.  NaN if no order.
	 */
    public double getBestSellPrice$O() {
        
        //#line 539 "/home/dsl/workspace/plhamK/plham/Market.x10"
        final plham.OrderBook t$21012 = ((plham.OrderBook)(this.sellOrderBook));
        
        //#line 539 "/home/dsl/workspace/plhamK/plham/Market.x10"
        final double t$21013 = t$21012.getBestPrice$O();
        
        //#line 539 "/home/dsl/workspace/plhamK/plham/Market.x10"
        return t$21013;
    }
    
    
    //#line 544 "/home/dsl/workspace/plhamK/plham/Market.x10"
    /**
	 * Get the mid price, the average (middle) of the best buy/bid and sell/ask prices.
	 */
    public double getMidPrice$O() {
        
        //#line 544 "/home/dsl/workspace/plhamK/plham/Market.x10"
        final double t$21014 = this.getBestBuyPrice$O();
        
        //#line 544 "/home/dsl/workspace/plhamK/plham/Market.x10"
        final double t$21015 = this.getBestSellPrice$O();
        
        //#line 544 "/home/dsl/workspace/plhamK/plham/Market.x10"
        final double t$21016 = ((t$21014) + (((double)(t$21015))));
        
        //#line 544 "/home/dsl/workspace/plhamK/plham/Market.x10"
        final double t$21017 = ((t$21016) / (((double)(2.0))));
        
        //#line 544 "/home/dsl/workspace/plhamK/plham/Market.x10"
        return t$21017;
    }
    
    
    //#line 546 "/home/dsl/workspace/plhamK/plham/Market.x10"
    public long getOutstandingShares$O() {
        
        //#line 546 "/home/dsl/workspace/plhamK/plham/Market.x10"
        final long t$21018 = this.outstandingShares;
        
        //#line 546 "/home/dsl/workspace/plhamK/plham/Market.x10"
        return t$21018;
    }
    
    
    //#line 548 "/home/dsl/workspace/plhamK/plham/Market.x10"
    final public long setOutstandingShares$O(final long outstandingShares) {
        
        //#line 549 "/home/dsl/workspace/plhamK/plham/Market.x10"
        final long t$21019 = this.outstandingShares = outstandingShares;
        
        //#line 549 "/home/dsl/workspace/plhamK/plham/Market.x10"
        return t$21019;
    }
    
    
    //#line 551 "/home/dsl/workspace/plhamK/plham/Market.x10"
    public long getTime$O() {
        
        //#line 551 "/home/dsl/workspace/plhamK/plham/Market.x10"
        final plham.Time t$21020 = ((plham.Time)(this.time));
        
        //#line 551 "/home/dsl/workspace/plhamK/plham/Market.x10"
        final long t$21021 = t$21020.t;
        
        //#line 551 "/home/dsl/workspace/plhamK/plham/Market.x10"
        return t$21021;
    }
    
    
    //#line 553 "/home/dsl/workspace/plhamK/plham/Market.x10"
    public long setTime$O(final long time) {
        
        //#line 553 "/home/dsl/workspace/plhamK/plham/Market.x10"
        final plham.Time t$21022 = ((plham.Time)(this.time));
        
        //#line 553 "/home/dsl/workspace/plhamK/plham/Market.x10"
        final long t$21023 = t$21022.t = time;
        
        //#line 553 "/home/dsl/workspace/plhamK/plham/Market.x10"
        return t$21023;
    }
    
    
    //#line 555 "/home/dsl/workspace/plhamK/plham/Market.x10"
    public long updateTime$O() {
        
        //#line 555 "/home/dsl/workspace/plhamK/plham/Market.x10"
        final plham.Time obj$20416 = ((plham.Time)(this.time));
        
        //#line 555 "/home/dsl/workspace/plhamK/plham/Market.x10"
        final long t$21024 = obj$20416.t;
        
        //#line 555 "/home/dsl/workspace/plhamK/plham/Market.x10"
        final long t$21025 = ((t$21024) + (((long)(1L))));
        
        //#line 555 "/home/dsl/workspace/plhamK/plham/Market.x10"
        final long t$21026 = obj$20416.t = t$21025;
        
        //#line 555 "/home/dsl/workspace/plhamK/plham/Market.x10"
        final long t$21027 = ((t$21026) - (((long)(1L))));
        
        //#line 555 "/home/dsl/workspace/plhamK/plham/Market.x10"
        return t$21027;
    }
    
    
    //#line 557 "/home/dsl/workspace/plhamK/plham/Market.x10"
    public void check() {
        
        //#line 558 "/home/dsl/workspace/plhamK/plham/Market.x10"
        final long t = this.getTime$O();
        
        //#line 559 "/home/dsl/workspace/plhamK/plham/Market.x10"
        assert ((long) ((((x10.util.ArrayList<x10.core.Double>)this.marketPrices).size$O()) - (((long)(1L))))) == ((long) t);
        
        //#line 560 "/home/dsl/workspace/plhamK/plham/Market.x10"
        assert ((long) ((((x10.util.ArrayList<x10.core.Double>)this.fundamentalPrices).size$O()) - (((long)(1L))))) == ((long) t);
        
        //#line 561 "/home/dsl/workspace/plhamK/plham/Market.x10"
        assert ((long) ((((x10.util.Container<x10.core.Double>)this.lastExecutedPrices).size$O()) - (((long)(1L))))) == ((long) t);
        
        //#line 562 "/home/dsl/workspace/plhamK/plham/Market.x10"
        assert ((long) ((((x10.util.Container<x10.core.Long>)this.sumExecutedVolumes).size$O()) - (((long)(1L))))) == ((long) t);
        
        //#line 563 "/home/dsl/workspace/plhamK/plham/Market.x10"
        assert ((long) ((((x10.util.Container<x10.core.Long>)this.buyOrdersCounts).size$O()) - (((long)(1L))))) == ((long) t);
        
        //#line 564 "/home/dsl/workspace/plhamK/plham/Market.x10"
        assert ((long) ((((x10.util.Container<x10.core.Long>)this.sellOrdersCounts).size$O()) - (((long)(1L))))) == ((long) t);
        
        //#line 565 "/home/dsl/workspace/plhamK/plham/Market.x10"
        assert ((long) ((((x10.util.Container<x10.core.Long>)this.executedOrdersCounts).size$O()) - (((long)(1L))))) == ((long) t);
        
        //#line 566 "/home/dsl/workspace/plhamK/plham/Market.x10"
        assert ((long) ((((x10.util.Container<x10.util.List<plham.Market.ExecutionLog>>)this.executionLogs).size$O()) - (((long)(1L))))) == ((long) t);
        
        //#line 567 "/home/dsl/workspace/plhamK/plham/Market.x10"
        assert ((long) ((((x10.util.Container<x10.util.List<plham.Market.AgentUpdate>>)this.agentUpdates).size$O()) - (((long)(1L))))) == ((long) t);
        
        //#line 568 "/home/dsl/workspace/plhamK/plham/Market.x10"
        final x10.io.Printer t$21028 = ((x10.io.Printer)(x10.io.Console.get$OUT()));
        
        //#line 568 "/home/dsl/workspace/plhamK/plham/Market.x10"
        t$21028.println(((java.lang.Object)("#MARKET CHECK PASSED")));
    }
    
    
    //#line 571 "/home/dsl/workspace/plhamK/plham/Market.x10"
    public void executeBuyOrders(final plham.Order buyOrder, final plham.Order sellOrder) {
        
        //#line 572 "/home/dsl/workspace/plhamK/plham/Market.x10"
        final double t$21029 = sellOrder.getPrice$O();
        
        //#line 572 "/home/dsl/workspace/plhamK/plham/Market.x10"
        this.executeOrders((double)(t$21029), ((plham.Order)(buyOrder)), ((plham.Order)(sellOrder)), (boolean)(true));
    }
    
    
    //#line 575 "/home/dsl/workspace/plhamK/plham/Market.x10"
    public void executeSellOrders(final plham.Order sellOrder, final plham.Order buyOrder) {
        
        //#line 576 "/home/dsl/workspace/plhamK/plham/Market.x10"
        final double t$21030 = buyOrder.getPrice$O();
        
        //#line 576 "/home/dsl/workspace/plhamK/plham/Market.x10"
        this.executeOrders((double)(t$21030), ((plham.Order)(buyOrder)), ((plham.Order)(sellOrder)), (boolean)(false));
    }
    
    
    //#line 586 "/home/dsl/workspace/plhamK/plham/Market.x10"
    /**
	 * Exchange the cash and assets between the buyer and seller.
	 * The 1st argument <code>price</code> is used to exchange.
	 * @param isSellMajor is an aux information:
	 *        true if the exchange price is determined by an order on the sell orderbook (seller).
	 * @return execution price (maybe <code>price</code>)
	 */
    public void executeOrders(final double price, final plham.Order buyOrder, final plham.Order sellOrder, final boolean isSellMajor) {
        
        //#line 587 "/home/dsl/workspace/plhamK/plham/Market.x10"
        assert ((long) buyOrder.marketId) == ((long) this.id);
        
        //#line 588 "/home/dsl/workspace/plhamK/plham/Market.x10"
        assert ((long) sellOrder.marketId) == ((long) this.id);
        
        //#line 590 "/home/dsl/workspace/plhamK/plham/Market.x10"
        final double exchangePrice = price;
        
        //#line 591 "/home/dsl/workspace/plhamK/plham/Market.x10"
        final long t$21031 = buyOrder.getVolume$O();
        
        //#line 591 "/home/dsl/workspace/plhamK/plham/Market.x10"
        final long t$21032 = sellOrder.getVolume$O();
        
        //#line 591 "/home/dsl/workspace/plhamK/plham/Market.x10"
        final long exchangeVolume = java.lang.Math.min(((long)(t$21031)),((long)(t$21032)));
        
        //#line 592 "/home/dsl/workspace/plhamK/plham/Market.x10"
        assert ((exchangePrice) >= (((double)(0.0)))): x10.runtime.impl.java.ArrayUtils.<java.lang.Object> makeRailFromJavaArray(x10.rtt.Types.ANY, new java.lang.Object[] {(((("Market#executeOrders(), ") + (isSellMajor
          ? "sell major"
          : "buy major"))) + (": exchangePrice >= 0.0 but ")), exchangePrice});
        
        //#line 593 "/home/dsl/workspace/plhamK/plham/Market.x10"
        assert ((exchangeVolume) >= (((long)(0L)))): x10.runtime.impl.java.ArrayUtils.<java.lang.Object> makeRailFromJavaArray(x10.rtt.Types.ANY, new java.lang.Object[] {(((("Market#executeOrders(), ") + (isSellMajor
          ? "sell major"
          : "buy major"))) + (": exchangeVolume >= 0  but ")), exchangeVolume});
        
        //#line 595 "/home/dsl/workspace/plhamK/plham/Market.x10"
        final double t$21033 = ((double)(long)(((long)(exchangeVolume))));
        
        //#line 595 "/home/dsl/workspace/plhamK/plham/Market.x10"
        final double cashAmountDelta = ((exchangePrice) * (((double)(t$21033))));
        
        //#line 596 "/home/dsl/workspace/plhamK/plham/Market.x10"
        final long assetVolumeDelta = exchangeVolume;
        
        //#line 598 "/home/dsl/workspace/plhamK/plham/Market.x10"
        final long t = this.getTime$O();
        
        //#line 600 "/home/dsl/workspace/plhamK/plham/Market.x10"
        final plham.Market.AgentUpdate buyUpdate = ((plham.Market.AgentUpdate)(new plham.Market.AgentUpdate((java.lang.System[]) null).plham$Market$AgentUpdate$$init$S()));
        
        //#line 601 "/home/dsl/workspace/plhamK/plham/Market.x10"
        final long t$21034 = buyOrder.agentId;
        
        //#line 601 "/home/dsl/workspace/plhamK/plham/Market.x10"
        buyUpdate.agentId = t$21034;
        
        //#line 602 "/home/dsl/workspace/plhamK/plham/Market.x10"
        final long t$21035 = buyOrder.marketId;
        
        //#line 602 "/home/dsl/workspace/plhamK/plham/Market.x10"
        buyUpdate.marketId = t$21035;
        
        //#line 603 "/home/dsl/workspace/plhamK/plham/Market.x10"
        final long t$21036 = buyOrder.orderId;
        
        //#line 603 "/home/dsl/workspace/plhamK/plham/Market.x10"
        buyUpdate.orderId = t$21036;
        
        //#line 604 "/home/dsl/workspace/plhamK/plham/Market.x10"
        buyUpdate.price = exchangePrice;
        
        //#line 605 "/home/dsl/workspace/plhamK/plham/Market.x10"
        final double t$21037 = (-(cashAmountDelta));
        
        //#line 605 "/home/dsl/workspace/plhamK/plham/Market.x10"
        buyUpdate.cashAmountDelta = t$21037;
        
        //#line 606 "/home/dsl/workspace/plhamK/plham/Market.x10"
        final long t$21038 = (+(assetVolumeDelta));
        
        //#line 606 "/home/dsl/workspace/plhamK/plham/Market.x10"
        buyUpdate.assetVolumeDelta = t$21038;
        
        //#line 607 "/home/dsl/workspace/plhamK/plham/Market.x10"
        this.handleAgentUpdate(((plham.Market.AgentUpdate)(buyUpdate)));
        
        //#line 609 "/home/dsl/workspace/plhamK/plham/Market.x10"
        final plham.Market.AgentUpdate sellUpdate = ((plham.Market.AgentUpdate)(new plham.Market.AgentUpdate((java.lang.System[]) null).plham$Market$AgentUpdate$$init$S()));
        
        //#line 610 "/home/dsl/workspace/plhamK/plham/Market.x10"
        final long t$21039 = sellOrder.agentId;
        
        //#line 610 "/home/dsl/workspace/plhamK/plham/Market.x10"
        sellUpdate.agentId = t$21039;
        
        //#line 611 "/home/dsl/workspace/plhamK/plham/Market.x10"
        final long t$21040 = sellOrder.marketId;
        
        //#line 611 "/home/dsl/workspace/plhamK/plham/Market.x10"
        sellUpdate.marketId = t$21040;
        
        //#line 612 "/home/dsl/workspace/plhamK/plham/Market.x10"
        final long t$21041 = sellOrder.orderId;
        
        //#line 612 "/home/dsl/workspace/plhamK/plham/Market.x10"
        sellUpdate.orderId = t$21041;
        
        //#line 613 "/home/dsl/workspace/plhamK/plham/Market.x10"
        sellUpdate.price = exchangePrice;
        
        //#line 614 "/home/dsl/workspace/plhamK/plham/Market.x10"
        final double t$21042 = (+(cashAmountDelta));
        
        //#line 614 "/home/dsl/workspace/plhamK/plham/Market.x10"
        sellUpdate.cashAmountDelta = t$21042;
        
        //#line 615 "/home/dsl/workspace/plhamK/plham/Market.x10"
        final long t$21043 = (-(assetVolumeDelta));
        
        //#line 615 "/home/dsl/workspace/plhamK/plham/Market.x10"
        sellUpdate.assetVolumeDelta = t$21043;
        
        //#line 616 "/home/dsl/workspace/plhamK/plham/Market.x10"
        this.handleAgentUpdate(((plham.Market.AgentUpdate)(sellUpdate)));
        
        //#line 618 "/home/dsl/workspace/plhamK/plham/Market.x10"
        final boolean EXECUTION_LOG = false;
        
        //#line 619 "/home/dsl/workspace/plhamK/plham/Market.x10"
        if (EXECUTION_LOG) {
            
            //#line 620 "/home/dsl/workspace/plhamK/plham/Market.x10"
            final plham.Market.ExecutionLog log = ((plham.Market.ExecutionLog)(new plham.Market.ExecutionLog((java.lang.System[]) null).plham$Market$ExecutionLog$$init$S()));
            
            //#line 621 "/home/dsl/workspace/plhamK/plham/Market.x10"
            log.isSellMajor = isSellMajor;
            
            //#line 622 "/home/dsl/workspace/plhamK/plham/Market.x10"
            log.time = t;
            
            //#line 623 "/home/dsl/workspace/plhamK/plham/Market.x10"
            final long t$21044 = buyOrder.agentId;
            
            //#line 623 "/home/dsl/workspace/plhamK/plham/Market.x10"
            log.buyAgentId = t$21044;
            
            //#line 624 "/home/dsl/workspace/plhamK/plham/Market.x10"
            final long t$21045 = sellOrder.agentId;
            
            //#line 624 "/home/dsl/workspace/plhamK/plham/Market.x10"
            log.sellAgentId = t$21045;
            
            //#line 625 "/home/dsl/workspace/plhamK/plham/Market.x10"
            log.exchangePrice = exchangePrice;
            
            //#line 626 "/home/dsl/workspace/plhamK/plham/Market.x10"
            log.exchangeVolume = exchangeVolume;
            
            //#line 627 "/home/dsl/workspace/plhamK/plham/Market.x10"
            final x10.util.List t$21046 = ((x10.util.List)(this.executionLogs));
            
            //#line 627 "/home/dsl/workspace/plhamK/plham/Market.x10"
            final x10.util.List t$21047 = ((x10.util.Indexed<x10.util.List<plham.Market.ExecutionLog>>)t$21046).$apply$G((long)(t));
            
            //#line 627 "/home/dsl/workspace/plhamK/plham/Market.x10"
            ((x10.util.Collection<plham.Market.ExecutionLog>)t$21047).add$Z(((plham.Market.ExecutionLog)(log)), plham.Market.ExecutionLog.$RTT);
        }
        
        //#line 630 "/home/dsl/workspace/plhamK/plham/Market.x10"
        final long t$21048 = (-(exchangeVolume));
        
        //#line 630 "/home/dsl/workspace/plhamK/plham/Market.x10"
        buyOrder.updateVolume((long)(t$21048));
        
        //#line 631 "/home/dsl/workspace/plhamK/plham/Market.x10"
        final long t$21049 = (-(exchangeVolume));
        
        //#line 631 "/home/dsl/workspace/plhamK/plham/Market.x10"
        sellOrder.updateVolume((long)(t$21049));
        
        //#line 633 "/home/dsl/workspace/plhamK/plham/Market.x10"
        final x10.util.List a$20721 = ((x10.util.List)(this.executedOrdersCounts));
        
        //#line 633 "/home/dsl/workspace/plhamK/plham/Market.x10"
        final long i0$20722 = t;
        
        //#line 633 "/home/dsl/workspace/plhamK/plham/Market.x10"
        final long t$21050 = x10.core.Long.$unbox(((x10.util.Indexed<x10.core.Long>)a$20721).$apply$G((long)(i0$20722)));
        
        //#line 633 "/home/dsl/workspace/plhamK/plham/Market.x10"
        final long r$20730 = ((t$21050) + (((long)(1L))));
        
        //#line 633 "/home/dsl/workspace/plhamK/plham/Market.x10"
        ((x10.lang.Settable<x10.core.Long, x10.core.Long>)a$20721).$set(x10.core.Long.$box(i0$20722), x10.rtt.Types.LONG, x10.core.Long.$box(r$20730), x10.rtt.Types.LONG);
        
        //#line 634 "/home/dsl/workspace/plhamK/plham/Market.x10"
        final x10.util.List t$21051 = ((x10.util.List)(this.lastExecutedPrices));
        
        //#line 634 "/home/dsl/workspace/plhamK/plham/Market.x10"
        ((x10.lang.Settable<x10.core.Long, x10.core.Double>)t$21051).$set(x10.core.Long.$box(t), x10.rtt.Types.LONG, x10.core.Double.$box(exchangePrice), x10.rtt.Types.DOUBLE);
        
        //#line 635 "/home/dsl/workspace/plhamK/plham/Market.x10"
        final x10.util.List t$21054 = ((x10.util.List)(this.sumExecutedVolumes));
        
        //#line 635 "/home/dsl/workspace/plhamK/plham/Market.x10"
        final x10.util.List t$21052 = ((x10.util.List)(this.sumExecutedVolumes));
        
        //#line 635 "/home/dsl/workspace/plhamK/plham/Market.x10"
        final long t$21053 = x10.core.Long.$unbox(((x10.util.Indexed<x10.core.Long>)t$21052).$apply$G((long)(t)));
        
        //#line 635 "/home/dsl/workspace/plhamK/plham/Market.x10"
        final long t$21055 = ((t$21053) + (((long)(exchangeVolume))));
        
        //#line 635 "/home/dsl/workspace/plhamK/plham/Market.x10"
        ((x10.lang.Settable<x10.core.Long, x10.core.Long>)t$21054).$set(x10.core.Long.$box(t), x10.rtt.Types.LONG, x10.core.Long.$box(t$21055), x10.rtt.Types.LONG);
        
        //#line 637 "/home/dsl/workspace/plhamK/plham/Market.x10"
        final boolean DEBUG = false;
        
        //#line 638 "/home/dsl/workspace/plhamK/plham/Market.x10"
        if (DEBUG) {
            
            //#line 639 "/home/dsl/workspace/plhamK/plham/Market.x10"
            final x10.io.Printer t$21056 = ((x10.io.Printer)(x10.io.Console.get$OUT()));
            
            //#line 639 "/home/dsl/workspace/plhamK/plham/Market.x10"
            final java.lang.String t$21057 = (("exchangePrice: ") + ((x10.core.Double.$box(exchangePrice))));
            
            //#line 639 "/home/dsl/workspace/plhamK/plham/Market.x10"
            t$21056.println(((java.lang.Object)(t$21057)));
            
            //#line 640 "/home/dsl/workspace/plhamK/plham/Market.x10"
            final x10.io.Printer t$21058 = ((x10.io.Printer)(x10.io.Console.get$OUT()));
            
            //#line 640 "/home/dsl/workspace/plhamK/plham/Market.x10"
            final java.lang.String t$21059 = (("exchangeVolume: ") + ((x10.core.Long.$box(exchangeVolume))));
            
            //#line 640 "/home/dsl/workspace/plhamK/plham/Market.x10"
            t$21058.println(((java.lang.Object)(t$21059)));
            
            //#line 641 "/home/dsl/workspace/plhamK/plham/Market.x10"
            final x10.io.Printer t$21061 = ((x10.io.Printer)(x10.io.Console.get$OUT()));
            
            //#line 641 "/home/dsl/workspace/plhamK/plham/Market.x10"
            final long t$21060 = buyOrder.getVolume$O();
            
            //#line 641 "/home/dsl/workspace/plhamK/plham/Market.x10"
            final java.lang.String t$21062 = (("buyOrder.getVolume(): ") + ((x10.core.Long.$box(t$21060))));
            
            //#line 641 "/home/dsl/workspace/plhamK/plham/Market.x10"
            t$21061.println(((java.lang.Object)(t$21062)));
            
            //#line 642 "/home/dsl/workspace/plhamK/plham/Market.x10"
            final x10.io.Printer t$21064 = ((x10.io.Printer)(x10.io.Console.get$OUT()));
            
            //#line 642 "/home/dsl/workspace/plhamK/plham/Market.x10"
            final long t$21063 = sellOrder.getVolume$O();
            
            //#line 642 "/home/dsl/workspace/plhamK/plham/Market.x10"
            final java.lang.String t$21065 = (("sellOrder.getVolume(): ") + ((x10.core.Long.$box(t$21063))));
            
            //#line 642 "/home/dsl/workspace/plhamK/plham/Market.x10"
            t$21064.println(((java.lang.Object)(t$21065)));
        }
    }
    
    
    //#line 646 "/home/dsl/workspace/plhamK/plham/Market.x10"
    public long getTradeVolume$O() {
        
        //#line 646 "/home/dsl/workspace/plhamK/plham/Market.x10"
        final long t$21066 = this.getTime$O();
        
        //#line 646 "/home/dsl/workspace/plhamK/plham/Market.x10"
        final long t$21067 = this.getTradeVolume$O((long)(t$21066));
        
        //#line 646 "/home/dsl/workspace/plhamK/plham/Market.x10"
        return t$21067;
    }
    
    
    //#line 648 "/home/dsl/workspace/plhamK/plham/Market.x10"
    public long getTradeVolume$O(final long t) {
        
        //#line 648 "/home/dsl/workspace/plhamK/plham/Market.x10"
        final x10.util.List t$21068 = ((x10.util.List)(this.sumExecutedVolumes));
        
        //#line 648 "/home/dsl/workspace/plhamK/plham/Market.x10"
        final long t$21069 = x10.core.Long.$unbox(((x10.util.Indexed<x10.core.Long>)t$21068).$apply$G((long)(t)));
        
        //#line 648 "/home/dsl/workspace/plhamK/plham/Market.x10"
        return t$21069;
    }
    
    
    //#line 650 "/home/dsl/workspace/plhamK/plham/Market.x10"
    public long setTradeVolume$O(final long t, final long tradeVolume) {
        
        //#line 650 "/home/dsl/workspace/plhamK/plham/Market.x10"
        final x10.util.List t$21070 = ((x10.util.List)(this.sumExecutedVolumes));
        
        //#line 650 "/home/dsl/workspace/plhamK/plham/Market.x10"
        final long t$21071 = x10.core.Long.$unbox(((x10.lang.Settable<x10.core.Long, x10.core.Long>)t$21070).$set(x10.core.Long.$box(t), x10.rtt.Types.LONG, x10.core.Long.$box(tradeVolume), x10.rtt.Types.LONG));
        
        //#line 650 "/home/dsl/workspace/plhamK/plham/Market.x10"
        return t$21071;
    }
    
    
    //#line 652 "/home/dsl/workspace/plhamK/plham/Market.x10"
    @x10.runtime.impl.java.X10Generated
    public static class AgentUpdate extends x10.core.Ref implements x10.serialization.X10JavaSerializable
    {
        public static final x10.rtt.RuntimeType<AgentUpdate> $RTT = 
            x10.rtt.NamedType.<AgentUpdate> make("plham.Market.AgentUpdate",
                                                 AgentUpdate.class);
        
        public x10.rtt.RuntimeType<?> $getRTT() { return $RTT; }
        
        public x10.rtt.Type<?> $getParam(int i) { return null; }
        
        private Object writeReplace() throws java.io.ObjectStreamException {
            return new x10.serialization.SerializationProxy(this);
        }
        
        public static x10.serialization.X10JavaSerializable $_deserialize_body(plham.Market.AgentUpdate $_obj, x10.serialization.X10JavaDeserializer $deserializer) throws java.io.IOException {
            if (x10.runtime.impl.java.Runtime.TRACE_SER) { x10.runtime.impl.java.Runtime.printTraceMessage("X10JavaSerializable: $_deserialize_body() of " + AgentUpdate.class + " calling"); } 
            $_obj.agentId = $deserializer.readLong();
            $_obj.assetVolumeDelta = $deserializer.readLong();
            $_obj.cashAmountDelta = $deserializer.readDouble();
            $_obj.marketId = $deserializer.readLong();
            $_obj.orderId = $deserializer.readLong();
            $_obj.price = $deserializer.readDouble();
            return $_obj;
        }
        
        public static x10.serialization.X10JavaSerializable $_deserializer(x10.serialization.X10JavaDeserializer $deserializer) throws java.io.IOException {
            plham.Market.AgentUpdate $_obj = new plham.Market.AgentUpdate((java.lang.System[]) null);
            $deserializer.record_reference($_obj);
            return $_deserialize_body($_obj, $deserializer);
        }
        
        public void $_serialize(x10.serialization.X10JavaSerializer $serializer) throws java.io.IOException {
            $serializer.write(this.agentId);
            $serializer.write(this.assetVolumeDelta);
            $serializer.write(this.cashAmountDelta);
            $serializer.write(this.marketId);
            $serializer.write(this.orderId);
            $serializer.write(this.price);
            
        }
        
        // constructor just for allocation
        public AgentUpdate(final java.lang.System[] $dummy) {
            
        }
        
        
    
        
        //#line 653 "/home/dsl/workspace/plhamK/plham/Market.x10"
        public long agentId;
        
        //#line 654 "/home/dsl/workspace/plhamK/plham/Market.x10"
        public long marketId;
        
        //#line 655 "/home/dsl/workspace/plhamK/plham/Market.x10"
        public long orderId;
        
        //#line 656 "/home/dsl/workspace/plhamK/plham/Market.x10"
        public double price;
        
        //#line 657 "/home/dsl/workspace/plhamK/plham/Market.x10"
        public double cashAmountDelta;
        
        //#line 658 "/home/dsl/workspace/plhamK/plham/Market.x10"
        public long assetVolumeDelta;
        
        
        //#line 660 "/home/dsl/workspace/plhamK/plham/Market.x10"
        public boolean isBuySide$O() {
            
            //#line 660 "/home/dsl/workspace/plhamK/plham/Market.x10"
            final long t$21072 = this.assetVolumeDelta;
            
            //#line 660 "/home/dsl/workspace/plhamK/plham/Market.x10"
            final boolean t$21073 = ((t$21072) > (((long)(0L))));
            
            //#line 660 "/home/dsl/workspace/plhamK/plham/Market.x10"
            return t$21073;
        }
        
        
        //#line 661 "/home/dsl/workspace/plhamK/plham/Market.x10"
        public boolean isSellSide$O() {
            
            //#line 661 "/home/dsl/workspace/plhamK/plham/Market.x10"
            final long t$21074 = this.assetVolumeDelta;
            
            //#line 661 "/home/dsl/workspace/plhamK/plham/Market.x10"
            final boolean t$21075 = ((t$21074) < (((long)(0L))));
            
            //#line 661 "/home/dsl/workspace/plhamK/plham/Market.x10"
            return t$21075;
        }
        
        
        //#line 652 "/home/dsl/workspace/plhamK/plham/Market.x10"
        final public plham.Market.AgentUpdate plham$Market$AgentUpdate$$this$plham$Market$AgentUpdate() {
            
            //#line 652 "/home/dsl/workspace/plhamK/plham/Market.x10"
            return plham.Market.AgentUpdate.this;
        }
        
        
        //#line 652 "/home/dsl/workspace/plhamK/plham/Market.x10"
        // creation method for java code (1-phase java constructor)
        public AgentUpdate() {
            this((java.lang.System[]) null);
            plham$Market$AgentUpdate$$init$S();
        }
        
        // constructor for non-virtual call
        final public plham.Market.AgentUpdate plham$Market$AgentUpdate$$init$S() {
             {
                
                //#line 652 "/home/dsl/workspace/plhamK/plham/Market.x10"
                
                
                //#line 652 "/home/dsl/workspace/plhamK/plham/Market.x10"
                this.__fieldInitializers_plham_Market_AgentUpdate();
            }
            return this;
        }
        
        
        
        //#line 652 "/home/dsl/workspace/plhamK/plham/Market.x10"
        final public void __fieldInitializers_plham_Market_AgentUpdate() {
            
            //#line 652 "/home/dsl/workspace/plhamK/plham/Market.x10"
            this.agentId = 0L;
            
            //#line 652 "/home/dsl/workspace/plhamK/plham/Market.x10"
            this.marketId = 0L;
            
            //#line 652 "/home/dsl/workspace/plhamK/plham/Market.x10"
            this.orderId = 0L;
            
            //#line 652 "/home/dsl/workspace/plhamK/plham/Market.x10"
            this.price = 0.0;
            
            //#line 652 "/home/dsl/workspace/plhamK/plham/Market.x10"
            this.cashAmountDelta = 0.0;
            
            //#line 652 "/home/dsl/workspace/plhamK/plham/Market.x10"
            this.assetVolumeDelta = 0L;
        }
    }
    
    
    //#line 664 "/home/dsl/workspace/plhamK/plham/Market.x10"
    public transient x10.util.List<x10.util.List<plham.Market.AgentUpdate>> agentUpdates;
    
    
    //#line 666 "/home/dsl/workspace/plhamK/plham/Market.x10"
    public void handleAgentUpdate(final plham.Market.AgentUpdate update) {
        
        //#line 667 "/home/dsl/workspace/plhamK/plham/Market.x10"
        final long t = this.getTime$O();
        
        //#line 668 "/home/dsl/workspace/plhamK/plham/Market.x10"
        try {{
            
            //#line 669 "/home/dsl/workspace/plhamK/plham/Market.x10"
            final plham.Env t$21076 = ((plham.Env)(this.env));
            
            //#line 669 "/home/dsl/workspace/plhamK/plham/Market.x10"
            final x10.util.List t$21077 = ((x10.util.List)(t$21076.agents));
            
            //#line 669 "/home/dsl/workspace/plhamK/plham/Market.x10"
            this.executeAgentUpdate__0$1plham$Agent$2(((x10.util.Indexed)(t$21077)), ((plham.Market.AgentUpdate)(update)));
        }}catch (final java.lang.IndexOutOfBoundsException e) {
            
            //#line 671 "/home/dsl/workspace/plhamK/plham/Market.x10"
            final x10.util.List t$21078 = ((x10.util.List)(this.agentUpdates));
            
            //#line 671 "/home/dsl/workspace/plhamK/plham/Market.x10"
            final x10.util.List t$21079 = ((x10.util.Indexed<x10.util.List<plham.Market.AgentUpdate>>)t$21078).$apply$G((long)(t));
            
            //#line 671 "/home/dsl/workspace/plhamK/plham/Market.x10"
            ((x10.util.Collection<plham.Market.AgentUpdate>)t$21079).add$Z(((plham.Market.AgentUpdate)(update)), plham.Market.AgentUpdate.$RTT);
        }
    }
    
    
    //#line 675 "/home/dsl/workspace/plhamK/plham/Market.x10"
    public void executeAgentUpdate__0$1plham$Agent$2(final x10.util.Indexed agents, final plham.Market.AgentUpdate update) {
        
        //#line 676 "/home/dsl/workspace/plhamK/plham/Market.x10"
        final long id = update.agentId;
        
        //#line 677 "/home/dsl/workspace/plhamK/plham/Market.x10"
        final plham.Agent agent = ((x10.util.Indexed<plham.Agent>)agents).$apply$G((long)(id));
        
        //#line 678 "/home/dsl/workspace/plhamK/plham/Market.x10"
        final boolean t$21080 = ((agent) != (null));
        
        //#line 678 "/home/dsl/workspace/plhamK/plham/Market.x10"
        if (t$21080) {
            
            //#line 679 "/home/dsl/workspace/plhamK/plham/Market.x10"
            agent.executeUpdate(((plham.Market.AgentUpdate)(update)));
        }
    }
    
    
    //#line 683 "/home/dsl/workspace/plhamK/plham/Market.x10"
    @x10.runtime.impl.java.X10Generated
    public static interface MarketEvent extends plham.Event, x10.serialization.X10JavaSerializable
    {
        public static final x10.rtt.RuntimeType<MarketEvent> $RTT = 
            x10.rtt.NamedType.<MarketEvent> make("plham.Market.MarketEvent",
                                                 MarketEvent.class,
                                                 new x10.rtt.Type[] {
                                                     plham.Event.$RTT
                                                 });
        
        
    
        
        
        //#line 684 "/home/dsl/workspace/plhamK/plham/Market.x10"
        void update(final plham.Market market);
    }
    
    
    //#line 687 "/home/dsl/workspace/plhamK/plham/Market.x10"
    @x10.runtime.impl.java.X10Generated
    public static interface OrderEvent extends plham.Event, x10.serialization.X10JavaSerializable
    {
        public static final x10.rtt.RuntimeType<OrderEvent> $RTT = 
            x10.rtt.NamedType.<OrderEvent> make("plham.Market.OrderEvent",
                                                OrderEvent.class,
                                                new x10.rtt.Type[] {
                                                    plham.Event.$RTT
                                                });
        
        
    
        
        
        //#line 688 "/home/dsl/workspace/plhamK/plham/Market.x10"
        void update(final plham.Market market, final plham.Order order);
    }
    
    
    //#line 691 "/home/dsl/workspace/plhamK/plham/Market.x10"
    public x10.util.List<plham.Market.OrderEvent> beforeOrderHandlingEvents;
    
    //#line 693 "/home/dsl/workspace/plhamK/plham/Market.x10"
    public x10.util.List<plham.Market.OrderEvent> afterOrderHandlingEvents;
    
    //#line 695 "/home/dsl/workspace/plhamK/plham/Market.x10"
    public x10.util.List<plham.Market.MarketEvent> beforeSimulationStepEvents;
    
    //#line 697 "/home/dsl/workspace/plhamK/plham/Market.x10"
    public x10.util.List<plham.Market.MarketEvent> afterSimulationStepEvents;
    
    
    //#line 699 "/home/dsl/workspace/plhamK/plham/Market.x10"
    public boolean addBeforeOrderHandlingEvent$O(final plham.Market.OrderEvent e) {
        
        //#line 699 "/home/dsl/workspace/plhamK/plham/Market.x10"
        final x10.util.List t$21081 = ((x10.util.List)(this.beforeOrderHandlingEvents));
        
        //#line 699 "/home/dsl/workspace/plhamK/plham/Market.x10"
        final boolean t$21082 = x10.core.Boolean.$unbox(((x10.util.Collection<plham.Market.OrderEvent>)t$21081).add$Z(((plham.Market.OrderEvent)(e)), plham.Market.OrderEvent.$RTT));
        
        //#line 699 "/home/dsl/workspace/plhamK/plham/Market.x10"
        return t$21082;
    }
    
    
    //#line 701 "/home/dsl/workspace/plhamK/plham/Market.x10"
    public boolean addAfterOrderHandlingEvent$O(final plham.Market.OrderEvent e) {
        
        //#line 701 "/home/dsl/workspace/plhamK/plham/Market.x10"
        final x10.util.List t$21083 = ((x10.util.List)(this.afterOrderHandlingEvents));
        
        //#line 701 "/home/dsl/workspace/plhamK/plham/Market.x10"
        final boolean t$21084 = x10.core.Boolean.$unbox(((x10.util.Collection<plham.Market.OrderEvent>)t$21083).add$Z(((plham.Market.OrderEvent)(e)), plham.Market.OrderEvent.$RTT));
        
        //#line 701 "/home/dsl/workspace/plhamK/plham/Market.x10"
        return t$21084;
    }
    
    
    //#line 703 "/home/dsl/workspace/plhamK/plham/Market.x10"
    public boolean addBeforeSimulationStepEvent$O(final plham.Market.MarketEvent e) {
        
        //#line 703 "/home/dsl/workspace/plhamK/plham/Market.x10"
        final x10.util.List t$21085 = ((x10.util.List)(this.beforeSimulationStepEvents));
        
        //#line 703 "/home/dsl/workspace/plhamK/plham/Market.x10"
        final boolean t$21086 = x10.core.Boolean.$unbox(((x10.util.Collection<plham.Market.MarketEvent>)t$21085).add$Z(((plham.Market.MarketEvent)(e)), plham.Market.MarketEvent.$RTT));
        
        //#line 703 "/home/dsl/workspace/plhamK/plham/Market.x10"
        return t$21086;
    }
    
    
    //#line 705 "/home/dsl/workspace/plhamK/plham/Market.x10"
    public boolean addAfterSimulationStepEvent$O(final plham.Market.MarketEvent e) {
        
        //#line 705 "/home/dsl/workspace/plhamK/plham/Market.x10"
        final x10.util.List t$21087 = ((x10.util.List)(this.afterSimulationStepEvents));
        
        //#line 705 "/home/dsl/workspace/plhamK/plham/Market.x10"
        final boolean t$21088 = x10.core.Boolean.$unbox(((x10.util.Collection<plham.Market.MarketEvent>)t$21087).add$Z(((plham.Market.MarketEvent)(e)), plham.Market.MarketEvent.$RTT));
        
        //#line 705 "/home/dsl/workspace/plhamK/plham/Market.x10"
        return t$21088;
    }
    
    
    //#line 707 "/home/dsl/workspace/plhamK/plham/Market.x10"
    public void triggerBeforeOrderHandlingEvents(final plham.Order order) {
        
        //#line 708 "/home/dsl/workspace/plhamK/plham/Market.x10"
        final x10.util.List t$21090 = ((x10.util.List)(this.beforeOrderHandlingEvents));
        
        //#line 708 "/home/dsl/workspace/plhamK/plham/Market.x10"
        final x10.util.ListIterator e$20782 = ((x10.util.ListIterator<plham.Market.OrderEvent>)
                                                ((x10.util.List<plham.Market.OrderEvent>)t$21090).iterator());
        
        //#line 708 "/home/dsl/workspace/plhamK/plham/Market.x10"
        for (;
             true;
             ) {
            
            //#line 708 "/home/dsl/workspace/plhamK/plham/Market.x10"
            final boolean t$21091 = ((x10.util.ListIterator<plham.Market.OrderEvent>)e$20782).hasNext$O();
            
            //#line 708 "/home/dsl/workspace/plhamK/plham/Market.x10"
            if (!(t$21091)) {
                
                //#line 708 "/home/dsl/workspace/plhamK/plham/Market.x10"
                break;
            }
            
            //#line 708 "/home/dsl/workspace/plhamK/plham/Market.x10"
            final plham.Market.OrderEvent e$21150 = ((plham.Market.OrderEvent)(((x10.util.ListIterator<plham.Market.OrderEvent>)e$20782).next$G()));
            
            //#line 709 "/home/dsl/workspace/plhamK/plham/Market.x10"
            e$21150.update(((plham.Market)(this)), ((plham.Order)(order)));
        }
    }
    
    
    //#line 713 "/home/dsl/workspace/plhamK/plham/Market.x10"
    public void triggerAfterOrderHandlingEvents(final plham.Order order) {
        
        //#line 714 "/home/dsl/workspace/plhamK/plham/Market.x10"
        final x10.util.List t$21093 = ((x10.util.List)(this.afterOrderHandlingEvents));
        
        //#line 714 "/home/dsl/workspace/plhamK/plham/Market.x10"
        final x10.util.ListIterator e$20784 = ((x10.util.ListIterator<plham.Market.OrderEvent>)
                                                ((x10.util.List<plham.Market.OrderEvent>)t$21093).iterator());
        
        //#line 714 "/home/dsl/workspace/plhamK/plham/Market.x10"
        for (;
             true;
             ) {
            
            //#line 714 "/home/dsl/workspace/plhamK/plham/Market.x10"
            final boolean t$21094 = ((x10.util.ListIterator<plham.Market.OrderEvent>)e$20784).hasNext$O();
            
            //#line 714 "/home/dsl/workspace/plhamK/plham/Market.x10"
            if (!(t$21094)) {
                
                //#line 714 "/home/dsl/workspace/plhamK/plham/Market.x10"
                break;
            }
            
            //#line 714 "/home/dsl/workspace/plhamK/plham/Market.x10"
            final plham.Market.OrderEvent e$21151 = ((plham.Market.OrderEvent)(((x10.util.ListIterator<plham.Market.OrderEvent>)e$20784).next$G()));
            
            //#line 715 "/home/dsl/workspace/plhamK/plham/Market.x10"
            e$21151.update(((plham.Market)(this)), ((plham.Order)(order)));
        }
    }
    
    
    //#line 719 "/home/dsl/workspace/plhamK/plham/Market.x10"
    public void triggerBeforeSimulationStepEvents() {
        
        //#line 720 "/home/dsl/workspace/plhamK/plham/Market.x10"
        final x10.util.List t$21096 = ((x10.util.List)(this.beforeSimulationStepEvents));
        
        //#line 720 "/home/dsl/workspace/plhamK/plham/Market.x10"
        final x10.util.ListIterator e$20786 = ((x10.util.ListIterator<plham.Market.MarketEvent>)
                                                ((x10.util.List<plham.Market.MarketEvent>)t$21096).iterator());
        
        //#line 720 "/home/dsl/workspace/plhamK/plham/Market.x10"
        for (;
             true;
             ) {
            
            //#line 720 "/home/dsl/workspace/plhamK/plham/Market.x10"
            final boolean t$21097 = ((x10.util.ListIterator<plham.Market.MarketEvent>)e$20786).hasNext$O();
            
            //#line 720 "/home/dsl/workspace/plhamK/plham/Market.x10"
            if (!(t$21097)) {
                
                //#line 720 "/home/dsl/workspace/plhamK/plham/Market.x10"
                break;
            }
            
            //#line 720 "/home/dsl/workspace/plhamK/plham/Market.x10"
            final plham.Market.MarketEvent e$21152 = ((plham.Market.MarketEvent)(((x10.util.ListIterator<plham.Market.MarketEvent>)e$20786).next$G()));
            
            //#line 721 "/home/dsl/workspace/plhamK/plham/Market.x10"
            e$21152.update(((plham.Market)(this)));
        }
    }
    
    
    //#line 725 "/home/dsl/workspace/plhamK/plham/Market.x10"
    public void triggerAfterSimulationStepEvents() {
        
        //#line 726 "/home/dsl/workspace/plhamK/plham/Market.x10"
        final x10.util.List t$21099 = ((x10.util.List)(this.afterSimulationStepEvents));
        
        //#line 726 "/home/dsl/workspace/plhamK/plham/Market.x10"
        final x10.util.ListIterator e$20788 = ((x10.util.ListIterator<plham.Market.MarketEvent>)
                                                ((x10.util.List<plham.Market.MarketEvent>)t$21099).iterator());
        
        //#line 726 "/home/dsl/workspace/plhamK/plham/Market.x10"
        for (;
             true;
             ) {
            
            //#line 726 "/home/dsl/workspace/plhamK/plham/Market.x10"
            final boolean t$21100 = ((x10.util.ListIterator<plham.Market.MarketEvent>)e$20788).hasNext$O();
            
            //#line 726 "/home/dsl/workspace/plhamK/plham/Market.x10"
            if (!(t$21100)) {
                
                //#line 726 "/home/dsl/workspace/plhamK/plham/Market.x10"
                break;
            }
            
            //#line 726 "/home/dsl/workspace/plhamK/plham/Market.x10"
            final plham.Market.MarketEvent e$21153 = ((plham.Market.MarketEvent)(((x10.util.ListIterator<plham.Market.MarketEvent>)e$20788).next$G()));
            
            //#line 727 "/home/dsl/workspace/plhamK/plham/Market.x10"
            e$21153.update(((plham.Market)(this)));
        }
    }
    
    
    //#line 34 "/home/dsl/workspace/plhamK/plham/Market.x10"
    final public plham.Market plham$Market$$this$plham$Market() {
        
        //#line 34 "/home/dsl/workspace/plhamK/plham/Market.x10"
        return plham.Market.this;
    }
    
    
    //#line 34 "/home/dsl/workspace/plhamK/plham/Market.x10"
    final public void __fieldInitializers_plham_Market() {
        
        //#line 34 "/home/dsl/workspace/plhamK/plham/Market.x10"
        this._isRunning = false;
        
        //#line 34 "/home/dsl/workspace/plhamK/plham/Market.x10"
        this.buyOrderBook = null;
        
        //#line 34 "/home/dsl/workspace/plhamK/plham/Market.x10"
        this.sellOrderBook = null;
        
        //#line 34 "/home/dsl/workspace/plhamK/plham/Market.x10"
        this.outstandingShares = 0L;
        
        //#line 34 "/home/dsl/workspace/plhamK/plham/Market.x10"
        this.time = null;
        
        //#line 34 "/home/dsl/workspace/plhamK/plham/Market.x10"
        this.env = null;
        
        //#line 34 "/home/dsl/workspace/plhamK/plham/Market.x10"
        this.tickSize = 0.0;
        
        //#line 58 "/home/dsl/workspace/plhamK/plham/Market.x10"
        final double t$21101 = -1.0;
        
        //#line 34 "/home/dsl/workspace/plhamK/plham/Market.x10"
        this.NO_TICKSIZE = t$21101;
        
        //#line 34 "/home/dsl/workspace/plhamK/plham/Market.x10"
        this.marketPrices = null;
        
        //#line 34 "/home/dsl/workspace/plhamK/plham/Market.x10"
        this.fundamentalPrices = null;
        
        //#line 34 "/home/dsl/workspace/plhamK/plham/Market.x10"
        this.fundamentalVolatility = 0.0;
        
        //#line 34 "/home/dsl/workspace/plhamK/plham/Market.x10"
        this.lastExecutedPrices = null;
        
        //#line 34 "/home/dsl/workspace/plhamK/plham/Market.x10"
        this.sumExecutedVolumes = null;
        
        //#line 34 "/home/dsl/workspace/plhamK/plham/Market.x10"
        this.buyOrdersCounts = null;
        
        //#line 34 "/home/dsl/workspace/plhamK/plham/Market.x10"
        this.sellOrdersCounts = null;
        
        //#line 34 "/home/dsl/workspace/plhamK/plham/Market.x10"
        this.executedOrdersCounts = null;
        
        //#line 75 "/home/dsl/workspace/plhamK/plham/Market.x10"
        final x10.util.ArrayList t$21102 = ((x10.util.ArrayList)(new x10.util.ArrayList<x10.util.List<plham.Market.ExecutionLog>>((java.lang.System[]) null, x10.rtt.ParameterizedType.make(x10.util.List.$RTT, plham.Market.ExecutionLog.$RTT)).x10$util$ArrayList$$init$S()));
        
        //#line 34 "/home/dsl/workspace/plhamK/plham/Market.x10"
        this.executionLogs = ((x10.util.List)(t$21102));
        
        //#line 664 "/home/dsl/workspace/plhamK/plham/Market.x10"
        final x10.util.ArrayList t$21103 = ((x10.util.ArrayList)(new x10.util.ArrayList<x10.util.List<plham.Market.AgentUpdate>>((java.lang.System[]) null, x10.rtt.ParameterizedType.make(x10.util.List.$RTT, plham.Market.AgentUpdate.$RTT)).x10$util$ArrayList$$init$S()));
        
        //#line 34 "/home/dsl/workspace/plhamK/plham/Market.x10"
        this.agentUpdates = ((x10.util.List)(t$21103));
        
        //#line 691 "/home/dsl/workspace/plhamK/plham/Market.x10"
        final x10.util.ArrayList t$21104 = ((x10.util.ArrayList)(new x10.util.ArrayList<plham.Market.OrderEvent>((java.lang.System[]) null, plham.Market.OrderEvent.$RTT).x10$util$ArrayList$$init$S()));
        
        //#line 34 "/home/dsl/workspace/plhamK/plham/Market.x10"
        this.beforeOrderHandlingEvents = ((x10.util.List)(t$21104));
        
        //#line 693 "/home/dsl/workspace/plhamK/plham/Market.x10"
        final x10.util.ArrayList t$21105 = ((x10.util.ArrayList)(new x10.util.ArrayList<plham.Market.OrderEvent>((java.lang.System[]) null, plham.Market.OrderEvent.$RTT).x10$util$ArrayList$$init$S()));
        
        //#line 34 "/home/dsl/workspace/plhamK/plham/Market.x10"
        this.afterOrderHandlingEvents = ((x10.util.List)(t$21105));
        
        //#line 695 "/home/dsl/workspace/plhamK/plham/Market.x10"
        final x10.util.ArrayList t$21106 = ((x10.util.ArrayList)(new x10.util.ArrayList<plham.Market.MarketEvent>((java.lang.System[]) null, plham.Market.MarketEvent.$RTT).x10$util$ArrayList$$init$S()));
        
        //#line 34 "/home/dsl/workspace/plhamK/plham/Market.x10"
        this.beforeSimulationStepEvents = ((x10.util.List)(t$21106));
        
        //#line 697 "/home/dsl/workspace/plhamK/plham/Market.x10"
        final x10.util.ArrayList t$21107 = ((x10.util.ArrayList)(new x10.util.ArrayList<plham.Market.MarketEvent>((java.lang.System[]) null, plham.Market.MarketEvent.$RTT).x10$util$ArrayList$$init$S()));
        
        //#line 34 "/home/dsl/workspace/plhamK/plham/Market.x10"
        this.afterSimulationStepEvents = ((x10.util.List)(t$21107));
    }
    
    final private static x10.core.concurrent.AtomicInteger initStatus$ROUND_LOWER = new x10.core.concurrent.AtomicInteger(x10.runtime.impl.java.InitDispatcher.UNINITIALIZED);
    private static x10.lang.ExceptionInInitializer exception$ROUND_LOWER;
    final private static x10.core.concurrent.AtomicInteger initStatus$ROUND_UPPER = new x10.core.concurrent.AtomicInteger(x10.runtime.impl.java.InitDispatcher.UNINITIALIZED);
    private static x10.lang.ExceptionInInitializer exception$ROUND_UPPER;
    
    public static x10.core.fun.Fun_0_2 get$ROUND_UPPER() {
        if (((int) plham.Market.initStatus$ROUND_UPPER.get()) == ((int) x10.runtime.impl.java.InitDispatcher.INITIALIZED)) {
            return plham.Market.ROUND_UPPER;
        }
        if (((int) plham.Market.initStatus$ROUND_UPPER.get()) == ((int) x10.runtime.impl.java.InitDispatcher.EXCEPTION_RAISED)) {
            if (((boolean) x10.runtime.impl.java.InitDispatcher.TRACE_STATIC_INIT) == ((boolean) true)) {
                x10.runtime.impl.java.InitDispatcher.printStaticInitMessage(((java.lang.String)("Rethrowing ExceptionInInitializer for field: plham.Market.ROUND_UPPER")));
            }
            throw plham.Market.exception$ROUND_UPPER;
        }
        if (plham.Market.initStatus$ROUND_UPPER.compareAndSet((int)(x10.runtime.impl.java.InitDispatcher.UNINITIALIZED), (int)(x10.runtime.impl.java.InitDispatcher.INITIALIZING))) {
            try {{
                plham.Market.ROUND_UPPER = ((x10.core.fun.Fun_0_2)(new plham.Market.$Closure$5()));
            }}catch (java.lang.Throwable exc$21154) {
                plham.Market.exception$ROUND_UPPER = new x10.lang.ExceptionInInitializer(exc$21154);
                plham.Market.initStatus$ROUND_UPPER.set((int)(x10.runtime.impl.java.InitDispatcher.EXCEPTION_RAISED));
                x10.runtime.impl.java.InitDispatcher.lockInitialized();
                x10.runtime.impl.java.InitDispatcher.notifyInitialized();
                throw plham.Market.exception$ROUND_UPPER;
            }
            if (((boolean) x10.runtime.impl.java.InitDispatcher.TRACE_STATIC_INIT) == ((boolean) true)) {
                x10.runtime.impl.java.InitDispatcher.printStaticInitMessage(((java.lang.String)("Doing static initialization for field: plham.Market.ROUND_UPPER")));
            }
            plham.Market.initStatus$ROUND_UPPER.set((int)(x10.runtime.impl.java.InitDispatcher.INITIALIZED));
            x10.runtime.impl.java.InitDispatcher.lockInitialized();
            x10.runtime.impl.java.InitDispatcher.notifyInitialized();
        } else {
            if (plham.Market.initStatus$ROUND_UPPER.get() < x10.runtime.impl.java.InitDispatcher.INITIALIZED) {
                x10.runtime.impl.java.InitDispatcher.lockInitialized();
                while (plham.Market.initStatus$ROUND_UPPER.get() < x10.runtime.impl.java.InitDispatcher.INITIALIZED) {
                    x10.runtime.impl.java.InitDispatcher.awaitInitialized();
                }
                x10.runtime.impl.java.InitDispatcher.unlockInitialized();
                if (((int) plham.Market.initStatus$ROUND_UPPER.get()) == ((int) x10.runtime.impl.java.InitDispatcher.EXCEPTION_RAISED)) {
                    if (((boolean) x10.runtime.impl.java.InitDispatcher.TRACE_STATIC_INIT) == ((boolean) true)) {
                        x10.runtime.impl.java.InitDispatcher.printStaticInitMessage(((java.lang.String)("Rethrowing ExceptionInInitializer for field: plham.Market.ROUND_UPPER")));
                    }
                    throw plham.Market.exception$ROUND_UPPER;
                }
            }
        }
        return plham.Market.ROUND_UPPER;
    }
    
    public static x10.core.fun.Fun_0_2 get$ROUND_LOWER() {
        if (((int) plham.Market.initStatus$ROUND_LOWER.get()) == ((int) x10.runtime.impl.java.InitDispatcher.INITIALIZED)) {
            return plham.Market.ROUND_LOWER;
        }
        if (((int) plham.Market.initStatus$ROUND_LOWER.get()) == ((int) x10.runtime.impl.java.InitDispatcher.EXCEPTION_RAISED)) {
            if (((boolean) x10.runtime.impl.java.InitDispatcher.TRACE_STATIC_INIT) == ((boolean) true)) {
                x10.runtime.impl.java.InitDispatcher.printStaticInitMessage(((java.lang.String)("Rethrowing ExceptionInInitializer for field: plham.Market.ROUND_LOWER")));
            }
            throw plham.Market.exception$ROUND_LOWER;
        }
        if (plham.Market.initStatus$ROUND_LOWER.compareAndSet((int)(x10.runtime.impl.java.InitDispatcher.UNINITIALIZED), (int)(x10.runtime.impl.java.InitDispatcher.INITIALIZING))) {
            try {{
                plham.Market.ROUND_LOWER = ((x10.core.fun.Fun_0_2)(new plham.Market.$Closure$6()));
            }}catch (java.lang.Throwable exc$21155) {
                plham.Market.exception$ROUND_LOWER = new x10.lang.ExceptionInInitializer(exc$21155);
                plham.Market.initStatus$ROUND_LOWER.set((int)(x10.runtime.impl.java.InitDispatcher.EXCEPTION_RAISED));
                x10.runtime.impl.java.InitDispatcher.lockInitialized();
                x10.runtime.impl.java.InitDispatcher.notifyInitialized();
                throw plham.Market.exception$ROUND_LOWER;
            }
            if (((boolean) x10.runtime.impl.java.InitDispatcher.TRACE_STATIC_INIT) == ((boolean) true)) {
                x10.runtime.impl.java.InitDispatcher.printStaticInitMessage(((java.lang.String)("Doing static initialization for field: plham.Market.ROUND_LOWER")));
            }
            plham.Market.initStatus$ROUND_LOWER.set((int)(x10.runtime.impl.java.InitDispatcher.INITIALIZED));
            x10.runtime.impl.java.InitDispatcher.lockInitialized();
            x10.runtime.impl.java.InitDispatcher.notifyInitialized();
        } else {
            if (plham.Market.initStatus$ROUND_LOWER.get() < x10.runtime.impl.java.InitDispatcher.INITIALIZED) {
                x10.runtime.impl.java.InitDispatcher.lockInitialized();
                while (plham.Market.initStatus$ROUND_LOWER.get() < x10.runtime.impl.java.InitDispatcher.INITIALIZED) {
                    x10.runtime.impl.java.InitDispatcher.awaitInitialized();
                }
                x10.runtime.impl.java.InitDispatcher.unlockInitialized();
                if (((int) plham.Market.initStatus$ROUND_LOWER.get()) == ((int) x10.runtime.impl.java.InitDispatcher.EXCEPTION_RAISED)) {
                    if (((boolean) x10.runtime.impl.java.InitDispatcher.TRACE_STATIC_INIT) == ((boolean) true)) {
                        x10.runtime.impl.java.InitDispatcher.printStaticInitMessage(((java.lang.String)("Rethrowing ExceptionInInitializer for field: plham.Market.ROUND_LOWER")));
                    }
                    throw plham.Market.exception$ROUND_LOWER;
                }
            }
        }
        return plham.Market.ROUND_LOWER;
    }
    
    @x10.runtime.impl.java.X10Generated
    final public static class $Closure$0 extends x10.core.Ref implements x10.core.fun.Fun_0_4, x10.serialization.X10JavaSerializable
    {
        public static final x10.rtt.RuntimeType<$Closure$0> $RTT = 
            x10.rtt.StaticFunType.<$Closure$0> make($Closure$0.class,
                                                    new x10.rtt.Type[] {
                                                        x10.rtt.ParameterizedType.make(x10.core.fun.Fun_0_4.$RTT, x10.rtt.Types.LONG, x10.rtt.Types.STRING, x10.util.Random.$RTT, cassia.util.JSON.Value.$RTT, x10.rtt.ParameterizedType.make(x10.util.List.$RTT, plham.Market.$RTT))
                                                    });
        
        public x10.rtt.RuntimeType<?> $getRTT() { return $RTT; }
        
        public x10.rtt.Type<?> $getParam(int i) { return null; }
        
        private Object writeReplace() throws java.io.ObjectStreamException {
            return new x10.serialization.SerializationProxy(this);
        }
        
        public static x10.serialization.X10JavaSerializable $_deserialize_body(plham.Market.$Closure$0 $_obj, x10.serialization.X10JavaDeserializer $deserializer) throws java.io.IOException {
            if (x10.runtime.impl.java.Runtime.TRACE_SER) { x10.runtime.impl.java.Runtime.printTraceMessage("X10JavaSerializable: $_deserialize_body() of " + $Closure$0.class + " calling"); } 
            $_obj.sim = $deserializer.readObject();
            return $_obj;
        }
        
        public static x10.serialization.X10JavaSerializable $_deserializer(x10.serialization.X10JavaDeserializer $deserializer) throws java.io.IOException {
            plham.Market.$Closure$0 $_obj = new plham.Market.$Closure$0((java.lang.System[]) null);
            $deserializer.record_reference($_obj);
            return $_deserialize_body($_obj, $deserializer);
        }
        
        public void $_serialize(x10.serialization.X10JavaSerializer $serializer) throws java.io.IOException {
            $serializer.write(this.sim);
            
        }
        
        // constructor just for allocation
        public $Closure$0(final java.lang.System[] $dummy) {
            
        }
        
        // dispatcher for method abstract public (Z1,Z2,Z3,Z4)=>U.operator()(a1:Z1, a2:Z2, a3:Z3, a4:Z4):U
        public java.lang.Object $apply(final java.lang.Object a1, final x10.rtt.Type t1, final java.lang.Object a2, final x10.rtt.Type t2, final java.lang.Object a3, final x10.rtt.Type t3, final java.lang.Object a4, final x10.rtt.Type t4) {
            return $apply(x10.core.Long.$unbox(a1), (java.lang.String)a2, (x10.util.Random)a3, (cassia.util.JSON.Value)a4);
            
        }
        
        
    
        
        public x10.util.List $apply(final long id, final java.lang.String name, final x10.util.Random random, final cassia.util.JSON.Value json) {
            
            //#line 134 "/home/dsl/workspace/plhamK/plham/Market.x10"
            final boolean t$20822 = ((cassia.util.JSON.Value)json).<java.lang.String> has__0cassia$util$JSON$Value$$T$O(x10.rtt.Types.STRING, ((java.lang.String)("numMarkets")));
            
            //#line 134 "/home/dsl/workspace/plhamK/plham/Market.x10"
            long t$20823 =  0;
            
            //#line 134 "/home/dsl/workspace/plhamK/plham/Market.x10"
            if (t$20822) {
                
                //#line 134 "/home/dsl/workspace/plhamK/plham/Market.x10"
                final cassia.util.JSON.Value t$20821 = ((cassia.util.JSON.Value)json).<java.lang.String> get(x10.rtt.Types.STRING, ((java.lang.String)("numMarkets")));
                
                //#line 134 "/home/dsl/workspace/plhamK/plham/Market.x10"
                t$20823 = t$20821.toLong$O();
            } else {
                
                //#line 134 "/home/dsl/workspace/plhamK/plham/Market.x10"
                t$20823 = 1L;
            }
            
            //#line 134 "/home/dsl/workspace/plhamK/plham/Market.x10"
            final long numMarkets = t$20823;
            
            //#line 135 "/home/dsl/workspace/plhamK/plham/Market.x10"
            final x10.util.ArrayList t$20824 = ((x10.util.ArrayList)(new x10.util.ArrayList<plham.Market>((java.lang.System[]) null, plham.Market.$RTT).x10$util$ArrayList$$init$S(((long)(numMarkets)))));
            
            //#line 135 "/home/dsl/workspace/plhamK/plham/Market.x10"
            final x10.util.List markets = ((x10.util.List<plham.Market>)
                                            t$20824);
            
            //#line 136 "/home/dsl/workspace/plhamK/plham/Market.x10"
            final plham.Market t$20825 = ((plham.Market)(new plham.Market((java.lang.System[]) null).plham$Market$$init$S(((long)(id)), ((java.lang.String)(name)), ((x10.util.Random)(random)))));
            
            //#line 136 "/home/dsl/workspace/plhamK/plham/Market.x10"
            final plham.Market t$20826 = t$20825.setup(((cassia.util.JSON.Value)(json)), ((plham.main.Simulator)(this.sim)));
            
            //#line 136 "/home/dsl/workspace/plhamK/plham/Market.x10"
            ((x10.util.Collection<plham.Market>)markets).add$Z(((plham.Market)(t$20826)), plham.Market.$RTT);
            
            //#line 137 "/home/dsl/workspace/plhamK/plham/Market.x10"
            final x10.util.Map t$20828 = ((x10.util.Map)(this.sim.GLOBAL));
            
            //#line 137 "/home/dsl/workspace/plhamK/plham/Market.x10"
            final plham.Market t$20827 = ((x10.util.Indexed<plham.Market>)markets).$apply$G((long)(0L));
            
            //#line 137 "/home/dsl/workspace/plhamK/plham/Market.x10"
            final java.lang.String t$20829 = ((java.lang.String)(t$20827.name));
            
            //#line 137 "/home/dsl/workspace/plhamK/plham/Market.x10"
            final java.lang.Object t$20830 = ((java.lang.Object)
                                               markets);
            
            //#line 137 "/home/dsl/workspace/plhamK/plham/Market.x10"
            ((x10.util.Map<java.lang.String, java.lang.Object>)t$20828).$set(((java.lang.String)(t$20829)), x10.rtt.Types.STRING, ((java.lang.Object)(t$20830)), x10.rtt.Types.ANY);
            
            //#line 139 "/home/dsl/workspace/plhamK/plham/Market.x10"
            final x10.util.ArrayList r = ((x10.util.ArrayList)(new x10.util.ArrayList<x10.lang.LongRange>((java.lang.System[]) null, x10.lang.LongRange.$RTT).x10$util$ArrayList$$init$S()));
            
            //#line 139 "/home/dsl/workspace/plhamK/plham/Market.x10"
            final x10.lang.LongRange t$20831 = ((x10.lang.LongRange)(new x10.lang.LongRange((java.lang.System[]) null).x10$lang$LongRange$$init$S(((long)(id)), ((long)(id)))));
            
            //#line 139 "/home/dsl/workspace/plhamK/plham/Market.x10"
            ((x10.util.ArrayList<x10.lang.LongRange>)r).add__0x10$util$ArrayList$$T$O(((x10.lang.LongRange)(t$20831)));
            
            //#line 140 "/home/dsl/workspace/plhamK/plham/Market.x10"
            final x10.util.Map t$20832 = ((x10.util.Map)(this.sim.marketName2Ranges));
            
            //#line 140 "/home/dsl/workspace/plhamK/plham/Market.x10"
            ((x10.util.Map<java.lang.String, x10.util.List<x10.lang.LongRange>>)t$20832).$set(((java.lang.String)(name)), x10.rtt.Types.STRING, ((x10.util.List)(r)), x10.rtt.ParameterizedType.make(x10.util.List.$RTT, x10.lang.LongRange.$RTT));
            
            //#line 141 "/home/dsl/workspace/plhamK/plham/Market.x10"
            return markets;
        }
        
        public plham.main.Simulator sim;
        
        public $Closure$0(final plham.main.Simulator sim) {
             {
                this.sim = ((plham.main.Simulator)(sim));
            }
        }
        
    }
    
    @x10.runtime.impl.java.X10Generated
    final public static class $Closure$1 extends x10.core.Ref implements x10.core.fun.Fun_0_1, x10.serialization.X10JavaSerializable
    {
        public static final x10.rtt.RuntimeType<$Closure$1> $RTT = 
            x10.rtt.StaticFunType.<$Closure$1> make($Closure$1.class,
                                                    new x10.rtt.Type[] {
                                                        x10.rtt.ParameterizedType.make(x10.core.fun.Fun_0_1.$RTT, plham.Order.$RTT, x10.rtt.Types.BOOLEAN)
                                                    });
        
        public x10.rtt.RuntimeType<?> $getRTT() { return $RTT; }
        
        public x10.rtt.Type<?> $getParam(int i) { return null; }
        
        private Object writeReplace() throws java.io.ObjectStreamException {
            return new x10.serialization.SerializationProxy(this);
        }
        
        public static x10.serialization.X10JavaSerializable $_deserialize_body(plham.Market.$Closure$1 $_obj, x10.serialization.X10JavaDeserializer $deserializer) throws java.io.IOException {
            if (x10.runtime.impl.java.Runtime.TRACE_SER) { x10.runtime.impl.java.Runtime.printTraceMessage("X10JavaSerializable: $_deserialize_body() of " + $Closure$1.class + " calling"); } 
            $_obj.out$$ = $deserializer.readObject();
            return $_obj;
        }
        
        public static x10.serialization.X10JavaSerializable $_deserializer(x10.serialization.X10JavaDeserializer $deserializer) throws java.io.IOException {
            plham.Market.$Closure$1 $_obj = new plham.Market.$Closure$1((java.lang.System[]) null);
            $deserializer.record_reference($_obj);
            return $_deserialize_body($_obj, $deserializer);
        }
        
        public void $_serialize(x10.serialization.X10JavaSerializer $serializer) throws java.io.IOException {
            $serializer.write(this.out$$);
            
        }
        
        // constructor just for allocation
        public $Closure$1(final java.lang.System[] $dummy) {
            
        }
        
        // dispatcher for method abstract public (Z1)=>U.operator()(a1:Z1):U
        public java.lang.Object $apply(final java.lang.Object a1, final x10.rtt.Type t1) {
            return x10.core.Boolean.$box($apply$O((plham.Order)a1));
            
        }
        
        // dispatcher for method abstract public (Z1)=>U.operator()(a1:Z1):U
        public boolean $apply$Z(final java.lang.Object a1, final x10.rtt.Type t1) {
            return $apply$O((plham.Order)a1);
            
        }
        
        
    
        
        public boolean $apply$O(final plham.Order order) {
            
            //#line 328 "/home/dsl/workspace/plhamK/plham/Market.x10"
            final boolean t$20908 = order.isExpired$O(((plham.Market)(this.out$$)));
            
            //#line 328 "/home/dsl/workspace/plhamK/plham/Market.x10"
            return t$20908;
        }
        
        public plham.Market out$$;
        
        public $Closure$1(final plham.Market out$$) {
             {
                this.out$$ = out$$;
            }
        }
        
    }
    
    @x10.runtime.impl.java.X10Generated
    final public static class $Closure$2 extends x10.core.Ref implements x10.core.fun.Fun_0_1, x10.serialization.X10JavaSerializable
    {
        public static final x10.rtt.RuntimeType<$Closure$2> $RTT = 
            x10.rtt.StaticFunType.<$Closure$2> make($Closure$2.class,
                                                    new x10.rtt.Type[] {
                                                        x10.rtt.ParameterizedType.make(x10.core.fun.Fun_0_1.$RTT, plham.Order.$RTT, x10.rtt.Types.BOOLEAN)
                                                    });
        
        public x10.rtt.RuntimeType<?> $getRTT() { return $RTT; }
        
        public x10.rtt.Type<?> $getParam(int i) { return null; }
        
        private Object writeReplace() throws java.io.ObjectStreamException {
            return new x10.serialization.SerializationProxy(this);
        }
        
        public static x10.serialization.X10JavaSerializable $_deserialize_body(plham.Market.$Closure$2 $_obj, x10.serialization.X10JavaDeserializer $deserializer) throws java.io.IOException {
            if (x10.runtime.impl.java.Runtime.TRACE_SER) { x10.runtime.impl.java.Runtime.printTraceMessage("X10JavaSerializable: $_deserialize_body() of " + $Closure$2.class + " calling"); } 
            return $_obj;
        }
        
        public static x10.serialization.X10JavaSerializable $_deserializer(x10.serialization.X10JavaDeserializer $deserializer) throws java.io.IOException {
            plham.Market.$Closure$2 $_obj = new plham.Market.$Closure$2((java.lang.System[]) null);
            $deserializer.record_reference($_obj);
            return $_deserialize_body($_obj, $deserializer);
        }
        
        public void $_serialize(x10.serialization.X10JavaSerializer $serializer) throws java.io.IOException {
            
        }
        
        // constructor just for allocation
        public $Closure$2(final java.lang.System[] $dummy) {
            
        }
        
        // dispatcher for method abstract public (Z1)=>U.operator()(a1:Z1):U
        public java.lang.Object $apply(final java.lang.Object a1, final x10.rtt.Type t1) {
            return x10.core.Boolean.$box($apply$O((plham.Order)a1));
            
        }
        
        // dispatcher for method abstract public (Z1)=>U.operator()(a1:Z1):U
        public boolean $apply$Z(final java.lang.Object a1, final x10.rtt.Type t1) {
            return $apply$O((plham.Order)a1);
            
        }
        
        
    
        
        public boolean $apply$O(final plham.Order order) {
            
            //#line 329 "/home/dsl/workspace/plhamK/plham/Market.x10"
            final long t$20909 = order.getVolume$O();
            
            //#line 329 "/home/dsl/workspace/plhamK/plham/Market.x10"
            final boolean t$20910 = ((t$20909) <= (((long)(0L))));
            
            //#line 329 "/home/dsl/workspace/plhamK/plham/Market.x10"
            return t$20910;
        }
        
        public $Closure$2() {
             {
                
            }
        }
        
    }
    
    @x10.runtime.impl.java.X10Generated
    final public static class $Closure$3 extends x10.core.Ref implements x10.core.fun.Fun_0_1, x10.serialization.X10JavaSerializable
    {
        public static final x10.rtt.RuntimeType<$Closure$3> $RTT = 
            x10.rtt.StaticFunType.<$Closure$3> make($Closure$3.class,
                                                    new x10.rtt.Type[] {
                                                        x10.rtt.ParameterizedType.make(x10.core.fun.Fun_0_1.$RTT, plham.Order.$RTT, x10.rtt.Types.BOOLEAN)
                                                    });
        
        public x10.rtt.RuntimeType<?> $getRTT() { return $RTT; }
        
        public x10.rtt.Type<?> $getParam(int i) { return null; }
        
        private Object writeReplace() throws java.io.ObjectStreamException {
            return new x10.serialization.SerializationProxy(this);
        }
        
        public static x10.serialization.X10JavaSerializable $_deserialize_body(plham.Market.$Closure$3 $_obj, x10.serialization.X10JavaDeserializer $deserializer) throws java.io.IOException {
            if (x10.runtime.impl.java.Runtime.TRACE_SER) { x10.runtime.impl.java.Runtime.printTraceMessage("X10JavaSerializable: $_deserialize_body() of " + $Closure$3.class + " calling"); } 
            $_obj.isExpired = $deserializer.readObject();
            $_obj.isNoVolume = $deserializer.readObject();
            return $_obj;
        }
        
        public static x10.serialization.X10JavaSerializable $_deserializer(x10.serialization.X10JavaDeserializer $deserializer) throws java.io.IOException {
            plham.Market.$Closure$3 $_obj = new plham.Market.$Closure$3((java.lang.System[]) null);
            $deserializer.record_reference($_obj);
            return $_deserialize_body($_obj, $deserializer);
        }
        
        public void $_serialize(x10.serialization.X10JavaSerializer $serializer) throws java.io.IOException {
            $serializer.write(this.isExpired);
            $serializer.write(this.isNoVolume);
            
        }
        
        // constructor just for allocation
        public $Closure$3(final java.lang.System[] $dummy) {
            
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
        public static final class __0$1plham$Order$3x10$lang$Boolean$2__1$1plham$Order$3x10$lang$Boolean$2 {}
        
    
        
        public boolean $apply$O(final plham.Order order) {
            
            //#line 330 "/home/dsl/workspace/plhamK/plham/Market.x10"
            boolean t$20911 = x10.core.Boolean.$unbox(((x10.core.fun.Fun_0_1<plham.Order,x10.core.Boolean>)this.isExpired).$apply(order, plham.Order.$RTT));
            
            //#line 330 "/home/dsl/workspace/plhamK/plham/Market.x10"
            if (!(t$20911)) {
                
                //#line 330 "/home/dsl/workspace/plhamK/plham/Market.x10"
                t$20911 = x10.core.Boolean.$unbox(((x10.core.fun.Fun_0_1<plham.Order,x10.core.Boolean>)this.isNoVolume).$apply(order, plham.Order.$RTT));
            }
            
            //#line 330 "/home/dsl/workspace/plhamK/plham/Market.x10"
            final boolean t$20912 = t$20911;
            
            //#line 330 "/home/dsl/workspace/plhamK/plham/Market.x10"
            return t$20912;
        }
        
        public x10.core.fun.Fun_0_1<plham.Order,x10.core.Boolean> isExpired;
        public x10.core.fun.Fun_0_1<plham.Order,x10.core.Boolean> isNoVolume;
        
        public $Closure$3(final x10.core.fun.Fun_0_1<plham.Order,x10.core.Boolean> isExpired, final x10.core.fun.Fun_0_1<plham.Order,x10.core.Boolean> isNoVolume, __0$1plham$Order$3x10$lang$Boolean$2__1$1plham$Order$3x10$lang$Boolean$2 $dummy) {
             {
                this.isExpired = ((x10.core.fun.Fun_0_1)(isExpired));
                this.isNoVolume = ((x10.core.fun.Fun_0_1)(isNoVolume));
            }
        }
        
    }
    
    @x10.runtime.impl.java.X10Generated
    final public static class $Closure$4 extends x10.core.Ref implements x10.core.fun.Fun_0_1, x10.serialization.X10JavaSerializable
    {
        public static final x10.rtt.RuntimeType<$Closure$4> $RTT = 
            x10.rtt.StaticFunType.<$Closure$4> make($Closure$4.class,
                                                    new x10.rtt.Type[] {
                                                        x10.rtt.ParameterizedType.make(x10.core.fun.Fun_0_1.$RTT, plham.Order.$RTT, x10.rtt.Types.BOOLEAN)
                                                    });
        
        public x10.rtt.RuntimeType<?> $getRTT() { return $RTT; }
        
        public x10.rtt.Type<?> $getParam(int i) { return null; }
        
        private Object writeReplace() throws java.io.ObjectStreamException {
            return new x10.serialization.SerializationProxy(this);
        }
        
        public static x10.serialization.X10JavaSerializable $_deserialize_body(plham.Market.$Closure$4 $_obj, x10.serialization.X10JavaDeserializer $deserializer) throws java.io.IOException {
            if (x10.runtime.impl.java.Runtime.TRACE_SER) { x10.runtime.impl.java.Runtime.printTraceMessage("X10JavaSerializable: $_deserialize_body() of " + $Closure$4.class + " calling"); } 
            $_obj.isExpired = $deserializer.readObject();
            $_obj.isNoVolume = $deserializer.readObject();
            return $_obj;
        }
        
        public static x10.serialization.X10JavaSerializable $_deserializer(x10.serialization.X10JavaDeserializer $deserializer) throws java.io.IOException {
            plham.Market.$Closure$4 $_obj = new plham.Market.$Closure$4((java.lang.System[]) null);
            $deserializer.record_reference($_obj);
            return $_deserialize_body($_obj, $deserializer);
        }
        
        public void $_serialize(x10.serialization.X10JavaSerializer $serializer) throws java.io.IOException {
            $serializer.write(this.isExpired);
            $serializer.write(this.isNoVolume);
            
        }
        
        // constructor just for allocation
        public $Closure$4(final java.lang.System[] $dummy) {
            
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
        public static final class __0$1plham$Order$3x10$lang$Boolean$2__1$1plham$Order$3x10$lang$Boolean$2 {}
        
    
        
        public boolean $apply$O(final plham.Order order) {
            
            //#line 331 "/home/dsl/workspace/plhamK/plham/Market.x10"
            boolean t$20915 = x10.core.Boolean.$unbox(((x10.core.fun.Fun_0_1<plham.Order,x10.core.Boolean>)this.isExpired).$apply(order, plham.Order.$RTT));
            
            //#line 331 "/home/dsl/workspace/plhamK/plham/Market.x10"
            if (!(t$20915)) {
                
                //#line 331 "/home/dsl/workspace/plhamK/plham/Market.x10"
                t$20915 = x10.core.Boolean.$unbox(((x10.core.fun.Fun_0_1<plham.Order,x10.core.Boolean>)this.isNoVolume).$apply(order, plham.Order.$RTT));
            }
            
            //#line 331 "/home/dsl/workspace/plhamK/plham/Market.x10"
            final boolean t$20916 = t$20915;
            
            //#line 331 "/home/dsl/workspace/plhamK/plham/Market.x10"
            return t$20916;
        }
        
        public x10.core.fun.Fun_0_1<plham.Order,x10.core.Boolean> isExpired;
        public x10.core.fun.Fun_0_1<plham.Order,x10.core.Boolean> isNoVolume;
        
        public $Closure$4(final x10.core.fun.Fun_0_1<plham.Order,x10.core.Boolean> isExpired, final x10.core.fun.Fun_0_1<plham.Order,x10.core.Boolean> isNoVolume, __0$1plham$Order$3x10$lang$Boolean$2__1$1plham$Order$3x10$lang$Boolean$2 $dummy) {
             {
                this.isExpired = ((x10.core.fun.Fun_0_1)(isExpired));
                this.isNoVolume = ((x10.core.fun.Fun_0_1)(isNoVolume));
            }
        }
        
    }
    
    @x10.runtime.impl.java.X10Generated
    final public static class $Closure$5 extends x10.core.Ref implements x10.core.fun.Fun_0_2, x10.serialization.X10JavaSerializable
    {
        public static final x10.rtt.RuntimeType<$Closure$5> $RTT = 
            x10.rtt.StaticFunType.<$Closure$5> make($Closure$5.class,
                                                    new x10.rtt.Type[] {
                                                        x10.rtt.ParameterizedType.make(x10.core.fun.Fun_0_2.$RTT, x10.rtt.Types.DOUBLE, x10.rtt.Types.DOUBLE, x10.rtt.Types.DOUBLE)
                                                    });
        
        public x10.rtt.RuntimeType<?> $getRTT() { return $RTT; }
        
        public x10.rtt.Type<?> $getParam(int i) { return null; }
        
        private Object writeReplace() throws java.io.ObjectStreamException {
            return new x10.serialization.SerializationProxy(this);
        }
        
        public static x10.serialization.X10JavaSerializable $_deserialize_body(plham.Market.$Closure$5 $_obj, x10.serialization.X10JavaDeserializer $deserializer) throws java.io.IOException {
            if (x10.runtime.impl.java.Runtime.TRACE_SER) { x10.runtime.impl.java.Runtime.printTraceMessage("X10JavaSerializable: $_deserialize_body() of " + $Closure$5.class + " calling"); } 
            return $_obj;
        }
        
        public static x10.serialization.X10JavaSerializable $_deserializer(x10.serialization.X10JavaDeserializer $deserializer) throws java.io.IOException {
            plham.Market.$Closure$5 $_obj = new plham.Market.$Closure$5((java.lang.System[]) null);
            $deserializer.record_reference($_obj);
            return $_deserialize_body($_obj, $deserializer);
        }
        
        public void $_serialize(x10.serialization.X10JavaSerializer $serializer) throws java.io.IOException {
            
        }
        
        // constructor just for allocation
        public $Closure$5(final java.lang.System[] $dummy) {
            
        }
        
        // dispatcher for method abstract public (Z1,Z2)=>U.operator()(a1:Z1, a2:Z2):U
        public java.lang.Object $apply(final java.lang.Object a1, final x10.rtt.Type t1, final java.lang.Object a2, final x10.rtt.Type t2) {
            return x10.core.Double.$box($apply$O(x10.core.Double.$unbox(a1), x10.core.Double.$unbox(a2)));
            
        }
        
        // dispatcher for method abstract public (Z1,Z2)=>U.operator()(a1:Z1, a2:Z2):U
        public double $apply$D(final java.lang.Object a1, final x10.rtt.Type t1, final java.lang.Object a2, final x10.rtt.Type t2) {
            return $apply$O(x10.core.Double.$unbox(a1), x10.core.Double.$unbox(a2));
            
        }
        
        
    
        
        public double $apply$O(final double price, final double tickSize) {
            
            //#line 59 "/home/dsl/workspace/plhamK/plham/Market.x10"
            return ((java.lang.Math.ceil(((double)(((price) / (((double)(tickSize)))))))) * (((double)(tickSize))));
        }
        
        public $Closure$5() {
             {
                
            }
        }
        
    }
    
    @x10.runtime.impl.java.X10Generated
    final public static class $Closure$6 extends x10.core.Ref implements x10.core.fun.Fun_0_2, x10.serialization.X10JavaSerializable
    {
        public static final x10.rtt.RuntimeType<$Closure$6> $RTT = 
            x10.rtt.StaticFunType.<$Closure$6> make($Closure$6.class,
                                                    new x10.rtt.Type[] {
                                                        x10.rtt.ParameterizedType.make(x10.core.fun.Fun_0_2.$RTT, x10.rtt.Types.DOUBLE, x10.rtt.Types.DOUBLE, x10.rtt.Types.DOUBLE)
                                                    });
        
        public x10.rtt.RuntimeType<?> $getRTT() { return $RTT; }
        
        public x10.rtt.Type<?> $getParam(int i) { return null; }
        
        private Object writeReplace() throws java.io.ObjectStreamException {
            return new x10.serialization.SerializationProxy(this);
        }
        
        public static x10.serialization.X10JavaSerializable $_deserialize_body(plham.Market.$Closure$6 $_obj, x10.serialization.X10JavaDeserializer $deserializer) throws java.io.IOException {
            if (x10.runtime.impl.java.Runtime.TRACE_SER) { x10.runtime.impl.java.Runtime.printTraceMessage("X10JavaSerializable: $_deserialize_body() of " + $Closure$6.class + " calling"); } 
            return $_obj;
        }
        
        public static x10.serialization.X10JavaSerializable $_deserializer(x10.serialization.X10JavaDeserializer $deserializer) throws java.io.IOException {
            plham.Market.$Closure$6 $_obj = new plham.Market.$Closure$6((java.lang.System[]) null);
            $deserializer.record_reference($_obj);
            return $_deserialize_body($_obj, $deserializer);
        }
        
        public void $_serialize(x10.serialization.X10JavaSerializer $serializer) throws java.io.IOException {
            
        }
        
        // constructor just for allocation
        public $Closure$6(final java.lang.System[] $dummy) {
            
        }
        
        // dispatcher for method abstract public (Z1,Z2)=>U.operator()(a1:Z1, a2:Z2):U
        public java.lang.Object $apply(final java.lang.Object a1, final x10.rtt.Type t1, final java.lang.Object a2, final x10.rtt.Type t2) {
            return x10.core.Double.$box($apply$O(x10.core.Double.$unbox(a1), x10.core.Double.$unbox(a2)));
            
        }
        
        // dispatcher for method abstract public (Z1,Z2)=>U.operator()(a1:Z1, a2:Z2):U
        public double $apply$D(final java.lang.Object a1, final x10.rtt.Type t1, final java.lang.Object a2, final x10.rtt.Type t2) {
            return $apply$O(x10.core.Double.$unbox(a1), x10.core.Double.$unbox(a2));
            
        }
        
        
    
        
        public double $apply$O(final double price, final double tickSize) {
            
            //#line 60 "/home/dsl/workspace/plhamK/plham/Market.x10"
            return ((java.lang.Math.floor(((double)(((price) / (((double)(tickSize)))))))) * (((double)(tickSize))));
        }
        
        public $Closure$6() {
             {
                
            }
        }
        
    }
    
}

