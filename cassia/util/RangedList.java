package cassia.util;

import java.util.List;

public interface RangedList<E> extends List<E>, RangedCommon<E> {
	RangedList<E> subList(long from, long to);
}
