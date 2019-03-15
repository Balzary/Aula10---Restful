package br.com.fiap.resource;

import java.util.ArrayList;
import java.util.List;

public class EstoqueBO {
	
	private static EstoqueBO estoqueBO;
	private static ArrayList<ProdutoTO> lista = new ArrayList<ProdutoTO>();
	
	public static EstoqueBO getInstance() {
		if(estoqueBO == null) {
			estoqueBO = new EstoqueBO();
		}
		return estoqueBO;
	}

	
	public EstoqueBO() {		
		lista.add(EstoqueBO.consultarProduto(401));
		lista.add(EstoqueBO.consultarProduto(402));
		lista.add(EstoqueBO.consultarProduto(403));		
	}
	
	public static ProdutoTO consultarProduto(int codigo) {
		if(codigo == 401) {
			return new ProdutoTO(codigo, "Camiseta branca", 4, 2.99);
		} else if(codigo == 402) {
			return new ProdutoTO(codigo, "Camiseta azul", 4, 2.99);
		} else if(codigo == 403) {
			return new ProdutoTO(codigo, "Camiseta rosa", 4, 2.99);
		} else {
			return new ProdutoTO(-1, "Produto não encontrado", 0, 0);
		}
	}
	
	public List<ProdutoTO> listar(){
		return lista;
	}
	
	public static ProdutoTO listar(int codigo) {
		return EstoqueBO.consultarProduto(codigo);
	}
	
	public void cadastrar(ProdutoTO produto) {
		lista.add(produto);
	}
}
