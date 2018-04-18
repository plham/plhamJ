package cassia.util.random;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import plham.util.Random;

/**
 * Knuth-Fisher-Yates shuffle. Reference:
 * http://en.wikipedia.org/wiki/Fisher-Yates_shuffle
 */
public class RandomPermutation<T> implements Iterable<T>, Serializable {
	private static final long serialVersionUID = -7930041204702780423L;

	/*
	public var array:List[T];
	public var random:Random;
	*/
	public List<T> array;
	public Random random;

	/*
	public def this(random:Random, array0:Indexed[T]) {
		this.random = random;
		this.array = new ArrayList[T]();
		this.array.addAll(array0);
	}
	*/

	public RandomPermutation(Random random, List<T> list) {
		this.random = random;
		this.array = new ArrayList<T>();
		this.array.addAll(list);
	}

	/*
	public def shuffle() {
		val size = this.array.size();
		for (var i:Long = size - 1; i > 0; i--) {
			val j = this.random.nextLong(i + 1);
			val temp = this.array(j);
			this.array(j) = this.array(i);
			this.array(i) = temp;
		}
	}
	*/
	public void shuffle() {
		int size = this.array.size();
		for (long i = size - 1; i > 0; i--) {
			long j = random.nextLong(i + 1);
			T temp = this.array.get((int) j);
			this.array.set((int) j, this.array.get((int) i));
			this.array.set((int) i, temp);
		}
	}

	/*
	public def iterator():Iterator[T] {
		return this.array.iterator();
	}
	*/
	public Iterator<T> iterator() {
		return this.array.iterator();
	}
	/*
	public def toString():String {
		return this.array.toString();
	}
	
	public static def main(Rail[String]) {
		val a = new ArrayList[Long]();
		a.add(1);
		a.add(2);
		a.add(3);
		a.add(100);
		a.add(999);
		
		val p = new RandomPermutation(new Random(), a); // MEMO: main()
		for (i in 0..10) {
			Console.OUT.println(p);
			p.shuffle();
		}
	}	 */

}
