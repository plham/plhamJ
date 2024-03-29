package plham.core.util;

import java.util.List;

import cassia.util.JSON.Value;
import handist.collections.Chunk;
import handist.collections.ChunkedList;
import handist.collections.LongRange;
import handist.collections.RangedList;
import plham.core.Agent;
import plham.core.HighFrequencyAgent;
import plham.core.main.Simulator;
import plham.core.main.SimulatorFactory;

public abstract class AgentAllocManager {

    public static class Centric extends AgentAllocManager {
        public ChunkedList<Agent> all = new ChunkedList<>();
        private Chunk<Agent> list;

        @Override
        public void finalSetup(Simulator sim) {
            sim.agents = all;
            ChunkedList<Agent> arbs = new ChunkedList<>();
            ChunkedList<Agent> ords = new ChunkedList<>();
            sim.hifreqAgents = new ChunkedList<>();
            all.forEachChunk((RangedList<Agent> c) -> {
                if (c.get(c.getRange().from) instanceof HighFrequencyAgent) {
                    arbs.add(c);
                } else {
                    ords.add(c);
                }
            });
            sim.hifreqAgents = arbs;
            sim.normalAgents = ords;
        }

        public Chunk<Agent> getChunk() {
            return list;
        }

        /*
         * public def getBody() { return body; }
         */
        @Override
        public Iterable<Agent> getContainer() {
            return list;
        }

        public List<Agent> getList() {
            return list.toList();
        }

        @Override
        public RangedList<Agent> getRangedList(Value config, LongRange range, String name,
                SimulatorFactory simulatorFactory) {
            RangedList<Agent> result = list.subList(range);
            all.add(result);
            return result;
        }

        @Override
        public void registerRange(Value config, LongRange range, String name, SimulatorFactory simulatorFactory) {
        }

        @Override
        public void scanDone() {
        }

        @Override
        public void setTotalCount(long size) {
            list = new Chunk<>(new LongRange(0, size));
        }

        @Override
        public boolean use2scan() {
            return false;
        }

    }

    /**
     * process finalization process of agent allocation manager.
     *
     * @param sim
     */
    public abstract void finalSetup(Simulator sim);

    public abstract Iterable<Agent> getContainer();

    /**
     * prepare a ranged list for agents created by the config. The simulation factory generates agents in the ranged
     * list.
     *
     * @param config
     * @param range
     * @param name
     * @param simulatorFactory
     * @return
     */
    public abstract RangedList<Agent> getRangedList(Value config, LongRange range, String name,
            SimulatorFactory simulatorFactory);

    /**
     * Simulation factory tells the range for the agents created by the config. This method is only called when two scan
     * (use2scan()==true).
     *
     * @param config
     * @param range
     * @param name
     * @param simulatorFactory
     */
    public abstract void registerRange(Value config, LongRange range, String name, SimulatorFactory simulatorFactory);

    /**
     * This method tells that all the range of agents are already notified. This method is only called when two scan
     * (use2scan()==true).
     */
    public abstract void scanDone();

    /**
     * This method tells the total number of agents.
     *
     * @param size
     */
    public abstract void setTotalCount(long size);

    /**
     * returns whether the agent allocation manager needs two scan or not. When the allocation manager has to know the
     * ranges of respective agents, please use two scan (return `true` for this method).
     *
     * @return
     */
    public abstract boolean use2scan();
}
