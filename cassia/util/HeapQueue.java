package cassia.util;


/**
 * A heap imported from java.util.PriorityQueue.
 * Use a comparator() to decide the priority of objects, and use the method
 * equals() to decide the identity of two objects.
 */
@x10.runtime.impl.java.X10Generated
public class HeapQueue<$T> extends x10.core.Ref implements cassia.util.SortedQueue, x10.serialization.X10JavaSerializable
{
    public static final x10.rtt.RuntimeType<HeapQueue> $RTT = 
        x10.rtt.NamedType.<HeapQueue> make("cassia.util.HeapQueue",
                                           HeapQueue.class,
                                           1,
                                           new x10.rtt.Type[] {
                                               x10.rtt.ParameterizedType.make(cassia.util.SortedQueue.$RTT, x10.rtt.UnresolvedType.PARAM(0))
                                           });
    
    public x10.rtt.RuntimeType<?> $getRTT() { return $RTT; }
    
    public x10.rtt.Type<?> $getParam(int i) { if (i == 0) return $T; return null; }
    
    private Object writeReplace() throws java.io.ObjectStreamException {
        return new x10.serialization.SerializationProxy(this);
    }
    
    public static <$T> x10.serialization.X10JavaSerializable $_deserialize_body(cassia.util.HeapQueue<$T> $_obj, x10.serialization.X10JavaDeserializer $deserializer) throws java.io.IOException {
        if (x10.runtime.impl.java.Runtime.TRACE_SER) { x10.runtime.impl.java.Runtime.printTraceMessage("X10JavaSerializable: $_deserialize_body() of " + HeapQueue.class + " calling"); } 
        $_obj.$T = (x10.rtt.Type) $deserializer.readObject();
        $_obj.comparator = $deserializer.readObject();
        $_obj.heap = $deserializer.readObject();
        return $_obj;
    }
    
    public static x10.serialization.X10JavaSerializable $_deserializer(x10.serialization.X10JavaDeserializer $deserializer) throws java.io.IOException {
        cassia.util.HeapQueue $_obj = new cassia.util.HeapQueue((java.lang.System[]) null, (x10.rtt.Type) null);
        $deserializer.record_reference($_obj);
        return $_deserialize_body($_obj, $deserializer);
    }
    
    public void $_serialize(x10.serialization.X10JavaSerializer $serializer) throws java.io.IOException {
        $serializer.write(this.$T);
        $serializer.write(this.comparator);
        $serializer.write(this.heap);
        
    }
    
    // constructor just for allocation
    public HeapQueue(final java.lang.System[] $dummy, final x10.rtt.Type $T) {
        cassia.util.HeapQueue.$initParams(this, $T);
        
    }
    
    // dispatcher for method abstract public cassia.util.SortedQueue[T].push(x:T){}:x10.lang.Boolean
    public java.lang.Object push(final java.lang.Object a1, final x10.rtt.Type t1) {
        return x10.core.Boolean.$box(push__0cassia$util$HeapQueue$$T$O(($T)a1));
        
    }
    
    // dispatcher for method abstract public cassia.util.SortedQueue[T].push(x:T){}:x10.lang.Boolean
    public boolean push$Z(final java.lang.Object a1, final x10.rtt.Type t1) {
        return push__0cassia$util$HeapQueue$$T$O(($T)a1);
        
    }
    
    // dispatcher for method abstract public cassia.util.SortedQueue[T].add(x:T){}:x10.lang.Boolean
    public java.lang.Object add(final java.lang.Object a1, final x10.rtt.Type t1) {
        return x10.core.Boolean.$box(add__0cassia$util$HeapQueue$$T$O(($T)a1));
        
    }
    
    // dispatcher for method abstract public cassia.util.SortedQueue[T].add(x:T){}:x10.lang.Boolean
    public boolean add$Z(final java.lang.Object a1, final x10.rtt.Type t1) {
        return add__0cassia$util$HeapQueue$$T$O(($T)a1);
        
    }
    
    // dispatcher for method abstract public cassia.util.SortedQueue[T].remove(x:T){}:x10.lang.Boolean
    public java.lang.Object remove(final java.lang.Object a1, final x10.rtt.Type t1) {
        return x10.core.Boolean.$box(remove__0cassia$util$HeapQueue$$T$O(($T)a1));
        
    }
    
    // dispatcher for method abstract public cassia.util.SortedQueue[T].remove(x:T){}:x10.lang.Boolean
    public boolean remove$Z(final java.lang.Object a1, final x10.rtt.Type t1) {
        return remove__0cassia$util$HeapQueue$$T$O(($T)a1);
        
    }
    
    // dispatcher for method abstract public cassia.util.SortedQueue[T].removeAllWhere(p:(T)=>x10.lang.Boolean){}:x10.lang.Boolean
    public java.lang.Object removeAllWhere(final x10.core.fun.Fun_0_1 a1, final x10.rtt.Type t1) {
        return x10.core.Boolean.$box(removeAllWhere__0$1cassia$util$HeapQueue$$T$3x10$lang$Boolean$2$O(a1));
        
    }
    
    // dispatcher for method abstract public cassia.util.SortedQueue[T].removeAllWhere(p:(T)=>x10.lang.Boolean){}:x10.lang.Boolean
    public boolean removeAllWhere$Z(final x10.core.fun.Fun_0_1 a1, final x10.rtt.Type t1) {
        return removeAllWhere__0$1cassia$util$HeapQueue$$T$3x10$lang$Boolean$2$O(a1);
        
    }
    
    // dispatcher for method abstract public cassia.util.SortedQueue[T].contains(x:T){}:x10.lang.Boolean
    public java.lang.Object contains(final java.lang.Object a1, final x10.rtt.Type t1) {
        return x10.core.Boolean.$box(contains__0cassia$util$HeapQueue$$T$O(($T)a1));
        
    }
    
    // dispatcher for method abstract public cassia.util.SortedQueue[T].contains(x:T){}:x10.lang.Boolean
    public boolean contains$Z(final java.lang.Object a1, final x10.rtt.Type t1) {
        return contains__0cassia$util$HeapQueue$$T$O(($T)a1);
        
    }
    
    private x10.rtt.Type $T;
    
    // initializer of type parameters
    public static void $initParams(final HeapQueue $this, final x10.rtt.Type $T) {
        $this.$T = $T;
        
    }
    // synthetic type for parameter mangling
    public static final class __0$1cassia$util$HeapQueue$$T$3cassia$util$HeapQueue$$T$3x10$lang$Int$2 {}
    

    
    
    //#line 13 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
    public static long PARENT$O(final long i) {
        
        //#line 13 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
        final long t$36283 = ((i) - (((1L))));
        
        //#line 13 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
        final long t$36284 = ((t$36283) >>> (int)(((1L))));
        
        //#line 13 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
        return t$36284;
    }
    
    
    //#line 14 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
    public static long LEFT$O(final long i) {
        
        //#line 14 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
        final long t$36285 = ((i) << (int)(((1L))));
        
        //#line 14 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
        final long t$36286 = ((t$36285) + (((1L))));
        
        //#line 14 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
        return t$36286;
    }
    
    
    //#line 15 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
    public static long RIGHT$O(final long i) {
        
        //#line 15 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
        final long t$36287 = ((i) << (int)(((1L))));
        
        //#line 15 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
        final long t$36288 = ((t$36287) + (((2L))));
        
        //#line 15 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
        return t$36288;
    }
    
    
    //#line 17 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
    public x10.util.List<$T> heap;
    
    //#line 18 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
    public x10.core.fun.Fun_0_2<$T,$T,x10.core.Int> comparator;
    
    
    //#line 20 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
    // creation method for java code (1-phase java constructor)
    public HeapQueue(final x10.rtt.Type $T, final x10.core.fun.Fun_0_2<$T,$T,x10.core.Int> comparator, __0$1cassia$util$HeapQueue$$T$3cassia$util$HeapQueue$$T$3x10$lang$Int$2 $dummy) {
        this((java.lang.System[]) null, $T);
        cassia$util$HeapQueue$$init$S(comparator, (cassia.util.HeapQueue.__0$1cassia$util$HeapQueue$$T$3cassia$util$HeapQueue$$T$3x10$lang$Int$2) null);
    }
    
    // constructor for non-virtual call
    final public cassia.util.HeapQueue<$T> cassia$util$HeapQueue$$init$S(final x10.core.fun.Fun_0_2<$T,$T,x10.core.Int> comparator, __0$1cassia$util$HeapQueue$$T$3cassia$util$HeapQueue$$T$3x10$lang$Int$2 $dummy) {
         {
            
            //#line 20 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
            
            
            //#line 11 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
            this.__fieldInitializers_cassia_util_HeapQueue();
            
            //#line 21 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
            final x10.util.ArrayList t$36289 = ((new x10.util.ArrayList<$T>((java.lang.System[]) null, $T).x10$util$ArrayList$$init$S()));
            
            //#line 21 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
            this.heap = ((t$36289));
            
            //#line 22 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
            this.comparator = ((comparator));
        }
        return this;
    }
    
    
    
    //#line 25 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
    public boolean push__0cassia$util$HeapQueue$$T$O(final $T x) {
        
        //#line 26 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
        final x10.util.List t$36290 = ((this.heap));
        
        //#line 26 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
        final long i = ((x10.util.Container<$T>)t$36290).size$O();
        
        //#line 27 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
        this.siftup__1cassia$util$HeapQueue$$T((i), ((x)));
        
        //#line 28 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
        return true;
    }
    
    
    //#line 31 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
    public $T pop$G() {
        
        //#line 32 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
        final x10.util.List t$36291 = ((this.heap));
        
        //#line 32 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
        final $T x = ((((x10.util.Indexed<$T>)t$36291).$apply$G((0L))));
        
        //#line 33 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
        final x10.util.List t$36292 = ((this.heap));
        
        //#line 33 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
        final $T e = ((((x10.util.List<$T>)t$36292).removeLast$G()));
        
        //#line 34 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
        final x10.util.List t$36293 = ((this.heap));
        
        //#line 34 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
        final long t$36294 = ((x10.util.Container<$T>)t$36293).size$O();
        
        //#line 34 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
        final boolean t$36295 = ((t$36294) > (((0L))));
        
        //#line 34 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
        if (t$36295) {
            
            //#line 35 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
            this.siftdown__1cassia$util$HeapQueue$$T((0L), ((e)));
        }
        
        //#line 37 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
        return x;
    }
    
    
    //#line 40 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
    public $T peek$G() {
        
        //#line 40 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
        final x10.util.List t$36296 = ((this.heap));
        
        //#line 40 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
        final $T t$36297 = ((((x10.util.Indexed<$T>)t$36296).$apply$G((0L))));
        
        //#line 40 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
        return t$36297;
    }
    
    
    //#line 42 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
    public boolean add__0cassia$util$HeapQueue$$T$O(final $T x) {
        
        //#line 43 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
        final boolean t$36298 = this.push__0cassia$util$HeapQueue$$T$O(((x)));
        
        //#line 43 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
        return t$36298;
    }
    
    
    //#line 46 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
    public boolean remove__0cassia$util$HeapQueue$$T$O(final $T x) {
        
        //#line 47 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
        final x10.util.List t$36299 = ((this.heap));
        
        //#line 47 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
        final long i = x10.core.Long.$unbox(((x10.util.List<$T>)t$36299).indexOf$J(((x)), $T));
        
        //#line 48 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
        final boolean t$36300 = ((i) < (((0L))));
        
        //#line 48 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
        if (t$36300) {
            
            //#line 49 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
            return false;
        }
        
        //#line 51 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
        final x10.util.List t$36301 = ((this.heap));
        
        //#line 51 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
        final $T e = ((((x10.util.List<$T>)t$36301).removeLast$G()));
        
        //#line 52 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
        final x10.util.List t$36302 = ((this.heap));
        
        //#line 52 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
        final long t$36303 = ((x10.util.Container<$T>)t$36302).size$O();
        
        //#line 52 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
        final boolean t$36307 = ((i) < (((t$36303))));
        
        //#line 52 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
        if (t$36307) {
            
            //#line 53 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
            this.siftdown__1cassia$util$HeapQueue$$T((i), ((e)));
            
            //#line 54 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
            final x10.util.List t$36304 = ((this.heap));
            
            //#line 54 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
            final $T t$36305 = ((((x10.util.Indexed<$T>)t$36304).$apply$G((i))));
            
            //#line 54 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
            final boolean t$36306 = (((t$36305))).equals(e);
            
            //#line 54 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
            if (t$36306) {
                
                //#line 55 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
                this.siftup__1cassia$util$HeapQueue$$T((i), ((e)));
            }
        }
        
        //#line 58 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
        return true;
    }
    
    
    //#line 61 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
    public boolean removeAllWhere__0$1cassia$util$HeapQueue$$T$3x10$lang$Boolean$2$O(final x10.core.fun.Fun_0_1 p) {
        
        //#line 62 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
        final x10.util.List a = ((this.heap));
        
        //#line 63 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
        final long n = ((x10.util.Container<$T>)a).size$O();
        
        //#line 64 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
        long i = 0L;
        
        //#line 65 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
        while (true) {
            
            //#line 65 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
            final long t$36308 = i;
            
            //#line 65 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
            final long t$36309 = ((x10.util.Container<$T>)a).size$O();
            
            //#line 65 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
            final boolean t$36319 = ((t$36308) < (((t$36309))));
            
            //#line 65 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
            if (!(t$36319)) {
                
                //#line 65 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
                break;
            }
            
            //#line 66 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
            final long t$36521 = i;
            
            //#line 66 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
            final $T t$36522 = ((((x10.util.Indexed<$T>)a).$apply$G((t$36521))));
            
            //#line 66 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
            final boolean t$36523 = x10.core.Boolean.$unbox(((x10.core.fun.Fun_0_1<$T,x10.core.Boolean>)p).$apply(t$36522, $T));
            
            //#line 66 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
            if (t$36523) {
                
                //#line 67 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
                final $T last$36524 = ((((x10.util.List<$T>)a).removeLast$G()));
                
                //#line 68 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
                final long t$36525 = i;
                
                //#line 68 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
                final long t$36526 = ((x10.util.Container<$T>)a).size$O();
                
                //#line 68 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
                final boolean t$36527 = ((t$36525) < (((t$36526))));
                
                //#line 68 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
                if (t$36527) {
                    
                    //#line 69 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
                    final long t$36528 = i;
                    
                    //#line 69 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
                    ((x10.lang.Settable<x10.core.Long, $T>)a).$set(x10.core.Long.$box(t$36528), x10.rtt.Types.LONG, ((last$36524)), $T);
                }
            } else {
                
                //#line 72 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
                final long t$36529 = i;
                
                //#line 72 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
                final long t$36530 = ((t$36529) + (((1L))));
                
                //#line 72 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
                i = t$36530;
            }
        }
        
        //#line 75 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
        final long t$36320 = i;
        
        //#line 75 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
        final boolean t$36321 = ((t$36320) < (((n))));
        
        //#line 75 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
        if (t$36321) {
            
            //#line 76 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
            this.heapify();
        }
        
        //#line 78 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
        final long t$36322 = i;
        
        //#line 78 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
        final boolean t$36323 = ((t$36322) < (((n))));
        
        //#line 78 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
        return t$36323;
    }
    
    
    //#line 96 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
    public long size$O() {
        
        //#line 96 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
        final x10.util.List t$36324 = ((this.heap));
        
        //#line 96 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
        final long t$36325 = ((x10.util.Container<$T>)t$36324).size$O();
        
        //#line 96 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
        return t$36325;
    }
    
    
    //#line 98 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
    public boolean contains__0cassia$util$HeapQueue$$T$O(final $T x) {
        
        //#line 98 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
        final x10.util.List t$36326 = ((this.heap));
        
        //#line 98 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
        final boolean t$36327 = x10.core.Boolean.$unbox(((x10.util.Container<$T>)t$36326).contains$Z(((x)), $T));
        
        //#line 98 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
        return t$36327;
    }
    
    
    //#line 100 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
    public x10.util.ListIterator iterator() {
        
        //#line 100 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
        final x10.util.List t$36328 = ((this.heap));
        
        //#line 100 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
        final x10.util.ListIterator t$36329 = (((x10.util.List<$T>)t$36328).iterator());
        
        //#line 100 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
        return t$36329;
    }
    
    
    //#line 102 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
    public x10.util.List toList() {
        
        //#line 102 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
        final x10.util.List t$36330 = ((this.heap));
        
        //#line 102 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
        final x10.util.Collection t$36331 = (((x10.util.Collection<$T>)t$36330).clone());
        
        //#line 102 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
        final x10.util.List t$36332 = x10.rtt.Types.<x10.util.List<$T>> cast(t$36331,x10.rtt.ParameterizedType.make(x10.util.List.$RTT, $T));
        
        //#line 102 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
        return t$36332;
    }
    
    
    //#line 104 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
    public void heapify() {
        
        //#line 105 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
        final x10.util.List t$36334 = ((this.heap));
        
        //#line 105 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
        final long t$36335 = ((x10.util.Container<$T>)t$36334).size$O();
        
        //#line 105 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
        final long t$36336 = ((t$36335) / (((2L))));
        
        //#line 105 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
        long i = ((t$36336) - (((1L))));
        
        //#line 105 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
        for (;
             true;
             ) {
            
            //#line 105 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
            final long t$36337 = i;
            
            //#line 105 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
            final boolean t$36344 = ((t$36337) >= (((0L))));
            
            //#line 105 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
            if (!(t$36344)) {
                
                //#line 105 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
                break;
            }
            
            //#line 106 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
            final long t$36531 = i;
            
            //#line 106 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
            final x10.util.List t$36532 = ((this.heap));
            
            //#line 106 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
            final long t$36533 = i;
            
            //#line 106 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
            final $T t$36534 = ((((x10.util.Indexed<$T>)t$36532).$apply$G((t$36533))));
            
            //#line 106 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
            this.siftdown__1cassia$util$HeapQueue$$T((t$36531), ((t$36534)));
            
            //#line 105 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
            final long t$36535 = i;
            
            //#line 105 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
            final long t$36536 = ((t$36535) - (((1L))));
            
            //#line 105 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
            i = t$36536;
        }
    }
    
    
    //#line 110 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
    public void siftup__1cassia$util$HeapQueue$$T(final long k, final $T x) {
        
        //#line 111 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
        long i = k;
        
        //#line 112 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
        while (true) {
            
            //#line 112 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
            final long t$36345 = i;
            
            //#line 112 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
            final boolean t$36358 = ((t$36345) > (((0L))));
            
            //#line 112 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
            if (!(t$36358)) {
                
                //#line 112 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
                break;
            }
            
            //#line 113 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
            final long t$36537 = i;
            
            //#line 113 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
            long parent$36538 = cassia.util.HeapQueue.PARENT$O((t$36537));
            
            //#line 114 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
            final x10.util.List t$36539 = ((this.heap));
            
            //#line 114 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
            final long t$36540 = parent$36538;
            
            //#line 114 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
            @SuppressWarnings("cast")
			$T e$36541 = ((((x10.util.Indexed<$T>)t$36539).$apply$G((long)(t$36540))));
            
            //#line 115 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
            final x10.core.fun.Fun_0_2 t$36542 = ((x10.core.fun.Fun_0_2)(this.comparator));
            
            //#line 115 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
            final $T t$36543 = (($T)(e$36541));
            
            //#line 115 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
            final int t$36544 = x10.core.Int.$unbox(((x10.core.fun.Fun_0_2<$T,$T,x10.core.Int>)t$36542).$apply(x, $T, t$36543, $T));
            
            //#line 115 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
            final long t$36545 = ((long)(((int)(t$36544))));
            
            //#line 115 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
            final boolean t$36546 = ((t$36545) >= (((long)(0L))));
            
            //#line 115 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
            if (t$36546) {
                
                //#line 116 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
                break;
            }
            
            //#line 118 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
            final x10.util.List t$36547 = ((x10.util.List)(this.heap));
            
            //#line 118 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
            final long t$36548 = i;
            
            //#line 118 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
            final $T t$36549 = (($T)(e$36541));
            
            //#line 118 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
            ((x10.lang.Settable<x10.core.Long, $T>)t$36547).$set(x10.core.Long.$box(t$36548), x10.rtt.Types.LONG, (($T)(t$36549)), $T);
            
            //#line 119 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
            final long t$36550 = parent$36538;
            
            //#line 119 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
            i = t$36550;
        }
        
        //#line 121 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
        final x10.util.List t$36359 = ((x10.util.List)(this.heap));
        
        //#line 121 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
        final long t$36360 = i;
        
        //#line 121 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
        ((x10.lang.Settable<x10.core.Long, $T>)t$36359).$set(x10.core.Long.$box(t$36360), x10.rtt.Types.LONG, (($T)(x)), $T);
    }
    
    
    //#line 124 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
    public void siftdown__1cassia$util$HeapQueue$$T(final long k, final $T x) {
        
        //#line 125 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
        long i = k;
        
        //#line 126 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
        final x10.util.List t$36361 = ((x10.util.List)(this.heap));
        
        //#line 126 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
        final long t$36362 = ((x10.util.Container<$T>)t$36361).size$O();
        
        //#line 126 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
        final long half = ((t$36362) / (((long)(2L))));
        
        //#line 127 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
        while (true) {
            
            //#line 127 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
            final long t$36363 = i;
            
            //#line 127 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
            final boolean t$36390 = ((t$36363) < (((long)(half))));
            
            //#line 127 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
            if (!(t$36390)) {
                
                //#line 127 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
                break;
            }
            
            //#line 128 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
            final long t$36551 = i;
            
            //#line 128 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
            long child$36552 = cassia.util.HeapQueue.LEFT$O((long)(t$36551));
            
            //#line 129 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
            final x10.util.List t$36553 = ((x10.util.List)(this.heap));
            
            //#line 129 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
            final long t$36554 = child$36552;
            
            //#line 129 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
            $T e$36555 = (($T)(((x10.util.Indexed<$T>)t$36553).$apply$G((long)(t$36554))));
            
            //#line 130 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
            final long t$36556 = i;
            
            //#line 130 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
            final long right$36557 = cassia.util.HeapQueue.RIGHT$O((long)(t$36556));
            
            //#line 131 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
            final x10.util.List t$36558 = ((x10.util.List)(this.heap));
            
            //#line 131 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
            final long t$36559 = ((x10.util.Container<$T>)t$36558).size$O();
            
            //#line 131 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
            boolean t$36560 = ((right$36557) < (((long)(t$36559))));
            
            //#line 131 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
            if (t$36560) {
                
                //#line 131 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
                final x10.core.fun.Fun_0_2 t$36561 = ((x10.core.fun.Fun_0_2)(this.comparator));
                
                //#line 131 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
                final $T t$36562 = (($T)(e$36555));
                
                //#line 131 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
                final x10.util.List t$36563 = ((x10.util.List)(this.heap));
                
                //#line 131 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
                final $T t$36564 = (($T)(((x10.util.Indexed<$T>)t$36563).$apply$G((long)(right$36557))));
                
                //#line 131 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
                final int t$36565 = x10.core.Int.$unbox(((x10.core.fun.Fun_0_2<$T,$T,x10.core.Int>)t$36561).$apply(t$36562, $T, t$36564, $T));
                
                //#line 131 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
                final long t$36566 = ((long)(((int)(t$36565))));
                
                //#line 131 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
                t$36560 = ((t$36566) > (((long)(0L))));
            }
            
            //#line 131 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
            final boolean t$36567 = t$36560;
            
            //#line 131 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
            if (t$36567) {
                
                //#line 132 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
                child$36552 = right$36557;
                
                //#line 133 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
                final x10.util.List t$36568 = ((x10.util.List)(this.heap));
                
                //#line 133 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
                final long t$36569 = child$36552;
                
                //#line 133 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
                final $T t$36570 = (($T)(((x10.util.Indexed<$T>)t$36568).$apply$G((long)(t$36569))));
                
                //#line 133 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
                e$36555 = (($T)(t$36570));
            }
            
            //#line 135 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
            final x10.core.fun.Fun_0_2 t$36571 = ((x10.core.fun.Fun_0_2)(this.comparator));
            
            //#line 135 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
            final $T t$36572 = (($T)(e$36555));
            
            //#line 135 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
            final int t$36573 = x10.core.Int.$unbox(((x10.core.fun.Fun_0_2<$T,$T,x10.core.Int>)t$36571).$apply(x, $T, t$36572, $T));
            
            //#line 135 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
            final long t$36574 = ((long)(((int)(t$36573))));
            
            //#line 135 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
            final boolean t$36575 = ((t$36574) <= (((long)(0L))));
            
            //#line 135 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
            if (t$36575) {
                
                //#line 136 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
                break;
            }
            
            //#line 138 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
            final x10.util.List t$36576 = ((x10.util.List)(this.heap));
            
            //#line 138 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
            final long t$36577 = i;
            
            //#line 138 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
            final $T t$36578 = (($T)(e$36555));
            
            //#line 138 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
            ((x10.lang.Settable<x10.core.Long, $T>)t$36576).$set(x10.core.Long.$box(t$36577), x10.rtt.Types.LONG, (($T)(t$36578)), $T);
            
            //#line 139 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
            final long t$36579 = child$36552;
            
            //#line 139 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
            i = t$36579;
        }
        
        //#line 141 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
        final x10.util.List t$36391 = ((x10.util.List)(this.heap));
        
        //#line 141 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
        final long t$36392 = i;
        
        //#line 141 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
        ((x10.lang.Settable<x10.core.Long, $T>)t$36391).$set(x10.core.Long.$box(t$36392), x10.rtt.Types.LONG, (($T)(x)), $T);
    }
    
    
    //#line 144 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
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
            HeapQueue.main(args);
        }
    }
    
    // the original app-main method
    public static void main(final x10.core.Rail<java.lang.String> id$13061) {
        
        //#line 145 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
        long last =  0;
        
        //#line 146 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
        cassia.util.SortedQueue q =  null;
        
        //#line 147 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
        final x10.util.Random random = ((x10.util.Random)(new x10.util.Random((java.lang.System[]) null).x10$util$Random$$init$S()));
        
        //#line 150 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
        final x10.io.Printer t$36393 = ((x10.io.Printer)(x10.io.Console.get$OUT()));
        
        //#line 150 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
        t$36393.println(((java.lang.Object)("# MIN-QUEUE")));
        
        //#line 151 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
        final x10.core.fun.Fun_0_2 t$36397 = ((x10.core.fun.Fun_0_2)(new cassia.util.HeapQueue.$Closure$37()));
        
        //#line 151 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
        final cassia.util.HeapQueue t$36398 = ((cassia.util.HeapQueue)(new cassia.util.HeapQueue<x10.core.Long>((java.lang.System[]) null, x10.rtt.Types.LONG).cassia$util$HeapQueue$$init$S(((x10.core.fun.Fun_0_2)(t$36397)), (cassia.util.HeapQueue.__0$1cassia$util$HeapQueue$$T$3cassia$util$HeapQueue$$T$3x10$lang$Int$2) null)));
        
        //#line 151 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
        q = ((cassia.util.SortedQueue)(t$36398));
        
        //#line 152 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
        final long i$36158min$36650 = 0L;
        
        //#line 152 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
        final long i$36158max$36651 = 10L;
        
        //#line 152 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
        long i$36586 = i$36158min$36650;
        
        //#line 152 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
        for (;
             true;
             ) {
            
            //#line 152 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
            final long t$36587 = i$36586;
            
            //#line 152 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
            final boolean t$36588 = ((t$36587) <= (((long)(i$36158max$36651))));
            
            //#line 152 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
            if (!(t$36588)) {
                
                //#line 152 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
                break;
            }
            
            //#line 152 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
            final long i$36583 = i$36586;
            
            //#line 153 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
            final cassia.util.SortedQueue t$36580 = ((cassia.util.SortedQueue)(q));
            
            //#line 153 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
            final long t$36581 = random.nextLong$O((long)(10L));
            
            //#line 153 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
            final long t$36582 = ((t$36581) - (((long)(5L))));
            
            //#line 153 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
            ((cassia.util.SortedQueue<x10.core.Long>)t$36580).push$Z(x10.core.Long.$box(t$36582), x10.rtt.Types.LONG);
            
            //#line 152 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
            final long t$36584 = i$36586;
            
            //#line 152 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
            final long t$36585 = ((t$36584) + (((long)(1L))));
            
            //#line 152 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
            i$36586 = t$36585;
        }
        
        //#line 155 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
        final long t$36407 = java.lang.Long.MIN_VALUE;
        
        //#line 155 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
        last = t$36407;
        
        //#line 156 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
        final long i$36176min$36652 = 0L;
        
        //#line 156 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
        final long i$36176max$36653 = 10L;
        
        //#line 156 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
        long i$36598 = i$36176min$36652;
        
        //#line 156 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
        for (;
             true;
             ) {
            
            //#line 156 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
            final long t$36599 = i$36598;
            
            //#line 156 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
            final boolean t$36600 = ((t$36599) <= (((long)(i$36176max$36653))));
            
            //#line 156 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
            if (!(t$36600)) {
                
                //#line 156 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
                break;
            }
            
            //#line 156 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
            final long i$36595 = i$36598;
            
            //#line 157 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
            final x10.io.Printer t$36589 = ((x10.io.Printer)(x10.io.Console.get$OUT()));
            
            //#line 157 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
            final cassia.util.SortedQueue t$36590 = ((cassia.util.SortedQueue)(q));
            
            //#line 157 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
            final x10.util.List t$36591 = ((x10.util.List<x10.core.Long>)
                                            ((cassia.util.SortedQueue<x10.core.Long>)t$36590).toList());
            
            //#line 157 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
            t$36589.println(((java.lang.Object)(t$36591)));
            
            //#line 158 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
            final cassia.util.SortedQueue t$36592 = ((cassia.util.SortedQueue)(q));
            
            //#line 158 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
            final long x$36593 = x10.core.Long.$unbox(((cassia.util.SortedQueue<x10.core.Long>)t$36592).pop$G());
            
            //#line 159 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
            final x10.io.Printer t$36594 = ((x10.io.Printer)(x10.io.Console.get$OUT()));
            
            //#line 159 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
            t$36594.println(x10.core.Long.$box(x$36593));
            
            //#line 160 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
            assert ((last) <= (((long)(x$36593))));
            
            //#line 161 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
            last = x$36593;
            
            //#line 156 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
            final long t$36596 = i$36598;
            
            //#line 156 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
            final long t$36597 = ((t$36596) + (((long)(1L))));
            
            //#line 156 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
            i$36598 = t$36597;
        }
        
        //#line 165 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
        final x10.io.Printer t$36418 = ((x10.io.Printer)(x10.io.Console.get$OUT()));
        
        //#line 165 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
        t$36418.println(((java.lang.Object)("# MAX-QUEUE")));
        
        //#line 166 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
        final x10.core.fun.Fun_0_2 t$36422 = ((x10.core.fun.Fun_0_2)(new cassia.util.HeapQueue.$Closure$38()));
        
        //#line 166 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
        final cassia.util.HeapQueue t$36423 = ((cassia.util.HeapQueue)(new cassia.util.HeapQueue<x10.core.Long>((java.lang.System[]) null, x10.rtt.Types.LONG).cassia$util$HeapQueue$$init$S(((x10.core.fun.Fun_0_2)(t$36422)), (cassia.util.HeapQueue.__0$1cassia$util$HeapQueue$$T$3cassia$util$HeapQueue$$T$3x10$lang$Int$2) null)));
        
        //#line 166 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
        q = ((cassia.util.SortedQueue)(t$36423));
        
        //#line 167 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
        final long i$36194min$36654 = 0L;
        
        //#line 167 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
        final long i$36194max$36655 = 10L;
        
        //#line 167 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
        long i$36607 = i$36194min$36654;
        
        //#line 167 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
        for (;
             true;
             ) {
            
            //#line 167 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
            final long t$36608 = i$36607;
            
            //#line 167 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
            final boolean t$36609 = ((t$36608) <= (((long)(i$36194max$36655))));
            
            //#line 167 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
            if (!(t$36609)) {
                
                //#line 167 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
                break;
            }
            
            //#line 167 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
            final long i$36604 = i$36607;
            
            //#line 168 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
            final cassia.util.SortedQueue t$36601 = ((cassia.util.SortedQueue)(q));
            
            //#line 168 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
            final long t$36602 = random.nextLong$O((long)(10L));
            
            //#line 168 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
            final long t$36603 = ((t$36602) - (((long)(5L))));
            
            //#line 168 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
            ((cassia.util.SortedQueue<x10.core.Long>)t$36601).push$Z(x10.core.Long.$box(t$36603), x10.rtt.Types.LONG);
            
            //#line 167 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
            final long t$36605 = i$36607;
            
            //#line 167 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
            final long t$36606 = ((t$36605) + (((long)(1L))));
            
            //#line 167 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
            i$36607 = t$36606;
        }
        
        //#line 170 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
        final long t$36432 = java.lang.Long.MAX_VALUE;
        
        //#line 170 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
        last = t$36432;
        
        //#line 171 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
        final long i$36212min$36656 = 0L;
        
        //#line 171 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
        final long i$36212max$36657 = 10L;
        
        //#line 171 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
        long i$36619 = i$36212min$36656;
        
        //#line 171 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
        for (;
             true;
             ) {
            
            //#line 171 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
            final long t$36620 = i$36619;
            
            //#line 171 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
            final boolean t$36621 = ((t$36620) <= (((long)(i$36212max$36657))));
            
            //#line 171 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
            if (!(t$36621)) {
                
                //#line 171 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
                break;
            }
            
            //#line 171 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
            final long i$36616 = i$36619;
            
            //#line 172 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
            final x10.io.Printer t$36610 = ((x10.io.Printer)(x10.io.Console.get$OUT()));
            
            //#line 172 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
            final cassia.util.SortedQueue t$36611 = ((cassia.util.SortedQueue)(q));
            
            //#line 172 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
            final x10.util.List t$36612 = ((x10.util.List<x10.core.Long>)
                                            ((cassia.util.SortedQueue<x10.core.Long>)t$36611).toList());
            
            //#line 172 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
            t$36610.println(((java.lang.Object)(t$36612)));
            
            //#line 173 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
            final cassia.util.SortedQueue t$36613 = ((cassia.util.SortedQueue)(q));
            
            //#line 173 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
            final long x$36614 = x10.core.Long.$unbox(((cassia.util.SortedQueue<x10.core.Long>)t$36613).pop$G());
            
            //#line 174 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
            final x10.io.Printer t$36615 = ((x10.io.Printer)(x10.io.Console.get$OUT()));
            
            //#line 174 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
            t$36615.println(x10.core.Long.$box(x$36614));
            
            //#line 175 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
            assert ((last) >= (((long)(x$36614))));
            
            //#line 176 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
            last = x$36614;
            
            //#line 171 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
            final long t$36617 = i$36619;
            
            //#line 171 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
            final long t$36618 = ((t$36617) + (((long)(1L))));
            
            //#line 171 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
            i$36619 = t$36618;
        }
        
        //#line 180 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
        final x10.io.Printer t$36443 = ((x10.io.Printer)(x10.io.Console.get$OUT()));
        
        //#line 180 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
        t$36443.println(((java.lang.Object)("# remove()")));
        
        //#line 181 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
        final x10.core.fun.Fun_0_2 t$36447 = ((x10.core.fun.Fun_0_2)(new cassia.util.HeapQueue.$Closure$39()));
        
        //#line 181 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
        final cassia.util.HeapQueue t$36448 = ((cassia.util.HeapQueue)(new cassia.util.HeapQueue<x10.core.Long>((java.lang.System[]) null, x10.rtt.Types.LONG).cassia$util$HeapQueue$$init$S(((x10.core.fun.Fun_0_2)(t$36447)), (cassia.util.HeapQueue.__0$1cassia$util$HeapQueue$$T$3cassia$util$HeapQueue$$T$3x10$lang$Int$2) null)));
        
        //#line 181 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
        q = ((cassia.util.SortedQueue)(t$36448));
        
        //#line 182 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
        final cassia.util.SortedQueue t$36449 = ((cassia.util.SortedQueue)(q));
        
        //#line 182 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
        ((cassia.util.SortedQueue<x10.core.Long>)t$36449).push$Z(x10.core.Long.$box(-5L), x10.rtt.Types.LONG);
        
        //#line 183 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
        final cassia.util.SortedQueue t$36450 = ((cassia.util.SortedQueue)(q));
        
        //#line 183 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
        ((cassia.util.SortedQueue<x10.core.Long>)t$36450).push$Z(x10.core.Long.$box(0L), x10.rtt.Types.LONG);
        
        //#line 184 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
        final cassia.util.SortedQueue t$36451 = ((cassia.util.SortedQueue)(q));
        
        //#line 184 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
        ((cassia.util.SortedQueue<x10.core.Long>)t$36451).push$Z(x10.core.Long.$box(0L), x10.rtt.Types.LONG);
        
        //#line 185 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
        final cassia.util.SortedQueue t$36452 = ((cassia.util.SortedQueue)(q));
        
        //#line 185 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
        final long t$36453 = 5L;
        
        //#line 185 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
        ((cassia.util.SortedQueue<x10.core.Long>)t$36452).push$Z(x10.core.Long.$box(t$36453), x10.rtt.Types.LONG);
        
        //#line 186 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
        final x10.io.Printer t$36455 = ((x10.io.Printer)(x10.io.Console.get$OUT()));
        
        //#line 186 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
        final cassia.util.SortedQueue t$36454 = ((cassia.util.SortedQueue)(q));
        
        //#line 186 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
        final x10.util.List t$36456 = ((x10.util.List<x10.core.Long>)
                                        ((cassia.util.SortedQueue<x10.core.Long>)t$36454).toList());
        
        //#line 186 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
        t$36455.println(((java.lang.Object)(t$36456)));
        
        //#line 187 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
        final cassia.util.SortedQueue t$36457 = ((cassia.util.SortedQueue)(q));
        
        //#line 187 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
        ((cassia.util.SortedQueue<x10.core.Long>)t$36457).remove$Z(x10.core.Long.$box(0L), x10.rtt.Types.LONG);
        
        //#line 188 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
        final x10.io.Printer t$36459 = ((x10.io.Printer)(x10.io.Console.get$OUT()));
        
        //#line 188 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
        final cassia.util.SortedQueue t$36458 = ((cassia.util.SortedQueue)(q));
        
        //#line 188 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
        final x10.util.List t$36460 = ((x10.util.List<x10.core.Long>)
                                        ((cassia.util.SortedQueue<x10.core.Long>)t$36458).toList());
        
        //#line 188 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
        t$36459.println(((java.lang.Object)(t$36460)));
        
        //#line 189 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
        final cassia.util.SortedQueue t$36461 = ((cassia.util.SortedQueue)(q));
        
        //#line 189 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
        ((cassia.util.SortedQueue<x10.core.Long>)t$36461).remove$Z(x10.core.Long.$box(0L), x10.rtt.Types.LONG);
        
        //#line 190 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
        final x10.io.Printer t$36463 = ((x10.io.Printer)(x10.io.Console.get$OUT()));
        
        //#line 190 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
        final cassia.util.SortedQueue t$36462 = ((cassia.util.SortedQueue)(q));
        
        //#line 190 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
        final x10.util.List t$36464 = ((x10.util.List<x10.core.Long>)
                                        ((cassia.util.SortedQueue<x10.core.Long>)t$36462).toList());
        
        //#line 190 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
        t$36463.println(((java.lang.Object)(t$36464)));
        
        //#line 191 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
        final cassia.util.SortedQueue t$36465 = ((cassia.util.SortedQueue)(q));
        
        //#line 191 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
        final long t$36466 = 5L;
        
        //#line 191 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
        ((cassia.util.SortedQueue<x10.core.Long>)t$36465).remove$Z(x10.core.Long.$box(t$36466), x10.rtt.Types.LONG);
        
        //#line 192 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
        final x10.io.Printer t$36468 = ((x10.io.Printer)(x10.io.Console.get$OUT()));
        
        //#line 192 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
        final cassia.util.SortedQueue t$36467 = ((cassia.util.SortedQueue)(q));
        
        //#line 192 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
        final x10.util.List t$36469 = ((x10.util.List<x10.core.Long>)
                                        ((cassia.util.SortedQueue<x10.core.Long>)t$36467).toList());
        
        //#line 192 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
        t$36468.println(((java.lang.Object)(t$36469)));
        
        //#line 193 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
        final cassia.util.SortedQueue t$36470 = ((cassia.util.SortedQueue)(q));
        
        //#line 193 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
        ((cassia.util.SortedQueue<x10.core.Long>)t$36470).remove$Z(x10.core.Long.$box(-5L), x10.rtt.Types.LONG);
        
        //#line 194 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
        final x10.io.Printer t$36472 = ((x10.io.Printer)(x10.io.Console.get$OUT()));
        
        //#line 194 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
        final cassia.util.SortedQueue t$36471 = ((cassia.util.SortedQueue)(q));
        
        //#line 194 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
        final x10.util.List t$36473 = ((x10.util.List<x10.core.Long>)
                                        ((cassia.util.SortedQueue<x10.core.Long>)t$36471).toList());
        
        //#line 194 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
        t$36472.println(((java.lang.Object)(t$36473)));
        
        //#line 197 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
        final x10.io.Printer t$36474 = ((x10.io.Printer)(x10.io.Console.get$OUT()));
        
        //#line 197 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
        t$36474.println(((java.lang.Object)("# removeAllWhere()")));
        
        //#line 198 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
        final x10.core.fun.Fun_0_2 t$36478 = ((x10.core.fun.Fun_0_2)(new cassia.util.HeapQueue.$Closure$40()));
        
        //#line 198 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
        final cassia.util.HeapQueue t$36479 = ((cassia.util.HeapQueue)(new cassia.util.HeapQueue<x10.core.Long>((java.lang.System[]) null, x10.rtt.Types.LONG).cassia$util$HeapQueue$$init$S(((x10.core.fun.Fun_0_2)(t$36478)), (cassia.util.HeapQueue.__0$1cassia$util$HeapQueue$$T$3cassia$util$HeapQueue$$T$3x10$lang$Int$2) null)));
        
        //#line 198 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
        q = ((cassia.util.SortedQueue)(t$36479));
        
        //#line 199 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
        final long i$36230min$36658 = 0L;
        
        //#line 199 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
        final long i$36230max$36659 = 10L;
        
        //#line 199 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
        long i$36628 = i$36230min$36658;
        
        //#line 199 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
        for (;
             true;
             ) {
            
            //#line 199 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
            final long t$36629 = i$36628;
            
            //#line 199 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
            final boolean t$36630 = ((t$36629) <= (((long)(i$36230max$36659))));
            
            //#line 199 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
            if (!(t$36630)) {
                
                //#line 199 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
                break;
            }
            
            //#line 199 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
            final long i$36625 = i$36628;
            
            //#line 200 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
            final cassia.util.SortedQueue t$36622 = ((cassia.util.SortedQueue)(q));
            
            //#line 200 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
            final long t$36623 = random.nextLong$O((long)(10L));
            
            //#line 200 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
            final long t$36624 = ((t$36623) - (((long)(5L))));
            
            //#line 200 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
            ((cassia.util.SortedQueue<x10.core.Long>)t$36622).push$Z(x10.core.Long.$box(t$36624), x10.rtt.Types.LONG);
            
            //#line 199 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
            final long t$36626 = i$36628;
            
            //#line 199 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
            final long t$36627 = ((t$36626) + (((long)(1L))));
            
            //#line 199 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
            i$36628 = t$36627;
        }
        
        //#line 202 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
        final x10.io.Printer t$36489 = ((x10.io.Printer)(x10.io.Console.get$OUT()));
        
        //#line 202 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
        final cassia.util.SortedQueue t$36488 = ((cassia.util.SortedQueue)(q));
        
        //#line 202 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
        final x10.util.List t$36490 = ((x10.util.List<x10.core.Long>)
                                        ((cassia.util.SortedQueue<x10.core.Long>)t$36488).toList());
        
        //#line 202 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
        t$36489.println(((java.lang.Object)(t$36490)));
        
        //#line 203 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
        final cassia.util.SortedQueue t$36492 = ((cassia.util.SortedQueue)(q));
        
        //#line 203 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
        final x10.core.fun.Fun_0_1 t$36493 = ((x10.core.fun.Fun_0_1)(new cassia.util.HeapQueue.$Closure$41()));
        
        //#line 203 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
        ((cassia.util.SortedQueue<x10.core.Long>)t$36492).removeAllWhere$Z(((x10.core.fun.Fun_0_1)(t$36493)), x10.rtt.ParameterizedType.make(x10.core.fun.Fun_0_1.$RTT,x10.rtt.Types.LONG,x10.rtt.Types.BOOLEAN));
        
        //#line 204 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
        final x10.io.Printer t$36495 = ((x10.io.Printer)(x10.io.Console.get$OUT()));
        
        //#line 204 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
        final cassia.util.SortedQueue t$36494 = ((cassia.util.SortedQueue)(q));
        
        //#line 204 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
        final x10.util.List t$36496 = ((x10.util.List<x10.core.Long>)
                                        ((cassia.util.SortedQueue<x10.core.Long>)t$36494).toList());
        
        //#line 204 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
        t$36495.println(((java.lang.Object)(t$36496)));
        
        //#line 207 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
        final x10.io.Printer t$36497 = ((x10.io.Printer)(x10.io.Console.get$OUT()));
        
        //#line 207 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
        t$36497.println(((java.lang.Object)("# heapify()")));
        
        //#line 208 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
        final x10.core.fun.Fun_0_2 t$36501 = ((x10.core.fun.Fun_0_2)(new cassia.util.HeapQueue.$Closure$42()));
        
        //#line 208 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
        final cassia.util.HeapQueue b = ((cassia.util.HeapQueue)(new cassia.util.HeapQueue<x10.core.Long>((java.lang.System[]) null, x10.rtt.Types.LONG).cassia$util$HeapQueue$$init$S(((x10.core.fun.Fun_0_2)(t$36501)), (cassia.util.HeapQueue.__0$1cassia$util$HeapQueue$$T$3cassia$util$HeapQueue$$T$3x10$lang$Int$2) null)));
        
        //#line 209 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
        final long i$36248min$36660 = 0L;
        
        //#line 209 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
        final long i$36248max$36661 = 10L;
        
        //#line 209 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
        long i$36637 = i$36248min$36660;
        
        //#line 209 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
        for (;
             true;
             ) {
            
            //#line 209 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
            final long t$36638 = i$36637;
            
            //#line 209 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
            final boolean t$36639 = ((t$36638) <= (((long)(i$36248max$36661))));
            
            //#line 209 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
            if (!(t$36639)) {
                
                //#line 209 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
                break;
            }
            
            //#line 209 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
            final long i$36634 = i$36637;
            
            //#line 210 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
            final x10.util.List t$36631 = ((x10.util.List)(((cassia.util.HeapQueue<x10.core.Long>)b).heap));
            
            //#line 210 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
            final long t$36632 = random.nextLong$O((long)(10L));
            
            //#line 210 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
            final long t$36633 = ((t$36632) - (((long)(5L))));
            
            //#line 210 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
            ((x10.util.Collection<x10.core.Long>)t$36631).add$Z(x10.core.Long.$box(t$36633), x10.rtt.Types.LONG);
            
            //#line 209 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
            final long t$36635 = i$36637;
            
            //#line 209 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
            final long t$36636 = ((t$36635) + (((long)(1L))));
            
            //#line 209 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
            i$36637 = t$36636;
        }
        
        //#line 212 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
        final x10.io.Printer t$36510 = ((x10.io.Printer)(x10.io.Console.get$OUT()));
        
        //#line 212 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
        final x10.util.List t$36511 = ((x10.util.List)(((cassia.util.HeapQueue<x10.core.Long>)b).heap));
        
        //#line 212 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
        t$36510.println(((java.lang.Object)(t$36511)));
        
        //#line 213 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
        ((cassia.util.HeapQueue<x10.core.Long>)b).heapify();
        
        //#line 214 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
        final long t$36512 = java.lang.Long.MIN_VALUE;
        
        //#line 214 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
        last = t$36512;
        
        //#line 215 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
        final long i$36266min$36662 = 0L;
        
        //#line 215 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
        final long i$36266max$36663 = 10L;
        
        //#line 215 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
        long i$36647 = i$36266min$36662;
        
        //#line 215 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
        for (;
             true;
             ) {
            
            //#line 215 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
            final long t$36648 = i$36647;
            
            //#line 215 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
            final boolean t$36649 = ((t$36648) <= (((long)(i$36266max$36663))));
            
            //#line 215 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
            if (!(t$36649)) {
                
                //#line 215 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
                break;
            }
            
            //#line 215 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
            final long i$36644 = i$36647;
            
            //#line 216 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
            final x10.io.Printer t$36640 = ((x10.io.Printer)(x10.io.Console.get$OUT()));
            
            //#line 216 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
            final x10.util.List t$36641 = ((x10.util.List)(((cassia.util.HeapQueue<x10.core.Long>)b).heap));
            
            //#line 216 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
            t$36640.println(((java.lang.Object)(t$36641)));
            
            //#line 217 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
            final long x$36642 = x10.core.Long.$unbox(((cassia.util.HeapQueue<x10.core.Long>)b).pop$G());
            
            //#line 218 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
            final x10.io.Printer t$36643 = ((x10.io.Printer)(x10.io.Console.get$OUT()));
            
            //#line 218 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
            t$36643.println(x10.core.Long.$box(x$36642));
            
            //#line 219 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
            assert ((last) <= (((long)(x$36642))));
            
            //#line 220 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
            last = x$36642;
            
            //#line 215 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
            final long t$36645 = i$36647;
            
            //#line 215 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
            final long t$36646 = ((t$36645) + (((long)(1L))));
            
            //#line 215 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
            i$36647 = t$36646;
        }
    }
    
    
    //#line 11 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
    final public cassia.util.HeapQueue cassia$util$HeapQueue$$this$cassia$util$HeapQueue() {
        
        //#line 11 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
        return cassia.util.HeapQueue.this;
    }
    
    
    //#line 11 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
    final public void __fieldInitializers_cassia_util_HeapQueue() {
        
        //#line 11 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
        ((cassia.util.HeapQueue<$T>)this).heap = null;
        
        //#line 11 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
        ((cassia.util.HeapQueue<$T>)this).comparator = null;
    }
    
    @x10.runtime.impl.java.X10Generated
    final public static class $Closure$37 extends x10.core.Ref implements x10.core.fun.Fun_0_2, x10.serialization.X10JavaSerializable
    {
        public static final x10.rtt.RuntimeType<$Closure$37> $RTT = 
            x10.rtt.StaticFunType.<$Closure$37> make($Closure$37.class,
                                                     new x10.rtt.Type[] {
                                                         x10.rtt.ParameterizedType.make(x10.core.fun.Fun_0_2.$RTT, x10.rtt.Types.LONG, x10.rtt.Types.LONG, x10.rtt.Types.INT)
                                                     });
        
        public x10.rtt.RuntimeType<?> $getRTT() { return $RTT; }
        
        public x10.rtt.Type<?> $getParam(int i) { return null; }
        
        private Object writeReplace() throws java.io.ObjectStreamException {
            return new x10.serialization.SerializationProxy(this);
        }
        
        public static x10.serialization.X10JavaSerializable $_deserialize_body(cassia.util.HeapQueue.$Closure$37 $_obj, x10.serialization.X10JavaDeserializer $deserializer) throws java.io.IOException {
            if (x10.runtime.impl.java.Runtime.TRACE_SER) { x10.runtime.impl.java.Runtime.printTraceMessage("X10JavaSerializable: $_deserialize_body() of " + $Closure$37.class + " calling"); } 
            return $_obj;
        }
        
        public static x10.serialization.X10JavaSerializable $_deserializer(x10.serialization.X10JavaDeserializer $deserializer) throws java.io.IOException {
            cassia.util.HeapQueue.$Closure$37 $_obj = new cassia.util.HeapQueue.$Closure$37((java.lang.System[]) null);
            $deserializer.record_reference($_obj);
            return $_deserialize_body($_obj, $deserializer);
        }
        
        public void $_serialize(x10.serialization.X10JavaSerializer $serializer) throws java.io.IOException {
            
        }
        
        // constructor just for allocation
        public $Closure$37(final java.lang.System[] $dummy) {
            
        }
        
        // dispatcher for method abstract public (Z1,Z2)=>U.operator()(a1:Z1, a2:Z2):U
        public java.lang.Object $apply(final java.lang.Object a1, final x10.rtt.Type t1, final java.lang.Object a2, final x10.rtt.Type t2) {
            return x10.core.Int.$box($apply$O(x10.core.Long.$unbox(a1), x10.core.Long.$unbox(a2)));
            
        }
        
        // dispatcher for method abstract public (Z1,Z2)=>U.operator()(a1:Z1, a2:Z2):U
        public int $apply$I(final java.lang.Object a1, final x10.rtt.Type t1, final java.lang.Object a2, final x10.rtt.Type t2) {
            return $apply$O(x10.core.Long.$unbox(a1), x10.core.Long.$unbox(a2));
            
        }
        
        
    
        
        public int $apply$O(final long x, final long y) {
            
            //#line 151 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
            final long t$36394 = ((x) - (((long)(y))));
            
            //#line 151 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
            final long t$36395 = x10.lang.Math.signum$O((long)(t$36394));
            
            //#line 151 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
            final int t$36396 = ((int)(long)(((long)(t$36395))));
            
            //#line 151 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
            return t$36396;
        }
        
        public $Closure$37() {
             {
                
            }
        }
        
    }
    
    @x10.runtime.impl.java.X10Generated
    final public static class $Closure$38 extends x10.core.Ref implements x10.core.fun.Fun_0_2, x10.serialization.X10JavaSerializable
    {
        public static final x10.rtt.RuntimeType<$Closure$38> $RTT = 
            x10.rtt.StaticFunType.<$Closure$38> make($Closure$38.class,
                                                     new x10.rtt.Type[] {
                                                         x10.rtt.ParameterizedType.make(x10.core.fun.Fun_0_2.$RTT, x10.rtt.Types.LONG, x10.rtt.Types.LONG, x10.rtt.Types.INT)
                                                     });
        
        public x10.rtt.RuntimeType<?> $getRTT() { return $RTT; }
        
        public x10.rtt.Type<?> $getParam(int i) { return null; }
        
        private Object writeReplace() throws java.io.ObjectStreamException {
            return new x10.serialization.SerializationProxy(this);
        }
        
        public static x10.serialization.X10JavaSerializable $_deserialize_body(cassia.util.HeapQueue.$Closure$38 $_obj, x10.serialization.X10JavaDeserializer $deserializer) throws java.io.IOException {
            if (x10.runtime.impl.java.Runtime.TRACE_SER) { x10.runtime.impl.java.Runtime.printTraceMessage("X10JavaSerializable: $_deserialize_body() of " + $Closure$38.class + " calling"); } 
            return $_obj;
        }
        
        public static x10.serialization.X10JavaSerializable $_deserializer(x10.serialization.X10JavaDeserializer $deserializer) throws java.io.IOException {
            cassia.util.HeapQueue.$Closure$38 $_obj = new cassia.util.HeapQueue.$Closure$38((java.lang.System[]) null);
            $deserializer.record_reference($_obj);
            return $_deserialize_body($_obj, $deserializer);
        }
        
        public void $_serialize(x10.serialization.X10JavaSerializer $serializer) throws java.io.IOException {
            
        }
        
        // constructor just for allocation
        public $Closure$38(final java.lang.System[] $dummy) {
            
        }
        
        // dispatcher for method abstract public (Z1,Z2)=>U.operator()(a1:Z1, a2:Z2):U
        public java.lang.Object $apply(final java.lang.Object a1, final x10.rtt.Type t1, final java.lang.Object a2, final x10.rtt.Type t2) {
            return x10.core.Int.$box($apply$O(x10.core.Long.$unbox(a1), x10.core.Long.$unbox(a2)));
            
        }
        
        // dispatcher for method abstract public (Z1,Z2)=>U.operator()(a1:Z1, a2:Z2):U
        public int $apply$I(final java.lang.Object a1, final x10.rtt.Type t1, final java.lang.Object a2, final x10.rtt.Type t2) {
            return $apply$O(x10.core.Long.$unbox(a1), x10.core.Long.$unbox(a2));
            
        }
        
        
    
        
        public int $apply$O(final long x, final long y) {
            
            //#line 166 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
            final long t$36419 = ((y) - (((long)(x))));
            
            //#line 166 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
            final long t$36420 = x10.lang.Math.signum$O((long)(t$36419));
            
            //#line 166 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
            final int t$36421 = ((int)(long)(((long)(t$36420))));
            
            //#line 166 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
            return t$36421;
        }
        
        public $Closure$38() {
             {
                
            }
        }
        
    }
    
    @x10.runtime.impl.java.X10Generated
    final public static class $Closure$39 extends x10.core.Ref implements x10.core.fun.Fun_0_2, x10.serialization.X10JavaSerializable
    {
        public static final x10.rtt.RuntimeType<$Closure$39> $RTT = 
            x10.rtt.StaticFunType.<$Closure$39> make($Closure$39.class,
                                                     new x10.rtt.Type[] {
                                                         x10.rtt.ParameterizedType.make(x10.core.fun.Fun_0_2.$RTT, x10.rtt.Types.LONG, x10.rtt.Types.LONG, x10.rtt.Types.INT)
                                                     });
        
        public x10.rtt.RuntimeType<?> $getRTT() { return $RTT; }
        
        public x10.rtt.Type<?> $getParam(int i) { return null; }
        
        private Object writeReplace() throws java.io.ObjectStreamException {
            return new x10.serialization.SerializationProxy(this);
        }
        
        public static x10.serialization.X10JavaSerializable $_deserialize_body(cassia.util.HeapQueue.$Closure$39 $_obj, x10.serialization.X10JavaDeserializer $deserializer) throws java.io.IOException {
            if (x10.runtime.impl.java.Runtime.TRACE_SER) { x10.runtime.impl.java.Runtime.printTraceMessage("X10JavaSerializable: $_deserialize_body() of " + $Closure$39.class + " calling"); } 
            return $_obj;
        }
        
        public static x10.serialization.X10JavaSerializable $_deserializer(x10.serialization.X10JavaDeserializer $deserializer) throws java.io.IOException {
            cassia.util.HeapQueue.$Closure$39 $_obj = new cassia.util.HeapQueue.$Closure$39((java.lang.System[]) null);
            $deserializer.record_reference($_obj);
            return $_deserialize_body($_obj, $deserializer);
        }
        
        public void $_serialize(x10.serialization.X10JavaSerializer $serializer) throws java.io.IOException {
            
        }
        
        // constructor just for allocation
        public $Closure$39(final java.lang.System[] $dummy) {
            
        }
        
        // dispatcher for method abstract public (Z1,Z2)=>U.operator()(a1:Z1, a2:Z2):U
        public java.lang.Object $apply(final java.lang.Object a1, final x10.rtt.Type t1, final java.lang.Object a2, final x10.rtt.Type t2) {
            return x10.core.Int.$box($apply$O(x10.core.Long.$unbox(a1), x10.core.Long.$unbox(a2)));
            
        }
        
        // dispatcher for method abstract public (Z1,Z2)=>U.operator()(a1:Z1, a2:Z2):U
        public int $apply$I(final java.lang.Object a1, final x10.rtt.Type t1, final java.lang.Object a2, final x10.rtt.Type t2) {
            return $apply$O(x10.core.Long.$unbox(a1), x10.core.Long.$unbox(a2));
            
        }
        
        
    
        
        public int $apply$O(final long x, final long y) {
            
            //#line 181 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
            final long t$36444 = ((x) - (((long)(y))));
            
            //#line 181 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
            final long t$36445 = x10.lang.Math.signum$O((long)(t$36444));
            
            //#line 181 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
            final int t$36446 = ((int)(long)(((long)(t$36445))));
            
            //#line 181 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
            return t$36446;
        }
        
        public $Closure$39() {
             {
                
            }
        }
        
    }
    
    @x10.runtime.impl.java.X10Generated
    final public static class $Closure$40 extends x10.core.Ref implements x10.core.fun.Fun_0_2, x10.serialization.X10JavaSerializable
    {
        public static final x10.rtt.RuntimeType<$Closure$40> $RTT = 
            x10.rtt.StaticFunType.<$Closure$40> make($Closure$40.class,
                                                     new x10.rtt.Type[] {
                                                         x10.rtt.ParameterizedType.make(x10.core.fun.Fun_0_2.$RTT, x10.rtt.Types.LONG, x10.rtt.Types.LONG, x10.rtt.Types.INT)
                                                     });
        
        public x10.rtt.RuntimeType<?> $getRTT() { return $RTT; }
        
        public x10.rtt.Type<?> $getParam(int i) { return null; }
        
        private Object writeReplace() throws java.io.ObjectStreamException {
            return new x10.serialization.SerializationProxy(this);
        }
        
        public static x10.serialization.X10JavaSerializable $_deserialize_body(cassia.util.HeapQueue.$Closure$40 $_obj, x10.serialization.X10JavaDeserializer $deserializer) throws java.io.IOException {
            if (x10.runtime.impl.java.Runtime.TRACE_SER) { x10.runtime.impl.java.Runtime.printTraceMessage("X10JavaSerializable: $_deserialize_body() of " + $Closure$40.class + " calling"); } 
            return $_obj;
        }
        
        public static x10.serialization.X10JavaSerializable $_deserializer(x10.serialization.X10JavaDeserializer $deserializer) throws java.io.IOException {
            cassia.util.HeapQueue.$Closure$40 $_obj = new cassia.util.HeapQueue.$Closure$40((java.lang.System[]) null);
            $deserializer.record_reference($_obj);
            return $_deserialize_body($_obj, $deserializer);
        }
        
        public void $_serialize(x10.serialization.X10JavaSerializer $serializer) throws java.io.IOException {
            
        }
        
        // constructor just for allocation
        public $Closure$40(final java.lang.System[] $dummy) {
            
        }
        
        // dispatcher for method abstract public (Z1,Z2)=>U.operator()(a1:Z1, a2:Z2):U
        public java.lang.Object $apply(final java.lang.Object a1, final x10.rtt.Type t1, final java.lang.Object a2, final x10.rtt.Type t2) {
            return x10.core.Int.$box($apply$O(x10.core.Long.$unbox(a1), x10.core.Long.$unbox(a2)));
            
        }
        
        // dispatcher for method abstract public (Z1,Z2)=>U.operator()(a1:Z1, a2:Z2):U
        public int $apply$I(final java.lang.Object a1, final x10.rtt.Type t1, final java.lang.Object a2, final x10.rtt.Type t2) {
            return $apply$O(x10.core.Long.$unbox(a1), x10.core.Long.$unbox(a2));
            
        }
        
        
    
        
        public int $apply$O(final long x, final long y) {
            
            //#line 198 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
            final long t$36475 = ((y) - (((long)(x))));
            
            //#line 198 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
            final long t$36476 = x10.lang.Math.signum$O((long)(t$36475));
            
            //#line 198 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
            final int t$36477 = ((int)(long)(((long)(t$36476))));
            
            //#line 198 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
            return t$36477;
        }
        
        public $Closure$40() {
             {
                
            }
        }
        
    }
    
    @x10.runtime.impl.java.X10Generated
    final public static class $Closure$41 extends x10.core.Ref implements x10.core.fun.Fun_0_1, x10.serialization.X10JavaSerializable
    {
        public static final x10.rtt.RuntimeType<$Closure$41> $RTT = 
            x10.rtt.StaticFunType.<$Closure$41> make($Closure$41.class,
                                                     new x10.rtt.Type[] {
                                                         x10.rtt.ParameterizedType.make(x10.core.fun.Fun_0_1.$RTT, x10.rtt.Types.LONG, x10.rtt.Types.BOOLEAN)
                                                     });
        
        public x10.rtt.RuntimeType<?> $getRTT() { return $RTT; }
        
        public x10.rtt.Type<?> $getParam(int i) { return null; }
        
        private Object writeReplace() throws java.io.ObjectStreamException {
            return new x10.serialization.SerializationProxy(this);
        }
        
        public static x10.serialization.X10JavaSerializable $_deserialize_body(cassia.util.HeapQueue.$Closure$41 $_obj, x10.serialization.X10JavaDeserializer $deserializer) throws java.io.IOException {
            if (x10.runtime.impl.java.Runtime.TRACE_SER) { x10.runtime.impl.java.Runtime.printTraceMessage("X10JavaSerializable: $_deserialize_body() of " + $Closure$41.class + " calling"); } 
            return $_obj;
        }
        
        public static x10.serialization.X10JavaSerializable $_deserializer(x10.serialization.X10JavaDeserializer $deserializer) throws java.io.IOException {
            cassia.util.HeapQueue.$Closure$41 $_obj = new cassia.util.HeapQueue.$Closure$41((java.lang.System[]) null);
            $deserializer.record_reference($_obj);
            return $_deserialize_body($_obj, $deserializer);
        }
        
        public void $_serialize(x10.serialization.X10JavaSerializer $serializer) throws java.io.IOException {
            
        }
        
        // constructor just for allocation
        public $Closure$41(final java.lang.System[] $dummy) {
            
        }
        
        // dispatcher for method abstract public (Z1)=>U.operator()(a1:Z1):U
        public java.lang.Object $apply(final java.lang.Object a1, final x10.rtt.Type t1) {
            return x10.core.Boolean.$box($apply$O(x10.core.Long.$unbox(a1)));
            
        }
        
        // dispatcher for method abstract public (Z1)=>U.operator()(a1:Z1):U
        public boolean $apply$Z(final java.lang.Object a1, final x10.rtt.Type t1) {
            return $apply$O(x10.core.Long.$unbox(a1));
            
        }
        
        
    
        
        public boolean $apply$O(final long i) {
            
            //#line 203 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
            final boolean t$36491 = ((i) < (((long)(0L))));
            
            //#line 203 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
            return t$36491;
        }
        
        public $Closure$41() {
             {
                
            }
        }
        
    }
    
    @x10.runtime.impl.java.X10Generated
    final public static class $Closure$42 extends x10.core.Ref implements x10.core.fun.Fun_0_2, x10.serialization.X10JavaSerializable
    {
        public static final x10.rtt.RuntimeType<$Closure$42> $RTT = 
            x10.rtt.StaticFunType.<$Closure$42> make($Closure$42.class,
                                                     new x10.rtt.Type[] {
                                                         x10.rtt.ParameterizedType.make(x10.core.fun.Fun_0_2.$RTT, x10.rtt.Types.LONG, x10.rtt.Types.LONG, x10.rtt.Types.INT)
                                                     });
        
        public x10.rtt.RuntimeType<?> $getRTT() { return $RTT; }
        
        public x10.rtt.Type<?> $getParam(int i) { return null; }
        
        private Object writeReplace() throws java.io.ObjectStreamException {
            return new x10.serialization.SerializationProxy(this);
        }
        
        public static x10.serialization.X10JavaSerializable $_deserialize_body(cassia.util.HeapQueue.$Closure$42 $_obj, x10.serialization.X10JavaDeserializer $deserializer) throws java.io.IOException {
            if (x10.runtime.impl.java.Runtime.TRACE_SER) { x10.runtime.impl.java.Runtime.printTraceMessage("X10JavaSerializable: $_deserialize_body() of " + $Closure$42.class + " calling"); } 
            return $_obj;
        }
        
        public static x10.serialization.X10JavaSerializable $_deserializer(x10.serialization.X10JavaDeserializer $deserializer) throws java.io.IOException {
            cassia.util.HeapQueue.$Closure$42 $_obj = new cassia.util.HeapQueue.$Closure$42((java.lang.System[]) null);
            $deserializer.record_reference($_obj);
            return $_deserialize_body($_obj, $deserializer);
        }
        
        public void $_serialize(x10.serialization.X10JavaSerializer $serializer) throws java.io.IOException {
            
        }
        
        // constructor just for allocation
        public $Closure$42(final java.lang.System[] $dummy) {
            
        }
        
        // dispatcher for method abstract public (Z1,Z2)=>U.operator()(a1:Z1, a2:Z2):U
        public java.lang.Object $apply(final java.lang.Object a1, final x10.rtt.Type t1, final java.lang.Object a2, final x10.rtt.Type t2) {
            return x10.core.Int.$box($apply$O(x10.core.Long.$unbox(a1), x10.core.Long.$unbox(a2)));
            
        }
        
        // dispatcher for method abstract public (Z1,Z2)=>U.operator()(a1:Z1, a2:Z2):U
        public int $apply$I(final java.lang.Object a1, final x10.rtt.Type t1, final java.lang.Object a2, final x10.rtt.Type t2) {
            return $apply$O(x10.core.Long.$unbox(a1), x10.core.Long.$unbox(a2));
            
        }
        
        
    
        
        public int $apply$O(final long x, final long y) {
            
            //#line 208 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
            final long t$36498 = ((x) - (((long)(y))));
            
            //#line 208 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
            final long t$36499 = x10.lang.Math.signum$O((long)(t$36498));
            
            //#line 208 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
            final int t$36500 = ((int)(long)(((long)(t$36499))));
            
            //#line 208 "/home/dsl/workspace/plhamK/cassia/util/HeapQueue.x10"
            return t$36500;
        }
        
        public $Closure$42() {
             {
                
            }
        }
        
    }
    
}

