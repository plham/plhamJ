package plham.core.model;

import plham.core.Order;

public class ComparatorLowersFirst implements PlhamComparator<Order> {
	private static final long serialVersionUID = 930716742485011396L;

	@Override
	public int compare(Order one, Order other) {
		// handle order type first.
		if (one.isMarketOrder() && other.isMarketOrder()) {
			return Long.compare(one.timePlaced, other.timePlaced);
		} else if (one.isMarketOrder()) {
			return -1;
		} else if (other.isMarketOrder()) {
			return +1;
		}

		if (one.price < other.price) {
			return -1;
		}
		if (one.price > other.price) {
			return +1;
		}
		if (one.timePlaced < other.timePlaced) {
			return -1;
		}
		if (one.timePlaced > other.timePlaced) {
			return +1;
		}
		return 0;
	}

}
