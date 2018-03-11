package plham.util;


/**
 * A helper class adding more utilities to Random.
 */

public class RandomHelper extends x10.core.Ref implements x10.serialization.X10JavaSerializable
{
    public static final x10.rtt.RuntimeType<RandomHelper> $RTT = 
        x10.rtt.NamedType.<RandomHelper> make("plham.util.RandomHelper",
                                              RandomHelper.class);
    
    public x10.rtt.RuntimeType<?> $getRTT() { return $RTT; }
    
    public x10.rtt.Type<?> $getParam(int i) { return null; }
    
    private Object writeReplace() throws java.io.ObjectStreamException {
        return new x10.serialization.SerializationProxy(this);
    }
    
    public static x10.serialization.X10JavaSerializable $_deserialize_body(plham.util.RandomHelper $_obj, x10.serialization.X10JavaDeserializer $deserializer) throws java.io.IOException {
        if (x10.runtime.impl.java.Runtime.TRACE_SER) { x10.runtime.impl.java.Runtime.printTraceMessage("X10JavaSerializable: $_deserialize_body() of " + RandomHelper.class + " calling"); } 
        $_obj.g = $deserializer.readObject();
        $_obj.random = $deserializer.readObject();
        return $_obj;
    }
    
    public static x10.serialization.X10JavaSerializable $_deserializer(x10.serialization.X10JavaDeserializer $deserializer) throws java.io.IOException {
        plham.util.RandomHelper $_obj = new plham.util.RandomHelper((java.lang.System[]) null);
        $deserializer.record_reference($_obj);
        return $_deserialize_body($_obj, $deserializer);
    }
    
    public void $_serialize(x10.serialization.X10JavaSerializer $serializer) throws java.io.IOException {
        $serializer.write(this.g);
        $serializer.write(this.random);
        
    }
    
    // constructor just for allocation
    public RandomHelper(final java.lang.System[] $dummy) {
        
    }
    
    

    
    //#line 10 "/home/dsl/workspace/plhamK/plham/util/RandomHelper.x10"
    public x10.util.Random random;
    
    //#line 11 "/home/dsl/workspace/plhamK/plham/util/RandomHelper.x10"
    public cassia.util.random.Gaussian g;
    
    
    //#line 13 "/home/dsl/workspace/plhamK/plham/util/RandomHelper.x10"
    // creation method for java code (1-phase java constructor)
    public RandomHelper(final x10.util.Random random) {
        this((java.lang.System[]) null);
        plham$util$RandomHelper$$init$S(random);
    }
    
    // constructor for non-virtual call
    final public plham.util.RandomHelper plham$util$RandomHelper$$init$S(final x10.util.Random random) {
         {
            
            //#line 13 "/home/dsl/workspace/plhamK/plham/util/RandomHelper.x10"
            
            
            //#line 8 "/home/dsl/workspace/plhamK/plham/util/RandomHelper.x10"
            this.__fieldInitializers_plham_util_RandomHelper();
            
            //#line 14 "/home/dsl/workspace/plhamK/plham/util/RandomHelper.x10"
            this.random = ((random));
            
            //#line 15 "/home/dsl/workspace/plhamK/plham/util/RandomHelper.x10"
            final cassia.util.random.Gaussian t$26236 = ((new cassia.util.random.Gaussian((java.lang.System[]) null).cassia$util$random$Gaussian$$init$S(((random)))));
            
            //#line 15 "/home/dsl/workspace/plhamK/plham/util/RandomHelper.x10"
            this.g = ((t$26236));
        }
        return this;
    }
    
    
    
    //#line 18 "/home/dsl/workspace/plhamK/plham/util/RandomHelper.x10"
    public boolean nextBoolean$O() {
        
        //#line 18 "/home/dsl/workspace/plhamK/plham/util/RandomHelper.x10"
        final x10.util.Random t$26237 = ((this.random));
        
        //#line 18 "/home/dsl/workspace/plhamK/plham/util/RandomHelper.x10"
        final boolean t$26238 = t$26237.nextBoolean$O();
        
        //#line 18 "/home/dsl/workspace/plhamK/plham/util/RandomHelper.x10"
        return t$26238;
    }
    
    
    //#line 20 "/home/dsl/workspace/plhamK/plham/util/RandomHelper.x10"
    public boolean nextBoolean$O(final double p) {
        
        //#line 20 "/home/dsl/workspace/plhamK/plham/util/RandomHelper.x10"
        final x10.util.Random t$26239 = ((this.random));
        
        //#line 20 "/home/dsl/workspace/plhamK/plham/util/RandomHelper.x10"
        final double t$26240 = t$26239.nextDouble$O();
        
        //#line 20 "/home/dsl/workspace/plhamK/plham/util/RandomHelper.x10"
        final boolean t$26241 = ((t$26240) < (((p))));
        
        //#line 20 "/home/dsl/workspace/plhamK/plham/util/RandomHelper.x10"
        return t$26241;
    }
    
    
    //#line 22 "/home/dsl/workspace/plhamK/plham/util/RandomHelper.x10"
    public double nextDouble$O() {
        
        //#line 22 "/home/dsl/workspace/plhamK/plham/util/RandomHelper.x10"
        final x10.util.Random t$26242 = ((this.random));
        
        //#line 22 "/home/dsl/workspace/plhamK/plham/util/RandomHelper.x10"
        final double t$26243 = t$26242.nextDouble$O();
        
        //#line 22 "/home/dsl/workspace/plhamK/plham/util/RandomHelper.x10"
        return t$26243;
    }
    
    
    //#line 24 "/home/dsl/workspace/plhamK/plham/util/RandomHelper.x10"
    public double nextDouble$O(final double max) {
        
        //#line 24 "/home/dsl/workspace/plhamK/plham/util/RandomHelper.x10"
        final x10.util.Random t$26244 = ((this.random));
        
        //#line 24 "/home/dsl/workspace/plhamK/plham/util/RandomHelper.x10"
        final double t$26245 = t$26244.nextDouble$O();
        
        //#line 24 "/home/dsl/workspace/plhamK/plham/util/RandomHelper.x10"
        final double t$26246 = ((t$26245) * (((max))));
        
        //#line 24 "/home/dsl/workspace/plhamK/plham/util/RandomHelper.x10"
        return t$26246;
    }
    
    
    //#line 26 "/home/dsl/workspace/plhamK/plham/util/RandomHelper.x10"
    public float nextFloat$O() {
        
        //#line 26 "/home/dsl/workspace/plhamK/plham/util/RandomHelper.x10"
        final x10.util.Random t$26247 = ((this.random));
        
        //#line 26 "/home/dsl/workspace/plhamK/plham/util/RandomHelper.x10"
        final float t$26248 = t$26247.nextFloat$O();
        
        //#line 26 "/home/dsl/workspace/plhamK/plham/util/RandomHelper.x10"
        return t$26248;
    }
    
    
    //#line 28 "/home/dsl/workspace/plhamK/plham/util/RandomHelper.x10"
    public float nextFloat$O(final float max) {
        
        //#line 28 "/home/dsl/workspace/plhamK/plham/util/RandomHelper.x10"
        final x10.util.Random t$26249 = ((this.random));
        
        //#line 28 "/home/dsl/workspace/plhamK/plham/util/RandomHelper.x10"
        final float t$26250 = t$26249.nextFloat$O();
        
        //#line 28 "/home/dsl/workspace/plhamK/plham/util/RandomHelper.x10"
        final float t$26251 = ((t$26250) * (((max))));
        
        //#line 28 "/home/dsl/workspace/plhamK/plham/util/RandomHelper.x10"
        return t$26251;
    }
    
    
    //#line 30 "/home/dsl/workspace/plhamK/plham/util/RandomHelper.x10"
    public int nextInt$O(final int max) {
        
        //#line 30 "/home/dsl/workspace/plhamK/plham/util/RandomHelper.x10"
        final x10.util.Random t$26252 = ((this.random));
        
        //#line 30 "/home/dsl/workspace/plhamK/plham/util/RandomHelper.x10"
        final int t$26253 = t$26252.nextInt$O((max));
        
        //#line 30 "/home/dsl/workspace/plhamK/plham/util/RandomHelper.x10"
        return t$26253;
    }
    
    
    //#line 32 "/home/dsl/workspace/plhamK/plham/util/RandomHelper.x10"
    public long nextLong$O(final long max) {
        
        //#line 32 "/home/dsl/workspace/plhamK/plham/util/RandomHelper.x10"
        final x10.util.Random t$26254 = ((this.random));
        
        //#line 32 "/home/dsl/workspace/plhamK/plham/util/RandomHelper.x10"
        final long t$26255 = t$26254.nextLong$O((max));
        
        //#line 32 "/home/dsl/workspace/plhamK/plham/util/RandomHelper.x10"
        return t$26255;
    }
    
    
    //#line 34 "/home/dsl/workspace/plhamK/plham/util/RandomHelper.x10"
    public double nextGaussian$O() {
        
        //#line 34 "/home/dsl/workspace/plhamK/plham/util/RandomHelper.x10"
        final cassia.util.random.Gaussian t$26256 = ((this.g));
        
        //#line 34 "/home/dsl/workspace/plhamK/plham/util/RandomHelper.x10"
        final double t$26257 = t$26256.nextGaussian$O();
        
        //#line 34 "/home/dsl/workspace/plhamK/plham/util/RandomHelper.x10"
        return t$26257;
    }
    
    
    //#line 39 "/home/dsl/workspace/plhamK/plham/util/RandomHelper.x10"
    /**
	 * Get a sample from a uniform distribution between <code>min</code> and <code>max</code>.
	 */
    public double nextUniform$O(final double min, final double max) {
        
        //#line 40 "/home/dsl/workspace/plhamK/plham/util/RandomHelper.x10"
        final double t$26258 = this.nextDouble$O();
        
        //#line 40 "/home/dsl/workspace/plhamK/plham/util/RandomHelper.x10"
        final double t$26259 = ((max) - (((min))));
        
        //#line 40 "/home/dsl/workspace/plhamK/plham/util/RandomHelper.x10"
        final double t$26260 = ((t$26258) * (((t$26259))));
        
        //#line 40 "/home/dsl/workspace/plhamK/plham/util/RandomHelper.x10"
        final double t$26261 = ((t$26260) + (((min))));
        
        //#line 40 "/home/dsl/workspace/plhamK/plham/util/RandomHelper.x10"
        return t$26261;
    }
    
    
    //#line 46 "/home/dsl/workspace/plhamK/plham/util/RandomHelper.x10"
    /**
	 * Get a sample from a normal distribution, whose mean <code>mu</code> and variance <code>sigma</code>^2.
	 */
    public double nextNormal$O(final double mu, final double sigma) {
        
        //#line 47 "/home/dsl/workspace/plhamK/plham/util/RandomHelper.x10"
        final double t$26262 = this.nextGaussian$O();
        
        //#line 47 "/home/dsl/workspace/plhamK/plham/util/RandomHelper.x10"
        final double t$26263 = ((t$26262) * (((sigma))));
        
        //#line 47 "/home/dsl/workspace/plhamK/plham/util/RandomHelper.x10"
        final double t$26264 = ((mu) + (((t$26263))));
        
        //#line 47 "/home/dsl/workspace/plhamK/plham/util/RandomHelper.x10"
        return t$26264;
    }
    
    
    //#line 55 "/home/dsl/workspace/plhamK/plham/util/RandomHelper.x10"
    /**
	 * Get a sample from an exponential distribution, whose expected value is <code>lambda</code>.
	 * Cf: the standard notation may prefer the expected value to be <code>1 / lambda</code>,
	 * but here it is <code>lambda</code> so lambda can take even zero.
	 */
    public double nextExponential$O(final double lambda) {
        
        //#line 56 "/home/dsl/workspace/plhamK/plham/util/RandomHelper.x10"
        final double t$26265 = this.nextDouble$O();
        
        //#line 56 "/home/dsl/workspace/plhamK/plham/util/RandomHelper.x10"
        final double t$26266 = java.lang.Math.log(((t$26265)));
        
        //#line 56 "/home/dsl/workspace/plhamK/plham/util/RandomHelper.x10"
        final double t$26267 = (-(t$26266));
        
        //#line 56 "/home/dsl/workspace/plhamK/plham/util/RandomHelper.x10"
        final double t$26268 = ((lambda) * (((t$26267))));
        
        //#line 56 "/home/dsl/workspace/plhamK/plham/util/RandomHelper.x10"
        return t$26268;
    }
    
    
    //#line 59 "/home/dsl/workspace/plhamK/plham/util/RandomHelper.x10"
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
            RandomHelper.main(args);
        }
    }
    
    // the original app-main method
    public static void main(final x10.core.Rail<java.lang.String> id$48) {
        
        //#line 60 "/home/dsl/workspace/plhamK/plham/util/RandomHelper.x10"
        final x10.util.Random t$26269 = ((new x10.util.Random((java.lang.System[]) null).x10$util$Random$$init$S()));
        
        //#line 60 "/home/dsl/workspace/plhamK/plham/util/RandomHelper.x10"
        final plham.util.RandomHelper random = ((new plham.util.RandomHelper((java.lang.System[]) null).plham$util$RandomHelper$$init$S(((t$26269)))));
        
        //#line 62 "/home/dsl/workspace/plhamK/plham/util/RandomHelper.x10"
        final long n = 100L;
        
        //#line 63 "/home/dsl/workspace/plhamK/plham/util/RandomHelper.x10"
        final x10.core.Rail U = ((new x10.core.Rail<x10.core.Long>(x10.rtt.Types.LONG, ((n)))));
        
        //#line 64 "/home/dsl/workspace/plhamK/plham/util/RandomHelper.x10"
        final x10.core.Rail N = ((new x10.core.Rail<x10.core.Long>(x10.rtt.Types.LONG, ((n)))));
        
        //#line 65 "/home/dsl/workspace/plhamK/plham/util/RandomHelper.x10"
        final x10.core.Rail E = ((new x10.core.Rail<x10.core.Long>(x10.rtt.Types.LONG, ((n)))));
        
        //#line 67 "/home/dsl/workspace/plhamK/plham/util/RandomHelper.x10"
        final long i$26165min$26374 = 1L;
        
        //#line 67 "/home/dsl/workspace/plhamK/plham/util/RandomHelper.x10"
        final long i$26165max$26375 = 1000000L;
        
        //#line 67 "/home/dsl/workspace/plhamK/plham/util/RandomHelper.x10"
        long i$26326 = i$26165min$26374;
        {
            
            //#line 67 "/home/dsl/workspace/plhamK/plham/util/RandomHelper.x10"
            final long[] U$value$26382 = ((long[])U.value);
            
            //#line 67 "/home/dsl/workspace/plhamK/plham/util/RandomHelper.x10"
            for (;
                 true;
                 ) {
                
                //#line 67 "/home/dsl/workspace/plhamK/plham/util/RandomHelper.x10"
                final long t$26327 = i$26326;
                
                //#line 67 "/home/dsl/workspace/plhamK/plham/util/RandomHelper.x10"
                final boolean t$26328 = ((t$26327) <= (((i$26165max$26375))));
                
                //#line 67 "/home/dsl/workspace/plhamK/plham/util/RandomHelper.x10"
                if (!(t$26328)) {
                    
                    //#line 67 "/home/dsl/workspace/plhamK/plham/util/RandomHelper.x10"
                    break;
                }
                
                //#line 67 "/home/dsl/workspace/plhamK/plham/util/RandomHelper.x10"
                final long t$26323 = i$26326;
                
                //#line 68 "/home/dsl/workspace/plhamK/plham/util/RandomHelper.x10"
                final double t$26317 = ((((0L))));
                
                //#line 68 "/home/dsl/workspace/plhamK/plham/util/RandomHelper.x10"
                final double t$26318 = ((((n))));
                
                //#line 68 "/home/dsl/workspace/plhamK/plham/util/RandomHelper.x10"
                final double x$26319 = random.nextUniform$O((t$26317), (t$26318));
                
                //#line 69 "/home/dsl/workspace/plhamK/plham/util/RandomHelper.x10"
                final long i$26320 = ((long)(((x$26319))));
                
                //#line 70 "/home/dsl/workspace/plhamK/plham/util/RandomHelper.x10"
                final long t$26321 = (U$value$26382[(int)i$26320]);
                
                //#line 70 "/home/dsl/workspace/plhamK/plham/util/RandomHelper.x10"
                final long t$26322 = ((t$26321) + (((1L))));
                
                //#line 70 "/home/dsl/workspace/plhamK/plham/util/RandomHelper.x10"
                U$value$26382[(int)i$26320]=t$26322;
                
                //#line 67 "/home/dsl/workspace/plhamK/plham/util/RandomHelper.x10"
                final long t$26324 = i$26326;
                
                //#line 67 "/home/dsl/workspace/plhamK/plham/util/RandomHelper.x10"
                final long t$26325 = ((t$26324) + (((1L))));
                
                //#line 67 "/home/dsl/workspace/plhamK/plham/util/RandomHelper.x10"
                i$26326 = t$26325;
            }
        }
        
        //#line 72 "/home/dsl/workspace/plhamK/plham/util/RandomHelper.x10"
        final long i$26183min$26376 = 1L;
        
        //#line 72 "/home/dsl/workspace/plhamK/plham/util/RandomHelper.x10"
        final long i$26183max$26377 = 1000000L;
        
        //#line 72 "/home/dsl/workspace/plhamK/plham/util/RandomHelper.x10"
        long i$26342 = i$26183min$26376;
        {
            
            //#line 72 "/home/dsl/workspace/plhamK/plham/util/RandomHelper.x10"
            final long[] N$value$26383 = ((long[])N.value);
            
            //#line 72 "/home/dsl/workspace/plhamK/plham/util/RandomHelper.x10"
            for (;
                 true;
                 ) {
                
                //#line 72 "/home/dsl/workspace/plhamK/plham/util/RandomHelper.x10"
                final long t$26343 = i$26342;
                
                //#line 72 "/home/dsl/workspace/plhamK/plham/util/RandomHelper.x10"
                final boolean t$26344 = ((t$26343) <= (((i$26183max$26377))));
                
                //#line 72 "/home/dsl/workspace/plhamK/plham/util/RandomHelper.x10"
                if (!(t$26344)) {
                    
                    //#line 72 "/home/dsl/workspace/plhamK/plham/util/RandomHelper.x10"
                    break;
                }
                
                //#line 72 "/home/dsl/workspace/plhamK/plham/util/RandomHelper.x10"
                final long t$26339 = i$26342;
                
                //#line 73 "/home/dsl/workspace/plhamK/plham/util/RandomHelper.x10"
                final double t$26329 = ((((0L))));
                
                //#line 73 "/home/dsl/workspace/plhamK/plham/util/RandomHelper.x10"
                final double t$26330 = ((((1L))));
                
                //#line 73 "/home/dsl/workspace/plhamK/plham/util/RandomHelper.x10"
                final double x$26331 = random.nextNormal$O((t$26329), (t$26330));
                
                //#line 74 "/home/dsl/workspace/plhamK/plham/util/RandomHelper.x10"
                final double t$26332 = ((((50L))));
                
                //#line 74 "/home/dsl/workspace/plhamK/plham/util/RandomHelper.x10"
                final double t$26333 = ((x$26331) + (((t$26332))));
                
                //#line 74 "/home/dsl/workspace/plhamK/plham/util/RandomHelper.x10"
                final long t$26334 = ((long)(((t$26333))));
                
                //#line 74 "/home/dsl/workspace/plhamK/plham/util/RandomHelper.x10"
                final long t$26335 = java.lang.Math.max(((t$26334)),((0L)));
                
                //#line 74 "/home/dsl/workspace/plhamK/plham/util/RandomHelper.x10"
                final long i$26336 = java.lang.Math.min(((t$26335)),((99L)));
                
                //#line 75 "/home/dsl/workspace/plhamK/plham/util/RandomHelper.x10"
                final long t$26337 = (N$value$26383[(int)i$26336]);
                
                //#line 75 "/home/dsl/workspace/plhamK/plham/util/RandomHelper.x10"
                final long t$26338 = ((t$26337) + (((1L))));
                
                //#line 75 "/home/dsl/workspace/plhamK/plham/util/RandomHelper.x10"
                N$value$26383[(int)i$26336]=t$26338;
                
                //#line 72 "/home/dsl/workspace/plhamK/plham/util/RandomHelper.x10"
                final long t$26340 = i$26342;
                
                //#line 72 "/home/dsl/workspace/plhamK/plham/util/RandomHelper.x10"
                final long t$26341 = ((t$26340) + (((1L))));
                
                //#line 72 "/home/dsl/workspace/plhamK/plham/util/RandomHelper.x10"
                i$26342 = t$26341;
            }
        }
        
        //#line 77 "/home/dsl/workspace/plhamK/plham/util/RandomHelper.x10"
        final long i$26201min$26378 = 1L;
        
        //#line 77 "/home/dsl/workspace/plhamK/plham/util/RandomHelper.x10"
        final long i$26201max$26379 = 1000000L;
        
        //#line 77 "/home/dsl/workspace/plhamK/plham/util/RandomHelper.x10"
        long i$26355 = i$26201min$26378;
        {
            
            //#line 77 "/home/dsl/workspace/plhamK/plham/util/RandomHelper.x10"
            final long[] E$value$26384 = ((long[])E.value);
            
            //#line 77 "/home/dsl/workspace/plhamK/plham/util/RandomHelper.x10"
            for (;
                 true;
                 ) {
                
                //#line 77 "/home/dsl/workspace/plhamK/plham/util/RandomHelper.x10"
                final long t$26356 = i$26355;
                
                //#line 77 "/home/dsl/workspace/plhamK/plham/util/RandomHelper.x10"
                final boolean t$26357 = ((t$26356) <= (((i$26201max$26379))));
                
                //#line 77 "/home/dsl/workspace/plhamK/plham/util/RandomHelper.x10"
                if (!(t$26357)) {
                    
                    //#line 77 "/home/dsl/workspace/plhamK/plham/util/RandomHelper.x10"
                    break;
                }
                
                //#line 77 "/home/dsl/workspace/plhamK/plham/util/RandomHelper.x10"
                final long t$26352 = i$26355;
                
                //#line 78 "/home/dsl/workspace/plhamK/plham/util/RandomHelper.x10"
                final double t$26345 = ((((10L))));
                
                //#line 78 "/home/dsl/workspace/plhamK/plham/util/RandomHelper.x10"
                final double x$26346 = random.nextExponential$O((t$26345));
                
                //#line 79 "/home/dsl/workspace/plhamK/plham/util/RandomHelper.x10"
                final long t$26347 = ((long)(((x$26346))));
                
                //#line 79 "/home/dsl/workspace/plhamK/plham/util/RandomHelper.x10"
                final long t$26348 = java.lang.Math.max(((t$26347)),((0L)));
                
                //#line 79 "/home/dsl/workspace/plhamK/plham/util/RandomHelper.x10"
                final long i$26349 = java.lang.Math.min(((t$26348)),((99L)));
                
                //#line 80 "/home/dsl/workspace/plhamK/plham/util/RandomHelper.x10"
                final long t$26350 = (E$value$26384[(int)i$26349]);
                
                //#line 80 "/home/dsl/workspace/plhamK/plham/util/RandomHelper.x10"
                final long t$26351 = ((t$26350) + (((1L))));
                
                //#line 80 "/home/dsl/workspace/plhamK/plham/util/RandomHelper.x10"
                E$value$26384[(int)i$26349]=t$26351;
                
                //#line 77 "/home/dsl/workspace/plhamK/plham/util/RandomHelper.x10"
                final long t$26353 = i$26355;
                
                //#line 77 "/home/dsl/workspace/plhamK/plham/util/RandomHelper.x10"
                final long t$26354 = ((t$26353) + (((1L))));
                
                //#line 77 "/home/dsl/workspace/plhamK/plham/util/RandomHelper.x10"
                i$26355 = t$26354;
            }
        }
        
        //#line 82 "/home/dsl/workspace/plhamK/plham/util/RandomHelper.x10"
        final long i$26219min$26380 = 0L;
        
        //#line 82 "/home/dsl/workspace/plhamK/plham/util/RandomHelper.x10"
        final long i$26219max$26381 = 99L;
        
        //#line 82 "/home/dsl/workspace/plhamK/plham/util/RandomHelper.x10"
        long i$26371 = i$26219min$26380;
        {
            
            //#line 82 "/home/dsl/workspace/plhamK/plham/util/RandomHelper.x10"
            final long[] U$value$26385 = ((long[])U.value);
            
            //#line 82 "/home/dsl/workspace/plhamK/plham/util/RandomHelper.x10"
            final long[] N$value$26386 = ((long[])N.value);
            
            //#line 82 "/home/dsl/workspace/plhamK/plham/util/RandomHelper.x10"
            final long[] E$value$26387 = ((long[])E.value);
            
            //#line 82 "/home/dsl/workspace/plhamK/plham/util/RandomHelper.x10"
            for (;
                 true;
                 ) {
                
                //#line 82 "/home/dsl/workspace/plhamK/plham/util/RandomHelper.x10"
                final long t$26372 = i$26371;
                
                //#line 82 "/home/dsl/workspace/plhamK/plham/util/RandomHelper.x10"
                final boolean t$26373 = ((t$26372) <= (((i$26219max$26381))));
                
                //#line 82 "/home/dsl/workspace/plhamK/plham/util/RandomHelper.x10"
                if (!(t$26373)) {
                    
                    //#line 82 "/home/dsl/workspace/plhamK/plham/util/RandomHelper.x10"
                    break;
                }
                
                //#line 82 "/home/dsl/workspace/plhamK/plham/util/RandomHelper.x10"
                final long i$26368 = i$26371;
                
                //#line 83 "/home/dsl/workspace/plhamK/plham/util/RandomHelper.x10"
                final x10.io.Printer t$26358 = ((x10.io.Console.get$OUT()));
                
                //#line 83 "/home/dsl/workspace/plhamK/plham/util/RandomHelper.x10"
                final java.lang.String t$26359 = (((x10.core.Long.$box(i$26368))) + (" "));
                
                //#line 83 "/home/dsl/workspace/plhamK/plham/util/RandomHelper.x10"
                final long t$26360 = (U$value$26385[(int)i$26368]);
                
                //#line 83 "/home/dsl/workspace/plhamK/plham/util/RandomHelper.x10"
                final java.lang.String t$26361 = ((t$26359) + ((x10.core.Long.$box(t$26360))));
                
                //#line 83 "/home/dsl/workspace/plhamK/plham/util/RandomHelper.x10"
                final java.lang.String t$26362 = ((t$26361) + (" "));
                
                //#line 83 "/home/dsl/workspace/plhamK/plham/util/RandomHelper.x10"
                final long t$26363 = (N$value$26386[(int)i$26368]);
                
                //#line 83 "/home/dsl/workspace/plhamK/plham/util/RandomHelper.x10"
                final java.lang.String t$26364 = ((t$26362) + ((x10.core.Long.$box(t$26363))));
                
                //#line 83 "/home/dsl/workspace/plhamK/plham/util/RandomHelper.x10"
                final java.lang.String t$26365 = ((t$26364) + (" "));
                
                //#line 83 "/home/dsl/workspace/plhamK/plham/util/RandomHelper.x10"
                final long t$26366 = (E$value$26387[(int)i$26368]);
                
                //#line 83 "/home/dsl/workspace/plhamK/plham/util/RandomHelper.x10"
                final java.lang.String t$26367 = ((t$26365) + ((x10.core.Long.$box(t$26366))));
                
                //#line 83 "/home/dsl/workspace/plhamK/plham/util/RandomHelper.x10"
                t$26358.println(((t$26367)));
                
                //#line 82 "/home/dsl/workspace/plhamK/plham/util/RandomHelper.x10"
                final long t$26369 = i$26371;
                
                //#line 82 "/home/dsl/workspace/plhamK/plham/util/RandomHelper.x10"
                final long t$26370 = ((t$26369) + (((1L))));
                
                //#line 82 "/home/dsl/workspace/plhamK/plham/util/RandomHelper.x10"
                i$26371 = t$26370;
            }
        }
    }
    
    
    //#line 8 "/home/dsl/workspace/plhamK/plham/util/RandomHelper.x10"
    final public plham.util.RandomHelper plham$util$RandomHelper$$this$plham$util$RandomHelper() {
        
        //#line 8 "/home/dsl/workspace/plhamK/plham/util/RandomHelper.x10"
        return plham.util.RandomHelper.this;
    }
    
    
    //#line 8 "/home/dsl/workspace/plhamK/plham/util/RandomHelper.x10"
    final public void __fieldInitializers_plham_util_RandomHelper() {
        
        //#line 8 "/home/dsl/workspace/plhamK/plham/util/RandomHelper.x10"
        this.random = null;
        
        //#line 8 "/home/dsl/workspace/plhamK/plham/util/RandomHelper.x10"
        this.g = null;
    }
}

