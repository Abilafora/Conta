package conta;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

import conta.util.Cores;
import conta.controller.ContaController;
import conta.model.ContaCorrente;
import conta.model.ContaPoupanca;

public class Menu {

	public static void main(String[] args) {
		
		Scanner leia = new Scanner(System.in);
		//nome+nome da  variavel = new nome da classe
		
		ContaController contas = new ContaController();
		
		
		int numero,agencia,tipo,aniversario;
		String titular;
		float saldo, limite;
		
		
		// Teste da Classe ContaCorrete
		ContaCorrente cc1  = new ContaCorrente(1, 123, 1, "Claudia", 10000.0f,15);
		cc1.visualizar();
		
		cc1.visualizar();
		cc1.depositar(5000.0f);
		cc1.visualizar();
		
		ContaPoupanca cp1  = new ContaPoupanca(1, 123, 1, "Vinicius", 10000.0f);
		cp1.visualizar();
		cp1.sacar(12000.0f);
		cp1.depositar(5000.0f);
		cp1.visualizar();
		
		
		
		int opcao = 0;
		
		
		while (true){
			System.out.println(Cores.TEXT_PURPLE_BOLD_BRIGHT + Cores.ANSI_BLACK_BACKGROUND );
			System.out.println("                                                    ");
			System.out.println("                BANCO DO BRAZIL COM Z               ");
			System.out.println("                                                    ");
			System.out.println("****************************************************");
			System.out.println("                                                    ");
			System.out.println("                1: Criar conta                       ");
			System.out.println("                2: Listar todas as  contas          ");
			System.out.println("                3: Buscar conta por Número          ");
			System.out.println("                4: Atuaalizar dados da conta        ");
			System.out.println("                5: Apagar conta                     ");
			System.out.println("                6: Sacar                            ");
			System.out.println("                7: Depositar                        ");	
			System.out.println("                8: Transferir valores entre contas  ");
			System.out.println("                9: Sair                             ");
			System.out.println("                                                    ");
			System.out.println("****************************************************");
			System.out.println("                Entre com a opcão desejada:         ");
				
			try {
				opcao =leia.nextInt();
			}catch(InputMismatchException e) {
				System.out.println("\nDigite valores inteiros, por favor ");
				leia.nextLine();
				opcao = 0;
			}
		
			
			if (opcao == 9);{
				System.out.println(" \nBanco do Brazil com Z - O seu Futuro começa aqui!");
				sobre();
				
				leia.close();
				System.exit(0);
				
			}
			
			switch(opcao) {
			
				case 1:
					System.out.println(" Criar Conta\n");
				
					System.out.println(" Digite o numero da Agência");
					agencia=leia.nextInt();
					System.out.println(" Nome do titular:\n");
					leia.skip("\\R");
			
					titular =leia.nextLine();
				
					do {
						System.out.println(" Digite o tipo da conta (1CC ou 2 CP):");
						tipo=leia.nextInt();
					
					
					}while (tipo < 1 && tipo > 2);
				
					System.out.println("Digite  o Saldo da Conta (R$): ");
					saldo = leia.nextFloat();
				
					switch(tipo) {
						case 1 : {
							System.out.println("Digite o limite de crédito");
							limite=leia.nextFloat();
							contas.cadastrar(new ContaCorrente (contas.gerarNumero(),agencia,tipo,titular,saldo,limite	));
					}
				
						case 2 : {
							System.out.println("Digite o dia de aniversário da Conta:");
							aniversario =leia.nextInt();
							contas.cadastrar(new ContaPoupanca (contas.gerarNumero(),agencia,tipo,titular,saldo + aniversario ));
					
					}
				
				}

				keyPress();
				break;
				
				case 2:
					System.out.println(Cores.TEXT_PURPLE_BOLD_BRIGHT +"Listar todas as Contas\n");

					contas.listarTodas(); 	 		
					keyPress();
					break;
				
				case 3:
					System.out.println(Cores.TEXT_PURPLE_BOLD_BRIGHT + "Consultar dados da Conta - por número\n");

					keyPress();
					break;
				
				case 4:
					System.out.println(Cores.TEXT_PURPLE_BOLD_BRIGHT +"Atualizar dados da Conta\n");

					keyPress();
					break;
				
				case 5:
					System.out.println(Cores.TEXT_PURPLE_BOLD_BRIGHT +"Apagar a Conta\n");

					keyPress();
					break;
				case 6:
					System.out.println(Cores.TEXT_PURPLE_BOLD_BRIGHT +"Saque\n");

					keyPress();
					break;
				case 7:
					System.out.println(Cores.TEXT_PURPLE_BOLD_BRIGHT +"Depósito\n");
				
					keyPress();
					break;
				case 8:
					System.out.println(Cores.TEXT_PURPLE_BOLD_BRIGHT +"Transferência entre Contas\n");
				
					keyPress();
					break;
				default:
					System.out.println(Cores.TEXT_PURPLE_BOLD_BRIGHT +"\nOpção Inválida!\n");
					break;
			}
			
		}
		

	}
	public static void sobre() {
		System.out.println(Cores.TEXT_PURPLE_BOLD_BRIGHT +"\n*********************************************************");
		System.out.println(Cores.TEXT_PURPLE_BOLD_BRIGHT +"Projeto Desenvolvido por: Abiqueila de Souza  ");
		System.out.println(Cores.TEXT_PURPLE_BOLD_BRIGHT +"Generation Brasil - abiqueilas@genstudents.org");
		System.out.println(Cores.TEXT_PURPLE_BOLD_BRIGHT +"git@github.com:Abilafora/Conta.git");
		System.out.println(Cores.TEXT_PURPLE_BOLD_BRIGHT +"*********************************************************");
	}
	
	//metodo criado 
	public static void keyPress() {

		try {

			System.out.println(Cores.TEXT_RESET + "\n\nPressione Enter para Continuar...");
			System.in.read();

		} catch (IOException e) {

			System.out.println("Você pressionou uma tecla diferente de enter!");

		}
	}
	
	

}
