package model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collection;

import entidade.Produto;

public class ModelCSV implements Model {
	
	@Override
	public Collection<Produto> loadProdutos() {
		
		Collection<Produto> produtos = new ArrayList<>();
		
		InputStream is;
		InputStreamReader isr;
		BufferedReader br;
		
		try {
			is = new FileInputStream("files/produtos.csv");
			isr = new InputStreamReader(is, StandardCharsets.UTF_8);
			br = new BufferedReader(isr);
			
			String linha;
			while( (linha = br.readLine()) != null ) {
				String[] palavras = linha.split("\\,");
				int id = Integer.parseInt(palavras[0]);
				String nome = palavras[1];
				double valor = Double.parseDouble(palavras[2]);
				Produto produto = new Produto(id, nome, valor);
				produtos.add(produto);
			}
			br.close();
			isr.close();
			is.close();
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		return produtos;
	}

	@Override
	public void saveProduto(Produto produto) {
		
		FileWriter fw;
		BufferedWriter bw;
		PrintWriter pw;
		
		try {
			fw = new FileWriter("files/produtos.csv", StandardCharsets.UTF_8, true);
			bw = new BufferedWriter(fw);
			pw = new PrintWriter(bw, true);
			
			pw.println(produto.getId() + "," + produto.getNome() + "," + produto.getValor());
			
			fw.close();
			bw.close();
			pw.close();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	

}
