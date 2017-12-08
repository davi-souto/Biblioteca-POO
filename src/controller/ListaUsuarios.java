package controller;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.Usuario;
import model.Reserva;
import controller.ListaLivros;
import view.Textos;


public class ListaUsuarios {
	
	private ArrayList<Usuario> usuarios = new ArrayList <Usuario> ();
	Textos t = new Textos();
	Reserva r = new Reserva();
	
	
	
	public void acessarConta() {
		Scanner ler = new Scanner(System.in); 
		
		System.out.println("Digite sua matricula: ");
		String matricula = ler.nextLine();
		System.out.println("Digite sua senha: ");
		String senha = ler.nextLine();
		
		for(int i = 0; i < usuarios.size(); i++) {
			if((usuarios.get(i).getMatricula().equals(matricula)) && (usuarios.get(i).getSenha().equals(senha))) {
				System.out.println("-------------------------------------");
				System.out.println("Olá, " + " " + usuarios.get(i).getNome());
				System.out.println("Matricula: " + " " + usuarios.get(i).getMatricula());
				System.out.println("Usuario: " + " " + usuarios.get(i).getNome());
				System.out.println("Curso: " + " " + usuarios.get(i).getCursoUsuario());
				//System.out.println("Livros em posse: " + r.getNomeLivro());
				System.out.println("-------------------------------------");
			}
		}
	}
	
	public void cadastrarUsuario() {
		Usuario u = new Usuario();
		Scanner ler = new Scanner(System.in);
		
		System.out.println("Digite sua matricula: ");
		u.setMatricula(ler.nextLine());
		
		System.out.println("Digite seu nome: ");
		u.setNome(ler.nextLine());
		
		System.out.println("Digite seu curso: ");
		u.setCursoUsuario(ler.nextLine());
		
		System.out.println("Digite sua senha: ");
		u.setSenha(ler.nextLine());
		
		System.out.println("Matricula: " + u.getMatricula());
		System.out.println("Nome: " + u.getNome());
		System.out.println("Curso: " + u.getCursoUsuario());
		System.out.println("Senha: " + u.getSenha());
		
		t.confirmarCadastro();
		int confirmar = ler.nextInt();
		switch(confirmar) {
		case 1:
			usuarios.add(u);
			System.out.println("Usuario " + u.getNome() + " cadastrado!");
		}
	
	}
	
	public void buscarUsuario() {
		// Errado ainda
		Scanner ler = new Scanner(System.in);
		t.buscaDeUsuario();
		
		int comando = ler.nextInt();
		switch(comando) {
		case 1:
			System.out.println("Digite a matrícula do usuário: ");
			String matricula = ler.next(); 
			for (int i = 0; i < usuarios.size(); i++) {
				if(usuarios.get(i).getMatricula().equals(matricula)) {
					System.out.println("Acesso a: " + usuarios.get(i).getNome());
					System.out.println("-------------------------------------");
					System.out.println("Usuario: " + " " + usuarios.get(i).getNome());
					System.out.println("Matricula: " + " " + usuarios.get(i).getMatricula());
					System.out.println("Curso: " + " " + usuarios.get(i).getCursoUsuario());
					System.out.println("-------------------------------------");
				}
			} 
			break;
		case 2:
			System.out.println("Digite o nome do usuário: ");
			String nome = ler.next(); 
			for (int i = 0; i < usuarios.size(); i++) {
				if(usuarios.get(i).getNome().equals(nome)) {
					System.out.println("Acesso a: " + usuarios.get(i).getNome());
					System.out.println("-------------------------------------");
					System.out.println("Usuario: " + " " + usuarios.get(i).getNome());
					System.out.println("Matricula: " + " " + usuarios.get(i).getMatricula());
					System.out.println("Curso: " + " " + usuarios.get(i).getCursoUsuario());
					System.out.println("-------------------------------------");
				}
			} 
			break;
		case 3:
			System.out.println("Digite o nome do usuário: ");
			String curso = ler.next(); 
			for (int i = 0; i < usuarios.size(); i++) {
				if(usuarios.get(i).getCursoUsuario().equals(curso)) {
					System.out.println("Acesso a: " + usuarios.get(i).getNome());
					System.out.println("-------------------------------------");
					System.out.println("Usuario: " + " " + usuarios.get(i).getNome());
					System.out.println("Matricula: " + " " + usuarios.get(i).getMatricula());
					System.out.println("Curso: " + " " + usuarios.get(i).getCursoUsuario());
					System.out.println("-------------------------------------");
				}
			} 
			break;
		}
	}
	
	public void removerUsuario() {
		Scanner ler = new Scanner(System.in);
		System.out.println("Digite a matrícula do usuário a ser excluido: ");
		String alunoExcluido = ler.nextLine();
		System.out.println("Digite a senha de administrador para confirmar a ação:");
		int senha = ler.nextInt();
		if (senha == 0001) {
		
			for (int i = 0; i < usuarios.size(); i++) {
				if(usuarios.get(i).getMatricula().equals(alunoExcluido)) {
					usuarios.remove(i);
					System.out.println("Usuario removido.");
				}		
			}
		}else {
			System.out.println("Acesso negado!");
		}
	}
	
	public void mostrarUsuarios() {
		System.out.println("Número de usuários cadastrados: " + usuarios.size());
		for (int i = 0; i < usuarios.size(); i++) {
			System.out.println("Usuario: " + usuarios.get(i).getNome());
		}
	}
	
	
}
