package orm.actions;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import orm.model.Aluno;

public class InserirDados {
	public static void main(String[] args) {
		Aluno aluno = new Aluno();
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Informe seu Nome: ");
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
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("alunos");
		EntityManager manager = factory.createEntityManager();
		
		manager.getTransaction().begin();
		manager.persist(aluno);
		manager.getTransaction().commit();
		
		manager.close();
		factory.close();
		sc.close();
	}
}
