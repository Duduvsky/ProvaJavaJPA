package orm.actions;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import orm.model.Aluno;

public class ListarAlunos {
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("alunos");
		EntityManager manager = factory.createEntityManager();
		
		Query query = manager.createQuery("select a from Aluno as a");		
		
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
	}
}
