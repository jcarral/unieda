package student;
 
public class Alg2D {
 
    public static student.Tuple<Integer, Integer> indexOf(int[][] data, int x) {
    	
        return indexOf(new Tuple<Integer, Integer>(0,0), new Tuple<Integer, Integer>(data.length-1, data[0].length-1), data, x);
 
    }
 
    private static student.Tuple<Integer, Integer> indexOf(Tuple<Integer, Integer> inicio, Tuple<Integer, Integer> fin, int[][] data, int e) {
		int i = inicio._1() - 1, j = inicio._2() - 1;
		int limiteX = fin._1() ;
		int limiteY = fin._2();
		
		//El elemento e no está en la submatriz porque no puede estar fuera de rango, fin de la ejecucion
		if(limiteX<0 || limiteY<0)
			return null;
		do {//Bucle para recorrer la diagonal
			if (i < limiteX)
				i++;
			if (j < limiteY)
				j++;
			if (data[i][j] == e) //Si encuentra el elemento e devuelve la posicion
				return new Tuple<Integer, Integer>(i, j);
			
			else if (data[i][j] > e) { //Se divide la matriz en dos submatrices candidatas
				//Analiza la submatriz de la izquierda
				Tuple<Integer, Integer> t = indexOf(new Tuple<Integer, Integer>(i, inicio._2()), new Tuple<Integer, Integer>(fin._1(), j-1), data, e); //Por la izquierda
				if (t != null) //Si ha encontrado en la anterior la respuesta correcta se acaba el programa
					return t;
				//Analiza la submatriz de la derecha
				return indexOf(new Tuple<Integer, Integer>(inicio._1(), j), new Tuple<Integer, Integer>(i-1, fin._2()), data, e); //Por la derecha
			}
			
		} while (i < limiteX && j < limiteY);
		
		//Si llega al final de la diagonal y aún hay submatrices
		//Para matrices no cuadradas
		if (i == limiteX && j == limiteY)
			return null; //FIN, no está dentro de esta submatriz
		else if (i< limiteX)
			return indexOf(new Tuple<Integer, Integer>(i+1, inicio._2()), fin, data, e); //Analiza la submatriz de la izquierda
		else
			return indexOf(new Tuple<Integer, Integer>(inicio._1(), j+1), fin, data, e); //Analiza la submatriz de la derecha
			
	}

    
}
 

