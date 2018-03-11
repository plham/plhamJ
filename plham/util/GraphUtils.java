package plham.util;



public class GraphUtils extends x10.core.Ref implements x10.serialization.X10JavaSerializable
{
    public static final x10.rtt.RuntimeType<GraphUtils> $RTT = 
        x10.rtt.NamedType.<GraphUtils> make("plham.util.GraphUtils",
                                            GraphUtils.class);
    
    public x10.rtt.RuntimeType<?> $getRTT() { return $RTT; }
    
    public x10.rtt.Type<?> $getParam(int i) { return null; }
    
    private Object writeReplace() throws java.io.ObjectStreamException {
        return new x10.serialization.SerializationProxy(this);
    }
    
    public static x10.serialization.X10JavaSerializable $_deserialize_body(plham.util.GraphUtils $_obj, x10.serialization.X10JavaDeserializer $deserializer) throws java.io.IOException {
        if (x10.runtime.impl.java.Runtime.TRACE_SER) { x10.runtime.impl.java.Runtime.printTraceMessage("X10JavaSerializable: $_deserialize_body() of " + GraphUtils.class + " calling"); } 
        return $_obj;
    }
    
    public static x10.serialization.X10JavaSerializable $_deserializer(x10.serialization.X10JavaDeserializer $deserializer) throws java.io.IOException {
        plham.util.GraphUtils $_obj = new plham.util.GraphUtils((java.lang.System[]) null);
        $deserializer.record_reference($_obj);
        return $_deserialize_body($_obj, $deserializer);
    }
    
    public void $_serialize(x10.serialization.X10JavaSerializer $serializer) throws java.io.IOException {
        
    }
    
    // constructor just for allocation
    public GraphUtils(final java.lang.System[] $dummy) {
        
    }
    
    

    
    
    //#line 17 "/home/dsl/workspace/plhamK/plham/util/GraphUtils.x10"
    /**
	 * Convert adjacency pairs to adjacency lists.
	 */
    public static <$T>x10.util.Map toAdjacencySet__0$1plham$util$GraphUtils$$T$2__1$1x10$util$Pair$1plham$util$GraphUtils$$T$3plham$util$GraphUtils$$T$2$2(final x10.rtt.Type $T, final x10.util.Set<$T> nodes, final x10.util.Set<x10.util.Pair<$T, $T>> pairs) {
        
        //#line 18 "/home/dsl/workspace/plhamK/plham/util/GraphUtils.x10"
        final x10.util.HashMap graph = ((new x10.util.HashMap<$T, x10.util.Set<$T>>((java.lang.System[]) null, $T, x10.rtt.ParameterizedType.make(x10.util.Set.$RTT, $T)).x10$util$HashMap$$init$S()));
        
        //#line 19 "/home/dsl/workspace/plhamK/plham/util/GraphUtils.x10"
        final x10.lang.Iterator i$33934 = (((x10.lang.Iterable<$T>)nodes).iterator());
        
        //#line 19 "/home/dsl/workspace/plhamK/plham/util/GraphUtils.x10"
        for (;
             true;
             ) {
            
            //#line 19 "/home/dsl/workspace/plhamK/plham/util/GraphUtils.x10"
            final boolean t$33935 = ((x10.lang.Iterator<$T>)i$33934).hasNext$O();
            
            //#line 19 "/home/dsl/workspace/plhamK/plham/util/GraphUtils.x10"
            if (!(t$33935)) {
                
                //#line 19 "/home/dsl/workspace/plhamK/plham/util/GraphUtils.x10"
                break;
            }
            
            //#line 19 "/home/dsl/workspace/plhamK/plham/util/GraphUtils.x10"
            final $T i$33928 = ((((x10.lang.Iterator<$T>)i$33934).next$G()));
            
            //#line 20 "/home/dsl/workspace/plhamK/plham/util/GraphUtils.x10"
            final x10.util.HashSet t$33929 = ((new x10.util.HashSet<$T>((java.lang.System[]) null, $T).x10$util$HashSet$$init$S()));
            
            //#line 20 "/home/dsl/workspace/plhamK/plham/util/GraphUtils.x10"
            ((x10.util.HashMap<$T, x10.util.Set<$T>>)graph).$set__0x10$util$HashMap$$K__1x10$util$HashMap$$V$G(((i$33928)), ((t$33929)));
        }
        
        //#line 22 "/home/dsl/workspace/plhamK/plham/util/GraphUtils.x10"
        final x10.lang.Iterator key$33936 = (((x10.lang.Iterable<x10.util.Pair<$T, $T>>)pairs).iterator());
        
        //#line 22 "/home/dsl/workspace/plhamK/plham/util/GraphUtils.x10"
        for (;
             true;
             ) {
            
            //#line 22 "/home/dsl/workspace/plhamK/plham/util/GraphUtils.x10"
            final boolean t$33937 = ((x10.lang.Iterator<x10.util.Pair<$T, $T>>)key$33936).hasNext$O();
            
            //#line 22 "/home/dsl/workspace/plhamK/plham/util/GraphUtils.x10"
            if (!(t$33937)) {
                
                //#line 22 "/home/dsl/workspace/plhamK/plham/util/GraphUtils.x10"
                break;
            }
            
            //#line 22 "/home/dsl/workspace/plhamK/plham/util/GraphUtils.x10"
            final x10.util.Pair key$33930 = ((((x10.lang.Iterator<x10.util.Pair<$T, $T>>)key$33936).next$G()));
            
            //#line 23 "/home/dsl/workspace/plhamK/plham/util/GraphUtils.x10"
            final $T i$33931 = ((((x10.util.Pair<$T, $T>)key$33930).first));
            
            //#line 24 "/home/dsl/workspace/plhamK/plham/util/GraphUtils.x10"
            final $T j$33932 = ((((x10.util.Pair<$T, $T>)key$33930).second));
            
            //#line 25 "/home/dsl/workspace/plhamK/plham/util/GraphUtils.x10"
            final x10.util.Set t$33933 = ((x10.util.HashMap<$T, x10.util.Set<$T>>)graph).$apply__0x10$util$HashMap$$K$G(((i$33931)));
            
            //#line 25 "/home/dsl/workspace/plhamK/plham/util/GraphUtils.x10"
            ((x10.util.Collection<$T>)t$33933).add$Z(((j$33932)), $T);
        }
        
        //#line 27 "/home/dsl/workspace/plhamK/plham/util/GraphUtils.x10"
        return graph;
    }
    
    
    //#line 30 "/home/dsl/workspace/plhamK/plham/util/GraphUtils.x10"
	public static <$T> x10.util.List getConnectedComponents(final x10.rtt.Type $T, final x10.util.Set<$T> nodes, final x10.util.Set<x10.util.Pair<$T, $T>> pairs) {
        
        //#line 31 "/home/dsl/workspace/plhamK/plham/util/GraphUtils.x10"
        final x10.util.Map graph = plham.util.GraphUtils.<$T> toAdjacencySet__0$1plham$util$GraphUtils$$T$2__1$1x10$util$Pair$1plham$util$GraphUtils$$T$3plham$util$GraphUtils$$T$2$2($T, ((x10.util.Set)(nodes)), ((x10.util.Set)(pairs)));
        
        //#line 32 "/home/dsl/workspace/plhamK/plham/util/GraphUtils.x10"
        final x10.util.List t$33849 = plham.util.GraphUtils.<$T> getConnectedComponents__0$1plham$util$GraphUtils$$T$3x10$util$Set$1plham$util$GraphUtils$$T$2$2($T, ((graph)));
        
        //#line 32 "/home/dsl/workspace/plhamK/plham/util/GraphUtils.x10"
        return t$33849;
    }
    
    
    //#line 40 "/home/dsl/workspace/plhamK/plham/util/GraphUtils.x10"
    /**
	 * Find connected components of the <b>undirected</b> graph.
	 * @param graph  adjacency list (all nodes must be in the keys)
	 * @return a list of connected components
	 */
    public static <$T>x10.util.List getConnectedComponents__0$1plham$util$GraphUtils$$T$3x10$util$Set$1plham$util$GraphUtils$$T$2$2(final x10.rtt.Type $T, final x10.util.Map<$T, x10.util.Set<$T>> graph) {
        
        //#line 41 "/home/dsl/workspace/plhamK/plham/util/GraphUtils.x10"
        final x10.util.ArrayList out = ((new x10.util.ArrayList<x10.util.Set<$T>>((java.lang.System[]) null, x10.rtt.ParameterizedType.make(x10.util.Set.$RTT, $T)).x10$util$ArrayList$$init$S()));
        
        //#line 42 "/home/dsl/workspace/plhamK/plham/util/GraphUtils.x10"
        final x10.util.HashSet checked = ((new x10.util.HashSet<$T>((java.lang.System[]) null, $T).x10$util$HashSet$$init$S()));
        
        //#line 43 "/home/dsl/workspace/plhamK/plham/util/GraphUtils.x10"
        final x10.util.Set t$33952 = (graph.keySet());
        
        //#line 43 "/home/dsl/workspace/plhamK/plham/util/GraphUtils.x10"
        final x10.lang.Iterator root$33953 = (((x10.lang.Iterable<$T>)t$33952).iterator());
        
        //#line 43 "/home/dsl/workspace/plhamK/plham/util/GraphUtils.x10"
        for (;
             true;
             ) {
            
            //#line 43 "/home/dsl/workspace/plhamK/plham/util/GraphUtils.x10"
            final boolean t$33954 = ((x10.lang.Iterator<$T>)root$33953).hasNext$O();
            
            //#line 43 "/home/dsl/workspace/plhamK/plham/util/GraphUtils.x10"
            if (!(t$33954)) {
                
                //#line 43 "/home/dsl/workspace/plhamK/plham/util/GraphUtils.x10"
                break;
            }
            
            //#line 43 "/home/dsl/workspace/plhamK/plham/util/GraphUtils.x10"
            L$33955: {
                
                //#line 43 "/home/dsl/workspace/plhamK/plham/util/GraphUtils.x10"
                final $T root$33956 = ((((x10.lang.Iterator<$T>)root$33953).next$G()));
                //#line 44 "/home/dsl/workspace/plhamK/plham/util/GraphUtils.x10"
                final boolean t$33957 = ((x10.util.MapSet<$T>)checked).contains__0x10$util$MapSet$$T$O(((root$33956)));
                //#line 44 "/home/dsl/workspace/plhamK/plham/util/GraphUtils.x10"
                if (t$33957) {
                    
                    //#line 45 "/home/dsl/workspace/plhamK/plham/util/GraphUtils.x10"
                    break L$33955;
                }
                //#line 48 "/home/dsl/workspace/plhamK/plham/util/GraphUtils.x10"
                final x10.io.Printer t$33958 = ((x10.io.Console.get$OUT()));
                //#line 48 "/home/dsl/workspace/plhamK/plham/util/GraphUtils.x10"
                final java.lang.String t$33959 = (("#GRAPH ") + (root$33956));
                //#line 48 "/home/dsl/workspace/plhamK/plham/util/GraphUtils.x10"
                final java.lang.String t$33960 = ((t$33959) + (" checking"));
                //#line 48 "/home/dsl/workspace/plhamK/plham/util/GraphUtils.x10"
                t$33958.println(((t$33960)));
                //#line 49 "/home/dsl/workspace/plhamK/plham/util/GraphUtils.x10"
                final x10.util.HashSet visited$33961 = ((new x10.util.HashSet<$T>((java.lang.System[]) null, $T).x10$util$HashSet$$init$S()));
                //#line 50 "/home/dsl/workspace/plhamK/plham/util/GraphUtils.x10"
                final x10.util.Stack stack$33962 = ((new x10.util.Stack<$T>((java.lang.System[]) null, $T).x10$util$Stack$$init$S()));
                //#line 51 "/home/dsl/workspace/plhamK/plham/util/GraphUtils.x10"
                ((x10.util.Stack<$T>)stack$33962).push__0x10$util$Stack$$T$O(((root$33956)));
                //#line 52 "/home/dsl/workspace/plhamK/plham/util/GraphUtils.x10"
                while (true) {
                    
                    //#line 52 "/home/dsl/workspace/plhamK/plham/util/GraphUtils.x10"
                    final long t$33963 = ((x10.util.ArrayList<$T>)stack$33962).size$O();
                    
                    //#line 52 "/home/dsl/workspace/plhamK/plham/util/GraphUtils.x10"
                    final boolean t$33964 = ((t$33963) > (((0L))));
                    
                    //#line 52 "/home/dsl/workspace/plhamK/plham/util/GraphUtils.x10"
                    if (!(t$33964)) {
                        
                        //#line 52 "/home/dsl/workspace/plhamK/plham/util/GraphUtils.x10"
                        break;
                    }
                    
                    //#line 53 "/home/dsl/workspace/plhamK/plham/util/GraphUtils.x10"
                    final $T key$33947 = ((((x10.util.Stack<$T>)stack$33962).pop$G()));
                    
                    //#line 54 "/home/dsl/workspace/plhamK/plham/util/GraphUtils.x10"
                    final boolean t$33948 = ((x10.util.MapSet<$T>)visited$33961).contains__0x10$util$MapSet$$T$O(((key$33947)));
                    
                    //#line 54 "/home/dsl/workspace/plhamK/plham/util/GraphUtils.x10"
                    if (t$33948) {
                        
                        //#line 55 "/home/dsl/workspace/plhamK/plham/util/GraphUtils.x10"
                        continue;
                    }
                    
                    //#line 57 "/home/dsl/workspace/plhamK/plham/util/GraphUtils.x10"
                    ((x10.util.MapSet<$T>)visited$33961).add__0x10$util$MapSet$$T$O(((key$33947)));
                    
                    //#line 58 "/home/dsl/workspace/plhamK/plham/util/GraphUtils.x10"
                    final x10.io.Printer t$33949 = ((x10.io.Console.get$OUT()));
                    
                    //#line 58 "/home/dsl/workspace/plhamK/plham/util/GraphUtils.x10"
                    final java.lang.String t$33950 = (("#GRAPH ") + (key$33947));
                    
                    //#line 58 "/home/dsl/workspace/plhamK/plham/util/GraphUtils.x10"
                    final java.lang.String t$33951 = ((t$33950) + (" checking(sub)"));
                    
                    //#line 58 "/home/dsl/workspace/plhamK/plham/util/GraphUtils.x10"
                    t$33949.println(((t$33951)));
                    
                    //#line 59 "/home/dsl/workspace/plhamK/plham/util/GraphUtils.x10"
                    final x10.util.Set t$33944 = ((x10.util.Set<$T>)
                                                   graph.$apply(((key$33947)), $T));
                    
                    //#line 59 "/home/dsl/workspace/plhamK/plham/util/GraphUtils.x10"
                    final x10.lang.Iterator child$33945 = (((x10.lang.Iterable<$T>)t$33944).iterator());
                    
                    //#line 59 "/home/dsl/workspace/plhamK/plham/util/GraphUtils.x10"
                    for (;
                         true;
                         ) {
                        
                        //#line 59 "/home/dsl/workspace/plhamK/plham/util/GraphUtils.x10"
                        final boolean t$33946 = ((x10.lang.Iterator<$T>)child$33945).hasNext$O();
                        
                        //#line 59 "/home/dsl/workspace/plhamK/plham/util/GraphUtils.x10"
                        if (!(t$33946)) {
                            
                            //#line 59 "/home/dsl/workspace/plhamK/plham/util/GraphUtils.x10"
                            break;
                        }
                        
                        //#line 59 "/home/dsl/workspace/plhamK/plham/util/GraphUtils.x10"
                        final $T child$33938 = ((((x10.lang.Iterator<$T>)child$33945).next$G()));
                        
                        //#line 60 "/home/dsl/workspace/plhamK/plham/util/GraphUtils.x10"
                        assert x10.core.Boolean.$unbox(((x10.util.Container<$T>)((x10.util.Set<$T>)
                                                                                  graph.$apply(((child$33938)), $T))).contains$Z(((key$33947)), $T)): "Undirected graph only supported";
                        
                        //#line 61 "/home/dsl/workspace/plhamK/plham/util/GraphUtils.x10"
                        ((x10.util.Stack<$T>)stack$33962).push__0x10$util$Stack$$T$O(((child$33938)));
                        
                        //#line 62 "/home/dsl/workspace/plhamK/plham/util/GraphUtils.x10"
                        final x10.io.Printer t$33939 = ((x10.io.Console.get$OUT()));
                        
                        //#line 62 "/home/dsl/workspace/plhamK/plham/util/GraphUtils.x10"
                        final java.lang.String t$33940 = (("#GRAPH ") + (key$33947));
                        
                        //#line 62 "/home/dsl/workspace/plhamK/plham/util/GraphUtils.x10"
                        final java.lang.String t$33941 = ((t$33940) + (" --> "));
                        
                        //#line 62 "/home/dsl/workspace/plhamK/plham/util/GraphUtils.x10"
                        final java.lang.String t$33942 = ((t$33941) + (child$33938));
                        
                        //#line 62 "/home/dsl/workspace/plhamK/plham/util/GraphUtils.x10"
                        final java.lang.String t$33943 = ((t$33942) + (" connected"));
                        
                        //#line 62 "/home/dsl/workspace/plhamK/plham/util/GraphUtils.x10"
                        t$33939.println(((t$33943)));
                    }
                }
                //#line 65 "/home/dsl/workspace/plhamK/plham/util/GraphUtils.x10"
                ((x10.util.ArrayList<x10.util.Set<$T>>)out).add__0x10$util$ArrayList$$T$O(((visited$33961)));
                //#line 66 "/home/dsl/workspace/plhamK/plham/util/GraphUtils.x10"
                ((x10.util.AbstractCollection<$T>)checked).addAll__0$1x10$util$AbstractCollection$$T$2$O(((visited$33961)));
            }
        }
        
        //#line 68 "/home/dsl/workspace/plhamK/plham/util/GraphUtils.x10"
        final x10.io.Printer t$33871 = ((x10.io.Console.get$OUT()));
        
        //#line 68 "/home/dsl/workspace/plhamK/plham/util/GraphUtils.x10"
        t$33871.println((("#GRAPH finished")));
        
        //#line 69 "/home/dsl/workspace/plhamK/plham/util/GraphUtils.x10"
        return out;
    }
    
    
    //#line 72 "/home/dsl/workspace/plhamK/plham/util/GraphUtils.x10"
    public static <$T>void dump__0$1plham$util$GraphUtils$$T$3x10$util$Set$1plham$util$GraphUtils$$T$2$2(final x10.rtt.Type $T, final x10.util.Map<$T, x10.util.Set<$T>> graph) {
        
        //#line 73 "/home/dsl/workspace/plhamK/plham/util/GraphUtils.x10"
        final x10.util.Set t$33873 = (graph.keySet());
        
        //#line 73 "/home/dsl/workspace/plhamK/plham/util/GraphUtils.x10"
        final x10.lang.Iterator i$33782 = (((x10.lang.Iterable<$T>)t$33873).iterator());
        
        //#line 73 "/home/dsl/workspace/plhamK/plham/util/GraphUtils.x10"
        for (;
             true;
             ) {
            
            //#line 73 "/home/dsl/workspace/plhamK/plham/util/GraphUtils.x10"
            final boolean t$33883 = ((x10.lang.Iterator<$T>)i$33782).hasNext$O();
            
            //#line 73 "/home/dsl/workspace/plhamK/plham/util/GraphUtils.x10"
            if (!(t$33883)) {
                
                //#line 73 "/home/dsl/workspace/plhamK/plham/util/GraphUtils.x10"
                break;
            }
            
            //#line 73 "/home/dsl/workspace/plhamK/plham/util/GraphUtils.x10"
            final $T i$33971 = ((((x10.lang.Iterator<$T>)i$33782).next$G()));
            
            //#line 74 "/home/dsl/workspace/plhamK/plham/util/GraphUtils.x10"
            final x10.io.Printer t$33972 = ((x10.io.Console.get$OUT()));
            
            //#line 74 "/home/dsl/workspace/plhamK/plham/util/GraphUtils.x10"
            t$33972.print((("# ")));
            
            //#line 75 "/home/dsl/workspace/plhamK/plham/util/GraphUtils.x10"
            final x10.io.Printer t$33973 = ((x10.io.Console.get$OUT()));
            
            //#line 75 "/home/dsl/workspace/plhamK/plham/util/GraphUtils.x10"
            final java.lang.String t$33974 = ((i$33971) + (": "));
            
            //#line 75 "/home/dsl/workspace/plhamK/plham/util/GraphUtils.x10"
            t$33973.print(((t$33974)));
            
            //#line 76 "/home/dsl/workspace/plhamK/plham/util/GraphUtils.x10"
            final x10.util.Set t$33968 = ((x10.util.Set<$T>)
                                           graph.$apply(((i$33971)), $T));
            
            //#line 76 "/home/dsl/workspace/plhamK/plham/util/GraphUtils.x10"
            final x10.lang.Iterator j$33969 = (((x10.lang.Iterable<$T>)t$33968).iterator());
            
            //#line 76 "/home/dsl/workspace/plhamK/plham/util/GraphUtils.x10"
            for (;
                 true;
                 ) {
                
                //#line 76 "/home/dsl/workspace/plhamK/plham/util/GraphUtils.x10"
                final boolean t$33970 = ((x10.lang.Iterator<$T>)j$33969).hasNext$O();
                
                //#line 76 "/home/dsl/workspace/plhamK/plham/util/GraphUtils.x10"
                if (!(t$33970)) {
                    
                    //#line 76 "/home/dsl/workspace/plhamK/plham/util/GraphUtils.x10"
                    break;
                }
                
                //#line 76 "/home/dsl/workspace/plhamK/plham/util/GraphUtils.x10"
                final $T j$33965 = ((((x10.lang.Iterator<$T>)j$33969).next$G()));
                
                //#line 77 "/home/dsl/workspace/plhamK/plham/util/GraphUtils.x10"
                final x10.io.Printer t$33966 = ((x10.io.Console.get$OUT()));
                
                //#line 77 "/home/dsl/workspace/plhamK/plham/util/GraphUtils.x10"
                final java.lang.String t$33967 = ((j$33965) + (" "));
                
                //#line 77 "/home/dsl/workspace/plhamK/plham/util/GraphUtils.x10"
                t$33966.print(((t$33967)));
            }
            
            //#line 79 "/home/dsl/workspace/plhamK/plham/util/GraphUtils.x10"
            final x10.io.Printer t$33975 = ((x10.io.Console.get$OUT()));
            
            //#line 79 "/home/dsl/workspace/plhamK/plham/util/GraphUtils.x10"
            t$33975.println();
        }
    }
    
    
    //#line 83 "/home/dsl/workspace/plhamK/plham/util/GraphUtils.x10"
	public static <$T> void dump(final x10.rtt.Type $T, final x10.util.List<x10.util.Set<$T>> list) {
        
        //#line 84 "/home/dsl/workspace/plhamK/plham/util/GraphUtils.x10"
        final x10.util.ListIterator cc$33786 = (list.iterator());
        
        //#line 84 "/home/dsl/workspace/plhamK/plham/util/GraphUtils.x10"
        for (;
             true;
             ) {
            
            //#line 84 "/home/dsl/workspace/plhamK/plham/util/GraphUtils.x10"
            final boolean t$33891 = ((x10.util.ListIterator<x10.util.Set<$T>>)cc$33786).hasNext$O();
            
            //#line 84 "/home/dsl/workspace/plhamK/plham/util/GraphUtils.x10"
            if (!(t$33891)) {
                
                //#line 84 "/home/dsl/workspace/plhamK/plham/util/GraphUtils.x10"
                break;
            }
            
            //#line 84 "/home/dsl/workspace/plhamK/plham/util/GraphUtils.x10"
            final x10.util.Set cc$33981 = ((((x10.util.ListIterator<x10.util.Set<$T>>)cc$33786).next$G()));
            
            //#line 85 "/home/dsl/workspace/plhamK/plham/util/GraphUtils.x10"
            final x10.io.Printer t$33982 = ((x10.io.Console.get$OUT()));
            
            //#line 85 "/home/dsl/workspace/plhamK/plham/util/GraphUtils.x10"
            t$33982.print((("# ")));
            
            //#line 86 "/home/dsl/workspace/plhamK/plham/util/GraphUtils.x10"
            final x10.lang.Iterator j$33979 = (((x10.lang.Iterable<$T>)cc$33981).iterator());
            
            //#line 86 "/home/dsl/workspace/plhamK/plham/util/GraphUtils.x10"
            for (;
                 true;
                 ) {
                
                //#line 86 "/home/dsl/workspace/plhamK/plham/util/GraphUtils.x10"
                final boolean t$33980 = ((x10.lang.Iterator<$T>)j$33979).hasNext$O();
                
                //#line 86 "/home/dsl/workspace/plhamK/plham/util/GraphUtils.x10"
                if (!(t$33980)) {
                    
                    //#line 86 "/home/dsl/workspace/plhamK/plham/util/GraphUtils.x10"
                    break;
                }
                
                //#line 86 "/home/dsl/workspace/plhamK/plham/util/GraphUtils.x10"
                final $T j$33976 = ((((x10.lang.Iterator<$T>)j$33979).next$G()));
                
                //#line 87 "/home/dsl/workspace/plhamK/plham/util/GraphUtils.x10"
                final x10.io.Printer t$33977 = ((x10.io.Console.get$OUT()));
                
                //#line 87 "/home/dsl/workspace/plhamK/plham/util/GraphUtils.x10"
                final java.lang.String t$33978 = ((j$33976) + (" "));
                
                //#line 87 "/home/dsl/workspace/plhamK/plham/util/GraphUtils.x10"
                t$33977.print(((t$33978)));
            }
            
            //#line 89 "/home/dsl/workspace/plhamK/plham/util/GraphUtils.x10"
            final x10.io.Printer t$33983 = ((x10.io.Console.get$OUT()));
            
            //#line 89 "/home/dsl/workspace/plhamK/plham/util/GraphUtils.x10"
            t$33983.println();
        }
    }
    
    
    //#line 93 "/home/dsl/workspace/plhamK/plham/util/GraphUtils.x10"
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
            GraphUtils.main(args);
        }
    }
    
    // the original app-main method
    public static void main(final x10.core.Rail<java.lang.String> args) {
        
        //#line 94 "/home/dsl/workspace/plhamK/plham/util/GraphUtils.x10"
        long T = 100L;
        
        //#line 95 "/home/dsl/workspace/plhamK/plham/util/GraphUtils.x10"
        long N = 10L;
        
        //#line 96 "/home/dsl/workspace/plhamK/plham/util/GraphUtils.x10"
        final long t$33892 = args.size;
        
        //#line 96 "/home/dsl/workspace/plhamK/plham/util/GraphUtils.x10"
        final boolean t$33895 = ((t$33892) > (((0L))));
        
        //#line 96 "/home/dsl/workspace/plhamK/plham/util/GraphUtils.x10"
        if (t$33895) {
            
            //#line 97 "/home/dsl/workspace/plhamK/plham/util/GraphUtils.x10"
            final java.lang.String t$33893 = ((java.lang.String[])args.value)[(int)0L];
            
            //#line 97 "/home/dsl/workspace/plhamK/plham/util/GraphUtils.x10"
            final long t$33894 = java.lang.Long.parseLong(t$33893);
            
            //#line 97 "/home/dsl/workspace/plhamK/plham/util/GraphUtils.x10"
            T = t$33894;
        }
        
        //#line 99 "/home/dsl/workspace/plhamK/plham/util/GraphUtils.x10"
        final long t$33896 = args.size;
        
        //#line 99 "/home/dsl/workspace/plhamK/plham/util/GraphUtils.x10"
        final boolean t$33899 = ((t$33896) > (((1L))));
        
        //#line 99 "/home/dsl/workspace/plhamK/plham/util/GraphUtils.x10"
        if (t$33899) {
            
            //#line 100 "/home/dsl/workspace/plhamK/plham/util/GraphUtils.x10"
            final java.lang.String t$33897 = ((java.lang.String[])args.value)[(int)1L];
            
            //#line 100 "/home/dsl/workspace/plhamK/plham/util/GraphUtils.x10"
            final long t$33898 = java.lang.Long.parseLong(t$33897);
            
            //#line 100 "/home/dsl/workspace/plhamK/plham/util/GraphUtils.x10"
            N = t$33898;
        }
        
        //#line 102 "/home/dsl/workspace/plhamK/plham/util/GraphUtils.x10"
        final x10.util.Random random = ((new x10.util.Random((java.lang.System[]) null).x10$util$Random$$init$S()));
        
        //#line 104 "/home/dsl/workspace/plhamK/plham/util/GraphUtils.x10"
        final x10.util.HashMap graph = ((new x10.util.HashMap<x10.core.Long, x10.util.Set<x10.core.Long>>((java.lang.System[]) null, x10.rtt.Types.LONG, x10.rtt.ParameterizedType.make(x10.util.Set.$RTT, x10.rtt.Types.LONG)).x10$util$HashMap$$init$S()));
        
        //#line 105 "/home/dsl/workspace/plhamK/plham/util/GraphUtils.x10"
        final long i$33788min$34014 = 0L;
        
        //#line 105 "/home/dsl/workspace/plhamK/plham/util/GraphUtils.x10"
        final long t$34015 = N;
        
        //#line 105 "/home/dsl/workspace/plhamK/plham/util/GraphUtils.x10"
        final long i$33788max$34016 = ((t$34015) - (((1L))));
        
        //#line 105 "/home/dsl/workspace/plhamK/plham/util/GraphUtils.x10"
        long i$33988 = i$33788min$34014;
        
        //#line 105 "/home/dsl/workspace/plhamK/plham/util/GraphUtils.x10"
        for (;
             true;
             ) {
            
            //#line 105 "/home/dsl/workspace/plhamK/plham/util/GraphUtils.x10"
            final long t$33989 = i$33988;
            
            //#line 105 "/home/dsl/workspace/plhamK/plham/util/GraphUtils.x10"
            final boolean t$33990 = ((t$33989) <= (((i$33788max$34016))));
            
            //#line 105 "/home/dsl/workspace/plhamK/plham/util/GraphUtils.x10"
            if (!(t$33990)) {
                
                //#line 105 "/home/dsl/workspace/plhamK/plham/util/GraphUtils.x10"
                break;
            }
            
            //#line 105 "/home/dsl/workspace/plhamK/plham/util/GraphUtils.x10"
            final long i$33985 = i$33988;
            
            //#line 106 "/home/dsl/workspace/plhamK/plham/util/GraphUtils.x10"
            final x10.util.HashSet t$33984 = ((new x10.util.HashSet<x10.core.Long>((java.lang.System[]) null, x10.rtt.Types.LONG).x10$util$HashSet$$init$S()));
            
            //#line 106 "/home/dsl/workspace/plhamK/plham/util/GraphUtils.x10"
            ((x10.util.HashMap<x10.core.Long, x10.util.Set<x10.core.Long>>)graph).$set__0x10$util$HashMap$$K__1x10$util$HashMap$$V$G(x10.core.Long.$box(i$33985), ((x10.util.Set)(t$33984)));
            
            //#line 105 "/home/dsl/workspace/plhamK/plham/util/GraphUtils.x10"
            final long t$33986 = i$33988;
            
            //#line 105 "/home/dsl/workspace/plhamK/plham/util/GraphUtils.x10"
            final long t$33987 = ((t$33986) + (((long)(1L))));
            
            //#line 105 "/home/dsl/workspace/plhamK/plham/util/GraphUtils.x10"
            i$33988 = t$33987;
        }
        
        //#line 108 "/home/dsl/workspace/plhamK/plham/util/GraphUtils.x10"
        final long i$33806min$34017 = 1L;
        
        //#line 108 "/home/dsl/workspace/plhamK/plham/util/GraphUtils.x10"
        final long i$33806max$34018 = T;
        
        //#line 108 "/home/dsl/workspace/plhamK/plham/util/GraphUtils.x10"
        long i$34000 = i$33806min$34017;
        
        //#line 108 "/home/dsl/workspace/plhamK/plham/util/GraphUtils.x10"
        for (;
             true;
             ) {
            
            //#line 108 "/home/dsl/workspace/plhamK/plham/util/GraphUtils.x10"
            final long t$34001 = i$34000;
            
            //#line 108 "/home/dsl/workspace/plhamK/plham/util/GraphUtils.x10"
            final boolean t$34002 = ((t$34001) <= (((long)(i$33806max$34018))));
            
            //#line 108 "/home/dsl/workspace/plhamK/plham/util/GraphUtils.x10"
            if (!(t$34002)) {
                
                //#line 108 "/home/dsl/workspace/plhamK/plham/util/GraphUtils.x10"
                break;
            }
            
            //#line 108 "/home/dsl/workspace/plhamK/plham/util/GraphUtils.x10"
            final long t$33997 = i$34000;
            
            //#line 109 "/home/dsl/workspace/plhamK/plham/util/GraphUtils.x10"
            final long t$33991 = N;
            
            //#line 109 "/home/dsl/workspace/plhamK/plham/util/GraphUtils.x10"
            final long i$33992 = random.nextLong$O((long)(t$33991));
            
            //#line 110 "/home/dsl/workspace/plhamK/plham/util/GraphUtils.x10"
            final long t$33993 = N;
            
            //#line 110 "/home/dsl/workspace/plhamK/plham/util/GraphUtils.x10"
            final long j$33994 = random.nextLong$O((long)(t$33993));
            
            //#line 111 "/home/dsl/workspace/plhamK/plham/util/GraphUtils.x10"
            final x10.util.Set t$33995 = ((x10.util.HashMap<x10.core.Long, x10.util.Set<x10.core.Long>>)graph).$apply__0x10$util$HashMap$$K$G(x10.core.Long.$box(i$33992));
            
            //#line 111 "/home/dsl/workspace/plhamK/plham/util/GraphUtils.x10"
            ((x10.util.Collection<x10.core.Long>)t$33995).add$Z(x10.core.Long.$box(j$33994), x10.rtt.Types.LONG);
            
            //#line 112 "/home/dsl/workspace/plhamK/plham/util/GraphUtils.x10"
            final x10.util.Set t$33996 = ((x10.util.HashMap<x10.core.Long, x10.util.Set<x10.core.Long>>)graph).$apply__0x10$util$HashMap$$K$G(x10.core.Long.$box(j$33994));
            
            //#line 112 "/home/dsl/workspace/plhamK/plham/util/GraphUtils.x10"
            ((x10.util.Collection<x10.core.Long>)t$33996).add$Z(x10.core.Long.$box(i$33992), x10.rtt.Types.LONG);
            
            //#line 108 "/home/dsl/workspace/plhamK/plham/util/GraphUtils.x10"
            final long t$33998 = i$34000;
            
            //#line 108 "/home/dsl/workspace/plhamK/plham/util/GraphUtils.x10"
            final long t$33999 = ((t$33998) + (((long)(1L))));
            
            //#line 108 "/home/dsl/workspace/plhamK/plham/util/GraphUtils.x10"
            i$34000 = t$33999;
        }
        
        //#line 114 "/home/dsl/workspace/plhamK/plham/util/GraphUtils.x10"
        plham.util.GraphUtils.<x10.core.Long> dump__0$1plham$util$GraphUtils$$T$3x10$util$Set$1plham$util$GraphUtils$$T$2$2(x10.rtt.Types.LONG, ((x10.util.Map)(graph)));
        
        //#line 116 "/home/dsl/workspace/plhamK/plham/util/GraphUtils.x10"
        final x10.util.List C = plham.util.GraphUtils.<x10.core.Long> getConnectedComponents__0$1plham$util$GraphUtils$$T$3x10$util$Set$1plham$util$GraphUtils$$T$2$2(x10.rtt.Types.LONG, ((x10.util.Map)(graph)));
        
        //#line 117 "/home/dsl/workspace/plhamK/plham/util/GraphUtils.x10"
        plham.util.GraphUtils.<x10.core.Long> dump(x10.rtt.Types.LONG, ((x10.util.List)(C)));
        
        //#line 119 "/home/dsl/workspace/plhamK/plham/util/GraphUtils.x10"
        final x10.io.Printer t$33916 = ((x10.io.Printer)(x10.io.Console.get$OUT()));
        
        //#line 119 "/home/dsl/workspace/plhamK/plham/util/GraphUtils.x10"
        t$33916.println(((java.lang.Object)("#### #### #### ####")));
        
        //#line 121 "/home/dsl/workspace/plhamK/plham/util/GraphUtils.x10"
        final x10.util.HashSet pairs = ((x10.util.HashSet)(new x10.util.HashSet<x10.util.Pair<x10.core.Long, x10.core.Long>>((java.lang.System[]) null, x10.rtt.ParameterizedType.make(x10.util.Pair.$RTT, x10.rtt.Types.LONG, x10.rtt.Types.LONG)).x10$util$HashSet$$init$S()));
        
        //#line 122 "/home/dsl/workspace/plhamK/plham/util/GraphUtils.x10"
        final long i$33826min$34019 = 0L;
        
        //#line 122 "/home/dsl/workspace/plhamK/plham/util/GraphUtils.x10"
        final long t$34020 = N;
        
        //#line 122 "/home/dsl/workspace/plhamK/plham/util/GraphUtils.x10"
        final long i$33826max$34021 = ((t$34020) - (((long)(1L))));
        
        //#line 122 "/home/dsl/workspace/plhamK/plham/util/GraphUtils.x10"
        long i$34011 = i$33826min$34019;
        
        //#line 122 "/home/dsl/workspace/plhamK/plham/util/GraphUtils.x10"
        for (;
             true;
             ) {
            
            //#line 122 "/home/dsl/workspace/plhamK/plham/util/GraphUtils.x10"
            final long t$34012 = i$34011;
            
            //#line 122 "/home/dsl/workspace/plhamK/plham/util/GraphUtils.x10"
            final boolean t$34013 = ((t$34012) <= (((long)(i$33826max$34021))));
            
            //#line 122 "/home/dsl/workspace/plhamK/plham/util/GraphUtils.x10"
            if (!(t$34013)) {
                
                //#line 122 "/home/dsl/workspace/plhamK/plham/util/GraphUtils.x10"
                break;
            }
            
            //#line 122 "/home/dsl/workspace/plhamK/plham/util/GraphUtils.x10"
            final long i$34008 = i$34011;
            
            //#line 123 "/home/dsl/workspace/plhamK/plham/util/GraphUtils.x10"
            final x10.util.Set t$34005 = ((x10.util.HashMap<x10.core.Long, x10.util.Set<x10.core.Long>>)graph).$apply__0x10$util$HashMap$$K$G(x10.core.Long.$box(i$34008));
            
            //#line 123 "/home/dsl/workspace/plhamK/plham/util/GraphUtils.x10"
            final x10.lang.Iterator j$34006 = ((x10.lang.Iterator<x10.core.Long>)
                                                ((x10.lang.Iterable<x10.core.Long>)t$34005).iterator());
            
            //#line 123 "/home/dsl/workspace/plhamK/plham/util/GraphUtils.x10"
            for (;
                 true;
                 ) {
                
                //#line 123 "/home/dsl/workspace/plhamK/plham/util/GraphUtils.x10"
                final boolean t$34007 = ((x10.lang.Iterator<x10.core.Long>)j$34006).hasNext$O();
                
                //#line 123 "/home/dsl/workspace/plhamK/plham/util/GraphUtils.x10"
                if (!(t$34007)) {
                    
                    //#line 123 "/home/dsl/workspace/plhamK/plham/util/GraphUtils.x10"
                    break;
                }
                
                //#line 123 "/home/dsl/workspace/plhamK/plham/util/GraphUtils.x10"
                final long j$34003 = x10.core.Long.$unbox(((x10.lang.Iterator<x10.core.Long>)j$34006).next$G());
                
                //#line 124 "/home/dsl/workspace/plhamK/plham/util/GraphUtils.x10"
                final x10.util.Pair t$34004 = new x10.util.Pair<x10.core.Long, x10.core.Long>((java.lang.System[]) null, x10.rtt.Types.LONG, x10.rtt.Types.LONG).x10$util$Pair$$init$S((x10.core.Long.$box(i$34008)), (x10.core.Long.$box(j$34003)), (x10.util.Pair.__0x10$util$Pair$$T__1x10$util$Pair$$U) null);
                
                //#line 124 "/home/dsl/workspace/plhamK/plham/util/GraphUtils.x10"
                ((x10.util.MapSet<x10.util.Pair<x10.core.Long, x10.core.Long>>)pairs).add__0x10$util$MapSet$$T$O(((x10.util.Pair)(t$34004)));
            }
            
            //#line 122 "/home/dsl/workspace/plhamK/plham/util/GraphUtils.x10"
            final long t$34009 = i$34011;
            
            //#line 122 "/home/dsl/workspace/plhamK/plham/util/GraphUtils.x10"
            final long t$34010 = ((t$34009) + (((long)(1L))));
            
            //#line 122 "/home/dsl/workspace/plhamK/plham/util/GraphUtils.x10"
            i$34011 = t$34010;
        }
        
        //#line 128 "/home/dsl/workspace/plhamK/plham/util/GraphUtils.x10"
        final x10.util.Set t$33927 = ((x10.util.Set<x10.core.Long>)
                                       ((x10.util.HashMap<x10.core.Long, x10.util.Set<x10.core.Long>>)graph).keySet());
        
        //#line 128 "/home/dsl/workspace/plhamK/plham/util/GraphUtils.x10"
        final x10.util.Map pG = plham.util.GraphUtils.<x10.core.Long> toAdjacencySet__0$1plham$util$GraphUtils$$T$2__1$1x10$util$Pair$1plham$util$GraphUtils$$T$3plham$util$GraphUtils$$T$2$2(x10.rtt.Types.LONG, ((x10.util.Set)(t$33927)), ((x10.util.Set)(pairs)));
        
        //#line 129 "/home/dsl/workspace/plhamK/plham/util/GraphUtils.x10"
        plham.util.GraphUtils.<x10.core.Long> dump__0$1plham$util$GraphUtils$$T$3x10$util$Set$1plham$util$GraphUtils$$T$2$2(x10.rtt.Types.LONG, ((x10.util.Map)(pG)));
        
        //#line 131 "/home/dsl/workspace/plhamK/plham/util/GraphUtils.x10"
        final x10.util.List pC = plham.util.GraphUtils.<x10.core.Long> getConnectedComponents__0$1plham$util$GraphUtils$$T$3x10$util$Set$1plham$util$GraphUtils$$T$2$2(x10.rtt.Types.LONG, ((x10.util.Map)(pG)));
        
        //#line 132 "/home/dsl/workspace/plhamK/plham/util/GraphUtils.x10"
        plham.util.GraphUtils.<x10.core.Long> dump(x10.rtt.Types.LONG, ((x10.util.List)(pC)));
    }
    
    
    //#line 12 "/home/dsl/workspace/plhamK/plham/util/GraphUtils.x10"
    final public plham.util.GraphUtils plham$util$GraphUtils$$this$plham$util$GraphUtils() {
        
        //#line 12 "/home/dsl/workspace/plhamK/plham/util/GraphUtils.x10"
        return plham.util.GraphUtils.this;
    }
    
    
    //#line 12 "/home/dsl/workspace/plhamK/plham/util/GraphUtils.x10"
    // creation method for java code (1-phase java constructor)
    public GraphUtils() {
        this((java.lang.System[]) null);
        plham$util$GraphUtils$$init$S();
    }
    
    // constructor for non-virtual call
    final public plham.util.GraphUtils plham$util$GraphUtils$$init$S() {
         {
            
            //#line 12 "/home/dsl/workspace/plhamK/plham/util/GraphUtils.x10"
            
            
            //#line 12 "/home/dsl/workspace/plhamK/plham/util/GraphUtils.x10"
            this.__fieldInitializers_plham_util_GraphUtils();
        }
        return this;
    }
    
    
    
    //#line 12 "/home/dsl/workspace/plhamK/plham/util/GraphUtils.x10"
    final public void __fieldInitializers_plham_util_GraphUtils() {
        
    }
}

