package plham.core.util;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.function.Function;

import handist.collections.Chunk;
import handist.collections.LongRange;
import handist.collections.RangedList;

/**
 * This generates a sequence of Randoms split from a given Random, and only allows sequential access to its elements.
 */

final public class RandomSequenceBySplit extends RangedList<Random> {
    public static class It implements Iterator<Random> {
        private RandomSequenceBySplit al;
        private long i;

        public It(RandomSequenceBySplit al) {
            this.al = al;
        }

        public void add(Random v) {
            throw new UnsupportedOperationException();
        }

        @Override
        public boolean hasNext() {
            return i + 1 < al.size();
        }

        public boolean hasPrevious() {
            return i - 1 >= 0;
        }

        @Override
        public Random next() {
            return al.get(++i);
        }

        public long nextIndex() {
            return ++i;
        }

        public Random previous() {
            return al.get(--i);
        }

        public long previousIndex() {
            return --i;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }

        public void set(Random v) {
            throw new UnsupportedOperationException();
        }

    }

    private Random current;
    private long index;

    private Random rand;

    public RandomSequenceBySplit(Random rand0) {
        rand = rand0;
        index = -1;
    }

    private RandomSequenceBySplit(RandomSequenceBySplit from) {
        rand = from.rand;
        index = from.index;
        current = from.current;
    }

    public void add(int arg0, Random arg1) {
        throw new UnsupportedOperationException();
    }

    public boolean add(Random arg0) {
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

    @Override
    public RandomSequenceBySplit clone() {
        return new RandomSequenceBySplit(this);
    }

    @Override
    public RangedList<Random> cloneRange(LongRange arg0) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean contains(Object arg0) {
        throw new UnsupportedOperationException();
    }

    public boolean contains(Random y) {
        throw new UnsupportedOperationException();
    }

    public boolean containsAll(List<Random> random) {
        throw new UnsupportedOperationException();
    }

    public Random get(int arg0) {
        return get((long) arg0);
    }

    @Override
    public Random get(long i) {
        assert i >= 0 : "RandomSequenceBySplit: arguments " + i + " is negative.";
        assert i >= index : "RandomSequenceBySplit: this only allows sequential access. You are accessing element No. "
                + i + ", while this already accessing No. " + index;
        Random r = null;
        if (i == index)
            return current;
        // if(i==index+1) { index++; return (current=rand.split());}
        while (i > index) {
            index++;
            r = rand.split();
        }
        return (current = r);
    }

    @Override
    public LongRange getRange() {
        return new LongRange(0, size());
    }

    public int indexOf(Object arg0) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public It iterator() {
        return new It(this);
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

    @Override
    public Random set(long arg0, Random arg1) {
        throw new UnsupportedOperationException();
    }

    @Override
    public <S> void setupFrom(RangedList<S> arg0, Function<? super S, ? extends Random> arg1) {
        throw new UnsupportedOperationException();
    }

    @Override
    public long size() {
        return Long.MAX_VALUE;
    }

    @Override
    public RangedList<Random> subList(long arg0, long arg1) {
        return this;
    }

    @Override
    public Object[] toArray() {
        throw new UnsupportedOperationException();
    }

    @Override
    public Object[] toArray(LongRange arg0) {
        throw new UnsupportedOperationException();
    }

    public <T> T[] toArray(T[] arg0) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Chunk<Random> toChunk(LongRange arg0) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<Random> toList(LongRange r) {
        throw new UnsupportedOperationException();
    }
}
