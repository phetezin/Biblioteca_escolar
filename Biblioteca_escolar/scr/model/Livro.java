//Raphael Cordeiro Lopes 4°Semestre Uniplan
package model;

public class Livro {
    private int idLivro;
    private String titulo;
    private String autor;
    private String codigo;
    private int anoPublicacao;
    private String status;
    
    
    public Livro() {
    }
    
    
    public Livro(int idLivro, String titulo, String autor, String codigo, int anoPublicacao, String status) {
        this.idLivro = idLivro;
        this.titulo = titulo;
        this.autor = autor;
        this.codigo = codigo;
        this.anoPublicacao = anoPublicacao;
        this.status = status;
    }
    
    
    public int getIdLivro() {
        return idLivro;
    }
    
    public void setIdLivro(int idLivro) {
        this.idLivro = idLivro;
    }
    
    public String getTitulo() {
        return titulo;
    }
    
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    
    public String getAutor() {
        return autor;
    }
    
    public void setAutor(String autor) {
        this.autor = autor;
    }
    
    public String getCodigo() {
        return codigo;
    }
    
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    
    public int getAnoPublicacao() {
        return anoPublicacao;
    }
    
    public void setAnoPublicacao(int anoPublicacao) {
        this.anoPublicacao = anoPublicacao;
    }
    
    public String getStatus() {
        return status;
    }
    
    public void setStatus(String status) {
        this.status = status;
    }
    
    @Override
    public String toString() {
        return titulo + " - " + autor;
    }
}