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
				
				System.out.println("Digite a matrícula: ");
				String matricula = ler.next();
				
				System.out.println("Digite seu nome: ");
				String nome = ler.next();
				
				System.out.println("Digite a senha: ");
				String senha = ler.next();
	
				Usuario u = new Usuario(nome, matricula, senha, false);
				
				System.out.println("Sua matrícula é: " + u.getMatricula());
				System.out.println("Seu nome é: " + u.getNome());
				System.out.println("Sua senha é: " + u.getSenha());
				texto.confirmarCadastro();
				int confirma = ler.nextInt();
				switch(confirma) {
				case 1:
					listaDeUsuarios.cadastrarUsuario(u);
					System.out.println("Usuário cadastrado!");
					break;
				case 2:
					break;
				}
				break;
				
			case 3:
				System.out.println("Digite a matrícula do usuario");
				String buscaMatricula = ler.next();
				listaDeUsuarios.buscar(buscaMatricula);
				
				break;
			case 4: 
				System.out.println("Número de usuários cadastrados: "+listaDeUsuarios.quatidadeAlunos());
				
				break;
			}
		}
	}
}

