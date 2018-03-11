package plham.util;



public class Itayose extends x10.core.Ref implements x10.serialization.X10JavaSerializable
{
    public static final x10.rtt.RuntimeType<Itayose> $RTT = 
        x10.rtt.NamedType.<Itayose> make("plham.util.Itayose",
                                         Itayose.class);
    
    public x10.rtt.RuntimeType<?> $getRTT() { return $RTT; }
    
    public x10.rtt.Type<?> $getParam(int i) { return null; }
    
    private Object writeReplace() throws java.io.ObjectStreamException {
        return new x10.serialization.SerializationProxy(this);
    }
    
    public static x10.serialization.X10JavaSerializable $_deserialize_body(plham.util.Itayose $_obj, x10.serialization.X10JavaDeserializer $deserializer) throws java.io.IOException {
        if (x10.runtime.impl.java.Runtime.TRACE_SER) { x10.runtime.impl.java.Runtime.printTraceMessage("X10JavaSerializable: $_deserialize_body() of " + Itayose.class + " calling"); } 
        return $_obj;
    }
    
    public static x10.serialization.X10JavaSerializable $_deserializer(x10.serialization.X10JavaDeserializer $deserializer) throws java.io.IOException {
        plham.util.Itayose $_obj = new plham.util.Itayose((java.lang.System[]) null);
        $deserializer.record_reference($_obj);
        return $_deserialize_body($_obj, $deserializer);
    }
    
    public void $_serialize(x10.serialization.X10JavaSerializer $serializer) throws java.io.IOException {
        
    }
    
    // constructor just for allocation
    public Itayose(final java.lang.System[] $dummy) {
        
    }
    
    

    
    
    
    //#line 18 "/home/dsl/workspace/plhamK/plham/util/Itayose.x10"
    public static void itayose(final plham.Market market) {
        
        //#line 19 "/home/dsl/workspace/plhamK/plham/util/Itayose.x10"
        final x10.util.ArrayList buyUpdates = ((new x10.util.ArrayList<plham.Market.AgentUpdate>((java.lang.System[]) null, plham.Market.AgentUpdate.$RTT).x10$util$ArrayList$$init$S()));
        
        //#line 20 "/home/dsl/workspace/plhamK/plham/util/Itayose.x10"
        final x10.util.ArrayList sellUpdates = ((new x10.util.ArrayList<plham.Market.AgentUpdate>((java.lang.System[]) null, plham.Market.AgentUpdate.$RTT).x10$util$ArrayList$$init$S()));
        
        //#line 21 "/home/dsl/workspace/plhamK/plham/util/Itayose.x10"
        double lastBuyPrice = 0.0;
        
        //#line 22 "/home/dsl/workspace/plhamK/plham/util/Itayose.x10"
        double lastSellPrice = 0.0;
        
        //#line 23 "/home/dsl/workspace/plhamK/plham/util/Itayose.x10"
        long sumExchangeVolume = 0L;
        
        //#line 24 "/home/dsl/workspace/plhamK/plham/util/Itayose.x10"
        while (true) {
            
            //#line 24 "/home/dsl/workspace/plhamK/plham/util/Itayose.x10"
            final double t$30646 = market.getBestBuyPrice$O();
            
            //#line 24 "/home/dsl/workspace/plhamK/plham/util/Itayose.x10"
            final double t$30647 = market.getBestSellPrice$O();
            
            //#line 24 "/home/dsl/workspace/plhamK/plham/util/Itayose.x10"
            final boolean t$30676 = ((t$30646) >= (((t$30647))));
            
            //#line 24 "/home/dsl/workspace/plhamK/plham/util/Itayose.x10"
            if (!(t$30676)) {
                
                //#line 24 "/home/dsl/workspace/plhamK/plham/util/Itayose.x10"
                break;
            }
            
            //#line 25 "/home/dsl/workspace/plhamK/plham/util/Itayose.x10"
            final plham.OrderBook t$30736 = ((market.buyOrderBook));
            
            //#line 25 "/home/dsl/workspace/plhamK/plham/util/Itayose.x10"
            final plham.Order buyOrder$30737 = t$30736.getBestOrder();
            
            //#line 26 "/home/dsl/workspace/plhamK/plham/util/Itayose.x10"
            final plham.OrderBook t$30738 = ((market.sellOrderBook));
            
            //#line 26 "/home/dsl/workspace/plhamK/plham/util/Itayose.x10"
            final plham.Order sellOrder$30739 = t$30738.getBestOrder();
            
            //#line 28 "/home/dsl/workspace/plhamK/plham/util/Itayose.x10"
            final double t$30740 = buyOrder$30737.getPrice$O();
            
            //#line 28 "/home/dsl/workspace/plhamK/plham/util/Itayose.x10"
            lastBuyPrice = t$30740;
            
            //#line 29 "/home/dsl/workspace/plhamK/plham/util/Itayose.x10"
            final double t$30741 = sellOrder$30739.getPrice$O();
            
            //#line 29 "/home/dsl/workspace/plhamK/plham/util/Itayose.x10"
            lastSellPrice = t$30741;
            
            //#line 30 "/home/dsl/workspace/plhamK/plham/util/Itayose.x10"
            final long t$30742 = buyOrder$30737.getVolume$O();
            
            //#line 30 "/home/dsl/workspace/plhamK/plham/util/Itayose.x10"
            final long t$30743 = sellOrder$30739.getVolume$O();
            
            //#line 30 "/home/dsl/workspace/plhamK/plham/util/Itayose.x10"
            final long exchangeVolume$30744 = java.lang.Math.min(((t$30742)),((t$30743)));
            
            //#line 31 "/home/dsl/workspace/plhamK/plham/util/Itayose.x10"
            final long t$30745 = sumExchangeVolume;
            
            //#line 31 "/home/dsl/workspace/plhamK/plham/util/Itayose.x10"
            final long t$30746 = ((t$30745) + (((exchangeVolume$30744))));
            
            //#line 31 "/home/dsl/workspace/plhamK/plham/util/Itayose.x10"
            sumExchangeVolume = t$30746;
            
            //#line 33 "/home/dsl/workspace/plhamK/plham/util/Itayose.x10"
            final long t$30747 = (-(exchangeVolume$30744));
            
            //#line 33 "/home/dsl/workspace/plhamK/plham/util/Itayose.x10"
            buyOrder$30737.updateVolume((t$30747));
            
            //#line 34 "/home/dsl/workspace/plhamK/plham/util/Itayose.x10"
            final long t$30748 = (-(exchangeVolume$30744));
            
            //#line 34 "/home/dsl/workspace/plhamK/plham/util/Itayose.x10"
            sellOrder$30739.updateVolume((t$30748));
            
            //#line 37 "/home/dsl/workspace/plhamK/plham/util/Itayose.x10"
            final long assetVolumeDelta$30749 = exchangeVolume$30744;
            
            //#line 39 "/home/dsl/workspace/plhamK/plham/util/Itayose.x10"
            final plham.Market.AgentUpdate buyUpdate$30750 = ((new plham.Market.AgentUpdate((java.lang.System[]) null).plham$Market$AgentUpdate$$init$S()));
            
            //#line 40 "/home/dsl/workspace/plhamK/plham/util/Itayose.x10"
            final long t$30751 = buyOrder$30737.agentId;
            
            //#line 40 "/home/dsl/workspace/plhamK/plham/util/Itayose.x10"
            buyUpdate$30750.agentId = t$30751;
            
            //#line 41 "/home/dsl/workspace/plhamK/plham/util/Itayose.x10"
            final long t$30752 = buyOrder$30737.marketId;
            
            //#line 41 "/home/dsl/workspace/plhamK/plham/util/Itayose.x10"
            buyUpdate$30750.marketId = t$30752;
            
            //#line 42 "/home/dsl/workspace/plhamK/plham/util/Itayose.x10"
            final long t$30753 = buyOrder$30737.orderId;
            
            //#line 42 "/home/dsl/workspace/plhamK/plham/util/Itayose.x10"
            buyUpdate$30750.orderId = t$30753;
            
            //#line 43 "/home/dsl/workspace/plhamK/plham/util/Itayose.x10"
            final double t$30754 = java.lang.Double.NaN;
            
            //#line 43 "/home/dsl/workspace/plhamK/plham/util/Itayose.x10"
            buyUpdate$30750.price = t$30754;
            
            //#line 44 "/home/dsl/workspace/plhamK/plham/util/Itayose.x10"
            final double t$30755 = java.lang.Double.NaN;
            
            //#line 44 "/home/dsl/workspace/plhamK/plham/util/Itayose.x10"
            buyUpdate$30750.cashAmountDelta = t$30755;
            
            //#line 45 "/home/dsl/workspace/plhamK/plham/util/Itayose.x10"
            final long t$30756 = (+(assetVolumeDelta$30749));
            
            //#line 45 "/home/dsl/workspace/plhamK/plham/util/Itayose.x10"
            buyUpdate$30750.assetVolumeDelta = t$30756;
            
            //#line 46 "/home/dsl/workspace/plhamK/plham/util/Itayose.x10"
            ((x10.util.ArrayList<plham.Market.AgentUpdate>)buyUpdates).add__0x10$util$ArrayList$$T$O(((buyUpdate$30750)));
            
            //#line 48 "/home/dsl/workspace/plhamK/plham/util/Itayose.x10"
            final plham.Market.AgentUpdate sellUpdate$30757 = ((new plham.Market.AgentUpdate((java.lang.System[]) null).plham$Market$AgentUpdate$$init$S()));
            
            //#line 49 "/home/dsl/workspace/plhamK/plham/util/Itayose.x10"
            final long t$30758 = sellOrder$30739.agentId;
            
            //#line 49 "/home/dsl/workspace/plhamK/plham/util/Itayose.x10"
            sellUpdate$30757.agentId = t$30758;
            
            //#line 50 "/home/dsl/workspace/plhamK/plham/util/Itayose.x10"
            final long t$30759 = sellOrder$30739.marketId;
            
            //#line 50 "/home/dsl/workspace/plhamK/plham/util/Itayose.x10"
            sellUpdate$30757.marketId = t$30759;
            
            //#line 51 "/home/dsl/workspace/plhamK/plham/util/Itayose.x10"
            final long t$30760 = sellOrder$30739.orderId;
            
            //#line 51 "/home/dsl/workspace/plhamK/plham/util/Itayose.x10"
            sellUpdate$30757.orderId = t$30760;
            
            //#line 52 "/home/dsl/workspace/plhamK/plham/util/Itayose.x10"
            final double t$30761 = java.lang.Double.NaN;
            
            //#line 52 "/home/dsl/workspace/plhamK/plham/util/Itayose.x10"
            sellUpdate$30757.price = t$30761;
            
            //#line 53 "/home/dsl/workspace/plhamK/plham/util/Itayose.x10"
            final double t$30762 = java.lang.Double.NaN;
            
            //#line 53 "/home/dsl/workspace/plhamK/plham/util/Itayose.x10"
            sellUpdate$30757.cashAmountDelta = t$30762;
            
            //#line 54 "/home/dsl/workspace/plhamK/plham/util/Itayose.x10"
            final long t$30763 = (-(assetVolumeDelta$30749));
            
            //#line 54 "/home/dsl/workspace/plhamK/plham/util/Itayose.x10"
            sellUpdate$30757.assetVolumeDelta = t$30763;
            
            //#line 55 "/home/dsl/workspace/plhamK/plham/util/Itayose.x10"
            ((x10.util.ArrayList<plham.Market.AgentUpdate>)sellUpdates).add__0x10$util$ArrayList$$T$O(((sellUpdate$30757)));
            
            //#line 57 "/home/dsl/workspace/plhamK/plham/util/Itayose.x10"
            final long t$30764 = buyOrder$30737.getVolume$O();
            
            //#line 57 "/home/dsl/workspace/plhamK/plham/util/Itayose.x10"
            final boolean t$30765 = ((t$30764) <= (((0L))));
            
            //#line 57 "/home/dsl/workspace/plhamK/plham/util/Itayose.x10"
            if (t$30765) {
                
                //#line 58 "/home/dsl/workspace/plhamK/plham/util/Itayose.x10"
                final plham.OrderBook t$30766 = ((market.buyOrderBook));
                
                //#line 58 "/home/dsl/workspace/plhamK/plham/util/Itayose.x10"
                t$30766.remove(((buyOrder$30737)));
            }
            
            //#line 60 "/home/dsl/workspace/plhamK/plham/util/Itayose.x10"
            final long t$30767 = sellOrder$30739.getVolume$O();
            
            //#line 60 "/home/dsl/workspace/plhamK/plham/util/Itayose.x10"
            final boolean t$30768 = ((t$30767) <= (((0L))));
            
            //#line 60 "/home/dsl/workspace/plhamK/plham/util/Itayose.x10"
            if (t$30768) {
                
                //#line 61 "/home/dsl/workspace/plhamK/plham/util/Itayose.x10"
                final plham.OrderBook t$30769 = ((market.sellOrderBook));
                
                //#line 61 "/home/dsl/workspace/plhamK/plham/util/Itayose.x10"
                t$30769.remove(((sellOrder$30739)));
            }
        }
        
        //#line 66 "/home/dsl/workspace/plhamK/plham/util/Itayose.x10"
        final double t$30677 = lastBuyPrice;
        
        //#line 66 "/home/dsl/workspace/plhamK/plham/util/Itayose.x10"
        final double t$30678 = lastSellPrice;
        
        //#line 66 "/home/dsl/workspace/plhamK/plham/util/Itayose.x10"
        final double t$30679 = ((t$30677) + (((t$30678))));
        
        //#line 66 "/home/dsl/workspace/plhamK/plham/util/Itayose.x10"
        final double exchangePrice = ((t$30679) / (((2.0))));
        
        //#line 67 "/home/dsl/workspace/plhamK/plham/util/Itayose.x10"
        final x10.util.ListIterator update$30784 = (((x10.util.ArrayList<plham.Market.AgentUpdate>)buyUpdates).iterator());
        
        //#line 67 "/home/dsl/workspace/plhamK/plham/util/Itayose.x10"
        for (;
             true;
             ) {
            
            //#line 67 "/home/dsl/workspace/plhamK/plham/util/Itayose.x10"
            final boolean t$30785 = ((x10.util.ListIterator<plham.Market.AgentUpdate>)update$30784).hasNext$O();
            
            //#line 67 "/home/dsl/workspace/plhamK/plham/util/Itayose.x10"
            if (!(t$30785)) {
                
                //#line 67 "/home/dsl/workspace/plhamK/plham/util/Itayose.x10"
                break;
            }
            
            //#line 67 "/home/dsl/workspace/plhamK/plham/util/Itayose.x10"
            final plham.Market.AgentUpdate update$30770 = ((((x10.util.ListIterator<plham.Market.AgentUpdate>)update$30784).next$G()));
            
            //#line 68 "/home/dsl/workspace/plhamK/plham/util/Itayose.x10"
            final long t$30771 = update$30770.assetVolumeDelta;
            
            //#line 68 "/home/dsl/workspace/plhamK/plham/util/Itayose.x10"
            final long exchangeVolume$30772 = java.lang.Math.abs(((t$30771)));
            
            //#line 69 "/home/dsl/workspace/plhamK/plham/util/Itayose.x10"
            final double t$30773 = ((((exchangeVolume$30772))));
            
            //#line 69 "/home/dsl/workspace/plhamK/plham/util/Itayose.x10"
            final double cashAmountDelta$30774 = ((exchangePrice) * (((t$30773))));
            
            //#line 70 "/home/dsl/workspace/plhamK/plham/util/Itayose.x10"
            update$30770.price = exchangePrice;
            
            //#line 71 "/home/dsl/workspace/plhamK/plham/util/Itayose.x10"
            final double t$30775 = (-(cashAmountDelta$30774));
            
            //#line 71 "/home/dsl/workspace/plhamK/plham/util/Itayose.x10"
            update$30770.cashAmountDelta = t$30775;
        }
        
        //#line 73 "/home/dsl/workspace/plhamK/plham/util/Itayose.x10"
        final x10.util.ListIterator update$30786 = (((x10.util.ArrayList<plham.Market.AgentUpdate>)sellUpdates).iterator());
        
        //#line 73 "/home/dsl/workspace/plhamK/plham/util/Itayose.x10"
        for (;
             true;
             ) {
            
            //#line 73 "/home/dsl/workspace/plhamK/plham/util/Itayose.x10"
            final boolean t$30787 = ((x10.util.ListIterator<plham.Market.AgentUpdate>)update$30786).hasNext$O();
            
            //#line 73 "/home/dsl/workspace/plhamK/plham/util/Itayose.x10"
            if (!(t$30787)) {
                
                //#line 73 "/home/dsl/workspace/plhamK/plham/util/Itayose.x10"
                break;
            }
            
            //#line 73 "/home/dsl/workspace/plhamK/plham/util/Itayose.x10"
            final plham.Market.AgentUpdate update$30776 = ((((x10.util.ListIterator<plham.Market.AgentUpdate>)update$30786).next$G()));
            
            //#line 74 "/home/dsl/workspace/plhamK/plham/util/Itayose.x10"
            final long t$30777 = update$30776.assetVolumeDelta;
            
            //#line 74 "/home/dsl/workspace/plhamK/plham/util/Itayose.x10"
            final long exchangeVolume$30778 = java.lang.Math.abs(((t$30777)));
            
            //#line 75 "/home/dsl/workspace/plhamK/plham/util/Itayose.x10"
            final double t$30779 = ((((exchangeVolume$30778))));
            
            //#line 75 "/home/dsl/workspace/plhamK/plham/util/Itayose.x10"
            final double cashAmountDelta$30780 = ((exchangePrice) * (((t$30779))));
            
            //#line 76 "/home/dsl/workspace/plhamK/plham/util/Itayose.x10"
            update$30776.price = exchangePrice;
            
            //#line 77 "/home/dsl/workspace/plhamK/plham/util/Itayose.x10"
            final double t$30781 = (+(cashAmountDelta$30780));
            
            //#line 77 "/home/dsl/workspace/plhamK/plham/util/Itayose.x10"
            update$30776.cashAmountDelta = t$30781;
        }
        
        //#line 80 "/home/dsl/workspace/plhamK/plham/util/Itayose.x10"
        final long t = market.getTime$O();
        
        //#line 81 "/home/dsl/workspace/plhamK/plham/util/Itayose.x10"
        final x10.util.List a$30586 = ((market.executedOrdersCounts));
        
        //#line 81 "/home/dsl/workspace/plhamK/plham/util/Itayose.x10"
        final long i0$30587 = t;
        
        //#line 81 "/home/dsl/workspace/plhamK/plham/util/Itayose.x10"
        final long t$30690 = x10.core.Long.$unbox(((x10.util.Indexed<x10.core.Long>)a$30586).$apply$G((i0$30587)));
        
        //#line 81 "/home/dsl/workspace/plhamK/plham/util/Itayose.x10"
        final long t$30691 = ((x10.util.ArrayList<plham.Market.AgentUpdate>)buyUpdates).size$O();
        
        //#line 81 "/home/dsl/workspace/plhamK/plham/util/Itayose.x10"
        final long r$30595 = ((t$30690) + (((t$30691))));
        
        //#line 81 "/home/dsl/workspace/plhamK/plham/util/Itayose.x10"
        ((x10.lang.Settable<x10.core.Long, x10.core.Long>)a$30586).$set(x10.core.Long.$box(i0$30587), x10.rtt.Types.LONG, x10.core.Long.$box(r$30595), x10.rtt.Types.LONG);
        
        //#line 82 "/home/dsl/workspace/plhamK/plham/util/Itayose.x10"
        final x10.util.List t$30692 = ((market.lastExecutedPrices));
        
        //#line 82 "/home/dsl/workspace/plhamK/plham/util/Itayose.x10"
        ((x10.lang.Settable<x10.core.Long, x10.core.Double>)t$30692).$set(x10.core.Long.$box(t), x10.rtt.Types.LONG, x10.core.Double.$box(exchangePrice), x10.rtt.Types.DOUBLE);
        
        //#line 83 "/home/dsl/workspace/plhamK/plham/util/Itayose.x10"
        final x10.util.List t$30696 = ((market.sumExecutedVolumes));
        
        //#line 83 "/home/dsl/workspace/plhamK/plham/util/Itayose.x10"
        final x10.util.List t$30693 = ((market.sumExecutedVolumes));
        
        //#line 83 "/home/dsl/workspace/plhamK/plham/util/Itayose.x10"
        final long t$30694 = x10.core.Long.$unbox(((x10.util.Indexed<x10.core.Long>)t$30693).$apply$G((t)));
        
        //#line 83 "/home/dsl/workspace/plhamK/plham/util/Itayose.x10"
        final long t$30695 = sumExchangeVolume;
        
        //#line 83 "/home/dsl/workspace/plhamK/plham/util/Itayose.x10"
        final long t$30697 = ((t$30694) + (((t$30695))));
        
        //#line 83 "/home/dsl/workspace/plhamK/plham/util/Itayose.x10"
        ((x10.lang.Settable<x10.core.Long, x10.core.Long>)t$30696).$set(x10.core.Long.$box(t), x10.rtt.Types.LONG, x10.core.Long.$box(t$30697), x10.rtt.Types.LONG);
        
        //#line 85 "/home/dsl/workspace/plhamK/plham/util/Itayose.x10"
        final x10.io.Printer t$30698 = ((x10.io.Console.get$OUT()));
        
        //#line 85 "/home/dsl/workspace/plhamK/plham/util/Itayose.x10"
        final java.lang.String t$30699 = (("# Itayose exchangePrice ") + ((x10.core.Double.$box(exchangePrice))));
        
        //#line 85 "/home/dsl/workspace/plhamK/plham/util/Itayose.x10"
        t$30698.println(((t$30699)));
        
        //#line 87 "/home/dsl/workspace/plhamK/plham/util/Itayose.x10"
        final x10.util.ListIterator update$30788 = (((x10.util.ArrayList<plham.Market.AgentUpdate>)buyUpdates).iterator());
        
        //#line 87 "/home/dsl/workspace/plhamK/plham/util/Itayose.x10"
        for (;
             true;
             ) {
            
            //#line 87 "/home/dsl/workspace/plhamK/plham/util/Itayose.x10"
            final boolean t$30789 = ((x10.util.ListIterator<plham.Market.AgentUpdate>)update$30788).hasNext$O();
            
            //#line 87 "/home/dsl/workspace/plhamK/plham/util/Itayose.x10"
            if (!(t$30789)) {
                
                //#line 87 "/home/dsl/workspace/plhamK/plham/util/Itayose.x10"
                break;
            }
            
            //#line 87 "/home/dsl/workspace/plhamK/plham/util/Itayose.x10"
            final plham.Market.AgentUpdate update$30782 = ((((x10.util.ListIterator<plham.Market.AgentUpdate>)update$30788).next$G()));
            
            //#line 88 "/home/dsl/workspace/plhamK/plham/util/Itayose.x10"
            market.handleAgentUpdate(((update$30782)));
        }
        
        //#line 90 "/home/dsl/workspace/plhamK/plham/util/Itayose.x10"
        final x10.util.ListIterator update$30790 = (((x10.util.ArrayList<plham.Market.AgentUpdate>)sellUpdates).iterator());
        
        //#line 90 "/home/dsl/workspace/plhamK/plham/util/Itayose.x10"
        for (;
             true;
             ) {
            
            //#line 90 "/home/dsl/workspace/plhamK/plham/util/Itayose.x10"
            final boolean t$30791 = ((x10.util.ListIterator<plham.Market.AgentUpdate>)update$30790).hasNext$O();
            
            //#line 90 "/home/dsl/workspace/plhamK/plham/util/Itayose.x10"
            if (!(t$30791)) {
                
                //#line 90 "/home/dsl/workspace/plhamK/plham/util/Itayose.x10"
                break;
            }
            
            //#line 90 "/home/dsl/workspace/plhamK/plham/util/Itayose.x10"
            final plham.Market.AgentUpdate update$30783 = ((((x10.util.ListIterator<plham.Market.AgentUpdate>)update$30790).next$G()));
            
            //#line 91 "/home/dsl/workspace/plhamK/plham/util/Itayose.x10"
            market.handleAgentUpdate(((update$30783)));
        }
    }
    
    
    //#line 95 "/home/dsl/workspace/plhamK/plham/util/Itayose.x10"
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
            Itayose.main(args);
        }
    }
    
    // the original app-main method
    public static void main(final x10.core.Rail<java.lang.String> args) {
        
        //#line 97 "/home/dsl/workspace/plhamK/plham/util/Itayose.x10"
        final x10.util.Random t$30704 = ((new x10.util.Random((java.lang.System[]) null).x10$util$Random$$init$S()));
        
        //#line 97 "/home/dsl/workspace/plhamK/plham/util/Itayose.x10"
        final plham.util.RandomHelper random = ((new plham.util.RandomHelper((java.lang.System[]) null).plham$util$RandomHelper$$init$S(((t$30704)))));
        
        //#line 99 "/home/dsl/workspace/plhamK/plham/util/Itayose.x10"
        final plham.Market market = ((new plham.Market((java.lang.System[]) null).plham$Market$$init$S(((-1L)))));
        
        //#line 100 "/home/dsl/workspace/plhamK/plham/util/Itayose.x10"
        market.setInitialMarketPrice((300.0));
        
        //#line 101 "/home/dsl/workspace/plhamK/plham/util/Itayose.x10"
        market.setInitialFundamentalPrice((300.0));
        
        //#line 102 "/home/dsl/workspace/plhamK/plham/util/Itayose.x10"
        market.setOutstandingShares$O((10000L));
        
        //#line 104 "/home/dsl/workspace/plhamK/plham/util/Itayose.x10"
        final plham.Env t$30705 = ((new plham.Env((java.lang.System[]) null).init()));
        
        //#line 104 "/home/dsl/workspace/plhamK/plham/util/Itayose.x10"
        market.env = ((t$30705));
        
        //#line 106 "/home/dsl/workspace/plhamK/plham/util/Itayose.x10"
        final plham.agent.TestAgent agent = ((new plham.agent.TestAgent((java.lang.System[]) null).plham$agent$TestAgent$$init$S(((0L)))));
        
        //#line 107 "/home/dsl/workspace/plhamK/plham/util/Itayose.x10"
        agent.setMarketAccessible$O(((market)));
        
        //#line 109 "/home/dsl/workspace/plhamK/plham/util/Itayose.x10"
        final x10.util.ArrayList agents = ((new x10.util.ArrayList<plham.Agent>((java.lang.System[]) null, plham.Agent.$RTT).x10$util$ArrayList$$init$S()));
        
        //#line 110 "/home/dsl/workspace/plhamK/plham/util/Itayose.x10"
        ((x10.util.ArrayList<plham.Agent>)agents).add__0x10$util$ArrayList$$T$O(((agent)));
        
        //#line 111 "/home/dsl/workspace/plhamK/plham/util/Itayose.x10"
        final plham.Env t$30706 = ((market.env));
        
        //#line 111 "/home/dsl/workspace/plhamK/plham/util/Itayose.x10"
        t$30706.agents = ((agents));
        
        //#line 114 "/home/dsl/workspace/plhamK/plham/util/Itayose.x10"
        final x10.core.fun.Fun_0_1 t$30714 = ((new plham.util.Itayose.$Closure$18(random)));
        
        //#line 115 "/home/dsl/workspace/plhamK/plham/util/Itayose.x10"
        final x10.core.fun.Fun_0_0 t$30715 = ((new plham.util.Itayose.$Closure$19()));
        
        //#line 116 "/home/dsl/workspace/plhamK/plham/util/Itayose.x10"
        final x10.core.fun.Fun_0_0 t$30716 = ((new plham.util.Itayose.$Closure$20(random)));
        
        //#line 113 "/home/dsl/workspace/plhamK/plham/util/Itayose.x10"
        final plham.util.RandomOrderGenerator rog = ((new plham.util.RandomOrderGenerator((java.lang.System[]) null).plham$util$RandomOrderGenerator$$init$S(((t$30714)), ((t$30715)), ((t$30716)), (plham.util.RandomOrderGenerator.__0$1x10$lang$Double$3x10$lang$Double$2__1$1x10$lang$Long$2__2$1x10$lang$Long$2) null)));
        
        //#line 118 "/home/dsl/workspace/plhamK/plham/util/Itayose.x10"
        market.setRunning$O((false));
        
        //#line 119 "/home/dsl/workspace/plhamK/plham/util/Itayose.x10"
        final x10.core.fun.Fun_0_0 t$30717 = ((new plham.util.Itayose.$Closure$21(agent)));
        
        //#line 119 "/home/dsl/workspace/plhamK/plham/util/Itayose.x10"
        final x10.util.List orders = rog.get__1$1plham$Agent$2(((market)), ((t$30717)), (100L));
        
        //#line 120 "/home/dsl/workspace/plhamK/plham/util/Itayose.x10"
        final x10.util.ListIterator order$30797 = (((x10.util.List<plham.Order>)orders).iterator());
        
        //#line 120 "/home/dsl/workspace/plhamK/plham/util/Itayose.x10"
        for (;
             true;
             ) {
            
            //#line 120 "/home/dsl/workspace/plhamK/plham/util/Itayose.x10"
            final boolean t$30798 = ((x10.util.ListIterator<plham.Order>)order$30797).hasNext$O();
            
            //#line 120 "/home/dsl/workspace/plhamK/plham/util/Itayose.x10"
            if (!(t$30798)) {
                
                //#line 120 "/home/dsl/workspace/plhamK/plham/util/Itayose.x10"
                break;
            }
            
            //#line 120 "/home/dsl/workspace/plhamK/plham/util/Itayose.x10"
            final plham.Order order$30792 = ((((x10.util.ListIterator<plham.Order>)order$30797).next$G()));
            
            //#line 121 "/home/dsl/workspace/plhamK/plham/util/Itayose.x10"
            final double t$30793 = random.nextDouble$O();
            
            //#line 121 "/home/dsl/workspace/plhamK/plham/util/Itayose.x10"
            final boolean t$30794 = ((t$30793) < (((0.5))));
            
            //#line 121 "/home/dsl/workspace/plhamK/plham/util/Itayose.x10"
            if (t$30794) {
                
                //#line 122 "/home/dsl/workspace/plhamK/plham/util/Itayose.x10"
                final plham.Order.Kind t$30795 = ((plham.Order.get$KIND_BUY_LIMIT_ORDER()));
                
                //#line 122 "/home/dsl/workspace/plhamK/plham/util/Itayose.x10"
                order$30792.kind = ((t$30795));
            } else {
                
                //#line 124 "/home/dsl/workspace/plhamK/plham/util/Itayose.x10"
                final plham.Order.Kind t$30796 = ((plham.Order.get$KIND_SELL_LIMIT_ORDER()));
                
                //#line 124 "/home/dsl/workspace/plhamK/plham/util/Itayose.x10"
                order$30792.kind = ((t$30796));
            }
        }
        
        //#line 127 "/home/dsl/workspace/plhamK/plham/util/Itayose.x10"
        market.handleOrders__0$1plham$Order$2(((orders)));
        
        //#line 129 "/home/dsl/workspace/plhamK/plham/util/Itayose.x10"
        final x10.io.Printer t$30724 = ((x10.io.Console.get$OUT()));
        
        //#line 129 "/home/dsl/workspace/plhamK/plham/util/Itayose.x10"
        t$30724.println((("######## SELL SIDE ########")));
        
        //#line 130 "/home/dsl/workspace/plhamK/plham/util/Itayose.x10"
        final plham.OrderBook t$30725 = ((market.getSellOrderBook()));
        
        //#line 130 "/home/dsl/workspace/plhamK/plham/util/Itayose.x10"
        final x10.core.fun.Fun_0_2 t$30726 = ((plham.OrderBook.get$HIGHERS_FIRST()));
        
        //#line 130 "/home/dsl/workspace/plhamK/plham/util/Itayose.x10"
        t$30725.dump__0$1plham$Order$3plham$Order$3x10$lang$Int$2(((t$30726)));
        
        //#line 131 "/home/dsl/workspace/plhamK/plham/util/Itayose.x10"
        final x10.io.Printer t$30727 = ((x10.io.Console.get$OUT()));
        
        //#line 131 "/home/dsl/workspace/plhamK/plham/util/Itayose.x10"
        t$30727.println((("######## BUY  SIDE ########")));
        
        //#line 132 "/home/dsl/workspace/plhamK/plham/util/Itayose.x10"
        final plham.OrderBook t$30728 = ((market.getBuyOrderBook()));
        
        //#line 132 "/home/dsl/workspace/plhamK/plham/util/Itayose.x10"
        final x10.core.fun.Fun_0_2 t$30729 = ((plham.OrderBook.get$HIGHERS_FIRST()));
        
        //#line 132 "/home/dsl/workspace/plhamK/plham/util/Itayose.x10"
        t$30728.dump__0$1plham$Order$3plham$Order$3x10$lang$Int$2(((t$30729)));
        
        //#line 134 "/home/dsl/workspace/plhamK/plham/util/Itayose.x10"
        plham.util.Itayose.itayose(((market)));
        
        //#line 136 "/home/dsl/workspace/plhamK/plham/util/Itayose.x10"
        final x10.io.Printer t$30730 = ((x10.io.Console.get$OUT()));
        
        //#line 136 "/home/dsl/workspace/plhamK/plham/util/Itayose.x10"
        t$30730.println((("######## SELL SIDE ########")));
        
        //#line 137 "/home/dsl/workspace/plhamK/plham/util/Itayose.x10"
        final plham.OrderBook t$30731 = ((market.getSellOrderBook()));
        
        //#line 137 "/home/dsl/workspace/plhamK/plham/util/Itayose.x10"
        final x10.core.fun.Fun_0_2 t$30732 = ((plham.OrderBook.get$HIGHERS_FIRST()));
        
        //#line 137 "/home/dsl/workspace/plhamK/plham/util/Itayose.x10"
        t$30731.dump__0$1plham$Order$3plham$Order$3x10$lang$Int$2(((t$30732)));
        
        //#line 138 "/home/dsl/workspace/plhamK/plham/util/Itayose.x10"
        final x10.io.Printer t$30733 = ((x10.io.Console.get$OUT()));
        
        //#line 138 "/home/dsl/workspace/plhamK/plham/util/Itayose.x10"
        t$30733.println((("######## BUY  SIDE ########")));
        
        //#line 139 "/home/dsl/workspace/plhamK/plham/util/Itayose.x10"
        final plham.OrderBook t$30734 = ((market.getBuyOrderBook()));
        
        //#line 139 "/home/dsl/workspace/plhamK/plham/util/Itayose.x10"
        final x10.core.fun.Fun_0_2 t$30735 = ((plham.OrderBook.get$HIGHERS_FIRST()));
        
        //#line 139 "/home/dsl/workspace/plhamK/plham/util/Itayose.x10"
        t$30734.dump__0$1plham$Order$3plham$Order$3x10$lang$Int$2(((t$30735)));
    }
    
    
    //#line 14 "/home/dsl/workspace/plhamK/plham/util/Itayose.x10"
    final public plham.util.Itayose plham$util$Itayose$$this$plham$util$Itayose() {
        
        //#line 14 "/home/dsl/workspace/plhamK/plham/util/Itayose.x10"
        return plham.util.Itayose.this;
    }
    
    
    //#line 14 "/home/dsl/workspace/plhamK/plham/util/Itayose.x10"
    // creation method for java code (1-phase java constructor)
    public Itayose() {
        this((java.lang.System[]) null);
        plham$util$Itayose$$init$S();
    }
    
    // constructor for non-virtual call
    final public plham.util.Itayose plham$util$Itayose$$init$S() {
         {
            
            //#line 14 "/home/dsl/workspace/plhamK/plham/util/Itayose.x10"
            
            
            //#line 14 "/home/dsl/workspace/plhamK/plham/util/Itayose.x10"
            this.__fieldInitializers_plham_util_Itayose();
        }
        return this;
    }
    
    
    
    //#line 14 "/home/dsl/workspace/plhamK/plham/util/Itayose.x10"
    final public void __fieldInitializers_plham_util_Itayose() {
        
    }
    
    
    final public static class $Closure$18 extends x10.core.Ref implements x10.core.fun.Fun_0_1, x10.serialization.X10JavaSerializable
    {
        public static final x10.rtt.RuntimeType<$Closure$18> $RTT = 
            x10.rtt.StaticFunType.<$Closure$18> make($Closure$18.class,
                                                     new x10.rtt.Type[] {
                                                         x10.rtt.ParameterizedType.make(x10.core.fun.Fun_0_1.$RTT, x10.rtt.Types.DOUBLE, x10.rtt.Types.DOUBLE)
                                                     });
        
        public x10.rtt.RuntimeType<?> $getRTT() { return $RTT; }
        
        public x10.rtt.Type<?> $getParam(int i) { return null; }
        
        private Object writeReplace() throws java.io.ObjectStreamException {
            return new x10.serialization.SerializationProxy(this);
        }
        
        public static x10.serialization.X10JavaSerializable $_deserialize_body(plham.util.Itayose.$Closure$18 $_obj, x10.serialization.X10JavaDeserializer $deserializer) throws java.io.IOException {
            if (x10.runtime.impl.java.Runtime.TRACE_SER) { x10.runtime.impl.java.Runtime.printTraceMessage("X10JavaSerializable: $_deserialize_body() of " + $Closure$18.class + " calling"); } 
            $_obj.random = $deserializer.readObject();
            return $_obj;
        }
        
        public static x10.serialization.X10JavaSerializable $_deserializer(x10.serialization.X10JavaDeserializer $deserializer) throws java.io.IOException {
            plham.util.Itayose.$Closure$18 $_obj = new plham.util.Itayose.$Closure$18((java.lang.System[]) null);
            $deserializer.record_reference($_obj);
            return $_deserialize_body($_obj, $deserializer);
        }
        
        public void $_serialize(x10.serialization.X10JavaSerializer $serializer) throws java.io.IOException {
            $serializer.write(this.random);
            
        }
        
        // constructor just for allocation
        public $Closure$18(final java.lang.System[] $dummy) {
            
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
            
            //#line 114 "/home/dsl/workspace/plhamK/plham/util/Itayose.x10"
            final double t$30707 = this.random.nextGaussian$O();
            
            //#line 114 "/home/dsl/workspace/plhamK/plham/util/Itayose.x10"
            final double t$30708 = ((((10L))));
            
            //#line 114 "/home/dsl/workspace/plhamK/plham/util/Itayose.x10"
            final double t$30709 = ((t$30707) * (((t$30708))));
            
            //#line 114 "/home/dsl/workspace/plhamK/plham/util/Itayose.x10"
            final double t$30710 = ((p) + (((t$30709))));
            
            //#line 114 "/home/dsl/workspace/plhamK/plham/util/Itayose.x10"
            final double t$30711 = java.lang.Math.max(((0.0)),((t$30710)));
            
            //#line 114 "/home/dsl/workspace/plhamK/plham/util/Itayose.x10"
            return t$30711;
        }
        
        public plham.util.RandomHelper random;
        
        public $Closure$18(final plham.util.RandomHelper random) {
             {
                this.random = ((random));
            }
        }
        
    }
    
    
    final public static class $Closure$19 extends x10.core.Ref implements x10.core.fun.Fun_0_0, x10.serialization.X10JavaSerializable
    {
        public static final x10.rtt.RuntimeType<$Closure$19> $RTT = 
            x10.rtt.StaticFunType.<$Closure$19> make($Closure$19.class,
                                                     new x10.rtt.Type[] {
                                                         x10.rtt.ParameterizedType.make(x10.core.fun.Fun_0_0.$RTT, x10.rtt.Types.LONG)
                                                     });
        
        public x10.rtt.RuntimeType<?> $getRTT() { return $RTT; }
        
        public x10.rtt.Type<?> $getParam(int i) { return null; }
        
        private Object writeReplace() throws java.io.ObjectStreamException {
            return new x10.serialization.SerializationProxy(this);
        }
        
        public static x10.serialization.X10JavaSerializable $_deserialize_body(plham.util.Itayose.$Closure$19 $_obj, x10.serialization.X10JavaDeserializer $deserializer) throws java.io.IOException {
            if (x10.runtime.impl.java.Runtime.TRACE_SER) { x10.runtime.impl.java.Runtime.printTraceMessage("X10JavaSerializable: $_deserialize_body() of " + $Closure$19.class + " calling"); } 
            return $_obj;
        }
        
        public static x10.serialization.X10JavaSerializable $_deserializer(x10.serialization.X10JavaDeserializer $deserializer) throws java.io.IOException {
            plham.util.Itayose.$Closure$19 $_obj = new plham.util.Itayose.$Closure$19((java.lang.System[]) null);
            $deserializer.record_reference($_obj);
            return $_deserialize_body($_obj, $deserializer);
        }
        
        public void $_serialize(x10.serialization.X10JavaSerializer $serializer) throws java.io.IOException {
            
        }
        
        // constructor just for allocation
        public $Closure$19(final java.lang.System[] $dummy) {
            
        }
        
        // bridge for method abstract public ()=>U.operator()():U
        public x10.core.Long $apply$G() {
            return x10.core.Long.$box($apply$O());
        }
        
        
    
        
        public long $apply$O() {
            
            //#line 115 "/home/dsl/workspace/plhamK/plham/util/Itayose.x10"
            return 1L;
        }
        
        public $Closure$19() {
             {
                
            }
        }
        
    }
    
    
    final public static class $Closure$20 extends x10.core.Ref implements x10.core.fun.Fun_0_0, x10.serialization.X10JavaSerializable
    {
        public static final x10.rtt.RuntimeType<$Closure$20> $RTT = 
            x10.rtt.StaticFunType.<$Closure$20> make($Closure$20.class,
                                                     new x10.rtt.Type[] {
                                                         x10.rtt.ParameterizedType.make(x10.core.fun.Fun_0_0.$RTT, x10.rtt.Types.LONG)
                                                     });
        
        public x10.rtt.RuntimeType<?> $getRTT() { return $RTT; }
        
        public x10.rtt.Type<?> $getParam(int i) { return null; }
        
        private Object writeReplace() throws java.io.ObjectStreamException {
            return new x10.serialization.SerializationProxy(this);
        }
        
        public static x10.serialization.X10JavaSerializable $_deserialize_body(plham.util.Itayose.$Closure$20 $_obj, x10.serialization.X10JavaDeserializer $deserializer) throws java.io.IOException {
            if (x10.runtime.impl.java.Runtime.TRACE_SER) { x10.runtime.impl.java.Runtime.printTraceMessage("X10JavaSerializable: $_deserialize_body() of " + $Closure$20.class + " calling"); } 
            $_obj.random = $deserializer.readObject();
            return $_obj;
        }
        
        public static x10.serialization.X10JavaSerializable $_deserializer(x10.serialization.X10JavaDeserializer $deserializer) throws java.io.IOException {
            plham.util.Itayose.$Closure$20 $_obj = new plham.util.Itayose.$Closure$20((java.lang.System[]) null);
            $deserializer.record_reference($_obj);
            return $_deserialize_body($_obj, $deserializer);
        }
        
        public void $_serialize(x10.serialization.X10JavaSerializer $serializer) throws java.io.IOException {
            $serializer.write(this.random);
            
        }
        
        // constructor just for allocation
        public $Closure$20(final java.lang.System[] $dummy) {
            
        }
        
        // bridge for method abstract public ()=>U.operator()():U
        public x10.core.Long $apply$G() {
            return x10.core.Long.$box($apply$O());
        }
        
        
    
        
        public long $apply$O() {
            
            //#line 116 "/home/dsl/workspace/plhamK/plham/util/Itayose.x10"
            final long t$30712 = this.random.nextLong$O((100L));
            
            //#line 116 "/home/dsl/workspace/plhamK/plham/util/Itayose.x10"
            final long t$30713 = ((t$30712) + (((10L))));
            
            //#line 116 "/home/dsl/workspace/plhamK/plham/util/Itayose.x10"
            return t$30713;
        }
        
        public plham.util.RandomHelper random;
        
        public $Closure$20(final plham.util.RandomHelper random) {
             {
                this.random = ((random));
            }
        }
        
    }
    
    
    final public static class $Closure$21 extends x10.core.Ref implements x10.core.fun.Fun_0_0, x10.serialization.X10JavaSerializable
    {
        public static final x10.rtt.RuntimeType<$Closure$21> $RTT = 
            x10.rtt.StaticFunType.<$Closure$21> make($Closure$21.class,
                                                     new x10.rtt.Type[] {
                                                         x10.rtt.ParameterizedType.make(x10.core.fun.Fun_0_0.$RTT, plham.agent.TestAgent.$RTT)
                                                     });
        
        public x10.rtt.RuntimeType<?> $getRTT() { return $RTT; }
        
        public x10.rtt.Type<?> $getParam(int i) { return null; }
        
        private Object writeReplace() throws java.io.ObjectStreamException {
            return new x10.serialization.SerializationProxy(this);
        }
        
        public static x10.serialization.X10JavaSerializable $_deserialize_body(plham.util.Itayose.$Closure$21 $_obj, x10.serialization.X10JavaDeserializer $deserializer) throws java.io.IOException {
            if (x10.runtime.impl.java.Runtime.TRACE_SER) { x10.runtime.impl.java.Runtime.printTraceMessage("X10JavaSerializable: $_deserialize_body() of " + $Closure$21.class + " calling"); } 
            $_obj.agent = $deserializer.readObject();
            return $_obj;
        }
        
        public static x10.serialization.X10JavaSerializable $_deserializer(x10.serialization.X10JavaDeserializer $deserializer) throws java.io.IOException {
            plham.util.Itayose.$Closure$21 $_obj = new plham.util.Itayose.$Closure$21((java.lang.System[]) null);
            $deserializer.record_reference($_obj);
            return $_deserialize_body($_obj, $deserializer);
        }
        
        public void $_serialize(x10.serialization.X10JavaSerializer $serializer) throws java.io.IOException {
            $serializer.write(this.agent);
            
        }
        
        // constructor just for allocation
        public $Closure$21(final java.lang.System[] $dummy) {
            
        }
        
        // bridge for method abstract public ()=>U.operator()():U
        public plham.agent.TestAgent $apply$G() {
            return $apply();
        }
        
        
    
        
        public plham.agent.TestAgent $apply() {
            
            //#line 119 "/home/dsl/workspace/plhamK/plham/util/Itayose.x10"
            return this.agent;
        }
        
        public plham.agent.TestAgent agent;
        
        public $Closure$21(final plham.agent.TestAgent agent) {
             {
                this.agent = ((agent));
            }
        }
        
    }
    
}

