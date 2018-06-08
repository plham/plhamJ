package plham.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import apgas.core.LongRange;
import cassia.util.JSON;
import cassia.util.RangedList;
import cassia.util.RangedListView;

public class CentricAllocManager<T> extends DistAllocManager<T> {
	private static final long serialVersionUID = -4363374140643632779L;

	/*
	private var body:List[T] = null;
	*/
	private List<T> body = null;

	/*
	public def this() {}
	*/
	public CentricAllocManager() {
		// do nothing
	}

	/*
	public def getRangedList(Place, config:JSON.Value, range: LongRange): RangedList[T] {
	    assert body != null: "CentricAllocManager: body is null, setTotalCount has not called yet!";
	return new RangedListView[T](body, range);
	}
	*/
	@Override
	public RangedList<T> getRangedList(String place, JSON.Value config,
			LongRange range) {
		assert body != null : "CentricAllocManager: body is null, setTotalCount has not called yet!";
		return new RangedListView<T>(body, range);
	}

	/*
	public def setTotalCount(size:Long) {
	    this.body = new ArrayList[T](size);
	}
	*/
	@Override
	public void setTotalCount(long size) {
		this.body = new ArrayList<T>((int) size);
		this.body.addAll(Collections.nCopies((int) size, (T) null));
	}

	/*
	public def getBody() { return body; }
	*/
	public List<T> getBody() {
		return body;
	}

}
