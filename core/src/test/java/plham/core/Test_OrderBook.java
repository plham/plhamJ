package plham.core;

import org.junit.Test;

public class Test_OrderBook {

    @Test
    public void testOrderBook() {
        // This piece of code was taken from the OrderBook class
        // TODO port to Junit test to check correct ordering of orders
        /*
         * val agent = new TestAgent(0); val market = new Market(0); val book = new OrderBook(HIGHERS_FIRST); val
         * agentId = agent.id; book.add(new Order(Order.KIND_BUY_LIMIT_ORDER, agentId, market.id, 100.0, 10, 30, 1));
         * book.add(new Order(Order.KIND_BUY_LIMIT_ORDER, agentId, market.id, 50.0, 10, 30, 2)); book.add(new
         * Order(Order.KIND_BUY_LIMIT_ORDER, agentId, market.id, 50.0, 40, 30, 3)); book.add(new
         * Order(Order.KIND_BUY_LIMIT_ORDER, agentId, market.id, 100.0, 10, 30, 4)); book.add(new
         * Order(Order.KIND_BUY_LIMIT_ORDER, agentId, market.id, 70.0, 10, 30, 4));
         * 
         * Console.OUT.println("THE BEST: " + book.getBestOrder());
         * 
         * Console.OUT.println("LOWERS-FIRST"); book.dump(LOWERS_FIRST);
         * 
         * Console.OUT.println("HIGHERS-FIRST"); book.dump(HIGHERS_FIRST);
         * 
         */
    }
}
