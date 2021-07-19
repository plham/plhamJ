package cassia.util.random;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import plham.core.util.Random;

/**
 * Knuth-Fisher-Yates shuffle. Reference:
 * <a href= "http://en.wikipedia.org/wiki/Fisher-Yates_shuffle">http://en.wikipedia.org/wiki/Fisher-Yates_shuffle</a>
 */
public class RandomPermutation<T> implements Iterable<T>, Serializable {
    private static final long serialVersionUID = -7930041204702780423L;

    public List<T> array;
    public Random random;

    public RandomPermutation(Random random, Iterable<T> list) {
        this.random = random;
        this.array = new ArrayList<>();
        for (T t : list) {
            this.array.add(t);
        }
    }

    @Override
    public Iterator<T> iterator() {
        return this.array.iterator();
    }

    public void shuffle() {
        int size = this.array.size();
        for (int i = size - 1; i > 0; i--) {
            // FIXME: the following is redundant, but we keep the code for result
            // compatibility.
            int j = (int) random.nextLong(i + 1);
            T temp = this.array.get(j);
            this.array.set(j, this.array.get(i));
            this.array.set(i, temp);
        }
    }

    @Override
    public String toString() {
        return this.array.toString();
    }
}
