package br.com.severo.escolabackend.escolabackend.config.validacao;

public class ErroDeCadastroDto {
	
	private String campo;
	private String erro;
	
	public ErroDeCadastroDto(String campo, String erro) {
		this.campo = campo;
		this.erro = erro;
	}

	public String getCampo() {
		return campo;
	}

	public String getErro() {
		return erro;
	}
	
	

}
