package cassia.util;


@x10.runtime.impl.java.X10Generated
public class RangedListView<$T> extends x10.core.Ref implements cassia.util.RangedList, x10.serialization.X10JavaSerializable
{
    public static final x10.rtt.RuntimeType<RangedListView> $RTT = 
        x10.rtt.NamedType.<RangedListView> make("cassia.util.RangedListView",
                                                RangedListView.class,
                                                1,
                                                new x10.rtt.Type[] {
                                                    x10.rtt.ParameterizedType.make(cassia.util.RangedList.$RTT, x10.rtt.UnresolvedType.PARAM(0))
                                                });
    
    public x10.rtt.RuntimeType<?> $getRTT() { return $RTT; }
    
    public x10.rtt.Type<?> $getParam(int i) { if (i == 0) return $T; return null; }
    
    private Object writeReplace() throws java.io.ObjectStreamException {
        return new x10.serialization.SerializationProxy(this);
    }
    
    public static <$T> x10.serialization.X10JavaSerializable $_deserialize_body(cassia.util.RangedListView<$T> $_obj, x10.serialization.X10JavaDeserializer $deserializer) throws java.io.IOException {
        if (x10.runtime.impl.java.Runtime.TRACE_SER) { x10.runtime.impl.java.Runtime.printTraceMessage("X10JavaSerializable: $_deserialize_body() of " + RangedListView.class + " calling"); } 
        $_obj.$T = (x10.rtt.Type) $deserializer.readObject();
        $_obj.base = $deserializer.readObject();
        $_obj.range = $deserializer.readObject();
        return $_obj;
    }
    
    public static x10.serialization.X10JavaSerializable $_deserializer(x10.serialization.X10JavaDeserializer $deserializer) throws java.io.IOException {
        cassia.util.RangedListView $_obj = new cassia.util.RangedListView((java.lang.System[]) null, (x10.rtt.Type) null);
        $deserializer.record_reference($_obj);
        return $_deserialize_body($_obj, $deserializer);
    }
    
    public void $_serialize(x10.serialization.X10JavaSerializer $serializer) throws java.io.IOException {
        $serializer.write(this.$T);
        $serializer.write(this.base);
        $serializer.write(this.range);
        
    }
    
    // constructor just for allocation
    public RangedListView(final java.lang.System[] $dummy, final x10.rtt.Type $T) {
        cassia.util.RangedListView.$initParams(this, $T);
        
    }
    
    // dispatcher for method abstract public x10.util.Container.contains(y:T){}:x10.lang.Boolean
    public java.lang.Object contains(final java.lang.Object a1, final x10.rtt.Type t1) {
        return x10.core.Boolean.$box(contains__0cassia$util$RangedListView$$T$O(($T)a1));
        
    }
    
    // dispatcher for method abstract public x10.util.Container.contains(y:T){}:x10.lang.Boolean
    public boolean contains$Z(final java.lang.Object a1, final x10.rtt.Type t1) {
        return contains__0cassia$util$RangedListView$$T$O(($T)a1);
        
    }
    
    // dispatcher for method abstract public x10.util.Container.containsAll(c:x10.util.Container[T]){}:x10.lang.Boolean
    public java.lang.Object containsAll(final x10.util.Container a1, final x10.rtt.Type t1) {
        return x10.core.Boolean.$box(containsAll__0$1cassia$util$RangedListView$$T$2$O(a1));
        
    }
    
    // dispatcher for method abstract public x10.util.Container.containsAll(c:x10.util.Container[T]){}:x10.lang.Boolean
    public boolean containsAll$Z(final x10.util.Container a1, final x10.rtt.Type t1) {
        return containsAll__0$1cassia$util$RangedListView$$T$2$O(a1);
        
    }
    
    // dispatcher for method abstract public x10.util.List.indexOf(v:T){}:x10.lang.Long
    public java.lang.Object indexOf(final java.lang.Object a1, final x10.rtt.Type t1) {
        return x10.core.Long.$box(indexOf__0cassia$util$RangedListView$$T$O(($T)a1));
        
    }
    
    // dispatcher for method abstract public x10.util.List.indexOf(v:T){}:x10.lang.Long
    public long indexOf$J(final java.lang.Object a1, final x10.rtt.Type t1) {
        return indexOf__0cassia$util$RangedListView$$T$O(($T)a1);
        
    }
    
    // dispatcher for method abstract public x10.util.List.indexOf(index:x10.lang.Long, v:T){}:x10.lang.Long
    public java.lang.Object indexOf(final long a1, final java.lang.Object a2, final x10.rtt.Type t2) {
        return x10.core.Long.$box(indexOf__1cassia$util$RangedListView$$T$O(a1, ($T)a2));
        
    }
    
    // dispatcher for method abstract public x10.util.List.indexOf(index:x10.lang.Long, v:T){}:x10.lang.Long
    public long indexOf$J(final long a1, final java.lang.Object a2, final x10.rtt.Type t2) {
        return indexOf__1cassia$util$RangedListView$$T$O(a1, ($T)a2);
        
    }
    
    // dispatcher for method abstract public x10.util.List.lastIndexOf(v:T){}:x10.lang.Long
    public java.lang.Object lastIndexOf(final java.lang.Object a1, final x10.rtt.Type t1) {
        return x10.core.Long.$box(lastIndexOf__0cassia$util$RangedListView$$T$O(($T)a1));
        
    }
    
    // dispatcher for method abstract public x10.util.List.lastIndexOf(v:T){}:x10.lang.Long
    public long lastIndexOf$J(final java.lang.Object a1, final x10.rtt.Type t1) {
        return lastIndexOf__0cassia$util$RangedListView$$T$O(($T)a1);
        
    }
    
    // dispatcher for method abstract public x10.util.List.lastIndexOf(index:x10.lang.Long, v:T){}:x10.lang.Long
    public java.lang.Object lastIndexOf(final long a1, final java.lang.Object a2, final x10.rtt.Type t2) {
        return x10.core.Long.$box(lastIndexOf__1cassia$util$RangedListView$$T$O(a1, ($T)a2));
        
    }
    
    // dispatcher for method abstract public x10.util.List.lastIndexOf(index:x10.lang.Long, v:T){}:x10.lang.Long
    public long lastIndexOf$J(final long a1, final java.lang.Object a2, final x10.rtt.Type t2) {
        return lastIndexOf__1cassia$util$RangedListView$$T$O(a1, ($T)a2);
        
    }
    
    // dispatcher for method abstract public x10.util.Collection.add(v:T){}:x10.lang.Boolean
    public java.lang.Object add(final java.lang.Object a1, final x10.rtt.Type t1) {
        return x10.core.Boolean.$box(add__0cassia$util$RangedListView$$T$O(($T)a1));
        
    }
    
    // dispatcher for method abstract public x10.util.Collection.add(v:T){}:x10.lang.Boolean
    public boolean add$Z(final java.lang.Object a1, final x10.rtt.Type t1) {
        return add__0cassia$util$RangedListView$$T$O(($T)a1);
        
    }
    
    // dispatcher for method abstract public x10.util.List.addBefore(i:x10.lang.Long, v:T){}:void
    public java.lang.Object addBefore(final long a1, final java.lang.Object a2, final x10.rtt.Type t2) {
        addBefore__1cassia$util$RangedListView$$T(a1, ($T)a2); return null;
        
    }
    
    // dispatcher for method abstract public x10.util.List.addBefore(i:x10.lang.Long, v:T){}:void
    public void addBefore$V(final long a1, final java.lang.Object a2, final x10.rtt.Type t2) {
        addBefore__1cassia$util$RangedListView$$T(a1, ($T)a2);
        
    }
    
    // dispatcher for method abstract public x10.util.Collection.addAll(c:x10.util.Container[T]){}:x10.lang.Boolean
    public java.lang.Object addAll(final x10.util.Container a1, final x10.rtt.Type t1) {
        return x10.core.Boolean.$box(addAll__0$1cassia$util$RangedListView$$T$2$O(a1));
        
    }
    
    // dispatcher for method abstract public x10.util.Collection.addAll(c:x10.util.Container[T]){}:x10.lang.Boolean
    public boolean addAll$Z(final x10.util.Container a1, final x10.rtt.Type t1) {
        return addAll__0$1cassia$util$RangedListView$$T$2$O(a1);
        
    }
    
    // dispatcher for method abstract public x10.util.Collection.remove(v:T){}:x10.lang.Boolean
    public java.lang.Object remove(final java.lang.Object a1, final x10.rtt.Type t1) {
        return x10.core.Boolean.$box(remove__0cassia$util$RangedListView$$T$O(($T)a1));
        
    }
    
    // dispatcher for method abstract public x10.util.Collection.remove(v:T){}:x10.lang.Boolean
    public boolean remove$Z(final java.lang.Object a1, final x10.rtt.Type t1) {
        return remove__0cassia$util$RangedListView$$T$O(($T)a1);
        
    }
    
    // dispatcher for method abstract public x10.util.Collection.retainAll(c:x10.util.Container[T]){}:x10.lang.Boolean
    public java.lang.Object retainAll(final x10.util.Container a1, final x10.rtt.Type t1) {
        return x10.core.Boolean.$box(retainAll__0$1cassia$util$RangedListView$$T$2$O(a1));
        
    }
    
    // dispatcher for method abstract public x10.util.Collection.retainAll(c:x10.util.Container[T]){}:x10.lang.Boolean
    public boolean retainAll$Z(final x10.util.Container a1, final x10.rtt.Type t1) {
        return retainAll__0$1cassia$util$RangedListView$$T$2$O(a1);
        
    }
    
    // dispatcher for method abstract public x10.util.Collection.removeAll(c:x10.util.Container[T]){}:x10.lang.Boolean
    public java.lang.Object removeAll(final x10.util.Container a1, final x10.rtt.Type t1) {
        return x10.core.Boolean.$box(removeAll__0$1cassia$util$RangedListView$$T$2$O(a1));
        
    }
    
    // dispatcher for method abstract public x10.util.Collection.removeAll(c:x10.util.Container[T]){}:x10.lang.Boolean
    public boolean removeAll$Z(final x10.util.Container a1, final x10.rtt.Type t1) {
        return removeAll__0$1cassia$util$RangedListView$$T$2$O(a1);
        
    }
    
    // dispatcher for method abstract public x10.util.Collection.addAllWhere(c:x10.util.Container[T], p:(T)=>x10.lang.Boolean){}:x10.lang.Boolean
    public java.lang.Object addAllWhere(final x10.util.Container a1, final x10.rtt.Type t1, final x10.core.fun.Fun_0_1 a2, final x10.rtt.Type t2) {
        return x10.core.Boolean.$box(addAllWhere__0$1cassia$util$RangedListView$$T$2__1$1cassia$util$RangedListView$$T$3x10$lang$Boolean$2$O(a1, a2));
        
    }
    
    // dispatcher for method abstract public x10.util.Collection.addAllWhere(c:x10.util.Container[T], p:(T)=>x10.lang.Boolean){}:x10.lang.Boolean
    public boolean addAllWhere$Z(final x10.util.Container a1, final x10.rtt.Type t1, final x10.core.fun.Fun_0_1 a2, final x10.rtt.Type t2) {
        return addAllWhere__0$1cassia$util$RangedListView$$T$2__1$1cassia$util$RangedListView$$T$3x10$lang$Boolean$2$O(a1, a2);
        
    }
    
    // dispatcher for method abstract public x10.util.Collection.removeAllWhere(p:(T)=>x10.lang.Boolean){}:x10.lang.Boolean
    public java.lang.Object removeAllWhere(final x10.core.fun.Fun_0_1 a1, final x10.rtt.Type t1) {
        return x10.core.Boolean.$box(removeAllWhere__0$1cassia$util$RangedListView$$T$3x10$lang$Boolean$2$O(a1));
        
    }
    
    // dispatcher for method abstract public x10.util.Collection.removeAllWhere(p:(T)=>x10.lang.Boolean){}:x10.lang.Boolean
    public boolean removeAllWhere$Z(final x10.core.fun.Fun_0_1 a1, final x10.rtt.Type t1) {
        return removeAllWhere__0$1cassia$util$RangedListView$$T$3x10$lang$Boolean$2$O(a1);
        
    }
    
    // dispatcher for method abstract public (Z1)=>U.operator()(a1:Z1){}:U
    public java.lang.Object $apply(final java.lang.Object a1, final x10.rtt.Type t1) {
        return $apply$G(x10.core.Long.$unbox(a1));
        
    }
    
    // dispatcher for method abstract public x10.lang.Settable.operator()=(i:I, v:V){}:V
    public java.lang.Object $set(final java.lang.Object a1, final x10.rtt.Type t1, final java.lang.Object a2, final x10.rtt.Type t2) {
        return $set__1cassia$util$RangedListView$$T$G(x10.core.Long.$unbox(a1), ($T)a2);
        
    }
    
    // dispatcher for method abstract public x10.util.List.sort(cmp:(T,T)=>x10.lang.Int){}:void
    public java.lang.Object sort(final x10.core.fun.Fun_0_2 a1, final x10.rtt.Type t1) {
        sort__0$1cassia$util$RangedListView$$T$3cassia$util$RangedListView$$T$3x10$lang$Int$2(a1); return null;
        
    }
    
    // dispatcher for method abstract public x10.util.List.sort(cmp:(T,T)=>x10.lang.Int){}:void
    public void sort$V(final x10.core.fun.Fun_0_2 a1, final x10.rtt.Type t1) {
        sort__0$1cassia$util$RangedListView$$T$3cassia$util$RangedListView$$T$3x10$lang$Int$2(a1);
        
    }
    
    // dispatcher for method abstract public cassia.util.RangedCommon[T].each(op:(T)=>void){}:void
    public java.lang.Object each(final x10.core.fun.VoidFun_0_1 a1, final x10.rtt.Type t1) {
        each__0$1cassia$util$RangedListView$$T$2((x10.core.fun.VoidFun_0_1)a1); return null;
        
    }
    
    // dispatcher for method abstract public cassia.util.RangedCommon[T].each(op:(T)=>void){}:void
    public void each$V(final x10.core.fun.VoidFun_0_1 a1, final x10.rtt.Type t1) {
        each__0$1cassia$util$RangedListView$$T$2((x10.core.fun.VoidFun_0_1)a1);
        
    }
    
    // dispatcher for method abstract public cassia.util.RangedCommon[T].each(range:x10.lang.LongRange, op:(T)=>void){}:void
    public java.lang.Object each(final x10.lang.LongRange a1, final x10.core.fun.VoidFun_0_1 a2, final x10.rtt.Type t2) {
        each__1$1cassia$util$RangedListView$$T$2((x10.lang.LongRange)a1, (x10.core.fun.VoidFun_0_1)a2); return null;
        
    }
    
    // dispatcher for method abstract public cassia.util.RangedCommon[T].each(range:x10.lang.LongRange, op:(T)=>void){}:void
    public void each$V(final x10.lang.LongRange a1, final x10.core.fun.VoidFun_0_1 a2, final x10.rtt.Type t2) {
        each__1$1cassia$util$RangedListView$$T$2((x10.lang.LongRange)a1, (x10.core.fun.VoidFun_0_1)a2);
        
    }
    
    private x10.rtt.Type $T;
    
    // initializer of type parameters
    public static void $initParams(final RangedListView $this, final x10.rtt.Type $T) {
        $this.$T = $T;
        
    }
    // synthetic type for parameter mangling
    public static final class __0$1cassia$util$RangedListView$$T$2 {}
    
    // properties
    
    //#line 4 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
    public x10.util.List<$T> base;
    
    //#line 4 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
    public x10.lang.LongRange range;
    

    
    
    //#line 6 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
    public static <$T>cassia.util.RangedListView emptyView(final x10.rtt.Type $T) {
        
        //#line 6 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
        final x10.lang.LongRange t$35272 = ((x10.lang.LongRange)(new x10.lang.LongRange((java.lang.System[]) null).x10$lang$LongRange$$init$S(((long)(0L)), ((long)(-1L)))));
        
        //#line 6 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
        final cassia.util.RangedListView t$35273 = ((cassia.util.RangedListView)(new cassia.util.RangedListView<$T>((java.lang.System[]) null, $T).cassia$util$RangedListView$$init$S(((x10.util.List<$T>)(null)), ((x10.lang.LongRange)(t$35272)), (cassia.util.RangedListView.__0$1cassia$util$RangedListView$$T$2) null)));
        
        //#line 6 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
        return t$35273;
    }
    
    
    //#line 8 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
    public x10.lang.LongRange getRange() {
        
        //#line 8 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
        final x10.lang.LongRange t$35274 = ((x10.lang.LongRange)(this.range));
        
        //#line 8 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
        return t$35274;
    }
    
    
    //#line 10 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
    public boolean contains__0cassia$util$RangedListView$$T$O(final $T v) {
        
        //#line 11 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
        final x10.lang.LongRange i$35140domain$35547 = ((x10.lang.LongRange)(this.range));
        
        //#line 11 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
        final long i$35140min$35548 = i$35140domain$35547.min;
        
        //#line 11 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
        final long i$35140max$35549 = i$35140domain$35547.max;
        
        //#line 11 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
        long i$35544 = i$35140min$35548;
        
        //#line 11 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
        for (;
             true;
             ) {
            
            //#line 11 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
            final long t$35545 = i$35544;
            
            //#line 11 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
            final boolean t$35546 = ((t$35545) <= (((long)(i$35140max$35549))));
            
            //#line 11 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
            if (!(t$35546)) {
                
                //#line 11 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
                break;
            }
            
            //#line 11 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
            final long i$35541 = i$35544;
            
            //#line 12 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
            final x10.util.List t$35536 = ((x10.util.List)(this.base));
            
            //#line 12 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
            final $T elem$35537 = (($T)(((x10.util.Indexed<$T>)t$35536).$apply$G((long)(i$35541))));
            
            //#line 13 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
            final boolean t$35538 = ((v) == (null));
            
            //#line 13 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
            boolean t$35539 =  false;
            
            //#line 13 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
            if (t$35538) {
                
                //#line 13 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
                t$35539 = ((elem$35537) == (null));
            } else {
                
                //#line 13 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
                t$35539 = ((java.lang.Object)(((java.lang.Object)(v)))).equals(elem$35537);
            }
            
            //#line 13 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
            final boolean t$35540 = t$35539;
            
            //#line 13 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
            if (t$35540) {
                
                //#line 14 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
                return true;
            }
            
            //#line 11 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
            final long t$35542 = i$35544;
            
            //#line 11 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
            final long t$35543 = ((t$35542) + (((long)(1L))));
            
            //#line 11 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
            i$35544 = t$35543;
        }
        
        //#line 17 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
        return false;
    }
    
    
    //#line 19 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
    public boolean containsAll__0$1cassia$util$RangedListView$$T$2$O(final x10.util.Container vs) {
        
        //#line 20 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
        final x10.lang.Iterator v$35553 = ((x10.lang.Iterator<$T>)
                                            ((x10.lang.Iterable<$T>)vs).iterator());
        
        //#line 20 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
        for (;
             true;
             ) {
            
            //#line 20 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
            final boolean t$35554 = ((x10.lang.Iterator<$T>)v$35553).hasNext$O();
            
            //#line 20 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
            if (!(t$35554)) {
                
                //#line 20 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
                break;
            }
            
            //#line 20 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
            final $T v$35550 = (($T)(((x10.lang.Iterator<$T>)v$35553).next$G()));
            
            //#line 20 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
            final boolean t$35551 = this.contains__0cassia$util$RangedListView$$T$O((($T)(v$35550)));
            
            //#line 20 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
            final boolean t$35552 = !(t$35551);
            
            //#line 20 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
            if (t$35552) {
                
                //#line 20 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
                return false;
            }
        }
        
        //#line 21 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
        return true;
    }
    
    
    //#line 23 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
    public long indexOf__0cassia$util$RangedListView$$T$O(final $T v) {
        
        //#line 24 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
        final x10.lang.LongRange t$35288 = ((x10.lang.LongRange)(this.range));
        
        //#line 24 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
        final long t$35289 = t$35288.min;
        
        //#line 24 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
        final long t$35290 = this.indexOf__1cassia$util$RangedListView$$T$O((long)(t$35289), (($T)(v)));
        
        //#line 24 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
        return t$35290;
    }
    
    
    //#line 26 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
    public long indexOf__1cassia$util$RangedListView$$T$O(final long index, final $T v) {
        
        //#line 27 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
        final x10.lang.LongRange i$35161domain$35568 = ((x10.lang.LongRange)(this.range));
        
        //#line 27 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
        final long i$35161min$35569 = i$35161domain$35568.min;
        
        //#line 27 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
        final long i$35161max$35570 = i$35161domain$35568.max;
        
        //#line 27 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
        long i$35565 = i$35161min$35569;
        
        //#line 27 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
        for (;
             true;
             ) {
            
            //#line 27 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
            final long t$35566 = i$35565;
            
            //#line 27 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
            final boolean t$35567 = ((t$35566) <= (((long)(i$35161max$35570))));
            
            //#line 27 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
            if (!(t$35567)) {
                
                //#line 27 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
                break;
            }
            
            //#line 27 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
            final long i$35562 = i$35565;
            
            //#line 28 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
            final boolean t$35555 = ((v) == (null));
            
            //#line 28 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
            boolean t$35556 =  false;
            
            //#line 28 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
            if (t$35555) {
                
                //#line 28 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
                final x10.util.List t$35557 = ((x10.util.List)(this.base));
                
                //#line 28 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
                final $T t$35558 = (($T)(((x10.util.Indexed<$T>)t$35557).$apply$G((long)(i$35562))));
                
                //#line 28 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
                t$35556 = ((t$35558) == (null));
            } else {
                
                //#line 28 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
                final x10.util.List t$35559 = ((x10.util.List)(this.base));
                
                //#line 28 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
                final $T t$35560 = (($T)(((x10.util.Indexed<$T>)t$35559).$apply$G((long)(i$35562))));
                
                //#line 28 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
                t$35556 = ((java.lang.Object)(((java.lang.Object)(v)))).equals(t$35560);
            }
            
            //#line 28 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
            final boolean t$35561 = t$35556;
            
            //#line 28 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
            if (t$35561) {
                
                //#line 29 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
                return i$35562;
            }
            
            //#line 27 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
            final long t$35563 = i$35565;
            
            //#line 27 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
            final long t$35564 = ((t$35563) + (((long)(1L))));
            
            //#line 27 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
            i$35565 = t$35564;
        }
        
        //#line 31 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
        return -1L;
    }
    
    
    //#line 33 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
    public long lastIndexOf__0cassia$util$RangedListView$$T$O(final $T v) {
        
        //#line 34 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
        final x10.lang.LongRange t$35303 = ((x10.lang.LongRange)(this.range));
        
        //#line 34 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
        final long t$35304 = t$35303.max;
        
        //#line 34 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
        final long t$35305 = this.indexOf__1cassia$util$RangedListView$$T$O((long)(t$35304), (($T)(v)));
        
        //#line 34 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
        return t$35305;
    }
    
    
    //#line 36 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
    public long lastIndexOf__1cassia$util$RangedListView$$T$O(final long index, final $T v) {
        
        //#line 37 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
        long i$35583 = index;
        
        //#line 37 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
        for (;
             true;
             ) {
            
            //#line 37 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
            final long t$35584 = i$35583;
            
            //#line 37 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
            final x10.lang.LongRange t$35585 = ((x10.lang.LongRange)(this.range));
            
            //#line 37 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
            final long t$35586 = t$35585.min;
            
            //#line 37 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
            final boolean t$35587 = ((t$35584) >= (((long)(t$35586))));
            
            //#line 37 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
            if (!(t$35587)) {
                
                //#line 37 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
                break;
            }
            
            //#line 38 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
            final boolean t$35571 = ((v) == (null));
            
            //#line 38 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
            boolean t$35572 =  false;
            
            //#line 38 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
            if (t$35571) {
                
                //#line 38 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
                final x10.util.List t$35573 = ((x10.util.List)(this.base));
                
                //#line 38 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
                final long t$35574 = i$35583;
                
                //#line 38 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
                final $T t$35575 = (($T)(((x10.util.Indexed<$T>)t$35573).$apply$G((long)(t$35574))));
                
                //#line 38 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
                t$35572 = ((t$35575) == (null));
            } else {
                
                //#line 38 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
                final x10.util.List t$35576 = ((x10.util.List)(this.base));
                
                //#line 38 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
                final long t$35577 = i$35583;
                
                //#line 38 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
                final $T t$35578 = (($T)(((x10.util.Indexed<$T>)t$35576).$apply$G((long)(t$35577))));
                
                //#line 38 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
                t$35572 = ((java.lang.Object)(((java.lang.Object)(v)))).equals(t$35578);
            }
            
            //#line 38 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
            final boolean t$35579 = t$35572;
            
            //#line 38 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
            if (t$35579) {
                
                //#line 39 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
                final long t$35580 = i$35583;
                
                //#line 39 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
                return t$35580;
            }
            
            //#line 37 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
            final long t$35581 = i$35583;
            
            //#line 37 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
            final long t$35582 = ((t$35581) - (((long)(1L))));
            
            //#line 37 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
            i$35583 = t$35582;
        }
        
        //#line 41 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
        return -1L;
    }
    
    
    //#line 45 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
    public void clear() {
        
        //#line 46 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
        final java.lang.UnsupportedOperationException t$35323 = ((java.lang.UnsupportedOperationException)(new java.lang.UnsupportedOperationException()));
        
        //#line 46 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
        throw t$35323;
    }
    
    
    //#line 49 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
    public x10.util.Collection clone() {
        
        //#line 50 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
        final java.lang.UnsupportedOperationException t$35324 = ((java.lang.UnsupportedOperationException)(new java.lang.UnsupportedOperationException()));
        
        //#line 50 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
        throw t$35324;
    }
    
    
    //#line 52 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
    public long last$O() {
        
        //#line 53 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
        final x10.lang.LongRange t$35325 = ((x10.lang.LongRange)(this.range));
        
        //#line 53 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
        final long t$35326 = t$35325.max;
        
        //#line 53 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
        return t$35326;
    }
    
    
    //#line 55 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
    public boolean add__0cassia$util$RangedListView$$T$O(final $T v) {
        
        //#line 56 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
        final java.lang.UnsupportedOperationException t$35327 = ((java.lang.UnsupportedOperationException)(new java.lang.UnsupportedOperationException()));
        
        //#line 56 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
        throw t$35327;
    }
    
    
    //#line 58 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
    public void addBefore__1cassia$util$RangedListView$$T(final long i, final $T v) {
        
        //#line 59 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
        final java.lang.UnsupportedOperationException t$35328 = ((java.lang.UnsupportedOperationException)(new java.lang.UnsupportedOperationException()));
        
        //#line 59 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
        throw t$35328;
    }
    
    
    //#line 63 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
    public boolean addAll__0$1cassia$util$RangedListView$$T$2$O(final x10.util.Container elems) {
        
        //#line 64 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
        final java.lang.UnsupportedOperationException t$35329 = ((java.lang.UnsupportedOperationException)(new java.lang.UnsupportedOperationException()));
        
        //#line 64 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
        throw t$35329;
    }
    
    
    //#line 66 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
    public boolean remove__0cassia$util$RangedListView$$T$O(final $T v) {
        
        //#line 67 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
        final java.lang.UnsupportedOperationException t$35330 = ((java.lang.UnsupportedOperationException)(new java.lang.UnsupportedOperationException()));
        
        //#line 67 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
        throw t$35330;
    }
    
    
    //#line 69 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
    public boolean retainAll__0$1cassia$util$RangedListView$$T$2$O(final x10.util.Container vs) {
        
        //#line 70 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
        final java.lang.UnsupportedOperationException t$35331 = ((java.lang.UnsupportedOperationException)(new java.lang.UnsupportedOperationException()));
        
        //#line 70 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
        throw t$35331;
    }
    
    
    //#line 72 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
    public boolean removeAll__0$1cassia$util$RangedListView$$T$2$O(final x10.util.Container vs) {
        
        //#line 73 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
        final java.lang.UnsupportedOperationException t$35332 = ((java.lang.UnsupportedOperationException)(new java.lang.UnsupportedOperationException()));
        
        //#line 73 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
        throw t$35332;
    }
    
    
    //#line 75 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
    public boolean addAllWhere__0$1cassia$util$RangedListView$$T$2__1$1cassia$util$RangedListView$$T$3x10$lang$Boolean$2$O(final x10.util.Container c, final x10.core.fun.Fun_0_1 p) {
        
        //#line 76 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
        final java.lang.UnsupportedOperationException t$35333 = ((java.lang.UnsupportedOperationException)(new java.lang.UnsupportedOperationException()));
        
        //#line 76 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
        throw t$35333;
    }
    
    
    //#line 78 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
    public boolean removeAllWhere__0$1cassia$util$RangedListView$$T$3x10$lang$Boolean$2$O(final x10.core.fun.Fun_0_1 p) {
        
        //#line 79 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
        final java.lang.UnsupportedOperationException t$35334 = ((java.lang.UnsupportedOperationException)(new java.lang.UnsupportedOperationException()));
        
        //#line 79 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
        throw t$35334;
    }
    
    
    //#line 82 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
    public $T getFirst$G() {
        
        //#line 82 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
        final x10.util.List t$35336 = ((x10.util.List)(this.base));
        
        //#line 82 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
        final x10.lang.LongRange t$35335 = ((x10.lang.LongRange)(this.range));
        
        //#line 82 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
        final long t$35337 = t$35335.min;
        
        //#line 82 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
        final $T t$35338 = (($T)(((x10.util.Indexed<$T>)t$35336).$apply$G((long)(t$35337))));
        
        //#line 82 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
        return t$35338;
    }
    
    
    //#line 83 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
    public $T getLast$G() {
        
        //#line 83 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
        final x10.util.List t$35340 = ((x10.util.List)(this.base));
        
        //#line 83 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
        final x10.lang.LongRange t$35339 = ((x10.lang.LongRange)(this.range));
        
        //#line 83 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
        final long t$35341 = t$35339.max;
        
        //#line 83 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
        final $T t$35342 = (($T)(((x10.util.Indexed<$T>)t$35340).$apply$G((long)(t$35341))));
        
        //#line 83 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
        return t$35342;
    }
    
    
    //#line 85 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
    public $T removeAt$G(final long i0) {
        
        //#line 86 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
        final java.lang.UnsupportedOperationException t$35343 = ((java.lang.UnsupportedOperationException)(new java.lang.UnsupportedOperationException()));
        
        //#line 86 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
        throw t$35343;
    }
    
    
    //#line 89 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
    public $T removeFirst$G() {
        
        //#line 90 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
        final java.lang.UnsupportedOperationException t$35344 = ((java.lang.UnsupportedOperationException)(new java.lang.UnsupportedOperationException()));
        
        //#line 90 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
        throw t$35344;
    }
    
    
    //#line 92 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
    public $T removeLast$G() {
        
        //#line 93 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
        final java.lang.UnsupportedOperationException t$35345 = ((java.lang.UnsupportedOperationException)(new java.lang.UnsupportedOperationException()));
        
        //#line 93 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
        throw t$35345;
    }
    
    
    //#line 96 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
    public $T $apply$G(final long i) {
        
        //#line 96 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
        final x10.util.List t$35346 = ((x10.util.List)(this.base));
        
        //#line 96 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
        final $T t$35347 = (($T)(((x10.util.Indexed<$T>)t$35346).$apply$G((long)(i))));
        
        //#line 96 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
        return t$35347;
    }
    
    
    //#line 97 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
    public $T $set__1cassia$util$RangedListView$$T$G(final long i, final $T v) {
        
        //#line 97 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
        final $T t$35348 = (($T)(this.set__0cassia$util$RangedListView$$T$G((($T)(v)), (long)(i))));
        
        //#line 97 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
        return t$35348;
    }
    
    
    //#line 99 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
    public $T set__0cassia$util$RangedListView$$T$G(final $T v, final long i0) {
        
        //#line 100 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
        final x10.util.List t$35349 = ((x10.util.List)(this.base));
        
        //#line 100 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
        ((x10.lang.Settable<x10.core.Long, $T>)t$35349).$set(x10.core.Long.$box(i0), x10.rtt.Types.LONG, (($T)(v)), $T);
        
        //#line 101 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
        return v;
    }
    
    
    //#line 104 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
    public $T get$G(final long i0) {
        
        //#line 105 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
        final x10.util.List t$35350 = ((x10.util.List)(this.base));
        
        //#line 105 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
        final $T t$35351 = (($T)(((x10.util.Indexed<$T>)t$35350).$apply$G((long)(i0))));
        
        //#line 105 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
        return t$35351;
    }
    
    
    //#line 108 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
    public long size$O() {
        
        //#line 108 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
        final x10.lang.LongRange t$35352 = ((x10.lang.LongRange)(this.range));
        
        //#line 108 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
        final long t$35354 = t$35352.max;
        
        //#line 108 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
        final x10.lang.LongRange t$35353 = ((x10.lang.LongRange)(this.range));
        
        //#line 108 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
        final long t$35355 = t$35353.min;
        
        //#line 108 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
        final long t$35356 = ((t$35354) - (((long)(t$35355))));
        
        //#line 108 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
        final long t$35357 = ((t$35356) + (((long)(1L))));
        
        //#line 108 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
        return t$35357;
    }
    
    
    //#line 109 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
    public boolean isEmpty$O() {
        
        //#line 109 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
        final x10.lang.LongRange t$35358 = ((x10.lang.LongRange)(this.range));
        
        //#line 109 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
        final long t$35360 = t$35358.max;
        
        //#line 109 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
        final x10.lang.LongRange t$35359 = ((x10.lang.LongRange)(this.range));
        
        //#line 109 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
        final long t$35361 = t$35359.min;
        
        //#line 109 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
        final boolean t$35362 = ((t$35360) < (((long)(t$35361))));
        
        //#line 109 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
        return t$35362;
    }
    
    
    //#line 110 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
    public x10.util.List indices() {
        
        //#line 111 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
        final x10.util.ArrayList result = ((x10.util.ArrayList)(new x10.util.ArrayList<x10.core.Long>((java.lang.System[]) null, x10.rtt.Types.LONG).x10$util$ArrayList$$init$S()));
        
        //#line 112 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
        final x10.lang.LongRange i$35180domain$35594 = ((x10.lang.LongRange)(this.range));
        
        //#line 112 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
        final long i$35180min$35595 = i$35180domain$35594.min;
        
        //#line 112 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
        final long i$35180max$35596 = i$35180domain$35594.max;
        
        //#line 112 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
        long i$35591 = i$35180min$35595;
        
        //#line 112 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
        for (;
             true;
             ) {
            
            //#line 112 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
            final long t$35592 = i$35591;
            
            //#line 112 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
            final boolean t$35593 = ((t$35592) <= (((long)(i$35180max$35596))));
            
            //#line 112 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
            if (!(t$35593)) {
                
                //#line 112 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
                break;
            }
            
            //#line 112 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
            final long i$35588 = i$35591;
            
            //#line 112 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
            ((x10.util.ArrayList<x10.core.Long>)result).add__0x10$util$ArrayList$$T$O(x10.core.Long.$box(i$35588));
            
            //#line 112 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
            final long t$35589 = i$35591;
            
            //#line 112 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
            final long t$35590 = ((t$35589) + (((long)(1L))));
            
            //#line 112 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
            i$35591 = t$35590;
        }
        
        //#line 113 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
        return result;
    }
    
    
    //#line 115 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
    public void reverse() {
        
        //#line 116 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
        final java.lang.UnsupportedOperationException t$35368 = ((java.lang.UnsupportedOperationException)(new java.lang.UnsupportedOperationException()));
        
        //#line 116 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
        throw t$35368;
    }
    
    
    //#line 118 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
    public void sort() {
        
        //#line 118 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
        final java.lang.UnsupportedOperationException t$35369 = ((java.lang.UnsupportedOperationException)(new java.lang.UnsupportedOperationException()));
        
        //#line 118 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
        throw t$35369;
    }
    
    
    //#line 119 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
    public void sort__0$1cassia$util$RangedListView$$T$3cassia$util$RangedListView$$T$3x10$lang$Int$2(final x10.core.fun.Fun_0_2 cmp) {
        
        //#line 119 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
        final java.lang.UnsupportedOperationException t$35370 = ((java.lang.UnsupportedOperationException)(new java.lang.UnsupportedOperationException()));
        
        //#line 119 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
        throw t$35370;
    }
    
    
    //#line 121 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
    @x10.runtime.impl.java.X10Generated
    public static class It<$S> extends x10.core.Ref implements x10.util.ListIterator, x10.serialization.X10JavaSerializable
    {
        public static final x10.rtt.RuntimeType<It> $RTT = 
            x10.rtt.NamedType.<It> make("cassia.util.RangedListView.It",
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
        
        public static <$S> x10.serialization.X10JavaSerializable $_deserialize_body(cassia.util.RangedListView.It<$S> $_obj, x10.serialization.X10JavaDeserializer $deserializer) throws java.io.IOException {
            if (x10.runtime.impl.java.Runtime.TRACE_SER) { x10.runtime.impl.java.Runtime.printTraceMessage("X10JavaSerializable: $_deserialize_body() of " + It.class + " calling"); } 
            $_obj.$S = (x10.rtt.Type) $deserializer.readObject();
            $_obj.base = $deserializer.readObject();
            $_obj.i = $deserializer.readLong();
            $_obj.range = $deserializer.readObject();
            return $_obj;
        }
        
        public static x10.serialization.X10JavaSerializable $_deserializer(x10.serialization.X10JavaDeserializer $deserializer) throws java.io.IOException {
            cassia.util.RangedListView.It $_obj = new cassia.util.RangedListView.It((java.lang.System[]) null, (x10.rtt.Type) null);
            $deserializer.record_reference($_obj);
            return $_deserialize_body($_obj, $deserializer);
        }
        
        public void $_serialize(x10.serialization.X10JavaSerializer $serializer) throws java.io.IOException {
            $serializer.write(this.$S);
            $serializer.write(this.base);
            $serializer.write(this.i);
            $serializer.write(this.range);
            
        }
        
        // constructor just for allocation
        public It(final java.lang.System[] $dummy, final x10.rtt.Type $S) {
            cassia.util.RangedListView.It.$initParams(this, $S);
            
        }
        
        // dispatcher for method abstract public x10.util.ListIterator.set(v:T){}:void
        public java.lang.Object set(final java.lang.Object a1, final x10.rtt.Type t1) {
            set__0cassia$util$RangedListView$It$$S(($S)a1); return null;
            
        }
        
        // dispatcher for method abstract public x10.util.ListIterator.set(v:T){}:void
        public void set$V(final java.lang.Object a1, final x10.rtt.Type t1) {
            set__0cassia$util$RangedListView$It$$S(($S)a1);
            
        }
        
        // dispatcher for method abstract public x10.util.ListIterator.add(v:T){}:void
        public java.lang.Object add(final java.lang.Object a1, final x10.rtt.Type t1) {
            add__0cassia$util$RangedListView$It$$S(($S)a1); return null;
            
        }
        
        // dispatcher for method abstract public x10.util.ListIterator.add(v:T){}:void
        public void add$V(final java.lang.Object a1, final x10.rtt.Type t1) {
            add__0cassia$util$RangedListView$It$$S(($S)a1);
            
        }
        
        private x10.rtt.Type $S;
        
        // initializer of type parameters
        public static void $initParams(final It $this, final x10.rtt.Type $S) {
            $this.$S = $S;
            
        }
        // synthetic type for parameter mangling
        public static final class __0$1cassia$util$RangedListView$It$$S$2 {}
        
        // properties
        
        //#line 121 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
        public x10.util.List<$S> base;
        
        //#line 121 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
        public x10.lang.LongRange range;
        
    
        
        //#line 123 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
        public long i;
        
        
        //#line 125 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
        public boolean hasNext$O() {
            
            //#line 126 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
            final long t$35371 = this.i;
            
            //#line 126 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
            final long t$35373 = ((t$35371) + (((long)(1L))));
            
            //#line 126 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
            final x10.lang.LongRange t$35372 = ((x10.lang.LongRange)(this.range));
            
            //#line 126 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
            final long t$35374 = t$35372.max;
            
            //#line 126 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
            final boolean t$35375 = ((t$35373) <= (((long)(t$35374))));
            
            //#line 126 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
            return t$35375;
        }
        
        
        //#line 128 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
        public $S next$G() {
            
            //#line 129 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
            final x10.util.List t$35378 = ((x10.util.List)(this.base));
            
            //#line 129 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
            final long t$35376 = this.i;
            
            //#line 129 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
            final long t$35377 = ((t$35376) + (((long)(1L))));
            
            //#line 129 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
            final long t$35379 = ((cassia.util.RangedListView.It<$S>)this).i = t$35377;
            
            //#line 129 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
            final $S t$35380 = (($S)(((x10.util.Indexed<$S>)t$35378).$apply$G((long)(t$35379))));
            
            //#line 129 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
            return t$35380;
        }
        
        
        //#line 131 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
        public long nextIndex$O() {
            
            //#line 132 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
            final long t$35381 = this.i;
            
            //#line 132 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
            final long t$35382 = ((t$35381) + (((long)(1L))));
            
            //#line 132 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
            final long t$35383 = ((cassia.util.RangedListView.It<$S>)this).i = t$35382;
            
            //#line 132 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
            return t$35383;
        }
        
        
        //#line 135 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
        public boolean hasPrevious$O() {
            
            //#line 136 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
            final long t$35384 = this.i;
            
            //#line 136 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
            final long t$35386 = ((t$35384) - (((long)(1L))));
            
            //#line 136 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
            final x10.lang.LongRange t$35385 = ((x10.lang.LongRange)(this.range));
            
            //#line 136 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
            final long t$35387 = t$35385.min;
            
            //#line 136 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
            final boolean t$35388 = ((t$35386) >= (((long)(t$35387))));
            
            //#line 136 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
            return t$35388;
        }
        
        
        //#line 139 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
        public long previousIndex$O() {
            
            //#line 140 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
            final long t$35389 = this.i;
            
            //#line 140 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
            final long t$35390 = ((t$35389) - (((long)(1L))));
            
            //#line 140 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
            final long t$35391 = ((cassia.util.RangedListView.It<$S>)this).i = t$35390;
            
            //#line 140 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
            return t$35391;
        }
        
        
        //#line 143 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
        public $S previous$G() {
            
            //#line 144 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
            final x10.util.List t$35394 = ((x10.util.List)(this.base));
            
            //#line 144 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
            final long t$35392 = this.i;
            
            //#line 144 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
            final long t$35393 = ((t$35392) - (((long)(1L))));
            
            //#line 144 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
            final long t$35395 = ((cassia.util.RangedListView.It<$S>)this).i = t$35393;
            
            //#line 144 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
            final $S t$35396 = (($S)(((x10.util.Indexed<$S>)t$35394).$apply$G((long)(t$35395))));
            
            //#line 144 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
            return t$35396;
        }
        
        
        //#line 147 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
        public void remove() {
            
            //#line 148 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
            final java.lang.UnsupportedOperationException t$35397 = ((java.lang.UnsupportedOperationException)(new java.lang.UnsupportedOperationException()));
            
            //#line 148 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
            throw t$35397;
        }
        
        
        //#line 151 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
        public void set__0cassia$util$RangedListView$It$$S(final $S v) {
            
            //#line 152 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
            final x10.util.List t$35398 = ((x10.util.List)(this.base));
            
            //#line 152 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
            final long t$35399 = this.i;
            
            //#line 152 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
            ((x10.lang.Settable<x10.core.Long, $S>)t$35398).$set(x10.core.Long.$box(t$35399), x10.rtt.Types.LONG, (($S)(v)), $S);
        }
        
        
        //#line 155 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
        public void add__0cassia$util$RangedListView$It$$S(final $S v) {
            
            //#line 156 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
            final java.lang.UnsupportedOperationException t$35400 = ((java.lang.UnsupportedOperationException)(new java.lang.UnsupportedOperationException()));
            
            //#line 156 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
            throw t$35400;
        }
        
        
        //#line 121 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
        final public cassia.util.RangedListView.It cassia$util$RangedListView$It$$this$cassia$util$RangedListView$It() {
            
            //#line 121 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
            return cassia.util.RangedListView.It.this;
        }
        
        
        //#line 121 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
        // creation method for java code (1-phase java constructor)
        public It(final x10.rtt.Type $S, final x10.util.List<$S> base, final x10.lang.LongRange range, __0$1cassia$util$RangedListView$It$$S$2 $dummy) {
            this((java.lang.System[]) null, $S);
            cassia$util$RangedListView$It$$init$S(base, range, (cassia.util.RangedListView.It.__0$1cassia$util$RangedListView$It$$S$2) null);
        }
        
        // constructor for non-virtual call
        final public cassia.util.RangedListView.It<$S> cassia$util$RangedListView$It$$init$S(final x10.util.List<$S> base, final x10.lang.LongRange range, __0$1cassia$util$RangedListView$It$$S$2 $dummy) {
             {
                
                //#line 121 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
                this.base = base;
                this.range = range;
                
                
                //#line 121 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
                this.__fieldInitializers_cassia_util_RangedListView_It();
            }
            return this;
        }
        
        
        
        //#line 121 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
        final public void __fieldInitializers_cassia_util_RangedListView_It() {
            
            //#line 123 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
            final x10.lang.LongRange t$35401 = ((x10.lang.LongRange)(this.range));
            
            //#line 123 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
            final long t$35402 = t$35401.min;
            
            //#line 123 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
            final long t$35403 = ((t$35402) - (((long)(1L))));
            
            //#line 121 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
            ((cassia.util.RangedListView.It<$S>)this).i = t$35403;
        }
    }
    
    
    
    //#line 159 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
    public x10.util.ListIterator iterator() {
        
        //#line 160 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
        final x10.util.List t$35404 = ((x10.util.List)(this.base));
        
        //#line 160 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
        final x10.lang.LongRange t$35405 = ((x10.lang.LongRange)(this.range));
        
        //#line 160 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
        final cassia.util.RangedListView.It t$35406 = ((cassia.util.RangedListView.It)(new cassia.util.RangedListView.It<$T>((java.lang.System[]) null, $T).cassia$util$RangedListView$It$$init$S(((x10.util.List<$T>)(t$35404)), ((x10.lang.LongRange)(t$35405)), (cassia.util.RangedListView.It.__0$1cassia$util$RangedListView$It$$S$2) null)));
        
        //#line 160 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
        return t$35406;
    }
    
    
    //#line 162 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
    public x10.util.ListIterator iteratorFrom(final long index) {
        
        //#line 163 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
        final x10.util.List t$35412 = ((x10.util.List)(this.base));
        
        //#line 163 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
        final x10.lang.LongRange t$35407 = ((x10.lang.LongRange)(this.range));
        
        //#line 163 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
        final long t$35408 = t$35407.min;
        
        //#line 163 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
        final long t$35410 = java.lang.Math.max(((long)(t$35408)),((long)(index)));
        
        //#line 163 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
        final x10.lang.LongRange t$35409 = ((x10.lang.LongRange)(this.range));
        
        //#line 163 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
        final long t$35411 = t$35409.max;
        
        //#line 163 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
        final x10.lang.LongRange t$35413 = ((x10.lang.LongRange)(new x10.lang.LongRange((java.lang.System[]) null).x10$lang$LongRange$$init$S(((long)(t$35410)), ((long)(t$35411)))));
        
        //#line 163 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
        final cassia.util.RangedListView.It t$35414 = ((cassia.util.RangedListView.It)(new cassia.util.RangedListView.It<$T>((java.lang.System[]) null, $T).cassia$util$RangedListView$It$$init$S(((x10.util.List<$T>)(t$35412)), ((x10.lang.LongRange)(t$35413)), (cassia.util.RangedListView.It.__0$1cassia$util$RangedListView$It$$S$2) null)));
        
        //#line 163 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
        return t$35414;
    }
    
    
    //#line 165 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
    public cassia.util.RangedList subList(final long fromIndex, final long toIndex) {
        
        //#line 166 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
        final x10.util.List t$35421 = ((x10.util.List)(this.base));
        
        //#line 166 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
        final x10.lang.LongRange t$35415 = ((x10.lang.LongRange)(this.range));
        
        //#line 166 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
        final long t$35416 = t$35415.min;
        
        //#line 166 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
        final long t$35419 = java.lang.Math.max(((long)(fromIndex)),((long)(t$35416)));
        
        //#line 166 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
        final x10.lang.LongRange t$35417 = ((x10.lang.LongRange)(this.range));
        
        //#line 166 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
        final long t$35418 = t$35417.max;
        
        //#line 166 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
        final long t$35420 = java.lang.Math.min(((long)(toIndex)),((long)(t$35418)));
        
        //#line 166 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
        final x10.lang.LongRange t$35422 = ((x10.lang.LongRange)(new x10.lang.LongRange((java.lang.System[]) null).x10$lang$LongRange$$init$S(((long)(t$35419)), ((long)(t$35420)))));
        
        //#line 166 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
        final cassia.util.RangedListView t$35423 = ((cassia.util.RangedListView)(new cassia.util.RangedListView<$T>((java.lang.System[]) null, $T).cassia$util$RangedListView$$init$S(((x10.util.List<$T>)(t$35421)), t$35422, (cassia.util.RangedListView.__0$1cassia$util$RangedListView$$T$2) null)));
        
        //#line 166 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
        return t$35423;
    }
    
    
    //#line 169 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
    public void each__0$1cassia$util$RangedListView$$T$2(final x10.core.fun.VoidFun_0_1 op) {
        
        //#line 170 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
        final x10.util.List t$35424 = ((x10.util.List)(this.base));
        
        //#line 170 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
        final boolean t$35435 = cassia.util.RangedList.$RTT.isInstance(t$35424, $T);
        
        //#line 170 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
        if (t$35435) {
            
            //#line 171 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
            final x10.util.List t$35425 = ((x10.util.List)(this.base));
            
            //#line 171 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
            final cassia.util.RangedList t$35426 = ((cassia.util.RangedList)(x10.rtt.Types.<cassia.util.RangedList<$T>> cast(t$35425,x10.rtt.ParameterizedType.make(cassia.util.RangedList.$RTT, $T))));
            
            //#line 171 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
            final x10.lang.LongRange t$35427 = ((x10.lang.LongRange)(this.range));
            
            //#line 171 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
            ((cassia.util.RangedCommon<$T>)t$35426).each$V(((x10.lang.LongRange)(t$35427)), ((x10.core.fun.VoidFun_0_1)(op)), x10.rtt.ParameterizedType.make(x10.core.fun.VoidFun_0_1.$RTT,$T));
        } else {
            
            //#line 173 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
            final x10.lang.LongRange i$35199domain$35202 = ((x10.lang.LongRange)(this.range));
            
            //#line 173 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
            final long i$35199min$35200 = i$35199domain$35202.min;
            
            //#line 173 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
            final long i$35199max$35201 = i$35199domain$35202.max;
            
            //#line 173 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
            long i$35602 = i$35199min$35200;
            
            //#line 173 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
            for (;
                 true;
                 ) {
                
                //#line 173 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
                final long t$35603 = i$35602;
                
                //#line 173 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
                final boolean t$35604 = ((t$35603) <= (((long)(i$35199max$35201))));
                
                //#line 173 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
                if (!(t$35604)) {
                    
                    //#line 173 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
                    break;
                }
                
                //#line 173 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
                final long i$35599 = i$35602;
                
                //#line 174 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
                final x10.util.List t$35597 = ((x10.util.List)(this.base));
                
                //#line 174 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
                final $T t$35598 = (($T)(((x10.util.Indexed<$T>)t$35597).$apply$G((long)(i$35599))));
                
                //#line 174 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
                ((x10.core.fun.VoidFun_0_1<$T>)op).$apply(t$35598, $T);
                
                //#line 173 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
                final long t$35600 = i$35602;
                
                //#line 173 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
                final long t$35601 = ((t$35600) + (((long)(1L))));
                
                //#line 173 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
                i$35602 = t$35601;
            }
        }
    }
    
    
    //#line 179 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
    public void each__1$1cassia$util$RangedListView$$T$2(final x10.lang.LongRange range, final x10.core.fun.VoidFun_0_1 op) {
        
        //#line 180 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
        final x10.util.List t$35436 = ((x10.util.List)(this.base));
        
        //#line 180 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
        final boolean t$35461 = cassia.util.RangedList.$RTT.isInstance(t$35436, $T);
        
        //#line 180 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
        if (t$35461) {
            
            //#line 181 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
            final x10.util.List t$35437 = ((x10.util.List)(this.base));
            
            //#line 181 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
            final cassia.util.RangedList t$35446 = ((cassia.util.RangedList)(x10.rtt.Types.<cassia.util.RangedList<$T>> cast(t$35437,x10.rtt.ParameterizedType.make(cassia.util.RangedList.$RTT, $T))));
            
            //#line 181 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
            final long t$35439 = range.min;
            
            //#line 181 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
            final x10.lang.LongRange t$35438 = ((x10.lang.LongRange)(this.range));
            
            //#line 181 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
            final long t$35440 = t$35438.min;
            
            //#line 181 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
            final long t$35444 = java.lang.Math.max(((long)(t$35439)),((long)(t$35440)));
            
            //#line 181 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
            final long t$35442 = range.max;
            
            //#line 181 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
            final x10.lang.LongRange t$35441 = ((x10.lang.LongRange)(this.range));
            
            //#line 181 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
            final long t$35443 = t$35441.max;
            
            //#line 181 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
            final long t$35445 = java.lang.Math.min(((long)(t$35442)),((long)(t$35443)));
            
            //#line 181 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
            final x10.lang.LongRange t$35447 = ((x10.lang.LongRange)(new x10.lang.LongRange((java.lang.System[]) null).x10$lang$LongRange$$init$S(((long)(t$35444)), ((long)(t$35445)))));
            
            //#line 181 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
            ((cassia.util.RangedCommon<$T>)t$35446).each$V(((x10.lang.LongRange)(t$35447)), ((x10.core.fun.VoidFun_0_1)(op)), x10.rtt.ParameterizedType.make(x10.core.fun.VoidFun_0_1.$RTT,$T));
        } else {
            
            //#line 183 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
            final long t$35449 = range.min;
            
            //#line 183 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
            final x10.lang.LongRange t$35448 = ((x10.lang.LongRange)(this.range));
            
            //#line 183 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
            final long t$35450 = t$35448.min;
            
            //#line 183 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
            final long i$35218min$35219 = java.lang.Math.max(((long)(t$35449)),((long)(t$35450)));
            
            //#line 183 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
            final long t$35452 = range.max;
            
            //#line 183 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
            final x10.lang.LongRange t$35451 = ((x10.lang.LongRange)(this.range));
            
            //#line 183 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
            final long t$35453 = t$35451.max;
            
            //#line 183 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
            final long i$35218max$35220 = java.lang.Math.min(((long)(t$35452)),((long)(t$35453)));
            
            //#line 183 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
            long i$35610 = i$35218min$35219;
            
            //#line 183 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
            for (;
                 true;
                 ) {
                
                //#line 183 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
                final long t$35611 = i$35610;
                
                //#line 183 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
                final boolean t$35612 = ((t$35611) <= (((long)(i$35218max$35220))));
                
                //#line 183 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
                if (!(t$35612)) {
                    
                    //#line 183 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
                    break;
                }
                
                //#line 183 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
                final long i$35607 = i$35610;
                
                //#line 184 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
                final x10.util.List t$35605 = ((x10.util.List)(this.base));
                
                //#line 184 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
                final $T t$35606 = (($T)(((x10.util.Indexed<$T>)t$35605).$apply$G((long)(i$35607))));
                
                //#line 184 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
                ((x10.core.fun.VoidFun_0_1<$T>)op).$apply(t$35606, $T);
                
                //#line 183 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
                final long t$35608 = i$35610;
                
                //#line 183 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
                final long t$35609 = ((t$35608) + (((long)(1L))));
                
                //#line 183 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
                i$35610 = t$35609;
            }
        }
    }
    
    
    //#line 189 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
    public <$U>void each__0$1cassia$util$RangedListView$$T$3cassia$util$Receiver$1cassia$util$RangedListView$$U$2$2__1$1cassia$util$RangedListView$$U$2(final x10.rtt.Type $U, final x10.core.fun.VoidFun_0_2 op, final cassia.util.Receiver receiver) {
        
        //#line 190 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
        final x10.core.fun.VoidFun_0_1 op2 = ((x10.core.fun.VoidFun_0_1)(new cassia.util.RangedListView.$Closure$31<$T, $U>($T, $U, op, receiver, (cassia.util.RangedListView.$Closure$31.__0$1cassia$util$RangedListView$$Closure$31$$T$3cassia$util$Receiver$1cassia$util$RangedListView$$Closure$31$$U$2$2__1$1cassia$util$RangedListView$$Closure$31$$U$2) null)));
        
        //#line 191 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
        final x10.lang.LongRange t$35462 = ((x10.lang.LongRange)(this.range));
        
        //#line 191 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
        this.each__1$1cassia$util$RangedListView$$T$2(((x10.lang.LongRange)(t$35462)), ((x10.core.fun.VoidFun_0_1)(op2)));
    }
    
    
    //#line 193 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
    public <$U>void each__1$1cassia$util$RangedListView$$T$3cassia$util$Receiver$1cassia$util$RangedListView$$U$2$2__2$1cassia$util$RangedListView$$U$2(final x10.rtt.Type $U, final x10.lang.LongRange range, final x10.core.fun.VoidFun_0_2 op, final cassia.util.Receiver receiver) {
        
        //#line 194 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
        final x10.core.fun.VoidFun_0_1 op2 = ((x10.core.fun.VoidFun_0_1)(new cassia.util.RangedListView.$Closure$32<$T, $U>($T, $U, op, receiver, (cassia.util.RangedListView.$Closure$32.__0$1cassia$util$RangedListView$$Closure$32$$T$3cassia$util$Receiver$1cassia$util$RangedListView$$Closure$32$$U$2$2__1$1cassia$util$RangedListView$$Closure$32$$U$2) null)));
        
        //#line 195 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
        final x10.lang.LongRange t$35463 = ((x10.lang.LongRange)(this.range));
        
        //#line 195 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
        this.each__1$1cassia$util$RangedListView$$T$2(((x10.lang.LongRange)(t$35463)), ((x10.core.fun.VoidFun_0_1)(op2)));
    }
    
    
    //#line 203 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
    /**
     * Return the string representation of this Chunk.
     * 
     * @return the string representation of this Chunk.
     */
    public java.lang.String toString() {
        
        //#line 204 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
        final x10.util.StringBuilder sb = ((x10.util.StringBuilder)(new x10.util.StringBuilder((java.lang.System[]) null).x10$util$StringBuilder$$init$S()));
        
        //#line 205 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
        final x10.lang.LongRange t$35464 = ((x10.lang.LongRange)(this.range));
        
        //#line 205 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
        final java.lang.String t$35465 = (("[") + (t$35464));
        
        //#line 205 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
        final java.lang.String t$35466 = ((t$35465) + (":"));
        
        //#line 205 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
        sb.add(((java.lang.String)(t$35466)));
        
        //#line 206 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
        final long t$35467 = this.size$O();
        
        //#line 206 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
        final long sz = java.lang.Math.min(((long)(t$35467)),((long)(10L)));
        
        //#line 207 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
        final x10.lang.LongRange i$35236domain$35622 = ((x10.lang.LongRange)(this.range));
        
        //#line 207 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
        final long i$35236min$35623 = i$35236domain$35622.min;
        
        //#line 207 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
        final long i$35236max$35624 = i$35236domain$35622.max;
        
        //#line 207 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
        long i$35619 = i$35236min$35623;
        
        //#line 207 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
        for (;
             true;
             ) {
            
            //#line 207 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
            final long t$35620 = i$35619;
            
            //#line 207 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
            final boolean t$35621 = ((t$35620) <= (((long)(i$35236max$35624))));
            
            //#line 207 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
            if (!(t$35621)) {
                
                //#line 207 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
                break;
            }
            
            //#line 207 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
            final long i$35616 = i$35619;
            
            //#line 208 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
            final boolean t$35613 = ((i$35616) > (((long)(0L))));
            
            //#line 208 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
            if (t$35613) {
                
                //#line 208 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
                sb.add(((java.lang.String)(",")));
            }
            
            //#line 209 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
            final $T t$35614 = (($T)(this.$apply$G((long)(i$35616))));
            
            //#line 209 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
            final java.lang.String t$35615 = (("") + (t$35614));
            
            //#line 209 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
            sb.add(((java.lang.String)(t$35615)));
            
            //#line 207 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
            final long t$35617 = i$35619;
            
            //#line 207 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
            final long t$35618 = ((t$35617) + (((long)(1L))));
            
            //#line 207 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
            i$35619 = t$35618;
        }
        
        //#line 211 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
        final long t$35476 = this.size$O();
        
        //#line 211 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
        final boolean t$35481 = ((sz) < (((long)(t$35476))));
        
        //#line 211 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
        if (t$35481) {
            
            //#line 211 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
            final long t$35477 = this.size$O();
            
            //#line 211 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
            final long t$35478 = ((t$35477) - (((long)(sz))));
            
            //#line 211 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
            final java.lang.String t$35479 = (("...(omitted ") + ((x10.core.Long.$box(t$35478))));
            
            //#line 211 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
            final java.lang.String t$35480 = ((t$35479) + (" elements)"));
            
            //#line 211 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
            sb.add(((java.lang.String)(t$35480)));
        }
        
        //#line 212 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
        final x10.lang.LongRange t$35482 = ((x10.lang.LongRange)(this.range));
        
        //#line 212 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
        final long t$35483 = t$35482.min;
        
        //#line 212 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
        final java.lang.String t$35484 = (("@") + ((x10.core.Long.$box(t$35483))));
        
        //#line 212 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
        final java.lang.String t$35485 = ((t$35484) + (".."));
        
        //#line 212 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
        final long t$35486 = this.last$O();
        
        //#line 212 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
        final java.lang.String t$35487 = ((t$35485) + ((x10.core.Long.$box(t$35486))));
        
        //#line 212 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
        final java.lang.String t$35488 = ((t$35487) + ("]"));
        
        //#line 212 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
        sb.add(((java.lang.String)(t$35488)));
        
        //#line 213 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
        final java.lang.String t$35489 = sb.toString();
        
        //#line 213 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
        return t$35489;
    }
    
    
    //#line 216 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
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
            RangedListView.main(args);
        }
    }
    
    // the original app-main method
    public static void main(final x10.core.Rail<java.lang.String> args) {
        
        //#line 217 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
        final long i = 10L;
        
        //#line 218 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
        final long t$35491 = 100L;
        
        //#line 218 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
        final long t$35490 = 110L;
        
        //#line 218 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
        final long t$35492 = 109L;
        
        //#line 218 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
        final x10.lang.LongRange t$35493 = ((x10.lang.LongRange)(new x10.lang.LongRange((java.lang.System[]) null).x10$lang$LongRange$$init$S(((long)(t$35491)), ((long)(t$35492)))));
        
        //#line 218 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
        final cassia.util.Chunk c = ((cassia.util.Chunk)(new cassia.util.Chunk<x10.core.Long>((java.lang.System[]) null, x10.rtt.Types.LONG).cassia$util$Chunk$$init$S(t$35493)));
        
        //#line 219 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
        final x10.io.Printer t$35494 = ((x10.io.Printer)(x10.io.Console.get$OUT()));
        
        //#line 219 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
        final java.lang.String t$35495 = (("prepare:") + (c));
        
        //#line 219 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
        t$35494.println(((java.lang.Object)(t$35495)));
        
        //#line 220 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
        final long i$35255min$35640 = 0L;
        
        //#line 220 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
        final long i$35255max$35641 = 9L;
        
        //#line 220 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
        long i$35637 = i$35255min$35640;
        
        //#line 220 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
        for (;
             true;
             ) {
            
            //#line 220 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
            final long t$35638 = i$35637;
            
            //#line 220 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
            final boolean t$35639 = ((t$35638) <= (((long)(i$35255max$35641))));
            
            //#line 220 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
            if (!(t$35639)) {
                
                //#line 220 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
                break;
            }
            
            //#line 220 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
            final long j$35634 = i$35637;
            
            //#line 221 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
            final x10.io.Printer t$35625 = ((x10.io.Printer)(x10.io.Console.get$OUT()));
            
            //#line 221 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
            final long t$35626 = 100L;
            
            //#line 221 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
            final long t$35627 = ((t$35626) + (((long)(j$35634))));
            
            //#line 221 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
            final java.lang.String t$35628 = (("set@") + ((x10.core.Long.$box(t$35627))));
            
            //#line 221 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
            t$35625.println(((java.lang.Object)(t$35628)));
            
            //#line 222 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
            final long t$35629 = 100L;
            
            //#line 222 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
            final long t$35630 = ((t$35629) + (((long)(j$35634))));
            
            //#line 222 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
            final long t$35631 = 1000L;
            
            //#line 222 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
            final long t$35632 = ((10L) * (((long)(j$35634))));
            
            //#line 222 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
            final long t$35633 = ((t$35631) + (((long)(t$35632))));
            
            //#line 222 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
            ((cassia.util.Chunk<x10.core.Long>)c).$set__1cassia$util$Chunk$$T$G((long)(t$35630), x10.core.Long.$box(t$35633));
            
            //#line 220 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
            final long t$35635 = i$35637;
            
            //#line 220 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
            final long t$35636 = ((t$35635) + (((long)(1L))));
            
            //#line 220 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
            i$35637 = t$35636;
        }
        
        //#line 224 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
        final x10.io.Printer t$35510 = ((x10.io.Printer)(x10.io.Console.get$OUT()));
        
        //#line 224 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
        final java.lang.String t$35511 = (("Chunk :") + (c));
        
        //#line 224 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
        t$35510.println(((java.lang.Object)(t$35511)));
        
        //#line 225 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
        final long t$35512 = 100L;
        
        //#line 225 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
        final long t$35514 = 100L;
        
        //#line 225 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
        final long t$35513 = 100L;
        
        //#line 225 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
        final long t$35515 = 102L;
        
        //#line 225 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
        final cassia.util.RangedList r1 = ((cassia.util.RangedList<x10.core.Long>)
                                            ((cassia.util.Chunk<x10.core.Long>)c).subList((long)(t$35514), (long)(t$35515)));
        
        //#line 226 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
        final long t$35516 = 100L;
        
        //#line 226 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
        final long t$35518 = 102L;
        
        //#line 226 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
        final long t$35517 = 100L;
        
        //#line 226 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
        final long t$35519 = 108L;
        
        //#line 226 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
        final cassia.util.RangedList r2 = ((cassia.util.RangedList<x10.core.Long>)
                                            ((cassia.util.Chunk<x10.core.Long>)c).subList((long)(t$35518), (long)(t$35519)));
        
        //#line 227 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
        final long t$35520 = 100L;
        
        //#line 227 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
        final long t$35522 = 108L;
        
        //#line 227 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
        final long t$35521 = 100L;
        
        //#line 227 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
        final long t$35523 = 109L;
        
        //#line 227 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
        final cassia.util.RangedList r3 = ((cassia.util.RangedList<x10.core.Long>)
                                            ((cassia.util.Chunk<x10.core.Long>)c).subList((long)(t$35522), (long)(t$35523)));
        
        //#line 228 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
        final long t$35524 = 100L;
        
        //#line 228 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
        final long t$35526 = 100L;
        
        //#line 228 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
        final long t$35525 = 100L;
        
        //#line 228 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
        final long t$35527 = 109L;
        
        //#line 228 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
        final cassia.util.RangedList r0 = ((cassia.util.RangedList<x10.core.Long>)
                                            ((cassia.util.Chunk<x10.core.Long>)c).subList((long)(t$35526), (long)(t$35527)));
        
        //#line 229 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
        final x10.io.Printer t$35528 = ((x10.io.Printer)(x10.io.Console.get$OUT()));
        
        //#line 229 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
        final java.lang.String t$35529 = (("RangedListView :") + (r1));
        
        //#line 229 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
        t$35528.println(((java.lang.Object)(t$35529)));
        
        //#line 230 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
        final x10.io.Printer t$35530 = ((x10.io.Printer)(x10.io.Console.get$OUT()));
        
        //#line 230 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
        final java.lang.String t$35531 = (("RangedListView :") + (r2));
        
        //#line 230 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
        t$35530.println(((java.lang.Object)(t$35531)));
        
        //#line 231 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
        final x10.io.Printer t$35532 = ((x10.io.Printer)(x10.io.Console.get$OUT()));
        
        //#line 231 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
        final java.lang.String t$35533 = (("RangedListView :") + (r3));
        
        //#line 231 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
        t$35532.println(((java.lang.Object)(t$35533)));
        
        //#line 232 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
        final x10.io.Printer t$35534 = ((x10.io.Printer)(x10.io.Console.get$OUT()));
        
        //#line 232 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
        final java.lang.String t$35535 = (("RangedListView :") + (r0));
        
        //#line 232 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
        t$35534.println(((java.lang.Object)(t$35535)));
    }
    
    
    //#line 4 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
    final public cassia.util.RangedListView cassia$util$RangedListView$$this$cassia$util$RangedListView() {
        
        //#line 4 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
        return cassia.util.RangedListView.this;
    }
    
    
    //#line 4 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
    // creation method for java code (1-phase java constructor)
    public RangedListView(final x10.rtt.Type $T, final x10.util.List<$T> base, final x10.lang.LongRange range, __0$1cassia$util$RangedListView$$T$2 $dummy) {
        this((java.lang.System[]) null, $T);
        cassia$util$RangedListView$$init$S(base, range, (cassia.util.RangedListView.__0$1cassia$util$RangedListView$$T$2) null);
    }
    
    // constructor for non-virtual call
    final public cassia.util.RangedListView<$T> cassia$util$RangedListView$$init$S(final x10.util.List<$T> base, final x10.lang.LongRange range, __0$1cassia$util$RangedListView$$T$2 $dummy) {
         {
            
            //#line 4 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
            this.base = base;
            this.range = range;
            
            
            //#line 4 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
            this.__fieldInitializers_cassia_util_RangedListView();
        }
        return this;
    }
    
    
    
    //#line 4 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
    final public void __fieldInitializers_cassia_util_RangedListView() {
        
    }
    
    @x10.runtime.impl.java.X10Generated
    final public static class $Closure$31<$T, $U> extends x10.core.Ref implements x10.core.fun.VoidFun_0_1, x10.serialization.X10JavaSerializable
    {
        public static final x10.rtt.RuntimeType<$Closure$31> $RTT = 
            x10.rtt.StaticVoidFunType.<$Closure$31> make($Closure$31.class,
                                                         2,
                                                         new x10.rtt.Type[] {
                                                             x10.rtt.ParameterizedType.make(x10.core.fun.VoidFun_0_1.$RTT, x10.rtt.UnresolvedType.PARAM(0))
                                                         });
        
        public x10.rtt.RuntimeType<?> $getRTT() { return $RTT; }
        
        public x10.rtt.Type<?> $getParam(int i) { if (i == 0) return $T; if (i == 1) return $U; return null; }
        
        private Object writeReplace() throws java.io.ObjectStreamException {
            return new x10.serialization.SerializationProxy(this);
        }
        
        public static <$T, $U> x10.serialization.X10JavaSerializable $_deserialize_body(cassia.util.RangedListView.$Closure$31<$T, $U> $_obj, x10.serialization.X10JavaDeserializer $deserializer) throws java.io.IOException {
            if (x10.runtime.impl.java.Runtime.TRACE_SER) { x10.runtime.impl.java.Runtime.printTraceMessage("X10JavaSerializable: $_deserialize_body() of " + $Closure$31.class + " calling"); } 
            $_obj.$T = (x10.rtt.Type) $deserializer.readObject();
            $_obj.$U = (x10.rtt.Type) $deserializer.readObject();
            $_obj.op = $deserializer.readObject();
            $_obj.receiver = $deserializer.readObject();
            return $_obj;
        }
        
        public static x10.serialization.X10JavaSerializable $_deserializer(x10.serialization.X10JavaDeserializer $deserializer) throws java.io.IOException {
            cassia.util.RangedListView.$Closure$31 $_obj = new cassia.util.RangedListView.$Closure$31((java.lang.System[]) null, (x10.rtt.Type) null, (x10.rtt.Type) null);
            $deserializer.record_reference($_obj);
            return $_deserialize_body($_obj, $deserializer);
        }
        
        public void $_serialize(x10.serialization.X10JavaSerializer $serializer) throws java.io.IOException {
            $serializer.write(this.$T);
            $serializer.write(this.$U);
            $serializer.write(this.op);
            $serializer.write(this.receiver);
            
        }
        
        // constructor just for allocation
        public $Closure$31(final java.lang.System[] $dummy, final x10.rtt.Type $T, final x10.rtt.Type $U) {
            cassia.util.RangedListView.$Closure$31.$initParams(this, $T, $U);
            
        }
        
        // dispatcher for method abstract public (Z1)=>void.operator()(a1:Z1):void
        public java.lang.Object $apply(final java.lang.Object a1, final x10.rtt.Type t1) {
            $apply__0cassia$util$RangedListView$$Closure$31$$T(($T)a1); return null;
            
        }
        
        // dispatcher for method abstract public (Z1)=>void.operator()(a1:Z1):void
        public void $apply$V(final java.lang.Object a1, final x10.rtt.Type t1) {
            $apply__0cassia$util$RangedListView$$Closure$31$$T(($T)a1);
            
        }
        
        private x10.rtt.Type $T;
        private x10.rtt.Type $U;
        
        // initializer of type parameters
        public static void $initParams(final $Closure$31 $this, final x10.rtt.Type $T, final x10.rtt.Type $U) {
            $this.$T = $T;
            $this.$U = $U;
            
        }
        // synthetic type for parameter mangling
        public static final class __0$1cassia$util$RangedListView$$Closure$31$$T$3cassia$util$Receiver$1cassia$util$RangedListView$$Closure$31$$U$2$2__1$1cassia$util$RangedListView$$Closure$31$$U$2 {}
        
    
        
        public void $apply__0cassia$util$RangedListView$$Closure$31$$T(final $T t) {
            
            //#line 190 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
            ((x10.core.fun.VoidFun_0_2<$T,cassia.util.Receiver<$U>>)this.op).$apply(t, $T, this.receiver, x10.rtt.ParameterizedType.make(cassia.util.Receiver.$RTT, $U));
        }
        
        public x10.core.fun.VoidFun_0_2<$T,cassia.util.Receiver<$U>> op;
        public cassia.util.Receiver<$U> receiver;
        
        public $Closure$31(final x10.rtt.Type $T, final x10.rtt.Type $U, final x10.core.fun.VoidFun_0_2<$T,cassia.util.Receiver<$U>> op, final cassia.util.Receiver<$U> receiver, __0$1cassia$util$RangedListView$$Closure$31$$T$3cassia$util$Receiver$1cassia$util$RangedListView$$Closure$31$$U$2$2__1$1cassia$util$RangedListView$$Closure$31$$U$2 $dummy) {
            cassia.util.RangedListView.$Closure$31.$initParams(this, $T, $U);
             {
                ((cassia.util.RangedListView.$Closure$31<$T, $U>)this).op = ((x10.core.fun.VoidFun_0_2)(op));
                ((cassia.util.RangedListView.$Closure$31<$T, $U>)this).receiver = ((cassia.util.Receiver)(receiver));
            }
        }
        
    }
    
    @x10.runtime.impl.java.X10Generated
    final public static class $Closure$32<$T, $U> extends x10.core.Ref implements x10.core.fun.VoidFun_0_1, x10.serialization.X10JavaSerializable
    {
        public static final x10.rtt.RuntimeType<$Closure$32> $RTT = 
            x10.rtt.StaticVoidFunType.<$Closure$32> make($Closure$32.class,
                                                         2,
                                                         new x10.rtt.Type[] {
                                                             x10.rtt.ParameterizedType.make(x10.core.fun.VoidFun_0_1.$RTT, x10.rtt.UnresolvedType.PARAM(0))
                                                         });
        
        public x10.rtt.RuntimeType<?> $getRTT() { return $RTT; }
        
        public x10.rtt.Type<?> $getParam(int i) { if (i == 0) return $T; if (i == 1) return $U; return null; }
        
        private Object writeReplace() throws java.io.ObjectStreamException {
            return new x10.serialization.SerializationProxy(this);
        }
        
        public static <$T, $U> x10.serialization.X10JavaSerializable $_deserialize_body(cassia.util.RangedListView.$Closure$32<$T, $U> $_obj, x10.serialization.X10JavaDeserializer $deserializer) throws java.io.IOException {
            if (x10.runtime.impl.java.Runtime.TRACE_SER) { x10.runtime.impl.java.Runtime.printTraceMessage("X10JavaSerializable: $_deserialize_body() of " + $Closure$32.class + " calling"); } 
            $_obj.$T = (x10.rtt.Type) $deserializer.readObject();
            $_obj.$U = (x10.rtt.Type) $deserializer.readObject();
            $_obj.op = $deserializer.readObject();
            $_obj.receiver = $deserializer.readObject();
            return $_obj;
        }
        
        public static x10.serialization.X10JavaSerializable $_deserializer(x10.serialization.X10JavaDeserializer $deserializer) throws java.io.IOException {
            cassia.util.RangedListView.$Closure$32 $_obj = new cassia.util.RangedListView.$Closure$32((java.lang.System[]) null, (x10.rtt.Type) null, (x10.rtt.Type) null);
            $deserializer.record_reference($_obj);
            return $_deserialize_body($_obj, $deserializer);
        }
        
        public void $_serialize(x10.serialization.X10JavaSerializer $serializer) throws java.io.IOException {
            $serializer.write(this.$T);
            $serializer.write(this.$U);
            $serializer.write(this.op);
            $serializer.write(this.receiver);
            
        }
        
        // constructor just for allocation
        public $Closure$32(final java.lang.System[] $dummy, final x10.rtt.Type $T, final x10.rtt.Type $U) {
            cassia.util.RangedListView.$Closure$32.$initParams(this, $T, $U);
            
        }
        
        // dispatcher for method abstract public (Z1)=>void.operator()(a1:Z1):void
        public java.lang.Object $apply(final java.lang.Object a1, final x10.rtt.Type t1) {
            $apply__0cassia$util$RangedListView$$Closure$32$$T(($T)a1); return null;
            
        }
        
        // dispatcher for method abstract public (Z1)=>void.operator()(a1:Z1):void
        public void $apply$V(final java.lang.Object a1, final x10.rtt.Type t1) {
            $apply__0cassia$util$RangedListView$$Closure$32$$T(($T)a1);
            
        }
        
        private x10.rtt.Type $T;
        private x10.rtt.Type $U;
        
        // initializer of type parameters
        public static void $initParams(final $Closure$32 $this, final x10.rtt.Type $T, final x10.rtt.Type $U) {
            $this.$T = $T;
            $this.$U = $U;
            
        }
        // synthetic type for parameter mangling
        public static final class __0$1cassia$util$RangedListView$$Closure$32$$T$3cassia$util$Receiver$1cassia$util$RangedListView$$Closure$32$$U$2$2__1$1cassia$util$RangedListView$$Closure$32$$U$2 {}
        
    
        
        public void $apply__0cassia$util$RangedListView$$Closure$32$$T(final $T t) {
            
            //#line 194 "/home/dsl/workspace/plhamK/cassia/util/RangedListView.x10"
            ((x10.core.fun.VoidFun_0_2<$T,cassia.util.Receiver<$U>>)this.op).$apply(t, $T, this.receiver, x10.rtt.ParameterizedType.make(cassia.util.Receiver.$RTT, $U));
        }
        
        public x10.core.fun.VoidFun_0_2<$T,cassia.util.Receiver<$U>> op;
        public cassia.util.Receiver<$U> receiver;
        
        public $Closure$32(final x10.rtt.Type $T, final x10.rtt.Type $U, final x10.core.fun.VoidFun_0_2<$T,cassia.util.Receiver<$U>> op, final cassia.util.Receiver<$U> receiver, __0$1cassia$util$RangedListView$$Closure$32$$T$3cassia$util$Receiver$1cassia$util$RangedListView$$Closure$32$$U$2$2__1$1cassia$util$RangedListView$$Closure$32$$U$2 $dummy) {
            cassia.util.RangedListView.$Closure$32.$initParams(this, $T, $U);
             {
                ((cassia.util.RangedListView.$Closure$32<$T, $U>)this).op = ((x10.core.fun.VoidFun_0_2)(op));
                ((cassia.util.RangedListView.$Closure$32<$T, $U>)this).receiver = ((cassia.util.Receiver)(receiver));
            }
        }
        
    }
    
}

