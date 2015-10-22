package test01;

import hw1.AlgPunto2D;
import hw1.Punto2D;

public class Test01_0_compute_y extends Test01_0_compute_abstract {
	@Override
	public Function newAlg() {
		return new Function() {
			@Override
			public int[] apply(Punto2D[] points) {
				return new AlgPunto2D().compute_y(points);
			}
		};
	}
}
