package modelo;

public class Pedidos {
	private String nome;
	private double valor;
	
	public Pedidos() {
		// TODO Auto-generated constructor stub
	}
	
	public void fazerPedido(String nome, double valor) {
		this.nome = nome;
		this.valor = valor;
	}
	
	public Pedidos(String nome, double valor) {
		this.nome = nome;
		this.valor = valor;
	}
	
	public String getNome() {
		return nome;
	}
//	public void setNome(String nome) {
//		this.nome = nome;
//	}
//
	public double getValor() {
		return valor;
	}
//	public void setValor(double valor) {
//		this.valor = valor;
//	}
	
}
