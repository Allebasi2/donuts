package br.com.donuts.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.donuts.model.Funcionario;

public class FuncionarioDao {

	private Connection conexao;

	public FuncionarioDao() {
		conexao = ConnectionFactory.conectar();
	}

	public void inserir(Funcionario funcionarios) {
		String sql = "INSERT INTO funcionarios (nome, cargo, idade)" + "VALUES (?, ?, ?)";

		PreparedStatement smtp;
		try {

			smtp = conexao.prepareStatement(sql);

			smtp.setString(1, funcionarios.getNome());
			smtp.setString(2, funcionarios.getCargo());
			smtp.setInt(3, funcionarios.getIdade());

			smtp.execute();
			smtp.close();
			conexao.close();

		} catch (Exception e) {
			System.out.println("Deu erro: " + e.getMessage());
		}

	}

	public List<Funcionario> listar() {
		String sql = "SELECT * FROM funcionarios";

		PreparedStatement smtp;
		List<Funcionario> funcionarios = new ArrayList<Funcionario>();
		try {
			smtp = conexao.prepareStatement(sql);
			ResultSet resultado = smtp.executeQuery();

			while (resultado.next()) {
				Funcionario fnc = new Funcionario();

				fnc.setId(resultado.getLong("id"));
				System.out.println(resultado.getLong("id"));
				fnc.setNome(resultado.getString("nome"));
				System.out.println(resultado.getString("nome"));
				fnc.setCargo(resultado.getString("cargo"));
				System.out.println(resultado.getString("cargo"));
				fnc.setIdade(resultado.getInt("idade"));
				System.out.println(resultado.getInt("idade"));
				funcionarios.add(fnc);

			}
			System.out.println("Chegou antes de fechar a conexao");
			resultado.close();
			System.out.println("Resultado fechou");
			smtp.close();
			System.out.println("Smtp fechou");
			conexao.close();
			System.out.println("Conexao fechou");
			System.out.println(funcionarios);
			return funcionarios;

		} catch (Exception e) {
			System.out.println(e);
			System.out.println("eRRO LISTAR DAO " + e);
			throw new RuntimeException();

		}
	}

	public Funcionario buscar(Long id) {
		String sql = "SELECT * FROM funcionarios WHERE id = ?";

		PreparedStatement smtp;
		System.out.println("esse e o id: " + id);

		try {
			smtp = conexao.prepareStatement(sql);
			smtp.setLong(1, id);
			ResultSet resultado = smtp.executeQuery();
			Funcionario f = null;
			while (resultado.next()) {
				f = new Funcionario();
				f.setId(resultado.getLong("id"));
				f.setNome(resultado.getString("nome"));
				f.setCargo(resultado.getString("cargo"));
				f.setIdade(resultado.getInt("idade"));
			}
			resultado.close();
			smtp.close();
			conexao.close();
			return f;
		} catch (Exception e) {
			System.out.println(e);
			System.out.println("Erro " + e);
			throw new RuntimeException();
		}

	}

	public void excluir(Long id) {
		String sql = "DELETE FROM funcionarios WHERE id = ?";
		PreparedStatement smtp;
		try {
			smtp = conexao.prepareStatement(sql);
			smtp.setLong(1, id);
			smtp.execute();
			smtp.close();
			conexao.close();
		} catch (Exception e) {
			throw new RuntimeException();
		}
	}

	public void atualizar(Funcionario funcionario, Long id) {
		String sql = "UPDATE funcionarios SET nome= ?, cargo = ?, idade = ?  WHERE id = ? ";
		PreparedStatement smtp;
		try {
			smtp = conexao.prepareStatement(sql);
			smtp.setString(1, funcionario.getNome());
			smtp.setString(2, funcionario.getCargo());
			smtp.setInt(3, funcionario.getIdade());
			smtp.setLong(4, id);
			smtp.execute();
			smtp.close();
			conexao.close();
		} catch (Exception e) {
			throw new RuntimeException();
		}
	}

}