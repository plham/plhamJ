package plham.util;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * This generates a sequence of Randoms split from a given Random, and only
 * allows sequential access to its elements.
 */

final public class RandomSequenceBySplit implements List<Random> {
	/*
	val rand:Random;
	var index:Long;
	var current:Random;
	*/
	private Random rand;
	private long index;
	private Random current;

	/*
	public def this(rand0: Random) {
	    this.rand = rand0;
	this.index = -1;
	}
	*/
	public RandomSequenceBySplit(Random rand0) {
		this.rand = rand0;
		this.index = -1;
	}

	/*
	private def this(from:RandomSequenceBySplit) {
	this.rand = from.rand;
	this.index = from.index;
	this.current = from.current;
	}
	*/
	private RandomSequenceBySplit(RandomSequenceBySplit from) {
		this.rand = from.rand;
		this.index = from.index;
		this.current = from.current;
	}

	/*
	public @Inline operator this(i: Long): Random {
	assert i>= 0: "RandomSequenceBySplit: arguments " + i + " is negative.";
	assert i>= index: "RandomSequenceBySplit: this only allows sequential access. You are accessing element No. " + i + ", while this already accessing No. " + index;
	var r:Random = null;
	if(i==index) return current;
	//	if(i==index+1) { index++; return (current=rand.split());}
	while(i>index) {
	    this.index++;
	    r=rand.split();
	}
	return (current=r);
	}
	*/
	public Random get(long i) {
		assert i >= 0 : "RandomSequenceBySplit: arguments " + i
				+ " is negative.";
		assert i >= index : "RandomSequenceBySplit: this only allows sequential access. You are accessing element No. "
				+ i + ", while this already accessing No. " + index;
		Random r = null;
		if (i == index)
			return current;
		// if(i==index+1) { index++; return (current=rand.split());}
		while (i > index) {
			this.index++;
			r = rand.split();
		}
		return (current = r);
	}

	/*
	public def size() = index+10000;
	*/
	public int size() {
		return (int) index + 10000;
	}

	/*
	public def isEmpty() = false;
	*/
	public boolean isEmpty() {
		return false;
	}

	/*
	public def contains(y:Random):Boolean {
	throw new UnsupportedOperationException();
	}
	*/
	@SuppressWarnings({ "unused", "static-method" })
	public boolean contains(Random y) {
		throw new UnsupportedOperationException();
	}

	/*
	public def containsAll(y:x10.util.Container[Random]):Boolean {
	throw new UnsupportedOperationException();
	}
	*/
	@SuppressWarnings({ "unused", "static-method" })
	public boolean containsAll(List<Random> random) {
		throw new UnsupportedOperationException();
	}

	/*
	public def clone() {
	return new RandomSequenceBySplit(this);
	}
	*/
	@Override
	public RandomSequenceBySplit clone() {
		return new RandomSequenceBySplit(this);
	}

	/*
	private static class It implements ListIterator[Random] {
	    
	    private var i: Long;
	    private val al: RandomSequenceBySplit;
	    
	    def this(al: RandomSequenceBySplit) {
	    this.al = al;
	    }

	    
	    public def hasNext(): Boolean {
	        return i+1 < al.size();
	    }

	    public def nextIndex(): Long {
	        return ++i;
	    }
	    
	    public def next(): Random {
	        return al(++i);
	    }

	    public def hasPrevious(): Boolean {
	        return i-1 >= 0;
	    }

	    public def previousIndex(): Long {
	        return --i;
	    }
	    
	    public def previous(): Random {
	        return al(--i);
	    }
	    
	    public def remove(): void {
	    throw new UnsupportedOperationException();
	    }
	    
	    public def set(v: Random): void {
	    throw new UnsupportedOperationException();
	    }
	    
	    public def add(v: Random): void {
	    throw new UnsupportedOperationException();
	    }
	}
	public def iterator() = new It(this);
	*/
	public static class It implements Iterator<Random> {
		private long i;
		private RandomSequenceBySplit al;

		public It(RandomSequenceBySplit al) {
			this.al = al;
		}

		public boolean hasNext() {
			return i + 1 < al.size();
		}

		public long nextIndex() {
			return ++i;
		}

		public Random next() {
			return al.get(++i);
		}

		public boolean hasPrevious() {
			return i - 1 >= 0;
		}

		public long previousIndex() {
			return --i;
		}

		public Random previous() {
			return al.get(--i);
		}

		public void remove() {
			throw new UnsupportedOperationException();
		}

		@SuppressWarnings({ "unused", "static-method" })
		public void set(Random v) {
			throw new UnsupportedOperationException();
		}

		@SuppressWarnings({ "unused", "static-method" })
		public void add(Random v) {
			throw new UnsupportedOperationException();
		}

	}

	public It iterator() {
		return new It(this);
	}

	public boolean add(Random arg0) {
		throw new UnsupportedOperationException();
	}

	public void add(int arg0, Random arg1) {
		throw new UnsupportedOperationException();
	}

	public boolean addAll(Collection<? extends Random> arg0) {
		throw new UnsupportedOperationException();
	}

	public boolean addAll(int arg0, Collection<? extends Random> arg1) {
		throw new UnsupportedOperationException();
	}

	public void clear() {
		throw new UnsupportedOperationException();
	}

	public boolean contains(Object arg0) {
		throw new UnsupportedOperationException();
	}

	public boolean containsAll(Collection<?> arg0) {
		throw new UnsupportedOperationException();
	}

	public Random get(int arg0) {
		return get((long)arg0);
	}

	public int indexOf(Object arg0) {
		throw new UnsupportedOperationException();
	}

	public int lastIndexOf(Object arg0) {
		throw new UnsupportedOperationException();
	}

	public ListIterator<Random> listIterator() {
		throw new UnsupportedOperationException();
	}

	public ListIterator<Random> listIterator(int arg0) {
		throw new UnsupportedOperationException();
	}

	public boolean remove(Object arg0) {
		throw new UnsupportedOperationException();
	}

	public Random remove(int arg0) {
		throw new UnsupportedOperationException();
	}

	public boolean removeAll(Collection<?> arg0) {
		throw new UnsupportedOperationException();
	}

	public boolean retainAll(Collection<?> arg0) {
		throw new UnsupportedOperationException();
	}

	public Random set(int arg0, Random arg1) {
		throw new UnsupportedOperationException();
	}

	public List<Random> subList(int arg0, int arg1) {
		throw new UnsupportedOperationException();
	}

	public Object[] toArray() {
		throw new UnsupportedOperationException();
	}

	public <T> T[] toArray(T[] arg0) {
		throw new UnsupportedOperationException();
	}

	/*
	public static def main(args:Rail[String]):void {
	val seed = 194327;
	val size = Long.parse(args(0));//*10000*10;
	val time = System.currentTimeMillis(); 
	val rgen = new Random(seed);
	val rgen2 = new Random(seed);
	val rx = new RandomSequenceBySplit(rgen2);
	var sum0:Long = 0L;
	var sum1:Long = 0L;
	
	for(i in 0..size) {
	    //	    val r = rgen.split();
	    //val r2 = rgen2(i);
	    val r2 = rx(i);
	    sum0+= r2.nextLong();
	}
	val diff = System.currentTimeMillis() -time; 
	Console.OUT.println("time:" + diff + ", for "+ size);

	val t2 = System.currentTimeMillis(); 
	for(i in 0..size) {
	    val r = rgen.split();
	    sum1+= r.nextLong();
	}
	val diff2 = System.currentTimeMillis() -t2; 
	Console.OUT.println("timeX:" + diff2+ ", for "+ size + ", diff" + (sum0-sum1));

	}
	*/
}
