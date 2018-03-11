package cassia.util;


@x10.runtime.impl.java.X10Generated
public interface RangedCommon<$T> extends x10.core.Any
{
    public static final x10.rtt.RuntimeType<RangedCommon> $RTT = 
        x10.rtt.NamedType.<RangedCommon> make("cassia.util.RangedCommon",
                                              RangedCommon.class,
                                              1);
    
    

    
    
    //#line 5 "/home/dsl/workspace/plhamK/cassia/util/RangedCommon.x10"
    x10.lang.LongRange getRange();
    
    
    //#line 7 "/home/dsl/workspace/plhamK/cassia/util/RangedCommon.x10"
    void each$V(final x10.core.fun.VoidFun_0_1 op, x10.rtt.Type t1);
    
    
    //#line 8 "/home/dsl/workspace/plhamK/cassia/util/RangedCommon.x10"
    void each$V(final x10.lang.LongRange range, final x10.core.fun.VoidFun_0_1 op, x10.rtt.Type t1);
}

