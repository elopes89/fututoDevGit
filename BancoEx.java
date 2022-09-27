package m2Semana3;

import java.util.ArrayList;

import java.util.List;

import lombok.Data;

@Data
public class BancoEx {

	private List<ContaEx> contas;

	public BancoEx() {
		this.contas = new ArrayList<>();
	}

	public void transfere(String numeroContaOrigem, String numeroContaDestino, double valor)
			throws ContaNaoExisteException {
		ContaEx contaDestino = null;
		ContaEx contaOrigem = null;

		if (valor <= 0) {
			throw new IllegalArgumentException();
		}

		for (

		ContaEx contaEx : contas) {
			if (contaEx.getNumeroConta().equals(numeroContaOrigem)) {
				contaOrigem = contaEx;
			} else if (contaEx.getNumeroConta().equals(numeroContaDestino)) {
				contaDestino = contaEx;
			}

		}

		if (contaOrigem == null || contaDestino == null) {
			throw new ContaNaoExisteException("Conta não existe!");
		} else {
			contaOrigem.saque(valor);
			contaDestino.deposito(valor);
		}
	}

}
