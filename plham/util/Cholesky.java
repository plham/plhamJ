package plham.util;

/**
 * Cholesky decomposition of a positive definite matrix.
 * Reference: Numerical Recipes 3rd Ed, p.100.
 */

public class Cholesky extends x10.core.Ref implements x10.serialization.X10JavaSerializable
{
    public static final x10.rtt.RuntimeType<Cholesky> $RTT = 
        x10.rtt.NamedType.<Cholesky> make("plham.util.Cholesky",
                                          Cholesky.class);
    
    public x10.rtt.RuntimeType<?> $getRTT() { return $RTT; }
    
    public x10.rtt.Type<?> $getParam(int i) { return null; }
    
    private Object writeReplace() throws java.io.ObjectStreamException {
        return new x10.serialization.SerializationProxy(this);
    }
    
    public static x10.serialization.X10JavaSerializable $_deserialize_body(plham.util.Cholesky $_obj, x10.serialization.X10JavaDeserializer $deserializer) throws java.io.IOException {
        if (x10.runtime.impl.java.Runtime.TRACE_SER) { x10.runtime.impl.java.Runtime.printTraceMessage("X10JavaSerializable: $_deserialize_body() of " + Cholesky.class + " calling"); } 
        return $_obj;
    }
    
    public static x10.serialization.X10JavaSerializable $_deserializer(x10.serialization.X10JavaDeserializer $deserializer) throws java.io.IOException {
        plham.util.Cholesky $_obj = new plham.util.Cholesky((java.lang.System[]) null);
        $deserializer.record_reference($_obj);
        return $_deserialize_body($_obj, $deserializer);
    }
    
    public void $_serialize(x10.serialization.X10JavaSerializer $serializer) throws java.io.IOException {
        
    }
    
    // constructor just for allocation
    public Cholesky(final java.lang.System[] $dummy) {
        
    }
    
    

    
    
    //#line 16 "/home/dsl/workspace/plhamK/plham/util/Cholesky.x10"
    /**
	 * Cholesky decomposition of a positive definite matrix.
	 * It returns a new array whose lower-triangular store the factors, and
	 * whose upper-triangular are all zero.
	 * Reference: Numerical Recipes 3rd Ed, p.100.
	 */
    public static x10.core.Rail decompose__0$1x10$lang$Rail$1x10$lang$Double$2$2(final x10.core.Rail<x10.core.Rail<x10.core.Double>> m) {
        
        //#line 17 "/home/dsl/workspace/plhamK/plham/util/Cholesky.x10"
        final long n = m.size;
        
        //#line 18 "/home/dsl/workspace/plhamK/plham/util/Cholesky.x10"
        final x10.core.Rail a = ((new x10.core.Rail<x10.core.Rail<x10.core.Double>>(x10.rtt.ParameterizedType.make(x10.core.Rail.$RTT, x10.rtt.Types.DOUBLE), ((n)))));
        
        //#line 19 "/home/dsl/workspace/plhamK/plham/util/Cholesky.x10"
        final long i$36770min$37031 = 0L;
        
        //#line 19 "/home/dsl/workspace/plhamK/plham/util/Cholesky.x10"
        final long i$36770max$37032 = ((n) - (((1L))));
        
        //#line 19 "/home/dsl/workspace/plhamK/plham/util/Cholesky.x10"
        long i$36970 = i$36770min$37031;
        {
            
            //#line 19 "/home/dsl/workspace/plhamK/plham/util/Cholesky.x10"
            final x10.core.Rail[] m$value$37047 = ((x10.core.Rail[])m.value);
            
            //#line 19 "/home/dsl/workspace/plhamK/plham/util/Cholesky.x10"
            final x10.core.Rail[] a$value$37048 = ((x10.core.Rail[])a.value);
            
            //#line 19 "/home/dsl/workspace/plhamK/plham/util/Cholesky.x10"
            for (;
                 true;
                 ) {
                
                //#line 19 "/home/dsl/workspace/plhamK/plham/util/Cholesky.x10"
                final long t$36971 = i$36970;
                
                //#line 19 "/home/dsl/workspace/plhamK/plham/util/Cholesky.x10"
                final boolean t$36972 = ((t$36971) <= (((i$36770max$37032))));
                
                //#line 19 "/home/dsl/workspace/plhamK/plham/util/Cholesky.x10"
                if (!(t$36972)) {
                    
                    //#line 19 "/home/dsl/workspace/plhamK/plham/util/Cholesky.x10"
                    break;
                }
                
                //#line 19 "/home/dsl/workspace/plhamK/plham/util/Cholesky.x10"
                final long i$36967 = i$36970;
                
                //#line 20 "/home/dsl/workspace/plhamK/plham/util/Cholesky.x10"
                final x10.core.Rail t$36965 = (m$value$37047[(int)i$36967]);
                
                //#line 20 "/home/dsl/workspace/plhamK/plham/util/Cholesky.x10"
                final x10.core.Rail t$36966 = ((new x10.core.Rail<x10.core.Double>(x10.rtt.Types.DOUBLE, t$36965, (x10.core.Rail.__0$1x10$lang$Rail$$T$2) null)));
                
                //#line 20 "/home/dsl/workspace/plhamK/plham/util/Cholesky.x10"
                a$value$37048[(int)i$36967]=t$36966;
                
                //#line 19 "/home/dsl/workspace/plhamK/plham/util/Cholesky.x10"
                final long t$36968 = i$36970;
                
                //#line 19 "/home/dsl/workspace/plhamK/plham/util/Cholesky.x10"
                final long t$36969 = ((t$36968) + (((1L))));
                
                //#line 19 "/home/dsl/workspace/plhamK/plham/util/Cholesky.x10"
                i$36970 = t$36969;
            }
        }
        
        //#line 22 "/home/dsl/workspace/plhamK/plham/util/Cholesky.x10"
        double sum =  0;
        
        //#line 23 "/home/dsl/workspace/plhamK/plham/util/Cholesky.x10"
        final long i$36824min$37033 = 0L;
        
        //#line 23 "/home/dsl/workspace/plhamK/plham/util/Cholesky.x10"
        final long i$36824max$37034 = ((n) - (((1L))));
        
        //#line 23 "/home/dsl/workspace/plhamK/plham/util/Cholesky.x10"
        long i$37013 = i$36824min$37033;
        {
            
            //#line 23 "/home/dsl/workspace/plhamK/plham/util/Cholesky.x10"
            final x10.core.Rail[] a$value$37049 = ((x10.core.Rail[])a.value);
            
            //#line 23 "/home/dsl/workspace/plhamK/plham/util/Cholesky.x10"
            for (;
                 true;
                 ) {
                
                //#line 23 "/home/dsl/workspace/plhamK/plham/util/Cholesky.x10"
                final long t$37014 = i$37013;
                
                //#line 23 "/home/dsl/workspace/plhamK/plham/util/Cholesky.x10"
                final boolean t$37015 = ((t$37014) <= (((i$36824max$37034))));
                
                //#line 23 "/home/dsl/workspace/plhamK/plham/util/Cholesky.x10"
                if (!(t$37015)) {
                    
                    //#line 23 "/home/dsl/workspace/plhamK/plham/util/Cholesky.x10"
                    break;
                }
                
                //#line 23 "/home/dsl/workspace/plhamK/plham/util/Cholesky.x10"
                final long i$37010 = i$37013;
                
                //#line 24 "/home/dsl/workspace/plhamK/plham/util/Cholesky.x10"
                assert (((x10.core.Rail<x10.core.Double>)a$value$37049[(int)i$37010]).size) == (n);
                
                //#line 25 "/home/dsl/workspace/plhamK/plham/util/Cholesky.x10"
                final long i$36806min$37008 = i$37010;
                
                //#line 25 "/home/dsl/workspace/plhamK/plham/util/Cholesky.x10"
                final long i$36806max$37009 = ((n) - (((1L))));
                
                //#line 25 "/home/dsl/workspace/plhamK/plham/util/Cholesky.x10"
                long i$37005 = i$36806min$37008;
                {
                    
                    //#line 25 "/home/dsl/workspace/plhamK/plham/util/Cholesky.x10"
                    for (;
                         true;
                         ) {
                        
                        //#line 25 "/home/dsl/workspace/plhamK/plham/util/Cholesky.x10"
                        final long t$37006 = i$37005;
                        
                        //#line 25 "/home/dsl/workspace/plhamK/plham/util/Cholesky.x10"
                        final boolean t$37007 = ((t$37006) <= (((i$36806max$37009))));
                        
                        //#line 25 "/home/dsl/workspace/plhamK/plham/util/Cholesky.x10"
                        if (!(t$37007)) {
                            
                            //#line 25 "/home/dsl/workspace/plhamK/plham/util/Cholesky.x10"
                            break;
                        }
                        
                        //#line 25 "/home/dsl/workspace/plhamK/plham/util/Cholesky.x10"
                        final long j$37002 = i$37005;
                        
                        //#line 26 "/home/dsl/workspace/plhamK/plham/util/Cholesky.x10"
                        final x10.core.Rail t$36988 = (a$value$37049[(int)i$37010]);
                        
                        //#line 26 "/home/dsl/workspace/plhamK/plham/util/Cholesky.x10"
                        final double t$36989 = ((double[])t$36988.value)[(int)j$37002];
                        
                        //#line 26 "/home/dsl/workspace/plhamK/plham/util/Cholesky.x10"
                        sum = t$36989;
                        
                        //#line 27 "/home/dsl/workspace/plhamK/plham/util/Cholesky.x10"
                        final long i$36788min$36986 = 0L;
                        
                        //#line 27 "/home/dsl/workspace/plhamK/plham/util/Cholesky.x10"
                        final long i$36788max$36987 = ((i$37010) - (((1L))));
                        
                        //#line 27 "/home/dsl/workspace/plhamK/plham/util/Cholesky.x10"
                        long i$36983 = i$36788min$36986;
                        {
                            
                            //#line 27 "/home/dsl/workspace/plhamK/plham/util/Cholesky.x10"
                            for (;
                                 true;
                                 ) {
                                
                                //#line 27 "/home/dsl/workspace/plhamK/plham/util/Cholesky.x10"
                                final long t$36984 = i$36983;
                                
                                //#line 27 "/home/dsl/workspace/plhamK/plham/util/Cholesky.x10"
                                final boolean t$36985 = ((t$36984) <= (((i$36788max$36987))));
                                
                                //#line 27 "/home/dsl/workspace/plhamK/plham/util/Cholesky.x10"
                                if (!(t$36985)) {
                                    
                                    //#line 27 "/home/dsl/workspace/plhamK/plham/util/Cholesky.x10"
                                    break;
                                }
                                
                                //#line 27 "/home/dsl/workspace/plhamK/plham/util/Cholesky.x10"
                                final long k$36980 = i$36983;
                                
                                //#line 28 "/home/dsl/workspace/plhamK/plham/util/Cholesky.x10"
                                final double t$36973 = sum;
                                
                                //#line 28 "/home/dsl/workspace/plhamK/plham/util/Cholesky.x10"
                                final x10.core.Rail t$36974 = (a$value$37049[(int)i$37010]);
                                
                                //#line 28 "/home/dsl/workspace/plhamK/plham/util/Cholesky.x10"
                                final double t$36975 = ((double[])t$36974.value)[(int)k$36980];
                                
                                //#line 28 "/home/dsl/workspace/plhamK/plham/util/Cholesky.x10"
                                final x10.core.Rail t$36976 = (a$value$37049[(int)j$37002]);
                                
                                //#line 28 "/home/dsl/workspace/plhamK/plham/util/Cholesky.x10"
                                final double t$36977 = ((double[])t$36976.value)[(int)k$36980];
                                
                                //#line 28 "/home/dsl/workspace/plhamK/plham/util/Cholesky.x10"
                                final double t$36978 = ((t$36975) * (((t$36977))));
                                
                                //#line 28 "/home/dsl/workspace/plhamK/plham/util/Cholesky.x10"
                                final double t$36979 = ((t$36973) - (((t$36978))));
                                
                                //#line 28 "/home/dsl/workspace/plhamK/plham/util/Cholesky.x10"
                                sum = t$36979;
                                
                                //#line 27 "/home/dsl/workspace/plhamK/plham/util/Cholesky.x10"
                                final long t$36981 = i$36983;
                                
                                //#line 27 "/home/dsl/workspace/plhamK/plham/util/Cholesky.x10"
                                final long t$36982 = ((t$36981) + (((1L))));
                                
                                //#line 27 "/home/dsl/workspace/plhamK/plham/util/Cholesky.x10"
                                i$36983 = t$36982;
                            }
                        }
                        
                        //#line 30 "/home/dsl/workspace/plhamK/plham/util/Cholesky.x10"
                        final boolean t$36990 = (i$37010) == (j$37002);
                        
                        //#line 30 "/home/dsl/workspace/plhamK/plham/util/Cholesky.x10"
                        if (t$36990) {
                            
                            //#line 31 "/home/dsl/workspace/plhamK/plham/util/Cholesky.x10"
                            final double t$36991 = sum;
                            
                            //#line 31 "/home/dsl/workspace/plhamK/plham/util/Cholesky.x10"
                            final boolean t$36992 = ((t$36991) <= (((0.0))));
                            
                            //#line 31 "/home/dsl/workspace/plhamK/plham/util/Cholesky.x10"
                            if (t$36992) {
                                
                                //#line 32 "/home/dsl/workspace/plhamK/plham/util/Cholesky.x10"
                                final plham.util.NumericalException t$36993 = ((new plham.util.NumericalException((("a matrix is not positive definite")))));
                                
                                //#line 32 "/home/dsl/workspace/plhamK/plham/util/Cholesky.x10"
                                throw t$36993;
                            }
                            
                            //#line 34 "/home/dsl/workspace/plhamK/plham/util/Cholesky.x10"
                            final x10.core.Rail t$36994 = (a$value$37049[(int)i$37010]);
                            
                            //#line 34 "/home/dsl/workspace/plhamK/plham/util/Cholesky.x10"
                            final double t$36995 = sum;
                            
                            //#line 34 "/home/dsl/workspace/plhamK/plham/util/Cholesky.x10"
                            final double t$36996 = java.lang.Math.sqrt(((t$36995)));
                            
                            //#line 34 "/home/dsl/workspace/plhamK/plham/util/Cholesky.x10"
                            ((double[])t$36994.value)[(int)i$37010] = t$36996;
                        } else {
                            
                            //#line 36 "/home/dsl/workspace/plhamK/plham/util/Cholesky.x10"
                            final x10.core.Rail t$36997 = (a$value$37049[(int)j$37002]);
                            
                            //#line 36 "/home/dsl/workspace/plhamK/plham/util/Cholesky.x10"
                            final double t$36998 = sum;
                            
                            //#line 36 "/home/dsl/workspace/plhamK/plham/util/Cholesky.x10"
                            final x10.core.Rail t$36999 = (a$value$37049[(int)i$37010]);
                            
                            //#line 36 "/home/dsl/workspace/plhamK/plham/util/Cholesky.x10"
                            final double t$37000 = ((double[])t$36999.value)[(int)i$37010];
                            
                            //#line 36 "/home/dsl/workspace/plhamK/plham/util/Cholesky.x10"
                            final double t$37001 = ((t$36998) / (((t$37000))));
                            
                            //#line 36 "/home/dsl/workspace/plhamK/plham/util/Cholesky.x10"
                            ((double[])t$36997.value)[(int)i$37010] = t$37001;
                        }
                        
                        //#line 25 "/home/dsl/workspace/plhamK/plham/util/Cholesky.x10"
                        final long t$37003 = i$37005;
                        
                        //#line 25 "/home/dsl/workspace/plhamK/plham/util/Cholesky.x10"
                        final long t$37004 = ((t$37003) + (((1L))));
                        
                        //#line 25 "/home/dsl/workspace/plhamK/plham/util/Cholesky.x10"
                        i$37005 = t$37004;
                    }
                }
                
                //#line 23 "/home/dsl/workspace/plhamK/plham/util/Cholesky.x10"
                final long t$37011 = i$37013;
                
                //#line 23 "/home/dsl/workspace/plhamK/plham/util/Cholesky.x10"
                final long t$37012 = ((t$37011) + (((1L))));
                
                //#line 23 "/home/dsl/workspace/plhamK/plham/util/Cholesky.x10"
                i$37013 = t$37012;
            }
        }
        
        //#line 40 "/home/dsl/workspace/plhamK/plham/util/Cholesky.x10"
        final long i$36860min$37035 = 0L;
        
        //#line 40 "/home/dsl/workspace/plhamK/plham/util/Cholesky.x10"
        final long i$36860max$37036 = ((n) - (((1L))));
        
        //#line 40 "/home/dsl/workspace/plhamK/plham/util/Cholesky.x10"
        long i$37028 = i$36860min$37035;
        {
            
            //#line 40 "/home/dsl/workspace/plhamK/plham/util/Cholesky.x10"
            final x10.core.Rail[] a$value$37050 = ((x10.core.Rail[])a.value);
            
            //#line 40 "/home/dsl/workspace/plhamK/plham/util/Cholesky.x10"
            for (;
                 true;
                 ) {
                
                //#line 40 "/home/dsl/workspace/plhamK/plham/util/Cholesky.x10"
                final long t$37029 = i$37028;
                
                //#line 40 "/home/dsl/workspace/plhamK/plham/util/Cholesky.x10"
                final boolean t$37030 = ((t$37029) <= (((i$36860max$37036))));
                
                //#line 40 "/home/dsl/workspace/plhamK/plham/util/Cholesky.x10"
                if (!(t$37030)) {
                    
                    //#line 40 "/home/dsl/workspace/plhamK/plham/util/Cholesky.x10"
                    break;
                }
                
                //#line 40 "/home/dsl/workspace/plhamK/plham/util/Cholesky.x10"
                final long i$37025 = i$37028;
                
                //#line 41 "/home/dsl/workspace/plhamK/plham/util/Cholesky.x10"
                final long i$36842min$37023 = 0L;
                
                //#line 41 "/home/dsl/workspace/plhamK/plham/util/Cholesky.x10"
                final long i$36842max$37024 = ((i$37025) - (((1L))));
                
                //#line 41 "/home/dsl/workspace/plhamK/plham/util/Cholesky.x10"
                long i$37020 = i$36842min$37023;
                {
                    
                    //#line 41 "/home/dsl/workspace/plhamK/plham/util/Cholesky.x10"
                    for (;
                         true;
                         ) {
                        
                        //#line 41 "/home/dsl/workspace/plhamK/plham/util/Cholesky.x10"
                        final long t$37021 = i$37020;
                        
                        //#line 41 "/home/dsl/workspace/plhamK/plham/util/Cholesky.x10"
                        final boolean t$37022 = ((t$37021) <= (((i$36842max$37024))));
                        
                        //#line 41 "/home/dsl/workspace/plhamK/plham/util/Cholesky.x10"
                        if (!(t$37022)) {
                            
                            //#line 41 "/home/dsl/workspace/plhamK/plham/util/Cholesky.x10"
                            break;
                        }
                        
                        //#line 41 "/home/dsl/workspace/plhamK/plham/util/Cholesky.x10"
                        final long j$37017 = i$37020;
                        
                        //#line 42 "/home/dsl/workspace/plhamK/plham/util/Cholesky.x10"
                        final x10.core.Rail t$37016 = (a$value$37050[(int)j$37017]);
                        
                        //#line 42 "/home/dsl/workspace/plhamK/plham/util/Cholesky.x10"
                        ((double[])t$37016.value)[(int)i$37025] = 0.0;
                        
                        //#line 41 "/home/dsl/workspace/plhamK/plham/util/Cholesky.x10"
                        final long t$37018 = i$37020;
                        
                        //#line 41 "/home/dsl/workspace/plhamK/plham/util/Cholesky.x10"
                        final long t$37019 = ((t$37018) + (((1L))));
                        
                        //#line 41 "/home/dsl/workspace/plhamK/plham/util/Cholesky.x10"
                        i$37020 = t$37019;
                    }
                }
                
                //#line 40 "/home/dsl/workspace/plhamK/plham/util/Cholesky.x10"
                final long t$37026 = i$37028;
                
                //#line 40 "/home/dsl/workspace/plhamK/plham/util/Cholesky.x10"
                final long t$37027 = ((t$37026) + (((1L))));
                
                //#line 40 "/home/dsl/workspace/plhamK/plham/util/Cholesky.x10"
                i$37028 = t$37027;
            }
        }
        
        //#line 45 "/home/dsl/workspace/plhamK/plham/util/Cholesky.x10"
        return a;
    }
    
    
    //#line 48 "/home/dsl/workspace/plhamK/plham/util/Cholesky.x10"
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
            Cholesky.main(args);
        }
    }
    
    // the original app-main method
    public static void main(final x10.core.Rail<java.lang.String> id$13460) {
        
        //#line 82 "/home/dsl/workspace/plhamK/plham/util/Cholesky.x10"
        final double t$36949 = -0.84282638;
        
        //#line 82 "/home/dsl/workspace/plhamK/plham/util/Cholesky.x10"
        final x10.core.Rail t$36951 = ((x10.runtime.impl.java.ArrayUtils.<x10.core.Double> makeRailFromJavaArray(x10.rtt.Types.DOUBLE, new double[] {1.0, t$36949, 0.20007618})));
        
        //#line 83 "/home/dsl/workspace/plhamK/plham/util/Cholesky.x10"
        final double t$36950 = -0.84282638;
        
        //#line 83 "/home/dsl/workspace/plhamK/plham/util/Cholesky.x10"
        final x10.core.Rail t$36952 = ((x10.runtime.impl.java.ArrayUtils.<x10.core.Double> makeRailFromJavaArray(x10.rtt.Types.DOUBLE, new double[] {t$36950, 1.0, 0.84461232})));
        
        //#line 84 "/home/dsl/workspace/plhamK/plham/util/Cholesky.x10"
        final x10.core.Rail t$36953 = ((x10.runtime.impl.java.ArrayUtils.<x10.core.Double> makeRailFromJavaArray(x10.rtt.Types.DOUBLE, new double[] {0.20007618, 0.84461232, 1.0})));
        
        //#line 81 "/home/dsl/workspace/plhamK/plham/util/Cholesky.x10"
        final x10.core.Rail M = ((x10.runtime.impl.java.ArrayUtils.<x10.core.Rail<x10.core.Double>> makeRailFromJavaArray(x10.rtt.ParameterizedType.make(x10.core.Rail.$RTT, x10.rtt.Types.DOUBLE), new x10.core.Rail[] {t$36951, t$36952, t$36953})));
        
        //#line 90 "/home/dsl/workspace/plhamK/plham/util/Cholesky.x10"
        final long n = ((x10.core.Rail<x10.core.Rail<x10.core.Double>>)M).size;
        
        //#line 91 "/home/dsl/workspace/plhamK/plham/util/Cholesky.x10"
        final x10.core.Rail m = ((new x10.core.Rail<x10.core.Rail<x10.core.Double>>(x10.rtt.ParameterizedType.make(x10.core.Rail.$RTT, x10.rtt.Types.DOUBLE), ((n)))));
        
        //#line 92 "/home/dsl/workspace/plhamK/plham/util/Cholesky.x10"
        final long i$36878min$37045 = 0L;
        
        //#line 92 "/home/dsl/workspace/plhamK/plham/util/Cholesky.x10"
        final long i$36878max$37046 = ((n) - (((1L))));
        
        //#line 92 "/home/dsl/workspace/plhamK/plham/util/Cholesky.x10"
        long i$37042 = i$36878min$37045;
        {
            
            //#line 92 "/home/dsl/workspace/plhamK/plham/util/Cholesky.x10"
            final x10.core.Rail[] M$value$37051 = ((x10.core.Rail[])M.value);
            
            //#line 92 "/home/dsl/workspace/plhamK/plham/util/Cholesky.x10"
            final x10.core.Rail[] m$value$37052 = ((x10.core.Rail[])m.value);
            
            //#line 92 "/home/dsl/workspace/plhamK/plham/util/Cholesky.x10"
            for (;
                 true;
                 ) {
                
                //#line 92 "/home/dsl/workspace/plhamK/plham/util/Cholesky.x10"
                final long t$37043 = i$37042;
                
                //#line 92 "/home/dsl/workspace/plhamK/plham/util/Cholesky.x10"
                final boolean t$37044 = ((t$37043) <= (((i$36878max$37046))));
                
                //#line 92 "/home/dsl/workspace/plhamK/plham/util/Cholesky.x10"
                if (!(t$37044)) {
                    
                    //#line 92 "/home/dsl/workspace/plhamK/plham/util/Cholesky.x10"
                    break;
                }
                
                //#line 92 "/home/dsl/workspace/plhamK/plham/util/Cholesky.x10"
                final long i$37039 = i$37042;
                
                //#line 93 "/home/dsl/workspace/plhamK/plham/util/Cholesky.x10"
                final x10.core.Rail t$37037 = (((M$value$37051[(int)i$37039])));
                
                //#line 93 "/home/dsl/workspace/plhamK/plham/util/Cholesky.x10"
                final x10.core.Rail t$37038 = ((new x10.core.Rail<x10.core.Double>(x10.rtt.Types.DOUBLE, ((t$37037)), (x10.core.Rail.__0$1x10$lang$Rail$$T$2) null)));
                
                //#line 93 "/home/dsl/workspace/plhamK/plham/util/Cholesky.x10"
                m$value$37052[(int)i$37039]=t$37038;
                
                //#line 92 "/home/dsl/workspace/plhamK/plham/util/Cholesky.x10"
                final long t$37040 = i$37042;
                
                //#line 92 "/home/dsl/workspace/plhamK/plham/util/Cholesky.x10"
                final long t$37041 = ((t$37040) + (((1L))));
                
                //#line 92 "/home/dsl/workspace/plhamK/plham/util/Cholesky.x10"
                i$37042 = t$37041;
            }
        }
        
        //#line 95 "/home/dsl/workspace/plhamK/plham/util/Cholesky.x10"
        final x10.io.Printer t$36961 = ((x10.io.Console.get$OUT()));
        
        //#line 95 "/home/dsl/workspace/plhamK/plham/util/Cholesky.x10"
        final java.lang.String t$36962 = x10.rtt.Types.typeName(((m)));
        
        //#line 95 "/home/dsl/workspace/plhamK/plham/util/Cholesky.x10"
        t$36961.println(((t$36962)));
        
        //#line 96 "/home/dsl/workspace/plhamK/plham/util/Cholesky.x10"
        final x10.io.Printer t$36963 = ((x10.io.Console.get$OUT()));
        
        //#line 96 "/home/dsl/workspace/plhamK/plham/util/Cholesky.x10"
        t$36963.println(((m)));
        
        //#line 97 "/home/dsl/workspace/plhamK/plham/util/Cholesky.x10"
        final x10.core.Rail a = plham.util.Cholesky.decompose__0$1x10$lang$Rail$1x10$lang$Double$2$2(((m)));
        
        //#line 98 "/home/dsl/workspace/plhamK/plham/util/Cholesky.x10"
        final x10.io.Printer t$36964 = ((x10.io.Console.get$OUT()));
        
        //#line 98 "/home/dsl/workspace/plhamK/plham/util/Cholesky.x10"
        t$36964.println(((a)));
    }
    
    
    //#line 8 "/home/dsl/workspace/plhamK/plham/util/Cholesky.x10"
    final public plham.util.Cholesky plham$util$Cholesky$$this$plham$util$Cholesky() {
        
        //#line 8 "/home/dsl/workspace/plhamK/plham/util/Cholesky.x10"
        return plham.util.Cholesky.this;
    }
    
    
    //#line 8 "/home/dsl/workspace/plhamK/plham/util/Cholesky.x10"
    // creation method for java code (1-phase java constructor)
    public Cholesky() {
        this((java.lang.System[]) null);
        plham$util$Cholesky$$init$S();
    }
    
    // constructor for non-virtual call
    final public plham.util.Cholesky plham$util$Cholesky$$init$S() {
         {
            
            //#line 8 "/home/dsl/workspace/plhamK/plham/util/Cholesky.x10"
            
            
            //#line 8 "/home/dsl/workspace/plhamK/plham/util/Cholesky.x10"
            this.__fieldInitializers_plham_util_Cholesky();
        }
        return this;
    }
    
    
    
    //#line 8 "/home/dsl/workspace/plhamK/plham/util/Cholesky.x10"
    final public void __fieldInitializers_plham_util_Cholesky() {
        
    }
}

