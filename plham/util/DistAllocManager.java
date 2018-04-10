package plham.util;

import java.io.Serializable;

import x10.lang.LongRange;
import cassia.util.JSON;
import cassia.util.RangedList;

public abstract class DistAllocManager<T> implements Serializable {
	private static final long serialVersionUID = 3455039974789082437L;

	/*
	public abstract class DistAllocManager[T] {
	public abstract def getRangedList(Place, config:JSON.Value, LongRange): RangedList[T];
	public abstract def setTotalCount(size:Long): void;
	}
	 */
	public abstract RangedList<T> getRangedList(String place,
			JSON.Value config, LongRange range);

	public abstract void setTotalCount(long size);
}
