package cassia.util;


@x10.runtime.impl.java.X10Generated
public interface SortedQueue<$T> extends x10.lang.Iterable, x10.serialization.X10JavaSerializable
{
    public static final x10.rtt.RuntimeType<SortedQueue> $RTT = 
        x10.rtt.NamedType.<SortedQueue> make("cassia.util.SortedQueue",
                                             SortedQueue.class,
                                             1,
                                             new x10.rtt.Type[] {
                                                 x10.rtt.ParameterizedType.make(x10.lang.Iterable.$RTT, x10.rtt.UnresolvedType.PARAM(0))
                                             });
    
    

    
    
    //#line 6 "/home/dsl/workspace/plhamK/cassia/util/SortedQueue.x10"
    boolean push$Z(final java.lang.Object x, x10.rtt.Type t1);
    
    
    //#line 8 "/home/dsl/workspace/plhamK/cassia/util/SortedQueue.x10"
    $T pop$G();
    
    
    //#line 10 "/home/dsl/workspace/plhamK/cassia/util/SortedQueue.x10"
    $T peek$G();
    
    
    //#line 12 "/home/dsl/workspace/plhamK/cassia/util/SortedQueue.x10"
    boolean add$Z(final java.lang.Object x, x10.rtt.Type t1);
    
    
    //#line 14 "/home/dsl/workspace/plhamK/cassia/util/SortedQueue.x10"
    boolean remove$Z(final java.lang.Object x, x10.rtt.Type t1);
    
    
    //#line 16 "/home/dsl/workspace/plhamK/cassia/util/SortedQueue.x10"
    boolean removeAllWhere$Z(final x10.core.fun.Fun_0_1 p, x10.rtt.Type t1);
    
    
    //#line 18 "/home/dsl/workspace/plhamK/cassia/util/SortedQueue.x10"
    long size$O();
    
    
    //#line 20 "/home/dsl/workspace/plhamK/cassia/util/SortedQueue.x10"
    boolean contains$Z(final java.lang.Object x, x10.rtt.Type t1);
    
    
    //#line 23 "/home/dsl/workspace/plhamK/cassia/util/SortedQueue.x10"
    /** An iterator that returns elements in an undefined order. */
    x10.lang.Iterator iterator();
    
    
    //#line 25 "/home/dsl/workspace/plhamK/cassia/util/SortedQueue.x10"
    x10.util.List toList();
}

