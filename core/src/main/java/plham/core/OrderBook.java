package plham.core;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.function.Predicate;

import plham.core.model.PlhamComparator;

/**
 * A class for orderbooks for continuous double action mechanism. Orders are arranged in the price/time priority basis.
 * Use HIGHERS_FIRST for buy side; Use LOWERS_FIRST for sell side.
 */

public class OrderBook implements Serializable {
    /**
     * @deprecated Consider using a {@link Predicate<Order>} instead
     */
    @Deprecated
    public interface RemoveAllWhere {
        boolean check(Order order);
    }

    /**
     * @deprecated Consider using a {@link Predicate<Order>} instead
     */
    @Deprecated
    public interface RemoveAllWhereFromQueue {
        boolean check(Order order);
    }

    private static final long serialVersionUID = 721205462405952627L;

    public static void dump(Collection<Order> orders, long time) {
        for (Order order : orders) {
            System.out.println(String.format("%s %s %s %s %s %s   ", "#BOOK", time, order.kind, order.marketId,
                    order.price, order.volume));
        }
    }

    protected static String getKey(long agentId, long orderId) {
        return agentId + ":" + orderId;
    }

    protected static String getKey(Order order) {
        return getKey(order.agentId, order.orderId);

    }

    protected Set<String> cancelCache = new HashSet<>();

    public PriorityQueue<Order> queue;

    private Time time;

    public OrderBook(PlhamComparator<Order> comparator) {
        queue = new PriorityQueue<>(comparator);
    }

    public void add(Order order) {
        queue.add(order);
    }

    public void cancel(Order order) {
        assert order.orderId > 0 : "Cancel requests must have orderId > 0";
        if (order.orderId > 0) {
            cancelCache.add(OrderBook.getKey(order));
        }
    }

    public void dump() {
        dump(queue, getTime());
    }

    public Order getBestOrder() {
        popUntil();
        if (queue.size() > 0) {
            return queue.peek();
        }
        return null;
    }

    public double getBestPrice() {
        popUntil();
        if (queue.size() > 0) {
            return queue.peek().getPrice();
        }
        return Double.NaN;
    }

    protected long getTime() {
        if (time == null) {
            return 0;
        }
        return time.t;
    }

    public boolean isCancelled(Order order) {
        return cancelCache.contains(OrderBook.getKey(order));
    }

    protected void popUntil() {
        long t = getTime();
        while (queue.size() > 0) {
            Order order = queue.peek();
            if (order.isExpired(t) || isCancelled(order)) {
                queue.remove();
                cancelCache.remove(OrderBook.getKey(order));
            } else {
                break;
            }
        }
    }

    public void remove(Order order) {
        if (queue.remove(order)) {
            cancelCache.remove(OrderBook.getKey(order));
        }
    }

    /**
     * Removes all Orders from this OrderBook which satisfy the predicate given as parameter, that is, if applying the
     * provided lambda expression on the orders contained by this instance returns true. The "removed" {@link Order}
     * instances will be placed
     *
     * @param condition the condition under which an Order should be removed
     * @return {@code true} if at least one Order was removed during this method, {@code false otherwise}
     */
    public synchronized boolean removeAllWhere(Predicate<Order> condition) {
//        System.err.println("size:" + queue.size()); // FIXME For debug purposes, don't forget to remove 

        // Old code located below
//        int size = queue.size();
//        Order[] orders = queue.toArray(new Order[size]);
//        LinkedList<Order> list = new LinkedList<>(queue);
//        for (int i = 0; i < orders.length; i++) {
//            Order order = orders[i];
//            if (condition.test(order)) {
//                cancelCache.remove(getKey(order));
//                Order last = list.removeLast();
//                list.addLast((Order) null);
//                if (i < queue.size()) {
//                    list.set(i, last);
//                }
//            }
//        }
//
//        queue.clear();
//        for (Order order : list) {
//            if (null != order) {
//                queue.add(order);
//            }
//        }
//
//        return queue.size() < size;

        boolean removed = false;
        Iterator<Order> it = queue.iterator();
        while (it.hasNext()) {
            if (condition.test(it.next())) {
                it.remove();
                removed = true;
            }
        }
        cancelCache.clear();
        return removed;
    }

    /**
     * @deprecated consider using {@link #removeAllWhere(Predicate)} instead
     */
    @Deprecated
    public synchronized boolean removeAllWhere(RemoveAllWhere p) {
        int size = queue.size();
        Order[] orders = queue.toArray(new Order[size]);
        LinkedList<Order> list = new LinkedList<>(queue);
        for (int i = 0; i < orders.length; i++) {
            Order order = orders[i];
            boolean b = p.check(order);
            if (b) {
                cancelCache.remove(OrderBook.getKey(order));
                Order last = list.removeLast();
                list.addLast((Order) null);
                if (i < queue.size()) {
                    list.set(i, last);
                }
            }
        }
        queue.clear();
        for (Order order : list) {
            if (null != order) {
                queue.add(order);
            }
        }
        return queue.size() < size;
    }

    protected void setTime(Time time) {
        this.time = time;
    }

    public long size() {
        popUntil();
        return queue.size();
    }

}
