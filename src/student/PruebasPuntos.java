package student;

import ehu.RankListPunto2D;

public class PruebasPuntos {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 100000;
		cuadratico(n);
		logaritmico(n);
	}
	
	private static void cuadratico(int n){
		
		Punto2D[] pts = new Punto2D[n];
		long time_start, time_end;
		for(int i = 0; i<n; i++){
			int num1 = (int)Math.floor(Math.random()*(1-100)+100);
			int num2 = (int)Math.floor(Math.random()*(1-100)+100);
			pts[i] = new Punto2D(num1, num2);
		}
		time_start = System.currentTimeMillis();
		AlgPunto2D rp = new AlgPunto2D();
		int[] v = rp.compute(pts);
		time_end = System.currentTimeMillis();
		
		System.out.println("Tiempo empleado en cuadratico: " + (time_end - time_start));
		//for (int i = 0; i < n; i++) {
		//	System.out.println(v[i]);
		//}
		

	
	}
	private static void logaritmico(int n){
		
		Punto2D[] pts = new Punto2D[n];
/*
		pts[0] = new Punto2D(9, 9); // 5
		pts[1] = new Punto2D(4, 2); // 0
		pts[2] = new Punto2D(6, 8); // 3
		pts[3] = new Punto2D(7, 6); // 3
		pts[4] = new Punto2D(10, 1); // 0
		pts[5] = new Punto2D(5, 4); // 2
		pts[6] = new Punto2D(2, 3); // 0
		*/
		for(int i = 0; i<n; i++){
			int num1 = (int)Math.floor(Math.random()*(1-100)+100);
			int num2 = (int)Math.floor(Math.random()*(1-100)+100);
			pts[i] = new Punto2D(num1, num2);
		}
		long time_start, time_end;
		time_start = System.currentTimeMillis();
		RankListPunto2D rp = new RankListPunto2D();
		int[] v = rp.compute(pts);
		time_end = System.currentTimeMillis();
		System.out.println("Tiempo empleado en logaritmico: " + (time_end - time_start));

		//for (int i = 0; i < n; i++) {
		//	System.out.println(v[i]);		
//	}
	}
}
