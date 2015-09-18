package test01;

import student.AlgPunto2D;
import student.Punto2D;

public class Test01_0_compute_x extends Test01_0_compute_abstract {
	@Override
	public Function newAlg() {
		return new Function() {
			@Override
			public int[] apply(Punto2D[] points) {
				return new AlgPunto2D().compute_x(points);
			}
		};
	}
}
