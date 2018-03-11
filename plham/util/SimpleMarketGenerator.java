package plham.util;


/**
 * A generator class for markets.
 * This class generates markets. All of them have the same 'base' configuration.
 * example:
 * ```json
 * "SpotMarket":{
 *     "class": "Market",
 *     "tickSize": 0.00001,
 *     "marketPrice": 300.0,
 *     "outstandingShares": 25000
 * },
 * "SpotMarket-N": {
 *     "class": "MarketGenerator",
 *     "prefix": "SpotMarket-",
 *     "from": 1, "to": 2,
 *     "base": {
 *         "extends": "SpotMarket"
 *     }
 * },
 * ```
 * This example generates 2 markets "SpotMarket-1" and "SpotMarket-2", whose config is the same as "SpotMarket", and a market group named "SpotMarket-N" which contains both markets.
 */

public class SimpleMarketGenerator extends x10.core.Ref implements x10.serialization.X10JavaSerializable
{
    public static final x10.rtt.RuntimeType<SimpleMarketGenerator> $RTT = 
        x10.rtt.NamedType.<SimpleMarketGenerator> make("plham.util.SimpleMarketGenerator",
                                                       SimpleMarketGenerator.class);
    
    public x10.rtt.RuntimeType<?> $getRTT() { return $RTT; }
    
    public x10.rtt.Type<?> $getParam(int i) { return null; }
    
    private Object writeReplace() throws java.io.ObjectStreamException {
        return new x10.serialization.SerializationProxy(this);
    }
    
    public static x10.serialization.X10JavaSerializable $_deserialize_body(plham.util.SimpleMarketGenerator $_obj, x10.serialization.X10JavaDeserializer $deserializer) throws java.io.IOException {
        if (x10.runtime.impl.java.Runtime.TRACE_SER) { x10.runtime.impl.java.Runtime.printTraceMessage("X10JavaSerializable: $_deserialize_body() of " + SimpleMarketGenerator.class + " calling"); } 
        return $_obj;
    }
    
    public static x10.serialization.X10JavaSerializable $_deserializer(x10.serialization.X10JavaDeserializer $deserializer) throws java.io.IOException {
        plham.util.SimpleMarketGenerator $_obj = new plham.util.SimpleMarketGenerator((java.lang.System[]) null);
        $deserializer.record_reference($_obj);
        return $_deserialize_body($_obj, $deserializer);
    }
    
    public void $_serialize(x10.serialization.X10JavaSerializer $serializer) throws java.io.IOException {
        
    }
    
    // constructor just for allocation
    public SimpleMarketGenerator(final java.lang.System[] $dummy) {
        
    }
    
    

    
    
    //#line 35 "/home/dsl/workspace/plhamK/plham/util/SimpleMarketGenerator.x10"
    public static void register(final plham.main.Simulator sim) {
        
        //#line 36 "/home/dsl/workspace/plhamK/plham/util/SimpleMarketGenerator.x10"
        final java.lang.String className = (("SimpleMarketGenerator"));
        
        //#line 37 "/home/dsl/workspace/plhamK/plham/util/SimpleMarketGenerator.x10"
        final x10.core.fun.Fun_0_1 t$25686 = ((new plham.util.SimpleMarketGenerator.$Closure$19()));
        
        //#line 37 "/home/dsl/workspace/plhamK/plham/util/SimpleMarketGenerator.x10"
        sim.addMarketGenerator__1$1cassia$util$JSON$Value$3x10$util$List$1cassia$util$JSON$Value$2$2(((className)), ((t$25686)));
    }
    
    
    //#line 34 "/home/dsl/workspace/plhamK/plham/util/SimpleMarketGenerator.x10"
    final public plham.util.SimpleMarketGenerator plham$util$SimpleMarketGenerator$$this$plham$util$SimpleMarketGenerator() {
        
        //#line 34 "/home/dsl/workspace/plhamK/plham/util/SimpleMarketGenerator.x10"
        return plham.util.SimpleMarketGenerator.this;
    }
    
    
    //#line 34 "/home/dsl/workspace/plhamK/plham/util/SimpleMarketGenerator.x10"
    // creation method for java code (1-phase java constructor)
    public SimpleMarketGenerator() {
        this((java.lang.System[]) null);
        plham$util$SimpleMarketGenerator$$init$S();
    }
    
    // constructor for non-virtual call
    final public plham.util.SimpleMarketGenerator plham$util$SimpleMarketGenerator$$init$S() {
         {
            
            //#line 34 "/home/dsl/workspace/plhamK/plham/util/SimpleMarketGenerator.x10"
            
            
            //#line 34 "/home/dsl/workspace/plhamK/plham/util/SimpleMarketGenerator.x10"
            this.__fieldInitializers_plham_util_SimpleMarketGenerator();
        }
        return this;
    }
    
    
    
    //#line 34 "/home/dsl/workspace/plhamK/plham/util/SimpleMarketGenerator.x10"
    final public void __fieldInitializers_plham_util_SimpleMarketGenerator() {
        
    }
    
    
    final public static class $Closure$19 extends x10.core.Ref implements x10.core.fun.Fun_0_1, x10.serialization.X10JavaSerializable
    {
        public static final x10.rtt.RuntimeType<$Closure$19> $RTT = 
            x10.rtt.StaticFunType.<$Closure$19> make($Closure$19.class,
                                                     new x10.rtt.Type[] {
                                                         x10.rtt.ParameterizedType.make(x10.core.fun.Fun_0_1.$RTT, cassia.util.JSON.Value.$RTT, x10.rtt.ParameterizedType.make(x10.util.List.$RTT, cassia.util.JSON.Value.$RTT))
                                                     });
        
        public x10.rtt.RuntimeType<?> $getRTT() { return $RTT; }
        
        public x10.rtt.Type<?> $getParam(int i) { return null; }
        
        private Object writeReplace() throws java.io.ObjectStreamException {
            return new x10.serialization.SerializationProxy(this);
        }
        
        public static x10.serialization.X10JavaSerializable $_deserialize_body(plham.util.SimpleMarketGenerator.$Closure$19 $_obj, x10.serialization.X10JavaDeserializer $deserializer) throws java.io.IOException {
            if (x10.runtime.impl.java.Runtime.TRACE_SER) { x10.runtime.impl.java.Runtime.printTraceMessage("X10JavaSerializable: $_deserialize_body() of " + $Closure$19.class + " calling"); } 
            return $_obj;
        }
        
        public static x10.serialization.X10JavaSerializable $_deserializer(x10.serialization.X10JavaDeserializer $deserializer) throws java.io.IOException {
            plham.util.SimpleMarketGenerator.$Closure$19 $_obj = new plham.util.SimpleMarketGenerator.$Closure$19((java.lang.System[]) null);
            $deserializer.record_reference($_obj);
            return $_deserialize_body($_obj, $deserializer);
        }
        
        public void $_serialize(x10.serialization.X10JavaSerializer $serializer) throws java.io.IOException {
            
        }
        
        // constructor just for allocation
        public $Closure$19(final java.lang.System[] $dummy) {
            
        }
        
        // dispatcher for method abstract public (Z1)=>U.operator()(a1:Z1):U
        public java.lang.Object $apply(final java.lang.Object a1, final x10.rtt.Type t1) {
            return $apply((cassia.util.JSON.Value)a1);
            
        }
        
        
    
        
        public x10.util.List $apply(final cassia.util.JSON.Value json) {
            
            //#line 38 "/home/dsl/workspace/plhamK/plham/util/SimpleMarketGenerator.x10"
            assert json.<java.lang.String> has__0cassia$util$JSON$Value$$T$O(x10.rtt.Types.STRING, (("prefix")));
            
            //#line 39 "/home/dsl/workspace/plhamK/plham/util/SimpleMarketGenerator.x10"
            assert json.<java.lang.String> has__0cassia$util$JSON$Value$$T$O(x10.rtt.Types.STRING, (("from")));
            
            //#line 40 "/home/dsl/workspace/plhamK/plham/util/SimpleMarketGenerator.x10"
            assert json.<java.lang.String> has__0cassia$util$JSON$Value$$T$O(x10.rtt.Types.STRING, (("to")));
            
            //#line 41 "/home/dsl/workspace/plhamK/plham/util/SimpleMarketGenerator.x10"
            assert json.<java.lang.String> has__0cassia$util$JSON$Value$$T$O(x10.rtt.Types.STRING, (("base")));
            
            //#line 42 "/home/dsl/workspace/plhamK/plham/util/SimpleMarketGenerator.x10"
            final cassia.util.JSON.Value t$25676 = json.<java.lang.String> get(x10.rtt.Types.STRING, (("prefix")));
            
            //#line 42 "/home/dsl/workspace/plhamK/plham/util/SimpleMarketGenerator.x10"
            final java.lang.String prefix = t$25676.toString();
            
            //#line 43 "/home/dsl/workspace/plhamK/plham/util/SimpleMarketGenerator.x10"
            final cassia.util.JSON.Value t$25677 = json.<java.lang.String> get(x10.rtt.Types.STRING, (("from")));
            
            //#line 43 "/home/dsl/workspace/plhamK/plham/util/SimpleMarketGenerator.x10"
            final long from = t$25677.toLong$O();
            
            //#line 44 "/home/dsl/workspace/plhamK/plham/util/SimpleMarketGenerator.x10"
            final cassia.util.JSON.Value t$25678 = json.<java.lang.String> get(x10.rtt.Types.STRING, (("to")));
            
            //#line 44 "/home/dsl/workspace/plhamK/plham/util/SimpleMarketGenerator.x10"
            final long to = t$25678.toLong$O();
            
            //#line 45 "/home/dsl/workspace/plhamK/plham/util/SimpleMarketGenerator.x10"
            final cassia.util.JSON.Value base = json.<java.lang.String> get(x10.rtt.Types.STRING, (("base")));
            
            //#line 46 "/home/dsl/workspace/plhamK/plham/util/SimpleMarketGenerator.x10"
            final x10.util.ArrayList ret = ((new x10.util.ArrayList<cassia.util.JSON.Value>((java.lang.System[]) null, cassia.util.JSON.Value.$RTT).x10$util$ArrayList$$init$S()));
            
            //#line 47 "/home/dsl/workspace/plhamK/plham/util/SimpleMarketGenerator.x10"
            final long n = ((to) - (((from))));
            
            //#line 48 "/home/dsl/workspace/plhamK/plham/util/SimpleMarketGenerator.x10"
            final long i$25659min$25697 = 0L;
            
            //#line 48 "/home/dsl/workspace/plhamK/plham/util/SimpleMarketGenerator.x10"
            final long i$25659max$25698 = n;
            
            //#line 48 "/home/dsl/workspace/plhamK/plham/util/SimpleMarketGenerator.x10"
            long i$25694 = i$25659min$25697;
            
            //#line 48 "/home/dsl/workspace/plhamK/plham/util/SimpleMarketGenerator.x10"
            for (;
                 true;
                 ) {
                
                //#line 48 "/home/dsl/workspace/plhamK/plham/util/SimpleMarketGenerator.x10"
                final long t$25695 = i$25694;
                
                //#line 48 "/home/dsl/workspace/plhamK/plham/util/SimpleMarketGenerator.x10"
                final boolean t$25696 = ((t$25695) <= (((i$25659max$25698))));
                
                //#line 48 "/home/dsl/workspace/plhamK/plham/util/SimpleMarketGenerator.x10"
                if (!(t$25696)) {
                    
                    //#line 48 "/home/dsl/workspace/plhamK/plham/util/SimpleMarketGenerator.x10"
                    break;
                }
                
                //#line 48 "/home/dsl/workspace/plhamK/plham/util/SimpleMarketGenerator.x10"
                final long i$25691 = i$25694;
                
                //#line 49 "/home/dsl/workspace/plhamK/plham/util/SimpleMarketGenerator.x10"
                final long id$25687 = ((i$25691) + (((from))));
                
                //#line 50 "/home/dsl/workspace/plhamK/plham/util/SimpleMarketGenerator.x10"
                final java.lang.String name$25688 = ((prefix) + ((x10.core.Long.$box(id$25687))));
                
                //#line 51 "/home/dsl/workspace/plhamK/plham/util/SimpleMarketGenerator.x10"
                final cassia.util.JSON.Value t$25689 = ((new cassia.util.JSON.Value((java.lang.System[]) null).cassia$util$JSON$Value$$init$S((name$25688))));
                
                //#line 51 "/home/dsl/workspace/plhamK/plham/util/SimpleMarketGenerator.x10"
                final cassia.util.JSON.Value generated$25690 = base.apply((("name")), ((t$25689)));
                
                //#line 52 "/home/dsl/workspace/plhamK/plham/util/SimpleMarketGenerator.x10"
                ((x10.util.ArrayList<cassia.util.JSON.Value>)ret).add__0x10$util$ArrayList$$T$O(((generated$25690)));
                
                //#line 48 "/home/dsl/workspace/plhamK/plham/util/SimpleMarketGenerator.x10"
                final long t$25692 = i$25694;
                
                //#line 48 "/home/dsl/workspace/plhamK/plham/util/SimpleMarketGenerator.x10"
                final long t$25693 = ((t$25692) + (((1L))));
                
                //#line 48 "/home/dsl/workspace/plhamK/plham/util/SimpleMarketGenerator.x10"
                i$25694 = t$25693;
            }
            
            //#line 54 "/home/dsl/workspace/plhamK/plham/util/SimpleMarketGenerator.x10"
            final x10.util.List t$25685 = (ret);
            
            //#line 54 "/home/dsl/workspace/plhamK/plham/util/SimpleMarketGenerator.x10"
            return t$25685;
        }
        
        public $Closure$19() {
             {
                
            }
        }
        
    }
    
}

