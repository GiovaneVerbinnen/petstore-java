package PetStore;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;


public class PetStore  extends JFrame{
	private ArrayList<Mamifero> mamiferos;

	public PetStore() {
		this.mamiferos = new ArrayList<Mamifero>();
	}
	public String[] leValores (String [] dadosIn){
		String [] dadosOut = new String [dadosIn.length];

		for (int i = 0; i < dadosIn.length; i++)
			dadosOut[i] = JOptionPane.showInputDialog  ("Entre com " + dadosIn[i]+ ": ");

		return dadosOut;
	}

	public Gato leGato (){

		String [] valores = new String [6];
		String [] nomeVal = {"Nome", "Idade", "Dono", "Cuidados próprios", "Alimentação"};
		valores = leValores (nomeVal);

		int idade = this.retornaInteiro(valores[1]);

		Gato gato = new Gato (valores[0],idade,valores[2], valores[3], valores[4]);
		return gato;
	}

	public Cao leCao (){

		String [] valores = new String [6];
		String [] nomeVal = {"Nome", "Idade", "Dono", "Cuidados próprios", "Alimentação"};
		valores = leValores (nomeVal);

		int idade = this.retornaInteiro(valores[1]);

		Cao cao = new Cao (valores[0],idade,valores[2], valores[3], valores[4]);
		return cao;
	}
	public Cavalo leCavalo (){

		String [] valores = new String [6];
		String [] nomeVal = {"Nome", "Idade", "Dono", "Cuidados próprios", "Alimentação"};
		valores = leValores (nomeVal);

		int idade = this.retornaInteiro(valores[1]);

		Cavalo cavalo = new Cavalo(valores[0],idade,valores[2], valores[3], valores[4]);
		return cavalo;
	}

	private boolean intValido(String s) {
		try {
			Integer.parseInt(s); // Método estático, que tenta tranformar uma string em inteiro
			return true;
		} catch (NumberFormatException e) { // Não conseguiu tranformar em inteiro e gera erro
			return false;
		}
	}
	public int retornaInteiro(String entrada) { // retorna um valor inteiro
		int numInt;

		//Enquanto não for possível converter o valor de entrada para inteiro, permanece no loop
		while (!this.intValido(entrada)) {
			entrada = JOptionPane.showInputDialog(null, "Valor incorreto!\n\nDigite um número inteiro.");
		}
		return Integer.parseInt(entrada);
	}

	public void salvaMamiferos (ArrayList<Mamifero> mamiferos){
		ObjectOutputStream outputStream = null;
		try {
			outputStream = new ObjectOutputStream 
					(new FileOutputStream("c:\\temp\\petStore.dados"));
			for (int i=0; i < mamiferos.size(); i++)
				outputStream.writeObject(mamiferos.get(i));
		} catch (FileNotFoundException ex) {
			JOptionPane.showMessageDialog(null,"Impossível criar arquivo!");
			ex.printStackTrace();
		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {  //Close the ObjectOutputStream
			try {
				if (outputStream != null) {
					outputStream.flush();
					outputStream.close();
				}
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}

	@SuppressWarnings("finally")
	public ArrayList<Mamifero> recuperaMamiferos (){
		ArrayList<Mamifero> mamiferosTemp = new ArrayList<Mamifero>();

		ObjectInputStream inputStream = null;

		try {	
			inputStream = new ObjectInputStream
					(new FileInputStream("c:\\temp\\petStore.dados"));
			Object obj = null;
			while ((obj = inputStream.readObject()) != null) {
				if (obj instanceof Mamifero) {
					mamiferosTemp.add((Mamifero) obj);
				}   
			}          
		} catch (EOFException ex) { // when EOF is reached
			System.out.println("Fim de arquivo.");
		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();
		} catch (FileNotFoundException ex) {
			JOptionPane.showMessageDialog(null,"Arquivo com mamíferos NÃO existe!");
			ex.printStackTrace();
		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {  //Close the ObjectInputStream
			try {
				if (inputStream != null) {
					inputStream.close();
				}
			} catch (final IOException ex) {
				ex.printStackTrace();
			}
			return mamiferosTemp;
		}
	}

	public void menuPetStore (){

		String menu = "";
		String entrada;
		int    opc1, opc2;

		do {
			menu = "Controle PetStore\n" +
					"Opções:\n" + 
					"1. Entrar Mamíferos\n" +
					"2. Exibir Mamíferos\n" +
					"3. Limpar Mamíferos\n" +
					"4. Gravar Mamíferos\n" +
					"5. Recuperar Mamíferos\n" +
					"9. Sair";
			entrada = JOptionPane.showInputDialog (menu + "\n\n");
			opc1 = this.retornaInteiro(entrada);

			switch (opc1) {
			case 1:// Entrar dados
				menu = "Entrada de Animais Mamíferos\n" +
						"Opções:\n" + 
						"1. Cão\n" +
						"2. Gato\n" + 
						"3. Cavalo\n";

				entrada = JOptionPane.showInputDialog (menu + "\n\n");
				opc2 = this.retornaInteiro(entrada);

				switch (opc2){
				case 1: mamiferos.add((Mamifero)leCao());
				break;
				case 2: mamiferos.add((Mamifero)leGato());
				break;
				case 3: mamiferos.add((Mamifero)leCavalo());
				break;
				default: 
					JOptionPane.showMessageDialog(null,"Animal mamífero para entrada NÃO escolhido!");
				}

				break;
			case 2: // Exibir dados
				if (mamiferos.size() == 0) {
					JOptionPane.showMessageDialog(null,"Entre com animais mamíferos primeiramente");
					break;
				}
				String dados = "";
				for (int i=0; i < mamiferos.size(); i++)	{
					dados += mamiferos.get(i).toString() + "---------------\n";
				}
				JOptionPane.showMessageDialog(null,dados);
				break;
			case 3: // Limpar Dados
				if (mamiferos.size() == 0) {
					JOptionPane.showMessageDialog(null,"Entre com animais mamíferos primeiramente");
					break;
				}
				mamiferos.clear();
				JOptionPane.showMessageDialog(null,"Dados LIMPOS com sucesso!");
				break;
			case 4: // Grava Dados
				if (mamiferos.size() == 0) {
					JOptionPane.showMessageDialog(null,"Entre com animais mamíferos primeiramente");
					break;
				}
				salvaMamiferos(mamiferos);
				JOptionPane.showMessageDialog(null,"Dados SALVOS com sucesso!");
				break;
			case 5: // Recupera Dados
				mamiferos = recuperaMamiferos();
				if (mamiferos.size() == 0) {
					JOptionPane.showMessageDialog(null,"Sem dados para apresentar.");
					break;
				}
				JOptionPane.showMessageDialog(null,"Dados RECUPERADOS com sucesso!");
				break;
			case 9:
				JOptionPane.showMessageDialog(null,"Fim do aplicativo PETSTORE");
				break;
			default:
				opc1 = 9;
				
				break;
			}
		} while (opc1 != 9);
	}


	public static void main (String [] args){

		PetStore pet = new PetStore ();
		pet.menuPetStore();

	}

}