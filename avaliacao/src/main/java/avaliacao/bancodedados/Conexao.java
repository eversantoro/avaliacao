package avaliacao.bancodedados;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.FlushModeType;
import javax.persistence.Persistence;

/**
 * 
 * @author Ever Santoro
 * Classe responsavel pela captura e disponibilizacao da conexao
 */
public class Conexao {
	/**
	 * Atributo responsavel pela captura das informacoes de conexoes do persistence.xml
	 */
	private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("conexao");
	protected static EntityManager em;

	/**
	 * Efetua a conexao com o banco de dados e retorna o Entity Manager
	 * @return EntityManager
	 */
	public static EntityManager getConexaoEM() {
		if (em==null || !em.isOpen())  {
			em = emf.createEntityManager();
			em.setFlushMode(FlushModeType.COMMIT);
		}
		return em;
	}
	
	/**
	 * Fecha a conexao com o banco de dados
	 * @param em - conexao a ser fechada
	 */
	public static void fechaConexaoEM(EntityManager em) {
		if(em != null && em.isOpen()) {
			em.close();
		}
	}
}
