package student;
 
public class Alg2D {
 
    public static student.Tuple<Integer, Integer> indexOf(int[][] data, int x) {
        return indexOf(0, 0, data, x);
 
    }
 
    private static student.Tuple<Integer, Integer> indexOf(int x, int y,
            int[][] data, int e) {
        int i = x, j = y;
 
        while (i <= data.length - 1 || j <= data[0].length - 1) {
 
            if (data[i][j] == e)
                return new Tuple<Integer, Integer>(i, j);
 
            if (data[i][j] > e) {
 
                Tuple<Integer, Integer> t = indexOf(0, j, data, e);
 
                if (t != null)
                    return t;
 
                return indexOf(i, 0, data, e);
 
            }
             
            if((i == j) && i == data.length-1)
                break;
            if (i < data.length - 1)
                i++;
            if (j < data[0].length - 1)
                j++;
             
        }
 
        return null;
    }
 
    // Tests
    public static void main(String[] args) {
        int[][] matrix1 = { { 3, 6, 9, 12 }, { 4, 7, 11, 13 },
                { 10, 11, 15, 17 }, { 12, 13, 19, 20 } },
                matrix2 = {{3,6},{4,7}},
                matrix3 = {{1}};
         
        System.out.println(indexOf(matrix1, 13)); //1,3
        System.out.println(indexOf(matrix1, 17));  //2,3
        System.out.println(indexOf(matrix1, 999)); //null
        System.out.println(indexOf(matrix2, 7)); //1,1
        System.out.println(indexOf(matrix3, 1)); //0,0
        System.out.println(indexOf(matrix3, 9)); //null
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