package plham.util;



public class MultiGeomBrownian extends x10.core.Ref implements x10.serialization.X10JavaSerializable
{
    public static final x10.rtt.RuntimeType<MultiGeomBrownian> $RTT = 
        x10.rtt.NamedType.<MultiGeomBrownian> make("plham.util.MultiGeomBrownian",
                                                   MultiGeomBrownian.class);
    
    public x10.rtt.RuntimeType<?> $getRTT() { return $RTT; }
    
    public x10.rtt.Type<?> $getParam(int i) { return null; }
    
    private Object writeReplace() throws java.io.ObjectStreamException {
        return new x10.serialization.SerializationProxy(this);
    }
    
    public static x10.serialization.X10JavaSerializable $_deserialize_body(plham.util.MultiGeomBrownian $_obj, x10.serialization.X10JavaDeserializer $deserializer) throws java.io.IOException {
        if (x10.runtime.impl.java.Runtime.TRACE_SER) { x10.runtime.impl.java.Runtime.printTraceMessage("X10JavaSerializable: $_deserialize_body() of " + MultiGeomBrownian.class + " calling"); } 
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
        plham.util.MultiGeomBrownian $_obj = new plham.util.MultiGeomBrownian((java.lang.System[]) null);
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
    public MultiGeomBrownian(final java.lang.System[] $dummy) {
        
    }
    
    // synthetic type for parameter mangling
    public static final class __1$1x10$lang$Double$2__2$1x10$lang$Double$2__3$1x10$lang$Double$2__4$1x10$lang$Rail$1x10$lang$Double$2$2 {}
    

    
    //#line 7 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
    public x10.util.Random random;
    
    //#line 8 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
    public cassia.util.random.Gaussian gaussian;
    
    //#line 16 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
    /**
	 * Given a lower-triangular cholesky decomposition matrix, U_{NxN},
	 * and a vector of independent Gaussians, X_{N} = (x_0,...,x_N),
	 * a correlated geometric Brownian vector is given by
	 *     \u0394S = X U  (dot)
	 * where S_{N} is a state vector of the N-dimensional geometric Brownian.
	 */
    public x10.core.Rail<x10.core.Double> s0;
    
    //#line 17 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
    public x10.core.Rail<x10.core.Double> mu;
    
    //#line 18 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
    public x10.core.Rail<x10.core.Double> sigma;
    
    //#line 19 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
    public x10.core.Rail<x10.core.Rail<x10.core.Double>> cor;
    
    //#line 20 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
    public double dt;
    
    //#line 21 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
    public long dim;
    
    //#line 22 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
    public x10.core.Rail<x10.core.Rail<x10.core.Double>> chol;
    
    //#line 23 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
    public x10.core.Rail<x10.core.Double> state;
    
    //#line 24 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
    public boolean logType;
    
    //#line 25 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
    public x10.core.Rail<x10.core.Double> g;
    
    //#line 26 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
    public x10.core.Rail<x10.core.Double> c;
    
    //#line 27 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
    public boolean initialCheck;
    
    
    //#line 28 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
    // creation method for java code (1-phase java constructor)
    public MultiGeomBrownian(final x10.util.Random random, final x10.core.Rail<x10.core.Double> s0, final x10.core.Rail<x10.core.Double> mu, final x10.core.Rail<x10.core.Double> sigma, final x10.core.Rail<x10.core.Rail<x10.core.Double>> cor, final double dt, final boolean logType, __1$1x10$lang$Double$2__2$1x10$lang$Double$2__3$1x10$lang$Double$2__4$1x10$lang$Rail$1x10$lang$Double$2$2 $dummy) {
        this((java.lang.System[]) null);
        plham$util$MultiGeomBrownian$$init$S(random, s0, mu, sigma, cor, dt, logType, (plham.util.MultiGeomBrownian.__1$1x10$lang$Double$2__2$1x10$lang$Double$2__3$1x10$lang$Double$2__4$1x10$lang$Rail$1x10$lang$Double$2$2) null);
    }
    
    // constructor for non-virtual call
    final public plham.util.MultiGeomBrownian plham$util$MultiGeomBrownian$$init$S(final x10.util.Random random, final x10.core.Rail<x10.core.Double> s0, final x10.core.Rail<x10.core.Double> mu, final x10.core.Rail<x10.core.Double> sigma, final x10.core.Rail<x10.core.Rail<x10.core.Double>> cor, final double dt, final boolean logType, __1$1x10$lang$Double$2__2$1x10$lang$Double$2__3$1x10$lang$Double$2__4$1x10$lang$Rail$1x10$lang$Double$2$2 $dummy) {
         {
            
            //#line 28 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
            
            
            //#line 5 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
            this.__fieldInitializers_plham_util_MultiGeomBrownian();
            
            //#line 29 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
            this.random = ((random));
            
            //#line 30 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
            final cassia.util.random.Gaussian t$31923 = ((new cassia.util.random.Gaussian((java.lang.System[]) null).cassia$util$random$Gaussian$$init$S(((random)))));
            
            //#line 30 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
            this.gaussian = ((t$31923));
            
            //#line 31 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
            this.s0 = ((s0));
            
            //#line 32 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
            this.mu = ((mu));
            
            //#line 33 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
            this.sigma = ((sigma));
            
            //#line 34 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
            this.cor = ((cor));
            
            //#line 35 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
            final x10.core.Rail t$31924 = plham.util.Cholesky.decompose__0$1x10$lang$Rail$1x10$lang$Double$2$2(((cor)));
            
            //#line 35 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
            this.chol = ((t$31924));
            
            //#line 36 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
            this.dt = dt;
            
            //#line 37 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
            final long t$31925 = mu.size;
            
            //#line 37 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
            this.dim = t$31925;
            
            //#line 38 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
            final long t$31926 = this.dim;
            
            //#line 38 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
            final x10.core.Rail t$31927 = ((new x10.core.Rail<x10.core.Double>(x10.rtt.Types.DOUBLE, t$31926)));
            
            //#line 38 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
            this.state = ((t$31927));
            
            //#line 39 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
            this.initialCheck = true;
            
            //#line 40 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
            final long t$31928 = this.dim;
            
            //#line 40 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
            final x10.core.Rail t$31929 = ((new x10.core.Rail<x10.core.Double>(x10.rtt.Types.DOUBLE, t$31928)));
            
            //#line 40 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
            this.g = ((t$31929));
            
            //#line 41 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
            final long t$31930 = this.dim;
            
            //#line 41 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
            final x10.core.Rail t$31931 = ((new x10.core.Rail<x10.core.Double>(x10.rtt.Types.DOUBLE, t$31930)));
            
            //#line 41 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
            this.c = ((t$31931));
            
            //#line 42 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
            this.logType = logType;
            
            //#line 43 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
            final long dim = this.dim;
            
            //#line 44 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
            assert (dim) == (s0.size);
            
            //#line 45 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
            assert (dim) == (mu.size);
            
            //#line 46 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
            assert (dim) == (sigma.size);
            
            //#line 47 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
            assert (dim) == (this.chol.size);
            
            //#line 48 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
            final long i$31701min$32131 = 0L;
            
            //#line 48 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
            final long i$31701max$32132 = ((dim) - (((1L))));
            
            //#line 48 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
            long i$32128 = i$31701min$32131;
            
            //#line 48 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
            for (;
                 true;
                 ) {
                
                //#line 48 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
                final long t$32129 = i$32128;
                
                //#line 48 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
                final boolean t$32130 = ((t$32129) <= (((i$31701max$32132))));
                
                //#line 48 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
                if (!(t$32130)) {
                    
                    //#line 48 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
                    break;
                }
                
                //#line 48 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
                final long i$32125 = i$32128;
                
                //#line 49 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
                final long i$31683min$32123 = 0L;
                
                //#line 49 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
                final long i$31683max$32124 = ((i$32125) - (((1L))));
                
                //#line 49 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
                long i$32120 = i$31683min$32123;
                
                //#line 49 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
                for (;
                     true;
                     ) {
                    
                    //#line 49 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
                    final long t$32121 = i$32120;
                    
                    //#line 49 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
                    final boolean t$32122 = ((t$32121) <= (((i$31683max$32124))));
                    
                    //#line 49 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
                    if (!(t$32122)) {
                        
                        //#line 49 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
                        break;
                    }
                    
                    //#line 49 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
                    final long j$32117 = i$32120;
                    
                    //#line 50 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
                    assert (((double[])((x10.core.Rail[])this.chol.value)[(int)j$32117].value)[(int)i$32125]) == (0.0);
                    
                    //#line 49 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
                    final long t$32118 = i$32120;
                    
                    //#line 49 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
                    final long t$32119 = ((t$32118) + (((1L))));
                    
                    //#line 49 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
                    i$32120 = t$32119;
                }
                
                //#line 48 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
                final long t$32126 = i$32128;
                
                //#line 48 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
                final long t$32127 = ((t$32126) + (((1L))));
                
                //#line 48 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
                i$32128 = t$32127;
            }
        }
        return this;
    }
    
    
    
    //#line 56 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
    // creation method for java code (1-phase java constructor)
    public MultiGeomBrownian(final x10.util.Random random, final long dim) {
        this((java.lang.System[]) null);
        init(random, dim);
    }
    
    // constructor for non-virtual call
	final public plham.util.MultiGeomBrownian init(final x10.util.Random random, final long dim) {
         {
            
            //#line 57 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
            /*this.*/plham$util$MultiGeomBrownian$$init$S(((random)), ((dim)), ((true)));
        }
        return this;
    }
    
    
    
    //#line 60 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
    // creation method for java code (1-phase java constructor)
    public MultiGeomBrownian(final x10.util.Random random, final long dim, final boolean logType) {
        this((java.lang.System[]) null);
        plham$util$MultiGeomBrownian$$init$S(random, dim, logType);
    }
    
    // constructor for non-virtual call
    final public plham.util.MultiGeomBrownian plham$util$MultiGeomBrownian$$init$S(final x10.util.Random random, final long dim, final boolean logType) {
         {
            
            //#line 60 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
            
            
            //#line 5 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
            this.__fieldInitializers_plham_util_MultiGeomBrownian();
            
            //#line 61 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
            this.random = ((random));
            
            //#line 62 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
            final cassia.util.random.Gaussian t$31942 = ((new cassia.util.random.Gaussian((java.lang.System[]) null).cassia$util$random$Gaussian$$init$S(((random)))));
            
            //#line 62 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
            this.gaussian = ((t$31942));
            
            //#line 63 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
            final x10.core.Rail t$31943 = ((new x10.core.Rail<x10.core.Double>(x10.rtt.Types.DOUBLE, ((dim)))));
            
            //#line 63 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
            this.mu = ((t$31943));
            
            //#line 64 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
            final x10.core.Rail t$31944 = ((new x10.core.Rail<x10.core.Double>(x10.rtt.Types.DOUBLE, ((dim)))));
            
            //#line 64 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
            this.sigma = ((t$31944));
            
            //#line 65 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
            final x10.core.fun.Fun_0_1 t$31946 = ((new plham.util.MultiGeomBrownian.$Closure$25(dim)));
            
            //#line 65 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
            final x10.core.Rail t$31947 = ((new x10.core.Rail<x10.core.Rail<x10.core.Double>>(x10.rtt.ParameterizedType.make(x10.core.Rail.$RTT, x10.rtt.Types.DOUBLE), ((dim)), ((t$31946)), (x10.core.Rail.__1$1x10$lang$Long$3x10$lang$Rail$$T$2) null)));
            
            //#line 65 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
            this.cor = ((t$31947));
            
            //#line 66 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
            this.chol = null;
            
            //#line 67 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
            final x10.core.Rail t$31948 = ((new x10.core.Rail<x10.core.Double>(x10.rtt.Types.DOUBLE, ((dim)))));
            
            //#line 67 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
            this.s0 = ((t$31948));
            
            //#line 68 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
            this.dt = 1.0;
            
            //#line 69 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
            this.dim = dim;
            
            //#line 70 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
            final x10.core.Rail t$31949 = ((new x10.core.Rail<x10.core.Double>(x10.rtt.Types.DOUBLE, ((dim)))));
            
            //#line 70 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
            this.state = ((t$31949));
            
            //#line 71 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
            this.initialCheck = true;
            
            //#line 72 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
            final x10.core.Rail t$31950 = ((new x10.core.Rail<x10.core.Double>(x10.rtt.Types.DOUBLE, ((dim)))));
            
            //#line 72 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
            this.g = ((t$31950));
            
            //#line 73 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
            final x10.core.Rail t$31951 = ((new x10.core.Rail<x10.core.Double>(x10.rtt.Types.DOUBLE, ((dim)))));
            
            //#line 73 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
            this.c = ((t$31951));
            
            //#line 74 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
            this.logType = logType;
        }
        return this;
    }
    
    
    
    //#line 78 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
    public x10.core.Rail nextBrownian() {
        
        //#line 79 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
        x10.core.Rail out = new x10.core.Rail<x10.core.Double>(x10.rtt.Types.DOUBLE);
        
        //#line 80 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
        final boolean t$31954 = this.logType;
        
        //#line 80 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
        if (t$31954) {
            
            //#line 82 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
            final x10.core.Rail t$31952 = this.nextBrownian2();
            
            //#line 82 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
            out = ((t$31952));
        } else {
            
            //#line 85 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
            final x10.core.Rail t$31953 = this.nextBrownian3();
            
            //#line 85 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
            out = ((t$31953));
        }
        
        //#line 87 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
        final x10.core.Rail t$31955 = ((out));
        
        //#line 87 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
        return t$31955;
    }
    
    
    //#line 90 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
    public x10.core.Rail nextBrownian2() {
        
        //#line 91 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
        final x10.core.Rail t$31956 = ((this.chol));
        
        //#line 91 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
        final boolean t$31959 = ((t$31956) == (null));
        
        //#line 91 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
        if (t$31959) {
            
            //#line 92 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
            final x10.core.Rail t$31957 = ((this.cor));
            
            //#line 92 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
            final x10.core.Rail t$31958 = plham.util.Cholesky.decompose__0$1x10$lang$Rail$1x10$lang$Double$2$2(((t$31957)));
            
            //#line 92 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
            this.chol = ((t$31958));
        }
        
        //#line 94 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
        final long dim = this.dim;
        
        //#line 95 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
        final long i$31719min$32204 = 0L;
        
        //#line 95 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
        final long i$31719max$32205 = ((dim) - (((1L))));
        
        //#line 95 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
        long i$32139 = i$31719min$32204;
        
        //#line 95 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
        for (;
             true;
             ) {
            
            //#line 95 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
            final long t$32140 = i$32139;
            
            //#line 95 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
            final boolean t$32141 = ((t$32140) <= (((i$31719max$32205))));
            
            //#line 95 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
            if (!(t$32141)) {
                
                //#line 95 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
                break;
            }
            
            //#line 95 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
            final long i$32136 = i$32139;
            
            //#line 96 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
            final x10.core.Rail t$32133 = ((this.g));
            
            //#line 96 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
            final cassia.util.random.Gaussian t$32134 = ((this.gaussian));
            
            //#line 96 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
            final double t$32135 = t$32134.nextGaussian$O();
            
            //#line 96 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
            ((double[])t$32133.value)[(int)i$32136] = t$32135;
            
            //#line 95 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
            final long t$32137 = i$32139;
            
            //#line 95 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
            final long t$32138 = ((t$32137) + (((1L))));
            
            //#line 95 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
            i$32139 = t$32138;
        }
        
        //#line 98 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
        final long i$31755min$32206 = 0L;
        
        //#line 98 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
        final long i$31755max$32207 = ((dim) - (((1L))));
        
        //#line 98 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
        long i$32164 = i$31755min$32206;
        
        //#line 98 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
        for (;
             true;
             ) {
            
            //#line 98 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
            final long t$32165 = i$32164;
            
            //#line 98 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
            final boolean t$32166 = ((t$32165) <= (((i$31755max$32207))));
            
            //#line 98 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
            if (!(t$32166)) {
                
                //#line 98 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
                break;
            }
            
            //#line 98 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
            final long i$32161 = i$32164;
            
            //#line 99 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
            final x10.core.Rail t$32160 = ((this.c));
            
            //#line 99 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
            ((double[])t$32160.value)[(int)i$32161] = 0.0;
            
            //#line 100 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
            final long i$31737min$32158 = 0L;
            
            //#line 100 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
            final long i$31737max$32159 = i$32161;
            
            //#line 100 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
            long i$32155 = i$31737min$32158;
            
            //#line 100 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
            for (;
                 true;
                 ) {
                
                //#line 100 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
                final long t$32156 = i$32155;
                
                //#line 100 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
                final boolean t$32157 = ((t$32156) <= (((i$31737max$32159))));
                
                //#line 100 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
                if (!(t$32157)) {
                    
                    //#line 100 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
                    break;
                }
                
                //#line 100 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
                final long j$32152 = i$32155;
                
                //#line 101 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
                final x10.core.Rail a$32142 = ((this.c));
                
                //#line 101 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
                final long i$32143 = i$32161;
                
                //#line 101 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
                final double t$32144 = ((double[])a$32142.value)[(int)i$32143];
                
                //#line 101 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
                final x10.core.Rail t$32145 = ((this.g));
                
                //#line 101 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
                final double t$32146 = ((double[])t$32145.value)[(int)j$32152];
                
                //#line 101 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
                final x10.core.Rail t$32147 = ((this.chol));
                
                //#line 101 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
                final x10.core.Rail t$32148 = ((x10.core.Rail[])t$32147.value)[(int)i$32161];
                
                //#line 101 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
                final double t$32149 = ((double[])t$32148.value)[(int)j$32152];
                
                //#line 101 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
                final double t$32150 = ((t$32146) * (((t$32149))));
                
                //#line 101 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
                final double r$32151 = ((t$32144) + (((t$32150))));
                
                //#line 101 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
                ((double[])a$32142.value)[(int)i$32143] = r$32151;
                
                //#line 100 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
                final long t$32153 = i$32155;
                
                //#line 100 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
                final long t$32154 = ((t$32153) + (((1L))));
                
                //#line 100 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
                i$32155 = t$32154;
            }
            
            //#line 98 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
            final long t$32162 = i$32164;
            
            //#line 98 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
            final long t$32163 = ((t$32162) + (((1L))));
            
            //#line 98 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
            i$32164 = t$32163;
        }
        
        //#line 104 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
        final long i$31773min$32208 = 0L;
        
        //#line 104 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
        final long i$31773max$32209 = ((dim) - (((1L))));
        
        //#line 104 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
        long i$32201 = i$31773min$32208;
        
        //#line 104 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
        for (;
             true;
             ) {
            
            //#line 104 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
            final long t$32202 = i$32201;
            
            //#line 104 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
            final boolean t$32203 = ((t$32202) <= (((i$31773max$32209))));
            
            //#line 104 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
            if (!(t$32203)) {
                
                //#line 104 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
                break;
            }
            
            //#line 104 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
            final long i$32198 = i$32201;
            
            //#line 106 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
            final x10.core.Rail a$32167 = ((this.state));
            
            //#line 106 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
            final long i$32168 = i$32198;
            
            //#line 106 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
            final double t$32169 = ((double[])a$32167.value)[(int)i$32168];
            
            //#line 106 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
            final x10.core.Rail t$32170 = ((this.mu));
            
            //#line 106 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
            final double t$32171 = ((double[])t$32170.value)[(int)i$32198];
            
            //#line 106 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
            final x10.core.Rail t$32172 = ((this.sigma));
            
            //#line 106 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
            final double t$32173 = ((double[])t$32172.value)[(int)i$32198];
            
            //#line 106 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
            final x10.core.Rail t$32174 = ((this.sigma));
            
            //#line 106 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
            final double t$32175 = ((double[])t$32174.value)[(int)i$32198];
            
            //#line 106 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
            final double t$32176 = ((t$32173) * (((t$32175))));
            
            //#line 106 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
            final double t$32177 = ((t$32176) * (((0.5))));
            
            //#line 106 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
            final double t$32178 = ((t$32171) - (((t$32177))));
            
            //#line 106 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
            final double t$32179 = this.dt;
            
            //#line 106 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
            final double t$32180 = ((t$32178) * (((t$32179))));
            
            //#line 106 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
            final x10.core.Rail t$32181 = ((this.sigma));
            
            //#line 106 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
            final double t$32182 = ((double[])t$32181.value)[(int)i$32198];
            
            //#line 106 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
            final x10.core.Rail t$32183 = ((this.c));
            
            //#line 106 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
            final double t$32184 = ((double[])t$32183.value)[(int)i$32198];
            
            //#line 106 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
            final double t$32185 = ((t$32182) * (((t$32184))));
            
            //#line 106 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
            final double t$32186 = this.dt;
            
            //#line 106 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
            final double t$32187 = java.lang.Math.sqrt(((t$32186)));
            
            //#line 106 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
            final double t$32188 = ((t$32185) * (((t$32187))));
            
            //#line 106 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
            final double t$32189 = ((t$32180) + (((t$32188))));
            
            //#line 106 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
            final double r$32190 = ((t$32169) + (((t$32189))));
            
            //#line 106 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
            ((double[])a$32167.value)[(int)i$32168] = r$32190;
            
            //#line 107 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
            final x10.core.Rail t$32191 = ((this.g));
            
            //#line 107 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
            final x10.core.Rail t$32192 = ((this.s0));
            
            //#line 107 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
            final double t$32193 = ((double[])t$32192.value)[(int)i$32198];
            
            //#line 107 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
            final x10.core.Rail t$32194 = ((this.state));
            
            //#line 107 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
            final double t$32195 = ((double[])t$32194.value)[(int)i$32198];
            
            //#line 107 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
            final double t$32196 = java.lang.Math.exp(((t$32195)));
            
            //#line 107 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
            final double t$32197 = ((t$32193) * (((t$32196))));
            
            //#line 107 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
            ((double[])t$32191.value)[(int)i$32198] = t$32197;
            
            //#line 104 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
            final long t$32199 = i$32201;
            
            //#line 104 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
            final long t$32200 = ((t$32199) + (((1L))));
            
            //#line 104 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
            i$32201 = t$32200;
        }
        
        //#line 109 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
        final x10.core.Rail t$32019 = ((this.g));
        
        //#line 109 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
        return t$32019;
    }
    
    
    //#line 112 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
    public x10.core.Rail nextBrownian3() {
        
        //#line 113 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
        final long dim = this.dim;
        
        //#line 114 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
        final boolean t$32028 = this.initialCheck;
        
        //#line 114 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
        if (t$32028) {
            
            //#line 115 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
            final long i$31791min$32219 = 0L;
            
            //#line 115 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
            final long i$31791max$32220 = ((dim) - (((1L))));
            
            //#line 115 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
            long i$32216 = i$31791min$32219;
            
            //#line 115 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
            for (;
                 true;
                 ) {
                
                //#line 115 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
                final long t$32217 = i$32216;
                
                //#line 115 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
                final boolean t$32218 = ((t$32217) <= (((i$31791max$32220))));
                
                //#line 115 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
                if (!(t$32218)) {
                    
                    //#line 115 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
                    break;
                }
                
                //#line 115 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
                final long i$32213 = i$32216;
                
                //#line 116 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
                final x10.core.Rail t$32210 = ((this.g));
                
                //#line 116 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
                final x10.core.Rail t$32211 = ((this.s0));
                
                //#line 116 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
                final double t$32212 = ((double[])t$32211.value)[(int)i$32213];
                
                //#line 116 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
                ((double[])t$32210.value)[(int)i$32213] = t$32212;
                
                //#line 115 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
                final long t$32214 = i$32216;
                
                //#line 115 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
                final long t$32215 = ((t$32214) + (((1L))));
                
                //#line 115 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
                i$32216 = t$32215;
            }
            
            //#line 118 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
            this.initialCheck = false;
        }
        
        //#line 121 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
        final x10.core.Rail t$32029 = ((this.chol));
        
        //#line 121 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
        final boolean t$32032 = ((t$32029) == (null));
        
        //#line 121 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
        if (t$32032) {
            
            //#line 122 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
            final x10.core.Rail t$32030 = ((this.cor));
            
            //#line 122 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
            final x10.core.Rail t$32031 = plham.util.Cholesky.decompose__0$1x10$lang$Rail$1x10$lang$Double$2$2(((t$32030)));
            
            //#line 122 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
            this.chol = ((t$32031));
        }
        
        //#line 125 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
        final x10.core.Rail hoge = ((new x10.core.Rail<x10.core.Double>(x10.rtt.Types.DOUBLE, ((dim)))));
        
        //#line 126 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
        final long i$31809min$32288 = 0L;
        
        //#line 126 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
        final long i$31809max$32289 = ((dim) - (((1L))));
        
        //#line 126 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
        long i$32226 = i$31809min$32288;
        {
            
            //#line 126 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
            final double[] hoge$value$32315 = ((double[])hoge.value);
            
            //#line 126 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
            for (;
                 true;
                 ) {
                
                //#line 126 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
                final long t$32227 = i$32226;
                
                //#line 126 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
                final boolean t$32228 = ((t$32227) <= (((i$31809max$32289))));
                
                //#line 126 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
                if (!(t$32228)) {
                    
                    //#line 126 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
                    break;
                }
                
                //#line 126 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
                final long i$32223 = i$32226;
                
                //#line 127 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
                final cassia.util.random.Gaussian t$32221 = ((this.gaussian));
                
                //#line 127 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
                final double t$32222 = t$32221.nextGaussian$O();
                
                //#line 127 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
                hoge$value$32315[(int)i$32223]=t$32222;
                
                //#line 126 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
                final long t$32224 = i$32226;
                
                //#line 126 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
                final long t$32225 = ((t$32224) + (((1L))));
                
                //#line 126 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
                i$32226 = t$32225;
            }
        }
        
        //#line 129 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
        final long i$31845min$32290 = 0L;
        
        //#line 129 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
        final long i$31845max$32291 = ((dim) - (((1L))));
        
        //#line 129 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
        long i$32250 = i$31845min$32290;
        {
            
            //#line 129 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
            final double[] hoge$value$32316 = ((double[])hoge.value);
            
            //#line 129 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
            for (;
                 true;
                 ) {
                
                //#line 129 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
                final long t$32251 = i$32250;
                
                //#line 129 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
                final boolean t$32252 = ((t$32251) <= (((i$31845max$32291))));
                
                //#line 129 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
                if (!(t$32252)) {
                    
                    //#line 129 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
                    break;
                }
                
                //#line 129 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
                final long i$32247 = i$32250;
                
                //#line 130 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
                final x10.core.Rail t$32246 = ((this.c));
                
                //#line 130 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
                ((double[])t$32246.value)[(int)i$32247] = 0.0;
                
                //#line 131 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
                final long i$31827min$32244 = 0L;
                
                //#line 131 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
                final long i$31827max$32245 = i$32247;
                
                //#line 131 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
                long i$32241 = i$31827min$32244;
                {
                    
                    //#line 131 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
                    for (;
                         true;
                         ) {
                        
                        //#line 131 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
                        final long t$32242 = i$32241;
                        
                        //#line 131 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
                        final boolean t$32243 = ((t$32242) <= (((i$31827max$32245))));
                        
                        //#line 131 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
                        if (!(t$32243)) {
                            
                            //#line 131 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
                            break;
                        }
                        
                        //#line 131 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
                        final long j$32238 = i$32241;
                        
                        //#line 132 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
                        final x10.core.Rail a$32229 = ((this.c));
                        
                        //#line 132 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
                        final long i$32230 = i$32247;
                        
                        //#line 132 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
                        final double t$32231 = ((double[])a$32229.value)[(int)i$32230];
                        
                        //#line 132 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
                        final double t$32232 = (hoge$value$32316[(int)j$32238]);
                        
                        //#line 132 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
                        final x10.core.Rail t$32233 = ((x10.core.Rail)(this.chol));
                        
                        //#line 132 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
                        final x10.core.Rail t$32234 = ((x10.core.Rail[])t$32233.value)[(int)i$32247];
                        
                        //#line 132 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
                        final double t$32235 = ((double[])t$32234.value)[(int)j$32238];
                        
                        //#line 132 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
                        final double t$32236 = ((t$32232) * (((double)(t$32235))));
                        
                        //#line 132 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
                        final double r$32237 = ((t$32231) + (((double)(t$32236))));
                        
                        //#line 132 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
                        ((double[])a$32229.value)[(int)i$32230] = r$32237;
                        
                        //#line 131 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
                        final long t$32239 = i$32241;
                        
                        //#line 131 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
                        final long t$32240 = ((t$32239) + (((long)(1L))));
                        
                        //#line 131 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
                        i$32241 = t$32240;
                    }
                }
                
                //#line 129 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
                final long t$32248 = i$32250;
                
                //#line 129 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
                final long t$32249 = ((t$32248) + (((long)(1L))));
                
                //#line 129 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
                i$32250 = t$32249;
            }
        }
        
        //#line 135 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
        final long i$31863min$32292 = 0L;
        
        //#line 135 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
        final long i$31863max$32293 = ((dim) - (((long)(1L))));
        
        //#line 135 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
        long i$32285 = i$31863min$32292;
        
        //#line 135 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
        for (;
             true;
             ) {
            
            //#line 135 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
            final long t$32286 = i$32285;
            
            //#line 135 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
            final boolean t$32287 = ((t$32286) <= (((long)(i$31863max$32293))));
            
            //#line 135 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
            if (!(t$32287)) {
                
                //#line 135 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
                break;
            }
            
            //#line 135 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
            final long i$32282 = i$32285;
            
            //#line 137 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
            final x10.core.Rail t$32253 = ((x10.core.Rail)(this.state));
            
            //#line 137 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
            final x10.core.Rail t$32254 = ((x10.core.Rail)(this.mu));
            
            //#line 137 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
            final double t$32255 = ((double[])t$32254.value)[(int)i$32282];
            
            //#line 137 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
            final x10.core.Rail t$32256 = ((x10.core.Rail)(this.sigma));
            
            //#line 137 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
            final double t$32257 = ((double[])t$32256.value)[(int)i$32282];
            
            //#line 137 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
            final x10.core.Rail t$32258 = ((x10.core.Rail)(this.sigma));
            
            //#line 137 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
            final double t$32259 = ((double[])t$32258.value)[(int)i$32282];
            
            //#line 137 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
            final double t$32260 = ((t$32257) * (((double)(t$32259))));
            
            //#line 137 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
            final double t$32261 = ((t$32260) * (((double)(0.5))));
            
            //#line 137 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
            final double t$32262 = ((t$32255) - (((double)(t$32261))));
            
            //#line 137 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
            final double t$32263 = this.dt;
            
            //#line 137 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
            final double t$32264 = ((t$32262) * (((double)(t$32263))));
            
            //#line 137 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
            final x10.core.Rail t$32265 = ((x10.core.Rail)(this.sigma));
            
            //#line 137 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
            final double t$32266 = ((double[])t$32265.value)[(int)i$32282];
            
            //#line 137 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
            final x10.core.Rail t$32267 = ((x10.core.Rail)(this.c));
            
            //#line 137 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
            final double t$32268 = ((double[])t$32267.value)[(int)i$32282];
            
            //#line 137 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
            final double t$32269 = ((t$32266) * (((double)(t$32268))));
            
            //#line 137 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
            final double t$32270 = this.dt;
            
            //#line 137 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
            final double t$32271 = java.lang.Math.sqrt(((double)(t$32270)));
            
            //#line 137 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
            final double t$32272 = ((t$32269) * (((double)(t$32271))));
            
            //#line 137 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
            final double t$32273 = ((t$32264) + (((double)(t$32272))));
            
            //#line 137 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
            ((double[])t$32253.value)[(int)i$32282] = t$32273;
            
            //#line 138 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
            final x10.core.Rail t$32274 = ((x10.core.Rail)(this.g));
            
            //#line 138 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
            final x10.core.Rail t$32275 = ((x10.core.Rail)(this.g));
            
            //#line 138 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
            final double t$32276 = ((double[])t$32275.value)[(int)i$32282];
            
            //#line 138 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
            final double t$32277 = ((double)(long)(((long)(1L))));
            
            //#line 138 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
            final x10.core.Rail t$32278 = ((x10.core.Rail)(this.state));
            
            //#line 138 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
            final double t$32279 = ((double[])t$32278.value)[(int)i$32282];
            
            //#line 138 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
            final double t$32280 = ((t$32277) + (((double)(t$32279))));
            
            //#line 138 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
            final double t$32281 = ((t$32276) * (((double)(t$32280))));
            
            //#line 138 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
            ((double[])t$32274.value)[(int)i$32282] = t$32281;
            
            //#line 135 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
            final long t$32283 = i$32285;
            
            //#line 135 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
            final long t$32284 = ((t$32283) + (((long)(1L))));
            
            //#line 135 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
            i$32285 = t$32284;
        }
        
        //#line 140 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
        final x10.core.Rail t$32091 = ((x10.core.Rail)(this.g));
        
        //#line 140 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
        return t$32091;
    }
    
    
    //#line 143 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
    public double get(final long i) {
        
        //#line 144 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
        final x10.core.Rail t$32092 = ((x10.core.Rail)(this.g));
        
        //#line 144 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
        final double t$32093 = ((double[])t$32092.value)[(int)i];
        
        //#line 144 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
        return t$32093;
    }
    
    
    //#line 147 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
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
            MultiGeomBrownian.main(args);
        }
    }
    
    // the original app-main method
    public static void main(final x10.core.Rail<java.lang.String> id$1676) {
        
        //#line 151 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
        final long dim = 3L;
        
        //#line 152 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
        final x10.core.Rail t$32094 = ((x10.core.Rail)(x10.runtime.impl.java.ArrayUtils.<x10.core.Double> makeRailFromJavaArray(x10.rtt.Types.DOUBLE, new double[] {300.0, 200.0, 100.0})));
        
        //#line 152 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
        final x10.core.Rail s0 = ((x10.core.Rail)(new x10.core.Rail<x10.core.Double>(x10.rtt.Types.DOUBLE, ((x10.core.Rail)(t$32094)), (x10.core.Rail.__0$1x10$lang$Rail$$T$2) null)));
        
        //#line 153 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
        final x10.core.Rail t$32095 = ((x10.core.Rail)(x10.runtime.impl.java.ArrayUtils.<x10.core.Double> makeRailFromJavaArray(x10.rtt.Types.DOUBLE, new double[] {1.0, 0.0, 0.0})));
        
        //#line 153 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
        final x10.core.Rail mu = ((x10.core.Rail)(new x10.core.Rail<x10.core.Double>(x10.rtt.Types.DOUBLE, ((x10.core.Rail)(t$32095)), (x10.core.Rail.__0$1x10$lang$Rail$$T$2) null)));
        
        //#line 153 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
        ((double[])mu.value)[(int)0L] = 0.0;
        
        //#line 154 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
        final x10.core.Rail t$32096 = ((x10.core.Rail)(x10.runtime.impl.java.ArrayUtils.<x10.core.Double> makeRailFromJavaArray(x10.rtt.Types.DOUBLE, new double[] {0.001, 0.01, 0.05})));
        
        //#line 154 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
        final x10.core.Rail sigma = ((x10.core.Rail)(new x10.core.Rail<x10.core.Double>(x10.rtt.Types.DOUBLE, ((x10.core.Rail)(t$32096)), (x10.core.Rail.__0$1x10$lang$Rail$$T$2) null)));
        
        //#line 155 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
        final x10.core.Rail cor = ((x10.core.Rail)(new x10.core.Rail<x10.core.Rail<x10.core.Double>>(x10.rtt.ParameterizedType.make(x10.core.Rail.$RTT, x10.rtt.Types.DOUBLE), ((long)(dim)))));
        
        //#line 156 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
        final x10.core.Rail t$32097 = ((x10.core.Rail)(x10.runtime.impl.java.ArrayUtils.<x10.core.Double> makeRailFromJavaArray(x10.rtt.Types.DOUBLE, new double[] {1.0, 0.8, 0.0})));
        
        //#line 156 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
        ((x10.core.Rail[])cor.value)[(int)0L] = t$32097;
        
        //#line 157 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
        final x10.core.Rail t$32098 = ((x10.core.Rail)(x10.runtime.impl.java.ArrayUtils.<x10.core.Double> makeRailFromJavaArray(x10.rtt.Types.DOUBLE, new double[] {0.8, 1.0, 0.0})));
        
        //#line 157 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
        ((x10.core.Rail[])cor.value)[(int)1L] = t$32098;
        
        //#line 158 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
        final x10.core.Rail t$32099 = ((x10.core.Rail)(x10.runtime.impl.java.ArrayUtils.<x10.core.Double> makeRailFromJavaArray(x10.rtt.Types.DOUBLE, new double[] {0.0, 0.0, 1.0})));
        
        //#line 158 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
        ((x10.core.Rail[])cor.value)[(int)2L] = t$32099;
        
        //#line 166 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
        final double dt = 1.0;
        
        //#line 168 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
        final boolean logType = true;
        
        //#line 169 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
        final x10.util.Random random = ((x10.util.Random)(new x10.util.Random((java.lang.System[]) null).x10$util$Random$$init$S()));
        
        //#line 170 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
        final plham.util.MultiGeomBrownian mgbm = ((plham.util.MultiGeomBrownian)(new plham.util.MultiGeomBrownian((java.lang.System[]) null).plham$util$MultiGeomBrownian$$init$S(((x10.util.Random)(random)), ((x10.core.Rail)(s0)), ((x10.core.Rail)(mu)), ((x10.core.Rail)(sigma)), ((x10.core.Rail)(cor)), ((double)(dt)), ((boolean)(logType)), (plham.util.MultiGeomBrownian.__1$1x10$lang$Double$2__2$1x10$lang$Double$2__3$1x10$lang$Double$2__4$1x10$lang$Rail$1x10$lang$Double$2$2) null)));
        
        //#line 171 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
        final x10.io.Printer t$32101 = ((x10.io.Printer)(x10.io.Console.get$OUT()));
        
        //#line 171 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
        final x10.core.Rail t$32100 = ((x10.core.Rail)(mgbm.chol));
        
        //#line 171 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
        final java.lang.String t$32102 = (("Cholesky\n") + (t$32100));
        
        //#line 171 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
        t$32101.println(((java.lang.Object)(t$32102)));
        
        //#line 173 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
        final long i$31906min$32313 = 0L;
        
        //#line 173 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
        final long i$31906max$32314 = 1000L;
        
        //#line 173 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
        long i$32310 = i$31906min$32313;
        
        //#line 173 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
        for (;
             true;
             ) {
            
            //#line 173 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
            final long t$32311 = i$32310;
            
            //#line 173 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
            final boolean t$32312 = ((t$32311) <= (((long)(i$31906max$32314))));
            
            //#line 173 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
            if (!(t$32312)) {
                
                //#line 173 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
                break;
            }
            
            //#line 173 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
            final long t$32307 = i$32310;
            
            //#line 174 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
            final x10.core.Rail X$32305 = mgbm.nextBrownian();
            
            //#line 175 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
            final x10.core.Rail rail$32303 = ((x10.core.Rail)(X$32305));
            
            //#line 175 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
            final long size$32304 = ((x10.core.Rail<x10.core.Double>)rail$32303).size;
            
            //#line 175 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
            long idx$32300 = 0L;
            {
                
                //#line 175 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
                final double[] rail$32303$value$32317 = ((double[])rail$32303.value);
                
                //#line 175 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
                for (;
                     true;
                     ) {
                    
                    //#line 175 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
                    final long t$32301 = idx$32300;
                    
                    //#line 175 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
                    final boolean t$32302 = ((t$32301) < (((long)(size$32304))));
                    
                    //#line 175 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
                    if (!(t$32302)) {
                        
                        //#line 175 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
                        break;
                    }
                    
                    //#line 175 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
                    final long t$32296 = idx$32300;
                    
                    //#line 175 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
                    final double x$32297 = ((double)rail$32303$value$32317[(int)t$32296]);
                    
                    //#line 176 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
                    final x10.io.Printer t$32294 = ((x10.io.Printer)(x10.io.Console.get$OUT()));
                    
                    //#line 176 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
                    final java.lang.String t$32295 = (((x10.core.Double.$box(x$32297))) + (" "));
                    
                    //#line 176 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
                    t$32294.print(((java.lang.String)(t$32295)));
                    
                    //#line 175 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
                    final long t$32298 = idx$32300;
                    
                    //#line 175 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
                    final long t$32299 = ((t$32298) + (((long)(1L))));
                    
                    //#line 175 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
                    idx$32300 = t$32299;
                }
            }
            
            //#line 178 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
            final x10.io.Printer t$32306 = ((x10.io.Printer)(x10.io.Console.get$OUT()));
            
            //#line 178 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
            t$32306.println();
            
            //#line 173 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
            final long t$32308 = i$32310;
            
            //#line 173 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
            final long t$32309 = ((t$32308) + (((long)(1L))));
            
            //#line 173 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
            i$32310 = t$32309;
        }
    }
    
    
    //#line 5 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
    final public plham.util.MultiGeomBrownian plham$util$MultiGeomBrownian$$this$plham$util$MultiGeomBrownian() {
        
        //#line 5 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
        return plham.util.MultiGeomBrownian.this;
    }
    
    
    //#line 5 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
    final public void __fieldInitializers_plham_util_MultiGeomBrownian() {
        
        //#line 5 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
        this.random = null;
        
        //#line 5 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
        this.gaussian = null;
        
        //#line 5 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
        this.s0 = null;
        
        //#line 5 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
        this.mu = null;
        
        //#line 5 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
        this.sigma = null;
        
        //#line 5 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
        this.cor = null;
        
        //#line 5 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
        this.dt = 0.0;
        
        //#line 5 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
        this.dim = 0L;
        
        //#line 5 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
        this.chol = null;
        
        //#line 5 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
        this.state = null;
        
        //#line 5 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
        this.logType = false;
        
        //#line 5 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
        this.g = null;
        
        //#line 5 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
        this.c = null;
        
        //#line 5 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
        this.initialCheck = false;
    }
    
    
    final public static class $Closure$25 extends x10.core.Ref implements x10.core.fun.Fun_0_1, x10.serialization.X10JavaSerializable
    {
        public static final x10.rtt.RuntimeType<$Closure$25> $RTT = 
            x10.rtt.StaticFunType.<$Closure$25> make($Closure$25.class,
                                                     new x10.rtt.Type[] {
                                                         x10.rtt.ParameterizedType.make(x10.core.fun.Fun_0_1.$RTT, x10.rtt.Types.LONG, x10.rtt.ParameterizedType.make(x10.core.Rail.$RTT, x10.rtt.Types.DOUBLE))
                                                     });
        
        public x10.rtt.RuntimeType<?> $getRTT() { return $RTT; }
        
        public x10.rtt.Type<?> $getParam(int i) { return null; }
        
        private Object writeReplace() throws java.io.ObjectStreamException {
            return new x10.serialization.SerializationProxy(this);
        }
        
        public static x10.serialization.X10JavaSerializable $_deserialize_body(plham.util.MultiGeomBrownian.$Closure$25 $_obj, x10.serialization.X10JavaDeserializer $deserializer) throws java.io.IOException {
            if (x10.runtime.impl.java.Runtime.TRACE_SER) { x10.runtime.impl.java.Runtime.printTraceMessage("X10JavaSerializable: $_deserialize_body() of " + $Closure$25.class + " calling"); } 
            $_obj.dim = $deserializer.readLong();
            return $_obj;
        }
        
        public static x10.serialization.X10JavaSerializable $_deserializer(x10.serialization.X10JavaDeserializer $deserializer) throws java.io.IOException {
            plham.util.MultiGeomBrownian.$Closure$25 $_obj = new plham.util.MultiGeomBrownian.$Closure$25((java.lang.System[]) null);
            $deserializer.record_reference($_obj);
            return $_deserialize_body($_obj, $deserializer);
        }
        
        public void $_serialize(x10.serialization.X10JavaSerializer $serializer) throws java.io.IOException {
            $serializer.write(this.dim);
            
        }
        
        // constructor just for allocation
        public $Closure$25(final java.lang.System[] $dummy) {
            
        }
        
        // dispatcher for method abstract public (Z1)=>U.operator()(a1:Z1):U
        public java.lang.Object $apply(final java.lang.Object a1, final x10.rtt.Type t1) {
            return $apply(x10.core.Long.$unbox(a1));
            
        }
        
        
    
        
        public x10.core.Rail $apply(final long id$1675) {
            
            //#line 65 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
            final x10.core.Rail t$31945 = ((x10.core.Rail)(new x10.core.Rail<x10.core.Double>(x10.rtt.Types.DOUBLE, this.dim)));
            
            //#line 65 "/home/dsl/workspace/plhamK/plham/util/MultiGeomBrownian.x10"
            return t$31945;
        }
        
        public long dim;
        
        public $Closure$25(final long dim) {
             {
                this.dim = dim;
            }
        }
        
    }
    
}

