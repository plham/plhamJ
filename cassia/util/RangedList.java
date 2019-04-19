package cassia.util;

import java.util.List;

/*
public interface RangedList[T] extends List[T], RangedCommon[T] {
    public def subList(from:Long,to:Long): RangedList[T];
}
*/
public interface RangedList<E> extends List<E>, RangedCommon<E> {
	RangedList<E> subList(long from, long to);
}
