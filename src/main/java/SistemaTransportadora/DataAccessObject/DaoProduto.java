package SistemaTransportadora.DataAccessObject;

import SistemaTransportadora.*;

import java.sql.*;
import java.util.ArrayList;

public class DaoProduto {

    public static boolean salvar(Construtor_Produtos produto, int grauFragilidadeId) {
        String sql = "INSERT INTO produtos (nome, descricao, familia, tipo, lote, altura, largura, comprimento, peso, grau_fragilidade_id, observacoes) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = ConexaoDB.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, produto.getNome());
            stmt.setString(2, produto.getDescricao());
            stmt.setString(3, produto.getFamília());
            stmt.setString(4, produto.getTipo());
            stmt.setString(5, produto.getLote());
            stmt.setDouble(6, produto.getDimensoes().getAltura());
            stmt.setDouble(7, produto.getDimensoes().getLargura());
            stmt.setDouble(8, produto.getDimensoes().getComprimento());
            stmt.setDouble(9, produto.getPeso());
            stmt.setInt(10, grauFragilidadeId);
            stmt.setString(11, produto.getObservacoes());

            stmt.executeUpdate();
            return true;
        } catch (SQLException error) {
            System.err.println("Erro ao salvar produto: " + error.getMessage());
            return false;
        }
    }
}
