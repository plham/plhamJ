package plham.agent;



public class TestAgent extends plham.Agent implements x10.serialization.X10JavaSerializable
{
    public static final x10.rtt.RuntimeType<TestAgent> $RTT = 
        x10.rtt.NamedType.<TestAgent> make("plham.agent.TestAgent",
                                           TestAgent.class,
                                           new x10.rtt.Type[] {
                                               plham.Agent.$RTT
                                           });
    
    public x10.rtt.RuntimeType<?> $getRTT() { return $RTT; }
    
    public x10.rtt.Type<?> $getParam(int i) { return null; }
    
    private Object writeReplace() throws java.io.ObjectStreamException {
        return new x10.serialization.SerializationProxy(this);
    }
    
    public static x10.serialization.X10JavaSerializable $_deserialize_body(plham.agent.TestAgent $_obj, x10.serialization.X10JavaDeserializer $deserializer) throws java.io.IOException {
        if (x10.runtime.impl.java.Runtime.TRACE_SER) { x10.runtime.impl.java.Runtime.printTraceMessage("X10JavaSerializable: $_deserialize_body() of " + TestAgent.class + " calling"); } 
        plham.Agent.$_deserialize_body($_obj, $deserializer);
        return $_obj;
    }
    
    public static x10.serialization.X10JavaSerializable $_deserializer(x10.serialization.X10JavaDeserializer $deserializer) throws java.io.IOException {
        plham.agent.TestAgent $_obj = new plham.agent.TestAgent((java.lang.System[]) null);
        $deserializer.record_reference($_obj);
        return $_deserialize_body($_obj, $deserializer);
    }
    
    public void $_serialize(x10.serialization.X10JavaSerializer $serializer) throws java.io.IOException {
        super.$_serialize($serializer);
        
    }
    
    // constructor just for allocation
    public TestAgent(final java.lang.System[] $dummy) {
        super($dummy);
        
    }
    
    

    
    
    //#line 19 "/home/dsl/workspace/plhamK/plham/agent/TestAgent.x10"
    // creation method for java code (1-phase java constructor)
    public TestAgent(final long id) {
        this((java.lang.System[]) null);
        plham$agent$TestAgent$$init$S(id);
    }
    
    // constructor for non-virtual call
    final public plham.agent.TestAgent plham$agent$TestAgent$$init$S(final long id) {
         {
            
            //#line 19 "/home/dsl/workspace/plhamK/plham/agent/TestAgent.x10"
            final x10.util.Random t$35730 = ((new x10.util.Random((java.lang.System[]) null).x10$util$Random$$init$S()));
            
            //#line 19 "/home/dsl/workspace/plhamK/plham/agent/TestAgent.x10"
            /*super.*/initAgent(((id)), (("test-agent")), ((t$35730)));
            
            //#line 19 "/home/dsl/workspace/plhamK/plham/agent/TestAgent.x10"
            
            
            //#line 18 "/home/dsl/workspace/plhamK/plham/agent/TestAgent.x10"
            this.__fieldInitializers_plham_agent_TestAgent();
        }
        return this;
    }
    
    
    
    //#line 20 "/home/dsl/workspace/plhamK/plham/agent/TestAgent.x10"
    public x10.util.ArrayList submitOrders(final x10.util.List markets) {
        
        //#line 21 "/home/dsl/workspace/plhamK/plham/agent/TestAgent.x10"
        final double MARGIN_SCALE = 10.0;
        
        //#line 22 "/home/dsl/workspace/plhamK/plham/agent/TestAgent.x10"
        final long VOLUME_SCALE = 100L;
        
        //#line 23 "/home/dsl/workspace/plhamK/plham/agent/TestAgent.x10"
        final long TIME_LENGTH_SCALE = 100L;
        
        //#line 24 "/home/dsl/workspace/plhamK/plham/agent/TestAgent.x10"
        final double BUY_CHANCE = 0.4;
        
        //#line 25 "/home/dsl/workspace/plhamK/plham/agent/TestAgent.x10"
        final double SELL_CHANCE = 0.4;
        
        //#line 27 "/home/dsl/workspace/plhamK/plham/agent/TestAgent.x10"
        final x10.util.ArrayList orders = ((new x10.util.ArrayList<plham.Order>((java.lang.System[]) null, plham.Order.$RTT).x10$util$ArrayList$$init$S()));
        
        //#line 29 "/home/dsl/workspace/plhamK/plham/agent/TestAgent.x10"
        final x10.util.ListIterator market$35758 = (((x10.util.List<plham.Market>)markets).iterator());
        
        //#line 29 "/home/dsl/workspace/plhamK/plham/agent/TestAgent.x10"
        for (;
             true;
             ) {
            
            //#line 29 "/home/dsl/workspace/plhamK/plham/agent/TestAgent.x10"
            final boolean t$35759 = ((x10.util.ListIterator<plham.Market>)market$35758).hasNext$O();
            
            //#line 29 "/home/dsl/workspace/plhamK/plham/agent/TestAgent.x10"
            if (!(t$35759)) {
                
                //#line 29 "/home/dsl/workspace/plhamK/plham/agent/TestAgent.x10"
                break;
            }
            
            //#line 29 "/home/dsl/workspace/plhamK/plham/agent/TestAgent.x10"
            final plham.Market market$35731 = ((((x10.util.ListIterator<plham.Market>)market$35758).next$G()));
            
            //#line 30 "/home/dsl/workspace/plhamK/plham/agent/TestAgent.x10"
            final boolean t$35732 = this.isMarketAccessible(((market$35731)));
            
            //#line 30 "/home/dsl/workspace/plhamK/plham/agent/TestAgent.x10"
            if (t$35732) {
                
                //#line 31 "/home/dsl/workspace/plhamK/plham/agent/TestAgent.x10"
                final x10.util.Random random$35733 = this.getRandom();
                
                //#line 32 "/home/dsl/workspace/plhamK/plham/agent/TestAgent.x10"
                final long marketTime$35734 = market$35731.getTime$O();
                
                //#line 33 "/home/dsl/workspace/plhamK/plham/agent/TestAgent.x10"
                final double t$35735 = market$35731.getPrice$O();
                
                //#line 33 "/home/dsl/workspace/plhamK/plham/agent/TestAgent.x10"
                final double t$35736 = random$35733.nextDouble$O();
                
                //#line 33 "/home/dsl/workspace/plhamK/plham/agent/TestAgent.x10"
                final double t$35737 = ((((2L))));
                
                //#line 33 "/home/dsl/workspace/plhamK/plham/agent/TestAgent.x10"
                final double t$35738 = ((t$35736) * (((t$35737))));
                
                //#line 33 "/home/dsl/workspace/plhamK/plham/agent/TestAgent.x10"
                final double t$35739 = ((t$35738) * (((MARGIN_SCALE))));
                
                //#line 33 "/home/dsl/workspace/plhamK/plham/agent/TestAgent.x10"
                final double t$35740 = ((t$35739) - (((MARGIN_SCALE))));
                
                //#line 33 "/home/dsl/workspace/plhamK/plham/agent/TestAgent.x10"
                final double price$35741 = ((t$35735) + (((t$35740))));
                
                //#line 34 "/home/dsl/workspace/plhamK/plham/agent/TestAgent.x10"
                final long t$35742 = random$35733.nextLong$O((VOLUME_SCALE));
                
                //#line 34 "/home/dsl/workspace/plhamK/plham/agent/TestAgent.x10"
                final long volume$35743 = ((t$35742) + (((1L))));
                
                //#line 35 "/home/dsl/workspace/plhamK/plham/agent/TestAgent.x10"
                final long t$35744 = random$35733.nextLong$O((TIME_LENGTH_SCALE));
                
                //#line 35 "/home/dsl/workspace/plhamK/plham/agent/TestAgent.x10"
                final long timeLength$35745 = ((t$35744) + (((10L))));
                
                //#line 36 "/home/dsl/workspace/plhamK/plham/agent/TestAgent.x10"
                final double p$35746 = random$35733.nextDouble$O();
                
                //#line 37 "/home/dsl/workspace/plhamK/plham/agent/TestAgent.x10"
                final boolean t$35747 = ((p$35746) < (((BUY_CHANCE))));
                
                //#line 37 "/home/dsl/workspace/plhamK/plham/agent/TestAgent.x10"
                if (t$35747) {
                    
                    //#line 38 "/home/dsl/workspace/plhamK/plham/agent/TestAgent.x10"
                    final plham.Order.Kind t$35748 = ((plham.Order.get$KIND_BUY_LIMIT_ORDER()));
                    
                    //#line 38 "/home/dsl/workspace/plhamK/plham/agent/TestAgent.x10"
                    final long t$35749 = this.id;
                    
                    //#line 38 "/home/dsl/workspace/plhamK/plham/agent/TestAgent.x10"
                    final long t$35750 = market$35731.id;
                    
                    //#line 38 "/home/dsl/workspace/plhamK/plham/agent/TestAgent.x10"
                    final plham.Order t$35751 = ((new plham.Order((java.lang.System[]) null).plham$Order$$init$S(((t$35748)), ((t$35749)), ((t$35750)), ((price$35741)), ((volume$35743)), ((timeLength$35745)), ((marketTime$35734)))));
                    
                    //#line 38 "/home/dsl/workspace/plhamK/plham/agent/TestAgent.x10"
                    ((x10.util.ArrayList<plham.Order>)orders).add__0x10$util$ArrayList$$T$O(((t$35751)));
                } else {
                    
                    //#line 39 "/home/dsl/workspace/plhamK/plham/agent/TestAgent.x10"
                    final double t$35752 = 0.8;
                    
                    //#line 39 "/home/dsl/workspace/plhamK/plham/agent/TestAgent.x10"
                    final boolean t$35753 = ((p$35746) < (((t$35752))));
                    
                    //#line 39 "/home/dsl/workspace/plhamK/plham/agent/TestAgent.x10"
                    if (t$35753) {
                        
                        //#line 40 "/home/dsl/workspace/plhamK/plham/agent/TestAgent.x10"
                        final plham.Order.Kind t$35754 = ((plham.Order.get$KIND_SELL_LIMIT_ORDER()));
                        
                        //#line 40 "/home/dsl/workspace/plhamK/plham/agent/TestAgent.x10"
                        final long t$35755 = this.id;
                        
                        //#line 40 "/home/dsl/workspace/plhamK/plham/agent/TestAgent.x10"
                        final long t$35756 = market$35731.id;
                        
                        //#line 40 "/home/dsl/workspace/plhamK/plham/agent/TestAgent.x10"
                        final plham.Order t$35757 = ((new plham.Order((java.lang.System[]) null).plham$Order$$init$S(((t$35754)), ((t$35755)), ((t$35756)), ((price$35741)), ((volume$35743)), ((timeLength$35745)), ((marketTime$35734)))));
                        
                        //#line 40 "/home/dsl/workspace/plhamK/plham/agent/TestAgent.x10"
                        ((x10.util.ArrayList<plham.Order>)orders).add__0x10$util$ArrayList$$T$O(((t$35757)));
                    }
                }
            }
        }
        
        //#line 44 "/home/dsl/workspace/plhamK/plham/agent/TestAgent.x10"
        return orders;
    }
    
    
    //#line 18 "/home/dsl/workspace/plhamK/plham/agent/TestAgent.x10"
    final public plham.agent.TestAgent plham$agent$TestAgent$$this$plham$agent$TestAgent() {
        
        //#line 18 "/home/dsl/workspace/plhamK/plham/agent/TestAgent.x10"
        return plham.agent.TestAgent.this;
    }
    
    
    //#line 18 "/home/dsl/workspace/plhamK/plham/agent/TestAgent.x10"
    final public void __fieldInitializers_plham_agent_TestAgent() {
        
    }
}

