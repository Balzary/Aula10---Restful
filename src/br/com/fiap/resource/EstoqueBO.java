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
		lista.add(new ProdutoTO(401, "Camiseta branca", 4, 2.99));
		lista.add(new ProdutoTO(402, "Camiseta azul", 4, 2.99));
		lista.add(new ProdutoTO(403, "Camiseta rosa", 4, 2.99));		
	}
	
	public static ProdutoTO consultarProduto(int codigo) {
		for(ProdutoTO produto : lista) {
			if(produto.getCodigo() == codigo) {
				return produto;
			}
		}
		return null;
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
	
	public void remover(int codigo) {
		for(ProdutoTO produto : lista) {
			if(produto.getCodigo() == codigo) {
				lista.remove(produto);
				break;
			}
		}
	}
	
	public void atualizar(ProdutoTO produto) {
		for(ProdutoTO produto2 : lista) {
			if(produto.getCodigo() == produto2.getCodigo()) {
				produto2.setDescricao(produto.getDescricao());
				produto2.setQuantidade(produto.getQuantidade());
				produto2.setPreco(produto.getPreco());
				break;
			}
		}
	}
}
