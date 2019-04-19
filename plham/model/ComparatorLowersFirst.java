package plham.model;

import plham.Order;

public class ComparatorLowersFirst implements PlhamComparator<Order> {
	private static final long serialVersionUID = 930716742485011396L;

	public int compare(Order one, Order other) {
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
