package controller;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.Usuario;
import exceptions.SenhaAdminIncorretaException;



public class ListaUsuarios {
	

	public void acessarConta() {
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
	
	public void cadastrarUsuario(String matricula, String nome, String curso, String senha) {
		
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
	
	public boolean removerUsuario(String matricula, int senhaAdmin) throws SenhaAdminIncorretaException {
		boolean usuarioExcluido = false;
		if (senhaAdmin == 0001) {
		
			for (int i = 0; i < usuarios.size(); i++) {
				if(usuarios.get(i).getMatricula().equals(matricula)) {
					usuarios.remove(i);
					usuarioExcluido = true;
				}
			}
		}else {
			throw new SenhaAdminIncorretaException(); 
		}
		
		return usuarioExcluido;
	/*	Scanner ler = new Scanner(System.in);
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
		}*/
	}
	
	public void mostrarUsuarios() {
		System.out.println("Número de usuários cadastrados: " + usuarios.size());
		for (int i = 0; i < usuarios.size(); i++) {
			System.out.println("Usuario: " + usuarios.get(i).getNome());
		}
	}
	
	
}
