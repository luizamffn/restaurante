package modelo;
import java.util.Iterator;

public class Restaurante {
	
	private String nome;
	private Mesa[] mesa;
	
	public Restaurante(String nome, int quantidade) {
		this.nome = nome;
		this.mesa = new Mesa[quantidade];
		
		for (int i = 0; i < mesa.length; i++) {
			this.mesa[i] = new Mesa(i); //criando as mesas
			
		}
	}
	
	public void abrirMesa(int numeroDaMesa) {
		if (numeroDaMesa >=1 && numeroDaMesa<= mesa.length){
			mesa[numeroDaMesa-1].setAbrir(true);
		}else{
			System.out.println("Numero da mesa invalido");
		}
	}
	
	public void juntarMesas(int principal, int secundaria){
		mesa[principal-1].setMesaJuntada(secundaria-1);
		mesa[secundaria-1].setMesaJuntada(principal-1);
	}
	
	public void statusMesas(){
		String disponivel = "";
		String ocupadas = "";
		for (Mesa i : mesa) {
			if (i.isAbrir() == false){
				disponivel += i.getNumero() + " ";
			}else{
				ocupadas += i.getNumero() + " ";
			}
		}
		
		if (disponivel != ""){
			System.out.println("\nMesas disponiveis: " +  disponivel );
		}else{
			System.out.println("\nNenhuma mesa disponivel");
		}
		if (ocupadas!= ""){
			System.out.println("Mesas Ocupadas: " +  ocupadas );
		}else{
			System.out.println("Nenhuma mesa ocupada");	
		}
		
	}
	
	public void fazerPedido(int numMesa, Pedidos pedido) {
		if(mesa[numMesa-1].isAbrir() ==true){
			int inserir = 0;
			int tamanhoDoPedido = mesa[numMesa-1].getPedidos().length;
			for (int j = 0; j < tamanhoDoPedido; j++) {
				if (mesa[numMesa-1].getPedidos()[j].getNome() == null){
					mesa[numMesa-1].getPedidos()[j].fazerPedido(pedido.getNome(), pedido.getValor());
					inserir =1;
					break;
				}
			}
			
			if(inserir ==0){
				Pedidos[] pedidoAnterior;
				pedidoAnterior = mesa[numMesa-1].getPedidos();
				mesa[numMesa-1].setPedidos(new Pedidos[tamanhoDoPedido+=4]);
	
				for (int j = 0; j < mesa[numMesa-1].getPedidos().length; j++) {
					mesa[numMesa-1].getPedidos()[j] = new Pedidos();
				}
				 
				tamanhoDoPedido = mesa[numMesa-1].getPedidos().length;
				int i;
				for (i=0;i < pedidoAnterior.length ; i++) {
					mesa[numMesa-1].getPedidos()[i].fazerPedido(pedidoAnterior[i].getNome(), pedidoAnterior[i].getValor());
					
				}
				int j;
				for (j=i;j < tamanhoDoPedido ; j++) {
					mesa[numMesa-1].getPedidos()[j].fazerPedido(pedido.getNome(), pedido.getValor());
					break;
				}
				
			}
		}else{
			System.out.println("Abra a mesa primeiro");
		}
	}
	
	public void status(){
		statusMesas();
		double faturamentoAtual = 0;
		for (int i = 0; i < mesa.length; i++) {
			if(mesa[i].isAbrir()!=false) {
				for (Pedidos p : mesa[i].getPedidos()) {
					if (p.getNome() != null) {
						faturamentoAtual += p.getValor();
					}
				}
			}
		}
		System.out.println("Ganho Atual: " + faturamentoAtual);
	}
	
	public void conta(int numMesa, int quantidadePagadores, boolean pagarTaxaDeServiço){
		if (mesa[numMesa-1].isAbrir()==true){
			String nomeMesaJuntada = "";
			double valorTotal = 0;
			double taxaServico = 0;
			int encontrou = 0;
			String[] nomes = new String[mesa[numMesa-1].getPedidos().length];
			int[] contador = new int[mesa[numMesa-1].getPedidos().length];
			double[] valor = new double[mesa[numMesa-1].getPedidos().length];
			int parada = 1;
			
			if(mesa[numMesa-1].getMesaJuntada() !=0){
				nomeMesaJuntada += mesa[mesa[numMesa-1].getMesaJuntada()].getNumero();
				parada = 2;
			}
			
			
			for (int j= 0; j < parada; j++) {
				for (Pedidos p : mesa[numMesa-1].getPedidos()) {
					if(p.getNome() == null) break;
						for (int i = 0; i < nomes.length; i++) {
							if(p.getNome() == nomes[i]){
								contador[i]++;
									
								valorTotal +=p.getValor();
								encontrou=1;
								break;
							}else{
								encontrou = 0;
							}
					}
						
					if(encontrou == 0){
						for (int i = 0; i < nomes.length; i++) {
							if(nomes[i] ==null){
								nomes[i] = p.getNome();
								valor[i] = p.getValor();
								contador[i]++;
									
								valorTotal +=p.getValor();
								break;
							};
						}
					}
						
				}
				if(parada == 2){
					numMesa = mesa[numMesa-1].getMesaJuntada() +1;
				}
			}
				
			System.out.println("\nResturante: " + this.nome + "\n"
					+"mesa: " + numMesa+ " " + nomeMesaJuntada +"\n"
					
					+"--------------------------------\n"
					+ "Pedidos \tQuant \tValor");
			
					for (int i = 0; i < nomes.length; i++) {
						if (nomes[i] !=null) {
							System.out.println(nomes[i] + "\t\t " + contador[i] + "\t" +valor[i]);
						}
					}
					
					System.out.println("--------------------------------");
					if (pagarTaxaDeServiço == true) {
						taxaServico = valorTotal * 0.1;
						System.out.println("Taxa de serviço: " +  taxaServico);
								
						valorTotal += taxaServico;
					}		
					System.out.println("Valor Total: "+ valorTotal);
					
			if (quantidadePagadores >1) {
				System.out.println("Rateio: " + valorTotal/quantidadePagadores );
			}		
		}else{
			System.out.println("A mesa não esta ocupada!");
		}
		
	}
	
	//mostras as informacoes do objeto
	public String toString(){
		return "Restaurante: " + this.nome + " mesas: "  + this.mesa.length +"\n";
	}
	
}
