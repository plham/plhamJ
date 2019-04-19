package cassia.util;

import apgas.core.LongRange;
import apgas.core.LongRange;

public interface RangedCommon<T> {
	/*
	public def getRange():LongRange;

	public def each(op: (T)=>void):void;
	public def each(range:LongRange, op: (T)=>void):void;
	 */
	public LongRange getRange();
}
