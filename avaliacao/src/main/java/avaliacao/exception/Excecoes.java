package avaliacao.exception;


/**
 * Controlador de Excecoes
 * @author Ever Santoro
 *
 */
public class Excecoes  extends Exception {
	private static final long serialVersionUID = 1362552504616368266L;

	/** 
	 * Adicionar uma mensagem tratada que vai para o usuario
	 * @param mensagem
	 */
	public Excecoes(String mensagem) {
    	super(mensagem);
    }
	
	/** 
	 * Adicionar uma excecao que vai para o usuario
	 * @param excecao
	 */
	public Excecoes(Exception excecao) {
    	super(excecao);
    	excecao.printStackTrace();
    }
	
	/**
	 * Adicionar uma excecao que vai para o usuario com mensagem
	 * @param excecao
	 * @param mensagem
	 */
	public Excecoes(Exception excecao, String mensagem) {
    	super(mensagem, excecao);
    	excecao.printStackTrace();
    }
}
