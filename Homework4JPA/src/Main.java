import hu.infokristaly.jpa.back.domain.Continents;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;


public class Main {
	static {
		try {
			Class c = Class.forName("org.eclipse.persistence.jpa.PersistenceProvider");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	static EntityManagerFactory emf = Persistence.createEntityManagerFactory("Homework4JPA");
	static EntityManager em = emf.createEntityManager();

	/*
	 * http://www.java2s.com/Tutorial/Java/0355__JPA/SaveanEntitytoDatabase.htm
	 */
	public static void main(String[] args) {
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
			Continents continent = new Continents();
			continent.setName("Europe");
			continent.setPhonePrefix((byte)1);
			em.persist(continent);
			continent = em.find(Continents.class, (byte)1);
			if (continent != null) {
				continent.setPhonePrefix((byte)3);
				em.merge(continent);
			}
			em.flush();
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
			em.close();
			emf.close();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	}

}
