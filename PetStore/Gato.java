package PetStore;

public class Gato extends Mamifero {

	public Gato(String nome, int idade, String dono, String cuidadosProprios, 
			String alimentacao) {
		super(nome, idade, dono, cuidadosProprios, alimentacao);
		this.especie = "Gato";
	}

	private static final long serialVersionUID = 1L;

	public String soar() {
		return "Faz Miados";
	}
	
}