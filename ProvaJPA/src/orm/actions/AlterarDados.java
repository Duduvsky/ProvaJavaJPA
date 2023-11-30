package orm.actions;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import orm.model.Aluno;

public class AlterarDados {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("alunos");
		EntityManager manager = factory.createEntityManager();
		
		System.out.println("Informe o ID para pesquisar o Aluno: ");
		int alunoId = sc.nextInt();
        sc.nextLine(); 
        
        Aluno aluno = manager.find(Aluno.class, alunoId);
		
		System.out.println("\nInforme seu Nome: ");
		aluno.setNome(sc.nextLine());
		
		System.out.println("\nInforme seu E-mail: ");
		aluno.setEmail(sc.nextLine());
		
		System.out.println("\nInforme seu CPF: ");
		aluno.setCpf(sc.nextLine());
		
		System.out.println("\nInforme sua Data de Nascimento: ");
		aluno.setDataNascimento(sc.nextLine());
		
		System.out.println("\nInforme sua Naturalidade: ");
		aluno.setNaturalidade(sc.nextLine());
		
		System.out.println("\nInforme seu Endereço: ");
		aluno.setEndereco(sc.nextLine());
		
		manager.getTransaction().begin();
		manager.merge(aluno);
		manager.getTransaction().commit();
		
		manager.close();
		factory.close();
		sc.close();
	}
}
