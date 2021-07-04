package PetStore;

import java.io.Serializable;

public abstract class Mamifero implements Serializable {


	private static final long serialVersionUID = 1L;
	private   String nome;
	private   int idade;
	private   String dono;
	protected String especie;
	private String cuidadosProprios;
	private String alimentacao;
	
	public Mamifero(String nome, int idade, String dono, String cuidadosProprios, 
			String alimentacao) {
		this.nome = nome;
		this.idade = idade;
		this.dono = dono;
		this.cuidadosProprios = cuidadosProprios;
		this.alimentacao = alimentacao;
		
	}
	public String toString() {
		String retorno = "";
		retorno += "Nome: "     + this.nome     + "\n";
		retorno += "Idade: "    + this.idade    + " anos\n";
		retorno += "Dono: "     + this.dono     + "\n";
		retorno += "Alimentação: " + this.alimentacao + "\n";
		retorno += "Cuidados prórios: " + this.cuidadosProprios + "\n";
		retorno += "Especie: "  + this.especie  + "\n";
		retorno += "Barulho: "  + soar()        + "\n";
		return retorno;
	}
	public abstract String soar();
	
	
	 
}