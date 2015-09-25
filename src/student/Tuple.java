package student;

public class Tuple<U, V> {
	private final int _1;
	private final int _2;

	public Tuple(int _1, int _2) {
		super();
		this._1 = _1;
		this._2 = _2;
	}

	public int _1() {
		return _1;
	}

	public int _2() {
		return _2;
	}

	@Override
	public String toString() {
		return "Tuple [_1=" + _1 + ", _2=" + _2 + "]";
	}
}
