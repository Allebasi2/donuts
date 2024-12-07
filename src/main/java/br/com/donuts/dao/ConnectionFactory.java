package br.com.donuts.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {
	private static final String USER = "root";
	private static final String SENHA = "root";
	
	public static Connection conectar() {
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			Connection conexao =
					DriverManager
						.getConnection("jdbc:mysql://localhost:3306/donuts", USER, SENHA);
			return conexao;
		} catch (Exception e) {
			// throw -> jogar para cima
			// RuntimeException -> Erro que aconteceu enquanto o codigo rodava 
			throw new RuntimeException();
		}
		
		
	}
	
}
