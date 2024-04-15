package avaliacao.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import avaliacao.entidade.Veiculo;
import avaliacao.exception.Excecoes;
import avaliacao.persistencia.VeiculoDao;
import avaliacao.util.Util;


public class VeiculoController extends HttpServlet {

		private static final long serialVersionUID = 8253970383459046848L;
		
		private static String SALVAR = "veiculo.jsp";
	    private static String LISTAR_VEICULO = "listarVeiculo.jsp";
	    private VeiculoDao dao;

	    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
	    	String forward="";
	        String action = request.getParameter("action");
	        try {
		        dao = new VeiculoDao();
		        if (action.equalsIgnoreCase("apagar")){
		        	int veiculoId = Integer.parseInt(request.getParameter("veiculoId"));
					dao.excluir((long) veiculoId);
		            forward = LISTAR_VEICULO;
		            request.setAttribute("listaVeiculos", dao.getTodos());    
		        } else if (action.equalsIgnoreCase("editar")){
		            forward = SALVAR;
		            int veiculoId = Integer.parseInt(request.getParameter("veiculoId"));
		            Veiculo veiculo = dao.getObjetoPorId((long) veiculoId);
		            request.setAttribute("veiculo", veiculo);
		        } else if (action.equalsIgnoreCase("pesquisar")){
		            forward = LISTAR_VEICULO;
	            	request.setAttribute("listaVeiculos",  dao.getPesquisaVeiculos(	request.getParameter("veiculoId"),
	            																	request.getParameter("placa"),
	            																	request.getParameter("modelo"),
	            																	request.getParameter("marca"),
	            																	request.getParameter("fabricacao")));
		        
		        } else if (action.equalsIgnoreCase("listarVeiculo")){
		            forward = LISTAR_VEICULO;
		            request.setAttribute("listaVeiculos", dao.getTodos());
		        } else {
		            forward = SALVAR;
		        }
			} catch (Excecoes e) {
				e.printStackTrace();
			}

	        RequestDispatcher view = request.getRequestDispatcher(forward);
	        view.forward(request, response);
	    }

	    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        Veiculo v = new Veiculo();
	        carregaParametros(request, v);
	        try {
		        dao = new VeiculoDao();
		        if (v.getId() != null) {
		        	dao.alterar(v);
		        } else {
		        	dao.salvar(v);	
		        }		        
	            request.setAttribute("listaVeiculos", dao.getTodos());
			} catch (Excecoes e) {
				e.printStackTrace();
			}	        
	        
	        response.sendRedirect("VeiculoController?action=listarVeiculo");
	    }
	    
	    private Veiculo carregaParametros(HttpServletRequest request, Veiculo v) {
	    	
	    	if (Util.nvl(request.getParameter("veiculoId")) != null) {
	    		v.setId(Long.parseLong(request.getParameter("veiculoId")));
	    	}
	    	v.setMarca(Util.nvl(request.getParameter("marca").trim()));
	        v.setModelo(Util.nvl(request.getParameter("modelo").trim()));
	        v.setPlaca(Util.nvl(request.getParameter("placa").trim()));
	        if (Util.nvl(request.getParameter("fabricacao")) == null) {
	        	v.setFabricacao(null);
	        } else {
	        	v.setFabricacao(Util.converterStringDate(request.getParameter("fabricacao")));
	        }
	    	return v;	    	
	    }
	    
	    
	
}
