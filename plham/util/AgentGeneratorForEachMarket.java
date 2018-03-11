package plham.util;



public class AgentGeneratorForEachMarket extends x10.core.Ref implements x10.serialization.X10JavaSerializable
{
    public static final x10.rtt.RuntimeType<AgentGeneratorForEachMarket> $RTT = 
        x10.rtt.NamedType.<AgentGeneratorForEachMarket> make("plham.util.AgentGeneratorForEachMarket",
                                                             AgentGeneratorForEachMarket.class);
    
    public x10.rtt.RuntimeType<?> $getRTT() { return $RTT; }
    
    public x10.rtt.Type<?> $getParam(int i) { return null; }
    
    private Object writeReplace() throws java.io.ObjectStreamException {
        return new x10.serialization.SerializationProxy(this);
    }
    
    public static x10.serialization.X10JavaSerializable $_deserialize_body(plham.util.AgentGeneratorForEachMarket $_obj, x10.serialization.X10JavaDeserializer $deserializer) throws java.io.IOException {
        if (x10.runtime.impl.java.Runtime.TRACE_SER) { x10.runtime.impl.java.Runtime.printTraceMessage("X10JavaSerializable: $_deserialize_body() of " + AgentGeneratorForEachMarket.class + " calling"); } 
        return $_obj;
    }
    
    public static x10.serialization.X10JavaSerializable $_deserializer(x10.serialization.X10JavaDeserializer $deserializer) throws java.io.IOException {
        plham.util.AgentGeneratorForEachMarket $_obj = new plham.util.AgentGeneratorForEachMarket((java.lang.System[]) null);
        $deserializer.record_reference($_obj);
        return $_deserialize_body($_obj, $deserializer);
    }
    
    public void $_serialize(x10.serialization.X10JavaSerializer $serializer) throws java.io.IOException {
        
    }
    
    // constructor just for allocation
    public AgentGeneratorForEachMarket(final java.lang.System[] $dummy) {
        
    }
    
    

    
    
    //#line 13 "/home/dsl/workspace/plhamK/plham/util/AgentGeneratorForEachMarket.x10"
    public static void register(final plham.main.Simulator sim) {
        
        //#line 14 "/home/dsl/workspace/plhamK/plham/util/AgentGeneratorForEachMarket.x10"
        final java.lang.String className = (("AgentGeneratorForEachMarket"));
        
        //#line 15 "/home/dsl/workspace/plhamK/plham/util/AgentGeneratorForEachMarket.x10"
        final x10.core.fun.Fun_0_1 t$25888 = ((new plham.util.AgentGeneratorForEachMarket.$Closure$20(sim)));
        
        //#line 15 "/home/dsl/workspace/plhamK/plham/util/AgentGeneratorForEachMarket.x10"
        sim.addAgentGenerator__1$1cassia$util$JSON$Value$3x10$util$List$1cassia$util$JSON$Value$2$2(((className)), ((t$25888)));
    }
    
    
    //#line 12 "/home/dsl/workspace/plhamK/plham/util/AgentGeneratorForEachMarket.x10"
    final public plham.util.AgentGeneratorForEachMarket plham$util$AgentGeneratorForEachMarket$$this$plham$util$AgentGeneratorForEachMarket() {
        
        //#line 12 "/home/dsl/workspace/plhamK/plham/util/AgentGeneratorForEachMarket.x10"
        return plham.util.AgentGeneratorForEachMarket.this;
    }
    
    
    //#line 12 "/home/dsl/workspace/plhamK/plham/util/AgentGeneratorForEachMarket.x10"
    // creation method for java code (1-phase java constructor)
    public AgentGeneratorForEachMarket() {
        this((java.lang.System[]) null);
        plham$util$AgentGeneratorForEachMarket$$init$S();
    }
    
    // constructor for non-virtual call
    final public plham.util.AgentGeneratorForEachMarket plham$util$AgentGeneratorForEachMarket$$init$S() {
         {
            
            //#line 12 "/home/dsl/workspace/plhamK/plham/util/AgentGeneratorForEachMarket.x10"
            
            
            //#line 12 "/home/dsl/workspace/plhamK/plham/util/AgentGeneratorForEachMarket.x10"
            this.__fieldInitializers_plham_util_AgentGeneratorForEachMarket();
        }
        return this;
    }
    
    
    
    //#line 12 "/home/dsl/workspace/plhamK/plham/util/AgentGeneratorForEachMarket.x10"
    final public void __fieldInitializers_plham_util_AgentGeneratorForEachMarket() {
        
    }
    
    
    final public static class $Closure$20 extends x10.core.Ref implements x10.core.fun.Fun_0_1, x10.serialization.X10JavaSerializable
    {
        public static final x10.rtt.RuntimeType<$Closure$20> $RTT = 
            x10.rtt.StaticFunType.<$Closure$20> make($Closure$20.class,
                                                     new x10.rtt.Type[] {
                                                         x10.rtt.ParameterizedType.make(x10.core.fun.Fun_0_1.$RTT, cassia.util.JSON.Value.$RTT, x10.rtt.ParameterizedType.make(x10.util.List.$RTT, cassia.util.JSON.Value.$RTT))
                                                     });
        
        public x10.rtt.RuntimeType<?> $getRTT() { return $RTT; }
        
        public x10.rtt.Type<?> $getParam(int i) { return null; }
        
        private Object writeReplace() throws java.io.ObjectStreamException {
            return new x10.serialization.SerializationProxy(this);
        }
        
        public static x10.serialization.X10JavaSerializable $_deserialize_body(plham.util.AgentGeneratorForEachMarket.$Closure$20 $_obj, x10.serialization.X10JavaDeserializer $deserializer) throws java.io.IOException {
            if (x10.runtime.impl.java.Runtime.TRACE_SER) { x10.runtime.impl.java.Runtime.printTraceMessage("X10JavaSerializable: $_deserialize_body() of " + $Closure$20.class + " calling"); } 
            $_obj.sim = $deserializer.readObject();
            return $_obj;
        }
        
        public static x10.serialization.X10JavaSerializable $_deserializer(x10.serialization.X10JavaDeserializer $deserializer) throws java.io.IOException {
            plham.util.AgentGeneratorForEachMarket.$Closure$20 $_obj = new plham.util.AgentGeneratorForEachMarket.$Closure$20((java.lang.System[]) null);
            $deserializer.record_reference($_obj);
            return $_deserialize_body($_obj, $deserializer);
        }
        
        public void $_serialize(x10.serialization.X10JavaSerializer $serializer) throws java.io.IOException {
            $serializer.write(this.sim);
            
        }
        
        // constructor just for allocation
        public $Closure$20(final java.lang.System[] $dummy) {
            
        }
        
        // dispatcher for method abstract public (Z1)=>U.operator()(a1:Z1):U
        public java.lang.Object $apply(final java.lang.Object a1, final x10.rtt.Type t1) {
            return $apply((cassia.util.JSON.Value)a1);
            
        }
        
        
    
        
        public x10.util.List $apply(final cassia.util.JSON.Value json) {
            
            //#line 16 "/home/dsl/workspace/plhamK/plham/util/AgentGeneratorForEachMarket.x10"
            assert json.<java.lang.String> has__0cassia$util$JSON$Value$$T$O(x10.rtt.Types.STRING, (("markets")));
            
            //#line 17 "/home/dsl/workspace/plhamK/plham/util/AgentGeneratorForEachMarket.x10"
            final x10.util.ArrayList markets = ((new x10.util.ArrayList<plham.Market>((java.lang.System[]) null, plham.Market.$RTT).x10$util$ArrayList$$init$S()));
            
            //#line 18 "/home/dsl/workspace/plhamK/plham/util/AgentGeneratorForEachMarket.x10"
            final cassia.util.JSON.Value t$25867 = json.<java.lang.String> get(x10.rtt.Types.STRING, (("markets")));
            
            //#line 18 "/home/dsl/workspace/plhamK/plham/util/AgentGeneratorForEachMarket.x10"
            final x10.util.List marketNames = t$25867.asList();
            
            //#line 19 "/home/dsl/workspace/plhamK/plham/util/AgentGeneratorForEachMarket.x10"
            final x10.util.ListIterator marketName$25908 = (((x10.util.List<cassia.util.JSON.Value>)marketNames).iterator());
            
            //#line 19 "/home/dsl/workspace/plhamK/plham/util/AgentGeneratorForEachMarket.x10"
            for (;
                 true;
                 ) {
                
                //#line 19 "/home/dsl/workspace/plhamK/plham/util/AgentGeneratorForEachMarket.x10"
                final boolean t$25909 = ((x10.util.ListIterator<cassia.util.JSON.Value>)marketName$25908).hasNext$O();
                
                //#line 19 "/home/dsl/workspace/plhamK/plham/util/AgentGeneratorForEachMarket.x10"
                if (!(t$25909)) {
                    
                    //#line 19 "/home/dsl/workspace/plhamK/plham/util/AgentGeneratorForEachMarket.x10"
                    break;
                }
                
                //#line 19 "/home/dsl/workspace/plhamK/plham/util/AgentGeneratorForEachMarket.x10"
                final cassia.util.JSON.Value marketName$25889 = ((((x10.util.ListIterator<cassia.util.JSON.Value>)marketName$25908).next$G()));
                
                //#line 20 "/home/dsl/workspace/plhamK/plham/util/AgentGeneratorForEachMarket.x10"
                final java.lang.String name$25890 = marketName$25889.toString();
                
                //#line 21 "/home/dsl/workspace/plhamK/plham/util/AgentGeneratorForEachMarket.x10"
                final x10.util.List t$25891 = this.sim.getMarketsByName(((name$25890)));
                
                //#line 21 "/home/dsl/workspace/plhamK/plham/util/AgentGeneratorForEachMarket.x10"
                ((x10.util.AbstractCollection<plham.Market>)markets).addAll__0$1x10$util$AbstractCollection$$T$2$O(((t$25891)));
            }
            
            //#line 23 "/home/dsl/workspace/plhamK/plham/util/AgentGeneratorForEachMarket.x10"
            assert json.<java.lang.String> has__0cassia$util$JSON$Value$$T$O(x10.rtt.Types.STRING, (("base")));
            
            //#line 24 "/home/dsl/workspace/plhamK/plham/util/AgentGeneratorForEachMarket.x10"
            final x10.util.ArrayList agentConfigs = ((new x10.util.ArrayList<cassia.util.JSON.Value>((java.lang.System[]) null, cassia.util.JSON.Value.$RTT).x10$util$ArrayList$$init$S()));
            
            //#line 25 "/home/dsl/workspace/plhamK/plham/util/AgentGeneratorForEachMarket.x10"
            final x10.util.ListIterator market$25910 = (((x10.util.ArrayList<plham.Market>)markets).iterator());
            
            //#line 25 "/home/dsl/workspace/plhamK/plham/util/AgentGeneratorForEachMarket.x10"
            for (;
                 true;
                 ) {
                
                //#line 25 "/home/dsl/workspace/plhamK/plham/util/AgentGeneratorForEachMarket.x10"
                final boolean t$25911 = ((x10.util.ListIterator<plham.Market>)market$25910).hasNext$O();
                
                //#line 25 "/home/dsl/workspace/plhamK/plham/util/AgentGeneratorForEachMarket.x10"
                if (!(t$25911)) {
                    
                    //#line 25 "/home/dsl/workspace/plhamK/plham/util/AgentGeneratorForEachMarket.x10"
                    break;
                }
                
                //#line 25 "/home/dsl/workspace/plhamK/plham/util/AgentGeneratorForEachMarket.x10"
                final plham.Market market$25892 = ((((x10.util.ListIterator<plham.Market>)market$25910).next$G()));
                
                //#line 26 "/home/dsl/workspace/plhamK/plham/util/AgentGeneratorForEachMarket.x10"
                final cassia.util.JSON.Value t$25893 = json.<java.lang.String> get(x10.rtt.Types.STRING, (("base")));
                
                //#line 29 "/home/dsl/workspace/plhamK/plham/util/AgentGeneratorForEachMarket.x10"
                final java.lang.String t$25894 = ((market$25892.name));
                
                //#line 29 "/home/dsl/workspace/plhamK/plham/util/AgentGeneratorForEachMarket.x10"
                final java.lang.String t$25895 = (("[") + (t$25894));
                
                //#line 29 "/home/dsl/workspace/plhamK/plham/util/AgentGeneratorForEachMarket.x10"
                final java.lang.String t$25896 = ((t$25895) + ("]"));
                
                //#line 29 "/home/dsl/workspace/plhamK/plham/util/AgentGeneratorForEachMarket.x10"
                final cassia.util.JSON.Value t$25897 = ((plham.util.JSON.parse(((t$25896)))));
                
                //#line 27 "/home/dsl/workspace/plhamK/plham/util/AgentGeneratorForEachMarket.x10"
                final cassia.util.JSON.Entry t$25898 = ((new cassia.util.JSON.Entry((java.lang.System[]) null).cassia$util$JSON$Entry$$init$S((("accessibleMarkets")), ((t$25897)))));
                
                //#line 27 "/home/dsl/workspace/plhamK/plham/util/AgentGeneratorForEachMarket.x10"
                final cassia.util.JSON.Entry t$25899 = (t$25898);
                
                //#line 33 "/home/dsl/workspace/plhamK/plham/util/AgentGeneratorForEachMarket.x10"
                final java.lang.String t$25900 = ((market$25892.name));
                
                //#line 33 "/home/dsl/workspace/plhamK/plham/util/AgentGeneratorForEachMarket.x10"
                final java.lang.String t$25901 = (("[") + (t$25900));
                
                //#line 33 "/home/dsl/workspace/plhamK/plham/util/AgentGeneratorForEachMarket.x10"
                final java.lang.String t$25902 = ((t$25901) + ("]"));
                
                //#line 33 "/home/dsl/workspace/plhamK/plham/util/AgentGeneratorForEachMarket.x10"
                final cassia.util.JSON.Value t$25903 = ((plham.util.JSON.parse(((t$25902)))));
                
                //#line 31 "/home/dsl/workspace/plhamK/plham/util/AgentGeneratorForEachMarket.x10"
                final cassia.util.JSON.Entry t$25904 = ((new cassia.util.JSON.Entry((java.lang.System[]) null).cassia$util$JSON$Entry$$init$S((("markets")), ((t$25903)))));
                
                //#line 26 "/home/dsl/workspace/plhamK/plham/util/AgentGeneratorForEachMarket.x10"
                final x10.core.Rail t$25905 = ((x10.runtime.impl.java.ArrayUtils.<cassia.util.JSON.Entry> makeRailFromJavaArray(cassia.util.JSON.Entry.$RTT, new cassia.util.JSON.Entry[] {t$25899, t$25904})));
                
                //#line 26 "/home/dsl/workspace/plhamK/plham/util/AgentGeneratorForEachMarket.x10"
                final x10.core.Rail t$25906 = (t$25905);
                
                //#line 26 "/home/dsl/workspace/plhamK/plham/util/AgentGeneratorForEachMarket.x10"
                final cassia.util.JSON.Value agentConfig$25907 = t$25893.apply__0$1cassia$util$JSON$Entry$2(((t$25906)));
                
                //#line 36 "/home/dsl/workspace/plhamK/plham/util/AgentGeneratorForEachMarket.x10"
                ((x10.util.ArrayList<cassia.util.JSON.Value>)agentConfigs).add__0x10$util$ArrayList$$T$O(((agentConfig$25907)));
            }
            
            //#line 38 "/home/dsl/workspace/plhamK/plham/util/AgentGeneratorForEachMarket.x10"
            final x10.util.List t$25887 = (agentConfigs);
            
            //#line 38 "/home/dsl/workspace/plhamK/plham/util/AgentGeneratorForEachMarket.x10"
            return t$25887;
        }
        
        public plham.main.Simulator sim;
        
        public $Closure$20(final plham.main.Simulator sim) {
             {
                this.sim = ((sim));
            }
        }
        
    }
    
}

