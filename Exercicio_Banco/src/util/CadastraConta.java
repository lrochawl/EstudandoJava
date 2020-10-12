package util;

public class CadastraConta {
	private String name;
	private double conta, saldo;
	private int senha = 2002;
	public static final int AG = 3189;


	public CadastraConta(String name, double deposito) {
		this.name = name;
		setDeposito(deposito);
		geraConta();
	}

	public CadastraConta(String name) {
		this.name = name;
		geraConta();
		

	}

	public void geraConta() {

		this.conta = (int) (1001 + Math.random() * 1000);
		setMensagem("\n *************Seja bem-vindo ao Banco **************%n");
		setMensagem("\nPrabéns "+getName()+" Foi confirmado a abertura da sua conta em nossa agência: %n");
		setMensagem("****** Acabamos de gerar o número de sua conta **********%n");
		setMensagem("\n\n**Informamos que todos os seus depositos são gratuitos, para os saques é cobrado uma taxa de R$ 5,00 por saque combinado :) %n");
	}
	
	public String toString() {
		
		
		return "\n------------------------------"
				+ "\n AGÊNCIA: " 
				+ AG
				+ "\n CONTA: " 
				+ String.format("%.0f", getContaNumber())
				+ "\n SALDO ATUAL: R$ " 
				+ String.format("%.2f", getSaldo())
				+ "\n------------------------------";
	}
	
	public void setMensagem(String msgUser) {
		System.out.printf(msgUser);
	}

	public void setName(String name) {
		this.name = name;
		setMensagem("\nO nome do usuario foi alterado com sucesso \n");
		setMensagem("\n#NOME DE USUÁRIO ATUAL: " + getName());
	}

	public String getName() {
		return this.name;
	}

	public double getConta() {
		return this.conta;
	}

	public double getSaldo() {
		return this.saldo;
	}

	public void setDeposito(double deposito) {
		this.saldo += deposito;
	}

	public void setSaque(double saque) {
		this.saldo -= saque + 5;
	}

	public double getContaNumber() {
		return this.conta;
	}

	public int verificaSenha(int senha) {

		int senhaOk = 0;

		if (this.senha == senha) {
			senhaOk = 1;
		}

		return senhaOk;
	}

	public void solicitaSenha(int senha) {
		verificaSenha(senha);
	}
}
