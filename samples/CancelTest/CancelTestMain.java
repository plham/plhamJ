package samples.CancelTest;


@x10.runtime.impl.java.X10Generated
public class CancelTestMain extends samples.CI2002.CI2002Main implements x10.serialization.X10JavaSerializable
{
    public static final x10.rtt.RuntimeType<CancelTestMain> $RTT = 
        x10.rtt.NamedType.<CancelTestMain> make("samples.CancelTest.CancelTestMain",
                                                CancelTestMain.class,
                                                new x10.rtt.Type[] {
                                                    samples.CI2002.CI2002Main.$RTT
                                                });
    
    public x10.rtt.RuntimeType<?> $getRTT() { return $RTT; }
    
    public x10.rtt.Type<?> $getParam(int i) { return null; }
    
    private Object writeReplace() throws java.io.ObjectStreamException {
        return new x10.serialization.SerializationProxy(this);
    }
    
    public static x10.serialization.X10JavaSerializable $_deserialize_body(samples.CancelTest.CancelTestMain $_obj, x10.serialization.X10JavaDeserializer $deserializer) throws java.io.IOException {
        if (x10.runtime.impl.java.Runtime.TRACE_SER) { x10.runtime.impl.java.Runtime.printTraceMessage("X10JavaSerializable: $_deserialize_body() of " + CancelTestMain.class + " calling"); } 
        samples.CI2002.CI2002Main.$_deserialize_body($_obj, $deserializer);
        return $_obj;
    }
    
    public static x10.serialization.X10JavaSerializable $_deserializer(x10.serialization.X10JavaDeserializer $deserializer) throws java.io.IOException {
        samples.CancelTest.CancelTestMain $_obj = new samples.CancelTest.CancelTestMain((java.lang.System[]) null);
        $deserializer.record_reference($_obj);
        return $_deserialize_body($_obj, $deserializer);
    }
    
    public void $_serialize(x10.serialization.X10JavaSerializer $serializer) throws java.io.IOException {
        super.$_serialize($serializer);
        
    }
    
    // constructor just for allocation
    public CancelTestMain(final java.lang.System[] $dummy) {
        super($dummy);
        
    }
    
    

    
    
    //#line 14 "samples/CancelTest/CancelTestMain.x10"
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
            CancelTestMain.main(args);
        }
    }
    
    // the original app-main method
    public static void main(final x10.core.Rail<java.lang.String> args) {
        
        //#line 15 "samples/CancelTest/CancelTestMain.x10"
        final samples.CancelTest.CancelTestMain sim = ((samples.CancelTest.CancelTestMain)(new samples.CancelTest.CancelTestMain((java.lang.System[]) null).samples$CancelTest$CancelTestMain$$init$S()));
        
        //#line 16 "samples/CancelTest/CancelTestMain.x10"
        samples.CancelTest.CancelFCNAgent.register(((plham.main.Simulator)(sim)));
        
        //#line 17 "samples/CancelTest/CancelTestMain.x10"
        final plham.main.SequentialRunner t$20091 = ((plham.main.SequentialRunner)(new plham.main.SequentialRunner<samples.CancelTest.CancelTestMain>((java.lang.System[]) null, samples.CancelTest.CancelTestMain.$RTT).plham$main$SequentialRunner$$init$S(sim, (plham.main.SequentialRunner.__0plham$main$SequentialRunner$$B) null)));
        
        //#line 17 "samples/CancelTest/CancelTestMain.x10"
        ((plham.main.Runner<samples.CancelTest.CancelTestMain>)t$20091).run__0$1x10$lang$String$2(((x10.core.Rail)(args)));
    }
    
    
    //#line 12 "samples/CancelTest/CancelTestMain.x10"
    final public samples.CancelTest.CancelTestMain samples$CancelTest$CancelTestMain$$this$samples$CancelTest$CancelTestMain() {
        
        //#line 12 "samples/CancelTest/CancelTestMain.x10"
        return samples.CancelTest.CancelTestMain.this;
    }
    
    
    //#line 12 "samples/CancelTest/CancelTestMain.x10"
    // creation method for java code (1-phase java constructor)
    public CancelTestMain() {
        this((java.lang.System[]) null);
        samples$CancelTest$CancelTestMain$$init$S();
    }
    
    // constructor for non-virtual call
    final public samples.CancelTest.CancelTestMain samples$CancelTest$CancelTestMain$$init$S() {
         {
            
            //#line 12 "samples/CancelTest/CancelTestMain.x10"
            /*super.*/samples$CI2002$CI2002Main$$init$S();
            
            //#line 12 "samples/CancelTest/CancelTestMain.x10"
            
            
            //#line 12 "samples/CancelTest/CancelTestMain.x10"
            this.__fieldInitializers_samples_CancelTest_CancelTestMain();
        }
        return this;
    }
    
    
    
    //#line 12 "samples/CancelTest/CancelTestMain.x10"
    final public void __fieldInitializers_samples_CancelTest_CancelTestMain() {
        
    }
}

