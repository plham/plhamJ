package plham.util;



public class JSONUtils extends x10.core.Ref implements x10.serialization.X10JavaSerializable
{
    public static final x10.rtt.RuntimeType<JSONUtils> $RTT = 
        x10.rtt.NamedType.<JSONUtils> make("plham.util.JSONUtils",
                                           JSONUtils.class);
    
    public x10.rtt.RuntimeType<?> $getRTT() { return $RTT; }
    
    public x10.rtt.Type<?> $getParam(int i) { return null; }
    
    private Object writeReplace() throws java.io.ObjectStreamException {
        return new x10.serialization.SerializationProxy(this);
    }
    
    public static x10.serialization.X10JavaSerializable $_deserialize_body(plham.util.JSONUtils $_obj, x10.serialization.X10JavaDeserializer $deserializer) throws java.io.IOException {
        if (x10.runtime.impl.java.Runtime.TRACE_SER) { x10.runtime.impl.java.Runtime.printTraceMessage("X10JavaSerializable: $_deserialize_body() of " + JSONUtils.class + " calling"); } 
        return $_obj;
    }
    
    public static x10.serialization.X10JavaSerializable $_deserializer(x10.serialization.X10JavaDeserializer $deserializer) throws java.io.IOException {
        plham.util.JSONUtils $_obj = new plham.util.JSONUtils((java.lang.System[]) null);
        $deserializer.record_reference($_obj);
        return $_deserialize_body($_obj, $deserializer);
    }
    
    public void $_serialize(x10.serialization.X10JavaSerializer $serializer) throws java.io.IOException {
        
    }
    
    // constructor just for allocation
    public JSONUtils(final java.lang.System[] $dummy) {
        
    }
    
    

    
    //#line 13 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
    
    public static class Graph extends x10.core.Ref implements x10.serialization.X10JavaSerializable
    {
        public static final x10.rtt.RuntimeType<Graph> $RTT = 
            x10.rtt.NamedType.<Graph> make("plham.util.JSONUtils.Graph",
                                           Graph.class);
        
        public x10.rtt.RuntimeType<?> $getRTT() { return $RTT; }
        
        public x10.rtt.Type<?> $getParam(int i) { return null; }
        
        private Object writeReplace() throws java.io.ObjectStreamException {
            return new x10.serialization.SerializationProxy(this);
        }
        
        public static x10.serialization.X10JavaSerializable $_deserialize_body(plham.util.JSONUtils.Graph $_obj, x10.serialization.X10JavaDeserializer $deserializer) throws java.io.IOException {
            if (x10.runtime.impl.java.Runtime.TRACE_SER) { x10.runtime.impl.java.Runtime.printTraceMessage("X10JavaSerializable: $_deserialize_body() of " + Graph.class + " calling"); } 
            $_obj.NodeID = $deserializer.readObject();
            $_obj.NodeName = $deserializer.readObject();
            $_obj.V = $deserializer.readLong();
            $_obj.g = $deserializer.readObject();
            $_obj.rg = $deserializer.readObject();
            return $_obj;
        }
        
        public static x10.serialization.X10JavaSerializable $_deserializer(x10.serialization.X10JavaDeserializer $deserializer) throws java.io.IOException {
            plham.util.JSONUtils.Graph $_obj = new plham.util.JSONUtils.Graph((java.lang.System[]) null);
            $deserializer.record_reference($_obj);
            return $_deserialize_body($_obj, $deserializer);
        }
        
        public void $_serialize(x10.serialization.X10JavaSerializer $serializer) throws java.io.IOException {
            $serializer.write(this.NodeID);
            $serializer.write(this.NodeName);
            $serializer.write(this.V);
            $serializer.write(this.g);
            $serializer.write(this.rg);
            
        }
        
        // constructor just for allocation
        public Graph(final java.lang.System[] $dummy) {
            
        }
        
        // synthetic type for parameter mangling
        public static final class __0$1x10$lang$String$3x10$util$Set$1x10$lang$String$2$2 {}
        
    
        
        //#line 14 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
        public x10.util.HashMap<java.lang.String, x10.core.Long> NodeID;
        
        //#line 15 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
        public x10.core.Rail<java.lang.String> NodeName;
        
        //#line 16 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
        public long V;
        
        //#line 17 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
        public x10.core.Rail<x10.util.ArrayList<x10.core.Long>> g;
        
        //#line 18 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
        public x10.core.Rail<x10.util.ArrayList<x10.core.Long>> rg;
        
        
        //#line 19 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
        // creation method for java code (1-phase java constructor)
        public Graph(final x10.util.Map<java.lang.String, x10.util.Set<java.lang.String>> originalGraph, __0$1x10$lang$String$3x10$util$Set$1x10$lang$String$2$2 $dummy) {
            this((java.lang.System[]) null);
            plham$util$JSONUtils$Graph$$init$S(originalGraph, (plham.util.JSONUtils.Graph.__0$1x10$lang$String$3x10$util$Set$1x10$lang$String$2$2) null);
        }
        
        // constructor for non-virtual call
        final public plham.util.JSONUtils.Graph plham$util$JSONUtils$Graph$$init$S(final x10.util.Map<java.lang.String, x10.util.Set<java.lang.String>> originalGraph, __0$1x10$lang$String$3x10$util$Set$1x10$lang$String$2$2 $dummy) {
             {
                
                //#line 19 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
                
                
                //#line 13 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
                this.__fieldInitializers_plham_util_JSONUtils_Graph();
                
                //#line 20 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
                final long t$28444 = originalGraph.size$O();
                
                //#line 20 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
                this.V = t$28444;
                
                //#line 21 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
                final long t$28445 = this.V;
                
                //#line 21 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
                final x10.core.Rail t$28446 = ((new x10.core.Rail<x10.util.ArrayList<x10.core.Long>>(x10.rtt.ParameterizedType.make(x10.util.ArrayList.$RTT, x10.rtt.Types.LONG), ((t$28445)))));
                
                //#line 21 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
                this.g = ((t$28446));
                
                //#line 22 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
                final long t$28447 = this.V;
                
                //#line 22 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
                final x10.core.Rail t$28448 = ((new x10.core.Rail<x10.util.ArrayList<x10.core.Long>>(x10.rtt.ParameterizedType.make(x10.util.ArrayList.$RTT, x10.rtt.Types.LONG), ((t$28447)))));
                
                //#line 22 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
                this.rg = ((t$28448));
                
                //#line 23 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
                final long i$28263min$28660 = 0L;
                
                //#line 23 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
                final long t$28661 = this.V;
                
                //#line 23 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
                final long i$28263max$28662 = ((t$28661) - (((1L))));
                
                //#line 23 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
                long i$28640 = i$28263min$28660;
                
                //#line 23 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
                for (;
                     true;
                     ) {
                    
                    //#line 23 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
                    final long t$28641 = i$28640;
                    
                    //#line 23 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
                    final boolean t$28642 = ((t$28641) <= (((i$28263max$28662))));
                    
                    //#line 23 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
                    if (!(t$28642)) {
                        
                        //#line 23 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
                        break;
                    }
                    
                    //#line 23 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
                    final long v$28637 = i$28640;
                    
                    //#line 24 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
                    final x10.core.Rail t$28633 = ((this.g));
                    
                    //#line 24 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
                    final x10.util.ArrayList t$28634 = ((new x10.util.ArrayList<x10.core.Long>((java.lang.System[]) null, x10.rtt.Types.LONG).x10$util$ArrayList$$init$S()));
                    
                    //#line 24 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
                    ((x10.util.ArrayList[])t$28633.value)[(int)v$28637] = t$28634;
                    
                    //#line 25 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
                    final x10.core.Rail t$28635 = ((this.rg));
                    
                    //#line 25 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
                    final x10.util.ArrayList t$28636 = ((new x10.util.ArrayList<x10.core.Long>((java.lang.System[]) null, x10.rtt.Types.LONG).x10$util$ArrayList$$init$S()));
                    
                    //#line 25 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
                    ((x10.util.ArrayList[])t$28635.value)[(int)v$28637] = t$28636;
                    
                    //#line 23 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
                    final long t$28638 = i$28640;
                    
                    //#line 23 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
                    final long t$28639 = ((t$28638) + (((1L))));
                    
                    //#line 23 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
                    i$28640 = t$28639;
                }
                
                //#line 27 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
                final x10.util.HashMap t$28459 = ((new x10.util.HashMap<java.lang.String, x10.core.Long>((java.lang.System[]) null, x10.rtt.Types.STRING, x10.rtt.Types.LONG).x10$util$HashMap$$init$S()));
                
                //#line 27 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
                this.NodeID = ((t$28459));
                
                //#line 28 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
                final long t$28460 = this.V;
                
                //#line 28 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
                final x10.core.Rail t$28461 = ((new x10.core.Rail<java.lang.String>(x10.rtt.Types.STRING, ((t$28460)))));
                
                //#line 28 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
                this.NodeName = ((t$28461));
                
                //#line 29 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
                long curID = 0L;
                
                //#line 30 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
                final x10.util.Set t$28663 = (originalGraph.keySet());
                
                //#line 30 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
                final x10.lang.Iterator key$28664 = (((x10.lang.Iterable<java.lang.String>)t$28663).iterator());
                
                //#line 30 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
                for (;
                     true;
                     ) {
                    
                    //#line 30 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
                    final boolean t$28665 = ((x10.lang.Iterator<java.lang.String>)key$28664).hasNext$O();
                    
                    //#line 30 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
                    if (!(t$28665)) {
                        
                        //#line 30 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
                        break;
                    }
                    
                    //#line 30 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
                    L$28666: {
                        
                        //#line 30 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
                        final java.lang.String key$28667 = ((((x10.lang.Iterator<java.lang.String>)key$28664).next$G()));
                        //#line 31 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
                        final x10.util.HashMap t$28668 = ((this.NodeID));
                        //#line 31 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
                        final boolean t$28669 = ((x10.util.HashMap<java.lang.String, x10.core.Long>)t$28668).containsKey__0x10$util$HashMap$$K$O(((key$28667)));
                        //#line 31 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
                        if (t$28669) {
                            
                            //#line 31 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
                            break L$28666;
                        }
                        //#line 32 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
                        final x10.core.Rail t$28670 = ((this.NodeName));
                        //#line 32 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
                        final long t$28671 = curID;
                        //#line 32 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
                        ((java.lang.String[])t$28670.value)[(int)t$28671] = key$28667;
                        //#line 33 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
                        final x10.util.HashMap t$28672 = ((this.NodeID));
                        //#line 33 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
                        final long pre$28673 = curID;
                        //#line 33 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
                        final long t$28674 = curID;
                        //#line 33 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
                        final long t$28675 = ((t$28674) + (((1L))));
                        //#line 33 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
                        curID = t$28675;
                        //#line 33 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
                        ((x10.util.HashMap<java.lang.String, x10.core.Long>)t$28672).$set__0x10$util$HashMap$$K__1x10$util$HashMap$$V$G(((key$28667)), x10.core.Long.$box(pre$28673));
                    }
                }
                
                //#line 35 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
                assert (curID) == (this.V);
                
                //#line 36 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
                final x10.util.Set t$28676 = (originalGraph.entries());
                
                //#line 36 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
                final x10.lang.Iterator entry$28677 = (((x10.lang.Iterable<x10.util.Map.Entry<java.lang.String, x10.util.Set<java.lang.String>>>)t$28676).iterator());
                
                //#line 36 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
                for (;
                     true;
                     ) {
                    
                    //#line 36 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
                    final boolean t$28678 = ((x10.lang.Iterator<x10.util.Map.Entry<java.lang.String, x10.util.Set<java.lang.String>>>)entry$28677).hasNext$O();
                    
                    //#line 36 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
                    if (!(t$28678)) {
                        
                        //#line 36 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
                        break;
                    }
                    
                    //#line 36 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
                    final x10.util.Map.Entry entry$28656 = ((((x10.lang.Iterator<x10.util.Map.Entry<java.lang.String, x10.util.Set<java.lang.String>>>)entry$28677).next$G()));
                    
                    //#line 37 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
                    final x10.util.HashMap t$28657 = ((this.NodeID));
                    
                    //#line 37 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
                    final java.lang.String t$28658 = ((x10.util.Map.Entry<java.lang.String, x10.util.Set<java.lang.String>>)entry$28656).getKey$G();
                    
                    //#line 37 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
                    final long dst$28659 = x10.core.Long.$unbox(((x10.util.HashMap<java.lang.String, x10.core.Long>)t$28657).$apply__0x10$util$HashMap$$K$G(((t$28658))));
                    
                    //#line 38 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
                    final x10.util.Set t$28653 = ((x10.util.Map.Entry<java.lang.String, x10.util.Set<java.lang.String>>)entry$28656).getValue$G();
                    
                    //#line 38 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
                    final x10.lang.Iterator v$28654 = (((x10.lang.Iterable<java.lang.String>)t$28653).iterator());
                    
                    //#line 38 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
                    for (;
                         true;
                         ) {
                        
                        //#line 38 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
                        final boolean t$28655 = ((x10.lang.Iterator<java.lang.String>)v$28654).hasNext$O();
                        
                        //#line 38 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
                        if (!(t$28655)) {
                            
                            //#line 38 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
                            break;
                        }
                        
                        //#line 38 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
                        final java.lang.String v$28643 = ((((x10.lang.Iterator<java.lang.String>)v$28654).next$G()));
                        
                        //#line 39 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
                        final x10.util.HashMap t$28644 = ((this.NodeID));
                        
                        //#line 39 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
                        final long src$28645 = x10.core.Long.$unbox(((x10.util.HashMap<java.lang.String, x10.core.Long>)t$28644).$apply__0x10$util$HashMap$$K$G(((v$28643))));
                        
                        //#line 40 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
                        final x10.io.Printer t$28646 = ((x10.io.Console.get$OUT()));
                        
                        //#line 40 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
                        final java.lang.String t$28647 = (("# src: ") + ((x10.core.Long.$box(src$28645))));
                        
                        //#line 40 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
                        final java.lang.String t$28648 = ((t$28647) + (" dst: "));
                        
                        //#line 40 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
                        final java.lang.String t$28649 = ((t$28648) + ((x10.core.Long.$box(dst$28659))));
                        
                        //#line 40 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
                        final java.lang.String t$28650 = ((t$28649) + (" V: "));
                        
                        //#line 40 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
                        final long t$28651 = this.V;
                        
                        //#line 40 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
                        final java.lang.String t$28652 = ((t$28650) + ((x10.core.Long.$box(t$28651))));
                        
                        //#line 40 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
                        t$28646.println(((t$28652)));
                        
                        //#line 41 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
                        this.addEdge((src$28645), (dst$28659));
                    }
                }
            }
            return this;
        }
        
        
        
        //#line 45 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
        private void addEdge(final long src, final long dst) {
            
            //#line 46 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
            final x10.core.Rail t$28488 = ((this.g));
            
            //#line 46 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
            final x10.util.ArrayList t$28489 = ((x10.util.ArrayList[])t$28488.value)[(int)src];
            
            //#line 46 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
            ((x10.util.ArrayList<x10.core.Long>)t$28489).add__0x10$util$ArrayList$$T$O(x10.core.Long.$box(dst));
            
            //#line 47 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
            final x10.core.Rail t$28490 = ((this.rg));
            
            //#line 47 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
            final x10.util.ArrayList t$28491 = ((x10.util.ArrayList[])t$28490.value)[(int)dst];
            
            //#line 47 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
            ((x10.util.ArrayList<x10.core.Long>)t$28491).add__0x10$util$ArrayList$$T$O(x10.core.Long.$box(src));
        }
        
        public static void addEdge$P(final long src, final long dst, final plham.util.JSONUtils.Graph Graph) {
            Graph.addEdge((src), (dst));
        }
        
        
        //#line 49 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
        public x10.core.Rail sort() {
            
            //#line 50 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
            final x10.core.Rail order = this.calcTopologicalOrder();
            
            //#line 51 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
            final long t$28492 = this.V;
            
            //#line 51 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
            final x10.core.Rail ans = ((new x10.core.Rail<java.lang.String>(x10.rtt.Types.STRING, ((t$28492)))));
            
            //#line 52 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
            final long i$28287min$28688 = 0L;
            
            //#line 52 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
            final long t$28689 = this.V;
            
            //#line 52 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
            final long i$28287max$28690 = ((t$28689) - (((1L))));
            
            //#line 52 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
            long i$28685 = i$28287min$28688;
            {
                
                //#line 52 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
                final long[] order$value$28851 = ((long[])order.value);
                
                //#line 52 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
                final java.lang.String[] ans$value$28852 = ((java.lang.String[])ans.value);
                
                //#line 52 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
                for (;
                     true;
                     ) {
                    
                    //#line 52 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
                    final long t$28686 = i$28685;
                    
                    //#line 52 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
                    final boolean t$28687 = ((t$28686) <= (((i$28287max$28690))));
                    
                    //#line 52 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
                    if (!(t$28687)) {
                        
                        //#line 52 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
                        break;
                    }
                    
                    //#line 52 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
                    final long i$28682 = i$28685;
                    
                    //#line 53 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
                    final long t$28679 = (order$value$28851[(int)i$28682]);
                    
                    //#line 53 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
                    final x10.core.Rail t$28680 = ((this.NodeName));
                    
                    //#line 53 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
                    final java.lang.String t$28681 = ((java.lang.String[])t$28680.value)[(int)i$28682];
                    
                    //#line 53 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
                    ans$value$28852[(int)t$28679]=t$28681;
                    
                    //#line 52 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
                    final long t$28683 = i$28685;
                    
                    //#line 52 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
                    final long t$28684 = ((t$28683) + (((1L))));
                    
                    //#line 52 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
                    i$28685 = t$28684;
                }
            }
            
            //#line 55 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
            return ans;
        }
        
        
        //#line 57 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
        private x10.core.Rail calcTopologicalOrder() {
            
            //#line 58 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
            final long t$28502 = this.V;
            
            //#line 58 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
            final x10.core.Rail used = ((new x10.core.Rail<x10.core.Boolean>(x10.rtt.Types.BOOLEAN, ((t$28502)), (x10.core.Boolean.$box(false)), (x10.core.Rail.__1x10$lang$Rail$$T) null)));
            
            //#line 59 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
            final x10.util.ArrayList vs = ((new x10.util.ArrayList<x10.core.Long>((java.lang.System[]) null, x10.rtt.Types.LONG).x10$util$ArrayList$$init$S()));
            
            //#line 60 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
            final long i$28305min$28711 = 0L;
            
            //#line 60 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
            final long t$28712 = this.V;
            
            //#line 60 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
            final long i$28305max$28713 = ((t$28712) - (((1L))));
            
            //#line 60 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
            long i$28694 = i$28305min$28711;
            {
                
                //#line 60 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
                final boolean[] used$value$28853 = ((boolean[])used.value);
                
                //#line 60 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
                for (;
                     true;
                     ) {
                    
                    //#line 60 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
                    final long t$28695 = i$28694;
                    
                    //#line 60 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
                    final boolean t$28696 = ((t$28695) <= (((i$28305max$28713))));
                    
                    //#line 60 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
                    if (!(t$28696)) {
                        
                        //#line 60 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
                        break;
                    }
                    
                    //#line 60 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
                    L$28697: {
                        
                        //#line 60 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
                        final long v$28698 = i$28694;
                        //#line 61 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
                        final boolean t$28691 = (used$value$28853[(int)v$28698]);
                        //#line 61 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
                        if (t$28691) {
                            
                            //#line 61 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
                            break L$28697;
                        }
                        //#line 62 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
                        this.forward__1$1x10$lang$Long$2__2$1x10$lang$Boolean$2((v$28698), ((vs)), ((used)));
                    }
                    
                    //#line 60 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
                    final long t$28692 = i$28694;
                    
                    //#line 60 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
                    final long t$28693 = ((t$28692) + (((1L))));
                    
                    //#line 60 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
                    i$28694 = t$28693;
                }
            }
            
            //#line 64 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
            final x10.core.Rail rail$28714 = ((used));
            
            //#line 64 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
            final long i$28323min$28715 = 0L;
            
            //#line 64 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
            final long i$28323max$28716 = ((x10.core.Rail<x10.core.Boolean>)rail$28714).size;
            
            //#line 64 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
            long i$28702 = i$28323min$28715;
            {
                
                //#line 64 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
                final boolean[] used$value$28854 = ((boolean[])used.value);
                
                //#line 64 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
                for (;
                     true;
                     ) {
                    
                    //#line 64 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
                    final long t$28703 = i$28702;
                    
                    //#line 64 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
                    final boolean t$28704 = ((t$28703) < (((i$28323max$28716))));
                    
                    //#line 64 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
                    if (!(t$28704)) {
                        
                        //#line 64 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
                        break;
                    }
                    
                    //#line 64 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
                    final long i$28699 = i$28702;
                    
                    //#line 64 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
                    used$value$28854[(int)i$28699]=false;
                    
                    //#line 64 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
                    final long t$28700 = i$28702;
                    
                    //#line 64 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
                    final long t$28701 = ((t$28700) + (((1L))));
                    
                    //#line 64 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
                    i$28702 = t$28701;
                }
            }
            
            //#line 65 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
            long k = 0L;
            
            //#line 66 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
            final long t$28515 = this.V;
            
            //#line 66 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
            final x10.core.Rail order = ((new x10.core.Rail<x10.core.Long>(x10.rtt.Types.LONG, ((t$28515)))));
            
            //#line 67 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
            final x10.core.Rail rail$28717 = ((order));
            
            //#line 67 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
            final long i$28342min$28718 = 0L;
            
            //#line 67 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
            final long i$28342max$28719 = ((x10.core.Rail<x10.core.Long>)rail$28717).size;
            
            //#line 67 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
            long i$28708 = i$28342min$28718;
            {
                
                //#line 67 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
                final long[] order$value$28855 = ((long[])order.value);
                
                //#line 67 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
                for (;
                     true;
                     ) {
                    
                    //#line 67 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
                    final long t$28709 = i$28708;
                    
                    //#line 67 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
                    final boolean t$28710 = ((t$28709) < (((i$28342max$28719))));
                    
                    //#line 67 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
                    if (!(t$28710)) {
                        
                        //#line 67 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
                        break;
                    }
                    
                    //#line 67 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
                    final long i$28705 = i$28708;
                    
                    //#line 67 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
                    order$value$28855[(int)i$28705]=-1L;
                    
                    //#line 67 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
                    final long t$28706 = i$28708;
                    
                    //#line 67 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
                    final long t$28707 = ((t$28706) + (((1L))));
                    
                    //#line 67 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
                    i$28708 = t$28707;
                }
            }
            
            //#line 68 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
            ((x10.util.ArrayList<x10.core.Long>)vs).reverse();
            
            //#line 69 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
            final x10.util.ListIterator v$28720 = (((x10.util.ArrayList<x10.core.Long>)vs).iterator());
            {
                
                //#line 69 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
                final boolean[] used$value$28856 = ((boolean[])used.value);
                
                //#line 69 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
                for (;
                     true;
                     ) {
                    
                    //#line 69 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
                    final boolean t$28721 = ((x10.util.ListIterator<x10.core.Long>)v$28720).hasNext$O();
                    
                    //#line 69 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
                    if (!(t$28721)) {
                        
                        //#line 69 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
                        break;
                    }
                    
                    //#line 69 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
                    L$28722: {
                        
                        //#line 69 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
                        final long v$28723 = x10.core.Long.$unbox(((x10.util.ListIterator<x10.core.Long>)v$28720).next$G());
                        //#line 70 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
                        final boolean t$28724 = (used$value$28856[(int)v$28723]);
                        //#line 70 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
                        if (t$28724) {
                            
                            //#line 70 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
                            break L$28722;
                        }
                        //#line 71 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
                        final long pre$28725 = k;
                        //#line 71 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
                        final long t$28726 = k;
                        //#line 71 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
                        final long t$28727 = ((t$28726) + (((1L))));
                        //#line 71 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
                        k = t$28727;
                        //#line 71 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
                        this.back__2$1x10$lang$Long$2__3$1x10$lang$Long$2__4$1x10$lang$Boolean$2((v$28723), (pre$28725), ((order)), ((vs)), ((used)));
                    }
                }
            }
            
            //#line 73 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
            return order;
        }
        
        public static x10.core.Rail calcTopologicalOrder$P(final plham.util.JSONUtils.Graph Graph) {
            return Graph.calcTopologicalOrder();
        }
        
        
        //#line 75 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
        private void forward__1$1x10$lang$Long$2__2$1x10$lang$Boolean$2(final long v, final x10.util.ArrayList vs, final x10.core.Rail used) {
            
            //#line 76 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
            ((boolean[])used.value)[(int)v] = true;
            
            //#line 77 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
            final x10.core.Rail t$28728 = ((this.g));
            
            //#line 77 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
            final x10.util.ArrayList t$28729 = ((x10.util.ArrayList[])t$28728.value)[(int)v];
            
            //#line 77 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
            final x10.util.ListIterator u$28730 = (((x10.util.ArrayList<x10.core.Long>)t$28729).iterator());
            {
                
                //#line 77 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
                final boolean[] used$value$28857 = ((boolean[])used.value);
                
                //#line 77 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
                for (;
                     true;
                     ) {
                    
                    //#line 77 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
                    final boolean t$28731 = ((x10.util.ListIterator<x10.core.Long>)u$28730).hasNext$O();
                    
                    //#line 77 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
                    if (!(t$28731)) {
                        
                        //#line 77 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
                        break;
                    }
                    
                    //#line 77 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
                    L$28732: {
                        
                        //#line 77 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
                        final long u$28733 = x10.core.Long.$unbox(((x10.util.ListIterator<x10.core.Long>)u$28730).next$G());
                        //#line 78 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
                        final boolean t$28734 = (used$value$28857[(int)u$28733]);
                        //#line 78 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
                        if (t$28734) {
                            
                            //#line 78 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
                            break L$28732;
                        }
                        //#line 79 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
                        this.forward__1$1x10$lang$Long$2__2$1x10$lang$Boolean$2((u$28733), ((vs)), ((used)));
                    }
                }
            }
            
            //#line 81 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
            ((x10.util.ArrayList<x10.core.Long>)vs).add__0x10$util$ArrayList$$T$O(x10.core.Long.$box(v));
        }
        
        public static void forward$P__1$1x10$lang$Long$2__2$1x10$lang$Boolean$2(final long v, final x10.util.ArrayList<x10.core.Long> vs, final x10.core.Rail<x10.core.Boolean> used, final plham.util.JSONUtils.Graph Graph) {
            Graph.forward__1$1x10$lang$Long$2__2$1x10$lang$Boolean$2((v), ((vs)), ((used)));
        }
        
        
        //#line 83 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
        private void back__2$1x10$lang$Long$2__3$1x10$lang$Long$2__4$1x10$lang$Boolean$2(final long v, final long k, final x10.core.Rail order, final x10.util.ArrayList vs, final x10.core.Rail used) {
            
            //#line 84 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
            ((boolean[])used.value)[(int)v] = true;
            
            //#line 85 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
            ((long[])order.value)[(int)v] = k;
            
            //#line 86 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
            final x10.core.Rail t$28735 = ((this.rg));
            
            //#line 86 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
            final x10.util.ArrayList t$28736 = ((x10.util.ArrayList[])t$28735.value)[(int)v];
            
            //#line 86 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
            final x10.util.ListIterator u$28737 = ((x10.util.ListIterator<x10.core.Long>)
                                                    ((x10.util.ArrayList<x10.core.Long>)t$28736).iterator());
            {
                
                //#line 86 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
                final boolean[] used$value$28858 = ((boolean[])used.value);
                
                //#line 86 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
                for (;
                     true;
                     ) {
                    
                    //#line 86 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
                    final boolean t$28738 = ((x10.util.ListIterator<x10.core.Long>)u$28737).hasNext$O();
                    
                    //#line 86 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
                    if (!(t$28738)) {
                        
                        //#line 86 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
                        break;
                    }
                    
                    //#line 86 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
                    L$28739: {
                        
                        //#line 86 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
                        final long u$28740 = x10.core.Long.$unbox(((x10.util.ListIterator<x10.core.Long>)u$28737).next$G());
                        //#line 87 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
                        final boolean t$28741 = ((boolean)used$value$28858[(int)u$28740]);
                        //#line 87 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
                        if (t$28741) {
                            
                            //#line 87 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
                            break L$28739;
                        }
                        //#line 88 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
                        this.back__2$1x10$lang$Long$2__3$1x10$lang$Long$2__4$1x10$lang$Boolean$2((long)(u$28740), (long)(k), ((x10.core.Rail)(order)), ((x10.util.ArrayList)(vs)), ((x10.core.Rail)(used)));
                    }
                }
            }
        }
        
        public static void back$P__2$1x10$lang$Long$2__3$1x10$lang$Long$2__4$1x10$lang$Boolean$2(final long v, final long k, final x10.core.Rail<x10.core.Long> order, final x10.util.ArrayList<x10.core.Long> vs, final x10.core.Rail<x10.core.Boolean> used, final plham.util.JSONUtils.Graph Graph) {
            Graph.back__2$1x10$lang$Long$2__3$1x10$lang$Long$2__4$1x10$lang$Boolean$2((long)(v), (long)(k), ((x10.core.Rail)(order)), ((x10.util.ArrayList)(vs)), ((x10.core.Rail)(used)));
        }
        
        
        //#line 13 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
        final public plham.util.JSONUtils.Graph plham$util$JSONUtils$Graph$$this$plham$util$JSONUtils$Graph() {
            
            //#line 13 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
            return plham.util.JSONUtils.Graph.this;
        }
        
        
        //#line 13 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
        final public void __fieldInitializers_plham_util_JSONUtils_Graph() {
            
        }
    }
    
    
    
    //#line 93 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
    public static x10.util.Map getDependencyGraph__2$1x10$lang$String$2(final cassia.util.JSON.Value root, final cassia.util.JSON.Value list, final x10.util.List<java.lang.String> keywords) {
        
        //#line 94 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
        final x10.util.HashMap graph = ((x10.util.HashMap)(new x10.util.HashMap<java.lang.String, x10.util.Set<java.lang.String>>((java.lang.System[]) null, x10.rtt.Types.STRING, x10.rtt.ParameterizedType.make(x10.util.Set.$RTT, x10.rtt.Types.STRING)).x10$util$HashMap$$init$S()));
        
        //#line 95 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
        final x10.util.Stack stack = ((x10.util.Stack)(new x10.util.Stack<java.lang.String>((java.lang.System[]) null, x10.rtt.Types.STRING).x10$util$Stack$$init$S()));
        
        //#line 96 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
        final long i$28367min$28781 = 0L;
        
        //#line 96 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
        final long t$28782 = list.size$O();
        
        //#line 96 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
        final long i$28367max$28783 = ((t$28782) - (((long)(1L))));
        
        //#line 96 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
        long i$28747 = i$28367min$28781;
        
        //#line 96 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
        for (;
             true;
             ) {
            
            //#line 96 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
            final long t$28748 = i$28747;
            
            //#line 96 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
            final boolean t$28749 = ((t$28748) <= (((long)(i$28367max$28783))));
            
            //#line 96 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
            if (!(t$28749)) {
                
                //#line 96 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
                break;
            }
            
            //#line 96 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
            final long i$28744 = i$28747;
            
            //#line 97 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
            final cassia.util.JSON.Value t$28742 = ((cassia.util.JSON.Value)list).<x10.core.Long> get(x10.rtt.Types.LONG, x10.core.Long.$box(i$28744));
            
            //#line 97 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
            final java.lang.String name$28743 = t$28742.toString();
            
            //#line 98 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
            ((x10.util.Stack<java.lang.String>)stack).push__0x10$util$Stack$$T$O(((java.lang.String)(name$28743)));
            
            //#line 96 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
            final long t$28745 = i$28747;
            
            //#line 96 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
            final long t$28746 = ((t$28745) + (((long)(1L))));
            
            //#line 96 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
            i$28747 = t$28746;
        }
        
        //#line 100 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
        while (true) {
            
            //#line 100 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
            final long t$28543 = ((x10.util.ArrayList<java.lang.String>)stack).size$O();
            
            //#line 100 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
            final boolean t$28568 = ((t$28543) > (((long)(0L))));
            
            //#line 100 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
            if (!(t$28568)) {
                
                //#line 100 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
                break;
            }
            
            //#line 101 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
            final java.lang.String name$28774 = ((x10.util.Stack<java.lang.String>)stack).pop$G();
            
            //#line 102 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
            final x10.io.Printer t$28775 = ((x10.io.Printer)(x10.io.Console.get$OUT()));
            
            //#line 102 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
            final java.lang.String t$28776 = (("#GRAPH ") + (name$28774));
            
            //#line 102 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
            final java.lang.String t$28777 = ((t$28776) + (" checking"));
            
            //#line 102 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
            t$28775.println(((java.lang.Object)(t$28777)));
            
            //#line 103 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
            final boolean t$28778 = ((x10.util.HashMap<java.lang.String, x10.util.Set<java.lang.String>>)graph).containsKey__0x10$util$HashMap$$K$O(((java.lang.String)(name$28774)));
            
            //#line 103 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
            final boolean t$28779 = !(t$28778);
            
            //#line 103 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
            if (t$28779) {
                
                //#line 104 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
                final x10.util.HashSet t$28780 = ((x10.util.HashSet)(new x10.util.HashSet<java.lang.String>((java.lang.System[]) null, x10.rtt.Types.STRING).x10$util$HashSet$$init$S()));
                
                //#line 104 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
                ((x10.util.HashMap<java.lang.String, x10.util.Set<java.lang.String>>)graph).$set__0x10$util$HashMap$$K__1x10$util$HashMap$$V$G(((java.lang.String)(name$28774)), ((x10.util.Set)(t$28780)));
            }
            
            //#line 106 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
            final x10.util.ListIterator keyword$28772 = ((x10.util.ListIterator<java.lang.String>)
                                                          ((x10.util.List<java.lang.String>)keywords).iterator());
            
            //#line 106 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
            for (;
                 true;
                 ) {
                
                //#line 106 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
                final boolean t$28773 = ((x10.util.ListIterator<java.lang.String>)keyword$28772).hasNext$O();
                
                //#line 106 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
                if (!(t$28773)) {
                    
                    //#line 106 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
                    break;
                }
                
                //#line 106 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
                final java.lang.String keyword$28767 = ((java.lang.String)(((x10.util.ListIterator<java.lang.String>)keyword$28772).next$G()));
                
                //#line 107 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
                final cassia.util.JSON.Value t$28768 = ((cassia.util.JSON.Value)root).<java.lang.String> get(x10.rtt.Types.STRING, ((java.lang.String)(name$28774)));
                
                //#line 107 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
                final boolean t$28769 = ((cassia.util.JSON.Value)t$28768).<java.lang.String> has__0cassia$util$JSON$Value$$T$O(x10.rtt.Types.STRING, ((java.lang.String)(keyword$28767)));
                
                //#line 107 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
                if (t$28769) {
                    
                    //#line 108 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
                    final cassia.util.JSON.Value t$28770 = ((cassia.util.JSON.Value)root).<java.lang.String> get(x10.rtt.Types.STRING, ((java.lang.String)(name$28774)));
                    
                    //#line 108 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
                    final cassia.util.JSON.Value children$28771 = ((cassia.util.JSON.Value)t$28770).<java.lang.String> get(x10.rtt.Types.STRING, ((java.lang.String)(keyword$28767)));
                    
                    //#line 109 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
                    final long i$28385min$28764 = 0L;
                    
                    //#line 109 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
                    final long t$28765 = children$28771.size$O();
                    
                    //#line 109 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
                    final long i$28385max$28766 = ((t$28765) - (((long)(1L))));
                    
                    //#line 109 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
                    long i$28761 = i$28385min$28764;
                    
                    //#line 109 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
                    for (;
                         true;
                         ) {
                        
                        //#line 109 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
                        final long t$28762 = i$28761;
                        
                        //#line 109 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
                        final boolean t$28763 = ((t$28762) <= (((long)(i$28385max$28766))));
                        
                        //#line 109 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
                        if (!(t$28763)) {
                            
                            //#line 109 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
                            break;
                        }
                        
                        //#line 109 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
                        final long i$28758 = i$28761;
                        
                        //#line 110 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
                        final cassia.util.JSON.Value t$28750 = ((cassia.util.JSON.Value)children$28771).<x10.core.Long> get(x10.rtt.Types.LONG, x10.core.Long.$box(i$28758));
                        
                        //#line 110 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
                        final java.lang.String child$28751 = t$28750.toString();
                        
                        //#line 111 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
                        ((x10.util.Stack<java.lang.String>)stack).push__0x10$util$Stack$$T$O(((java.lang.String)(child$28751)));
                        
                        //#line 112 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
                        final x10.util.Set t$28752 = ((x10.util.HashMap<java.lang.String, x10.util.Set<java.lang.String>>)graph).$apply__0x10$util$HashMap$$K$G(((java.lang.String)(name$28774)));
                        
                        //#line 112 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
                        ((x10.util.Collection<java.lang.String>)t$28752).add$Z(((java.lang.String)(child$28751)), x10.rtt.Types.STRING);
                        
                        //#line 113 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
                        final x10.io.Printer t$28753 = ((x10.io.Printer)(x10.io.Console.get$OUT()));
                        
                        //#line 113 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
                        final java.lang.String t$28754 = (("#GRAPH ") + (name$28774));
                        
                        //#line 113 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
                        final java.lang.String t$28755 = ((t$28754) + (" --> "));
                        
                        //#line 113 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
                        final java.lang.String t$28756 = ((t$28755) + (child$28751));
                        
                        //#line 113 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
                        final java.lang.String t$28757 = ((t$28756) + (" created"));
                        
                        //#line 113 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
                        t$28753.println(((java.lang.Object)(t$28757)));
                        
                        //#line 109 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
                        final long t$28759 = i$28761;
                        
                        //#line 109 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
                        final long t$28760 = ((t$28759) + (((long)(1L))));
                        
                        //#line 109 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
                        i$28761 = t$28760;
                    }
                }
            }
        }
        
        //#line 118 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
        return graph;
    }
    
    
    //#line 121 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
    public static x10.util.List getDependencySortedList__2$1x10$lang$String$2(final cassia.util.JSON.Value root, final cassia.util.JSON.Value list, final x10.util.List<java.lang.String> keywords) {
        
        //#line 122 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
        final x10.util.Map t$28569 = plham.util.JSONUtils.getDependencyGraph__2$1x10$lang$String$2(((cassia.util.JSON.Value)(root)), ((cassia.util.JSON.Value)(list)), ((x10.util.List)(keywords)));
        
        //#line 122 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
        final plham.util.JSONUtils.Graph graph = ((plham.util.JSONUtils.Graph)(new plham.util.JSONUtils.Graph((java.lang.System[]) null).plham$util$JSONUtils$Graph$$init$S(t$28569, (plham.util.JSONUtils.Graph.__0$1x10$lang$String$3x10$util$Set$1x10$lang$String$2$2) null)));
        
        //#line 123 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
        final x10.core.Rail rail = graph.sort();
        
        //#line 124 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
        final x10.util.ArrayList retval = ((x10.util.ArrayList)(new x10.util.ArrayList<java.lang.String>((java.lang.System[]) null, x10.rtt.Types.STRING).x10$util$ArrayList$$init$S()));
        
        //#line 125 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
        ((x10.util.ArrayList<java.lang.String>)retval).addAll__0$1x10$util$ArrayList$$T$2$O(((x10.core.Rail)(rail)));
        
        //#line 126 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
        final x10.io.Printer t$28570 = ((x10.io.Printer)(x10.io.Console.get$OUT()));
        
        //#line 126 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
        final java.lang.String t$28571 = (("#GRAPH-SORTED ") + (retval));
        
        //#line 126 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
        t$28570.println(((java.lang.Object)(t$28571)));
        
        //#line 127 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
        return retval;
    }
    
    
    //#line 130 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
    public static x10.util.Map getDependencyGraph(final cassia.util.JSON.Value root, final cassia.util.JSON.Value list, final java.lang.String keyword) {
        
        //#line 131 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
        final x10.util.HashMap graph = ((x10.util.HashMap)(new x10.util.HashMap<java.lang.String, x10.util.Set<java.lang.String>>((java.lang.System[]) null, x10.rtt.Types.STRING, x10.rtt.ParameterizedType.make(x10.util.Set.$RTT, x10.rtt.Types.STRING)).x10$util$HashMap$$init$S()));
        
        //#line 132 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
        final x10.util.Stack stack = ((x10.util.Stack)(new x10.util.Stack<java.lang.String>((java.lang.System[]) null, x10.rtt.Types.STRING).x10$util$Stack$$init$S()));
        
        //#line 133 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
        final long i$28405min$28822 = 0L;
        
        //#line 133 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
        final long t$28823 = list.size$O();
        
        //#line 133 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
        final long i$28405max$28824 = ((t$28823) - (((long)(1L))));
        
        //#line 133 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
        long i$28789 = i$28405min$28822;
        
        //#line 133 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
        for (;
             true;
             ) {
            
            //#line 133 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
            final long t$28790 = i$28789;
            
            //#line 133 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
            final boolean t$28791 = ((t$28790) <= (((long)(i$28405max$28824))));
            
            //#line 133 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
            if (!(t$28791)) {
                
                //#line 133 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
                break;
            }
            
            //#line 133 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
            final long i$28786 = i$28789;
            
            //#line 134 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
            final cassia.util.JSON.Value t$28784 = ((cassia.util.JSON.Value)list).<x10.core.Long> get(x10.rtt.Types.LONG, x10.core.Long.$box(i$28786));
            
            //#line 134 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
            final java.lang.String name$28785 = t$28784.toString();
            
            //#line 135 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
            ((x10.util.Stack<java.lang.String>)stack).push__0x10$util$Stack$$T$O(((java.lang.String)(name$28785)));
            
            //#line 133 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
            final long t$28787 = i$28789;
            
            //#line 133 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
            final long t$28788 = ((t$28787) + (((long)(1L))));
            
            //#line 133 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
            i$28789 = t$28788;
        }
        
        //#line 137 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
        long t = 0L;
        
        //#line 138 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
        while (true) {
            
            //#line 138 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
            final long t$28579 = ((x10.util.ArrayList<java.lang.String>)stack).size$O();
            
            //#line 138 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
            final boolean t$28604 = ((t$28579) > (((long)(0L))));
            
            //#line 138 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
            if (!(t$28604)) {
                
                //#line 138 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
                break;
            }
            
            //#line 139 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
            final java.lang.String name$28809 = ((x10.util.Stack<java.lang.String>)stack).pop$G();
            
            //#line 140 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
            final x10.io.Printer t$28810 = ((x10.io.Printer)(x10.io.Console.get$OUT()));
            
            //#line 140 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
            final java.lang.String t$28811 = (("#GRAPH ") + (name$28809));
            
            //#line 140 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
            final java.lang.String t$28812 = ((t$28811) + (" checking"));
            
            //#line 140 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
            t$28810.println(((java.lang.Object)(t$28812)));
            
            //#line 141 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
            final boolean t$28813 = ((x10.util.HashMap<java.lang.String, x10.util.Set<java.lang.String>>)graph).containsKey__0x10$util$HashMap$$K$O(((java.lang.String)(name$28809)));
            
            //#line 141 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
            final boolean t$28814 = !(t$28813);
            
            //#line 141 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
            if (t$28814) {
                
                //#line 142 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
                final x10.util.HashSet t$28815 = ((x10.util.HashSet)(new x10.util.HashSet<java.lang.String>((java.lang.System[]) null, x10.rtt.Types.STRING).x10$util$HashSet$$init$S()));
                
                //#line 142 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
                ((x10.util.HashMap<java.lang.String, x10.util.Set<java.lang.String>>)graph).$set__0x10$util$HashMap$$K__1x10$util$HashMap$$V$G(((java.lang.String)(name$28809)), ((x10.util.Set)(t$28815)));
            }
            
            //#line 144 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
            final cassia.util.JSON.Value t$28816 = ((cassia.util.JSON.Value)root).<java.lang.String> get(x10.rtt.Types.STRING, ((java.lang.String)(name$28809)));
            
            //#line 144 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
            final boolean t$28817 = ((cassia.util.JSON.Value)t$28816).<java.lang.String> has__0cassia$util$JSON$Value$$T$O(x10.rtt.Types.STRING, ((java.lang.String)(keyword)));
            
            //#line 144 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
            if (t$28817) {
                
                //#line 145 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
                final cassia.util.JSON.Value t$28818 = ((cassia.util.JSON.Value)root).<java.lang.String> get(x10.rtt.Types.STRING, ((java.lang.String)(name$28809)));
                
                //#line 145 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
                final cassia.util.JSON.Value children$28819 = ((cassia.util.JSON.Value)t$28818).<java.lang.String> get(x10.rtt.Types.STRING, ((java.lang.String)(keyword)));
                
                //#line 146 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
                final long i$28423min$28806 = 0L;
                
                //#line 146 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
                final long t$28807 = children$28819.size$O();
                
                //#line 146 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
                final long i$28423max$28808 = ((t$28807) - (((long)(1L))));
                
                //#line 146 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
                long i$28803 = i$28423min$28806;
                
                //#line 146 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
                for (;
                     true;
                     ) {
                    
                    //#line 146 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
                    final long t$28804 = i$28803;
                    
                    //#line 146 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
                    final boolean t$28805 = ((t$28804) <= (((long)(i$28423max$28808))));
                    
                    //#line 146 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
                    if (!(t$28805)) {
                        
                        //#line 146 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
                        break;
                    }
                    
                    //#line 146 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
                    final long j$28800 = i$28803;
                    
                    //#line 147 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
                    final cassia.util.JSON.Value t$28792 = ((cassia.util.JSON.Value)children$28819).<x10.core.Long> get(x10.rtt.Types.LONG, x10.core.Long.$box(j$28800));
                    
                    //#line 147 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
                    final java.lang.String child$28793 = t$28792.toString();
                    
                    //#line 148 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
                    ((x10.util.Stack<java.lang.String>)stack).push__0x10$util$Stack$$T$O(((java.lang.String)(child$28793)));
                    
                    //#line 149 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
                    final x10.util.Set t$28794 = ((x10.util.HashMap<java.lang.String, x10.util.Set<java.lang.String>>)graph).$apply__0x10$util$HashMap$$K$G(((java.lang.String)(name$28809)));
                    
                    //#line 149 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
                    ((x10.util.Collection<java.lang.String>)t$28794).add$Z(((java.lang.String)(child$28793)), x10.rtt.Types.STRING);
                    
                    //#line 150 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
                    final x10.io.Printer t$28795 = ((x10.io.Printer)(x10.io.Console.get$OUT()));
                    
                    //#line 150 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
                    final java.lang.String t$28796 = (("#GRAPH ") + (name$28809));
                    
                    //#line 150 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
                    final java.lang.String t$28797 = ((t$28796) + (" --> "));
                    
                    //#line 150 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
                    final java.lang.String t$28798 = ((t$28797) + (child$28793));
                    
                    //#line 150 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
                    final java.lang.String t$28799 = ((t$28798) + (" created"));
                    
                    //#line 150 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
                    t$28795.println(((java.lang.Object)(t$28799)));
                    
                    //#line 146 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
                    final long t$28801 = i$28803;
                    
                    //#line 146 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
                    final long t$28802 = ((t$28801) + (((long)(1L))));
                    
                    //#line 146 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
                    i$28803 = t$28802;
                }
            }
            
            //#line 153 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
            final long t$28820 = t;
            
            //#line 153 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
            final long t$28821 = ((t$28820) + (((long)(1L))));
            
            //#line 153 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
            t = t$28821;
        }
        
        //#line 155 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
        return graph;
    }
    
    
    //#line 158 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
    public static x10.util.List getDependencySortedList(final cassia.util.JSON.Value root, final cassia.util.JSON.Value list, final java.lang.String keyword) {
        
        //#line 159 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
        final x10.util.Map graph = plham.util.JSONUtils.getDependencyGraph(((cassia.util.JSON.Value)(root)), ((cassia.util.JSON.Value)(list)), ((java.lang.String)(keyword)));
        
        //#line 160 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
        final x10.util.ArrayList nodes = ((x10.util.ArrayList)(new x10.util.ArrayList<java.lang.String>((java.lang.System[]) null, x10.rtt.Types.STRING).x10$util$ArrayList$$init$S()));
        
        //#line 161 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
        final x10.util.Set t$28605 = ((x10.util.Set<java.lang.String>)
                                       ((x10.util.Map<java.lang.String, x10.util.Set<java.lang.String>>)graph).keySet());
        
        //#line 161 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
        ((x10.util.AbstractCollection<java.lang.String>)nodes).addAll__0$1x10$util$AbstractCollection$$T$2$O(((x10.util.Container)(t$28605)));
        
        //#line 164 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
        final x10.util.ArrayList sorted = ((x10.util.ArrayList)(new x10.util.ArrayList<java.lang.String>((java.lang.System[]) null, x10.rtt.Types.STRING).x10$util$ArrayList$$init$S()));
        
        //#line 165 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
        while (true) {
            
            //#line 165 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
            final long t$28606 = ((x10.util.Map<java.lang.String, x10.util.Set<java.lang.String>>)graph).size$O();
            
            //#line 165 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
            final boolean t$28630 = ((t$28606) > (((long)(0L))));
            
            //#line 165 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
            if (!(t$28630)) {
                
                //#line 165 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
                break;
            }
            
            //#line 166 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
            final long numNodes$28845 = ((x10.util.Map<java.lang.String, x10.util.Set<java.lang.String>>)graph).size$O();
            
            //#line 167 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
            final x10.util.ListIterator name$28843 = ((x10.util.ListIterator<java.lang.String>)
                                                       ((x10.util.ArrayList<java.lang.String>)nodes).iterator());
            
            //#line 167 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
            for (;
                 true;
                 ) {
                
                //#line 167 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
                final boolean t$28844 = ((x10.util.ListIterator<java.lang.String>)name$28843).hasNext$O();
                
                //#line 167 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
                if (!(t$28844)) {
                    
                    //#line 167 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
                    break;
                }
                
                //#line 167 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
                final java.lang.String name$28836 = ((java.lang.String)(((x10.util.ListIterator<java.lang.String>)name$28843).next$G()));
                
                //#line 168 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
                final x10.util.Set t$28837 = ((x10.util.Set<java.lang.String>)
                                               ((x10.util.Map<java.lang.String, x10.util.Set<java.lang.String>>)graph).$apply(((java.lang.String)(name$28836)), x10.rtt.Types.STRING));
                
                //#line 168 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
                final long t$28838 = ((x10.util.Container<java.lang.String>)t$28837).size$O();
                
                //#line 168 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
                final boolean t$28839 = ((long) t$28838) == ((long) 0L);
                
                //#line 168 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
                if (t$28839) {
                    
                    //#line 169 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
                    ((x10.util.ArrayList<java.lang.String>)sorted).add__0x10$util$ArrayList$$T$O(((java.lang.String)(name$28836)));
                    
                    //#line 170 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
                    final x10.util.Set t$28833 = ((x10.util.Set<java.lang.String>)
                                                   ((x10.util.Map<java.lang.String, x10.util.Set<java.lang.String>>)graph).keySet());
                    
                    //#line 170 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
                    final x10.lang.Iterator parent$28834 = ((x10.lang.Iterator<java.lang.String>)
                                                             ((x10.lang.Iterable<java.lang.String>)t$28833).iterator());
                    
                    //#line 170 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
                    for (;
                         true;
                         ) {
                        
                        //#line 170 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
                        final boolean t$28835 = ((x10.lang.Iterator<java.lang.String>)parent$28834).hasNext$O();
                        
                        //#line 170 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
                        if (!(t$28835)) {
                            
                            //#line 170 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
                            break;
                        }
                        
                        //#line 170 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
                        final java.lang.String parent$28825 = ((java.lang.String)(((x10.lang.Iterator<java.lang.String>)parent$28834).next$G()));
                        
                        //#line 171 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
                        final x10.util.Set t$28826 = ((x10.util.Set<java.lang.String>)
                                                       ((x10.util.Map<java.lang.String, x10.util.Set<java.lang.String>>)graph).$apply(((java.lang.String)(parent$28825)), x10.rtt.Types.STRING));
                        
                        //#line 171 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
                        final boolean t$28827 = x10.core.Boolean.$unbox(((x10.util.Collection<java.lang.String>)t$28826).remove$Z(((java.lang.String)(name$28836)), x10.rtt.Types.STRING));
                        
                        //#line 171 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
                        if (t$28827) {
                            
                            //#line 172 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
                            final x10.io.Printer t$28828 = ((x10.io.Printer)(x10.io.Console.get$OUT()));
                            
                            //#line 172 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
                            final java.lang.String t$28829 = (("#GRAPH ") + (parent$28825));
                            
                            //#line 172 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
                            final java.lang.String t$28830 = ((t$28829) + (" --> "));
                            
                            //#line 172 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
                            final java.lang.String t$28831 = ((t$28830) + (name$28836));
                            
                            //#line 172 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
                            final java.lang.String t$28832 = ((t$28831) + (" removed"));
                            
                            //#line 172 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
                            t$28828.println(((java.lang.Object)(t$28832)));
                        }
                    }
                    
                    //#line 175 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
                    ((x10.util.Map<java.lang.String, x10.util.Set<java.lang.String>>)graph).remove(((java.lang.String)(name$28836)), x10.rtt.Types.STRING);
                    
                    //#line 176 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
                    ((x10.util.ArrayList<java.lang.String>)nodes).remove__0x10$util$ArrayList$$T$O(((java.lang.String)(name$28836)));
                    
                    //#line 177 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
                    final x10.io.Printer t$28840 = ((x10.io.Printer)(x10.io.Console.get$OUT()));
                    
                    //#line 177 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
                    final java.lang.String t$28841 = (("#GRAPH ") + (name$28836));
                    
                    //#line 177 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
                    final java.lang.String t$28842 = ((t$28841) + (" removed"));
                    
                    //#line 177 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
                    t$28840.println(((java.lang.Object)(t$28842)));
                }
            }
            
            //#line 180 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
            final long t$28846 = ((x10.util.Map<java.lang.String, x10.util.Set<java.lang.String>>)graph).size$O();
            
            //#line 180 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
            final boolean t$28847 = ((long) numNodes$28845) == ((long) t$28846);
            
            //#line 180 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
            if (t$28847) {
                
                //#line 181 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
                final java.lang.String t$28848 = (("Circular dependency of \'") + (keyword));
                
                //#line 181 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
                final java.lang.String t$28849 = ((t$28848) + ("\' detected"));
                
                //#line 181 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
                final java.lang.RuntimeException t$28850 = ((java.lang.RuntimeException)(new java.lang.RuntimeException(t$28849)));
                
                //#line 181 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
                throw t$28850;
            }
        }
        
        //#line 184 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
        final x10.io.Printer t$28631 = ((x10.io.Printer)(x10.io.Console.get$OUT()));
        
        //#line 184 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
        final java.lang.String t$28632 = (("#GRAPH-SORTED ") + (sorted));
        
        //#line 184 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
        t$28631.println(((java.lang.Object)(t$28632)));
        
        //#line 185 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
        return sorted;
    }
    
    
    //#line 11 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
    final public plham.util.JSONUtils plham$util$JSONUtils$$this$plham$util$JSONUtils() {
        
        //#line 11 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
        return plham.util.JSONUtils.this;
    }
    
    
    //#line 11 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
    // creation method for java code (1-phase java constructor)
    public JSONUtils() {
        this((java.lang.System[]) null);
        plham$util$JSONUtils$$init$S();
    }
    
    // constructor for non-virtual call
    final public plham.util.JSONUtils plham$util$JSONUtils$$init$S() {
         {
            
            //#line 11 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
            
            
            //#line 11 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
            this.__fieldInitializers_plham_util_JSONUtils();
        }
        return this;
    }
    
    
    
    //#line 11 "/home/dsl/workspace/plhamK/plham/util/JSONUtils.x10"
    final public void __fieldInitializers_plham_util_JSONUtils() {
        
    }
}

