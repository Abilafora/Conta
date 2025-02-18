package conta.controller;

import java.util.ArrayList;

import conta.model.Conta;
import conta.repository.ContaRepository;

public class ContaController implements ContaRepository{
	
	private ArrayList<Conta> listaContas = new ArrayList<Conta>();
	int numero =0;

	@Override
	public void procurarPorNumero(int numero) {
		var conta = buscarNaCollection( numero);
		
		if(conta != null) 
			conta.visualizar();
		else
			System.out.println(" Conta do numero: " + numero + " não encontrado");
		
	}

	@Override
	public void listarTodas() {
		// TODO Auto-generated method stub
		for (var conta :listaContas) {
			conta.visualizar();
		}
		
		
	}

	@Override
	public void cadastrar(Conta conta) {
		listaContas.add(conta);
		System.out.println("\nconta do numero:"+conta.getNumero()+ "foi criada com sucesso");
		
	}

	@Override
	public void atualizar(Conta conta) {
		
		var buscaConta = buscarNaCollection(conta.getNumero());
		
		if(buscaConta !=null) {
			listaContas.set(listaContas.indexOf(buscaConta),conta);
			System.out.println( " \n A conta número: "+ conta.getNumero()+ "foi atualizada com sucesso!");
	
		}else
			System.out.println( " \n A conta número: "+ conta.getNumero()+ "não foi encontrada!");
		
	}

	@Override
	public void deletar(int numero) {
		var conta= buscarNaCollection(numero);
		
		if (conta != null) {
			if(listaContas.remove(conta) ==true)
				System.out.println(" \nA conta numero:" +numero + " foi deletada com sucesso");
			
		}else
			System.out.println(" \nA conta numero:" +numero + " não foi encontrada");
		
	}

	@Override
	public void sacar(int numero, float valor) {
var conta =buscarNaCollection(numero);
		
		if (conta != null) {
			if(conta.sacar(valor) == true)
				System.out.println("\nO Saque da conta " + numero + "foi efetuado com sucesso");
			
		}else 
			System.out.println("\nO Saque da conta " +numero + "não encontrado");
		
		
	}

	@Override
	public void depositar(int numero, float valor) {
	var conta = buscarNaCollection(numero);
	
		if (conta  != null) {
			conta.depositar(valor);
			System.out.println("\n O desposito na conta: "+ numero +"foi efetuado com sucesso");
		}else
			System.out.println("\n A conta: "+ numero +"não foi encontfrado ou não é uma Conta Corrente");
		
	}

	@Override
	public void transferir(int numeroOrigem, int numeroDestino, float valor) {
		var contaOrigem = buscarNaCollection(numeroOrigem);
		var contaDestino = buscarNaCollection(numeroDestino);
		
		if (contaOrigem != null && contaDestino != null ) {
			if(contaOrigem.sacar(valor) == true) {
				contaDestino.depositar(valor);
				System.out.println(" \nA trânsfererencia  foi efetuada com sucesso");
				
			}
		}else
		System.out.println(" \nConta destino não foi encontrada");
		
		
	}
	
	
	public int gerarNumero() {
		return ++ numero;
		}
	public Conta buscarNaCollection(int numero) {
		for (var conta :listaContas) {
			if (conta.getNumero()==numero) {
				return conta;
			}
		}
		
		return null;
	}
	
	
		
	}
	

