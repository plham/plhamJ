package plham.model;

import java.io.Serializable;

public interface PlhamComparator<T> extends Serializable {
	public int compare(T one, T other);
}
