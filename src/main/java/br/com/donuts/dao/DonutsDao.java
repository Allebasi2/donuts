package br.com.donuts.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.donuts.model.Donuts;

public class DonutsDao {

	private Connection conexao;

	public DonutsDao() {
		conexao = ConnectionFactory.conectar();
	}

	public void inserir(Donuts donuts) {
		String sql = "INSERT INTO donuts (nome, preco, descricao, tamanho)" + "VALUES (?, ?, ?, ?)";

		PreparedStatement smtp;
		try {

			smtp = conexao.prepareStatement(sql);

			smtp.setString(1, donuts.getNome());
			smtp.setDouble(2, donuts.getPreco());
			smtp.setString(3, donuts.getDescricao());
			smtp.setString(4, donuts.getTamanho());

			smtp.execute();
			smtp.close();
			conexao.close();

		} catch (Exception e) {
			System.out.println("Deu erro: " + e.getMessage());
		}

	}

	public List<Donuts> listar() {
		String sql = "SELECT * FROM donuts";

		List<Donuts> donuts = new ArrayList<>();
		try (Connection conn = ConnectionFactory.conectar();
				PreparedStatement smtp = conn.prepareStatement(sql);
				ResultSet resultado = smtp.executeQuery()) {

			while (resultado.next()) {
				Donuts pi = new Donuts();
				pi.setId(resultado.getLong("id")); // Aqui usamos 'id' em vez de 'id_donuts'
				pi.setNome(resultado.getString("nome"));
				pi.setPreco(resultado.getDouble("preco"));
				pi.setDescricao(resultado.getString("descricao"));
				pi.setTamanho(resultado.getString("tamanho"));
				donuts.add(pi);
			}
		} catch (SQLException e) {
			System.out.println("Erro ao listar donuts: " + e.getMessage());
			throw new RuntimeException("Erro ao listar donuts", e);
		}

		return donuts;
	}

	public Donuts buscar(Long id) {
		String sql = "SELECT * FROM donuts WHERE id = ?";

		PreparedStatement smtp;

		try {
			smtp = conexao.prepareStatement(sql);
			smtp.setLong(1, id);
			ResultSet resultado = smtp.executeQuery();
			Donuts d = null;

			while (resultado.next()) {
				d = new Donuts();
				d.setId(resultado.getLong("id"));
				d.setNome(resultado.getString("nome"));
				d.setPreco(resultado.getDouble("preco"));
				d.setDescricao(resultado.getString("descricao"));
				d.setTamanho(resultado.getString("tamanho"));
			}

			smtp.close();
			resultado.close();
			conexao.close();
			return d;
		} catch (Exception e) {
			System.out.println("Erro: " + e.getMessage());
			throw new RuntimeException();
		}
	}

	public void excluir(Long id) {

		String sql = "DELETE FROM donuts WHERE id = ?";

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

	public void atualizar(Donuts donuts, Long id) {
		String sql = "UPDATE donuts SET nome = ?, preco = ?, tamanho = ?, descricao = ? WHERE id = ?";

		PreparedStatement smtp;

		try {
			smtp = conexao.prepareStatement(sql);
			smtp.setString(1, donuts.getNome());
			smtp.setDouble(2, donuts.getPreco());
			smtp.setString(3, donuts.getTamanho());
			smtp.setString(4, donuts.getDescricao());
			smtp.setLong(5, id);

			smtp.execute();
			smtp.close();
			conexao.close();

		} catch (Exception e) {
			throw new RuntimeException();
		}
	}
}
