package avaliacao.persistencia;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import avaliacao.bancodedados.Conexao;
import avaliacao.bancodedados.Dao;
import avaliacao.entidade.Veiculo;
import avaliacao.util.Util;

public class VeiculoDao extends Dao<Veiculo>{

	private static final long serialVersionUID = 1L;

	public VeiculoDao() {
		super(Veiculo.class);
	}
	
	@SuppressWarnings("unchecked")
	public List<Veiculo> getPesquisaVeiculos(String veiculoId, String placa, String modelo, String marca, String fabricacao ) {
		EntityManager em = Conexao.getConexaoEM();
		List<Veiculo> lista = new ArrayList<Veiculo>();
		try {
			StringBuilder sql = new StringBuilder(); 
			sql.append("select v from Veiculo as v ");
			
			if (Util.nvl(veiculoId) != null) {
				sql.append(" where v.id = :id");
	    	} else if (Util.nvl(placa) != null) {
				sql.append(" where v.placa = :placa");
	    	} 
	    	
			if ((Util.nvl(modelo) != null) || (Util.nvl(marca) != null) || (Util.nvl(fabricacao) != null)) sql.append(" where ");	    	
	    	
			int contador = 0;
	    	if (Util.nvl(modelo) != null) {
				sql.append(" v.modelo = :modelo");
				contador++;
	    	} 
	    	
	    	if (Util.nvl(marca) != null) {
	    		if (contador > 0)  sql.append(" and ");
				sql.append(" v.marca = :marca");
				contador++;
	    	} 
	    	
	    	if (Util.nvl(fabricacao) != null) {
	    		if (contador > 0)  sql.append(" and ");
				sql.append(" v.fabricacao = :fabricacao");
	    	}
			
	    	
			Query listQuery = em.createQuery(sql.toString());
			if (Util.nvl(veiculoId) != null) {
				listQuery.setParameter("id", Long.parseLong(veiculoId));
	    	} 
			if (Util.nvl(placa) != null) {
				listQuery.setParameter("placa", placa);
	    	} 
			if (Util.nvl(modelo) != null) {
				listQuery.setParameter("modelo", modelo);
	    	} 
			if (Util.nvl(marca) != null) {
				listQuery.setParameter("marca", marca);
	    	} 
			
			if (Util.nvl(fabricacao) != null) {
				listQuery.setParameter("fabricacao", Util.converterStringDate(fabricacao));
	    	}
			lista = listQuery.getResultList();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			Conexao.fechaConexaoEM(em);
		}
		return lista;
	}
	
	
}
