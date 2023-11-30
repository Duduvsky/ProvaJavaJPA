package orm.actions;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import orm.model.Aluno;

public class RemoverAluno {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);		
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("alunos");
		EntityManager manager = factory.createEntityManager();
		
		System.out.println("Informe o ID para remover o Aluno: ");	
		int alunoId = sc.nextInt();
        sc.nextLine(); 
        
        Aluno aluno = manager.find(Aluno.class, alunoId);
		
		manager.getTransaction().begin();
		manager.remove(aluno);
		manager.getTransaction().commit();
		
		manager.close();
		factory.close();
		sc.close();
	}
}
