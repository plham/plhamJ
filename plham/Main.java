package plham;


/**
 * The base class for user-defined <q>main</q> classes.
 * See the <code>samples</code> to know how to extend this class.
 */
@x10.runtime.impl.java.X10Generated
public class Main extends plham.main.Simulator implements x10.serialization.X10JavaSerializable
{
    public static final x10.rtt.RuntimeType<Main> $RTT = 
        x10.rtt.NamedType.<Main> make("plham.Main",
                                      Main.class,
                                      new x10.rtt.Type[] {
                                          plham.main.Simulator.$RTT
                                      });
    
    public x10.rtt.RuntimeType<?> $getRTT() { return $RTT; }
    
    public x10.rtt.Type<?> $getParam(int i) { return null; }
    
    private Object writeReplace() throws java.io.ObjectStreamException {
        return new x10.serialization.SerializationProxy(this);
    }
    
    public static x10.serialization.X10JavaSerializable $_deserialize_body(plham.Main $_obj, x10.serialization.X10JavaDeserializer $deserializer) throws java.io.IOException {
        if (x10.runtime.impl.java.Runtime.TRACE_SER) { x10.runtime.impl.java.Runtime.printTraceMessage("X10JavaSerializable: $_deserialize_body() of " + Main.class + " calling"); } 
        plham.main.Simulator.$_deserialize_body($_obj, $deserializer);
        return $_obj;
    }
    
    public static x10.serialization.X10JavaSerializable $_deserializer(x10.serialization.X10JavaDeserializer $deserializer) throws java.io.IOException {
        plham.Main $_obj = new plham.Main((java.lang.System[]) null);
        $deserializer.record_reference($_obj);
        return $_deserialize_body($_obj, $deserializer);
    }
    
    public void $_serialize(x10.serialization.X10JavaSerializer $serializer) throws java.io.IOException {
        super.$_serialize($serializer);
        
    }
    
    // constructor just for allocation
    public Main(final java.lang.System[] $dummy) {
        super($dummy);
        
    }
    
    

    
    
    //#line 15 "/home/dsl/workspace/plhamK/plham/Main.x10"
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
            Main.main(args);
        }
    }
    
    // the original app-main method
    public static void main(final x10.core.Rail<java.lang.String> args) {
        
        //#line 16 "/home/dsl/workspace/plhamK/plham/Main.x10"
        final plham.Main sim = ((new plham.Main((java.lang.System[]) null).plham$Main$$init$S()));
        
        //#line 17 "/home/dsl/workspace/plhamK/plham/Main.x10"
        final plham.main.SequentialRunner t$22421 = ((new plham.main.SequentialRunner<plham.Main>((java.lang.System[]) null, plham.Main.$RTT).init(((sim)), (plham.main.SequentialRunner.sequentialRunner) null)));
        
        //#line 17 "/home/dsl/workspace/plhamK/plham/Main.x10"
        ((plham.main.Runner<plham.Main>)t$22421).run(((args)));
    }
    
    
    //#line 29 "/home/dsl/workspace/plhamK/plham/Main.x10"
    /**
	 * Called at the beginning of the simulation (before the first session).
	 */
    public void beginSimulation() {
        
    }
    
    
    //#line 34 "/home/dsl/workspace/plhamK/plham/Main.x10"
    /**
	 * Called at the end of the simulation (after the last session).
	 */
    public void endSimulation() {
        
    }
    
    
    //#line 40 "/home/dsl/workspace/plhamK/plham/Main.x10"
    /**
	 * Called at the beginning of every session.
	 * @param sessionName
	 */
    public void beginSession(final java.lang.String sessionName) {
        
    }
    
    
    //#line 46 "/home/dsl/workspace/plhamK/plham/Main.x10"
    /**
	 * Called at the end of every session.
	 * @param sessionName
	 */
    public void endSession(final java.lang.String sessionName) {
        
    }
    
    
    //#line 48 "/home/dsl/workspace/plhamK/plham/Main.x10"
    public void endprint(final java.lang.String sessionName, final long iterationSteps) {
        
    }
    
    
    //#line 57 "/home/dsl/workspace/plhamK/plham/Main.x10"
    /**
	 * Override this to configure the standard outputs of the simulation.
	 * Called in the middle of every step of sessions.
	 * @param sessionName
	 */
    public void print(final java.lang.String sessionName) {
        
        //#line 58 "/home/dsl/workspace/plhamK/plham/Main.x10"
        final x10.util.List t$22422 = this.getMarketsByName((("markets")));
        
        //#line 58 "/home/dsl/workspace/plhamK/plham/Main.x10"
        final x10.util.List markets = (t$22422);
        
        //#line 59 "/home/dsl/workspace/plhamK/plham/Main.x10"
        final x10.util.ListIterator market$22443 = (((x10.util.List<plham.Market>)markets).iterator());
        
        //#line 59 "/home/dsl/workspace/plhamK/plham/Main.x10"
        for (;
             true;
             ) {
            
            //#line 59 "/home/dsl/workspace/plhamK/plham/Main.x10"
            final boolean t$22444 = ((x10.util.ListIterator<plham.Market>)market$22443).hasNext$O();
            
            //#line 59 "/home/dsl/workspace/plhamK/plham/Main.x10"
            if (!(t$22444)) {
                
                //#line 59 "/home/dsl/workspace/plhamK/plham/Main.x10"
                break;
            }
            
            //#line 59 "/home/dsl/workspace/plhamK/plham/Main.x10"
            final plham.Market market$22433 = ((((x10.util.ListIterator<plham.Market>)market$22443).next$G()));
            
            //#line 60 "/home/dsl/workspace/plhamK/plham/Main.x10"
            final long t$22434 = market$22433.getTime$O();
            
            //#line 61 "/home/dsl/workspace/plhamK/plham/Main.x10"
            final x10.io.Printer t$22435 = ((x10.io.Console.get$OUT()));
            
            //#line 64 "/home/dsl/workspace/plhamK/plham/Main.x10"
            final long t$22436 = market$22433.id;
            
            //#line 65 "/home/dsl/workspace/plhamK/plham/Main.x10"
            final java.lang.String t$22437 = ((market$22433.name));
            
            //#line 66 "/home/dsl/workspace/plhamK/plham/Main.x10"
            final double t$22438 = market$22433.getPrice$O((t$22434));
            
            //#line 67 "/home/dsl/workspace/plhamK/plham/Main.x10"
            final double t$22439 = market$22433.getFundamentalPrice((t$22434));
            
            //#line 61 "/home/dsl/workspace/plhamK/plham/Main.x10"
            final x10.core.Rail t$22440 = ((x10.runtime.impl.java.ArrayUtils.<java.lang.Object> makeRailFromJavaArray(x10.rtt.Types.ANY, new java.lang.Object[] {sessionName, t$22434, t$22436, t$22437, t$22438, t$22439, "", ""})));
            
            //#line 68 "/home/dsl/workspace/plhamK/plham/Main.x10"
            final int t$22441 = java.lang.Integer.MAX_VALUE;
            
            //#line 61 "/home/dsl/workspace/plhamK/plham/Main.x10"
            final java.lang.String t$22442 = x10.util.StringUtil.<java.lang.Object> formatArray__0$1x10$util$StringUtil$$T$2(x10.rtt.Types.ANY, ((t$22440)), ((" ")), (("")), (t$22441));
            
            //#line 61 "/home/dsl/workspace/plhamK/plham/Main.x10"
            t$22435.println(((t$22442)));
        }
    }
    
    
    //#line 13 "/home/dsl/workspace/plhamK/plham/Main.x10"
    final public plham.Main plham$Main$$this$plham$Main() {
        
        //#line 13 "/home/dsl/workspace/plhamK/plham/Main.x10"
        return plham.Main.this;
    }
    
    
    //#line 13 "/home/dsl/workspace/plhamK/plham/Main.x10"
    // creation method for java code (1-phase java constructor)
    public Main() {
        this((java.lang.System[]) null);
        plham$Main$$init$S();
    }
    
    // constructor for non-virtual call
    final public plham.Main plham$Main$$init$S() {
         {
            
            //#line 13 "/home/dsl/workspace/plhamK/plham/Main.x10"
            /*super.*/plham$main$Simulator$$init$S();
            
            //#line 13 "/home/dsl/workspace/plhamK/plham/Main.x10"
            
            
            //#line 13 "/home/dsl/workspace/plhamK/plham/Main.x10"
            this.__fieldInitializers_plham_Main();
        }
        return this;
    }
    
    
    
    //#line 13 "/home/dsl/workspace/plhamK/plham/Main.x10"
    final public void __fieldInitializers_plham_Main() {
        
    }
}

