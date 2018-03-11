package cassia.util;


@x10.runtime.impl.java.X10Generated
public class Chunk<$T> extends x10.util.AbstractCollection<$T> implements cassia.util.RangedList, x10.serialization.X10JavaSerializable
{
    public static final x10.rtt.RuntimeType<Chunk> $RTT = 
        x10.rtt.NamedType.<Chunk> make("cassia.util.Chunk",
                                       Chunk.class,
                                       1,
                                       new x10.rtt.Type[] {
                                           x10.rtt.ParameterizedType.make(cassia.util.RangedList.$RTT, x10.rtt.UnresolvedType.PARAM(0)),
                                           x10.rtt.ParameterizedType.make(x10.util.AbstractCollection.$RTT, x10.rtt.UnresolvedType.PARAM(0))
                                       });
    
    public x10.rtt.RuntimeType<?> $getRTT() { return $RTT; }
    
    public x10.rtt.Type<?> $getParam(int i) { if (i == 0) return $T; return null; }
    
    private Object writeReplace() throws java.io.ObjectStreamException {
        return new x10.serialization.SerializationProxy(this);
    }
    
    public static <$T> x10.serialization.X10JavaSerializable $_deserialize_body(cassia.util.Chunk<$T> $_obj, x10.serialization.X10JavaDeserializer $deserializer) throws java.io.IOException {
        if (x10.runtime.impl.java.Runtime.TRACE_SER) { x10.runtime.impl.java.Runtime.printTraceMessage("X10JavaSerializable: $_deserialize_body() of " + Chunk.class + " calling"); } 
        x10.util.AbstractCollection.$_deserialize_body($_obj, $deserializer);
        $_obj.$T = (x10.rtt.Type) $deserializer.readObject();
        $_obj.a = $deserializer.readObject();
        $_obj.range = $deserializer.readObject();
        return $_obj;
    }
    
    public static x10.serialization.X10JavaSerializable $_deserializer(x10.serialization.X10JavaDeserializer $deserializer) throws java.io.IOException {
        cassia.util.Chunk $_obj = new cassia.util.Chunk((java.lang.System[]) null, (x10.rtt.Type) null);
        $deserializer.record_reference($_obj);
        return $_deserialize_body($_obj, $deserializer);
    }
    
    public void $_serialize(x10.serialization.X10JavaSerializer $serializer) throws java.io.IOException {
        super.$_serialize($serializer);
        $serializer.write(this.$T);
        $serializer.write(this.a);
        $serializer.write(this.range);
        
    }
    
    // constructor just for allocation
    public Chunk(final java.lang.System[] $dummy, final x10.rtt.Type $T) {
        super($dummy, $T);
        cassia.util.Chunk.$initParams(this, $T);
        
    }
    
    // dispatcher for method abstract public x10.util.Container.contains(y:T){}:x10.lang.Boolean
    public java.lang.Object contains(final java.lang.Object a1, final x10.rtt.Type t1) {
        return x10.core.Boolean.$box(contains__0cassia$util$Chunk$$T$O(($T)a1));
        
    }
    
    // dispatcher for method abstract public x10.util.Container.contains(y:T){}:x10.lang.Boolean
    public boolean contains$Z(final java.lang.Object a1, final x10.rtt.Type t1) {
        return contains__0cassia$util$Chunk$$T$O(($T)a1);
        
    }
    
    // dispatcher for method abstract public x10.util.Collection.add(v:T){}:x10.lang.Boolean
    public java.lang.Object add(final java.lang.Object a1, final x10.rtt.Type t1) {
        return x10.core.Boolean.$box(add__0cassia$util$Chunk$$T$O(($T)a1));
        
    }
    
    // dispatcher for method abstract public x10.util.Collection.add(v:T){}:x10.lang.Boolean
    public boolean add$Z(final java.lang.Object a1, final x10.rtt.Type t1) {
        return add__0cassia$util$Chunk$$T$O(($T)a1);
        
    }
    
    // dispatcher for method abstract public x10.util.Collection.remove(v:T){}:x10.lang.Boolean
    public java.lang.Object remove(final java.lang.Object a1, final x10.rtt.Type t1) {
        return x10.core.Boolean.$box(remove__0cassia$util$Chunk$$T$O(($T)a1));
        
    }
    
    // dispatcher for method abstract public x10.util.Collection.remove(v:T){}:x10.lang.Boolean
    public boolean remove$Z(final java.lang.Object a1, final x10.rtt.Type t1) {
        return remove__0cassia$util$Chunk$$T$O(($T)a1);
        
    }
    
    // dispatcher for method abstract public x10.lang.Settable.operator()=(i:I, v:V){}:V
    public java.lang.Object $set(final java.lang.Object a1, final x10.rtt.Type t1, final java.lang.Object a2, final x10.rtt.Type t2) {
        return $set__1cassia$util$Chunk$$T$G(x10.core.Long.$unbox(a1), ($T)a2);
        
    }
    
    // dispatcher for method abstract public x10.util.List.addBefore(i:x10.lang.Long, v:T){}:void
    public java.lang.Object addBefore(final long a1, final java.lang.Object a2, final x10.rtt.Type t2) {
        addBefore__1cassia$util$Chunk$$T(a1, ($T)a2); return null;
        
    }
    
    // dispatcher for method abstract public x10.util.List.addBefore(i:x10.lang.Long, v:T){}:void
    public void addBefore$V(final long a1, final java.lang.Object a2, final x10.rtt.Type t2) {
        addBefore__1cassia$util$Chunk$$T(a1, ($T)a2);
        
    }
    
    // dispatcher for method abstract public (Z1)=>U.operator()(a1:Z1){}:U
    public java.lang.Object $apply(final java.lang.Object a1, final x10.rtt.Type t1) {
        return $apply$G(x10.core.Long.$unbox(a1));
        
    }
    
    // dispatcher for method abstract public x10.util.List.sort(cmp:(T,T)=>x10.lang.Int){}:void
    public java.lang.Object sort(final x10.core.fun.Fun_0_2 a1, final x10.rtt.Type t1) {
        sort__0$1cassia$util$Chunk$$T$3cassia$util$Chunk$$T$3x10$lang$Int$2(a1); return null;
        
    }
    
    // dispatcher for method abstract public x10.util.List.sort(cmp:(T,T)=>x10.lang.Int){}:void
    public void sort$V(final x10.core.fun.Fun_0_2 a1, final x10.rtt.Type t1) {
        sort__0$1cassia$util$Chunk$$T$3cassia$util$Chunk$$T$3x10$lang$Int$2(a1);
        
    }
    
    // dispatcher for method abstract public x10.util.List.indexOf(v:T){}:x10.lang.Long
    public java.lang.Object indexOf(final java.lang.Object a1, final x10.rtt.Type t1) {
        return x10.core.Long.$box(indexOf__0cassia$util$Chunk$$T$O(($T)a1));
        
    }
    
    // dispatcher for method abstract public x10.util.List.indexOf(v:T){}:x10.lang.Long
    public long indexOf$J(final java.lang.Object a1, final x10.rtt.Type t1) {
        return indexOf__0cassia$util$Chunk$$T$O(($T)a1);
        
    }
    
    // dispatcher for method abstract public x10.util.List.indexOf(index:x10.lang.Long, v:T){}:x10.lang.Long
    public java.lang.Object indexOf(final long a1, final java.lang.Object a2, final x10.rtt.Type t2) {
        return x10.core.Long.$box(indexOf__1cassia$util$Chunk$$T$O(a1, ($T)a2));
        
    }
    
    // dispatcher for method abstract public x10.util.List.indexOf(index:x10.lang.Long, v:T){}:x10.lang.Long
    public long indexOf$J(final long a1, final java.lang.Object a2, final x10.rtt.Type t2) {
        return indexOf__1cassia$util$Chunk$$T$O(a1, ($T)a2);
        
    }
    
    // dispatcher for method abstract public x10.util.List.lastIndexOf(v:T){}:x10.lang.Long
    public java.lang.Object lastIndexOf(final java.lang.Object a1, final x10.rtt.Type t1) {
        return x10.core.Long.$box(lastIndexOf__0cassia$util$Chunk$$T$O(($T)a1));
        
    }
    
    // dispatcher for method abstract public x10.util.List.lastIndexOf(v:T){}:x10.lang.Long
    public long lastIndexOf$J(final java.lang.Object a1, final x10.rtt.Type t1) {
        return lastIndexOf__0cassia$util$Chunk$$T$O(($T)a1);
        
    }
    
    // dispatcher for method abstract public x10.util.List.lastIndexOf(index:x10.lang.Long, v:T){}:x10.lang.Long
    public java.lang.Object lastIndexOf(final long a1, final java.lang.Object a2, final x10.rtt.Type t2) {
        return x10.core.Long.$box(lastIndexOf__1cassia$util$Chunk$$T$O(a1, ($T)a2));
        
    }
    
    // dispatcher for method abstract public x10.util.List.lastIndexOf(index:x10.lang.Long, v:T){}:x10.lang.Long
    public long lastIndexOf$J(final long a1, final java.lang.Object a2, final x10.rtt.Type t2) {
        return lastIndexOf__1cassia$util$Chunk$$T$O(a1, ($T)a2);
        
    }
    
    // dispatcher for method abstract public cassia.util.RangedCommon[T].each(op:(T)=>void){}:void
    public java.lang.Object each(final x10.core.fun.VoidFun_0_1 a1, final x10.rtt.Type t1) {
        each__0$1cassia$util$Chunk$$T$2(a1); return null;
        
    }
    
    // dispatcher for method abstract public cassia.util.RangedCommon[T].each(op:(T)=>void){}:void
    public void each$V(final x10.core.fun.VoidFun_0_1 a1, final x10.rtt.Type t1) {
        each__0$1cassia$util$Chunk$$T$2(a1);
        
    }
    
    // dispatcher for method abstract public cassia.util.RangedCommon[T].each(range:x10.lang.LongRange, op:(T)=>void){}:void
    public java.lang.Object each(final x10.lang.LongRange a1, final x10.core.fun.VoidFun_0_1 a2, final x10.rtt.Type t2) {
        each__1$1cassia$util$Chunk$$T$2(a1, a2); return null;
        
    }
    
    // dispatcher for method abstract public cassia.util.RangedCommon[T].each(range:x10.lang.LongRange, op:(T)=>void){}:void
    public void each$V(final x10.lang.LongRange a1, final x10.core.fun.VoidFun_0_1 a2, final x10.rtt.Type t2) {
        each__1$1cassia$util$Chunk$$T$2(a1, a2);
        
    }
    
    // dispatcher for method abstract public x10.util.Collection.addAll(c:x10.util.Container[T]){}:x10.lang.Boolean
    public java.lang.Object addAll(final x10.util.Container a1, final x10.rtt.Type t1) {
        return x10.core.Boolean.$box(addAll__0$1x10$util$AbstractCollection$$T$2$O(a1));
        
    }
    
    // dispatcher for method abstract public x10.util.Collection.addAll(c:x10.util.Container[T]){}:x10.lang.Boolean
    public boolean addAll$Z(final x10.util.Container a1, final x10.rtt.Type t1) {
        return addAll__0$1x10$util$AbstractCollection$$T$2$O(a1);
        
    }
    
    // dispatcher for method abstract public x10.util.Collection.retainAll(c:x10.util.Container[T]){}:x10.lang.Boolean
    public java.lang.Object retainAll(final x10.util.Container a1, final x10.rtt.Type t1) {
        return x10.core.Boolean.$box(retainAll__0$1x10$util$AbstractCollection$$T$2$O(a1));
        
    }
    
    // dispatcher for method abstract public x10.util.Collection.retainAll(c:x10.util.Container[T]){}:x10.lang.Boolean
    public boolean retainAll$Z(final x10.util.Container a1, final x10.rtt.Type t1) {
        return retainAll__0$1x10$util$AbstractCollection$$T$2$O(a1);
        
    }
    
    // dispatcher for method abstract public x10.util.Collection.removeAll(c:x10.util.Container[T]){}:x10.lang.Boolean
    public java.lang.Object removeAll(final x10.util.Container a1, final x10.rtt.Type t1) {
        return x10.core.Boolean.$box(removeAll__0$1x10$util$AbstractCollection$$T$2$O(a1));
        
    }
    
    // dispatcher for method abstract public x10.util.Collection.removeAll(c:x10.util.Container[T]){}:x10.lang.Boolean
    public boolean removeAll$Z(final x10.util.Container a1, final x10.rtt.Type t1) {
        return removeAll__0$1x10$util$AbstractCollection$$T$2$O(a1);
        
    }
    
    // dispatcher for method abstract public x10.util.Collection.addAllWhere(c:x10.util.Container[T], p:(T)=>x10.lang.Boolean){}:x10.lang.Boolean
    public java.lang.Object addAllWhere(final x10.util.Container a1, final x10.rtt.Type t1, final x10.core.fun.Fun_0_1 a2, final x10.rtt.Type t2) {
        return x10.core.Boolean.$box(addAllWhere__0$1x10$util$AbstractCollection$$T$2__1$1x10$util$AbstractCollection$$T$3x10$lang$Boolean$2$O((x10.util.Container)a1, (x10.core.fun.Fun_0_1)a2));
        
    }
    
    // dispatcher for method abstract public x10.util.Collection.addAllWhere(c:x10.util.Container[T], p:(T)=>x10.lang.Boolean){}:x10.lang.Boolean
    public boolean addAllWhere$Z(final x10.util.Container a1, final x10.rtt.Type t1, final x10.core.fun.Fun_0_1 a2, final x10.rtt.Type t2) {
        return addAllWhere__0$1x10$util$AbstractCollection$$T$2__1$1x10$util$AbstractCollection$$T$3x10$lang$Boolean$2$O((x10.util.Container)a1, (x10.core.fun.Fun_0_1)a2);
        
    }
    
    // dispatcher for method abstract public x10.util.Collection.removeAllWhere(p:(T)=>x10.lang.Boolean){}:x10.lang.Boolean
    public java.lang.Object removeAllWhere(final x10.core.fun.Fun_0_1 a1, final x10.rtt.Type t1) {
        return x10.core.Boolean.$box(removeAllWhere__0$1x10$util$AbstractCollection$$T$3x10$lang$Boolean$2$O((x10.core.fun.Fun_0_1)a1));
        
    }
    
    // dispatcher for method abstract public x10.util.Collection.removeAllWhere(p:(T)=>x10.lang.Boolean){}:x10.lang.Boolean
    public boolean removeAllWhere$Z(final x10.core.fun.Fun_0_1 a1, final x10.rtt.Type t1) {
        return removeAllWhere__0$1x10$util$AbstractCollection$$T$3x10$lang$Boolean$2$O((x10.core.fun.Fun_0_1)a1);
        
    }
    
    // dispatcher for method abstract public x10.util.Container.containsAll(c:x10.util.Container[T]){}:x10.lang.Boolean
    public java.lang.Object containsAll(final x10.util.Container a1, final x10.rtt.Type t1) {
        return x10.core.Boolean.$box(containsAll__0$1x10$util$AbstractContainer$$T$2$O((x10.util.Container)a1));
        
    }
    
    // dispatcher for method abstract public x10.util.Container.containsAll(c:x10.util.Container[T]){}:x10.lang.Boolean
    public boolean containsAll$Z(final x10.util.Container a1, final x10.rtt.Type t1) {
        return containsAll__0$1x10$util$AbstractContainer$$T$2$O((x10.util.Container)a1);
        
    }
    
    // bridge for method abstract public x10.util.AbstractContainer.contains(y:T){}:x10.lang.Boolean
    public boolean contains__0x10$util$AbstractContainer$$T$O($T a1) {
        return contains__0cassia$util$Chunk$$T$O(a1);
    }
    
    // bridge for method abstract public x10.util.AbstractCollection.add(v:T){}:x10.lang.Boolean
    public boolean add__0x10$util$AbstractCollection$$T$O($T a1) {
        return add__0cassia$util$Chunk$$T$O(a1);
    }
    
    // bridge for method abstract public x10.util.AbstractCollection.remove(v:T){}:x10.lang.Boolean
    public boolean remove__0x10$util$AbstractCollection$$T$O($T a1) {
        return remove__0cassia$util$Chunk$$T$O(a1);
    }
    
    private x10.rtt.Type $T;
    
    // initializer of type parameters
    public static void $initParams(final Chunk $this, final x10.rtt.Type $T) {
        $this.$T = $T;
        
    }
    // synthetic type for parameter mangling
    public static final class __1cassia$util$Chunk$$T {}
    // synthetic type for parameter mangling
    public static final class __1$1cassia$util$Chunk$$T$2 {}
    

    
    //#line 8 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
    public x10.core.Rail<$T> a;
    
    //#line 9 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
    public x10.lang.LongRange range;
    
    
    //#line 11 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
    public static <$T>cassia.util.Chunk make__0$1cassia$util$Chunk$$T$2__2cassia$util$Chunk$$T(final x10.rtt.Type $T, final x10.util.Container<$T> c, final x10.lang.LongRange range, final $T v) {
        
        //#line 12 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
        final cassia.util.Chunk a = ((cassia.util.Chunk)(new cassia.util.Chunk<$T>((java.lang.System[]) null, $T).cassia$util$Chunk$$init$S(((x10.lang.LongRange)(range)), (($T)(v)), (cassia.util.Chunk.__1cassia$util$Chunk$$T) null)));
        
        //#line 13 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
        ((x10.util.AbstractCollection<$T>)a).addAll__0$1x10$util$AbstractCollection$$T$2$O(((x10.util.Container)(c)));
        
        //#line 14 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
        return a;
    }
    
    
    //#line 16 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
    public static <$T>cassia.util.Chunk make__0$1cassia$util$Chunk$$T$2(final x10.rtt.Type $T, final x10.util.Container<$T> c, final x10.lang.LongRange range) {
        
        //#line 17 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
        final cassia.util.Chunk a = ((cassia.util.Chunk)(new cassia.util.Chunk<$T>((java.lang.System[]) null, $T).cassia$util$Chunk$$init$S(((x10.lang.LongRange)(range)))));
        
        //#line 18 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
        ((x10.util.AbstractCollection<$T>)a).addAll__0$1x10$util$AbstractCollection$$T$2$O(((x10.util.Container)(c)));
        
        //#line 19 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
        return a;
    }
    
    
    //#line 21 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
    public x10.lang.LongRange getRange() {
        
        //#line 21 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
        final x10.lang.LongRange t$37729 = ((x10.lang.LongRange)(this.range));
        
        //#line 21 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
        return t$37729;
    }
    
    
    //#line 22 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
    public boolean contains__0cassia$util$Chunk$$T$O(final $T v) {
        
        //#line 28 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
        final x10.core.Rail rail$37995 = ((x10.core.Rail)(this.a));
        
        //#line 28 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
        final long size$37996 = ((x10.core.Rail<$T>)rail$37995).size;
        
        //#line 28 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
        long idx$37992 = 0L;
        
        //#line 28 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
        for (;
             true;
             ) {
            
            //#line 28 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
            final long t$37993 = idx$37992;
            
            //#line 28 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
            final boolean t$37994 = ((t$37993) < (((long)(size$37996))));
            
            //#line 28 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
            if (!(t$37994)) {
                
                //#line 28 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
                break;
            }
            
            //#line 28 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
            final long t$37988 = idx$37992;
            
            //#line 28 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
            final $T elem$37989 = (($T)(((x10.core.Rail<$T>)rail$37995).$apply$G((long)(t$37988))));
            
            //#line 29 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
            final boolean t$37985 = ((v) == (null));
            
            //#line 29 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
            boolean t$37986 =  false;
            
            //#line 29 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
            if (t$37985) {
                
                //#line 29 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
                t$37986 = ((elem$37989) == (null));
            } else {
                
                //#line 29 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
                t$37986 = ((java.lang.Object)(((java.lang.Object)(v)))).equals(elem$37989);
            }
            
            //#line 29 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
            final boolean t$37987 = t$37986;
            
            //#line 29 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
            if (t$37987) {
                
                //#line 30 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
                return true;
            }
            
            //#line 28 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
            final long t$37990 = idx$37992;
            
            //#line 28 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
            final long t$37991 = ((t$37990) + (((long)(1L))));
            
            //#line 28 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
            idx$37992 = t$37991;
        }
        
        //#line 33 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
        return false;
    }
    
    
    //#line 36 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
    public void clear() {
        
        //#line 37 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
        final java.lang.UnsupportedOperationException t$37739 = ((java.lang.UnsupportedOperationException)(new java.lang.UnsupportedOperationException()));
        
        //#line 37 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
        throw t$37739;
    }
    
    
    //#line 41 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
    public cassia.util.Chunk clone() {
        
        //#line 45 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
        final x10.lang.LongRange t$37740 = ((x10.lang.LongRange)(this.range));
        
        //#line 45 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
        final x10.core.Rail t$37741 = ((x10.core.Rail)(this.a));
        
        //#line 45 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
        final cassia.util.Chunk t$37742 = ((cassia.util.Chunk)(new cassia.util.Chunk<$T>((java.lang.System[]) null, $T).cassia$util$Chunk$$init$S(((x10.lang.LongRange)(t$37740)), ((x10.core.Rail)(t$37741)), (cassia.util.Chunk.__1$1cassia$util$Chunk$$T$2) null)));
        
        //#line 45 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
        return t$37742;
    }
    
    
    //#line 47 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
    public long last$O() {
        
        //#line 49 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
        final x10.lang.LongRange t$37743 = ((x10.lang.LongRange)(this.range));
        
        //#line 49 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
        final long t$37744 = t$37743.max;
        
        //#line 49 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
        return t$37744;
    }
    
    
    //#line 52 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
    public boolean add__0cassia$util$Chunk$$T$O(final $T v) {
        
        //#line 53 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
        final java.lang.UnsupportedOperationException t$37745 = ((java.lang.UnsupportedOperationException)(new java.lang.UnsupportedOperationException()));
        
        //#line 53 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
        throw t$37745;
    }
    
    
    //#line 59 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
    public boolean addAll__0$1cassia$util$Chunk$$T$2$O(final x10.core.Rail elems) {
        
        //#line 60 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
        final java.lang.UnsupportedOperationException t$37746 = ((java.lang.UnsupportedOperationException)(new java.lang.UnsupportedOperationException()));
        
        //#line 60 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
        throw t$37746;
    }
    
    
    //#line 65 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
    public boolean remove__0cassia$util$Chunk$$T$O(final $T v) {
        
        //#line 66 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
        final java.lang.UnsupportedOperationException t$37747 = ((java.lang.UnsupportedOperationException)(new java.lang.UnsupportedOperationException()));
        
        //#line 66 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
        throw t$37747;
    }
    
    
    //#line 68 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
    public $T removeFirst$G() {
        
        //#line 69 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
        final java.lang.UnsupportedOperationException t$37748 = ((java.lang.UnsupportedOperationException)(new java.lang.UnsupportedOperationException()));
        
        //#line 69 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
        throw t$37748;
    }
    
    
    //#line 72 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
    public $T $set__1cassia$util$Chunk$$T$G(final long i, final $T v) {
        
        //#line 72 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
        final $T t$37749 = (($T)(this.set__0cassia$util$Chunk$$T$G((($T)(v)), (long)(i))));
        
        //#line 72 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
        return t$37749;
    }
    
    
    //#line 74 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
    public $T set__0cassia$util$Chunk$$T$G(final $T v, final long i0) {
        
        //#line 75 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
        final x10.lang.LongRange t$37750 = ((x10.lang.LongRange)(this.range));
        
        //#line 75 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
        final long t$37751 = t$37750.min;
        
        //#line 75 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
        final long i = ((i0) - (((long)(t$37751))));
        
        //#line 76 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
        final x10.core.Rail t$37752 = ((x10.core.Rail)(this.a));
        
        //#line 76 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
        ((x10.core.Rail<$T>)t$37752).$set__1x10$lang$Rail$$T$G((long)(i), (($T)(v)));
        
        //#line 77 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
        return v;
    }
    
    
    //#line 79 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
    public cassia.util.RangedList subList(final long fromIndex, final long toIndex) {
        
        //#line 80 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
        final x10.lang.LongRange t$37753 = ((x10.lang.LongRange)(this.range));
        
        //#line 80 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
        final long t$37754 = t$37753.min;
        
        //#line 80 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
        boolean t$37757 = ((fromIndex) <= (((long)(t$37754))));
        
        //#line 80 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
        if (t$37757) {
            
            //#line 80 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
            final x10.lang.LongRange t$37755 = ((x10.lang.LongRange)(this.range));
            
            //#line 80 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
            final long t$37756 = t$37755.max;
            
            //#line 80 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
            t$37757 = ((toIndex) >= (((long)(t$37756))));
        }
        
        //#line 80 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
        final boolean t$37758 = t$37757;
        
        //#line 80 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
        if (t$37758) {
            
            //#line 80 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
            return this;
        }
        
        //#line 81 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
        final x10.lang.LongRange t$37759 = ((x10.lang.LongRange)(new x10.lang.LongRange((java.lang.System[]) null).x10$lang$LongRange$$init$S(((long)(fromIndex)), ((long)(toIndex)))));
        
        //#line 81 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
        final cassia.util.RangedListView t$37760 = ((cassia.util.RangedListView)(new cassia.util.RangedListView<$T>((java.lang.System[]) null, $T).cassia$util$RangedListView$$init$S(((x10.util.List<$T>)(this)), ((x10.lang.LongRange)(t$37759)), (cassia.util.RangedListView.__0$1cassia$util$RangedListView$$T$2) null)));
        
        //#line 81 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
        return t$37760;
    }
    
    
    //#line 83 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
    public void addBefore__1cassia$util$Chunk$$T(final long i0, final $T v) {
        
        //#line 84 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
        final java.lang.UnsupportedOperationException t$37761 = ((java.lang.UnsupportedOperationException)(new java.lang.UnsupportedOperationException()));
        
        //#line 84 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
        throw t$37761;
    }
    
    
    //#line 86 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
    public $T removeAt$G(final long i0) {
        
        //#line 87 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
        final java.lang.UnsupportedOperationException t$37762 = ((java.lang.UnsupportedOperationException)(new java.lang.UnsupportedOperationException()));
        
        //#line 87 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
        throw t$37762;
    }
    
    
    //#line 97 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
    public $T $apply$G(final long i) {
        
        //#line 97 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
        final $T t$37763 = (($T)(this.get$G((long)(i))));
        
        //#line 97 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
        return t$37763;
    }
    
    
    //#line 99 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
    public $T get$G(final long i0) {
        
        //#line 100 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
        final x10.lang.LongRange t$37764 = ((x10.lang.LongRange)(this.range));
        
        //#line 100 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
        final long t$37765 = t$37764.min;
        
        //#line 100 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
        final long i = ((i0) - (((long)(t$37765))));
        
        //#line 101 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
        final x10.core.Rail t$37766 = ((x10.core.Rail)(this.a));
        
        //#line 101 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
        final $T t$37767 = (($T)(((x10.core.Rail<$T>)t$37766).$apply$G((long)(i))));
        
        //#line 101 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
        return t$37767;
    }
    
    
    //#line 104 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
    public long size$O() {
        
        //#line 104 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
        final x10.lang.LongRange t$37768 = ((x10.lang.LongRange)(this.range));
        
        //#line 104 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
        final long t$37770 = t$37768.max;
        
        //#line 104 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
        final x10.lang.LongRange t$37769 = ((x10.lang.LongRange)(this.range));
        
        //#line 104 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
        final long t$37771 = t$37769.min;
        
        //#line 104 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
        final long t$37772 = ((t$37770) - (((long)(t$37771))));
        
        //#line 104 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
        final long t$37773 = ((t$37772) + (((long)(1L))));
        
        //#line 104 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
        return t$37773;
    }
    
    
    //#line 106 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
    public boolean isEmpty$O() {
        
        //#line 106 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
        final x10.core.Rail t$37774 = ((x10.core.Rail)(this.a));
        
        //#line 106 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
        final long t$37775 = ((x10.core.Rail<$T>)t$37774).size;
        
        //#line 106 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
        final boolean t$37776 = ((long) t$37775) == ((long) 0L);
        
        //#line 106 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
        return t$37776;
    }
    
    
    //#line 108 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
    public x10.core.Rail toRail() {
        
        //#line 108 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
        final x10.core.Rail t$37777 = ((x10.core.Rail)(this.a));
        
        //#line 108 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
        return t$37777;
    }
    
    
    //#line 110 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
    // creation method for java code (1-phase java constructor)
    public Chunk(final x10.rtt.Type $T, final x10.lang.LongRange range) {
        this((java.lang.System[]) null, $T);
        cassia$util$Chunk$$init$S(range);
    }
    
    // constructor for non-virtual call
    final public cassia.util.Chunk<$T> cassia$util$Chunk$$init$S(final x10.lang.LongRange range) {
         {
            
            //#line 110 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
            /*super.*/x10$util$AbstractCollection$$init$S();
            
            //#line 110 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
            
            
            //#line 5 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
            this.__fieldInitializers_cassia_util_Chunk();
            
            //#line 111 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
            final long t$37778 = range.max;
            
            //#line 111 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
            final long t$37779 = range.min;
            
            //#line 111 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
            final long t$37780 = ((t$37778) - (((long)(t$37779))));
            
            //#line 111 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
            final long t$37781 = ((t$37780) + (((long)(1L))));
            
            //#line 111 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
            final x10.core.Rail t$37782 = ((x10.core.Rail)(new x10.core.Rail<$T>($T, t$37781)));
            
            //#line 111 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
            ((cassia.util.Chunk<$T>)this).a = ((x10.core.Rail)(t$37782));
            
            //#line 112 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
            ((cassia.util.Chunk<$T>)this).range = ((x10.lang.LongRange)(range));
        }
        return this;
    }
    
    
    
    //#line 114 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
    // creation method for java code (1-phase java constructor)
    public Chunk(final x10.rtt.Type $T, final x10.lang.LongRange range, final $T v, __1cassia$util$Chunk$$T $dummy) {
        this((java.lang.System[]) null, $T);
        cassia$util$Chunk$$init$S(range, v, (cassia.util.Chunk.__1cassia$util$Chunk$$T) null);
    }
    
    // constructor for non-virtual call
    final public cassia.util.Chunk<$T> cassia$util$Chunk$$init$S(final x10.lang.LongRange range, final $T v, __1cassia$util$Chunk$$T $dummy) {
         {
            
            //#line 114 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
            /*super.*/x10$util$AbstractCollection$$init$S();
            
            //#line 114 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
            
            
            //#line 5 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
            this.__fieldInitializers_cassia_util_Chunk();
            
            //#line 115 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
            final long t$37783 = range.max;
            
            //#line 115 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
            final long t$37784 = range.min;
            
            //#line 115 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
            final long t$37785 = ((t$37783) - (((long)(t$37784))));
            
            //#line 115 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
            final long t$37786 = ((t$37785) + (((long)(1L))));
            
            //#line 115 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
            final x10.core.Rail t$37787 = ((x10.core.Rail)(new x10.core.Rail<$T>($T, t$37786, (($T)(v)), (x10.core.Rail.__1x10$lang$Rail$$T) null)));
            
            //#line 115 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
            ((cassia.util.Chunk<$T>)this).a = ((x10.core.Rail)(t$37787));
            
            //#line 116 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
            ((cassia.util.Chunk<$T>)this).range = ((x10.lang.LongRange)(range));
        }
        return this;
    }
    
    
    
    //#line 120 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
    // creation method for java code (1-phase java constructor)
    public Chunk(final x10.rtt.Type $T, final x10.lang.LongRange range, final x10.core.Rail<$T> a, __1$1cassia$util$Chunk$$T$2 $dummy) {
        this((java.lang.System[]) null, $T);
        cassia$util$Chunk$$init$S(range, a, (cassia.util.Chunk.__1$1cassia$util$Chunk$$T$2) null);
    }
    
    // constructor for non-virtual call
    final public cassia.util.Chunk<$T> cassia$util$Chunk$$init$S(final x10.lang.LongRange range, final x10.core.Rail<$T> a, __1$1cassia$util$Chunk$$T$2 $dummy) {
         {
            
            //#line 120 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
            /*super.*/x10$util$AbstractCollection$$init$S();
            
            //#line 120 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
            
            
            //#line 5 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
            this.__fieldInitializers_cassia_util_Chunk();
            
            //#line 121 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
            ((cassia.util.Chunk<$T>)this).range = ((x10.lang.LongRange)(range));
            
            //#line 122 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
            ((cassia.util.Chunk<$T>)this).a = ((x10.core.Rail)(a));
        }
        return this;
    }
    
    
    
    //#line 125 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
    public $T removeLast$G() {
        
        //#line 125 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
        final java.lang.UnsupportedOperationException t$37788 = ((java.lang.UnsupportedOperationException)(new java.lang.UnsupportedOperationException()));
        
        //#line 125 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
        throw t$37788;
    }
    
    
    //#line 126 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
    public void reverse() {
        
        //#line 126 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
        final java.lang.UnsupportedOperationException t$37789 = ((java.lang.UnsupportedOperationException)(new java.lang.UnsupportedOperationException()));
        
        //#line 126 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
        throw t$37789;
    }
    
    
    //#line 127 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
    public void sort() {
        
        //#line 127 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
        final java.lang.UnsupportedOperationException t$37790 = ((java.lang.UnsupportedOperationException)(new java.lang.UnsupportedOperationException()));
        
        //#line 127 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
        throw t$37790;
    }
    
    
    //#line 128 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
    public void sort__0$1cassia$util$Chunk$$T$3cassia$util$Chunk$$T$3x10$lang$Int$2(final x10.core.fun.Fun_0_2 cmp) {
        
        //#line 128 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
        final java.lang.UnsupportedOperationException t$37791 = ((java.lang.UnsupportedOperationException)(new java.lang.UnsupportedOperationException()));
        
        //#line 128 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
        throw t$37791;
    }
    
    
    //#line 129 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
    public $T getFirst$G() {
        
        //#line 129 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
        final x10.lang.LongRange t$37792 = ((x10.lang.LongRange)(this.range));
        
        //#line 129 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
        final long t$37793 = t$37792.min;
        
        //#line 129 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
        final $T t$37794 = (($T)(this.get$G((long)(t$37793))));
        
        //#line 129 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
        return t$37794;
    }
    
    
    //#line 130 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
    public $T getLast$G() {
        
        //#line 130 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
        final x10.lang.LongRange t$37795 = ((x10.lang.LongRange)(this.range));
        
        //#line 130 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
        final long t$37796 = t$37795.max;
        
        //#line 130 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
        final $T t$37797 = (($T)(this.get$G((long)(t$37796))));
        
        //#line 130 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
        return t$37797;
    }
    
    
    //#line 132 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
    public x10.util.List indices() {
        
        //#line 133 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
        final x10.util.ArrayList l = ((x10.util.ArrayList)(new x10.util.ArrayList<x10.core.Long>((java.lang.System[]) null, x10.rtt.Types.LONG).x10$util$ArrayList$$init$S()));
        
        //#line 134 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
        final x10.lang.LongRange i$37657domain$38003 = ((x10.lang.LongRange)(this.range));
        
        //#line 134 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
        final long i$37657min$38004 = i$37657domain$38003.min;
        
        //#line 134 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
        final long i$37657max$38005 = i$37657domain$38003.max;
        
        //#line 134 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
        long i$38000 = i$37657min$38004;
        
        //#line 134 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
        for (;
             true;
             ) {
            
            //#line 134 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
            final long t$38001 = i$38000;
            
            //#line 134 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
            final boolean t$38002 = ((t$38001) <= (((long)(i$37657max$38005))));
            
            //#line 134 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
            if (!(t$38002)) {
                
                //#line 134 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
                break;
            }
            
            //#line 134 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
            final long i$37997 = i$38000;
            
            //#line 135 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
            ((x10.util.ArrayList<x10.core.Long>)l).add__0x10$util$ArrayList$$T$O(x10.core.Long.$box(i$37997));
            
            //#line 134 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
            final long t$37998 = i$38000;
            
            //#line 134 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
            final long t$37999 = ((t$37998) + (((long)(1L))));
            
            //#line 134 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
            i$38000 = t$37999;
        }
        
        //#line 137 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
        return l;
    }
    
    
    //#line 140 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
    public long indexOf__0cassia$util$Chunk$$T$O(final $T v) {
        
        //#line 141 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
        final x10.lang.LongRange t$37803 = ((x10.lang.LongRange)(this.range));
        
        //#line 141 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
        final long t$37804 = t$37803.min;
        
        //#line 141 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
        final long t$37805 = this.indexOf__1cassia$util$Chunk$$T$O((long)(t$37804), (($T)(v)));
        
        //#line 141 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
        return t$37805;
    }
    
    
    //#line 144 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
    public long indexOf__1cassia$util$Chunk$$T$O(final long index, final $T v) {
        
        //#line 145 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
        final x10.lang.LongRange t$38021 = ((x10.lang.LongRange)(this.range));
        
        //#line 145 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
        final long t$38022 = t$38021.min;
        
        //#line 145 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
        long i$38023 = ((index) - (((long)(t$38022))));
        
        //#line 145 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
        for (;
             true;
             ) {
            
            //#line 145 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
            final long t$38024 = i$38023;
            
            //#line 145 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
            final x10.core.Rail t$38025 = ((x10.core.Rail)(this.a));
            
            //#line 145 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
            final long t$38026 = ((x10.core.Rail<$T>)t$38025).size;
            
            //#line 145 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
            final boolean t$38027 = ((t$38024) < (((long)(t$38026))));
            
            //#line 145 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
            if (!(t$38027)) {
                
                //#line 145 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
                break;
            }
            
            //#line 146 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
            final boolean t$38006 = ((v) == (null));
            
            //#line 146 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
            boolean t$38007 =  false;
            
            //#line 146 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
            if (t$38006) {
                
                //#line 146 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
                final x10.core.Rail t$38008 = ((x10.core.Rail)(this.a));
                
                //#line 146 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
                final long t$38009 = i$38023;
                
                //#line 146 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
                final $T t$38010 = (($T)(((x10.core.Rail<$T>)t$38008).$apply$G((long)(t$38009))));
                
                //#line 146 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
                t$38007 = ((t$38010) == (null));
            } else {
                
                //#line 146 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
                final x10.core.Rail t$38011 = ((x10.core.Rail)(this.a));
                
                //#line 146 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
                final long t$38012 = i$38023;
                
                //#line 146 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
                final $T t$38013 = (($T)(((x10.core.Rail<$T>)t$38011).$apply$G((long)(t$38012))));
                
                //#line 146 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
                t$38007 = ((java.lang.Object)(((java.lang.Object)(v)))).equals(t$38013);
            }
            
            //#line 146 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
            final boolean t$38014 = t$38007;
            
            //#line 146 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
            if (t$38014) {
                
                //#line 147 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
                final long t$38015 = i$38023;
                
                //#line 147 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
                final x10.lang.LongRange t$38016 = ((x10.lang.LongRange)(this.range));
                
                //#line 147 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
                final long t$38017 = t$38016.min;
                
                //#line 147 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
                final long t$38018 = ((t$38015) + (((long)(t$38017))));
                
                //#line 147 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
                return t$38018;
            }
            
            //#line 145 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
            final long t$38019 = i$38023;
            
            //#line 145 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
            final long t$38020 = ((t$38019) + (((long)(1L))));
            
            //#line 145 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
            i$38023 = t$38020;
        }
        
        //#line 149 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
        return -1L;
    }
    
    
    //#line 152 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
    public long lastIndexOf__0cassia$util$Chunk$$T$O(final $T v) {
        
        //#line 153 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
        final x10.lang.LongRange t$37828 = ((x10.lang.LongRange)(this.range));
        
        //#line 153 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
        final long t$37829 = t$37828.max;
        
        //#line 153 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
        final long t$37830 = this.lastIndexOf__1cassia$util$Chunk$$T$O((long)(t$37829), (($T)(v)));
        
        //#line 153 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
        return t$37830;
    }
    
    
    //#line 156 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
    public long lastIndexOf__1cassia$util$Chunk$$T$O(final long index, final $T v) {
        
        //#line 157 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
        final x10.lang.LongRange t$38043 = ((x10.lang.LongRange)(this.range));
        
        //#line 157 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
        final long t$38044 = t$38043.min;
        
        //#line 157 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
        long i$38045 = ((index) - (((long)(t$38044))));
        
        //#line 157 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
        for (;
             true;
             ) {
            
            //#line 157 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
            final long t$38046 = i$38045;
            
            //#line 157 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
            final boolean t$38047 = ((t$38046) >= (((long)(0L))));
            
            //#line 157 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
            if (!(t$38047)) {
                
                //#line 157 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
                break;
            }
            
            //#line 158 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
            final boolean t$38028 = ((v) == (null));
            
            //#line 158 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
            boolean t$38029 =  false;
            
            //#line 158 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
            if (t$38028) {
                
                //#line 158 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
                final x10.core.Rail t$38030 = ((x10.core.Rail)(this.a));
                
                //#line 158 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
                final long t$38031 = i$38045;
                
                //#line 158 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
                final $T t$38032 = (($T)(((x10.core.Rail<$T>)t$38030).$apply$G((long)(t$38031))));
                
                //#line 158 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
                t$38029 = ((t$38032) == (null));
            } else {
                
                //#line 158 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
                final x10.core.Rail t$38033 = ((x10.core.Rail)(this.a));
                
                //#line 158 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
                final long t$38034 = i$38045;
                
                //#line 158 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
                final $T t$38035 = (($T)(((x10.core.Rail<$T>)t$38033).$apply$G((long)(t$38034))));
                
                //#line 158 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
                t$38029 = ((java.lang.Object)(((java.lang.Object)(v)))).equals(t$38035);
            }
            
            //#line 158 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
            final boolean t$38036 = t$38029;
            
            //#line 158 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
            if (t$38036) {
                
                //#line 159 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
                final long t$38037 = i$38045;
                
                //#line 159 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
                final x10.lang.LongRange t$38038 = ((x10.lang.LongRange)(this.range));
                
                //#line 159 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
                final long t$38039 = t$38038.min;
                
                //#line 159 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
                final long t$38040 = ((t$38037) + (((long)(t$38039))));
                
                //#line 159 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
                return t$38040;
            }
            
            //#line 157 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
            final long t$38041 = i$38045;
            
            //#line 157 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
            final long t$38042 = ((t$38041) - (((long)(1L))));
            
            //#line 157 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
            i$38045 = t$38042;
        }
        
        //#line 161 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
        return -1L;
    }
    
    
    //#line 169 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
    @x10.runtime.impl.java.X10Generated
    public static class It<$S> extends x10.core.Ref implements x10.util.ListIterator, x10.serialization.X10JavaSerializable
    {
        public static final x10.rtt.RuntimeType<It> $RTT = 
            x10.rtt.NamedType.<It> make("cassia.util.Chunk.It",
                                        It.class,
                                        1,
                                        new x10.rtt.Type[] {
                                            x10.rtt.ParameterizedType.make(x10.util.ListIterator.$RTT, x10.rtt.UnresolvedType.PARAM(0))
                                        });
        
        public x10.rtt.RuntimeType<?> $getRTT() { return $RTT; }
        
        public x10.rtt.Type<?> $getParam(int i) { if (i == 0) return $S; return null; }
        
        private Object writeReplace() throws java.io.ObjectStreamException {
            return new x10.serialization.SerializationProxy(this);
        }
        
        public static <$S> x10.serialization.X10JavaSerializable $_deserialize_body(cassia.util.Chunk.It<$S> $_obj, x10.serialization.X10JavaDeserializer $deserializer) throws java.io.IOException {
            if (x10.runtime.impl.java.Runtime.TRACE_SER) { x10.runtime.impl.java.Runtime.printTraceMessage("X10JavaSerializable: $_deserialize_body() of " + It.class + " calling"); } 
            $_obj.$S = (x10.rtt.Type) $deserializer.readObject();
            $_obj.chunk = $deserializer.readObject();
            $_obj.i = $deserializer.readLong();
            return $_obj;
        }
        
        public static x10.serialization.X10JavaSerializable $_deserializer(x10.serialization.X10JavaDeserializer $deserializer) throws java.io.IOException {
            cassia.util.Chunk.It $_obj = new cassia.util.Chunk.It((java.lang.System[]) null, (x10.rtt.Type) null);
            $deserializer.record_reference($_obj);
            return $_deserialize_body($_obj, $deserializer);
        }
        
        public void $_serialize(x10.serialization.X10JavaSerializer $serializer) throws java.io.IOException {
            $serializer.write(this.$S);
            $serializer.write(this.chunk);
            $serializer.write(this.i);
            
        }
        
        // constructor just for allocation
        public It(final java.lang.System[] $dummy, final x10.rtt.Type $S) {
            cassia.util.Chunk.It.$initParams(this, $S);
            
        }
        
        // dispatcher for method abstract public x10.util.ListIterator.set(v:T){}:void
        public java.lang.Object set(final java.lang.Object a1, final x10.rtt.Type t1) {
            set__0cassia$util$Chunk$It$$S(($S)a1); return null;
            
        }
        
        // dispatcher for method abstract public x10.util.ListIterator.set(v:T){}:void
        public void set$V(final java.lang.Object a1, final x10.rtt.Type t1) {
            set__0cassia$util$Chunk$It$$S(($S)a1);
            
        }
        
        // dispatcher for method abstract public x10.util.ListIterator.add(v:T){}:void
        public java.lang.Object add(final java.lang.Object a1, final x10.rtt.Type t1) {
            add__0cassia$util$Chunk$It$$S(($S)a1); return null;
            
        }
        
        // dispatcher for method abstract public x10.util.ListIterator.add(v:T){}:void
        public void add$V(final java.lang.Object a1, final x10.rtt.Type t1) {
            add__0cassia$util$Chunk$It$$S(($S)a1);
            
        }
        
        private x10.rtt.Type $S;
        
        // initializer of type parameters
        public static void $initParams(final It $this, final x10.rtt.Type $S) {
            $this.$S = $S;
            
        }
        // synthetic type for parameter mangling
        public static final class __0$1cassia$util$Chunk$It$$S$2 {}
        
    
        
        //#line 171 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
        public long i;
        
        //#line 172 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
        public cassia.util.Chunk<$S> chunk;
        
        
        //#line 174 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
        // creation method for java code (1-phase java constructor)
        public It(final x10.rtt.Type $S, final cassia.util.Chunk<$S> chunk, __0$1cassia$util$Chunk$It$$S$2 $dummy) {
            this((java.lang.System[]) null, $S);
            cassia$util$Chunk$It$$init$S(chunk, (cassia.util.Chunk.It.__0$1cassia$util$Chunk$It$$S$2) null);
        }
        
        // constructor for non-virtual call
        final public cassia.util.Chunk.It<$S> cassia$util$Chunk$It$$init$S(final cassia.util.Chunk<$S> chunk, __0$1cassia$util$Chunk$It$$S$2 $dummy) {
             {
                
                //#line 174 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
                
                
                //#line 169 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
                this.__fieldInitializers_cassia_util_Chunk_It();
                
                //#line 175 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
                ((cassia.util.Chunk.It<$S>)this).chunk = ((cassia.util.Chunk)(chunk));
                
                //#line 176 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
                ((cassia.util.Chunk.It<$S>)this).i = -1L;
            }
            return this;
        }
        
        
        
        //#line 179 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
        // creation method for java code (1-phase java constructor)
        public It(final x10.rtt.Type $S, final cassia.util.Chunk<$S> chunk, final long i0, __0$1cassia$util$Chunk$It$$S$2 $dummy) {
            this((java.lang.System[]) null, $S);
            cassia$util$Chunk$It$$init$S(chunk, i0, (cassia.util.Chunk.It.__0$1cassia$util$Chunk$It$$S$2) null);
        }
        
        // constructor for non-virtual call
        final public cassia.util.Chunk.It<$S> cassia$util$Chunk$It$$init$S(final cassia.util.Chunk<$S> chunk, final long i0, __0$1cassia$util$Chunk$It$$S$2 $dummy) {
             {
                
                //#line 179 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
                
                
                //#line 169 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
                this.__fieldInitializers_cassia_util_Chunk_It();
                
                //#line 180 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
                ((cassia.util.Chunk.It<$S>)this).chunk = ((cassia.util.Chunk)(chunk));
                
                //#line 181 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
                final x10.lang.LongRange t$37851 = ((x10.lang.LongRange)(((cassia.util.Chunk<$S>)chunk).range));
                
                //#line 181 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
                final long t$37852 = t$37851.min;
                
                //#line 181 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
                final long t$37853 = ((i0) - (((long)(t$37852))));
                
                //#line 181 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
                final long t$37854 = ((t$37853) - (((long)(1L))));
                
                //#line 181 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
                ((cassia.util.Chunk.It<$S>)this).i = t$37854;
            }
            return this;
        }
        
        
        
        //#line 184 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
        public boolean hasNext$O() {
            
            //#line 185 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
            final long t$37855 = this.i;
            
            //#line 185 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
            final long t$37857 = ((t$37855) + (((long)(1L))));
            
            //#line 185 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
            final cassia.util.Chunk t$37856 = ((cassia.util.Chunk)(this.chunk));
            
            //#line 185 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
            final long t$37858 = ((cassia.util.Chunk<$S>)t$37856).size$O();
            
            //#line 185 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
            final boolean t$37859 = ((t$37857) < (((long)(t$37858))));
            
            //#line 185 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
            return t$37859;
        }
        
        
        //#line 188 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
        public long nextIndex$O() {
            
            //#line 189 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
            final long t$37860 = this.i;
            
            //#line 189 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
            final long t$37861 = ((t$37860) + (((long)(1L))));
            
            //#line 189 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
            final long t$37864 = ((cassia.util.Chunk.It<$S>)this).i = t$37861;
            
            //#line 189 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
            final cassia.util.Chunk t$37862 = ((cassia.util.Chunk)(this.chunk));
            
            //#line 189 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
            final x10.lang.LongRange t$37863 = ((x10.lang.LongRange)(((cassia.util.Chunk<$S>)t$37862).range));
            
            //#line 189 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
            final long t$37865 = t$37863.min;
            
            //#line 189 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
            final long t$37866 = ((t$37864) + (((long)(t$37865))));
            
            //#line 189 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
            return t$37866;
        }
        
        
        //#line 192 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
        public $S next$G() {
            
            //#line 193 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
            final cassia.util.Chunk t$37867 = ((cassia.util.Chunk)(this.chunk));
            
            //#line 193 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
            final x10.core.Rail t$37870 = ((x10.core.Rail)(((cassia.util.Chunk<$S>)t$37867).a));
            
            //#line 193 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
            final long t$37868 = this.i;
            
            //#line 193 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
            final long t$37869 = ((t$37868) + (((long)(1L))));
            
            //#line 193 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
            final long t$37871 = ((cassia.util.Chunk.It<$S>)this).i = t$37869;
            
            //#line 193 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
            final $S t$37872 = (($S)(((x10.core.Rail<$S>)t$37870).$apply$G((long)(t$37871))));
            
            //#line 193 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
            return t$37872;
        }
        
        
        //#line 196 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
        public boolean hasPrevious$O() {
            
            //#line 197 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
            final long t$37873 = this.i;
            
            //#line 197 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
            final long t$37874 = ((t$37873) - (((long)(1L))));
            
            //#line 197 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
            final boolean t$37875 = ((t$37874) >= (((long)(0L))));
            
            //#line 197 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
            return t$37875;
        }
        
        
        //#line 200 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
        public long previousIndex$O() {
            
            //#line 201 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
            final long t$37876 = this.i;
            
            //#line 201 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
            final long t$37877 = ((t$37876) - (((long)(1L))));
            
            //#line 201 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
            final long t$37880 = ((cassia.util.Chunk.It<$S>)this).i = t$37877;
            
            //#line 201 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
            final cassia.util.Chunk t$37878 = ((cassia.util.Chunk)(this.chunk));
            
            //#line 201 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
            final x10.lang.LongRange t$37879 = ((x10.lang.LongRange)(((cassia.util.Chunk<$S>)t$37878).range));
            
            //#line 201 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
            final long t$37881 = t$37879.min;
            
            //#line 201 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
            final long t$37882 = ((t$37880) + (((long)(t$37881))));
            
            //#line 201 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
            return t$37882;
        }
        
        
        //#line 204 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
        public $S previous$G() {
            
            //#line 205 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
            final cassia.util.Chunk t$37883 = ((cassia.util.Chunk)(this.chunk));
            
            //#line 205 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
            final x10.core.Rail t$37886 = ((x10.core.Rail)(((cassia.util.Chunk<$S>)t$37883).a));
            
            //#line 205 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
            final long t$37884 = this.i;
            
            //#line 205 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
            final long t$37885 = ((t$37884) - (((long)(1L))));
            
            //#line 205 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
            final long t$37887 = ((cassia.util.Chunk.It<$S>)this).i = t$37885;
            
            //#line 205 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
            final $S t$37888 = (($S)(((x10.core.Rail<$S>)t$37886).$apply$G((long)(t$37887))));
            
            //#line 205 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
            return t$37888;
        }
        
        
        //#line 208 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
        public void remove() {
            
            //#line 209 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
            final cassia.util.Chunk t$37889 = ((cassia.util.Chunk)(this.chunk));
            
            //#line 209 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
            final long t$37890 = this.i;
            
            //#line 209 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
            ((cassia.util.Chunk<$S>)t$37889).removeAt$G((long)(t$37890));
        }
        
        
        //#line 212 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
        public void set__0cassia$util$Chunk$It$$S(final $S v) {
            
            //#line 213 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
            final cassia.util.Chunk t$37891 = ((cassia.util.Chunk)(this.chunk));
            
            //#line 213 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
            final long t$37892 = this.i;
            
            //#line 213 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
            ((cassia.util.Chunk<$S>)t$37891).set__0cassia$util$Chunk$$T$G((($S)(v)), (long)(t$37892));
        }
        
        
        //#line 216 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
        public void add__0cassia$util$Chunk$It$$S(final $S v) {
            
            //#line 217 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
            final boolean t$37894 = this.hasNext$O();
            
            //#line 217 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
            if (t$37894) {
                
                //#line 217 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
                final java.lang.UnsupportedOperationException t$37893 = ((java.lang.UnsupportedOperationException)(new java.lang.UnsupportedOperationException("Iterator of Chunk only support add at last.")));
                
                //#line 217 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
                throw t$37893;
            }
            
            //#line 218 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
            final cassia.util.Chunk t$37895 = ((cassia.util.Chunk)(this.chunk));
            
            //#line 218 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
            ((cassia.util.Chunk<$S>)t$37895).add__0cassia$util$Chunk$$T$O((($S)(v)));
        }
        
        
        //#line 169 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
        final public cassia.util.Chunk.It cassia$util$Chunk$It$$this$cassia$util$Chunk$It() {
            
            //#line 169 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
            return cassia.util.Chunk.It.this;
        }
        
        
        //#line 169 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
        final public void __fieldInitializers_cassia_util_Chunk_It() {
            
            //#line 169 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
            ((cassia.util.Chunk.It<$S>)this).i = 0L;
        }
    }
    
    
    
    //#line 222 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
    public x10.util.ListIterator iterator() {
        
        //#line 223 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
        final cassia.util.Chunk.It t$37896 = ((cassia.util.Chunk.It)(new cassia.util.Chunk.It<$T>((java.lang.System[]) null, $T).cassia$util$Chunk$It$$init$S(((cassia.util.Chunk<$T>)(this)), (cassia.util.Chunk.It.__0$1cassia$util$Chunk$It$$S$2) null)));
        
        //#line 223 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
        return t$37896;
    }
    
    
    //#line 226 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
    public x10.util.ListIterator iteratorFrom(final long i) {
        
        //#line 227 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
        final cassia.util.Chunk.It t$37897 = ((cassia.util.Chunk.It)(new cassia.util.Chunk.It<$T>((java.lang.System[]) null, $T).cassia$util$Chunk$It$$init$S(((cassia.util.Chunk<$T>)(this)), ((long)(i)), (cassia.util.Chunk.It.__0$1cassia$util$Chunk$It$$S$2) null)));
        
        //#line 227 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
        return t$37897;
    }
    
    
    //#line 230 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
    public void each__0$1cassia$util$Chunk$$T$2(final x10.core.fun.VoidFun_0_1 op) {
        
        //#line 231 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
        final x10.lang.LongRange t$37898 = ((x10.lang.LongRange)(this.range));
        
        //#line 231 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
        this.each__1$1cassia$util$Chunk$$T$2(((x10.lang.LongRange)(t$37898)), ((x10.core.fun.VoidFun_0_1)(op)));
    }
    
    
    //#line 233 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
    public void each__1$1cassia$util$Chunk$$T$2(final x10.lang.LongRange range, final x10.core.fun.VoidFun_0_1 op) {
        
        //#line 234 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
        final long t$37900 = range.min;
        
        //#line 234 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
        final x10.lang.LongRange t$37899 = ((x10.lang.LongRange)(this.range));
        
        //#line 234 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
        final long t$37901 = t$37899.min;
        
        //#line 234 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
        final long t$37902 = java.lang.Math.max(((long)(t$37900)),((long)(t$37901)));
        
        //#line 234 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
        final long t$37903 = range.min;
        
        //#line 234 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
        final long from = ((t$37902) - (((long)(t$37903))));
        
        //#line 235 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
        final long t$37905 = range.max;
        
        //#line 235 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
        final x10.lang.LongRange t$37904 = ((x10.lang.LongRange)(this.range));
        
        //#line 235 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
        final long t$37906 = t$37904.max;
        
        //#line 235 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
        final long t$37907 = java.lang.Math.min(((long)(t$37905)),((long)(t$37906)));
        
        //#line 235 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
        final long t$37908 = range.min;
        
        //#line 235 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
        final long to = ((t$37907) - (((long)(t$37908))));
        
        //#line 236 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
        final long i$37676min$38056 = from;
        
        //#line 236 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
        final long i$37676max$38057 = ((to) - (((long)(1L))));
        
        //#line 236 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
        long i$38053 = i$37676min$38056;
        
        //#line 236 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
        for (;
             true;
             ) {
            
            //#line 236 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
            final long t$38054 = i$38053;
            
            //#line 236 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
            final boolean t$38055 = ((t$38054) <= (((long)(i$37676max$38057))));
            
            //#line 236 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
            if (!(t$38055)) {
                
                //#line 236 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
                break;
            }
            
            //#line 236 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
            final long i$38050 = i$38053;
            
            //#line 236 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
            final x10.core.Rail t$38048 = ((x10.core.Rail)(this.a));
            
            //#line 236 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
            final $T t$38049 = (($T)(((x10.core.Rail<$T>)t$38048).$apply$G((long)(i$38050))));
            
            //#line 236 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
            ((x10.core.fun.VoidFun_0_1<$T>)op).$apply(t$38049, $T);
            
            //#line 236 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
            final long t$38051 = i$38053;
            
            //#line 236 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
            final long t$38052 = ((t$38051) + (((long)(1L))));
            
            //#line 236 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
            i$38053 = t$38052;
        }
    }
    
    
    //#line 239 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
    public <$U>void each__0$1cassia$util$Chunk$$T$3cassia$util$Receiver$1cassia$util$Chunk$$U$2$2__1$1cassia$util$Chunk$$U$2(final x10.rtt.Type $U, final x10.core.fun.VoidFun_0_2 op, final cassia.util.Receiver receiver) {
        
        //#line 240 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
        final x10.lang.LongRange t$37916 = ((x10.lang.LongRange)(this.range));
        
        //#line 240 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
        this.<$U> each__1$1cassia$util$Chunk$$T$3cassia$util$Receiver$1cassia$util$Chunk$$U$2$2__2$1cassia$util$Chunk$$U$2($U, ((x10.lang.LongRange)(t$37916)), ((x10.core.fun.VoidFun_0_2)(op)), ((cassia.util.Receiver)(receiver)));
    }
    
    
    //#line 242 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
    public <$U>void each__1$1cassia$util$Chunk$$T$3cassia$util$Receiver$1cassia$util$Chunk$$U$2$2__2$1cassia$util$Chunk$$U$2(final x10.rtt.Type $U, final x10.lang.LongRange range, final x10.core.fun.VoidFun_0_2 op, final cassia.util.Receiver receiver) {
        
        //#line 243 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
        final long t$37918 = range.min;
        
        //#line 243 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
        final x10.lang.LongRange t$37917 = ((x10.lang.LongRange)(this.range));
        
        //#line 243 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
        final long t$37919 = t$37917.min;
        
        //#line 243 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
        final long t$37920 = java.lang.Math.max(((long)(t$37918)),((long)(t$37919)));
        
        //#line 243 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
        final long t$37921 = range.min;
        
        //#line 243 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
        final long from = ((t$37920) - (((long)(t$37921))));
        
        //#line 244 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
        final long t$37923 = range.max;
        
        //#line 244 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
        final x10.lang.LongRange t$37922 = ((x10.lang.LongRange)(this.range));
        
        //#line 244 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
        final long t$37924 = t$37922.max;
        
        //#line 244 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
        final long t$37925 = java.lang.Math.min(((long)(t$37923)),((long)(t$37924)));
        
        //#line 244 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
        final long t$37926 = range.min;
        
        //#line 244 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
        final long to = ((t$37925) - (((long)(t$37926))));
        
        //#line 245 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
        final long i$37694min$38066 = from;
        
        //#line 245 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
        final long i$37694max$38067 = ((to) - (((long)(1L))));
        
        //#line 245 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
        long i$38063 = i$37694min$38066;
        
        //#line 245 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
        for (;
             true;
             ) {
            
            //#line 245 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
            final long t$38064 = i$38063;
            
            //#line 245 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
            final boolean t$38065 = ((t$38064) <= (((long)(i$37694max$38067))));
            
            //#line 245 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
            if (!(t$38065)) {
                
                //#line 245 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
                break;
            }
            
            //#line 245 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
            final long i$38060 = i$38063;
            
            //#line 245 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
            final x10.core.Rail t$38058 = ((x10.core.Rail)(this.a));
            
            //#line 245 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
            final $T t$38059 = (($T)(((x10.core.Rail<$T>)t$38058).$apply$G((long)(i$38060))));
            
            //#line 245 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
            ((x10.core.fun.VoidFun_0_2<$T,cassia.util.Receiver<$U>>)op).$apply(t$38059, $T, receiver, x10.rtt.ParameterizedType.make(cassia.util.Receiver.$RTT, $U));
            
            //#line 245 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
            final long t$38061 = i$38063;
            
            //#line 245 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
            final long t$38062 = ((t$38061) + (((long)(1L))));
            
            //#line 245 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
            i$38063 = t$38062;
        }
    }
    
    
    //#line 255 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
    /**
     * Return the string representation of this Chunk.
     * 
     * @return the string representation of this Chunk.
     */
    public java.lang.String toString() {
        
        //#line 256 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
        final x10.util.StringBuilder sb = ((x10.util.StringBuilder)(new x10.util.StringBuilder((java.lang.System[]) null).x10$util$StringBuilder$$init$S()));
        
        //#line 257 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
        final x10.lang.LongRange t$37934 = ((x10.lang.LongRange)(this.range));
        
        //#line 257 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
        final java.lang.String t$37935 = (("[") + (t$37934));
        
        //#line 257 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
        final java.lang.String t$37936 = ((t$37935) + (":"));
        
        //#line 257 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
        sb.add(((java.lang.String)(t$37936)));
        
        //#line 258 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
        final long t$37937 = this.size$O();
        
        //#line 258 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
        final long sz = java.lang.Math.min(((long)(t$37937)),((long)(10L)));
        
        //#line 259 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
        long i$38076 = 0L;
        
        //#line 259 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
        for (;
             true;
             ) {
            
            //#line 259 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
            final long t$38077 = i$38076;
            
            //#line 259 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
            final boolean t$38078 = ((t$38077) < (((long)(sz))));
            
            //#line 259 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
            if (!(t$38078)) {
                
                //#line 259 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
                break;
            }
            
            //#line 260 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
            final long t$38068 = i$38076;
            
            //#line 260 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
            final boolean t$38069 = ((t$38068) > (((long)(0L))));
            
            //#line 260 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
            if (t$38069) {
                
                //#line 260 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
                sb.add(((java.lang.String)(",")));
            }
            
            //#line 261 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
            final x10.core.Rail t$38070 = ((x10.core.Rail)(this.a));
            
            //#line 261 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
            final long t$38071 = i$38076;
            
            //#line 261 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
            final $T t$38072 = (($T)(((x10.core.Rail<$T>)t$38070).$apply$G((long)(t$38071))));
            
            //#line 261 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
            final java.lang.String t$38073 = (("") + (t$38072));
            
            //#line 261 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
            sb.add(((java.lang.String)(t$38073)));
            
            //#line 259 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
            final long t$38074 = i$38076;
            
            //#line 259 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
            final long t$38075 = ((t$38074) + (((long)(1L))));
            
            //#line 259 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
            i$38076 = t$38075;
        }
        
        //#line 263 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
        final long t$37949 = this.size$O();
        
        //#line 263 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
        final boolean t$37954 = ((sz) < (((long)(t$37949))));
        
        //#line 263 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
        if (t$37954) {
            
            //#line 263 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
            final long t$37950 = this.size$O();
            
            //#line 263 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
            final long t$37951 = ((t$37950) - (((long)(sz))));
            
            //#line 263 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
            final java.lang.String t$37952 = (("...(omitted ") + ((x10.core.Long.$box(t$37951))));
            
            //#line 263 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
            final java.lang.String t$37953 = ((t$37952) + (" elements)"));
            
            //#line 263 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
            sb.add(((java.lang.String)(t$37953)));
        }
        
        //#line 264 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
        final x10.lang.LongRange t$37955 = ((x10.lang.LongRange)(this.range));
        
        //#line 264 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
        final long t$37956 = t$37955.min;
        
        //#line 264 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
        final java.lang.String t$37957 = (("@") + ((x10.core.Long.$box(t$37956))));
        
        //#line 264 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
        final java.lang.String t$37958 = ((t$37957) + (".."));
        
        //#line 264 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
        final long t$37959 = this.last$O();
        
        //#line 264 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
        final java.lang.String t$37960 = ((t$37958) + ((x10.core.Long.$box(t$37959))));
        
        //#line 264 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
        final java.lang.String t$37961 = ((t$37960) + ("]"));
        
        //#line 264 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
        sb.add(((java.lang.String)(t$37961)));
        
        //#line 265 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
        final java.lang.String t$37962 = sb.toString();
        
        //#line 265 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
        return t$37962;
    }
    
    
    //#line 268 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
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
            Chunk.main(args);
        }
    }
    
    // the original app-main method
    public static void main(final x10.core.Rail<java.lang.String> args) {
        
        //#line 269 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
        final long i = 5L;
        
        //#line 270 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
        final long t$37964 = 50L;
        
        //#line 270 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
        final long t$37963 = 55L;
        
        //#line 270 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
        final long t$37965 = 54L;
        
        //#line 270 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
        final x10.lang.LongRange t$37966 = ((x10.lang.LongRange)(new x10.lang.LongRange((java.lang.System[]) null).x10$lang$LongRange$$init$S(((long)(t$37964)), ((long)(t$37965)))));
        
        //#line 270 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
        final cassia.util.Chunk c = ((cassia.util.Chunk)(new cassia.util.Chunk<x10.core.Long>((java.lang.System[]) null, x10.rtt.Types.LONG).cassia$util$Chunk$$init$S(t$37966)));
        
        //#line 271 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
        final x10.io.Printer t$37967 = ((x10.io.Printer)(x10.io.Console.get$OUT()));
        
        //#line 271 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
        final java.lang.String t$37968 = (("prepare:") + (c));
        
        //#line 271 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
        t$37967.println(((java.lang.Object)(t$37968)));
        
        //#line 272 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
        final long i$37712min$38094 = 0L;
        
        //#line 272 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
        final long i$37712max$38095 = 4L;
        
        //#line 272 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
        long i$38091 = i$37712min$38094;
        
        //#line 272 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
        for (;
             true;
             ) {
            
            //#line 272 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
            final long t$38092 = i$38091;
            
            //#line 272 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
            final boolean t$38093 = ((t$38092) <= (((long)(i$37712max$38095))));
            
            //#line 272 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
            if (!(t$38093)) {
                
                //#line 272 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
                break;
            }
            
            //#line 272 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
            final long j$38088 = i$38091;
            
            //#line 273 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
            final x10.io.Printer t$38079 = ((x10.io.Printer)(x10.io.Console.get$OUT()));
            
            //#line 273 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
            final long t$38080 = 50L;
            
            //#line 273 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
            final long t$38081 = ((t$38080) + (((long)(j$38088))));
            
            //#line 273 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
            final java.lang.String t$38082 = (("set@") + ((x10.core.Long.$box(t$38081))));
            
            //#line 273 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
            t$38079.println(((java.lang.Object)(t$38082)));
            
            //#line 274 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
            final long t$38083 = 50L;
            
            //#line 274 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
            final long t$38084 = ((t$38083) + (((long)(j$38088))));
            
            //#line 274 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
            final long t$38085 = 500L;
            
            //#line 274 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
            final long t$38086 = ((10L) * (((long)(j$38088))));
            
            //#line 274 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
            final long t$38087 = ((t$38085) + (((long)(t$38086))));
            
            //#line 274 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
            ((cassia.util.Chunk<x10.core.Long>)c).$set__1cassia$util$Chunk$$T$G((long)(t$38084), x10.core.Long.$box(t$38087));
            
            //#line 272 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
            final long t$38089 = i$38091;
            
            //#line 272 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
            final long t$38090 = ((t$38089) + (((long)(1L))));
            
            //#line 272 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
            i$38091 = t$38090;
        }
        
        //#line 276 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
        final x10.io.Printer t$37983 = ((x10.io.Printer)(x10.io.Console.get$OUT()));
        
        //#line 276 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
        final java.lang.String t$37984 = ((":") + (c));
        
        //#line 276 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
        t$37983.println(((java.lang.Object)(t$37984)));
    }
    
    
    //#line 5 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
    final public cassia.util.Chunk cassia$util$Chunk$$this$cassia$util$Chunk() {
        
        //#line 5 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
        return cassia.util.Chunk.this;
    }
    
    
    //#line 5 "/home/dsl/workspace/plhamK/cassia/util/Chunk.x10"
    final public void __fieldInitializers_cassia_util_Chunk() {
        
    }
}

