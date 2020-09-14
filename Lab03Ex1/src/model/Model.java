package model;

import java.util.Collection;

import entidade.Produto;

public interface Model {
	
	public Collection<Produto> loadProdutos();
	public void saveProdutos(Collection<Produto> produtos);

}
