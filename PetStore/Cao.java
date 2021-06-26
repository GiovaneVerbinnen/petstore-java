package PetStore;

public class Cao extends Mamifero {
	
	public Cao(String nome, int idade, String dono, String cuidadosProprios, 
			String alimentacao) {
		super(nome, idade, dono, cuidadosProprios, alimentacao);
		this.especie = "Cachorro";
	}
	private static final long serialVersionUID = 1L;

	public String soar() {
		return "Faz latidos";
	}
}
