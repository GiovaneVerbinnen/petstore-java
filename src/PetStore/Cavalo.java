package PetStore;

public class Cavalo extends Mamifero{

	public Cavalo(String nome, int idade, String dono, String cuidadosProprios, String alimentacao) {
		super(nome, idade, dono, cuidadosProprios, alimentacao);
		this.especie = "Cavalo";
	}

	private static final long serialVersionUID = 1L;

	@Override
	public String soar() {
		// TODO Auto-generated method stub
		return "Relincha";
	}
}
