package plham.util;


/** 
 * This generates a sequence of Randoms split from a given Random,
 * and only allows sequential access to its elements.
 */

final public class RandomSequenceBySplit extends x10.core.Ref implements x10.util.Indexed, x10.serialization.X10JavaSerializable
{
    public static final x10.rtt.RuntimeType<RandomSequenceBySplit> $RTT = 
        x10.rtt.NamedType.<RandomSequenceBySplit> make("plham.util.RandomSequenceBySplit",
                                                       RandomSequenceBySplit.class,
                                                       new x10.rtt.Type[] {
                                                           x10.rtt.ParameterizedType.make(x10.util.Indexed.$RTT, x10.util.Random.$RTT)
                                                       });
    
    public x10.rtt.RuntimeType<?> $getRTT() { return $RTT; }
    
    public x10.rtt.Type<?> $getParam(int i) { return null; }
    
    private Object writeReplace() throws java.io.ObjectStreamException {
        return new x10.serialization.SerializationProxy(this);
    }
    
    public static x10.serialization.X10JavaSerializable $_deserialize_body(plham.util.RandomSequenceBySplit $_obj, x10.serialization.X10JavaDeserializer $deserializer) throws java.io.IOException {
        if (x10.runtime.impl.java.Runtime.TRACE_SER) { x10.runtime.impl.java.Runtime.printTraceMessage("X10JavaSerializable: $_deserialize_body() of " + RandomSequenceBySplit.class + " calling"); } 
        $_obj.current = $deserializer.readObject();
        $_obj.index = $deserializer.readLong();
        $_obj.rand = $deserializer.readObject();
        return $_obj;
    }
    
    public static x10.serialization.X10JavaSerializable $_deserializer(x10.serialization.X10JavaDeserializer $deserializer) throws java.io.IOException {
        plham.util.RandomSequenceBySplit $_obj = new plham.util.RandomSequenceBySplit((java.lang.System[]) null);
        $deserializer.record_reference($_obj);
        return $_deserialize_body($_obj, $deserializer);
    }
    
    public void $_serialize(x10.serialization.X10JavaSerializer $serializer) throws java.io.IOException {
        $serializer.write(this.current);
        $serializer.write(this.index);
        $serializer.write(this.rand);
        
    }
    
    // constructor just for allocation
    public RandomSequenceBySplit(final java.lang.System[] $dummy) {
        
    }
    
    // dispatcher for method abstract public (Z1)=>U.operator()(a1:Z1){}:U
    public java.lang.Object $apply(final java.lang.Object a1, final x10.rtt.Type t1) {
        return $apply(x10.core.Long.$unbox(a1));
        
    }
    
    // dispatcher for method abstract public x10.util.Container.contains(y:T){}:x10.lang.Boolean
    public java.lang.Object contains(final java.lang.Object a1, final x10.rtt.Type t1) {
        return x10.core.Boolean.$box(contains$O((x10.util.Random)a1));
        
    }
    
    // dispatcher for method abstract public x10.util.Container.contains(y:T){}:x10.lang.Boolean
    public boolean contains$Z(final java.lang.Object a1, final x10.rtt.Type t1) {
        return contains$O((x10.util.Random)a1);
        
    }
    
    // dispatcher for method abstract public x10.util.Container.containsAll(c:x10.util.Container[T]){}:x10.lang.Boolean
    public java.lang.Object containsAll(final x10.util.Container a1, final x10.rtt.Type t1) {
        return x10.core.Boolean.$box(containsAll__0$1x10$util$Random$2$O(a1));
        
    }
    
    // dispatcher for method abstract public x10.util.Container.containsAll(c:x10.util.Container[T]){}:x10.lang.Boolean
    public boolean containsAll$Z(final x10.util.Container a1, final x10.rtt.Type t1) {
        return containsAll__0$1x10$util$Random$2$O(a1);
        
    }
    
    // bridge for method abstract public x10.util.Indexed.operator()(index:x10.lang.Long){}:T
    public x10.util.Random $apply$G(long a1) {
        return $apply(a1);
    }
    
    

    
    //#line 21 "/home/dsl/workspace/plhamK/plham/util/RandomSequenceBySplit.x10"
    public x10.util.Random rand;
    
    //#line 22 "/home/dsl/workspace/plhamK/plham/util/RandomSequenceBySplit.x10"
    public long index;
    
    //#line 23 "/home/dsl/workspace/plhamK/plham/util/RandomSequenceBySplit.x10"
    public x10.util.Random current;
    
    
    //#line 25 "/home/dsl/workspace/plhamK/plham/util/RandomSequenceBySplit.x10"
    // creation method for java code (1-phase java constructor)
    public RandomSequenceBySplit(final x10.util.Random rand0) {
        this((java.lang.System[]) null);
        plham$util$RandomSequenceBySplit$$init$S(rand0);
    }
    
    // constructor for non-virtual call
    final public plham.util.RandomSequenceBySplit plham$util$RandomSequenceBySplit$$init$S(final x10.util.Random rand0) {
         {
            
            //#line 25 "/home/dsl/workspace/plhamK/plham/util/RandomSequenceBySplit.x10"
            
            
            //#line 20 "/home/dsl/workspace/plhamK/plham/util/RandomSequenceBySplit.x10"
            this.__fieldInitializers_plham_util_RandomSequenceBySplit();
            
            //#line 26 "/home/dsl/workspace/plhamK/plham/util/RandomSequenceBySplit.x10"
            this.rand = ((rand0));
            
            //#line 27 "/home/dsl/workspace/plhamK/plham/util/RandomSequenceBySplit.x10"
            this.index = -1L;
        }
        return this;
    }
    
    
    
    //#line 29 "/home/dsl/workspace/plhamK/plham/util/RandomSequenceBySplit.x10"
    // creation method for java code (1-phase java constructor)
    public RandomSequenceBySplit(final plham.util.RandomSequenceBySplit from) {
        this((java.lang.System[]) null);
        plham$util$RandomSequenceBySplit$$init$S(from);
    }
    
    // constructor for non-virtual call
    final public plham.util.RandomSequenceBySplit plham$util$RandomSequenceBySplit$$init$S(final plham.util.RandomSequenceBySplit from) {
         {
            
            //#line 29 "/home/dsl/workspace/plhamK/plham/util/RandomSequenceBySplit.x10"
            
            
            //#line 20 "/home/dsl/workspace/plhamK/plham/util/RandomSequenceBySplit.x10"
            this.__fieldInitializers_plham_util_RandomSequenceBySplit();
            
            //#line 30 "/home/dsl/workspace/plhamK/plham/util/RandomSequenceBySplit.x10"
            final x10.util.Random t$29270 = ((from.rand));
            
            //#line 30 "/home/dsl/workspace/plhamK/plham/util/RandomSequenceBySplit.x10"
            this.rand = ((t$29270));
            
            //#line 31 "/home/dsl/workspace/plhamK/plham/util/RandomSequenceBySplit.x10"
            final long t$29271 = from.index;
            
            //#line 31 "/home/dsl/workspace/plhamK/plham/util/RandomSequenceBySplit.x10"
            this.index = t$29271;
            
            //#line 32 "/home/dsl/workspace/plhamK/plham/util/RandomSequenceBySplit.x10"
            final x10.util.Random t$29272 = ((from.current));
            
            //#line 32 "/home/dsl/workspace/plhamK/plham/util/RandomSequenceBySplit.x10"
            this.current = ((t$29272));
        }
        return this;
    }
    
    
    
    //#line 35 "/home/dsl/workspace/plhamK/plham/util/RandomSequenceBySplit.x10"
    public x10.util.Random $apply(final long i) {
        
        //#line 36 "/home/dsl/workspace/plhamK/plham/util/RandomSequenceBySplit.x10"
        assert ((i) >= (((0L)))): (((("RandomSequenceBySplit: arguments ") + ((x10.core.Long.$box(i))))) + (" is negative."));
        
        //#line 37 "/home/dsl/workspace/plhamK/plham/util/RandomSequenceBySplit.x10"
        assert ((i) >= (((this.index)))): (((((("RandomSequenceBySplit: this only allows sequential access. You are accessing element No. ") + ((x10.core.Long.$box(i))))) + (", while this already accessing No. "))) + ((x10.core.Long.$box(this.index))));
        
        //#line 38 "/home/dsl/workspace/plhamK/plham/util/RandomSequenceBySplit.x10"
        x10.util.Random r = null;
        
        //#line 39 "/home/dsl/workspace/plhamK/plham/util/RandomSequenceBySplit.x10"
        final long t$29273 = this.index;
        
        //#line 39 "/home/dsl/workspace/plhamK/plham/util/RandomSequenceBySplit.x10"
        final boolean t$29275 = (i) == (t$29273);
        
        //#line 39 "/home/dsl/workspace/plhamK/plham/util/RandomSequenceBySplit.x10"
        if (t$29275) {
            
            //#line 39 "/home/dsl/workspace/plhamK/plham/util/RandomSequenceBySplit.x10"
            final x10.util.Random t$29274 = ((this.current));
            
            //#line 39 "/home/dsl/workspace/plhamK/plham/util/RandomSequenceBySplit.x10"
            return t$29274;
        }
        
        //#line 41 "/home/dsl/workspace/plhamK/plham/util/RandomSequenceBySplit.x10"
        while (true) {
            
            //#line 41 "/home/dsl/workspace/plhamK/plham/util/RandomSequenceBySplit.x10"
            final long t$29276 = this.index;
            
            //#line 41 "/home/dsl/workspace/plhamK/plham/util/RandomSequenceBySplit.x10"
            final boolean t$29281 = ((i) > (((t$29276))));
            
            //#line 41 "/home/dsl/workspace/plhamK/plham/util/RandomSequenceBySplit.x10"
            if (!(t$29281)) {
                
                //#line 41 "/home/dsl/workspace/plhamK/plham/util/RandomSequenceBySplit.x10"
                break;
            }
            
            //#line 42 "/home/dsl/workspace/plhamK/plham/util/RandomSequenceBySplit.x10"
            final long t$29349 = this.index;
            
            //#line 42 "/home/dsl/workspace/plhamK/plham/util/RandomSequenceBySplit.x10"
            final long t$29350 = ((t$29349) + (((1L))));
            
            //#line 42 "/home/dsl/workspace/plhamK/plham/util/RandomSequenceBySplit.x10"
            this.index = t$29350;
            
            //#line 43 "/home/dsl/workspace/plhamK/plham/util/RandomSequenceBySplit.x10"
            final x10.util.Random t$29351 = ((this.rand));
            
            //#line 43 "/home/dsl/workspace/plhamK/plham/util/RandomSequenceBySplit.x10"
            final x10.util.Random t$29352 = ((t$29351.split()));
            
            //#line 43 "/home/dsl/workspace/plhamK/plham/util/RandomSequenceBySplit.x10"
            r = ((t$29352));
        }
        
        //#line 45 "/home/dsl/workspace/plhamK/plham/util/RandomSequenceBySplit.x10"
        final x10.util.Random t$29282 = ((r));
        
        //#line 45 "/home/dsl/workspace/plhamK/plham/util/RandomSequenceBySplit.x10"
        final x10.util.Random t$29283 = (this.current = ((t$29282)));
        
        //#line 45 "/home/dsl/workspace/plhamK/plham/util/RandomSequenceBySplit.x10"
        return t$29283;
    }
    
    
    //#line 48 "/home/dsl/workspace/plhamK/plham/util/RandomSequenceBySplit.x10"
    public long size$O() {
        
        //#line 48 "/home/dsl/workspace/plhamK/plham/util/RandomSequenceBySplit.x10"
        final long t$29284 = this.index;
        
        //#line 48 "/home/dsl/workspace/plhamK/plham/util/RandomSequenceBySplit.x10"
        final long t$29285 = ((t$29284) + (((10000L))));
        
        //#line 48 "/home/dsl/workspace/plhamK/plham/util/RandomSequenceBySplit.x10"
        return t$29285;
    }
    
    
    //#line 49 "/home/dsl/workspace/plhamK/plham/util/RandomSequenceBySplit.x10"
    public boolean isEmpty$O() {
        
        //#line 49 "/home/dsl/workspace/plhamK/plham/util/RandomSequenceBySplit.x10"
        return false;
    }
    
    
    //#line 50 "/home/dsl/workspace/plhamK/plham/util/RandomSequenceBySplit.x10"
    public boolean contains$O(final x10.util.Random y) {
        
        //#line 51 "/home/dsl/workspace/plhamK/plham/util/RandomSequenceBySplit.x10"
        final java.lang.UnsupportedOperationException t$29286 = ((new java.lang.UnsupportedOperationException()));
        
        //#line 51 "/home/dsl/workspace/plhamK/plham/util/RandomSequenceBySplit.x10"
        throw t$29286;
    }
    
    
    //#line 53 "/home/dsl/workspace/plhamK/plham/util/RandomSequenceBySplit.x10"
    public boolean containsAll__0$1x10$util$Random$2$O(final x10.util.Container y) {
        
        //#line 54 "/home/dsl/workspace/plhamK/plham/util/RandomSequenceBySplit.x10"
        final java.lang.UnsupportedOperationException t$29287 = ((new java.lang.UnsupportedOperationException()));
        
        //#line 54 "/home/dsl/workspace/plhamK/plham/util/RandomSequenceBySplit.x10"
        throw t$29287;
    }
    
    
    //#line 56 "/home/dsl/workspace/plhamK/plham/util/RandomSequenceBySplit.x10"
    public plham.util.RandomSequenceBySplit clone() {
        
        //#line 57 "/home/dsl/workspace/plhamK/plham/util/RandomSequenceBySplit.x10"
        final plham.util.RandomSequenceBySplit t$29288 = ((new plham.util.RandomSequenceBySplit((java.lang.System[]) null).plham$util$RandomSequenceBySplit$$init$S(((this)))));
        
        //#line 57 "/home/dsl/workspace/plhamK/plham/util/RandomSequenceBySplit.x10"
        return t$29288;
    }
    
    
    //#line 60 "/home/dsl/workspace/plhamK/plham/util/RandomSequenceBySplit.x10"
    
    public static class It extends x10.core.Ref implements x10.util.ListIterator, x10.serialization.X10JavaSerializable
    {
        public static final x10.rtt.RuntimeType<It> $RTT = 
            x10.rtt.NamedType.<It> make("plham.util.RandomSequenceBySplit.It",
                                        It.class,
                                        new x10.rtt.Type[] {
                                            x10.rtt.ParameterizedType.make(x10.util.ListIterator.$RTT, x10.util.Random.$RTT)
                                        });
        
        public x10.rtt.RuntimeType<?> $getRTT() { return $RTT; }
        
        public x10.rtt.Type<?> $getParam(int i) { return null; }
        
        private Object writeReplace() throws java.io.ObjectStreamException {
            return new x10.serialization.SerializationProxy(this);
        }
        
        public static x10.serialization.X10JavaSerializable $_deserialize_body(plham.util.RandomSequenceBySplit.It $_obj, x10.serialization.X10JavaDeserializer $deserializer) throws java.io.IOException {
            if (x10.runtime.impl.java.Runtime.TRACE_SER) { x10.runtime.impl.java.Runtime.printTraceMessage("X10JavaSerializable: $_deserialize_body() of " + It.class + " calling"); } 
            $_obj.al = $deserializer.readObject();
            $_obj.i = $deserializer.readLong();
            return $_obj;
        }
        
        public static x10.serialization.X10JavaSerializable $_deserializer(x10.serialization.X10JavaDeserializer $deserializer) throws java.io.IOException {
            plham.util.RandomSequenceBySplit.It $_obj = new plham.util.RandomSequenceBySplit.It((java.lang.System[]) null);
            $deserializer.record_reference($_obj);
            return $_deserialize_body($_obj, $deserializer);
        }
        
        public void $_serialize(x10.serialization.X10JavaSerializer $serializer) throws java.io.IOException {
            $serializer.write(this.al);
            $serializer.write(this.i);
            
        }
        
        // constructor just for allocation
        public It(final java.lang.System[] $dummy) {
            
        }
        
        // dispatcher for method abstract public x10.util.ListIterator.set(v:T){}:void
        public java.lang.Object set(final java.lang.Object a1, final x10.rtt.Type t1) {
            set((x10.util.Random)a1); return null;
            
        }
        
        // dispatcher for method abstract public x10.util.ListIterator.set(v:T){}:void
        public void set$V(final java.lang.Object a1, final x10.rtt.Type t1) {
            set((x10.util.Random)a1);
            
        }
        
        // dispatcher for method abstract public x10.util.ListIterator.add(v:T){}:void
        public java.lang.Object add(final java.lang.Object a1, final x10.rtt.Type t1) {
            add((x10.util.Random)a1); return null;
            
        }
        
        // dispatcher for method abstract public x10.util.ListIterator.add(v:T){}:void
        public void add$V(final java.lang.Object a1, final x10.rtt.Type t1) {
            add((x10.util.Random)a1);
            
        }
        
        // bridge for method abstract public x10.util.ListIterator.next(){}:T
        public x10.util.Random next$G() {
            return next();
        }
        
        // bridge for method abstract public x10.util.ListIterator.previous(){}:T
        public x10.util.Random previous$G() {
            return previous();
        }
        
        
    
        
        //#line 62 "/home/dsl/workspace/plhamK/plham/util/RandomSequenceBySplit.x10"
        public long i;
        
        //#line 63 "/home/dsl/workspace/plhamK/plham/util/RandomSequenceBySplit.x10"
        public plham.util.RandomSequenceBySplit al;
        
        
        //#line 65 "/home/dsl/workspace/plhamK/plham/util/RandomSequenceBySplit.x10"
        // creation method for java code (1-phase java constructor)
        public It(final plham.util.RandomSequenceBySplit al) {
            this((java.lang.System[]) null);
            plham$util$RandomSequenceBySplit$It$$init$S(al);
        }
        
        // constructor for non-virtual call
        final public plham.util.RandomSequenceBySplit.It plham$util$RandomSequenceBySplit$It$$init$S(final plham.util.RandomSequenceBySplit al) {
             {
                
                //#line 65 "/home/dsl/workspace/plhamK/plham/util/RandomSequenceBySplit.x10"
                
                
                //#line 60 "/home/dsl/workspace/plhamK/plham/util/RandomSequenceBySplit.x10"
                this.__fieldInitializers_plham_util_RandomSequenceBySplit_It();
                
                //#line 66 "/home/dsl/workspace/plhamK/plham/util/RandomSequenceBySplit.x10"
                this.al = ((al));
            }
            return this;
        }
        
        
        
        //#line 70 "/home/dsl/workspace/plhamK/plham/util/RandomSequenceBySplit.x10"
        public boolean hasNext$O() {
            
            //#line 71 "/home/dsl/workspace/plhamK/plham/util/RandomSequenceBySplit.x10"
            final long t$29289 = this.i;
            
            //#line 71 "/home/dsl/workspace/plhamK/plham/util/RandomSequenceBySplit.x10"
            final long t$29291 = ((t$29289) + (((1L))));
            
            //#line 71 "/home/dsl/workspace/plhamK/plham/util/RandomSequenceBySplit.x10"
            final plham.util.RandomSequenceBySplit t$29290 = ((this.al));
            
            //#line 71 "/home/dsl/workspace/plhamK/plham/util/RandomSequenceBySplit.x10"
            final long t$29292 = t$29290.size$O();
            
            //#line 71 "/home/dsl/workspace/plhamK/plham/util/RandomSequenceBySplit.x10"
            final boolean t$29293 = ((t$29291) < (((t$29292))));
            
            //#line 71 "/home/dsl/workspace/plhamK/plham/util/RandomSequenceBySplit.x10"
            return t$29293;
        }
        
        
        //#line 74 "/home/dsl/workspace/plhamK/plham/util/RandomSequenceBySplit.x10"
        public long nextIndex$O() {
            
            //#line 75 "/home/dsl/workspace/plhamK/plham/util/RandomSequenceBySplit.x10"
            final long t$29294 = this.i;
            
            //#line 75 "/home/dsl/workspace/plhamK/plham/util/RandomSequenceBySplit.x10"
            final long t$29295 = ((t$29294) + (((1L))));
            
            //#line 75 "/home/dsl/workspace/plhamK/plham/util/RandomSequenceBySplit.x10"
            final long t$29296 = this.i = t$29295;
            
            //#line 75 "/home/dsl/workspace/plhamK/plham/util/RandomSequenceBySplit.x10"
            return t$29296;
        }
        
        
        //#line 78 "/home/dsl/workspace/plhamK/plham/util/RandomSequenceBySplit.x10"
        public x10.util.Random next() {
            
            //#line 79 "/home/dsl/workspace/plhamK/plham/util/RandomSequenceBySplit.x10"
            final plham.util.RandomSequenceBySplit t$29299 = ((this.al));
            
            //#line 79 "/home/dsl/workspace/plhamK/plham/util/RandomSequenceBySplit.x10"
            final long t$29297 = this.i;
            
            //#line 79 "/home/dsl/workspace/plhamK/plham/util/RandomSequenceBySplit.x10"
            final long t$29298 = ((t$29297) + (((1L))));
            
            //#line 79 "/home/dsl/workspace/plhamK/plham/util/RandomSequenceBySplit.x10"
            final long t$29300 = this.i = t$29298;
            
            //#line 79 "/home/dsl/workspace/plhamK/plham/util/RandomSequenceBySplit.x10"
            final x10.util.Random t$29301 = t$29299.$apply((t$29300));
            
            //#line 79 "/home/dsl/workspace/plhamK/plham/util/RandomSequenceBySplit.x10"
            return t$29301;
        }
        
        
        //#line 82 "/home/dsl/workspace/plhamK/plham/util/RandomSequenceBySplit.x10"
        public boolean hasPrevious$O() {
            
            //#line 83 "/home/dsl/workspace/plhamK/plham/util/RandomSequenceBySplit.x10"
            final long t$29302 = this.i;
            
            //#line 83 "/home/dsl/workspace/plhamK/plham/util/RandomSequenceBySplit.x10"
            final long t$29303 = ((t$29302) - (((1L))));
            
            //#line 83 "/home/dsl/workspace/plhamK/plham/util/RandomSequenceBySplit.x10"
            final boolean t$29304 = ((t$29303) >= (((0L))));
            
            //#line 83 "/home/dsl/workspace/plhamK/plham/util/RandomSequenceBySplit.x10"
            return t$29304;
        }
        
        
        //#line 86 "/home/dsl/workspace/plhamK/plham/util/RandomSequenceBySplit.x10"
        public long previousIndex$O() {
            
            //#line 87 "/home/dsl/workspace/plhamK/plham/util/RandomSequenceBySplit.x10"
            final long t$29305 = this.i;
            
            //#line 87 "/home/dsl/workspace/plhamK/plham/util/RandomSequenceBySplit.x10"
            final long t$29306 = ((t$29305) - (((1L))));
            
            //#line 87 "/home/dsl/workspace/plhamK/plham/util/RandomSequenceBySplit.x10"
            final long t$29307 = this.i = t$29306;
            
            //#line 87 "/home/dsl/workspace/plhamK/plham/util/RandomSequenceBySplit.x10"
            return t$29307;
        }
        
        
        //#line 90 "/home/dsl/workspace/plhamK/plham/util/RandomSequenceBySplit.x10"
        public x10.util.Random previous() {
            
            //#line 91 "/home/dsl/workspace/plhamK/plham/util/RandomSequenceBySplit.x10"
            final plham.util.RandomSequenceBySplit t$29310 = ((this.al));
            
            //#line 91 "/home/dsl/workspace/plhamK/plham/util/RandomSequenceBySplit.x10"
            final long t$29308 = this.i;
            
            //#line 91 "/home/dsl/workspace/plhamK/plham/util/RandomSequenceBySplit.x10"
            final long t$29309 = ((t$29308) - (((1L))));
            
            //#line 91 "/home/dsl/workspace/plhamK/plham/util/RandomSequenceBySplit.x10"
            final long t$29311 = this.i = t$29309;
            
            //#line 91 "/home/dsl/workspace/plhamK/plham/util/RandomSequenceBySplit.x10"
            final x10.util.Random t$29312 = t$29310.$apply((t$29311));
            
            //#line 91 "/home/dsl/workspace/plhamK/plham/util/RandomSequenceBySplit.x10"
            return t$29312;
        }
        
        
        //#line 94 "/home/dsl/workspace/plhamK/plham/util/RandomSequenceBySplit.x10"
        public void remove() {
            
            //#line 95 "/home/dsl/workspace/plhamK/plham/util/RandomSequenceBySplit.x10"
            final java.lang.UnsupportedOperationException t$29313 = ((new java.lang.UnsupportedOperationException()));
            
            //#line 95 "/home/dsl/workspace/plhamK/plham/util/RandomSequenceBySplit.x10"
            throw t$29313;
        }
        
        
        //#line 98 "/home/dsl/workspace/plhamK/plham/util/RandomSequenceBySplit.x10"
        public void set(final x10.util.Random v) {
            
            //#line 99 "/home/dsl/workspace/plhamK/plham/util/RandomSequenceBySplit.x10"
            final java.lang.UnsupportedOperationException t$29314 = ((new java.lang.UnsupportedOperationException()));
            
            //#line 99 "/home/dsl/workspace/plhamK/plham/util/RandomSequenceBySplit.x10"
            throw t$29314;
        }
        
        
        //#line 102 "/home/dsl/workspace/plhamK/plham/util/RandomSequenceBySplit.x10"
        public void add(final x10.util.Random v) {
            
            //#line 103 "/home/dsl/workspace/plhamK/plham/util/RandomSequenceBySplit.x10"
            final java.lang.UnsupportedOperationException t$29315 = ((new java.lang.UnsupportedOperationException()));
            
            //#line 103 "/home/dsl/workspace/plhamK/plham/util/RandomSequenceBySplit.x10"
            throw t$29315;
        }
        
        
        //#line 60 "/home/dsl/workspace/plhamK/plham/util/RandomSequenceBySplit.x10"
        final public plham.util.RandomSequenceBySplit.It plham$util$RandomSequenceBySplit$It$$this$plham$util$RandomSequenceBySplit$It() {
            
            //#line 60 "/home/dsl/workspace/plhamK/plham/util/RandomSequenceBySplit.x10"
            return plham.util.RandomSequenceBySplit.It.this;
        }
        
        
        //#line 60 "/home/dsl/workspace/plhamK/plham/util/RandomSequenceBySplit.x10"
        final public void __fieldInitializers_plham_util_RandomSequenceBySplit_It() {
            
            //#line 60 "/home/dsl/workspace/plhamK/plham/util/RandomSequenceBySplit.x10"
            this.i = 0L;
        }
    }
    
    
    
    //#line 106 "/home/dsl/workspace/plhamK/plham/util/RandomSequenceBySplit.x10"
    public plham.util.RandomSequenceBySplit.It iterator() {
        
        //#line 106 "/home/dsl/workspace/plhamK/plham/util/RandomSequenceBySplit.x10"
        final plham.util.RandomSequenceBySplit.It t$29316 = ((new plham.util.RandomSequenceBySplit.It((java.lang.System[]) null).plham$util$RandomSequenceBySplit$It$$init$S(((this)))));
        
        //#line 106 "/home/dsl/workspace/plhamK/plham/util/RandomSequenceBySplit.x10"
        return t$29316;
    }
    
    
    //#line 109 "/home/dsl/workspace/plhamK/plham/util/RandomSequenceBySplit.x10"
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
            RandomSequenceBySplit.main(args);
        }
    }
    
    // the original app-main method
    public static void main(final x10.core.Rail<java.lang.String> args) {
        
        //#line 110 "/home/dsl/workspace/plhamK/plham/util/RandomSequenceBySplit.x10"
        final long seed = 194327L;
        
        //#line 111 "/home/dsl/workspace/plhamK/plham/util/RandomSequenceBySplit.x10"
        final java.lang.String t$29317 = ((java.lang.String[])args.value)[(int)0L];
        
        //#line 111 "/home/dsl/workspace/plhamK/plham/util/RandomSequenceBySplit.x10"
        final long size = java.lang.Long.parseLong(t$29317);
        
        //#line 112 "/home/dsl/workspace/plhamK/plham/util/RandomSequenceBySplit.x10"
        final long time = x10.lang.System.currentTimeMillis$O();
        
        //#line 113 "/home/dsl/workspace/plhamK/plham/util/RandomSequenceBySplit.x10"
        final x10.util.Random rgen = ((new x10.util.Random((java.lang.System[]) null).x10$util$Random$$init$S(((seed)))));
        
        //#line 114 "/home/dsl/workspace/plhamK/plham/util/RandomSequenceBySplit.x10"
        final x10.util.Random rgen2 = ((new x10.util.Random((java.lang.System[]) null).x10$util$Random$$init$S(((seed)))));
        
        //#line 115 "/home/dsl/workspace/plhamK/plham/util/RandomSequenceBySplit.x10"
        final plham.util.RandomSequenceBySplit rx = ((new plham.util.RandomSequenceBySplit((java.lang.System[]) null).plham$util$RandomSequenceBySplit$$init$S(((rgen2)))));
        
        //#line 116 "/home/dsl/workspace/plhamK/plham/util/RandomSequenceBySplit.x10"
        long sum0 = 0L;
        
        //#line 117 "/home/dsl/workspace/plhamK/plham/util/RandomSequenceBySplit.x10"
        long sum1 = 0L;
        
        //#line 119 "/home/dsl/workspace/plhamK/plham/util/RandomSequenceBySplit.x10"
        final long i$29235min$29373 = 0L;
        
        //#line 119 "/home/dsl/workspace/plhamK/plham/util/RandomSequenceBySplit.x10"
        final long i$29235max$29374 = size;
        
        //#line 119 "/home/dsl/workspace/plhamK/plham/util/RandomSequenceBySplit.x10"
        long i$29360 = i$29235min$29373;
        
        //#line 119 "/home/dsl/workspace/plhamK/plham/util/RandomSequenceBySplit.x10"
        for (;
             true;
             ) {
            
            //#line 119 "/home/dsl/workspace/plhamK/plham/util/RandomSequenceBySplit.x10"
            final long t$29361 = i$29360;
            
            //#line 119 "/home/dsl/workspace/plhamK/plham/util/RandomSequenceBySplit.x10"
            final boolean t$29362 = ((t$29361) <= (((i$29235max$29374))));
            
            //#line 119 "/home/dsl/workspace/plhamK/plham/util/RandomSequenceBySplit.x10"
            if (!(t$29362)) {
                
                //#line 119 "/home/dsl/workspace/plhamK/plham/util/RandomSequenceBySplit.x10"
                break;
            }
            
            //#line 119 "/home/dsl/workspace/plhamK/plham/util/RandomSequenceBySplit.x10"
            final long i$29357 = i$29360;
            
            //#line 122 "/home/dsl/workspace/plhamK/plham/util/RandomSequenceBySplit.x10"
            final x10.util.Random r$29353 = rx.$apply((i$29357));
            
            //#line 123 "/home/dsl/workspace/plhamK/plham/util/RandomSequenceBySplit.x10"
            final long t$29354 = sum0;
            
            //#line 123 "/home/dsl/workspace/plhamK/plham/util/RandomSequenceBySplit.x10"
            final long t$29355 = r$29353.nextLong$O();
            
            //#line 123 "/home/dsl/workspace/plhamK/plham/util/RandomSequenceBySplit.x10"
            final long t$29356 = ((t$29354) + (((t$29355))));
            
            //#line 123 "/home/dsl/workspace/plhamK/plham/util/RandomSequenceBySplit.x10"
            sum0 = t$29356;
            
            //#line 119 "/home/dsl/workspace/plhamK/plham/util/RandomSequenceBySplit.x10"
            final long t$29358 = i$29360;
            
            //#line 119 "/home/dsl/workspace/plhamK/plham/util/RandomSequenceBySplit.x10"
            final long t$29359 = ((t$29358) + (((1L))));
            
            //#line 119 "/home/dsl/workspace/plhamK/plham/util/RandomSequenceBySplit.x10"
            i$29360 = t$29359;
        }
        
        //#line 128 "/home/dsl/workspace/plhamK/plham/util/RandomSequenceBySplit.x10"
        final long t$29326 = x10.lang.System.currentTimeMillis$O();
        
        //#line 128 "/home/dsl/workspace/plhamK/plham/util/RandomSequenceBySplit.x10"
        final long diff = ((t$29326) - (((time))));
        
        //#line 129 "/home/dsl/workspace/plhamK/plham/util/RandomSequenceBySplit.x10"
        final x10.io.Printer t$29329 = ((x10.io.Console.get$OUT()));
        
        //#line 129 "/home/dsl/workspace/plhamK/plham/util/RandomSequenceBySplit.x10"
        final java.lang.String t$29327 = (("time:") + ((x10.core.Long.$box(diff))));
        
        //#line 129 "/home/dsl/workspace/plhamK/plham/util/RandomSequenceBySplit.x10"
        final java.lang.String t$29328 = ((t$29327) + (", for "));
        
        //#line 129 "/home/dsl/workspace/plhamK/plham/util/RandomSequenceBySplit.x10"
        final java.lang.String t$29330 = ((t$29328) + ((x10.core.Long.$box(size))));
        
        //#line 129 "/home/dsl/workspace/plhamK/plham/util/RandomSequenceBySplit.x10"
        t$29329.println(((t$29330)));
        
        //#line 131 "/home/dsl/workspace/plhamK/plham/util/RandomSequenceBySplit.x10"
        final long t2 = x10.lang.System.currentTimeMillis$O();
        
        //#line 132 "/home/dsl/workspace/plhamK/plham/util/RandomSequenceBySplit.x10"
        final long i$29253min$29375 = 0L;
        
        //#line 132 "/home/dsl/workspace/plhamK/plham/util/RandomSequenceBySplit.x10"
        final long i$29253max$29376 = size;
        
        //#line 132 "/home/dsl/workspace/plhamK/plham/util/RandomSequenceBySplit.x10"
        long i$29370 = i$29253min$29375;
        
        //#line 132 "/home/dsl/workspace/plhamK/plham/util/RandomSequenceBySplit.x10"
        for (;
             true;
             ) {
            
            //#line 132 "/home/dsl/workspace/plhamK/plham/util/RandomSequenceBySplit.x10"
            final long t$29371 = i$29370;
            
            //#line 132 "/home/dsl/workspace/plhamK/plham/util/RandomSequenceBySplit.x10"
            final boolean t$29372 = ((t$29371) <= (((i$29253max$29376))));
            
            //#line 132 "/home/dsl/workspace/plhamK/plham/util/RandomSequenceBySplit.x10"
            if (!(t$29372)) {
                
                //#line 132 "/home/dsl/workspace/plhamK/plham/util/RandomSequenceBySplit.x10"
                break;
            }
            
            //#line 132 "/home/dsl/workspace/plhamK/plham/util/RandomSequenceBySplit.x10"
            final long i$29367 = i$29370;
            
            //#line 133 "/home/dsl/workspace/plhamK/plham/util/RandomSequenceBySplit.x10"
            final x10.util.Random r$29363 = ((rgen.split()));
            
            //#line 134 "/home/dsl/workspace/plhamK/plham/util/RandomSequenceBySplit.x10"
            final long t$29364 = sum1;
            
            //#line 134 "/home/dsl/workspace/plhamK/plham/util/RandomSequenceBySplit.x10"
            final long t$29365 = r$29363.nextLong$O();
            
            //#line 134 "/home/dsl/workspace/plhamK/plham/util/RandomSequenceBySplit.x10"
            final long t$29366 = ((t$29364) + (((t$29365))));
            
            //#line 134 "/home/dsl/workspace/plhamK/plham/util/RandomSequenceBySplit.x10"
            sum1 = t$29366;
            
            //#line 132 "/home/dsl/workspace/plhamK/plham/util/RandomSequenceBySplit.x10"
            final long t$29368 = i$29370;
            
            //#line 132 "/home/dsl/workspace/plhamK/plham/util/RandomSequenceBySplit.x10"
            final long t$29369 = ((t$29368) + (((1L))));
            
            //#line 132 "/home/dsl/workspace/plhamK/plham/util/RandomSequenceBySplit.x10"
            i$29370 = t$29369;
        }
        
        //#line 136 "/home/dsl/workspace/plhamK/plham/util/RandomSequenceBySplit.x10"
        final long t$29339 = x10.lang.System.currentTimeMillis$O();
        
        //#line 136 "/home/dsl/workspace/plhamK/plham/util/RandomSequenceBySplit.x10"
        final long diff2 = ((t$29339) - (((t2))));
        
        //#line 137 "/home/dsl/workspace/plhamK/plham/util/RandomSequenceBySplit.x10"
        final x10.io.Printer t$29347 = ((x10.io.Console.get$OUT()));
        
        //#line 137 "/home/dsl/workspace/plhamK/plham/util/RandomSequenceBySplit.x10"
        final java.lang.String t$29340 = (("timeX:") + ((x10.core.Long.$box(diff2))));
        
        //#line 137 "/home/dsl/workspace/plhamK/plham/util/RandomSequenceBySplit.x10"
        final java.lang.String t$29341 = ((t$29340) + (", for "));
        
        //#line 137 "/home/dsl/workspace/plhamK/plham/util/RandomSequenceBySplit.x10"
        final java.lang.String t$29342 = ((t$29341) + ((x10.core.Long.$box(size))));
        
        //#line 137 "/home/dsl/workspace/plhamK/plham/util/RandomSequenceBySplit.x10"
        final java.lang.String t$29345 = ((t$29342) + (", diff"));
        
        //#line 137 "/home/dsl/workspace/plhamK/plham/util/RandomSequenceBySplit.x10"
        final long t$29343 = sum0;
        
        //#line 137 "/home/dsl/workspace/plhamK/plham/util/RandomSequenceBySplit.x10"
        final long t$29344 = sum1;
        
        //#line 137 "/home/dsl/workspace/plhamK/plham/util/RandomSequenceBySplit.x10"
        final long t$29346 = ((t$29343) - (((t$29344))));
        
        //#line 137 "/home/dsl/workspace/plhamK/plham/util/RandomSequenceBySplit.x10"
        final java.lang.String t$29348 = ((t$29345) + ((x10.core.Long.$box(t$29346))));
        
        //#line 137 "/home/dsl/workspace/plhamK/plham/util/RandomSequenceBySplit.x10"
        t$29347.println(((t$29348)));
    }
    
    
    //#line 20 "/home/dsl/workspace/plhamK/plham/util/RandomSequenceBySplit.x10"
    final public plham.util.RandomSequenceBySplit plham$util$RandomSequenceBySplit$$this$plham$util$RandomSequenceBySplit() {
        
        //#line 20 "/home/dsl/workspace/plhamK/plham/util/RandomSequenceBySplit.x10"
        return plham.util.RandomSequenceBySplit.this;
    }
    
    
    //#line 20 "/home/dsl/workspace/plhamK/plham/util/RandomSequenceBySplit.x10"
    final public void __fieldInitializers_plham_util_RandomSequenceBySplit() {
        
        //#line 20 "/home/dsl/workspace/plhamK/plham/util/RandomSequenceBySplit.x10"
        this.index = 0L;
        
        //#line 20 "/home/dsl/workspace/plhamK/plham/util/RandomSequenceBySplit.x10"
        this.current = null;
    }
}

