package cassia.util;

import java.io.Serializable;
import java.util.List;

public interface SortedQueue<T> extends Serializable, Iterable<T> {
	/*

	public def push(x:T):Boolean;

	public def pop():T;

	public def peek():T;

	public def add(x:T):Boolean;

	public def remove(x:T):Boolean;

	public def removeAllWhere(p:(T)=>Boolean):Boolean;

	public def size():Long;

	public def contains(x:T):Boolean;

	public def iterator():Iterator[T];

	public def toList():List[T];
	 */
	public boolean push(T x);

	public T pop();

	public T peed();

	public boolean add(T x);

	public boolean remove(T x);

	public boolean removeAllWhere(T p);

	public long size();

	public boolean contains(T x);

	public List<T> toList();
}
