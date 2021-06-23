package plham.samples.CI2002;

import plham.core.*;
import plham.core.main.SequentialRunner;
import plham.core.main.Simulator.Session;
import plham.core.main.SimulatorFactory;
import plham.core.util.Random;

import java.util.ArrayList;
import java.util.List;

public class NewCI2002MainForLogging extends SimulationOutput {
    public static class SubmissionLog {
        public static final double errors = 0.000001;
        private final long agentId;
        private final Random random;
        private final List<Order> orders;
        private final List<Double> mPrices;
        private final List<Double> mfPrices;

        public SubmissionLog(Agent a, List<Market> markets, List<Order> orders) {
            this.agentId = a.id;
            this.random = a.getRandom().copy();
            this.orders = new ArrayList<Order>();
            for(Order order: orders) {
                this.orders.add(new Order(order)); // clone
            }
            this.mPrices = new ArrayList<>(markets.size());
            this.mfPrices = new ArrayList<>(markets.size());
            markets.forEach((Market m)->{
                mPrices.add(m.getPrice());
                mfPrices.add(m.getFundamentalPrice());
            });
        }

        public boolean equals(Object o) {
            if(o instanceof SubmissionLog) {
                SubmissionLog target = (SubmissionLog) o;
                if(agentId != target.agentId) return false;
                if(!random.equals(target.random)) return false;
                if(orders.size()!=target.orders.size()) return false;
                for(int i = 0; i<orders.size(); i++) {
                    if(!orderEq(orders.get(i), target.orders.get(i))) return false;
                }
                for(int i=0; i< mPrices.size(); i++) {
                    if(Math.abs(mPrices.get(i) - target.mPrices.get(i)) > errors) return false;
                    if(Math.abs(mfPrices.get(i) - target.mfPrices.get(i)) > errors) return false;
                }
                return true;
            }
            return false;
        }
        public boolean orderEq(Order o1, Order o2) {
            return (Math.abs(o1.getPrice()-o2.getPrice()) < errors) && o1.isBuyOrder() == o2.isBuyOrder(); // && ....
        }
        public String toString() {
            if(orders.isEmpty())
                return "a:" + agentId + "->NO";
            else
                return "a:" + agentId + "->" + orders.get(0).marketId + "@" + orders.get(0).getPrice();
        }
    }
	/** Serial Version UID */
    private static final long serialVersionUID = 2493462616283426664L;

    public static void main(String[] args) {
		try {
			final NewCI2002MainForLogging sim = new NewCI2002MainForLogging();
			SimulatorFactory factory = new SimulatorFactory(args[0]);
			long seed;
			if (args.length > 1) {
				seed = Long.valueOf(args[1]);
			} else {
				seed = new Random().nextLong(Long.MAX_VALUE / 2); // MEMO: main()
			}

			final SequentialRunner runner = new SequentialRunner(factory, sim);
			runner.run(seed);
		} catch (Exception e) {
			e.printStackTrace();
			return;
		}
	}

    @Override
    public void marketOutput(OutputCollector out, SimulationStage stage, Market market) {
        long t = market.getTime();
        out.log("Market:" + market.id +":"+market.getTime(), String.format("%s %s %s %s %s %s ", t, market.id, market.name,
                market.getPrice(t), market.getFundamentalPrice(t), market.getRandom()));
    }

    @Override
    public void agentOutput(OutputCollector out, SimulationStage stage, Agent agent) {
        // out.log("Agent:"+agent.id, String.format("Agent %s %s ", agent.id, agent.toString()));
    }

    @Override
    public void sessionOutput(OutputCollector out, SimulationStage stage, Session s) {
        out.log("_SESSION_NAME_", s.sessionName);
    }

    @Override
    public void orderSubmissionOutput(OutputCollector out, SimulationStage stage, Agent a, List<Order> orders, List<Market> markets) {
        for(Order order: orders) {
            out.log("OrderSubmission:" + order.agentId + ":" + order.marketId +"@"+order.timePlaced, order.toString());
        }
    }
    
    @Override
    public void postProcess(OutputCollector output, SimulationStage stage) {
        /*
        switch (stage) {
        case WITH_PRINT_DURING_SESSION:
            // Here we combine the session name with the state of each market in a single line
            // First remove the session name from the "logs" Map
            String sessionName = (String) output.getLog("_SESSION_NAME_").get(0);
            // All remaining entries in the "logs" correspond to the markets taking part in the simulation
            break;
            default:
                // No grouped outputs in all other stages
        }
         */
    }
}
