package cassia.util.random;


/**
 * Knuth-Fisher-Yates shuffle.
 * Reference: http://en.wikipedia.org/wiki/Fisher-Yates_shuffle
 */
@x10.runtime.impl.java.X10Generated
public class RandomPermutation<$T> extends x10.core.Ref implements x10.lang.Iterable, x10.serialization.X10JavaSerializable
{
    public static final x10.rtt.RuntimeType<RandomPermutation> $RTT = 
        x10.rtt.NamedType.<RandomPermutation> make("cassia.util.random.RandomPermutation",
                                                   RandomPermutation.class,
                                                   1,
                                                   new x10.rtt.Type[] {
                                                       x10.rtt.ParameterizedType.make(x10.lang.Iterable.$RTT, x10.rtt.UnresolvedType.PARAM(0))
                                                   });
    
    public x10.rtt.RuntimeType<?> $getRTT() { return $RTT; }
    
    public x10.rtt.Type<?> $getParam(int i) { if (i == 0) return $T; return null; }
    
    private Object writeReplace() throws java.io.ObjectStreamException {
        return new x10.serialization.SerializationProxy(this);
    }
    
    public static <$T> x10.serialization.X10JavaSerializable $_deserialize_body(cassia.util.random.RandomPermutation<$T> $_obj, x10.serialization.X10JavaDeserializer $deserializer) throws java.io.IOException {
        if (x10.runtime.impl.java.Runtime.TRACE_SER) { x10.runtime.impl.java.Runtime.printTraceMessage("X10JavaSerializable: $_deserialize_body() of " + RandomPermutation.class + " calling"); } 
        $_obj.$T = (x10.rtt.Type) $deserializer.readObject();
        $_obj.array = $deserializer.readObject();
        $_obj.random = $deserializer.readObject();
        return $_obj;
    }
    
    public static x10.serialization.X10JavaSerializable $_deserializer(x10.serialization.X10JavaDeserializer $deserializer) throws java.io.IOException {
        cassia.util.random.RandomPermutation $_obj = new cassia.util.random.RandomPermutation((java.lang.System[]) null, (x10.rtt.Type) null);
        $deserializer.record_reference($_obj);
        return $_deserialize_body($_obj, $deserializer);
    }
    
    public void $_serialize(x10.serialization.X10JavaSerializer $serializer) throws java.io.IOException {
        $serializer.write(this.$T);
        $serializer.write(this.array);
        $serializer.write(this.random);
        
    }
    
    // constructor just for allocation
    public RandomPermutation(final java.lang.System[] $dummy, final x10.rtt.Type $T) {
        cassia.util.random.RandomPermutation.$initParams(this, $T);
        
    }
    
    private x10.rtt.Type $T;
    
    // initializer of type parameters
    public static void $initParams(final RandomPermutation $this, final x10.rtt.Type $T) {
        $this.$T = $T;
        
    }
    // synthetic type for parameter mangling
    public static final class __1$1cassia$util$random$RandomPermutation$$T$2 {}
    

    
    //#line 13 "/home/dsl/workspace/plhamK/cassia/util/random/RandomPermutation.x10"
    public x10.util.List<$T> array;
    
    //#line 14 "/home/dsl/workspace/plhamK/cassia/util/random/RandomPermutation.x10"
    public x10.util.Random random;
    
    
    //#line 16 "/home/dsl/workspace/plhamK/cassia/util/random/RandomPermutation.x10"
    // creation method for java code (1-phase java constructor)
    public RandomPermutation(final x10.rtt.Type $T, final x10.util.Random random, final x10.util.Indexed<$T> array0, __1$1cassia$util$random$RandomPermutation$$T$2 $dummy) {
        this((java.lang.System[]) null, $T);
        cassia$util$random$RandomPermutation$$init$S(random, array0, (cassia.util.random.RandomPermutation.__1$1cassia$util$random$RandomPermutation$$T$2) null);
    }
    
    // constructor for non-virtual call
    final public cassia.util.random.RandomPermutation<$T> cassia$util$random$RandomPermutation$$init$S(final x10.util.Random random, final x10.util.Indexed<$T> array0, __1$1cassia$util$random$RandomPermutation$$T$2 $dummy) {
         {
            
            //#line 16 "/home/dsl/workspace/plhamK/cassia/util/random/RandomPermutation.x10"
            
            
            //#line 11 "/home/dsl/workspace/plhamK/cassia/util/random/RandomPermutation.x10"
            this.__fieldInitializers_cassia_util_random_RandomPermutation();
            
            //#line 17 "/home/dsl/workspace/plhamK/cassia/util/random/RandomPermutation.x10"
            this.random = ((random));
            
            //#line 18 "/home/dsl/workspace/plhamK/cassia/util/random/RandomPermutation.x10"
            final x10.util.ArrayList t$33476 = ((new x10.util.ArrayList<$T>((java.lang.System[]) null, $T).x10$util$ArrayList$$init$S()));
            
            //#line 18 "/home/dsl/workspace/plhamK/cassia/util/random/RandomPermutation.x10"
            this.array = ((t$33476));
            
            //#line 19 "/home/dsl/workspace/plhamK/cassia/util/random/RandomPermutation.x10"
            final x10.util.List t$33477 = ((this.array));
            
            //#line 19 "/home/dsl/workspace/plhamK/cassia/util/random/RandomPermutation.x10"
            ((x10.util.Collection<$T>)t$33477).addAll$Z(((array0)), x10.rtt.ParameterizedType.make(x10.util.Container.$RTT, $T));
        }
        return this;
    }
    
    
    
    //#line 25 "/home/dsl/workspace/plhamK/cassia/util/random/RandomPermutation.x10"
    /**
	 * Randomize the array.
	 */
    public void shuffle() {
        
        //#line 26 "/home/dsl/workspace/plhamK/cassia/util/random/RandomPermutation.x10"
        final x10.util.List t$33478 = ((this.array));
        
        //#line 26 "/home/dsl/workspace/plhamK/cassia/util/random/RandomPermutation.x10"
        final long size = ((x10.util.Container<$T>)t$33478).size$O();
        
        //#line 27 "/home/dsl/workspace/plhamK/cassia/util/random/RandomPermutation.x10"
        long i$33519 = ((size) - (((1L))));
        
        //#line 27 "/home/dsl/workspace/plhamK/cassia/util/random/RandomPermutation.x10"
        for (;
             true;
             ) {
            
            //#line 27 "/home/dsl/workspace/plhamK/cassia/util/random/RandomPermutation.x10"
            final long t$33520 = i$33519;
            
            //#line 27 "/home/dsl/workspace/plhamK/cassia/util/random/RandomPermutation.x10"
            final boolean t$33521 = ((t$33520) > (((0L))));
            
            //#line 27 "/home/dsl/workspace/plhamK/cassia/util/random/RandomPermutation.x10"
            if (!(t$33521)) {
                
                //#line 27 "/home/dsl/workspace/plhamK/cassia/util/random/RandomPermutation.x10"
                break;
            }
            
            //#line 28 "/home/dsl/workspace/plhamK/cassia/util/random/RandomPermutation.x10"
            final x10.util.Random t$33505 = ((this.random));
            
            //#line 28 "/home/dsl/workspace/plhamK/cassia/util/random/RandomPermutation.x10"
            final long t$33506 = i$33519;
            
            //#line 28 "/home/dsl/workspace/plhamK/cassia/util/random/RandomPermutation.x10"
            final long t$33507 = ((t$33506) + (((1L))));
            
            //#line 28 "/home/dsl/workspace/plhamK/cassia/util/random/RandomPermutation.x10"
            final long j$33508 = t$33505.nextLong$O((t$33507));
            
            //#line 29 "/home/dsl/workspace/plhamK/cassia/util/random/RandomPermutation.x10"
            final x10.util.List t$33509 = ((this.array));
            
            //#line 29 "/home/dsl/workspace/plhamK/cassia/util/random/RandomPermutation.x10"
            final $T temp$33510 = ((((x10.util.Indexed<$T>)t$33509).$apply$G((j$33508))));
            
            //#line 30 "/home/dsl/workspace/plhamK/cassia/util/random/RandomPermutation.x10"
            final x10.util.List t$33511 = ((this.array));
            
            //#line 30 "/home/dsl/workspace/plhamK/cassia/util/random/RandomPermutation.x10"
            final x10.util.List t$33512 = ((this.array));
            
            //#line 30 "/home/dsl/workspace/plhamK/cassia/util/random/RandomPermutation.x10"
            final long t$33513 = i$33519;
            
            //#line 30 "/home/dsl/workspace/plhamK/cassia/util/random/RandomPermutation.x10"
            final $T t$33514 = ((((x10.util.Indexed<$T>)t$33512).$apply$G((t$33513))));
            
            //#line 30 "/home/dsl/workspace/plhamK/cassia/util/random/RandomPermutation.x10"
            ((x10.lang.Settable<x10.core.Long, $T>)t$33511).$set(x10.core.Long.$box(j$33508), x10.rtt.Types.LONG, ((t$33514)), $T);
            
            //#line 31 "/home/dsl/workspace/plhamK/cassia/util/random/RandomPermutation.x10"
            final x10.util.List t$33515 = ((this.array));
            
            //#line 31 "/home/dsl/workspace/plhamK/cassia/util/random/RandomPermutation.x10"
            final long t$33516 = i$33519;
            
            //#line 31 "/home/dsl/workspace/plhamK/cassia/util/random/RandomPermutation.x10"
            ((x10.lang.Settable<x10.core.Long, $T>)t$33515).$set(x10.core.Long.$box(t$33516), x10.rtt.Types.LONG, ((temp$33510)), $T);
            
            //#line 27 "/home/dsl/workspace/plhamK/cassia/util/random/RandomPermutation.x10"
            final long t$33517 = i$33519;
            
            //#line 27 "/home/dsl/workspace/plhamK/cassia/util/random/RandomPermutation.x10"
            final long t$33518 = ((t$33517) - (((1L))));
            
            //#line 27 "/home/dsl/workspace/plhamK/cassia/util/random/RandomPermutation.x10"
            i$33519 = t$33518;
        }
    }
    
    
    //#line 35 "/home/dsl/workspace/plhamK/cassia/util/random/RandomPermutation.x10"
    public x10.lang.Iterator iterator() {
        
        //#line 36 "/home/dsl/workspace/plhamK/cassia/util/random/RandomPermutation.x10"
        final x10.util.List t$33494 = ((this.array));
        
        //#line 36 "/home/dsl/workspace/plhamK/cassia/util/random/RandomPermutation.x10"
        final x10.util.ListIterator t$33495 = (((x10.util.List<$T>)t$33494).iterator());
        
        //#line 36 "/home/dsl/workspace/plhamK/cassia/util/random/RandomPermutation.x10"
        return t$33495;
    }
    
    
    //#line 39 "/home/dsl/workspace/plhamK/cassia/util/random/RandomPermutation.x10"
    public java.lang.String toString() {
        
        //#line 40 "/home/dsl/workspace/plhamK/cassia/util/random/RandomPermutation.x10"
        final x10.util.List t$33496 = ((this.array));
        
        //#line 40 "/home/dsl/workspace/plhamK/cassia/util/random/RandomPermutation.x10"
        final java.lang.String t$33497 = x10.rtt.Types.toString(((t$33496)));
        
        //#line 40 "/home/dsl/workspace/plhamK/cassia/util/random/RandomPermutation.x10"
        return t$33497;
    }
    
    
    //#line 43 "/home/dsl/workspace/plhamK/cassia/util/random/RandomPermutation.x10"
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
            RandomPermutation.main(args);
        }
    }
    
    // the original app-main method
    public static void main(final x10.core.Rail<java.lang.String> id$4167) {
        
        //#line 44 "/home/dsl/workspace/plhamK/cassia/util/random/RandomPermutation.x10"
        final x10.util.ArrayList a = ((new x10.util.ArrayList<x10.core.Long>((java.lang.System[]) null, x10.rtt.Types.LONG).x10$util$ArrayList$$init$S()));
        
        //#line 45 "/home/dsl/workspace/plhamK/cassia/util/random/RandomPermutation.x10"
        ((x10.util.ArrayList<x10.core.Long>)a).add__0x10$util$ArrayList$$T$O(x10.core.Long.$box(1L));
        
        //#line 46 "/home/dsl/workspace/plhamK/cassia/util/random/RandomPermutation.x10"
        ((x10.util.ArrayList<x10.core.Long>)a).add__0x10$util$ArrayList$$T$O(x10.core.Long.$box(2L));
        
        //#line 47 "/home/dsl/workspace/plhamK/cassia/util/random/RandomPermutation.x10"
        ((x10.util.ArrayList<x10.core.Long>)a).add__0x10$util$ArrayList$$T$O(x10.core.Long.$box(3L));
        
        //#line 48 "/home/dsl/workspace/plhamK/cassia/util/random/RandomPermutation.x10"
        ((x10.util.ArrayList<x10.core.Long>)a).add__0x10$util$ArrayList$$T$O(x10.core.Long.$box(100L));
        
        //#line 49 "/home/dsl/workspace/plhamK/cassia/util/random/RandomPermutation.x10"
        ((x10.util.ArrayList<x10.core.Long>)a).add__0x10$util$ArrayList$$T$O(x10.core.Long.$box(999L));
        
        //#line 51 "/home/dsl/workspace/plhamK/cassia/util/random/RandomPermutation.x10"
        final x10.util.Random t$33498 = ((new x10.util.Random((java.lang.System[]) null).x10$util$Random$$init$S()));
        
        //#line 51 "/home/dsl/workspace/plhamK/cassia/util/random/RandomPermutation.x10"
        final cassia.util.random.RandomPermutation p = ((new cassia.util.random.RandomPermutation<x10.core.Long>((java.lang.System[]) null, x10.rtt.Types.LONG).cassia$util$random$RandomPermutation$$init$S(((t$33498)), ((a)), (cassia.util.random.RandomPermutation.__1$1cassia$util$random$RandomPermutation$$T$2) null)));
        
        //#line 52 "/home/dsl/workspace/plhamK/cassia/util/random/RandomPermutation.x10"
        final long i$33459min$33529 = 0L;
        
        //#line 52 "/home/dsl/workspace/plhamK/cassia/util/random/RandomPermutation.x10"
        final long i$33459max$33530 = 10L;
        
        //#line 52 "/home/dsl/workspace/plhamK/cassia/util/random/RandomPermutation.x10"
        long i$33526 = i$33459min$33529;
        
        //#line 52 "/home/dsl/workspace/plhamK/cassia/util/random/RandomPermutation.x10"
        for (;
             true;
             ) {
            
            //#line 52 "/home/dsl/workspace/plhamK/cassia/util/random/RandomPermutation.x10"
            final long t$33527 = i$33526;
            
            //#line 52 "/home/dsl/workspace/plhamK/cassia/util/random/RandomPermutation.x10"
            final boolean t$33528 = ((t$33527) <= (((i$33459max$33530))));
            
            //#line 52 "/home/dsl/workspace/plhamK/cassia/util/random/RandomPermutation.x10"
            if (!(t$33528)) {
                
                //#line 52 "/home/dsl/workspace/plhamK/cassia/util/random/RandomPermutation.x10"
                break;
            }
            
            //#line 52 "/home/dsl/workspace/plhamK/cassia/util/random/RandomPermutation.x10"
            final long i$33523 = i$33526;
            
            //#line 53 "/home/dsl/workspace/plhamK/cassia/util/random/RandomPermutation.x10"
            final x10.io.Printer t$33522 = ((x10.io.Console.get$OUT()));
            
            //#line 53 "/home/dsl/workspace/plhamK/cassia/util/random/RandomPermutation.x10"
            t$33522.println(((p)));
            
            //#line 54 "/home/dsl/workspace/plhamK/cassia/util/random/RandomPermutation.x10"
            ((cassia.util.random.RandomPermutation<x10.core.Long>)p).shuffle();
            
            //#line 52 "/home/dsl/workspace/plhamK/cassia/util/random/RandomPermutation.x10"
            final long t$33524 = i$33526;
            
            //#line 52 "/home/dsl/workspace/plhamK/cassia/util/random/RandomPermutation.x10"
            final long t$33525 = ((t$33524) + (((1L))));
            
            //#line 52 "/home/dsl/workspace/plhamK/cassia/util/random/RandomPermutation.x10"
            i$33526 = t$33525;
        }
    }
    
    
    //#line 11 "/home/dsl/workspace/plhamK/cassia/util/random/RandomPermutation.x10"
    final public cassia.util.random.RandomPermutation cassia$util$random$RandomPermutation$$this$cassia$util$random$RandomPermutation() {
        
        //#line 11 "/home/dsl/workspace/plhamK/cassia/util/random/RandomPermutation.x10"
        return cassia.util.random.RandomPermutation.this;
    }
    
    
    //#line 11 "/home/dsl/workspace/plhamK/cassia/util/random/RandomPermutation.x10"
    final public void __fieldInitializers_cassia_util_random_RandomPermutation() {
        
        //#line 11 "/home/dsl/workspace/plhamK/cassia/util/random/RandomPermutation.x10"
        this.array = null;
        
        //#line 11 "/home/dsl/workspace/plhamK/cassia/util/random/RandomPermutation.x10"
        this.random = null;
    }
}

