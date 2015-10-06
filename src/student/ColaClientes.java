package student;

public class ColaClientes {

	static private class Node {
		public DatosCliente datos;
		public Node previous;
		public Node next;

		public Node(Node previous, DatosCliente datos, Node next) {
			this.datos = datos;
			this.previous = previous;
			this.next = next;
		}
	}

	public Node first;
	public Node last;

	public void print() {
		Node aux = first;
		while (aux != null) {
			System.out.println(aux.datos.nif() + " " + aux.datos.gorra() + " " + aux.datos.factura());
			aux = aux.next;
		}
	}

	public void ponerAlFinal(DatosCliente datos) {
		if (last == null) {
			Node newNode = new Node(null, datos, null);
			first = newNode;
			last = newNode;
		} else {
			Node newNode = new Node(last, datos, null);
			last.next = newNode;
			last = newNode;
		}
	}

	public void print(int numeroGorra) {
		Node aux = first;
		while (aux != null) {
			if (numeroGorra == aux.datos.gorra())
				System.out.println(aux.datos.nif() + " " + aux.datos.gorra());
			aux = aux.next;
		}
	}

	public void ponerGrupoNuevoAlaCola(ColaClientes OtraCola) {
		if(first==null)
			first = OtraCola.first;
		else
			last.next = OtraCola.first;
		last = OtraCola.last;
	}

	public void facturarGrupos() {
		Node aux = first;
		int numGrupo;
		int cantidad = 0;
		while (aux != null) {
			numGrupo = aux.datos.gorra();
			cantidad += aux.datos.factura();
			if (aux.next != null && aux.next.datos.gorra() != numGrupo) {
				System.out.println("El grupo " + numGrupo + " debe pagar " + cantidad + "€");
				cantidad = 0;
			}
		}
	}

	public void meterEnLaCola(DatosCliente datos) {
		Node aux = first;

		while (aux != null && aux.datos.gorra() != datos.gorra()) {
			aux = aux.next;
		}

		if (aux == first) {// Añadir al principio
			Node newNode = new Node(null, new DatosCliente(1, datos.nif(), datos.gorra()), null);
			first = newNode;
			last = newNode;
		} else if (aux != null) {// Añadir después
			Node newNode = new Node(aux, new DatosCliente(aux.datos.gorra(), datos.nif(), datos.factura()), aux.next);
			aux.next.previous = newNode;
			aux.next = newNode;
		} else {// Añadir al final, no encontrado
			Node newNode = new Node(last, new DatosCliente(last.datos.gorra() + 1, datos.nif(), datos.factura()), null);
			last.next = newNode;
			last = newNode;
		}
	}

	public DatosCliente quitarPrimeroDeLaCola() {
		if (first == null)
			return null;
		else if (first == last) {
			DatosCliente ret = first.datos;
			first = null;
			last = null;
			return ret;
		} else {
			DatosCliente ret = first.datos;
			first.next.previous = null;
			first = first.next;
			return ret;
		}
	}

}
