package cassia.util;

public interface Receiver<T> {
	/*
	public def receive(value: T): void;
	public def close(): void;
	*/
	public void receive(T x);

	public void close();
}
