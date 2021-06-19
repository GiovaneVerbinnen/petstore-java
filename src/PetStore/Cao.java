package PetStore;

public class Cao extends Mamifero {

	private static final long serialVersionUID = 1L;

	public String soar() {
		return "Faz latidos";
	}
	public Cao(String nome, int idade, String dono) {
		super(nome, idade, dono);
		this.especie = "Cachorro";
	}
}
