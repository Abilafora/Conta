package conta;

import java.util.Scanner;

import conta.util.Cores;

import conta.model.ContaCorrente;
import conta.model.ContaPoupanca;

public class Menu {

	public static void main(String[] args) {
		
		
		
			// Teste da Classe ContaCorrete
			ContaCorrente cc1  = new ContaCorrente(1, 123, 1, "Claudia", 10000.0f,15);
			cc1.visualizar();
			cc1.sacar(12000.0f);
			cc1.visualizar();
			cc1.depositar(5000.0f);
			cc1.visualizar();
			
			ContaPoupanca cp1  = new ContaPoupanca(1, 123, 1, "Vinicius", 10000.0f);
			cp1.visualizar();
			cp1.sacar(12000.0f);
			cp1.visualizar();
			cp1.depositar(5000.0f);
			cp1.visualizar();
			
			
		
		Scanner leia = new Scanner(System.in);
		
		int opcao;
		
		
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
				
			
			opcao =leia.nextInt();
			
			if (opcao==9);{
				System.out.println(" \nBanco do Brazil com Z - O seu Futuro começa aqui!");
				sobre();
				
			leia.close();
			System.exit(0);
				
			}
			
			switch(opcao) {
			case 1:
				System.out.println(" Criar Conta\n");

				break;
			case 2:
				System.out.println("Listar todas as Contas\n");

				break;
			case 3:
				System.out.println("Consultar dados da Conta - por número\n");

				break;
			case 4:
				System.out.println("Atualizar dados da Conta\n");

				break;
			case 5:
				System.out.println("Apagar a Conta\n");

				break;
			case 6:
				System.out.println("Saque\n");

				break;
			case 7:
				System.out.println("Depósito\n");

				break;
			case 8:
				System.out.println("Transferência entre Contas\n");

				break;
			default:
				System.out.println("\nOpção Inválida!\n");
				break;
			}
			
		}
		

	}
	public static void sobre() {
		System.out.println("\n*********************************************************");
		System.out.println("Projeto Desenvolvido por: Abiqueila de Souza  ");
		System.out.println("Generation Brasil - abiqueilas@genstudents.org");
		System.out.println("git@github.com:Abilafora/Conta.git");
		System.out.println("*********************************************************");
	}

}
