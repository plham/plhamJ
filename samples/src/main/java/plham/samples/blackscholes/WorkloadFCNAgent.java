package plham.samples.blackscholes;

import java.util.ArrayList;
import java.util.List;

import cassia.util.JSON;
import plham.core.Agent;
import plham.core.Market;
import plham.core.Order;
import plham.core.agent.FCNAgent;
import plham.core.main.SimulatorFactory;
import plham.core.model.AgentInitializer;
import plham.core.util.Random;

/**
 * An Agent class mimicking the burden of Monte Carlo simulations,
 * currently by solving the Black-Scholes equation.
 * @author Kamada
 */
public class WorkloadFCNAgent extends FCNAgent {

    /** Serial Version UID */
    private static final long serialVersionUID = 4669890119339329983L;

    boolean hasWorkload;
    /** Countdown until 0 where the workload will be tuned off, set negative to disable (set by default) */
    long workLoadShutdown;
    long bsNSamples;
    long bsNSteps;
    double bsSum;
    double orderRate;

    public static void register(SimulatorFactory sim) {
        String className = "WorkloadFCNAgent";
        sim.addAgentInitializer(className, new AgentInitializer() {
            /** Serial Version UID */
            private static final long serialVersionUID = -2286430372167712705L;

            @Override
            public Agent initialize(long id, String name, Random random, JSON.Value json) {
                return new WorkloadFCNAgent(id, name, random).setup(json, sim);
            }
        });
    }

    public WorkloadFCNAgent(long id, String name, Random r) {
        super(id, name, r);
    }

    public WorkloadFCNAgent setup(JSON.Value json, SimulatorFactory sim) {
        super.setup(json, sim);

        hasWorkload = Boolean.parseBoolean(json.getOrElse("BS_WORKLOAD", "false").toString());
        workLoadShutdown = Long.parseLong(json.getOrElse("BS_LOAD_SHUTDOWN", "-1").toString());
        bsNSamples = Long.parseLong(json.getOrElse("BS_NSAMPLES", "0").toString());
        bsNSteps = Long.parseLong(json.getOrElse("BS_NSTEPS", "0").toString());
        orderRate = Double.parseDouble(json.getOrElse("ORDER_RATE", "0.1").toString());

        return this;
    }

    @Override
    public List<Order> submitOrders(List<Market> markets) {
        if (!isMarketAccessible(markets.get(0))) {
            return new ArrayList<>();
        }

        if (hasWorkload) {
            if (0 < workLoadShutdown) {
                workLoadShutdown--;
                if (0 == workLoadShutdown) {
                    hasWorkload = false;
                }
            }
            BlackScholes bs = new BlackScholes(getRandom(), 100.0, 100.0, 0.1, 0.3, 3);
            double price = bs.compute(bsNSamples, bsNSteps);
            bsSum += price;
        }

        // Randomly submit (or not) based on a random variable
        if (getRandom().nextDouble() > orderRate) {
            return new ArrayList<>();
        }

        return super.submitOrders(markets);
    }
}
