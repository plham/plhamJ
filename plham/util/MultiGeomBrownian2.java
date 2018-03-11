package plham.util;



public class MultiGeomBrownian2 extends x10.core.Ref implements x10.serialization.X10JavaSerializable
{
    public static final x10.rtt.RuntimeType<MultiGeomBrownian2> $RTT = 
        x10.rtt.NamedType.<MultiGeomBrownian2> make("plham.util.MultiGeomBrownian2",
                                                    MultiGeomBrownian2.class);
    
    public x10.rtt.RuntimeType<?> $getRTT() { return $RTT; }
    
    public x10.rtt.Type<?> $getParam(int i) { return null; }
    
    private Object writeReplace() throws java.io.ObjectStreamException {
        return new x10.serialization.SerializationProxy(this);
    }
    
    public static x10.serialization.X10JavaSerializable $_deserialize_body(plham.util.MultiGeomBrownian2 $_obj, x10.serialization.X10JavaDeserializer $deserializer) throws java.io.IOException {
        if (x10.runtime.impl.java.Runtime.TRACE_SER) { x10.runtime.impl.java.Runtime.printTraceMessage("X10JavaSerializable: $_deserialize_body() of " + MultiGeomBrownian2.class + " calling"); } 
        $_obj.c = $deserializer.readObject();
        $_obj.chol = $deserializer.readObject();
        $_obj.cor = $deserializer.readObject();
        $_obj.dim = $deserializer.readLong();
        $_obj.dt = $deserializer.readDouble();
        $_obj.g = $deserializer.readObject();
        $_obj.gaussian = $deserializer.readObject();
        $_obj.initialCheck = $deserializer.readBoolean();
        $_obj.logType = $deserializer.readBoolean();
        $_obj.mu = $deserializer.readObject();
        $_obj.random = $deserializer.readObject();
        $_obj.s0 = $deserializer.readObject();
        $_obj.sigma = $deserializer.readObject();
        $_obj.state = $deserializer.readObject();
        return $_obj;
    }
    
    public static x10.serialization.X10JavaSerializable $_deserializer(x10.serialization.X10JavaDeserializer $deserializer) throws java.io.IOException {
        plham.util.MultiGeomBrownian2 $_obj = new plham.util.MultiGeomBrownian2((java.lang.System[]) null);
        $deserializer.record_reference($_obj);
        return $_deserialize_body($_obj, $deserializer);
    }
    
    public void $_serialize(x10.serialization.X10JavaSerializer $serializer) throws java.io.IOException {
        $serializer.write(this.c);
        $serializer.write(this.chol);
        $serializer.write(this.cor);
        $serializer.write(this.dim);
        $serializer.write(this.dt);
        $serializer.write(this.g);
        $serializer.write(this.gaussian);
        $serializer.write(this.initialCheck);
        $serializer.write(this.logType);
        $serializer.write(this.mu);
        $serializer.write(this.random);
        $serializer.write(this.s0);
        $serializer.write(this.sigma);
        $serializer.write(this.state);
        
    }
    
    // constructor just for allocation
    public MultiGeomBrownian2(final java.lang.System[] $dummy) {
        
    }
    
    // synthetic type for parameter mangling
    public static final class __1$1x10$lang$Double$2__2$1x10$lang$Double$2__3$1x10$lang$Double$2__4$1x10$lang$Rail$1x10$lang$Double$2$2 {}
    

    
    //#line 7 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
    public x10.util.Random random;
    
    //#line 8 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
    public cassia.util.random.Gaussian gaussian;
    
    //#line 16 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
    /**
	 * Given a lower-triangular cholesky decomposition matrix, U_{NxN},
	 * and a vector of independent Gaussians, X_{N} = (x_0,...,x_N),
	 * a correlated geometric Brownian vector is given by
	 *     \u0394S = X U  (dot)
	 * where S_{N} is a state vector of the N-dimensional geometric Brownian.
	 */
    public x10.core.Rail<x10.core.Double> s0;
    
    //#line 17 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
    public x10.core.Rail<x10.core.Double> mu;
    
    //#line 18 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
    public x10.core.Rail<x10.core.Double> sigma;
    
    //#line 19 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
    public x10.core.Rail<x10.core.Rail<x10.core.Double>> cor;
    
    //#line 20 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
    public double dt;
    
    //#line 21 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
    public long dim;
    
    //#line 22 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
    public x10.core.Rail<x10.core.Rail<x10.core.Double>> chol;
    
    //#line 23 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
    public x10.core.Rail<x10.core.Double> state;
    
    //#line 24 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
    public boolean logType;
    
    //#line 25 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
    public x10.core.Rail<x10.core.Double> g;
    
    //#line 26 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
    public x10.core.Rail<x10.core.Double> c;
    
    //#line 27 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
    public boolean initialCheck;
    
    
    //#line 28 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
    // creation method for java code (1-phase java constructor)
    public MultiGeomBrownian2(final x10.util.Random random, final x10.core.Rail<x10.core.Double> s0, final x10.core.Rail<x10.core.Double> mu, final x10.core.Rail<x10.core.Double> sigma, final x10.core.Rail<x10.core.Rail<x10.core.Double>> cor, final double dt, final boolean logType, __1$1x10$lang$Double$2__2$1x10$lang$Double$2__3$1x10$lang$Double$2__4$1x10$lang$Rail$1x10$lang$Double$2$2 $dummy) {
        this((java.lang.System[]) null);
        plham$util$MultiGeomBrownian2$$init$S(random, s0, mu, sigma, cor, dt, logType, (plham.util.MultiGeomBrownian2.__1$1x10$lang$Double$2__2$1x10$lang$Double$2__3$1x10$lang$Double$2__4$1x10$lang$Rail$1x10$lang$Double$2$2) null);
    }
    
    // constructor for non-virtual call
    final public plham.util.MultiGeomBrownian2 plham$util$MultiGeomBrownian2$$init$S(final x10.util.Random random, final x10.core.Rail<x10.core.Double> s0, final x10.core.Rail<x10.core.Double> mu, final x10.core.Rail<x10.core.Double> sigma, final x10.core.Rail<x10.core.Rail<x10.core.Double>> cor, final double dt, final boolean logType, __1$1x10$lang$Double$2__2$1x10$lang$Double$2__3$1x10$lang$Double$2__4$1x10$lang$Rail$1x10$lang$Double$2$2 $dummy) {
         {
            
            //#line 28 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
            
            
            //#line 5 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
            this.__fieldInitializers_plham_util_MultiGeomBrownian2();
            
            //#line 29 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
            this.random = ((random));
            
            //#line 30 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
            final cassia.util.random.Gaussian t$70743 = ((new cassia.util.random.Gaussian((java.lang.System[]) null).cassia$util$random$Gaussian$$init$S(((random)))));
            
            //#line 30 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
            this.gaussian = ((t$70743));
            
            //#line 31 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
            this.s0 = ((s0));
            
            //#line 32 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
            this.mu = ((mu));
            
            //#line 33 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
            this.sigma = ((sigma));
            
            //#line 34 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
            this.cor = ((cor));
            
            //#line 35 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
            final x10.core.Rail t$70744 = plham.util.Cholesky.decompose__0$1x10$lang$Rail$1x10$lang$Double$2$2(((cor)));
            
            //#line 35 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
            this.chol = ((t$70744));
            
            //#line 36 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
            this.dt = dt;
            
            //#line 37 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
            final long t$70745 = mu.size;
            
            //#line 37 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
            this.dim = t$70745;
            
            //#line 38 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
            final long t$70746 = this.dim;
            
            //#line 38 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
            final x10.core.Rail t$70747 = ((new x10.core.Rail<x10.core.Double>(x10.rtt.Types.DOUBLE, t$70746)));
            
            //#line 38 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
            this.state = ((t$70747));
            
            //#line 39 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
            this.initialCheck = true;
            
            //#line 40 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
            final long t$70748 = this.dim;
            
            //#line 40 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
            final x10.core.Rail t$70749 = ((new x10.core.Rail<x10.core.Double>(x10.rtt.Types.DOUBLE, t$70748)));
            
            //#line 40 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
            this.g = ((t$70749));
            
            //#line 41 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
            final long t$70750 = this.dim;
            
            //#line 41 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
            final x10.core.Rail t$70751 = ((new x10.core.Rail<x10.core.Double>(x10.rtt.Types.DOUBLE, t$70750)));
            
            //#line 41 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
            this.c = ((t$70751));
            
            //#line 42 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
            this.logType = logType;
            
            //#line 43 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
            final long dim = this.dim;
            
            //#line 44 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
            assert (dim) == (s0.size);
            
            //#line 45 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
            assert (dim) == (mu.size);
            
            //#line 46 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
            assert (dim) == (sigma.size);
            
            //#line 47 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
            assert (dim) == (this.chol.size);
            
            //#line 48 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
            final long i$70521min$70951 = 0L;
            
            //#line 48 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
            final long i$70521max$70952 = ((dim) - (((1L))));
            
            //#line 48 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
            long i$70948 = i$70521min$70951;
            
            //#line 48 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
            for (;
                 true;
                 ) {
                
                //#line 48 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
                final long t$70949 = i$70948;
                
                //#line 48 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
                final boolean t$70950 = ((t$70949) <= (((i$70521max$70952))));
                
                //#line 48 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
                if (!(t$70950)) {
                    
                    //#line 48 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
                    break;
                }
                
                //#line 48 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
                final long i$70945 = i$70948;
                
                //#line 49 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
                final long i$70503min$70943 = 0L;
                
                //#line 49 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
                final long i$70503max$70944 = ((i$70945) - (((1L))));
                
                //#line 49 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
                long i$70940 = i$70503min$70943;
                
                //#line 49 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
                for (;
                     true;
                     ) {
                    
                    //#line 49 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
                    final long t$70941 = i$70940;
                    
                    //#line 49 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
                    final boolean t$70942 = ((t$70941) <= (((i$70503max$70944))));
                    
                    //#line 49 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
                    if (!(t$70942)) {
                        
                        //#line 49 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
                        break;
                    }
                    
                    //#line 49 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
                    final long j$70937 = i$70940;
                    
                    //#line 50 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
                    assert (((double[])((x10.core.Rail[])this.chol.value)[(int)j$70937].value)[(int)i$70945]) == (0.0);
                    
                    //#line 49 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
                    final long t$70938 = i$70940;
                    
                    //#line 49 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
                    final long t$70939 = ((t$70938) + (((1L))));
                    
                    //#line 49 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
                    i$70940 = t$70939;
                }
                
                //#line 48 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
                final long t$70946 = i$70948;
                
                //#line 48 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
                final long t$70947 = ((t$70946) + (((1L))));
                
                //#line 48 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
                i$70948 = t$70947;
            }
        }
        return this;
    }
    
    
    
    //#line 56 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
    // creation method for java code (1-phase java constructor)
    public MultiGeomBrownian2(final x10.util.Random random, final long dim, final boolean logType) {
        this((java.lang.System[]) null);
        plham$util$MultiGeomBrownian2$$init$S(random, dim, logType);
    }
    
    // constructor for non-virtual call
    final public plham.util.MultiGeomBrownian2 plham$util$MultiGeomBrownian2$$init$S(final x10.util.Random random, final long dim, final boolean logType) {
         {
            
            //#line 56 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
            
            
            //#line 5 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
            this.__fieldInitializers_plham_util_MultiGeomBrownian2();
            
            //#line 57 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
            this.random = ((random));
            
            //#line 58 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
            final cassia.util.random.Gaussian t$70762 = ((new cassia.util.random.Gaussian((java.lang.System[]) null).cassia$util$random$Gaussian$$init$S(((random)))));
            
            //#line 58 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
            this.gaussian = ((t$70762));
            
            //#line 59 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
            final x10.core.Rail t$70763 = ((new x10.core.Rail<x10.core.Double>(x10.rtt.Types.DOUBLE, ((dim)))));
            
            //#line 59 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
            this.mu = ((t$70763));
            
            //#line 60 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
            final x10.core.Rail t$70764 = ((new x10.core.Rail<x10.core.Double>(x10.rtt.Types.DOUBLE, ((dim)))));
            
            //#line 60 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
            this.sigma = ((t$70764));
            
            //#line 61 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
            final x10.core.fun.Fun_0_1 t$70766 = ((new plham.util.MultiGeomBrownian2.$Closure$33(dim)));
            
            //#line 61 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
            final x10.core.Rail t$70767 = ((new x10.core.Rail<x10.core.Rail<x10.core.Double>>(x10.rtt.ParameterizedType.make(x10.core.Rail.$RTT, x10.rtt.Types.DOUBLE), ((dim)), ((t$70766)), (x10.core.Rail.__1$1x10$lang$Long$3x10$lang$Rail$$T$2) null)));
            
            //#line 61 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
            this.cor = ((t$70767));
            
            //#line 62 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
            this.chol = null;
            
            //#line 63 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
            final x10.core.Rail t$70768 = ((new x10.core.Rail<x10.core.Double>(x10.rtt.Types.DOUBLE, ((dim)))));
            
            //#line 63 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
            this.s0 = ((t$70768));
            
            //#line 64 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
            this.dt = 1.0;
            
            //#line 65 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
            this.dim = dim;
            
            //#line 66 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
            final x10.core.Rail t$70769 = ((new x10.core.Rail<x10.core.Double>(x10.rtt.Types.DOUBLE, ((dim)))));
            
            //#line 66 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
            this.state = ((t$70769));
            
            //#line 67 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
            this.initialCheck = true;
            
            //#line 68 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
            final x10.core.Rail t$70770 = ((new x10.core.Rail<x10.core.Double>(x10.rtt.Types.DOUBLE, ((dim)))));
            
            //#line 68 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
            this.g = ((t$70770));
            
            //#line 69 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
            final x10.core.Rail t$70771 = ((new x10.core.Rail<x10.core.Double>(x10.rtt.Types.DOUBLE, ((dim)))));
            
            //#line 69 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
            this.c = ((t$70771));
            
            //#line 70 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
            this.logType = logType;
        }
        return this;
    }
    
    
    
    //#line 74 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
    public x10.core.Rail nextBrownian() {
        
        //#line 75 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
        x10.core.Rail out = new x10.core.Rail<x10.core.Double>(x10.rtt.Types.DOUBLE);
        
        //#line 76 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
        final boolean t$70774 = this.logType;
        
        //#line 76 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
        if (t$70774) {
            
            //#line 78 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
            final x10.core.Rail t$70772 = this.nextBrownian2();
            
            //#line 78 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
            out = ((t$70772));
        } else {
            
            //#line 81 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
            final x10.core.Rail t$70773 = this.nextBrownian3();
            
            //#line 81 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
            out = ((t$70773));
        }
        
        //#line 83 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
        final x10.core.Rail t$70775 = ((out));
        
        //#line 83 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
        return t$70775;
    }
    
    
    //#line 86 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
    public x10.core.Rail nextBrownian2() {
        
        //#line 87 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
        final x10.core.Rail t$70776 = ((this.chol));
        
        //#line 87 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
        final boolean t$70779 = ((t$70776) == (null));
        
        //#line 87 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
        if (t$70779) {
            
            //#line 88 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
            final x10.core.Rail t$70777 = ((this.cor));
            
            //#line 88 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
            final x10.core.Rail t$70778 = plham.util.Cholesky.decompose__0$1x10$lang$Rail$1x10$lang$Double$2$2(((t$70777)));
            
            //#line 88 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
            this.chol = ((t$70778));
        }
        
        //#line 90 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
        final long dim = this.dim;
        
        //#line 91 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
        final long i$70539min$71024 = 0L;
        
        //#line 91 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
        final long i$70539max$71025 = ((dim) - (((1L))));
        
        //#line 91 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
        long i$70959 = i$70539min$71024;
        
        //#line 91 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
        for (;
             true;
             ) {
            
            //#line 91 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
            final long t$70960 = i$70959;
            
            //#line 91 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
            final boolean t$70961 = ((t$70960) <= (((i$70539max$71025))));
            
            //#line 91 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
            if (!(t$70961)) {
                
                //#line 91 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
                break;
            }
            
            //#line 91 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
            final long i$70956 = i$70959;
            
            //#line 92 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
            final x10.core.Rail t$70953 = ((this.g));
            
            //#line 92 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
            final cassia.util.random.Gaussian t$70954 = ((this.gaussian));
            
            //#line 92 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
            final double t$70955 = t$70954.nextGaussian$O();
            
            //#line 92 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
            ((double[])t$70953.value)[(int)i$70956] = t$70955;
            
            //#line 91 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
            final long t$70957 = i$70959;
            
            //#line 91 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
            final long t$70958 = ((t$70957) + (((1L))));
            
            //#line 91 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
            i$70959 = t$70958;
        }
        
        //#line 94 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
        final long i$70575min$71026 = 0L;
        
        //#line 94 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
        final long i$70575max$71027 = ((dim) - (((1L))));
        
        //#line 94 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
        long i$70984 = i$70575min$71026;
        
        //#line 94 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
        for (;
             true;
             ) {
            
            //#line 94 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
            final long t$70985 = i$70984;
            
            //#line 94 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
            final boolean t$70986 = ((t$70985) <= (((i$70575max$71027))));
            
            //#line 94 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
            if (!(t$70986)) {
                
                //#line 94 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
                break;
            }
            
            //#line 94 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
            final long i$70981 = i$70984;
            
            //#line 95 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
            final x10.core.Rail t$70980 = ((this.c));
            
            //#line 95 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
            ((double[])t$70980.value)[(int)i$70981] = 0.0;
            
            //#line 96 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
            final long i$70557min$70978 = 0L;
            
            //#line 96 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
            final long i$70557max$70979 = i$70981;
            
            //#line 96 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
            long i$70975 = i$70557min$70978;
            
            //#line 96 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
            for (;
                 true;
                 ) {
                
                //#line 96 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
                final long t$70976 = i$70975;
                
                //#line 96 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
                final boolean t$70977 = ((t$70976) <= (((i$70557max$70979))));
                
                //#line 96 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
                if (!(t$70977)) {
                    
                    //#line 96 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
                    break;
                }
                
                //#line 96 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
                final long j$70972 = i$70975;
                
                //#line 97 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
                final x10.core.Rail a$70962 = ((this.c));
                
                //#line 97 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
                final long i$70963 = i$70981;
                
                //#line 97 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
                final double t$70964 = ((double[])a$70962.value)[(int)i$70963];
                
                //#line 97 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
                final x10.core.Rail t$70965 = ((this.g));
                
                //#line 97 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
                final double t$70966 = ((double[])t$70965.value)[(int)j$70972];
                
                //#line 97 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
                final x10.core.Rail t$70967 = ((this.chol));
                
                //#line 97 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
                final x10.core.Rail t$70968 = ((x10.core.Rail[])t$70967.value)[(int)i$70981];
                
                //#line 97 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
                final double t$70969 = ((double[])t$70968.value)[(int)j$70972];
                
                //#line 97 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
                final double t$70970 = ((t$70966) * (((t$70969))));
                
                //#line 97 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
                final double r$70971 = ((t$70964) + (((t$70970))));
                
                //#line 97 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
                ((double[])a$70962.value)[(int)i$70963] = r$70971;
                
                //#line 96 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
                final long t$70973 = i$70975;
                
                //#line 96 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
                final long t$70974 = ((t$70973) + (((1L))));
                
                //#line 96 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
                i$70975 = t$70974;
            }
            
            //#line 94 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
            final long t$70982 = i$70984;
            
            //#line 94 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
            final long t$70983 = ((t$70982) + (((1L))));
            
            //#line 94 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
            i$70984 = t$70983;
        }
        
        //#line 100 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
        final long i$70593min$71028 = 0L;
        
        //#line 100 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
        final long i$70593max$71029 = ((dim) - (((1L))));
        
        //#line 100 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
        long i$71021 = i$70593min$71028;
        
        //#line 100 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
        for (;
             true;
             ) {
            
            //#line 100 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
            final long t$71022 = i$71021;
            
            //#line 100 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
            final boolean t$71023 = ((t$71022) <= (((i$70593max$71029))));
            
            //#line 100 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
            if (!(t$71023)) {
                
                //#line 100 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
                break;
            }
            
            //#line 100 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
            final long i$71018 = i$71021;
            
            //#line 102 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
            final x10.core.Rail a$70987 = ((this.state));
            
            //#line 102 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
            final long i$70988 = i$71018;
            
            //#line 102 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
            final double t$70989 = ((double[])a$70987.value)[(int)i$70988];
            
            //#line 102 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
            final x10.core.Rail t$70990 = ((this.mu));
            
            //#line 102 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
            final double t$70991 = ((double[])t$70990.value)[(int)i$71018];
            
            //#line 102 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
            final x10.core.Rail t$70992 = ((this.sigma));
            
            //#line 102 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
            final double t$70993 = ((double[])t$70992.value)[(int)i$71018];
            
            //#line 102 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
            final x10.core.Rail t$70994 = ((this.sigma));
            
            //#line 102 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
            final double t$70995 = ((double[])t$70994.value)[(int)i$71018];
            
            //#line 102 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
            final double t$70996 = ((t$70993) * (((t$70995))));
            
            //#line 102 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
            final double t$70997 = ((t$70996) * (((0.5))));
            
            //#line 102 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
            final double t$70998 = ((t$70991) - (((t$70997))));
            
            //#line 102 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
            final double t$70999 = this.dt;
            
            //#line 102 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
            final double t$71000 = ((t$70998) * (((t$70999))));
            
            //#line 102 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
            final x10.core.Rail t$71001 = ((this.sigma));
            
            //#line 102 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
            final double t$71002 = ((double[])t$71001.value)[(int)i$71018];
            
            //#line 102 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
            final x10.core.Rail t$71003 = ((this.c));
            
            //#line 102 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
            final double t$71004 = ((double[])t$71003.value)[(int)i$71018];
            
            //#line 102 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
            final double t$71005 = ((t$71002) * (((t$71004))));
            
            //#line 102 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
            final double t$71006 = this.dt;
            
            //#line 102 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
            final double t$71007 = java.lang.Math.sqrt(((t$71006)));
            
            //#line 102 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
            final double t$71008 = ((t$71005) * (((t$71007))));
            
            //#line 102 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
            final double t$71009 = ((t$71000) + (((t$71008))));
            
            //#line 102 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
            final double r$71010 = ((t$70989) + (((t$71009))));
            
            //#line 102 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
            ((double[])a$70987.value)[(int)i$70988] = r$71010;
            
            //#line 103 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
            final x10.core.Rail t$71011 = ((this.g));
            
            //#line 103 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
            final x10.core.Rail t$71012 = ((this.s0));
            
            //#line 103 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
            final double t$71013 = ((double[])t$71012.value)[(int)i$71018];
            
            //#line 103 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
            final x10.core.Rail t$71014 = ((this.state));
            
            //#line 103 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
            final double t$71015 = ((double[])t$71014.value)[(int)i$71018];
            
            //#line 103 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
            final double t$71016 = java.lang.Math.exp(((t$71015)));
            
            //#line 103 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
            final double t$71017 = ((t$71013) * (((t$71016))));
            
            //#line 103 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
            ((double[])t$71011.value)[(int)i$71018] = t$71017;
            
            //#line 100 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
            final long t$71019 = i$71021;
            
            //#line 100 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
            final long t$71020 = ((t$71019) + (((1L))));
            
            //#line 100 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
            i$71021 = t$71020;
        }
        
        //#line 105 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
        final x10.core.Rail t$70839 = ((this.g));
        
        //#line 105 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
        return t$70839;
    }
    
    
    //#line 108 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
    public x10.core.Rail nextBrownian3() {
        
        //#line 109 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
        final long dim = this.dim;
        
        //#line 110 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
        final boolean t$70848 = this.initialCheck;
        
        //#line 110 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
        if (t$70848) {
            
            //#line 111 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
            final long i$70611min$71039 = 0L;
            
            //#line 111 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
            final long i$70611max$71040 = ((dim) - (((1L))));
            
            //#line 111 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
            long i$71036 = i$70611min$71039;
            
            //#line 111 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
            for (;
                 true;
                 ) {
                
                //#line 111 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
                final long t$71037 = i$71036;
                
                //#line 111 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
                final boolean t$71038 = ((t$71037) <= (((i$70611max$71040))));
                
                //#line 111 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
                if (!(t$71038)) {
                    
                    //#line 111 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
                    break;
                }
                
                //#line 111 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
                final long i$71033 = i$71036;
                
                //#line 112 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
                final x10.core.Rail t$71030 = ((this.g));
                
                //#line 112 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
                final x10.core.Rail t$71031 = ((this.s0));
                
                //#line 112 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
                final double t$71032 = ((double[])t$71031.value)[(int)i$71033];
                
                //#line 112 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
                ((double[])t$71030.value)[(int)i$71033] = t$71032;
                
                //#line 111 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
                final long t$71034 = i$71036;
                
                //#line 111 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
                final long t$71035 = ((t$71034) + (((1L))));
                
                //#line 111 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
                i$71036 = t$71035;
            }
            
            //#line 114 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
            this.initialCheck = false;
        }
        
        //#line 117 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
        final x10.core.Rail t$70849 = ((this.chol));
        
        //#line 117 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
        final boolean t$70852 = ((t$70849) == (null));
        
        //#line 117 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
        if (t$70852) {
            
            //#line 118 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
            final x10.core.Rail t$70850 = ((this.cor));
            
            //#line 118 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
            final x10.core.Rail t$70851 = plham.util.Cholesky.decompose__0$1x10$lang$Rail$1x10$lang$Double$2$2(((t$70850)));
            
            //#line 118 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
            this.chol = ((t$70851));
        }
        
        //#line 121 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
        final x10.core.Rail hoge = ((new x10.core.Rail<x10.core.Double>(x10.rtt.Types.DOUBLE, ((dim)))));
        
        //#line 122 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
        final long i$70629min$71108 = 0L;
        
        //#line 122 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
        final long i$70629max$71109 = ((dim) - (((1L))));
        
        //#line 122 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
        long i$71046 = i$70629min$71108;
        {
            
            //#line 122 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
            final double[] hoge$value$71135 = ((double[])hoge.value);
            
            //#line 122 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
            for (;
                 true;
                 ) {
                
                //#line 122 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
                final long t$71047 = i$71046;
                
                //#line 122 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
                final boolean t$71048 = ((t$71047) <= (((i$70629max$71109))));
                
                //#line 122 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
                if (!(t$71048)) {
                    
                    //#line 122 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
                    break;
                }
                
                //#line 122 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
                final long i$71043 = i$71046;
                
                //#line 123 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
                final cassia.util.random.Gaussian t$71041 = ((this.gaussian));
                
                //#line 123 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
                final double t$71042 = t$71041.nextGaussian$O();
                
                //#line 123 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
                hoge$value$71135[(int)i$71043]=t$71042;
                
                //#line 122 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
                final long t$71044 = i$71046;
                
                //#line 122 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
                final long t$71045 = ((t$71044) + (((1L))));
                
                //#line 122 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
                i$71046 = t$71045;
            }
        }
        
        //#line 125 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
        final long i$70665min$71110 = 0L;
        
        //#line 125 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
        final long i$70665max$71111 = ((dim) - (((1L))));
        
        //#line 125 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
        long i$71070 = i$70665min$71110;
        {
            
            //#line 125 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
            final double[] hoge$value$71136 = ((double[])hoge.value);
            
            //#line 125 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
            for (;
                 true;
                 ) {
                
                //#line 125 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
                final long t$71071 = i$71070;
                
                //#line 125 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
                final boolean t$71072 = ((t$71071) <= (((i$70665max$71111))));
                
                //#line 125 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
                if (!(t$71072)) {
                    
                    //#line 125 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
                    break;
                }
                
                //#line 125 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
                final long i$71067 = i$71070;
                
                //#line 126 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
                final x10.core.Rail t$71066 = ((this.c));
                
                //#line 126 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
                ((double[])t$71066.value)[(int)i$71067] = 0.0;
                
                //#line 127 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
                final long i$70647min$71064 = 0L;
                
                //#line 127 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
                final long i$70647max$71065 = i$71067;
                
                //#line 127 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
                long i$71061 = i$70647min$71064;
                {
                    
                    //#line 127 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
                    for (;
                         true;
                         ) {
                        
                        //#line 127 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
                        final long t$71062 = i$71061;
                        
                        //#line 127 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
                        final boolean t$71063 = ((t$71062) <= (((i$70647max$71065))));
                        
                        //#line 127 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
                        if (!(t$71063)) {
                            
                            //#line 127 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
                            break;
                        }
                        
                        //#line 127 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
                        final long j$71058 = i$71061;
                        
                        //#line 128 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
                        final x10.core.Rail a$71049 = ((this.c));
                        
                        //#line 128 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
                        final long i$71050 = i$71067;
                        
                        //#line 128 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
                        final double t$71051 = ((double[])a$71049.value)[(int)i$71050];
                        
                        //#line 128 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
                        final double t$71052 = (hoge$value$71136[(int)j$71058]);
                        
                        //#line 128 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
                        final x10.core.Rail t$71053 = ((this.chol));
                        
                        //#line 128 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
                        final x10.core.Rail t$71054 = ((x10.core.Rail[])t$71053.value)[(int)i$71067];
                        
                        //#line 128 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
                        final double t$71055 = ((double[])t$71054.value)[(int)j$71058];
                        
                        //#line 128 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
                        final double t$71056 = ((t$71052) * (((t$71055))));
                        
                        //#line 128 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
                        final double r$71057 = ((t$71051) + (((t$71056))));
                        
                        //#line 128 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
                        ((double[])a$71049.value)[(int)i$71050] = r$71057;
                        
                        //#line 127 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
                        final long t$71059 = i$71061;
                        
                        //#line 127 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
                        final long t$71060 = ((t$71059) + (((1L))));
                        
                        //#line 127 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
                        i$71061 = t$71060;
                    }
                }
                
                //#line 125 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
                final long t$71068 = i$71070;
                
                //#line 125 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
                final long t$71069 = ((t$71068) + (((1L))));
                
                //#line 125 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
                i$71070 = t$71069;
            }
        }
        
        //#line 131 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
        final long i$70683min$71112 = 0L;
        
        //#line 131 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
        final long i$70683max$71113 = ((dim) - (((1L))));
        
        //#line 131 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
        long i$71105 = i$70683min$71112;
        
        //#line 131 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
        for (;
             true;
             ) {
            
            //#line 131 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
            final long t$71106 = i$71105;
            
            //#line 131 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
            final boolean t$71107 = ((t$71106) <= (((i$70683max$71113))));
            
            //#line 131 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
            if (!(t$71107)) {
                
                //#line 131 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
                break;
            }
            
            //#line 131 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
            final long i$71102 = i$71105;
            
            //#line 133 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
            final x10.core.Rail t$71073 = ((x10.core.Rail)(this.state));
            
            //#line 133 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
            final x10.core.Rail t$71074 = ((x10.core.Rail)(this.mu));
            
            //#line 133 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
            final double t$71075 = ((double[])t$71074.value)[(int)i$71102];
            
            //#line 133 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
            final x10.core.Rail t$71076 = ((x10.core.Rail)(this.sigma));
            
            //#line 133 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
            final double t$71077 = ((double[])t$71076.value)[(int)i$71102];
            
            //#line 133 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
            final x10.core.Rail t$71078 = ((x10.core.Rail)(this.sigma));
            
            //#line 133 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
            final double t$71079 = ((double[])t$71078.value)[(int)i$71102];
            
            //#line 133 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
            final double t$71080 = ((t$71077) * (((double)(t$71079))));
            
            //#line 133 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
            final double t$71081 = ((t$71080) * (((double)(0.5))));
            
            //#line 133 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
            final double t$71082 = ((t$71075) - (((double)(t$71081))));
            
            //#line 133 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
            final double t$71083 = this.dt;
            
            //#line 133 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
            final double t$71084 = ((t$71082) * (((double)(t$71083))));
            
            //#line 133 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
            final x10.core.Rail t$71085 = ((x10.core.Rail)(this.sigma));
            
            //#line 133 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
            final double t$71086 = ((double[])t$71085.value)[(int)i$71102];
            
            //#line 133 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
            final x10.core.Rail t$71087 = ((x10.core.Rail)(this.c));
            
            //#line 133 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
            final double t$71088 = ((double[])t$71087.value)[(int)i$71102];
            
            //#line 133 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
            final double t$71089 = ((t$71086) * (((double)(t$71088))));
            
            //#line 133 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
            final double t$71090 = this.dt;
            
            //#line 133 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
            final double t$71091 = java.lang.Math.sqrt(((double)(t$71090)));
            
            //#line 133 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
            final double t$71092 = ((t$71089) * (((double)(t$71091))));
            
            //#line 133 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
            final double t$71093 = ((t$71084) + (((double)(t$71092))));
            
            //#line 133 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
            ((double[])t$71073.value)[(int)i$71102] = t$71093;
            
            //#line 134 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
            final x10.core.Rail t$71094 = ((x10.core.Rail)(this.g));
            
            //#line 134 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
            final x10.core.Rail t$71095 = ((x10.core.Rail)(this.g));
            
            //#line 134 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
            final double t$71096 = ((double[])t$71095.value)[(int)i$71102];
            
            //#line 134 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
            final double t$71097 = ((double)(long)(((long)(1L))));
            
            //#line 134 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
            final x10.core.Rail t$71098 = ((x10.core.Rail)(this.state));
            
            //#line 134 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
            final double t$71099 = ((double[])t$71098.value)[(int)i$71102];
            
            //#line 134 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
            final double t$71100 = ((t$71097) + (((double)(t$71099))));
            
            //#line 134 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
            final double t$71101 = ((t$71096) * (((double)(t$71100))));
            
            //#line 134 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
            ((double[])t$71094.value)[(int)i$71102] = t$71101;
            
            //#line 131 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
            final long t$71103 = i$71105;
            
            //#line 131 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
            final long t$71104 = ((t$71103) + (((long)(1L))));
            
            //#line 131 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
            i$71105 = t$71104;
        }
        
        //#line 136 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
        final x10.core.Rail t$70911 = ((x10.core.Rail)(this.g));
        
        //#line 136 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
        return t$70911;
    }
    
    
    //#line 139 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
    public double get$O(final long i) {
        
        //#line 140 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
        final x10.core.Rail t$70912 = ((x10.core.Rail)(this.g));
        
        //#line 140 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
        final double t$70913 = ((double[])t$70912.value)[(int)i];
        
        //#line 140 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
        return t$70913;
    }
    
    
    //#line 143 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
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
            MultiGeomBrownian2.main(args);
        }
    }
    
    // the original app-main method
    public static void main(final x10.core.Rail<java.lang.String> id$17336) {
        
        //#line 147 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
        final long dim = 3L;
        
        //#line 148 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
        final x10.core.Rail t$70914 = ((x10.core.Rail)(x10.runtime.impl.java.ArrayUtils.<x10.core.Double> makeRailFromJavaArray(x10.rtt.Types.DOUBLE, new double[] {300.0, 200.0, 100.0})));
        
        //#line 148 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
        final x10.core.Rail s0 = ((x10.core.Rail)(new x10.core.Rail<x10.core.Double>(x10.rtt.Types.DOUBLE, ((x10.core.Rail)(t$70914)), (x10.core.Rail.__0$1x10$lang$Rail$$T$2) null)));
        
        //#line 149 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
        final x10.core.Rail t$70915 = ((x10.core.Rail)(x10.runtime.impl.java.ArrayUtils.<x10.core.Double> makeRailFromJavaArray(x10.rtt.Types.DOUBLE, new double[] {1.0, 0.0, 0.0})));
        
        //#line 149 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
        final x10.core.Rail mu = ((x10.core.Rail)(new x10.core.Rail<x10.core.Double>(x10.rtt.Types.DOUBLE, ((x10.core.Rail)(t$70915)), (x10.core.Rail.__0$1x10$lang$Rail$$T$2) null)));
        
        //#line 149 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
        ((double[])mu.value)[(int)0L] = 0.0;
        
        //#line 150 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
        final x10.core.Rail t$70916 = ((x10.core.Rail)(x10.runtime.impl.java.ArrayUtils.<x10.core.Double> makeRailFromJavaArray(x10.rtt.Types.DOUBLE, new double[] {0.001, 0.01, 0.05})));
        
        //#line 150 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
        final x10.core.Rail sigma = ((x10.core.Rail)(new x10.core.Rail<x10.core.Double>(x10.rtt.Types.DOUBLE, ((x10.core.Rail)(t$70916)), (x10.core.Rail.__0$1x10$lang$Rail$$T$2) null)));
        
        //#line 151 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
        final x10.core.Rail cor = ((x10.core.Rail)(new x10.core.Rail<x10.core.Rail<x10.core.Double>>(x10.rtt.ParameterizedType.make(x10.core.Rail.$RTT, x10.rtt.Types.DOUBLE), ((long)(dim)))));
        
        //#line 152 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
        final x10.core.Rail t$70917 = ((x10.core.Rail)(x10.runtime.impl.java.ArrayUtils.<x10.core.Double> makeRailFromJavaArray(x10.rtt.Types.DOUBLE, new double[] {1.0, 0.8, 0.0})));
        
        //#line 152 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
        ((x10.core.Rail[])cor.value)[(int)0L] = t$70917;
        
        //#line 153 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
        final x10.core.Rail t$70918 = ((x10.core.Rail)(x10.runtime.impl.java.ArrayUtils.<x10.core.Double> makeRailFromJavaArray(x10.rtt.Types.DOUBLE, new double[] {0.8, 1.0, 0.0})));
        
        //#line 153 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
        ((x10.core.Rail[])cor.value)[(int)1L] = t$70918;
        
        //#line 154 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
        final x10.core.Rail t$70919 = ((x10.core.Rail)(x10.runtime.impl.java.ArrayUtils.<x10.core.Double> makeRailFromJavaArray(x10.rtt.Types.DOUBLE, new double[] {0.0, 0.0, 1.0})));
        
        //#line 154 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
        ((x10.core.Rail[])cor.value)[(int)2L] = t$70919;
        
        //#line 162 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
        final double dt = 1.0;
        
        //#line 164 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
        final boolean logType = true;
        
        //#line 165 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
        final x10.util.Random random = ((x10.util.Random)(new x10.util.Random((java.lang.System[]) null).x10$util$Random$$init$S()));
        
        //#line 166 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
        final plham.util.MultiGeomBrownian2 mgbm = ((plham.util.MultiGeomBrownian2)(new plham.util.MultiGeomBrownian2((java.lang.System[]) null).plham$util$MultiGeomBrownian2$$init$S(((x10.util.Random)(random)), ((x10.core.Rail)(s0)), ((x10.core.Rail)(mu)), ((x10.core.Rail)(sigma)), ((x10.core.Rail)(cor)), ((double)(dt)), ((boolean)(logType)), (plham.util.MultiGeomBrownian2.__1$1x10$lang$Double$2__2$1x10$lang$Double$2__3$1x10$lang$Double$2__4$1x10$lang$Rail$1x10$lang$Double$2$2) null)));
        
        //#line 167 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
        final x10.io.Printer t$70921 = ((x10.io.Printer)(x10.io.Console.get$OUT()));
        
        //#line 167 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
        final x10.core.Rail t$70920 = ((x10.core.Rail)(mgbm.chol));
        
        //#line 167 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
        final java.lang.String t$70922 = (("Cholesky\n") + (t$70920));
        
        //#line 167 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
        t$70921.println(((java.lang.Object)(t$70922)));
        
        //#line 169 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
        final long i$70726min$71133 = 0L;
        
        //#line 169 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
        final long i$70726max$71134 = 1000L;
        
        //#line 169 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
        long i$71130 = i$70726min$71133;
        
        //#line 169 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
        for (;
             true;
             ) {
            
            //#line 169 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
            final long t$71131 = i$71130;
            
            //#line 169 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
            final boolean t$71132 = ((t$71131) <= (((long)(i$70726max$71134))));
            
            //#line 169 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
            if (!(t$71132)) {
                
                //#line 169 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
                break;
            }
            
            //#line 169 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
            final long t$71127 = i$71130;
            
            //#line 170 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
            final x10.core.Rail X$71125 = mgbm.nextBrownian();
            
            //#line 171 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
            final x10.core.Rail rail$71123 = ((x10.core.Rail)(X$71125));
            
            //#line 171 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
            final long size$71124 = ((x10.core.Rail<x10.core.Double>)rail$71123).size;
            
            //#line 171 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
            long idx$71120 = 0L;
            {
                
                //#line 171 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
                final double[] rail$71123$value$71137 = ((double[])rail$71123.value);
                
                //#line 171 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
                for (;
                     true;
                     ) {
                    
                    //#line 171 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
                    final long t$71121 = idx$71120;
                    
                    //#line 171 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
                    final boolean t$71122 = ((t$71121) < (((long)(size$71124))));
                    
                    //#line 171 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
                    if (!(t$71122)) {
                        
                        //#line 171 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
                        break;
                    }
                    
                    //#line 171 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
                    final long t$71116 = idx$71120;
                    
                    //#line 171 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
                    final double x$71117 = ((double)rail$71123$value$71137[(int)t$71116]);
                    
                    //#line 172 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
                    final x10.io.Printer t$71114 = ((x10.io.Printer)(x10.io.Console.get$OUT()));
                    
                    //#line 172 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
                    final java.lang.String t$71115 = (((x10.core.Double.$box(x$71117))) + (" "));
                    
                    //#line 172 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
                    t$71114.print(((java.lang.String)(t$71115)));
                    
                    //#line 171 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
                    final long t$71118 = idx$71120;
                    
                    //#line 171 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
                    final long t$71119 = ((t$71118) + (((long)(1L))));
                    
                    //#line 171 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
                    idx$71120 = t$71119;
                }
            }
            
            //#line 174 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
            final x10.io.Printer t$71126 = ((x10.io.Printer)(x10.io.Console.get$OUT()));
            
            //#line 174 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
            t$71126.println();
            
            //#line 169 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
            final long t$71128 = i$71130;
            
            //#line 169 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
            final long t$71129 = ((t$71128) + (((long)(1L))));
            
            //#line 169 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
            i$71130 = t$71129;
        }
    }
    
    
    //#line 5 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
    final public plham.util.MultiGeomBrownian2 plham$util$MultiGeomBrownian2$$this$plham$util$MultiGeomBrownian2() {
        
        //#line 5 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
        return plham.util.MultiGeomBrownian2.this;
    }
    
    
    //#line 5 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
    final public void __fieldInitializers_plham_util_MultiGeomBrownian2() {
        
        //#line 5 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
        this.random = null;
        
        //#line 5 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
        this.gaussian = null;
        
        //#line 5 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
        this.s0 = null;
        
        //#line 5 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
        this.mu = null;
        
        //#line 5 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
        this.sigma = null;
        
        //#line 5 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
        this.cor = null;
        
        //#line 5 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
        this.dt = 0.0;
        
        //#line 5 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
        this.dim = 0L;
        
        //#line 5 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
        this.chol = null;
        
        //#line 5 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
        this.state = null;
        
        //#line 5 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
        this.logType = false;
        
        //#line 5 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
        this.g = null;
        
        //#line 5 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
        this.c = null;
        
        //#line 5 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
        this.initialCheck = false;
    }
    
    
    final public static class $Closure$33 extends x10.core.Ref implements x10.core.fun.Fun_0_1, x10.serialization.X10JavaSerializable
    {
        public static final x10.rtt.RuntimeType<$Closure$33> $RTT = 
            x10.rtt.StaticFunType.<$Closure$33> make($Closure$33.class,
                                                     new x10.rtt.Type[] {
                                                         x10.rtt.ParameterizedType.make(x10.core.fun.Fun_0_1.$RTT, x10.rtt.Types.LONG, x10.rtt.ParameterizedType.make(x10.core.Rail.$RTT, x10.rtt.Types.DOUBLE))
                                                     });
        
        public x10.rtt.RuntimeType<?> $getRTT() { return $RTT; }
        
        public x10.rtt.Type<?> $getParam(int i) { return null; }
        
        private Object writeReplace() throws java.io.ObjectStreamException {
            return new x10.serialization.SerializationProxy(this);
        }
        
        public static x10.serialization.X10JavaSerializable $_deserialize_body(plham.util.MultiGeomBrownian2.$Closure$33 $_obj, x10.serialization.X10JavaDeserializer $deserializer) throws java.io.IOException {
            if (x10.runtime.impl.java.Runtime.TRACE_SER) { x10.runtime.impl.java.Runtime.printTraceMessage("X10JavaSerializable: $_deserialize_body() of " + $Closure$33.class + " calling"); } 
            $_obj.dim = $deserializer.readLong();
            return $_obj;
        }
        
        public static x10.serialization.X10JavaSerializable $_deserializer(x10.serialization.X10JavaDeserializer $deserializer) throws java.io.IOException {
            plham.util.MultiGeomBrownian2.$Closure$33 $_obj = new plham.util.MultiGeomBrownian2.$Closure$33((java.lang.System[]) null);
            $deserializer.record_reference($_obj);
            return $_deserialize_body($_obj, $deserializer);
        }
        
        public void $_serialize(x10.serialization.X10JavaSerializer $serializer) throws java.io.IOException {
            $serializer.write(this.dim);
            
        }
        
        // constructor just for allocation
        public $Closure$33(final java.lang.System[] $dummy) {
            
        }
        
        // dispatcher for method abstract public (Z1)=>U.operator()(a1:Z1):U
        public java.lang.Object $apply(final java.lang.Object a1, final x10.rtt.Type t1) {
            return $apply(x10.core.Long.$unbox(a1));
            
        }
        
        
    
        
        public x10.core.Rail $apply(final long id$17335) {
            
            //#line 61 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
            final x10.core.Rail t$70765 = ((x10.core.Rail)(new x10.core.Rail<x10.core.Double>(x10.rtt.Types.DOUBLE, this.dim)));
            
            //#line 61 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian2.x10"
            return t$70765;
        }
        
        public long dim;
        
        public $Closure$33(final long dim) {
             {
                this.dim = dim;
            }
        }
        
    }
    
}

