//Raphael Cordeiro Lopes 4°Semestre Uniplan
package main;

import dao.LivroDAO;
import model.Livro;
import java.util.List;

public class TesteLivroDAO {
    public static void main(String[] args) {
        System.out.println("🧪 Testando LivroDAO...");
        
        LivroDAO livroDAO = new LivroDAO();
        
        
        Livro livro = new Livro();
        livro.setTitulo("Dom Casmurro");
        livro.setAutor("Machado de Assis");
        livro.setCodigo("1234");
        livro.setAnoPublicacao(1899);
        livro.setStatus("Disponível");
        
        boolean inserido = livroDAO.inserir(livro);
        System.out.println("Inserido: " + inserido);
        
        
        List<Livro> livros = livroDAO.listarTodos();
        System.out.println("Livros encontrados: " + livros.size());
        
        for (Livro l : livros) {
            System.out.println("📖 " + l.getTitulo() + " - " + l.getAutor());
        }
    }
}