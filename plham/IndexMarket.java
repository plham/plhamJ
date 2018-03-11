package plham;


/**
 * A class for markets (assets) associated with some underlying markets (assets).
 *
 * <p><ul>
 * <li> Call <code>addMarkets(List[Market])</code> to add underlying components.
 * </ul>  
 */

public class IndexMarket extends plham.Market implements x10.serialization.X10JavaSerializable
{
    public static final x10.rtt.RuntimeType<IndexMarket> $RTT = 
        x10.rtt.NamedType.<IndexMarket> make("plham.IndexMarket",
                                             IndexMarket.class,
                                             new x10.rtt.Type[] {
                                                 plham.Market.$RTT
                                             });
    
    public x10.rtt.RuntimeType<?> $getRTT() { return $RTT; }
    
    public x10.rtt.Type<?> $getParam(int i) { return null; }
    
    private Object writeReplace() throws java.io.ObjectStreamException {
        return new x10.serialization.SerializationProxy(this);
    }
    
    public static x10.serialization.X10JavaSerializable $_deserialize_body(plham.IndexMarket $_obj, x10.serialization.X10JavaDeserializer $deserializer) throws java.io.IOException {
        if (x10.runtime.impl.java.Runtime.TRACE_SER) { x10.runtime.impl.java.Runtime.printTraceMessage("X10JavaSerializable: $_deserialize_body() of " + IndexMarket.class + " calling"); } 
        plham.Market.$_deserialize_body($_obj, $deserializer);
        $_obj.components = $deserializer.readObject();
        return $_obj;
    }
    
    public static x10.serialization.X10JavaSerializable $_deserializer(x10.serialization.X10JavaDeserializer $deserializer) throws java.io.IOException {
        plham.IndexMarket $_obj = new plham.IndexMarket((java.lang.System[]) null);
        $deserializer.record_reference($_obj);
        return $_deserialize_body($_obj, $deserializer);
    }
    
    public void $_serialize(x10.serialization.X10JavaSerializer $serializer) throws java.io.IOException {
        super.$_serialize($serializer);
        $serializer.write(this.components);
        
    }
    
    // constructor just for allocation
    public IndexMarket(final java.lang.System[] $dummy) {
        super($dummy);
        
    }
    
    

    
    //#line 21 "/home/dsl/workspace/plhamK/plham/IndexMarket.x10"
    /** The list of its underlying markets by their ids. */
    public x10.util.List<x10.core.Long> components;
    
    
    //#line 23 "/home/dsl/workspace/plhamK/plham/IndexMarket.x10"
    // creation method for java code (1-phase java constructor)
    public IndexMarket(final long id, final java.lang.String name, final x10.util.Random random) {
        this((java.lang.System[]) null);
        plham$IndexMarket$$init$S(id, name, random);
    }
    
    // constructor for non-virtual call
    final public plham.IndexMarket plham$IndexMarket$$init$S(final long id, final java.lang.String name, final x10.util.Random random) {
         {
            
            //#line 24 "/home/dsl/workspace/plhamK/plham/IndexMarket.x10"
            /*super.*/plham$Market$$init$S(((id)), ((name)), ((random)));
            
            //#line 23 "/home/dsl/workspace/plhamK/plham/IndexMarket.x10"
            
            
            //#line 18 "/home/dsl/workspace/plhamK/plham/IndexMarket.x10"
            this.__fieldInitializers_plham_IndexMarket();
            
            //#line 25 "/home/dsl/workspace/plhamK/plham/IndexMarket.x10"
            final x10.util.ArrayList t$32651 = ((new x10.util.ArrayList<x10.core.Long>((java.lang.System[]) null, x10.rtt.Types.LONG).x10$util$ArrayList$$init$S()));
            
            //#line 25 "/home/dsl/workspace/plhamK/plham/IndexMarket.x10"
            this.components = ((t$32651));
        }
        return this;
    }
    
    
    
    //#line 27 "/home/dsl/workspace/plhamK/plham/IndexMarket.x10"
    // creation method for java code (1-phase java constructor)
    public IndexMarket() {
        this((java.lang.System[]) null);
        plham$IndexMarket$$init$S();
    }
    
    // constructor for non-virtual call
    final public plham.IndexMarket plham$IndexMarket$$init$S() {
         {
            
            //#line 28 "/home/dsl/workspace/plhamK/plham/IndexMarket.x10"
            final x10.util.Random t$32652 = ((new x10.util.Random((java.lang.System[]) null).x10$util$Random$$init$S()));
            
            //#line 28 "/home/dsl/workspace/plhamK/plham/IndexMarket.x10"
            /*this.*/plham$IndexMarket$$init$S(((-1L)), (("default")), ((t$32652)));
        }
        return this;
    }
    
    
    
    //#line 31 "/home/dsl/workspace/plhamK/plham/IndexMarket.x10"
    public void addMarket(final plham.Market market) {
        
        //#line 32 "/home/dsl/workspace/plhamK/plham/IndexMarket.x10"
        assert !(x10.core.Boolean.$unbox(((x10.util.Container<x10.core.Long>)this.components).contains$Z(x10.core.Long.$box(market.id), x10.rtt.Types.LONG)));
        
        //#line 33 "/home/dsl/workspace/plhamK/plham/IndexMarket.x10"
        final x10.util.List t$32653 = ((this.components));
        
        //#line 33 "/home/dsl/workspace/plhamK/plham/IndexMarket.x10"
        final long t$32654 = market.id;
        
        //#line 33 "/home/dsl/workspace/plhamK/plham/IndexMarket.x10"
        ((x10.util.Collection<x10.core.Long>)t$32653).add$Z(x10.core.Long.$box(t$32654), x10.rtt.Types.LONG);
    }
    
    
    //#line 36 "/home/dsl/workspace/plhamK/plham/IndexMarket.x10"
    public void addMarkets__0$1plham$Market$2(final x10.util.Container markets) {
        
        //#line 37 "/home/dsl/workspace/plhamK/plham/IndexMarket.x10"
        final x10.lang.Iterator m$32642 = (((x10.lang.Iterable<plham.Market>)markets).iterator());
        
        //#line 37 "/home/dsl/workspace/plhamK/plham/IndexMarket.x10"
        for (;
             true;
             ) {
            
            //#line 37 "/home/dsl/workspace/plhamK/plham/IndexMarket.x10"
            final boolean t$32656 = ((x10.lang.Iterator<plham.Market>)m$32642).hasNext$O();
            
            //#line 37 "/home/dsl/workspace/plhamK/plham/IndexMarket.x10"
            if (!(t$32656)) {
                
                //#line 37 "/home/dsl/workspace/plhamK/plham/IndexMarket.x10"
                break;
            }
            
            //#line 37 "/home/dsl/workspace/plhamK/plham/IndexMarket.x10"
            final plham.Market m$32791 = ((((x10.lang.Iterator<plham.Market>)m$32642).next$G()));
            
            //#line 38 "/home/dsl/workspace/plhamK/plham/IndexMarket.x10"
            this.addMarket(((m$32791)));
        }
    }
    
    
    //#line 46 "/home/dsl/workspace/plhamK/plham/IndexMarket.x10"
    /**
	 * Get a list of market ids, the components of the index.
	 * It can be helpful before setting market's <code>env</code> field.
	 */
    public x10.util.List getComponents() {
        
        //#line 46 "/home/dsl/workspace/plhamK/plham/IndexMarket.x10"
        final x10.util.List t$32657 = ((this.components));
        
        //#line 46 "/home/dsl/workspace/plhamK/plham/IndexMarket.x10"
        return t$32657;
    }
    
    
    //#line 52 "/home/dsl/workspace/plhamK/plham/IndexMarket.x10"
    /**
	 * Get a list of markets.
	 * It can be available after setting its <code>env</code> field.
	 */
    public x10.util.List getMarkets() {
        
        //#line 53 "/home/dsl/workspace/plhamK/plham/IndexMarket.x10"
        assert ((this.env) != (null)): "Cannot call during the setup procedure";
        
        //#line 54 "/home/dsl/workspace/plhamK/plham/IndexMarket.x10"
        final x10.util.ArrayList m = ((new x10.util.ArrayList<plham.Market>((java.lang.System[]) null, plham.Market.$RTT).x10$util$ArrayList$$init$S()));
        
        //#line 55 "/home/dsl/workspace/plhamK/plham/IndexMarket.x10"
        final x10.util.List t$32796 = ((this.components));
        
        //#line 55 "/home/dsl/workspace/plhamK/plham/IndexMarket.x10"
        final x10.util.ListIterator id$32797 = (((x10.util.List<x10.core.Long>)t$32796).iterator());
        
        //#line 55 "/home/dsl/workspace/plhamK/plham/IndexMarket.x10"
        for (;
             true;
             ) {
            
            //#line 55 "/home/dsl/workspace/plhamK/plham/IndexMarket.x10"
            final boolean t$32798 = ((x10.util.ListIterator<x10.core.Long>)id$32797).hasNext$O();
            
            //#line 55 "/home/dsl/workspace/plhamK/plham/IndexMarket.x10"
            if (!(t$32798)) {
                
                //#line 55 "/home/dsl/workspace/plhamK/plham/IndexMarket.x10"
                break;
            }
            
            //#line 55 "/home/dsl/workspace/plhamK/plham/IndexMarket.x10"
            final long id$32792 = x10.core.Long.$unbox(((x10.util.ListIterator<x10.core.Long>)id$32797).next$G());
            
            //#line 56 "/home/dsl/workspace/plhamK/plham/IndexMarket.x10"
            final plham.Env t$32793 = ((this.env));
            
            //#line 56 "/home/dsl/workspace/plhamK/plham/IndexMarket.x10"
            final x10.util.List t$32794 = ((t$32793.markets));
            
            //#line 56 "/home/dsl/workspace/plhamK/plham/IndexMarket.x10"
            final plham.Market t$32795 = ((x10.util.Indexed<plham.Market>)t$32794).$apply$G((id$32792));
            
            //#line 56 "/home/dsl/workspace/plhamK/plham/IndexMarket.x10"
            ((x10.util.ArrayList<plham.Market>)m).add__0x10$util$ArrayList$$T$O(((t$32795)));
        }
        
        //#line 58 "/home/dsl/workspace/plhamK/plham/IndexMarket.x10"
        return m;
    }
    
    
    //#line 61 "/home/dsl/workspace/plhamK/plham/IndexMarket.x10"
    public boolean isAllMarketsRunning$O() {
        
        //#line 62 "/home/dsl/workspace/plhamK/plham/IndexMarket.x10"
        assert ((this.env) != (null)): "Cannot call during the setup procedure";
        
        //#line 63 "/home/dsl/workspace/plhamK/plham/IndexMarket.x10"
        final x10.util.List t$32805 = ((this.components));
        
        //#line 63 "/home/dsl/workspace/plhamK/plham/IndexMarket.x10"
        final x10.util.ListIterator id$32806 = (((x10.util.List<x10.core.Long>)t$32805).iterator());
        
        //#line 63 "/home/dsl/workspace/plhamK/plham/IndexMarket.x10"
        for (;
             true;
             ) {
            
            //#line 63 "/home/dsl/workspace/plhamK/plham/IndexMarket.x10"
            final boolean t$32807 = ((x10.util.ListIterator<x10.core.Long>)id$32806).hasNext$O();
            
            //#line 63 "/home/dsl/workspace/plhamK/plham/IndexMarket.x10"
            if (!(t$32807)) {
                
                //#line 63 "/home/dsl/workspace/plhamK/plham/IndexMarket.x10"
                break;
            }
            
            //#line 63 "/home/dsl/workspace/plhamK/plham/IndexMarket.x10"
            final long id$32799 = x10.core.Long.$unbox(((x10.util.ListIterator<x10.core.Long>)id$32806).next$G());
            
            //#line 64 "/home/dsl/workspace/plhamK/plham/IndexMarket.x10"
            final plham.Env t$32800 = ((this.env));
            
            //#line 64 "/home/dsl/workspace/plhamK/plham/IndexMarket.x10"
            final x10.util.List t$32801 = ((t$32800.markets));
            
            //#line 64 "/home/dsl/workspace/plhamK/plham/IndexMarket.x10"
            final plham.Market t$32802 = ((x10.util.Indexed<plham.Market>)t$32801).$apply$G((id$32799));
            
            //#line 64 "/home/dsl/workspace/plhamK/plham/IndexMarket.x10"
            final boolean t$32803 = t$32802.isRunning$O();
            
            //#line 64 "/home/dsl/workspace/plhamK/plham/IndexMarket.x10"
            final boolean t$32804 = !(t$32803);
            
            //#line 64 "/home/dsl/workspace/plhamK/plham/IndexMarket.x10"
            if (t$32804) {
                
                //#line 65 "/home/dsl/workspace/plhamK/plham/IndexMarket.x10"
                return false;
            }
        }
        
        //#line 68 "/home/dsl/workspace/plhamK/plham/IndexMarket.x10"
        final boolean t$32672 = this.isRunning$O();
        
        //#line 68 "/home/dsl/workspace/plhamK/plham/IndexMarket.x10"
        return t$32672;
    }
    
    
    //#line 72 "/home/dsl/workspace/plhamK/plham/IndexMarket.x10"
    public void check() {
        
        //#line 73 "/home/dsl/workspace/plhamK/plham/IndexMarket.x10"
        final long t = this.getTime$O();
        
        //#line 74 "/home/dsl/workspace/plhamK/plham/IndexMarket.x10"
        assert ((this.marketPrices.size$O()) - (((1L)))) == (t);
        
        //#line 76 "/home/dsl/workspace/plhamK/plham/IndexMarket.x10"
        assert ((((x10.util.Container<x10.core.Double>)this.lastExecutedPrices).size$O()) - (((1L)))) == (t);
        
        //#line 77 "/home/dsl/workspace/plhamK/plham/IndexMarket.x10"
        assert ((((x10.util.Container<x10.core.Long>)this.sumExecutedVolumes).size$O()) - (((1L)))) == (t);
        
        //#line 78 "/home/dsl/workspace/plhamK/plham/IndexMarket.x10"
        assert ((((x10.util.Container<x10.core.Long>)this.buyOrdersCounts).size$O()) - (((1L)))) == (t);
        
        //#line 79 "/home/dsl/workspace/plhamK/plham/IndexMarket.x10"
        assert ((((x10.util.Container<x10.core.Long>)this.sellOrdersCounts).size$O()) - (((1L)))) == (t);
        
        //#line 80 "/home/dsl/workspace/plhamK/plham/IndexMarket.x10"
        assert ((((x10.util.Container<x10.core.Long>)this.executedOrdersCounts).size$O()) - (((1L)))) == (t);
        
        //#line 81 "/home/dsl/workspace/plhamK/plham/IndexMarket.x10"
        assert ((((x10.util.Container<x10.util.List<plham.Market.ExecutionLog>>)this.executionLogs).size$O()) - (((1L)))) == (t);
        
        //#line 82 "/home/dsl/workspace/plhamK/plham/IndexMarket.x10"
        assert ((((x10.util.Container<x10.util.List<plham.Market.AgentUpdate>>)this.agentUpdates).size$O()) - (((1L)))) == (t);
        
        //#line 83 "/home/dsl/workspace/plhamK/plham/IndexMarket.x10"
        final x10.io.Printer t$32673 = ((x10.io.Console.get$OUT()));
        
        //#line 83 "/home/dsl/workspace/plhamK/plham/IndexMarket.x10"
        t$32673.println((("#MARKET CHECK PASSED")));
    }
    
    
    //#line 91 "/home/dsl/workspace/plhamK/plham/IndexMarket.x10"
    /**
	 * Get the latest market index value.
	 * Same as <code>getMarketIndex()</code>.
	 * @return the index value
	 */
    public double getIndex$O() {
        
        //#line 91 "/home/dsl/workspace/plhamK/plham/IndexMarket.x10"
        final double t$32674 = this.getMarketIndex$O();
        
        //#line 91 "/home/dsl/workspace/plhamK/plham/IndexMarket.x10"
        return t$32674;
    }
    
    
    //#line 99 "/home/dsl/workspace/plhamK/plham/IndexMarket.x10"
    /**
	 * Get the market index at time <code>t</code>.
	 * Same as <code>getMarketIndex(t)</code>.
	 * @param t
	 * @return the index value at time <code>t</code>
	 */
    public double getIndex$O(final long t) {
        
        //#line 99 "/home/dsl/workspace/plhamK/plham/IndexMarket.x10"
        final double t$32675 = this.getMarketIndex$O((t));
        
        //#line 99 "/home/dsl/workspace/plhamK/plham/IndexMarket.x10"
        return t$32675;
    }
    
    
    //#line 106 "/home/dsl/workspace/plhamK/plham/IndexMarket.x10"
    /**
	 * Get the latest market index value.
	 * Same as <code>getIndex()</code>.
	 * @return the index value
	 */
    public double getMarketIndex$O() {
        
        //#line 106 "/home/dsl/workspace/plhamK/plham/IndexMarket.x10"
        final long t$32676 = this.getTime$O();
        
        //#line 106 "/home/dsl/workspace/plhamK/plham/IndexMarket.x10"
        final double t$32677 = this.getMarketIndex$O((t$32676));
        
        //#line 106 "/home/dsl/workspace/plhamK/plham/IndexMarket.x10"
        return t$32677;
    }
    
    
    //#line 114 "/home/dsl/workspace/plhamK/plham/IndexMarket.x10"
    /**
	 * Get the market index at time <code>t</code>.
	 * Same as <code>getIndex(t)</code>.
	 * @param t
	 * @return the index value at time <code>t</code>
	 */
    public double getMarketIndex$O(final long t) {
        
        //#line 115 "/home/dsl/workspace/plhamK/plham/IndexMarket.x10"
        final double t$32678 = this.computeMarketIndex$O((t));
        
        //#line 115 "/home/dsl/workspace/plhamK/plham/IndexMarket.x10"
        return t$32678;
    }
    
    
    //#line 123 "/home/dsl/workspace/plhamK/plham/IndexMarket.x10"
    /**
	 * Returns the fundamental price of the index market.
	 * if the cache contains the fundamental price at the specified time, use the cache,
	 * otherwise calculates and returns the fundamental price and caches it.
	 */
    public double getFundamentalPrice(final long t) {
        
        //#line 124 "/home/dsl/workspace/plhamK/plham/IndexMarket.x10"
        final x10.util.ArrayList t$32679 = ((this.fundamentalPrices));
        
        //#line 124 "/home/dsl/workspace/plhamK/plham/IndexMarket.x10"
        final long t$32680 = ((x10.util.ArrayList<x10.core.Double>)t$32679).size$O();
        
        //#line 124 "/home/dsl/workspace/plhamK/plham/IndexMarket.x10"
        final boolean t$32684 = ((t$32680) <= (((t))));
        
        //#line 124 "/home/dsl/workspace/plhamK/plham/IndexMarket.x10"
        if (t$32684) {
            
            //#line 125 "/home/dsl/workspace/plhamK/plham/IndexMarket.x10"
            final x10.util.ArrayList t$32681 = ((this.fundamentalPrices));
            
            //#line 125 "/home/dsl/workspace/plhamK/plham/IndexMarket.x10"
            final long t$32682 = ((t) + (((1L))));
            
            //#line 125 "/home/dsl/workspace/plhamK/plham/IndexMarket.x10"
            final double t$32683 = java.lang.Double.NaN;
            
            //#line 125 "/home/dsl/workspace/plhamK/plham/IndexMarket.x10"
            ((x10.util.ArrayList<x10.core.Double>)t$32681).resize__1x10$util$ArrayList$$T((t$32682), x10.core.Double.$box(t$32683));
        }
        
        //#line 127 "/home/dsl/workspace/plhamK/plham/IndexMarket.x10"
        final x10.util.ArrayList t$32685 = ((this.fundamentalPrices));
        
        //#line 127 "/home/dsl/workspace/plhamK/plham/IndexMarket.x10"
        final double t$32686 = x10.core.Double.$unbox(((x10.util.ArrayList<x10.core.Double>)t$32685).$apply$G((t)));
        
        //#line 127 "/home/dsl/workspace/plhamK/plham/IndexMarket.x10"
        final boolean t$32689 = java.lang.Double.isNaN(t$32686);
        
        //#line 127 "/home/dsl/workspace/plhamK/plham/IndexMarket.x10"
        if (t$32689) {
            
            //#line 128 "/home/dsl/workspace/plhamK/plham/IndexMarket.x10"
            final x10.util.ArrayList t$32687 = ((this.fundamentalPrices));
            
            //#line 128 "/home/dsl/workspace/plhamK/plham/IndexMarket.x10"
            final double t$32688 = this.computeFundamentalIndex$O((t));
            
            //#line 128 "/home/dsl/workspace/plhamK/plham/IndexMarket.x10"
            ((x10.util.ArrayList<x10.core.Double>)t$32687).$set__1x10$util$ArrayList$$T$G((t), x10.core.Double.$box(t$32688));
        }
        
        //#line 130 "/home/dsl/workspace/plhamK/plham/IndexMarket.x10"
        final x10.util.ArrayList t$32690 = ((this.fundamentalPrices));
        
        //#line 130 "/home/dsl/workspace/plhamK/plham/IndexMarket.x10"
        final double t$32691 = x10.core.Double.$unbox(((x10.util.ArrayList<x10.core.Double>)t$32690).$apply$G((t)));
        
        //#line 130 "/home/dsl/workspace/plhamK/plham/IndexMarket.x10"
        return t$32691;
    }
    
    
    //#line 133 "/home/dsl/workspace/plhamK/plham/IndexMarket.x10"
    public double getFundamentalPrice() {
        
        //#line 133 "/home/dsl/workspace/plhamK/plham/IndexMarket.x10"
        final long t$32692 = this.getTime$O();
        
        //#line 133 "/home/dsl/workspace/plhamK/plham/IndexMarket.x10"
        final double t$32693 = this.getFundamentalPrice((t$32692));
        
        //#line 133 "/home/dsl/workspace/plhamK/plham/IndexMarket.x10"
        return t$32693;
    }
    
    
    //#line 139 "/home/dsl/workspace/plhamK/plham/IndexMarket.x10"
    /**
	 * Get the latest fundamental index value.
	 * @return the index value
	 */
    public double getFundamentalIndex$O() {
        
        //#line 139 "/home/dsl/workspace/plhamK/plham/IndexMarket.x10"
        final double t$32694 = this.getFundamentalPrice();
        
        //#line 139 "/home/dsl/workspace/plhamK/plham/IndexMarket.x10"
        return t$32694;
    }
    
    
    //#line 146 "/home/dsl/workspace/plhamK/plham/IndexMarket.x10"
    /**
	 * Get the fundamental index value at time <code>t</code>.
	 * @param t
	 * @return the index value at time <code>t</code>
	 */
    public double getFundamentalIndex$O(final long t) {
        
        //#line 146 "/home/dsl/workspace/plhamK/plham/IndexMarket.x10"
        final double t$32695 = this.getFundamentalPrice((t));
        
        //#line 146 "/home/dsl/workspace/plhamK/plham/IndexMarket.x10"
        return t$32695;
    }
    
    
    //#line 148 "/home/dsl/workspace/plhamK/plham/IndexMarket.x10"
    
    public static class WHICH_INDEX extends x10.core.Struct implements x10.serialization.X10JavaSerializable
    {
        public static final x10.rtt.RuntimeType<WHICH_INDEX> $RTT = 
            x10.rtt.NamedStructType.<WHICH_INDEX> make("plham.IndexMarket.WHICH_INDEX",
                                                       WHICH_INDEX.class,
                                                       new x10.rtt.Type[] {
                                                           x10.rtt.Types.STRUCT
                                                       });
        
        public x10.rtt.RuntimeType<?> $getRTT() { return $RTT; }
        
        public x10.rtt.Type<?> $getParam(int i) { return null; }
        
        private Object writeReplace() throws java.io.ObjectStreamException {
            return new x10.serialization.SerializationProxy(this);
        }
        
        public static x10.serialization.X10JavaSerializable $_deserialize_body(plham.IndexMarket.WHICH_INDEX $_obj, x10.serialization.X10JavaDeserializer $deserializer) throws java.io.IOException {
            if (x10.runtime.impl.java.Runtime.TRACE_SER) { x10.runtime.impl.java.Runtime.printTraceMessage("X10JavaSerializable: $_deserialize_body() of " + WHICH_INDEX.class + " calling"); } 
            $_obj.id = $deserializer.readLong();
            return $_obj;
        }
        
        public static x10.serialization.X10JavaSerializable $_deserializer(x10.serialization.X10JavaDeserializer $deserializer) throws java.io.IOException {
            plham.IndexMarket.WHICH_INDEX $_obj = new plham.IndexMarket.WHICH_INDEX((java.lang.System[]) null);
            return $_deserialize_body($_obj, $deserializer);
        }
        
        public void $_serialize(x10.serialization.X10JavaSerializer $serializer) throws java.io.IOException {
            $serializer.write(this.id);
            
        }
        
        // zero value constructor
        public WHICH_INDEX(final java.lang.System $dummy) { this.id = 0L; }
        
        // constructor just for allocation
        public WHICH_INDEX(final java.lang.System[] $dummy) {
            
        }
        
        
        // properties
        
        //#line 148 "/home/dsl/workspace/plhamK/plham/IndexMarket.x10"
        public long id;
        
    
        
        
        //#line 148 "/home/dsl/workspace/plhamK/plham/IndexMarket.x10"
        final public java.lang.String typeName() {
            try {
                return x10.rtt.Types.typeName(this);
            }
            catch (java.lang.Throwable exc$38112) {
                throw x10.runtime.impl.java.ThrowableUtils.ensureX10Exception(exc$38112);
            }
            
        }
        
        
        
        //#line 148 "/home/dsl/workspace/plhamK/plham/IndexMarket.x10"
        final public java.lang.String toString() {
            
            //#line 148 "/home/dsl/workspace/plhamK/plham/IndexMarket.x10"
            final java.lang.String t$32696 = "struct plham.IndexMarket.WHICH_INDEX: id=";
            
            //#line 148 "/home/dsl/workspace/plhamK/plham/IndexMarket.x10"
            final long t$32697 = this.id;
            
            //#line 148 "/home/dsl/workspace/plhamK/plham/IndexMarket.x10"
            final java.lang.String t$32698 = ((t$32696) + ((x10.core.Long.$box(t$32697))));
            
            //#line 148 "/home/dsl/workspace/plhamK/plham/IndexMarket.x10"
            return t$32698;
        }
        
        
        //#line 148 "/home/dsl/workspace/plhamK/plham/IndexMarket.x10"
        final public int hashCode() {
            
            //#line 148 "/home/dsl/workspace/plhamK/plham/IndexMarket.x10"
            int result = 1;
            
            //#line 148 "/home/dsl/workspace/plhamK/plham/IndexMarket.x10"
            final int t$32699 = result;
            
            //#line 148 "/home/dsl/workspace/plhamK/plham/IndexMarket.x10"
            final int t$32701 = ((8191) * (((t$32699))));
            
            //#line 148 "/home/dsl/workspace/plhamK/plham/IndexMarket.x10"
            final long t$32700 = this.id;
            
            //#line 148 "/home/dsl/workspace/plhamK/plham/IndexMarket.x10"
            final int t$32702 = x10.rtt.Types.hashCode(t$32700);
            
            //#line 148 "/home/dsl/workspace/plhamK/plham/IndexMarket.x10"
            final int t$32703 = ((t$32701) + (((t$32702))));
            
            //#line 148 "/home/dsl/workspace/plhamK/plham/IndexMarket.x10"
            result = t$32703;
            
            //#line 148 "/home/dsl/workspace/plhamK/plham/IndexMarket.x10"
            final int t$32704 = result;
            
            //#line 148 "/home/dsl/workspace/plhamK/plham/IndexMarket.x10"
            return t$32704;
        }
        
        
        //#line 148 "/home/dsl/workspace/plhamK/plham/IndexMarket.x10"
        final public boolean equals(java.lang.Object other) {
            
            //#line 148 "/home/dsl/workspace/plhamK/plham/IndexMarket.x10"
            final java.lang.Object t$32705 = ((other));
            
            //#line 148 "/home/dsl/workspace/plhamK/plham/IndexMarket.x10"
            final boolean t$32706 = plham.IndexMarket.WHICH_INDEX.$RTT.isInstance(t$32705);
            
            //#line 148 "/home/dsl/workspace/plhamK/plham/IndexMarket.x10"
            final boolean t$32707 = !(t$32706);
            
            //#line 148 "/home/dsl/workspace/plhamK/plham/IndexMarket.x10"
            if (t$32707) {
                
                //#line 148 "/home/dsl/workspace/plhamK/plham/IndexMarket.x10"
                return false;
            }
            
            //#line 148 "/home/dsl/workspace/plhamK/plham/IndexMarket.x10"
            final java.lang.Object t$32708 = ((other));
            
            //#line 148 "/home/dsl/workspace/plhamK/plham/IndexMarket.x10"
            final plham.IndexMarket.WHICH_INDEX t$32709 = ((plham.IndexMarket.WHICH_INDEX)x10.rtt.Types.asStruct(plham.IndexMarket.WHICH_INDEX.$RTT,t$32708));
            
            //#line 148 "/home/dsl/workspace/plhamK/plham/IndexMarket.x10"
            final boolean t$32710 = this.equals$O(((t$32709)));
            
            //#line 148 "/home/dsl/workspace/plhamK/plham/IndexMarket.x10"
            return t$32710;
        }
        
        
        //#line 148 "/home/dsl/workspace/plhamK/plham/IndexMarket.x10"
        final public boolean equals$O(plham.IndexMarket.WHICH_INDEX other) {
            
            //#line 148 "/home/dsl/workspace/plhamK/plham/IndexMarket.x10"
            final long t$32712 = this.id;
            
            //#line 148 "/home/dsl/workspace/plhamK/plham/IndexMarket.x10"
            final plham.IndexMarket.WHICH_INDEX t$32711 = ((other));
            
            //#line 148 "/home/dsl/workspace/plhamK/plham/IndexMarket.x10"
            final long t$32713 = t$32711.id;
            
            //#line 148 "/home/dsl/workspace/plhamK/plham/IndexMarket.x10"
            final boolean t$32714 = (t$32712) == (t$32713);
            
            //#line 148 "/home/dsl/workspace/plhamK/plham/IndexMarket.x10"
            return t$32714;
        }
        
        
        //#line 148 "/home/dsl/workspace/plhamK/plham/IndexMarket.x10"
        final public boolean _struct_equals$O(java.lang.Object other) {
            
            //#line 148 "/home/dsl/workspace/plhamK/plham/IndexMarket.x10"
            final java.lang.Object t$32715 = ((other));
            
            //#line 148 "/home/dsl/workspace/plhamK/plham/IndexMarket.x10"
            final boolean t$32716 = plham.IndexMarket.WHICH_INDEX.$RTT.isInstance(t$32715);
            
            //#line 148 "/home/dsl/workspace/plhamK/plham/IndexMarket.x10"
            final boolean t$32717 = !(t$32716);
            
            //#line 148 "/home/dsl/workspace/plhamK/plham/IndexMarket.x10"
            if (t$32717) {
                
                //#line 148 "/home/dsl/workspace/plhamK/plham/IndexMarket.x10"
                return false;
            }
            
            //#line 148 "/home/dsl/workspace/plhamK/plham/IndexMarket.x10"
            final java.lang.Object t$32718 = ((other));
            
            //#line 148 "/home/dsl/workspace/plhamK/plham/IndexMarket.x10"
            final plham.IndexMarket.WHICH_INDEX t$32719 = ((plham.IndexMarket.WHICH_INDEX)x10.rtt.Types.asStruct(plham.IndexMarket.WHICH_INDEX.$RTT,t$32718));
            
            //#line 148 "/home/dsl/workspace/plhamK/plham/IndexMarket.x10"
            final boolean t$32720 = this._struct_equals$O(((t$32719)));
            
            //#line 148 "/home/dsl/workspace/plhamK/plham/IndexMarket.x10"
            return t$32720;
        }
        
        
        //#line 148 "/home/dsl/workspace/plhamK/plham/IndexMarket.x10"
        final public boolean _struct_equals$O(plham.IndexMarket.WHICH_INDEX other) {
            
            //#line 148 "/home/dsl/workspace/plhamK/plham/IndexMarket.x10"
            final long t$32722 = this.id;
            
            //#line 148 "/home/dsl/workspace/plhamK/plham/IndexMarket.x10"
            final plham.IndexMarket.WHICH_INDEX t$32721 = ((other));
            
            //#line 148 "/home/dsl/workspace/plhamK/plham/IndexMarket.x10"
            final long t$32723 = t$32721.id;
            
            //#line 148 "/home/dsl/workspace/plhamK/plham/IndexMarket.x10"
            final boolean t$32724 = (t$32722) == (t$32723);
            
            //#line 148 "/home/dsl/workspace/plhamK/plham/IndexMarket.x10"
            return t$32724;
        }
        
        
        //#line 148 "/home/dsl/workspace/plhamK/plham/IndexMarket.x10"
        final public plham.IndexMarket.WHICH_INDEX plham$IndexMarket$WHICH_INDEX$$this$plham$IndexMarket$WHICH_INDEX() {
            
            //#line 148 "/home/dsl/workspace/plhamK/plham/IndexMarket.x10"
            return plham.IndexMarket.WHICH_INDEX.this;
        }
        
        
        //#line 148 "/home/dsl/workspace/plhamK/plham/IndexMarket.x10"
        // creation method for java code (1-phase java constructor)
        public WHICH_INDEX(final long id) {
            this((java.lang.System[]) null);
            plham$IndexMarket$WHICH_INDEX$$init$S(id);
        }
        
        // constructor for non-virtual call
        final public plham.IndexMarket.WHICH_INDEX plham$IndexMarket$WHICH_INDEX$$init$S(final long id) {
             {
                
                //#line 148 "/home/dsl/workspace/plhamK/plham/IndexMarket.x10"
                this.id = id;
                
                
                //#line 148 "/home/dsl/workspace/plhamK/plham/IndexMarket.x10"
                this.__fieldInitializers_plham_IndexMarket_WHICH_INDEX();
            }
            return this;
        }
        
        
        
        //#line 148 "/home/dsl/workspace/plhamK/plham/IndexMarket.x10"
        final public void __fieldInitializers_plham_IndexMarket_WHICH_INDEX() {
            
        }
    }
    
    
    //#line 149 "/home/dsl/workspace/plhamK/plham/IndexMarket.x10"
    private static plham.IndexMarket.WHICH_INDEX FUNDAMENTAL;
    
    //#line 150 "/home/dsl/workspace/plhamK/plham/IndexMarket.x10"
    private static plham.IndexMarket.WHICH_INDEX MARKET;
    
    
    //#line 151 "/home/dsl/workspace/plhamK/plham/IndexMarket.x10"
    public double computeIndex$O(final long t, final plham.IndexMarket.WHICH_INDEX which_type) {
        
        //#line 152 "/home/dsl/workspace/plhamK/plham/IndexMarket.x10"
        double total_value = ((((0L))));
        
        //#line 153 "/home/dsl/workspace/plhamK/plham/IndexMarket.x10"
        double total_shares = ((((0L))));
        
        //#line 154 "/home/dsl/workspace/plhamK/plham/IndexMarket.x10"
        final x10.util.List t$32825 = ((this.components));
        
        //#line 154 "/home/dsl/workspace/plhamK/plham/IndexMarket.x10"
        final x10.util.ListIterator component_id$32826 = (((x10.util.List<x10.core.Long>)t$32825).iterator());
        
        //#line 154 "/home/dsl/workspace/plhamK/plham/IndexMarket.x10"
        for (;
             true;
             ) {
            
            //#line 154 "/home/dsl/workspace/plhamK/plham/IndexMarket.x10"
            final boolean t$32827 = ((x10.util.ListIterator<x10.core.Long>)component_id$32826).hasNext$O();
            
            //#line 154 "/home/dsl/workspace/plhamK/plham/IndexMarket.x10"
            if (!(t$32827)) {
                
                //#line 154 "/home/dsl/workspace/plhamK/plham/IndexMarket.x10"
                break;
            }
            
            //#line 154 "/home/dsl/workspace/plhamK/plham/IndexMarket.x10"
            final long component_id$32808 = x10.core.Long.$unbox(((x10.util.ListIterator<x10.core.Long>)component_id$32826).next$G());
            
            //#line 155 "/home/dsl/workspace/plhamK/plham/IndexMarket.x10"
            final plham.Env t$32809 = ((this.env));
            
            //#line 155 "/home/dsl/workspace/plhamK/plham/IndexMarket.x10"
            final x10.util.List t$32810 = ((t$32809.markets));
            
            //#line 155 "/home/dsl/workspace/plhamK/plham/IndexMarket.x10"
            final plham.Market m$32811 = ((x10.util.Indexed<plham.Market>)t$32810).$apply$G((component_id$32808));
            
            //#line 157 "/home/dsl/workspace/plhamK/plham/IndexMarket.x10"
            final double t$32812 = total_value;
            
            //#line 157 "/home/dsl/workspace/plhamK/plham/IndexMarket.x10"
            final plham.IndexMarket.WHICH_INDEX t$32813 = ((plham.IndexMarket.get$FUNDAMENTAL()));
            
            //#line 157 "/home/dsl/workspace/plhamK/plham/IndexMarket.x10"
            final boolean t$32814 = x10.rtt.Equality.equalsequals((which_type),(t$32813));
            
            //#line 157 "/home/dsl/workspace/plhamK/plham/IndexMarket.x10"
            double t$32815 =  0;
            
            //#line 157 "/home/dsl/workspace/plhamK/plham/IndexMarket.x10"
            if (t$32814) {
                
                //#line 157 "/home/dsl/workspace/plhamK/plham/IndexMarket.x10"
                t$32815 = m$32811.getFundamentalPrice((t));
            } else {
                
                //#line 157 "/home/dsl/workspace/plhamK/plham/IndexMarket.x10"
                t$32815 = m$32811.getMarketPrice$O((t));
            }
            
            //#line 157 "/home/dsl/workspace/plhamK/plham/IndexMarket.x10"
            final double t$32816 = t$32815;
            
            //#line 157 "/home/dsl/workspace/plhamK/plham/IndexMarket.x10"
            final long t$32817 = m$32811.getOutstandingShares$O();
            
            //#line 157 "/home/dsl/workspace/plhamK/plham/IndexMarket.x10"
            final double t$32818 = ((((t$32817))));
            
            //#line 157 "/home/dsl/workspace/plhamK/plham/IndexMarket.x10"
            final double t$32819 = ((t$32816) * (((t$32818))));
            
            //#line 157 "/home/dsl/workspace/plhamK/plham/IndexMarket.x10"
            final double t$32820 = ((t$32812) + (((t$32819))));
            
            //#line 157 "/home/dsl/workspace/plhamK/plham/IndexMarket.x10"
            total_value = t$32820;
            
            //#line 158 "/home/dsl/workspace/plhamK/plham/IndexMarket.x10"
            final double t$32821 = total_shares;
            
            //#line 158 "/home/dsl/workspace/plhamK/plham/IndexMarket.x10"
            final long t$32822 = m$32811.getOutstandingShares$O();
            
            //#line 158 "/home/dsl/workspace/plhamK/plham/IndexMarket.x10"
            final double t$32823 = ((((t$32822))));
            
            //#line 158 "/home/dsl/workspace/plhamK/plham/IndexMarket.x10"
            final double t$32824 = ((t$32821) + (((t$32823))));
            
            //#line 158 "/home/dsl/workspace/plhamK/plham/IndexMarket.x10"
            total_shares = t$32824;
        }
        
        //#line 160 "/home/dsl/workspace/plhamK/plham/IndexMarket.x10"
        final double t$32743 = total_value;
        
        //#line 160 "/home/dsl/workspace/plhamK/plham/IndexMarket.x10"
        final double t$32744 = total_shares;
        
        //#line 160 "/home/dsl/workspace/plhamK/plham/IndexMarket.x10"
        final double t$32745 = ((t$32743) / (((t$32744))));
        
        //#line 160 "/home/dsl/workspace/plhamK/plham/IndexMarket.x10"
        return t$32745;
    }
    
    
    //#line 167 "/home/dsl/workspace/plhamK/plham/IndexMarket.x10"
    /**
	 * Compute the latest market index value.
	 * @return the index value
	 */
    public double computeMarketIndex$O() {
        
        //#line 168 "/home/dsl/workspace/plhamK/plham/IndexMarket.x10"
        assert ((this.env) != (null)): "Cannot call during the setup procedure";
        
        //#line 169 "/home/dsl/workspace/plhamK/plham/IndexMarket.x10"
        final long t$32746 = this.getTime$O();
        
        //#line 169 "/home/dsl/workspace/plhamK/plham/IndexMarket.x10"
        final plham.IndexMarket.WHICH_INDEX t$32747 = ((plham.IndexMarket.get$MARKET()));
        
        //#line 169 "/home/dsl/workspace/plhamK/plham/IndexMarket.x10"
        final double t$32748 = this.computeIndex$O((t$32746), ((t$32747)));
        
        //#line 169 "/home/dsl/workspace/plhamK/plham/IndexMarket.x10"
        return t$32748;
    }
    
    
    //#line 175 "/home/dsl/workspace/plhamK/plham/IndexMarket.x10"
    /**
	 * Compute the latest market index value.
	 * @return the index value
	 */
    public double computeMarketIndex$O(final long t) {
        
        //#line 176 "/home/dsl/workspace/plhamK/plham/IndexMarket.x10"
        assert ((this.env) != (null)): "Cannot call during the setup procedure";
        
        //#line 177 "/home/dsl/workspace/plhamK/plham/IndexMarket.x10"
        final plham.IndexMarket.WHICH_INDEX t$32749 = ((plham.IndexMarket.get$MARKET()));
        
        //#line 177 "/home/dsl/workspace/plhamK/plham/IndexMarket.x10"
        final double t$32750 = this.computeIndex$O((t), ((t$32749)));
        
        //#line 177 "/home/dsl/workspace/plhamK/plham/IndexMarket.x10"
        return t$32750;
    }
    
    
    //#line 180 "/home/dsl/workspace/plhamK/plham/IndexMarket.x10"
    public double computeFundamentalIndex$O() {
        
        //#line 180 "/home/dsl/workspace/plhamK/plham/IndexMarket.x10"
        final long t$32751 = this.getTime$O();
        
        //#line 180 "/home/dsl/workspace/plhamK/plham/IndexMarket.x10"
        final double t$32752 = this.computeFundamentalIndex$O((t$32751));
        
        //#line 180 "/home/dsl/workspace/plhamK/plham/IndexMarket.x10"
        return t$32752;
    }
    
    
    //#line 185 "/home/dsl/workspace/plhamK/plham/IndexMarket.x10"
    /**
	 * Compute the latest fundamental index value.
	 * @return the index value
	 */
    public double computeFundamentalIndex$O(final long t) {
        
        //#line 186 "/home/dsl/workspace/plhamK/plham/IndexMarket.x10"
        assert ((this.env) != (null)): "Cannot call during the setup procedure";
        
        //#line 187 "/home/dsl/workspace/plhamK/plham/IndexMarket.x10"
        final plham.IndexMarket.WHICH_INDEX t$32753 = ((plham.IndexMarket.get$FUNDAMENTAL()));
        
        //#line 187 "/home/dsl/workspace/plhamK/plham/IndexMarket.x10"
        final double t$32754 = this.computeIndex$O((t), ((t$32753)));
        
        //#line 187 "/home/dsl/workspace/plhamK/plham/IndexMarket.x10"
        return t$32754;
    }
    
    
    //#line 190 "/home/dsl/workspace/plhamK/plham/IndexMarket.x10"
    public plham.IndexMarket setup(final cassia.util.JSON.Value json, final plham.main.Simulator sim) {
        
        //#line 191 "/home/dsl/workspace/plhamK/plham/IndexMarket.x10"
        final x10.util.Random t$32755 = this.getRandom();
        
        //#line 191 "/home/dsl/workspace/plhamK/plham/IndexMarket.x10"
        final plham.util.JSONRandom random = ((new plham.util.JSONRandom((java.lang.System[]) null).plham$util$JSONRandom$$init$S(t$32755)));
        
        //#line 192 "/home/dsl/workspace/plhamK/plham/IndexMarket.x10"
        final cassia.util.JSON.Value t$32756 = json.<java.lang.String> get(x10.rtt.Types.STRING, (("markets")));
        
        //#line 192 "/home/dsl/workspace/plhamK/plham/IndexMarket.x10"
        final x10.util.List spots = sim.getMarketsByName(((t$32756)));
        
        //#line 193 "/home/dsl/workspace/plhamK/plham/IndexMarket.x10"
        this.addMarkets__0$1plham$Market$2(((spots)));
        
        //#line 197 "/home/dsl/workspace/plhamK/plham/IndexMarket.x10"
        final cassia.util.JSON.Value t$32757 = json.<java.lang.String> get(x10.rtt.Types.STRING, (("outstandingShares")));
        
        //#line 197 "/home/dsl/workspace/plhamK/plham/IndexMarket.x10"
        final double t$32758 = random.nextRandom$O(((t$32757)));
        
        //#line 197 "/home/dsl/workspace/plhamK/plham/IndexMarket.x10"
        final long t$32759 = ((long)(((t$32758))));
        
        //#line 197 "/home/dsl/workspace/plhamK/plham/IndexMarket.x10"
        this.setOutstandingShares$O((t$32759));
        
        //#line 200 "/home/dsl/workspace/plhamK/plham/IndexMarket.x10"
        final x10.core.fun.Fun_0_1 compute = ((new plham.IndexMarket.$Closure$26(spots, (plham.IndexMarket.$Closure$26.__0$1plham$Market$2) null)));
        
        //#line 209 "/home/dsl/workspace/plhamK/plham/IndexMarket.x10"
        final plham.IndexMarket.WHICH_INDEX t$32778 = ((plham.IndexMarket.get$MARKET()));
        
        //#line 209 "/home/dsl/workspace/plhamK/plham/IndexMarket.x10"
        final double t$32779 = x10.core.Double.$unbox(((x10.core.fun.Fun_0_1<plham.IndexMarket.WHICH_INDEX,x10.core.Double>)compute).$apply(t$32778, plham.IndexMarket.WHICH_INDEX.$RTT));
        
        //#line 209 "/home/dsl/workspace/plhamK/plham/IndexMarket.x10"
        this.setInitialMarketPrice((t$32779));
        
        //#line 210 "/home/dsl/workspace/plhamK/plham/IndexMarket.x10"
        final plham.IndexMarket.WHICH_INDEX t$32780 = ((plham.IndexMarket.get$FUNDAMENTAL()));
        
        //#line 210 "/home/dsl/workspace/plhamK/plham/IndexMarket.x10"
        final double t$32781 = x10.core.Double.$unbox(((x10.core.fun.Fun_0_1<plham.IndexMarket.WHICH_INDEX,x10.core.Double>)compute).$apply(t$32780, plham.IndexMarket.WHICH_INDEX.$RTT));
        
        //#line 210 "/home/dsl/workspace/plhamK/plham/IndexMarket.x10"
        this.setInitialFundamentalPrice((t$32781));
        
        //#line 211 "/home/dsl/workspace/plhamK/plham/IndexMarket.x10"
        return this;
    }
    
    
    //#line 214 "/home/dsl/workspace/plhamK/plham/IndexMarket.x10"
    public static void register(final plham.main.Simulator sim) {
        
        //#line 215 "/home/dsl/workspace/plhamK/plham/IndexMarket.x10"
        final java.lang.String className = (("IndexMarket"));
        
        //#line 216 "/home/dsl/workspace/plhamK/plham/IndexMarket.x10"
        final x10.core.fun.Fun_0_4 t$32790 = ((new plham.IndexMarket.$Closure$27(sim)));
        
        //#line 216 "/home/dsl/workspace/plhamK/plham/IndexMarket.x10"
        sim.addMarketsInitializer__1$1x10$lang$Long$3x10$lang$String$3x10$util$Random$3cassia$util$JSON$Value$3x10$util$List$1plham$Market$2$2(((className)), ((t$32790)));
    }
    
    
    //#line 18 "/home/dsl/workspace/plhamK/plham/IndexMarket.x10"
    final public plham.IndexMarket plham$IndexMarket$$this$plham$IndexMarket() {
        
        //#line 18 "/home/dsl/workspace/plhamK/plham/IndexMarket.x10"
        return plham.IndexMarket.this;
    }
    
    
    //#line 18 "/home/dsl/workspace/plhamK/plham/IndexMarket.x10"
    final public void __fieldInitializers_plham_IndexMarket() {
        
        //#line 18 "/home/dsl/workspace/plhamK/plham/IndexMarket.x10"
        this.components = null;
    }
    
    final private static x10.core.concurrent.AtomicInteger initStatus$MARKET = new x10.core.concurrent.AtomicInteger(x10.runtime.impl.java.InitDispatcher.UNINITIALIZED);
    private static x10.lang.ExceptionInInitializer exception$MARKET;
    final private static x10.core.concurrent.AtomicInteger initStatus$FUNDAMENTAL = new x10.core.concurrent.AtomicInteger(x10.runtime.impl.java.InitDispatcher.UNINITIALIZED);
    private static x10.lang.ExceptionInInitializer exception$FUNDAMENTAL;
    
    public static plham.IndexMarket.WHICH_INDEX get$FUNDAMENTAL() {
        if ((plham.IndexMarket.initStatus$FUNDAMENTAL.get()) == (x10.runtime.impl.java.InitDispatcher.INITIALIZED)) {
            return plham.IndexMarket.FUNDAMENTAL;
        }
        if ((plham.IndexMarket.initStatus$FUNDAMENTAL.get()) == (x10.runtime.impl.java.InitDispatcher.EXCEPTION_RAISED)) {
            if (((boolean) x10.runtime.impl.java.InitDispatcher.TRACE_STATIC_INIT) == ((boolean) true)) {
                x10.runtime.impl.java.InitDispatcher.printStaticInitMessage(((java.lang.String)("Rethrowing ExceptionInInitializer for field: plham.IndexMarket.FUNDAMENTAL")));
            }
            throw plham.IndexMarket.exception$FUNDAMENTAL;
        }
        if (plham.IndexMarket.initStatus$FUNDAMENTAL.compareAndSet((int)(x10.runtime.impl.java.InitDispatcher.UNINITIALIZED), (int)(x10.runtime.impl.java.InitDispatcher.INITIALIZING))) {
            try {{
                plham.IndexMarket.FUNDAMENTAL = ((plham.IndexMarket.WHICH_INDEX)(new plham.IndexMarket.WHICH_INDEX((java.lang.System[]) null).plham$IndexMarket$WHICH_INDEX$$init$S(((long)(0L)))));
            }}catch (java.lang.Throwable exc$32844) {
                plham.IndexMarket.exception$FUNDAMENTAL = new x10.lang.ExceptionInInitializer(exc$32844);
                plham.IndexMarket.initStatus$FUNDAMENTAL.set((int)(x10.runtime.impl.java.InitDispatcher.EXCEPTION_RAISED));
                x10.runtime.impl.java.InitDispatcher.lockInitialized();
                x10.runtime.impl.java.InitDispatcher.notifyInitialized();
                throw plham.IndexMarket.exception$FUNDAMENTAL;
            }
            if (((boolean) x10.runtime.impl.java.InitDispatcher.TRACE_STATIC_INIT) == ((boolean) true)) {
                x10.runtime.impl.java.InitDispatcher.printStaticInitMessage(((java.lang.String)("Doing static initialization for field: plham.IndexMarket.FUNDAMENTAL")));
            }
            plham.IndexMarket.initStatus$FUNDAMENTAL.set((int)(x10.runtime.impl.java.InitDispatcher.INITIALIZED));
            x10.runtime.impl.java.InitDispatcher.lockInitialized();
            x10.runtime.impl.java.InitDispatcher.notifyInitialized();
        } else {
            if (plham.IndexMarket.initStatus$FUNDAMENTAL.get() < x10.runtime.impl.java.InitDispatcher.INITIALIZED) {
                x10.runtime.impl.java.InitDispatcher.lockInitialized();
                while (plham.IndexMarket.initStatus$FUNDAMENTAL.get() < x10.runtime.impl.java.InitDispatcher.INITIALIZED) {
                    x10.runtime.impl.java.InitDispatcher.awaitInitialized();
                }
                x10.runtime.impl.java.InitDispatcher.unlockInitialized();
                if (((int) plham.IndexMarket.initStatus$FUNDAMENTAL.get()) == ((int) x10.runtime.impl.java.InitDispatcher.EXCEPTION_RAISED)) {
                    if (((boolean) x10.runtime.impl.java.InitDispatcher.TRACE_STATIC_INIT) == ((boolean) true)) {
                        x10.runtime.impl.java.InitDispatcher.printStaticInitMessage(((java.lang.String)("Rethrowing ExceptionInInitializer for field: plham.IndexMarket.FUNDAMENTAL")));
                    }
                    throw plham.IndexMarket.exception$FUNDAMENTAL;
                }
            }
        }
        return plham.IndexMarket.FUNDAMENTAL;
    }
    
    public static plham.IndexMarket.WHICH_INDEX get$MARKET() {
        if (((int) plham.IndexMarket.initStatus$MARKET.get()) == ((int) x10.runtime.impl.java.InitDispatcher.INITIALIZED)) {
            return plham.IndexMarket.MARKET;
        }
        if (((int) plham.IndexMarket.initStatus$MARKET.get()) == ((int) x10.runtime.impl.java.InitDispatcher.EXCEPTION_RAISED)) {
            if (((boolean) x10.runtime.impl.java.InitDispatcher.TRACE_STATIC_INIT) == ((boolean) true)) {
                x10.runtime.impl.java.InitDispatcher.printStaticInitMessage(((java.lang.String)("Rethrowing ExceptionInInitializer for field: plham.IndexMarket.MARKET")));
            }
            throw plham.IndexMarket.exception$MARKET;
        }
        if (plham.IndexMarket.initStatus$MARKET.compareAndSet((int)(x10.runtime.impl.java.InitDispatcher.UNINITIALIZED), (int)(x10.runtime.impl.java.InitDispatcher.INITIALIZING))) {
            try {{
                plham.IndexMarket.MARKET = ((plham.IndexMarket.WHICH_INDEX)(new plham.IndexMarket.WHICH_INDEX((java.lang.System[]) null).plham$IndexMarket$WHICH_INDEX$$init$S(((long)(1L)))));
            }}catch (java.lang.Throwable exc$32845) {
                plham.IndexMarket.exception$MARKET = new x10.lang.ExceptionInInitializer(exc$32845);
                plham.IndexMarket.initStatus$MARKET.set((int)(x10.runtime.impl.java.InitDispatcher.EXCEPTION_RAISED));
                x10.runtime.impl.java.InitDispatcher.lockInitialized();
                x10.runtime.impl.java.InitDispatcher.notifyInitialized();
                throw plham.IndexMarket.exception$MARKET;
            }
            if (((boolean) x10.runtime.impl.java.InitDispatcher.TRACE_STATIC_INIT) == ((boolean) true)) {
                x10.runtime.impl.java.InitDispatcher.printStaticInitMessage(((java.lang.String)("Doing static initialization for field: plham.IndexMarket.MARKET")));
            }
            plham.IndexMarket.initStatus$MARKET.set((int)(x10.runtime.impl.java.InitDispatcher.INITIALIZED));
            x10.runtime.impl.java.InitDispatcher.lockInitialized();
            x10.runtime.impl.java.InitDispatcher.notifyInitialized();
        } else {
            if (plham.IndexMarket.initStatus$MARKET.get() < x10.runtime.impl.java.InitDispatcher.INITIALIZED) {
                x10.runtime.impl.java.InitDispatcher.lockInitialized();
                while (plham.IndexMarket.initStatus$MARKET.get() < x10.runtime.impl.java.InitDispatcher.INITIALIZED) {
                    x10.runtime.impl.java.InitDispatcher.awaitInitialized();
                }
                x10.runtime.impl.java.InitDispatcher.unlockInitialized();
                if (((int) plham.IndexMarket.initStatus$MARKET.get()) == ((int) x10.runtime.impl.java.InitDispatcher.EXCEPTION_RAISED)) {
                    if (((boolean) x10.runtime.impl.java.InitDispatcher.TRACE_STATIC_INIT) == ((boolean) true)) {
                        x10.runtime.impl.java.InitDispatcher.printStaticInitMessage(((java.lang.String)("Rethrowing ExceptionInInitializer for field: plham.IndexMarket.MARKET")));
                    }
                    throw plham.IndexMarket.exception$MARKET;
                }
            }
        }
        return plham.IndexMarket.MARKET;
    }
    
    
    final public static class $Closure$26 extends x10.core.Ref implements x10.core.fun.Fun_0_1, x10.serialization.X10JavaSerializable
    {
        public static final x10.rtt.RuntimeType<$Closure$26> $RTT = 
            x10.rtt.StaticFunType.<$Closure$26> make($Closure$26.class,
                                                     new x10.rtt.Type[] {
                                                         x10.rtt.ParameterizedType.make(x10.core.fun.Fun_0_1.$RTT, plham.IndexMarket.WHICH_INDEX.$RTT, x10.rtt.Types.DOUBLE)
                                                     });
        
        public x10.rtt.RuntimeType<?> $getRTT() { return $RTT; }
        
        public x10.rtt.Type<?> $getParam(int i) { return null; }
        
        private Object writeReplace() throws java.io.ObjectStreamException {
            return new x10.serialization.SerializationProxy(this);
        }
        
        public static x10.serialization.X10JavaSerializable $_deserialize_body(plham.IndexMarket.$Closure$26 $_obj, x10.serialization.X10JavaDeserializer $deserializer) throws java.io.IOException {
            if (x10.runtime.impl.java.Runtime.TRACE_SER) { x10.runtime.impl.java.Runtime.printTraceMessage("X10JavaSerializable: $_deserialize_body() of " + $Closure$26.class + " calling"); } 
            $_obj.spots = $deserializer.readObject();
            return $_obj;
        }
        
        public static x10.serialization.X10JavaSerializable $_deserializer(x10.serialization.X10JavaDeserializer $deserializer) throws java.io.IOException {
            plham.IndexMarket.$Closure$26 $_obj = new plham.IndexMarket.$Closure$26((java.lang.System[]) null);
            $deserializer.record_reference($_obj);
            return $_deserialize_body($_obj, $deserializer);
        }
        
        public void $_serialize(x10.serialization.X10JavaSerializer $serializer) throws java.io.IOException {
            $serializer.write(this.spots);
            
        }
        
        // constructor just for allocation
        public $Closure$26(final java.lang.System[] $dummy) {
            
        }
        
        // dispatcher for method abstract public (Z1)=>U.operator()(a1:Z1):U
        public java.lang.Object $apply(final java.lang.Object a1, final x10.rtt.Type t1) {
            return x10.core.Double.$box($apply$O((plham.IndexMarket.WHICH_INDEX)a1));
            
        }
        
        // dispatcher for method abstract public (Z1)=>U.operator()(a1:Z1):U
        public double $apply$D(final java.lang.Object a1, final x10.rtt.Type t1) {
            return $apply$O((plham.IndexMarket.WHICH_INDEX)a1);
            
        }
        
        // synthetic type for parameter mangling
        public static final class __0$1plham$Market$2 {}
        
    
        
        public double $apply$O(final plham.IndexMarket.WHICH_INDEX which_type) {
            
            //#line 201 "/home/dsl/workspace/plhamK/plham/IndexMarket.x10"
            double total_value = ((double)(long)(((long)(0L))));
            
            //#line 202 "/home/dsl/workspace/plhamK/plham/IndexMarket.x10"
            double total_shares = ((double)(long)(((long)(0L))));
            
            //#line 203 "/home/dsl/workspace/plhamK/plham/IndexMarket.x10"
            final x10.util.ListIterator m$32842 = ((x10.util.ListIterator<plham.Market>)
                                                    ((x10.util.List<plham.Market>)this.spots).iterator());
            
            //#line 203 "/home/dsl/workspace/plhamK/plham/IndexMarket.x10"
            for (;
                 true;
                 ) {
                
                //#line 203 "/home/dsl/workspace/plhamK/plham/IndexMarket.x10"
                final boolean t$32843 = ((x10.util.ListIterator<plham.Market>)m$32842).hasNext$O();
                
                //#line 203 "/home/dsl/workspace/plhamK/plham/IndexMarket.x10"
                if (!(t$32843)) {
                    
                    //#line 203 "/home/dsl/workspace/plhamK/plham/IndexMarket.x10"
                    break;
                }
                
                //#line 203 "/home/dsl/workspace/plhamK/plham/IndexMarket.x10"
                final plham.Market m$32828 = ((plham.Market)(((x10.util.ListIterator<plham.Market>)m$32842).next$G()));
                
                //#line 204 "/home/dsl/workspace/plhamK/plham/IndexMarket.x10"
                final double t$32829 = total_value;
                
                //#line 204 "/home/dsl/workspace/plhamK/plham/IndexMarket.x10"
                final plham.IndexMarket.WHICH_INDEX t$32830 = ((plham.IndexMarket.WHICH_INDEX)(plham.IndexMarket.get$FUNDAMENTAL()));
                
                //#line 204 "/home/dsl/workspace/plhamK/plham/IndexMarket.x10"
                final boolean t$32831 = x10.rtt.Equality.equalsequals((which_type),(t$32830));
                
                //#line 204 "/home/dsl/workspace/plhamK/plham/IndexMarket.x10"
                double t$32832 =  0;
                
                //#line 204 "/home/dsl/workspace/plhamK/plham/IndexMarket.x10"
                if (t$32831) {
                    
                    //#line 204 "/home/dsl/workspace/plhamK/plham/IndexMarket.x10"
                    t$32832 = m$32828.getFundamentalPrice();
                } else {
                    
                    //#line 204 "/home/dsl/workspace/plhamK/plham/IndexMarket.x10"
                    t$32832 = m$32828.getMarketPrice$O();
                }
                
                //#line 204 "/home/dsl/workspace/plhamK/plham/IndexMarket.x10"
                final double t$32833 = t$32832;
                
                //#line 204 "/home/dsl/workspace/plhamK/plham/IndexMarket.x10"
                final long t$32834 = m$32828.getOutstandingShares$O();
                
                //#line 204 "/home/dsl/workspace/plhamK/plham/IndexMarket.x10"
                final double t$32835 = ((double)(long)(((long)(t$32834))));
                
                //#line 204 "/home/dsl/workspace/plhamK/plham/IndexMarket.x10"
                final double t$32836 = ((t$32833) * (((double)(t$32835))));
                
                //#line 204 "/home/dsl/workspace/plhamK/plham/IndexMarket.x10"
                final double t$32837 = ((t$32829) + (((double)(t$32836))));
                
                //#line 204 "/home/dsl/workspace/plhamK/plham/IndexMarket.x10"
                total_value = t$32837;
                
                //#line 205 "/home/dsl/workspace/plhamK/plham/IndexMarket.x10"
                final double t$32838 = total_shares;
                
                //#line 205 "/home/dsl/workspace/plhamK/plham/IndexMarket.x10"
                final long t$32839 = m$32828.getOutstandingShares$O();
                
                //#line 205 "/home/dsl/workspace/plhamK/plham/IndexMarket.x10"
                final double t$32840 = ((double)(long)(((long)(t$32839))));
                
                //#line 205 "/home/dsl/workspace/plhamK/plham/IndexMarket.x10"
                final double t$32841 = ((t$32838) + (((double)(t$32840))));
                
                //#line 205 "/home/dsl/workspace/plhamK/plham/IndexMarket.x10"
                total_shares = t$32841;
            }
            
            //#line 207 "/home/dsl/workspace/plhamK/plham/IndexMarket.x10"
            final double t$32775 = total_value;
            
            //#line 207 "/home/dsl/workspace/plhamK/plham/IndexMarket.x10"
            final double t$32776 = total_shares;
            
            //#line 207 "/home/dsl/workspace/plhamK/plham/IndexMarket.x10"
            final double t$32777 = ((t$32775) / (((double)(t$32776))));
            
            //#line 207 "/home/dsl/workspace/plhamK/plham/IndexMarket.x10"
            return t$32777;
        }
        
        public x10.util.List<plham.Market> spots;
        
        public $Closure$26(final x10.util.List<plham.Market> spots, __0$1plham$Market$2 $dummy) {
             {
                this.spots = ((x10.util.List)(spots));
            }
        }
        
    }
    
    
    final public static class $Closure$27 extends x10.core.Ref implements x10.core.fun.Fun_0_4, x10.serialization.X10JavaSerializable
    {
        public static final x10.rtt.RuntimeType<$Closure$27> $RTT = 
            x10.rtt.StaticFunType.<$Closure$27> make($Closure$27.class,
                                                     new x10.rtt.Type[] {
                                                         x10.rtt.ParameterizedType.make(x10.core.fun.Fun_0_4.$RTT, x10.rtt.Types.LONG, x10.rtt.Types.STRING, x10.util.Random.$RTT, cassia.util.JSON.Value.$RTT, x10.rtt.ParameterizedType.make(x10.util.ArrayList.$RTT, plham.Market.$RTT))
                                                     });
        
        public x10.rtt.RuntimeType<?> $getRTT() { return $RTT; }
        
        public x10.rtt.Type<?> $getParam(int i) { return null; }
        
        private Object writeReplace() throws java.io.ObjectStreamException {
            return new x10.serialization.SerializationProxy(this);
        }
        
        public static x10.serialization.X10JavaSerializable $_deserialize_body(plham.IndexMarket.$Closure$27 $_obj, x10.serialization.X10JavaDeserializer $deserializer) throws java.io.IOException {
            if (x10.runtime.impl.java.Runtime.TRACE_SER) { x10.runtime.impl.java.Runtime.printTraceMessage("X10JavaSerializable: $_deserialize_body() of " + $Closure$27.class + " calling"); } 
            $_obj.sim = $deserializer.readObject();
            return $_obj;
        }
        
        public static x10.serialization.X10JavaSerializable $_deserializer(x10.serialization.X10JavaDeserializer $deserializer) throws java.io.IOException {
            plham.IndexMarket.$Closure$27 $_obj = new plham.IndexMarket.$Closure$27((java.lang.System[]) null);
            $deserializer.record_reference($_obj);
            return $_deserialize_body($_obj, $deserializer);
        }
        
        public void $_serialize(x10.serialization.X10JavaSerializer $serializer) throws java.io.IOException {
            $serializer.write(this.sim);
            
        }
        
        // constructor just for allocation
        public $Closure$27(final java.lang.System[] $dummy) {
            
        }
        
        // dispatcher for method abstract public (Z1,Z2,Z3,Z4)=>U.operator()(a1:Z1, a2:Z2, a3:Z3, a4:Z4):U
        public java.lang.Object $apply(final java.lang.Object a1, final x10.rtt.Type t1, final java.lang.Object a2, final x10.rtt.Type t2, final java.lang.Object a3, final x10.rtt.Type t3, final java.lang.Object a4, final x10.rtt.Type t4) {
            return $apply(x10.core.Long.$unbox(a1), (java.lang.String)a2, (x10.util.Random)a3, (cassia.util.JSON.Value)a4);
            
        }
        
        
    
        
        public x10.util.ArrayList $apply(final long id, final java.lang.String name, final x10.util.Random random, final cassia.util.JSON.Value json) {
            
            //#line 217 "/home/dsl/workspace/plhamK/plham/IndexMarket.x10"
            final x10.util.ArrayList markets = ((x10.util.ArrayList)(new x10.util.ArrayList<plham.Market>((java.lang.System[]) null, plham.Market.$RTT).x10$util$ArrayList$$init$S()));
            
            //#line 218 "/home/dsl/workspace/plhamK/plham/IndexMarket.x10"
            final plham.IndexMarket t$32782 = ((plham.IndexMarket)(new plham.IndexMarket((java.lang.System[]) null).plham$IndexMarket$$init$S(((long)(id)), ((java.lang.String)(name)), ((x10.util.Random)(random)))));
            
            //#line 218 "/home/dsl/workspace/plhamK/plham/IndexMarket.x10"
            final plham.IndexMarket market = ((plham.IndexMarket)(t$32782.setup(((cassia.util.JSON.Value)(json)), ((plham.main.Simulator)(this.sim)))));
            
            //#line 219 "/home/dsl/workspace/plhamK/plham/IndexMarket.x10"
            ((x10.util.ArrayList<plham.Market>)markets).add__0x10$util$ArrayList$$T$O(((plham.Market)(market)));
            
            //#line 220 "/home/dsl/workspace/plhamK/plham/IndexMarket.x10"
            final x10.io.Printer t$32788 = ((x10.io.Printer)(x10.io.Console.get$OUT()));
            
            //#line 220 "/home/dsl/workspace/plhamK/plham/IndexMarket.x10"
            final cassia.util.JSON.Value t$32783 = ((cassia.util.JSON.Value)json).<java.lang.String> get(x10.rtt.Types.STRING, ((java.lang.String)("class")));
            
            //#line 220 "/home/dsl/workspace/plhamK/plham/IndexMarket.x10"
            final java.lang.String t$32784 = t$32783.toString();
            
            //#line 220 "/home/dsl/workspace/plhamK/plham/IndexMarket.x10"
            final java.lang.String t$32785 = (("# ") + (t$32784));
            
            //#line 220 "/home/dsl/workspace/plhamK/plham/IndexMarket.x10"
            final java.lang.String t$32786 = ((t$32785) + (" : "));
            
            //#line 220 "/home/dsl/workspace/plhamK/plham/IndexMarket.x10"
            final java.lang.String t$32787 = plham.util.JSON.dump(((cassia.util.JSON.Value)(json)));
            
            //#line 220 "/home/dsl/workspace/plhamK/plham/IndexMarket.x10"
            final java.lang.String t$32789 = ((t$32786) + (t$32787));
            
            //#line 220 "/home/dsl/workspace/plhamK/plham/IndexMarket.x10"
            t$32788.println(((java.lang.Object)(t$32789)));
            
            //#line 221 "/home/dsl/workspace/plhamK/plham/IndexMarket.x10"
            return markets;
        }
        
        public plham.main.Simulator sim;
        
        public $Closure$27(final plham.main.Simulator sim) {
             {
                this.sim = ((plham.main.Simulator)(sim));
            }
        }
        
    }
    
}

