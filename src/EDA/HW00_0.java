package EDA;

import java.util.Arrays;

public class HW00_0 {

	public static int gcd(int[] values){
		int num = gcd(values[0], values[1]);
		for(int i = 2; i<values.length; i++){
			num = (values[i]<num)?gcd(num, values[i]):gcd(values[i], num);
		}
		return num;
	}
	
	private static int gcd(int a, int b){
		if(b == 0)
			return a;
		else 
			return gcd(b, a % b);
	}
	
	
	public static int freqs(int[]  data, int[] buffer, int[] freqs){
		//Arrays.sort(data);
		ordenar(data);
		System.out.println("Data: " + Arrays.toString(data));
		int n = 1;
		buffer[0] = data [0];
		freqs[0] = 1;
		for(int i = 1; i<data.length; i++){
			if(data[i] == data[i-1]){
				freqs[n-1]++;
			}else{
				buffer[n] = data[i];
				freqs[n]++;
				n++;
			}
		}
		System.out.println("Buffer: " + Arrays.toString(buffer));
		System.out.println("Freqs: " + Arrays.toString(freqs));
		return n;
	}
	

	public static void ordenar(int[] a){  
      for(int i = 0; i < a.length - 1; i++){
          intercambio(a);
      }
    }  
	
	private static void intercambio(int[] a){
		for(int j = 0; j < a.length - 1; j++){
            if (a[j] > a[j + 1]) {
                int tmp = a[j+1];
                a[j+1] = a[j];
                a[j] = tmp;
            }
        }
	}
	
	
	public static void main(String[] args){
		int[] data = {1, 9, 1};
		int[] buffer = new int[data.length];
		int[] freqs = new int[data.length];
		
		System.out.println(freqs(data, buffer, freqs));
		
		int[] a = {48, 60, 6, 3};
		
		System.out.println(gcd(a));
	}
	
}
