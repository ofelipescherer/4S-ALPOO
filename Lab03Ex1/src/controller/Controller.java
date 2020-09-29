package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collection;

import entidade.Produto;
import model.Model;
import view.View;

public class Controller {
	private View view;
	private Model model;
	
	public Controller(View view, Model model) {
		this.view = view;
		this.model = model;
		this.init();
	}
	
	public void init() {
		view.setMostraProdutoListener(new ComportamentoListaProdutos());
		view.setCadastraProdutoListener(new ComportamentoCadastraProduto());
	}
	
	class ComportamentoListaProdutos implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			Collection<Produto> produtos = model.loadProdutos();
			view.mostraProdutos(produtos);
		}
		
	}
	
	class ComportamentoCadastraProduto implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			int id = view.getIdProduto();
			String nome = view.getNomeProduto();
			double valor = view.getValorProduto();
			Produto produto = new Produto(id, nome, valor);
			
			Collection<Produto> produtos = model.loadProdutos();
			produtos.add(produto);
			
			model.saveProdutos(produtos);
			
		}
		
	}


}
