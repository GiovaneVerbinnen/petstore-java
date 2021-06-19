package PetStore;

public class Gato extends Mamifero {

	private static final long serialVersionUID = 1L;

	public String soar() {
		return "Faz Miados";
	}
	public Gato(String nome, int idade, String dono) {
		super(nome, idade, dono);
		this.especie = "Gato";
	}
}
