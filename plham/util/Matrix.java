package plham.util;



public class Matrix extends x10.core.Ref implements x10.serialization.X10JavaSerializable
{
    public static final x10.rtt.RuntimeType<Matrix> $RTT = 
        x10.rtt.NamedType.<Matrix> make("plham.util.Matrix",
                                        Matrix.class);
    
    public x10.rtt.RuntimeType<?> $getRTT() { return $RTT; }
    
    public x10.rtt.Type<?> $getParam(int i) { return null; }
    
    private Object writeReplace() throws java.io.ObjectStreamException {
        return new x10.serialization.SerializationProxy(this);
    }
    
    public static x10.serialization.X10JavaSerializable $_deserialize_body(plham.util.Matrix $_obj, x10.serialization.X10JavaDeserializer $deserializer) throws java.io.IOException {
        if (x10.runtime.impl.java.Runtime.TRACE_SER) { x10.runtime.impl.java.Runtime.printTraceMessage("X10JavaSerializable: $_deserialize_body() of " + Matrix.class + " calling"); } 
        return $_obj;
    }
    
    public static x10.serialization.X10JavaSerializable $_deserializer(x10.serialization.X10JavaDeserializer $deserializer) throws java.io.IOException {
        plham.util.Matrix $_obj = new plham.util.Matrix((java.lang.System[]) null);
        $deserializer.record_reference($_obj);
        return $_deserialize_body($_obj, $deserializer);
    }
    
    public void $_serialize(x10.serialization.X10JavaSerializer $serializer) throws java.io.IOException {
        
    }
    
    // constructor just for allocation
    public Matrix(final java.lang.System[] $dummy) {
        
    }
    
    

    
    //#line 7 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
    final public static double epsilon = 1.0E-6;
    
    //#line 8 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
    final public static double epsilon2 = 1.0E-6;
    
    //#line 9 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
    final public static double epsilon3 = 0.01;
    
    //#line 10 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
    private static long maxPositionSize = 0L;
    
    //#line 11 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
    final public static long index = 31L;
    
    //#line 12 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
    final public static long DEBUG = 0L;
    
    
    //#line 15 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
    public static x10.core.Rail ActiveSetMethod__0$1x10$lang$Rail$1x10$lang$Double$2$2__1$1x10$lang$Double$2__2$1x10$lang$Rail$1x10$lang$Double$2$2__3$1x10$lang$Double$2__4$1x10$lang$Double$2(final x10.core.Rail<x10.core.Rail<x10.core.Double>> A2, final x10.core.Rail<x10.core.Double> B2, final x10.core.Rail<x10.core.Rail<x10.core.Double>> Q2, final x10.core.Rail<x10.core.Double> C2, final x10.core.Rail<x10.core.Double> initialValue) {
        
        //#line 20 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        final long t$46528 = plham.util.Matrix.index;
        
        //#line 20 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        x10.core.Rail A = plham.util.Matrix.round__0$1x10$lang$Rail$1x10$lang$Double$2$2(((A2)), (t$46528));
        
        //#line 21 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        final long t$46529 = plham.util.Matrix.index;
        
        //#line 21 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        x10.core.Rail B = plham.util.Matrix.round__0$1x10$lang$Double$2(((B2)), (t$46529));
        
        //#line 22 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        final long t$46530 = plham.util.Matrix.index;
        
        //#line 22 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        x10.core.Rail Q = plham.util.Matrix.round__0$1x10$lang$Rail$1x10$lang$Double$2$2(((Q2)), (t$46530));
        
        //#line 23 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        final long t$46531 = plham.util.Matrix.index;
        
        //#line 23 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        x10.core.Rail C = plham.util.Matrix.round__0$1x10$lang$Double$2(((C2)), (t$46531));
        
        //#line 24 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        assert plham.util.Matrix.checkInitialASM__0$1x10$lang$Rail$1x10$lang$Double$2$2__1$1x10$lang$Double$2__2$1x10$lang$Double$2$O(((A)), ((B)), ((initialValue))): "initialValueError";
        
        //#line 25 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        x10.core.Rail out = initialValue;
        
        //#line 26 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        final long t$46532 = initialValue.size;
        
        //#line 26 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        x10.core.Rail lastOut = new x10.core.Rail<x10.core.Double>(x10.rtt.Types.DOUBLE, ((t$46532)));
        
        //#line 27 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        x10.core.Rail kenzan =  null;
        
        //#line 28 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        long s = 0L;
        
        //#line 29 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        final x10.core.Rail t$46533 = ((A));
        
        //#line 29 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        final x10.core.Rail t$46534 = ((B));
        
        //#line 29 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        x10.core.Rail activeCheck = plham.util.Matrix.activeCheck__0$1x10$lang$Rail$1x10$lang$Double$2$2__1$1x10$lang$Double$2__2$1x10$lang$Double$2(((t$46533)), ((t$46534)), ((initialValue)));
        
        //#line 30 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        long f = 0L;
        
        //#line 31 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        long t = -1L;
        
        //#line 32 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        boolean repeat = true;
        
        //#line 33 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        final x10.core.Rail t$46535 = ((out));
        
        //#line 33 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        final long t$46536 = ((x10.core.Rail<x10.core.Double>)t$46535).size;
        
        //#line 33 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        x10.core.Rail tout = new x10.core.Rail<x10.core.Double>(x10.rtt.Types.DOUBLE, t$46536);
        
        //#line 35 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        final x10.core.Rail t$46537 = ((Q));
        
        //#line 35 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        final x10.core.Rail t$46538 = plham.util.Matrix.decompose__0$1x10$lang$Rail$1x10$lang$Double$2$2(((t$46537)));
        
        //#line 35 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        final x10.core.Rail t$46539 = ((C));
        
        //#line 35 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        final x10.core.Rail t$46540 = plham.util.Matrix.luSolver__0$1x10$lang$Rail$1x10$lang$Double$2$2__1$1x10$lang$Double$2(((t$46538)), ((t$46539)));
        
        //#line 35 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        tout = ((t$46540));
        
        //#line 36 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        boolean t$49242 = false;
        
        //#line 36 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        do  {
            
            //#line 38 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            final long t$48981 = t;
            
            //#line 38 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            final boolean t$48982 = (t$48981) == (-1L);
            
            //#line 38 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            if (t$48982) {
                
                //#line 39 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final x10.core.Rail t$48983 = ((activeCheck));
                
                //#line 39 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final x10.core.Rail t$48984 = ((A));
                
                //#line 39 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final x10.core.Rail t$48985 = ((B));
                
                //#line 39 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final x10.core.Rail t$48986 = ((out));
                
                //#line 39 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                plham.util.Matrix.setActiveCheck__0$1x10$lang$Boolean$2__1$1x10$lang$Rail$1x10$lang$Double$2$2__2$1x10$lang$Double$2__3$1x10$lang$Double$2(((t$48983)), ((t$48984)), ((t$48985)), ((t$48986)));
            } else {
                
                //#line 42 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final x10.core.Rail t$48987 = ((activeCheck));
                
                //#line 42 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long t$48988 = t;
                
                //#line 42 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                ((boolean[])t$48987.value)[(int)t$48988] = false;
            }
            
            //#line 44 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            final x10.core.Rail t$48989 = ((activeCheck));
            
            //#line 44 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            final long t$48990 = plham.util.Matrix.countActive__0$1x10$lang$Boolean$2$O(((t$48989)));
            
            //#line 44 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            s = t$48990;
            
            //#line 45 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            final x10.core.Rail t$48991 = ((activeCheck));
            
            //#line 45 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            final x10.core.Rail t$48992 = ((A));
            
            //#line 45 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            x10.core.Rail smallA$48993 = plham.util.Matrix.getSmall__0$1x10$lang$Boolean$2__1$1x10$lang$Rail$1x10$lang$Double$2$2(((t$48991)), ((t$48992)));
            
            //#line 46 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            final x10.core.Rail t$48994 = ((activeCheck));
            
            //#line 46 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            final x10.core.Rail t$48995 = ((B));
            
            //#line 46 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            x10.core.Rail smallB$48996 = plham.util.Matrix.getSmall__0$1x10$lang$Boolean$2__1$1x10$lang$Double$2(((t$48994)), ((t$48995)));
            
            //#line 54 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            final x10.core.Rail t$48997 = ((smallA$48993));
            
            //#line 54 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            final long t$48998 = plham.util.Matrix.index;
            
            //#line 54 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            final x10.core.Rail t$48999 = plham.util.Matrix.round__0$1x10$lang$Rail$1x10$lang$Double$2$2(((t$48997)), (t$48998));
            
            //#line 54 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            smallA$48993 = ((t$48999));
            
            //#line 55 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            final x10.core.Rail t$49000 = ((smallB$48996));
            
            //#line 55 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            final long t$49001 = plham.util.Matrix.index;
            
            //#line 55 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            final x10.core.Rail t$49002 = plham.util.Matrix.round__0$1x10$lang$Double$2(((t$49000)), (t$49001));
            
            //#line 55 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            smallB$48996 = ((t$49002));
            
            //#line 58 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            final x10.core.Rail t$49003 = ((smallA$48993));
            
            //#line 58 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            final x10.core.Rail t$49004 = ((Q));
            
            //#line 58 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            x10.core.Rail mat$49005 = plham.util.Matrix.getMat__0$1x10$lang$Rail$1x10$lang$Double$2$2__1$1x10$lang$Rail$1x10$lang$Double$2$2(((t$49003)), ((t$49004)));
            
            //#line 59 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            final x10.core.Rail t$49006 = ((smallB$48996));
            
            //#line 59 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            final x10.core.Rail t$49007 = ((C));
            
            //#line 59 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            x10.core.Rail right$49008 = plham.util.Matrix.getRight__0$1x10$lang$Double$2__1$1x10$lang$Double$2(((t$49006)), ((t$49007)));
            
            //#line 61 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            final x10.core.Rail t$49009 = ((mat$49005));
            
            //#line 61 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            final long t$49010 = plham.util.Matrix.index;
            
            //#line 61 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            final x10.core.Rail t$49011 = plham.util.Matrix.round__0$1x10$lang$Rail$1x10$lang$Double$2$2(((t$49009)), (t$49010));
            
            //#line 61 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            mat$49005 = ((t$49011));
            
            //#line 62 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            final x10.core.Rail t$49012 = ((right$49008));
            
            //#line 62 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            final long t$49013 = plham.util.Matrix.index;
            
            //#line 62 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            final x10.core.Rail t$49014 = plham.util.Matrix.round__0$1x10$lang$Double$2(((t$49012)), (t$49013));
            
            //#line 62 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            right$49008 = ((t$49014));
            
            //#line 64 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            final x10.core.Rail t$49015 = ((mat$49005));
            
            //#line 64 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            final x10.core.Rail t$49016 = ((right$49008));
            
            //#line 64 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            x10.core.Rail ex$49017 = plham.util.Matrix.ExpansionCoefficientMatrix__0$1x10$lang$Rail$1x10$lang$Double$2$2__1$1x10$lang$Double$2(((t$49015)), ((t$49016)));
            
            //#line 65 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            final x10.core.Rail t$49018 = ((ex$49017));
            
            //#line 65 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            x10.core.Rail echelon$49019 = plham.util.Matrix.echelonForm2__0$1x10$lang$Rail$1x10$lang$Double$2$2(((t$49018)));
            
            //#line 66 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            final x10.core.Rail t$49020 = ((mat$49005));
            
            //#line 66 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            x10.core.Rail echelon$49021 = plham.util.Matrix.echelonForm2__0$1x10$lang$Rail$1x10$lang$Double$2$2(((t$49020)));
            
            //#line 69 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            final x10.core.Rail t$49022 = ((ex$49017));
            
            //#line 69 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            final long t$49023 = plham.util.Matrix.index;
            
            //#line 69 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            final x10.core.Rail t$49024 = plham.util.Matrix.round__0$1x10$lang$Rail$1x10$lang$Double$2$2(((t$49022)), (t$49023));
            
            //#line 69 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            ex$49017 = ((t$49024));
            
            //#line 70 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            final x10.core.Rail t$49025 = ((echelon$49019));
            
            //#line 70 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            final long t$49026 = plham.util.Matrix.index;
            
            //#line 70 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            final x10.core.Rail t$49027 = plham.util.Matrix.round__0$1x10$lang$Rail$1x10$lang$Double$2$2(((t$49025)), (t$49026));
            
            //#line 70 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            echelon$49019 = ((x10.core.Rail)(t$49027));
            
            //#line 71 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            final x10.core.Rail t$49028 = ((x10.core.Rail)(echelon$49021));
            
            //#line 71 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            final long t$49029 = plham.util.Matrix.index;
            
            //#line 71 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            final x10.core.Rail t$49030 = plham.util.Matrix.round__0$1x10$lang$Rail$1x10$lang$Double$2$2(((x10.core.Rail)(t$49028)), (long)(t$49029));
            
            //#line 71 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            echelon$49021 = ((x10.core.Rail)(t$49030));
            
            //#line 74 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            x10.core.Rail echelon$49031 =  null;
            
            //#line 75 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            final x10.core.Rail t$49032 = ((x10.core.Rail)(smallB$48996));
            
            //#line 75 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            final long t$49033 = ((x10.core.Rail<x10.core.Double>)t$49032).size;
            
            //#line 75 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            final boolean t$49034 = ((long) t$49033) != ((long) 0L);
            
            //#line 75 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            if (t$49034) {
                
                //#line 76 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final x10.core.Rail t$49035 = ((x10.core.Rail)(smallA$48993));
                
                //#line 76 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final x10.core.Rail t$49036 = ((x10.core.Rail)(smallB$48996));
                
                //#line 76 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                x10.core.Rail smallC$49037 = plham.util.Matrix.ExpansionCoefficientMatrix__0$1x10$lang$Rail$1x10$lang$Double$2$2__1$1x10$lang$Double$2(((x10.core.Rail)(t$49035)), ((x10.core.Rail)(t$49036)));
                
                //#line 77 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final x10.core.Rail t$49038 = ((x10.core.Rail)(smallC$49037));
                
                //#line 77 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long t$49039 = plham.util.Matrix.index;
                
                //#line 77 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final x10.core.Rail t$49040 = plham.util.Matrix.round__0$1x10$lang$Rail$1x10$lang$Double$2$2(((x10.core.Rail)(t$49038)), (long)(t$49039));
                
                //#line 77 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                smallC$49037 = ((x10.core.Rail)(t$49040));
                
                //#line 79 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final x10.core.Rail t$49041 = ((x10.core.Rail)(smallC$49037));
                
                //#line 79 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final x10.core.Rail t$49042 = plham.util.Matrix.echelonForm2__0$1x10$lang$Rail$1x10$lang$Double$2$2(((x10.core.Rail)(t$49041)));
                
                //#line 79 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                echelon$49031 = ((x10.core.Rail)(t$49042));
                
                //#line 81 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final x10.core.Rail t$49043 = ((x10.core.Rail)(echelon$49031));
                
                //#line 81 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long t$49044 = plham.util.Matrix.index;
                
                //#line 81 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final x10.core.Rail t$49045 = plham.util.Matrix.round__0$1x10$lang$Rail$1x10$lang$Double$2$2(((x10.core.Rail)(t$49043)), (long)(t$49044));
                
                //#line 81 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                echelon$49031 = ((x10.core.Rail)(t$49045));
            } else {
                
                //#line 84 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long t$49046 = ((x10.core.Rail<x10.core.Double>)initialValue).size;
                
                //#line 84 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long t$49047 = ((t$49046) + (((long)(1L))));
                
                //#line 84 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final x10.core.Rail t$49048 = ((x10.core.Rail)(new x10.core.Rail<x10.core.Rail<x10.core.Double>>(x10.rtt.ParameterizedType.make(x10.core.Rail.$RTT, x10.rtt.Types.DOUBLE), t$49047)));
                
                //#line 84 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                echelon$49031 = ((x10.core.Rail)(t$49048));
            }
            
            //#line 87 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            final long t$49049 = plham.util.Matrix.DEBUG;
            
            //#line 87 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            final boolean t$49050 = ((long) t$49049) == ((long) -2L);
            
            //#line 87 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            if (t$49050) {
                
                //#line 88 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final x10.io.Printer t$49051 = ((x10.io.Printer)(x10.io.Console.get$OUT()));
                
                //#line 88 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long t$49052 = f;
                
                //#line 88 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final java.lang.String t$49053 = (("============ASM") + ((x10.core.Long.$box(t$49052))));
                
                //#line 88 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                t$49051.println(((java.lang.Object)(t$49053)));
                
                //#line 89 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final x10.io.Printer t$49054 = ((x10.io.Printer)(x10.io.Console.get$OUT()));
                
                //#line 89 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                t$49054.println(((java.lang.Object)("*A")));
                
                //#line 90 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final x10.core.Rail t$49055 = ((x10.core.Rail)(A));
                
                //#line 90 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                plham.util.Matrix.dump__0$1x10$lang$Rail$1x10$lang$Double$2$2(((x10.core.Rail)(t$49055)));
                
                //#line 91 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final x10.io.Printer t$49056 = ((x10.io.Printer)(x10.io.Console.get$OUT()));
                
                //#line 91 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                t$49056.println(((java.lang.Object)("*B")));
                
                //#line 92 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final x10.core.Rail t$49057 = ((x10.core.Rail)(B));
                
                //#line 92 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                plham.util.Matrix.dump__0$1x10$lang$Double$2(((x10.core.Rail)(t$49057)));
                
                //#line 93 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final x10.io.Printer t$49058 = ((x10.io.Printer)(x10.io.Console.get$OUT()));
                
                //#line 93 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                t$49058.println(((java.lang.Object)("*Q")));
                
                //#line 94 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final x10.core.Rail t$49059 = ((x10.core.Rail)(Q));
                
                //#line 94 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                plham.util.Matrix.dump__0$1x10$lang$Rail$1x10$lang$Double$2$2(((x10.core.Rail)(t$49059)));
                
                //#line 95 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final x10.io.Printer t$49060 = ((x10.io.Printer)(x10.io.Console.get$OUT()));
                
                //#line 95 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                t$49060.println(((java.lang.Object)("*C")));
                
                //#line 96 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final x10.core.Rail t$49061 = ((x10.core.Rail)(C));
                
                //#line 96 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                plham.util.Matrix.dump__0$1x10$lang$Double$2(((x10.core.Rail)(t$49061)));
                
                //#line 97 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final x10.io.Printer t$49062 = ((x10.io.Printer)(x10.io.Console.get$OUT()));
                
                //#line 97 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                t$49062.println(((java.lang.Object)("============")));
                
                //#line 98 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final x10.io.Printer t$49063 = ((x10.io.Printer)(x10.io.Console.get$OUT()));
                
                //#line 98 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                t$49063.println(((java.lang.Object)("*out")));
                
                //#line 99 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final x10.core.Rail t$49064 = ((x10.core.Rail)(out));
                
                //#line 99 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                plham.util.Matrix.dump__0$1x10$lang$Double$2(((x10.core.Rail)(t$49064)));
                
                //#line 100 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final x10.io.Printer t$49065 = ((x10.io.Printer)(x10.io.Console.get$OUT()));
                
                //#line 100 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                t$49065.println(((java.lang.Object)("*check")));
                
                //#line 101 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final x10.core.Rail t$49066 = ((x10.core.Rail)(activeCheck));
                
                //#line 101 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                plham.util.Matrix.dump__0$1x10$lang$Boolean$2(((x10.core.Rail)(t$49066)));
                
                //#line 102 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final x10.io.Printer t$49067 = ((x10.io.Printer)(x10.io.Console.get$OUT()));
                
                //#line 102 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long t$49068 = s;
                
                //#line 102 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final java.lang.String t$49069 = (("*smallConstraits(s=") + ((x10.core.Long.$box(t$49068))));
                
                //#line 102 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                t$49067.println(((java.lang.Object)(t$49069)));
                
                //#line 103 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final x10.io.Printer t$49070 = ((x10.io.Printer)(x10.io.Console.get$OUT()));
                
                //#line 103 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                t$49070.println(((java.lang.Object)("**smallA")));
                
                //#line 104 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final x10.core.Rail t$49071 = ((x10.core.Rail)(smallA$48993));
                
                //#line 104 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                plham.util.Matrix.dump__0$1x10$lang$Rail$1x10$lang$Double$2$2(((x10.core.Rail)(t$49071)));
                
                //#line 105 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final x10.io.Printer t$49072 = ((x10.io.Printer)(x10.io.Console.get$OUT()));
                
                //#line 105 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                t$49072.println(((java.lang.Object)("**smallB")));
                
                //#line 106 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final x10.core.Rail t$49073 = ((x10.core.Rail)(smallB$48996));
                
                //#line 106 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                plham.util.Matrix.dump__0$1x10$lang$Double$2(((x10.core.Rail)(t$49073)));
                
                //#line 107 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final x10.io.Printer t$49074 = ((x10.io.Printer)(x10.io.Console.get$OUT()));
                
                //#line 107 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                t$49074.println(((java.lang.Object)("*FOC of objective function")));
                
                //#line 108 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final x10.io.Printer t$49075 = ((x10.io.Printer)(x10.io.Console.get$OUT()));
                
                //#line 108 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                t$49075.println(((java.lang.Object)("**Q")));
                
                //#line 109 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final x10.core.Rail t$49076 = ((x10.core.Rail)(Q));
                
                //#line 109 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                plham.util.Matrix.dump__0$1x10$lang$Rail$1x10$lang$Double$2$2(((x10.core.Rail)(t$49076)));
                
                //#line 110 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final x10.io.Printer t$49077 = ((x10.io.Printer)(x10.io.Console.get$OUT()));
                
                //#line 110 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                t$49077.println(((java.lang.Object)("**C")));
                
                //#line 111 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final x10.core.Rail t$49078 = ((x10.core.Rail)(C));
                
                //#line 111 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                plham.util.Matrix.dump__0$1x10$lang$Double$2(((x10.core.Rail)(t$49078)));
                
                //#line 112 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final x10.io.Printer t$49079 = ((x10.io.Printer)(x10.io.Console.get$OUT()));
                
                //#line 112 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long t$49080 = f;
                
                //#line 112 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final java.lang.String t$49081 = (("============bigMat") + ((x10.core.Long.$box(t$49080))));
                
                //#line 112 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                t$49079.println(((java.lang.Object)(t$49081)));
                
                //#line 113 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final x10.io.Printer t$49082 = ((x10.io.Printer)(x10.io.Console.get$OUT()));
                
                //#line 113 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long t$49083 = s;
                
                //#line 113 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final java.lang.String t$49084 = (("*Mat(s=") + ((x10.core.Long.$box(t$49083))));
                
                //#line 113 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                t$49082.println(((java.lang.Object)(t$49084)));
                
                //#line 114 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final x10.core.Rail t$49085 = ((x10.core.Rail)(mat$49005));
                
                //#line 114 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                plham.util.Matrix.dump__0$1x10$lang$Rail$1x10$lang$Double$2$2(((x10.core.Rail)(t$49085)));
                
                //#line 115 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final x10.io.Printer t$49086 = ((x10.io.Printer)(x10.io.Console.get$OUT()));
                
                //#line 115 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long t$49087 = s;
                
                //#line 115 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final java.lang.String t$49088 = (("*right(s=") + ((x10.core.Long.$box(t$49087))));
                
                //#line 115 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                t$49086.println(((java.lang.Object)(t$49088)));
                
                //#line 116 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final x10.core.Rail t$49089 = ((x10.core.Rail)(right$49008));
                
                //#line 116 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                plham.util.Matrix.dump__0$1x10$lang$Double$2(((x10.core.Rail)(t$49089)));
                
                //#line 117 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final x10.io.Printer t$49090 = ((x10.io.Printer)(x10.io.Console.get$OUT()));
                
                //#line 117 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long t$49091 = s;
                
                //#line 117 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final java.lang.String t$49092 = (("*ex") + ((x10.core.Long.$box(t$49091))));
                
                //#line 117 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                t$49090.println(((java.lang.Object)(t$49092)));
                
                //#line 118 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final x10.core.Rail t$49093 = ((x10.core.Rail)(ex$49017));
                
                //#line 118 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                plham.util.Matrix.dump__0$1x10$lang$Rail$1x10$lang$Double$2$2(((x10.core.Rail)(t$49093)));
                
                //#line 119 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final x10.io.Printer t$49094 = ((x10.io.Printer)(x10.io.Console.get$OUT()));
                
                //#line 119 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long t$49095 = f;
                
                //#line 119 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final java.lang.String t$49096 = (("============echelon") + ((x10.core.Long.$box(t$49095))));
                
                //#line 119 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                t$49094.println(((java.lang.Object)(t$49096)));
                
                //#line 120 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final x10.io.Printer t$49097 = ((x10.io.Printer)(x10.io.Console.get$OUT()));
                
                //#line 120 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long t$49098 = s;
                
                //#line 120 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final java.lang.String t$49099 = (("*echelonex:") + ((x10.core.Long.$box(t$49098))));
                
                //#line 120 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                t$49097.println(((java.lang.Object)(t$49099)));
                
                //#line 121 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final x10.core.Rail t$49100 = ((x10.core.Rail)(echelon$49019));
                
                //#line 121 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                plham.util.Matrix.dump__0$1x10$lang$Rail$1x10$lang$Double$2$2(((x10.core.Rail)(t$49100)));
                
                //#line 122 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final x10.io.Printer t$49101 = ((x10.io.Printer)(x10.io.Console.get$OUT()));
                
                //#line 122 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long t$49102 = s;
                
                //#line 122 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final java.lang.String t$49103 = (("*echelonMat:") + ((x10.core.Long.$box(t$49102))));
                
                //#line 122 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                t$49101.println(((java.lang.Object)(t$49103)));
                
                //#line 123 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final x10.core.Rail t$49104 = ((x10.core.Rail)(echelon$49021));
                
                //#line 123 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                plham.util.Matrix.dump__0$1x10$lang$Rail$1x10$lang$Double$2$2(((x10.core.Rail)(t$49104)));
            }
            
            //#line 126 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            final x10.core.Rail t$49105 = ((x10.core.Rail)(out));
            
            //#line 126 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            lastOut = ((x10.core.Rail)(t$49105));
            
            //#line 127 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            x10.core.Rail hoge$49106 =  null;
            
            //#line 139 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            final x10.core.Rail t$49107 = ((x10.core.Rail)(mat$49005));
            
            //#line 139 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            final boolean t$49108 = plham.util.Matrix.checkForIterative__0$1x10$lang$Rail$1x10$lang$Double$2$2$O(((x10.core.Rail)(t$49107)));
            
            //#line 139 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            if (t$49108) {
                
                //#line 140 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final x10.core.Rail t$49109 = ((x10.core.Rail)(ex$49017));
                
                //#line 140 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long t$49110 = ((x10.core.Rail<x10.core.Rail<x10.core.Double>>)t$49109).size;
                
                //#line 140 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final x10.core.Rail t$49111 = ((x10.core.Rail)(new x10.core.Rail<x10.core.Double>(x10.rtt.Types.DOUBLE, t$49110)));
                
                //#line 140 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                hoge$49106 = ((x10.core.Rail)(t$49111));
                
                //#line 141 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final x10.core.Rail t$49112 = ((x10.core.Rail)(mat$49005));
                
                //#line 141 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final x10.core.Rail t$49113 = ((x10.core.Rail)(right$49008));
                
                //#line 141 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final x10.core.Rail t$49114 = plham.util.Matrix.iteration__0$1x10$lang$Rail$1x10$lang$Double$2$2__1$1x10$lang$Double$2(((x10.core.Rail)(t$49112)), ((x10.core.Rail)(t$49113)), (long)(10L));
                
                //#line 141 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                hoge$49106 = ((x10.core.Rail)(t$49114));
            } else {
                
                //#line 143 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final x10.core.Rail t$49115 = ((x10.core.Rail)(ex$49017));
                
                //#line 143 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long t$49116 = ((x10.core.Rail<x10.core.Rail<x10.core.Double>>)t$49115).size;
                
                //#line 143 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final x10.core.Rail t$49117 = ((x10.core.Rail)(new x10.core.Rail<x10.core.Double>(x10.rtt.Types.DOUBLE, t$49116)));
                
                //#line 143 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                hoge$49106 = ((x10.core.Rail)(t$49117));
                
                //#line 144 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final x10.core.Rail t$49118 = ((x10.core.Rail)(mat$49005));
                
                //#line 144 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final x10.core.Rail t$49119 = plham.util.Matrix.decompose__0$1x10$lang$Rail$1x10$lang$Double$2$2(((x10.core.Rail)(t$49118)));
                
                //#line 144 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final x10.core.Rail t$49120 = ((x10.core.Rail)(right$49008));
                
                //#line 144 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final x10.core.Rail t$49121 = plham.util.Matrix.luSolver__0$1x10$lang$Rail$1x10$lang$Double$2$2__1$1x10$lang$Double$2(((x10.core.Rail)(t$49119)), ((x10.core.Rail)(t$49120)));
                
                //#line 144 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                hoge$49106 = ((x10.core.Rail)(t$49121));
            }
            
            //#line 147 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            final x10.core.Rail t$49122 = ((x10.core.Rail)(hoge$49106));
            
            //#line 147 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            final long t$49123 = plham.util.Matrix.index;
            
            //#line 147 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            final x10.core.Rail t$49124 = plham.util.Matrix.round__0$1x10$lang$Double$2(((x10.core.Rail)(t$49122)), (long)(t$49123));
            
            //#line 147 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            hoge$49106 = ((x10.core.Rail)(t$49124));
            
            //#line 154 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            final x10.core.Rail t$49125 = ((x10.core.Rail)(hoge$49106));
            
            //#line 154 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            final long t$49126 = ((x10.core.Rail<x10.core.Double>)initialValue).size;
            
            //#line 154 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            final x10.core.Rail t$49127 = plham.util.Matrix.shorten__0$1x10$lang$Double$2(((x10.core.Rail)(t$49125)), (long)(t$49126));
            
            //#line 154 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            out = ((x10.core.Rail)(t$49127));
            
            //#line 155 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            final long t$49128 = ((x10.core.Rail<x10.core.Double>)initialValue).size;
            
            //#line 155 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            x10.core.Rail y$49129 = new x10.core.Rail<x10.core.Double>(x10.rtt.Types.DOUBLE, ((long)(t$49128)));
            
            //#line 156 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            final x10.core.Rail t$49130 = ((x10.core.Rail)(hoge$49106));
            
            //#line 156 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            final long t$49131 = ((x10.core.Rail<x10.core.Double>)initialValue).size;
            
            //#line 156 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            final x10.core.Rail t$49132 = plham.util.Matrix.shorten2__0$1x10$lang$Double$2(((x10.core.Rail)(t$49130)), (long)(t$49131));
            
            //#line 156 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            y$49129 = ((x10.core.Rail)(t$49132));
            
            //#line 157 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            final long t$49133 = plham.util.Matrix.DEBUG;
            
            //#line 157 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            final boolean t$49134 = ((long) t$49133) == ((long) -2L);
            
            //#line 157 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            if (t$49134) {
                
                //#line 158 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final x10.io.Printer t$49135 = ((x10.io.Printer)(x10.io.Console.get$OUT()));
                
                //#line 158 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                t$49135.println(((java.lang.Object)("*xy")));
                
                //#line 159 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final x10.core.Rail t$49136 = ((x10.core.Rail)(hoge$49106));
                
                //#line 159 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                plham.util.Matrix.dump__0$1x10$lang$Double$2(((x10.core.Rail)(t$49136)));
                
                //#line 160 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final x10.io.Printer t$49137 = ((x10.io.Printer)(x10.io.Console.get$OUT()));
                
                //#line 160 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                t$49137.println(((java.lang.Object)("*y")));
                
                //#line 161 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final x10.core.Rail t$49138 = ((x10.core.Rail)(y$49129));
                
                //#line 161 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                plham.util.Matrix.dump__0$1x10$lang$Double$2(((x10.core.Rail)(t$49138)));
                
                //#line 162 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final x10.io.Printer t$49139 = ((x10.io.Printer)(x10.io.Console.get$OUT()));
                
                //#line 162 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                t$49139.println(((java.lang.Object)("*conditionCheck")));
                
                //#line 163 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final x10.core.Rail t$49140 = ((x10.core.Rail)(activeCheck));
                
                //#line 163 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                plham.util.Matrix.dump__0$1x10$lang$Boolean$2(((x10.core.Rail)(t$49140)));
            }
            
            //#line 166 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            final x10.core.Rail t$49141 = ((x10.core.Rail)(mat$49005));
            
            //#line 166 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            final x10.core.Rail t$49142 = ((x10.core.Rail)(hoge$49106));
            
            //#line 166 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            final x10.core.Rail t$49143 = plham.util.Matrix.multiply__0$1x10$lang$Rail$1x10$lang$Double$2$2__1$1x10$lang$Double$2(((x10.core.Rail)(t$49141)), ((x10.core.Rail)(t$49142)));
            
            //#line 166 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            kenzan = ((x10.core.Rail)(t$49143));
            
            //#line 167 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            final x10.core.Rail t$49144 = ((x10.core.Rail)(activeCheck));
            
            //#line 167 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            final long t$49145 = plham.util.Matrix.countActive__0$1x10$lang$Boolean$2$O(((x10.core.Rail)(t$49144)));
            
            //#line 167 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            s = t$49145;
            
            //#line 168 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            final long t$49146 = plham.util.Matrix.DEBUG;
            
            //#line 168 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            final boolean t$49147 = ((long) t$49146) == ((long) -2L);
            
            //#line 168 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            if (t$49147) {
                
                //#line 169 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final x10.io.Printer t$49148 = ((x10.io.Printer)(x10.io.Console.get$OUT()));
                
                //#line 169 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                t$49148.println(((java.lang.Object)("*newOut")));
                
                //#line 170 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final x10.core.Rail t$49149 = ((x10.core.Rail)(out));
                
                //#line 170 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                plham.util.Matrix.dump__0$1x10$lang$Double$2(((x10.core.Rail)(t$49149)));
                
                //#line 171 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final x10.io.Printer t$49150 = ((x10.io.Printer)(x10.io.Console.get$OUT()));
                
                //#line 171 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                t$49150.println(((java.lang.Object)("*lastOut")));
                
                //#line 172 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final x10.core.Rail t$49151 = ((x10.core.Rail)(lastOut));
                
                //#line 172 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                plham.util.Matrix.dump__0$1x10$lang$Double$2(((x10.core.Rail)(t$49151)));
                
                //#line 173 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final x10.io.Printer t$49152 = ((x10.io.Printer)(x10.io.Console.get$OUT()));
                
                //#line 173 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                t$49152.println(((java.lang.Object)("*kenzan")));
                
                //#line 174 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final x10.io.Printer t$49153 = ((x10.io.Printer)(x10.io.Console.get$OUT()));
                
                //#line 174 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                t$49153.println(((java.lang.Object)("**result")));
                
                //#line 175 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final x10.core.Rail t$49154 = ((x10.core.Rail)(kenzan));
                
                //#line 175 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                plham.util.Matrix.dump__0$1x10$lang$Double$2(((x10.core.Rail)(t$49154)));
                
                //#line 176 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final x10.io.Printer t$49155 = ((x10.io.Printer)(x10.io.Console.get$OUT()));
                
                //#line 176 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                t$49155.println(((java.lang.Object)("**right")));
                
                //#line 177 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final x10.core.Rail t$49156 = ((x10.core.Rail)(right$49008));
                
                //#line 177 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                plham.util.Matrix.dump__0$1x10$lang$Double$2(((x10.core.Rail)(t$49156)));
                
                //#line 178 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final x10.io.Printer t$49157 = ((x10.io.Printer)(x10.io.Console.get$OUT()));
                
                //#line 178 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long t$49158 = f;
                
                //#line 178 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final java.lang.String t$49159 = (("*============step1end") + ((x10.core.Long.$box(t$49158))));
                
                //#line 178 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                t$49157.println(((java.lang.Object)(t$49159)));
                
                //#line 179 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final x10.io.Printer t$49160 = ((x10.io.Printer)(x10.io.Console.get$OUT()));
                
                //#line 179 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                t$49160.println(((java.lang.Object)("*checkASM1")));
            }
            
            //#line 184 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            final x10.core.Rail t$49161 = ((x10.core.Rail)(out));
            
            //#line 184 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            final x10.core.Rail t$49162 = ((x10.core.Rail)(lastOut));
            
            //#line 184 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            final double t$49163 = plham.util.Matrix.epsilon;
            
            //#line 184 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            final double t$49164 = plham.util.Matrix.epsilon2;
            
            //#line 184 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            final boolean t$49165 = plham.util.Matrix.checkASM__0$1x10$lang$Double$2__1$1x10$lang$Double$2$O(((x10.core.Rail)(t$49161)), ((x10.core.Rail)(t$49162)), (double)(t$49163), (double)(t$49164));
            
            //#line 184 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            final boolean t$49166 = !(t$49165);
            
            //#line 184 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            if (t$49166) {
                
                //#line 187 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long t$49167 = ((x10.core.Rail<x10.core.Double>)initialValue).size;
                
                //#line 187 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                x10.core.Rail d$49168 = new x10.core.Rail<x10.core.Double>(x10.rtt.Types.DOUBLE, ((long)(t$49167)));
                
                //#line 188 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long t$49169 = ((x10.core.Rail<x10.core.Double>)initialValue).size;
                
                //#line 188 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                x10.core.Rail arufa$49170 = new x10.core.Rail<x10.core.Double>(x10.rtt.Types.DOUBLE, ((long)(t$49169)));
                
                //#line 189 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long t$49171 = ((x10.core.Rail<x10.core.Double>)initialValue).size;
                
                //#line 189 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                x10.core.Rail mvec$49172 = new x10.core.Rail<x10.core.Double>(x10.rtt.Types.DOUBLE, ((long)(t$49171)));
                
                //#line 190 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long i$45413min$48957 = 0L;
                
                //#line 190 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final x10.core.Rail t$48958 = ((x10.core.Rail)(d$49168));
                
                //#line 190 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long t$48959 = ((x10.core.Rail<x10.core.Double>)t$48958).size;
                
                //#line 190 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long i$45413max$48960 = ((t$48959) - (((long)(1L))));
                
                //#line 190 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                long i$48883 = i$45413min$48957;
                
                //#line 190 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                for (;
                     true;
                     ) {
                    
                    //#line 190 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final long t$48884 = i$48883;
                    
                    //#line 190 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final boolean t$48885 = ((t$48884) <= (((long)(i$45413max$48960))));
                    
                    //#line 190 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    if (!(t$48885)) {
                        
                        //#line 190 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        break;
                    }
                    
                    //#line 190 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final long i$48880 = i$48883;
                    
                    //#line 191 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final x10.core.Rail t$48873 = ((x10.core.Rail)(d$49168));
                    
                    //#line 191 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final x10.core.Rail t$48874 = ((x10.core.Rail)(out));
                    
                    //#line 191 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final double t$48875 = ((double[])t$48874.value)[(int)i$48880];
                    
                    //#line 191 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final x10.core.Rail t$48876 = ((x10.core.Rail)(lastOut));
                    
                    //#line 191 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final double t$48877 = ((double[])t$48876.value)[(int)i$48880];
                    
                    //#line 191 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final double t$48878 = ((t$48875) - (((double)(t$48877))));
                    
                    //#line 191 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    ((double[])t$48873.value)[(int)i$48880] = t$48878;
                    
                    //#line 192 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final x10.core.Rail t$48879 = ((x10.core.Rail)(mvec$49172));
                    
                    //#line 192 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    ((double[])t$48879.value)[(int)i$48880] = 1.0;
                    
                    //#line 190 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final long t$48881 = i$48883;
                    
                    //#line 190 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final long t$48882 = ((t$48881) + (((long)(1L))));
                    
                    //#line 190 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    i$48883 = t$48882;
                }
                
                //#line 195 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long t$49173 = plham.util.Matrix.DEBUG;
                
                //#line 195 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final boolean t$49174 = ((long) t$49173) == ((long) -2L);
                
                //#line 195 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                if (t$49174) {
                    
                    //#line 196 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final x10.io.Printer t$49175 = ((x10.io.Printer)(x10.io.Console.get$OUT()));
                    
                    //#line 196 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    t$49175.println(((java.lang.Object)("false")));
                    
                    //#line 197 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final x10.io.Printer t$49176 = ((x10.io.Printer)(x10.io.Console.get$OUT()));
                    
                    //#line 197 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    t$49176.println(((java.lang.Object)("*d")));
                    
                    //#line 198 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final x10.core.Rail t$49177 = ((x10.core.Rail)(d$49168));
                    
                    //#line 198 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    plham.util.Matrix.dump__0$1x10$lang$Double$2(((x10.core.Rail)(t$49177)));
                }
                
                //#line 200 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                double min$49178 = ((double)(long)(((long)(1L))));
                
                //#line 201 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long i$45431min$48961 = 0L;
                
                //#line 201 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final x10.core.Rail t$48962 = ((x10.core.Rail)(A));
                
                //#line 201 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long t$48963 = ((x10.core.Rail<x10.core.Rail<x10.core.Double>>)t$48962).size;
                
                //#line 201 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long i$45431max$48964 = ((t$48963) - (((long)(1L))));
                
                //#line 201 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                long i$48939 = i$45431min$48961;
                
                //#line 201 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                for (;
                     true;
                     ) {
                    
                    //#line 201 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final long t$48940 = i$48939;
                    
                    //#line 201 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final boolean t$48941 = ((t$48940) <= (((long)(i$45431max$48964))));
                    
                    //#line 201 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    if (!(t$48941)) {
                        
                        //#line 201 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        break;
                    }
                    
                    //#line 201 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final long i$48936 = i$48939;
                    
                    //#line 202 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final x10.core.Rail t$48886 = ((x10.core.Rail)(activeCheck));
                    
                    //#line 202 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final boolean t$48887 = ((boolean[])t$48886.value)[(int)i$48936];
                    
                    //#line 202 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final boolean t$48888 = !(t$48887);
                    
                    //#line 202 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    if (t$48888) {
                        
                        //#line 203 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        final long t$48889 = plham.util.Matrix.DEBUG;
                        
                        //#line 203 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        final boolean t$48890 = ((long) t$48889) == ((long) -2L);
                        
                        //#line 203 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        if (t$48890) {
                            
                            //#line 204 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                            final x10.io.Printer t$48891 = ((x10.io.Printer)(x10.io.Console.get$OUT()));
                            
                            //#line 204 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                            final java.lang.String t$48892 = (("*bar(") + ((x10.core.Long.$box(i$48936))));
                            
                            //#line 204 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                            final java.lang.String t$48893 = ((t$48892) + (")"));
                            
                            //#line 204 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                            t$48891.println(((java.lang.Object)(t$48893)));
                            
                            //#line 205 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                            final x10.io.Printer t$48894 = ((x10.io.Printer)(x10.io.Console.get$OUT()));
                            
                            //#line 205 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                            t$48894.println(((java.lang.Object)("**b-ax")));
                            
                            //#line 206 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                            final x10.io.Printer t$48895 = ((x10.io.Printer)(x10.io.Console.get$OUT()));
                            
                            //#line 206 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                            final x10.core.Rail t$48896 = ((x10.core.Rail)(B));
                            
                            //#line 206 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                            final double t$48897 = ((double[])t$48896.value)[(int)i$48936];
                            
                            //#line 206 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                            final x10.core.Rail t$48898 = ((x10.core.Rail)(A));
                            
                            //#line 206 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                            final x10.core.Rail t$48899 = ((x10.core.Rail[])t$48898.value)[(int)i$48936];
                            
                            //#line 206 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                            final x10.core.Rail t$48900 = ((x10.core.Rail)(lastOut));
                            
                            //#line 206 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                            final double t$48901 = plham.util.Matrix.multiply__0$1x10$lang$Double$2__1$1x10$lang$Double$2$O(((x10.core.Rail)(t$48899)), ((x10.core.Rail)(t$48900)));
                            
                            //#line 206 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                            final double t$48902 = ((t$48897) - (((double)(t$48901))));
                            
                            //#line 206 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                            t$48895.println(x10.core.Double.$box(t$48902));
                            
                            //#line 207 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                            final x10.io.Printer t$48903 = ((x10.io.Printer)(x10.io.Console.get$OUT()));
                            
                            //#line 207 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                            t$48903.println(((java.lang.Object)("**ad")));
                            
                            //#line 208 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                            final x10.io.Printer t$48904 = ((x10.io.Printer)(x10.io.Console.get$OUT()));
                            
                            //#line 208 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                            final x10.core.Rail t$48905 = ((x10.core.Rail)(A));
                            
                            //#line 208 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                            final x10.core.Rail t$48906 = ((x10.core.Rail[])t$48905.value)[(int)i$48936];
                            
                            //#line 208 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                            final x10.core.Rail t$48907 = ((x10.core.Rail)(d$49168));
                            
                            //#line 208 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                            final double t$48908 = plham.util.Matrix.multiply__0$1x10$lang$Double$2__1$1x10$lang$Double$2$O(((x10.core.Rail)(t$48906)), ((x10.core.Rail)(t$48907)));
                            
                            //#line 208 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                            t$48904.println(x10.core.Double.$box(t$48908));
                        }
                        
                        //#line 210 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        final x10.core.Rail t$48909 = ((x10.core.Rail)(A));
                        
                        //#line 210 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        final x10.core.Rail t$48910 = ((x10.core.Rail[])t$48909.value)[(int)i$48936];
                        
                        //#line 210 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        final x10.core.Rail t$48911 = ((x10.core.Rail)(d$49168));
                        
                        //#line 210 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        final double t$48912 = plham.util.Matrix.multiply__0$1x10$lang$Double$2__1$1x10$lang$Double$2$O(((x10.core.Rail)(t$48910)), ((x10.core.Rail)(t$48911)));
                        
                        //#line 210 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        final double t$48913 = ((double)(long)(((long)(0L))));
                        
                        //#line 210 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        final boolean t$48914 = ((t$48912) > (((double)(t$48913))));
                        
                        //#line 210 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        if (t$48914) {
                            
                            //#line 211 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                            final x10.core.Rail t$48915 = ((x10.core.Rail)(B));
                            
                            //#line 211 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                            final double t$48916 = ((double[])t$48915.value)[(int)i$48936];
                            
                            //#line 211 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                            final x10.core.Rail t$48917 = ((x10.core.Rail)(A));
                            
                            //#line 211 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                            final x10.core.Rail t$48918 = ((x10.core.Rail[])t$48917.value)[(int)i$48936];
                            
                            //#line 211 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                            final x10.core.Rail t$48919 = ((x10.core.Rail)(lastOut));
                            
                            //#line 211 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                            final double t$48920 = plham.util.Matrix.multiply__0$1x10$lang$Double$2__1$1x10$lang$Double$2$O(((x10.core.Rail)(t$48918)), ((x10.core.Rail)(t$48919)));
                            
                            //#line 211 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                            final double t$48921 = ((t$48916) - (((double)(t$48920))));
                            
                            //#line 211 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                            final x10.core.Rail t$48922 = ((x10.core.Rail)(A));
                            
                            //#line 211 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                            final x10.core.Rail t$48923 = ((x10.core.Rail[])t$48922.value)[(int)i$48936];
                            
                            //#line 211 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                            final x10.core.Rail t$48924 = ((x10.core.Rail)(d$49168));
                            
                            //#line 211 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                            final double t$48925 = plham.util.Matrix.multiply__0$1x10$lang$Double$2__1$1x10$lang$Double$2$O(((x10.core.Rail)(t$48923)), ((x10.core.Rail)(t$48924)));
                            
                            //#line 211 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                            double l$48926 = ((t$48921) / (((double)(t$48925))));
                            
                            //#line 212 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                            final long t$48927 = plham.util.Matrix.DEBUG;
                            
                            //#line 212 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                            final boolean t$48928 = ((long) t$48927) == ((long) -2L);
                            
                            //#line 212 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                            if (t$48928) {
                                
                                //#line 213 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                                final x10.io.Printer t$48929 = ((x10.io.Printer)(x10.io.Console.get$OUT()));
                                
                                //#line 213 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                                t$48929.println(((java.lang.Object)("**l")));
                                
                                //#line 214 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                                final x10.io.Printer t$48930 = ((x10.io.Printer)(x10.io.Console.get$OUT()));
                                
                                //#line 214 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                                final double t$48931 = l$48926;
                                
                                //#line 214 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                                t$48930.println(x10.core.Double.$box(t$48931));
                            }
                            
                            //#line 216 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                            final double t$48932 = l$48926;
                            
                            //#line 216 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                            final double t$48933 = min$49178;
                            
                            //#line 216 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                            final boolean t$48934 = ((t$48932) < (((double)(t$48933))));
                            
                            //#line 216 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                            if (t$48934) {
                                
                                //#line 216 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                                final double t$48935 = l$48926;
                                
                                //#line 216 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                                min$49178 = t$48935;
                            }
                        }
                    }
                    
                    //#line 201 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final long t$48937 = i$48939;
                    
                    //#line 201 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final long t$48938 = ((t$48937) + (((long)(1L))));
                    
                    //#line 201 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    i$48939 = t$48938;
                }
                
                //#line 220 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final double t$49179 = min$49178;
                
                //#line 220 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final x10.core.Rail t$49180 = ((x10.core.Rail)(mvec$49172));
                
                //#line 220 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final x10.core.Rail t$49181 = plham.util.Matrix.multiply__1$1x10$lang$Double$2((double)(t$49179), ((x10.core.Rail)(t$49180)));
                
                //#line 220 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                mvec$49172 = ((x10.core.Rail)(t$49181));
                
                //#line 221 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long t$49182 = plham.util.Matrix.DEBUG;
                
                //#line 221 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final boolean t$49183 = ((long) t$49182) == ((long) -2L);
                
                //#line 221 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                if (t$49183) {
                    
                    //#line 222 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final x10.io.Printer t$49184 = ((x10.io.Printer)(x10.io.Console.get$OUT()));
                    
                    //#line 222 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    t$49184.println(((java.lang.Object)("*mvec")));
                    
                    //#line 223 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final x10.core.Rail t$49185 = ((x10.core.Rail)(mvec$49172));
                    
                    //#line 223 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    plham.util.Matrix.dump__0$1x10$lang$Double$2(((x10.core.Rail)(t$49185)));
                }
                
                //#line 225 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long i$45449min$48965 = 0L;
                
                //#line 225 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final x10.core.Rail t$48966 = ((x10.core.Rail)(d$49168));
                
                //#line 225 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long t$48967 = ((x10.core.Rail<x10.core.Double>)t$48966).size;
                
                //#line 225 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long i$45449max$48968 = ((t$48967) - (((long)(1L))));
                
                //#line 225 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                long i$48954 = i$45449min$48965;
                
                //#line 225 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                for (;
                     true;
                     ) {
                    
                    //#line 225 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final long t$48955 = i$48954;
                    
                    //#line 225 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final boolean t$48956 = ((t$48955) <= (((long)(i$45449max$48968))));
                    
                    //#line 225 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    if (!(t$48956)) {
                        
                        //#line 225 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        break;
                    }
                    
                    //#line 225 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final long i$48951 = i$48954;
                    
                    //#line 226 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final x10.core.Rail t$48942 = ((x10.core.Rail)(out));
                    
                    //#line 226 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final x10.core.Rail t$48943 = ((x10.core.Rail)(lastOut));
                    
                    //#line 226 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final double t$48944 = ((double[])t$48943.value)[(int)i$48951];
                    
                    //#line 226 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final x10.core.Rail t$48945 = ((x10.core.Rail)(mvec$49172));
                    
                    //#line 226 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final double t$48946 = ((double[])t$48945.value)[(int)i$48951];
                    
                    //#line 226 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final x10.core.Rail t$48947 = ((x10.core.Rail)(d$49168));
                    
                    //#line 226 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final double t$48948 = ((double[])t$48947.value)[(int)i$48951];
                    
                    //#line 226 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final double t$48949 = ((t$48946) * (((double)(t$48948))));
                    
                    //#line 226 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final double t$48950 = ((t$48944) + (((double)(t$48949))));
                    
                    //#line 226 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    ((double[])t$48942.value)[(int)i$48951] = t$48950;
                    
                    //#line 225 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final long t$48952 = i$48954;
                    
                    //#line 225 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final long t$48953 = ((t$48952) + (((long)(1L))));
                    
                    //#line 225 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    i$48954 = t$48953;
                }
                
                //#line 228 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final x10.core.Rail t$49186 = ((x10.core.Rail)(out));
                
                //#line 228 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long t$49187 = plham.util.Matrix.index;
                
                //#line 228 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final x10.core.Rail t$49188 = plham.util.Matrix.round__0$1x10$lang$Double$2(((x10.core.Rail)(t$49186)), (long)(t$49187));
                
                //#line 228 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                out = ((x10.core.Rail)(t$49188));
                
                //#line 229 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long t$49189 = plham.util.Matrix.DEBUG;
                
                //#line 229 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final boolean t$49190 = ((long) t$49189) == ((long) -2L);
                
                //#line 229 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                if (t$49190) {
                    
                    //#line 230 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final x10.io.Printer t$49191 = ((x10.io.Printer)(x10.io.Console.get$OUT()));
                    
                    //#line 230 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    t$49191.println(((java.lang.Object)("*nextOut")));
                    
                    //#line 231 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final x10.core.Rail t$49192 = ((x10.core.Rail)(out));
                    
                    //#line 231 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    plham.util.Matrix.dump__0$1x10$lang$Double$2(((x10.core.Rail)(t$49192)));
                }
                
                //#line 233 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                t = -1L;
                
                //#line 234 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                repeat = true;
                
                //#line 235 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long t$49193 = plham.util.Matrix.DEBUG;
                
                //#line 235 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final boolean t$49194 = ((long) t$49193) == ((long) -2L);
                
                //#line 235 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                if (t$49194) {
                    
                    //#line 236 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final x10.io.Printer t$49195 = ((x10.io.Printer)(x10.io.Console.get$OUT()));
                    
                    //#line 236 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final long t$49196 = f;
                    
                    //#line 236 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final java.lang.String t$49197 = (("*============step2end") + ((x10.core.Long.$box(t$49196))));
                    
                    //#line 236 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    t$49195.println(((java.lang.Object)(t$49197)));
                }
            } else {
                
                //#line 240 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long t$49198 = plham.util.Matrix.DEBUG;
                
                //#line 240 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final boolean t$49199 = ((long) t$49198) == ((long) -2L);
                
                //#line 240 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                if (t$49199) {
                    
                    //#line 241 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final x10.io.Printer t$49200 = ((x10.io.Printer)(x10.io.Console.get$OUT()));
                    
                    //#line 241 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    t$49200.println(((java.lang.Object)("true")));
                    
                    //#line 242 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final x10.io.Printer t$49201 = ((x10.io.Printer)(x10.io.Console.get$OUT()));
                    
                    //#line 242 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    t$49201.println(((java.lang.Object)("*checkASM2")));
                }
                
                //#line 244 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final x10.core.Rail t$49202 = ((x10.core.Rail)(hoge$49106));
                
                //#line 244 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long t$49203 = ((x10.core.Rail<x10.core.Double>)t$49202).size;
                
                //#line 244 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long t$49204 = ((x10.core.Rail<x10.core.Double>)initialValue).size;
                
                //#line 244 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final boolean t$49205 = ((long) t$49203) == ((long) t$49204);
                
                //#line 244 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                if (t$49205) {
                    
                    //#line 245 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final long t$49206 = plham.util.Matrix.DEBUG;
                    
                    //#line 245 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final boolean t$49207 = ((long) t$49206) == ((long) -2L);
                    
                    //#line 245 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    if (t$49207) {
                        
                        //#line 246 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        final x10.io.Printer t$49208 = ((x10.io.Printer)(x10.io.Console.get$OUT()));
                        
                        //#line 246 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        t$49208.println(((java.lang.Object)("true1")));
                    }
                    
                    //#line 248 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    repeat = false;
                } else {
                    
                    //#line 249 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final x10.core.Rail t$49209 = ((x10.core.Rail)(hoge$49106));
                    
                    //#line 249 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final long t$49210 = ((x10.core.Rail<x10.core.Double>)t$49209).size;
                    
                    //#line 249 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final long t$49211 = ((x10.core.Rail<x10.core.Double>)initialValue).size;
                    
                    //#line 249 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    boolean t$49212 = ((t$49210) > (((long)(t$49211))));
                    
                    //#line 249 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    if (t$49212) {
                        
                        //#line 249 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        final x10.core.Rail t$49213 = ((x10.core.Rail)(y$49129));
                        
                        //#line 249 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        t$49212 = plham.util.Matrix.checkPositive__0$1x10$lang$Double$2$O(((x10.core.Rail)(t$49213)));
                    }
                    
                    //#line 249 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final boolean t$49214 = t$49212;
                    
                    //#line 249 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    if (t$49214) {
                        
                        //#line 250 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        final long t$49215 = plham.util.Matrix.DEBUG;
                        
                        //#line 250 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        final boolean t$49216 = ((long) t$49215) == ((long) -2L);
                        
                        //#line 250 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        if (t$49216) {
                            
                            //#line 251 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                            final x10.io.Printer t$49217 = ((x10.io.Printer)(x10.io.Console.get$OUT()));
                            
                            //#line 251 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                            t$49217.println(((java.lang.Object)("true2")));
                        }
                        
                        //#line 253 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        repeat = false;
                    } else {
                        
                        //#line 255 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        long oldT$49218 = t;
                        
                        //#line 256 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        repeat = true;
                        
                        //#line 257 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        final x10.core.Rail t$49219 = ((x10.core.Rail)(hoge$49106));
                        
                        //#line 257 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        final long t$49220 = ((x10.core.Rail<x10.core.Double>)t$49219).size;
                        
                        //#line 257 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        final long t$49221 = ((x10.core.Rail<x10.core.Double>)initialValue).size;
                        
                        //#line 257 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        final long t$49222 = ((t$49220) - (((long)(t$49221))));
                        
                        //#line 257 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        final boolean t$49223 = ((t$49222) > (((long)(0L))));
                        
                        //#line 257 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        if (t$49223) {
                            
                            //#line 258 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                            final x10.core.Rail t$49224 = ((x10.core.Rail)(y$49129));
                            
                            //#line 258 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                            final x10.core.Rail t$49225 = ((x10.core.Rail)(activeCheck));
                            
                            //#line 258 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                            final long t$49226 = plham.util.Matrix.getNumMinMinusY__0$1x10$lang$Double$2__1$1x10$lang$Boolean$2$O(((x10.core.Rail)(t$49224)), ((x10.core.Rail)(t$49225)));
                            
                            //#line 258 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                            t = t$49226;
                        }
                        
                        //#line 260 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        final long t$49227 = plham.util.Matrix.DEBUG;
                        
                        //#line 260 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        final boolean t$49228 = ((long) t$49227) == ((long) -2L);
                        
                        //#line 260 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        if (t$49228) {
                            
                            //#line 261 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                            final x10.io.Printer t$49229 = ((x10.io.Printer)(x10.io.Console.get$OUT()));
                            
                            //#line 261 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                            t$49229.println(((java.lang.Object)("false")));
                            
                            //#line 262 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                            final x10.io.Printer t$49230 = ((x10.io.Printer)(x10.io.Console.get$OUT()));
                            
                            //#line 262 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                            final long t$49231 = t;
                            
                            //#line 262 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                            final java.lang.String t$49232 = (("*t\n") + ((x10.core.Long.$box(t$49231))));
                            
                            //#line 262 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                            t$49230.println(((java.lang.Object)(t$49232)));
                        }
                    }
                }
                
                //#line 265 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long t$49233 = plham.util.Matrix.DEBUG;
                
                //#line 265 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final boolean t$49234 = ((long) t$49233) == ((long) -2L);
                
                //#line 265 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                if (t$49234) {
                    
                    //#line 266 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final x10.io.Printer t$49235 = ((x10.io.Printer)(x10.io.Console.get$OUT()));
                    
                    //#line 266 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final long t$49236 = f;
                    
                    //#line 266 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final java.lang.String t$49237 = (("*============step3end") + ((x10.core.Long.$box(t$49236))));
                    
                    //#line 266 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    t$49235.println(((java.lang.Object)(t$49237)));
                }
            }
            
            //#line 269 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            final long t$49238 = f;
            
            //#line 269 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            final long t$49239 = ((t$49238) + (((long)(1L))));
            
            //#line 269 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            f = t$49239;
            
            //#line 271 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            final long t$49240 = f;
            
            //#line 271 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            final boolean t$49241 = ((long) t$49240) == ((long) 1000L);
            
            //#line 271 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            if (t$49241) {
                
                //#line 274 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long i$45467min$48977 = 0L;
                
                //#line 274 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final x10.core.Rail t$48978 = ((x10.core.Rail)(out));
                
                //#line 274 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long t$48979 = ((x10.core.Rail<x10.core.Double>)t$48978).size;
                
                //#line 274 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long i$45467max$48980 = ((t$48979) - (((long)(1L))));
                
                //#line 274 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                long i$48974 = i$45467min$48977;
                
                //#line 274 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                for (;
                     true;
                     ) {
                    
                    //#line 274 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final long t$48975 = i$48974;
                    
                    //#line 274 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final boolean t$48976 = ((t$48975) <= (((long)(i$45467max$48980))));
                    
                    //#line 274 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    if (!(t$48976)) {
                        
                        //#line 274 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        break;
                    }
                    
                    //#line 274 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final long i$48971 = i$48974;
                    
                    //#line 275 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final x10.core.Rail t$48969 = ((x10.core.Rail)(out));
                    
                    //#line 275 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final double t$48970 = java.lang.Double.NaN;
                    
                    //#line 275 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    ((double[])t$48969.value)[(int)i$48971] = t$48970;
                    
                    //#line 274 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final long t$48972 = i$48974;
                    
                    //#line 274 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final long t$48973 = ((t$48972) + (((long)(1L))));
                    
                    //#line 274 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    i$48974 = t$48973;
                }
                
                //#line 278 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                repeat = false;
            }
            
            //#line 280 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            final boolean t$49243 = repeat;
            
            //#line 36 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            t$49242 = t$49243;
        }while(t$49242); 
        
        //#line 282 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        final long t$46883 = plham.util.Matrix.DEBUG;
        
        //#line 282 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        final boolean t$46894 = ((long) t$46883) == ((long) -2L);
        
        //#line 282 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        if (t$46894) {
            
            //#line 283 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            final x10.io.Printer t$46884 = ((x10.io.Printer)(x10.io.Console.get$OUT()));
            
            //#line 283 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            t$46884.println(((java.lang.Object)("**trueOPTIMAL")));
            
            //#line 284 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            final x10.core.Rail t$46885 = ((x10.core.Rail)(tout));
            
            //#line 284 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            plham.util.Matrix.dump__0$1x10$lang$Double$2(((x10.core.Rail)(t$46885)));
            
            //#line 285 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            final x10.io.Printer t$46886 = ((x10.io.Printer)(x10.io.Console.get$OUT()));
            
            //#line 285 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            t$46886.println(((java.lang.Object)("**continuousOPTIMAL")));
            
            //#line 286 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            final x10.core.Rail t$46887 = ((x10.core.Rail)(out));
            
            //#line 286 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            plham.util.Matrix.dump__0$1x10$lang$Double$2(((x10.core.Rail)(t$46887)));
            
            //#line 287 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            final x10.io.Printer t$46888 = ((x10.io.Printer)(x10.io.Console.get$OUT()));
            
            //#line 287 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            t$46888.println(((java.lang.Object)("**check")));
            
            //#line 288 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            final x10.core.Rail t$46889 = ((x10.core.Rail)(A));
            
            //#line 288 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            final x10.core.Rail t$46890 = ((x10.core.Rail)(B));
            
            //#line 288 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            final x10.core.Rail t$46891 = ((x10.core.Rail)(out));
            
            //#line 288 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            final x10.core.Rail t$46892 = plham.util.Matrix.activeCheck2__0$1x10$lang$Rail$1x10$lang$Double$2$2__1$1x10$lang$Double$2__2$1x10$lang$Double$2(((x10.core.Rail)(t$46889)), ((x10.core.Rail)(t$46890)), ((x10.core.Rail)(t$46891)));
            
            //#line 288 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            activeCheck = ((x10.core.Rail)(t$46892));
            
            //#line 289 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            final x10.io.Printer t$46893 = ((x10.io.Printer)(x10.io.Console.get$OUT()));
            
            //#line 289 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            t$46893.println(((java.lang.Object)("**check")));
        }
        
        //#line 292 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        final x10.core.Rail t$46895 = ((x10.core.Rail)(out));
        
        //#line 292 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        return t$46895;
    }
    
    
    //#line 297 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
    public static long getNumMinMinusY__0$1x10$lang$Double$2__1$1x10$lang$Boolean$2$O(final x10.core.Rail<x10.core.Double> y1, final x10.core.Rail<x10.core.Boolean> activeCheck) {
        
        //#line 298 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        long out = -1L;
        
        //#line 299 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        final double t$46896 = -1.0;
        
        //#line 299 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        final double t$46897 = plham.util.Matrix.epsilon;
        
        //#line 299 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        double min = -1.0E-6;
        
        //#line 300 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        long count = 0L;
        
        //#line 301 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        final long t$46898 = ((x10.core.Rail<x10.core.Boolean>)activeCheck).size;
        
        //#line 301 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        x10.core.Rail y = new x10.core.Rail<x10.core.Double>(x10.rtt.Types.DOUBLE, ((long)(t$46898)));
        
        //#line 302 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        final long i$45485min$49276 = 0L;
        
        //#line 302 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        final long t$49277 = ((x10.core.Rail<x10.core.Boolean>)activeCheck).size;
        
        //#line 302 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        final long i$45485max$49278 = ((t$49277) - (((long)(1L))));
        
        //#line 302 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        long i$49254 = i$45485min$49276;
        {
            
            //#line 302 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            final boolean[] activeCheck$value$51203 = ((boolean[])activeCheck.value);
            
            //#line 302 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            final double[] y1$value$51204 = ((double[])y1.value);
            
            //#line 302 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            for (;
                 true;
                 ) {
                
                //#line 302 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long t$49255 = i$49254;
                
                //#line 302 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final boolean t$49256 = ((t$49255) <= (((long)(i$45485max$49278))));
                
                //#line 302 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                if (!(t$49256)) {
                    
                    //#line 302 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    break;
                }
                
                //#line 302 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long i$49251 = i$49254;
                
                //#line 303 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final boolean t$49244 = ((boolean)activeCheck$value$51203[(int)i$49251]);
                
                //#line 303 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                if (t$49244) {
                    
                    //#line 304 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final x10.core.Rail t$49245 = ((x10.core.Rail)(y));
                    
                    //#line 304 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final long t$49246 = count;
                    
                    //#line 304 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final double t$49247 = ((double)y1$value$51204[(int)t$49246]);
                    
                    //#line 304 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    ((double[])t$49245.value)[(int)i$49251] = t$49247;
                    
                    //#line 305 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final long t$49248 = count;
                    
                    //#line 305 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final long t$49249 = ((t$49248) + (((long)(1L))));
                    
                    //#line 305 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    count = t$49249;
                } else {
                    
                    //#line 307 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final x10.core.Rail t$49250 = ((x10.core.Rail)(y));
                    
                    //#line 307 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    ((double[])t$49250.value)[(int)i$49251] = 0.0;
                }
                
                //#line 302 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long t$49252 = i$49254;
                
                //#line 302 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long t$49253 = ((t$49252) + (((long)(1L))));
                
                //#line 302 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                i$49254 = t$49253;
            }
        }
        
        //#line 310 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        final long i$45503min$49279 = 0L;
        
        //#line 310 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        final long t$49280 = ((x10.core.Rail<x10.core.Boolean>)activeCheck).size;
        
        //#line 310 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        final long i$45503max$49281 = ((t$49280) - (((long)(1L))));
        
        //#line 310 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        long i$49273 = i$45503min$49279;
        {
            
            //#line 310 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            final boolean[] activeCheck$value$51205 = ((boolean[])activeCheck.value);
            
            //#line 310 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            for (;
                 true;
                 ) {
                
                //#line 310 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long t$49274 = i$49273;
                
                //#line 310 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final boolean t$49275 = ((t$49274) <= (((long)(i$45503max$49281))));
                
                //#line 310 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                if (!(t$49275)) {
                    
                    //#line 310 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    break;
                }
                
                //#line 310 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long i$49270 = i$49273;
                
                //#line 311 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final boolean t$49257 = ((boolean)activeCheck$value$51205[(int)i$49270]);
                
                //#line 311 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                if (t$49257) {
                    
                    //#line 312 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final x10.core.Rail t$49258 = ((x10.core.Rail)(y));
                    
                    //#line 312 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final double t$49259 = ((double[])t$49258.value)[(int)i$49270];
                    
                    //#line 312 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final double t$49260 = min;
                    
                    //#line 312 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    boolean t$49261 = ((t$49259) < (((double)(t$49260))));
                    
                    //#line 312 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    if (t$49261) {
                        
                        //#line 312 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        final x10.core.Rail t$49262 = ((x10.core.Rail)(y));
                        
                        //#line 312 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        final double t$49263 = ((double[])t$49262.value)[(int)i$49270];
                        
                        //#line 312 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        final double t$49264 = -1.0;
                        
                        //#line 312 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        final double t$49265 = plham.util.Matrix.epsilon;
                        
                        //#line 312 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        final double t$49266 = -1.0E-6;
                        
                        //#line 312 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        t$49261 = ((t$49263) < (((double)(t$49266))));
                    }
                    
                    //#line 312 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final boolean t$49267 = t$49261;
                    
                    //#line 312 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    if (t$49267) {
                        
                        //#line 313 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        final x10.core.Rail t$49268 = ((x10.core.Rail)(y));
                        
                        //#line 313 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        final double t$49269 = ((double[])t$49268.value)[(int)i$49270];
                        
                        //#line 313 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        min = t$49269;
                        
                        //#line 314 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        out = i$49270;
                    }
                }
                
                //#line 310 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long t$49271 = i$49273;
                
                //#line 310 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long t$49272 = ((t$49271) + (((long)(1L))));
                
                //#line 310 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                i$49273 = t$49272;
            }
        }
        
        //#line 319 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        final long t$46931 = out;
        
        //#line 319 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        return t$46931;
    }
    
    
    //#line 323 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
    public static x10.core.Rail simplex__0$1x10$lang$Double$2__2$1x10$lang$Rail$1x10$lang$Double$2$2__3$1x10$lang$Double$2(final x10.core.Rail<x10.core.Double> obj, final double C, final x10.core.Rail<x10.core.Rail<x10.core.Double>> A, final x10.core.Rail<x10.core.Double> B) {
        
        //#line 324 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        long n = ((x10.core.Rail<x10.core.Double>)obj).size;
        
        //#line 325 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        long m = ((x10.core.Rail<x10.core.Rail<x10.core.Double>>)A).size;
        
        //#line 327 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        final long t$46932 = m;
        
        //#line 327 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        final long t$46933 = ((t$46932) + (((long)(1L))));
        
        //#line 327 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        x10.core.Rail simptable = new x10.core.Rail<x10.core.Rail<x10.core.Double>>(x10.rtt.ParameterizedType.make(x10.core.Rail.$RTT, x10.rtt.Types.DOUBLE), t$46933);
        
        //#line 328 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        final long i$45521min$49404 = 0L;
        
        //#line 328 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        final long i$45521max$49405 = m;
        
        //#line 328 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        long i$49293 = i$45521min$49404;
        
        //#line 328 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        for (;
             true;
             ) {
            
            //#line 328 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            final long t$49294 = i$49293;
            
            //#line 328 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            final boolean t$49295 = ((t$49294) <= (((long)(i$45521max$49405))));
            
            //#line 328 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            if (!(t$49295)) {
                
                //#line 328 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                break;
            }
            
            //#line 328 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            final long i$49290 = i$49293;
            
            //#line 329 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            final x10.core.Rail t$49282 = ((x10.core.Rail)(simptable));
            
            //#line 329 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            final long t$49283 = n;
            
            //#line 329 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            final long t$49284 = ((2L) * (((long)(t$49283))));
            
            //#line 329 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            final long t$49285 = m;
            
            //#line 329 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            final long t$49286 = ((2L) * (((long)(t$49285))));
            
            //#line 329 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            final long t$49287 = ((t$49284) + (((long)(t$49286))));
            
            //#line 329 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            final long t$49288 = ((t$49287) + (((long)(1L))));
            
            //#line 329 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            final x10.core.Rail t$49289 = ((x10.core.Rail)(new x10.core.Rail<x10.core.Double>(x10.rtt.Types.DOUBLE, t$49288)));
            
            //#line 329 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            ((x10.core.Rail[])t$49282.value)[(int)i$49290] = t$49289;
            
            //#line 328 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            final long t$49291 = i$49293;
            
            //#line 328 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            final long t$49292 = ((t$49291) + (((long)(1L))));
            
            //#line 328 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            i$49293 = t$49292;
        }
        
        //#line 332 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        final long i$45557min$49406 = 0L;
        
        //#line 332 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        final long t$49407 = m;
        
        //#line 332 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        final long i$45557max$49408 = ((t$49407) - (((long)(1L))));
        
        //#line 332 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        long i$49376 = i$45557min$49406;
        {
            
            //#line 332 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            final x10.core.Rail[] A$value$51206 = ((x10.core.Rail[])A.value);
            
            //#line 332 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            final double[] B$value$51207 = ((double[])B.value);
            
            //#line 332 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            for (;
                 true;
                 ) {
                
                //#line 332 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long t$49377 = i$49376;
                
                //#line 332 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final boolean t$49378 = ((t$49377) <= (((long)(i$45557max$49408))));
                
                //#line 332 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                if (!(t$49378)) {
                    
                    //#line 332 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    break;
                }
                
                //#line 332 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long i$49373 = i$49376;
                
                //#line 333 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long i$45539min$49343 = 0L;
                
                //#line 333 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long t$49344 = n;
                
                //#line 333 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long i$45539max$49345 = ((t$49344) - (((long)(1L))));
                
                //#line 333 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                long i$49311 = i$45539min$49343;
                {
                    
                    //#line 333 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    for (;
                         true;
                         ) {
                        
                        //#line 333 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        final long t$49312 = i$49311;
                        
                        //#line 333 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        final boolean t$49313 = ((t$49312) <= (((long)(i$45539max$49345))));
                        
                        //#line 333 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        if (!(t$49313)) {
                            
                            //#line 333 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                            break;
                        }
                        
                        //#line 333 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        final long j$49308 = i$49311;
                        
                        //#line 334 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        final x10.core.Rail t$49296 = ((x10.core.Rail)(simptable));
                        
                        //#line 334 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        final x10.core.Rail t$49297 = ((x10.core.Rail[])t$49296.value)[(int)i$49373];
                        
                        //#line 334 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        final x10.core.Rail t$49298 = ((x10.core.Rail<x10.core.Double>)A$value$51206[(int)i$49373]);
                        
                        //#line 334 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        final double t$49299 = ((double[])t$49298.value)[(int)j$49308];
                        
                        //#line 334 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        ((double[])t$49297.value)[(int)j$49308] = t$49299;
                        
                        //#line 335 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        final x10.core.Rail t$49300 = ((x10.core.Rail)(simptable));
                        
                        //#line 335 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        final x10.core.Rail t$49301 = ((x10.core.Rail[])t$49300.value)[(int)i$49373];
                        
                        //#line 335 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        final long t$49302 = n;
                        
                        //#line 335 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        final long t$49303 = ((t$49302) + (((long)(j$49308))));
                        
                        //#line 335 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        final double t$49304 = -1.0;
                        
                        //#line 335 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        final x10.core.Rail t$49305 = ((x10.core.Rail<x10.core.Double>)A$value$51206[(int)i$49373]);
                        
                        //#line 335 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        final double t$49306 = ((double[])t$49305.value)[(int)j$49308];
                        
                        //#line 335 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        final double t$49307 = ((t$49304) * (((double)(t$49306))));
                        
                        //#line 335 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        ((double[])t$49301.value)[(int)t$49303] = t$49307;
                        
                        //#line 333 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        final long t$49309 = i$49311;
                        
                        //#line 333 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        final long t$49310 = ((t$49309) + (((long)(1L))));
                        
                        //#line 333 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        i$49311 = t$49310;
                    }
                }
                
                //#line 337 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long t$49346 = n;
                
                //#line 337 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                long j$49347 = ((2L) * (((long)(t$49346))));
                
                //#line 337 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                for (;
                     true;
                     ) {
                    
                    //#line 337 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final long t$49348 = j$49347;
                    
                    //#line 337 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final long t$49349 = n;
                    
                    //#line 337 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final long t$49350 = ((2L) * (((long)(t$49349))));
                    
                    //#line 337 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final long t$49351 = m;
                    
                    //#line 337 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final long t$49352 = ((t$49350) + (((long)(t$49351))));
                    
                    //#line 337 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final boolean t$49353 = ((t$49348) < (((long)(t$49352))));
                    
                    //#line 337 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    if (!(t$49353)) {
                        
                        //#line 337 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        break;
                    }
                    
                    //#line 338 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final long t$49314 = j$49347;
                    
                    //#line 338 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final long t$49315 = n;
                    
                    //#line 338 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final long t$49316 = ((2L) * (((long)(t$49315))));
                    
                    //#line 338 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final long t$49317 = ((t$49314) - (((long)(t$49316))));
                    
                    //#line 338 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final boolean t$49318 = ((long) i$49373) == ((long) t$49317);
                    
                    //#line 338 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    if (t$49318) {
                        
                        //#line 339 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        final x10.core.Rail t$49319 = ((x10.core.Rail)(simptable));
                        
                        //#line 339 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        final x10.core.Rail t$49320 = ((x10.core.Rail[])t$49319.value)[(int)i$49373];
                        
                        //#line 339 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        final long t$49321 = j$49347;
                        
                        //#line 339 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        ((double[])t$49320.value)[(int)t$49321] = 1.0;
                    } else {
                        
                        //#line 341 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        final x10.core.Rail t$49322 = ((x10.core.Rail)(simptable));
                        
                        //#line 341 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        final x10.core.Rail t$49323 = ((x10.core.Rail[])t$49322.value)[(int)i$49373];
                        
                        //#line 341 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        final long t$49324 = j$49347;
                        
                        //#line 341 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        ((double[])t$49323.value)[(int)t$49324] = 0.0;
                    }
                    
                    //#line 337 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final long t$49325 = j$49347;
                    
                    //#line 337 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final long t$49326 = ((t$49325) + (((long)(1L))));
                    
                    //#line 337 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    j$49347 = t$49326;
                }
                
                //#line 344 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long t$49354 = n;
                
                //#line 344 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long t$49355 = ((2L) * (((long)(t$49354))));
                
                //#line 344 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long t$49356 = m;
                
                //#line 344 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                long j$49357 = ((t$49355) + (((long)(t$49356))));
                
                //#line 344 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                for (;
                     true;
                     ) {
                    
                    //#line 344 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final long t$49358 = j$49357;
                    
                    //#line 344 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final long t$49359 = n;
                    
                    //#line 344 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final long t$49360 = ((2L) * (((long)(t$49359))));
                    
                    //#line 344 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final long t$49361 = m;
                    
                    //#line 344 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final long t$49362 = ((2L) * (((long)(t$49361))));
                    
                    //#line 344 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final long t$49363 = ((t$49360) + (((long)(t$49362))));
                    
                    //#line 344 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final boolean t$49364 = ((t$49358) < (((long)(t$49363))));
                    
                    //#line 344 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    if (!(t$49364)) {
                        
                        //#line 344 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        break;
                    }
                    
                    //#line 345 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final long t$49327 = j$49357;
                    
                    //#line 345 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final long t$49328 = n;
                    
                    //#line 345 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final long t$49329 = ((2L) * (((long)(t$49328))));
                    
                    //#line 345 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final long t$49330 = ((t$49327) - (((long)(t$49329))));
                    
                    //#line 345 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final long t$49331 = m;
                    
                    //#line 345 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final long t$49332 = ((t$49330) - (((long)(t$49331))));
                    
                    //#line 345 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final boolean t$49333 = ((long) i$49373) == ((long) t$49332);
                    
                    //#line 345 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    if (t$49333) {
                        
                        //#line 346 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        final x10.core.Rail t$49334 = ((x10.core.Rail)(simptable));
                        
                        //#line 346 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        final x10.core.Rail t$49335 = ((x10.core.Rail[])t$49334.value)[(int)i$49373];
                        
                        //#line 346 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        final long t$49336 = j$49357;
                        
                        //#line 346 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        final double t$49337 = -1.0;
                        
                        //#line 346 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        ((double[])t$49335.value)[(int)t$49336] = t$49337;
                    } else {
                        
                        //#line 348 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        final x10.core.Rail t$49338 = ((x10.core.Rail)(simptable));
                        
                        //#line 348 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        final x10.core.Rail t$49339 = ((x10.core.Rail[])t$49338.value)[(int)i$49373];
                        
                        //#line 348 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        final long t$49340 = j$49357;
                        
                        //#line 348 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        ((double[])t$49339.value)[(int)t$49340] = 0.0;
                    }
                    
                    //#line 344 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final long t$49341 = j$49357;
                    
                    //#line 344 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final long t$49342 = ((t$49341) + (((long)(1L))));
                    
                    //#line 344 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    j$49357 = t$49342;
                }
                
                //#line 351 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final x10.core.Rail t$49365 = ((x10.core.Rail)(simptable));
                
                //#line 351 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final x10.core.Rail t$49366 = ((x10.core.Rail[])t$49365.value)[(int)i$49373];
                
                //#line 351 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long t$49367 = n;
                
                //#line 351 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long t$49368 = ((2L) * (((long)(t$49367))));
                
                //#line 351 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long t$49369 = m;
                
                //#line 351 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long t$49370 = ((2L) * (((long)(t$49369))));
                
                //#line 351 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long t$49371 = ((t$49368) + (((long)(t$49370))));
                
                //#line 351 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final double t$49372 = ((double)B$value$51207[(int)i$49373]);
                
                //#line 351 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                ((double[])t$49366.value)[(int)t$49371] = t$49372;
                
                //#line 332 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long t$49374 = i$49376;
                
                //#line 332 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long t$49375 = ((t$49374) + (((long)(1L))));
                
                //#line 332 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                i$49376 = t$49375;
            }
        }
        
        //#line 354 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        final long i$45575min$49409 = 0L;
        
        //#line 354 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        final long t$49410 = n;
        
        //#line 354 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        final long i$45575max$49411 = ((t$49410) - (((long)(1L))));
        
        //#line 354 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        long i$49394 = i$45575min$49409;
        {
            
            //#line 354 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            final double[] obj$value$51208 = ((double[])obj.value);
            
            //#line 354 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            for (;
                 true;
                 ) {
                
                //#line 354 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long t$49395 = i$49394;
                
                //#line 354 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final boolean t$49396 = ((t$49395) <= (((long)(i$45575max$49411))));
                
                //#line 354 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                if (!(t$49396)) {
                    
                    //#line 354 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    break;
                }
                
                //#line 354 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long j$49391 = i$49394;
                
                //#line 355 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final x10.core.Rail t$49379 = ((x10.core.Rail)(simptable));
                
                //#line 355 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long t$49380 = m;
                
                //#line 355 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final x10.core.Rail t$49381 = ((x10.core.Rail[])t$49379.value)[(int)t$49380];
                
                //#line 355 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final double t$49382 = ((double)obj$value$51208[(int)j$49391]);
                
                //#line 355 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                ((double[])t$49381.value)[(int)j$49391] = t$49382;
                
                //#line 356 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final x10.core.Rail t$49383 = ((x10.core.Rail)(simptable));
                
                //#line 356 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long t$49384 = m;
                
                //#line 356 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final x10.core.Rail t$49385 = ((x10.core.Rail[])t$49383.value)[(int)t$49384];
                
                //#line 356 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long t$49386 = n;
                
                //#line 356 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long t$49387 = ((t$49386) + (((long)(j$49391))));
                
                //#line 356 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final double t$49388 = -1.0;
                
                //#line 356 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final double t$49389 = ((double)obj$value$51208[(int)j$49391]);
                
                //#line 356 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final double t$49390 = ((t$49388) * (((double)(t$49389))));
                
                //#line 356 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                ((double[])t$49385.value)[(int)t$49387] = t$49390;
                
                //#line 354 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long t$49392 = i$49394;
                
                //#line 354 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long t$49393 = ((t$49392) + (((long)(1L))));
                
                //#line 354 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                i$49394 = t$49393;
            }
        }
        
        //#line 358 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        final long t$49412 = n;
        
        //#line 358 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        long j$49413 = ((2L) * (((long)(t$49412))));
        
        //#line 358 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        for (;
             true;
             ) {
            
            //#line 358 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            final long t$49414 = j$49413;
            
            //#line 358 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            final long t$49415 = n;
            
            //#line 358 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            final long t$49416 = ((2L) * (((long)(t$49415))));
            
            //#line 358 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            final long t$49417 = m;
            
            //#line 358 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            final long t$49418 = ((2L) * (((long)(t$49417))));
            
            //#line 358 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            final long t$49419 = ((t$49416) + (((long)(t$49418))));
            
            //#line 358 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            final boolean t$49420 = ((t$49414) < (((long)(t$49419))));
            
            //#line 358 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            if (!(t$49420)) {
                
                //#line 358 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                break;
            }
            
            //#line 359 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            final x10.core.Rail t$49397 = ((x10.core.Rail)(simptable));
            
            //#line 359 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            final long t$49398 = m;
            
            //#line 359 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            final x10.core.Rail t$49399 = ((x10.core.Rail[])t$49397.value)[(int)t$49398];
            
            //#line 359 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            final long t$49400 = j$49413;
            
            //#line 359 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            final double t$49401 = ((double)(long)(((long)(0L))));
            
            //#line 359 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            ((double[])t$49399.value)[(int)t$49400] = t$49401;
            
            //#line 358 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            final long t$49402 = j$49413;
            
            //#line 358 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            final long t$49403 = ((t$49402) + (((long)(1L))));
            
            //#line 358 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            j$49413 = t$49403;
        }
        
        //#line 361 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        final x10.core.Rail t$47061 = ((x10.core.Rail)(simptable));
        
        //#line 361 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        final long t$47062 = m;
        
        //#line 361 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        final x10.core.Rail t$47067 = ((x10.core.Rail[])t$47061.value)[(int)t$47062];
        
        //#line 361 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        final long t$47063 = n;
        
        //#line 361 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        final long t$47065 = ((2L) * (((long)(t$47063))));
        
        //#line 361 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        final long t$47064 = m;
        
        //#line 361 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        final long t$47066 = ((2L) * (((long)(t$47064))));
        
        //#line 361 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        final long t$47068 = ((t$47065) + (((long)(t$47066))));
        
        //#line 361 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        ((double[])t$47067.value)[(int)t$47068] = C;
        
        //#line 363 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        final x10.io.Printer t$47069 = ((x10.io.Printer)(x10.io.Console.get$OUT()));
        
        //#line 363 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        t$47069.println(((java.lang.Object)("*simpTable")));
        
        //#line 364 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        final x10.core.Rail t$47070 = ((x10.core.Rail)(simptable));
        
        //#line 364 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        plham.util.Matrix.dump__0$1x10$lang$Rail$1x10$lang$Double$2$2(((x10.core.Rail)(t$47070)));
        
        //#line 366 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        final x10.core.Rail t$47071 = ((x10.core.Rail)(simptable));
        
        //#line 366 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        final long t$47072 = n;
        
        //#line 366 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        final long t$47073 = m;
        
        //#line 366 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        final x10.core.Rail t$47074 = plham.util.Matrix.simplex__0$1x10$lang$Rail$1x10$lang$Double$2$2(((x10.core.Rail)(t$47071)), (long)(t$47072), (long)(t$47073));
        
        //#line 366 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        return t$47074;
    }
    
    
    //#line 372 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
    public static x10.core.Rail simplex__0$1x10$lang$Rail$1x10$lang$Double$2$2(final x10.core.Rail<x10.core.Rail<x10.core.Double>> C, final long n, final long m) {
        
        //#line 373 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        assert ((long) ((x10.core.Rail<x10.core.Rail<x10.core.Double>>)C).size) == ((long) ((m) + (((long)(1L))))): "simplexError1";
        
        //#line 374 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        assert ((long) ((x10.core.Rail<x10.core.Double>)((x10.core.Rail[])C.value)[(int)0L]).size) == ((long) ((((((2L) * (((long)(n))))) + (((long)(((2L) * (((long)(m))))))))) + (((long)(1L))))): "simplexError2";
        
        //#line 375 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        long count = 0L;
        
        //#line 376 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        boolean repeat = true;
        
        //#line 377 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        final long t$47075 = ((m) + (((long)(1L))));
        
        //#line 377 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        x10.core.Rail A = new x10.core.Rail<x10.core.Rail<x10.core.Double>>(x10.rtt.ParameterizedType.make(x10.core.Rail.$RTT, x10.rtt.Types.DOUBLE), t$47075);
        
        //#line 378 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        final long i$45593min$49748 = 0L;
        
        //#line 378 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        final long i$45593max$49749 = m;
        
        //#line 378 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        long i$49430 = i$45593min$49748;
        
        //#line 378 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        for (;
             true;
             ) {
            
            //#line 378 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            final long t$49431 = i$49430;
            
            //#line 378 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            final boolean t$49432 = ((t$49431) <= (((long)(i$45593max$49749))));
            
            //#line 378 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            if (!(t$49432)) {
                
                //#line 378 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                break;
            }
            
            //#line 378 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            final long i$49427 = i$49430;
            
            //#line 379 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            final x10.core.Rail t$49421 = ((x10.core.Rail)(A));
            
            //#line 379 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            final long t$49422 = ((2L) * (((long)(n))));
            
            //#line 379 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            final long t$49423 = ((2L) * (((long)(m))));
            
            //#line 379 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            final long t$49424 = ((t$49422) + (((long)(t$49423))));
            
            //#line 379 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            final long t$49425 = ((t$49424) + (((long)(1L))));
            
            //#line 379 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            final x10.core.Rail t$49426 = ((x10.core.Rail)(new x10.core.Rail<x10.core.Double>(x10.rtt.Types.DOUBLE, t$49425)));
            
            //#line 379 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            ((x10.core.Rail[])t$49421.value)[(int)i$49427] = t$49426;
            
            //#line 378 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            final long t$49428 = i$49430;
            
            //#line 378 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            final long t$49429 = ((t$49428) + (((long)(1L))));
            
            //#line 378 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            i$49430 = t$49429;
        }
        
        //#line 381 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        final long i$45629min$49750 = 0L;
        
        //#line 381 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        final long i$45629max$49751 = ((m) - (((long)(1L))));
        
        //#line 381 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        long i$49463 = i$45629min$49750;
        {
            
            //#line 381 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            final x10.core.Rail[] C$value$51209 = ((x10.core.Rail[])C.value);
            
            //#line 381 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            for (;
                 true;
                 ) {
                
                //#line 381 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long t$49464 = i$49463;
                
                //#line 381 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final boolean t$49465 = ((t$49464) <= (((long)(i$45629max$49751))));
                
                //#line 381 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                if (!(t$49465)) {
                    
                    //#line 381 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    break;
                }
                
                //#line 381 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long i$49460 = i$49463;
                
                //#line 382 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long i$45611min$49456 = 0L;
                
                //#line 382 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long t$49457 = ((2L) * (((long)(m))));
                
                //#line 382 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long t$49458 = ((2L) * (((long)(n))));
                
                //#line 382 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long i$45611max$49459 = ((t$49457) + (((long)(t$49458))));
                
                //#line 382 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                long i$49453 = i$45611min$49456;
                {
                    
                    //#line 382 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    for (;
                         true;
                         ) {
                        
                        //#line 382 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        final long t$49454 = i$49453;
                        
                        //#line 382 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        final boolean t$49455 = ((t$49454) <= (((long)(i$45611max$49459))));
                        
                        //#line 382 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        if (!(t$49455)) {
                            
                            //#line 382 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                            break;
                        }
                        
                        //#line 382 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        final long j$49450 = i$49453;
                        
                        //#line 383 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        final x10.core.Rail t$49433 = ((x10.core.Rail<x10.core.Double>)C$value$51209[(int)i$49460]);
                        
                        //#line 383 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        final long t$49434 = ((2L) * (((long)(m))));
                        
                        //#line 383 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        final long t$49435 = ((2L) * (((long)(n))));
                        
                        //#line 383 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        final long t$49436 = ((t$49434) + (((long)(t$49435))));
                        
                        //#line 383 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        final double t$49437 = ((double[])t$49433.value)[(int)t$49436];
                        
                        //#line 383 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        final double t$49438 = ((double)(long)(((long)(0L))));
                        
                        //#line 383 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        final boolean t$49439 = ((t$49437) >= (((double)(t$49438))));
                        
                        //#line 383 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        if (t$49439) {
                            
                            //#line 384 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                            final x10.core.Rail t$49440 = ((x10.core.Rail)(A));
                            
                            //#line 384 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                            final x10.core.Rail t$49441 = ((x10.core.Rail[])t$49440.value)[(int)i$49460];
                            
                            //#line 384 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                            final x10.core.Rail t$49442 = ((x10.core.Rail<x10.core.Double>)C$value$51209[(int)i$49460]);
                            
                            //#line 384 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                            final double t$49443 = ((double[])t$49442.value)[(int)j$49450];
                            
                            //#line 384 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                            ((double[])t$49441.value)[(int)j$49450] = t$49443;
                        } else {
                            
                            //#line 386 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                            final x10.core.Rail t$49444 = ((x10.core.Rail)(A));
                            
                            //#line 386 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                            final x10.core.Rail t$49445 = ((x10.core.Rail[])t$49444.value)[(int)i$49460];
                            
                            //#line 386 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                            final double t$49446 = -1.0;
                            
                            //#line 386 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                            final x10.core.Rail t$49447 = ((x10.core.Rail<x10.core.Double>)C$value$51209[(int)i$49460]);
                            
                            //#line 386 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                            final double t$49448 = ((double[])t$49447.value)[(int)j$49450];
                            
                            //#line 386 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                            final double t$49449 = ((t$49446) * (((double)(t$49448))));
                            
                            //#line 386 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                            ((double[])t$49445.value)[(int)j$49450] = t$49449;
                        }
                        
                        //#line 382 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        final long t$49451 = i$49453;
                        
                        //#line 382 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        final long t$49452 = ((t$49451) + (((long)(1L))));
                        
                        //#line 382 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        i$49453 = t$49452;
                    }
                }
                
                //#line 381 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long t$49461 = i$49463;
                
                //#line 381 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long t$49462 = ((t$49461) + (((long)(1L))));
                
                //#line 381 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                i$49463 = t$49462;
            }
        }
        
        //#line 390 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        final long i$45647min$49752 = 0L;
        
        //#line 390 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        final long t$49753 = ((2L) * (((long)(m))));
        
        //#line 390 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        final long t$49754 = ((2L) * (((long)(n))));
        
        //#line 390 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        final long i$45647max$49755 = ((t$49753) + (((long)(t$49754))));
        
        //#line 390 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        long i$49473 = i$45647min$49752;
        {
            
            //#line 390 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            final x10.core.Rail[] C$value$51210 = ((x10.core.Rail[])C.value);
            
            //#line 390 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            for (;
                 true;
                 ) {
                
                //#line 390 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long t$49474 = i$49473;
                
                //#line 390 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final boolean t$49475 = ((t$49474) <= (((long)(i$45647max$49755))));
                
                //#line 390 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                if (!(t$49475)) {
                    
                    //#line 390 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    break;
                }
                
                //#line 390 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long j$49470 = i$49473;
                
                //#line 391 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final x10.core.Rail t$49466 = ((x10.core.Rail)(A));
                
                //#line 391 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final x10.core.Rail t$49467 = ((x10.core.Rail[])t$49466.value)[(int)m];
                
                //#line 391 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final x10.core.Rail t$49468 = ((x10.core.Rail<x10.core.Double>)C$value$51210[(int)m]);
                
                //#line 391 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final double t$49469 = ((double[])t$49468.value)[(int)j$49470];
                
                //#line 391 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                ((double[])t$49467.value)[(int)j$49470] = t$49469;
                
                //#line 390 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long t$49471 = i$49473;
                
                //#line 390 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long t$49472 = ((t$49471) + (((long)(1L))));
                
                //#line 390 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                i$49473 = t$49472;
            }
        }
        
        //#line 395 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        final x10.io.Printer t$47127 = ((x10.io.Printer)(x10.io.Console.get$OUT()));
        
        //#line 395 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        t$47127.println(((java.lang.Object)("*simpTable")));
        
        //#line 396 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        final x10.core.Rail t$47128 = ((x10.core.Rail)(A));
        
        //#line 396 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        plham.util.Matrix.dump__0$1x10$lang$Rail$1x10$lang$Double$2$2(((x10.core.Rail)(t$47128)));
        
        //#line 398 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        boolean t$49756 = false;
        
        //#line 398 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        do  {
            
            //#line 399 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            final x10.io.Printer t$49632 = ((x10.io.Printer)(x10.io.Console.get$OUT()));
            
            //#line 399 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            final long t$49633 = count;
            
            //#line 399 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            final java.lang.String t$49634 = (("*============step") + ((x10.core.Long.$box(t$49633))));
            
            //#line 399 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            t$49632.println(((java.lang.Object)(t$49634)));
            
            //#line 400 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            final long t$49635 = ((2L) * (((long)(n))));
            
            //#line 400 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            x10.core.Rail delta$49636 = new x10.core.Rail<x10.core.Double>(x10.rtt.Types.DOUBLE, t$49635);
            
            //#line 401 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            final long t$49637 = ((2L) * (((long)(n))));
            
            //#line 401 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            x10.core.Rail index$49638 = new x10.core.Rail<x10.core.Long>(x10.rtt.Types.LONG, t$49637);
            
            //#line 402 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            final long i$45683min$49626 = 0L;
            
            //#line 402 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            final long t$49627 = ((2L) * (((long)(n))));
            
            //#line 402 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            final long i$45683max$49628 = ((t$49627) - (((long)(1L))));
            
            //#line 402 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            long i$49550 = i$45683min$49626;
            
            //#line 402 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            for (;
                 true;
                 ) {
                
                //#line 402 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long t$49551 = i$49550;
                
                //#line 402 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final boolean t$49552 = ((t$49551) <= (((long)(i$45683max$49628))));
                
                //#line 402 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                if (!(t$49552)) {
                    
                    //#line 402 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    break;
                }
                
                //#line 402 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long k$49547 = i$49550;
                
                //#line 403 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final x10.io.Printer t$49515 = ((x10.io.Printer)(x10.io.Console.get$OUT()));
                
                //#line 403 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final java.lang.String t$49516 = (("**k=") + ((x10.core.Long.$box(k$49547))));
                
                //#line 403 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                t$49515.println(((java.lang.Object)(t$49516)));
                
                //#line 404 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final x10.core.Rail t$49517 = ((x10.core.Rail)(A));
                
                //#line 404 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final x10.core.Rail t$49518 = ((x10.core.Rail[])t$49517.value)[(int)m];
                
                //#line 404 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final double t$49519 = ((double[])t$49518.value)[(int)k$49547];
                
                //#line 404 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final double t$49520 = ((double)(long)(((long)(0L))));
                
                //#line 404 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final boolean t$49521 = ((t$49519) < (((double)(t$49520))));
                
                //#line 404 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                if (t$49521) {
                    
                    //#line 405 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    long id$49522 = -1L;
                    
                    //#line 408 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    double min$49523 = java.lang.Double.MAX_VALUE;
                    
                    //#line 409 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final long i$45665min$49513 = 0L;
                    
                    //#line 409 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final long i$45665max$49514 = ((m) - (((long)(1L))));
                    
                    //#line 409 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    long i$49510 = i$45665min$49513;
                    
                    //#line 409 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    for (;
                         true;
                         ) {
                        
                        //#line 409 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        final long t$49511 = i$49510;
                        
                        //#line 409 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        final boolean t$49512 = ((t$49511) <= (((long)(i$45665max$49514))));
                        
                        //#line 409 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        if (!(t$49512)) {
                            
                            //#line 409 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                            break;
                        }
                        
                        //#line 409 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        final long i$49507 = i$49510;
                        
                        //#line 411 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        double d$49476 = 0.0;
                        
                        //#line 412 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        final x10.core.Rail t$49477 = ((x10.core.Rail)(A));
                        
                        //#line 412 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        final x10.core.Rail t$49478 = ((x10.core.Rail[])t$49477.value)[(int)i$49507];
                        
                        //#line 412 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        final double t$49479 = ((double[])t$49478.value)[(int)k$49547];
                        
                        //#line 412 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        boolean t$49480 = ((t$49479) > (((double)(0.0))));
                        
                        //#line 412 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        if (t$49480) {
                            
                            //#line 412 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                            final x10.core.Rail t$49481 = ((x10.core.Rail)(A));
                            
                            //#line 412 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                            final x10.core.Rail t$49482 = ((x10.core.Rail[])t$49481.value)[(int)i$49507];
                            
                            //#line 412 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                            final long t$49483 = ((2L) * (((long)(n))));
                            
                            //#line 412 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                            final long t$49484 = ((2L) * (((long)(m))));
                            
                            //#line 412 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                            final long t$49485 = ((t$49483) + (((long)(t$49484))));
                            
                            //#line 412 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                            final double t$49486 = ((double[])t$49482.value)[(int)t$49485];
                            
                            //#line 412 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                            t$49480 = ((t$49486) >= (((double)(0.0))));
                        }
                        
                        //#line 412 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        final boolean t$49487 = t$49480;
                        
                        //#line 412 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        if (t$49487) {
                            
                            //#line 413 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                            final x10.core.Rail t$49488 = ((x10.core.Rail)(A));
                            
                            //#line 413 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                            final x10.core.Rail t$49489 = ((x10.core.Rail[])t$49488.value)[(int)i$49507];
                            
                            //#line 413 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                            final long t$49490 = ((2L) * (((long)(n))));
                            
                            //#line 413 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                            final long t$49491 = ((2L) * (((long)(m))));
                            
                            //#line 413 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                            final long t$49492 = ((t$49490) + (((long)(t$49491))));
                            
                            //#line 413 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                            final double t$49493 = ((double[])t$49489.value)[(int)t$49492];
                            
                            //#line 413 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                            final x10.core.Rail t$49494 = ((x10.core.Rail)(A));
                            
                            //#line 413 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                            final x10.core.Rail t$49495 = ((x10.core.Rail[])t$49494.value)[(int)i$49507];
                            
                            //#line 413 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                            final double t$49496 = ((double[])t$49495.value)[(int)k$49547];
                            
                            //#line 413 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                            final double t$49497 = ((t$49493) / (((double)(t$49496))));
                            
                            //#line 413 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                            d$49476 = t$49497;
                        }
                        
                        //#line 416 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        final x10.core.Rail t$49498 = ((x10.core.Rail)(A));
                        
                        //#line 416 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        final x10.core.Rail t$49499 = ((x10.core.Rail[])t$49498.value)[(int)i$49507];
                        
                        //#line 416 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        final double t$49500 = ((double[])t$49499.value)[(int)k$49547];
                        
                        //#line 416 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        final double t$49501 = ((double)(long)(((long)(0L))));
                        
                        //#line 416 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        boolean t$49502 = ((t$49500) > (((double)(t$49501))));
                        
                        //#line 416 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        if (t$49502) {
                            
                            //#line 416 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                            final double t$49503 = d$49476;
                            
                            //#line 416 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                            final double t$49504 = min$49523;
                            
                            //#line 416 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                            t$49502 = ((t$49503) < (((double)(t$49504))));
                        }
                        
                        //#line 416 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        final boolean t$49505 = t$49502;
                        
                        //#line 416 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        if (t$49505) {
                            
                            //#line 417 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                            final double t$49506 = d$49476;
                            
                            //#line 417 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                            min$49523 = t$49506;
                            
                            //#line 418 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                            id$49522 = i$49507;
                        }
                        
                        //#line 409 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        final long t$49508 = i$49510;
                        
                        //#line 409 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        final long t$49509 = ((t$49508) + (((long)(1L))));
                        
                        //#line 409 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        i$49510 = t$49509;
                    }
                    
                    //#line 422 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final double t$49524 = min$49523;
                    
                    //#line 422 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final double t$49525 = java.lang.Double.MAX_VALUE;
                    
                    //#line 422 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final boolean t$49526 = ((double) t$49524) != ((double) t$49525);
                    
                    //#line 422 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    if (t$49526) {
                        
                        //#line 423 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        final x10.core.Rail t$49527 = ((x10.core.Rail)(delta$49636));
                        
                        //#line 423 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        final double t$49528 = min$49523;
                        
                        //#line 423 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        final x10.core.Rail t$49529 = ((x10.core.Rail)(A));
                        
                        //#line 423 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        final x10.core.Rail t$49530 = ((x10.core.Rail[])t$49529.value)[(int)m];
                        
                        //#line 423 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        final double t$49531 = ((double[])t$49530.value)[(int)k$49547];
                        
                        //#line 423 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        final double t$49532 = ((t$49528) * (((double)(t$49531))));
                        
                        //#line 423 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        ((double[])t$49527.value)[(int)k$49547] = t$49532;
                        
                        //#line 424 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        final x10.core.Rail t$49533 = ((x10.core.Rail)(index$49638));
                        
                        //#line 424 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        final long t$49534 = id$49522;
                        
                        //#line 424 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        ((long[])t$49533.value)[(int)k$49547] = t$49534;
                    } else {
                        
                        //#line 426 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        final x10.core.Rail t$49535 = ((x10.core.Rail)(delta$49636));
                        
                        //#line 426 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        ((double[])t$49535.value)[(int)k$49547] = 0.0;
                        
                        //#line 427 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        final x10.core.Rail t$49536 = ((x10.core.Rail)(index$49638));
                        
                        //#line 427 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        ((long[])t$49536.value)[(int)k$49547] = -1L;
                    }
                } else {
                    
                    //#line 431 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final x10.core.Rail t$49537 = ((x10.core.Rail)(delta$49636));
                    
                    //#line 431 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    ((double[])t$49537.value)[(int)k$49547] = 0.0;
                    
                    //#line 432 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final x10.core.Rail t$49538 = ((x10.core.Rail)(index$49638));
                    
                    //#line 432 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    ((long[])t$49538.value)[(int)k$49547] = -1L;
                }
                
                //#line 434 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final x10.io.Printer t$49539 = ((x10.io.Printer)(x10.io.Console.get$OUT()));
                
                //#line 434 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final x10.core.Rail t$49540 = ((x10.core.Rail)(delta$49636));
                
                //#line 434 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final double t$49541 = ((double[])t$49540.value)[(int)k$49547];
                
                //#line 434 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final java.lang.String t$49542 = (("delta=") + ((x10.core.Double.$box(t$49541))));
                
                //#line 434 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                t$49539.println(((java.lang.Object)(t$49542)));
                
                //#line 435 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final x10.io.Printer t$49543 = ((x10.io.Printer)(x10.io.Console.get$OUT()));
                
                //#line 435 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final x10.core.Rail t$49544 = ((x10.core.Rail)(index$49638));
                
                //#line 435 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long t$49545 = ((long[])t$49544.value)[(int)k$49547];
                
                //#line 435 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final java.lang.String t$49546 = (("index=") + ((x10.core.Long.$box(t$49545))));
                
                //#line 435 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                t$49543.println(((java.lang.Object)(t$49546)));
                
                //#line 402 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long t$49548 = i$49550;
                
                //#line 402 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long t$49549 = ((t$49548) + (((long)(1L))));
                
                //#line 402 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                i$49550 = t$49549;
            }
            
            //#line 439 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            long selected$49639 = -1L;
            
            //#line 440 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            double minDelta$49640 = 0.0;
            
            //#line 441 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            final long i$45701min$49629 = 0L;
            
            //#line 441 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            final long t$49630 = ((2L) * (((long)(n))));
            
            //#line 441 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            final long i$45701max$49631 = ((t$49630) - (((long)(1L))));
            
            //#line 441 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            long i$49562 = i$45701min$49629;
            
            //#line 441 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            for (;
                 true;
                 ) {
                
                //#line 441 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long t$49563 = i$49562;
                
                //#line 441 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final boolean t$49564 = ((t$49563) <= (((long)(i$45701max$49631))));
                
                //#line 441 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                if (!(t$49564)) {
                    
                    //#line 441 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    break;
                }
                
                //#line 441 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long k$49559 = i$49562;
                
                //#line 442 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final x10.core.Rail t$49553 = ((x10.core.Rail)(delta$49636));
                
                //#line 442 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final double t$49554 = ((double[])t$49553.value)[(int)k$49559];
                
                //#line 442 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final double t$49555 = minDelta$49640;
                
                //#line 442 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final boolean t$49556 = ((t$49554) < (((double)(t$49555))));
                
                //#line 442 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                if (t$49556) {
                    
                    //#line 443 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final x10.core.Rail t$49557 = ((x10.core.Rail)(delta$49636));
                    
                    //#line 443 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final double t$49558 = ((double[])t$49557.value)[(int)k$49559];
                    
                    //#line 443 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    minDelta$49640 = t$49558;
                    
                    //#line 444 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    selected$49639 = k$49559;
                }
                
                //#line 441 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long t$49560 = i$49562;
                
                //#line 441 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long t$49561 = ((t$49560) + (((long)(1L))));
                
                //#line 441 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                i$49562 = t$49561;
            }
            
            //#line 448 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            final x10.io.Printer t$49641 = ((x10.io.Printer)(x10.io.Console.get$OUT()));
            
            //#line 448 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            final double t$49642 = minDelta$49640;
            
            //#line 448 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            final java.lang.String t$49643 = (("*minDelta=") + ((x10.core.Double.$box(t$49642))));
            
            //#line 448 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            t$49641.println(((java.lang.Object)(t$49643)));
            
            //#line 449 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            final x10.io.Printer t$49644 = ((x10.io.Printer)(x10.io.Console.get$OUT()));
            
            //#line 449 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            final long t$49645 = selected$49639;
            
            //#line 449 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            final java.lang.String t$49646 = (("*selected=") + ((x10.core.Long.$box(t$49645))));
            
            //#line 449 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            t$49644.println(((java.lang.Object)(t$49646)));
            
            //#line 450 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            final long t$49647 = selected$49639;
            
            //#line 450 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            final boolean t$49648 = ((long) t$49647) == ((long) -1L);
            
            //#line 450 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            if (t$49648) {
                
                //#line 450 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                repeat = false;
            } else {
                
                //#line 451 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final x10.io.Printer t$49649 = ((x10.io.Printer)(x10.io.Console.get$OUT()));
                
                //#line 451 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long t$49650 = selected$49639;
                
                //#line 451 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final java.lang.String t$49651 = (("*pivot(") + ((x10.core.Long.$box(t$49650))));
                
                //#line 451 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final java.lang.String t$49652 = ((t$49651) + (")("));
                
                //#line 451 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final x10.core.Rail t$49653 = ((x10.core.Rail)(index$49638));
                
                //#line 451 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long t$49654 = selected$49639;
                
                //#line 451 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long t$49655 = ((long[])t$49653.value)[(int)t$49654];
                
                //#line 451 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final java.lang.String t$49656 = ((t$49652) + ((x10.core.Long.$box(t$49655))));
                
                //#line 451 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final java.lang.String t$49657 = ((t$49656) + (")="));
                
                //#line 451 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                t$49649.print(((java.lang.String)(t$49657)));
                
                //#line 452 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final x10.core.Rail t$49658 = ((x10.core.Rail)(A));
                
                //#line 452 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long t$49659 = selected$49639;
                
                //#line 452 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final x10.core.Rail t$49660 = ((x10.core.Rail[])t$49658.value)[(int)t$49659];
                
                //#line 452 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final x10.core.Rail t$49661 = ((x10.core.Rail)(index$49638));
                
                //#line 452 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long t$49662 = selected$49639;
                
                //#line 452 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long t$49663 = ((long[])t$49661.value)[(int)t$49662];
                
                //#line 452 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                double pivot$49664 = ((double[])t$49660.value)[(int)t$49663];
                
                //#line 453 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final x10.io.Printer t$49665 = ((x10.io.Printer)(x10.io.Console.get$OUT()));
                
                //#line 453 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final double t$49666 = pivot$49664;
                
                //#line 453 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                t$49665.println(x10.core.Double.$box(t$49666));
                
                //#line 456 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long i$45719min$49620 = 0L;
                
                //#line 456 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long t$49621 = ((2L) * (((long)(n))));
                
                //#line 456 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long t$49622 = ((2L) * (((long)(m))));
                
                //#line 456 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long i$45719max$49623 = ((t$49621) + (((long)(t$49622))));
                
                //#line 456 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                long i$49577 = i$45719min$49620;
                
                //#line 456 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                for (;
                     true;
                     ) {
                    
                    //#line 456 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final long t$49578 = i$49577;
                    
                    //#line 456 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final boolean t$49579 = ((t$49578) <= (((long)(i$45719max$49623))));
                    
                    //#line 456 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    if (!(t$49579)) {
                        
                        //#line 456 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        break;
                    }
                    
                    //#line 456 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final long j$49574 = i$49577;
                    
                    //#line 457 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final x10.core.Rail t$49565 = ((x10.core.Rail)(A));
                    
                    //#line 457 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final long t$49566 = selected$49639;
                    
                    //#line 457 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final x10.core.Rail t$49567 = ((x10.core.Rail[])t$49565.value)[(int)t$49566];
                    
                    //#line 457 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final x10.core.Rail t$49568 = ((x10.core.Rail)(A));
                    
                    //#line 457 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final long t$49569 = selected$49639;
                    
                    //#line 457 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final x10.core.Rail t$49570 = ((x10.core.Rail[])t$49568.value)[(int)t$49569];
                    
                    //#line 457 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final double t$49571 = ((double[])t$49570.value)[(int)j$49574];
                    
                    //#line 457 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final double t$49572 = pivot$49664;
                    
                    //#line 457 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final double t$49573 = ((t$49571) / (((double)(t$49572))));
                    
                    //#line 457 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    ((double[])t$49567.value)[(int)j$49574] = t$49573;
                    
                    //#line 456 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final long t$49575 = i$49577;
                    
                    //#line 456 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final long t$49576 = ((t$49575) + (((long)(1L))));
                    
                    //#line 456 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    i$49577 = t$49576;
                }
                
                //#line 459 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final x10.io.Printer t$49667 = ((x10.io.Printer)(x10.io.Console.get$OUT()));
                
                //#line 459 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                t$49667.println(((java.lang.Object)("*A:\u30d4\u30dc\u30c3\u30c8\u884c\u306e\u8981\u7d20\u3092\u30d4\u30dc\u30c3\u30c8\u8981\u7d20\u3067\u5272\u308b")));
                
                //#line 460 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final x10.core.Rail t$49668 = ((x10.core.Rail)(A));
                
                //#line 460 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                plham.util.Matrix.dump__0$1x10$lang$Rail$1x10$lang$Double$2$2(((x10.core.Rail)(t$49668)));
                
                //#line 463 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long i$45755min$49624 = 0L;
                
                //#line 463 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long i$45755max$49625 = m;
                
                //#line 463 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                long i$49617 = i$45755min$49624;
                
                //#line 463 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                for (;
                     true;
                     ) {
                    
                    //#line 463 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final long t$49618 = i$49617;
                    
                    //#line 463 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final boolean t$49619 = ((t$49618) <= (((long)(i$45755max$49625))));
                    
                    //#line 463 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    if (!(t$49619)) {
                        
                        //#line 463 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        break;
                    }
                    
                    //#line 463 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final long i$49614 = i$49617;
                    
                    //#line 464 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final long t$49602 = selected$49639;
                    
                    //#line 464 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final boolean t$49603 = ((long) i$49614) != ((long) t$49602);
                    
                    //#line 464 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    if (t$49603) {
                        
                        //#line 465 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        final x10.core.Rail t$49604 = ((x10.core.Rail)(A));
                        
                        //#line 465 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        final x10.core.Rail t$49605 = ((x10.core.Rail[])t$49604.value)[(int)i$49614];
                        
                        //#line 465 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        final x10.core.Rail t$49606 = ((x10.core.Rail)(index$49638));
                        
                        //#line 465 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        final long t$49607 = selected$49639;
                        
                        //#line 465 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        final long t$49608 = ((long[])t$49606.value)[(int)t$49607];
                        
                        //#line 465 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        double d$49609 = ((double[])t$49605.value)[(int)t$49608];
                        
                        //#line 466 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        final long i$45737min$49598 = 0L;
                        
                        //#line 466 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        final long t$49599 = ((2L) * (((long)(n))));
                        
                        //#line 466 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        final long t$49600 = ((2L) * (((long)(m))));
                        
                        //#line 466 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        final long i$45737max$49601 = ((t$49599) + (((long)(t$49600))));
                        
                        //#line 466 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        long i$49595 = i$45737min$49598;
                        
                        //#line 466 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        for (;
                             true;
                             ) {
                            
                            //#line 466 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                            final long t$49596 = i$49595;
                            
                            //#line 466 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                            final boolean t$49597 = ((t$49596) <= (((long)(i$45737max$49601))));
                            
                            //#line 466 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                            if (!(t$49597)) {
                                
                                //#line 466 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                                break;
                            }
                            
                            //#line 466 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                            final long j$49592 = i$49595;
                            
                            //#line 467 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                            final x10.core.Rail t$49580 = ((x10.core.Rail)(A));
                            
                            //#line 467 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                            final x10.core.Rail t$49581 = ((x10.core.Rail[])t$49580.value)[(int)i$49614];
                            
                            //#line 467 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                            final x10.core.Rail t$49582 = ((x10.core.Rail)(A));
                            
                            //#line 467 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                            final x10.core.Rail t$49583 = ((x10.core.Rail[])t$49582.value)[(int)i$49614];
                            
                            //#line 467 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                            final double t$49584 = ((double[])t$49583.value)[(int)j$49592];
                            
                            //#line 467 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                            final x10.core.Rail t$49585 = ((x10.core.Rail)(A));
                            
                            //#line 467 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                            final long t$49586 = selected$49639;
                            
                            //#line 467 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                            final x10.core.Rail t$49587 = ((x10.core.Rail[])t$49585.value)[(int)t$49586];
                            
                            //#line 467 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                            final double t$49588 = ((double[])t$49587.value)[(int)j$49592];
                            
                            //#line 467 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                            final double t$49589 = d$49609;
                            
                            //#line 467 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                            final double t$49590 = ((t$49588) * (((double)(t$49589))));
                            
                            //#line 467 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                            final double t$49591 = ((t$49584) - (((double)(t$49590))));
                            
                            //#line 467 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                            ((double[])t$49581.value)[(int)j$49592] = t$49591;
                            
                            //#line 466 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                            final long t$49593 = i$49595;
                            
                            //#line 466 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                            final long t$49594 = ((t$49593) + (((long)(1L))));
                            
                            //#line 466 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                            i$49595 = t$49594;
                        }
                        
                        //#line 469 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        final x10.io.Printer t$49610 = ((x10.io.Printer)(x10.io.Console.get$OUT()));
                        
                        //#line 469 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        final java.lang.String t$49611 = (("*A:") + ((x10.core.Long.$box(i$49614))));
                        
                        //#line 469 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        final java.lang.String t$49612 = ((t$49611) + ("\u884c\u76ee\u306e\u5410\u304d\u51fa\u3057"));
                        
                        //#line 469 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        t$49610.println(((java.lang.Object)(t$49612)));
                        
                        //#line 470 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        final x10.core.Rail t$49613 = ((x10.core.Rail)(A));
                        
                        //#line 470 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        plham.util.Matrix.dump__0$1x10$lang$Rail$1x10$lang$Double$2$2(((x10.core.Rail)(t$49613)));
                    }
                    
                    //#line 463 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final long t$49615 = i$49617;
                    
                    //#line 463 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final long t$49616 = ((t$49615) + (((long)(1L))));
                    
                    //#line 463 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    i$49617 = t$49616;
                }
                
                //#line 473 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long t$49669 = count;
                
                //#line 473 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long t$49670 = ((t$49669) + (((long)(1L))));
                
                //#line 473 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                count = t$49670;
                
                //#line 474 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long t$49671 = count;
                
                //#line 474 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final boolean t$49672 = ((long) t$49671) == ((long) 2L);
                
                //#line 474 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                if (t$49672) {
                    
                    //#line 474 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    repeat = false;
                }
            }
            
            //#line 476 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            final boolean t$49757 = repeat;
            
            //#line 398 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            t$49756 = t$49757;
        }while(t$49756); 
        
        //#line 478 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        final x10.io.Printer t$47301 = ((x10.io.Printer)(x10.io.Console.get$OUT()));
        
        //#line 478 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        t$47301.println(((java.lang.Object)("*lastA")));
        
        //#line 479 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        final x10.core.Rail t$47302 = ((x10.core.Rail)(A));
        
        //#line 479 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        plham.util.Matrix.dump__0$1x10$lang$Rail$1x10$lang$Double$2$2(((x10.core.Rail)(t$47302)));
        
        //#line 481 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        x10.core.Rail out = new x10.core.Rail<x10.core.Double>(x10.rtt.Types.DOUBLE, ((long)(n)));
        
        //#line 482 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        final long i$45791min$49758 = 0L;
        
        //#line 482 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        final long i$45791max$49759 = ((m) - (((long)(1L))));
        
        //#line 482 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        long i$49707 = i$45791min$49758;
        
        //#line 482 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        for (;
             true;
             ) {
            
            //#line 482 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            final long t$49708 = i$49707;
            
            //#line 482 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            final boolean t$49709 = ((t$49708) <= (((long)(i$45791max$49759))));
            
            //#line 482 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            if (!(t$49709)) {
                
                //#line 482 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                break;
            }
            
            //#line 482 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            final long i$49704 = i$49707;
            
            //#line 483 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            final long i$45773min$49701 = 0L;
            
            //#line 483 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            final long t$49702 = ((2L) * (((long)(n))));
            
            //#line 483 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            final long i$45773max$49703 = ((t$49702) - (((long)(1L))));
            
            //#line 483 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            long i$49698 = i$45773min$49701;
            
            //#line 483 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            for (;
                 true;
                 ) {
                
                //#line 483 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long t$49699 = i$49698;
                
                //#line 483 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final boolean t$49700 = ((t$49699) <= (((long)(i$45773max$49703))));
                
                //#line 483 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                if (!(t$49700)) {
                    
                    //#line 483 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    break;
                }
                
                //#line 483 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long j$49695 = i$49698;
                
                //#line 484 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final x10.core.Rail t$49673 = ((x10.core.Rail)(A));
                
                //#line 484 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final x10.core.Rail t$49674 = ((x10.core.Rail[])t$49673.value)[(int)i$49704];
                
                //#line 484 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final double t$49675 = ((double[])t$49674.value)[(int)j$49695];
                
                //#line 484 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final boolean t$49676 = ((double) t$49675) == ((double) 1.0);
                
                //#line 484 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                if (t$49676) {
                    
                    //#line 486 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final boolean t$49677 = ((j$49695) < (((long)(n))));
                    
                    //#line 486 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    if (t$49677) {
                        
                        //#line 487 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        final x10.core.Rail t$49678 = ((x10.core.Rail)(out));
                        
                        //#line 487 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        final x10.core.Rail t$49679 = ((x10.core.Rail)(A));
                        
                        //#line 487 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        final x10.core.Rail t$49680 = ((x10.core.Rail[])t$49679.value)[(int)i$49704];
                        
                        //#line 487 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        final long t$49681 = ((2L) * (((long)(n))));
                        
                        //#line 487 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        final long t$49682 = ((2L) * (((long)(m))));
                        
                        //#line 487 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        final long t$49683 = ((t$49681) + (((long)(t$49682))));
                        
                        //#line 487 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        final double t$49684 = ((double[])t$49680.value)[(int)t$49683];
                        
                        //#line 487 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        ((double[])t$49678.value)[(int)j$49695] = t$49684;
                    } else {
                        
                        //#line 489 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        final x10.core.Rail t$49685 = ((x10.core.Rail)(out));
                        
                        //#line 489 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        final long t$49686 = ((j$49695) - (((long)(n))));
                        
                        //#line 489 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        final double t$49687 = ((double)(long)(((long)(-1L))));
                        
                        //#line 489 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        final x10.core.Rail t$49688 = ((x10.core.Rail)(A));
                        
                        //#line 489 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        final x10.core.Rail t$49689 = ((x10.core.Rail[])t$49688.value)[(int)i$49704];
                        
                        //#line 489 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        final long t$49690 = ((2L) * (((long)(n))));
                        
                        //#line 489 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        final long t$49691 = ((2L) * (((long)(m))));
                        
                        //#line 489 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        final long t$49692 = ((t$49690) + (((long)(t$49691))));
                        
                        //#line 489 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        final double t$49693 = ((double[])t$49689.value)[(int)t$49692];
                        
                        //#line 489 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        final double t$49694 = ((t$49687) * (((double)(t$49693))));
                        
                        //#line 489 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        ((double[])t$49685.value)[(int)t$49686] = t$49694;
                    }
                }
                
                //#line 483 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long t$49696 = i$49698;
                
                //#line 483 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long t$49697 = ((t$49696) + (((long)(1L))));
                
                //#line 483 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                i$49698 = t$49697;
            }
            
            //#line 482 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            final long t$49705 = i$49707;
            
            //#line 482 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            final long t$49706 = ((t$49705) + (((long)(1L))));
            
            //#line 482 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            i$49707 = t$49706;
        }
        
        //#line 494 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        final x10.io.Printer t$47336 = ((x10.io.Printer)(x10.io.Console.get$OUT()));
        
        //#line 494 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        t$47336.println(((java.lang.Object)("*out")));
        
        //#line 495 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        final x10.core.Rail t$47337 = ((x10.core.Rail)(out));
        
        //#line 495 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        plham.util.Matrix.dump__0$1x10$lang$Double$2(((x10.core.Rail)(t$47337)));
        
        //#line 497 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        x10.core.Rail obj = new x10.core.Rail<x10.core.Double>(x10.rtt.Types.DOUBLE, ((long)(n)));
        
        //#line 498 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        final long i$45809min$49760 = 0L;
        
        //#line 498 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        final long i$45809max$49761 = ((n) - (((long)(1L))));
        
        //#line 498 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        long i$49716 = i$45809min$49760;
        {
            
            //#line 498 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            final x10.core.Rail[] C$value$51211 = ((x10.core.Rail[])C.value);
            
            //#line 498 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            for (;
                 true;
                 ) {
                
                //#line 498 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long t$49717 = i$49716;
                
                //#line 498 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final boolean t$49718 = ((t$49717) <= (((long)(i$45809max$49761))));
                
                //#line 498 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                if (!(t$49718)) {
                    
                    //#line 498 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    break;
                }
                
                //#line 498 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long i$49713 = i$49716;
                
                //#line 499 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final x10.core.Rail t$49710 = ((x10.core.Rail)(obj));
                
                //#line 499 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final x10.core.Rail t$49711 = ((x10.core.Rail<x10.core.Double>)C$value$51211[(int)m]);
                
                //#line 499 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final double t$49712 = ((double[])t$49711.value)[(int)i$49713];
                
                //#line 499 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                ((double[])t$49710.value)[(int)i$49713] = t$49712;
                
                //#line 498 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long t$49714 = i$49716;
                
                //#line 498 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long t$49715 = ((t$49714) + (((long)(1L))));
                
                //#line 498 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                i$49716 = t$49715;
            }
        }
        
        //#line 502 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        final x10.core.Rail t$47346 = ((x10.core.Rail)(obj));
        
        //#line 502 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        final x10.core.Rail t$47347 = ((x10.core.Rail)(out));
        
        //#line 502 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        final double t$47352 = plham.util.Matrix.multiply__0$1x10$lang$Double$2__1$1x10$lang$Double$2$O(((x10.core.Rail)(t$47346)), ((x10.core.Rail)(t$47347)));
        
        //#line 502 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        final x10.core.Rail t$47350 = ((x10.core.Rail[])C.value)[(int)m];
        
        //#line 502 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        final long t$47348 = ((2L) * (((long)(n))));
        
        //#line 502 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        final long t$47349 = ((2L) * (((long)(m))));
        
        //#line 502 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        final long t$47351 = ((t$47348) + (((long)(t$47349))));
        
        //#line 502 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        final double t$47353 = ((double[])t$47350.value)[(int)t$47351];
        
        //#line 502 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        double result = ((t$47352) + (((double)(t$47353))));
        
        //#line 503 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        final x10.io.Printer t$47355 = ((x10.io.Printer)(x10.io.Console.get$OUT()));
        
        //#line 503 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        final double t$47354 = result;
        
        //#line 503 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        final java.lang.String t$47356 = (("*result:") + ((x10.core.Double.$box(t$47354))));
        
        //#line 503 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        t$47355.println(((java.lang.Object)(t$47356)));
        
        //#line 505 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        x10.core.Rail out2 = new x10.core.Rail<x10.core.Double>(x10.rtt.Types.DOUBLE, ((long)(m)));
        
        //#line 506 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        final long i$45845min$49762 = 0L;
        
        //#line 506 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        final long i$45845max$49763 = ((m) - (((long)(1L))));
        
        //#line 506 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        long i$49745 = i$45845min$49762;
        {
            
            //#line 506 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            final x10.core.Rail[] C$value$51212 = ((x10.core.Rail[])C.value);
            
            //#line 506 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            for (;
                 true;
                 ) {
                
                //#line 506 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long t$49746 = i$49745;
                
                //#line 506 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final boolean t$49747 = ((t$49746) <= (((long)(i$45845max$49763))));
                
                //#line 506 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                if (!(t$49747)) {
                    
                    //#line 506 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    break;
                }
                
                //#line 506 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long i$49742 = i$49745;
                
                //#line 507 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                x10.core.Rail x$49730 = new x10.core.Rail<x10.core.Double>(x10.rtt.Types.DOUBLE, ((long)(n)));
                
                //#line 508 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long i$45827min$49728 = 0L;
                
                //#line 508 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long i$45827max$49729 = ((n) - (((long)(1L))));
                
                //#line 508 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                long i$49725 = i$45827min$49728;
                {
                    
                    //#line 508 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    for (;
                         true;
                         ) {
                        
                        //#line 508 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        final long t$49726 = i$49725;
                        
                        //#line 508 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        final boolean t$49727 = ((t$49726) <= (((long)(i$45827max$49729))));
                        
                        //#line 508 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        if (!(t$49727)) {
                            
                            //#line 508 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                            break;
                        }
                        
                        //#line 508 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        final long j$49722 = i$49725;
                        
                        //#line 509 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        final x10.core.Rail t$49719 = ((x10.core.Rail)(x$49730));
                        
                        //#line 509 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        final x10.core.Rail t$49720 = ((x10.core.Rail<x10.core.Double>)C$value$51212[(int)i$49742]);
                        
                        //#line 509 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        final double t$49721 = ((double[])t$49720.value)[(int)j$49722];
                        
                        //#line 509 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        ((double[])t$49719.value)[(int)j$49722] = t$49721;
                        
                        //#line 508 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        final long t$49723 = i$49725;
                        
                        //#line 508 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        final long t$49724 = ((t$49723) + (((long)(1L))));
                        
                        //#line 508 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        i$49725 = t$49724;
                    }
                }
                
                //#line 511 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final x10.core.Rail t$49731 = ((x10.core.Rail)(out2));
                
                //#line 511 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final x10.core.Rail t$49732 = ((x10.core.Rail<x10.core.Double>)C$value$51212[(int)i$49742]);
                
                //#line 511 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long t$49733 = ((2L) * (((long)(n))));
                
                //#line 511 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long t$49734 = ((2L) * (((long)(m))));
                
                //#line 511 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long t$49735 = ((t$49733) + (((long)(t$49734))));
                
                //#line 511 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final double t$49736 = ((double[])t$49732.value)[(int)t$49735];
                
                //#line 511 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final x10.core.Rail t$49737 = ((x10.core.Rail<x10.core.Double>)C$value$51212[(int)i$49742]);
                
                //#line 511 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final x10.core.Rail t$49738 = plham.util.Matrix.shorten__0$1x10$lang$Double$2(((x10.core.Rail)(t$49737)), (long)(n));
                
                //#line 511 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final x10.core.Rail t$49739 = ((x10.core.Rail)(out));
                
                //#line 511 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final double t$49740 = plham.util.Matrix.multiply__0$1x10$lang$Double$2__1$1x10$lang$Double$2$O(((x10.core.Rail)(t$49738)), ((x10.core.Rail)(t$49739)));
                
                //#line 511 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final double t$49741 = ((t$49736) - (((double)(t$49740))));
                
                //#line 511 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                ((double[])t$49731.value)[(int)i$49742] = t$49741;
                
                //#line 506 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long t$49743 = i$49745;
                
                //#line 506 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long t$49744 = ((t$49743) + (((long)(1L))));
                
                //#line 506 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                i$49745 = t$49744;
            }
        }
        
        //#line 514 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        final x10.io.Printer t$47381 = ((x10.io.Printer)(x10.io.Console.get$OUT()));
        
        //#line 514 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        t$47381.println(((java.lang.Object)("*distance")));
        
        //#line 515 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        final x10.core.Rail t$47382 = ((x10.core.Rail)(out2));
        
        //#line 515 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        plham.util.Matrix.dump__0$1x10$lang$Double$2(((x10.core.Rail)(t$47382)));
        
        //#line 518 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        final x10.core.Rail t$47383 = ((x10.core.Rail)(out));
        
        //#line 518 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        return t$47383;
    }
    
    
    //#line 523 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
    public static x10.core.Rail initialASM0__0$1x10$lang$Double$2(final x10.core.Rail<x10.core.Double> A, final double B, final double r) {
        
        //#line 524 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        assert ((r) > (((double)(0.0)))) && ((r) < (((double)(1.0)))): "initialRError";
        
        //#line 526 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        final long t$47384 = ((x10.core.Rail<x10.core.Double>)A).size;
        
        //#line 526 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        x10.core.Rail out = new x10.core.Rail<x10.core.Double>(x10.rtt.Types.DOUBLE, ((long)(t$47384)));
        
        //#line 527 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        double sum = 0.0;
        
        //#line 528 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        double C = ((B) * (((double)(r))));
        
        //#line 530 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        final long i$45863min$49783 = 0L;
        
        //#line 530 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        final long t$49784 = ((x10.core.Rail<x10.core.Double>)A).size;
        
        //#line 530 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        final long i$45863max$49785 = ((t$49784) - (((long)(1L))));
        
        //#line 530 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        long i$49770 = i$45863min$49783;
        {
            
            //#line 530 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            final double[] A$value$51213 = ((double[])A.value);
            
            //#line 530 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            for (;
                 true;
                 ) {
                
                //#line 530 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long t$49771 = i$49770;
                
                //#line 530 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final boolean t$49772 = ((t$49771) <= (((long)(i$45863max$49785))));
                
                //#line 530 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                if (!(t$49772)) {
                    
                    //#line 530 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    break;
                }
                
                //#line 530 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long i$49767 = i$49770;
                
                //#line 531 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final double t$49764 = sum;
                
                //#line 531 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final double t$49765 = ((double)A$value$51213[(int)i$49767]);
                
                //#line 531 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final double t$49766 = ((t$49764) + (((double)(t$49765))));
                
                //#line 531 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                sum = t$49766;
                
                //#line 530 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long t$49768 = i$49770;
                
                //#line 530 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long t$49769 = ((t$49768) + (((long)(1L))));
                
                //#line 530 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                i$49770 = t$49769;
            }
        }
        
        //#line 533 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        final long i$45881min$49786 = 0L;
        
        //#line 533 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        final long t$49787 = ((x10.core.Rail<x10.core.Double>)A).size;
        
        //#line 533 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        final long i$45881max$49788 = ((t$49787) - (((long)(1L))));
        
        //#line 533 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        long i$49780 = i$45881min$49786;
        
        //#line 533 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        for (;
             true;
             ) {
            
            //#line 533 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            final long t$49781 = i$49780;
            
            //#line 533 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            final boolean t$49782 = ((t$49781) <= (((long)(i$45881max$49788))));
            
            //#line 533 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            if (!(t$49782)) {
                
                //#line 533 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                break;
            }
            
            //#line 533 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            final long i$49777 = i$49780;
            
            //#line 534 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            final x10.core.Rail t$49773 = ((x10.core.Rail)(out));
            
            //#line 534 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            final double t$49774 = C;
            
            //#line 534 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            final double t$49775 = sum;
            
            //#line 534 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            final double t$49776 = ((t$49774) / (((double)(t$49775))));
            
            //#line 534 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            ((double[])t$49773.value)[(int)i$49777] = t$49776;
            
            //#line 533 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            final long t$49778 = i$49780;
            
            //#line 533 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            final long t$49779 = ((t$49778) + (((long)(1L))));
            
            //#line 533 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            i$49780 = t$49779;
        }
        
        //#line 536 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        final x10.core.Rail t$47404 = ((x10.core.Rail)(out));
        
        //#line 536 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        return t$47404;
    }
    
    
    //#line 541 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
    public static x10.core.Rail initialASM0__0$1x10$lang$Rail$1x10$lang$Double$2$2__1$1x10$lang$Double$2(final x10.core.Rail<x10.core.Rail<x10.core.Double>> A, final x10.core.Rail<x10.core.Double> B) {
        
        //#line 543 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        final x10.core.Rail t$47405 = ((x10.core.Rail[])A.value)[(int)0L];
        
        //#line 543 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        final long t$47406 = ((x10.core.Rail<x10.core.Double>)t$47405).size;
        
        //#line 543 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        x10.core.Rail out = new x10.core.Rail<x10.core.Double>(x10.rtt.Types.DOUBLE, t$47406);
        
        //#line 553 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        assert plham.util.Matrix.checkInitialASM__0$1x10$lang$Rail$1x10$lang$Double$2$2__1$1x10$lang$Double$2__2$1x10$lang$Double$2$O(((x10.core.Rail)(A)), ((x10.core.Rail)(B)), ((x10.core.Rail)(out))): "initialValueError";
        
        //#line 554 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        final x10.core.Rail t$47407 = ((x10.core.Rail)(out));
        
        //#line 554 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        return t$47407;
    }
    
    
    //#line 557 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
    public static boolean checkPositive$O(final double x) {
        
        //#line 558 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        long s = 0L;
        
        //#line 559 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        final long t$47408 = plham.util.Matrix.index;
        
        //#line 559 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        final double t$47413 = plham.util.Matrix.round$O((double)(x), (long)(t$47408));
        
        //#line 559 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        final double t$47411 = plham.util.Matrix.epsilon2;
        
        //#line 559 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        final long t$47409 = plham.util.Matrix.index;
        
        //#line 559 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        final double t$47410 = plham.util.Matrix.round$O((double)(x), (long)(t$47409));
        
        //#line 559 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        final double t$47412 = java.lang.Math.abs(((double)(t$47410)));
        
        //#line 559 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        final double t$47414 = ((t$47411) * (((double)(t$47412))));
        
        //#line 559 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        boolean t$47418 = ((t$47413) >= (((double)(t$47414))));
        
        //#line 559 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        if (!(t$47418)) {
            
            //#line 559 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            final long t$47415 = plham.util.Matrix.index;
            
            //#line 559 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            final double t$47416 = plham.util.Matrix.round$O((double)(x), (long)(t$47415));
            
            //#line 559 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            final double t$47417 = plham.util.Matrix.epsilon;
            
            //#line 559 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            t$47418 = ((t$47416) >= (((double)(t$47417))));
        }
        
        //#line 559 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        final boolean t$47419 = t$47418;
        
        //#line 559 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        if (t$47419) {
            
            //#line 560 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            return true;
        } else {
            
            //#line 562 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            return false;
        }
    }
    
    
    //#line 567 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
    public static boolean checkPositive__0$1x10$lang$Double$2$O(final x10.core.Rail<x10.core.Double> x) {
        
        //#line 568 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        long s = 0L;
        
        //#line 569 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        long i$49811 = 0L;
        {
            
            //#line 569 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            final double[] x$value$51214 = ((double[])x.value);
            
            //#line 569 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            for (;
                 true;
                 ) {
                
                //#line 569 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long t$49812 = i$49811;
                
                //#line 569 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long t$49813 = ((x10.core.Rail<x10.core.Double>)x).size;
                
                //#line 569 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final boolean t$49814 = ((t$49812) < (((long)(t$49813))));
                
                //#line 569 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                if (!(t$49814)) {
                    
                    //#line 569 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    break;
                }
                
                //#line 570 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long t$49789 = i$49811;
                
                //#line 570 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final double t$49790 = ((double)x$value$51214[(int)t$49789]);
                
                //#line 570 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long t$49791 = plham.util.Matrix.index;
                
                //#line 570 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final double t$49792 = plham.util.Matrix.round$O((double)(t$49790), (long)(t$49791));
                
                //#line 570 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final double t$49793 = plham.util.Matrix.epsilon2;
                
                //#line 570 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long t$49794 = i$49811;
                
                //#line 570 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final double t$49795 = ((double)x$value$51214[(int)t$49794]);
                
                //#line 570 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long t$49796 = plham.util.Matrix.index;
                
                //#line 570 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final double t$49797 = plham.util.Matrix.round$O((double)(t$49795), (long)(t$49796));
                
                //#line 570 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final double t$49798 = java.lang.Math.abs(((double)(t$49797)));
                
                //#line 570 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final double t$49799 = ((t$49793) * (((double)(t$49798))));
                
                //#line 570 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                boolean t$49800 = ((t$49792) >= (((double)(t$49799))));
                
                //#line 570 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                if (!(t$49800)) {
                    
                    //#line 570 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final long t$49801 = i$49811;
                    
                    //#line 570 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final double t$49802 = ((double)x$value$51214[(int)t$49801]);
                    
                    //#line 570 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final long t$49803 = plham.util.Matrix.index;
                    
                    //#line 570 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final double t$49804 = plham.util.Matrix.round$O((double)(t$49802), (long)(t$49803));
                    
                    //#line 570 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final double t$49805 = plham.util.Matrix.epsilon;
                    
                    //#line 570 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    t$49800 = ((t$49804) >= (((double)(t$49805))));
                }
                
                //#line 570 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final boolean t$49806 = t$49800;
                
                //#line 570 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                if (t$49806) {
                    
                    //#line 571 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final long t$49807 = s;
                    
                    //#line 571 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final long t$49808 = ((t$49807) + (((long)(1L))));
                    
                    //#line 571 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    s = t$49808;
                }
                
                //#line 569 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long t$49809 = i$49811;
                
                //#line 569 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long t$49810 = ((t$49809) + (((long)(1L))));
                
                //#line 569 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                i$49811 = t$49810;
            }
        }
        
        //#line 574 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        final long t$47446 = ((x10.core.Rail<x10.core.Double>)x).size;
        
        //#line 574 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        final long t$47447 = s;
        
        //#line 574 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        final boolean t$47448 = ((long) t$47446) == ((long) t$47447);
        
        //#line 574 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        if (t$47448) {
            
            //#line 575 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            return true;
        } else {
            
            //#line 577 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            return false;
        }
    }
    
    
    //#line 582 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
    public static boolean checkInitialASM__0$1x10$lang$Rail$1x10$lang$Double$2$2__1$1x10$lang$Double$2__2$1x10$lang$Double$2$O(final x10.core.Rail<x10.core.Rail<x10.core.Double>> C, final x10.core.Rail<x10.core.Double> D, final x10.core.Rail<x10.core.Double> out) {
        
        //#line 583 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        boolean output = true;
        
        //#line 584 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        long count = 0L;
        
        //#line 585 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        x10.core.Rail X = plham.util.Matrix.multiply__0$1x10$lang$Rail$1x10$lang$Double$2$2__1$1x10$lang$Double$2(((x10.core.Rail)(C)), ((x10.core.Rail)(out)));
        
        //#line 587 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        final long i$45899min$49885 = 0L;
        
        //#line 587 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        final long t$49886 = ((x10.core.Rail<x10.core.Rail<x10.core.Double>>)C).size;
        
        //#line 587 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        final long i$45899max$49887 = ((t$49886) - (((long)(1L))));
        
        //#line 587 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        long i$49882 = i$45899min$49885;
        {
            
            //#line 587 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            final double[] D$value$51215 = ((double[])D.value);
            
            //#line 587 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            for (;
                 true;
                 ) {
                
                //#line 587 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long t$49883 = i$49882;
                
                //#line 587 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final boolean t$49884 = ((t$49883) <= (((long)(i$45899max$49887))));
                
                //#line 587 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                if (!(t$49884)) {
                    
                    //#line 587 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    break;
                }
                
                //#line 587 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long i$49879 = i$49882;
                
                //#line 588 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final double t$49815 = ((double)D$value$51215[(int)i$49879]);
                
                //#line 588 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long t$49816 = plham.util.Matrix.index;
                
                //#line 588 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final double t$49817 = plham.util.Matrix.round$O((double)(t$49815), (long)(t$49816));
                
                //#line 588 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final x10.core.Rail t$49818 = ((x10.core.Rail)(X));
                
                //#line 588 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final double t$49819 = ((double[])t$49818.value)[(int)i$49879];
                
                //#line 588 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long t$49820 = plham.util.Matrix.index;
                
                //#line 588 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final double t$49821 = plham.util.Matrix.round$O((double)(t$49819), (long)(t$49820));
                
                //#line 588 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final double t$49822 = ((t$49817) - (((double)(t$49821))));
                
                //#line 588 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long t$49823 = plham.util.Matrix.index;
                
                //#line 588 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final double t$49824 = plham.util.Matrix.round$O((double)(t$49822), (long)(t$49823));
                
                //#line 588 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final double t$49825 = ((double)(long)(((long)(0L))));
                
                //#line 588 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                boolean t$49826 = ((t$49824) >= (((double)(t$49825))));
                
                //#line 588 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                if (!(t$49826)) {
                    
                    //#line 588 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final x10.core.Rail t$49827 = ((x10.core.Rail)(X));
                    
                    //#line 588 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final double t$49828 = ((double[])t$49827.value)[(int)i$49879];
                    
                    //#line 588 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final long t$49829 = plham.util.Matrix.index;
                    
                    //#line 588 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final double t$49830 = plham.util.Matrix.round$O((double)(t$49828), (long)(t$49829));
                    
                    //#line 588 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final double t$49831 = ((double)D$value$51215[(int)i$49879]);
                    
                    //#line 588 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final long t$49832 = plham.util.Matrix.index;
                    
                    //#line 588 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final double t$49833 = plham.util.Matrix.round$O((double)(t$49831), (long)(t$49832));
                    
                    //#line 588 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final double t$49834 = ((t$49830) - (((double)(t$49833))));
                    
                    //#line 588 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final long t$49835 = plham.util.Matrix.index;
                    
                    //#line 588 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final double t$49836 = plham.util.Matrix.round$O((double)(t$49834), (long)(t$49835));
                    
                    //#line 588 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final double t$49837 = java.lang.Math.abs(((double)(t$49836)));
                    
                    //#line 588 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final x10.core.Rail t$49838 = ((x10.core.Rail)(X));
                    
                    //#line 588 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final double t$49839 = ((double[])t$49838.value)[(int)i$49879];
                    
                    //#line 588 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final long t$49840 = plham.util.Matrix.index;
                    
                    //#line 588 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final double t$49841 = plham.util.Matrix.round$O((double)(t$49839), (long)(t$49840));
                    
                    //#line 588 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final double t$49842 = java.lang.Math.abs(((double)(t$49841)));
                    
                    //#line 588 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final double t$49843 = plham.util.Matrix.epsilon2;
                    
                    //#line 588 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final double t$49844 = ((t$49842) * (((double)(t$49843))));
                    
                    //#line 588 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    t$49826 = ((t$49837) <= (((double)(t$49844))));
                }
                
                //#line 588 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                boolean t$49845 = t$49826;
                
                //#line 588 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                if (!(t$49845)) {
                    
                    //#line 588 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final x10.core.Rail t$49846 = ((x10.core.Rail)(X));
                    
                    //#line 588 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final double t$49847 = ((double[])t$49846.value)[(int)i$49879];
                    
                    //#line 588 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final long t$49848 = plham.util.Matrix.index;
                    
                    //#line 588 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final double t$49849 = plham.util.Matrix.round$O((double)(t$49847), (long)(t$49848));
                    
                    //#line 588 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final double t$49850 = ((double)D$value$51215[(int)i$49879]);
                    
                    //#line 588 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final long t$49851 = plham.util.Matrix.index;
                    
                    //#line 588 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final double t$49852 = plham.util.Matrix.round$O((double)(t$49850), (long)(t$49851));
                    
                    //#line 588 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final double t$49853 = ((t$49849) - (((double)(t$49852))));
                    
                    //#line 588 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final long t$49854 = plham.util.Matrix.index;
                    
                    //#line 588 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final double t$49855 = plham.util.Matrix.round$O((double)(t$49853), (long)(t$49854));
                    
                    //#line 588 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final double t$49856 = java.lang.Math.abs(((double)(t$49855)));
                    
                    //#line 588 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final double t$49857 = plham.util.Matrix.epsilon;
                    
                    //#line 588 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    t$49845 = ((t$49856) <= (((double)(t$49857))));
                }
                
                //#line 588 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                boolean t$49858 = t$49845;
                
                //#line 588 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                if (!(t$49858)) {
                    
                    //#line 588 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final x10.core.Rail t$49859 = ((x10.core.Rail)(X));
                    
                    //#line 588 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final double t$49860 = ((double[])t$49859.value)[(int)i$49879];
                    
                    //#line 588 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final long t$49861 = plham.util.Matrix.index;
                    
                    //#line 588 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final double t$49862 = plham.util.Matrix.round$O((double)(t$49860), (long)(t$49861));
                    
                    //#line 588 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final double t$49863 = ((double)D$value$51215[(int)i$49879]);
                    
                    //#line 588 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final long t$49864 = plham.util.Matrix.index;
                    
                    //#line 588 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final double t$49865 = plham.util.Matrix.round$O((double)(t$49863), (long)(t$49864));
                    
                    //#line 588 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final double t$49866 = ((t$49862) - (((double)(t$49865))));
                    
                    //#line 588 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final long t$49867 = plham.util.Matrix.index;
                    
                    //#line 588 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final double t$49868 = plham.util.Matrix.round$O((double)(t$49866), (long)(t$49867));
                    
                    //#line 588 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final double t$49869 = java.lang.Math.abs(((double)(t$49868)));
                    
                    //#line 588 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final double t$49870 = ((double)D$value$51215[(int)i$49879]);
                    
                    //#line 588 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final long t$49871 = plham.util.Matrix.index;
                    
                    //#line 588 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final double t$49872 = plham.util.Matrix.round$O((double)(t$49870), (long)(t$49871));
                    
                    //#line 588 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final double t$49873 = java.lang.Math.abs(((double)(t$49872)));
                    
                    //#line 588 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final double t$49874 = plham.util.Matrix.epsilon2;
                    
                    //#line 588 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final double t$49875 = ((t$49873) * (((double)(t$49874))));
                    
                    //#line 588 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    t$49858 = ((t$49869) <= (((double)(t$49875))));
                }
                
                //#line 588 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final boolean t$49876 = t$49858;
                
                //#line 588 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                if (t$49876) {
                    
                    //#line 589 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final long t$49877 = count;
                    
                    //#line 589 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final long t$49878 = ((t$49877) + (((long)(1L))));
                    
                    //#line 589 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    count = t$49878;
                } else {
                    
                }
                
                //#line 587 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long t$49880 = i$49882;
                
                //#line 587 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long t$49881 = ((t$49880) + (((long)(1L))));
                
                //#line 587 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                i$49882 = t$49881;
            }
        }
        
        //#line 596 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        final long t$47519 = count;
        
        //#line 596 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        final long t$47520 = ((x10.core.Rail<x10.core.Rail<x10.core.Double>>)C).size;
        
        //#line 596 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        final boolean t$47521 = ((long) t$47519) == ((long) t$47520);
        
        //#line 596 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        if (t$47521) {
            
            //#line 598 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            output = true;
        } else {
            
            //#line 601 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            output = false;
        }
        
        //#line 603 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        final boolean t$47522 = output;
        
        //#line 603 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        return t$47522;
    }
    
    
    //#line 608 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
    public static boolean checkASM__0$1x10$lang$Double$2__1$1x10$lang$Double$2$O(final x10.core.Rail<x10.core.Double> out, final x10.core.Rail<x10.core.Double> lastOut, final double epsilon, final double epsilon2) {
        
        //#line 609 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        long count = 0L;
        
        //#line 610 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        final long t$47523 = plham.util.Matrix.DEBUG;
        
        //#line 610 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        final boolean t$47525 = ((long) t$47523) == ((long) -2L);
        
        //#line 610 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        if (t$47525) {
            
            //#line 611 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            final x10.io.Printer t$47524 = ((x10.io.Printer)(x10.io.Console.get$OUT()));
            
            //#line 611 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            t$47524.println(((java.lang.Object)("**dif==0?:")));
        }
        
        //#line 613 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        long i$49948 = 0L;
        {
            
            //#line 613 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            final double[] out$value$51216 = ((double[])out.value);
            
            //#line 613 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            final double[] lastOut$value$51217 = ((double[])lastOut.value);
            
            //#line 613 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            for (;
                 true;
                 ) {
                
                //#line 613 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long t$49949 = i$49948;
                
                //#line 613 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long t$49950 = ((x10.core.Rail<x10.core.Double>)out).size;
                
                //#line 613 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final boolean t$49951 = ((t$49949) < (((long)(t$49950))));
                
                //#line 613 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                if (!(t$49951)) {
                    
                    //#line 613 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    break;
                }
                
                //#line 614 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long t$49888 = i$49948;
                
                //#line 614 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final double t$49889 = ((double)out$value$51216[(int)t$49888]);
                
                //#line 614 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long t$49890 = plham.util.Matrix.index;
                
                //#line 614 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final double t$49891 = plham.util.Matrix.round$O((double)(t$49889), (long)(t$49890));
                
                //#line 614 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long t$49892 = i$49948;
                
                //#line 614 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final double t$49893 = ((double)lastOut$value$51217[(int)t$49892]);
                
                //#line 614 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long t$49894 = plham.util.Matrix.index;
                
                //#line 614 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final double t$49895 = plham.util.Matrix.round$O((double)(t$49893), (long)(t$49894));
                
                //#line 614 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final double t$49896 = ((t$49891) - (((double)(t$49895))));
                
                //#line 614 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long t$49897 = plham.util.Matrix.index;
                
                //#line 614 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final double t$49898 = plham.util.Matrix.round$O((double)(t$49896), (long)(t$49897));
                
                //#line 614 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final double t$49899 = java.lang.Math.abs(((double)(t$49898)));
                
                //#line 614 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long t$49900 = i$49948;
                
                //#line 614 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final double t$49901 = ((double)lastOut$value$51217[(int)t$49900]);
                
                //#line 614 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long t$49902 = plham.util.Matrix.index;
                
                //#line 614 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final double t$49903 = plham.util.Matrix.round$O((double)(t$49901), (long)(t$49902));
                
                //#line 614 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final double t$49904 = java.lang.Math.abs(((double)(t$49903)));
                
                //#line 614 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final double t$49905 = ((epsilon2) * (((double)(t$49904))));
                
                //#line 614 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                boolean t$49906 = ((t$49899) <= (((double)(t$49905))));
                
                //#line 614 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                if (!(t$49906)) {
                    
                    //#line 614 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final long t$49907 = i$49948;
                    
                    //#line 614 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final double t$49908 = ((double)out$value$51216[(int)t$49907]);
                    
                    //#line 614 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final long t$49909 = plham.util.Matrix.index;
                    
                    //#line 614 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final double t$49910 = plham.util.Matrix.round$O((double)(t$49908), (long)(t$49909));
                    
                    //#line 614 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final long t$49911 = i$49948;
                    
                    //#line 614 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final double t$49912 = ((double)lastOut$value$51217[(int)t$49911]);
                    
                    //#line 614 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final long t$49913 = plham.util.Matrix.index;
                    
                    //#line 614 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final double t$49914 = plham.util.Matrix.round$O((double)(t$49912), (long)(t$49913));
                    
                    //#line 614 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final double t$49915 = ((t$49910) - (((double)(t$49914))));
                    
                    //#line 614 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final long t$49916 = plham.util.Matrix.index;
                    
                    //#line 614 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final double t$49917 = plham.util.Matrix.round$O((double)(t$49915), (long)(t$49916));
                    
                    //#line 614 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final double t$49918 = java.lang.Math.abs(((double)(t$49917)));
                    
                    //#line 614 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    t$49906 = ((t$49918) <= (((double)(epsilon))));
                }
                
                //#line 614 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                boolean t$49919 = t$49906;
                
                //#line 614 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                if (!(t$49919)) {
                    
                    //#line 614 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final long t$49920 = i$49948;
                    
                    //#line 614 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final double t$49921 = ((double)out$value$51216[(int)t$49920]);
                    
                    //#line 614 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final long t$49922 = plham.util.Matrix.index;
                    
                    //#line 614 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final double t$49923 = plham.util.Matrix.round$O((double)(t$49921), (long)(t$49922));
                    
                    //#line 614 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final long t$49924 = i$49948;
                    
                    //#line 614 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final double t$49925 = ((double)lastOut$value$51217[(int)t$49924]);
                    
                    //#line 614 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final long t$49926 = plham.util.Matrix.index;
                    
                    //#line 614 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final double t$49927 = plham.util.Matrix.round$O((double)(t$49925), (long)(t$49926));
                    
                    //#line 614 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final double t$49928 = ((t$49923) - (((double)(t$49927))));
                    
                    //#line 614 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final long t$49929 = plham.util.Matrix.index;
                    
                    //#line 614 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final double t$49930 = plham.util.Matrix.round$O((double)(t$49928), (long)(t$49929));
                    
                    //#line 614 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final double t$49931 = java.lang.Math.abs(((double)(t$49930)));
                    
                    //#line 614 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final long t$49932 = i$49948;
                    
                    //#line 614 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final double t$49933 = ((double)out$value$51216[(int)t$49932]);
                    
                    //#line 614 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final long t$49934 = plham.util.Matrix.index;
                    
                    //#line 614 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final double t$49935 = plham.util.Matrix.round$O((double)(t$49933), (long)(t$49934));
                    
                    //#line 614 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final double t$49936 = java.lang.Math.abs(((double)(t$49935)));
                    
                    //#line 614 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final double t$49937 = ((epsilon2) * (((double)(t$49936))));
                    
                    //#line 614 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    t$49919 = ((t$49931) <= (((double)(t$49937))));
                }
                
                //#line 614 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final boolean t$49938 = t$49919;
                
                //#line 614 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                if (t$49938) {
                    
                    //#line 615 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final long t$49939 = plham.util.Matrix.DEBUG;
                    
                    //#line 615 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final boolean t$49940 = ((long) t$49939) == ((long) -2L);
                    
                    //#line 615 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    if (t$49940) {
                        
                        //#line 616 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        final x10.io.Printer t$49941 = ((x10.io.Printer)(x10.io.Console.get$OUT()));
                        
                        //#line 616 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        final long t$49942 = i$49948;
                        
                        //#line 616 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        final java.lang.String t$49943 = (((x10.core.Long.$box(t$49942))) + (","));
                        
                        //#line 616 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        t$49941.print(((java.lang.String)(t$49943)));
                    }
                    
                    //#line 618 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final long t$49944 = count;
                    
                    //#line 618 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final long t$49945 = ((t$49944) + (((long)(1L))));
                    
                    //#line 618 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    count = t$49945;
                }
                
                //#line 613 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long t$49946 = i$49948;
                
                //#line 613 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long t$49947 = ((t$49946) + (((long)(1L))));
                
                //#line 613 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                i$49948 = t$49947;
            }
        }
        
        //#line 621 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        final long t$47590 = plham.util.Matrix.DEBUG;
        
        //#line 621 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        final boolean t$47592 = ((long) t$47590) == ((long) -2L);
        
        //#line 621 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        if (t$47592) {
            
            //#line 622 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            final x10.io.Printer t$47591 = ((x10.io.Printer)(x10.io.Console.get$OUT()));
            
            //#line 622 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            t$47591.println(((java.lang.Object)("")));
        }
        
        //#line 625 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        final long t$47593 = count;
        
        //#line 625 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        final long t$47594 = ((x10.core.Rail<x10.core.Double>)out).size;
        
        //#line 625 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        final boolean t$47595 = ((long) t$47593) == ((long) t$47594);
        
        //#line 625 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        if (t$47595) {
            
            //#line 627 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            return true;
        } else {
            
            //#line 630 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            return false;
        }
    }
    
    
    //#line 635 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
    public static x10.core.Rail shorten__0$1x10$lang$Double$2(final x10.core.Rail<x10.core.Double> x, final long s) {
        
        //#line 636 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        final x10.core.Rail out = new x10.core.Rail<x10.core.Double>(x10.rtt.Types.DOUBLE, ((long)(s)));
        
        //#line 637 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        long i$49957 = 0L;
        {
            
            //#line 637 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            final double[] x$value$51218 = ((double[])x.value);
            
            //#line 637 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            final double[] out$value$51219 = ((double[])out.value);
            
            //#line 637 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            for (;
                 true;
                 ) {
                
                //#line 637 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long t$49958 = i$49957;
                
                //#line 637 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final boolean t$49959 = ((t$49958) < (((long)(s))));
                
                //#line 637 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                if (!(t$49959)) {
                    
                    //#line 637 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    break;
                }
                
                //#line 638 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long t$49952 = i$49957;
                
                //#line 638 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long t$49953 = i$49957;
                
                //#line 638 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final double t$49954 = ((double)x$value$51218[(int)t$49953]);
                
                //#line 638 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                out$value$51219[(int)t$49952]=t$49954;
                
                //#line 637 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long t$49955 = i$49957;
                
                //#line 637 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long t$49956 = ((t$49955) + (((long)(1L))));
                
                //#line 637 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                i$49957 = t$49956;
            }
        }
        
        //#line 640 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        return out;
    }
    
    
    //#line 643 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
    public static x10.core.Rail shorten2__0$1x10$lang$Double$2(final x10.core.Rail<x10.core.Double> x, final long s) {
        
        //#line 645 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        final long t$47604 = ((x10.core.Rail<x10.core.Double>)x).size;
        
        //#line 645 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        final long t$47605 = ((t$47604) - (((long)(s))));
        
        //#line 645 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        final x10.core.Rail out = new x10.core.Rail<x10.core.Double>(x10.rtt.Types.DOUBLE, t$47605);
        
        //#line 646 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        long i$49966 = s;
        {
            
            //#line 646 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            final double[] x$value$51220 = ((double[])x.value);
            
            //#line 646 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            final double[] out$value$51221 = ((double[])out.value);
            
            //#line 646 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            for (;
                 true;
                 ) {
                
                //#line 646 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long t$49967 = i$49966;
                
                //#line 646 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long t$49968 = ((x10.core.Rail<x10.core.Double>)x).size;
                
                //#line 646 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final boolean t$49969 = ((t$49967) < (((long)(t$49968))));
                
                //#line 646 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                if (!(t$49969)) {
                    
                    //#line 646 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    break;
                }
                
                //#line 648 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long t$49960 = i$49966;
                
                //#line 648 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long t$49961 = ((t$49960) - (((long)(s))));
                
                //#line 648 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long t$49962 = i$49966;
                
                //#line 648 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final double t$49963 = ((double)x$value$51220[(int)t$49962]);
                
                //#line 648 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                out$value$51221[(int)t$49961]=t$49963;
                
                //#line 646 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long t$49964 = i$49966;
                
                //#line 646 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long t$49965 = ((t$49964) + (((long)(1L))));
                
                //#line 646 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                i$49966 = t$49965;
            }
        }
        
        //#line 650 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        return out;
    }
    
    
    //#line 653 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
    public static x10.core.Rail getRight__0$1x10$lang$Double$2__1$1x10$lang$Double$2(final x10.core.Rail<x10.core.Double> smallB, final x10.core.Rail<x10.core.Double> C) {
        
        //#line 654 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        final long t$47616 = ((x10.core.Rail<x10.core.Double>)smallB).size;
        
        //#line 654 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        final long t$47617 = ((x10.core.Rail<x10.core.Double>)C).size;
        
        //#line 654 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        long n = ((t$47616) + (((long)(t$47617))));
        
        //#line 655 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        final long t$47618 = n;
        
        //#line 655 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        x10.core.Rail out = new x10.core.Rail<x10.core.Double>(x10.rtt.Types.DOUBLE, t$47618);
        
        //#line 656 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        long i$49985 = 0L;
        {
            
            //#line 656 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            final double[] C$value$51222 = ((double[])C.value);
            
            //#line 656 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            final double[] smallB$value$51223 = ((double[])smallB.value);
            
            //#line 656 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            for (;
                 true;
                 ) {
                
                //#line 656 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long t$49986 = i$49985;
                
                //#line 656 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long t$49987 = n;
                
                //#line 656 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final boolean t$49988 = ((t$49986) < (((long)(t$49987))));
                
                //#line 656 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                if (!(t$49988)) {
                    
                    //#line 656 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    break;
                }
                
                //#line 657 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long t$49970 = i$49985;
                
                //#line 657 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long t$49971 = ((x10.core.Rail<x10.core.Double>)C).size;
                
                //#line 657 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final boolean t$49972 = ((t$49970) < (((long)(t$49971))));
                
                //#line 657 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                if (t$49972) {
                    
                    //#line 658 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final x10.core.Rail t$49973 = ((x10.core.Rail)(out));
                    
                    //#line 658 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final long t$49974 = i$49985;
                    
                    //#line 658 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final long t$49975 = i$49985;
                    
                    //#line 658 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final double t$49976 = ((double)C$value$51222[(int)t$49975]);
                    
                    //#line 658 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    ((double[])t$49973.value)[(int)t$49974] = t$49976;
                } else {
                    
                    //#line 660 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final x10.core.Rail t$49977 = ((x10.core.Rail)(out));
                    
                    //#line 660 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final long t$49978 = i$49985;
                    
                    //#line 660 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final long t$49979 = i$49985;
                    
                    //#line 660 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final long t$49980 = ((x10.core.Rail<x10.core.Double>)C).size;
                    
                    //#line 660 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final long t$49981 = ((t$49979) - (((long)(t$49980))));
                    
                    //#line 660 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final double t$49982 = ((double)smallB$value$51223[(int)t$49981]);
                    
                    //#line 660 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    ((double[])t$49977.value)[(int)t$49978] = t$49982;
                }
                
                //#line 656 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long t$49983 = i$49985;
                
                //#line 656 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long t$49984 = ((t$49983) + (((long)(1L))));
                
                //#line 656 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                i$49985 = t$49984;
            }
        }
        
        //#line 663 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        final x10.core.Rail t$47638 = ((x10.core.Rail)(out));
        
        //#line 663 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        return t$47638;
    }
    
    
    //#line 666 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
    public static x10.core.Rail getMat__0$1x10$lang$Rail$1x10$lang$Double$2$2__1$1x10$lang$Rail$1x10$lang$Double$2$2(final x10.core.Rail<x10.core.Rail<x10.core.Double>> smallA, final x10.core.Rail<x10.core.Rail<x10.core.Double>> Q) {
        
        //#line 667 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        final long t$47639 = ((x10.core.Rail<x10.core.Rail<x10.core.Double>>)Q).size;
        
        //#line 667 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        final long t$47640 = ((x10.core.Rail<x10.core.Rail<x10.core.Double>>)smallA).size;
        
        //#line 667 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        long n = ((t$47639) + (((long)(t$47640))));
        
        //#line 668 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        final long t$47641 = n;
        
        //#line 668 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        x10.core.Rail out = new x10.core.Rail<x10.core.Rail<x10.core.Double>>(x10.rtt.ParameterizedType.make(x10.core.Rail.$RTT, x10.rtt.Types.DOUBLE), t$47641);
        
        //#line 669 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        long i$50053 = 0L;
        
        //#line 669 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        for (;
             true;
             ) {
            
            //#line 669 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            final long t$50054 = i$50053;
            
            //#line 669 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            final long t$50055 = n;
            
            //#line 669 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            final boolean t$50056 = ((t$50054) < (((long)(t$50055))));
            
            //#line 669 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            if (!(t$50056)) {
                
                //#line 669 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                break;
            }
            
            //#line 670 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            final x10.core.Rail t$49989 = ((x10.core.Rail)(out));
            
            //#line 670 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            final long t$49990 = i$50053;
            
            //#line 670 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            final long t$49991 = n;
            
            //#line 670 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            final x10.core.Rail t$49992 = ((x10.core.Rail)(new x10.core.Rail<x10.core.Double>(x10.rtt.Types.DOUBLE, t$49991)));
            
            //#line 670 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            ((x10.core.Rail[])t$49989.value)[(int)t$49990] = t$49992;
            
            //#line 669 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            final long t$49993 = i$50053;
            
            //#line 669 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            final long t$49994 = ((t$49993) + (((long)(1L))));
            
            //#line 669 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            i$50053 = t$49994;
        }
        
        //#line 674 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        long i$50057 = 0L;
        {
            
            //#line 674 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            final x10.core.Rail[] Q$value$51224 = ((x10.core.Rail[])Q.value);
            
            //#line 674 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            final x10.core.Rail[] smallA$value$51225 = ((x10.core.Rail[])smallA.value);
            
            //#line 674 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            for (;
                 true;
                 ) {
                
                //#line 674 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long t$50058 = i$50057;
                
                //#line 674 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long t$50059 = n;
                
                //#line 674 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final boolean t$50060 = ((t$50058) < (((long)(t$50059))));
                
                //#line 674 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                if (!(t$50060)) {
                    
                    //#line 674 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    break;
                }
                
                //#line 675 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                long j$50047 = 0L;
                {
                    
                    //#line 675 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    for (;
                         true;
                         ) {
                        
                        //#line 675 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        final long t$50048 = j$50047;
                        
                        //#line 675 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        final long t$50049 = n;
                        
                        //#line 675 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        final boolean t$50050 = ((t$50048) < (((long)(t$50049))));
                        
                        //#line 675 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        if (!(t$50050)) {
                            
                            //#line 675 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                            break;
                        }
                        
                        //#line 676 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        final long t$49995 = i$50057;
                        
                        //#line 676 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        final long t$49996 = ((x10.core.Rail<x10.core.Rail<x10.core.Double>>)Q).size;
                        
                        //#line 676 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        boolean t$49997 = ((t$49995) < (((long)(t$49996))));
                        
                        //#line 676 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        if (t$49997) {
                            
                            //#line 676 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                            final long t$49998 = j$50047;
                            
                            //#line 676 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                            final long t$49999 = ((x10.core.Rail<x10.core.Rail<x10.core.Double>>)Q).size;
                            
                            //#line 676 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                            t$49997 = ((t$49998) < (((long)(t$49999))));
                        }
                        
                        //#line 676 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        final boolean t$50000 = t$49997;
                        
                        //#line 676 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        if (t$50000) {
                            
                            //#line 677 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                            final x10.core.Rail t$50001 = ((x10.core.Rail)(out));
                            
                            //#line 677 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                            final long t$50002 = i$50057;
                            
                            //#line 677 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                            final x10.core.Rail t$50003 = ((x10.core.Rail[])t$50001.value)[(int)t$50002];
                            
                            //#line 677 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                            final long t$50004 = j$50047;
                            
                            //#line 677 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                            final long t$50005 = i$50057;
                            
                            //#line 677 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                            final x10.core.Rail t$50006 = ((x10.core.Rail<x10.core.Double>)Q$value$51224[(int)t$50005]);
                            
                            //#line 677 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                            final long t$50007 = j$50047;
                            
                            //#line 677 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                            final double t$50008 = ((double[])t$50006.value)[(int)t$50007];
                            
                            //#line 677 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                            ((double[])t$50003.value)[(int)t$50004] = t$50008;
                        } else {
                            
                            //#line 678 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                            final long t$50009 = i$50057;
                            
                            //#line 678 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                            final long t$50010 = ((x10.core.Rail<x10.core.Rail<x10.core.Double>>)Q).size;
                            
                            //#line 678 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                            boolean t$50011 = ((t$50009) >= (((long)(t$50010))));
                            
                            //#line 678 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                            if (t$50011) {
                                
                                //#line 678 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                                final long t$50012 = j$50047;
                                
                                //#line 678 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                                final long t$50013 = ((x10.core.Rail<x10.core.Rail<x10.core.Double>>)Q).size;
                                
                                //#line 678 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                                t$50011 = ((t$50012) < (((long)(t$50013))));
                            }
                            
                            //#line 678 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                            final boolean t$50014 = t$50011;
                            
                            //#line 678 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                            if (t$50014) {
                                
                                //#line 679 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                                final x10.core.Rail t$50015 = ((x10.core.Rail)(out));
                                
                                //#line 679 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                                final long t$50016 = i$50057;
                                
                                //#line 679 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                                final x10.core.Rail t$50017 = ((x10.core.Rail[])t$50015.value)[(int)t$50016];
                                
                                //#line 679 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                                final long t$50018 = j$50047;
                                
                                //#line 679 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                                final long t$50019 = i$50057;
                                
                                //#line 679 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                                final long t$50020 = ((x10.core.Rail<x10.core.Rail<x10.core.Double>>)Q).size;
                                
                                //#line 679 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                                final long t$50021 = ((t$50019) - (((long)(t$50020))));
                                
                                //#line 679 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                                final x10.core.Rail t$50022 = ((x10.core.Rail<x10.core.Double>)smallA$value$51225[(int)t$50021]);
                                
                                //#line 679 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                                final long t$50023 = j$50047;
                                
                                //#line 679 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                                final double t$50024 = ((double[])t$50022.value)[(int)t$50023];
                                
                                //#line 679 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                                ((double[])t$50017.value)[(int)t$50018] = t$50024;
                            } else {
                                
                                //#line 680 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                                final long t$50025 = i$50057;
                                
                                //#line 680 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                                final long t$50026 = ((x10.core.Rail<x10.core.Rail<x10.core.Double>>)Q).size;
                                
                                //#line 680 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                                boolean t$50027 = ((t$50025) < (((long)(t$50026))));
                                
                                //#line 680 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                                if (t$50027) {
                                    
                                    //#line 680 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                                    final long t$50028 = j$50047;
                                    
                                    //#line 680 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                                    final long t$50029 = ((x10.core.Rail<x10.core.Rail<x10.core.Double>>)Q).size;
                                    
                                    //#line 680 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                                    t$50027 = ((t$50028) >= (((long)(t$50029))));
                                }
                                
                                //#line 680 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                                final boolean t$50030 = t$50027;
                                
                                //#line 680 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                                if (t$50030) {
                                    
                                    //#line 681 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                                    final x10.core.Rail t$50031 = ((x10.core.Rail)(out));
                                    
                                    //#line 681 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                                    final long t$50032 = i$50057;
                                    
                                    //#line 681 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                                    final x10.core.Rail t$50033 = ((x10.core.Rail[])t$50031.value)[(int)t$50032];
                                    
                                    //#line 681 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                                    final long t$50034 = j$50047;
                                    
                                    //#line 681 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                                    final long t$50035 = j$50047;
                                    
                                    //#line 681 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                                    final long t$50036 = ((x10.core.Rail<x10.core.Rail<x10.core.Double>>)Q).size;
                                    
                                    //#line 681 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                                    final long t$50037 = ((t$50035) - (((long)(t$50036))));
                                    
                                    //#line 681 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                                    final x10.core.Rail t$50038 = ((x10.core.Rail<x10.core.Double>)smallA$value$51225[(int)t$50037]);
                                    
                                    //#line 681 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                                    final long t$50039 = i$50057;
                                    
                                    //#line 681 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                                    final double t$50040 = ((double[])t$50038.value)[(int)t$50039];
                                    
                                    //#line 681 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                                    ((double[])t$50033.value)[(int)t$50034] = t$50040;
                                } else {
                                    
                                    //#line 683 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                                    final x10.core.Rail t$50041 = ((x10.core.Rail)(out));
                                    
                                    //#line 683 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                                    final long t$50042 = i$50057;
                                    
                                    //#line 683 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                                    final x10.core.Rail t$50043 = ((x10.core.Rail[])t$50041.value)[(int)t$50042];
                                    
                                    //#line 683 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                                    final long t$50044 = j$50047;
                                    
                                    //#line 683 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                                    ((double[])t$50043.value)[(int)t$50044] = 0.0;
                                }
                            }
                        }
                        
                        //#line 675 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        final long t$50045 = j$50047;
                        
                        //#line 675 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        final long t$50046 = ((t$50045) + (((long)(1L))));
                        
                        //#line 675 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        j$50047 = t$50046;
                    }
                }
                
                //#line 674 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long t$50051 = i$50057;
                
                //#line 674 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long t$50052 = ((t$50051) + (((long)(1L))));
                
                //#line 674 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                i$50057 = t$50052;
            }
        }
        
        //#line 687 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        final x10.core.Rail t$47714 = ((x10.core.Rail)(out));
        
        //#line 687 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        return t$47714;
    }
    
    
    //#line 690 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
    public static x10.core.Rail round__0$1x10$lang$Rail$1x10$lang$Double$2$2(final x10.core.Rail<x10.core.Rail<x10.core.Double>> A, final long m) {
        
        //#line 691 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        final long n = ((x10.core.Rail<x10.core.Rail<x10.core.Double>>)A).size;
        
        //#line 692 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        x10.core.Rail out = new x10.core.Rail<x10.core.Rail<x10.core.Double>>(x10.rtt.ParameterizedType.make(x10.core.Rail.$RTT, x10.rtt.Types.DOUBLE), ((long)(n)));
        
        //#line 693 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        long i$50086 = 0L;
        {
            
            //#line 693 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            final x10.core.Rail[] A$value$51226 = ((x10.core.Rail[])A.value);
            
            //#line 693 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            for (;
                 true;
                 ) {
                
                //#line 693 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long t$50087 = i$50086;
                
                //#line 693 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final boolean t$50088 = ((t$50087) < (((long)(n))));
                
                //#line 693 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                if (!(t$50088)) {
                    
                    //#line 693 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    break;
                }
                
                //#line 694 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final x10.core.Rail t$50061 = ((x10.core.Rail)(out));
                
                //#line 694 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long t$50062 = i$50086;
                
                //#line 694 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final x10.core.Rail t$50063 = ((x10.core.Rail<x10.core.Double>)A$value$51226[(int)0L]);
                
                //#line 694 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long t$50064 = ((x10.core.Rail<x10.core.Double>)t$50063).size;
                
                //#line 694 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final x10.core.Rail t$50065 = ((x10.core.Rail)(new x10.core.Rail<x10.core.Double>(x10.rtt.Types.DOUBLE, t$50064)));
                
                //#line 694 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                ((x10.core.Rail[])t$50061.value)[(int)t$50062] = t$50065;
                
                //#line 693 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long t$50066 = i$50086;
                
                //#line 693 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long t$50067 = ((t$50066) + (((long)(1L))));
                
                //#line 693 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                i$50086 = t$50067;
            }
        }
        
        //#line 696 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        long i$50089 = 0L;
        {
            
            //#line 696 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            final x10.core.Rail[] A$value$51227 = ((x10.core.Rail[])A.value);
            
            //#line 696 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            for (;
                 true;
                 ) {
                
                //#line 696 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long t$50090 = i$50089;
                
                //#line 696 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final boolean t$50091 = ((t$50090) < (((long)(n))));
                
                //#line 696 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                if (!(t$50091)) {
                    
                    //#line 696 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    break;
                }
                
                //#line 697 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                long j$50079 = 0L;
                {
                    
                    //#line 697 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    for (;
                         true;
                         ) {
                        
                        //#line 697 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        final long t$50080 = j$50079;
                        
                        //#line 697 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        final x10.core.Rail t$50081 = ((x10.core.Rail<x10.core.Double>)A$value$51227[(int)0L]);
                        
                        //#line 697 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        final long t$50082 = ((x10.core.Rail<x10.core.Double>)t$50081).size;
                        
                        //#line 697 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        final boolean t$50083 = ((t$50080) < (((long)(t$50082))));
                        
                        //#line 697 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        if (!(t$50083)) {
                            
                            //#line 697 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                            break;
                        }
                        
                        //#line 698 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        final x10.core.Rail t$50068 = ((x10.core.Rail)(out));
                        
                        //#line 698 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        final long t$50069 = i$50089;
                        
                        //#line 698 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        final x10.core.Rail t$50070 = ((x10.core.Rail[])t$50068.value)[(int)t$50069];
                        
                        //#line 698 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        final long t$50071 = j$50079;
                        
                        //#line 698 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        final long t$50072 = i$50089;
                        
                        //#line 698 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        final x10.core.Rail t$50073 = ((x10.core.Rail<x10.core.Double>)A$value$51227[(int)t$50072]);
                        
                        //#line 698 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        final long t$50074 = j$50079;
                        
                        //#line 698 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        final double t$50075 = ((double[])t$50073.value)[(int)t$50074];
                        
                        //#line 698 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        final double t$50076 = plham.util.Matrix.round$O((double)(t$50075), (long)(m));
                        
                        //#line 698 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        ((double[])t$50070.value)[(int)t$50071] = t$50076;
                        
                        //#line 697 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        final long t$50077 = j$50079;
                        
                        //#line 697 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        final long t$50078 = ((t$50077) + (((long)(1L))));
                        
                        //#line 697 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        j$50079 = t$50078;
                    }
                }
                
                //#line 696 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long t$50084 = i$50089;
                
                //#line 696 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long t$50085 = ((t$50084) + (((long)(1L))));
                
                //#line 696 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                i$50089 = t$50085;
            }
        }
        
        //#line 701 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        final x10.core.Rail t$47746 = ((x10.core.Rail)(out));
        
        //#line 701 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        return t$47746;
    }
    
    
    //#line 704 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
    public static x10.core.Rail round__0$1x10$lang$Double$2(final x10.core.Rail<x10.core.Double> B, final long m) {
        
        //#line 705 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        final long n = ((x10.core.Rail<x10.core.Double>)B).size;
        
        //#line 706 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        x10.core.Rail out = new x10.core.Rail<x10.core.Double>(x10.rtt.Types.DOUBLE, ((long)(n)));
        
        //#line 707 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        long i$50099 = 0L;
        {
            
            //#line 707 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            final double[] B$value$51228 = ((double[])B.value);
            
            //#line 707 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            for (;
                 true;
                 ) {
                
                //#line 707 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long t$50100 = i$50099;
                
                //#line 707 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final boolean t$50101 = ((t$50100) < (((long)(n))));
                
                //#line 707 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                if (!(t$50101)) {
                    
                    //#line 707 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    break;
                }
                
                //#line 708 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final x10.core.Rail t$50092 = ((x10.core.Rail)(out));
                
                //#line 708 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long t$50093 = i$50099;
                
                //#line 708 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long t$50094 = i$50099;
                
                //#line 708 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final double t$50095 = ((double)B$value$51228[(int)t$50094]);
                
                //#line 708 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final double t$50096 = plham.util.Matrix.round$O((double)(t$50095), (long)(m));
                
                //#line 708 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                ((double[])t$50092.value)[(int)t$50093] = t$50096;
                
                //#line 707 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long t$50097 = i$50099;
                
                //#line 707 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long t$50098 = ((t$50097) + (((long)(1L))));
                
                //#line 707 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                i$50099 = t$50098;
            }
        }
        
        //#line 710 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        final x10.core.Rail t$47757 = ((x10.core.Rail)(out));
        
        //#line 710 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        return t$47757;
    }
    
    
    //#line 713 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
    public static double round$O(final double x, final long m) {
        
        //#line 714 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        final boolean t$47758 = ((double) x) == ((double) 0.0);
        
        //#line 714 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        if (t$47758) {
            
            //#line 714 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            return x;
        }
        
        //#line 715 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        double out = 0.0;
        
        //#line 716 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        final double t$47759 = java.lang.Math.abs(((double)(x)));
        
        //#line 716 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        final double t$47760 = java.lang.Math.log10(((double)(t$47759)));
        
        //#line 716 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        double ketasuu = java.lang.Math.ceil(((double)(t$47760)));
        
        //#line 719 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        final double t$47761 = ((double)(long)(((long)(-1L))));
        
        //#line 719 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        final double t$47762 = ketasuu;
        
        //#line 719 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        final double t$47763 = ((t$47761) * (((double)(t$47762))));
        
        //#line 719 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        final double t$47764 = x10.lang.Math.pow$O((long)(10L), (double)(t$47763));
        
        //#line 719 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        final double t$47765 = ((x) * (((double)(t$47764))));
        
        //#line 719 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        out = t$47765;
        
        //#line 721 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        final double t$47767 = out;
        
        //#line 721 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        final double t$47766 = ((double)(long)(((long)(m))));
        
        //#line 721 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        final double t$47768 = x10.lang.Math.pow$O((long)(10L), (double)(t$47766));
        
        //#line 721 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        final double t$47769 = ((t$47767) * (((double)(t$47768))));
        
        //#line 721 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        out = t$47769;
        
        //#line 723 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        final double t$47770 = out;
        
        //#line 723 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        final double t$47771 = (double)java.lang.Math.round(((double)(t$47770)));
        
        //#line 723 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        out = t$47771;
        
        //#line 725 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        final double t$47776 = out;
        
        //#line 725 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        final double t$47772 = ketasuu;
        
        //#line 725 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        final double t$47773 = ((double)(long)(((long)(m))));
        
        //#line 725 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        final double t$47774 = ((t$47772) - (((double)(t$47773))));
        
        //#line 725 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        final double t$47775 = t$47774;
        
        //#line 725 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        final double t$47777 = x10.lang.Math.pow$O((long)(10L), (double)(t$47775));
        
        //#line 725 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        final double t$47778 = ((t$47776) * (((double)(t$47777))));
        
        //#line 725 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        out = t$47778;
        
        //#line 727 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        final double t$47779 = out;
        
        //#line 727 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        return t$47779;
    }
    
    
    //#line 731 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
    public static x10.core.Rail getSmall__0$1x10$lang$Boolean$2__1$1x10$lang$Double$2(final x10.core.Rail<x10.core.Boolean> activeCheck, final x10.core.Rail<x10.core.Double> B) {
        
        //#line 732 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        long s = plham.util.Matrix.countActive__0$1x10$lang$Boolean$2$O(((x10.core.Rail)(activeCheck)));
        
        //#line 733 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        final long t$47780 = s;
        
        //#line 733 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        x10.core.Rail out = new x10.core.Rail<x10.core.Double>(x10.rtt.Types.DOUBLE, t$47780);
        
        //#line 734 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        long j = 0L;
        
        //#line 735 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        long i$50112 = 0L;
        {
            
            //#line 735 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            final boolean[] activeCheck$value$51229 = ((boolean[])activeCheck.value);
            
            //#line 735 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            final double[] B$value$51230 = ((double[])B.value);
            
            //#line 735 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            for (;
                 true;
                 ) {
                
                //#line 735 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long t$50113 = i$50112;
                
                //#line 735 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long t$50114 = ((x10.core.Rail<x10.core.Boolean>)activeCheck).size;
                
                //#line 735 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final boolean t$50115 = ((t$50113) < (((long)(t$50114))));
                
                //#line 735 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                if (!(t$50115)) {
                    
                    //#line 735 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    break;
                }
                
                //#line 736 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long t$50102 = i$50112;
                
                //#line 736 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final boolean t$50103 = ((boolean)activeCheck$value$51229[(int)t$50102]);
                
                //#line 736 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                if (t$50103) {
                    
                    //#line 737 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final x10.core.Rail t$50104 = ((x10.core.Rail)(out));
                    
                    //#line 737 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final long t$50105 = j;
                    
                    //#line 737 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final long t$50106 = i$50112;
                    
                    //#line 737 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final double t$50107 = ((double)B$value$51230[(int)t$50106]);
                    
                    //#line 737 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    ((double[])t$50104.value)[(int)t$50105] = t$50107;
                    
                    //#line 738 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final long t$50108 = j;
                    
                    //#line 738 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final long t$50109 = ((t$50108) + (((long)(1L))));
                    
                    //#line 738 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    j = t$50109;
                }
                
                //#line 735 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long t$50110 = i$50112;
                
                //#line 735 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long t$50111 = ((t$50110) + (((long)(1L))));
                
                //#line 735 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                i$50112 = t$50111;
            }
        }
        
        //#line 741 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        final x10.core.Rail t$47795 = ((x10.core.Rail)(out));
        
        //#line 741 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        return t$47795;
    }
    
    
    //#line 745 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
    public static x10.core.Rail getSmall__0$1x10$lang$Boolean$2__1$1x10$lang$Rail$1x10$lang$Double$2$2(final x10.core.Rail<x10.core.Boolean> activeCheck, final x10.core.Rail<x10.core.Rail<x10.core.Double>> A) {
        
        //#line 746 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        long s = plham.util.Matrix.countActive__0$1x10$lang$Boolean$2$O(((x10.core.Rail)(activeCheck)));
        
        //#line 747 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        final long t$47796 = s;
        
        //#line 747 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        x10.core.Rail out = new x10.core.Rail<x10.core.Rail<x10.core.Double>>(x10.rtt.ParameterizedType.make(x10.core.Rail.$RTT, x10.rtt.Types.DOUBLE), t$47796);
        
        //#line 748 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        long j = 0L;
        
        //#line 749 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        long i$50126 = 0L;
        {
            
            //#line 749 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            final boolean[] activeCheck$value$51231 = ((boolean[])activeCheck.value);
            
            //#line 749 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            final x10.core.Rail[] A$value$51232 = ((x10.core.Rail[])A.value);
            
            //#line 749 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            for (;
                 true;
                 ) {
                
                //#line 749 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long t$50127 = i$50126;
                
                //#line 749 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long t$50128 = ((x10.core.Rail<x10.core.Boolean>)activeCheck).size;
                
                //#line 749 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final boolean t$50129 = ((t$50127) < (((long)(t$50128))));
                
                //#line 749 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                if (!(t$50129)) {
                    
                    //#line 749 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    break;
                }
                
                //#line 750 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long t$50116 = i$50126;
                
                //#line 750 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final boolean t$50117 = ((boolean)activeCheck$value$51231[(int)t$50116]);
                
                //#line 750 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                if (t$50117) {
                    
                    //#line 751 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final x10.core.Rail t$50118 = ((x10.core.Rail)(out));
                    
                    //#line 751 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final long t$50119 = j;
                    
                    //#line 751 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final long t$50120 = i$50126;
                    
                    //#line 751 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final x10.core.Rail t$50121 = ((x10.core.Rail<x10.core.Double>)A$value$51232[(int)t$50120]);
                    
                    //#line 751 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    ((x10.core.Rail[])t$50118.value)[(int)t$50119] = t$50121;
                    
                    //#line 752 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final long t$50122 = j;
                    
                    //#line 752 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final long t$50123 = ((t$50122) + (((long)(1L))));
                    
                    //#line 752 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    j = t$50123;
                }
                
                //#line 749 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long t$50124 = i$50126;
                
                //#line 749 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long t$50125 = ((t$50124) + (((long)(1L))));
                
                //#line 749 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                i$50126 = t$50125;
            }
        }
        
        //#line 755 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        final x10.core.Rail t$47811 = ((x10.core.Rail)(out));
        
        //#line 755 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        return t$47811;
    }
    
    
    //#line 759 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
    public static long countActive__0$1x10$lang$Boolean$2$O(final x10.core.Rail<x10.core.Boolean> activeCheck) {
        
        //#line 760 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        long count = 0L;
        
        //#line 761 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        long i$50136 = 0L;
        {
            
            //#line 761 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            final boolean[] activeCheck$value$51233 = ((boolean[])activeCheck.value);
            
            //#line 761 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            for (;
                 true;
                 ) {
                
                //#line 761 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long t$50137 = i$50136;
                
                //#line 761 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long t$50138 = ((x10.core.Rail<x10.core.Boolean>)activeCheck).size;
                
                //#line 761 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final boolean t$50139 = ((t$50137) < (((long)(t$50138))));
                
                //#line 761 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                if (!(t$50139)) {
                    
                    //#line 761 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    break;
                }
                
                //#line 762 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long t$50130 = i$50136;
                
                //#line 762 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final boolean t$50131 = ((boolean)activeCheck$value$51233[(int)t$50130]);
                
                //#line 762 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                if (t$50131) {
                    
                    //#line 762 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final long t$50132 = count;
                    
                    //#line 762 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final long t$50133 = ((t$50132) + (((long)(1L))));
                    
                    //#line 762 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    count = t$50133;
                }
                
                //#line 761 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long t$50134 = i$50136;
                
                //#line 761 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long t$50135 = ((t$50134) + (((long)(1L))));
                
                //#line 761 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                i$50136 = t$50135;
            }
        }
        
        //#line 764 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        final long t$47822 = count;
        
        //#line 764 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        return t$47822;
    }
    
    
    //#line 769 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
    public static x10.core.Rail activeCheck__0$1x10$lang$Rail$1x10$lang$Double$2$2__1$1x10$lang$Double$2__2$1x10$lang$Double$2(final x10.core.Rail<x10.core.Rail<x10.core.Double>> C, final x10.core.Rail<x10.core.Double> D, final x10.core.Rail<x10.core.Double> value) {
        
        //#line 770 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        final long t$47823 = ((x10.core.Rail<x10.core.Rail<x10.core.Double>>)C).size;
        
        //#line 770 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        x10.core.Rail out = new x10.core.Rail<x10.core.Boolean>(x10.rtt.Types.BOOLEAN, ((long)(t$47823)));
        
        //#line 771 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        long i$50211 = 0L;
        {
            
            //#line 771 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            final x10.core.Rail[] C$value$51234 = ((x10.core.Rail[])C.value);
            
            //#line 771 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            final double[] D$value$51235 = ((double[])D.value);
            
            //#line 771 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            for (;
                 true;
                 ) {
                
                //#line 771 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long t$50212 = i$50211;
                
                //#line 771 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long t$50213 = ((x10.core.Rail<x10.core.Rail<x10.core.Double>>)C).size;
                
                //#line 771 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final boolean t$50214 = ((t$50212) < (((long)(t$50213))));
                
                //#line 771 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                if (!(t$50214)) {
                    
                    //#line 771 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    break;
                }
                
                //#line 773 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long t$50140 = i$50211;
                
                //#line 773 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final x10.core.Rail t$50141 = ((x10.core.Rail<x10.core.Double>)C$value$51234[(int)t$50140]);
                
                //#line 773 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final double t$50142 = plham.util.Matrix.multiply__0$1x10$lang$Double$2__1$1x10$lang$Double$2$O(((x10.core.Rail)(t$50141)), ((x10.core.Rail)(value)));
                
                //#line 773 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long t$50143 = plham.util.Matrix.index;
                
                //#line 773 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final double t$50144 = plham.util.Matrix.round$O((double)(t$50142), (long)(t$50143));
                
                //#line 773 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long t$50145 = i$50211;
                
                //#line 773 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final double t$50146 = ((double)D$value$51235[(int)t$50145]);
                
                //#line 773 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long t$50147 = plham.util.Matrix.index;
                
                //#line 773 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final double t$50148 = plham.util.Matrix.round$O((double)(t$50146), (long)(t$50147));
                
                //#line 773 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final double t$50149 = ((t$50144) - (((double)(t$50148))));
                
                //#line 773 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long t$50150 = plham.util.Matrix.index;
                
                //#line 773 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final double t$50151 = plham.util.Matrix.round$O((double)(t$50149), (long)(t$50150));
                
                //#line 773 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final double t$50152 = java.lang.Math.abs(((double)(t$50151)));
                
                //#line 773 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final double t$50153 = plham.util.Matrix.epsilon2;
                
                //#line 773 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long t$50154 = i$50211;
                
                //#line 773 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final double t$50155 = ((double)D$value$51235[(int)t$50154]);
                
                //#line 773 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long t$50156 = plham.util.Matrix.index;
                
                //#line 773 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final double t$50157 = plham.util.Matrix.round$O((double)(t$50155), (long)(t$50156));
                
                //#line 773 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final double t$50158 = java.lang.Math.abs(((double)(t$50157)));
                
                //#line 773 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final double t$50159 = ((t$50153) * (((double)(t$50158))));
                
                //#line 773 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                boolean t$50160 = ((t$50152) <= (((double)(t$50159))));
                
                //#line 773 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                if (!(t$50160)) {
                    
                    //#line 773 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final long t$50161 = i$50211;
                    
                    //#line 773 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final x10.core.Rail t$50162 = ((x10.core.Rail<x10.core.Double>)C$value$51234[(int)t$50161]);
                    
                    //#line 773 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final double t$50163 = plham.util.Matrix.multiply__0$1x10$lang$Double$2__1$1x10$lang$Double$2$O(((x10.core.Rail)(t$50162)), ((x10.core.Rail)(value)));
                    
                    //#line 773 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final long t$50164 = plham.util.Matrix.index;
                    
                    //#line 773 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final double t$50165 = plham.util.Matrix.round$O((double)(t$50163), (long)(t$50164));
                    
                    //#line 773 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final long t$50166 = i$50211;
                    
                    //#line 773 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final double t$50167 = ((double)D$value$51235[(int)t$50166]);
                    
                    //#line 773 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final long t$50168 = plham.util.Matrix.index;
                    
                    //#line 773 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final double t$50169 = plham.util.Matrix.round$O((double)(t$50167), (long)(t$50168));
                    
                    //#line 773 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final double t$50170 = ((t$50165) - (((double)(t$50169))));
                    
                    //#line 773 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final long t$50171 = plham.util.Matrix.index;
                    
                    //#line 773 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final double t$50172 = plham.util.Matrix.round$O((double)(t$50170), (long)(t$50171));
                    
                    //#line 773 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final double t$50173 = java.lang.Math.abs(((double)(t$50172)));
                    
                    //#line 773 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final double t$50174 = plham.util.Matrix.epsilon;
                    
                    //#line 773 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    t$50160 = ((t$50173) <= (((double)(t$50174))));
                }
                
                //#line 773 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                boolean t$50175 = t$50160;
                
                //#line 773 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                if (!(t$50175)) {
                    
                    //#line 773 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final long t$50176 = i$50211;
                    
                    //#line 773 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final x10.core.Rail t$50177 = ((x10.core.Rail<x10.core.Double>)C$value$51234[(int)t$50176]);
                    
                    //#line 773 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final double t$50178 = plham.util.Matrix.multiply__0$1x10$lang$Double$2__1$1x10$lang$Double$2$O(((x10.core.Rail)(t$50177)), ((x10.core.Rail)(value)));
                    
                    //#line 773 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final long t$50179 = plham.util.Matrix.index;
                    
                    //#line 773 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final double t$50180 = plham.util.Matrix.round$O((double)(t$50178), (long)(t$50179));
                    
                    //#line 773 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final long t$50181 = i$50211;
                    
                    //#line 773 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final double t$50182 = ((double)D$value$51235[(int)t$50181]);
                    
                    //#line 773 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final long t$50183 = plham.util.Matrix.index;
                    
                    //#line 773 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final double t$50184 = plham.util.Matrix.round$O((double)(t$50182), (long)(t$50183));
                    
                    //#line 773 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final double t$50185 = ((t$50180) - (((double)(t$50184))));
                    
                    //#line 773 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final long t$50186 = plham.util.Matrix.index;
                    
                    //#line 773 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final double t$50187 = plham.util.Matrix.round$O((double)(t$50185), (long)(t$50186));
                    
                    //#line 773 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final double t$50188 = java.lang.Math.abs(((double)(t$50187)));
                    
                    //#line 773 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final double t$50189 = plham.util.Matrix.epsilon2;
                    
                    //#line 773 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final long t$50190 = i$50211;
                    
                    //#line 773 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final x10.core.Rail t$50191 = ((x10.core.Rail<x10.core.Double>)C$value$51234[(int)t$50190]);
                    
                    //#line 773 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final double t$50192 = plham.util.Matrix.multiply__0$1x10$lang$Double$2__1$1x10$lang$Double$2$O(((x10.core.Rail)(t$50191)), ((x10.core.Rail)(value)));
                    
                    //#line 773 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final long t$50193 = plham.util.Matrix.index;
                    
                    //#line 773 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final double t$50194 = plham.util.Matrix.round$O((double)(t$50192), (long)(t$50193));
                    
                    //#line 773 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final long t$50195 = i$50211;
                    
                    //#line 773 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final double t$50196 = ((double)D$value$51235[(int)t$50195]);
                    
                    //#line 773 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final long t$50197 = plham.util.Matrix.index;
                    
                    //#line 773 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final double t$50198 = plham.util.Matrix.round$O((double)(t$50196), (long)(t$50197));
                    
                    //#line 773 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final double t$50199 = ((t$50194) - (((double)(t$50198))));
                    
                    //#line 773 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final long t$50200 = plham.util.Matrix.index;
                    
                    //#line 773 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final double t$50201 = plham.util.Matrix.round$O((double)(t$50199), (long)(t$50200));
                    
                    //#line 773 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final double t$50202 = java.lang.Math.abs(((double)(t$50201)));
                    
                    //#line 773 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final double t$50203 = ((t$50189) * (((double)(t$50202))));
                    
                    //#line 773 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    t$50175 = ((t$50188) <= (((double)(t$50203))));
                }
                
                //#line 773 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final boolean t$50204 = t$50175;
                
                //#line 773 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                if (t$50204) {
                    
                    //#line 774 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final x10.core.Rail t$50205 = ((x10.core.Rail)(out));
                    
                    //#line 774 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final long t$50206 = i$50211;
                    
                    //#line 774 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    ((boolean[])t$50205.value)[(int)t$50206] = true;
                } else {
                    
                    //#line 775 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final x10.core.Rail t$50207 = ((x10.core.Rail)(out));
                    
                    //#line 775 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final long t$50208 = i$50211;
                    
                    //#line 775 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    ((boolean[])t$50207.value)[(int)t$50208] = false;
                }
                
                //#line 771 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long t$50209 = i$50211;
                
                //#line 771 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long t$50210 = ((t$50209) + (((long)(1L))));
                
                //#line 771 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                i$50211 = t$50210;
            }
        }
        
        //#line 777 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        final x10.core.Rail t$47899 = ((x10.core.Rail)(out));
        
        //#line 777 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        return t$47899;
    }
    
    
    //#line 780 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
    public static x10.core.Rail activeCheck2__0$1x10$lang$Rail$1x10$lang$Double$2$2__1$1x10$lang$Double$2__2$1x10$lang$Double$2(final x10.core.Rail<x10.core.Rail<x10.core.Double>> C, final x10.core.Rail<x10.core.Double> D, final x10.core.Rail<x10.core.Double> value) {
        
        //#line 781 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        final long t$47900 = ((x10.core.Rail<x10.core.Rail<x10.core.Double>>)C).size;
        
        //#line 781 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        x10.core.Rail out = new x10.core.Rail<x10.core.Boolean>(x10.rtt.Types.BOOLEAN, ((long)(t$47900)));
        
        //#line 782 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        long i$50281 = 0L;
        {
            
            //#line 782 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            final x10.core.Rail[] C$value$51236 = ((x10.core.Rail[])C.value);
            
            //#line 782 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            final double[] D$value$51237 = ((double[])D.value);
            
            //#line 782 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            for (;
                 true;
                 ) {
                
                //#line 782 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long t$50282 = i$50281;
                
                //#line 782 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long t$50283 = ((x10.core.Rail<x10.core.Rail<x10.core.Double>>)C).size;
                
                //#line 782 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final boolean t$50284 = ((t$50282) < (((long)(t$50283))));
                
                //#line 782 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                if (!(t$50284)) {
                    
                    //#line 782 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    break;
                }
                
                //#line 783 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long t$50215 = plham.util.Matrix.DEBUG;
                
                //#line 783 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final boolean t$50216 = ((long) t$50215) == ((long) -2L);
                
                //#line 783 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                if (t$50216) {
                    
                }
                
                //#line 788 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long t$50217 = i$50281;
                
                //#line 788 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final x10.core.Rail t$50218 = ((x10.core.Rail<x10.core.Double>)C$value$51236[(int)t$50217]);
                
                //#line 788 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final double t$50219 = plham.util.Matrix.multiply__0$1x10$lang$Double$2__1$1x10$lang$Double$2$O(((x10.core.Rail)(t$50218)), ((x10.core.Rail)(value)));
                
                //#line 788 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long t$50220 = plham.util.Matrix.index;
                
                //#line 788 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final double t$50221 = plham.util.Matrix.round$O((double)(t$50219), (long)(t$50220));
                
                //#line 788 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long t$50222 = i$50281;
                
                //#line 788 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final double t$50223 = ((double)D$value$51237[(int)t$50222]);
                
                //#line 788 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long t$50224 = plham.util.Matrix.index;
                
                //#line 788 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final double t$50225 = plham.util.Matrix.round$O((double)(t$50223), (long)(t$50224));
                
                //#line 788 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final double t$50226 = ((t$50221) - (((double)(t$50225))));
                
                //#line 788 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long t$50227 = plham.util.Matrix.index;
                
                //#line 788 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final double t$50228 = plham.util.Matrix.round$O((double)(t$50226), (long)(t$50227));
                
                //#line 788 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final double t$50229 = java.lang.Math.abs(((double)(t$50228)));
                
                //#line 788 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final double t$50230 = plham.util.Matrix.epsilon2;
                
                //#line 788 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long t$50231 = i$50281;
                
                //#line 788 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final double t$50232 = ((double)D$value$51237[(int)t$50231]);
                
                //#line 788 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long t$50233 = plham.util.Matrix.index;
                
                //#line 788 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final double t$50234 = plham.util.Matrix.round$O((double)(t$50232), (long)(t$50233));
                
                //#line 788 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final double t$50235 = java.lang.Math.abs(((double)(t$50234)));
                
                //#line 788 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final double t$50236 = ((t$50230) * (((double)(t$50235))));
                
                //#line 788 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                boolean t$50237 = ((t$50229) <= (((double)(t$50236))));
                
                //#line 788 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                if (!(t$50237)) {
                    
                    //#line 788 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final long t$50238 = i$50281;
                    
                    //#line 788 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final x10.core.Rail t$50239 = ((x10.core.Rail<x10.core.Double>)C$value$51236[(int)t$50238]);
                    
                    //#line 788 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final double t$50240 = plham.util.Matrix.multiply__0$1x10$lang$Double$2__1$1x10$lang$Double$2$O(((x10.core.Rail)(t$50239)), ((x10.core.Rail)(value)));
                    
                    //#line 788 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final long t$50241 = plham.util.Matrix.index;
                    
                    //#line 788 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final double t$50242 = plham.util.Matrix.round$O((double)(t$50240), (long)(t$50241));
                    
                    //#line 788 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final long t$50243 = i$50281;
                    
                    //#line 788 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final double t$50244 = ((double)D$value$51237[(int)t$50243]);
                    
                    //#line 788 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final long t$50245 = plham.util.Matrix.index;
                    
                    //#line 788 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final double t$50246 = plham.util.Matrix.round$O((double)(t$50244), (long)(t$50245));
                    
                    //#line 788 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final double t$50247 = ((t$50242) - (((double)(t$50246))));
                    
                    //#line 788 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final long t$50248 = plham.util.Matrix.index;
                    
                    //#line 788 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final double t$50249 = plham.util.Matrix.round$O((double)(t$50247), (long)(t$50248));
                    
                    //#line 788 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final double t$50250 = java.lang.Math.abs(((double)(t$50249)));
                    
                    //#line 788 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final double t$50251 = plham.util.Matrix.epsilon;
                    
                    //#line 788 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    t$50237 = ((t$50250) <= (((double)(t$50251))));
                }
                
                //#line 788 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                boolean t$50252 = t$50237;
                
                //#line 788 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                if (!(t$50252)) {
                    
                    //#line 788 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final long t$50253 = i$50281;
                    
                    //#line 788 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final x10.core.Rail t$50254 = ((x10.core.Rail<x10.core.Double>)C$value$51236[(int)t$50253]);
                    
                    //#line 788 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final double t$50255 = plham.util.Matrix.multiply__0$1x10$lang$Double$2__1$1x10$lang$Double$2$O(((x10.core.Rail)(t$50254)), ((x10.core.Rail)(value)));
                    
                    //#line 788 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final long t$50256 = plham.util.Matrix.index;
                    
                    //#line 788 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final double t$50257 = plham.util.Matrix.round$O((double)(t$50255), (long)(t$50256));
                    
                    //#line 788 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final long t$50258 = i$50281;
                    
                    //#line 788 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final double t$50259 = ((double)D$value$51237[(int)t$50258]);
                    
                    //#line 788 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final long t$50260 = plham.util.Matrix.index;
                    
                    //#line 788 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final double t$50261 = plham.util.Matrix.round$O((double)(t$50259), (long)(t$50260));
                    
                    //#line 788 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final double t$50262 = ((t$50257) - (((double)(t$50261))));
                    
                    //#line 788 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final long t$50263 = plham.util.Matrix.index;
                    
                    //#line 788 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final double t$50264 = plham.util.Matrix.round$O((double)(t$50262), (long)(t$50263));
                    
                    //#line 788 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final double t$50265 = java.lang.Math.abs(((double)(t$50264)));
                    
                    //#line 788 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final double t$50266 = plham.util.Matrix.epsilon2;
                    
                    //#line 788 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final long t$50267 = i$50281;
                    
                    //#line 788 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final x10.core.Rail t$50268 = ((x10.core.Rail<x10.core.Double>)C$value$51236[(int)t$50267]);
                    
                    //#line 788 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final double t$50269 = plham.util.Matrix.multiply__0$1x10$lang$Double$2__1$1x10$lang$Double$2$O(((x10.core.Rail)(t$50268)), ((x10.core.Rail)(value)));
                    
                    //#line 788 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final long t$50270 = plham.util.Matrix.index;
                    
                    //#line 788 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final double t$50271 = plham.util.Matrix.round$O((double)(t$50269), (long)(t$50270));
                    
                    //#line 788 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final double t$50272 = java.lang.Math.abs(((double)(t$50271)));
                    
                    //#line 788 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final double t$50273 = ((t$50266) * (((double)(t$50272))));
                    
                    //#line 788 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    t$50252 = ((t$50265) <= (((double)(t$50273))));
                }
                
                //#line 788 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final boolean t$50274 = t$50252;
                
                //#line 788 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                if (t$50274) {
                    
                    //#line 789 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final x10.core.Rail t$50275 = ((x10.core.Rail)(out));
                    
                    //#line 789 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final long t$50276 = i$50281;
                    
                    //#line 789 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    ((boolean[])t$50275.value)[(int)t$50276] = true;
                } else {
                    
                    //#line 790 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final x10.core.Rail t$50277 = ((x10.core.Rail)(out));
                    
                    //#line 790 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final long t$50278 = i$50281;
                    
                    //#line 790 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    ((boolean[])t$50277.value)[(int)t$50278] = false;
                }
                
                //#line 782 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long t$50279 = i$50281;
                
                //#line 782 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long t$50280 = ((t$50279) + (((long)(1L))));
                
                //#line 782 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                i$50281 = t$50280;
            }
        }
        
        //#line 795 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        final x10.core.Rail t$47971 = ((x10.core.Rail)(out));
        
        //#line 795 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        return t$47971;
    }
    
    
    //#line 798 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
    public static void setActiveCheck__0$1x10$lang$Boolean$2__1$1x10$lang$Rail$1x10$lang$Double$2$2__2$1x10$lang$Double$2__3$1x10$lang$Double$2(final x10.core.Rail<x10.core.Boolean> activeCheck, final x10.core.Rail<x10.core.Rail<x10.core.Double>> C, final x10.core.Rail<x10.core.Double> D, final x10.core.Rail<x10.core.Double> value) {
        
        //#line 799 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        final long i$45917min$45918 = 0L;
        
        //#line 799 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        final long t$47972 = ((x10.core.Rail<x10.core.Rail<x10.core.Double>>)C).size;
        
        //#line 799 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        final long i$45917max$45919 = ((t$47972) - (((long)(1L))));
        
        //#line 799 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        long i$50338 = i$45917min$45918;
        {
            
            //#line 799 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            final x10.core.Rail[] C$value$51238 = ((x10.core.Rail[])C.value);
            
            //#line 799 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            final double[] D$value$51239 = ((double[])D.value);
            
            //#line 799 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            final boolean[] activeCheck$value$51240 = ((boolean[])activeCheck.value);
            
            //#line 799 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            for (;
                 true;
                 ) {
                
                //#line 799 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long t$50339 = i$50338;
                
                //#line 799 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final boolean t$50340 = ((t$50339) <= (((long)(i$45917max$45919))));
                
                //#line 799 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                if (!(t$50340)) {
                    
                    //#line 799 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    break;
                }
                
                //#line 799 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long i$50335 = i$50338;
                
                //#line 801 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final x10.core.Rail t$50285 = ((x10.core.Rail<x10.core.Double>)C$value$51238[(int)i$50335]);
                
                //#line 801 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final double t$50286 = plham.util.Matrix.multiply__0$1x10$lang$Double$2__1$1x10$lang$Double$2$O(((x10.core.Rail)(t$50285)), ((x10.core.Rail)(value)));
                
                //#line 801 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long t$50287 = plham.util.Matrix.index;
                
                //#line 801 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final double t$50288 = plham.util.Matrix.round$O((double)(t$50286), (long)(t$50287));
                
                //#line 801 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final double t$50289 = ((double)D$value$51239[(int)i$50335]);
                
                //#line 801 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long t$50290 = plham.util.Matrix.index;
                
                //#line 801 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final double t$50291 = plham.util.Matrix.round$O((double)(t$50289), (long)(t$50290));
                
                //#line 801 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final double t$50292 = ((t$50288) - (((double)(t$50291))));
                
                //#line 801 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long t$50293 = plham.util.Matrix.index;
                
                //#line 801 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final double t$50294 = plham.util.Matrix.round$O((double)(t$50292), (long)(t$50293));
                
                //#line 801 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final double t$50295 = java.lang.Math.abs(((double)(t$50294)));
                
                //#line 801 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final double t$50296 = plham.util.Matrix.epsilon2;
                
                //#line 801 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final double t$50297 = ((double)D$value$51239[(int)i$50335]);
                
                //#line 801 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long t$50298 = plham.util.Matrix.index;
                
                //#line 801 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final double t$50299 = plham.util.Matrix.round$O((double)(t$50297), (long)(t$50298));
                
                //#line 801 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final double t$50300 = java.lang.Math.abs(((double)(t$50299)));
                
                //#line 801 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final double t$50301 = ((t$50296) * (((double)(t$50300))));
                
                //#line 801 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                boolean t$50302 = ((t$50295) <= (((double)(t$50301))));
                
                //#line 801 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                if (!(t$50302)) {
                    
                    //#line 802 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final x10.core.Rail t$50303 = ((x10.core.Rail<x10.core.Double>)C$value$51238[(int)i$50335]);
                    
                    //#line 802 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final double t$50304 = plham.util.Matrix.multiply__0$1x10$lang$Double$2__1$1x10$lang$Double$2$O(((x10.core.Rail)(t$50303)), ((x10.core.Rail)(value)));
                    
                    //#line 802 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final long t$50305 = plham.util.Matrix.index;
                    
                    //#line 802 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final double t$50306 = plham.util.Matrix.round$O((double)(t$50304), (long)(t$50305));
                    
                    //#line 802 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final double t$50307 = ((double)D$value$51239[(int)i$50335]);
                    
                    //#line 802 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final long t$50308 = plham.util.Matrix.index;
                    
                    //#line 802 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final double t$50309 = plham.util.Matrix.round$O((double)(t$50307), (long)(t$50308));
                    
                    //#line 802 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final double t$50310 = ((t$50306) - (((double)(t$50309))));
                    
                    //#line 802 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final long t$50311 = plham.util.Matrix.index;
                    
                    //#line 802 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final double t$50312 = plham.util.Matrix.round$O((double)(t$50310), (long)(t$50311));
                    
                    //#line 802 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final double t$50313 = java.lang.Math.abs(((double)(t$50312)));
                    
                    //#line 802 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final double t$50314 = plham.util.Matrix.epsilon;
                    
                    //#line 801 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    t$50302 = ((t$50313) <= (((double)(t$50314))));
                }
                
                //#line 801 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                boolean t$50315 = t$50302;
                
                //#line 801 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                if (!(t$50315)) {
                    
                    //#line 803 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final x10.core.Rail t$50316 = ((x10.core.Rail<x10.core.Double>)C$value$51238[(int)i$50335]);
                    
                    //#line 803 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final double t$50317 = plham.util.Matrix.multiply__0$1x10$lang$Double$2__1$1x10$lang$Double$2$O(((x10.core.Rail)(t$50316)), ((x10.core.Rail)(value)));
                    
                    //#line 803 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final long t$50318 = plham.util.Matrix.index;
                    
                    //#line 803 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final double t$50319 = plham.util.Matrix.round$O((double)(t$50317), (long)(t$50318));
                    
                    //#line 803 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final double t$50320 = ((double)D$value$51239[(int)i$50335]);
                    
                    //#line 803 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final long t$50321 = plham.util.Matrix.index;
                    
                    //#line 803 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final double t$50322 = plham.util.Matrix.round$O((double)(t$50320), (long)(t$50321));
                    
                    //#line 803 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final double t$50323 = ((t$50319) - (((double)(t$50322))));
                    
                    //#line 803 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final long t$50324 = plham.util.Matrix.index;
                    
                    //#line 803 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final double t$50325 = plham.util.Matrix.round$O((double)(t$50323), (long)(t$50324));
                    
                    //#line 803 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final double t$50326 = java.lang.Math.abs(((double)(t$50325)));
                    
                    //#line 803 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final double t$50327 = plham.util.Matrix.epsilon2;
                    
                    //#line 803 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final x10.core.Rail t$50328 = ((x10.core.Rail<x10.core.Double>)C$value$51238[(int)i$50335]);
                    
                    //#line 803 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final double t$50329 = plham.util.Matrix.multiply__0$1x10$lang$Double$2__1$1x10$lang$Double$2$O(((x10.core.Rail)(t$50328)), ((x10.core.Rail)(value)));
                    
                    //#line 803 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final long t$50330 = plham.util.Matrix.index;
                    
                    //#line 803 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final double t$50331 = plham.util.Matrix.round$O((double)(t$50329), (long)(t$50330));
                    
                    //#line 803 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final double t$50332 = java.lang.Math.abs(((double)(t$50331)));
                    
                    //#line 803 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final double t$50333 = ((t$50327) * (((double)(t$50332))));
                    
                    //#line 801 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    t$50315 = ((t$50326) <= (((double)(t$50333))));
                }
                
                //#line 801 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final boolean t$50334 = t$50315;
                
                //#line 801 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                if (t$50334) {
                    
                    //#line 804 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    activeCheck$value$51240[(int)i$50335]=true;
                }
                
                //#line 799 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long t$50336 = i$50338;
                
                //#line 799 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long t$50337 = ((t$50336) + (((long)(1L))));
                
                //#line 799 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                i$50338 = t$50337;
            }
        }
    }
    
    
    //#line 810 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
    public static x10.core.Rail iteration__0$1x10$lang$Rail$1x10$lang$Double$2$2__1$1x10$lang$Double$2(final x10.core.Rail<x10.core.Rail<x10.core.Double>> m, final x10.core.Rail<x10.core.Double> b, final long num) {
        
        //#line 811 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        assert plham.util.Matrix.checkForIterative__0$1x10$lang$Rail$1x10$lang$Double$2$2$O(((x10.core.Rail)(m))): "error";
        
        //#line 815 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        final long n = ((x10.core.Rail<x10.core.Rail<x10.core.Double>>)m).size;
        
        //#line 816 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        final x10.core.Rail lu = plham.util.Matrix.decompose__0$1x10$lang$Rail$1x10$lang$Double$2$2(((x10.core.Rail)(m)));
        
        //#line 817 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        x10.core.Rail last = plham.util.Matrix.luSolver__0$1x10$lang$Rail$1x10$lang$Double$2$2__1$1x10$lang$Double$2(((x10.core.Rail)(lu)), ((x10.core.Rail)(b)));
        
        //#line 819 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        x10.core.Rail now = new x10.core.Rail<x10.core.Double>(x10.rtt.Types.DOUBLE, ((long)(n)));
        
        //#line 820 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        double d = 0.0;
        
        //#line 821 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        long i$50405 = 0L;
        {
            
            //#line 821 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            final double[] b$value$51241 = ((double[])b.value);
            
            //#line 821 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            for (;
                 true;
                 ) {
                
                //#line 821 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long t$50406 = i$50405;
                
                //#line 821 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final boolean t$50407 = ((t$50406) < (((long)(num))));
                
                //#line 821 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                if (!(t$50407)) {
                    
                    //#line 821 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    break;
                }
                
                //#line 822 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                d = 0.0;
                
                //#line 823 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final x10.core.Rail t$50381 = ((x10.core.Rail)(last));
                
                //#line 823 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                x10.core.Rail right$50382 = plham.util.Matrix.multiply__0$1x10$lang$Rail$1x10$lang$Double$2$2__1$1x10$lang$Double$2(((x10.core.Rail)(m)), ((x10.core.Rail)(t$50381)));
                
                //#line 824 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                long j$50371 = 0L;
                {
                    
                    //#line 824 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    for (;
                         true;
                         ) {
                        
                        //#line 824 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        final long t$50372 = j$50371;
                        
                        //#line 824 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        final x10.core.Rail t$50373 = ((x10.core.Rail)(right$50382));
                        
                        //#line 824 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        final long t$50374 = ((x10.core.Rail<x10.core.Double>)t$50373).size;
                        
                        //#line 824 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        final boolean t$50375 = ((t$50372) < (((long)(t$50374))));
                        
                        //#line 824 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        if (!(t$50375)) {
                            
                            //#line 824 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                            break;
                        }
                        
                        //#line 824 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        final x10.core.Rail t$50341 = ((x10.core.Rail)(right$50382));
                        
                        //#line 824 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        final long t$50342 = j$50371;
                        
                        //#line 824 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        final x10.core.Rail t$50343 = ((x10.core.Rail)(right$50382));
                        
                        //#line 824 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        final long t$50344 = j$50371;
                        
                        //#line 824 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        final double t$50345 = ((double[])t$50343.value)[(int)t$50344];
                        
                        //#line 824 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        final long t$50346 = j$50371;
                        
                        //#line 824 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        final double t$50347 = ((double)b$value$51241[(int)t$50346]);
                        
                        //#line 824 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        final double t$50348 = ((t$50345) - (((double)(t$50347))));
                        
                        //#line 824 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        ((double[])t$50341.value)[(int)t$50342] = t$50348;
                        
                        //#line 824 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        final long t$50349 = j$50371;
                        
                        //#line 824 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        final long t$50350 = ((t$50349) + (((long)(1L))));
                        
                        //#line 824 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        j$50371 = t$50350;
                    }
                }
                
                //#line 825 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final x10.core.Rail t$50383 = ((x10.core.Rail)(right$50382));
                
                //#line 825 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final x10.core.Rail t$50384 = plham.util.Matrix.luSolver__0$1x10$lang$Rail$1x10$lang$Double$2$2__1$1x10$lang$Double$2(((x10.core.Rail)(lu)), ((x10.core.Rail)(t$50383)));
                
                //#line 825 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                right$50382 = ((x10.core.Rail)(t$50384));
                
                //#line 826 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                long j$50376 = 0L;
                
                //#line 826 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                for (;
                     true;
                     ) {
                    
                    //#line 826 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final long t$50377 = j$50376;
                    
                    //#line 826 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final x10.core.Rail t$50378 = ((x10.core.Rail)(right$50382));
                    
                    //#line 826 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final long t$50379 = ((x10.core.Rail<x10.core.Double>)t$50378).size;
                    
                    //#line 826 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final boolean t$50380 = ((t$50377) < (((long)(t$50379))));
                    
                    //#line 826 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    if (!(t$50380)) {
                        
                        //#line 826 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        break;
                    }
                    
                    //#line 827 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final double t$50351 = d;
                    
                    //#line 827 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final x10.core.Rail t$50352 = ((x10.core.Rail)(right$50382));
                    
                    //#line 827 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final long t$50353 = j$50376;
                    
                    //#line 827 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final double t$50354 = ((double[])t$50352.value)[(int)t$50353];
                    
                    //#line 827 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final x10.core.Rail t$50355 = ((x10.core.Rail)(right$50382));
                    
                    //#line 827 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final long t$50356 = j$50376;
                    
                    //#line 827 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final double t$50357 = ((double[])t$50355.value)[(int)t$50356];
                    
                    //#line 827 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final double t$50358 = ((t$50354) * (((double)(t$50357))));
                    
                    //#line 827 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final double t$50359 = ((t$50351) + (((double)(t$50358))));
                    
                    //#line 827 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    d = t$50359;
                    
                    //#line 828 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final x10.core.Rail t$50360 = ((x10.core.Rail)(now));
                    
                    //#line 828 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final long t$50361 = j$50376;
                    
                    //#line 828 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final x10.core.Rail t$50362 = ((x10.core.Rail)(last));
                    
                    //#line 828 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final long t$50363 = j$50376;
                    
                    //#line 828 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final double t$50364 = ((double[])t$50362.value)[(int)t$50363];
                    
                    //#line 828 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final x10.core.Rail t$50365 = ((x10.core.Rail)(right$50382));
                    
                    //#line 828 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final long t$50366 = j$50376;
                    
                    //#line 828 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final double t$50367 = ((double[])t$50365.value)[(int)t$50366];
                    
                    //#line 828 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final double t$50368 = ((t$50364) - (((double)(t$50367))));
                    
                    //#line 828 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    ((double[])t$50360.value)[(int)t$50361] = t$50368;
                    
                    //#line 826 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final long t$50369 = j$50376;
                    
                    //#line 826 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final long t$50370 = ((t$50369) + (((long)(1L))));
                    
                    //#line 826 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    j$50376 = t$50370;
                }
                
                //#line 830 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final double t$50385 = d;
                
                //#line 830 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final double t$50386 = java.lang.Math.sqrt(((double)(t$50385)));
                
                //#line 830 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                d = t$50386;
                
                //#line 833 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final double t$50387 = d;
                
                //#line 833 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long t$50388 = plham.util.Matrix.index;
                
                //#line 833 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final double t$50389 = plham.util.Matrix.round$O((double)(t$50387), (long)(t$50388));
                
                //#line 833 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final double t$50390 = plham.util.Matrix.epsilon2;
                
                //#line 833 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final double t$50391 = d;
                
                //#line 833 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long t$50392 = plham.util.Matrix.index;
                
                //#line 833 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final double t$50393 = plham.util.Matrix.round$O((double)(t$50391), (long)(t$50392));
                
                //#line 833 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final double t$50394 = ((t$50390) * (((double)(t$50393))));
                
                //#line 833 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                boolean t$50395 = ((t$50389) < (((double)(t$50394))));
                
                //#line 833 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                if (!(t$50395)) {
                    
                    //#line 833 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final double t$50396 = d;
                    
                    //#line 833 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final long t$50397 = plham.util.Matrix.index;
                    
                    //#line 833 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final double t$50398 = plham.util.Matrix.round$O((double)(t$50396), (long)(t$50397));
                    
                    //#line 833 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final double t$50399 = plham.util.Matrix.epsilon;
                    
                    //#line 833 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    t$50395 = ((t$50398) < (((double)(t$50399))));
                }
                
                //#line 833 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final boolean t$50400 = t$50395;
                
                //#line 833 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                if (t$50400) {
                    
                    //#line 833 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    break;
                }
                
                //#line 834 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final x10.core.Rail t$50401 = ((x10.core.Rail)(now));
                
                //#line 834 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                last = ((x10.core.Rail)(t$50401));
                
                //#line 835 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final x10.core.Rail t$50402 = ((x10.core.Rail)(new x10.core.Rail<x10.core.Double>(x10.rtt.Types.DOUBLE, ((long)(n)))));
                
                //#line 835 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                now = ((x10.core.Rail)(t$50402));
                
                //#line 821 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long t$50403 = i$50405;
                
                //#line 821 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long t$50404 = ((t$50403) + (((long)(1L))));
                
                //#line 821 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                i$50405 = t$50404;
            }
        }
        
        //#line 843 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        final x10.core.Rail t$48094 = ((x10.core.Rail)(last));
        
        //#line 843 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        return t$48094;
    }
    
    
    //#line 847 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
    public static double multiplier$O(final double min) {
        
        //#line 848 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        double out = 0.1;
        
        //#line 849 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        boolean t$50411 = false;
        
        //#line 849 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        do  {
            
            //#line 850 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            final double t$50408 = out;
            
            //#line 850 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            final double t$50409 = ((double)(long)(((long)(10L))));
            
            //#line 850 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            final double t$50410 = ((t$50408) * (((double)(t$50409))));
            
            //#line 850 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            out = t$50410;
            
            //#line 851 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            final double t$50412 = out;
            
            //#line 851 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            final double t$50413 = ((t$50412) * (((double)(min))));
            
            //#line 851 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            final double t$50414 = ((double)(long)(((long)(1L))));
            
            //#line 851 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            final boolean t$50415 = ((t$50413) < (((double)(t$50414))));
            
            //#line 849 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            t$50411 = t$50415;
        }while(t$50411); 
        
        //#line 852 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        final double t$48103 = out;
        
        //#line 852 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        return t$48103;
    }
    
    
    //#line 856 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
    public static x10.core.Rail multiply__0$1x10$lang$Rail$1x10$lang$Double$2$2__1$1x10$lang$Double$2(final x10.core.Rail<x10.core.Rail<x10.core.Double>> a, final x10.core.Rail<x10.core.Double> x) {
        
        //#line 857 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        assert ((long) ((x10.core.Rail<x10.core.Double>)((x10.core.Rail[])a.value)[(int)0L]).size) == ((long) ((x10.core.Rail<x10.core.Double>)x).size): "errorMulti";
        
        //#line 858 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        final long n = ((x10.core.Rail<x10.core.Rail<x10.core.Double>>)a).size;
        
        //#line 859 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        final x10.core.Rail t$48104 = ((x10.core.Rail[])a.value)[(int)0L];
        
        //#line 859 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        final long m = ((x10.core.Rail<x10.core.Double>)t$48104).size;
        
        //#line 861 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        x10.core.Rail out = new x10.core.Rail<x10.core.Double>(x10.rtt.Types.DOUBLE, ((long)(n)));
        
        //#line 862 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        long i$50436 = 0L;
        {
            
            //#line 862 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            final x10.core.Rail[] a$value$51242 = ((x10.core.Rail[])a.value);
            
            //#line 862 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            final double[] x$value$51243 = ((double[])x.value);
            
            //#line 862 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            for (;
                 true;
                 ) {
                
                //#line 862 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long t$50437 = i$50436;
                
                //#line 862 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final boolean t$50438 = ((t$50437) < (((long)(n))));
                
                //#line 862 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                if (!(t$50438)) {
                    
                    //#line 862 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    break;
                }
                
                //#line 863 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                long j$50431 = 0L;
                {
                    
                    //#line 863 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    for (;
                         true;
                         ) {
                        
                        //#line 863 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        final long t$50432 = j$50431;
                        
                        //#line 863 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        final boolean t$50433 = ((t$50432) < (((long)(m))));
                        
                        //#line 863 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        if (!(t$50433)) {
                            
                            //#line 863 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                            break;
                        }
                        
                        //#line 864 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        final x10.core.Rail t$50416 = ((x10.core.Rail)(out));
                        
                        //#line 864 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        final long t$50417 = i$50436;
                        
                        //#line 864 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        final x10.core.Rail t$50418 = ((x10.core.Rail)(out));
                        
                        //#line 864 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        final long t$50419 = i$50436;
                        
                        //#line 864 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        final double t$50420 = ((double[])t$50418.value)[(int)t$50419];
                        
                        //#line 864 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        final long t$50421 = i$50436;
                        
                        //#line 864 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        final x10.core.Rail t$50422 = ((x10.core.Rail<x10.core.Double>)a$value$51242[(int)t$50421]);
                        
                        //#line 864 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        final long t$50423 = j$50431;
                        
                        //#line 864 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        final double t$50424 = ((double[])t$50422.value)[(int)t$50423];
                        
                        //#line 864 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        final long t$50425 = j$50431;
                        
                        //#line 864 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        final double t$50426 = ((double)x$value$51243[(int)t$50425]);
                        
                        //#line 864 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        final double t$50427 = ((t$50424) * (((double)(t$50426))));
                        
                        //#line 864 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        final double t$50428 = ((t$50420) + (((double)(t$50427))));
                        
                        //#line 864 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        ((double[])t$50416.value)[(int)t$50417] = t$50428;
                        
                        //#line 863 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        final long t$50429 = j$50431;
                        
                        //#line 863 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        final long t$50430 = ((t$50429) + (((long)(1L))));
                        
                        //#line 863 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        j$50431 = t$50430;
                    }
                }
                
                //#line 862 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long t$50434 = i$50436;
                
                //#line 862 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long t$50435 = ((t$50434) + (((long)(1L))));
                
                //#line 862 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                i$50436 = t$50435;
            }
        }
        
        //#line 867 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        final x10.core.Rail t$48128 = ((x10.core.Rail)(out));
        
        //#line 867 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        return t$48128;
    }
    
    
    //#line 872 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
    public static double multiply__0$1x10$lang$Double$2__1$1x10$lang$Double$2$O(final x10.core.Rail<x10.core.Double> a, final x10.core.Rail<x10.core.Double> b) {
        
        //#line 873 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        assert ((long) ((x10.core.Rail<x10.core.Double>)a).size) == ((long) ((x10.core.Rail<x10.core.Double>)b).size): "errorMulti";
        
        //#line 874 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        final long n = ((x10.core.Rail<x10.core.Double>)a).size;
        
        //#line 875 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        double out = 0.0;
        
        //#line 876 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        long i$50448 = 0L;
        {
            
            //#line 876 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            final double[] a$value$51244 = ((double[])a.value);
            
            //#line 876 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            final double[] b$value$51245 = ((double[])b.value);
            
            //#line 876 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            for (;
                 true;
                 ) {
                
                //#line 876 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long t$50449 = i$50448;
                
                //#line 876 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final boolean t$50450 = ((t$50449) < (((long)(n))));
                
                //#line 876 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                if (!(t$50450)) {
                    
                    //#line 876 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    break;
                }
                
                //#line 877 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final double t$50439 = out;
                
                //#line 877 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long t$50440 = i$50448;
                
                //#line 877 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final double t$50441 = ((double)a$value$51244[(int)t$50440]);
                
                //#line 877 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long t$50442 = i$50448;
                
                //#line 877 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final double t$50443 = ((double)b$value$51245[(int)t$50442]);
                
                //#line 877 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final double t$50444 = ((t$50441) * (((double)(t$50443))));
                
                //#line 877 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final double t$50445 = ((t$50439) + (((double)(t$50444))));
                
                //#line 877 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                out = t$50445;
                
                //#line 876 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long t$50446 = i$50448;
                
                //#line 876 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long t$50447 = ((t$50446) + (((long)(1L))));
                
                //#line 876 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                i$50448 = t$50447;
            }
        }
        
        //#line 879 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        final double t$48141 = out;
        
        //#line 879 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        return t$48141;
    }
    
    
    //#line 883 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
    public static x10.core.Rail multiply__1$1x10$lang$Double$2(final double a, final x10.core.Rail<x10.core.Double> x) {
        
        //#line 884 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        final long n = ((x10.core.Rail<x10.core.Double>)x).size;
        
        //#line 885 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        x10.core.Rail out = new x10.core.Rail<x10.core.Double>(x10.rtt.Types.DOUBLE, ((long)(n)));
        
        //#line 886 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        long i$50458 = 0L;
        {
            
            //#line 886 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            final double[] x$value$51246 = ((double[])x.value);
            
            //#line 886 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            for (;
                 true;
                 ) {
                
                //#line 886 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long t$50459 = i$50458;
                
                //#line 886 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final boolean t$50460 = ((t$50459) < (((long)(n))));
                
                //#line 886 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                if (!(t$50460)) {
                    
                    //#line 886 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    break;
                }
                
                //#line 887 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final x10.core.Rail t$50451 = ((x10.core.Rail)(out));
                
                //#line 887 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long t$50452 = i$50458;
                
                //#line 887 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long t$50453 = i$50458;
                
                //#line 887 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final double t$50454 = ((double)x$value$51246[(int)t$50453]);
                
                //#line 887 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final double t$50455 = ((a) * (((double)(t$50454))));
                
                //#line 887 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                ((double[])t$50451.value)[(int)t$50452] = t$50455;
                
                //#line 886 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long t$50456 = i$50458;
                
                //#line 886 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long t$50457 = ((t$50456) + (((long)(1L))));
                
                //#line 886 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                i$50458 = t$50457;
            }
        }
        
        //#line 889 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        final x10.core.Rail t$48152 = ((x10.core.Rail)(out));
        
        //#line 889 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        return t$48152;
    }
    
    
    //#line 893 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
    public static x10.core.Rail multiply__1$1x10$lang$Rail$1x10$lang$Double$2$2(final double m, final x10.core.Rail<x10.core.Rail<x10.core.Double>> A) {
        
        //#line 894 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        final long n = ((x10.core.Rail<x10.core.Rail<x10.core.Double>>)A).size;
        
        //#line 895 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        x10.core.Rail out = new x10.core.Rail<x10.core.Rail<x10.core.Double>>(x10.rtt.ParameterizedType.make(x10.core.Rail.$RTT, x10.rtt.Types.DOUBLE), ((long)(n)));
        
        //#line 896 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        long i$50486 = 0L;
        {
            
            //#line 896 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            final x10.core.Rail[] A$value$51247 = ((x10.core.Rail[])A.value);
            
            //#line 896 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            for (;
                 true;
                 ) {
                
                //#line 896 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long t$50487 = i$50486;
                
                //#line 896 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final boolean t$50488 = ((t$50487) < (((long)(n))));
                
                //#line 896 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                if (!(t$50488)) {
                    
                    //#line 896 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    break;
                }
                
                //#line 897 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final x10.core.Rail t$50461 = ((x10.core.Rail)(out));
                
                //#line 897 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long t$50462 = i$50486;
                
                //#line 897 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final x10.core.Rail t$50463 = ((x10.core.Rail<x10.core.Double>)A$value$51247[(int)0L]);
                
                //#line 897 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long t$50464 = ((x10.core.Rail<x10.core.Double>)t$50463).size;
                
                //#line 897 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final x10.core.Rail t$50465 = ((x10.core.Rail)(new x10.core.Rail<x10.core.Double>(x10.rtt.Types.DOUBLE, t$50464)));
                
                //#line 897 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                ((x10.core.Rail[])t$50461.value)[(int)t$50462] = t$50465;
                
                //#line 896 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long t$50466 = i$50486;
                
                //#line 896 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long t$50467 = ((t$50466) + (((long)(1L))));
                
                //#line 896 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                i$50486 = t$50467;
            }
        }
        
        //#line 899 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        long i$50489 = 0L;
        {
            
            //#line 899 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            final x10.core.Rail[] A$value$51248 = ((x10.core.Rail[])A.value);
            
            //#line 899 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            for (;
                 true;
                 ) {
                
                //#line 899 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long t$50490 = i$50489;
                
                //#line 899 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final boolean t$50491 = ((t$50490) < (((long)(n))));
                
                //#line 899 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                if (!(t$50491)) {
                    
                    //#line 899 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    break;
                }
                
                //#line 900 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                long j$50479 = 0L;
                {
                    
                    //#line 900 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    for (;
                         true;
                         ) {
                        
                        //#line 900 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        final long t$50480 = j$50479;
                        
                        //#line 900 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        final x10.core.Rail t$50481 = ((x10.core.Rail<x10.core.Double>)A$value$51248[(int)0L]);
                        
                        //#line 900 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        final long t$50482 = ((x10.core.Rail<x10.core.Double>)t$50481).size;
                        
                        //#line 900 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        final boolean t$50483 = ((t$50480) < (((long)(t$50482))));
                        
                        //#line 900 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        if (!(t$50483)) {
                            
                            //#line 900 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                            break;
                        }
                        
                        //#line 901 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        final x10.core.Rail t$50468 = ((x10.core.Rail)(out));
                        
                        //#line 901 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        final long t$50469 = i$50489;
                        
                        //#line 901 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        final x10.core.Rail t$50470 = ((x10.core.Rail[])t$50468.value)[(int)t$50469];
                        
                        //#line 901 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        final long t$50471 = j$50479;
                        
                        //#line 901 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        final long t$50472 = i$50489;
                        
                        //#line 901 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        final x10.core.Rail t$50473 = ((x10.core.Rail<x10.core.Double>)A$value$51248[(int)t$50472]);
                        
                        //#line 901 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        final long t$50474 = j$50479;
                        
                        //#line 901 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        final double t$50475 = ((double[])t$50473.value)[(int)t$50474];
                        
                        //#line 901 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        final double t$50476 = ((m) * (((double)(t$50475))));
                        
                        //#line 901 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        ((double[])t$50470.value)[(int)t$50471] = t$50476;
                        
                        //#line 900 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        final long t$50477 = j$50479;
                        
                        //#line 900 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        final long t$50478 = ((t$50477) + (((long)(1L))));
                        
                        //#line 900 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        j$50479 = t$50478;
                    }
                }
                
                //#line 899 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long t$50484 = i$50489;
                
                //#line 899 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long t$50485 = ((t$50484) + (((long)(1L))));
                
                //#line 899 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                i$50489 = t$50485;
            }
        }
        
        //#line 904 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        final x10.core.Rail t$48184 = ((x10.core.Rail)(out));
        
        //#line 904 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        return t$48184;
    }
    
    
    //#line 907 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
    public static x10.core.Rail plus__0$1x10$lang$Long$2__1$1x10$lang$Long$2(final x10.core.Rail<x10.core.Long> x, final x10.core.Rail<x10.core.Long> y) {
        
        //#line 908 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        assert ((long) ((x10.core.Rail<x10.core.Long>)x).size) == ((long) ((x10.core.Rail<x10.core.Long>)y).size): "plusError";
        
        //#line 909 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        final long n = ((x10.core.Rail<x10.core.Long>)x).size;
        
        //#line 910 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        x10.core.Rail out = new x10.core.Rail<x10.core.Long>(x10.rtt.Types.LONG, ((long)(n)));
        
        //#line 911 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        final long i$45935min$50502 = 0L;
        
        //#line 911 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        final long i$45935max$50503 = ((n) - (((long)(1L))));
        
        //#line 911 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        long i$50499 = i$45935min$50502;
        {
            
            //#line 911 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            final long[] x$value$51249 = ((long[])x.value);
            
            //#line 911 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            final long[] y$value$51250 = ((long[])y.value);
            
            //#line 911 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            for (;
                 true;
                 ) {
                
                //#line 911 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long t$50500 = i$50499;
                
                //#line 911 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final boolean t$50501 = ((t$50500) <= (((long)(i$45935max$50503))));
                
                //#line 911 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                if (!(t$50501)) {
                    
                    //#line 911 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    break;
                }
                
                //#line 911 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long i$50496 = i$50499;
                
                //#line 912 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final x10.core.Rail t$50492 = ((x10.core.Rail)(out));
                
                //#line 912 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long t$50493 = ((long)x$value$51249[(int)i$50496]);
                
                //#line 912 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long t$50494 = ((long)y$value$51250[(int)i$50496]);
                
                //#line 912 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long t$50495 = ((t$50493) + (((long)(t$50494))));
                
                //#line 912 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                ((long[])t$50492.value)[(int)i$50496] = t$50495;
                
                //#line 911 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long t$50497 = i$50499;
                
                //#line 911 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long t$50498 = ((t$50497) + (((long)(1L))));
                
                //#line 911 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                i$50499 = t$50498;
            }
        }
        
        //#line 914 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        final x10.core.Rail t$48194 = ((x10.core.Rail)(out));
        
        //#line 914 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        return t$48194;
    }
    
    
    //#line 920 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
    public static boolean checkForIterative__0$1x10$lang$Rail$1x10$lang$Double$2$2$O(final x10.core.Rail<x10.core.Rail<x10.core.Double>> m) {
        
        //#line 921 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        assert ((long) ((x10.core.Rail<x10.core.Rail<x10.core.Double>>)m).size) == ((long) ((x10.core.Rail<x10.core.Double>)((x10.core.Rail[])m.value)[(int)0L]).size): (((((("error:") + ((x10.core.Long.$box(((x10.core.Rail<x10.core.Rail<x10.core.Double>>)m).size))))) + (","))) + ((x10.core.Long.$box(((x10.core.Rail<x10.core.Double>)((x10.core.Rail[])m.value)[(int)0L]).size))));
        
        //#line 922 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        final long n = ((x10.core.Rail<x10.core.Rail<x10.core.Double>>)m).size;
        
        //#line 923 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        long i$50529 = 0L;
        {
            
            //#line 923 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            final x10.core.Rail[] m$value$51251 = ((x10.core.Rail[])m.value);
            
            //#line 923 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            for (;
                 true;
                 ) {
                
                //#line 923 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long t$50530 = i$50529;
                
                //#line 923 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final boolean t$50531 = ((t$50530) < (((long)(n))));
                
                //#line 923 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                if (!(t$50531)) {
                    
                    //#line 923 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    break;
                }
                
                //#line 924 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long t$50519 = i$50529;
                
                //#line 924 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final x10.core.Rail t$50520 = ((x10.core.Rail<x10.core.Double>)m$value$51251[(int)t$50519]);
                
                //#line 924 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long t$50521 = i$50529;
                
                //#line 924 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final double t$50522 = ((double[])t$50520.value)[(int)t$50521];
                
                //#line 924 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final double upper$50523 = java.lang.Math.abs(((double)(t$50522)));
                
                //#line 925 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                double sum$50524 = ((double)(long)(((long)(0L))));
                
                //#line 926 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                long j$50516 = 0L;
                {
                    
                    //#line 926 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    for (;
                         true;
                         ) {
                        
                        //#line 926 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        final long t$50517 = j$50516;
                        
                        //#line 926 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        final boolean t$50518 = ((t$50517) < (((long)(n))));
                        
                        //#line 926 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        if (!(t$50518)) {
                            
                            //#line 926 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                            break;
                        }
                        
                        //#line 927 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        final long t$50504 = i$50529;
                        
                        //#line 927 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        final long t$50505 = j$50516;
                        
                        //#line 927 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        final boolean t$50506 = ((long) t$50504) != ((long) t$50505);
                        
                        //#line 927 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        if (t$50506) {
                            
                            //#line 928 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                            final double t$50507 = sum$50524;
                            
                            //#line 928 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                            final long t$50508 = i$50529;
                            
                            //#line 928 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                            final x10.core.Rail t$50509 = ((x10.core.Rail<x10.core.Double>)m$value$51251[(int)t$50508]);
                            
                            //#line 928 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                            final long t$50510 = j$50516;
                            
                            //#line 928 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                            final double t$50511 = ((double[])t$50509.value)[(int)t$50510];
                            
                            //#line 928 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                            final double t$50512 = java.lang.Math.abs(((double)(t$50511)));
                            
                            //#line 928 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                            final double t$50513 = ((t$50507) + (((double)(t$50512))));
                            
                            //#line 928 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                            sum$50524 = t$50513;
                        }
                        
                        //#line 926 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        final long t$50514 = j$50516;
                        
                        //#line 926 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        final long t$50515 = ((t$50514) + (((long)(1L))));
                        
                        //#line 926 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        j$50516 = t$50515;
                    }
                }
                
                //#line 931 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final double t$50525 = sum$50524;
                
                //#line 931 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final boolean t$50526 = ((upper$50523) <= (((double)(t$50525))));
                
                //#line 931 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                if (t$50526) {
                    
                    //#line 931 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    return false;
                }
                
                //#line 923 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long t$50527 = i$50529;
                
                //#line 923 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long t$50528 = ((t$50527) + (((long)(1L))));
                
                //#line 923 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                i$50529 = t$50528;
            }
        }
        
        //#line 933 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        return true;
    }
    
    
    //#line 938 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
    public static x10.core.Rail luSolver__0$1x10$lang$Rail$1x10$lang$Double$2$2__1$1x10$lang$Double$2(final x10.core.Rail<x10.core.Rail<x10.core.Double>> lu, final x10.core.Rail<x10.core.Double> b) {
        
        //#line 939 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        assert ((long) ((x10.core.Rail<x10.core.Rail<x10.core.Double>>)lu).size) == ((long) ((x10.core.Rail<x10.core.Double>)((x10.core.Rail[])lu.value)[(int)0L]).size): "error";
        
        //#line 940 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        assert ((long) ((x10.core.Rail<x10.core.Rail<x10.core.Double>>)lu).size) == ((long) ((x10.core.Rail<x10.core.Double>)b).size): "error";
        
        //#line 941 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        final long n = ((x10.core.Rail<x10.core.Rail<x10.core.Double>>)lu).size;
        
        //#line 942 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        x10.core.Rail x = new x10.core.Rail<x10.core.Double>(x10.rtt.Types.DOUBLE, ((long)(n)));
        
        //#line 946 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        long i$50584 = 0L;
        {
            
            //#line 946 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            final x10.core.Rail[] lu$value$51252 = ((x10.core.Rail[])lu.value);
            
            //#line 946 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            final double[] b$value$51253 = ((double[])b.value);
            
            //#line 946 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            for (;
                 true;
                 ) {
                
                //#line 946 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long t$50585 = i$50584;
                
                //#line 946 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final boolean t$50586 = ((t$50585) < (((long)(n))));
                
                //#line 946 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                if (!(t$50586)) {
                    
                    //#line 946 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    break;
                }
                
                //#line 947 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long t$50548 = i$50584;
                
                //#line 947 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                double bly$50549 = ((double)b$value$51253[(int)t$50548]);
                
                //#line 948 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                long j$50544 = 0L;
                {
                    
                    //#line 948 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    for (;
                         true;
                         ) {
                        
                        //#line 948 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        final long t$50545 = j$50544;
                        
                        //#line 948 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        final long t$50546 = i$50584;
                        
                        //#line 948 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        final boolean t$50547 = ((t$50545) < (((long)(t$50546))));
                        
                        //#line 948 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        if (!(t$50547)) {
                            
                            //#line 948 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                            break;
                        }
                        
                        //#line 949 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        final double t$50532 = bly$50549;
                        
                        //#line 949 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        final long t$50533 = i$50584;
                        
                        //#line 949 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        final x10.core.Rail t$50534 = ((x10.core.Rail<x10.core.Double>)lu$value$51252[(int)t$50533]);
                        
                        //#line 949 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        final long t$50535 = j$50544;
                        
                        //#line 949 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        final double t$50536 = ((double[])t$50534.value)[(int)t$50535];
                        
                        //#line 949 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        final x10.core.Rail t$50537 = ((x10.core.Rail)(x));
                        
                        //#line 949 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        final long t$50538 = j$50544;
                        
                        //#line 949 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        final double t$50539 = ((double[])t$50537.value)[(int)t$50538];
                        
                        //#line 949 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        final double t$50540 = ((t$50536) * (((double)(t$50539))));
                        
                        //#line 949 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        final double t$50541 = ((t$50532) - (((double)(t$50540))));
                        
                        //#line 949 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        bly$50549 = t$50541;
                        
                        //#line 948 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        final long t$50542 = j$50544;
                        
                        //#line 948 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        final long t$50543 = ((t$50542) + (((long)(1L))));
                        
                        //#line 948 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        j$50544 = t$50543;
                    }
                }
                
                //#line 951 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final x10.core.Rail t$50550 = ((x10.core.Rail)(x));
                
                //#line 951 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long t$50551 = i$50584;
                
                //#line 951 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final double t$50552 = bly$50549;
                
                //#line 951 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long t$50553 = i$50584;
                
                //#line 951 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final x10.core.Rail t$50554 = ((x10.core.Rail<x10.core.Double>)lu$value$51252[(int)t$50553]);
                
                //#line 951 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long t$50555 = i$50584;
                
                //#line 951 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final double t$50556 = ((double[])t$50554.value)[(int)t$50555];
                
                //#line 951 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final double t$50557 = ((t$50552) / (((double)(t$50556))));
                
                //#line 951 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                ((double[])t$50550.value)[(int)t$50551] = t$50557;
                
                //#line 946 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long t$50558 = i$50584;
                
                //#line 946 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long t$50559 = ((t$50558) + (((long)(1L))));
                
                //#line 946 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                i$50584 = t$50559;
            }
        }
        
        //#line 956 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        long i$50587 = ((n) - (((long)(1L))));
        {
            
            //#line 956 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            final x10.core.Rail[] lu$value$51254 = ((x10.core.Rail[])lu.value);
            
            //#line 956 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            for (;
                 true;
                 ) {
                
                //#line 956 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long t$50588 = i$50587;
                
                //#line 956 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final boolean t$50589 = ((t$50588) >= (((long)(0L))));
                
                //#line 956 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                if (!(t$50589)) {
                    
                    //#line 956 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    break;
                }
                
                //#line 957 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final x10.core.Rail t$50576 = ((x10.core.Rail)(x));
                
                //#line 957 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long t$50577 = i$50587;
                
                //#line 957 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                double yux$50578 = ((double[])t$50576.value)[(int)t$50577];
                
                //#line 958 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long t$50572 = i$50587;
                
                //#line 958 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                long j$50573 = ((t$50572) + (((long)(1L))));
                {
                    
                    //#line 958 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    for (;
                         true;
                         ) {
                        
                        //#line 958 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        final long t$50574 = j$50573;
                        
                        //#line 958 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        final boolean t$50575 = ((t$50574) < (((long)(n))));
                        
                        //#line 958 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        if (!(t$50575)) {
                            
                            //#line 958 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                            break;
                        }
                        
                        //#line 959 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        final double t$50560 = yux$50578;
                        
                        //#line 959 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        final long t$50561 = i$50587;
                        
                        //#line 959 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        final x10.core.Rail t$50562 = ((x10.core.Rail<x10.core.Double>)lu$value$51254[(int)t$50561]);
                        
                        //#line 959 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        final long t$50563 = j$50573;
                        
                        //#line 959 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        final double t$50564 = ((double[])t$50562.value)[(int)t$50563];
                        
                        //#line 959 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        final x10.core.Rail t$50565 = ((x10.core.Rail)(x));
                        
                        //#line 959 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        final long t$50566 = j$50573;
                        
                        //#line 959 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        final double t$50567 = ((double[])t$50565.value)[(int)t$50566];
                        
                        //#line 959 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        final double t$50568 = ((t$50564) * (((double)(t$50567))));
                        
                        //#line 959 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        final double t$50569 = ((t$50560) - (((double)(t$50568))));
                        
                        //#line 959 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        yux$50578 = t$50569;
                        
                        //#line 958 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        final long t$50570 = j$50573;
                        
                        //#line 958 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        final long t$50571 = ((t$50570) + (((long)(1L))));
                        
                        //#line 958 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        j$50573 = t$50571;
                    }
                }
                
                //#line 961 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final x10.core.Rail t$50579 = ((x10.core.Rail)(x));
                
                //#line 961 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long t$50580 = i$50587;
                
                //#line 961 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final double t$50581 = yux$50578;
                
                //#line 961 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                ((double[])t$50579.value)[(int)t$50580] = t$50581;
                
                //#line 956 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long t$50582 = i$50587;
                
                //#line 956 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long t$50583 = ((t$50582) - (((long)(1L))));
                
                //#line 956 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                i$50587 = t$50583;
            }
        }
        
        //#line 964 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        final x10.core.Rail t$48277 = ((x10.core.Rail)(x));
        
        //#line 964 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        return t$48277;
    }
    
    
    //#line 968 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
    public static x10.core.Rail decompose__0$1x10$lang$Rail$1x10$lang$Double$2$2(final x10.core.Rail<x10.core.Rail<x10.core.Double>> m) {
        
        //#line 969 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        final long t$48279 = ((x10.core.Rail<x10.core.Rail<x10.core.Double>>)m).size;
        
        //#line 969 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        final x10.core.Rail t$48278 = ((x10.core.Rail[])m.value)[(int)0L];
        
        //#line 969 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        final long t$48280 = ((x10.core.Rail<x10.core.Double>)t$48278).size;
        
        //#line 969 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        final boolean t$48281 = ((long) t$48279) == ((long) t$48280);
        
        //#line 969 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        if (t$48281) {
            
            //#line 970 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            assert ((double) plham.util.Matrix.determinant__0$1x10$lang$Rail$1x10$lang$Double$2$2$O(((x10.core.Rail)(m)))) != ((double) 0.0): "The determinant is 0.";
        }
        
        //#line 972 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        final long n = ((x10.core.Rail<x10.core.Rail<x10.core.Double>>)m).size;
        
        //#line 973 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        double l = ((double)(long)(((long)(0L))));
        
        //#line 976 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        x10.core.Rail h = new x10.core.Rail<x10.core.Rail<x10.core.Double>>(x10.rtt.ParameterizedType.make(x10.core.Rail.$RTT, x10.rtt.Types.DOUBLE), ((long)(n)));
        
        //#line 977 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        final long i$45953min$50694 = 0L;
        
        //#line 977 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        final long i$45953max$50695 = ((n) - (((long)(1L))));
        
        //#line 977 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        long i$50595 = i$45953min$50694;
        
        //#line 977 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        for (;
             true;
             ) {
            
            //#line 977 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            final long t$50596 = i$50595;
            
            //#line 977 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            final boolean t$50597 = ((t$50596) <= (((long)(i$45953max$50695))));
            
            //#line 977 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            if (!(t$50597)) {
                
                //#line 977 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                break;
            }
            
            //#line 977 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            final long i$50592 = i$50595;
            
            //#line 978 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            final x10.core.Rail t$50590 = ((x10.core.Rail)(h));
            
            //#line 978 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            final x10.core.Rail t$50591 = ((x10.core.Rail)(new x10.core.Rail<x10.core.Double>(x10.rtt.Types.DOUBLE, ((long)(n)))));
            
            //#line 978 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            ((x10.core.Rail[])t$50590.value)[(int)i$50592] = t$50591;
            
            //#line 977 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            final long t$50593 = i$50595;
            
            //#line 977 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            final long t$50594 = ((t$50593) + (((long)(1L))));
            
            //#line 977 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            i$50595 = t$50594;
        }
        
        //#line 980 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        final long i$45989min$50696 = 0L;
        
        //#line 980 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        final long i$45989max$50697 = ((n) - (((long)(1L))));
        
        //#line 980 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        long i$50613 = i$45989min$50696;
        {
            
            //#line 980 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            final x10.core.Rail[] m$value$51255 = ((x10.core.Rail[])m.value);
            
            //#line 980 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            for (;
                 true;
                 ) {
                
                //#line 980 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long t$50614 = i$50613;
                
                //#line 980 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final boolean t$50615 = ((t$50614) <= (((long)(i$45989max$50697))));
                
                //#line 980 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                if (!(t$50615)) {
                    
                    //#line 980 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    break;
                }
                
                //#line 980 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long i$50610 = i$50613;
                
                //#line 981 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long i$45971min$50608 = 0L;
                
                //#line 981 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long i$45971max$50609 = ((n) - (((long)(1L))));
                
                //#line 981 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                long i$50605 = i$45971min$50608;
                {
                    
                    //#line 981 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    for (;
                         true;
                         ) {
                        
                        //#line 981 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        final long t$50606 = i$50605;
                        
                        //#line 981 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        final boolean t$50607 = ((t$50606) <= (((long)(i$45971max$50609))));
                        
                        //#line 981 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        if (!(t$50607)) {
                            
                            //#line 981 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                            break;
                        }
                        
                        //#line 981 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        final long j$50602 = i$50605;
                        
                        //#line 982 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        final x10.core.Rail t$50598 = ((x10.core.Rail)(h));
                        
                        //#line 982 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        final x10.core.Rail t$50599 = ((x10.core.Rail[])t$50598.value)[(int)i$50610];
                        
                        //#line 982 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        final x10.core.Rail t$50600 = ((x10.core.Rail<x10.core.Double>)m$value$51255[(int)i$50610]);
                        
                        //#line 982 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        final double t$50601 = ((double[])t$50600.value)[(int)j$50602];
                        
                        //#line 982 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        ((double[])t$50599.value)[(int)j$50602] = t$50601;
                        
                        //#line 981 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        final long t$50603 = i$50605;
                        
                        //#line 981 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        final long t$50604 = ((t$50603) + (((long)(1L))));
                        
                        //#line 981 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        i$50605 = t$50604;
                    }
                }
                
                //#line 980 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long t$50611 = i$50613;
                
                //#line 980 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long t$50612 = ((t$50611) + (((long)(1L))));
                
                //#line 980 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                i$50613 = t$50612;
            }
        }
        
        //#line 987 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        long i$50698 = 0L;
        
        //#line 987 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        for (;
             true;
             ) {
            
            //#line 987 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            final long t$50699 = i$50698;
            
            //#line 987 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            final boolean t$50700 = ((t$50699) < (((long)(n))));
            
            //#line 987 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            if (!(t$50700)) {
                
                //#line 987 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                break;
            }
            
            //#line 989 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            long j$50684 = 0L;
            
            //#line 989 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            for (;
                 true;
                 ) {
                
                //#line 989 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long t$50685 = j$50684;
                
                //#line 989 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long t$50686 = i$50698;
                
                //#line 989 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final boolean t$50687 = ((t$50685) <= (((long)(t$50686))));
                
                //#line 989 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                if (!(t$50687)) {
                    
                    //#line 989 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    break;
                }
                
                //#line 990 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final x10.core.Rail t$50635 = ((x10.core.Rail)(h));
                
                //#line 990 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long t$50636 = i$50698;
                
                //#line 990 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final x10.core.Rail t$50637 = ((x10.core.Rail[])t$50635.value)[(int)t$50636];
                
                //#line 990 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long t$50638 = j$50684;
                
                //#line 990 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final double t$50639 = ((double[])t$50637.value)[(int)t$50638];
                
                //#line 990 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                l = t$50639;
                
                //#line 991 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                long k$50631 = 0L;
                
                //#line 991 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                for (;
                     true;
                     ) {
                    
                    //#line 991 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final long t$50632 = k$50631;
                    
                    //#line 991 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final long t$50633 = j$50684;
                    
                    //#line 991 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final boolean t$50634 = ((t$50632) < (((long)(t$50633))));
                    
                    //#line 991 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    if (!(t$50634)) {
                        
                        //#line 991 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        break;
                    }
                    
                    //#line 992 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final double t$50616 = l;
                    
                    //#line 992 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final x10.core.Rail t$50617 = ((x10.core.Rail)(h));
                    
                    //#line 992 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final long t$50618 = i$50698;
                    
                    //#line 992 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final x10.core.Rail t$50619 = ((x10.core.Rail[])t$50617.value)[(int)t$50618];
                    
                    //#line 992 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final long t$50620 = k$50631;
                    
                    //#line 992 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final double t$50621 = ((double[])t$50619.value)[(int)t$50620];
                    
                    //#line 992 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final x10.core.Rail t$50622 = ((x10.core.Rail)(h));
                    
                    //#line 992 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final long t$50623 = k$50631;
                    
                    //#line 992 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final x10.core.Rail t$50624 = ((x10.core.Rail[])t$50622.value)[(int)t$50623];
                    
                    //#line 992 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final long t$50625 = j$50684;
                    
                    //#line 992 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final double t$50626 = ((double[])t$50624.value)[(int)t$50625];
                    
                    //#line 992 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final double t$50627 = ((t$50621) * (((double)(t$50626))));
                    
                    //#line 992 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final double t$50628 = ((t$50616) - (((double)(t$50627))));
                    
                    //#line 992 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    l = t$50628;
                    
                    //#line 991 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final long t$50629 = k$50631;
                    
                    //#line 991 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final long t$50630 = ((t$50629) + (((long)(1L))));
                    
                    //#line 991 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    k$50631 = t$50630;
                }
                
                //#line 994 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final x10.core.Rail t$50640 = ((x10.core.Rail)(h));
                
                //#line 994 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long t$50641 = i$50698;
                
                //#line 994 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final x10.core.Rail t$50642 = ((x10.core.Rail[])t$50640.value)[(int)t$50641];
                
                //#line 994 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long t$50643 = j$50684;
                
                //#line 994 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final double t$50644 = l;
                
                //#line 994 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                ((double[])t$50642.value)[(int)t$50643] = t$50644;
                
                //#line 989 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long t$50645 = j$50684;
                
                //#line 989 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long t$50646 = ((t$50645) + (((long)(1L))));
                
                //#line 989 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                j$50684 = t$50646;
            }
            
            //#line 998 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            final long t$50688 = i$50698;
            
            //#line 998 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            long j$50689 = ((t$50688) + (((long)(1L))));
            
            //#line 998 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            for (;
                 true;
                 ) {
                
                //#line 998 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long t$50690 = j$50689;
                
                //#line 998 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final boolean t$50691 = ((t$50690) < (((long)(n))));
                
                //#line 998 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                if (!(t$50691)) {
                    
                    //#line 998 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    break;
                }
                
                //#line 999 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final x10.core.Rail t$50666 = ((x10.core.Rail)(h));
                
                //#line 999 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long t$50667 = i$50698;
                
                //#line 999 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final x10.core.Rail t$50668 = ((x10.core.Rail[])t$50666.value)[(int)t$50667];
                
                //#line 999 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long t$50669 = j$50689;
                
                //#line 999 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final double t$50670 = ((double[])t$50668.value)[(int)t$50669];
                
                //#line 999 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                l = t$50670;
                
                //#line 1000 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                long k$50662 = 0L;
                
                //#line 1000 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                for (;
                     true;
                     ) {
                    
                    //#line 1000 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final long t$50663 = k$50662;
                    
                    //#line 1000 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final long t$50664 = i$50698;
                    
                    //#line 1000 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final boolean t$50665 = ((t$50663) < (((long)(t$50664))));
                    
                    //#line 1000 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    if (!(t$50665)) {
                        
                        //#line 1000 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        break;
                    }
                    
                    //#line 1001 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final double t$50647 = l;
                    
                    //#line 1001 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final x10.core.Rail t$50648 = ((x10.core.Rail)(h));
                    
                    //#line 1001 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final long t$50649 = i$50698;
                    
                    //#line 1001 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final x10.core.Rail t$50650 = ((x10.core.Rail[])t$50648.value)[(int)t$50649];
                    
                    //#line 1001 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final long t$50651 = k$50662;
                    
                    //#line 1001 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final double t$50652 = ((double[])t$50650.value)[(int)t$50651];
                    
                    //#line 1001 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final x10.core.Rail t$50653 = ((x10.core.Rail)(h));
                    
                    //#line 1001 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final long t$50654 = k$50662;
                    
                    //#line 1001 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final x10.core.Rail t$50655 = ((x10.core.Rail[])t$50653.value)[(int)t$50654];
                    
                    //#line 1001 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final long t$50656 = j$50689;
                    
                    //#line 1001 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final double t$50657 = ((double[])t$50655.value)[(int)t$50656];
                    
                    //#line 1001 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final double t$50658 = ((t$50652) * (((double)(t$50657))));
                    
                    //#line 1001 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final double t$50659 = ((t$50647) - (((double)(t$50658))));
                    
                    //#line 1001 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    l = t$50659;
                    
                    //#line 1000 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final long t$50660 = k$50662;
                    
                    //#line 1000 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final long t$50661 = ((t$50660) + (((long)(1L))));
                    
                    //#line 1000 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    k$50662 = t$50661;
                }
                
                //#line 1003 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final x10.core.Rail t$50671 = ((x10.core.Rail)(h));
                
                //#line 1003 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long t$50672 = i$50698;
                
                //#line 1003 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final x10.core.Rail t$50673 = ((x10.core.Rail[])t$50671.value)[(int)t$50672];
                
                //#line 1003 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long t$50674 = j$50689;
                
                //#line 1003 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final double t$50675 = l;
                
                //#line 1003 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final x10.core.Rail t$50676 = ((x10.core.Rail)(h));
                
                //#line 1003 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long t$50677 = i$50698;
                
                //#line 1003 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final x10.core.Rail t$50678 = ((x10.core.Rail[])t$50676.value)[(int)t$50677];
                
                //#line 1003 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long t$50679 = i$50698;
                
                //#line 1003 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final double t$50680 = ((double[])t$50678.value)[(int)t$50679];
                
                //#line 1003 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final double t$50681 = ((t$50675) / (((double)(t$50680))));
                
                //#line 1003 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                ((double[])t$50673.value)[(int)t$50674] = t$50681;
                
                //#line 998 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long t$50682 = j$50689;
                
                //#line 998 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long t$50683 = ((t$50682) + (((long)(1L))));
                
                //#line 998 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                j$50689 = t$50683;
            }
            
            //#line 987 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            final long t$50692 = i$50698;
            
            //#line 987 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            final long t$50693 = ((t$50692) + (((long)(1L))));
            
            //#line 987 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            i$50698 = t$50693;
        }
        
        //#line 1006 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        final x10.core.Rail t$48384 = ((x10.core.Rail)(h));
        
        //#line 1006 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        return t$48384;
    }
    
    
    //#line 1010 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
    public static void pivoting__0$1x10$lang$Rail$1x10$lang$Double$2$2(final x10.core.Rail<x10.core.Rail<x10.core.Double>> m, final long n, final long k) {
        
        //#line 1012 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        long p = k;
        
        //#line 1013 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        final x10.core.Rail t$48385 = ((x10.core.Rail[])m.value)[(int)k];
        
        //#line 1013 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        final double t$48386 = ((double[])t$48385.value)[(int)k];
        
        //#line 1013 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        double am = java.lang.Math.abs(((double)(t$48386)));
        
        //#line 1016 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        long i$50729 = ((k) + (((long)(1L))));
        {
            
            //#line 1016 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            final x10.core.Rail[] m$value$51256 = ((x10.core.Rail[])m.value);
            
            //#line 1016 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            for (;
                 true;
                 ) {
                
                //#line 1016 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long t$50730 = i$50729;
                
                //#line 1016 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final boolean t$50731 = ((t$50730) < (((long)(n))));
                
                //#line 1016 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                if (!(t$50731)) {
                    
                    //#line 1016 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    break;
                }
                
                //#line 1017 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long t$50701 = i$50729;
                
                //#line 1017 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final x10.core.Rail t$50702 = ((x10.core.Rail<x10.core.Double>)m$value$51256[(int)t$50701]);
                
                //#line 1017 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final double t$50703 = ((double[])t$50702.value)[(int)k];
                
                //#line 1017 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final double t$50704 = java.lang.Math.abs(((double)(t$50703)));
                
                //#line 1017 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final double t$50705 = am;
                
                //#line 1017 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final boolean t$50706 = ((t$50704) > (((double)(t$50705))));
                
                //#line 1017 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                if (t$50706) {
                    
                    //#line 1018 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final long t$50707 = i$50729;
                    
                    //#line 1018 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    p = t$50707;
                    
                    //#line 1019 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final long t$50708 = i$50729;
                    
                    //#line 1019 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final x10.core.Rail t$50709 = ((x10.core.Rail<x10.core.Double>)m$value$51256[(int)t$50708]);
                    
                    //#line 1019 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final double t$50710 = ((double[])t$50709.value)[(int)k];
                    
                    //#line 1019 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final double t$50711 = java.lang.Math.abs(((double)(t$50710)));
                    
                    //#line 1019 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    am = t$50711;
                }
                
                //#line 1016 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long t$50712 = i$50729;
                
                //#line 1016 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long t$50713 = ((t$50712) + (((long)(1L))));
                
                //#line 1016 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                i$50729 = t$50713;
            }
        }
        
        //#line 1024 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        final long t$48403 = p;
        
        //#line 1024 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        final boolean t$48421 = ((long) k) != ((long) t$48403);
        
        //#line 1024 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        if (t$48421) {
            
            //#line 1025 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            long i = 0L;
            {
                
                //#line 1025 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final x10.core.Rail[] m$value$51257 = ((x10.core.Rail[])m.value);
                
                //#line 1025 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                for (;
                     true;
                     ) {
                    
                    //#line 1025 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final long t$48405 = i;
                    
                    //#line 1025 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final boolean t$48420 = ((t$48405) < (((long)(n))));
                    
                    //#line 1025 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    if (!(t$48420)) {
                        
                        //#line 1025 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        break;
                    }
                    
                    //#line 1026 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final x10.core.Rail t$50714 = ((x10.core.Rail<x10.core.Double>)m$value$51257[(int)k]);
                    
                    //#line 1026 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final long t$50715 = i;
                    
                    //#line 1026 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    double tmp$50716 = ((double[])t$50714.value)[(int)t$50715];
                    
                    //#line 1027 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final x10.core.Rail t$50717 = ((x10.core.Rail<x10.core.Double>)m$value$51257[(int)k]);
                    
                    //#line 1027 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final long t$50718 = i;
                    
                    //#line 1027 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final long t$50719 = p;
                    
                    //#line 1027 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final x10.core.Rail t$50720 = ((x10.core.Rail<x10.core.Double>)m$value$51257[(int)t$50719]);
                    
                    //#line 1027 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final long t$50721 = i;
                    
                    //#line 1027 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final double t$50722 = ((double[])t$50720.value)[(int)t$50721];
                    
                    //#line 1027 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    ((double[])t$50717.value)[(int)t$50718] = t$50722;
                    
                    //#line 1028 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final long t$50723 = p;
                    
                    //#line 1028 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final x10.core.Rail t$50724 = ((x10.core.Rail<x10.core.Double>)m$value$51257[(int)t$50723]);
                    
                    //#line 1028 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final long t$50725 = i;
                    
                    //#line 1028 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final double t$50726 = tmp$50716;
                    
                    //#line 1028 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    ((double[])t$50724.value)[(int)t$50725] = t$50726;
                    
                    //#line 1025 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final long t$50727 = i;
                    
                    //#line 1025 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final long t$50728 = ((t$50727) + (((long)(1L))));
                    
                    //#line 1025 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    i = t$50728;
                }
            }
        }
    }
    
    
    //#line 1036 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
    public static long rank__0$1x10$lang$Rail$1x10$lang$Double$2$2$O(final x10.core.Rail<x10.core.Rail<x10.core.Double>> m) {
        
        //#line 1037 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        final long n = ((x10.core.Rail<x10.core.Rail<x10.core.Double>>)m).size;
        
        //#line 1038 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        long out = n;
        
        //#line 1039 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        final long i$46025min$50771 = 0L;
        
        //#line 1039 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        final long i$46025max$50772 = ((n) - (((long)(1L))));
        
        //#line 1039 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        long i$50768 = i$46025min$50771;
        {
            
            //#line 1039 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            final x10.core.Rail[] m$value$51258 = ((x10.core.Rail[])m.value);
            
            //#line 1039 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            for (;
                 true;
                 ) {
                
                //#line 1039 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long t$50769 = i$50768;
                
                //#line 1039 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final boolean t$50770 = ((t$50769) <= (((long)(i$46025max$50772))));
                
                //#line 1039 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                if (!(t$50770)) {
                    
                    //#line 1039 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    break;
                }
                
                //#line 1039 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long i$50765 = i$50768;
                
                //#line 1040 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                long count$50758 = 0L;
                
                //#line 1041 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long i$46007min$50754 = 0L;
                
                //#line 1041 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final x10.core.Rail t$50755 = ((x10.core.Rail<x10.core.Double>)m$value$51258[(int)0L]);
                
                //#line 1041 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long t$50756 = ((x10.core.Rail<x10.core.Double>)t$50755).size;
                
                //#line 1041 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long i$46007max$50757 = ((t$50756) - (((long)(1L))));
                
                //#line 1041 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                long i$50751 = i$46007min$50754;
                {
                    
                    //#line 1041 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    for (;
                         true;
                         ) {
                        
                        //#line 1041 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        final long t$50752 = i$50751;
                        
                        //#line 1041 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        final boolean t$50753 = ((t$50752) <= (((long)(i$46007max$50757))));
                        
                        //#line 1041 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        if (!(t$50753)) {
                            
                            //#line 1041 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                            break;
                        }
                        
                        //#line 1041 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        final long j$50748 = i$50751;
                        
                        //#line 1042 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        final x10.core.Rail t$50732 = ((x10.core.Rail<x10.core.Double>)m$value$51258[(int)i$50765]);
                        
                        //#line 1042 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        final double t$50733 = ((double[])t$50732.value)[(int)j$50748];
                        
                        //#line 1042 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        final double t$50734 = java.lang.Math.abs(((double)(t$50733)));
                        
                        //#line 1042 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        final double t$50735 = plham.util.Matrix.epsilon;
                        
                        //#line 1042 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        boolean t$50736 = ((t$50734) <= (((double)(t$50735))));
                        
                        //#line 1042 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        if (!(t$50736)) {
                            
                            //#line 1042 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                            final x10.core.Rail t$50737 = ((x10.core.Rail<x10.core.Double>)m$value$51258[(int)i$50765]);
                            
                            //#line 1042 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                            final double t$50738 = ((double[])t$50737.value)[(int)j$50748];
                            
                            //#line 1042 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                            final double t$50739 = java.lang.Math.abs(((double)(t$50738)));
                            
                            //#line 1042 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                            final double t$50740 = plham.util.Matrix.epsilon2;
                            
                            //#line 1042 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                            final x10.core.Rail t$50741 = ((x10.core.Rail<x10.core.Double>)m$value$51258[(int)i$50765]);
                            
                            //#line 1042 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                            final double t$50742 = ((double[])t$50741.value)[(int)j$50748];
                            
                            //#line 1042 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                            final double t$50743 = java.lang.Math.abs(((double)(t$50742)));
                            
                            //#line 1042 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                            final double t$50744 = ((t$50740) * (((double)(t$50743))));
                            
                            //#line 1042 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                            t$50736 = ((t$50739) <= (((double)(t$50744))));
                        }
                        
                        //#line 1042 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        final boolean t$50745 = t$50736;
                        
                        //#line 1042 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        if (t$50745) {
                            
                            //#line 1042 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                            final long t$50746 = count$50758;
                            
                            //#line 1042 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                            final long t$50747 = ((t$50746) + (((long)(1L))));
                            
                            //#line 1042 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                            count$50758 = t$50747;
                        }
                        
                        //#line 1041 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        final long t$50749 = i$50751;
                        
                        //#line 1041 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        final long t$50750 = ((t$50749) + (((long)(1L))));
                        
                        //#line 1041 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        i$50751 = t$50750;
                    }
                }
                
                //#line 1044 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long t$50759 = count$50758;
                
                //#line 1044 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final x10.core.Rail t$50760 = ((x10.core.Rail<x10.core.Double>)m$value$51258[(int)0L]);
                
                //#line 1044 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long t$50761 = ((x10.core.Rail<x10.core.Double>)t$50760).size;
                
                //#line 1044 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final boolean t$50762 = ((long) t$50759) == ((long) t$50761);
                
                //#line 1044 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                if (t$50762) {
                    
                    //#line 1044 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final long t$50763 = out;
                    
                    //#line 1044 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final long t$50764 = ((t$50763) - (((long)(1L))));
                    
                    //#line 1044 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    out = t$50764;
                }
                
                //#line 1039 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long t$50766 = i$50768;
                
                //#line 1039 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long t$50767 = ((t$50766) + (((long)(1L))));
                
                //#line 1039 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                i$50768 = t$50767;
            }
        }
        
        //#line 1046 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        final long t$48456 = out;
        
        //#line 1046 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        return t$48456;
    }
    
    
    //#line 1050 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
    public static x10.core.Rail devideExpansionCoefficientMatrix1__0$1x10$lang$Rail$1x10$lang$Double$2$2(final x10.core.Rail<x10.core.Rail<x10.core.Double>> a) {
        
        //#line 1051 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        final long t$48457 = ((x10.core.Rail<x10.core.Rail<x10.core.Double>>)a).size;
        
        //#line 1051 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        x10.core.Rail C = new x10.core.Rail<x10.core.Rail<x10.core.Double>>(x10.rtt.ParameterizedType.make(x10.core.Rail.$RTT, x10.rtt.Types.DOUBLE), ((long)(t$48457)));
        
        //#line 1052 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        final long t$48458 = ((x10.core.Rail<x10.core.Rail<x10.core.Double>>)a).size;
        
        //#line 1052 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        x10.core.Rail D = new x10.core.Rail<x10.core.Double>(x10.rtt.Types.DOUBLE, ((long)(t$48458)));
        
        //#line 1053 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        final long i$46043min$50810 = 0L;
        
        //#line 1053 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        final long t$50811 = ((x10.core.Rail<x10.core.Rail<x10.core.Double>>)a).size;
        
        //#line 1053 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        final long i$46043max$50812 = ((t$50811) - (((long)(1L))));
        
        //#line 1053 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        long i$50781 = i$46043min$50810;
        {
            
            //#line 1053 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            final x10.core.Rail[] a$value$51259 = ((x10.core.Rail[])a.value);
            
            //#line 1053 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            for (;
                 true;
                 ) {
                
                //#line 1053 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long t$50782 = i$50781;
                
                //#line 1053 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final boolean t$50783 = ((t$50782) <= (((long)(i$46043max$50812))));
                
                //#line 1053 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                if (!(t$50783)) {
                    
                    //#line 1053 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    break;
                }
                
                //#line 1053 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long i$50778 = i$50781;
                
                //#line 1054 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final x10.core.Rail t$50773 = ((x10.core.Rail)(C));
                
                //#line 1054 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final x10.core.Rail t$50774 = ((x10.core.Rail<x10.core.Double>)a$value$51259[(int)0L]);
                
                //#line 1054 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long t$50775 = ((x10.core.Rail<x10.core.Double>)t$50774).size;
                
                //#line 1054 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long t$50776 = ((t$50775) - (((long)(1L))));
                
                //#line 1054 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final x10.core.Rail t$50777 = ((x10.core.Rail)(new x10.core.Rail<x10.core.Double>(x10.rtt.Types.DOUBLE, t$50776)));
                
                //#line 1054 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                ((x10.core.Rail[])t$50773.value)[(int)i$50778] = t$50777;
                
                //#line 1053 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long t$50779 = i$50781;
                
                //#line 1053 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long t$50780 = ((t$50779) + (((long)(1L))));
                
                //#line 1053 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                i$50781 = t$50780;
            }
        }
        
        //#line 1057 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        final long i$46079min$50813 = 0L;
        
        //#line 1057 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        final long t$50814 = ((x10.core.Rail<x10.core.Rail<x10.core.Double>>)a).size;
        
        //#line 1057 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        final long i$46079max$50815 = ((t$50814) - (((long)(1L))));
        
        //#line 1057 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        long i$50807 = i$46079min$50813;
        {
            
            //#line 1057 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            final x10.core.Rail[] a$value$51260 = ((x10.core.Rail[])a.value);
            
            //#line 1057 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            for (;
                 true;
                 ) {
                
                //#line 1057 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long t$50808 = i$50807;
                
                //#line 1057 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final boolean t$50809 = ((t$50808) <= (((long)(i$46079max$50815))));
                
                //#line 1057 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                if (!(t$50809)) {
                    
                    //#line 1057 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    break;
                }
                
                //#line 1057 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long i$50804 = i$50807;
                
                //#line 1058 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long i$46061min$50794 = 0L;
                
                //#line 1058 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final x10.core.Rail t$50795 = ((x10.core.Rail<x10.core.Double>)a$value$51260[(int)0L]);
                
                //#line 1058 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long t$50796 = ((x10.core.Rail<x10.core.Double>)t$50795).size;
                
                //#line 1058 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long i$46061max$50797 = ((t$50796) - (((long)(2L))));
                
                //#line 1058 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                long i$50791 = i$46061min$50794;
                {
                    
                    //#line 1058 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    for (;
                         true;
                         ) {
                        
                        //#line 1058 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        final long t$50792 = i$50791;
                        
                        //#line 1058 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        final boolean t$50793 = ((t$50792) <= (((long)(i$46061max$50797))));
                        
                        //#line 1058 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        if (!(t$50793)) {
                            
                            //#line 1058 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                            break;
                        }
                        
                        //#line 1058 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        final long j$50788 = i$50791;
                        
                        //#line 1059 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        final x10.core.Rail t$50784 = ((x10.core.Rail)(C));
                        
                        //#line 1059 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        final x10.core.Rail t$50785 = ((x10.core.Rail[])t$50784.value)[(int)i$50804];
                        
                        //#line 1059 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        final x10.core.Rail t$50786 = ((x10.core.Rail<x10.core.Double>)a$value$51260[(int)i$50804]);
                        
                        //#line 1059 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        final double t$50787 = ((double[])t$50786.value)[(int)j$50788];
                        
                        //#line 1059 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        ((double[])t$50785.value)[(int)j$50788] = t$50787;
                        
                        //#line 1058 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        final long t$50789 = i$50791;
                        
                        //#line 1058 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        final long t$50790 = ((t$50789) + (((long)(1L))));
                        
                        //#line 1058 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        i$50791 = t$50790;
                    }
                }
                
                //#line 1061 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final x10.core.Rail t$50798 = ((x10.core.Rail)(D));
                
                //#line 1061 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final x10.core.Rail t$50799 = ((x10.core.Rail<x10.core.Double>)a$value$51260[(int)i$50804]);
                
                //#line 1061 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final x10.core.Rail t$50800 = ((x10.core.Rail<x10.core.Double>)a$value$51260[(int)0L]);
                
                //#line 1061 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long t$50801 = ((x10.core.Rail<x10.core.Double>)t$50800).size;
                
                //#line 1061 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long t$50802 = ((t$50801) - (((long)(1L))));
                
                //#line 1061 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final double t$50803 = ((double[])t$50799.value)[(int)t$50802];
                
                //#line 1061 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                ((double[])t$50798.value)[(int)i$50804] = t$50803;
                
                //#line 1057 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long t$50805 = i$50807;
                
                //#line 1057 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long t$50806 = ((t$50805) + (((long)(1L))));
                
                //#line 1057 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                i$50807 = t$50806;
            }
        }
        
        //#line 1063 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        final x10.core.Rail t$48493 = ((x10.core.Rail)(C));
        
        //#line 1063 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        return t$48493;
    }
    
    
    //#line 1066 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
    public static x10.core.Rail devideExpansionCoefficientMatrix2__0$1x10$lang$Rail$1x10$lang$Double$2$2(final x10.core.Rail<x10.core.Rail<x10.core.Double>> a) {
        
        //#line 1067 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        final long t$48494 = ((x10.core.Rail<x10.core.Rail<x10.core.Double>>)a).size;
        
        //#line 1067 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        x10.core.Rail C = new x10.core.Rail<x10.core.Rail<x10.core.Double>>(x10.rtt.ParameterizedType.make(x10.core.Rail.$RTT, x10.rtt.Types.DOUBLE), ((long)(t$48494)));
        
        //#line 1068 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        final long t$48495 = ((x10.core.Rail<x10.core.Rail<x10.core.Double>>)a).size;
        
        //#line 1068 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        x10.core.Rail D = new x10.core.Rail<x10.core.Double>(x10.rtt.Types.DOUBLE, ((long)(t$48495)));
        
        //#line 1069 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        final long i$46097min$50853 = 0L;
        
        //#line 1069 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        final long t$50854 = ((x10.core.Rail<x10.core.Rail<x10.core.Double>>)a).size;
        
        //#line 1069 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        final long i$46097max$50855 = ((t$50854) - (((long)(1L))));
        
        //#line 1069 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        long i$50824 = i$46097min$50853;
        {
            
            //#line 1069 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            final x10.core.Rail[] a$value$51261 = ((x10.core.Rail[])a.value);
            
            //#line 1069 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            for (;
                 true;
                 ) {
                
                //#line 1069 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long t$50825 = i$50824;
                
                //#line 1069 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final boolean t$50826 = ((t$50825) <= (((long)(i$46097max$50855))));
                
                //#line 1069 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                if (!(t$50826)) {
                    
                    //#line 1069 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    break;
                }
                
                //#line 1069 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long i$50821 = i$50824;
                
                //#line 1070 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final x10.core.Rail t$50816 = ((x10.core.Rail)(C));
                
                //#line 1070 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final x10.core.Rail t$50817 = ((x10.core.Rail<x10.core.Double>)a$value$51261[(int)0L]);
                
                //#line 1070 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long t$50818 = ((x10.core.Rail<x10.core.Double>)t$50817).size;
                
                //#line 1070 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long t$50819 = ((t$50818) - (((long)(1L))));
                
                //#line 1070 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final x10.core.Rail t$50820 = ((x10.core.Rail)(new x10.core.Rail<x10.core.Double>(x10.rtt.Types.DOUBLE, t$50819)));
                
                //#line 1070 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                ((x10.core.Rail[])t$50816.value)[(int)i$50821] = t$50820;
                
                //#line 1069 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long t$50822 = i$50824;
                
                //#line 1069 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long t$50823 = ((t$50822) + (((long)(1L))));
                
                //#line 1069 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                i$50824 = t$50823;
            }
        }
        
        //#line 1073 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        final long i$46133min$50856 = 0L;
        
        //#line 1073 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        final long t$50857 = ((x10.core.Rail<x10.core.Rail<x10.core.Double>>)a).size;
        
        //#line 1073 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        final long i$46133max$50858 = ((t$50857) - (((long)(1L))));
        
        //#line 1073 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        long i$50850 = i$46133min$50856;
        {
            
            //#line 1073 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            final x10.core.Rail[] a$value$51262 = ((x10.core.Rail[])a.value);
            
            //#line 1073 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            for (;
                 true;
                 ) {
                
                //#line 1073 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long t$50851 = i$50850;
                
                //#line 1073 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final boolean t$50852 = ((t$50851) <= (((long)(i$46133max$50858))));
                
                //#line 1073 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                if (!(t$50852)) {
                    
                    //#line 1073 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    break;
                }
                
                //#line 1073 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long i$50847 = i$50850;
                
                //#line 1074 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long i$46115min$50837 = 0L;
                
                //#line 1074 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final x10.core.Rail t$50838 = ((x10.core.Rail<x10.core.Double>)a$value$51262[(int)0L]);
                
                //#line 1074 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long t$50839 = ((x10.core.Rail<x10.core.Double>)t$50838).size;
                
                //#line 1074 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long i$46115max$50840 = ((t$50839) - (((long)(2L))));
                
                //#line 1074 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                long i$50834 = i$46115min$50837;
                {
                    
                    //#line 1074 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    for (;
                         true;
                         ) {
                        
                        //#line 1074 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        final long t$50835 = i$50834;
                        
                        //#line 1074 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        final boolean t$50836 = ((t$50835) <= (((long)(i$46115max$50840))));
                        
                        //#line 1074 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        if (!(t$50836)) {
                            
                            //#line 1074 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                            break;
                        }
                        
                        //#line 1074 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        final long j$50831 = i$50834;
                        
                        //#line 1075 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        final x10.core.Rail t$50827 = ((x10.core.Rail)(C));
                        
                        //#line 1075 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        final x10.core.Rail t$50828 = ((x10.core.Rail[])t$50827.value)[(int)i$50847];
                        
                        //#line 1075 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        final x10.core.Rail t$50829 = ((x10.core.Rail<x10.core.Double>)a$value$51262[(int)i$50847]);
                        
                        //#line 1075 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        final double t$50830 = ((double[])t$50829.value)[(int)j$50831];
                        
                        //#line 1075 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        ((double[])t$50828.value)[(int)j$50831] = t$50830;
                        
                        //#line 1074 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        final long t$50832 = i$50834;
                        
                        //#line 1074 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        final long t$50833 = ((t$50832) + (((long)(1L))));
                        
                        //#line 1074 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        i$50834 = t$50833;
                    }
                }
                
                //#line 1077 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final x10.core.Rail t$50841 = ((x10.core.Rail)(D));
                
                //#line 1077 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final x10.core.Rail t$50842 = ((x10.core.Rail<x10.core.Double>)a$value$51262[(int)i$50847]);
                
                //#line 1077 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final x10.core.Rail t$50843 = ((x10.core.Rail<x10.core.Double>)a$value$51262[(int)0L]);
                
                //#line 1077 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long t$50844 = ((x10.core.Rail<x10.core.Double>)t$50843).size;
                
                //#line 1077 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long t$50845 = ((t$50844) - (((long)(1L))));
                
                //#line 1077 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final double t$50846 = ((double[])t$50842.value)[(int)t$50845];
                
                //#line 1077 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                ((double[])t$50841.value)[(int)i$50847] = t$50846;
                
                //#line 1073 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long t$50848 = i$50850;
                
                //#line 1073 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long t$50849 = ((t$50848) + (((long)(1L))));
                
                //#line 1073 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                i$50850 = t$50849;
            }
        }
        
        //#line 1079 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        final x10.core.Rail t$48530 = ((x10.core.Rail)(D));
        
        //#line 1079 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        return t$48530;
    }
    
    
    //#line 1083 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
    public static x10.core.Rail ExpansionCoefficientMatrix__0$1x10$lang$Rail$1x10$lang$Double$2$2__1$1x10$lang$Double$2(final x10.core.Rail<x10.core.Rail<x10.core.Double>> a, final x10.core.Rail<x10.core.Double> b) {
        
        //#line 1084 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        assert ((long) ((x10.core.Rail<x10.core.Rail<x10.core.Double>>)a).size) == ((long) ((x10.core.Rail<x10.core.Double>)b).size): "errorEchelon1";
        
        //#line 1089 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        final long n = ((x10.core.Rail<x10.core.Rail<x10.core.Double>>)a).size;
        
        //#line 1090 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        final x10.core.Rail t$48531 = ((x10.core.Rail[])a.value)[(int)0L];
        
        //#line 1090 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        final long nn = ((x10.core.Rail<x10.core.Double>)t$48531).size;
        
        //#line 1091 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        x10.core.Rail m = new x10.core.Rail<x10.core.Rail<x10.core.Double>>(x10.rtt.ParameterizedType.make(x10.core.Rail.$RTT, x10.rtt.Types.DOUBLE), ((long)(n)));
        
        //#line 1094 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        final long i$46151min$50889 = 0L;
        
        //#line 1094 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        final long i$46151max$50890 = ((n) - (((long)(1L))));
        
        //#line 1094 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        long i$50865 = i$46151min$50889;
        
        //#line 1094 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        for (;
             true;
             ) {
            
            //#line 1094 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            final long t$50866 = i$50865;
            
            //#line 1094 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            final boolean t$50867 = ((t$50866) <= (((long)(i$46151max$50890))));
            
            //#line 1094 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            if (!(t$50867)) {
                
                //#line 1094 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                break;
            }
            
            //#line 1094 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            final long i$50862 = i$50865;
            
            //#line 1095 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            final x10.core.Rail t$50859 = ((x10.core.Rail)(m));
            
            //#line 1095 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            final long t$50860 = ((nn) + (((long)(1L))));
            
            //#line 1095 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            final x10.core.Rail t$50861 = ((x10.core.Rail)(new x10.core.Rail<x10.core.Double>(x10.rtt.Types.DOUBLE, t$50860)));
            
            //#line 1095 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            ((x10.core.Rail[])t$50859.value)[(int)i$50862] = t$50861;
            
            //#line 1094 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            final long t$50863 = i$50865;
            
            //#line 1094 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            final long t$50864 = ((t$50863) + (((long)(1L))));
            
            //#line 1094 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            i$50865 = t$50864;
        }
        
        //#line 1097 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        final long i$46187min$50891 = 0L;
        
        //#line 1097 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        final long i$46187max$50892 = ((n) - (((long)(1L))));
        
        //#line 1097 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        long i$50886 = i$46187min$50891;
        {
            
            //#line 1097 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            final x10.core.Rail[] a$value$51263 = ((x10.core.Rail[])a.value);
            
            //#line 1097 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            final double[] b$value$51264 = ((double[])b.value);
            
            //#line 1097 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            for (;
                 true;
                 ) {
                
                //#line 1097 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long t$50887 = i$50886;
                
                //#line 1097 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final boolean t$50888 = ((t$50887) <= (((long)(i$46187max$50892))));
                
                //#line 1097 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                if (!(t$50888)) {
                    
                    //#line 1097 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    break;
                }
                
                //#line 1097 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long i$50883 = i$50886;
                
                //#line 1098 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long i$46169min$50878 = 0L;
                
                //#line 1098 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long i$46169max$50879 = ((nn) - (((long)(1L))));
                
                //#line 1098 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                long i$50875 = i$46169min$50878;
                {
                    
                    //#line 1098 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    for (;
                         true;
                         ) {
                        
                        //#line 1098 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        final long t$50876 = i$50875;
                        
                        //#line 1098 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        final boolean t$50877 = ((t$50876) <= (((long)(i$46169max$50879))));
                        
                        //#line 1098 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        if (!(t$50877)) {
                            
                            //#line 1098 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                            break;
                        }
                        
                        //#line 1098 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        final long j$50872 = i$50875;
                        
                        //#line 1099 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        final x10.core.Rail t$50868 = ((x10.core.Rail)(m));
                        
                        //#line 1099 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        final x10.core.Rail t$50869 = ((x10.core.Rail[])t$50868.value)[(int)i$50883];
                        
                        //#line 1099 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        final x10.core.Rail t$50870 = ((x10.core.Rail<x10.core.Double>)a$value$51263[(int)i$50883]);
                        
                        //#line 1099 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        final double t$50871 = ((double[])t$50870.value)[(int)j$50872];
                        
                        //#line 1099 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        ((double[])t$50869.value)[(int)j$50872] = t$50871;
                        
                        //#line 1098 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        final long t$50873 = i$50875;
                        
                        //#line 1098 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        final long t$50874 = ((t$50873) + (((long)(1L))));
                        
                        //#line 1098 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        i$50875 = t$50874;
                    }
                }
                
                //#line 1101 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final x10.core.Rail t$50880 = ((x10.core.Rail)(m));
                
                //#line 1101 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final x10.core.Rail t$50881 = ((x10.core.Rail[])t$50880.value)[(int)i$50883];
                
                //#line 1101 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final double t$50882 = ((double)b$value$51264[(int)i$50883]);
                
                //#line 1101 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                ((double[])t$50881.value)[(int)nn] = t$50882;
                
                //#line 1097 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long t$50884 = i$50886;
                
                //#line 1097 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long t$50885 = ((t$50884) + (((long)(1L))));
                
                //#line 1097 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                i$50886 = t$50885;
            }
        }
        
        //#line 1107 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        final x10.core.Rail t$48557 = ((x10.core.Rail)(m));
        
        //#line 1107 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        return t$48557;
    }
    
    
    //#line 1111 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
    public static x10.core.Rail echelonForm2__0$1x10$lang$Rail$1x10$lang$Double$2$2(final x10.core.Rail<x10.core.Rail<x10.core.Double>> a) {
        
        //#line 1112 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        x10.core.Rail m = plham.util.Matrix.echelonForm__0$1x10$lang$Rail$1x10$lang$Double$2$2(((x10.core.Rail)(a)));
        
        //#line 1113 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        final x10.core.Rail t$48558 = ((x10.core.Rail)(m));
        
        //#line 1113 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        long rank = plham.util.Matrix.rank__0$1x10$lang$Rail$1x10$lang$Double$2$2$O(((x10.core.Rail)(t$48558)));
        
        //#line 1114 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        final long n = ((x10.core.Rail<x10.core.Rail<x10.core.Double>>)a).size;
        
        //#line 1116 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        final long t$48559 = rank;
        
        //#line 1116 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        x10.core.Rail out = new x10.core.Rail<x10.core.Rail<x10.core.Double>>(x10.rtt.ParameterizedType.make(x10.core.Rail.$RTT, x10.rtt.Types.DOUBLE), t$48559);
        
        //#line 1117 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        final long i$46205min$50905 = 0L;
        
        //#line 1117 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        final long t$50906 = rank;
        
        //#line 1117 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        final long i$46205max$50907 = ((t$50906) - (((long)(1L))));
        
        //#line 1117 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        long i$50902 = i$46205min$50905;
        
        //#line 1117 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        for (;
             true;
             ) {
            
            //#line 1117 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            final long t$50903 = i$50902;
            
            //#line 1117 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            final boolean t$50904 = ((t$50903) <= (((long)(i$46205max$50907))));
            
            //#line 1117 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            if (!(t$50904)) {
                
                //#line 1117 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                break;
            }
            
            //#line 1117 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            final long i$50899 = i$50902;
            
            //#line 1118 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            final x10.core.Rail t$50893 = ((x10.core.Rail)(out));
            
            //#line 1118 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            final long t$50894 = ((n) + (((long)(1L))));
            
            //#line 1118 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            final x10.core.Rail t$50895 = ((x10.core.Rail)(new x10.core.Rail<x10.core.Double>(x10.rtt.Types.DOUBLE, t$50894)));
            
            //#line 1118 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            ((x10.core.Rail[])t$50893.value)[(int)i$50899] = t$50895;
            
            //#line 1119 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            final x10.core.Rail t$50896 = ((x10.core.Rail)(out));
            
            //#line 1119 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            final x10.core.Rail t$50897 = ((x10.core.Rail)(m));
            
            //#line 1119 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            final x10.core.Rail t$50898 = ((x10.core.Rail[])t$50897.value)[(int)i$50899];
            
            //#line 1119 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            ((x10.core.Rail[])t$50896.value)[(int)i$50899] = t$50898;
            
            //#line 1117 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            final long t$50900 = i$50902;
            
            //#line 1117 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            final long t$50901 = ((t$50900) + (((long)(1L))));
            
            //#line 1117 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            i$50902 = t$50901;
        }
        
        //#line 1121 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        final x10.core.Rail t$48572 = ((x10.core.Rail)(out));
        
        //#line 1121 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        return t$48572;
    }
    
    
    //#line 1125 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
    public static x10.core.Rail echelonForm__0$1x10$lang$Rail$1x10$lang$Double$2$2(final x10.core.Rail<x10.core.Rail<x10.core.Double>> a) {
        
        //#line 1128 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        final long n = ((x10.core.Rail<x10.core.Rail<x10.core.Double>>)a).size;
        
        //#line 1129 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        x10.core.Rail m = new x10.core.Rail<x10.core.Rail<x10.core.Double>>(x10.rtt.ParameterizedType.make(x10.core.Rail.$RTT, x10.rtt.Types.DOUBLE), ((long)(n)));
        
        //#line 1132 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        final long i$46241min$50999 = 0L;
        
        //#line 1132 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        final long i$46241max$51000 = ((n) - (((long)(1L))));
        
        //#line 1132 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        long i$50929 = i$46241min$50999;
        {
            
            //#line 1132 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            final x10.core.Rail[] a$value$51265 = ((x10.core.Rail[])a.value);
            
            //#line 1132 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            for (;
                 true;
                 ) {
                
                //#line 1132 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long t$50930 = i$50929;
                
                //#line 1132 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final boolean t$50931 = ((t$50930) <= (((long)(i$46241max$51000))));
                
                //#line 1132 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                if (!(t$50931)) {
                    
                    //#line 1132 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    break;
                }
                
                //#line 1132 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long i$50926 = i$50929;
                
                //#line 1133 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final x10.core.Rail t$50922 = ((x10.core.Rail)(m));
                
                //#line 1133 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final x10.core.Rail t$50923 = ((x10.core.Rail<x10.core.Double>)a$value$51265[(int)0L]);
                
                //#line 1133 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long t$50924 = ((x10.core.Rail<x10.core.Double>)t$50923).size;
                
                //#line 1133 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final x10.core.Rail t$50925 = ((x10.core.Rail)(new x10.core.Rail<x10.core.Double>(x10.rtt.Types.DOUBLE, t$50924)));
                
                //#line 1133 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                ((x10.core.Rail[])t$50922.value)[(int)i$50926] = t$50925;
                
                //#line 1134 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long i$46223min$50918 = 0L;
                
                //#line 1134 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final x10.core.Rail t$50919 = ((x10.core.Rail<x10.core.Double>)a$value$51265[(int)0L]);
                
                //#line 1134 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long t$50920 = ((x10.core.Rail<x10.core.Double>)t$50919).size;
                
                //#line 1134 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long i$46223max$50921 = ((t$50920) - (((long)(1L))));
                
                //#line 1134 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                long i$50915 = i$46223min$50918;
                {
                    
                    //#line 1134 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    for (;
                         true;
                         ) {
                        
                        //#line 1134 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        final long t$50916 = i$50915;
                        
                        //#line 1134 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        final boolean t$50917 = ((t$50916) <= (((long)(i$46223max$50921))));
                        
                        //#line 1134 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        if (!(t$50917)) {
                            
                            //#line 1134 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                            break;
                        }
                        
                        //#line 1134 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        final long j$50912 = i$50915;
                        
                        //#line 1135 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        final x10.core.Rail t$50908 = ((x10.core.Rail)(m));
                        
                        //#line 1135 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        final x10.core.Rail t$50909 = ((x10.core.Rail[])t$50908.value)[(int)i$50926];
                        
                        //#line 1135 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        final x10.core.Rail t$50910 = ((x10.core.Rail<x10.core.Double>)a$value$51265[(int)i$50926]);
                        
                        //#line 1135 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        final double t$50911 = ((double[])t$50910.value)[(int)j$50912];
                        
                        //#line 1135 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        ((double[])t$50909.value)[(int)j$50912] = t$50911;
                        
                        //#line 1134 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        final long t$50913 = i$50915;
                        
                        //#line 1134 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        final long t$50914 = ((t$50913) + (((long)(1L))));
                        
                        //#line 1134 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        i$50915 = t$50914;
                    }
                }
                
                //#line 1132 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long t$50927 = i$50929;
                
                //#line 1132 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long t$50928 = ((t$50927) + (((long)(1L))));
                
                //#line 1132 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                i$50929 = t$50928;
            }
        }
        
        //#line 1142 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        double pivot =  0;
        
        //#line 1143 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        double mul =  0;
        
        //#line 1146 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        final long i$46277min$51001 = 0L;
        
        //#line 1146 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        final long i$46277max$51002 = ((n) - (((long)(1L))));
        
        //#line 1146 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        long i$50996 = i$46277min$51001;
        {
            
            //#line 1146 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            final x10.core.Rail[] a$value$51266 = ((x10.core.Rail[])a.value);
            
            //#line 1146 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            for (;
                 true;
                 ) {
                
                //#line 1146 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long t$50997 = i$50996;
                
                //#line 1146 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final boolean t$50998 = ((t$50997) <= (((long)(i$46277max$51002))));
                
                //#line 1146 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                if (!(t$50998)) {
                    
                    //#line 1146 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    break;
                }
                
                //#line 1146 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long i$50993 = i$50996;
                
                //#line 1148 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final x10.core.Rail t$50983 = ((x10.core.Rail<x10.core.Double>)a$value$51266[(int)0L]);
                
                //#line 1148 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long t$50984 = ((x10.core.Rail<x10.core.Double>)t$50983).size;
                
                //#line 1148 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final boolean t$50985 = ((i$50993) < (((long)(t$50984))));
                
                //#line 1148 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                if (t$50985) {
                    
                    //#line 1150 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final x10.core.Rail t$50986 = ((x10.core.Rail)(m));
                    
                    //#line 1150 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    plham.util.Matrix.pivoting__0$1x10$lang$Rail$1x10$lang$Double$2$2(((x10.core.Rail)(t$50986)), (long)(n), (long)(i$50993));
                    
                    //#line 1154 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final x10.core.Rail t$50987 = ((x10.core.Rail)(m));
                    
                    //#line 1154 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final x10.core.Rail t$50988 = ((x10.core.Rail[])t$50987.value)[(int)i$50993];
                    
                    //#line 1154 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final double t$50989 = ((double[])t$50988.value)[(int)i$50993];
                    
                    //#line 1154 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    pivot = t$50989;
                    
                    //#line 1155 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final double t$50990 = pivot;
                    
                    //#line 1155 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final double t$50991 = ((double)(long)(((long)(0L))));
                    
                    //#line 1155 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final boolean t$50992 = ((t$50990) > (((double)(t$50991))));
                    
                    //#line 1155 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    if (t$50992) {
                        
                        //#line 1157 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        final long i$46259min$50976 = 0L;
                        
                        //#line 1157 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        final x10.core.Rail t$50977 = ((x10.core.Rail<x10.core.Double>)a$value$51266[(int)0L]);
                        
                        //#line 1157 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        final long t$50978 = ((x10.core.Rail<x10.core.Double>)t$50977).size;
                        
                        //#line 1157 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        final long i$46259max$50979 = ((t$50978) - (((long)(1L))));
                        
                        //#line 1157 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        long i$50944 = i$46259min$50976;
                        
                        //#line 1157 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        for (;
                             true;
                             ) {
                            
                            //#line 1157 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                            final long t$50945 = i$50944;
                            
                            //#line 1157 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                            final boolean t$50946 = ((t$50945) <= (((long)(i$46259max$50979))));
                            
                            //#line 1157 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                            if (!(t$50946)) {
                                
                                //#line 1157 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                                break;
                            }
                            
                            //#line 1157 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                            final long j$50941 = i$50944;
                            
                            //#line 1159 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                            final x10.core.Rail t$50932 = ((x10.core.Rail)(m));
                            
                            //#line 1159 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                            final x10.core.Rail t$50933 = ((x10.core.Rail[])t$50932.value)[(int)i$50993];
                            
                            //#line 1159 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                            final double t$50934 = ((double)(long)(((long)(1L))));
                            
                            //#line 1159 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                            final double t$50935 = pivot;
                            
                            //#line 1159 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                            final double t$50936 = ((t$50934) / (((double)(t$50935))));
                            
                            //#line 1159 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                            final x10.core.Rail t$50937 = ((x10.core.Rail)(m));
                            
                            //#line 1159 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                            final x10.core.Rail t$50938 = ((x10.core.Rail[])t$50937.value)[(int)i$50993];
                            
                            //#line 1159 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                            final double t$50939 = ((double[])t$50938.value)[(int)j$50941];
                            
                            //#line 1159 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                            final double t$50940 = ((t$50936) * (((double)(t$50939))));
                            
                            //#line 1159 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                            ((double[])t$50933.value)[(int)j$50941] = t$50940;
                            
                            //#line 1157 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                            final long t$50942 = i$50944;
                            
                            //#line 1157 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                            final long t$50943 = ((t$50942) + (((long)(1L))));
                            
                            //#line 1157 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                            i$50944 = t$50943;
                        }
                        
                        //#line 1179 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        long k$50980 = ((i$50993) + (((long)(1L))));
                        {
                            
                            //#line 1179 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                            for (;
                                 true;
                                 ) {
                                
                                //#line 1179 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                                final long t$50981 = k$50980;
                                
                                //#line 1179 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                                final boolean t$50982 = ((t$50981) < (((long)(n))));
                                
                                //#line 1179 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                                if (!(t$50982)) {
                                    
                                    //#line 1179 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                                    break;
                                }
                                
                                //#line 1180 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                                final x10.core.Rail t$50970 = ((x10.core.Rail)(m));
                                
                                //#line 1180 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                                final long t$50971 = k$50980;
                                
                                //#line 1180 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                                final x10.core.Rail t$50972 = ((x10.core.Rail[])t$50970.value)[(int)t$50971];
                                
                                //#line 1180 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                                final double t$50973 = ((double[])t$50972.value)[(int)i$50993];
                                
                                //#line 1180 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                                mul = t$50973;
                                
                                //#line 1181 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                                long l$50965 = i$50993;
                                {
                                    
                                    //#line 1181 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                                    for (;
                                         true;
                                         ) {
                                        
                                        //#line 1181 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                                        final long t$50966 = l$50965;
                                        
                                        //#line 1181 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                                        final x10.core.Rail t$50967 = ((x10.core.Rail<x10.core.Double>)a$value$51266[(int)0L]);
                                        
                                        //#line 1181 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                                        final long t$50968 = ((x10.core.Rail<x10.core.Double>)t$50967).size;
                                        
                                        //#line 1181 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                                        final boolean t$50969 = ((t$50966) < (((long)(t$50968))));
                                        
                                        //#line 1181 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                                        if (!(t$50969)) {
                                            
                                            //#line 1181 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                                            break;
                                        }
                                        
                                        //#line 1183 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                                        final x10.core.Rail t$50947 = ((x10.core.Rail)(m));
                                        
                                        //#line 1183 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                                        final long t$50948 = k$50980;
                                        
                                        //#line 1183 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                                        final x10.core.Rail t$50949 = ((x10.core.Rail[])t$50947.value)[(int)t$50948];
                                        
                                        //#line 1183 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                                        final long t$50950 = l$50965;
                                        
                                        //#line 1183 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                                        final x10.core.Rail t$50951 = ((x10.core.Rail)(m));
                                        
                                        //#line 1183 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                                        final long t$50952 = k$50980;
                                        
                                        //#line 1183 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                                        final x10.core.Rail t$50953 = ((x10.core.Rail[])t$50951.value)[(int)t$50952];
                                        
                                        //#line 1183 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                                        final long t$50954 = l$50965;
                                        
                                        //#line 1183 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                                        final double t$50955 = ((double[])t$50953.value)[(int)t$50954];
                                        
                                        //#line 1183 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                                        final double t$50956 = mul;
                                        
                                        //#line 1183 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                                        final x10.core.Rail t$50957 = ((x10.core.Rail)(m));
                                        
                                        //#line 1183 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                                        final x10.core.Rail t$50958 = ((x10.core.Rail[])t$50957.value)[(int)i$50993];
                                        
                                        //#line 1183 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                                        final long t$50959 = l$50965;
                                        
                                        //#line 1183 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                                        final double t$50960 = ((double[])t$50958.value)[(int)t$50959];
                                        
                                        //#line 1183 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                                        final double t$50961 = ((t$50956) * (((double)(t$50960))));
                                        
                                        //#line 1183 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                                        final double t$50962 = ((t$50955) - (((double)(t$50961))));
                                        
                                        //#line 1183 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                                        ((double[])t$50949.value)[(int)t$50950] = t$50962;
                                        
                                        //#line 1181 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                                        final long t$50963 = l$50965;
                                        
                                        //#line 1181 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                                        final long t$50964 = ((t$50963) + (((long)(1L))));
                                        
                                        //#line 1181 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                                        l$50965 = t$50964;
                                    }
                                }
                                
                                //#line 1179 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                                final long t$50974 = k$50980;
                                
                                //#line 1179 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                                final long t$50975 = ((t$50974) + (((long)(1L))));
                                
                                //#line 1179 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                                k$50980 = t$50975;
                            }
                        }
                    }
                }
                
                //#line 1146 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long t$50994 = i$50996;
                
                //#line 1146 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long t$50995 = ((t$50994) + (((long)(1L))));
                
                //#line 1146 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                i$50996 = t$50995;
            }
        }
        
        //#line 1198 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        final x10.core.Rail t$48656 = ((x10.core.Rail)(m));
        
        //#line 1198 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        return t$48656;
    }
    
    
    //#line 1203 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
    public static double determinant__0$1x10$lang$Rail$1x10$lang$Double$2$2$O(final x10.core.Rail<x10.core.Rail<x10.core.Double>> m) {
        
        //#line 1204 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        double det = 1.0;
        
        //#line 1205 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        assert ((long) ((x10.core.Rail<x10.core.Rail<x10.core.Double>>)m).size) == ((long) ((x10.core.Rail<x10.core.Double>)((x10.core.Rail[])m.value)[(int)0L]).size): "error";
        
        //#line 1206 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        final long n = ((x10.core.Rail<x10.core.Rail<x10.core.Double>>)m).size;
        
        //#line 1209 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        x10.core.Rail h = new x10.core.Rail<x10.core.Rail<x10.core.Double>>(x10.rtt.ParameterizedType.make(x10.core.Rail.$RTT, x10.rtt.Types.DOUBLE), ((long)(n)));
        
        //#line 1210 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        final long i$46295min$51077 = 0L;
        
        //#line 1210 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        final long i$46295max$51078 = ((n) - (((long)(1L))));
        
        //#line 1210 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        long i$51008 = i$46295min$51077;
        
        //#line 1210 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        for (;
             true;
             ) {
            
            //#line 1210 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            final long t$51009 = i$51008;
            
            //#line 1210 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            final boolean t$51010 = ((t$51009) <= (((long)(i$46295max$51078))));
            
            //#line 1210 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            if (!(t$51010)) {
                
                //#line 1210 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                break;
            }
            
            //#line 1210 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            final long i$51005 = i$51008;
            
            //#line 1211 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            final x10.core.Rail t$51003 = ((x10.core.Rail)(h));
            
            //#line 1211 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            final x10.core.Rail t$51004 = ((x10.core.Rail)(new x10.core.Rail<x10.core.Double>(x10.rtt.Types.DOUBLE, ((long)(n)))));
            
            //#line 1211 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            ((x10.core.Rail[])t$51003.value)[(int)i$51005] = t$51004;
            
            //#line 1210 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            final long t$51006 = i$51008;
            
            //#line 1210 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            final long t$51007 = ((t$51006) + (((long)(1L))));
            
            //#line 1210 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            i$51008 = t$51007;
        }
        
        //#line 1214 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        final long i$46331min$51079 = 0L;
        
        //#line 1214 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        final long i$46331max$51080 = ((n) - (((long)(1L))));
        
        //#line 1214 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        long i$51026 = i$46331min$51079;
        {
            
            //#line 1214 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            final x10.core.Rail[] m$value$51267 = ((x10.core.Rail[])m.value);
            
            //#line 1214 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            for (;
                 true;
                 ) {
                
                //#line 1214 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long t$51027 = i$51026;
                
                //#line 1214 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final boolean t$51028 = ((t$51027) <= (((long)(i$46331max$51080))));
                
                //#line 1214 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                if (!(t$51028)) {
                    
                    //#line 1214 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    break;
                }
                
                //#line 1214 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long i$51023 = i$51026;
                
                //#line 1215 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long i$46313min$51021 = 0L;
                
                //#line 1215 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long i$46313max$51022 = ((n) - (((long)(1L))));
                
                //#line 1215 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                long i$51018 = i$46313min$51021;
                {
                    
                    //#line 1215 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    for (;
                         true;
                         ) {
                        
                        //#line 1215 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        final long t$51019 = i$51018;
                        
                        //#line 1215 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        final boolean t$51020 = ((t$51019) <= (((long)(i$46313max$51022))));
                        
                        //#line 1215 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        if (!(t$51020)) {
                            
                            //#line 1215 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                            break;
                        }
                        
                        //#line 1215 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        final long j$51015 = i$51018;
                        
                        //#line 1216 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        final x10.core.Rail t$51011 = ((x10.core.Rail)(h));
                        
                        //#line 1216 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        final x10.core.Rail t$51012 = ((x10.core.Rail[])t$51011.value)[(int)i$51023];
                        
                        //#line 1216 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        final x10.core.Rail t$51013 = ((x10.core.Rail<x10.core.Double>)m$value$51267[(int)i$51023]);
                        
                        //#line 1216 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        final double t$51014 = ((double[])t$51013.value)[(int)j$51015];
                        
                        //#line 1216 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        ((double[])t$51012.value)[(int)j$51015] = t$51014;
                        
                        //#line 1215 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        final long t$51016 = i$51018;
                        
                        //#line 1215 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        final long t$51017 = ((t$51016) + (((long)(1L))));
                        
                        //#line 1215 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        i$51018 = t$51017;
                    }
                }
                
                //#line 1214 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long t$51024 = i$51026;
                
                //#line 1214 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long t$51025 = ((t$51024) + (((long)(1L))));
                
                //#line 1214 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                i$51026 = t$51025;
            }
        }
        
        //#line 1224 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        long i$51081 = 0L;
        
        //#line 1224 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        for (;
             true;
             ) {
            
            //#line 1224 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            final long t$51082 = i$51081;
            
            //#line 1224 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            final boolean t$51083 = ((t$51082) < (((long)(n))));
            
            //#line 1224 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            if (!(t$51083)) {
                
                //#line 1224 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                break;
            }
            
            //#line 1225 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            long j$51063 = 0L;
            
            //#line 1225 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            for (;
                 true;
                 ) {
                
                //#line 1225 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long t$51064 = j$51063;
                
                //#line 1225 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final boolean t$51065 = ((t$51064) < (((long)(n))));
                
                //#line 1225 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                if (!(t$51065)) {
                    
                    //#line 1225 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    break;
                }
                
                //#line 1226 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long t$51047 = i$51081;
                
                //#line 1226 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long t$51048 = j$51063;
                
                //#line 1226 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final boolean t$51049 = ((t$51047) < (((long)(t$51048))));
                
                //#line 1226 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                if (t$51049) {
                    
                    //#line 1227 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final x10.core.Rail t$51050 = ((x10.core.Rail)(h));
                    
                    //#line 1227 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final long t$51051 = j$51063;
                    
                    //#line 1227 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final x10.core.Rail t$51052 = ((x10.core.Rail[])t$51050.value)[(int)t$51051];
                    
                    //#line 1227 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final long t$51053 = i$51081;
                    
                    //#line 1227 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final double t$51054 = ((double[])t$51052.value)[(int)t$51053];
                    
                    //#line 1227 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final x10.core.Rail t$51055 = ((x10.core.Rail)(h));
                    
                    //#line 1227 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final long t$51056 = i$51081;
                    
                    //#line 1227 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final x10.core.Rail t$51057 = ((x10.core.Rail[])t$51055.value)[(int)t$51056];
                    
                    //#line 1227 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final long t$51058 = i$51081;
                    
                    //#line 1227 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final double t$51059 = ((double[])t$51057.value)[(int)t$51058];
                    
                    //#line 1227 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    double buf$51060 = ((t$51054) / (((double)(t$51059))));
                    
                    //#line 1228 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    long k$51044 = 0L;
                    
                    //#line 1228 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    for (;
                         true;
                         ) {
                        
                        //#line 1228 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        final long t$51045 = k$51044;
                        
                        //#line 1228 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        final boolean t$51046 = ((t$51045) < (((long)(n))));
                        
                        //#line 1228 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        if (!(t$51046)) {
                            
                            //#line 1228 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                            break;
                        }
                        
                        //#line 1229 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        final x10.core.Rail t$51029 = ((x10.core.Rail)(h));
                        
                        //#line 1229 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        final long t$51030 = j$51063;
                        
                        //#line 1229 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        final x10.core.Rail a$51031 = ((x10.core.Rail[])t$51029.value)[(int)t$51030];
                        
                        //#line 1229 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        final long i$51032 = k$51044;
                        
                        //#line 1229 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        final double t$51033 = ((double[])a$51031.value)[(int)i$51032];
                        
                        //#line 1229 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        final x10.core.Rail t$51034 = ((x10.core.Rail)(h));
                        
                        //#line 1229 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        final long t$51035 = i$51081;
                        
                        //#line 1229 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        final x10.core.Rail t$51036 = ((x10.core.Rail[])t$51034.value)[(int)t$51035];
                        
                        //#line 1229 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        final long t$51037 = k$51044;
                        
                        //#line 1229 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        final double t$51038 = ((double[])t$51036.value)[(int)t$51037];
                        
                        //#line 1229 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        final double t$51039 = buf$51060;
                        
                        //#line 1229 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        final double t$51040 = ((t$51038) * (((double)(t$51039))));
                        
                        //#line 1229 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        final double r$51041 = ((t$51033) - (((double)(t$51040))));
                        
                        //#line 1229 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        ((double[])a$51031.value)[(int)i$51032] = r$51041;
                        
                        //#line 1228 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        final long t$51042 = k$51044;
                        
                        //#line 1228 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        final long t$51043 = ((t$51042) + (((long)(1L))));
                        
                        //#line 1228 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        k$51044 = t$51043;
                    }
                }
                
                //#line 1225 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long t$51061 = j$51063;
                
                //#line 1225 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long t$51062 = ((t$51061) + (((long)(1L))));
                
                //#line 1225 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                j$51063 = t$51062;
            }
            
            //#line 1224 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            final long t$51066 = i$51081;
            
            //#line 1224 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            final long t$51067 = ((t$51066) + (((long)(1L))));
            
            //#line 1224 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            i$51081 = t$51067;
        }
        
        //#line 1238 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        long i$51084 = 0L;
        
        //#line 1238 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        for (;
             true;
             ) {
            
            //#line 1238 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            final long t$51085 = i$51084;
            
            //#line 1238 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            final boolean t$51086 = ((t$51085) < (((long)(n))));
            
            //#line 1238 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            if (!(t$51086)) {
                
                //#line 1238 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                break;
            }
            
            //#line 1239 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            final double t$51068 = det;
            
            //#line 1239 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            final x10.core.Rail t$51069 = ((x10.core.Rail)(h));
            
            //#line 1239 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            final long t$51070 = i$51084;
            
            //#line 1239 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            final x10.core.Rail t$51071 = ((x10.core.Rail[])t$51069.value)[(int)t$51070];
            
            //#line 1239 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            final long t$51072 = i$51084;
            
            //#line 1239 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            final double t$51073 = ((double[])t$51071.value)[(int)t$51072];
            
            //#line 1239 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            final double t$51074 = ((t$51068) * (((double)(t$51073))));
            
            //#line 1239 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            det = t$51074;
            
            //#line 1238 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            final long t$51075 = i$51084;
            
            //#line 1238 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            final long t$51076 = ((t$51075) + (((long)(1L))));
            
            //#line 1238 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            i$51084 = t$51076;
        }
        
        //#line 1241 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        final double t$48728 = det;
        
        //#line 1241 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        return t$48728;
    }
    
    
    //#line 1246 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
    public static void dump__0$1x10$lang$Double$2(final x10.core.Rail<x10.core.Double> v) {
        
        //#line 1247 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        final long n = ((x10.core.Rail<x10.core.Double>)v).size;
        
        //#line 1248 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        final long i$46349min$51096 = 0L;
        
        //#line 1248 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        final long i$46349max$51097 = ((n) - (((long)(1L))));
        
        //#line 1248 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        long i$51093 = i$46349min$51096;
        {
            
            //#line 1248 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            final double[] v$value$51268 = ((double[])v.value);
            
            //#line 1248 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            for (;
                 true;
                 ) {
                
                //#line 1248 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long t$51094 = i$51093;
                
                //#line 1248 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final boolean t$51095 = ((t$51094) <= (((long)(i$46349max$51097))));
                
                //#line 1248 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                if (!(t$51095)) {
                    
                    //#line 1248 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    break;
                }
                
                //#line 1248 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long i$51090 = i$51093;
                
                //#line 1249 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final x10.io.Printer t$51087 = ((x10.io.Printer)(x10.io.Console.get$OUT()));
                
                //#line 1249 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final double t$51088 = ((double)v$value$51268[(int)i$51090]);
                
                //#line 1249 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final java.lang.String t$51089 = (((x10.core.Double.$box(t$51088))) + ("\t"));
                
                //#line 1249 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                t$51087.print(((java.lang.String)(t$51089)));
                
                //#line 1248 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long t$51091 = i$51093;
                
                //#line 1248 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long t$51092 = ((t$51091) + (((long)(1L))));
                
                //#line 1248 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                i$51093 = t$51092;
            }
        }
        
        //#line 1251 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        final x10.io.Printer t$48737 = ((x10.io.Printer)(x10.io.Console.get$OUT()));
        
        //#line 1251 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        t$48737.println(((java.lang.Object)("\n")));
    }
    
    
    //#line 1254 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
    public static void dump__0$1x10$lang$Boolean$2(final x10.core.Rail<x10.core.Boolean> v) {
        
        //#line 1255 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        final long n = ((x10.core.Rail<x10.core.Boolean>)v).size;
        
        //#line 1256 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        final long i$46367min$51107 = 0L;
        
        //#line 1256 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        final long i$46367max$51108 = ((n) - (((long)(1L))));
        
        //#line 1256 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        long i$51104 = i$46367min$51107;
        {
            
            //#line 1256 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            final boolean[] v$value$51269 = ((boolean[])v.value);
            
            //#line 1256 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            for (;
                 true;
                 ) {
                
                //#line 1256 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long t$51105 = i$51104;
                
                //#line 1256 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final boolean t$51106 = ((t$51105) <= (((long)(i$46367max$51108))));
                
                //#line 1256 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                if (!(t$51106)) {
                    
                    //#line 1256 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    break;
                }
                
                //#line 1256 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long i$51101 = i$51104;
                
                //#line 1257 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final x10.io.Printer t$51098 = ((x10.io.Printer)(x10.io.Console.get$OUT()));
                
                //#line 1257 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final boolean t$51099 = ((boolean)v$value$51269[(int)i$51101]);
                
                //#line 1257 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final java.lang.String t$51100 = (((x10.core.Boolean.$box(t$51099))) + ("\t"));
                
                //#line 1257 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                t$51098.print(((java.lang.String)(t$51100)));
                
                //#line 1256 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long t$51102 = i$51104;
                
                //#line 1256 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long t$51103 = ((t$51102) + (((long)(1L))));
                
                //#line 1256 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                i$51104 = t$51103;
            }
        }
        
        //#line 1259 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        final x10.io.Printer t$48746 = ((x10.io.Printer)(x10.io.Console.get$OUT()));
        
        //#line 1259 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        t$48746.println(((java.lang.Object)("\n")));
    }
    
    
    //#line 1262 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
    public static void dump__0$1x10$lang$Long$2(final x10.core.Rail<x10.core.Long> v) {
        
        //#line 1263 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        final long n = ((x10.core.Rail<x10.core.Long>)v).size;
        
        //#line 1264 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        final long i$46385min$51118 = 0L;
        
        //#line 1264 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        final long i$46385max$51119 = ((n) - (((long)(1L))));
        
        //#line 1264 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        long i$51115 = i$46385min$51118;
        {
            
            //#line 1264 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            final long[] v$value$51270 = ((long[])v.value);
            
            //#line 1264 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            for (;
                 true;
                 ) {
                
                //#line 1264 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long t$51116 = i$51115;
                
                //#line 1264 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final boolean t$51117 = ((t$51116) <= (((long)(i$46385max$51119))));
                
                //#line 1264 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                if (!(t$51117)) {
                    
                    //#line 1264 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    break;
                }
                
                //#line 1264 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long i$51112 = i$51115;
                
                //#line 1265 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final x10.io.Printer t$51109 = ((x10.io.Printer)(x10.io.Console.get$OUT()));
                
                //#line 1265 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long t$51110 = ((long)v$value$51270[(int)i$51112]);
                
                //#line 1265 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final java.lang.String t$51111 = (((x10.core.Long.$box(t$51110))) + ("\t"));
                
                //#line 1265 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                t$51109.print(((java.lang.String)(t$51111)));
                
                //#line 1264 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long t$51113 = i$51115;
                
                //#line 1264 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long t$51114 = ((t$51113) + (((long)(1L))));
                
                //#line 1264 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                i$51115 = t$51114;
            }
        }
        
        //#line 1267 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        final x10.io.Printer t$48755 = ((x10.io.Printer)(x10.io.Console.get$OUT()));
        
        //#line 1267 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        t$48755.println(((java.lang.Object)("\n")));
    }
    
    
    //#line 1271 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
    public static void dump__0$1x10$lang$Rail$1x10$lang$Double$2$2(final x10.core.Rail<x10.core.Rail<x10.core.Double>> m) {
        
        //#line 1272 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        final x10.io.Printer t$48756 = ((x10.io.Printer)(x10.io.Console.get$OUT()));
        
        //#line 1272 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        t$48756.print(((java.lang.String)("\n")));
        
        //#line 1273 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        final long n = ((x10.core.Rail<x10.core.Rail<x10.core.Double>>)m).size;
        
        //#line 1274 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        final long i$46421min$51141 = 0L;
        
        //#line 1274 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        final long i$46421max$51142 = ((n) - (((long)(1L))));
        
        //#line 1274 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        long i$51138 = i$46421min$51141;
        {
            
            //#line 1274 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            final x10.core.Rail[] m$value$51271 = ((x10.core.Rail[])m.value);
            
            //#line 1274 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            for (;
                 true;
                 ) {
                
                //#line 1274 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long t$51139 = i$51138;
                
                //#line 1274 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final boolean t$51140 = ((t$51139) <= (((long)(i$46421max$51142))));
                
                //#line 1274 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                if (!(t$51140)) {
                    
                    //#line 1274 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    break;
                }
                
                //#line 1274 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long i$51135 = i$51138;
                
                //#line 1275 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long i$46403min$51130 = 0L;
                
                //#line 1275 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final x10.core.Rail t$51131 = ((x10.core.Rail<x10.core.Double>)m$value$51271[(int)i$51135]);
                
                //#line 1275 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long t$51132 = ((x10.core.Rail<x10.core.Double>)t$51131).size;
                
                //#line 1275 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long i$46403max$51133 = ((t$51132) - (((long)(1L))));
                
                //#line 1275 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                long i$51127 = i$46403min$51130;
                {
                    
                    //#line 1275 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    for (;
                         true;
                         ) {
                        
                        //#line 1275 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        final long t$51128 = i$51127;
                        
                        //#line 1275 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        final boolean t$51129 = ((t$51128) <= (((long)(i$46403max$51133))));
                        
                        //#line 1275 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        if (!(t$51129)) {
                            
                            //#line 1275 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                            break;
                        }
                        
                        //#line 1275 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        final long j$51124 = i$51127;
                        
                        //#line 1276 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        final x10.io.Printer t$51120 = ((x10.io.Printer)(x10.io.Console.get$OUT()));
                        
                        //#line 1276 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        final x10.core.Rail t$51121 = ((x10.core.Rail<x10.core.Double>)m$value$51271[(int)i$51135]);
                        
                        //#line 1276 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        final double t$51122 = ((double[])t$51121.value)[(int)j$51124];
                        
                        //#line 1276 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        final java.lang.String t$51123 = (((x10.core.Double.$box(t$51122))) + ("\t"));
                        
                        //#line 1276 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        t$51120.print(((java.lang.String)(t$51123)));
                        
                        //#line 1275 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        final long t$51125 = i$51127;
                        
                        //#line 1275 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        final long t$51126 = ((t$51125) + (((long)(1L))));
                        
                        //#line 1275 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                        i$51127 = t$51126;
                    }
                }
                
                //#line 1278 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final x10.io.Printer t$51134 = ((x10.io.Printer)(x10.io.Console.get$OUT()));
                
                //#line 1278 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                t$51134.println(((java.lang.Object)("")));
                
                //#line 1274 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long t$51136 = i$51138;
                
                //#line 1274 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long t$51137 = ((t$51136) + (((long)(1L))));
                
                //#line 1274 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                i$51138 = t$51137;
            }
        }
        
        //#line 1280 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        final x10.io.Printer t$48774 = ((x10.io.Printer)(x10.io.Console.get$OUT()));
        
        //#line 1280 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        t$48774.println(((java.lang.Object)("")));
    }
    
    
    //#line 1284 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
    public static double minimum__0$1x10$lang$Double$2$O(final x10.util.ArrayList<x10.core.Double> base) {
        
        //#line 1285 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        final long n = ((x10.util.ArrayList<x10.core.Double>)base).size$O();
        
        //#line 1286 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        x10.core.Rail hoge = new x10.core.Rail<x10.core.Double>(x10.rtt.Types.DOUBLE, ((long)(n)));
        
        //#line 1287 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        final long i$46439min$51151 = 0L;
        
        //#line 1287 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        final long i$46439max$51152 = ((n) - (((long)(1L))));
        
        //#line 1287 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        long i$51148 = i$46439min$51151;
        
        //#line 1287 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        for (;
             true;
             ) {
            
            //#line 1287 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            final long t$51149 = i$51148;
            
            //#line 1287 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            final boolean t$51150 = ((t$51149) <= (((long)(i$46439max$51152))));
            
            //#line 1287 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            if (!(t$51150)) {
                
                //#line 1287 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                break;
            }
            
            //#line 1287 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            final long i$51145 = i$51148;
            
            //#line 1288 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            final x10.core.Rail t$51143 = ((x10.core.Rail)(hoge));
            
            //#line 1288 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            final double t$51144 = x10.core.Double.$unbox(((x10.util.ArrayList<x10.core.Double>)base).get$G((long)(i$51145)));
            
            //#line 1288 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            ((double[])t$51143.value)[(int)i$51145] = t$51144;
            
            //#line 1287 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            final long t$51146 = i$51148;
            
            //#line 1287 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            final long t$51147 = ((t$51146) + (((long)(1L))));
            
            //#line 1287 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            i$51148 = t$51147;
        }
        
        //#line 1290 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        final x10.core.Rail t$48782 = ((x10.core.Rail)(hoge));
        
        //#line 1290 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        final double t$48783 = plham.util.Matrix.minimum__0$1x10$lang$Double$2$O(((x10.core.Rail)(t$48782)));
        
        //#line 1290 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        return t$48783;
    }
    
    
    //#line 1293 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
    public static double minimum__0$1x10$lang$Double$2$O(final x10.core.Rail<x10.core.Double> x) {
        
        //#line 1294 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        final long t$48784 = plham.util.Matrix.get$maxPositionSize();
        
        //#line 1294 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        double out = ((double)(long)(((long)(t$48784))));
        
        //#line 1295 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        final long i$46457min$51163 = 0L;
        
        //#line 1295 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        final long t$51164 = ((x10.core.Rail<x10.core.Double>)x).size;
        
        //#line 1295 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        final long i$46457max$51165 = ((t$51164) - (((long)(1L))));
        
        //#line 1295 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        long i$51160 = i$46457min$51163;
        {
            
            //#line 1295 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            final double[] x$value$51272 = ((double[])x.value);
            
            //#line 1295 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            for (;
                 true;
                 ) {
                
                //#line 1295 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long t$51161 = i$51160;
                
                //#line 1295 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final boolean t$51162 = ((t$51161) <= (((long)(i$46457max$51165))));
                
                //#line 1295 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                if (!(t$51162)) {
                    
                    //#line 1295 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    break;
                }
                
                //#line 1295 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long i$51157 = i$51160;
                
                //#line 1296 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final double t$51153 = ((double)x$value$51272[(int)i$51157]);
                
                //#line 1296 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final double t$51154 = out;
                
                //#line 1296 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final boolean t$51155 = ((t$51153) < (((double)(t$51154))));
                
                //#line 1296 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                if (t$51155) {
                    
                    //#line 1297 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final double t$51156 = ((double)x$value$51272[(int)i$51157]);
                    
                    //#line 1297 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    out = t$51156;
                }
                
                //#line 1295 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long t$51158 = i$51160;
                
                //#line 1295 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long t$51159 = ((t$51158) + (((long)(1L))));
                
                //#line 1295 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                i$51160 = t$51159;
            }
        }
        
        //#line 1300 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        final double t$48795 = out;
        
        //#line 1300 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        return t$48795;
    }
    
    
    //#line 1304 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
    public static double maximum__0$1x10$lang$Double$2$O(final x10.core.Rail<x10.core.Double> x) {
        
        //#line 1305 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        final double t$48797 = ((double)(long)(((long)(-1L))));
        
        //#line 1305 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        final long t$48796 = plham.util.Matrix.get$maxPositionSize();
        
        //#line 1305 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        final double t$48798 = ((double)(long)(((long)(t$48796))));
        
        //#line 1305 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        double out = ((t$48797) * (((double)(t$48798))));
        
        //#line 1306 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        final long i$46475min$51176 = 0L;
        
        //#line 1306 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        final long t$51177 = ((x10.core.Rail<x10.core.Double>)x).size;
        
        //#line 1306 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        final long i$46475max$51178 = ((t$51177) - (((long)(1L))));
        
        //#line 1306 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        long i$51173 = i$46475min$51176;
        {
            
            //#line 1306 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            final double[] x$value$51273 = ((double[])x.value);
            
            //#line 1306 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            for (;
                 true;
                 ) {
                
                //#line 1306 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long t$51174 = i$51173;
                
                //#line 1306 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final boolean t$51175 = ((t$51174) <= (((long)(i$46475max$51178))));
                
                //#line 1306 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                if (!(t$51175)) {
                    
                    //#line 1306 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    break;
                }
                
                //#line 1306 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long i$51170 = i$51173;
                
                //#line 1307 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final double t$51166 = ((double)x$value$51273[(int)i$51170]);
                
                //#line 1307 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final double t$51167 = out;
                
                //#line 1307 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final boolean t$51168 = ((t$51166) > (((double)(t$51167))));
                
                //#line 1307 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                if (t$51168) {
                    
                    //#line 1308 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    final double t$51169 = ((double)x$value$51273[(int)i$51170]);
                    
                    //#line 1308 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    out = t$51169;
                }
                
                //#line 1306 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long t$51171 = i$51173;
                
                //#line 1306 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long t$51172 = ((t$51171) + (((long)(1L))));
                
                //#line 1306 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                i$51173 = t$51172;
            }
        }
        
        //#line 1311 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        final double t$48809 = out;
        
        //#line 1311 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        return t$48809;
    }
    
    
    //#line 1315 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
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
            Matrix.main(args);
        }
    }
    
    // the original app-main method
    public static void main(final x10.core.Rail<java.lang.String> args) {
        
        //#line 1895 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        x10.core.Rail Q = new x10.core.Rail<x10.core.Rail<x10.core.Double>>(x10.rtt.ParameterizedType.make(x10.core.Rail.$RTT, x10.rtt.Types.DOUBLE), ((long)(2L)));
        
        //#line 1896 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        final x10.core.Rail t$48810 = ((x10.core.Rail)(Q));
        
        //#line 1896 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        final x10.core.Rail t$48811 = ((x10.core.Rail)(new x10.core.Rail<x10.core.Double>(x10.rtt.Types.DOUBLE, ((long)(2L)))));
        
        //#line 1896 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        ((x10.core.Rail[])t$48810.value)[(int)0L] = t$48811;
        
        //#line 1897 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        final x10.core.Rail t$48812 = ((x10.core.Rail)(Q));
        
        //#line 1897 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        final x10.core.Rail t$48813 = ((x10.core.Rail)(new x10.core.Rail<x10.core.Double>(x10.rtt.Types.DOUBLE, ((long)(2L)))));
        
        //#line 1897 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        ((x10.core.Rail[])t$48812.value)[(int)1L] = t$48813;
        
        //#line 1898 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        final x10.core.Rail t$48814 = ((x10.core.Rail)(Q));
        
        //#line 1898 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        final x10.core.Rail t$48815 = ((x10.core.Rail[])t$48814.value)[(int)0L];
        
        //#line 1898 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        ((double[])t$48815.value)[(int)0L] = 3.491238029731011;
        
        //#line 1898 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        final x10.core.Rail t$48816 = ((x10.core.Rail)(Q));
        
        //#line 1898 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        final x10.core.Rail t$48817 = ((x10.core.Rail[])t$48816.value)[(int)0L];
        
        //#line 1898 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        final double t$48818 = -137.85828574971586;
        
        //#line 1898 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        ((double[])t$48817.value)[(int)1L] = t$48818;
        
        //#line 1899 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        final x10.core.Rail t$48819 = ((x10.core.Rail)(Q));
        
        //#line 1899 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        final x10.core.Rail t$48820 = ((x10.core.Rail[])t$48819.value)[(int)1L];
        
        //#line 1899 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        final double t$48821 = -137.85828574971586;
        
        //#line 1899 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        ((double[])t$48820.value)[(int)0L] = t$48821;
        
        //#line 1899 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        final x10.core.Rail t$48822 = ((x10.core.Rail)(Q));
        
        //#line 1899 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        final x10.core.Rail t$48823 = ((x10.core.Rail[])t$48822.value)[(int)1L];
        
        //#line 1899 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        ((double[])t$48823.value)[(int)1L] = 456507.3710301268;
        
        //#line 1900 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        final x10.io.Printer t$48824 = ((x10.io.Printer)(x10.io.Console.get$OUT()));
        
        //#line 1900 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        t$48824.println(((java.lang.Object)("============settings")));
        
        //#line 1901 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        final x10.io.Printer t$48825 = ((x10.io.Printer)(x10.io.Console.get$OUT()));
        
        //#line 1901 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        t$48825.println(((java.lang.Object)("*FOC of objective function")));
        
        //#line 1902 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        final x10.io.Printer t$48826 = ((x10.io.Printer)(x10.io.Console.get$OUT()));
        
        //#line 1902 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        t$48826.println(((java.lang.Object)("**Q")));
        
        //#line 1903 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        final x10.core.Rail t$48827 = ((x10.core.Rail)(Q));
        
        //#line 1903 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        plham.util.Matrix.dump__0$1x10$lang$Rail$1x10$lang$Double$2$2(((x10.core.Rail)(t$48827)));
        
        //#line 1905 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        final double t$48828 = -1.5029194602888159E10;
        
        //#line 1905 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        final double t$48829 = -1.5029194602888159E10;
        
        //#line 1905 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        final x10.core.Rail c = ((x10.core.Rail)(x10.runtime.impl.java.ArrayUtils.<x10.core.Double> makeRailFromJavaArray(x10.rtt.Types.DOUBLE, new double[] {t$48828, t$48829})));
        
        //#line 1907 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        final long t$48830 = ((x10.core.Rail<x10.core.Double>)c).size;
        
        //#line 1907 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        x10.core.Rail C = new x10.core.Rail<x10.core.Double>(x10.rtt.Types.DOUBLE, ((long)(t$48830)));
        
        //#line 1908 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        final long i$46493min$51195 = 0L;
        
        //#line 1908 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        final long t$51196 = ((x10.core.Rail<x10.core.Double>)c).size;
        
        //#line 1908 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        final long i$46493max$51197 = ((t$51196) - (((long)(1L))));
        
        //#line 1908 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        long i$51184 = i$46493min$51195;
        {
            
            //#line 1908 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            final double[] c$value$51274 = ((double[])c.value);
            
            //#line 1908 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            for (;
                 true;
                 ) {
                
                //#line 1908 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long t$51185 = i$51184;
                
                //#line 1908 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final boolean t$51186 = ((t$51185) <= (((long)(i$46493max$51197))));
                
                //#line 1908 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                if (!(t$51186)) {
                    
                    //#line 1908 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                    break;
                }
                
                //#line 1908 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long i$51181 = i$51184;
                
                //#line 1909 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final x10.core.Rail t$51179 = ((x10.core.Rail)(C));
                
                //#line 1909 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final double t$51180 = ((double)c$value$51274[(int)i$51181]);
                
                //#line 1909 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                ((double[])t$51179.value)[(int)i$51181] = t$51180;
                
                //#line 1908 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long t$51182 = i$51184;
                
                //#line 1908 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                final long t$51183 = ((t$51182) + (((long)(1L))));
                
                //#line 1908 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                i$51184 = t$51183;
            }
        }
        
        //#line 1911 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        final x10.io.Printer t$48839 = ((x10.io.Printer)(x10.io.Console.get$OUT()));
        
        //#line 1911 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        t$48839.println(((java.lang.Object)("**C")));
        
        //#line 1912 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        final x10.core.Rail t$48840 = ((x10.core.Rail)(C));
        
        //#line 1912 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        plham.util.Matrix.dump__0$1x10$lang$Double$2(((x10.core.Rail)(t$48840)));
        
        //#line 1929 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        x10.core.Rail constraints = new x10.core.Rail<x10.core.Rail<x10.core.Double>>(x10.rtt.ParameterizedType.make(x10.core.Rail.$RTT, x10.rtt.Types.DOUBLE), ((long)(1L)));
        
        //#line 1930 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        final long i$46511min$51198 = 0L;
        
        //#line 1930 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        final x10.core.Rail t$51199 = ((x10.core.Rail)(constraints));
        
        //#line 1930 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        final long t$51200 = ((x10.core.Rail<x10.core.Rail<x10.core.Double>>)t$51199).size;
        
        //#line 1930 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        final long i$46511max$51201 = ((t$51200) - (((long)(1L))));
        
        //#line 1930 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        long i$51192 = i$46511min$51198;
        
        //#line 1930 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        for (;
             true;
             ) {
            
            //#line 1930 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            final long t$51193 = i$51192;
            
            //#line 1930 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            final boolean t$51194 = ((t$51193) <= (((long)(i$46511max$51201))));
            
            //#line 1930 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            if (!(t$51194)) {
                
                //#line 1930 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
                break;
            }
            
            //#line 1930 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            final long i$51189 = i$51192;
            
            //#line 1931 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            final x10.core.Rail t$51187 = ((x10.core.Rail)(constraints));
            
            //#line 1931 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            final x10.core.Rail t$51188 = ((x10.core.Rail)(new x10.core.Rail<x10.core.Double>(x10.rtt.Types.DOUBLE, ((long)(3L)))));
            
            //#line 1931 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            ((x10.core.Rail[])t$51187.value)[(int)i$51189] = t$51188;
            
            //#line 1930 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            final long t$51190 = i$51192;
            
            //#line 1930 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            final long t$51191 = ((t$51190) + (((long)(1L))));
            
            //#line 1930 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            i$51192 = t$51191;
        }
        
        //#line 1934 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        final x10.core.Rail t$48850 = ((x10.core.Rail)(constraints));
        
        //#line 1934 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        final x10.core.Rail t$48851 = ((x10.core.Rail[])t$48850.value)[(int)0L];
        
        //#line 1934 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        ((double[])t$48851.value)[(int)0L] = 9.352411165770475;
        
        //#line 1934 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        final x10.core.Rail t$48852 = ((x10.core.Rail)(constraints));
        
        //#line 1934 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        final x10.core.Rail t$48853 = ((x10.core.Rail[])t$48852.value)[(int)0L];
        
        //#line 1934 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        ((double[])t$48853.value)[(int)1L] = 3128.463420483581;
        
        //#line 1934 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        final x10.core.Rail t$48854 = ((x10.core.Rail)(constraints));
        
        //#line 1934 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        final x10.core.Rail t$48855 = ((x10.core.Rail[])t$48854.value)[(int)0L];
        
        //#line 1934 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        ((double[])t$48855.value)[(int)2L] = 9281203.443951873;
        
        //#line 1935 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        final x10.core.Rail t$48856 = ((x10.core.Rail)(constraints));
        
        //#line 1935 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        x10.core.Rail A = plham.util.Matrix.devideExpansionCoefficientMatrix1__0$1x10$lang$Rail$1x10$lang$Double$2$2(((x10.core.Rail)(t$48856)));
        
        //#line 1936 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        final x10.core.Rail t$48857 = ((x10.core.Rail)(constraints));
        
        //#line 1936 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        x10.core.Rail B = plham.util.Matrix.devideExpansionCoefficientMatrix2__0$1x10$lang$Rail$1x10$lang$Double$2$2(((x10.core.Rail)(t$48857)));
        
        //#line 1938 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        final x10.io.Printer t$48858 = ((x10.io.Printer)(x10.io.Console.get$OUT()));
        
        //#line 1938 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        t$48858.println(((java.lang.Object)("*constraints")));
        
        //#line 1939 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        final x10.io.Printer t$48859 = ((x10.io.Printer)(x10.io.Console.get$OUT()));
        
        //#line 1939 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        t$48859.println(((java.lang.Object)("**A")));
        
        //#line 1940 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        final x10.core.Rail t$48860 = ((x10.core.Rail)(A));
        
        //#line 1940 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        plham.util.Matrix.dump__0$1x10$lang$Rail$1x10$lang$Double$2$2(((x10.core.Rail)(t$48860)));
        
        //#line 1941 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        final x10.io.Printer t$48861 = ((x10.io.Printer)(x10.io.Console.get$OUT()));
        
        //#line 1941 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        t$48861.println(((java.lang.Object)("**B")));
        
        //#line 1942 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        final x10.core.Rail t$48862 = ((x10.core.Rail)(B));
        
        //#line 1942 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        plham.util.Matrix.dump__0$1x10$lang$Double$2(((x10.core.Rail)(t$48862)));
        
        //#line 1944 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        final x10.core.Rail t$48863 = ((x10.core.Rail)(A));
        
        //#line 1944 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        final x10.core.Rail t$48864 = ((x10.core.Rail)(B));
        
        //#line 1944 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        x10.core.Rail initialValue = plham.util.Matrix.initialASM0__0$1x10$lang$Rail$1x10$lang$Double$2$2__1$1x10$lang$Double$2(((x10.core.Rail)(t$48863)), ((x10.core.Rail)(t$48864)));
        
        //#line 1945 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        final x10.core.Rail t$48865 = ((x10.core.Rail)(A));
        
        //#line 1945 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        final x10.core.Rail t$48866 = ((x10.core.Rail)(B));
        
        //#line 1945 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        final x10.core.Rail t$48867 = ((x10.core.Rail)(Q));
        
        //#line 1945 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        final x10.core.Rail t$48868 = ((x10.core.Rail)(C));
        
        //#line 1945 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        final x10.core.Rail t$48869 = ((x10.core.Rail)(initialValue));
        
        //#line 1945 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        final x10.core.Rail t$48870 = plham.util.Matrix.ActiveSetMethod__0$1x10$lang$Rail$1x10$lang$Double$2$2__1$1x10$lang$Double$2__2$1x10$lang$Rail$1x10$lang$Double$2$2__3$1x10$lang$Double$2__4$1x10$lang$Double$2(((x10.core.Rail)(t$48865)), ((x10.core.Rail)(t$48866)), ((x10.core.Rail)(t$48867)), ((x10.core.Rail)(t$48868)), ((x10.core.Rail)(t$48869)));
        
        //#line 1945 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        initialValue = ((x10.core.Rail)(t$48870));
        
        //#line 1946 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        final x10.io.Printer t$48871 = ((x10.io.Printer)(x10.io.Console.get$OUT()));
        
        //#line 1946 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        t$48871.println(((java.lang.Object)("*answer")));
        
        //#line 1947 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        final x10.core.Rail t$48872 = ((x10.core.Rail)(initialValue));
        
        //#line 1947 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        plham.util.Matrix.dump__0$1x10$lang$Double$2(((x10.core.Rail)(t$48872)));
    }
    
    
    //#line 6 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
    final public plham.util.Matrix plham$util$Matrix$$this$plham$util$Matrix() {
        
        //#line 6 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
        return plham.util.Matrix.this;
    }
    
    
    //#line 6 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
    // creation method for java code (1-phase java constructor)
    public Matrix() {
        this((java.lang.System[]) null);
        plham$util$Matrix$$init$S();
    }
    
    // constructor for non-virtual call
    final public plham.util.Matrix plham$util$Matrix$$init$S() {
         {
            
            //#line 6 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            
            
            //#line 6 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
            this.__fieldInitializers_plham_util_Matrix();
        }
        return this;
    }
    
    
    
    //#line 6 "/home/dsl/workspace/plhamK/plham/util/Matrix.x10"
    final public void __fieldInitializers_plham_util_Matrix() {
        
    }
    
    final private static x10.core.concurrent.AtomicInteger initStatus$maxPositionSize = new x10.core.concurrent.AtomicInteger(x10.runtime.impl.java.InitDispatcher.UNINITIALIZED);
    private static x10.lang.ExceptionInInitializer exception$maxPositionSize;
    
    public static double get$epsilon() {
        return plham.util.Matrix.epsilon;
    }
    
    public static double get$epsilon2() {
        return plham.util.Matrix.epsilon2;
    }
    
    public static double get$epsilon3() {
        return plham.util.Matrix.epsilon3;
    }
    
    public static long get$maxPositionSize() {
        if (((int) plham.util.Matrix.initStatus$maxPositionSize.get()) == ((int) x10.runtime.impl.java.InitDispatcher.INITIALIZED)) {
            return plham.util.Matrix.maxPositionSize;
        }
        if (((int) plham.util.Matrix.initStatus$maxPositionSize.get()) == ((int) x10.runtime.impl.java.InitDispatcher.EXCEPTION_RAISED)) {
            if (((boolean) x10.runtime.impl.java.InitDispatcher.TRACE_STATIC_INIT) == ((boolean) true)) {
                x10.runtime.impl.java.InitDispatcher.printStaticInitMessage(((java.lang.String)("Rethrowing ExceptionInInitializer for field: plham.util.Matrix.maxPositionSize")));
            }
            throw plham.util.Matrix.exception$maxPositionSize;
        }
        if (plham.util.Matrix.initStatus$maxPositionSize.compareAndSet((int)(x10.runtime.impl.java.InitDispatcher.UNINITIALIZED), (int)(x10.runtime.impl.java.InitDispatcher.INITIALIZING))) {
            try {{
                plham.util.Matrix.maxPositionSize = x10.lang.Math.pow2$O((long)(50L));
            }}catch (java.lang.Throwable exc$51202) {
                plham.util.Matrix.exception$maxPositionSize = new x10.lang.ExceptionInInitializer(exc$51202);
                plham.util.Matrix.initStatus$maxPositionSize.set((int)(x10.runtime.impl.java.InitDispatcher.EXCEPTION_RAISED));
                x10.runtime.impl.java.InitDispatcher.lockInitialized();
                x10.runtime.impl.java.InitDispatcher.notifyInitialized();
                throw plham.util.Matrix.exception$maxPositionSize;
            }
            if (((boolean) x10.runtime.impl.java.InitDispatcher.TRACE_STATIC_INIT) == ((boolean) true)) {
                x10.runtime.impl.java.InitDispatcher.printStaticInitMessage(((java.lang.String)("Doing static initialization for field: plham.util.Matrix.maxPositionSize")));
            }
            plham.util.Matrix.initStatus$maxPositionSize.set((int)(x10.runtime.impl.java.InitDispatcher.INITIALIZED));
            x10.runtime.impl.java.InitDispatcher.lockInitialized();
            x10.runtime.impl.java.InitDispatcher.notifyInitialized();
        } else {
            if (plham.util.Matrix.initStatus$maxPositionSize.get() < x10.runtime.impl.java.InitDispatcher.INITIALIZED) {
                x10.runtime.impl.java.InitDispatcher.lockInitialized();
                while (plham.util.Matrix.initStatus$maxPositionSize.get() < x10.runtime.impl.java.InitDispatcher.INITIALIZED) {
                    x10.runtime.impl.java.InitDispatcher.awaitInitialized();
                }
                x10.runtime.impl.java.InitDispatcher.unlockInitialized();
                if (((int) plham.util.Matrix.initStatus$maxPositionSize.get()) == ((int) x10.runtime.impl.java.InitDispatcher.EXCEPTION_RAISED)) {
                    if (((boolean) x10.runtime.impl.java.InitDispatcher.TRACE_STATIC_INIT) == ((boolean) true)) {
                        x10.runtime.impl.java.InitDispatcher.printStaticInitMessage(((java.lang.String)("Rethrowing ExceptionInInitializer for field: plham.util.Matrix.maxPositionSize")));
                    }
                    throw plham.util.Matrix.exception$maxPositionSize;
                }
            }
        }
        return plham.util.Matrix.maxPositionSize;
    }
    
    public static long get$index() {
        return plham.util.Matrix.index;
    }
    
    public static long get$DEBUG() {
        return plham.util.Matrix.DEBUG;
    }
}

