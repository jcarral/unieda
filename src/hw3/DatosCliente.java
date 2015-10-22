package hw3;

public class DatosCliente {

	private int numeroGorra;
	private String nif;
	private double cantidadAPagar;
	
	public DatosCliente(int gorra, String nif, double euros){
		numeroGorra = gorra;
		this.nif= nif;
		cantidadAPagar = euros;
	}
	
	public int gorra(){
		return numeroGorra;
	}
	
	public String nif(){
		return nif;
	}
	
	public double factura(){
		return cantidadAPagar;
	}
	
	
}
