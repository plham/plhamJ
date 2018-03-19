package cassia.util;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.stream.LongStream;

import x10.lang.LongRange;

public class RangedListView<T> implements Serializable {
	/*
public class RangedListView [T](base:List[T],range:LongRange) implements RangedList[T]{
	 */

	private List<T> base;
	private LongRange range;
	public RangedListView(List<T> base, LongRange range) {
		this.base = base;
		this.range= range;
	}
	/*
	public static def emptyView[T]() =  new RangedListView[T](null, 0..-1);
	 */
	public static RangedListView emptyView = new RangedListView(null, 0, -1);
	/*
	public def getRange() = range;
	 */
	public LongRange getRange(LongRange range) {
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
	public boolean contains(T v) {
		for(long l : range) {
		    T elem = base.get((int)l);	// TODO:int
	        if (v == null ? elem == null : v.equals(elem)) {
	            return true;
	        }
	    return false;
	}
		/*
		public def containsAll(vs: Container[T]): Boolean {
		for(v in vs) if(!contains(v)) return false;
		return true;
		 */
		public boolean containsAll(Collection<T> vs) {
			for(T v vs) {
				if(!contains(v)) return false;
			}
					return true;
			
		}
		
		public long indexOf(T v) {
			indexOf(range.min, v);
		}
		
		public long indexOf(long index, T v) {
			for(long l : range) {
		        if (v==null ? base(i)==null : v.equals(base(i)))
		        	return i;
			}
		    return -1;
		}
		
		public long lastIndexOf(T x) {
			return indexOf(range.max,v);
		}
		
		public long lastIndexOf(long index, T v) {
		    for (long i = index;; i>=range.min; i--) {
		        if (v==null ? base(i)==null : v.equals(base(i)))
		        	return i;
		    }
		    return -1;
		}
		
		public void clear() {
			throw new UnsupportedOperationException();
		}
		public Collection<T> clone() {
			throw new UnsupportedOperationException();
		}
		
		public long last() {
			return range.max;
		}
		
		public boolean add(T v) {
			throw new UnsupportedOperationException();
		}
		public boolean addBefore(T v) {
			throw new UnsupportedOperationException();
		}
		public boolean addAll(T elems) {
			throw new UnsupportedOperationException();
		}
		public boolean remove(T v) {
			throw new UnsupportedOperationException();
		}
		public boolean retainAll(Collection<T> vs) {
			throw new UnsupportedOperationException();
		}
		public boolean removeAll(Collection<T> vs) {
			throw new UnsupportedOperationException();
		}
		public boolean addAllWhere(Collection<T> vs, Object o) {
			throw new UnsupportedOperationException();
		}
		public boolen removeAllWhere(Object o) {
			throw new UnsupportedOperationException();
			}
		public T getFirst() {
	return 		base(range.min);
		}
		public T getLast() {
			return base(range.max);
		}
		
		public T removeAt(long l) {
			throw new UnsupportedOperationException();
		}
		public T removeFirst(){
			throw new UnsupportedOperationException();
		}
		public T removeLast(){
			throw new UnsupportedOperationException();
		}
		
		public T set(T v, long i0) {
			base.set((int)i0, v);	//TODO:int
					return v;
		}
		public T get(long i0) {
			return base.get((int)i0);	//TODO:int
		}
		
		public long size() {
			return range.max-range.min+1;
		}
		public boolean isEmpty() {
			return range.max<range.min;
		}
		public List<Long> indices() {
			List<Long> results = new ArrayList<Long>();
			for(long i : range) {
			result.add(i);	
			}
					return result;
		}

		public void reverse() {
			throw new UnsupportedOperationException();
		}
		public void sort() { throw new UnsupportedOperationException();} 
		public int sort(Comparable<T> c) { throw new UnsupportedOperationException();} 

private  class It<S>  implements Iterator<S> {
	private List<S> base;
	LongRange range;
    public It(List<S> base, LongRange range) {
    	this.base = base;
    	this.range = range;
    }
    private long i = range.min-1;
    
    public boolean hasNext() {
        return i+1 <= range.max;
    }
    public S next() {
        return base.get((int)++i);	// TODO:int
    }
    public long nextIndex()  {
        return ++i;
    }

    public boolean hasPrevious() {
        return i -1 >= range.min;
    }

    public long previousIndex() {
        return (--i);
    }
    
    public S previous()  {
        return base.get((int)--i);	// TODO:int
    }
    
    public void remove()  {
    throw new UnsupportedOperationException();
    }
    
    public void set( S v) {
        base.set((int)i,  v);	// TODO:int
    }
    
    public void add(S v)  {
    throw new UnsupportedOperationException();
    }
}

public Iterator<T> iterator() {
    return new It<T>(this.base,this.range);
}
public Iterator<T> iteratorFrom(long index) {
	long[] a = LongStream.rangeClosed(Math.max(range.min,index), range.max).toArray();
	return new It<>T>(this.base, a);
}
public RangedList<T> subList(long fromIndex, long toIndex) {
return new RangedListView[T](base, Math.max(fromIndex,range.min)..Math.min(toIndex,range.max));
}

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





		/*
public operator this(i: Long): T = base(i); 
public operator this(i: Long)=(v: T) : T = set(v,i);
*/


/**
 * Return the string representation of this Chunk.
 * 
 * @return the string representation of this Chunk.
 */
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
{
    
    
}

