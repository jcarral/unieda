package student;

public class Alg2D {

	public static student.Tuple<Integer, Integer> indexOf(int[][] data, int x){
		
		for(int i = 0; i<data.length; i++){
			if(data[i][i] <= x && data[i+1][i+1] >=  x){
				return buscar(i, data, x);
			}
		}
	}
	
	private static int[][] buscar(int pos, int[][] data, int x){
		for(int i = pos; i< data[pos].length; i++){
			if(data[pos][i] == x){
				int[][] mat = {{pos}, {i}};
				return mat;
			}
		}
		for(int i = 0; i< pos; i++){
			if(data[pos+1][i] == x){
				int[][] mat = {{pos+1}, {i}};
				return mat;
			}
		}
		return null;
	}
}
