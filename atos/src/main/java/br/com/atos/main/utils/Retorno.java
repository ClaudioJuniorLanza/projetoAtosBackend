package br.com.atos.main.utils;

/**
 * Classe auxiliar de Retorno de mensagens
 * para interface do cliente que requisita os serviços Rest
 * @author Claudio Junior
 *
 */


public class Retorno {
	
	private static final String mensagemAtualiza = "Atualizado com sucesso!";
	private static final String mensagemDeleta = "Deletado com sucesso!";
	private static final String mensagemInsere = "Inserido com sucesso!";
	private String mensagem;
	private int idRetorno;
	
	
	public String getMensagem() {
		return mensagem;
	}
	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
	public int getIdRetorno() {
		return idRetorno;
	}
	public void setIdRetorno(int idRetorno) {
		this.idRetorno = idRetorno;
	}
	public static String getMensagematualiza() {
		return mensagemAtualiza;
	}
	public static String getMensagemdeleta() {
		return mensagemDeleta;
	}
	public static String getMensageminsere() {
		return mensagemInsere;
	}

}
