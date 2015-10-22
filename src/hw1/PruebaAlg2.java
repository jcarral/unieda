package hw1;

public class PruebaAlg2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	        int[][] matrix1 = { { 3, 6, 9, 12 }, { 4, 7, 11, 13 },
	                { 10, 11, 15, 17 }, { 12, 13, 19, 20 } },
	                matrix2 = {{3,6},{4,7}},
	                matrix3 = {{1}},
	                matrix4 = {{1, 3, 7},{3, 5, 9},{8, 10, 11}},
	                matrix5 = {{1, 5, 7, 9, 11}, {3, 8, 11, 13, 17}, {4, 12, 34, 47, 78}, {7, 13, 35, 53, 80}, {11, 45, 54, 67, 99}};
	         
	        System.out.println(Alg2D.indexOf(matrix1, 1)); //null
	        System.out.println(Alg2D.indexOf(matrix1, 17)); //2,3
	        System.out.println(Alg2D.indexOf(matrix1, 999)); //null
	        System.out.println(Alg2D.indexOf(matrix2, 7)); //1,1
	        System.out.println(Alg2D.indexOf(matrix3, 1)); //0,0
	        System.out.println(Alg2D.indexOf(matrix3, 9)); //null
	  
	        
	        //Matriz 5
	        System.out.println("\n\nMatriz 5x5");
	        System.out.println(Alg2D.indexOf(matrix5, 1)); 
	        System.out.println(Alg2D.indexOf(matrix5, 5));
	        System.out.println(Alg2D.indexOf(matrix5, 7));
	        System.out.println(Alg2D.indexOf(matrix5, 9));
	        System.out.println(Alg2D.indexOf(matrix5, 11));
	        System.out.println("");
	        
	        System.out.println(Alg2D.indexOf(matrix5, 3));
	        System.out.println(Alg2D.indexOf(matrix5, 8));
	        System.out.println(Alg2D.indexOf(matrix5, 11));
	        System.out.println(Alg2D.indexOf(matrix5, 13));
	        System.out.println(Alg2D.indexOf(matrix5, 17));
	        System.out.println("");
	        
	        System.out.println(Alg2D.indexOf(matrix5, 4));
	        System.out.println(Alg2D.indexOf(matrix5, 12));
	        System.out.println(Alg2D.indexOf(matrix5, 34));
	        System.out.println(Alg2D.indexOf(matrix5, 47));
	        System.out.println(Alg2D.indexOf(matrix5, 78));
	        System.out.println("");
	        
	        System.out.println(Alg2D.indexOf(matrix5, 7));
	        System.out.println(Alg2D.indexOf(matrix5, 13));
	        System.out.println(Alg2D.indexOf(matrix5, 35));
	        System.out.println(Alg2D.indexOf(matrix5, 53));
	        System.out.println(Alg2D.indexOf(matrix5, 80));
	        System.out.println("");
	        
	        System.out.println(Alg2D.indexOf(matrix5, 11));
	        if(Alg2D.indexOf(matrix5, 45) == null)
	        	System.out.println("Error");
	        else
	        	System.out.println(Alg2D.indexOf(matrix5, 45));
	        System.out.println(Alg2D.indexOf(matrix5, 54));
	        System.out.println(Alg2D.indexOf(matrix5, 67));
	        System.out.println(Alg2D.indexOf(matrix5, 99));
	        System.out.println("");
	        
	        System.out.println(Alg2D.indexOf(matrix5, 121));
	        
	        
	        
	        
	    
	}

}
