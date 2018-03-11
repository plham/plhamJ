package plham.util;



public class Statistics extends x10.core.Ref implements x10.serialization.X10JavaSerializable
{
    public static final x10.rtt.RuntimeType<Statistics> $RTT = 
        x10.rtt.NamedType.<Statistics> make("plham.util.Statistics",
                                            Statistics.class);
    
    public x10.rtt.RuntimeType<?> $getRTT() { return $RTT; }
    
    public x10.rtt.Type<?> $getParam(int i) { return null; }
    
    private Object writeReplace() throws java.io.ObjectStreamException {
        return new x10.serialization.SerializationProxy(this);
    }
    
    public static x10.serialization.X10JavaSerializable $_deserialize_body(plham.util.Statistics $_obj, x10.serialization.X10JavaDeserializer $deserializer) throws java.io.IOException {
        if (x10.runtime.impl.java.Runtime.TRACE_SER) { x10.runtime.impl.java.Runtime.printTraceMessage("X10JavaSerializable: $_deserialize_body() of " + Statistics.class + " calling"); } 
        return $_obj;
    }
    
    public static x10.serialization.X10JavaSerializable $_deserializer(x10.serialization.X10JavaDeserializer $deserializer) throws java.io.IOException {
        plham.util.Statistics $_obj = new plham.util.Statistics((java.lang.System[]) null);
        $deserializer.record_reference($_obj);
        return $_deserialize_body($_obj, $deserializer);
    }
    
    public void $_serialize(x10.serialization.X10JavaSerializer $serializer) throws java.io.IOException {
        
    }
    
    // constructor just for allocation
    public Statistics(final java.lang.System[] $dummy) {
        
    }
    
    

    
    
    //#line 8 "/home/dsl/workspace/plhamK/plham/util/Statistics.x10"
    public static double sum__0$1x10$lang$Double$2$O(final x10.util.List<x10.core.Double> a) {
        
        //#line 9 "/home/dsl/workspace/plhamK/plham/util/Statistics.x10"
        double sum = 0.0;
        
        //#line 10 "/home/dsl/workspace/plhamK/plham/util/Statistics.x10"
        final long i$34936min$35144 = 0L;
        
        //#line 10 "/home/dsl/workspace/plhamK/plham/util/Statistics.x10"
        final long t$35145 = ((x10.util.Container<x10.core.Double>)a).size$O();
        
        //#line 10 "/home/dsl/workspace/plhamK/plham/util/Statistics.x10"
        final long i$34936max$35146 = ((t$35145) - (((1L))));
        
        //#line 10 "/home/dsl/workspace/plhamK/plham/util/Statistics.x10"
        long i$35141 = i$34936min$35144;
        
        //#line 10 "/home/dsl/workspace/plhamK/plham/util/Statistics.x10"
        for (;
             true;
             ) {
            
            //#line 10 "/home/dsl/workspace/plhamK/plham/util/Statistics.x10"
            final long t$35142 = i$35141;
            
            //#line 10 "/home/dsl/workspace/plhamK/plham/util/Statistics.x10"
            final boolean t$35143 = ((t$35142) <= (((i$34936max$35146))));
            
            //#line 10 "/home/dsl/workspace/plhamK/plham/util/Statistics.x10"
            if (!(t$35143)) {
                
                //#line 10 "/home/dsl/workspace/plhamK/plham/util/Statistics.x10"
                break;
            }
            
            //#line 10 "/home/dsl/workspace/plhamK/plham/util/Statistics.x10"
            final long i$35138 = i$35141;
            
            //#line 11 "/home/dsl/workspace/plhamK/plham/util/Statistics.x10"
            final double t$35135 = sum;
            
            //#line 11 "/home/dsl/workspace/plhamK/plham/util/Statistics.x10"
            final double t$35136 = x10.core.Double.$unbox(((x10.util.Indexed<x10.core.Double>)a).$apply$G((i$35138)));
            
            //#line 11 "/home/dsl/workspace/plhamK/plham/util/Statistics.x10"
            final double t$35137 = ((t$35135) + (((t$35136))));
            
            //#line 11 "/home/dsl/workspace/plhamK/plham/util/Statistics.x10"
            sum = t$35137;
            
            //#line 10 "/home/dsl/workspace/plhamK/plham/util/Statistics.x10"
            final long t$35139 = i$35141;
            
            //#line 10 "/home/dsl/workspace/plhamK/plham/util/Statistics.x10"
            final long t$35140 = ((t$35139) + (((1L))));
            
            //#line 10 "/home/dsl/workspace/plhamK/plham/util/Statistics.x10"
            i$35141 = t$35140;
        }
        
        //#line 13 "/home/dsl/workspace/plhamK/plham/util/Statistics.x10"
        final double t$35034 = sum;
        
        //#line 13 "/home/dsl/workspace/plhamK/plham/util/Statistics.x10"
        return t$35034;
    }
    
    
    //#line 16 "/home/dsl/workspace/plhamK/plham/util/Statistics.x10"
    public static double sumofproducts__0$1x10$lang$Double$2__1$1x10$lang$Double$2$O(final x10.util.List<x10.core.Double> a, final x10.util.List<x10.core.Double> b) {
        
        //#line 17 "/home/dsl/workspace/plhamK/plham/util/Statistics.x10"
        assert (((x10.util.Container<x10.core.Double>)a).size$O()) == (((x10.util.Container<x10.core.Double>)b).size$O());
        
        //#line 18 "/home/dsl/workspace/plhamK/plham/util/Statistics.x10"
        double sum = 0.0;
        
        //#line 19 "/home/dsl/workspace/plhamK/plham/util/Statistics.x10"
        final long i$34954min$35158 = 0L;
        
        //#line 19 "/home/dsl/workspace/plhamK/plham/util/Statistics.x10"
        final long t$35159 = ((x10.util.Container<x10.core.Double>)a).size$O();
        
        //#line 19 "/home/dsl/workspace/plhamK/plham/util/Statistics.x10"
        final long i$34954max$35160 = ((t$35159) - (((1L))));
        
        //#line 19 "/home/dsl/workspace/plhamK/plham/util/Statistics.x10"
        long i$35155 = i$34954min$35158;
        
        //#line 19 "/home/dsl/workspace/plhamK/plham/util/Statistics.x10"
        for (;
             true;
             ) {
            
            //#line 19 "/home/dsl/workspace/plhamK/plham/util/Statistics.x10"
            final long t$35156 = i$35155;
            
            //#line 19 "/home/dsl/workspace/plhamK/plham/util/Statistics.x10"
            final boolean t$35157 = ((t$35156) <= (((i$34954max$35160))));
            
            //#line 19 "/home/dsl/workspace/plhamK/plham/util/Statistics.x10"
            if (!(t$35157)) {
                
                //#line 19 "/home/dsl/workspace/plhamK/plham/util/Statistics.x10"
                break;
            }
            
            //#line 19 "/home/dsl/workspace/plhamK/plham/util/Statistics.x10"
            final long i$35152 = i$35155;
            
            //#line 20 "/home/dsl/workspace/plhamK/plham/util/Statistics.x10"
            final double t$35147 = sum;
            
            //#line 20 "/home/dsl/workspace/plhamK/plham/util/Statistics.x10"
            final double t$35148 = x10.core.Double.$unbox(((x10.util.Indexed<x10.core.Double>)a).$apply$G((i$35152)));
            
            //#line 20 "/home/dsl/workspace/plhamK/plham/util/Statistics.x10"
            final double t$35149 = x10.core.Double.$unbox(((x10.util.Indexed<x10.core.Double>)b).$apply$G((i$35152)));
            
            //#line 20 "/home/dsl/workspace/plhamK/plham/util/Statistics.x10"
            final double t$35150 = ((t$35148) * (((t$35149))));
            
            //#line 20 "/home/dsl/workspace/plhamK/plham/util/Statistics.x10"
            final double t$35151 = ((t$35147) + (((t$35150))));
            
            //#line 20 "/home/dsl/workspace/plhamK/plham/util/Statistics.x10"
            sum = t$35151;
            
            //#line 19 "/home/dsl/workspace/plhamK/plham/util/Statistics.x10"
            final long t$35153 = i$35155;
            
            //#line 19 "/home/dsl/workspace/plhamK/plham/util/Statistics.x10"
            final long t$35154 = ((t$35153) + (((1L))));
            
            //#line 19 "/home/dsl/workspace/plhamK/plham/util/Statistics.x10"
            i$35155 = t$35154;
        }
        
        //#line 22 "/home/dsl/workspace/plhamK/plham/util/Statistics.x10"
        final double t$35046 = sum;
        
        //#line 22 "/home/dsl/workspace/plhamK/plham/util/Statistics.x10"
        return t$35046;
    }
    
    
    //#line 25 "/home/dsl/workspace/plhamK/plham/util/Statistics.x10"
    public static double sumofsquares__0$1x10$lang$Double$2$O(final x10.util.List<x10.core.Double> a) {
        
        //#line 26 "/home/dsl/workspace/plhamK/plham/util/Statistics.x10"
        final double t$35047 = plham.util.Statistics.sumofproducts__0$1x10$lang$Double$2__1$1x10$lang$Double$2$O(((a)), ((a)));
        
        //#line 26 "/home/dsl/workspace/plhamK/plham/util/Statistics.x10"
        return t$35047;
    }
    
    
    //#line 29 "/home/dsl/workspace/plhamK/plham/util/Statistics.x10"
    public static double mean__0$1x10$lang$Double$2$O(final x10.util.List<x10.core.Double> a) {
        
        //#line 30 "/home/dsl/workspace/plhamK/plham/util/Statistics.x10"
        final long t$35048 = ((x10.util.Container<x10.core.Double>)a).size$O();
        
        //#line 30 "/home/dsl/workspace/plhamK/plham/util/Statistics.x10"
        final boolean t$35049 = (t$35048) == (0L);
        
        //#line 30 "/home/dsl/workspace/plhamK/plham/util/Statistics.x10"
        if (t$35049) {
            
            //#line 30 "/home/dsl/workspace/plhamK/plham/util/Statistics.x10"
            return 0.0;
        }
        
        //#line 31 "/home/dsl/workspace/plhamK/plham/util/Statistics.x10"
        final double t$35051 = plham.util.Statistics.sum__0$1x10$lang$Double$2$O(((a)));
        
        //#line 31 "/home/dsl/workspace/plhamK/plham/util/Statistics.x10"
        final long t$35050 = ((x10.util.Container<x10.core.Double>)a).size$O();
        
        //#line 31 "/home/dsl/workspace/plhamK/plham/util/Statistics.x10"
        final double t$35052 = ((((t$35050))));
        
        //#line 31 "/home/dsl/workspace/plhamK/plham/util/Statistics.x10"
        final double t$35053 = ((t$35051) / (((t$35052))));
        
        //#line 31 "/home/dsl/workspace/plhamK/plham/util/Statistics.x10"
        return t$35053;
    }
    
    
    //#line 34 "/home/dsl/workspace/plhamK/plham/util/Statistics.x10"
    public static double variance__0$1x10$lang$Double$2$O(final x10.util.List<x10.core.Double> a) {
        
        //#line 35 "/home/dsl/workspace/plhamK/plham/util/Statistics.x10"
        final long t$35054 = ((x10.util.Container<x10.core.Double>)a).size$O();
        
        //#line 35 "/home/dsl/workspace/plhamK/plham/util/Statistics.x10"
        final boolean t$35055 = (t$35054) == (0L);
        
        //#line 35 "/home/dsl/workspace/plhamK/plham/util/Statistics.x10"
        if (t$35055) {
            
            //#line 35 "/home/dsl/workspace/plhamK/plham/util/Statistics.x10"
            return 0.0;
        }
        
        //#line 36 "/home/dsl/workspace/plhamK/plham/util/Statistics.x10"
        final double m = plham.util.Statistics.mean__0$1x10$lang$Double$2$O(((a)));
        
        //#line 37 "/home/dsl/workspace/plhamK/plham/util/Statistics.x10"
        final double t$35057 = plham.util.Statistics.sumofsquares__0$1x10$lang$Double$2$O(((a)));
        
        //#line 37 "/home/dsl/workspace/plhamK/plham/util/Statistics.x10"
        final long t$35056 = ((x10.util.Container<x10.core.Double>)a).size$O();
        
        //#line 37 "/home/dsl/workspace/plhamK/plham/util/Statistics.x10"
        final double t$35058 = ((((t$35056))));
        
        //#line 37 "/home/dsl/workspace/plhamK/plham/util/Statistics.x10"
        final double t$35059 = ((t$35057) / (((t$35058))));
        
        //#line 37 "/home/dsl/workspace/plhamK/plham/util/Statistics.x10"
        final double t$35060 = ((m) * (((m))));
        
        //#line 37 "/home/dsl/workspace/plhamK/plham/util/Statistics.x10"
        final double t$35061 = ((t$35059) - (((t$35060))));
        
        //#line 37 "/home/dsl/workspace/plhamK/plham/util/Statistics.x10"
        return t$35061;
    }
    
    
    //#line 40 "/home/dsl/workspace/plhamK/plham/util/Statistics.x10"
    public static double covariance__0$1x10$lang$Double$2__1$1x10$lang$Double$2$O(final x10.util.List<x10.core.Double> a, final x10.util.List<x10.core.Double> b) {
        
        //#line 41 "/home/dsl/workspace/plhamK/plham/util/Statistics.x10"
        final long t$35062 = ((x10.util.Container<x10.core.Double>)a).size$O();
        
        //#line 41 "/home/dsl/workspace/plhamK/plham/util/Statistics.x10"
        final boolean t$35063 = (t$35062) == (0L);
        
        //#line 41 "/home/dsl/workspace/plhamK/plham/util/Statistics.x10"
        if (t$35063) {
            
            //#line 41 "/home/dsl/workspace/plhamK/plham/util/Statistics.x10"
            return 0.0;
        }
        
        //#line 42 "/home/dsl/workspace/plhamK/plham/util/Statistics.x10"
        final double t$35065 = plham.util.Statistics.sumofproducts__0$1x10$lang$Double$2__1$1x10$lang$Double$2$O(((a)), ((b)));
        
        //#line 42 "/home/dsl/workspace/plhamK/plham/util/Statistics.x10"
        final long t$35064 = ((x10.util.Container<x10.core.Double>)a).size$O();
        
        //#line 42 "/home/dsl/workspace/plhamK/plham/util/Statistics.x10"
        final double t$35066 = ((((t$35064))));
        
        //#line 42 "/home/dsl/workspace/plhamK/plham/util/Statistics.x10"
        final double t$35069 = ((t$35065) / (((t$35066))));
        
        //#line 42 "/home/dsl/workspace/plhamK/plham/util/Statistics.x10"
        final double t$35067 = plham.util.Statistics.mean__0$1x10$lang$Double$2$O(((a)));
        
        //#line 42 "/home/dsl/workspace/plhamK/plham/util/Statistics.x10"
        final double t$35068 = plham.util.Statistics.mean__0$1x10$lang$Double$2$O(((b)));
        
        //#line 42 "/home/dsl/workspace/plhamK/plham/util/Statistics.x10"
        final double t$35070 = ((t$35067) * (((t$35068))));
        
        //#line 42 "/home/dsl/workspace/plhamK/plham/util/Statistics.x10"
        final double t$35071 = ((t$35069) - (((t$35070))));
        
        //#line 42 "/home/dsl/workspace/plhamK/plham/util/Statistics.x10"
        return t$35071;
    }
    
    
    //#line 45 "/home/dsl/workspace/plhamK/plham/util/Statistics.x10"
    public static double corrcoef__0$1x10$lang$Double$2__1$1x10$lang$Double$2$O(final x10.util.List<x10.core.Double> a, final x10.util.List<x10.core.Double> b) {
        
        //#line 46 "/home/dsl/workspace/plhamK/plham/util/Statistics.x10"
        final double t$35076 = plham.util.Statistics.covariance__0$1x10$lang$Double$2__1$1x10$lang$Double$2$O(((a)), ((b)));
        
        //#line 46 "/home/dsl/workspace/plhamK/plham/util/Statistics.x10"
        final double t$35072 = plham.util.Statistics.variance__0$1x10$lang$Double$2$O(((a)));
        
        //#line 46 "/home/dsl/workspace/plhamK/plham/util/Statistics.x10"
        final double t$35074 = java.lang.Math.sqrt(((t$35072)));
        
        //#line 46 "/home/dsl/workspace/plhamK/plham/util/Statistics.x10"
        final double t$35073 = plham.util.Statistics.variance__0$1x10$lang$Double$2$O(((b)));
        
        //#line 46 "/home/dsl/workspace/plhamK/plham/util/Statistics.x10"
        final double t$35075 = java.lang.Math.sqrt(((t$35073)));
        
        //#line 46 "/home/dsl/workspace/plhamK/plham/util/Statistics.x10"
        final double t$35077 = ((t$35074) * (((t$35075))));
        
        //#line 46 "/home/dsl/workspace/plhamK/plham/util/Statistics.x10"
        final double t$35078 = ((t$35076) / (((t$35077))));
        
        //#line 46 "/home/dsl/workspace/plhamK/plham/util/Statistics.x10"
        return t$35078;
    }
    
    
    //#line 49 "/home/dsl/workspace/plhamK/plham/util/Statistics.x10"
    public static double regcoef__0$1x10$lang$Double$2__1$1x10$lang$Double$2$O(final x10.util.List<x10.core.Double> x, final x10.util.List<x10.core.Double> y) {
        
        //#line 50 "/home/dsl/workspace/plhamK/plham/util/Statistics.x10"
        final double t$35079 = plham.util.Statistics.covariance__0$1x10$lang$Double$2__1$1x10$lang$Double$2$O(((x)), ((y)));
        
        //#line 50 "/home/dsl/workspace/plhamK/plham/util/Statistics.x10"
        final double t$35080 = plham.util.Statistics.variance__0$1x10$lang$Double$2$O(((x)));
        
        //#line 50 "/home/dsl/workspace/plhamK/plham/util/Statistics.x10"
        final double t$35081 = ((t$35079) / (((t$35080))));
        
        //#line 50 "/home/dsl/workspace/plhamK/plham/util/Statistics.x10"
        return t$35081;
    }
    
    
    //#line 56 "/home/dsl/workspace/plhamK/plham/util/Statistics.x10"
    /**
	 * NOTE: Replace its elements in place; do NOT create its elements.
	 */
    public static x10.util.List map__0$1x10$lang$Double$2__1$1x10$lang$Double$3x10$lang$Double$2(final x10.util.List<x10.core.Double> a, final x10.core.fun.Fun_0_1<x10.core.Double,x10.core.Double> f) {
        
        //#line 57 "/home/dsl/workspace/plhamK/plham/util/Statistics.x10"
        final long i$34972min$35169 = 0L;
        
        //#line 57 "/home/dsl/workspace/plhamK/plham/util/Statistics.x10"
        final long t$35170 = ((x10.util.Container<x10.core.Double>)a).size$O();
        
        //#line 57 "/home/dsl/workspace/plhamK/plham/util/Statistics.x10"
        final long i$34972max$35171 = ((t$35170) - (((1L))));
        
        //#line 57 "/home/dsl/workspace/plhamK/plham/util/Statistics.x10"
        long i$35166 = i$34972min$35169;
        
        //#line 57 "/home/dsl/workspace/plhamK/plham/util/Statistics.x10"
        for (;
             true;
             ) {
            
            //#line 57 "/home/dsl/workspace/plhamK/plham/util/Statistics.x10"
            final long t$35167 = i$35166;
            
            //#line 57 "/home/dsl/workspace/plhamK/plham/util/Statistics.x10"
            final boolean t$35168 = ((t$35167) <= (((i$34972max$35171))));
            
            //#line 57 "/home/dsl/workspace/plhamK/plham/util/Statistics.x10"
            if (!(t$35168)) {
                
                //#line 57 "/home/dsl/workspace/plhamK/plham/util/Statistics.x10"
                break;
            }
            
            //#line 57 "/home/dsl/workspace/plhamK/plham/util/Statistics.x10"
            final long i$35163 = i$35166;
            
            //#line 58 "/home/dsl/workspace/plhamK/plham/util/Statistics.x10"
            final double t$35161 = x10.core.Double.$unbox(((x10.util.Indexed<x10.core.Double>)a).$apply$G((i$35163)));
            
            //#line 58 "/home/dsl/workspace/plhamK/plham/util/Statistics.x10"
            final double t$35162 = x10.core.Double.$unbox(f.$apply(x10.core.Double.$box(t$35161), x10.rtt.Types.DOUBLE));
            
            //#line 58 "/home/dsl/workspace/plhamK/plham/util/Statistics.x10"
            ((x10.lang.Settable<x10.core.Long, x10.core.Double>)a).$set(x10.core.Long.$box(i$35163), x10.rtt.Types.LONG, x10.core.Double.$box(t$35162), x10.rtt.Types.DOUBLE);
            
            //#line 57 "/home/dsl/workspace/plhamK/plham/util/Statistics.x10"
            final long t$35164 = i$35166;
            
            //#line 57 "/home/dsl/workspace/plhamK/plham/util/Statistics.x10"
            final long t$35165 = ((t$35164) + (((1L))));
            
            //#line 57 "/home/dsl/workspace/plhamK/plham/util/Statistics.x10"
            i$35166 = t$35165;
        }
        
        //#line 60 "/home/dsl/workspace/plhamK/plham/util/Statistics.x10"
        return a;
    }
    
    
    //#line 63 "/home/dsl/workspace/plhamK/plham/util/Statistics.x10"
    public static x10.util.List log__0$1x10$lang$Double$2(final x10.util.List<x10.core.Double> a) {
        
        //#line 64 "/home/dsl/workspace/plhamK/plham/util/Statistics.x10"
        final x10.core.fun.Fun_0_1 t$35091 = ((new plham.util.Statistics.$Closure$28()));
        
        //#line 64 "/home/dsl/workspace/plhamK/plham/util/Statistics.x10"
        final x10.util.List t$35092 = plham.util.Statistics.map__0$1x10$lang$Double$2__1$1x10$lang$Double$3x10$lang$Double$2(((a)), ((t$35091)));
        
        //#line 64 "/home/dsl/workspace/plhamK/plham/util/Statistics.x10"
        return t$35092;
    }
    
    
    //#line 67 "/home/dsl/workspace/plhamK/plham/util/Statistics.x10"
    public static x10.util.List exp__0$1x10$lang$Double$2(final x10.util.List<x10.core.Double> a) {
        
        //#line 68 "/home/dsl/workspace/plhamK/plham/util/Statistics.x10"
        final x10.core.fun.Fun_0_1 t$35094 = ((new plham.util.Statistics.$Closure$29()));
        
        //#line 68 "/home/dsl/workspace/plhamK/plham/util/Statistics.x10"
        final x10.util.List t$35095 = plham.util.Statistics.map__0$1x10$lang$Double$2__1$1x10$lang$Double$3x10$lang$Double$2(((a)), ((t$35094)));
        
        //#line 68 "/home/dsl/workspace/plhamK/plham/util/Statistics.x10"
        return t$35095;
    }
    
    
    //#line 71 "/home/dsl/workspace/plhamK/plham/util/Statistics.x10"
    public static long roulette__1$1x10$lang$Double$2$O(final x10.util.Random random, final x10.util.List<x10.core.Double> weights) {
        
        //#line 73 "/home/dsl/workspace/plhamK/plham/util/Statistics.x10"
        final long size = ((x10.util.Container<x10.core.Double>)weights).size$O();
        
        //#line 74 "/home/dsl/workspace/plhamK/plham/util/Statistics.x10"
        double total = 0.0;
        
        //#line 75 "/home/dsl/workspace/plhamK/plham/util/Statistics.x10"
        final long i$34990min$35192 = 0L;
        
        //#line 75 "/home/dsl/workspace/plhamK/plham/util/Statistics.x10"
        final long i$34990max$35193 = ((size) - (((1L))));
        
        //#line 75 "/home/dsl/workspace/plhamK/plham/util/Statistics.x10"
        long i$35178 = i$34990min$35192;
        
        //#line 75 "/home/dsl/workspace/plhamK/plham/util/Statistics.x10"
        for (;
             true;
             ) {
            
            //#line 75 "/home/dsl/workspace/plhamK/plham/util/Statistics.x10"
            final long t$35179 = i$35178;
            
            //#line 75 "/home/dsl/workspace/plhamK/plham/util/Statistics.x10"
            final boolean t$35180 = ((t$35179) <= (((i$34990max$35193))));
            
            //#line 75 "/home/dsl/workspace/plhamK/plham/util/Statistics.x10"
            if (!(t$35180)) {
                
                //#line 75 "/home/dsl/workspace/plhamK/plham/util/Statistics.x10"
                break;
            }
            
            //#line 75 "/home/dsl/workspace/plhamK/plham/util/Statistics.x10"
            final long i$35175 = i$35178;
            
            //#line 76 "/home/dsl/workspace/plhamK/plham/util/Statistics.x10"
            final double t$35172 = total;
            
            //#line 76 "/home/dsl/workspace/plhamK/plham/util/Statistics.x10"
            final double t$35173 = x10.core.Double.$unbox(((x10.util.Indexed<x10.core.Double>)weights).$apply$G((i$35175)));
            
            //#line 76 "/home/dsl/workspace/plhamK/plham/util/Statistics.x10"
            final double t$35174 = ((t$35172) + (((t$35173))));
            
            //#line 76 "/home/dsl/workspace/plhamK/plham/util/Statistics.x10"
            total = t$35174;
            
            //#line 75 "/home/dsl/workspace/plhamK/plham/util/Statistics.x10"
            final long t$35176 = i$35178;
            
            //#line 75 "/home/dsl/workspace/plhamK/plham/util/Statistics.x10"
            final long t$35177 = ((t$35176) + (((1L))));
            
            //#line 75 "/home/dsl/workspace/plhamK/plham/util/Statistics.x10"
            i$35178 = t$35177;
        }
        
        //#line 78 "/home/dsl/workspace/plhamK/plham/util/Statistics.x10"
        final double t$35104 = total;
        
        //#line 78 "/home/dsl/workspace/plhamK/plham/util/Statistics.x10"
        final double t$35105 = random.nextDouble$O();
        
        //#line 78 "/home/dsl/workspace/plhamK/plham/util/Statistics.x10"
        final double d = ((t$35104) * (((t$35105))));
        
        //#line 79 "/home/dsl/workspace/plhamK/plham/util/Statistics.x10"
        double w = 0.0;
        
        //#line 80 "/home/dsl/workspace/plhamK/plham/util/Statistics.x10"
        final long i$35008min$35194 = 0L;
        
        //#line 80 "/home/dsl/workspace/plhamK/plham/util/Statistics.x10"
        final long i$35008max$35195 = ((size) - (((1L))));
        
        //#line 80 "/home/dsl/workspace/plhamK/plham/util/Statistics.x10"
        long i$35189 = i$35008min$35194;
        
        //#line 80 "/home/dsl/workspace/plhamK/plham/util/Statistics.x10"
        for (;
             true;
             ) {
            
            //#line 80 "/home/dsl/workspace/plhamK/plham/util/Statistics.x10"
            final long t$35190 = i$35189;
            
            //#line 80 "/home/dsl/workspace/plhamK/plham/util/Statistics.x10"
            final boolean t$35191 = ((t$35190) <= (((i$35008max$35195))));
            
            //#line 80 "/home/dsl/workspace/plhamK/plham/util/Statistics.x10"
            if (!(t$35191)) {
                
                //#line 80 "/home/dsl/workspace/plhamK/plham/util/Statistics.x10"
                break;
            }
            
            //#line 80 "/home/dsl/workspace/plhamK/plham/util/Statistics.x10"
            final long i$35186 = i$35189;
            
            //#line 81 "/home/dsl/workspace/plhamK/plham/util/Statistics.x10"
            final double t$35181 = w;
            
            //#line 81 "/home/dsl/workspace/plhamK/plham/util/Statistics.x10"
            final double t$35182 = x10.core.Double.$unbox(((x10.util.Indexed<x10.core.Double>)weights).$apply$G((i$35186)));
            
            //#line 81 "/home/dsl/workspace/plhamK/plham/util/Statistics.x10"
            final double t$35183 = ((t$35181) + (((t$35182))));
            
            //#line 81 "/home/dsl/workspace/plhamK/plham/util/Statistics.x10"
            w = t$35183;
            
            //#line 82 "/home/dsl/workspace/plhamK/plham/util/Statistics.x10"
            final double t$35184 = w;
            
            //#line 82 "/home/dsl/workspace/plhamK/plham/util/Statistics.x10"
            final boolean t$35185 = ((d) <= (((t$35184))));
            
            //#line 82 "/home/dsl/workspace/plhamK/plham/util/Statistics.x10"
            if (t$35185) {
                
                //#line 83 "/home/dsl/workspace/plhamK/plham/util/Statistics.x10"
                return i$35186;
            }
            
            //#line 80 "/home/dsl/workspace/plhamK/plham/util/Statistics.x10"
            final long t$35187 = i$35189;
            
            //#line 80 "/home/dsl/workspace/plhamK/plham/util/Statistics.x10"
            final long t$35188 = ((t$35187) + (((1L))));
            
            //#line 80 "/home/dsl/workspace/plhamK/plham/util/Statistics.x10"
            i$35189 = t$35188;
        }
        
        //#line 86 "/home/dsl/workspace/plhamK/plham/util/Statistics.x10"
        final long t$35116 = ((size) - (((1L))));
        
        //#line 86 "/home/dsl/workspace/plhamK/plham/util/Statistics.x10"
        return t$35116;
    }
    
    
    //#line 89 "/home/dsl/workspace/plhamK/plham/util/Statistics.x10"
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
            Statistics.main(args);
        }
    }
    
    // the original app-main method
    public static void main(final x10.core.Rail<java.lang.String> args) {
        
        //#line 90 "/home/dsl/workspace/plhamK/plham/util/Statistics.x10"
        final x10.util.ArrayList a = ((new x10.util.ArrayList<x10.core.Double>((java.lang.System[]) null, x10.rtt.Types.DOUBLE).x10$util$ArrayList$$init$S()));
        
        //#line 91 "/home/dsl/workspace/plhamK/plham/util/Statistics.x10"
        ((x10.util.ArrayList<x10.core.Double>)a).add__0x10$util$ArrayList$$T$O(x10.core.Double.$box(1.0));
        
        //#line 92 "/home/dsl/workspace/plhamK/plham/util/Statistics.x10"
        ((x10.util.ArrayList<x10.core.Double>)a).add__0x10$util$ArrayList$$T$O(x10.core.Double.$box(2.0));
        
        //#line 93 "/home/dsl/workspace/plhamK/plham/util/Statistics.x10"
        ((x10.util.ArrayList<x10.core.Double>)a).add__0x10$util$ArrayList$$T$O(x10.core.Double.$box(3.0));
        
        //#line 94 "/home/dsl/workspace/plhamK/plham/util/Statistics.x10"
        ((x10.util.ArrayList<x10.core.Double>)a).add__0x10$util$ArrayList$$T$O(x10.core.Double.$box(4.0));
        
        //#line 95 "/home/dsl/workspace/plhamK/plham/util/Statistics.x10"
        ((x10.util.ArrayList<x10.core.Double>)a).add__0x10$util$ArrayList$$T$O(x10.core.Double.$box(5.0));
        
        //#line 96 "/home/dsl/workspace/plhamK/plham/util/Statistics.x10"
        final x10.io.Printer t$35117 = ((x10.io.Console.get$OUT()));
        
        //#line 96 "/home/dsl/workspace/plhamK/plham/util/Statistics.x10"
        t$35117.println(((a)));
        
        //#line 97 "/home/dsl/workspace/plhamK/plham/util/Statistics.x10"
        final x10.io.Printer t$35118 = ((x10.io.Console.get$OUT()));
        
        //#line 97 "/home/dsl/workspace/plhamK/plham/util/Statistics.x10"
        final x10.util.List t$35119 = plham.util.Statistics.log__0$1x10$lang$Double$2(((a)));
        
        //#line 97 "/home/dsl/workspace/plhamK/plham/util/Statistics.x10"
        t$35118.println(((t$35119)));
        
        //#line 98 "/home/dsl/workspace/plhamK/plham/util/Statistics.x10"
        final x10.io.Printer t$35120 = ((x10.io.Console.get$OUT()));
        
        //#line 98 "/home/dsl/workspace/plhamK/plham/util/Statistics.x10"
        final double t$35121 = plham.util.Statistics.sum__0$1x10$lang$Double$2$O(((a)));
        
        //#line 98 "/home/dsl/workspace/plhamK/plham/util/Statistics.x10"
        t$35120.println(x10.core.Double.$box(t$35121));
        
        //#line 99 "/home/dsl/workspace/plhamK/plham/util/Statistics.x10"
        final x10.io.Printer t$35124 = ((x10.io.Console.get$OUT()));
        
        //#line 99 "/home/dsl/workspace/plhamK/plham/util/Statistics.x10"
        final long t$35122 = ((x10.util.ArrayList<x10.core.Double>)a).size$O();
        
        //#line 99 "/home/dsl/workspace/plhamK/plham/util/Statistics.x10"
        final x10.util.List t$35123 = (((x10.util.ArrayList<x10.core.Double>)a).subList((0L), (t$35122)));
        
        //#line 99 "/home/dsl/workspace/plhamK/plham/util/Statistics.x10"
        final double t$35125 = plham.util.Statistics.sum__0$1x10$lang$Double$2$O(((t$35123)));
        
        //#line 99 "/home/dsl/workspace/plhamK/plham/util/Statistics.x10"
        t$35124.println(x10.core.Double.$box(t$35125));
        
        //#line 100 "/home/dsl/workspace/plhamK/plham/util/Statistics.x10"
        final x10.io.Printer t$35127 = ((x10.io.Console.get$OUT()));
        
        //#line 100 "/home/dsl/workspace/plhamK/plham/util/Statistics.x10"
        final x10.util.List t$35126 = (((x10.util.ArrayList<x10.core.Double>)a).subList((0L), (2L)));
        
        //#line 100 "/home/dsl/workspace/plhamK/plham/util/Statistics.x10"
        final double t$35128 = plham.util.Statistics.sum__0$1x10$lang$Double$2$O(((t$35126)));
        
        //#line 100 "/home/dsl/workspace/plhamK/plham/util/Statistics.x10"
        t$35127.println(x10.core.Double.$box(t$35128));
        
        //#line 101 "/home/dsl/workspace/plhamK/plham/util/Statistics.x10"
        final x10.io.Printer t$35129 = ((x10.io.Console.get$OUT()));
        
        //#line 101 "/home/dsl/workspace/plhamK/plham/util/Statistics.x10"
        final double t$35130 = plham.util.Statistics.sumofproducts__0$1x10$lang$Double$2__1$1x10$lang$Double$2$O(((a)), ((a)));
        
        //#line 101 "/home/dsl/workspace/plhamK/plham/util/Statistics.x10"
        t$35129.println(x10.core.Double.$box(t$35130));
        
        //#line 102 "/home/dsl/workspace/plhamK/plham/util/Statistics.x10"
        final x10.io.Printer t$35131 = ((x10.io.Console.get$OUT()));
        
        //#line 102 "/home/dsl/workspace/plhamK/plham/util/Statistics.x10"
        final double t$35132 = plham.util.Statistics.sumofsquares__0$1x10$lang$Double$2$O(((a)));
        
        //#line 102 "/home/dsl/workspace/plhamK/plham/util/Statistics.x10"
        t$35131.println(x10.core.Double.$box(t$35132));
        
        //#line 103 "/home/dsl/workspace/plhamK/plham/util/Statistics.x10"
        final x10.io.Printer t$35133 = ((x10.io.Console.get$OUT()));
        
        //#line 103 "/home/dsl/workspace/plhamK/plham/util/Statistics.x10"
        final double t$35134 = plham.util.Statistics.corrcoef__0$1x10$lang$Double$2__1$1x10$lang$Double$2$O(((a)), ((a)));
        
        //#line 103 "/home/dsl/workspace/plhamK/plham/util/Statistics.x10"
        t$35133.println(x10.core.Double.$box(t$35134));
    }
    
    
    //#line 6 "/home/dsl/workspace/plhamK/plham/util/Statistics.x10"
    final public plham.util.Statistics plham$util$Statistics$$this$plham$util$Statistics() {
        
        //#line 6 "/home/dsl/workspace/plhamK/plham/util/Statistics.x10"
        return plham.util.Statistics.this;
    }
    
    
    //#line 6 "/home/dsl/workspace/plhamK/plham/util/Statistics.x10"
    // creation method for java code (1-phase java constructor)
    public Statistics() {
        this((java.lang.System[]) null);
        plham$util$Statistics$$init$S();
    }
    
    // constructor for non-virtual call
    final public plham.util.Statistics plham$util$Statistics$$init$S() {
         {
            
            //#line 6 "/home/dsl/workspace/plhamK/plham/util/Statistics.x10"
            
            
            //#line 6 "/home/dsl/workspace/plhamK/plham/util/Statistics.x10"
            this.__fieldInitializers_plham_util_Statistics();
        }
        return this;
    }
    
    
    
    //#line 6 "/home/dsl/workspace/plhamK/plham/util/Statistics.x10"
    final public void __fieldInitializers_plham_util_Statistics() {
        
    }
    
    
    final public static class $Closure$28 extends x10.core.Ref implements x10.core.fun.Fun_0_1, x10.serialization.X10JavaSerializable
    {
        public static final x10.rtt.RuntimeType<$Closure$28> $RTT = 
            x10.rtt.StaticFunType.<$Closure$28> make($Closure$28.class,
                                                     new x10.rtt.Type[] {
                                                         x10.rtt.ParameterizedType.make(x10.core.fun.Fun_0_1.$RTT, x10.rtt.Types.DOUBLE, x10.rtt.Types.DOUBLE)
                                                     });
        
        public x10.rtt.RuntimeType<?> $getRTT() { return $RTT; }
        
        public x10.rtt.Type<?> $getParam(int i) { return null; }
        
        private Object writeReplace() throws java.io.ObjectStreamException {
            return new x10.serialization.SerializationProxy(this);
        }
        
        public static x10.serialization.X10JavaSerializable $_deserialize_body(plham.util.Statistics.$Closure$28 $_obj, x10.serialization.X10JavaDeserializer $deserializer) throws java.io.IOException {
            if (x10.runtime.impl.java.Runtime.TRACE_SER) { x10.runtime.impl.java.Runtime.printTraceMessage("X10JavaSerializable: $_deserialize_body() of " + $Closure$28.class + " calling"); } 
            return $_obj;
        }
        
        public static x10.serialization.X10JavaSerializable $_deserializer(x10.serialization.X10JavaDeserializer $deserializer) throws java.io.IOException {
            plham.util.Statistics.$Closure$28 $_obj = new plham.util.Statistics.$Closure$28((java.lang.System[]) null);
            $deserializer.record_reference($_obj);
            return $_deserialize_body($_obj, $deserializer);
        }
        
        public void $_serialize(x10.serialization.X10JavaSerializer $serializer) throws java.io.IOException {
            
        }
        
        // constructor just for allocation
        public $Closure$28(final java.lang.System[] $dummy) {
            
        }
        
        // dispatcher for method abstract public (Z1)=>U.operator()(a1:Z1):U
        public java.lang.Object $apply(final java.lang.Object a1, final x10.rtt.Type t1) {
            return x10.core.Double.$box($apply$O(x10.core.Double.$unbox(a1)));
            
        }
        
        // dispatcher for method abstract public (Z1)=>U.operator()(a1:Z1):U
        public double $apply$D(final java.lang.Object a1, final x10.rtt.Type t1) {
            return $apply$O(x10.core.Double.$unbox(a1));
            
        }
        
        
    
        
        public double $apply$O(final double x) {
            
            //#line 64 "/home/dsl/workspace/plhamK/plham/util/Statistics.x10"
            final double t$35090 = java.lang.Math.log(((x)));
            
            //#line 64 "/home/dsl/workspace/plhamK/plham/util/Statistics.x10"
            return t$35090;
        }
        
        public $Closure$28() {
             {
                
            }
        }
        
    }
    
    
    final public static class $Closure$29 extends x10.core.Ref implements x10.core.fun.Fun_0_1, x10.serialization.X10JavaSerializable
    {
        public static final x10.rtt.RuntimeType<$Closure$29> $RTT = 
            x10.rtt.StaticFunType.<$Closure$29> make($Closure$29.class,
                                                     new x10.rtt.Type[] {
                                                         x10.rtt.ParameterizedType.make(x10.core.fun.Fun_0_1.$RTT, x10.rtt.Types.DOUBLE, x10.rtt.Types.DOUBLE)
                                                     });
        
        public x10.rtt.RuntimeType<?> $getRTT() { return $RTT; }
        
        public x10.rtt.Type<?> $getParam(int i) { return null; }
        
        private Object writeReplace() throws java.io.ObjectStreamException {
            return new x10.serialization.SerializationProxy(this);
        }
        
        public static x10.serialization.X10JavaSerializable $_deserialize_body(plham.util.Statistics.$Closure$29 $_obj, x10.serialization.X10JavaDeserializer $deserializer) throws java.io.IOException {
            if (x10.runtime.impl.java.Runtime.TRACE_SER) { x10.runtime.impl.java.Runtime.printTraceMessage("X10JavaSerializable: $_deserialize_body() of " + $Closure$29.class + " calling"); } 
            return $_obj;
        }
        
        public static x10.serialization.X10JavaSerializable $_deserializer(x10.serialization.X10JavaDeserializer $deserializer) throws java.io.IOException {
            plham.util.Statistics.$Closure$29 $_obj = new plham.util.Statistics.$Closure$29((java.lang.System[]) null);
            $deserializer.record_reference($_obj);
            return $_deserialize_body($_obj, $deserializer);
        }
        
        public void $_serialize(x10.serialization.X10JavaSerializer $serializer) throws java.io.IOException {
            
        }
        
        // constructor just for allocation
        public $Closure$29(final java.lang.System[] $dummy) {
            
        }
        
        // dispatcher for method abstract public (Z1)=>U.operator()(a1:Z1):U
        public java.lang.Object $apply(final java.lang.Object a1, final x10.rtt.Type t1) {
            return x10.core.Double.$box($apply$O(x10.core.Double.$unbox(a1)));
            
        }
        
        // dispatcher for method abstract public (Z1)=>U.operator()(a1:Z1):U
        public double $apply$D(final java.lang.Object a1, final x10.rtt.Type t1) {
            return $apply$O(x10.core.Double.$unbox(a1));
            
        }
        
        
    
        
        public double $apply$O(final double x) {
            
            //#line 68 "/home/dsl/workspace/plhamK/plham/util/Statistics.x10"
            final double t$35093 = java.lang.Math.exp(((x)));
            
            //#line 68 "/home/dsl/workspace/plhamK/plham/util/Statistics.x10"
            return t$35093;
        }
        
        public $Closure$29() {
             {
                
            }
        }
        
    }
    
}

