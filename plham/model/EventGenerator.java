package plham.model;

import java.io.Serializable;
import java.util.List;

import cassia.util.JSON;

/*
	public static type EventGenerator = (JSON.Value)=>List[JSON.Value];
 */
public interface EventGenerator extends Serializable {
	public List<JSON.Value> generate(JSON.Value json);
}