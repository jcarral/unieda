package student;
 
public class Alg2D {
 
    public static student.Tuple<Integer, Integer> indexOf(int[][] data, int x) {
        return indexOf(0, 0, data, x);
 
    }
 
    private static student.Tuple<Integer, Integer> indexOf(int x, int y, int[][] data, int e) {
		int i = x - 1, j = y - 1;
		do {
			if (i < data.length - 1)
				i++;
			if (j < data[0].length - 1)
				j++;
			if (data[i][j] == e)
				return new Tuple<Integer, Integer>(i, j);
			else if (data[i][j] > e) {
				Tuple<Integer, Integer> t = indexOf(0, j-1, data, e);
				if (t != null)
					return t;
				return indexOf(i-1, 0, data, e);
			}
		} while (i < data.length - 1 || j < data[0].length - 1);
		return null;
	}

    
}
 
class Tuple<T, E> {
    T posX;
    E posY;
 
    public Tuple(T x, E y) {
        posX = x;
        posY = y;
    }
 
    public String toString() {
 
        return "( " + posX + ", " + posY + " )";
    }
}