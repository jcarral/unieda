package student;

public class PruebaAlg2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	        int[][] matrix1 = { { 3, 6, 9, 12 }, { 4, 7, 11, 13 },
	                { 10, 11, 15, 17 }, { 12, 13, 19, 20 } },
	                matrix2 = {{3,6},{4,7}},
	                matrix3 = {{1}},
	                matrix4 = {{1, 3, 7},{3, 5, 9},{8, 10, 11}};
	         
	        System.out.println(Alg2D.indexOf(matrix1, 13)); //1,3
	        System.out.println(Alg2D.indexOf(matrix1, 17));  //2,3
	        System.out.println(Alg2D.indexOf(matrix1, 999)); //null
	        System.out.println(Alg2D.indexOf(matrix2, 7)); //1,1
	        System.out.println(Alg2D.indexOf(matrix3, 1)); //0,0
	        System.out.println(Alg2D.indexOf(matrix3, 9)); //null
	        System.out.println(Alg2D.indexOf(matrix4, 8)); 
	    
	}

}
