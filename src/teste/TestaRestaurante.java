package teste;
import modelo.Pedidos;
import modelo.Restaurante;


public class TestaRestaurante {

	public static void main(String[] args) {
		Restaurante restaurante = new Restaurante("Luiza", 10);
		
		System.out.println(restaurante);
		
//		restaurante.statusMesas();
		restaurante.abrirMesa(10);
//		restaurante.status();
		
		Pedidos meuPedido = new Pedidos("Frango", 25);
		restaurante.fazerPedido(10, meuPedido);
		
//		restaurante.status();
		restaurante.abrirMesa(3);
//		restaurante.status();
		
		Pedidos meuPedido2 = new Pedidos("Lasanha", 35.00);

		restaurante.fazerPedido(3, meuPedido2);
		restaurante.fazerPedido(3, meuPedido2);
		restaurante.fazerPedido(3, meuPedido);
		restaurante.fazerPedido(3, meuPedido2);
		restaurante.fazerPedido(3, meuPedido2);
		restaurante.fazerPedido(3, meuPedido2);
		restaurante.fazerPedido(3, meuPedido2);
		restaurante.fazerPedido(3, meuPedido);
		
		
		
		restaurante.status();
		
		restaurante.conta(3, 2,true);
		restaurante.conta(10, 2,false);
		
		restaurante.juntarMesas(3, 10);
		
		restaurante.conta(3, 2, true);
		
		
		
	}

}
