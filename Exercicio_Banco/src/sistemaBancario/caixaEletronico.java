package sistemaBancario;

import java.util.Locale;
import java.util.Scanner;
import util.CadastraConta;

public class caixaEletronico {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		System.out.println(" ---------- Sistema Bancário ----------");
		System.out.println();
		System.out.println(" $$$$$$$ Abra sua conta $$$$$$$$$");
		System.out.print("Para prosseguir informe seu nome: ");
		String name = sc.nextLine();
		System.out.print("\n*Para iniciarmos a abertura da sua conta é necessario que seja realizado um deposito inicial");
		System.out.println();
		System.out.printf("\nOlá %s deseja realizar agora seu deposito inicial? (sim/nao) ", name);
		String confirma = sc.next().toLowerCase();
		CadastraConta conta ;
		if(confirma.equals("sim")) {
			System.out.print("\nQual será o valor do deposito? R$ ");
			double deposito = sc.nextDouble();
			conta = new CadastraConta(name, deposito);
			System.out.println(conta);
			
		}else{
			System.out.print("\nVocê optou por não realizar o deposito inicial neste momento");
			System.out.print("\nAlguns serviços estarão indisponiveis até a realização do primeiro deposito");
			conta = new CadastraConta(name);
			conta.setMensagem(conta.toString());
		}
		
	
		conta.setMensagem("%n Deseja realizar nova operação? (sim/nao) ");
		String opcao = sc.next();
		
		if(opcao.equals("sim")) {
			conta.setMensagem("\n1 para deposíto\n2 para saque\n3 para alterações cadastrais\n4 para finalizar\nSlecione uma opção: ");
			int op = sc.nextInt();
			while(op > 0 && op < 4) {
				switch(op) {
					case 1:
						conta.setMensagem("\nOpção 1: %nOpção deposito selecionada\n");
						conta.setMensagem("Informe o valor do deposito: R$ ");
						conta.setDeposito(sc.nextInt());
						conta.setMensagem("\nSALDO ATUAL: R$ " + String.format("%.2f", conta.getSaldo()));
						conta.setMensagem("\nE agora qual o proximo passo? \n");
						conta.setMensagem("\nFINALIZAR ou realizar outra OPERAÇÂO? \n");
						conta.setMensagem("\n1 para deposíto\n2 para saque\n3 para alterações cadastrais\n4 para finalizar\nSlecione uma opção: ");
						op = sc.nextInt();
						break;
					case 2:
						conta.setMensagem("\nOpção 2: %nOpção saque selecionada \n");
						conta.setMensagem("Informe o valor do saque: R$ ");
						conta.setSaque(sc.nextInt());
						conta.setMensagem("\nSALDO ATUAL: R$ " + String.format("%.2f", conta.getSaldo()));
						conta.setMensagem("\n\nE agora qual o proximo passo? \n");
						conta.setMensagem("\nFINALIZAR ou realizar outra OPERAÇÂO? \n");
						conta.setMensagem("\n1 para deposíto\n2 para saque\n3 para alterações cadastrais\n4 para finalizar\nSlecione uma opção: ");
						op = sc.nextInt();
						break;
					case 3:
							conta.setMensagem("\nOpção 3: %nVocê está prestes a realizar uma atualização cadastral \n");
							conta.setMensagem("Para continuar digite sua senha: ");
							int senha  = conta.verificaSenha(sc.nextInt());
							
							if(senha == 1) {
								conta.setMensagem("\n**** Acesso permitido :) **** \n \n");
								conta.setMensagem("Campos diponiveis para alteração: (Nome) \n");
								conta.setMensagem("\nInforme o novo nome para concluir a alteração: ");
								sc.nextLine();
								name = sc.nextLine();
								conta.setName(name);
								System.out.println(conta);
								conta.setMensagem("\nE agora qual o proximo passo? \n");
								conta.setMensagem("\nFINALIZAR ou realizar outra OPERAÇÂO? \n");
								conta.setMensagem("\n1 para deposíto\n2 para saque\n3 para alterações cadastrais\n4 para finalizar\nSlecione uma opção: ");
								op = sc.nextInt();
							}else {
								conta.setMensagem("**** Acesso negado :( **** \n \n");
								conta.setMensagem("Senha incorreta, digite novamente: ");
								senha  = conta.verificaSenha(sc.nextInt());
							}
						break;
					default:
						conta.setMensagem("\n Operação finalizada pelo usuário");
						break;
				}
		}
		
		}
		
		conta.setMensagem("Operação finalizada pelo usuario");
		
		
		
		System.out.println();
		
		sc.close();
		
	}

}
