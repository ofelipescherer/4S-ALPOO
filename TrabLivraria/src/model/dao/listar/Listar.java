package model.dao.listar;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;

import entities.Author;
import entities.BooksAuthors;
import entities.Book;
import entities.Publisher;
import model.dao.DaoListar;


public class Listar implements DaoListar {
	
	private static final String USER = "root";
    private static final String PASS = "Br@sil2020";
    private static final String URL = "jdbc:mysql://localhost:3306/Livraria";
    private static final String DRIVER = "com.mysql.jdbc.Driver";

    @Override
	public Collection<Book> listarLivro() {
    	
    	Collection<Book> livros = new ArrayList<>();
    	try(Connection con = DriverManager.getConnection(URL, USER, PASS)){
			
			final String query = "SELECT Books.title, Books.isbn,Publishers.name, Books.price from Books inner join Publishers ON Books.publisher_id_fk = Publishers.publisher_id";
			
			Statement stm = con.createStatement();
			
			ResultSet rs = stm.executeQuery(query);
			
			while(rs.next()) {
				String titulo = rs.getString("title");
				String isbn = rs.getString("isbn");
				int editoraIdFk = rs.getInt("editoraIdFk");
				double preco = rs.getDouble("price");
			
				Book livro = new Book(titulo, isbn, editoraIdFk, preco);
				livros.add(livro);
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
    	return livros;
	}		
	

	@Override
	public Collection<Publisher> listarEditora() {
    	Collection<Publisher> editoras = new ArrayList<>();

		
		try(Connection con = DriverManager.getConnection(URL, USER, PASS)){
			
			final String query = "SELECT * FROM Publishers";
			
			Statement stm = con.createStatement();
			
			ResultSet rs = stm.executeQuery(query);
			
			while(rs.next()) {
				int id_editora = rs.getInt("publisher_id");
				String nome = rs.getString("name"); 
				String url = rs.getString("url"); 						      
				  
				Publisher editora = new Publisher(id_editora, nome, url);
				editoras.add(editora);
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return editoras;
	}

	@Override
	public Collection<Author> listarAutor() {
    	Collection<Author> autores = new ArrayList<>();

		try(Connection con = DriverManager.getConnection(URL, USER, PASS)){
			
			final String query = "SELECT * FROM Authors";
			
			Statement stm = con.createStatement();
			
			ResultSet rs = stm.executeQuery(query);
			
			while(rs.next()) {
				int autor_id = rs.getInt(1);
		        String nome = rs.getString("name");
				String fnome = rs.getString("fname");
				
				Author autor = new Author(autor_id, nome, fnome);
				autores.add(autor);
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}		
		return autores;
	}


	@Override
	public Collection<BooksAuthors>listarAutorLivro() {
    	Collection<BooksAuthors> autorLivros = new ArrayList<>();

		try(Connection con = DriverManager.getConnection(URL, USER, PASS)){
			
			final String query = "SELECT Books.title, Books.isbn, Authors.name from BooksAuthors inner join Books on BooksAuthors.isbn_books_fk = Books.isbn inner join Authors on BooksAuthors.authorID_authors_fk = Authors.author_id";
			
			Statement stm = con.createStatement();
			
			ResultSet rs = stm.executeQuery(query);
			
			while(rs.next()) {
				String titulo = rs.getString("title"); 
				String isbn = rs.getString("isbn");
				String nomeAutor =  rs.getString("name");				      
				
				BooksAuthors autorLivro = new BooksAuthors(titulo, isbn, nomeAutor);
				autorLivros.add(autorLivro);
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}	
		return autorLivros;
	}


}
