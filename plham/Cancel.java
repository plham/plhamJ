package plham;

/**
 * A cancel request of an order.
 *
 * <p>
 * Cancel is performed in terms of <code>Order</code>'s <code>agentId</code> and
 * <code>orderId</code>. When a cancel request is accepted, any orders having
 * the <code>agentId</code> and <code>orderId</code> will be cancelled. To be
 * cancelleable, the <code>orderId</code> must be &gt; 0 (which is 0 by
 * default). One (<code>Agent</code>) should assign a unique
 * <code>orderId</code> for each order if needed. The cancel behavior when using
 * the same <code>orderId</code> more than once is <i>undefined</i>.
 */
public class Cancel extends Order {
	private static final long serialVersionUID = 436708972539417642L;

	public Cancel(Order order) {
		super(order);
	}

}
