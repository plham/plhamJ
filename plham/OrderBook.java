package plham;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Set;

import plham.model.PlhamComparator;

/**
 * A class for orderbooks for continuous double action mechanism. Orders are
 * arranged in the price/time priority basis. Use HIGHERS_FIRST for buy side;
 * Use LOWERS_FIRST for sell side.
 */

public class OrderBook implements Serializable {
	private static final long serialVersionUID = 721205462405952627L;
	/*
	public var queue:SortedQueue[Order];
	public var time:Time;
	protected var cancelCache:Set[Key] = new HashSet[Key](); // Poor implimentation.
	*/
	public PriorityQueue<Order> queue;
	private Time time;
	protected Set<String> cancelCache = new HashSet<String>();

	/*
	public def this(comparator:(Order,Order)=>Int) {
		this.queue = new HeapQueue[Order](comparator);
	}
	*/
	public OrderBook(PlhamComparator<Order> comparator) {
		this.queue = new PriorityQueue<Order>(comparator);
	}

	/*
	protected def setTime(time:Time) {
		this.time = time;
	}
	*/
	protected void setTime(Time time) {
		this.time = time;
	}

	/*
	protected def getTime():Long {
		if (this.time == null) {
			return 0;
		}
		return this.time.t;
	}
	*/

	protected long getTime() {
		if (this.time == null) {
			return 0;
		}
		return this.time.t;
	}

	/*
	protected def popUntil() {
		val t = this.getTime();
		val q = this.queue;
		val n = q.size();
		while (q.size() > 0) {
			val order = q.peek();
			if (order.isExpired(t) || isCancelled(order)) {
				q.pop();
				cancelCache.remove(new Key(order));
			} else {
				break;
			}
		}
		//if (n - q.size() > 0) Console.OUT.println("#OrderBook#popUntil: " + (n - q.size()) + " were popped");
	}
	*/

	protected void popUntil() {
		long t = this.getTime();
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

	/*
	public def size():Long {
		this.popUntil();
		return this.queue.size();
	}
	*/

	public long size() {
		this.popUntil();
		return this.queue.size();
	}

	/*
	public def add(order:Order) {
		this.queue.add(order);
	}
	*/
	public void add(Order order) {
		this.queue.add(order);
	}

	/*
	public def remove(order:Order) {
		if (this.queue.remove(order)) {
			cancelCache.remove(new Key(order));
		}
	}
	*/
	public void remove(Order order) {
		if (this.queue.remove(order)) {
			cancelCache.remove(OrderBook.getKey(order));
		}
	}

	/*
	public def getBestOrder():Order {
		this.popUntil();
		if (this.queue.size() > 0) {
			return this.queue.peek();
		}
		return null;
	}
	*/
	public Order getBestOrder() {
		this.popUntil();
		if (this.queue.size() > 0) {
			return this.queue.peek();
		}
		return null;
	}

	/*
	public def removeAllWhere(p:(Order)=>Boolean):Boolean {
		//for (o in this.queue) { if (isCancelled(o)) Console.OUT.println("#isCancelled but isInQueue " + o); }
		val f = (order:Order) => { // A wrapper
			val b = p(order);
			if (b) cancelCache.remove(new Key(order));
			return b;
		};
		return this.queue.removeAllWhere(f);
	}
	*/
	/* from HeapQueue.x10
	public def removeAllWhere(p:(T)=>Boolean):Boolean {
		val a = this.heap;
		val n = a.size();
		var i:Long = 0;
		while (i < a.size()) {
			if (p(a(i))) {
				val last = a.removeLast();
				if (i < a.size()) {
					a(i) = last;
				}
			} else {
				i++;
			}
		}
		if (i < n) {
			heapify();
		}
		return i < n;
	}
	 */
	public interface RemoveAllWhere {
		public boolean check(Order order);
	}

	public interface RemoveAllWhereFromQueue {
		public boolean check(Order order);
	}

	public synchronized boolean removeAllWhere(RemoveAllWhere p) {
		long size = this.queue.size();
		Order[] orders = this.queue.toArray(new Order[(int) size]);
		LinkedList<Order> list = new LinkedList<Order>(this.queue);
		for (int i = 0; i < orders.length; i++) {
			Order order = orders[i];
			boolean b = p.check(order);
			if (b) {
				cancelCache.remove(OrderBook.getKey(order));
				Order last = list.removeLast();
				list.addLast((Order) null);
				if (i < this.queue.size()) {
					list.set(i, last);
				}
			}
		}
		this.queue.clear();
		for (Order order : list) {
			if (null != order) {
				this.queue.add(order);
			}
		}
		return this.queue.size() < size;
	}

	/*
	public def getBestPrice():Double {
		this.popUntil();
		if (this.queue.size() > 0) {
			return this.queue.peek().getPrice();
		}
		return Double.NaN;
	}
	*/
	public double getBestPrice() {
		this.popUntil();
		if (this.queue.size() > 0) {
			return this.queue.peek().getPrice();
		}
		return Double.NaN;
	}

	/*
	public def cancel(order:Order) {
		assert order.orderId > 0 : "Cancel requests must have orderId > 0";
		if (order.orderId > 0) {
			cancelCache.add(new Key(order));
			//Console.OUT.println("#OrderBook#cancel: " + order);
		}
	}
	*/
	public void cancel(Order order) {
		assert order.orderId > 0 : "Cancel requests must have orderId > 0";
		if (order.orderId > 0) {
			cancelCache.add(OrderBook.getKey(order));
		}
	}

	/*
	public def isCancelled(order:Order):Boolean = cancelCache.contains(new Key(order));
	*/
	public boolean isCancelled(Order order) {
		return cancelCache.contains(OrderBook.getKey(order));
	}

	/*
	public static LOWERS_FIRST = (one:Order, other:Order) => {
		if (one.price < other.price) {
			return -1n;
		}
		if (one.price > other.price) {
			return +1n;
		}
		if (one.timePlaced < other.timePlaced) {
			return -1n;
		}
		if (one.timePlaced > other.timePlaced) {
			return +1n;
		}
		return 0n;
	};
	
	public static HIGHERS_FIRST = (one:Order, other:Order) => {
		if (one.price > other.price) {
			return -1n;
		}
		if (one.price < other.price) {
			return +1n;
		}
		if (one.timePlaced < other.timePlaced) {
			return -1n;
		}
		if (one.timePlaced > other.timePlaced) {
			return +1n;
		}
		return 0n;
	};
	
	=> 別クラスに移動
	 */

	/*
	protected static struct Key {

		val agentId:Long;
		val orderId:Long;

		def this(order:Order) {
			this(order.agentId, order.orderId);
		}

		def this(agentId:Long, orderId:Long) {
			this.agentId = agentId;
			this.orderId = orderId;
		}
	}
	*/
	protected static String getKey(Order order) {
		return getKey(order.agentId, order.orderId);

	}

	protected static String getKey(long agentId, long orderId) {
		return agentId + ":" + orderId;
	}

	/*
	public static def dump(it:Iterator[Order], time:Long) {
		while (it.hasNext()) {
			val order = it.next();
			Console.OUT.println(StringUtil.formatArray([
				"#BOOK", time, order.kind.id, order.marketId, order.price, order.volume,
				"", ""], " ", "", Int.MAX_VALUE));
		}
	}
	*/
	/*
	public static def dump(orders:List[Order], time:Long) {
		dump(orders.iterator(), time);
	}
	*/
	public static void dump(Collection<Order> orders, long time) {
		for (Order order : orders) {
			System.out.println(String
					.format("%s %s %s %s %s %s   ", "#BOOK", time, order.kind,
							order.marketId, order.price, order.volume));

		}

	}

	/*

	public def dump() {
		dump(this.queue.iterator(), this.getTime());
	}
	*/
	public void dump() {
		dump(this.queue, this.getTime());
	}
	/*

	public def dump(comparator:(Order,Order)=>Int) {
		val orders = this.toList(comparator);
		dump(orders, this.getTime());
	}
	*/
	/*
	public def toList():List[Order] {
		return this.queue.toList();
	}

	public def toList(comparator:(Order,Order)=>Int):List[Order] {
		val orders = this.toList();
		orders.sort(comparator);
		return orders;
	}

	public static def main(Rail[String]) {
		val agent = new TestAgent(0);
		val market = new Market(0);
		val book = new OrderBook(HIGHERS_FIRST);
		val agentId = agent.id;
		book.add(new Order(Order.KIND_BUY_LIMIT_ORDER, agentId, market.id, 100.0, 10, 30, 1));
		book.add(new Order(Order.KIND_BUY_LIMIT_ORDER, agentId, market.id, 50.0, 10, 30, 2));
		book.add(new Order(Order.KIND_BUY_LIMIT_ORDER, agentId, market.id, 50.0, 40, 30, 3));
		book.add(new Order(Order.KIND_BUY_LIMIT_ORDER, agentId, market.id, 100.0, 10, 30, 4));
		book.add(new Order(Order.KIND_BUY_LIMIT_ORDER, agentId, market.id, 70.0, 10, 30, 4));

		Console.OUT.println("THE BEST: " + book.getBestOrder());

		Console.OUT.println("LOWERS-FIRST");
		book.dump(LOWERS_FIRST);

		Console.OUT.println("HIGHERS-FIRST");
		book.dump(HIGHERS_FIRST);
	}
	 */

}
