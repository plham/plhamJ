package cassia.util;


@x10.runtime.impl.java.X10Generated
public interface RangedList<$T> extends x10.util.List, cassia.util.RangedCommon, x10.serialization.X10JavaSerializable
{
    public static final x10.rtt.RuntimeType<RangedList> $RTT = 
        x10.rtt.NamedType.<RangedList> make("cassia.util.RangedList",
                                            RangedList.class,
                                            1,
                                            new x10.rtt.Type[] {
                                                x10.rtt.ParameterizedType.make(x10.util.List.$RTT, x10.rtt.UnresolvedType.PARAM(0)),
                                                x10.rtt.ParameterizedType.make(cassia.util.RangedCommon.$RTT, x10.rtt.UnresolvedType.PARAM(0))
                                            });
    
    

    
    
    //#line 5 "/home/dsl/workspace/plhamK/cassia/util/RangedList.x10"
    cassia.util.RangedList subList(final long from, final long to);
}

