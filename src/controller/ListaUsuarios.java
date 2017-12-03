package controller;
import java.util.ArrayList;
import java.util.Scanner;

import ifrn.edu.poo.Livro;
import model.Usuario;
import view.Textos;


public class ListaUsuarios {
	
	private ArrayList<Usuario> usuarios = new ArrayList <Usuario> ();
	Textos t = new Textos();
	
	public void cadastrarUsuario() {
		Usuario u = new Usuario();
		Scanner ler = new Scanner(System.in);
		
		System.out.println("Digite sua matricula: ");
		u.setMatricula(ler.nextLine());
		
		System.out.println("Digite seu nome: ");
		u.setNome(ler.nextLine());
		
		System.out.println("Digite sua senha: ");
		u.setSenha(ler.nextLine());
		
		System.out.println("Matricula: " + u.getMatricula());
		System.out.println("Nome: " + u.getNome());
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
		Scanner ler = new Scanner(System.in);
		System.out.println("Digite a matrícula do usuário: ");
		String matricula = ler.nextLine(); 
		
		for (int i = 0; i < usuarios.size(); i++) {
			if(usuarios.get(i).getMatricula().equals(matricula))
				System.out.println("Acesso a: " + usuarios.get(i));
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
	
	public int quantidadeAlunos() {
		return usuarios.size();
	}
	
	public void mostrarUsuarios() {
		for (int i = 0; i < usuarios.size(); i++) {
			System.out.println("Usuario: " + usuarios.get(i).getNome());
		}
	}
	
	public void addLivro(Livro livros) {
		
	}
	
}
