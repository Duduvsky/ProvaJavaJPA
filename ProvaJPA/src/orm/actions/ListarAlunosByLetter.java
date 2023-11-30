package orm.actions;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import orm.model.Aluno;

public class ListarAlunosByLetter {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("alunos");
		EntityManager manager = factory.createEntityManager();
		
		System.out.println("Digite a letra para buscar alunos:");
		String letra = sc.nextLine().toLowerCase();

		Query query = manager.createQuery("SELECT a FROM Aluno a WHERE LOWER(SUBSTRING(a.nome, 1, 1)) = :paramPrimeiraLetra");
		query.setParameter("paramPrimeiraLetra", letra);
		
		List<Aluno> lista = query.getResultList();
		
		for (Aluno a : lista) {
			System.out.println("\n-=-=-=-=-=-==-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-\n");
			System.out.println("ID: " + a.getId());
			System.out.println("Nome: " + a.getNome());
			System.out.println("E-mail: " + a.getEmail());
			System.out.println("CPF: " + a.getCpf());
			System.out.println("Nascimento: " + a.getDataNascimento());
			System.out.println("Naturalidade: " + a.getNaturalidade());
			System.out.println("Endereço: " + a.getEndereco());
		}
		
		manager.close();
		factory.close();
		sc.close();
	}
}
