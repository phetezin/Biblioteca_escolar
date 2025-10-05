//Raphael Cordeiro Lopes 4°Semestre Uniplan
package main;

import dao.DatabaseConnection;

public class TesteConexao {
    public static void main(String[] args) {
        System.out.println("Testando conexão com o banco...");
        DatabaseConnection.testarConexao();
    }
}
