package modelo;

public class Mesa {
	private int numero;
	private Pedidos[] pedidos;
	private boolean abrir =  false;
	private int mesaJuntada = 0;
//	private int[] mesaJuntadaTeste;
	
	public Mesa() {
		
	}
	
	public Mesa(int i) {
		this.numero = i+1;
		this.pedidos = new Pedidos[4];
		for (int j = 0; j < pedidos.length; j++) {
			pedidos[j] = new Pedidos();
		}
	}
	
	public int getNumero() {
		return numero;
	}

//	public void setNumero(int numero) {
//		this.numero = numero;
//	}
//
	public Pedidos[] getPedidos() {
		return pedidos;
	}

	public void setPedidos(Pedidos[] pedidos) {
		this.pedidos = pedidos;
	}

	public boolean isAbrir() {
		return abrir;
	}

	public void setAbrir(boolean abrir) {
		this.abrir = abrir;
	}

	public int getMesaJuntada() {
		return mesaJuntada;
	}

	public void setMesaJuntada(int mesaJuntada) {
		this.mesaJuntada = mesaJuntada;
	}
	
}
