package cassia.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import apgas.core.LongRange;

public class RangedListView<T> extends ArrayList<T> implements RangedList<T> {
	private static final long serialVersionUID = 5144877061214880343L;
	/*
	public class RangedListView [T](base:List[T],range:LongRange) implements RangedList[T]{
	 */
	private List<T> base;
	private LongRange range;

	public RangedListView(List<T> base, LongRange range) {
		this.base = base;
		this.range = range;
	}

	/*
	public static def emptyView[T]() =  new RangedListView[T](null, 0..-1);
	 */
	public static RangedListView<Object> emptyView = new RangedListView<Object>(
			null, new LongRange(0, 0));

	/*
	public def getRange() = range;
	 */
	public LongRange getRange() {
		return this.range;
	}

	/*
	public def contains(v: T): Boolean {
	for (i in range) {
	    val elem = base(i);
	        if (v == null ? elem == null : v.equals(elem)) {
	            return true;
	        }
	}
	    return false;
	}
	 */
	@Override
	public boolean contains(Object v) {
		for (long i = range.from; i < range.to; i++) {
			T elem = base.get((int) i);
			if (v == null ? elem == null : v.equals(elem)) {
				return true;
			}
		}
		return false;
	}

	/*
	public def containsAll(vs: Container[T]): Boolean {
	for(v in vs) if(!contains(v)) return false;
	return true;
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public boolean containsAll(Collection vs) {
		for (Object v : vs) {
			if (!contains(v))
				return false;
		}
		return true;

	}

	/*
	public def indexOf(v: T): Long {
	return indexOf(range.min,v);
	}
	 */
	@Override
	@SuppressWarnings("unchecked")
	public int indexOf(Object v) {
		return indexOf(range.from, (T) v);
	}

	/*
	public def indexOf(index: Long, v: T): Long {
	    for (i in range) {
	        if (v==null ? base(i)==null : v.equals(base(i)))
	        	return i;
	    }
	    return -1;
	}
	 */
	public int indexOf(long index, T v) {
		for (long i = index; i < range.to; i++) {
			if (v == null ? base.get((int) i) == null : v.equals(base
					.get((int) i))) {
				return (int) i;
			}
		}
		return -1;
	}

	/*
	public def lastIndexOf(v: T): Long {
	return indexOf(range.max,v);
	}
	 */
	@Override
	@SuppressWarnings("unchecked")
	public int lastIndexOf(Object v) {
		return indexOf(range.to-1, (T) v);
	}

	/*
	public def lastIndexOf(index: Long, v: T): Long {
	    for (var i:Long=index; i>=range.min; i--) {
	        if (v==null ? base(i)==null : v.equals(base(i)))
	        	return i;
	    }
	    return -1;
	}
	 */
	public long lastIndexOf(long index, T v) {
		for (long i = index; i >= range.from; i--) {
			if (v == null ? base.get((int) i) == null : v.equals(base
					.get((int) i)))
				return i;
		}
		return -1;
	}

	/*

	public def clear(): void {
	throw new UnsupportedOperationException();
	}

	public def clone(): Collection[T] {
	throw new UnsupportedOperationException();
	}
	public def last() {
	return range.max;
	}
	public def add(v: T): Boolean {
	throw new UnsupportedOperationException();
	}
	public def addBefore(i:Long, v: T) {
	throw new UnsupportedOperationException();
	}


	public def addAll(elems:Container[T]):Boolean {
	throw new UnsupportedOperationException();
	}
	public def remove(v: T): Boolean {
	throw new UnsupportedOperationException();
	}
	public def retainAll(vs: Container[T]):Boolean {
	throw new UnsupportedOperationException();
	}
	public def removeAll(vs: Container[T]):Boolean {
	throw new UnsupportedOperationException();
	}
	public def addAllWhere(c: Container[T], p:(T)=>Boolean):Boolean {
	throw new UnsupportedOperationException();
	}
	public def removeAllWhere(p:(T)=>Boolean):Boolean {
	throw new UnsupportedOperationException();
	}

	public def getFirst(): T  = base(range.min);
	public def getLast(): T  = base(range.max);

	public def removeAt(i0: Long): T {
	throw new UnsupportedOperationException();
	}

	public def removeFirst(): T {
	throw new UnsupportedOperationException();
	}
	public def removeLast(): T {
	throw new UnsupportedOperationException();
	}
	 */
	@Override
	public void clear() {
		throw new UnsupportedOperationException();
	}

	@Override
	public Collection<T> clone() {
		throw new UnsupportedOperationException();
	}

	public long last() {
		return range.to-1;
	}

	@Override
	public boolean add(Object v) {
		throw new UnsupportedOperationException();
	}

	@SuppressWarnings("unused")
	public boolean addBefore(T v) {
		throw new UnsupportedOperationException();
	}

	@SuppressWarnings("unused")
	public boolean addAll(T elems) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean remove(Object v) {
		throw new UnsupportedOperationException();
	}

	@Override
	@SuppressWarnings({ "rawtypes" })
	public boolean retainAll(Collection vs) {
		throw new UnsupportedOperationException();
	}

	@Override
	@SuppressWarnings({ "rawtypes" })
	public boolean removeAll(Collection vs) {
		throw new UnsupportedOperationException();
	}

	@SuppressWarnings("unused")
	public boolean addAllWhere(Collection<T> vs, Object o) {
		throw new UnsupportedOperationException();
	}

	@SuppressWarnings({ "static-method", "unused" })
	public boolean removeAllWhere(Object o) {
		throw new UnsupportedOperationException();
	}

	/*
	public def getFirst(): T  = base(range.min);
	 */
	public T getFirst() {
		return base.get((int) range.from);
	}

	/*
	public def getLast(): T  = base(range.max);
	 */
	public T getLast() {
		return base.get((int) (range.to-1));
	}

	/*

	public def removeAt(i0: Long): T {
	throw new UnsupportedOperationException();
	}

	public def removeFirst(): T {
	throw new UnsupportedOperationException();
	}
	public def removeLast(): T {
	throw new UnsupportedOperationException();
	}
	 */
	@SuppressWarnings("unused")
	public T removeAt(long l) {
		throw new UnsupportedOperationException();
	}

	public T removeFirst() {
		throw new UnsupportedOperationException();
	}

	public T removeLast() {
		throw new UnsupportedOperationException();
	}

	/*
	public operator this(i: Long)=(v: T) : T = set(v,i);
	*/
	@Override
	public T set(int i, T v) {
		base.set(i, v);
		return v;
	}

	public void set(long i, T v) {
		base.set((int) i, v);
	}

	/*
	public def set(v: T, i0: Long): T {
	    base(i0) = v;
	    return v;
	}
	 */
	public T set(T v, long i) {
		base.set((int) i, v);
		return v;
	}

	/*
	public operator this(i: Long): T = base(i); 
	public def get(i0: Long): T {
	return base(i0);
	}
	 */
	public T get(long i) {
		return base.get((int) i);
	}

	/*
	public def size(): Long = range.max-range.min+1;
	 */
	@Override
	public int size() {
		return (int) (range.to - range.from);
	}

	/*
	public def isEmpty(): Boolean = range.max<range.min; 
	 */
	@Override
	public boolean isEmpty() {
		return (range.to <= range.from);
	}

	/*
	public def indices(): List[Long] {
	val result = new ArrayList[Long]();
	for(i in range) result.add(i);
	return result;
	}
	 */
	public List<Long> indices() {
		List<Long> results = new ArrayList<Long>();
		for (long i = range.from; i < range.to; i++) {
			results.add(i);
		}
		return results;
	}

	/*
	public def reverse() {
	throw new UnsupportedOperationException();
	}
	public def sort() { throw new UnsupportedOperationException();} 
	public def sort(cmp:(T,T)=>Int) { throw new UnsupportedOperationException();} 
	 */
	@SuppressWarnings("static-method")
	public void reverse() {
		throw new UnsupportedOperationException();
	}

	@SuppressWarnings("static-method")
	public void sort() {
		throw new UnsupportedOperationException();
	}

	@SuppressWarnings("unused")
	public int sort(Comparable<T> c) {
		throw new UnsupportedOperationException();
	}

	/*
	private static class It[S] (base:List[S], range:LongRange)implements ListIterator[S] {
	    
	    private var i: Long = range.min-1; // offset inside the chunk
	    
	    public def hasNext(): Boolean {
	        return i+1 <= range.max;
	    }
	    public def next(): S {
	        return base(++i);
	    }
	    public def nextIndex(): Long {
	        return ++i;
	    }

	    public def hasPrevious(): Boolean {
	        return i -1 >= range.min;
	    }

	    public def previousIndex(): Long {
	        return (--i);
	    }
	    
	    public def previous(): S {
	        return base(--i);
	    }
	    
	    public def remove(): void {
	    throw new UnsupportedOperationException();
	    }
	    
	    public def set(v: S): void {
	        base(i) = v;
	    }
	    
	    public def add(v: S): void {
	    throw new UnsupportedOperationException();
	    }
	}
	 */
	@SuppressWarnings("hiding")
	private class It<S> implements Iterator<S> {
		private List<S> base;
		LongRange range;

		public It(List<S> base, LongRange range) {
			this.base = base;
			this.range = range;
		}

		private long i = range.from - 1;

		public boolean hasNext() {
			return i + 1 < range.to;
		}

		public S next() {
			return base.get((int) ++i);
		}

		@SuppressWarnings("unused")
		public long nextIndex() {
			return ++i;
		}

		@SuppressWarnings("unused")
		public boolean hasPrevious() {
			return i - 1 >= range.from;
		}

		@SuppressWarnings("unused")
		public long previousIndex() {
			return (--i);
		}

		@SuppressWarnings("unused")
		public S previous() {
			return base.get((int) --i);
		}

		public void remove() {
			throw new UnsupportedOperationException();
		}

		@SuppressWarnings("unused")
		public void set(S v) {
			base.set((int) i, v);
		}

		@SuppressWarnings("unused")
		public void add(S v) {
			throw new UnsupportedOperationException();
		}
	}

	/*
	public def iterator(): ListIterator[T] {
	    return new It[T](this.base,this.range);
	}
	*/
	@Override
	public Iterator<T> iterator() {
		return new It<T>(this.base, this.range);
	}

	/*
	public def iteratorFrom(index:Long): ListIterator[T] {
	    return new It[T](this.base, Math.max(range.min,index)..range.max);
	}
	*/
	public Iterator<T> iteratorFrom(long index) {
		return new It<T>(this.base, new LongRange(Math.max(range.from, index),
				range.to));
	}

	/*
	public def subList(fromIndex:Long, toIndex:Long): RangedList[T] {
	return new RangedListView[T](base, Math.max(fromIndex,range.min)..Math.min(toIndex,range.max));
	}
	*/
	public RangedList<T> subList(long fromIndex, long toIndex) {
		return new RangedListView<T>(base, new LongRange(Math.max(fromIndex,
				range.from), Math.min(toIndex, range.to)));
	}

	/*
	public def each(op: (T)=>void) {
	if(base instanceof RangedList[T]) {
	    (base as RangedList[T]).each(this.range, op);
	} else {
	    for(i in this.range) {
		op(base(i));
	    }
	}
	}
	public def each(range:LongRange, op: (T)=>void) {
	if(base instanceof RangedList[T]) {
	    (base as RangedList[T]).each(Math.max(range.min,this.range.min)..Math.min(range.max,this.range.max), op);
	} else {
	    for(i in Math.max(range.min,this.range.min)..Math.min(range.max,this.range.max)) {
		op(base(i));
	    }
	}
	}
	
	public def each[U](op: (T,Receiver[U])=>void, receiver: Receiver[U]) {
	val op2 = (t:T)=>{ op(t,receiver); };
	each(this.range, op2);
	}
	public def each[U](range:LongRange, op: (T,Receiver[U])=>void, receiver: Receiver[U]) {
	val op2 = (t:T)=>{ op(t,receiver); };
	each(this.range, op2);
	}
	*/

	/*
	public def toString(): String {
	    val sb = new x10.util.StringBuilder();
	    sb.add("["+range+":");
	    val sz = Math.min(size(), 10);
	    for (i in range) {
	        if (i > 0) sb.add(",");
	        sb.add("" + this(i));
	    }
	    if (sz < size()) sb.add("...(omitted " + (size() - sz) + " elements)");
	    sb.add("@" + range.min + ".."+last()+"]");
	    return sb.toString();
	}

	public static def main(args:Rail[String]) {
	    val i = 10;
	    val c = new Chunk[Long]((10*i)..(11*i-1));
	    Console.OUT.println("prepare:"+c);
	    for(j in 0..(i-1)) {
	        Console.OUT.println("set@"+(10*i+j));
	        c(10*i+j) = 100*i+10*j;
	    }
	    Console.OUT.println("Chunk :"+ c);
	    val r1 = c.subList(10*i+0, 10*i+2);
	    val r2 = c.subList(10*i+2, 10*i+8);
	    val r3 = c.subList(10*i+8, 10*i+9);
	    val r0 = c.subList(10*i+0, 10*i+9);
	    Console.OUT.println("RangedListView :" + r1);
	    Console.OUT.println("RangedListView :" + r2);
	    Console.OUT.println("RangedListView :" + r3);
	    Console.OUT.println("RangedListView :" + r0);
	}
	 */

}
