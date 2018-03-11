package plham.util;



public class SubSettable<$T> extends x10.core.Ref implements x10.lang.Settable, x10.serialization.X10JavaSerializable
{
    public static final x10.rtt.RuntimeType<SubSettable> $RTT = 
        x10.rtt.NamedType.<SubSettable> make("plham.util.SubSettable",
                                             SubSettable.class,
                                             1,
                                             new x10.rtt.Type[] {
                                                 x10.rtt.ParameterizedType.make(x10.lang.Settable.$RTT, x10.rtt.Types.LONG, x10.rtt.UnresolvedType.PARAM(0))
                                             });
    
    public x10.rtt.RuntimeType<?> $getRTT() { return $RTT; }
    
    public x10.rtt.Type<?> $getParam(int i) { if (i == 0) return $T; return null; }
    
    private Object writeReplace() throws java.io.ObjectStreamException {
        return new x10.serialization.SerializationProxy(this);
    }
    
    public static <$T> x10.serialization.X10JavaSerializable $_deserialize_body(plham.util.SubSettable<$T> $_obj, x10.serialization.X10JavaDeserializer $deserializer) throws java.io.IOException {
        if (x10.runtime.impl.java.Runtime.TRACE_SER) { x10.runtime.impl.java.Runtime.printTraceMessage("X10JavaSerializable: $_deserialize_body() of " + SubSettable.class + " calling"); } 
        $_obj.$T = (x10.rtt.Type) $deserializer.readObject();
        $_obj.body = $deserializer.readObject();
        $_obj.range = $deserializer.readObject();
        $_obj.tmp = $deserializer.readObject();
        return $_obj;
    }
    
    public static x10.serialization.X10JavaSerializable $_deserializer(x10.serialization.X10JavaDeserializer $deserializer) throws java.io.IOException {
        plham.util.SubSettable $_obj = new plham.util.SubSettable((java.lang.System[]) null, (x10.rtt.Type) null);
        $deserializer.record_reference($_obj);
        return $_deserialize_body($_obj, $deserializer);
    }
    
    public void $_serialize(x10.serialization.X10JavaSerializer $serializer) throws java.io.IOException {
        $serializer.write(this.$T);
        $serializer.write(this.body);
        $serializer.write(this.range);
        $serializer.write(this.tmp);
        
    }
    
    // constructor just for allocation
    public SubSettable(final java.lang.System[] $dummy, final x10.rtt.Type $T) {
        plham.util.SubSettable.$initParams(this, $T);
        
    }
    
    // dispatcher for method abstract public x10.lang.Settable.operator()=(i:I, v:V){}:V
    public java.lang.Object $set(final java.lang.Object a1, final x10.rtt.Type t1, final java.lang.Object a2, final x10.rtt.Type t2) {
        return $set__1plham$util$SubSettable$$T$G(x10.core.Long.$unbox(a1), ($T)a2);
        
    }
    
    private x10.rtt.Type $T;
    
    // initializer of type parameters
    public static void $initParams(final SubSettable $this, final x10.rtt.Type $T) {
        $this.$T = $T;
        
    }
    // synthetic type for parameter mangling
    public static final class __0$1x10$lang$Long$3plham$util$SubSettable$$T$2__2$1x10$lang$Long$3plham$util$SubSettable$$T$2 {}
    
    // properties
    
    //#line 4 "/home/dsl/workspace/plhamK/plham/util/SubSettable.x10"
    public x10.lang.Settable<x10.core.Long, $T> body;
    
    //#line 4 "/home/dsl/workspace/plhamK/plham/util/SubSettable.x10"
    public x10.lang.LongRange range;
    
    //#line 4 "/home/dsl/workspace/plhamK/plham/util/SubSettable.x10"
    public x10.lang.Settable<x10.core.Long, $T> tmp;
    

    
    
    //#line 6 "/home/dsl/workspace/plhamK/plham/util/SubSettable.x10"
    public static <$T>plham.util.SubSettable getEmptyOne(final x10.rtt.Type $T) {
        
        //#line 6 "/home/dsl/workspace/plhamK/plham/util/SubSettable.x10"
        final x10.lang.Settable t$25862 = ((null));
        
        //#line 6 "/home/dsl/workspace/plhamK/plham/util/SubSettable.x10"
        final x10.lang.LongRange t$25863 = ((new x10.lang.LongRange((java.lang.System[]) null).x10$lang$LongRange$$init$S(((0L)), ((-1L)))));
        
        //#line 6 "/home/dsl/workspace/plhamK/plham/util/SubSettable.x10"
        final plham.util.SubSettable t$25864 = ((new plham.util.SubSettable<$T>((java.lang.System[]) null, $T).plham$util$SubSettable$$init$S(t$25862, ((t$25863)), ((x10.lang.Settable<x10.core.Long, $T>)(null)), (plham.util.SubSettable.__0$1x10$lang$Long$3plham$util$SubSettable$$T$2__2$1x10$lang$Long$3plham$util$SubSettable$$T$2) null)));
        
        //#line 6 "/home/dsl/workspace/plhamK/plham/util/SubSettable.x10"
        return t$25864;
    }
    
    
    //#line 7 "/home/dsl/workspace/plhamK/plham/util/SubSettable.x10"
    public x10.lang.LongRange getRange() {
        
        //#line 7 "/home/dsl/workspace/plhamK/plham/util/SubSettable.x10"
        final x10.lang.LongRange t$25865 = ((this.range));
        
        //#line 7 "/home/dsl/workspace/plhamK/plham/util/SubSettable.x10"
        return t$25865;
    }
    
    
    //#line 8 "/home/dsl/workspace/plhamK/plham/util/SubSettable.x10"
    public x10.lang.Settable getBody() {
        
        //#line 8 "/home/dsl/workspace/plhamK/plham/util/SubSettable.x10"
        final x10.lang.Settable t$25866 = ((this.body));
        
        //#line 8 "/home/dsl/workspace/plhamK/plham/util/SubSettable.x10"
        return t$25866;
    }
    
    
    //#line 10 "/home/dsl/workspace/plhamK/plham/util/SubSettable.x10"
    public long size$O() {
        
        //#line 11 "/home/dsl/workspace/plhamK/plham/util/SubSettable.x10"
        final x10.lang.LongRange t$25867 = ((this.range));
        
        //#line 11 "/home/dsl/workspace/plhamK/plham/util/SubSettable.x10"
        final long t$25869 = t$25867.max;
        
        //#line 11 "/home/dsl/workspace/plhamK/plham/util/SubSettable.x10"
        final x10.lang.LongRange t$25868 = ((this.range));
        
        //#line 11 "/home/dsl/workspace/plhamK/plham/util/SubSettable.x10"
        final long t$25870 = t$25868.min;
        
        //#line 11 "/home/dsl/workspace/plhamK/plham/util/SubSettable.x10"
        final long t$25871 = ((t$25869) - (((t$25870))));
        
        //#line 11 "/home/dsl/workspace/plhamK/plham/util/SubSettable.x10"
        final long t = ((t$25871) + (((1L))));
        
        //#line 12 "/home/dsl/workspace/plhamK/plham/util/SubSettable.x10"
        final boolean t$25872 = ((t) < (((0L))));
        
        //#line 12 "/home/dsl/workspace/plhamK/plham/util/SubSettable.x10"
        long t$25873 =  0;
        
        //#line 12 "/home/dsl/workspace/plhamK/plham/util/SubSettable.x10"
        if (t$25872) {
            
            //#line 12 "/home/dsl/workspace/plhamK/plham/util/SubSettable.x10"
            t$25873 = 0L;
        } else {
            
            //#line 12 "/home/dsl/workspace/plhamK/plham/util/SubSettable.x10"
            t$25873 = t;
        }
        
        //#line 12 "/home/dsl/workspace/plhamK/plham/util/SubSettable.x10"
        final long t$25874 = t$25873;
        
        //#line 12 "/home/dsl/workspace/plhamK/plham/util/SubSettable.x10"
        return t$25874;
    }
    
    
    //#line 15 "/home/dsl/workspace/plhamK/plham/util/SubSettable.x10"
    public boolean isEmpty$O() {
        
        //#line 15 "/home/dsl/workspace/plhamK/plham/util/SubSettable.x10"
        final long t$25875 = this.size$O();
        
        //#line 15 "/home/dsl/workspace/plhamK/plham/util/SubSettable.x10"
        final boolean t$25876 = ((t$25875) < (((0L))));
        
        //#line 15 "/home/dsl/workspace/plhamK/plham/util/SubSettable.x10"
        return t$25876;
    }
    
    
    //#line 16 "/home/dsl/workspace/plhamK/plham/util/SubSettable.x10"
    public $T $set__1plham$util$SubSettable$$T$G(final long i, final $T v) {
        
        //#line 17 "/home/dsl/workspace/plhamK/plham/util/SubSettable.x10"
        assert ((this.body) != (null)): "SubSettable: access to empty (null) SubSettable";
        
        //#line 18 "/home/dsl/workspace/plhamK/plham/util/SubSettable.x10"
        assert !(this.isEmpty$O()): (("SubSettable: access to empty SubSettable") + (this.range));
        
        //#line 19 "/home/dsl/workspace/plhamK/plham/util/SubSettable.x10"
        assert ((this.range.min) <= (((i)))) && ((i) <= (((this.range.max)))): (((((("SubSettable: access to the element No. ") + ((x10.core.Long.$box(i))))) + (" is range out of "))) + (this.range));
        
        //#line 20 "/home/dsl/workspace/plhamK/plham/util/SubSettable.x10"
        final x10.lang.Settable t$25877 = ((this.body));
        
        //#line 20 "/home/dsl/workspace/plhamK/plham/util/SubSettable.x10"
        ((x10.lang.Settable<x10.core.Long, $T>)t$25877).$set(x10.core.Long.$box(i), x10.rtt.Types.LONG, ((v)), $T);
        
        //#line 21 "/home/dsl/workspace/plhamK/plham/util/SubSettable.x10"
        final x10.lang.Settable t$25878 = ((this.tmp));
        
        //#line 21 "/home/dsl/workspace/plhamK/plham/util/SubSettable.x10"
        final boolean t$25880 = ((t$25878) != (null));
        
        //#line 21 "/home/dsl/workspace/plhamK/plham/util/SubSettable.x10"
        if (t$25880) {
            
            //#line 21 "/home/dsl/workspace/plhamK/plham/util/SubSettable.x10"
            final x10.lang.Settable t$25879 = ((this.tmp));
            
            //#line 21 "/home/dsl/workspace/plhamK/plham/util/SubSettable.x10"
            ((x10.lang.Settable<x10.core.Long, $T>)t$25879).$set(x10.core.Long.$box(i), x10.rtt.Types.LONG, ((v)), $T);
        }
        
        //#line 22 "/home/dsl/workspace/plhamK/plham/util/SubSettable.x10"
        return v;
    }
    
    
    //#line 4 "/home/dsl/workspace/plhamK/plham/util/SubSettable.x10"
    final public plham.util.SubSettable plham$util$SubSettable$$this$plham$util$SubSettable() {
        
        //#line 4 "/home/dsl/workspace/plhamK/plham/util/SubSettable.x10"
        return plham.util.SubSettable.this;
    }
    
    
    //#line 4 "/home/dsl/workspace/plhamK/plham/util/SubSettable.x10"
    // creation method for java code (1-phase java constructor)
    public SubSettable(final x10.rtt.Type $T, final x10.lang.Settable<x10.core.Long, $T> body, final x10.lang.LongRange range, final x10.lang.Settable<x10.core.Long, $T> tmp, __0$1x10$lang$Long$3plham$util$SubSettable$$T$2__2$1x10$lang$Long$3plham$util$SubSettable$$T$2 $dummy) {
        this((java.lang.System[]) null, $T);
        plham$util$SubSettable$$init$S(body, range, tmp, (plham.util.SubSettable.__0$1x10$lang$Long$3plham$util$SubSettable$$T$2__2$1x10$lang$Long$3plham$util$SubSettable$$T$2) null);
    }
    
    // constructor for non-virtual call
    final public plham.util.SubSettable<$T> plham$util$SubSettable$$init$S(final x10.lang.Settable<x10.core.Long, $T> body, final x10.lang.LongRange range, final x10.lang.Settable<x10.core.Long, $T> tmp, __0$1x10$lang$Long$3plham$util$SubSettable$$T$2__2$1x10$lang$Long$3plham$util$SubSettable$$T$2 $dummy) {
         {
            
            //#line 4 "/home/dsl/workspace/plhamK/plham/util/SubSettable.x10"
            this.body = body;
            this.range = range;
            this.tmp = tmp;
            
            
            //#line 4 "/home/dsl/workspace/plhamK/plham/util/SubSettable.x10"
            this.__fieldInitializers_plham_util_SubSettable();
        }
        return this;
    }
    
    
    
    //#line 4 "/home/dsl/workspace/plhamK/plham/util/SubSettable.x10"
    final public void __fieldInitializers_plham_util_SubSettable() {
        
    }
}

