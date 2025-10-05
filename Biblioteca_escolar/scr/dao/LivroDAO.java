//Raphael Cordeiro Lopes 4°Semestre Uniplan
package dao;

import model.Livro;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LivroDAO {

    public boolean inserir(Livro livro) {
        String sql = "INSERT INTO livros (titulo, autor, codigo, ano_publicacao, status) VALUES (?, ?, ?, ?, ?)";
        
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setString(1, livro.getTitulo());
            stmt.setString(2, livro.getAutor());
            stmt.setString(3, livro.getCodigo());
            stmt.setInt(4, livro.getAnoPublicacao());
            stmt.setString(5, livro.getStatus());
            
            stmt.executeUpdate();
            return true;
            
        } catch (SQLException e) {
            System.out.println("Erro ao inserir: " + e.getMessage());
            return false;
        }
    }

    public List<Livro> listarTodos(String filtro) {
        List<Livro> livros = new ArrayList<>();
        
        String sql = "SELECT * FROM livros WHERE titulo LIKE ? OR autor LIKE ?";
        String filtroSql = "%" + filtro + "%";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setString(1, filtroSql);
            stmt.setString(2, filtroSql);
            
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    Livro livro = new Livro();
                    livro.setIdLivro(rs.getInt("id_livro"));
                    livro.setTitulo(rs.getString("titulo"));
                    livro.setAutor(rs.getString("autor"));
                    livro.setCodigo(rs.getString("codigo"));
                    livro.setAnoPublicacao(rs.getInt("ano_publicacao"));
                    livro.setStatus(rs.getString("status"));
                    
                    livros.add(livro);
                }
            }

        } catch (SQLException e) {
            System.out.println("Erro ao listar livros com filtro: " + e.getMessage());
        }
        
        return livros;
    }

    public List<Livro> listarTodos() {
        return listarTodos("");
    }

    public boolean atualizar(Livro livro) {
        String sql = "UPDATE livros SET titulo = ?, autor = ?, codigo = ?, ano_publicacao = ?, status = ? WHERE id_livro = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, livro.getTitulo());
            stmt.setString(2, livro.getAutor());
            stmt.setString(3, livro.getCodigo());
            stmt.setInt(4, livro.getAnoPublicacao());
            stmt.setString(5, livro.getStatus());
            stmt.setInt(6, livro.getIdLivro());

            stmt.executeUpdate();
            return true;

        } catch (SQLException e) {
            System.out.println("Erro ao atualizar livro: " + e.getMessage());
            return false;
        }
    }

    public Livro buscarPorId(int id) {
        String sql = "SELECT id_livro, titulo, autor, codigo, ano_publicacao, status FROM livros WHERE id_livro = ?";
        Livro livro = null;
        
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    livro = new Livro();
                    livro.setIdLivro(rs.getInt("id_livro"));
                    livro.setTitulo(rs.getString("titulo"));
                    livro.setAutor(rs.getString("autor"));
                    livro.setCodigo(rs.getString("codigo"));
                    livro.setAnoPublicacao(rs.getInt("ano_publicacao"));
                    livro.setStatus(rs.getString("status"));
                }
            }

        } catch (SQLException e) {
            System.out.println("Erro ao buscar livro por ID: " + e.getMessage());
        }
        
        return livro;
    }

    public boolean deletar(int idLivro) {
        String sql = "DELETE FROM livros WHERE id_livro = ?" ;
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setInt(1,idLivro);
            stmt.executeUpdate();
            return true;
            
        } catch (SQLException e) {
            System.out.println("Erro ao Deletar livro: " + e.getMessage());
            return false;
        }
    }
}