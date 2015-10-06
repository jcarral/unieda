package student;

import java.util.*;
import java.io.*;

/**
 * Tiemplo empleado: 20 minutos
 * 
 * La clase Quebrados genera un archivo resultados.txt con una lista ordenada de quebrados junto a su representante canónico
 * Los quebrados los lee de un archivo que se pasa como parametro de tipo String por el constructor.
 * En el archivo estarán todos los quebrados que se leeran, un quebrado por linea con el formato a/b donde a y b son números enteros.
 * Cualquier otro tipo de dato lanzará una excepción y será obviado aunque el programa seguirá ejecutandose.
 *
 */
public class Quebrados {

	private List<QuebradoInfo> nums; //Lista con la información de cada Quebrado
	private static final String FILE_SALIDA = "src/student/resultados.txt"; //Valor del fichero de salida por defecto

	/**
	 * Constructor, lee el archivo y genera uno nuevo con los datos de los
	 * quebrados en orden creciente
	 * 
	 * @param src
	 *            String con la dirección del fichero a leer
	 */
	Quebrados(String src) {
		nums = new LinkedList();
		try {
			leerInfo(src);
			ordenarLista();
			imprimirLista();
			System.out.println("Archivo generado con éxito");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage() + " > Archivo no encontrado");
		}
	}

	/**
	 * Imprime la lista en un archivo.
	 * 
	 * @throws IOException
	 */
	private void imprimirLista() throws IOException {
		BufferedWriter wr = new BufferedWriter(new FileWriter(new File(FILE_SALIDA)));
		String s = "=============LISTA DE QUEBRADOS================\n\n";
		for (QuebradoInfo q : nums) {
			s += "Quebrado: " + q.quebrado + ", Representante canónico: " + q.representante + "\n";
		}
		wr.write(s);
		wr.close();
	}

	/**
	 * Ordena la lista de menor a mayor.
	 */
	private void ordenarLista() {
		nums.sort(new Comparator<QuebradoInfo>() {

			@Override
			public int compare(QuebradoInfo o1, QuebradoInfo o2) {
				if (o1.valor > o2.valor)
					return 1;
				else if (o1.valor == o2.valor)
					return 0;
				else
					return -1;
			}

		});
	}

	/**
	 * Lee los datos del archivo y los introduce en la lista
	 * 
	 * @param src
	 *            String con la ruta del archivo fuente
	 * @throws IOException
	 */
	private void leerInfo(String src) throws IOException {
		String linea;
		FileReader f = new FileReader(src);
		BufferedReader b = new BufferedReader(f);
		while ((linea = b.readLine()) != null) {
			getQuebradoInfo(linea);
		}
		b.close();
	}

	/**
	 * Genera un String con el valor del representante canónico
	 * 
	 * @param a
	 *            Numerador
	 * @param b
	 *            Denominador
	 * @return String con el valor de representante canónico
	 */
	private String representanteCanonico(int a, int b) {
		int gcm = gcm(a, b);
		return (a / gcm) + "/" + (b / gcm);
	}

	private int gcm(int a, int b) {
		return b == 0 ? a : gcm(b, a % b);
	}

	/**
	 * Lee el quebrado e introduce en la lista un objeto QuebradoInfo con los
	 * detalles del quebrado
	 * 
	 * @param s
	 *            String del Quebrado
	 */
	private void getQuebradoInfo(String s) {
		String[] num;
		QuebradoInfo n;
		try {
			num = s.split("/");
			float val0 = Float.parseFloat(num[0]);
			float val1 = Float.parseFloat(num[1]);
			n = new QuebradoInfo(s, representanteCanonico((int) val0, (int) val1), (val0 / val1));
			nums.add(n);
		} catch (Exception e) {
			System.out.println(
					e.getMessage() + " > Formato incorrecto, debe tener un formato 'a/b' donde a y b son enteros");
		}
	}

	/**
	 * Clase auxiliar donde se guardan la información de cada Quebrado
	 *
	 */
	class QuebradoInfo {
		private String quebrado;
		private String representante;
		private float valor;

		QuebradoInfo(String quebrado, String representante, float valor) {
			this.quebrado = quebrado;
			this.representante = representante;
			this.valor = valor;
		}

	}

	/**
	 * Tests
	 * 
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {

		new Quebrados("src/student/lista.txt");
	}

}
