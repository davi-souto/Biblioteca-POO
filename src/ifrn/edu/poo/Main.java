package ifrn.edu.poo;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner ler = new Scanner(System.in);
		ListaUsuarios listaDeUsuarios = new ListaUsuarios();
		Textos texto = new Textos();
		int opcao = -1;
		
		while (opcao != 0) {
			texto.menuInicial();
			opcao = ler.nextInt();
			
			switch(opcao) {
			case 0:
				System.out.println("Saindo do aplicativo.");
				break;
				
			case 1:
				
				break;
				
			case 2:
				
				System.out.println("Digite a matr�cula: ");
				String matricula = ler.next();
				
				System.out.println("Digite seu nome: ");
				String nome = ler.next();
				
				System.out.println("Digite a senha: ");
				String senha = ler.next();
	
				Usuario u = new Usuario(nome, matricula, senha, false);
				
				System.out.println("Sua matr�cula �: " + u.getMatricula());
				System.out.println("Seu nome �: " + u.getNome());
				System.out.println("Sua senha �: " + u.getSenha());
				texto.confirmarCadastro();
				int confirma = ler.nextInt();
				switch(confirma) {
				case 1:
					listaDeUsuarios.cadastrarUsuario(u);
					System.out.println("Usu�rio cadastrado!");
					break;
				case 2:
					break;
				}
				break;
				
			case 3:
				System.out.println("Digite a matr�cula do usuario");
				String buscaMatricula = ler.next();
				listaDeUsuarios.buscar(buscaMatricula);
				
				break;
			case 4: 
				System.out.println("N�mero de usu�rios cadastrados: "+listaDeUsuarios.quatidadeAlunos());
				
				break;
			}
		}
	}
}

