package plham.core.util;

import java.util.List;

import cassia.util.JSON;
import cassia.util.JSON.Value;
import handist.collections.Chunk;
import handist.collections.LongRange;
import handist.collections.RangedList;

public abstract class AllocManager<T> {

    public static class Centric<T> extends AllocManager<T> {

        private Chunk<T> list;

        /*
         * public def getBody() { return body; }
         */
        public List<T> getBody() {
            return list.toList();
        }

        public Chunk<T> getChunk() {
            return list;
        }

        @Override
        public RangedList<T> getRangedList(JSON.Value config, LongRange range) {
            assert list != null : "CentricAllocManager: body is null, setTotalCount has not called yet!";
            return list.subList(range);
        }

        @Override
        public void registerRange(Value config, LongRange range) {
        }

        @Override
        public void scanDone() {
        }

        @Override
        public void setTotalCount(long size) {
            this.list = new Chunk<>(new LongRange(0, size));
        }
        // TODO expand ...

        @Override
        public boolean use2scan() {
            return false;
        }

    }

    public abstract RangedList<T> getRangedList(JSON.Value config, LongRange range);

    public abstract void registerRange(JSON.Value config, LongRange range);

    public abstract void scanDone();

    public abstract void setTotalCount(long size);

    public abstract boolean use2scan();
}
