package cassia.util.random;


@x10.runtime.impl.java.X10Generated
public class Gaussian extends x10.core.Ref implements x10.serialization.X10JavaSerializable
{
    public static final x10.rtt.RuntimeType<Gaussian> $RTT = 
        x10.rtt.NamedType.<Gaussian> make("cassia.util.random.Gaussian",
                                          Gaussian.class);
    
    public x10.rtt.RuntimeType<?> $getRTT() { return $RTT; }
    
    public x10.rtt.Type<?> $getParam(int i) { return null; }
    
    private Object writeReplace() throws java.io.ObjectStreamException {
        return new x10.serialization.SerializationProxy(this);
    }
    
    public static x10.serialization.X10JavaSerializable $_deserialize_body(cassia.util.random.Gaussian $_obj, x10.serialization.X10JavaDeserializer $deserializer) throws java.io.IOException {
        if (x10.runtime.impl.java.Runtime.TRACE_SER) { x10.runtime.impl.java.Runtime.printTraceMessage("X10JavaSerializable: $_deserialize_body() of " + Gaussian.class + " calling"); } 
        $_obj.g = $deserializer.readDouble();
        $_obj.random = $deserializer.readObject();
        $_obj.state = $deserializer.readBoolean();
        return $_obj;
    }
    
    public static x10.serialization.X10JavaSerializable $_deserializer(x10.serialization.X10JavaDeserializer $deserializer) throws java.io.IOException {
        cassia.util.random.Gaussian $_obj = new cassia.util.random.Gaussian((java.lang.System[]) null);
        $deserializer.record_reference($_obj);
        return $_deserialize_body($_obj, $deserializer);
    }
    
    public void $_serialize(x10.serialization.X10JavaSerializer $serializer) throws java.io.IOException {
        $serializer.write(this.g);
        $serializer.write(this.random);
        $serializer.write(this.state);
        
    }
    
    // constructor just for allocation
    public Gaussian(final java.lang.System[] $dummy) {
        
    }
    
    

    
    //#line 7 "/home/dsl/workspace/plhamK/cassia/util/random/Gaussian.x10"
    public boolean state;
    
    //#line 8 "/home/dsl/workspace/plhamK/cassia/util/random/Gaussian.x10"
    public double g;
    
    //#line 9 "/home/dsl/workspace/plhamK/cassia/util/random/Gaussian.x10"
    public x10.util.Random random;
    
    
    //#line 11 "/home/dsl/workspace/plhamK/cassia/util/random/Gaussian.x10"
    // creation method for java code (1-phase java constructor)
    public Gaussian(final x10.util.Random random) {
        this((java.lang.System[]) null);
        cassia$util$random$Gaussian$$init$S(random);
    }
    
    // constructor for non-virtual call
    final public cassia.util.random.Gaussian cassia$util$random$Gaussian$$init$S(final x10.util.Random random) {
         {
            
            //#line 11 "/home/dsl/workspace/plhamK/cassia/util/random/Gaussian.x10"
            
            
            //#line 5 "/home/dsl/workspace/plhamK/cassia/util/random/Gaussian.x10"
            this.__fieldInitializers_cassia_util_random_Gaussian();
            
            //#line 12 "/home/dsl/workspace/plhamK/cassia/util/random/Gaussian.x10"
            this.state = false;
            
            //#line 13 "/home/dsl/workspace/plhamK/cassia/util/random/Gaussian.x10"
            final double t$33251 = ((((-1L))));
            
            //#line 13 "/home/dsl/workspace/plhamK/cassia/util/random/Gaussian.x10"
            this.g = t$33251;
            
            //#line 14 "/home/dsl/workspace/plhamK/cassia/util/random/Gaussian.x10"
            this.random = ((random));
        }
        return this;
    }
    
    
    
    //#line 17 "/home/dsl/workspace/plhamK/cassia/util/random/Gaussian.x10"
    public double nextGaussian$O() {
        
        //#line 18 "/home/dsl/workspace/plhamK/cassia/util/random/Gaussian.x10"
        final boolean t$33283 = this.state;
        
        //#line 18 "/home/dsl/workspace/plhamK/cassia/util/random/Gaussian.x10"
        if (t$33283) {
            
            //#line 19 "/home/dsl/workspace/plhamK/cassia/util/random/Gaussian.x10"
            this.state = false;
            
            //#line 20 "/home/dsl/workspace/plhamK/cassia/util/random/Gaussian.x10"
            final double t$33252 = this.g;
            
            //#line 20 "/home/dsl/workspace/plhamK/cassia/util/random/Gaussian.x10"
            return t$33252;
        } else {
            
            //#line 22 "/home/dsl/workspace/plhamK/cassia/util/random/Gaussian.x10"
            this.state = true;
            
            //#line 23 "/home/dsl/workspace/plhamK/cassia/util/random/Gaussian.x10"
            double v1 =  0;
            
            //#line 24 "/home/dsl/workspace/plhamK/cassia/util/random/Gaussian.x10"
            double v2 =  0;
            
            //#line 25 "/home/dsl/workspace/plhamK/cassia/util/random/Gaussian.x10"
            double s =  0;
            
            //#line 26 "/home/dsl/workspace/plhamK/cassia/util/random/Gaussian.x10"
            boolean t$33372 = false;
            
            //#line 26 "/home/dsl/workspace/plhamK/cassia/util/random/Gaussian.x10"
            do  {
                
                //#line 27 "/home/dsl/workspace/plhamK/cassia/util/random/Gaussian.x10"
                final x10.util.Random t$33357 = ((this.random));
                
                //#line 27 "/home/dsl/workspace/plhamK/cassia/util/random/Gaussian.x10"
                final double t$33358 = t$33357.nextDouble$O();
                
                //#line 27 "/home/dsl/workspace/plhamK/cassia/util/random/Gaussian.x10"
                final double t$33359 = ((2.0) * (((t$33358))));
                
                //#line 27 "/home/dsl/workspace/plhamK/cassia/util/random/Gaussian.x10"
                final double t$33360 = ((t$33359) - (((1.0))));
                
                //#line 27 "/home/dsl/workspace/plhamK/cassia/util/random/Gaussian.x10"
                v1 = t$33360;
                
                //#line 28 "/home/dsl/workspace/plhamK/cassia/util/random/Gaussian.x10"
                final x10.util.Random t$33361 = ((this.random));
                
                //#line 28 "/home/dsl/workspace/plhamK/cassia/util/random/Gaussian.x10"
                final double t$33362 = t$33361.nextDouble$O();
                
                //#line 28 "/home/dsl/workspace/plhamK/cassia/util/random/Gaussian.x10"
                final double t$33363 = ((2.0) * (((t$33362))));
                
                //#line 28 "/home/dsl/workspace/plhamK/cassia/util/random/Gaussian.x10"
                final double t$33364 = ((t$33363) - (((1.0))));
                
                //#line 28 "/home/dsl/workspace/plhamK/cassia/util/random/Gaussian.x10"
                v2 = t$33364;
                
                //#line 29 "/home/dsl/workspace/plhamK/cassia/util/random/Gaussian.x10"
                final double t$33365 = v1;
                
                //#line 29 "/home/dsl/workspace/plhamK/cassia/util/random/Gaussian.x10"
                final double t$33366 = v1;
                
                //#line 29 "/home/dsl/workspace/plhamK/cassia/util/random/Gaussian.x10"
                final double t$33367 = ((t$33365) * (((t$33366))));
                
                //#line 29 "/home/dsl/workspace/plhamK/cassia/util/random/Gaussian.x10"
                final double t$33368 = v2;
                
                //#line 29 "/home/dsl/workspace/plhamK/cassia/util/random/Gaussian.x10"
                final double t$33369 = v2;
                
                //#line 29 "/home/dsl/workspace/plhamK/cassia/util/random/Gaussian.x10"
                final double t$33370 = ((t$33368) * (((t$33369))));
                
                //#line 29 "/home/dsl/workspace/plhamK/cassia/util/random/Gaussian.x10"
                final double t$33371 = ((t$33367) + (((t$33370))));
                
                //#line 29 "/home/dsl/workspace/plhamK/cassia/util/random/Gaussian.x10"
                s = t$33371;
                
                //#line 30 "/home/dsl/workspace/plhamK/cassia/util/random/Gaussian.x10"
                final double t$33373 = s;
                
                //#line 30 "/home/dsl/workspace/plhamK/cassia/util/random/Gaussian.x10"
                final boolean t$33374 = ((t$33373) >= (((1.0))));
                
                //#line 26 "/home/dsl/workspace/plhamK/cassia/util/random/Gaussian.x10"
                t$33372 = t$33374;
            }while(t$33372); 
            
            //#line 32 "/home/dsl/workspace/plhamK/cassia/util/random/Gaussian.x10"
            final double t$33272 = -2.0;
            
            //#line 32 "/home/dsl/workspace/plhamK/cassia/util/random/Gaussian.x10"
            final double t$33271 = s;
            
            //#line 32 "/home/dsl/workspace/plhamK/cassia/util/random/Gaussian.x10"
            final double t$33273 = java.lang.Math.log(((t$33271)));
            
            //#line 32 "/home/dsl/workspace/plhamK/cassia/util/random/Gaussian.x10"
            final double t$33274 = ((t$33272) * (((t$33273))));
            
            //#line 32 "/home/dsl/workspace/plhamK/cassia/util/random/Gaussian.x10"
            final double t$33275 = s;
            
            //#line 32 "/home/dsl/workspace/plhamK/cassia/util/random/Gaussian.x10"
            final double t$33276 = ((t$33274) / (((t$33275))));
            
            //#line 32 "/home/dsl/workspace/plhamK/cassia/util/random/Gaussian.x10"
            double norm = java.lang.Math.sqrt(((t$33276)));
            
            //#line 33 "/home/dsl/workspace/plhamK/cassia/util/random/Gaussian.x10"
            final double t$33277 = v2;
            
            //#line 33 "/home/dsl/workspace/plhamK/cassia/util/random/Gaussian.x10"
            final double t$33278 = norm;
            
            //#line 33 "/home/dsl/workspace/plhamK/cassia/util/random/Gaussian.x10"
            final double t$33279 = ((t$33277) * (((t$33278))));
            
            //#line 33 "/home/dsl/workspace/plhamK/cassia/util/random/Gaussian.x10"
            this.g = t$33279;
            
            //#line 34 "/home/dsl/workspace/plhamK/cassia/util/random/Gaussian.x10"
            final double t$33280 = v1;
            
            //#line 34 "/home/dsl/workspace/plhamK/cassia/util/random/Gaussian.x10"
            final double t$33281 = norm;
            
            //#line 34 "/home/dsl/workspace/plhamK/cassia/util/random/Gaussian.x10"
            final double t$33282 = ((t$33280) * (((t$33281))));
            
            //#line 34 "/home/dsl/workspace/plhamK/cassia/util/random/Gaussian.x10"
            return t$33282;
        }
    }
    
    
    //#line 38 "/home/dsl/workspace/plhamK/cassia/util/random/Gaussian.x10"
    public double nextGaussian$O(final double mu, final double sigma) {
        
        //#line 39 "/home/dsl/workspace/plhamK/cassia/util/random/Gaussian.x10"
        final double t$33284 = this.nextGaussian$O();
        
        //#line 39 "/home/dsl/workspace/plhamK/cassia/util/random/Gaussian.x10"
        final double t$33285 = ((sigma) * (((t$33284))));
        
        //#line 39 "/home/dsl/workspace/plhamK/cassia/util/random/Gaussian.x10"
        final double t$33286 = ((mu) + (((t$33285))));
        
        //#line 39 "/home/dsl/workspace/plhamK/cassia/util/random/Gaussian.x10"
        return t$33286;
    }
    
    
    //#line 42 "/home/dsl/workspace/plhamK/cassia/util/random/Gaussian.x10"
    public static double gaussDenseValue$O(final double x, final double mu, final double sigma) {
        
        //#line 43 "/home/dsl/workspace/plhamK/cassia/util/random/Gaussian.x10"
        final double t$33287 = ((((-1L))));
        
        //#line 43 "/home/dsl/workspace/plhamK/cassia/util/random/Gaussian.x10"
        final double t$33288 = ((x) - (((mu))));
        
        //#line 43 "/home/dsl/workspace/plhamK/cassia/util/random/Gaussian.x10"
        final double t$33289 = ((t$33287) * (((t$33288))));
        
        //#line 43 "/home/dsl/workspace/plhamK/cassia/util/random/Gaussian.x10"
        final double t$33290 = ((x) - (((mu))));
        
        //#line 43 "/home/dsl/workspace/plhamK/cassia/util/random/Gaussian.x10"
        final double t$33293 = ((t$33289) * (((t$33290))));
        
        //#line 43 "/home/dsl/workspace/plhamK/cassia/util/random/Gaussian.x10"
        final double t$33291 = ((((2L))));
        
        //#line 43 "/home/dsl/workspace/plhamK/cassia/util/random/Gaussian.x10"
        final double t$33292 = ((t$33291) * (((sigma))));
        
        //#line 43 "/home/dsl/workspace/plhamK/cassia/util/random/Gaussian.x10"
        final double t$33294 = ((t$33292) * (((sigma))));
        
        //#line 43 "/home/dsl/workspace/plhamK/cassia/util/random/Gaussian.x10"
        final double t$33295 = ((t$33293) / (((t$33294))));
        
        //#line 43 "/home/dsl/workspace/plhamK/cassia/util/random/Gaussian.x10"
        final double t$33301 = java.lang.Math.exp(((t$33295)));
        
        //#line 43 "/home/dsl/workspace/plhamK/cassia/util/random/Gaussian.x10"
        final double t$33296 = ((((2L))));
        
        //#line 43 "/home/dsl/workspace/plhamK/cassia/util/random/Gaussian.x10"
        final double t$33297 = x10.lang.Math.PI;
        
        //#line 43 "/home/dsl/workspace/plhamK/cassia/util/random/Gaussian.x10"
        final double t$33298 = ((t$33296) * (((t$33297))));
        
        //#line 43 "/home/dsl/workspace/plhamK/cassia/util/random/Gaussian.x10"
        final double t$33299 = ((t$33298) * (((sigma))));
        
        //#line 43 "/home/dsl/workspace/plhamK/cassia/util/random/Gaussian.x10"
        final double t$33300 = ((t$33299) * (((sigma))));
        
        //#line 43 "/home/dsl/workspace/plhamK/cassia/util/random/Gaussian.x10"
        final double t$33302 = java.lang.Math.pow(((t$33300)),((0.5)));
        
        //#line 43 "/home/dsl/workspace/plhamK/cassia/util/random/Gaussian.x10"
        final double out = ((t$33301) / (((t$33302))));
        
        //#line 44 "/home/dsl/workspace/plhamK/cassia/util/random/Gaussian.x10"
        return out;
    }
    
    
    //#line 47 "/home/dsl/workspace/plhamK/cassia/util/random/Gaussian.x10"
    public static double gaussCumulativeValue$O(final double a, final double b, final double delta, final double mu, final double sigma) {
        
        //#line 48 "/home/dsl/workspace/plhamK/cassia/util/random/Gaussian.x10"
        assert ((a) < (((b)))) && ((delta) > (((0.0)))) && ((delta) < (((1.0)))) && !(java.lang.Double.isInfinite(a)) && !(java.lang.Double.isInfinite(b)): "gaussCumulativeValueError";
        
        //#line 49 "/home/dsl/workspace/plhamK/cassia/util/random/Gaussian.x10"
        double out = 0.0;
        
        //#line 50 "/home/dsl/workspace/plhamK/cassia/util/random/Gaussian.x10"
        final double t$33303 = ((b) - (((a))));
        
        //#line 50 "/home/dsl/workspace/plhamK/cassia/util/random/Gaussian.x10"
        final double n = ((t$33303) / (((delta))));
        
        //#line 51 "/home/dsl/workspace/plhamK/cassia/util/random/Gaussian.x10"
        long i$33385 = 0L;
        
        //#line 51 "/home/dsl/workspace/plhamK/cassia/util/random/Gaussian.x10"
        for (;
             true;
             ) {
            
            //#line 51 "/home/dsl/workspace/plhamK/cassia/util/random/Gaussian.x10"
            final long t$33386 = i$33385;
            
            //#line 51 "/home/dsl/workspace/plhamK/cassia/util/random/Gaussian.x10"
            final double t$33387 = ((((t$33386))));
            
            //#line 51 "/home/dsl/workspace/plhamK/cassia/util/random/Gaussian.x10"
            final boolean t$33388 = ((t$33387) <= (((n))));
            
            //#line 51 "/home/dsl/workspace/plhamK/cassia/util/random/Gaussian.x10"
            if (!(t$33388)) {
                
                //#line 51 "/home/dsl/workspace/plhamK/cassia/util/random/Gaussian.x10"
                break;
            }
            
            //#line 52 "/home/dsl/workspace/plhamK/cassia/util/random/Gaussian.x10"
            final long t$33375 = i$33385;
            
            //#line 52 "/home/dsl/workspace/plhamK/cassia/util/random/Gaussian.x10"
            final double t$33376 = ((((t$33375))));
            
            //#line 52 "/home/dsl/workspace/plhamK/cassia/util/random/Gaussian.x10"
            final double t$33377 = ((t$33376) * (((delta))));
            
            //#line 52 "/home/dsl/workspace/plhamK/cassia/util/random/Gaussian.x10"
            final double v$33378 = ((a) + (((t$33377))));
            
            //#line 53 "/home/dsl/workspace/plhamK/cassia/util/random/Gaussian.x10"
            final double t$33379 = out;
            
            //#line 53 "/home/dsl/workspace/plhamK/cassia/util/random/Gaussian.x10"
            final double t$33380 = cassia.util.random.Gaussian.gaussDenseValue$O((v$33378), (mu), (sigma));
            
            //#line 53 "/home/dsl/workspace/plhamK/cassia/util/random/Gaussian.x10"
            final double t$33381 = ((t$33380) * (((delta))));
            
            //#line 53 "/home/dsl/workspace/plhamK/cassia/util/random/Gaussian.x10"
            final double t$33382 = ((t$33379) + (((t$33381))));
            
            //#line 53 "/home/dsl/workspace/plhamK/cassia/util/random/Gaussian.x10"
            out = t$33382;
            
            //#line 51 "/home/dsl/workspace/plhamK/cassia/util/random/Gaussian.x10"
            final long t$33383 = i$33385;
            
            //#line 51 "/home/dsl/workspace/plhamK/cassia/util/random/Gaussian.x10"
            final long t$33384 = ((t$33383) + (((1L))));
            
            //#line 51 "/home/dsl/workspace/plhamK/cassia/util/random/Gaussian.x10"
            i$33385 = t$33384;
        }
        
        //#line 55 "/home/dsl/workspace/plhamK/cassia/util/random/Gaussian.x10"
        final double t$33317 = out;
        
        //#line 55 "/home/dsl/workspace/plhamK/cassia/util/random/Gaussian.x10"
        return t$33317;
    }
    
    
    //#line 58 "/home/dsl/workspace/plhamK/cassia/util/random/Gaussian.x10"
    public static double gaussExpectedValue$O(final double a, final double b, final double delta, final double mu, final double sigma) {
        
        //#line 59 "/home/dsl/workspace/plhamK/cassia/util/random/Gaussian.x10"
        assert ((a) < (((b)))) && ((delta) > (((0.0)))) && ((delta) < (((1.0)))) && !(java.lang.Double.isInfinite(a)) && !(java.lang.Double.isInfinite(b)): "gaussExpectedValueError";
        
        //#line 60 "/home/dsl/workspace/plhamK/cassia/util/random/Gaussian.x10"
        double out = 0.0;
        
        //#line 61 "/home/dsl/workspace/plhamK/cassia/util/random/Gaussian.x10"
        final double t$33318 = ((b) - (((a))));
        
        //#line 61 "/home/dsl/workspace/plhamK/cassia/util/random/Gaussian.x10"
        final double n = ((t$33318) / (((delta))));
        
        //#line 62 "/home/dsl/workspace/plhamK/cassia/util/random/Gaussian.x10"
        long i$33400 = 0L;
        
        //#line 62 "/home/dsl/workspace/plhamK/cassia/util/random/Gaussian.x10"
        for (;
             true;
             ) {
            
            //#line 62 "/home/dsl/workspace/plhamK/cassia/util/random/Gaussian.x10"
            final long t$33401 = i$33400;
            
            //#line 62 "/home/dsl/workspace/plhamK/cassia/util/random/Gaussian.x10"
            final double t$33402 = ((((t$33401))));
            
            //#line 62 "/home/dsl/workspace/plhamK/cassia/util/random/Gaussian.x10"
            final boolean t$33403 = ((t$33402) <= (((n))));
            
            //#line 62 "/home/dsl/workspace/plhamK/cassia/util/random/Gaussian.x10"
            if (!(t$33403)) {
                
                //#line 62 "/home/dsl/workspace/plhamK/cassia/util/random/Gaussian.x10"
                break;
            }
            
            //#line 63 "/home/dsl/workspace/plhamK/cassia/util/random/Gaussian.x10"
            final long t$33389 = i$33400;
            
            //#line 63 "/home/dsl/workspace/plhamK/cassia/util/random/Gaussian.x10"
            final double t$33390 = ((((t$33389))));
            
            //#line 63 "/home/dsl/workspace/plhamK/cassia/util/random/Gaussian.x10"
            final double t$33391 = ((t$33390) * (((delta))));
            
            //#line 63 "/home/dsl/workspace/plhamK/cassia/util/random/Gaussian.x10"
            final double v$33392 = ((a) + (((t$33391))));
            
            //#line 64 "/home/dsl/workspace/plhamK/cassia/util/random/Gaussian.x10"
            final double t$33393 = out;
            
            //#line 64 "/home/dsl/workspace/plhamK/cassia/util/random/Gaussian.x10"
            final double t$33394 = cassia.util.random.Gaussian.gaussDenseValue$O((v$33392), (mu), (sigma));
            
            //#line 64 "/home/dsl/workspace/plhamK/cassia/util/random/Gaussian.x10"
            final double t$33395 = ((v$33392) * (((t$33394))));
            
            //#line 64 "/home/dsl/workspace/plhamK/cassia/util/random/Gaussian.x10"
            final double t$33396 = ((t$33395) * (((delta))));
            
            //#line 64 "/home/dsl/workspace/plhamK/cassia/util/random/Gaussian.x10"
            final double t$33397 = ((t$33393) + (((t$33396))));
            
            //#line 64 "/home/dsl/workspace/plhamK/cassia/util/random/Gaussian.x10"
            out = t$33397;
            
            //#line 62 "/home/dsl/workspace/plhamK/cassia/util/random/Gaussian.x10"
            final long t$33398 = i$33400;
            
            //#line 62 "/home/dsl/workspace/plhamK/cassia/util/random/Gaussian.x10"
            final long t$33399 = ((t$33398) + (((1L))));
            
            //#line 62 "/home/dsl/workspace/plhamK/cassia/util/random/Gaussian.x10"
            i$33400 = t$33399;
        }
        
        //#line 66 "/home/dsl/workspace/plhamK/cassia/util/random/Gaussian.x10"
        final double t$33333 = out;
        
        //#line 66 "/home/dsl/workspace/plhamK/cassia/util/random/Gaussian.x10"
        return t$33333;
    }
    
    
    //#line 70 "/home/dsl/workspace/plhamK/cassia/util/random/Gaussian.x10"
    public static double confidence$O(final double confInterval) {
        
        //#line 71 "/home/dsl/workspace/plhamK/cassia/util/random/Gaussian.x10"
        double value = 0.5;
        
        //#line 72 "/home/dsl/workspace/plhamK/cassia/util/random/Gaussian.x10"
        final double delta = x10.lang.Math.pow$O((10L), (-5L));
        
        //#line 73 "/home/dsl/workspace/plhamK/cassia/util/random/Gaussian.x10"
        long i = 0L;
        
        //#line 74 "/home/dsl/workspace/plhamK/cassia/util/random/Gaussian.x10"
        double x = 0.0;
        
        //#line 75 "/home/dsl/workspace/plhamK/cassia/util/random/Gaussian.x10"
        boolean t$33414 = false;
        
        //#line 75 "/home/dsl/workspace/plhamK/cassia/util/random/Gaussian.x10"
        do  {
            
            //#line 76 "/home/dsl/workspace/plhamK/cassia/util/random/Gaussian.x10"
            final long t$33404 = i;
            
            //#line 76 "/home/dsl/workspace/plhamK/cassia/util/random/Gaussian.x10"
            final double t$33405 = ((((t$33404))));
            
            //#line 76 "/home/dsl/workspace/plhamK/cassia/util/random/Gaussian.x10"
            final double t$33406 = ((t$33405) * (((delta))));
            
            //#line 76 "/home/dsl/workspace/plhamK/cassia/util/random/Gaussian.x10"
            x = t$33406;
            
            //#line 77 "/home/dsl/workspace/plhamK/cassia/util/random/Gaussian.x10"
            final double t$33407 = value;
            
            //#line 77 "/home/dsl/workspace/plhamK/cassia/util/random/Gaussian.x10"
            final double t$33408 = x;
            
            //#line 77 "/home/dsl/workspace/plhamK/cassia/util/random/Gaussian.x10"
            final double t$33409 = cassia.util.random.Gaussian.gaussDenseValue$O((t$33408), (0.0), (1.0));
            
            //#line 77 "/home/dsl/workspace/plhamK/cassia/util/random/Gaussian.x10"
            final double t$33410 = ((t$33409) * (((delta))));
            
            //#line 77 "/home/dsl/workspace/plhamK/cassia/util/random/Gaussian.x10"
            final double t$33411 = ((t$33407) + (((t$33410))));
            
            //#line 77 "/home/dsl/workspace/plhamK/cassia/util/random/Gaussian.x10"
            value = t$33411;
            
            //#line 78 "/home/dsl/workspace/plhamK/cassia/util/random/Gaussian.x10"
            final long t$33412 = i;
            
            //#line 78 "/home/dsl/workspace/plhamK/cassia/util/random/Gaussian.x10"
            final long t$33413 = ((t$33412) + (((1L))));
            
            //#line 78 "/home/dsl/workspace/plhamK/cassia/util/random/Gaussian.x10"
            i = t$33413;
            
            //#line 79 "/home/dsl/workspace/plhamK/cassia/util/random/Gaussian.x10"
            final double t$33415 = value;
            
            //#line 79 "/home/dsl/workspace/plhamK/cassia/util/random/Gaussian.x10"
            final boolean t$33416 = ((t$33415) <= (((confInterval))));
            
            //#line 75 "/home/dsl/workspace/plhamK/cassia/util/random/Gaussian.x10"
            t$33414 = t$33416;
        }while(t$33414); 
        
        //#line 80 "/home/dsl/workspace/plhamK/cassia/util/random/Gaussian.x10"
        final double t$33347 = x;
        
        //#line 80 "/home/dsl/workspace/plhamK/cassia/util/random/Gaussian.x10"
        return t$33347;
    }
    
    
    //#line 83 "/home/dsl/workspace/plhamK/cassia/util/random/Gaussian.x10"
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
            Gaussian.main(args);
        }
    }
    
    // the original app-main method
    public static void main(final x10.core.Rail<java.lang.String> id$4166) {
        
        //#line 84 "/home/dsl/workspace/plhamK/cassia/util/random/Gaussian.x10"
        final double std = 0.01;
        
        //#line 85 "/home/dsl/workspace/plhamK/cassia/util/random/Gaussian.x10"
        final x10.util.Random t$33348 = ((new x10.util.Random((java.lang.System[]) null).x10$util$Random$$init$S()));
        
        //#line 85 "/home/dsl/workspace/plhamK/cassia/util/random/Gaussian.x10"
        final cassia.util.random.Gaussian g = ((new cassia.util.random.Gaussian((java.lang.System[]) null).cassia$util$random$Gaussian$$init$S(((t$33348)))));
        
        //#line 86 "/home/dsl/workspace/plhamK/cassia/util/random/Gaussian.x10"
        final long i$33234min$33426 = 1L;
        
        //#line 86 "/home/dsl/workspace/plhamK/cassia/util/random/Gaussian.x10"
        final long i$33234max$33427 = 1000L;
        
        //#line 86 "/home/dsl/workspace/plhamK/cassia/util/random/Gaussian.x10"
        long i$33423 = i$33234min$33426;
        
        //#line 86 "/home/dsl/workspace/plhamK/cassia/util/random/Gaussian.x10"
        for (;
             true;
             ) {
            
            //#line 86 "/home/dsl/workspace/plhamK/cassia/util/random/Gaussian.x10"
            final long t$33424 = i$33423;
            
            //#line 86 "/home/dsl/workspace/plhamK/cassia/util/random/Gaussian.x10"
            final boolean t$33425 = ((t$33424) <= (((i$33234max$33427))));
            
            //#line 86 "/home/dsl/workspace/plhamK/cassia/util/random/Gaussian.x10"
            if (!(t$33425)) {
                
                //#line 86 "/home/dsl/workspace/plhamK/cassia/util/random/Gaussian.x10"
                break;
            }
            
            //#line 86 "/home/dsl/workspace/plhamK/cassia/util/random/Gaussian.x10"
            final long t$33420 = i$33423;
            
            //#line 87 "/home/dsl/workspace/plhamK/cassia/util/random/Gaussian.x10"
            final x10.io.Printer t$33417 = ((x10.io.Console.get$OUT()));
            
            //#line 87 "/home/dsl/workspace/plhamK/cassia/util/random/Gaussian.x10"
            final double t$33418 = g.nextGaussian$O();
            
            //#line 87 "/home/dsl/workspace/plhamK/cassia/util/random/Gaussian.x10"
            final double t$33419 = ((t$33418) * (((std))));
            
            //#line 87 "/home/dsl/workspace/plhamK/cassia/util/random/Gaussian.x10"
            t$33417.println(x10.core.Double.$box(t$33419));
            
            //#line 86 "/home/dsl/workspace/plhamK/cassia/util/random/Gaussian.x10"
            final long t$33421 = i$33423;
            
            //#line 86 "/home/dsl/workspace/plhamK/cassia/util/random/Gaussian.x10"
            final long t$33422 = ((t$33421) + (((1L))));
            
            //#line 86 "/home/dsl/workspace/plhamK/cassia/util/random/Gaussian.x10"
            i$33423 = t$33422;
        }
    }
    
    
    //#line 5 "/home/dsl/workspace/plhamK/cassia/util/random/Gaussian.x10"
    final public cassia.util.random.Gaussian cassia$util$random$Gaussian$$this$cassia$util$random$Gaussian() {
        
        //#line 5 "/home/dsl/workspace/plhamK/cassia/util/random/Gaussian.x10"
        return cassia.util.random.Gaussian.this;
    }
    
    
    //#line 5 "/home/dsl/workspace/plhamK/cassia/util/random/Gaussian.x10"
    final public void __fieldInitializers_cassia_util_random_Gaussian() {
        
        //#line 5 "/home/dsl/workspace/plhamK/cassia/util/random/Gaussian.x10"
        this.state = false;
        
        //#line 5 "/home/dsl/workspace/plhamK/cassia/util/random/Gaussian.x10"
        this.g = 0.0;
        
        //#line 5 "/home/dsl/workspace/plhamK/cassia/util/random/Gaussian.x10"
        this.random = null;
    }
}

